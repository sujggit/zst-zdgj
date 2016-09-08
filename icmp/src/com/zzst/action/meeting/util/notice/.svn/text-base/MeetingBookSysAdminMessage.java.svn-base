package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

public class MeetingBookSysAdminMessage extends MessageContent implements Message{
	private String type;
	public MeetingBookSysAdminMessage(String type){
			this.type = type;
	}
	@Override
	public String getMessage(Object[] obj) {
		String message = "";
		if(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING.equals(type)){
			
			message = super.getMessageContent("base_info_notice_meetingbook_sysadmin");
			message = super.replaceStr(obj, message);
		}else if(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING.equals(type)){
			
			message = super.getMessageContent("base_info_notice_meetingbookmodify_sysadmin");
			message = super.replaceStr(obj, message);
		}else if(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING.equals(type)){
			
			message = super.getMessageContent("base_info_notice_meetingbookdel_sysadmin");
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
		return meetingDetail.getMeetingDebugVO().getNoticeTime();
	
	}
}
