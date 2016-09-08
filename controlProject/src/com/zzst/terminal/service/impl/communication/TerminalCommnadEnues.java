package com.zzst.terminal.service.impl.communication;


/**
 *@Description
 *@date 2011-3-21下午07:10:05
 *@author ryan
 */
public class TerminalCommnadEnues {
	
	//group 300终端的图像地址
	public final static String 	near_image_url="http://##1/near_image_1.jpg";
	public final static String 	far_image_url="http://##1/far_image_1.jpg";
	
	public final static  String		WEB_URL_NEAR_IMAGE	  			 	="http://##1/web2/docroot/date/near_image_1.jpg";	//呼终端
	public final static  String		WEB_URL_FAR_IMAGE	  			 	="http://##1/web2/docroot/date/near_image_1.jpg";	//呼终端

	 
	public final static  String		COMMAND_CALL_AUTO		  			 	="dial auto speed dialstr";		//呼终端
	
	public final static  String		COMMAND_CALL_IP		  			 	="dial manual speed dialstr ip";		//呼终端
	public final static  String 	COMMAND_CLOSE_TERMINAL			 	="hangup video";						//挂断终端
	public final static  String 	COMMAND_ANSWER_TERMINAL 			="answer video";						//应答终端
	
	public final static  String 	COMMAND_CALL_PHONE	  			 	="dial phone \"phoneNumber\"";			//呼电话
	public final static  String 	COMMAND_HANGUP_PHONE				="hangup phone";						//挂断电话
	public final static  String 	COMMAND_ANSWER_PHONE				="answer phone";						//应答电话
	
	public final static  String 	COMMAND_HANGUP_ALL 					="hangup all";							//挂断终端所有通信
	
	public final static  String 	COMMAND_MUTE_NEAR_OFF				="mute near off";						//终端取消静音
	public final static  String 	COMMAND_MUTE_NEAR_ON				="mute near on";						//终端静音
	public final static  String[] 	COMMAND_MUTE_NEAR_STATUS			={"mute near get","mute near"};						//终端当前声音状态
	public final static  String[] 	COMMAND_MUTE_FAR_STATUS				={"mute far get","mute near"};						//终端当前声音状态
	
	public final static  String 	CONNECTION_STATUS					="display call";						//终端呼叫状态
	public final static  String[] 	CALL_INFO_COMMAND1					={"advnetstats","all:"};							//终端通话信息1
	public final static  String[] 	CALL_INFO_COMMAND2					={"callinfo all","all:"};						//终端通话信息2
	public final static  String[] 	CALL_INFO_COMMAND3					={"netstats","all:"};							//终端通话信息3
	
	public final static  String 	COMMAND_CAMERA_NEAR				="camera near ##1";					//选择输入摄像头
	public final static  String 	COMMAND_CAMERA_FAR				="camera far ##1";					
	public final static  String 	COMMAND_CAMERA_NEAR_LEFT			="camera near left";					//近端摄像头向左跳动
	public final static  String 	COMMAND_CAMERA_NEAR_RIGHT			="camera near right";					//近端摄像头向右跳动
	public final static  String 	COMMAND_CAMERA_NEAR_UP				="camera near up";						//近端摄像头向上跳动
	public final static  String 	COMMAND_CAMERA_NEAR_DOWN			="camera near down";					//近端摄像头向下跳动
	public final static  String 	COMMAND_CAMERA_NEAR_NEAR			="camera near zoom-";					//近端摄像头向近跳动
	public final static  String 	COMMAND_CAMERA_NEAR_FAR				="camera near zoom+";					//近端摄像头向远跳动

	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_LEFT		="camera near move left";				//近端摄像头一直左移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_RIGHT		="camera near move right";				//近端摄像头一直右移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_UP			="camera near move up";					//近端摄像头一直上移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_DOWN		="camera near move down";				//近端摄像头一直下移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_NEAR		="camera near move zoom-";				//近端摄像头一直近移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_FAR		="camera near move zoom+";				//近端摄像头一直远移动
	public final static  String 	COMMAND_CAMERA_NEAR_MOVE_STOP		="camera near move stop";				//近端摄像头停止移动
	public final static  String 	COMMAND_CAMERA_NEAR_POSITION_GET	="button camera near get ##1";			//调用近端摄像头预置位
	public final static  String 	COMMAND_CAMERA_NEAR_POSITION_SET	="button camera near set ##1";			//存储近端摄像头预置位
	public final static  String 	COMMAND_CAMERA_NEAR_PRESET_GET		="preset near go ##1";					//调用近端摄像头预置位
	public final static  String 	COMMAND_CAMERA_NEAR_PRESET_SET		="preset near set ##1";					//存储近端摄像头预置位
	public final static  String 	COMMAND_CAMERA_SELECT_NUMBER		="button camera ##1 center select";		//选择终端输入摄像头
	
