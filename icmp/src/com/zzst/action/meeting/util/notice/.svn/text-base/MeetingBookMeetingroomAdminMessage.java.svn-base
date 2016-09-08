package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

public class MeetingBookMeetingroomAdminMessage extends MessageContent implements Message {

	private String type;
	public MeetingBookMeetingroomAdminMessage(String type){
			this.type = type;
	}
	@Override
	public String getMessage(Object[] obj) {
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		MeetingRoomVO mr = (MeetingRoomVO)obj[1];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分 ");
		String message = "";
		if(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING.equals(type)){
			message = super.getMessageContent("base_info_notice_meetingbook_radmin");
			message = super.replaceStr(obj, message);
		}else if(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING.equals(type)){
			message = super.getMessageContent("base_info_notice_meetingbookmodify_radmin");
			message = super.replaceStr(obj, message);
		}else if(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING.equals(type)){
			message = super.getMessageContent("base_info_notice_meetingbookdel_radmin");
			message = super.replaceStr(obj, message);
		}else if(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG.equals(type)){
			message = super.getMessageContent("base_info_notice_meetingdebug_radmin");
			message = super.replaceStr(obj, message);
		}
		 
		return message;
		
	}
	
	@Override
	public String getFlowType(){
		return this.type;
	}
	
	@Override
	public String getFlowIdCont(Object[] obj){
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		return meetingDetail.getMeetingDetailID();
	}
	
	@Override
	public String getMessageSubject(){
		return MeetingAppConfig.MAIL_SUBNAME;
	}
	
	public Timestamp getSendTime(Object[] obj){
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		return meetingDetail.getMeetingDebugVO().getNoticeTime();
	}

}
