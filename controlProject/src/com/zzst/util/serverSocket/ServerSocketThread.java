package com.zzst.util.serverSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;



/**
 *@Description 提供Socket连接服务
 *@date 2011-12-22下午02:06:28
 *@author ryan
 */
public class ServerSocketThread {
	private static Logger logger = Logger.getLogger(ServerSocketThread.class
			.getName());
	
	private int port = 8888;
	
	public ServerSocketThread(int port){
		this.port = port;
	}
	//http://blog.csdn.net/wl_ldy/article/details/5496218
	public  void serverSocket(){
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		
		try{
			ServerSocket server=new ServerSocket(port);
			while(true){
				logger.info("接受中控发送指令");
				socket=server.accept();
				//logger.info("客户端信息："+socket.getRemoteSocketAddress());
			    InputStream in=socket.getInputStream();
			    br=new BufferedReader(new InputStreamReader(in));
			    String info=br.readLine();
			    
			    
			    OutputStream out = socket.getOutputStream();
			    String reStr ="beijing 已经收到了";
			    out.write(reStr.getBytes());
			    out.flush();
			    
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { 
		ServerSocketThread ssT = new ServerSocketThread(8888);
		ssT.serverSocket();
		
	}
}
