package com.zzst.action.meeting.meeting.task;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.SendMessage;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.timerTask.CjfTimeTask;

/**
 *@Description 会议结束前提醒
 *@date 2013-2-27上午10:19:23
 *@author ryan
 *
 */
public class NoticeTask extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(NoticeTask.class.getName());
	
	
	public NoticeTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	 
	public boolean excuteTask() {
		logger.info("会议结束提醒…………");
		MeetingDetailVO vMeetingDetailVO = (MeetingDetailVO)super.getTaskObject();
		//ZZOMcuFactory.getInstance().getMcuControlHelper().deleteConf(vMeetingDetailVO.getMeetingDetailID());
		InformationVO informationVO = new InformationVO();
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTimeInMillis(MeetingAppConfig.meeting_ent_time);
		informationVO.setContent(vMeetingDetailVO.getMeetingName()+"将要在"+c.get(Calendar.MINUTE)+"分钟后结束，请注意时间");
		informationVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
		informationVO.setInfoType(InformationEnum.TYPE_MEETING);
		informationVO.setStatus(InformationEnum.STATUS_VALID);
		informationVO.setTitle("会议结束提醒");
		informationVO.setSourceName(vMeetingDetailVO.getCreateUserID());
		try {
			ServiceFactory.getInformationService().add(informationVO);
			
		//发送邮件及短信
//			SendMessage sdMessage = new SendMessage(MeetingAppConfig.MESSAGE_TYPE_MEETINGEND,vMeetingDetailVO);
//			sdMessage.sendMessage();
			/**
			 * 接口调整，张建志还没有调整完成
			 */
		} catch (Exception e) {
			logger.error("会议结束提醒异常："+e.getMessage());
		}
		return true;
	}

}