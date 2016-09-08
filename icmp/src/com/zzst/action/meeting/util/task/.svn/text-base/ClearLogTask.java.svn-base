package com.zzst.action.meeting.util.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.util.timerTask.CjfTimeTask;

public class ClearLogTask  extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(ClearLogTask.class.getName());

	public ClearLogTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	@Override
	public boolean excuteTask() {
		logger.info("ClearLogTask	excuteTask	begin");
		try{
			LogVO logVO = new LogVO();
			logVO.setLogType(Integer.MIN_VALUE);
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, -MeetingAppConfig.CLEAR_LOG_PERIOD);
			logVO.setEndTime(new Timestamp(c.getTimeInMillis()));
			ArrayList<LogVO> logVOList = ServiceFactory.getLogService().query(logVO,null);
			logger.info("清理日志"+logVOList.size()+"条");
			for(LogVO vo : logVOList){
				ServiceFactory.getLogService().deleteByID(vo.getLogID());
			}
		}catch(Exception e){
			logger.error("ClearLogTask	excuteTask	exception："+e.getMessage());
		}
		logger.info("ClearLogTask	excuteTask	end");
		return false;
	}
}
