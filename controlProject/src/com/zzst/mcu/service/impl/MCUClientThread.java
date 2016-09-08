package com.zzst.mcu.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


/**
 *@Description
 *@date 2011-3-14下午05:04:05
 *@author ryan
 */
public class MCUClientThread extends Thread {
	public static Map<String,Socket> mcuServerSocketMap 				= new HashMap<String,Socket>();
	
	public static Map<String,URLConnection> mcuServerUrlConnection 		= new HashMap<String,URLConnection>();
	
	//private InetSocketAddress svrAddress;   
	private static Socket svrSocket;   
	private static int port	= 60000;
	    
	 /**
	  * 
	  * @param ip
	  * @return
	  */
	public	static	Socket getMCUSocket(String ip){
		Socket svrSocket	= mcuServerSocketMap.get(ip);
		if(svrSocket==null){
			try {
				InetSocketAddress svrAddress = new InetSocketAddress(ip, port);   
				svrSocket = new Socket(svrAddress.getAddress(), svrAddress   
				        .getPort());
				mcuServerSocketMap.put(ip, svrSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return svrSocket;
		}else{
			if(svrSocket.isClosed()){
				try {
					InetSocketAddress svrAddress = new InetSocketAddress(ip, port);  
					svrSocket = new Socket(svrAddress.getAddress(), svrAddress   
					        .getPort());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return svrSocket;
		}
	}
	
	/**
	 * 初始化---接受数据线程
	 * @param ip
	 */
	public static  void initSysThread(String ip){
		getMCUSocket(ip);
		Thread t = new Thread(new ResponseProcessor(svrSocket));
		t.getId();
		t.start();
		t.isAlive();
		t.getName();
		t.run();
		t.getPriority();
		t.interrupt();
		t.isInterrupted();
        new Thread(new ResponseProcessor(svrSocket)).run();
	}
	 
	
	/**
	 *
	 * String	ip	mcu设备ip地址
	 */
	public static URLConnection getURLConnection(String ip){
		
		if(ip==null||ip.length()<0) return null;
		URLConnection conn	=	null;
		String url = "http://"+ip;
		
		conn = mcuServerUrlConnection.get(ip);
		if(conn==null){
			try{
				URL urlObj = new URL(url);
		        conn = urlObj.openConnection();

		        conn.setRequestProperty("accept", "*/*");
		        conn.setRequestProperty("connection", "Keep-Alive");
		        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

		        conn.setDoOutput(true);
		        conn.setDoInput(true);
		       // conn.setConnectTimeout(MAX_PRIORITY);//设置长连接
			}catch(Exception e){
				e.printStackTrace();
			}
		}
        return conn;
	}
	
	
	/**  
	 * 
     * @param ip
     * @param command  
     * @return	String 
     */ 
    public static String sendCommand(String ip, String command){
        String resultStr = "";
        if (command == null || command.length() == 0)
        	return "";
        if (ip == null || ip.length() == 0)
        	return "";
        
        OutputStream out = null;
        BufferedReader in = null;
        try {
          URLConnection conn =getURLConnection(ip);
          out = conn.getOutputStream();
          out.write(command.getBytes());
          out.flush();
          in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
		  String line	="";
		  while ((line = in.readLine()) != null) {
			resultStr += line;
		  }
        }catch (IOException ex) {
        	return null;
        }
        return resultStr;
    }
    
    /**  
     * @param args  
     */  
    public static void main(String[] args) {
    	String s =MCUClientThread.sendCommand("10.1.3.238","asd");
    	System.out.println(s);
    }
}
