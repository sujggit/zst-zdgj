package com.zzst.action.meeting.meeting;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;

public class DebugConferenceAction extends CjfAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(DebugConferenceAction.class.getName());
	
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingDetailVO>  meetingDetailList = new ArrayList<MeetingDetailVO>();
	
	public	String	queryDebugConferenceList(){
		logger.info("DebugConferenceAction	queryDebugConferenceList		begin");
		try{
			meetingDetailVO	=	new MeetingDetailServiceImpl().queryByID(meetingDetailVO.getMeetingDetailID());
			
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			MeetingDetailVO	vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingID(meetingDetailVO.getMeetingDetailID());
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO_DEBUG);
			
			meetingDetailList = meetingDetailService.getMeetingDetailList(vMeetingDetailVO, null);

		}catch(Exception e){
			logger.error("DebugConferenceAction	queryDebugConferenceList	error："+e.getMessage());
			return ERROR;
		}
		logger.info("DebugConferenceAction	queryDebugConferenceList		end");
		return SUCCESS;
	}
	
	public ArrayList<MeetingDetailVO> getMeetingDetailList() {
		return meetingDetailList;
	}

	public void setMeetingDetailList(ArrayList<MeetingDetailVO> meetingDetailList) {
		this.meetingDetailList = meetingDetailList;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
	
	
}
