package com.zzst.model.enums;



/**
 *@Description
 *@date 2011-11-29上午09:43:09
 *@author ryan
 */
public class EquipmentEnum {
	
	
	public static final int 	STATUS_INVALID		=	3;		//失效
	public static final int 	STATUS_VALID		=	1;		//有效
	public static final int     STATUS_TODOREPAIRED =   5;      //待修
	public static final int     STATUS_USELESS      =   6;      //已报废处理
	
	//比对卡比对结果显示
	public static final int COMPARISON_GOOD             =   3;
	public static final int COMPARISON_OK             =   2;
	public static final int COMPARISON_BAD             =   1;

	public static final String  COMPARISON_GOOD_NAME            =   "好";
	public static final String  COMPARISON_OK_NAME				=   "中";
	public static final String  COMPARISON_BAD_NAME             =   "差";

	//设备类型
	public static final int 	TYPE_ID_TERMINAL	=	0;		//终端
	public static final int 	TYPE_ID_MCU			=	1;		//mcu
	public static final int 	TYPE_ID_CENTERCONTROL			=	2;		//中控设备
	public static final int 	TYPE_ID_MONITOR			=	3;		//可视同视频监控
	public static final int 	TYPE_ID_ENC			=	4;		//元嘉--告示
	public static final int 	TYPE_ID_QBOX			=	5;		//qbox
	public static final int 	TYPE_ID_MICROPHONE      =6;       //话筒
	public static final int 	TYPE_ID_VIDEOCARD			=	7;//对比卡
	public static final int     TYPE_ID_OTHEREQUIPMENT = 8;//其他设备
	public static final int     TYPE_ID_AUDIO 		= 9;//音频设备
	
	public static final String 	TYPE_NAME_TERMINAL	=	"终端";	
	public static final String 	TYPE_NAME_MCU		=	"MCU";	
	public static final String 	TYPE_NAME_CENTERCONTROL		=	"智能中控";	
	public static final String 	TYPE_NAME_MONITOR		=	"视频监控";	
	public static final String 	TYPE_NAME_ENC		=	"告示";
	public static final String 	TYPE_NAME_QBOX 		=	"QBOX";
	public static final String 	TYPE_NAME_MICROPHONE 		=	"话筒";
	public static final String 	TYPE_NAME_VIDEOCARD 		=	"比对卡";
	public static final String  TYPE_NAME_OTHEREQUIPMENT    =   "其他设备";
	public static final String  TYPE_NAME_AUDIO    =   "音频设备";
	//设备名称
	public static final String 	NAME_ID_TERMINAL	=	"0";	
	public static final String 	NAME_ID_MCU		=	"1";	
	public static final String 	NAME_ID_CENTERCONTROL	=	"2";	
	public static final String 	NAME_ID_MONITOR		=	"3";	
	public static final String 	NAME_ID_ENC		=	"4";	
	public static final String 	NAME_ID_QBOX		=	"5";	
	public static final String 	NAME_ID_MICROPHONE		=	"6";	
	public static final String 	NAME_ID_VIDEOCARD		=	"7";
	
	
	public static final String 	NAME_TERMINAL	=	"宝利通";	
	public static final String 	NAME_MCU		=	"宝利通";	
	public static final String 	NAME_VIDEOCARD		=	"真视通";	
	public static final String 	NAME_CENTERCONTROL	=	"AMX";	
	public static final String 	NAME_MONITOR		=	"可视通";	
	public static final String 	NAME_ENC		=	"告示";
	public static final String 	NAME_QBOX		=	"真视通";
	public static final String  NAME_OTHER      =   "其他设备";
	// add by duting
	public static final String 	NAME_MICROPHONE		=	"话筒";
	
	//设备型号
	public static final int 	MODEL_ID_TERMINAL_6000	=	30;		//终端
	public static final int 	MODEL_ID_TERMINAL_8000	=	31;		//终端
	public static final int 	MODEL_ID_TERMINAL_9000	=	32;		//终端
	public static final int 	MODEL_ID_TERMINAL_7000	=	33;		//终端
	public static final int     MODEL_ID_TERMINAL_4000  =   34;      //终端
	public static final int     MODEL_ID_TERMINAL_SOFT  =   35;      //终端
	public static final int     MODEL_ID_TERMINAL_IPPHONE=  36;      //终端
	
	public static final int 	MODEL_ID_MCU_1000			=	11;		//mcu
	public static final int 	MODEL_ID_MCU_2000			=	12;		//mcu
	public static final int 	MODEL_ID_MCU_2000C			=	13;		//mcu
	public static final int 	MODEL_ID_MCU_4000			=	16;		//mcu
	public static final int 	MODEL_ID_MCU_500c			=	17;		//mcu
	public static final int 	MODEL_ID_MCU_50			=	18;		//mcu
	public static final int 	MODEL_ID_MCU_25			=	19;		//mcu
	
