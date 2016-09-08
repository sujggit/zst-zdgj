package com.zzst.terminal.service;


import java.net.Socket;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.terminal.service.impl.communication.TerminalClientThreadByReturn;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.SystemConfig;
import com.zzst.util.timerTask.CjfTimeTask;


	/**
	 *@Description	监测终端网络是否正常
	 *一个线程内跑多个终端检测
	 *@date 2013-3-14下午01:18:33
	 *@author ryan
	 *delete	by	ryan	on	20140226	在设备状态哪里统一维护,本模块已经完成，放开相关功能即可
	 */
	public class TerminalNetStatusTask2 extends CjfTimeTask{
		private static Logger logger = Logger.getLogger(TerminalNetStatusTask2.class.getName());
		 
		public TerminalNetStatusTask2(String timeTaskID, String timeTaskName, Object taskObject) {
			super(timeTaskID, timeTaskName, taskObject);
		}

		@Override
		public boolean excuteTask() {
			ArrayList<TerminalObject> list = EquipmentObjectImpl.getTerminalObject();
			if(this.getTaskObject()==null)				return false;
			if(list==null||list.size()==0)				return false;
			int startNumber = ((Integer)this.getTaskObject()).intValue();
			int endNumber = startNumber+EquipmentObjectImpl.net_status_equipment_number;
			
			while(true){
				for(int i=startNumber;i<list.size();i++){
					//只检测到endNumber个终端
					if(i>=endNumber) {
						try {
							Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);
						} catch (InterruptedException e) {
						}
						continue;
					}
					
					TerminalObject obj = null;
					try{
						obj = list.get(i);
					}catch(Exception e){
						logger.error("异常："+e.getMessage());
						continue;
					}
					
					if(obj==null) continue;
					
					String status_n = getSocket(obj.getTerminalIp());
					
					if(obj.getStatus()==null||obj.getStatus().equalsIgnoreCase(""))
						obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
					
					if(TerminalObject.status_def.equalsIgnoreCase(obj.getStatus())){
						String sta = "网络异常";
						if(CenterControlObject.status_on.equalsIgnoreCase(status_n))
							sta = "网络正常";
						logger.warn("第一次检查终端（"+obj.getTerminalIp()+"）的(23)端口"+sta);
						obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
					}
					
					if(!obj.getStatus().equalsIgnoreCase(status_n)){
						if(TerminalObject.status_off.equalsIgnoreCase(status_n)){
							stopWorking(obj.getTerminalIp());
							logger.warn("检查终端（"+obj.getTerminalIp()+"）的端口(23)网络异常");
						}else if(TerminalObject.status_on.equalsIgnoreCase(status_n)){
							logger.warn("检查终端（"+obj.getTerminalIp()+"）的端口(23)网络在线");
						}
					}
		
					if(TerminalObject.status_on.equalsIgnoreCase(status_n)){
						if(!TerminalObject.status_onMeeting.equalsIgnoreCase(obj.getStatus()))
							obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
					}else if(TerminalObject.status_off.equalsIgnoreCase(status_n)){
						stopWorking(obj.getTerminalIp());
						obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
					}
				}
				
			}
		}
		
		private void stopWorking(String ip){
			if(!ServerSocketEnues.threadMap.isEmpty()&&ServerSocketEnues.threadMap.get(ip)!=null){
				TerminalClientThreadByReturn t = (TerminalClientThreadByReturn)ServerSocketEnues.threadMap.get(ip);
				if(t!=null)
					t.setLoop(false);
				
				ServerSocketEnues.threadMap.remove(ip);
			}
		}
		
		private  String getSocket(String ip){
			 try{
				Socket server = new Socket(ip,23);
				server.close();
				return TerminalObject.status_on;
			 }catch(Exception e){
//				 logger.error("检查终端（"+ip+"）的端口(23)网络异常"+e.getMessage());
				 return TerminalObject.status_off;
			 }
		 }
	}

