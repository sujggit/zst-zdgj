package com.zzst.model.enums;

import java.util.HashMap;

/**
 * 数据字典相关
 * @author zhangdq
 *
 */
public class DictionaryEnum {
	//z_t_equipment_dictionary表中sysValue字段
	public static int sysValue = 0;//页面增加的设备
	public static int sysValue_lock = 1;//系统基础数据
	
	//z_t_equipment_dictionary表中status字段
	public static int STATUS_INVALID = 0;//无效
	public static int STATUS_VALID   = 1;//有效
	
	//z_t_equipment_dictionary表中根节点的dicID
	public static String dicID = "a";
	
	public static String meetingTime = "meetingTime";//定义会议时长
	public static String meetingTime_Name = "立即召开-会议时长";
	
	public static final String MEETINGCOST = "meetingCost";//定义会议费用-费用项
	public static final String MEETINGCOST_NAME = "会议费用-费用项";
	
	public static final String MEETLABLE="meetLable";//会议标签
	public static final String MEETLABLE_NAME = "会议标签";
	
	public static final String EQUIPMENTSTATUS = "equipmentStatus";//会场维护~设备状态
	public static final String EQUIPMENTSTATUS_NAME = "会场记录-记录项状态";
	
	public static final String EQUIPMENTTYPE = "equipmentType";//会场维护~设备类型
	public static final String EQUIPMENTTYPE_NAME = "会场记录-记录项";
	
	public static final String DICTYPE_APPLYFLOW = "applyFlow";	//数据字典内流程类型的配置
	public static final String DICTYPE_APPLYFLOW_NAME = "流程类型";
	
	public static final String MYSTATUS = "myStatus";//会议状态
	public static final String MYSTATUS_NAME = "会议状态";
	
	public static final String MEETINGSERVICETYPE = "meetingServiceType";//会议类型
	public static final String MEETINGSERVICETYPE_NAME = "会议服务类型";
	
	public static final String MEETINGDEBUGDURATION = "meetingDebugDuration";//会议调试默认时长
	public static final String MEETINGDEBUGDURATION_NAME = "调试会议时长";
	
	public static final String MAINTENANCESTARTTIME = "maintenanceStartTime";//维保日期
	public static final String MAINTENANCESTARTTIME_NAME = "设备维保期限";
	
	public static final String POLLTIMESPAN = "pollTimeSpan";//轮询间隔时间
	public static final String POLLTIMESPAN_NAME = "轮询间隔时间";
	
	public static final String MEETINGNOTICETYPE = "meetingNoticeType";//会议通知类型
	public static final String MEETINGNOTICETYPE_NAME = "会议通知类型";
	
	public static final String MEETINGRECORDTYPE = "meetingRecordType";//会议录制类型
	public static final String MEETINGRECORDTYPE_NAME = "会议录制类型";
	
	public static final String CONTROLMENU = "controlMenu";
	public static final String CONTROLMENU_NAME = "控制菜单";
	
	public static final String CONTROLRightMENU = "controlRightMenu";
	public static final String CONTROLRightMENU_NAME = "右键菜单";
	
	public static final String CHANGECSS = "changeCss";
	public static final String CHANGECSS_NAME = "换肤模板";
	
	public static String[][] getDicType(){
		String[][] s = new String[9][2];
		s[0][0] = meetingTime;
		s[0][1] = meetingTime_Name;
		s[1][0] = MEETINGCOST;
		s[1][1] = MEETINGCOST_NAME;
		s[2][0] = MEETLABLE;
		s[2][1] = MEETLABLE_NAME;
		s[3][0] = EQUIPMENTSTATUS;
		s[3][1] = EQUIPMENTSTATUS_NAME;
		s[4][0] = EQUIPMENTTYPE;
		s[4][1] = EQUIPMENTTYPE_NAME;
//		s[5][0] = DICTYPE_APPLYFLOW;
//		s[5][1] = DICTYPE_APPLYFLOW_NAME;
//		s[6][0] = MYSTATUS;
//		s[6][1] = MYSTATUS_NAME;
	    s[5][0] = MEETINGSERVICETYPE;
	    s[5][1] = MEETINGSERVICETYPE_NAME;
	    s[6][0] = MEETINGDEBUGDURATION;
	    s[6][1] = MEETINGDEBUGDURATION_NAME;
	    s[7][0] = MAINTENANCESTARTTIME;
	    s[7][1] = MAINTENANCESTARTTIME_NAME;
	    s[8][0] = POLLTIMESPAN;
	    s[8][1] = POLLTIMESPAN_NAME;
//	    s[11][0] = MEETINGNOTICETYPE;
//	    s[11][1] = MEETINGNOTICETYPE_NAME;
//	    s[12][0] = MEETINGRECORDTYPE;
//	    s[12][1] =MEETINGRECORDTYPE_NAME;
//	    s[14][0] = CONTROLMENU;
//	    s[14][1] = CONTROLMENU_NAME;
//	    s[13][0] = CHANGECSS;
//	    s[13][1] = CHANGECSS_NAME;
		return s;
	}
	
