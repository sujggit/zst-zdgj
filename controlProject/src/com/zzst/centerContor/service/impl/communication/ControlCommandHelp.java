package com.zzst.centerContor.service.impl.communication;


/**
 *@Description
 *@date 2011-12-20下午03:21:22
 *@author ryan
 */
public class ControlCommandHelp {
	
	public final static String			EQUIPMENT_STATUS		="EQUIPMENT.##1:STATUS";//询问中控设备是否可用
	public final static String[]		EQUIPMENT_STATUS_PLA	={"PLA.##1:STATUS>TRUE","PLA.##1:STATUS>FALSE"};		//返回值--等离子是否可用
	public final static String[]		EQUIPMENT_STATUS_PROJ	={"PROJ.##1:STATUS>TRUE","PROJ.##1:STATUS>FALSE"};		//返回值--投影机是否可用
	public final static String[]		EQUIPMENT_STATUS_POWER	={"POWER.##1:STATUS>TRUE","POWER.##1:STATUS>FALSE"};	//返回值--系统电源是否可用
	public final static String[]		EQUIPMENT_STATUS_MATRIX	={"MATRIX.##1:STATUS>TRUE","MATRIX.##1:STATUS>FALSE"};	//返回值--矩阵是否可用
	public final static String[]		EQUIPMENT_STATUS_CAMERA	={"CAMERA.##1:STATUS>TRUE","CAMERA.##1:STATUS>FALSE"};	//返回值--摄像头是否可用
	//其它设备都按照一样的格式处理XX设备.##1:STATUS>TRUE/FALSE
	
	
	public final static String[]		ROOM_MODEL_SET			={"ROOM.##1:MODEL>##2",""};//调用会议室组合键
	public final static String[]		ROOM_MODEL_GET			={"ROOM.##1:MODEL>STATUS","ROOM.##1:MODEL>STATUS>##2"};//查询当前调用的会议室组合键
	
	public final static String[]		PROJ_POWER_ON			={"PROJ.##1:POWER>ON","PROJ.##1:STATUS>ON"};
	public final static String[]		PROJ_POWER_OFF			={"PROJ.##1:POWER>OFF","PROJ.##1:STATUS>OFF"};
	public final static String[]		PROJ_DISPLAY_TYPE		={"PROJ.##1:DISPLAY>##2","PROJ.##1:DISPLAY>##2"};
	public final static String[]		PROJ_RUNTIME_PROJ		={"PROJ.##1:RUNTIME>PROJ",""};
	public final static String[]		PROJ_RUNTIME_LAMP		={"PROJ.##1:RUNTIME>LAMP",""};	
	public final static String[]		PROJ_STATUS				={"PROJ.##1:STATUS","PROJ.##1:STATUS>ON","PROJ.##1:STATUS>OFF"};
	public final static String[]		PROJ_STATUS_DISPLAY		={"PROJ.##1:STATUS>DISPLAY","PROJ.##1:DISPLAY>##2"};
	
