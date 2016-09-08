package com.zzst.util.serverSocket;

import java.io.IOException;
import java.net.Socket;


/**
 *@Description
 *@date 2012-4-19下午06:09:09
 *@author ryan
 */
public class ServerSocketHelp {

	public static  Socket getSocket(String ip,int port){
		 Socket server = null;
		 try{
			 server = new Socket(ip,port);
		 }catch(Exception e){
			 if(server!=null){
				 try {
					 if(server.isConnected())
						 server.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			 }
		 }
		return server;
	 }
	 
	
}