	public final static  String 	COMMAND_CONFIG_PRESENTATION_SET		="configpresentation ##1 ##2";			//设置当前终端监视器显示内容##1为monitor1/monitor2##2为<near/far/content/near-or-far/content-or-far/content-or-near/all/none>
	public final static  String 	COMMAND_CONFIG_PRESENTATION_GET		="configpresentation ##1 get";			//提取当前终端监视器显示内容##1为monitor1/monitor2
	public final static  String 	COMMAND_CONFIG_DISPLAY_SET			="configdisplay monitor##1 ##2 ##3";	//设置当前终端输出格式##1为monitor1/monitor2##2为<vag 4:3/dvi 4:3/component 16:9> ##3为<720p/1080i/1080p>或<50hz720p/60hz720p/50hz1080i/60hz1080i/50hz1080p/60hz1080p>
	public final static  String 	COMMAND_CONFIG_DISLAY_GET			="configdisplay monitor##1 get";		//提取当前终端输出格式
	
	public final static  String 	COMMAND_GRAPHICS					="button graphics";						//内容按钮
	public final static  String 	COMMAND_GRAPHICS_PLAY				="vcbutton play";						//发送双流
	public final static  String 	COMMAND_GRAPHICS_STOP				="vcbutton stop";						//结束双流
	
	public final static  String 	COMMAND_SOUND_PROMPT_SET			="alertusertone ##1";					//设置提示声音
	public final static  String 	COMMAND_SOUND_CALL_SET				="alertvideotone ##1";					//设置呼叫铃音
	public final static  String 	COMMAND_SOUND_PROMPT_GET			="alertusertone get";					//提取提示声音
	public final static  String 	COMMAND_SOUND_CALL_GET				="alertvideotone get";					//提取呼叫铃音

	public final static  String[] 	COMMAND_SOUND_AUDIOMETER_OFF		={"audiometer off","audiometer off"};						//结束检测声音
	public final static  String[] 	COMMAND_SOUND_AUDIOMETER_GET		={"audiometer ##1","audiometer ##1 level peak:"};						//检测声音

	public final static  String 	COMMAND_SEND_CONTENT				="showpopup \"##1\"";					//远端站点右
	
	
	