	/**
	 * CONTROLMENU_ENDMEETING
	 * 会议分屏screenModel轮询startPolling1暂停轮询pollSuspend定制轮询pollmodify
	 * 延时会议delayMeetingTime显示字幕getMessageOverlay开始录制暂停录制继续录制结束录制recordControl
	 * 结束会议deleteConf连接挂断静音取消静音mute闭音取消闭音block闭视取消闭视suspend
	 * 添加会场删除会场delParticipants会场分屏setPersonal终端备份terminalBackup
	 * 预监openyjMCU备份openmcubk
	 */
	
	public static final int CONTROLMENUGROUP_FIRST = 1;
	
	public static final String CONTROLMENU_ENDCONFERENCE_ID = "CM001";//结束会议
	public static final String CONTROLMENU_ENDCONFERENCE_NAME = "结束会议";//结束会议
	
	public static final String CONTROLMENU_SCREENMODEL_ID = "CM002";
	public static final String CONTROLMENU_SCREENMODEL_NAME = "会议分屏";
	
	public static final String CONTROLMENU_POLLSTART_ID = "CM003";
	public static final String CONTROLMENU_POLLSTART_NAME = "开始轮询";
	
	public static final String CONTROLMENU_POLLSUSPEND_ID = "CM004";
	public static final String CONTROLMENU_POLLSUSPEND_NAME = "结束轮询";
	
	public static final String CONTROLMENU_POLLSDEFINED_ID = "CM005";
	public static final String CONTROLMENU_POLLSDEFINED_NAME = "修改轮询";
	
	public static final String CONTROLMENU_DELAYCONFERENCE_ID = "CM006";
	public static final String CONTROLMENU_DELAYCONFERENCE_NAME = "延时会议";
	
	public static final String CONTROLMENU_SUBTITLE_ID = "CM007";
	public static final String CONTROLMENU_SUBTITLE_NAME = "显示字幕";
	
	public static final String CONTROLMENU_RECORDSTART_ID = "CM008";
	public static final String CONTROLMENU_RECORDSTART_NAME = "开始录制";
	
//	public static final String CONTROLMENU_RECORDSUSPEND_ID = "CM009";
//	public static final String CONTROLMENU_RECORDSUSPEND_NAME = "暂停录制";
//	
//	public static final String CONTROLMENU_RECORDCONTINUE_ID = "CM010";
//	public static final String CONTROLMENU_RECORDCONTINUE_NAME = "继续录制";
	
	public static final String CONTROLMENU_RECORDEND_ID = "CM011";
	public static final String CONTROLMENU_RECORDEND_NAME = "结束录制";
	
	public static final String CONTROLMENU_CONNECT_ID = "CM012";
	public static final String CONTROLMENU_CONNECT_NAME = "连接";
	
	public static final String CONTROLMENU_DISCONNECT_ID = "CM013";
	public static final String CONTROLMENU_DISCONNECT_NAME = "挂断";
	
	public static final String CONTROLMENU_MUTE_ID = "CM014";
	public static final String CONTROLMENU_MUTE_NAME = "静音";
	
	public static final String CONTROLMENU_UNMUTE_ID = "CM015";
	public static final String CONTROLMENU_UNMUTE_NAME = "取消静音";
	
	public static final String CONTROLMENU_BLOCKAUDIO_ID = "CM016";
	public static final String CONTROLMENU_BLOCKAUDIO_NAME = "闭音";
	
	public static final String CONTROLMENU_UNBLOCKAUDIO_ID = "CM017";
	public static final String CONTROLMENU_UNBLOCKAUDIO_NAME = "取消闭音";
	
	public static final String CONTROLMENU_SUSPENDVIDEO_ID = "CM018";
	public static final String CONTROLMENU_SUSPENDVIDEO_NAME = "视频屏蔽";
	
	public static final String CONTROLMENU_UNSUSPENDVIDEO_ID = "CM019";
	public static final String CONTROLMENU_UNSUSPENDVIDEO_NAME = "取消视频屏蔽";
	
	public static final String CONTROLMENU_CREATROOM_ID = "CM020";
	public static final String CONTROLMENU_CREATROOM_NAME = "添加会场";
	
	public static final String CONTROLMENU_DELROOM_ID = "CM021";
	public static final String CONTROLMENU_DELROOM_NAME = "删除会场";
	
	public static final String CONTROLMENU_YUJIAN_ID = "CM022";
	public static final String CONTROLMENU_YUJIAN_NAME = "预监";
	
	public static final String CONTROLMENU_BEIFEN_ID = "CM023";
	public static final String CONTROLMENU_BEIFEN_NAME = "MCU备份";
	
	public static final String CONTROLMENU_TONGBU_ID = "CM024";
	public static final String CONTROLMENU_TONGBU_NAME = "数据同步";
	
