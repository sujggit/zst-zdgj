package com.zzst.vtron.service.impl.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.zzst.util.ServerSocketEnues;
import com.zzst.util.ZZSTControlException;


/**
 *@Description	socket连接
 *@date 2012-8-12下午12:58:56
 *@author ryan
 */
public class VtronThread extends Thread {
	private static Logger logger = Logger.getLogger(VtronThread.class
			.getName());
	
	private String ip;
	private int port;
	private boolean isResolved = true;//ip是否通
	
	public VtronThread(String ip,int port){
		this.ip = ip;
		this.port = port;
	}
	
	
	public boolean isResolved() {
		return isResolved;
	}


	public static void main(String[] arg){
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件 
		
		try{
			new VtronThread("192.168.0.168",5999).sendCommand("2:192.168.0.102");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 向中控发送命令无返回值
	 * @param String 发送命令
	 * @param String ip
	 * @param String port
	 * @return boolean 成功返回true 失败抛出ZZSTControlTerminalException异常
	 */
	public  boolean  sendCommand(String outCommand)throws ZZSTControlException {
		try {
			OutputStream out=getSocket().getOutputStream();
			out.write(outCommand.getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			logger.info(ip+"  发送命令:	"+outCommand+"		成功");
			
			return true;
		} catch (Exception e) {
			throw new  ZZSTControlException("系统异常");
		}finally{
			
		}
	}
	static byte bswap(byte a)
    {
        byte b = 0;
        for(int i = 0; i < 8; ++i)
            b |= ((a & (1 << i)) == 0 ? 0 : 1) << (7-i);
        return b;
    }
    
    static void bprint(byte b)
    {
        for(int i = 7; i >= 0; --i)
                System.out.print((b & (1 << i)) == 0 ? '0' : '1');
        System.out.println();
    }
 
 	/**
 	 * 发送命令并接收返回值
 	 * @param ip
 	 * @param port
 	 * @param command
 	 * @return String
 	 * @throws ZZSTControlException
 	 */
	 public   synchronized  String  sendCommandByReturn(String command)throws ZZSTControlException {
		try {
			Socket server =  getSocket();
			if(server==null) return null;
			
			OutputStream out=server.getOutputStream();
			command = VtronCommandHelp.COMMAND_HEAD+command;
			command = command+VtronCommandHelp.COMMAND_FOOT;
			out.write(command.getBytes());
//			out.write(new byte[]{13,10});
			out.flush();
//			for(byte b : command.getBytes()){
//				System.out.println(b);
//			}
			logger.info(ip+"  发送命令:	"+command+"		成功");
			
			//等待才能接到返回值？？？？
//			Thread.sleep(100);
//		        bprint(b); 

			String reStr = "";
			InputStream in = server.getInputStream();
			int c = 0;
			boolean m = true;
			while(m){
				logger.info("返回数据总长度："+in.available());
				if(in.available()==0){
					m = false;
					continue;
				}
				c  = in.read();
				//logger.info((char)c+"========"+c);
				if(c==3){
					m = false;
					continue;
				}
				reStr += (char)c;
			}
			logger.info(ip+"返回值："+reStr);
			return reStr;
		} catch (Exception e) {
			ServerSocketEnues.removeVtronSocket(ip);
			throw new  ZZSTControlException("系统异常");
		}finally{
			
		}
	}
	  
	  

	 
	 private  Socket getSocket(){
		 Socket server = null;
		 try{
			server = ServerSocketEnues.getVtronSocket(ip);
			if(server==null){
				server = new Socket(ip,port);
				ServerSocketEnues.setVtronSocket(ip, server);
				Thread.sleep(500);
			}
			
			if(!server.isConnected()){
				server = new Socket(ip,port);
				Thread.sleep(500);
			}
		 }catch(Exception e){
			 logger.error("连接"+ip+"异常");
			 if(server!=null){
				 try {
					 if(server.isConnected())
						 server.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			 }
			 ServerSocketEnues.removeVtronSocket(ip);
		 }
		return server;
	 }
}