	public final static String[]		CAMERA_STOP			={"CAMERA.##1:STOP","CAMERA.##1:STATUS>STOP"};
	public final static String[]		CAMERA_LEFT			={"CAMERA.##1:LEFT","CAMERA.##1:STATUS>LEFT"};			
	public final static String[]		CAMERA_RIGHT		={"CAMERA.##1:RIGHT","CAMERA.##1:STATUS>RIGHT"};			
	public final static String[]		CAMERA_UP			={"CAMERA.##1:UP","CAMERA.##1:STATUS>UP"};			
	public final static String[]		CAMERA_DOWN			={"CAMERA.##1:DOWN","CAMERA.##1:STATUS>DOWN"};			
	public final static String[]		CAMERA_STORE		={"CAMERA.##1:STORE##2","CAMERA.##1:STATUS>STORE##2"};			
	public final static String[]		CAMERA_RECALL		={"CAMERA.##1:RECALL##2","CAMERA.##1:STATUS>RECALL##2"};
	public final static String[]		CAMERA_SETSPEED		={"CAMERA.##1:SETSPEED>##2","CAMERA.##1:CAMSPEED##2"};
	public final static String[]		CAMERA_GETSPEED		={"CAMERA.##1:GETSPEED","CAMERA.##1:CAMSPEED##2"};//返回值CAMERA.##1:GETSPEED>CAMSPEED##2
	public final static String[]		CAMERA_ZOOM_ADD		={"CAMERA.##1:WIDE","CAMERA.##1:STATUS>WIDE"};
	public final static String[]		CAMERA_ZOOM_SUBTRACT		={"CAMERA.##1:TELE","CAMERA.##1:STATUS>TELE"};
	public final static String[]		CAMERA_INFO_BACKLIGHT		={"CAMERA.##1:INFO>BACKLIGHT>##2",""};//背光
	public final static String[]		CAMERA_INFO_BACKLIGHT_STATUS		={"CAMERA.##1:INFO>BACKLIGHT>STATUS","CAMERA.##1:INFO>BACKLIGHT>"};//背光BACKLIGHT>后为true或者false
	public final static String[]		CAMERA_INFO_EXPOSUREMANUAL		={"CAMERA.##1:INFO>EXPOSUREMANUAL>##2",""};//曝光
	public final static String[]		CAMERA_INFO_EXPOSUREMANUAL_STATUS		={"CAMERA.##1:INFO>EXPOSUREMANUAL>STATUS","CAMERA.##1:INFO>EXPOSUREMANUAL>"};//询问曝光状态.返回值举例：CAMERA.##1>INFO>EXPOSUREMANUAL>false:2:1/10000:3.4是否手动;增益;快门;光圈
	public final static String[]		CAMERA_INFO_ExposureManuaIris		={"CAMERA.##1:INFO>IRIS>##2",""};//光圈
	public final static String[]		CAMERA_INFO_ExposureManuaSpeed		={"CAMERA.##1:INFO>SPEED>##2",""};//快门
	public final static String[]		CAMERA_INFO_ExposureManuaGain		={"CAMERA.##1:INFO>gain>##2",""};//增益
	public final static String[]		CAMERA_INFO_WhiteBalanceManual		={"CAMERA.##1:INFO>WHITEBALANCEMANUAL>##2",""};//白平衡
	public final static String[]		CAMERA_INFO_WhiteBalanceManual_STATUS		={"CAMERA.##1:INFO>WHITEBALANCEMANUAL>STATUS","CAMERA.##1:INFO>WHITEBALANCEMANUAL>"};//询问白平衡状态返回值举例：CAMERA.##1>INFO>WHITEBALANCEMANUAL>STATUS>false:2:4是否手动;r;b
	public final static String[]		CAMERA_INFO_WhiteBalanceManual_R		={"CAMERA.##1:INFO>MANUALR>##2",""};//白平衡-红
	public final static String[]		CAMERA_INFO_WhiteBalanceManual_B		={"CAMERA.##1:INFO>MANUALB>##2",""};//白平衡-蓝
	
	public final static String[]		CAMERA_AUTO_TRACK_ON		={"CAMERA.##1:ON","CAMERA.##1:STATUS>ON"};//自动跟踪
	public final static String[]		CAMERA_AUTO_TRACK_OFF		={"CAMERA.##1:OFF","CAMERA.##1:STATUS>OFF"};//自动跟踪
	public final static String[]		CAMERA_AUTO_TRACK_STATUS		={"CAMERA.##1:STATUS","CAMERA.##1:STATUS>OFF","CAMERA##1:STATUS>ON"};//自动跟踪
	
	public final static String[]		PLA_ON		={"PLA.##1:ON","PLA.##1:STATUS>ON"};//等离子
	public final static String[]		PLA_OFF		={"PLA.##1:OFF","PLA.##1:STATUS>OFF"};//等离子
	public final static String[]		PLA_STATUS		={"PLA.##1:STATUS","PLA.##1:STATUS>ON","PLA.##1:STATUS>OFF"};//提取等离子开关状态
	public final static String[]		PLA_SWITCH		={"PLA.##1:SWITCH>##2","PLA.##1:SWITCH>##2"};//设置等离子显示模式
	public final static String[]		PLA_SWITCH_STATUS		={"PLA.##1:SWITCHSTATUS>##2","PLA.##1:SWITCHSTATUS>##2"};//提取等离子显示模式
	
