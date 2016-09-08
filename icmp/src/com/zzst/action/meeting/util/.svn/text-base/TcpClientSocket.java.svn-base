package com.zzst.action.meeting.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;

public class TcpClientSocket {
	private static Logger logger = CjfLogger.getLogger(TcpClientSocket.class.getName());
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.1.190",6666);
		System.out.println(socket.isConnected());
		OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
		InputStreamReader in = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(in);
//		out.write("2V10.");
		out.write("Status.");
//		out.write("Inquire2.");
//		out.write("QueryH2.");
		out.flush();
		String result = br.readLine();
		System.out.println(result);
		in.close();
		out.close();
		socket.close();
	}
	
	public String sendMessage(String serverHost, int serverPort, String sendInfo){
    	String returnInfo = "";
    	Socket socket = new Socket();
    	OutputStreamWriter out = null;
    	 InputStreamReader in = null;
    	try { 
    		InetSocketAddress inetSocketAddress = new InetSocketAddress(serverHost,serverPort);
			socket.connect(inetSocketAddress);
//    		Socket socket = new Socket(serverHost,serverPort);
    		System.out.println(socket.isConnected());
    		if(socket.isConnected()){
    			Thread.sleep(500);
	    		out = new OutputStreamWriter(socket.getOutputStream());
	    		in = new InputStreamReader(socket.getInputStream());
	    		BufferedReader br = new BufferedReader(in);
	    		logger.info("TcpClientSocket向"+serverHost+":"+serverPort+"的发送值为："+sendInfo);
	    		out.write(sendInfo);
	    		out.flush();
	    		returnInfo = br.readLine();
	    		logger.info("TcpClientSocket收到"+serverHost+":"+serverPort+"的返回值为："+returnInfo);
//	    		in.close();
//	    		out.close();
//	    		socket.close();
    		}else{
    			logger.info("TcpClientSocket的返回值为："+returnInfo);
    		}
        } catch (Exception ex) {  
        	logger.error("连接快捷矩阵异常："+ex.getMessage());
        	returnInfo = ex.getMessage();
            ex.printStackTrace();  
        }  finally{
			try {
				Thread.sleep(1000);
				if(in!=null)
					in.close();
				if(out!=null)
					out.close();
				if(socket!=null)
					socket.close();
			} catch (Exception e) {
				logger.error("finally连接快捷矩阵异常："+e.getMessage());
				e.printStackTrace();
			}
		}
    	return returnInfo;
    }
}
