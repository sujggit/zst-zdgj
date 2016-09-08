package com.zzst.model.enums;


/**
 *@Description	中控基础数据枚举
 *@date 2012-6-28下午03:30:29
 *@author ryan
 */
public class McuCtrlParameterEnum {
	//呼叫方向
	public static final String 	dial_out_id	=	"dial_out";
	public static final String 	dial_out_name	=	"呼出";
	public static final String 	dial_in_id	=	"dial_in";
	public static final String 	dial_in_name	=	"呼入";
	//类型
	public static final String 	h323_id	=	"h323";
	public static final String 	h323_name	=	"h.323";
	public static final String 	sip_id	=	"sip";
	public static final String 	sip_name	=	"sip";
	public static final String 	ISDN_PSTN_id	=	"ISDN/PSTN";
	public static final String 	ISDN_PSTN_name	=	"ISDN/PSTN";
	//分辨率
	public static final String 	AUTO_id	=	"AUTO";
	public static final String 	AUTO_name	=	"AUTO";
	public static final String 	CIF_id	=	"CIF";
	public static final String 	CIF_name	=	"CIF";
	public static final String 	SD_id	=	"SD";
	public static final String 	SD_name	=	"SD";
	public static final String 	HD720_id	=	"HD720";
	public static final String 	HD720_name	=	"HD720";
	public static final String 	HD1080_id	=	"HD1080";
	public static final String 	HD1080_name	=	"HD1080";
	//别名类型
	public static final String 	NONE_id	=	"NONE";
	public static final String 	NONE_name	=	"NONE";
	public static final String 	h323ID_id	=	"h.323ID";
	public static final String 	h323ID_name	=	"h.323ID";
	public static final String 	E164_id	=	"E164";
	public static final String 	E164_name	=	"E164";
	public static final String 	EmailID_id	=	"EmailID";
	public static final String 	EmailID_name	=	"EmailID";
	public static final String 	ParticipantUumber_id	=	"ParticipantUumber";
	public static final String 	ParticipantUumber_name	=	"ParticipantUumber";
	
	//视频协议
	public static final String 	AUTO_videoTreaty_id	=	"AUTO";
	public static final String 	AUTO_videoTreaty_name	=	"AUTO";
	public static final String 	h261_id	=	"h261";
	public static final String 	h261_name	=	"h261";
	public static final String 	h263_id	=	"h263";
	public static final String 	h263_name	=	"h263";
	public static final String 	h264_id	=	"h264";
	public static final String 	h264_name	=	"h264";
	//连接速率
	public static final String 	AUTO_speed_id	=	"automatic";
	public static final String 	AUTO_speed_name	=	"AUTO";
	public static final String 	s384_id	=	"384";
	public static final String 	s384_name	=	"384";
	public static final String 	s512_id	=	"512";
	public static final String 	s512_name	=	"512";
	public static final String 	s768_id	=	"768";
	public static final String 	s768_name	=	"768";
	public static final String 	s1024_id	=	"1024";
	public static final String 	s1024_name	=	"1024";
	public static final String 	s1536_id	=	"1536";
	public static final String 	s1536_name	=	"1536";
	public static final String 	s1920_id	=	"1920";
	public static final String 	s1920_name	=	"1920";
	public static final String 	s2048_id	=	"2048";
	public static final String 	s2048_name	=	"2048";
	public static final String 	s4096_id	=	"4096";
	public static final String 	s4096_name	=	"4096";
	//级联角色
	public static final String 	none_id	=	"none";
	public static final String 	none_name	=	"none";
	public static final String 	master_id	=	"master";
	public static final String 	master_name	=	"master";
	public static final String 	slave_id	=	"slave";
	public static final String 	slave_name	=	"slave";
	//通讯协议/音频协议
	public static final String 	radioTreaty_ip_id	=	"";
	public static final String 	radioTreaty_ip_name	=	"设备IP";
	public static final String 	radioTreaty_E164_id	=	"e164";
	public static final String 	radioTreaty_E164_name	=	"E.164";
	
	public static String[][] getRadioTreaty(){
		String[][] type = new String[2][2];
		type[0][0] = radioTreaty_ip_id+"";
		type[0][1] = radioTreaty_ip_name;
		type[1][0] = radioTreaty_E164_id;
		type[1][1] = radioTreaty_E164_name;
		return type;
	}
	
	public static String[][] getDialingDirection(){
		String[][] type = new String[2][2];
		type[0][0] = dial_out_id;
		type[0][1] = dial_out_name;
		type[1][0] = dial_in_id;
		type[1][1] = dial_in_name;
		return type;
	}
	
	public static String[][] getDialingType(){
		String[][] type = new String[3][2];
		type[0][0] = h323_id;
		type[0][1] = h323_name;
		type[1][0] = sip_id;
		type[1][1] = sip_name;
		type[2][0] = ISDN_PSTN_id;
		type[2][1] = ISDN_PSTN_name;
		return type;
	}
	
	public static String[][] getMaxPesolution(){
		String[][] type = new String[5][2];
		type[0][0] = AUTO_id;
		type[0][1] = AUTO_name;
		type[1][0] = CIF_id;
		type[1][1] = CIF_name;
		type[2][0] = SD_id;
		type[2][1] = SD_name;
		type[3][0] = HD720_id;
		type[3][1] = HD720_name;
		type[4][0] = HD1080_id;
		type[4][1] = HD1080_name;
		return type;
	}
	
	public static String[][] getAliasType(){
		String[][] type = new String[5][2];
		type[0][0] = NONE_id;
		type[0][1] = NONE_name;
		type[1][0] = h323ID_id;
		type[1][1] = h323ID_name;
		type[2][0] = E164_id;
		type[2][1] = E164_name;
		type[3][0] = EmailID_id;
		type[3][1] = EmailID_name;
		type[4][0] = ParticipantUumber_id;
		type[4][1] = ParticipantUumber_name;
		return type;
	}
	
	public static String[][] getVideoTreaty(){
		String[][] type = new String[4][2];
		type[0][0] = AUTO_videoTreaty_id;
		type[0][1] = AUTO_videoTreaty_name;
		type[1][0] = h261_id;
		type[1][1] = h261_name;
		type[2][0] = h263_id;
		type[2][1] = h263_name;
		type[3][0] = h264_id;
		type[3][1] = h264_name;
		return type;
	}
	
	public static String[][] getSpeed(){
		String[][] type = new String[9][2];
		type[0][0] = AUTO_speed_id;
		type[0][1] = AUTO_speed_name;
		type[1][0] = s384_id;
		type[1][1] = s384_name;
		type[2][0] = s512_id;
		type[2][1] = s512_name;
		type[3][0] = s768_id;
		type[3][1] = s768_name;
		type[4][0] = s1024_id;
		type[4][1] = s1024_name;
		type[5][0] = s1536_id;
		type[5][1] = s1536_name;
		type[6][0] = s1920_id;
		type[6][1] = s1920_name;
		type[7][0] = s2048_id;
		type[7][1] = s2048_name;
		type[8][0] = s4096_id;
		type[8][1] = s4096_name;
		return type;
	}
	
	public static String[][] getCascadeRole(){
		String[][] type = new String[3][2];
		type[0][0] = none_id;
		type[0][1] = none_name;
		type[1][0] = master_id;
		type[1][1] = master_name;
		type[2][0] = slave_id;
		type[2][1] = slave_name;
		return type;
	}
}
