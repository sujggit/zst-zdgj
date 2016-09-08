package com.zzst.action.meeting.meeting.task;


import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.InitMeetingTaskDate;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description	每天定时执行
 *@date 2012-1-29下午04:29:38
 *@author ryan
 */
public class MeetingDayTaskPeriod  extends CjfTimeTask {

	public MeetingDayTaskPeriod(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	private static Logger logger = CjfLogger.getLogger(MeetingDayTaskPeriod.class.getName());

	public boolean excuteTask() { 
		logger.info("每天定时执行***加载会议信息");
		InitMeetingTaskDate.initMeetingDetailTaskDate();
		return false;
	}
}