	public final static String[]		UPDOWN_SCREEN_UP		={"SJP.##1:UP","SJP.##1:STATUS>UP"};//升降屏
	public final static String[]		UPDOWN_SCREEN_DOWN		={"SJP.##1:DOWN","SJP.##1:STATUS>DOWN"};//升降屏
	public final static String[]		UPDOWN_SCREEN_STATUS		={"SJP.##1:STATUS","SJP.##1:STATUS>DOWN","SJP.##1:STATUS>UP"};//升降屏
	
	public final static String[]		LIGHT_ON		={"LIGHT.##1:ON","LIGHT.##1:STATUS>ON"};//灯光开
	public final static String[]		LIGHT_OFF	={"LIGHT.##1:OFF","LIGHT.##1:STATUS>OFF"};//灯光关
	public final static String[]		LIGHT_STATUS	={"LIGHT.##1:STATUS","LIGHT.##1:STATUS>ON","LIGHT.##1:STATUS>OFF"};//灯光关
	
	//MATRIX.1:INFO>SWITCH>1->0,2->0,3->0,4->0,5->0,6->0,7->0,8->0,9->0,10->0,11->0,12->0,13->0,14->0,15->0,16->0,17->13,18->13,19->0,20->0,21->0,22->0,23->0,24->0
	public final static String		MATRIX_SWITCH		="MATRIX.##1:VIDEO>##2>##3";			//矩阵切换MATRIX.1:INFO>SWITCH>1->0,2->0,
	public final static String		MATRIX_SWITCH_INFO	="MATRIX.##1:SWITCH>STATUS";			//当前矩阵切换信息MATRIX.1:INFO>SWITCH>1->0,2->0,
	
	public final static String[]		POWER_ON	={"POWER.##1:ON","POWER001=POWER.##1:STATUS>ON"};			//系统电源开
	public final static String[]		POWER_OFF	={"POWER.##1:OFF","POWER002=POWER.##1:STATUS>OFF"};			//系统电源关
	public final static String[]		POWER_STATUS={"POWER.##1:STATUS","POWER003=POWER.##1:STATUS>ON","POWER.##1:STATUS>OFF"};	//系统电源状态
	
	
	public final static String[]		AUDIO_UP	={"AUDIO.##1:UP","AUDIO.##1:VALUE>##2"};				//音频设备- ＋
	public final static String[]		AUDIO_DOWN	={"AUDIO.##1:DOWN","AUDIO.##1:VALUE>##2"};			//音频设备- -
	public final static String[]		AUDIO_ON	={"AUDIO.##1:MUTE>ON","AUDIO.##1:STATUS>MUTEON"};			//音频设备 静音
	public final static String[]		AUDIO_OFF	={"AUDIO.##1:MUTE>OFF","AUDIO.##1:STATUS>MUTEOFF"};			//音频设备非静音
	public final static String[]		AUDIO_STATUS	={"AUDIO.##1:MUTE>STATUS","AUDIO.##1:STATUS>MUTEOFF","AUDIO.##1:STATUS>MUTEON"};	//音频设备非静音
	
	public final static String		AUDIO_SET_VALUES="AUDIO.##1>VALUE>10";	//设置音频设备音量值  不能实现
	public final static String[]		AUDIO_GET_VALUES={"AUDIO.##1>VALUE","AUDIO.##1>VALUE>##2"};	//提取音频设备音量值
//	public final static String		AUDIO_STATUS_ON="AUDIO.##1:MUTE>OFF";	//音频设备非静音
	
	
	public final static String[]		SCREENT_ON				={"SCREENT.##1:ON","SCREENT.##1:STATUS>ON"};			//大屏开
	public final static String[]		SCREENT_OFF				={"SCREENT.##1:OFF","SCREENT.##1:STATUS>OFF"};			//大屏关
	public final static String[]		SCREENT_STATUS			={"SCREENT.##1:STATUS","SCREENT.##1:STATUS>ON","SCREENT.##1:STATUS>OFF"};			//大屏开关状态
	public final static String[]		SCREENT_MODEL_STATUS	={"SCREENT.##1:MODEL>STATUS","SCREENT.##1:STATUS>MODEL##2"};			//询问大屏当前的模式
	