	//终端遥控器=================开始
	public static final	String		 BUTTON_PIP_CONTENT="button pip";	 //画中画	 
	public static final	String		 BUTTON_CAMERA_CONTENT="button camera";	 	 
	public static final	String		 BUTTON_GRAPHICS_CONTENT="button graphics";	 	 
	//public static final	String		 BUTTON_CALL_CONTENT="button call";	  
	public static final	String		 BUTTON_HANGUP_CONTENT="button callhangup";	 	 
	public static final	String		 BUTTON_NEAR_CONTENT="button near";	  
	public static final	String		 BUTTON_FAR_CONTENT="button far";	 	 
	public static final	String		 BUTTON_VOLUME_UP_CONTENT="button volume+";	 	 
	public static final	String		 BUTTON_VOLUME_DOWN_CONTENT="button volume-"; 		 
	public static final	String		 BUTTON_LEFT_CONTENT="button left";	 	 
	public static final	String		 BUTTON_RIGHT_CONTENT="button right";	 	 
	public static final	String		 BUTTON_UP_CONTENT="button up"; 	 
	public static final	String		 BUTTON_DOWN_CONTENT="button down"; 		 
	public static final	String		 BUTTON_SELECT_CONTENT="button select";	 	 
	public static final	String		 BUTTON_BACK_CONTENT="button back";	 	 
	public static final	String		 BUTTON_HOME_CONTENT="button home";	 	 
	public static final	String		 BUTTON_KEYBOARD_CONTENT="button keyboard"; 		 
	public static final	String		 BUTTON_DIRECTORY_CONTENT="button directory";	//目录 	 
	public static final	String		 BUTTON_DELETE_CONTENT="button delete";	 	 
	public static final	String		 BUTTON_INFO_CONTENT="button info"; 	//信息 
	public static final	String		 BUTTON_HELP_CONTENT="button help"; 	//帮助 
	public static final	String		 BUTTON_MUTE_CONTENT="button mute"; 	 
	public static final	String		 BUTTON_PERIOD_CONTENT="button period";	 	 //拨打电话页面
	public static final	String		 BUTTON_NUM_CONTENT="button ##1";	 	 
//	public static final	String		 BUTTON_NUM_2_CONTENT="button 2";	 	 
//	public static final	String		 BUTTON_NUM_3_CONTENT="button 3";	  
//	public static final	String		 BUTTON_NUM_4_CONTENT="button 4";	  
//	public static final	String		 BUTTON_NUM_5_CONTENT="button 5";	 	 
//	public static final	String		 BUTTON_NUM_6_CONTENT="button 6";	 	 
//	public static final	String		 BUTTON_NUM_7_CONTENT="button 7";	 	 
//	public static final	String		 BUTTON_NUM_8_CONTENT="button 8";	 	 
//	public static final	String		 BUTTON_NUM_9_CONTENT="button 9";	 	 
//	public static final	String		 BUTTON_NUM_XIN_CONTENT="button *";	 	 
//	public static final	String		 BUTTON_NUM_0_CONTENT="button 0";	 	 
//	public static final	String		 BUTTON_NUM_JIN_CONTENT="button #";	 	 
	public static final	String		 MONITOR1_NEAR_CONTENT="configpresentation monitor1 near";	 	 
	public static final	String		 MONITOR1_FAR_CONTENT ="configpresentation monitor1 far";	 	 
	//终端遥控器=================结束
	
	//2012-04-10 add  by ryan====================begin
	public static final	String[]		 WHOAMI ={"whoami","Here is what I know about myself:"};//询问当前终端的信息
	//2012-04-10 add  by ryan====================end

	//2012-05-19 add  by ryan====================begin
	public final static  String[] 	CAMERA_NEAR_POSITION_GET		={"camera near getposition","camera near position "};//提取摄像头坐标
	public final static  String[] 	CAMERA_NEAR_POSITION_SET		={"camera near setposition ##1 ##2 ##3","camera near setposition "};//设置摄像头坐标
	////2012-04-10 add  by ryan====================end
	
	//2013-05-26 add  by ryan====================begin
	public static final	String[]		 testToneOn ={"generatetone on","generatetone on"};//开启测试音
	public static final	String[]		 testToneOff ={"generatetone off","generatetone off"};//关闭测试音
	//2012-05-26 add  by ryan====================end
	//2014-11-03 回音消除：yes设置回音消除，no取消回音消除
	public static final String echocanceller_yes="echocanceller yes";
	public static final String echocanceller_no="echocanceller no";
	//2014-11-03 键盘降噪：yes设置键盘降噪，no取消键盘降噪
	public static final String enablekeyboardnoisereduction_yes="enablekeyboardnoisereduction yes";
	public static final String enablekeyboardnoisereduction_no="enablekeyboardnoisereduction no";
}
