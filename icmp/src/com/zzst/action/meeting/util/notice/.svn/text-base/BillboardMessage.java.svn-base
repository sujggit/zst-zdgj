package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

public class BillboardMessage extends MessageContent implements Message{
	private String type;
	public BillboardMessage(String type){
			this.type = type;
	}
	@Override
	public String getMessage(Object[] obj) {
		String message = "";
		if(MeetingAppConfig.MESSAGE_TYPE_MEETINGBILLBOARD.equals(type)){
			
			message = super.getMessageContent("base_info_notice_meetingbillboard");
			message = super.replaceStr(obj, message);
		}
		 
		return message;
		
	}
	
	public String getFlowType(){
		return this.type;
	}
	
	public String getFlowIdCont(Object[] obj){
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		return meetingDetail.getMeetingDetailID();
	}
	
	public String getMessageSubject(){
		return MeetingAppConfig.MAIL_SUBNAME;
	}
	
	public Timestamp getSendTime(Object[] obj){
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		long sendTimeMills =meetingDetail.getMeetingStartTime().getTime()-MeetingAppConfig.billboard_time*60*1000;
		Timestamp sendTime = new Timestamp(sendTimeMills);
		return sendTime;
	
	}
}
