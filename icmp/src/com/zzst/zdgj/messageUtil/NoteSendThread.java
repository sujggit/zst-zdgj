package com.zzst.zdgj.messageUtil;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

public class NoteSendThread extends Thread{
	private ArrayList<String> mobileList = new ArrayList<String>();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private String type = "";//1 预订信息，2撤销信息
	@Override
	public void run() {
		try {
			//判断是否需要发短信
			if(MeetingAppConfig.sms_status){
				NoteSendUtil.sendNote(mobileList, getSendContent(meetingDetailVO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//构造短信内容
	private String getSendContent(MeetingDetailVO mvo){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(type.equals("1")){//会议：##1将于##2到##3召开，请您准时参加！
			String roomName = mvo.getMeetingRoomName()!=null?mvo.getMeetingRoomName():mvo.getMeetingRoomNames();
			return "会议：【"+mvo.getMeetingName()+"】将于"+format.format(new Date(mvo.getMeetingStartTime().getTime()))+"到"+format.format(new Date(mvo.getMeetingEndTime().getTime()))+"在【"+roomName+"】召开，请您准时参加！";
		}else{//定于##2召开的会议：##1 已取消，您无需参加本次会议。
			return "定于"+format.format(new Date(mvo.getMeetingStartTime().getTime()))+"召开的会议：【"+mvo.getMeetingName()+"】已取消，您无需参加本次会议。";
		}
	}
	
	public NoteSendThread(ArrayList<String> mobileList,
			MeetingDetailVO meetingDetailVO, String type) {
		this.mobileList = mobileList;
		this.meetingDetailVO = meetingDetailVO;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getMobileList() {
		return mobileList;
	}
	public void setMobileList(ArrayList<String> mobileList) {
		this.mobileList = mobileList;
	}
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}
	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
	
	public static void main(String[] args) {
		ArrayList<String> ml = new ArrayList<String>();
		MeetingDetailVO mdv = new MeetingDetailVO();
		ml.add("15701574020");
		//ml.add("15701574021");
		mdv.setMeetingName("测试会议");
		mdv.setMeetingStartTime(new Timestamp(new Date().getTime()));
		mdv.setMeetingEndTime(new Timestamp(new Date().getTime()+60*60*1000));
		NoteSendThread nst = new NoteSendThread(ml, mdv,"2");
		nst.start();
	}
	
}
