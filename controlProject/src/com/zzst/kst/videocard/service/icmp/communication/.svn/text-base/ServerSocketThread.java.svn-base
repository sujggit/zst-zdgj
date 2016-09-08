package com.zzst.kst.videocard.service.icmp.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.zzst.util.ServerSocketEnues;



/**
 *@Description 提供Socket连接服务
 *@date 2011-12-22下午02:06:28
 *@author ryan
 */
public class ServerSocketThread {
	private static Logger logger = Logger.getLogger(ServerSocketThread.class
			.getName());
	
	private String ip;
	private int port;
	
	public ServerSocketThread(String ip,int port){
		this.ip = ip;
		this.port = port;
	}
	
	
	/** 
	* @Title: sendCommandTCP 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @return byte[]    返回类型 
	* @throws 
	*/ 
	public byte[] sendCommandTCP(byte[] sendByte)throws Exception {
		Socket cardSocket =getSocket();
//		cardSocket.setSoTimeout(vcv.getRevSoTimeout());//接收超时时间
		
		OutputStream outputStream ;//输出流
		outputStream = cardSocket.getOutputStream();
		InputStream inputStream;//输入流
		inputStream = cardSocket.getInputStream();
		byte[] revByte=new byte[50];//接收到得数组
	    //发送命令
		outputStream.write(sendByte);
		//接收指令
		inputStream.read(revByte);
		//清空输入输出流
		outputStream.close();
		inputStream.close();
		return revByte;
	}
	
	
	
	 private  Socket getSocket(){
		 Socket server = null;
		 try{
			 logger.info(ip+"========="+port);
			server = ServerSocketEnues.getSocket(ip);
			if(server==null){
				server = new Socket(ip,port);
				ServerSocketEnues.setSocket(ip, server);
				Thread.sleep(500);
			}
			
			if(!server.isConnected()){
				server = new Socket(ip,port);
				Thread.sleep(500);
			}
		 }catch(Exception e){
			 logger.error("SOCKET	连接异常"+e.getMessage());
			 if(server!=null){
				 try {
					 if(server.isConnected())
						 server.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			 }
			 ServerSocketEnues.removeSocket(ip);
		 }
		return server;
	 }
}
