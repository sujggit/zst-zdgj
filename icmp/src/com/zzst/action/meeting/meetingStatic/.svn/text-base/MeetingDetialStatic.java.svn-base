package com.zzst.action.meeting.meetingStatic;

import java.util.ArrayList;

public class MeetingDetialStatic {
 private String meetingDetialID;
 private String monitorMeetingRoomIP;
 private String[] nowMonitorMeetRoom;
 
 static ArrayList<MeetingDetialStatic> meetingListStaticList=new  ArrayList<MeetingDetialStatic>();
 
public String getMeetingDetialID() {
	return meetingDetialID;
}
public void setMeetingDetialID(String meetingDetialID) {
	this.meetingDetialID = meetingDetialID;
}
public String getMonitorMeetingRoomIP() {
	return monitorMeetingRoomIP;
}
public void setMonitorMeetingRoomIP(String monitorMeetingRoomIP) {
	this.monitorMeetingRoomIP = monitorMeetingRoomIP;
}
public String[] getNowMonitorMeetRoom() {
	return nowMonitorMeetRoom;
}
public void setNowMonitorMeetRoom(String[] nowMonitorMeetRoom) {
	this.nowMonitorMeetRoom = nowMonitorMeetRoom;
}
public static MeetingDetialStatic getMeetingListStaticList(String meetingID) {
	System.out.println("=============="+meetingID);
	for(MeetingDetialStatic mds:meetingListStaticList){
		if(mds.getMeetingDetialID()==null)continue;
		if(meetingID.equals(mds.getMeetingDetialID())){
			return mds;
		}
	}
	MeetingDetialStatic ret= new MeetingDetialStatic();
	String[] str={""};
	ret.setMeetingDetialID("");
	ret.setMonitorMeetingRoomIP("");
	ret.setNowMonitorMeetRoom(str);
	return ret;
}
public static void addMeetingListStaticList(MeetingDetialStatic meetingListStatic) {
	for(MeetingDetialStatic mds:meetingListStaticList){
		if(meetingListStatic.getMeetingDetialID().equals(mds.getMeetingDetialID())){
			meetingListStaticList.remove(mds);
			break;
		}
	}
	meetingListStaticList.add(meetingListStatic);
}

public static void delMeetingListStatic(String meetingID) {
	for(MeetingDetialStatic mds:meetingListStaticList){
		if(meetingID.equals(mds.getMeetingDetialID())){
			meetingListStaticList.remove(mds);
			break;
		}
	}
	
}
 
}