	//modify by yangyi 
	public final static String[]		SCREENT_MODEL_STATUS_INFO	={"SCREENT.##1:MODEL>WALLINFO","SCREENT.##1:MODEL>WALLINFO"};			//询问大屏当前的模式及详细信息,返回值为所有信息
	
//	public final static String[]		SCREENT_SET_MODEL_INFO		={"SCREENT.##1:SETMODEL##2>##3>##4",""};			// 没有实现   设置大屏当前模式下，详细信息。某个窗口显示信号	
	public final static String[]		SCREENT_SET_MODEL		={"SCREENT.##1:MODEL##2","SCREENT.##1:STATUS>MODEL##2"};			//大屏模式 ##2为402-AV
	public final static String[]		SCREENT_MODEL_ALL		={"SCREENT.##1:MODEL>VALUE","MODEL1,MODEL2,MODEL3,NETSIGNAL1,NETSIGNAL2"};			//大屏所有的模式
	public final static String[]		SCREENT_MODEL_SWITCH		={"SCREENT.##1:MODEL##2>MATRIX>##3>##4",""};			//大屏信号切换
	
	//add by yangyi
//	public final static String[]		SCREENT_MODEL_INFO		={"SCREENT.##1:MODEL##2-##3",""};		//大屏信号切换

	public final static String[]		DVD_POWER		={"DVD.##1:POWER",""};			//DVD电源开/关
	public final static String[]		DVD_OPCL		={"DVD.##1:OPCL",""};			//DVD开/关仓
	public final static String[]		DVD_PLAY		={"DVD.##1:PLAY",""};			//DVD播放	
	public final static String[]		DVD_STOP		={"DVD.##1:STOP",""};			//DVD停止
	public final static String[]		DVD_PAUSE		={"DVD.##1:PAUSE",""};			//DVD暂停
	public final static String[]		DVD_NEXT		={"DVD.##1:NEXT",""};			//DVD下一个
	public final static String[]		DVD_PREV		={"DVD.##1:PREV",""};			//DVD上一个
	public final static String[]		DVD_FORWARD		={"DVD.##1:FORWARD",""};			//DVD前进
	public final static String[]		DVD_REVERSE		={"DVD.##1:REVERSE",""};			//DVD后退
	public final static String[]		DVD_REC		={"DVD.##1:REC",""};			//DVD录制
	public final static String[]		DVD_STOP_REC		={"DVD.##1:STOP REC",""};			//DVD录制停止
	public final static String[]		DVD_INPUT		={"DVD.##1:INPUT",""};			//DVD输入选择
	public final static String[]		DVD_TITLE		={"DVD.##1:SUBTITLE",""};			//DVD字幕
	public final static String[]		DVD_DVD		={"DVD.##1:DVD",""};			//DVD
	public final static String[]		DVD_HDD		={"DVD.##1:HDD",""};			//DVD
	public final static String[]		DVD_MENU		={"DVD.##1:MENU",""};			//DVD菜单
	public final static String[]		DVD_MAIN_MENU		={"DVD.##1:MAINMENU",""};			//DVD主菜单
	public final static String[]		DVD_AUDIO		={"DVD.##1:AUDIO",""};			//DVD声道
	public final static String[]		DVD_RETURN		={"DVD.##1:RETURN",""};			//DVD返回
	public final static String[]		DVD_UP		={"DVD.##1:UP",""};			//DVD上
	public final static String[]		DVD_DOWN		={"DVD.##1:DOWN",""};			//DVD下
	public final static String[]		DVD_LEFT		={"DVD.##1:LEFT",""};			//DVD左
	public final static String[]		DVD_RIGHT		={"DVD.##1:RIGHT",""};			//DVD右
	public final static String[]		DVD_ENTER		={"DVD.##1:ENTER",""};			//DVD确认
	public final static String[]		DVD_CHANNEL_ADD		={"DVD.##1:CH+",""};			//DVD频道+
	public final static String[]		DVD_CHANNEL_SUBTRACT		={"DVD.##1:CH-",""};			//DVD频道-
	public final static String[]		DVD_NUM		={"DVD.##1:##2",""};			//DVD数字##2为0-9
	 
	public final static String[]        CURTAIN_STOP = {"CURTAIN.##1:STOP",""};//窗帘-停	
	public final static String[]        CURTAIN_OPEN = {"CURTAIN.##1:OPEN",""};//窗帘-开
	public final static String[]        CURTAIN_CLOSE = {"CURTAIN.##1:CLOSE",""};//窗帘-关
	
