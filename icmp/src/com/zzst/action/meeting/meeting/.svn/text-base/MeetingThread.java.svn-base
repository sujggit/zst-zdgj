package com.zzst.action.meeting.meeting;

import java.util.ArrayList;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

public class MeetingThread implements Runnable{
	private MeetingDetailVO mVO;
	private String[] users;
	private String[] meetingrooms;
	private String type;
	private ArrayList<VideoconferenceVO> roomList;
	private ArrayList<UserVO> userList;
	private String departIDs;
	
	public final static String ADD = "add";
	public final static String MODIFY = "modify";
	public final static String GENERAL_ADD = "general_add";
	public final static String GENERAL_MODIFY = "general_modify";
	
	public MeetingThread(MeetingDetailVO mVO,String[] users,String[] meetingrooms,String type){
		this.mVO = mVO;
		this.users = users;
		this.meetingrooms = meetingrooms;
		this.type = type;
	}
	
	public MeetingThread(MeetingDetailVO mVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList,String departIDs,String type){
		this.mVO = mVO;
		this.userList = userList;
		this.roomList = roomList;
		this.departIDs = departIDs;
		this.type = type;
	}
	
	public void run(){
		if(ADD.equals(type)){
			ServiceFactory.getMeetingDetailService().addVedioMeetingDetail(mVO, users, meetingrooms);
		}else if(MODIFY.equals(type)){
			ServiceFactory.getMeetingDetailService().modifyVedioMeetingDetail(mVO, users, meetingrooms);
		}else if(GENERAL_ADD.equals(type)){
			ServiceFactory.getMeetingDetailService().addGeneralMeetingDetailThread(mVO, userList, roomList, departIDs);
		}else if(GENERAL_MODIFY.equals(type)){
			ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(mVO, userList, roomList, departIDs);
		}
	}
}
