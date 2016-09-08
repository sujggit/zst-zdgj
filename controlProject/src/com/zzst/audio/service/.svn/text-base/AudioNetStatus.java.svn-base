package com.zzst.audio.service;
 
import java.net.Socket;

import org.apache.log4j.Logger;

import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description	定期检测音频端口是否正常
 *@date 2013-12-27下午04:04:46
 *@author ryan
 *delete	by	ryan	on	20140226	音频状态调整为字符型。在设备状态哪里统一维护	
 */
public class AudioNetStatus extends CjfTimeTask{
	private static Logger logger = Logger.getLogger(AudioNetStatus.class.getName());
	
	
	public AudioNetStatus(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	} 
	
	public AudioNetStatus() {
		super(System.currentTimeMillis()+"",System.currentTimeMillis()+"", null);
	} 
	
	
	@Override
	public boolean excuteTask() { 
		while(true){
			try {
				if(this.getTimeTaskName()==null||this.getTimeTaskName().length()==0) return false;
				
				AudioObject obj = ControlFactory.getAudioObject(this.getTimeTaskName());
				
				if(obj==null) return false;
//				boolean status_n = getSocket(obj.getIp(),Integer.valueOf(obj.getPort()).intValue());
//					if(status_n!=obj.isOnline()){
//						if(status_n)
//							logger.info("检查音频设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接正常");
//						else
//							logger.info("检查音频设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接异常");
//					}
//				obj.setOnline(status_n);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			
			try {
				Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	private  boolean getSocket(String ip,int port){
		 try{
			Socket server = new Socket(ip,port);
			server.close();
			return true;
		 }catch(Exception e){
			 return false;
		 }
	 }
}
