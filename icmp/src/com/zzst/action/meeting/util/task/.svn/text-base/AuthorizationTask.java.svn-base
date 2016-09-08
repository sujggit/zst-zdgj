package com.zzst.action.meeting.util.task;


import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description	
 *系统启动检查授权，每天定时检查授权。
 *
 *@date 2013-5-29下午05:53:32
 *@author ryan
 */
public class AuthorizationTask extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(AuthorizationTask.class.getName());

	public AuthorizationTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	@Override
	public boolean excuteTask() {
		logger.info("AuthorizationTask	excuteTask	begin");
		
//		//如果满足时长
//		if(MeetingAppConfig.authorization_date.before(new Timestamp(System.currentTimeMillis()))){
//			MeetingAppConfig.authorizatione = false;
//		}
		logger.info("AuthorizationTask	excuteTask	end");
		return false;
	}
}
