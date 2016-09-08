package com.zzst.action.meeting.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;

public class UdpClientSocket {
	private static Logger logger = CjfLogger.getLogger(UdpClientSocket.class.getName());
	private byte[] buffer = new byte[1024];  
	  
	    private static DatagramSocket ds = null;  
	      
	    /** 
	     * 测试客户端发包和接收回应信息的方法 
	     */  
	    public static void main(String[] args) throws Exception {  
	        UdpClientSocket client = new UdpClientSocket();  
	        String serverHost = "10.1.6.157";  
	        int serverPort = 8888; 
	        //2ALL.		2切至所有
	        //2V1,2.	2切至1和2
	        client.send(serverHost, serverPort, ("5V1,2.").getBytes());  
	        byte[] bt = client.receive();  
	        System.out.println("服务端回应数据：" + new String(bt));  
	        // 关闭连接  
	        try {  
	            ds.close();  
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  
	    }
	    
	    public String sendMessage(String serverHost, int serverPort, String sendInfo){
	    	String returnInfo = "";
	    	try { 
		    	UdpClientSocket client = new UdpClientSocket();  
//		        String serverHost = "192.168.1.234";  
//		        int serverPort = 8888; 
		        //2ALL.		2切至所有
		        //2V1,2.	2切至1和2
		    	logger.info("UdpClientSocket向"+serverHost+":"+serverPort+"的发送值为："+sendInfo);
		        Thread.sleep(500);
		    	client.send(serverHost, serverPort, sendInfo.getBytes());  
		        byte[] bt = client.receive();  
		        returnInfo = new String(bt);
		        logger.info("UdpClientSocket收到"+serverHost+":"+serverPort+"的返回值为："+returnInfo);
		        // 关闭连接  
//		        ds.close();  
	        } catch (Exception ex) {  
	        	logger.error("连接捷控矩阵异常："+ex.getMessage());
	            ex.printStackTrace();
	            returnInfo = ex.getMessage();
	        	if("Receive timed out".equals(returnInfo)){
	        		returnInfo = "Connection timed out: connect";
	        	}
	        }  finally {
	        	try {
					Thread.sleep(500);
					if(ds!=null)
						ds.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    	return returnInfo;
	    }
	  
	    /** 
	     * 构造函数，创建UDP客户端 
	     */  
	    public UdpClientSocket() throws Exception {  
//	        ds = new DatagramSocket(8899); // 邦定本地端口作为客户端  
	    	ds = new DatagramSocket(); // 邦定本地端口作为客户端
	    }  
	      
	    /** 
	     * 向指定的服务端发送数据信息 
	     */  
	    public final void send(final String host, final int port,  
	            final byte[] bytes) throws IOException {  
	        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(host), port);  
	        ds.setSoTimeout(5000);
	        ds.send(dp);  
	    }  
	  
	    /** 
	     * 接收从指定的服务端发回的数据 
	     */  
	    public final byte[] receive()  
	            throws Exception {  
	        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  
	        ds.receive(dp);       
	        byte[] data = new byte[dp.getLength()];  
	        System.arraycopy(dp.getData(), 0, data, 0, dp.getLength());       
	        return data;  
	    }  

}
