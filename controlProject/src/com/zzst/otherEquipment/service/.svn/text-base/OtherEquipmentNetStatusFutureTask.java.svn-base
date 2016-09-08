package com.zzst.otherEquipment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.zzst.util.ControlFactory;


/**
 *@Description	监测端口是否正常连接或者是ping ip是否正常
 *@date 2013-12-29下午11:32:05
 *@author ryan
 *delete	by	ryan	on	20140226	状态调整为字符型。在设备状态哪里统一维护
 */
public class OtherEquipmentNetStatusFutureTask implements Callable<Boolean> {
	private static Logger logger = Logger.getLogger(OtherEquipmentNetStatusFutureTask.class.getName());
	
	private boolean quit = false;
	private String ip = null;
	
	public OtherEquipmentNetStatusFutureTask(Object taskObject) {
		this.ip = (String)taskObject;
	}
	
	public synchronized  Boolean call() throws Exception {
		
		if(ip==null||ip.length()==0) {
			this.quit = true;
			return false;
		}
		OtherEquipmentObject obj = ControlFactory.getOtherEquipmentObject(ip);
		if(obj==null) {
			this.quit = true;
			return false;
		}
//		while(!quit){
//			try {
//				boolean status_n = getSocket(obj.getIp(),Integer.valueOf(obj.getPort()).intValue());
//				if(Integer.MIN_VALUE==obj.getPort()){
//						if(status_n!=obj.isOnline()){
//							if(status_n)
//								logger.info("ping设备（"+obj.getIp()+"）正常");
//							else
//								logger.info("ping设备（"+obj.getIp()+"）异常");
//						}
//				}else{
//						if(status_n!=obj.isOnline()){
//							if(status_n)
//								logger.info("检查设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接正常");
//							else
//								logger.info("检查设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接异常");
//						}
//				}
//				obj.setOnline(status_n);
//				
//				Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);
//				
//			} catch (Exception e) {
//				logger.error(e.getMessage());
//			}
//		}
//		obj.setOnline(false);
		return false;
	}
	/**
	 * 退出检查通信状态
	 * @param b
	 */
	public void quit(){
		this.quit = true;
	}
	
	
	private  boolean getSocket(String ip,int port){
		if(Integer.MIN_VALUE==port){
	        BufferedReader in = null;   
	        Runtime r = Runtime.getRuntime();   
	        String pingCommand = "ping " + ip + " -n 1 -w " + 3000;   
	        try {
	            Process p = r.exec(pingCommand);   
	            if (p == null) {   
	                return false;   
	            }   
	            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
	            String line = null;   
	            while ((line = in.readLine()) != null) {   
	                if (line.contains("ms")) {   
	                    return true;   
	                }
	            }   
	  
	        } catch (Exception ex) {   
	        	logger.error(ex.getMessage());
	            return false;   
	        } finally {   
	            try {   
	            	if(in!=null)
	            		in.close();   
	            } catch (IOException e) {   
	            	logger.error(e.getMessage());
	            	return false;
	            }   
	        }
	        return false;   
		}else{
			 try{
				Socket server = new Socket();
				 InetSocketAddress address = new InetSocketAddress(ip,port);
		           server.connect(address, 3000);

				server.close();
				return true;
			 }catch(Exception e){
				 return false;
			 }finally{
				 
			 }
		}
	 }

	public boolean isQuit() {
		return quit;
	}
	
}