	public final static String[]        TV_POWER = {"TV.##1:POWER",""};	
	public final static String[]        TV_MUTE = {"TV.##1:MUTE",""};
	public final static String[]        TV_MUTE_UP = {"TV.##1:MUTE>UP",""};
	public final static String[]        TV_MUTE_DOWN = {"TV.##1:MUTE>DOWN",""};
	public final static String[]        TV_PINDAO_UP = {"TV.##1:PINDAO>UP",""};
	public final static String[]        TV_PINDAO_DOWN = {"TV.##1:PINDAO>DOWN",""};
	public final static String[]        TV_MENU = {"TV.##1:MENU",""};
	public final static String[]        TV_NUMBER = {"TV.##1:NUMBER>##2",""};
	
	public final static String[]        VIDEOM_MODEL = {"VIDEOM.##1:##2",""};//切换模式 	
	public final static String[]        VIDEOM_MODEL_INFO = {"",""}; //切换模式信号
	 
														
														
														
														
														
														
														

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final	String		 COMMAND_PIP_CONTENT="button pip";	 	 
	public static final	String		 COMMAND_CAMERA_CONTENT="button camera";	 	 
	public static final	String		 COMMAND_GRAPHICS_CONTENT="button graphics";	 	 
	public static final	String		 COMMAND_DAILUP_CONTENT="button callhangup";	  
	public static final	String		 COMMAND_HANGUP_CONTENT="button callhangup";	 	 
	public static final	String		 COMMAND_NEAR_CONTENT="button near";	  
	public static final	String		 COMMAND_FAR_CONTENT="button far";	 	 
	public static final	String		 COMMAND_VOLUME_UP_CONTENT="button volume+";	 	 
	public static final	String		 COMMAND_VOLUME_DOWN_CONTENT="button volume-"; 		 
	public static final	String		 COMMAND_LEFT_CONTENT="button left";	 	 
	public static final	String		 COMMAND_RIGHT_CONTENT="button right";	 	 
	public static final	String		 COMMAND_UP_CONTENT="button up"; 	 
	public static final	String		 COMMAND_DOWN_CONTENT="button down"; 		 
	public static final	String		 COMMAND_SELECT_CONTENT="button select";	 	 
	public static final	String		 COMMAND_BACK_CONTENT="button back";	 	 
	public static final	String		 COMMAND_HOME_CONTENT="button home";	 	 
	public static final	String		 COMMAND_KEYBOARD_CONTENT="button keyboard"; 		 
	public static final	String		 COMMAND_DIRECTORY_CONTENT="button directory";	 	 
	public static final	String		 COMMAND_DELETE_CONTENT="button delete";	 	 
	public static final	String		 COMMAND_INFO_CONTENT="button help"; 	 
	public static final	String		 COMMAND_MUTE_CONTENT="button mute"; 	 
	public static final	String		 COMMAND_PERIOD_CONTENT="button period";	 	 
	public static final	String		 COMMAND_NUM_1_CONTENT="button 1";	 	 
	public static final	String		 COMMAND_NUM_2_CONTENT="button 2";	 	 
	public static final	String		 COMMAND_NUM_3_CONTENT="button 3";	  
	public static final	String		 COMMAND_NUM_4_CONTENT="button 4";	  
	public static final	String		 COMMAND_NUM_5_CONTENT="button 5";	 	 
	public static final	String		 COMMAND_NUM_6_CONTENT="button 6";	 	 
	public static final	String		 COMMAND_NUM_7_CONTENT="button 7";	 	 
	public static final	String		 COMMAND_NUM_8_CONTENT="button 8";	 	 
	public static final	String		 COMMAND_NUM_9_CONTENT="button 9";	 	 
	public static final	String		 COMMAND_NUM_XIN_CONTENT="button *";	 	 
	public static final	String		 COMMAND_NUM_0_CONTENT="button 0";	 	 
	public static final	String		 COMMAND_NUM_JIN_CONTENT="button #";	 	 
	public static final	String		 MONITOR1_NEAR_CONTENT="configpresentation monitor1 near";	 	 
	public static final	String		 MONITOR1_FAR_CONTENT ="configpresentation monitor1 far";	 	 

}
