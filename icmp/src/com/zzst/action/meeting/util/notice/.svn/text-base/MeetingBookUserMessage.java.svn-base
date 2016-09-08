package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

public class MeetingBookUserMessage extends MessageContent  implements Message {
	private String type;
	public MeetingBookUserMessage(String type){
			this.type = type;
	}
	@Override
	public String getMessage(Object[] obj) {
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分 ");
		String message = "";
		if(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING.equals(type)){
			if(meetingDetail.getMeetingType()==MeetingDetailEnum.TYPE_GENERAL){
				message = super.getMessageContent("base_info_notice_meetingbook_user_local");
				message = super.replaceStr(obj, message);
			}else{
				message = super.getMessageContent("base_info_notice_meetingbook_user");
				message = super.replaceStr(obj, message);
			}
			
		}else if(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING.equals(type)){
			if(meetingDetail.getMeetingType()==MeetingDetailEnum.TYPE_GENERAL){
				message = super.getMessageContent("base_info_notice_meetingbookmodify_user_local");
				message = super.replaceStr(obj, message);
			}else{
				message = super.getMessageContent("base_info_notice_meetingbookmodify_user");
				message = super.replaceStr(obj, message);
			}
			
		}else if(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING.equals(type)){
			message = super.getMessageContent("base_info_notice_meetingbookdel_user");
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
