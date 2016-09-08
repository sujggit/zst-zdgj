package com.zzst.action.meeting.meeting.task;


import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.timerTask.CjfTimerHelper;


/**
 *@Description
 *@date 2011-12-5上午10:35:57
 *@author ryan
 */
public class MeetingTaskOperate {
	private static Logger logger = CjfLogger.getLogger(MeetingTaskOperate.class.getName());
 
	/**
	 * 会议开始，执行此项操作
	 * @param meetingVO
	 */
	public	static	void	meetingStartTask(MeetingDetailVO meetingDetailVO){
		logger.info("MeetingTaskOperate	meetingStartTask	begin");
		meetingStartTask(meetingDetailVO,"建立预约会议");
		logger.info("MeetingTaskOperate	meetingStartTask	end");
	}
	
	/**
	 * 根据会议与设备的关系表建立会议
	 * @param meetingDetailVO
	 * @param taskName	
	 * @return
	 */
	public	static	boolean	meetingStartForEquipment(MeetingDetailVO meetingDetailVO){
		logger.info("MeetingTaskOperate	meetingStartForEquipment	begin");
		if(!MeetingAppConfig.CONFERENCE_AUTO_TASK){
			logger.info("系统设置为不自动建立会议");
			return false;
		}
		
		if(meetingDetailVO==null||meetingDetailVO.getMeetingDetailID()==null){
			return false;
		}
		
		CjfTimerHelper.addTimerTask(
				meetingDetailVO.getMeetingStartTime()   
				, new MeetingStartForEquipmentTask("start-"+meetingDetailVO.getMeetingDetailID(),"建立会议",meetingDetailVO));
		logger.info("MeetingTaskOperate	meetingStartForEquipment	end");
		return true;
	}

	/**
	 * 会议结束，执行此项操作
	 * @param meetingVO
	 */
	public	static	void	meetingEndTask(MeetingDetailVO meetingDetailVO){
		logger.info("MeetingTaskOperate	meetingEndTask	begin");
		meetingEndTask(meetingDetailVO,"结束预约会议");
		logger.info("MeetingTaskOperate	meetingEndTask	end");
	}
	
	/**
	 * 移除会议定时器
	 * @param meetingDetailID
	 */
	public	static	void	removeMeetingEndTask(String timeTaskID){
		logger.info("MeetingTaskOperate	removeMeetingEndTask	begin");
		if(timeTaskID==null){
			return ;
		}
		CjfTimerHelper.removeTimerTask("start-"+timeTaskID);
		CjfTimerHelper.removeTimerTask("end-"+timeTaskID);
		logger.info("MeetingTaskOperate	removeMeetingEndTask	end");
	}
	
	/**
	 * 调试会议开始，执行此项操作
	 * @param meetingVO
	 */
	public	static	void	debugMeetingStartTask(MeetingDetailVO meetingDetailVO){
		logger.info("MeetingTaskOperate	debugMeetingStartTask	begin");
		meetingStartTask(meetingDetailVO,"建立调试会议");
		logger.info("MeetingTaskOperate	debugMeetingStartTask	end");
	}
	
	
	/**
	 * 调试会议结束，执行此项操作
	 * @param meetingVO
	 */
	public	static	void	debugMeetingEndTask(MeetingDetailVO meetingDetailVO){
		logger.info("MeetingTaskOperate	debugMeetingEndTask	begin");
		meetingEndTask(meetingDetailVO,"结束调试会议");
		logger.info("MeetingTaskOperate	debugMeetingEndTask	end");
	}
	
	/**
	 * 会议开始，执行此项操作
	 * @param meetingVO
	 */
	private	static	void	meetingStartTask(MeetingDetailVO meetingDetailVO,String taskName){
		logger.info("MeetingTaskOperate	meetingStartTask	begin");
		if(!MeetingAppConfig.CONFERENCE_AUTO_TASK){
			logger.info("系统设置为不自动建立会议");
			return;
		}
		
		if(meetingDetailVO==null){
			return ;
		}
		
		CjfTimerHelper.addTimerTask(
				meetingDetailVO.getMeetingStartTime()   
				, new MeetingStartTask("start-"+meetingDetailVO.getMeetingDetailID(),taskName,meetingDetailVO));
		logger.info("MeetingTaskOperate	meetingStartTask	end");
	}
	
	
	/**
	 * 会议结束，执行此项操作
	 * @param meetingVO
	 */
	private	static	void	meetingEndTask(MeetingDetailVO meetingDetailVO,String taskName){
		logger.info("MeetingTaskOperate	meetingEndTask	begin");
		if(!MeetingAppConfig.CONFERENCE_AUTO_TASK){
			logger.info("系统设置为不自动结束会议");
			return;
		}
		
		if(meetingDetailVO==null){
			return ;
		}
		
		CjfTimerHelper.addTimerTask(
				meetingDetailVO.getMeetingEndTime() 
				, new MeetingEndTask("end-"+meetingDetailVO.getMeetingDetailID(),taskName,meetingDetailVO));
		logger.info("MeetingTaskOperate	meetingEndTask	end");
	}
}