	public static final String CONTROLMENU_JLD_ID = "CM025";
	public static final String CONTROLMENU_JLD_NAME = "创建级联点";
	
	public static final String CONTROLMENU_CONFERENCE_MAINTAIN_ID = "CM026";
	public static final String CONTROLMENU_CONFERENCE_MAINTAIN_NAME = "会议记录";
	
	public static String[][] getControlMenu(){
		String[][] type = new String[24][2];
		type[0][0] = CONTROLMENU_ENDCONFERENCE_ID;
		type[0][1] = CONTROLMENU_ENDCONFERENCE_NAME;
		type[1][0] = CONTROLMENU_SCREENMODEL_ID;
		type[1][1] = CONTROLMENU_SCREENMODEL_NAME;
		type[2][0] = CONTROLMENU_POLLSTART_ID;
		type[2][1] = CONTROLMENU_POLLSTART_NAME;
		type[3][0] = CONTROLMENU_POLLSUSPEND_ID;
		type[3][1] = CONTROLMENU_POLLSUSPEND_NAME;
		type[4][0] = CONTROLMENU_POLLSDEFINED_ID;
		type[4][1] = CONTROLMENU_POLLSDEFINED_NAME;
		type[5][0] = CONTROLMENU_DELAYCONFERENCE_ID;
		type[5][1] = CONTROLMENU_DELAYCONFERENCE_NAME;
		type[6][0] = CONTROLMENU_SUBTITLE_ID;
		type[6][1] = CONTROLMENU_SUBTITLE_NAME;
		type[7][0] = CONTROLMENU_RECORDSTART_ID;
		type[7][1] = CONTROLMENU_RECORDSTART_NAME;
		
		type[8][0]=CONTROLMENU_BEIFEN_ID;
		type[8][1]=CONTROLMENU_BEIFEN_NAME;
		type[9][0]=CONTROLMENU_TONGBU_ID;
		type[9][1]=CONTROLMENU_TONGBU_NAME;
		
		type[10][0] = CONTROLMENU_RECORDEND_ID;
		type[10][1] = CONTROLMENU_RECORDEND_NAME;
		type[11][0] = CONTROLMENU_CONNECT_ID;
		type[11][1] = CONTROLMENU_CONNECT_NAME;
		type[12][0] = CONTROLMENU_DISCONNECT_ID;
		type[12][1] = CONTROLMENU_DISCONNECT_NAME;
		type[13][0] = CONTROLMENU_MUTE_ID;
		type[13][1] = CONTROLMENU_MUTE_NAME;
		type[14][0] = CONTROLMENU_UNMUTE_ID;
		type[14][1] = CONTROLMENU_UNMUTE_NAME;
		type[15][0] = CONTROLMENU_BLOCKAUDIO_ID;
		type[15][1] = CONTROLMENU_BLOCKAUDIO_NAME;
		type[16][0] = CONTROLMENU_UNBLOCKAUDIO_ID;
		type[16][1] = CONTROLMENU_UNBLOCKAUDIO_NAME;
		type[17][0] = CONTROLMENU_SUSPENDVIDEO_ID;
		type[17][1] = CONTROLMENU_SUSPENDVIDEO_NAME;
		type[18][0] = CONTROLMENU_UNSUSPENDVIDEO_ID;
		type[18][1] = CONTROLMENU_UNSUSPENDVIDEO_NAME;
		type[19][0] = CONTROLMENU_CREATROOM_ID;
		type[19][1] = CONTROLMENU_CREATROOM_NAME;
		type[20][0] = CONTROLMENU_DELROOM_ID;
		type[20][1] = CONTROLMENU_DELROOM_NAME;
		type[21][0] = CONTROLMENU_YUJIAN_ID;
		type[21][1] = CONTROLMENU_YUJIAN_NAME;
		type[22][0] = CONTROLMENU_JLD_ID;
		type[22][1] = CONTROLMENU_JLD_NAME;
		type[23][0] = CONTROLMENU_CONFERENCE_MAINTAIN_ID;
		type[23][1] = CONTROLMENU_CONFERENCE_MAINTAIN_NAME;
//		type[8][0] = CONTROLMENU_RECORDSUSPEND_ID;
//		type[8][1] = CONTROLMENU_RECORDSUSPEND_NAME;
//		type[9][0] = CONTROLMENU_RECORDCONTINUE_ID;
//		type[9][1] = CONTROLMENU_RECORDCONTINUE_NAME;

		return type;
	}
	
	public static HashMap<String, String> controlMenuMap = new HashMap<String, String>();
	
	public static HashMap<String, String> getControlMenuMap(){
		String[][] controlMenus = getControlMenu();
		for(int i=0;i<controlMenus.length;i++ ){
			controlMenuMap.put(controlMenus[i][0],controlMenus[i][1]);
		}
		return controlMenuMap;
	}
	
}
