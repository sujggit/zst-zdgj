package com.zzst.model.enums;

public class MeetingRoomEnum {

	private static final long serialVersionUID = 1L;

	public static final int ROOM_TYPE_GENERAL=1;//本地会议室
	public static final int ROOM_TYPE_VEDIO=2;//视频会议室
	
	public static final int ROOM_STATUS_VALID=0;//有效
	public static final int ROOM_STATUS_INVALID=1;//无效
	public static final int ROOM_STATUS_MODIFY=2;//维修
	
	public static String[][] getMeetingRooomStatus(){
		String[][] status = new String[2][2];
		status[0][0] = ROOM_STATUS_VALID+"";
		status[0][1] = "正常";
//		status[2][0] = ROOM_STATUS_INVALID+"";
//		status[2][1] = "失效";
		status[1][0] = ROOM_STATUS_MODIFY+"";
		status[1][1] = "维修";
		return status;
	}
	
	public static String[][] getMeetingRooomType(){
		String[][] status = new String[2][2];
		status[0][0] = ROOM_TYPE_GENERAL+"";
		status[0][1] = "本地会议室";
		status[1][0] = ROOM_TYPE_VEDIO+"";
		status[1][1] = "视频会议室";
		return status;
	}
	
//	/**
//	 * addby chenshuo
//	 * 数据字典使用
//	 * 提取所有会议室类型
//	 * @return
//	 */
//	public static String[][] getMeetingRooomType1(){
//		String[][] status = new String[2][2];
//		status[0][0] = ROOM_TYPE_GENERAL+"";
//		status[0][1] = "本地会议室";
//		status[1][0] = ROOM_TYPE_VEDIO+"";
//		status[1][1] = "视频会议室";
//		return status;
//	}
}