	public static final int 	MODEL_ID_CENTERCONTROL_4100			=	14;		//中控
	public static final int 	MODEL_ID_MONITOR			=	15;		//中控
	public static final int 	MODEL_ID_ENC			=	17;		//告示
	public static final int 	MODEL_ID_QBOX			=	18;		//QBOX
	public static final int 	MODEL_ID_MICROPHONE			=	19;		//话筒
	
	public static final int 	MODEL_ID_AUDIO_C8			=	20;		//音频设备
	public static final int 	MODEL_ID_AUDIO_C16			=	21;		//音频设备
	
	public static final String 	MODEL_NAEM_TERMINAL_6000	=	"HDX6000";		//终端
	public static final String 	MODEL_NAEM_TERMINAL_8000	=	"HDX8000";	//终端
	public static final String 	MODEL_NAEM_TERMINAL_9000	=	"HDX9000";		//终端
	public static final String 	MODEL_NAEM_TERMINAL_7000	=	"HDX7000";		//终端
	public static final String  MODEL_NAEM_TERMINAL_4000    =   "HDX4000";      //终端
	public static final String  MODEL_NAEM_TERMINAL_SOFT    =   "软终端";      //终端
	public static final String  MODEL_NAEM_TERMINAL_IPPHONE =   "IP电话";      //终端
	
	public static final String 	MODEL_NAEM_MCU_1000			=	"1000";		//mcu
	public static final String 	MODEL_NAEM_MCU_2000			=	"2000";		//mcu
	public static final String 	MODEL_NAEM_MCU_2000C		=	"2000C";		//mcu
	public static final String 	MODEL_NAEM_MCU_4000			=	"4000";		//mcu
	public static final String 	MODEL_NAEM_MCU_500C			=	"500C";		//mcu
	public static final String 	MODEL_NAEM_MCU_MGC50			=	"50";		//mcu
	public static final String 	MODEL_NAEM_MCU_MGC25			=	"25";		//mcu
	
	public static final String 	MODEL_NAEM_ENC			=	"100";		//告示
	public static final String 	MODEL_NAEM_QBOX			=	"1000";		//QBOX
	
	public static final String	MODEL_NAME_AUDIO_C8 	=	"C8";	//音频设备
	public static final String	MODEL_NAME_AUDIO_C16 	=	"C16";	//音频设备
	
	public static final String 	MODEL_NAEM_CENTERCONTROL_4100		=	"4100";		//中控
	public static final String 	MODEL_NAEM_MONITOR		=	"xxxx";		//视频监控
	public static final String 	MODEL_NAEM_MICROPHONE		=	"111";		//话筒
	
	public static final String OTHER_EQUIPMENT_MODEL = "45";
	
	
	//通信协议 add by yangyi
	public static final String 	COMMUCONV_IP		=	"";		//通信协议——IP
	public static final String 	COMMUCONV_E164			=	"e164";		//通信协议——E.164
	
	//其他设备 add on 2013-5-7
	public static final String OPTION_VALUE_OTHER = "其他设备";
	public static final String OPTION_TEXT_OTHER = "其他设备";
	
	
	
	/**
	 * 提取通信协议
	 * @return
	 */
	public static String[][] getCommunicationConvention(){
		String[][] s = new String[2][2];
		s[0][0] =   COMMUCONV_IP+"";
		s[0][1] =	"设备IP";
		s[1][0] =	COMMUCONV_E164+"";
		s[1][1] =	"E.164";
		return s;
	}
	
	/**
	 * 提取设备状态
	 * @return
	 */
	public static String[][] getTerminalStatus(){
		String[][] s = new String[3][2];
		s[0][0] =   STATUS_VALID+"";
		s[0][1] =	"正常";
//		s[1][0] =	STATUS_INVALID+"";
//		s[1][1] =	"无效";
		s[1][0] =   STATUS_TODOREPAIRED+"";
		s[1][1] =	"待修";
		s[2][0] =	STATUS_USELESS+"";
		s[2][1] =	"报废";
		
		return s;
	}
	
