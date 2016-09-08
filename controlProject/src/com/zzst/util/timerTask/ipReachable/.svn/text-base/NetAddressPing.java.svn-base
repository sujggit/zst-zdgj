package com.zzst.util.timerTask.ipReachable;

import java.net.InetAddress;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.SystemConfig;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description
 *@date 2012-1-4下午08:03:57
 *@author ryan
 */
public class NetAddressPing extends CjfTimeTask{
	private static Logger logger = Logger.getLogger(NetAddressPing.class.getName());
	public static String terminal_task="1";
	public static String cc_task="0";
	
	public NetAddressPing(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	@Override
	public boolean excuteTask() { 
//		logger.info("检查ip地址是否ping通	begin");
		if(this.getTaskObject()==null) return false;
		try {
			boolean status = true;//InetAddress.getByName(this.getTaskObject().toString()).isReachable(2000);
			if(cc_task.equalsIgnoreCase(this.getTimeTaskName())){
				//已经废弃，已经在其他地方实现
//				CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(this.getTaskObject().toString());
//				if(obj!=null){
//					if(status)
//						obj.setStatus(CenterControlObject.status_on);
//					else 
//						obj.setStatus(CenterControlObject.status_off);	
//				}
			}else if(terminal_task.equalsIgnoreCase(this.getTimeTaskName())){
//				TerminalObject obj = (TerminalObject)ControlFactory.getTerminalObject(this.getTaskObject().toString());
//				if(obj!=null){
//					if(status){
//						if(!TerminalObject.status_onMeeting.equalsIgnoreCase(obj.getStatus()))
//							obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_on);
//					}else{
//						obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_off);
//					}
//				}
			}
//			logger.info("ip:"+this.getTaskObject().toString()+"状态："+status);	
			return true;
		} catch (Exception e) {
			logger.error("定期检查ip是否ping通异常："+e.getMessage());
		}
		return false; 
	}
}
