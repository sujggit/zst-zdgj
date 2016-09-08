package com.zzst.util.equipment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.audio.service.AudioObject;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.timerTask.CjfTimerHelper;


/**
 *@Description	操作检测设备网络状态的现场方法
 *@date 2014-2-25下午06:29:19
 *@author ryan
 */
public class EquipmentNetStatusOperate {
	private static Logger logger = Logger.getLogger(EquipmentNetStatusOperate.class
			.getName());
	
	/**
	 * 存储检测网络状态的线程
	 * add by ryan on 20140226
	 */
	public static ArrayList<EquipmentNetStatusTask> threadList = new ArrayList<EquipmentNetStatusTask>();
	
	/**
	 * 存储不检测网络状态的设备IP
	 * key	ip
	 * value	IP
	 * add by ryan on 20140226
	 */
	public static Map<String,String> stopCheckNetIPMap = new HashMap<String,String>();
	
	/**
	 * 提取正在使用的线程情况
	 * 没有实现
	 * @return	int
	 * add by ryan on 20140224
	 */
	public	ArrayList<String[]> getThreads(){
		return null;
	};
	
	
	/**
	 * 开启设备的状态检测,目前只针对关闭的终端做恢复检查
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public	static boolean recoverEquipmentNetStatusThreads(String[] ips){
		if(ips==null||ips.length==0) return false;
		for(String ip :ips){
			stopCheckNetIPMap.remove(ip);	
		}
		return true;
	};
	
	/**
	 * 停止对设备状态的检测
	 * 设备状态设置为未知状态
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public static	boolean stopEquipmentNetStatusThreads(String[] ips) {
		if(ips==null||ips.length==0) return false;
		for(String ip :ips){
			stopCheckNetIPMap.put(ip, ip);	
		}
		return true;
	};
	
	/**
	 * 开启一类设备的状态检测线程，达到正常控制本设备的目标
	 * @param	equipmentType
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public	static boolean startEquipmentNetStatusThreads(int equipmentType) {
		switch(equipmentType){
			 case EquipmentObject.EQUIPMENT_TYPE_TERMINAL:			
				int number = EquipmentObjectImpl.getTerminalObject().size();
				if(number==0) break;
				for(int i=0;i<number;i++){
					int	startNum = EquipmentObjectImpl.net_status_equipment_number*TerminalObject.getNetStatusThreadNumber();
					int endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
//					if(number>startNum){
						logger.info("检测终端设备网络状态线程："+TerminalObject.getNetStatusThreadNumber());
						EquipmentNetStatusTask task = new EquipmentNetStatusTask(System.currentTimeMillis()+"",equipmentType+"",startNum);
						CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),task,"终端设备（"+startNum+"到"+endNum+")网络情况");
						threadList.add(task);//缓存线程对象
						EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_TERMINAL);//记录开启线程数量
//					}
				}
				break;
		     case EquipmentObject.EQUIPMENT_TYPE_AUDIO:				
		    	number = EquipmentObjectImpl.audioObjectes.size();
				if(number==0) break;
				for(int i=0;i<number;i++){
					int	startNum = EquipmentObjectImpl.net_status_equipment_number*AudioObject.getNetStatusThreadNumber();
					int	endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
					if(number>startNum){
						logger.info("启动检测音频设备网络状态线程:"+AudioObject.getNetStatusThreadNumber());
						EquipmentNetStatusTask task = new EquipmentNetStatusTask(System.currentTimeMillis()+"",equipmentType+"",startNum);
						CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),task,"音频设备（"+startNum+"到"+endNum+")网络情况");
						threadList.add(task);
						EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_AUDIO);
					}	
				}
		    	break;
		     case EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL:		
		    	number = EquipmentObjectImpl.getCenterControlObject().size();
				if(number==0) break;
				for(int i=0;i<number;i++){
					int	startNum = EquipmentObjectImpl.net_status_equipment_number*CenterControlObject.getNetStatusThreadNumber();
					int	endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
					if(number>startNum){
						logger.info("检测中控设备网络状态线程："+CenterControlObject.getNetStatusThreadNumber());
						EquipmentNetStatusTask task = new EquipmentNetStatusTask(System.currentTimeMillis()+"",equipmentType+"",startNum);
						CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),task,"中控设备（"+startNum+"到"+endNum+")网络情况");//在指定的时间间隔能执行命令
						threadList.add(task);
						EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL);
					} 
				}
		    	break;
		     case EquipmentObject.EQUIPMENT_TYPE_OTHER:		
		    	number = EquipmentObjectImpl.otherEquipmentObjectes.size();
				if(number==0) break;
				for(int i=0;i<number;i++){
					int	startNum = EquipmentObjectImpl.net_status_equipment_number*OtherEquipmentObject.getNetStatusThreadNumber();
					int	endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
					if(number>startNum){
						logger.info("启动检测其他设备网络状态线程");
						EquipmentNetStatusTask task = new EquipmentNetStatusTask(System.currentTimeMillis()+"",equipmentType+"",startNum);
						CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),task,"其他设备（"+startNum+"到"+endNum+")网络情况");
						threadList.add(task);
						EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_OTHER);
					}
				}
		    	break;	
		     case EquipmentObject.EQUIPMENT_TYPE_REACH:		
			    	number = EquipmentObjectImpl.reachObjectes.size();
					if(number==0) break;
					for(int i=0;i<number;i++){
						int	startNum = EquipmentObjectImpl.net_status_equipment_number*OtherEquipmentObject.getNetStatusThreadNumber();
						int	endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
						if(number>startNum){
							logger.info("启动检测锐取设备网络状态线程");
							EquipmentNetStatusTask task = new EquipmentNetStatusTask(System.currentTimeMillis()+"",equipmentType+"",startNum);
							CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),task,"锐取设备（"+startNum+"到"+endNum+")网络情况");
							threadList.add(task);
							EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_REACH);
						}
					}
			    	break;	
		     default:	break;
		}
		return true;
	};
	
	/**
	 * 关闭一类设备的状态检测线程
	 * @param	设备类型
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public static boolean stopEquipmentNetStatusThreads(int equipmentType) {
		for(EquipmentNetStatusTask task :	threadList){
			if(task.getTimeTaskName().equalsIgnoreCase(equipmentType+""))
				task.setLoop(false);
		}
		return true;
	};
}