	/**
	 * 根据设备类型提取设备型号
	 * @param typeID
	 * @return
	 */
	public static String[][] getEquipmentModel(String typeID){
		if(typeID==null||typeID.length()==0) return null;
		
		if(typeID.equalsIgnoreCase(TYPE_ID_MCU+""))
			return getMcuModel();
		else if(typeID.equalsIgnoreCase(TYPE_ID_TERMINAL+""))
			return getTerminalModel();
		else  if(typeID.equalsIgnoreCase(TYPE_ID_CENTERCONTROL+""))
			return getCenterControl();
		else  if(typeID.equalsIgnoreCase(TYPE_ID_MONITOR+""))
			return getMonitor();
		else  if(typeID.equalsIgnoreCase(TYPE_ID_MONITOR+""))
			return getQBoxType();
		else  if(typeID.equalsIgnoreCase(TYPE_ID_MICROPHONE+""))
			return getMicrophone();
		else  if(typeID.equalsIgnoreCase(TYPE_ID_AUDIO+""))
			return getAudio();
		return null;
	}
	
	/**
	 * 设备名称
	 */
	public static String[][] getEquipmentName(){
		String[][] s = new String[8][2];
		s[0][0] =	NAME_ID_TERMINAL+"";
		s[0][1] =	NAME_TERMINAL;
		s[1][0] =	NAME_ID_MCU+"";
		s[1][1] =	NAME_MCU;
		s[2][0] =	NAME_ID_CENTERCONTROL+"";
		s[2][1] =	NAME_CENTERCONTROL;
		s[3][0] =	NAME_ID_MONITOR+"";
		s[3][1] =	NAME_MONITOR;
		s[4][0] =	NAME_ID_ENC+"";
		s[4][1] =	NAME_ENC;
		s[5][0] =	NAME_ID_QBOX+"";
		s[5][1] =	NAME_QBOX;
		s[6][0] =	NAME_ID_MICROPHONE+"";
		s[6][1] =	NAME_MICROPHONE;
		s[7][0] =	NAME_ID_VIDEOCARD+"";
		s[7][1] =	NAME_VIDEOCARD;
		return s;
	}
	
	/**
	 * 设备类别
	 * @return
	 */
	public static String[][] getEquipmentType(){
		String[][] s = new String[7][2];
		s[0][0] =	TYPE_ID_TERMINAL+"";
		s[0][1] =	TYPE_NAME_TERMINAL;
		s[1][0] =	TYPE_ID_MCU+"";
		s[1][1] =	TYPE_NAME_MCU;
		s[2][0] =	TYPE_ID_CENTERCONTROL+"";
		s[2][1] =	TYPE_NAME_CENTERCONTROL;
		s[3][0] =	TYPE_ID_VIDEOCARD+"";
		s[3][1] =	TYPE_NAME_VIDEOCARD;
		s[4][0] =   TYPE_ID_OTHEREQUIPMENT +"";
		s[4][1] =   TYPE_NAME_OTHEREQUIPMENT;
		s[5][0] =	TYPE_ID_ENC+"";
		s[5][1]	=	TYPE_NAME_ENC;
		s[6][0] =	TYPE_ID_AUDIO+"";
		s[6][1]	=	TYPE_NAME_AUDIO;
		//s[3][0] =	TYPE_ID_MONITOR+"";
		//s[3][1] =	TYPE_NAME_MONITOR;
		//s[4][0] =	TYPE_ID_ENC+"";
		//s[4][1] =	TYPE_NAME_ENC;
		//s[5][0] =	TYPE_ID_QBOX+"";
		//s[5][1] =	TYPE_NAME_QBOX;
		//s[6][0] =	TYPE_ID_MICROPHONE+"";
		//s[6][1] =	TYPE_NAME_MICROPHONE;
		
		return s;
	}
	
	/**
	 * 数据字典模块使用
	 * 提取所有设备类别
	 * @return
	 */
//	public static String[][] getEquipmentType1(){
//		String[][] s = new String[6][2];
//		s[0][0] =	TYPE_ID_TERMINAL+"";
//		s[0][1] =	TYPE_NAME_TERMINAL;
//		s[1][0] =	TYPE_ID_MCU+"";
//		s[1][1] =	TYPE_NAME_MCU;
//		s[2][0] =	TYPE_ID_CENTERCONTROL+"";
//		s[2][1] =	TYPE_NAME_CENTERCONTROL;
//		s[3][0] =	TYPE_ID_MONITOR+"";
//		s[3][1] =	TYPE_NAME_MONITOR;
//		s[4][0] =	TYPE_ID_ENC+"";
//		s[4][1] =	TYPE_NAME_ENC;
//		s[5][0] =	TYPE_ID_QBOX+"";
//		s[5][1] =	TYPE_NAME_QBOX;
//		
//		return s;
//	}
	
