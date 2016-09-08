package com.zzst.centerContor.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.ReturnValueThread;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.SystemConfig;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description	定期检测中控端口是否正常、给中控发送心跳指令
 *@date 2013-3-12下午02:21:09
 *@author ryan
 *modify by ryan on 2013-8-18	调整为检测注册端口
 *delete	by	ryan	on	20140226	在设备状态哪里统一维护
 */
public class CCNetStatusTask extends CjfTimeTask{
	private static Logger logger = Logger.getLogger(CCNetStatusTask.class.getName());
	
	public static int def_num = 10;
	
	public CCNetStatusTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	} 
	
	public CCNetStatusTask() {
		super(System.currentTimeMillis()+"",System.currentTimeMillis()+"", null);
	} 
	public static long heartbeatTime=0;//多长时间发一次心跳
	@Override
	public boolean excuteTask() { 
		while(true){
			
			heartbeatTime +=EquipmentObjectImpl.THREAD_SLEEP_TIME;
			ReturnValueThread socketThread = null;
			if(this.getTimeTaskName()==null||this.getTimeTaskName().length()==0) return false;
//			logger.info("询问中控（"+this.getTimeTaskName()+"）是否正常============开始");
			CenterControlObject ccobj	= ControlFactory.getCenterControlObject(this.getTimeTaskName());
			
			if(ccobj==null||ccobj.getIP()==null||ccobj.getIP().equalsIgnoreCase("")) return false;
			
			String status = getConnection(ccobj.getIP(),ccobj.getPort());
			if(ccobj.getStatus()==null)
				ccobj.setStatus(SystemConfig.METHED_WITHIN,CenterControlObject.status_def);
			
			
			if(CenterControlObject.status_def.equalsIgnoreCase(ccobj.getStatus())){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
					socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
					socketThread.setName("中控"+ccobj.getIP()+"长连接");
					socketThread.start();
					CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
					if(CenterControlObject.status_off.equalsIgnoreCase(status)){
						logger.warn("第一次检查中控（"+ccobj.getIP()+"）的"+ccobj.getPort()+"端口通讯：异常");					
					}else if(CenterControlObject.status_on.equalsIgnoreCase(status)){
						logger.warn("第一次检查中控（"+ccobj.getIP()+"）的"+ccobj.getPort()+"端口通讯：正常");					
					}
					ccobj.setStatus(SystemConfig.METHED_WITHIN,status);
			}
				
			if(!ccobj.getStatus().equalsIgnoreCase(status)){
				if(CenterControlObject.status_off.equalsIgnoreCase(status)){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), false);
					CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
					Socket s = CenterControlObjectHelp.socketMap.get(ccobj.getIP());
					if(s!=null) {
						try {
							s.shutdownInput();
							s.shutdownOutput();
							s.close();
						} catch (IOException e) {}
					}
					CenterControlObjectHelp.socketMap.remove(ccobj.getIP());
					logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：异常");
				}else if(CenterControlObject.status_on.equalsIgnoreCase(status)){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
					CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
					socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
					socketThread.setName("中控"+ccobj.getIP()+"长连接");
					socketThread.start();
					CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
					
					logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：正常");
				}else{
				}
			}
			ccobj.setStatus(SystemConfig.METHED_WITHIN,status);
			
			try {
				Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);
			} catch (InterruptedException e) {
				
			}
		}
