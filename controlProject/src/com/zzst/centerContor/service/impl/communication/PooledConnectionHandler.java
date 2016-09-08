package com.zzst.centerContor.service.impl.communication;


/**
 *@Description
 *@date 2012-2-29上午11:08:16
 *@author ryan
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * PooledConnectionHandler实现了Runnable接口，它的用途是处理服务器端传来的Socket连
 * 接。该类维护了一个被称为"连接池"的全局链式列表(静态)，该列表在类被加载时创建。
 * 
 * 当该类的run()方法被调用时，它首先检查该"连接池"中是否有需要待处理的客户端连接，如果
 * 没有(可能是请求尚未到来)则调用wait()方法等待，而另一个静态方法processRequest则负
 * 责接收客户端请求并添加到"连接池"的末尾，然后通知所有正在等待的线程，各个等待的线程则
 * 以"互斥"的方式竞争资源(请求)当某个线程率先获取到对象锁，拿到一个连接后，将释放锁，然
 * 后在自己的线程中处理请求。各个线程之间彼此不会互相影响。
 * 
 * 需要注意的是这个类的一个方法：processRequest这个方法第一个为静态方法，因为对于这个
 * 方法来说，它只是一个负责通知的角色，所以没有必要是对象级的。将其修饰符置为static是合
 * 理的。
 * 
 * 其次我们看到在对全局资源"连接池"进行操作时，不管是往池中添加请求，还是从池中取出请求，
 * 都需要在关键的语句块中增加synchronized{}，来保证同一时刻不会有多个线程竞争同一个
 * 资源，或者在添加资源未完成前有另一个线程试图读取该资源。
 * 
 * 最后一个要注意的地方是其中的wait()和notifyAll()方法，wait()方法的调用发送在线程创建
 * 完成，但请求尚未到来之前，这时线程并不持有对List的锁，而notifyAll()方法唤起所有等待
 * 的线程，所有等待线程将一起竞争锁，此时只有一个线程可能检测到池非空而进入池中请求资
 * 源。
 * </pre>
 */
public class PooledConnectionHandler implements Runnable {

    /** The client connection of Socket. */
    protected Socket connection;

    /** The request pool. */
    protected static List pool = new LinkedList();

    /**
     * Instantiates a new pooled connection handler.
     */
    public PooledConnectionHandler() {
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        while (true) {
            // 因为可能有多个线程同时去Pool中取Socket进行处理。
            // 所以这里我们需同步，防止同一个请求被多次处理
            synchronized (pool) {
                while (pool.isEmpty()) {
                    try {
                        pool.wait();// 没有请求到来则等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 从池中取出一个Socket，准备进行处理
                connection = (Socket) pool.remove(0);
            }
            // 取到Socket后则不需要同步了，因为此时是Connection是对象
            // 级属性，在线程内部自己处理，不涉及公共资源的访问
            handleConnection();
        }
    }
    
    /**
     * Process request, append Socket to pool and notify all waitting thread
     * 
     * @param requestToHandle the request to handle
     */
    public static void processRequest(Socket requestToHandle) {
        // 因为有可能在向池中塞请求的时候，另外一个线程
        // 正在从池中取Socket，所以这里需要同步一下
        synchronized (pool) {
            // 将来自客户端的请求添加到请求队列末尾
            pool.add(pool.size(), requestToHandle);
            // 通知其它正在等待的线程有新请求来到，
            // 此时所有处于wait状态的线程将被唤醒
            pool.notifyAll();
        }
    }    

    /**
     * Handle connection.
     */
    public void handleConnection() {
        try {
            PrintWriter streamWriter = new PrintWriter(connection
                    .getOutputStream());
            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String fileToRead = streamReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(
                    fileToRead));

            String line = null;
            while ((line = fileReader.readLine()) != null)
                streamWriter.println(line);

            fileReader.close();
            streamWriter.close();
            streamReader.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }    
}