	/**
	 * 提取终端型号
	 * @return
	 */
	public static String[][] getTerminalModel(){
		String[][] s = new String[7][2];
		s[0][0] =	MODEL_ID_TERMINAL_6000+"";
		s[0][1] =	MODEL_NAEM_TERMINAL_6000;
		s[1][0] =	MODEL_ID_TERMINAL_7000+"";
		s[1][1] =	MODEL_NAEM_TERMINAL_7000;
		s[2][0] =	MODEL_ID_TERMINAL_8000+"";
		s[2][1] =	MODEL_NAEM_TERMINAL_8000;
		s[3][0] =	MODEL_ID_TERMINAL_9000+"";
		s[3][1] =	MODEL_NAEM_TERMINAL_9000;
		s[4][0] =   MODEL_ID_TERMINAL_4000+"";
		s[4][1] =   MODEL_NAEM_TERMINAL_4000;
		s[5][0] =   MODEL_ID_TERMINAL_SOFT+"";
		s[5][1] =   MODEL_NAEM_TERMINAL_SOFT;
		s[6][0] =   MODEL_ID_TERMINAL_IPPHONE+"";
		s[6][1] =   MODEL_NAEM_TERMINAL_IPPHONE;
		return s;
	}
	
	/**
	 * 提取mcu型号
	 * @return
	 */
	public static String[][] getMcuModel(){
		String[][] s = new String[7][2];
		s[0][0] =	MODEL_ID_MCU_25+"";
		s[0][1] =	MODEL_NAEM_MCU_MGC25;
		s[1][0] =	MODEL_ID_MCU_50+"";
		s[1][1] =	MODEL_NAEM_MCU_MGC50;
		s[2][0] =	MODEL_ID_MCU_500c+"";
		s[2][1] =	MODEL_NAEM_MCU_500C;
		s[3][0] =	MODEL_ID_MCU_1000+"";
		s[3][1] =	MODEL_NAEM_MCU_1000;
		s[4][0] =	MODEL_ID_MCU_2000+"";
		s[4][1] =	MODEL_NAEM_MCU_2000;
		s[5][0] =	MODEL_ID_MCU_2000C+"";
		s[5][1] =	MODEL_NAEM_MCU_2000C;
		s[6][0] =	MODEL_ID_MCU_4000+"";
		s[6][1] =	MODEL_NAEM_MCU_4000;
		return s;
	}

	/**
	 * 提取中控型号
	 * @return
	 */
	public static String[][] getCenterControl(){
		String[][] s = new String[1][2];
		s[0][0] =	MODEL_ID_CENTERCONTROL_4100+"";
		s[0][1] =	MODEL_NAEM_CENTERCONTROL_4100;
		return s;
	}
	/**
	 * 提取视频监控型号
	 * @return
	 */
	public static String[][] getMonitor(){
		String[][] s = new String[1][2];
		s[0][0] =	MODEL_ID_MONITOR+"";
		s[0][1] =	MODEL_NAEM_MONITOR;
		return s;
	}
	//equipment_Centercontrol_Model
	
	/**
	 * 提取告示型号
	 * @return
	 */
	public static String[][] getEncType(){
		String[][] s = new String[1][2];
		s[0][0] =	MODEL_ID_ENC+"";
		s[0][1] =	MODEL_NAEM_ENC;
		return s;
	}
	
	/**
	 * 提取音频型号
	 * @return
	 */
	public static String[][] getAudio() {
		String[][] s = new String[2][2];
		s[0][0] =	MODEL_ID_AUDIO_C8+"";
		s[0][1] =	MODEL_NAME_AUDIO_C8;
		s[1][0] =	MODEL_ID_AUDIO_C16+"";
		s[1][1] =	MODEL_NAME_AUDIO_C16;
		return s;
	}
	
	/**
	 * 提取QBOX型号
	 * @return
	 */
	public static String[][] getQBoxType(){
		String[][] s = new String[1][2];
		s[0][0] =	MODEL_ID_QBOX+"";
		s[0][1] =	MODEL_NAEM_QBOX;
		return s;
	}
	// add by duting
	/**
	 * 提取话筒型号
	 * @return
	 */
	public static String[][] getMicrophone(){
		String[][] s = new String[1][2];
		s[0][0] =	MODEL_ID_MICROPHONE+"";
		s[0][1] =	MODEL_NAEM_MICROPHONE;
		return s;
	}
	
	/**
	 * 提取其他设备名称
	 * @return
	 */
	public static String[][] getOtherType(){
		String[][] s = new String[1][2];
		s[0][0] =  OPTION_VALUE_OTHER;
		s[0][1] =  OPTION_TEXT_OTHER;
	    			
	    return s;
	}
	
	/**
	 * 提取其他设备型号
	 * @return
	 */
	public static String[][] getOtherModel(){
		String[][] s = new String[1][2];
		s[0][0] =  OTHER_EQUIPMENT_MODEL+"";
		s[0][1] =  "其他型号";
	    			
	    return s;
	}
	
}
