package com.zzst.action.meeting.util.task;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.dataInterface.meeting.InterfaceMeetingDetailAction;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description	同步标准接口表数据到核心表
 *@date 2013-5-29下午06:40:50
 *@author ryan
 */
public class SynchroDBDataTask extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(SynchroDBDataTask.class.getName());

	public SynchroDBDataTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	
	@Override
	public boolean excuteTask() {
		logger.info("接口数据同步线程	开始");
		
		new InterfaceMeetingDetailAction().dataInput();
		
		logger.info("接口数据同步线程	结束");
		return false;
	}


}
