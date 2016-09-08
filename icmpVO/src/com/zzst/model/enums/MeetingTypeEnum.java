package com.zzst.model.enums;

public class MeetingTypeEnum {

	private static final long serialVersionUID = 1L;

	public static final int HOST_MEETING_NEW=1;//本地会议
//	
	public static final String HOSTCOPTION_MEETING="本地会议";//本地会议
//	
	public static final int PLOYCOM_MEETING_NEW=2;//视频会议
//	
	public static final String PLOYCOMCOPTION_MEETING ="视频会议";//视频会议
	
	public static final int selfMeetingType=11;//自主预定会议
	public static final int assignLocalMeetingType=21;//委托本地会议
	public static final int assignVideoMeetingType=22;//委托视频会议
	public static final int detailLocalMeetingType=31;//详细本地会议
	public static final int detailVideoMeetingType=32;//详细视频会议
	
	public static final String selfMeetingName = "自主预定会议";
	public static final String assignLocalMeetingName = "委托本地会议";
	public static final String assignVideoMeetingName = "委托视频会议";
	public static final String detailLocalMeetingName = "详细本地会议";
	public static final String detailVideoMeetingName = "详细视频会议";
	
	public	static	final boolean isHostMeeting(int param){
		if(HOST_MEETING_NEW==param ||  selfMeetingType==param || assignLocalMeetingType==param || detailLocalMeetingType ==param){
			return true;
		}
		return false;
	}
	
	/**
	 * 委托视频会议\详细视频会议
	 * @param param
	 * @return
	 * modify by xiamj on 2010-1-28
	 */
	public	static	final boolean isPolycomMeeting(int param){
		if( PLOYCOM_MEETING_NEW==param || assignVideoMeetingType==param|| detailVideoMeetingType ==param){
			return true;
		}
		return false;
	}
	
	public static String getMeetingTypeName(int typeID){
		String returnStr="";
		
		if(selfMeetingType==typeID){
			returnStr="自主预定会议";
		}else if(assignLocalMeetingType==typeID){
			returnStr= "委托本地会议";
		}else if(assignVideoMeetingType==typeID){
			returnStr= "委托视频会议";
		}else if(detailLocalMeetingType==typeID){
			returnStr= "本地会议";
		}else if(detailVideoMeetingType==typeID){
			returnStr= "视频会议";
		}
		return returnStr;
	}

	
	/**
	 * 数据字典模块使用
	 * 提取所有会议类型
	 * @return
	 */
	public static String[][] getMeetingType(){
		String[][] s = new String[2][2];
		s[0][0] =	HOST_MEETING_NEW+"";
		s[0][1] =	HOSTCOPTION_MEETING;
		s[1][0] =	PLOYCOM_MEETING_NEW+"";
		s[1][1] =	PLOYCOMCOPTION_MEETING;
//		s[2][0] =   selfMeetingType + "";
//		s[2][1] =   selfMeetingName;
//		s[3][0] =   assignLocalMeetingType + "";
//		s[3][1] =   assignLocalMeetingName;
//		s[4][0] = 	assignVideoMeetingType + "";
//		s[4][1] =   assignVideoMeetingName;
//		s[5][0] =	detailLocalMeetingType + "";
//		s[5][1] =   detailLocalMeetingName;
//		s[6][0] = 	detailVideoMeetingType + "";
//		s[6][1] =   detailVideoMeetingName;
		return s;
	}
	
}
