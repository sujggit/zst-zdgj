package com.zzst.model.enums;


/**
 *@Description	基础信息--枚举
 *@date 2012-6-15上午10:42:28
 *@author ryan
 */
public class BaseInfoEnum {
	
	public static final String 	TYPE_SYS	=	"";
	
	public static final String 	TYPE_KST_DOMAIN_GUID	=	"kst_guid";
	public static final String 	TYPE_KST_DOMAIN_GUID_VALUE = "可视通省级分公司";
	
	public static final String 	TYPE_KST_SERVER_IP	=	"kst_server_ip";
	public static final String 	TYPE_KST_SERVER_IP_VALUE = "可视通服务器IP";
	
	public static final String 	TYPE_FIXEDTIME	=	"fixedTimeControl";//定时开关设备
	public static final String 	TYPE_FIXEDTIME_VALUE = "定时开关";
	
	public static final String 	TYPE_BASEINFO	=	"base_info";//配置
	public static final String 	TYPE_BASEINFO_VALUE = "基础配置";
	
	public static final String 	TYPE_BASEINFO_MCU	=	"base_info_MCU";//配置MCU模板
	public static final String 	TYPE_BASEINFO_MCU_VALUE = "MCU模板配置";
	
	public static final String 	TYPE_BASEINFO_EMAIL	=	"base_info_email";//配置邮件信息类型
	public static final String 	TYPE_BASEINFO_EMAIL_VALUE = "邮件配置";
	
	public static final String 	TYPE_BASEINFO_DICTIONARY	=	"base_info_dictionary";//数据字典
	public static final String 	TYPE_BASEINFO_DICTIONARY_VALUE = "数据配置";//
	
	public static final String 	TYPE_BASEINFO_LEVLEL	=	"base_info_level";//分级分权
	public static final String 	TYPE_BASEINFO_LEVLEL_VALUE = "分级配置";//
	
//	数据字典部分===================================开始
	public static final String  DICTIONARY_EQUIPMENT_TYPE = "0";//设备类型
	public static final String  DICTIONARY_MEETING_STATUS = "1";//会议状态
	public static final String  DICTIONARY_MEEITNG_TYPE = "2";//会议类型
	public static final String  DICTIONARY_LOG_TYPE = "3";//日志类型
	public static final String  DICTIONARY_MEEITNGROOM_TYPE = "4";//会议室类型
	public static final String  DICTIONARY_MEETINGCONTROL_MENU = "5";//会议室类型
	public static final String	DICTIONARY_MEETINGSERVICE_TYPE	=	"6";//会议服务类型
//	数据字典===================================结束
	
//邮件部分===================================开始
	//邮件格式基本内容
	//邮件内容类型
	public static final String  EMAIL_ISEFFECT_TRUE = "1";//邮件有效
	public static final String  EMAIL_ISEFFECT_FALSE = "0";//邮件无效
	
	public static final String  EMAIL_ISEFFECT = "isEffect";
	public static final String  EMAIL_ADDRESS = "emailAddress";
	public static final String  EMAIL_SMTP = "smtp";
	public static final String  EMAIL_SMTP_PORT = "smtpPort";
	public static final String  EMAIL_USERNAME = "userName";
	public static final String  EMAIL_PASSWORD = "passWord";
	public static final String  EMAIL_FORMAT  =  "format";//$1会议，将于$2在$3会议室召开，请相关人士准时参加！
	
	public static final String  IF_CALLIN_TRUE = "1";//允许终端主动呼入
	public static final String  IF_CALLIN_FALSE = "0";//不允许终端主动呼入
	
	public static final String  IF_OPENLOG_TRUE  = "1";//开启系统日志
	public static final String  IF_OPENLOG_FALSE = "0";//关闭系统日志
	public static final String	IF_OPENLOG		 = "if_openLog";//infovalue

//邮件部分===================================结束
	
	public static final String  NOTICE_CONTENT = "base_info_notice";
	//获取基础配置类型 	add by yangyi
	public static String[][] getBaseInfoType(){
		String[][] type = new String[4][2];
		type[0][0] = TYPE_BASEINFO_EMAIL;
		type[0][1] = TYPE_BASEINFO_EMAIL_VALUE;
		type[1][0] = TYPE_BASEINFO_DICTIONARY;
		type[1][1] = TYPE_BASEINFO_DICTIONARY_VALUE;
		type[2][0] = TYPE_BASEINFO;
		type[2][1] = TYPE_BASEINFO_VALUE;
		type[3][0] = TYPE_BASEINFO_MCU;
		type[3][1] = TYPE_BASEINFO_MCU_VALUE;
		
//		type[0][0] = TYPE_KST_DOMAIN_GUID;
//		type[0][1] = TYPE_KST_DOMAIN_GUID_VALUE;
//		type[1][0] = TYPE_BASEINFO_DICTIONARY;
//		type[1][1] = TYPE_BASEINFO_DICTIONARY_VALUE;
//		type[2][0] = TYPE_FIXEDTIME;
//		type[2][1] = TYPE_FIXEDTIME_VALUE;
//		type[3][0] = TYPE_BASEINFO;
//		type[3][1] = TYPE_BASEINFO_VALUE;
//		type[4][0] = TYPE_BASEINFO_MCU;
//		type[4][1] = TYPE_BASEINFO_MCU_VALUE;
//		type[5][0] = TYPE_BASEINFO_EMAIL;
//		type[5][1] = TYPE_BASEINFO_EMAIL_VALUE;
//		type[6][0] = TYPE_KST_SERVER_IP;
//		type[6][1] = TYPE_KST_SERVER_IP_VALUE;
		return type;
	}
	
}