//		return true; 
		
		
//		String ccip=null;
//		try {
//			ArrayList<CenterControlObject> list = EquipmentObjectImpl.getCenterControlObject();
//			if(list==null) return false;
//
//			int ThreadNum = 0;
//			if(list.size()%def_num==0)
//				ThreadNum = list.size()/def_num;
//			else
//				ThreadNum = list.size()/def_num+1;
//			logger.info("启动检查中控线程数："+ThreadNum);
//			for(int i=0;i<ThreadNum;i++){
//				
//				logger.info("启动第"+i+"个线程");
//				new Thread(i+""){
//					int listNum = Integer.parseInt(this.getName());
//				
//					@Override   
//					 public void run() {
//						int count=0;
//						while(true){
//							count++;
//							logger.info("线程名称："+listNum+"	循环检查次数："+count);
//							ArrayList<CenterControlObject> list = EquipmentObjectImpl.getCenterControlObject();
//							int endNum = 0;
//							if(listNum*def_num+def_num>list.size())
//								endNum = list.size();
//							else
//								endNum = listNum*def_num+def_num;
//							logger.info("开始："+listNum*def_num+"结束："+endNum);
//							for(int i=listNum*def_num;i<endNum;i++){
//								CenterControlObject ccobj	=list.get(i);
//								if(ccobj.getIP()==null||ccobj.getIP().equalsIgnoreCase("")) continue;
//								
//								String status = getConnection(ccobj.getIP(),ccobj.getPort());
//								if(ccobj.getStatus()==null)
//									ccobj.setStatus(CenterControlObject.status_def);
//								
//								if(!ccobj.getStatus().equalsIgnoreCase(status)){
//									ReturnValueThread socketThread = null;
//									if(CenterControlObject.status_off.equalsIgnoreCase(status)){
//										CenterControlObjectHelp.flagMap.put(ccobj.getIP(), false);
//										CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
//										Socket s = CenterControlObjectHelp.socketMap.get(ccobj.getIP());
//										if(s!=null) {
//											try {
//												s.shutdownInput();
//												s.shutdownOutput();
//												s.close();
//											} catch (IOException e) {}
//										}
//										CenterControlObjectHelp.socketMap.remove(ccobj.getIP());
//										logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：异常");
//									}else if(CenterControlObject.status_on.equalsIgnoreCase(status)){
//										CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
//										CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
//										socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
//										socketThread.start();
//										CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
//										
//										logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：正常");
//									}else{
//										CenterControlObjectHelp.flagMap.put(ccobj.getIP(), false);
//										String sta = "异常";
//										if(CenterControlObject.status_on.equalsIgnoreCase(status)){
//											CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
//											sta = "正常";
//											socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
//											socketThread.start();
//											CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
//										}
//										logger.warn("第一次检查中控（"+ccobj.getIP()+"）的"+ccobj.getPort()+"端口通讯："+sta);
//									}
//								}
//								ccobj.setStatus(status);
//							}
//							try {
//								Thread.sleep(2000);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				}.start();
//			}
//		} catch (Exception e) {
//			if(ccip!=null)
//				netException(ccip);
//			logger.error("检查中控的端口系统异常:"+e.getMessage());
//		}

	}
	
	/**
	 * 异常时，初始化缓存信息
	 * @param ip
	 */
	public static void	netException(String ip){
		CenterControlObjectHelp.flagMap.put(ip, false);
		Socket s = CenterControlObjectHelp.socketMap.get(ip);
		if(s!=null) {
			try {
				s.shutdownInput();
				s.shutdownOutput();
				s.close();
			} catch (Exception e) {}
		}
		CenterControlObjectHelp.socketMap.remove(ip); 
		CenterControlObjectHelp.threadMap.remove(ip);
		ArrayList<CenterControlObject> list = EquipmentObjectImpl.getCenterControlObject();
		if(list==null) return;
		
		for(CenterControlObject ccobj  : list){
			if(ccobj.getIP().equalsIgnoreCase(ip))
				ccobj.setStatus(SystemConfig.METHED_WITHIN,CenterControlObject.status_off);
		}
	}
	
	/**
	 * 提前中控连接
	 * @param ip
	 * @param port
	 * @return
	 */
	public	static	Socket checkConnection(String ip ,int port){
		try{
			getConnection(ip, port);
		}catch(Exception e){
			logger.error(ip+"="+port+"建立连接时异常："+e.getMessage());
			CenterControlObjectHelp.socketMap.remove(ip);
			return null;
		}
		return CenterControlObjectHelp.socketMap.get(ip);
	}
	
	private  static String getConnection(String ip,int port){
//		if(ip.equalsIgnoreCase("10.1.8.126")){
//			System.out.println("aaa");
//		}
		 Socket server = null;
		 try{
			server = CenterControlObjectHelp.socketMap.get(ip);
			if(server==null){
				server = new Socket(ip,port);
				CenterControlObjectHelp.socketMap.put(ip, server);
				Thread.sleep(500);
			}else if(server.isClosed()||!server.isConnected()){
				logger.error(ip+"="+port+"长连接失效：是否关闭"+server.isClosed()+"是否连接"+server.isConnected());
				server.shutdownInput();
				server.shutdownOutput();
				server.close();
				CenterControlObjectHelp.socketMap.remove(ip);
				server = new Socket(ip,port);
				CenterControlObjectHelp.socketMap.put(ip, server);
				Thread.sleep(500);
			}
			server.setSoTimeout(6*60*1000);
			if(CCNetStatusTask.heartbeatTime>5*60*1000){//5分钟发一次心跳
				OutputStream out=server.getOutputStream();
				out.write("icmpheartbeat".getBytes());
				out.write(new byte[]{13,10});
				out.flush();
				CCNetStatusTask.heartbeatTime=0;
			}
			
			return CenterControlObject.status_on;
		 }catch(Exception e){
//			 logger.error(ip+"="+port+"检查中控的端口系统异常:"+e.getMessage());
			 CenterControlObjectHelp.flagMap.put(ip, false);
			 CenterControlObjectHelp.socketMap.remove(ip);
			 if(server!=null){
				 try {
					 if(server.isClosed())
						 server.close();
				} catch (IOException e1) {
					logger.error(ip+"="+port+"检查中控的端口系统异常:"+e.getMessage());
				}
			 }
			 return CenterControlObject.status_off;
		 }
	 }
}
