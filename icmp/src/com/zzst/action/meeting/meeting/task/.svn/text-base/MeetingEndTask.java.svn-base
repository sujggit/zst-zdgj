package com.zzst.action.meeting.meeting.task;


import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.meeting.dwr.McuDwrMethod;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.timerTask.CjfTimeTask;


/**  ssss
 *@Description
 *@date 2011-12-5上午10:19:14
 *@author ryan
 */
public class MeetingEndTask extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(MeetingEndTask.class.getName());
	
	
	public MeetingEndTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	 
	public boolean excuteTask() { 
		
		logger.info("结束会议…………");
		MeetingDetailVO vMeetingDetailVO = (MeetingDetailVO)super.getTaskObject();
		ZZOMcuFactory.getInstance().getMcuControlHelper().deleteConf(vMeetingDetailVO.getMeetingDetailID());
		
		try {
			//插入日志
			LogVO vLogVO = new LogVO();
			vLogVO.setUserID(vMeetingDetailVO.getCreateUserID());
			vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName());
			vLogVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
			vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
			
			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_END+"");
			ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);
			McuDwrMethod.getTerComment().remove(vMeetingDetailVO.getMeetingDetailID());//清楚该会议相关终端备注
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
		
	}

}
