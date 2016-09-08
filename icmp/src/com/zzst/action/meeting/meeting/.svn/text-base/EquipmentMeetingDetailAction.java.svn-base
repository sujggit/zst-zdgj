package com.zzst.action.meeting.meeting;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

public class EquipmentMeetingDetailAction extends CjfAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(ConferenceAction.class.getName());
	private MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
	private ArrayList<MeetingDetailEquipmentVO> mList = new ArrayList<MeetingDetailEquipmentVO>();
	
	public	String	equipmentMeetingList(){
		logger.info("EquipmentMeetingDetailAction	equipmentMeetingList		begin");
		try{
			mList = ServiceFactory.getMeetingDetailEquipmentService().queryMeeting(meetingDetailEquipmentVO, null);
		}catch(Exception e){
			logger.error("EquipmentMeetingDetailAction	equipmentMeetingList	error："+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentMeetingDetailAction	equipmentMeetingList		end");
		return "SUCCESS";
	}

	

	public MeetingDetailEquipmentVO getMeetingDetailEquipmentVO() {
		return meetingDetailEquipmentVO;
	}



	public void setMeetingDetailEquipmentVO(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO) {
		this.meetingDetailEquipmentVO = meetingDetailEquipmentVO;
	}



	public ArrayList<MeetingDetailEquipmentVO> getMList() {
		return mList;
	}

	public void setMList(ArrayList<MeetingDetailEquipmentVO> list) {
		mList = list;
	}
	
	
}
