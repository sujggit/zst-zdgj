package com.zzst.mcu.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.dom4j.Document;

import com.zzst.mcu.service.McuObject;
import com.zzst.mcu.service.impl.vo.ControlLoginVO;
import com.zzst.mcu.service.impl.vo.IDEnum;
import com.zzst.mcu.service.impl.vo.MeetingInfoVO;
import com.zzst.mcu.service.impl.vo.MeetingRoomVO;
import com.zzst.mcu.service.impl.vo.TerminalVO;
import com.zzst.util.tools.XMLProcessor;

//import java.sql.Timestamp;
//import java.util.ArrayList;
//
//import org.dom4j.Document;
//
//import com.zzst.mcu.service.McuObject;
//import com.zzst.mcu.service.impl.vo.ControlLoginVO;
//import com.zzst.mcu.service.impl.vo.IDEnum;
//import com.zzst.mcu.service.impl.vo.MeetingInfoVO;
//import com.zzst.mcu.service.impl.vo.MeetingRoomVO;
//import com.zzst.mcu.service.impl.vo.TerminalVO;
//import com.zzst.util.tools.XMLProcessor;


/**
 *@Description
 *@date 2011-3-18下午12:47:34
 *@author ryan
 */
public class MCUServiceImplHelp {
	
	public static	String	test(String mcuToken,String mcuUserToken,String messageID,String obj1,String obj2){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.test);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(obj1!=null){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/ASYNC/YOUR_TOKEN1",obj1);	
		}
		if(obj2!=null){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/ASYNC/YOUR_TOKEN2",obj2);	
		}
		if(messageID!=null&&messageID.length()>0){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		return	document.asXML();
	}
	
	/**
	 * RES列表--组建命令
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceGetRESListFormMcuCommand_2000(String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.getRESListFromMcu_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		return	document.asXML();
	}
	/**
	 * RES--解析返回值
	 * @return
	 */
	public static	String	assayGetRESListFromMcuReStr_2000(){
		 
		return	null;
	}
	/**
	 * 查询会议列表--组建命令
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceGetMeetingListFormMcuCommand_2000(String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.getMeetingListFromMcu_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		return	document.asXML();
	}
	
	/**
	 * 查询会议列表--解析值
	 * @return
	 */
	public static	String	assayGetMeetingListFromMcuReStr_2000(){
 
		return	null;
	}
	/**
	 * 结束会议--组建命令
	 * @param meetingInfoVO
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceEndMeetingCommand_2000(MeetingInfoVO	meetingInfoVO,String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.deleteMeeting_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/ACTION/TERMINATE_CONF/ID",meetingInfoVO.getMeetingID());
		
		return	document.asXML();
	}
	
	/**
	 * 结束命令--返回值
	 * @param terminalVO
	 * @param reStr
	 * @return
	 */
	public static	MeetingInfoVO assayEndMeetingReStr_2000(MeetingInfoVO	meetingInfoVO,String reStr){
		Document document	=	XMLProcessor.getDocumentForString(reStr);
		meetingInfoVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/ID"));
		meetingInfoVO.setDescription(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/DESCRIPTION"));
		return meetingInfoVO;
	}
	
	/**
	 * 查询mcu内的的终端列表---组建命令
	 * @param terminalVO
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceRegisterVenueToMCUCommand_2000(TerminalVO	terminalVO,String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.registerVenueToMcu_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/PARTY/NAME","ZZZZZZZZZ");
		document	=	XMLProcessor.setLeafElementValue(document,"/PARTY/ID","454");
		//if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/PARTY/IP","10.1.3.150");
		//}
		return	document.asXML();
	}
	
	/**
	 * 查询mcu内的的终端列表---解析返回值
	 * @param terminalVO
	 * @param reStr
	 * @return
	 */
	public static	TerminalVO assayRegisterVenueToMCUReStr_2000(TerminalVO terminalVO,String reStr){
		return null;
	}
	
	
	/**
	 * 查询参加会议的终端列表---组建命令
	 * @param meetingInfoVO
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceGetVenueFromMeetingCommand_2000(MeetingInfoVO	meetingInfoVO,String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.getVenueFromMeeting_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/ACTION/GET/ID",meetingInfoVO.getMeetingID());
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/ACTION/GET/OBJ_TOKEN",meetingInfoVO.getObj_token());
		return	document.asXML();
	}
	
	/**
	 * 查询参加会议的终端列表---解析返回值
	 * @param meetingInfoVO
	 * @param reStr
	 * @return
	 */
	public static	MeetingInfoVO assayGetVenueFromMeetingReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
		//reStr="<RESPONSE_TRANS_CONF><RETURN_STATUS><ID>0</ID><DESCRIPTION>Status OK</DESCRIPTION><YOUR_TOKEN1>0</YOUR_TOKEN1><YOUR_TOKEN2>0</YOUR_TOKEN2><MESSAGE_ID>16332</MESSAGE_ID><DESCRIPTION_EX></DESCRIPTION_EX></RETURN_STATUS><ACTION><GET><CONFERENCE><OBJ_TOKEN>2818</OBJ_TOKEN><CHANGED>true</CHANGED><RESERVATION><NAME>bb1302154987937</NAME><ID>774</ID><PASSWORD></PASSWORD><START_TIME>2011-04-07T05:41:44</START_TIME><DURATION><HOUR>1</HOUR><MINUTE>0</MINUTE><SECOND>0</SECOND></DURATION><CASCADE><CASCADE_ROLE>none</CASCADE_ROLE></CASCADE><LECTURE_MODE><ON>true</ON><TIMER>false</TIMER><INTERVAL>15</INTERVAL><AUDIO_ACTIVATED>false</AUDIO_ACTIVATED><LECTURE_NAME></LECTURE_NAME><LECTURE_MODE_TYPE>lecture_presentation</LECTURE_MODE_TYPE><LECTURE_ID>-1</LECTURE_ID></LECTURE_MODE><LAYOUT>1x1</LAYOUT><FORCE_LIST><FORCE><LAYOUT>1x1</LAYOUT><CELL><ID>1</ID><FORCE_STATE>auto</FORCE_STATE></CELL></FORCE></FORCE_LIST><ENTRY_PASSWORD></ENTRY_PASSWORD><VISUAL_EFFECTS><BACKGROUND_COLOR><RED>0</RED><GREEN>0</GREEN><BLUE>0</BLUE><Y>81</Y><U>144</U><V>119</V></BACKGROUND_COLOR><LAYOUT_BORDER>true</LAYOUT_BORDER><LAYOUT_BORDER_COLOR><RED>0</RED><GREEN>0</GREEN><BLUE>0</BLUE><Y>133</Y><U>149</U><V>117</V></LAYOUT_BORDER_COLOR><SPEAKER_NOTATION>true</SPEAKER_NOTATION><SPEAKER_NOTATION_COLOR><RED>0</RED><GREEN>0</GREEN><BLUE>0</BLUE><Y>161</Y><U>44</U><V>160</V></SPEAKER_NOTATION_COLOR><IMAGE_ID>0</IMAGE_ID><USE_YUV>true</USE_YUV></VISUAL_EFFECTS><MESSAGE_OVERLAY><ON>false</ON><MESSAGE_TEXT></MESSAGE_TEXT><MESSAGE_FONT_SIZE>small</MESSAGE_FONT_SIZE><MESSAGE_COLOR>white_font_on_light_blue_background</MESSAGE_COLOR><NUM_OF_REPETITIONS>3</NUM_OF_REPETITIONS><MESSAGE_DISPLAY_SPEED>slow</MESSAGE_DISPLAY_SPEED><MESSAGE_DISPLAY_POSITION>bottom</MESSAGE_DISPLAY_POSITION></MESSAGE_OVERLAY><AUTO_SCAN_ORDER/><AD_HOC>false</AD_HOC><AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID><AUTO_LAYOUT>true</AUTO_LAYOUT><BILLING_DATA></BILLING_DATA><NUMERIC_ID>00395</NUMERIC_ID><CONTACT_INFO_LIST/><IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE><VIDEO_CLARITY>false</VIDEO_CLARITY><AUTO_REDIAL>false</AUTO_REDIAL><PERMANENT>false</PERMANENT><AUTO_SCAN_INTERVAL>10</AUTO_SCAN_INTERVAL><GATHERING><ENABLE_GATHERING>false</ENABLE_GATHERING><LANGUAGE>english</LANGUAGE><IP_NUMBER_ACCESS></IP_NUMBER_ACCESS><ACCESS_NUMBER_1></ACCESS_NUMBER_1><ACCESS_NUMBER_2></ACCESS_NUMBER_2><FREE_TEXT_1></FREE_TEXT_1><FREE_TEXT_2></FREE_TEXT_2><FREE_TEXT_3></FREE_TEXT_3></GATHERING></RESERVATION><CONF_STATUS><CONF_OK>false</CONF_OK><CONF_EMPTY>true</CONF_EMPTY><SINGLE_PARTY>false</SINGLE_PARTY><NOT_FULL>false</NOT_FULL><RESOURCES_DEFICIENCY>false</RESOURCES_DEFICIENCY><BAD_RESOURCES>false</BAD_RESOURCES><PROBLEM_PARTY>false</PROBLEM_PARTY><PARTY_REQUIRES_OPERATOR_ASSIST>false</PARTY_REQUIRES_OPERATOR_ASSIST><CONTENT_RESOURCES_DEFICIENCY>false</CONTENT_RESOURCES_DEFICIENCY></CONF_STATUS><AUDIO_SOURCE_ID>-1</AUDIO_SOURCE_ID><LSD_SOURCE_ID>-1</LSD_SOURCE_ID><NUM_CONNECTED_PARTIES>0</NUM_CONNECTED_PARTIES><SECURE>false</SECURE><EPC_CONTENT_SOURCE_ID>-1</EPC_CONTENT_SOURCE_ID><RECORDING_STATUS>stop</RECORDING_STATUS><ONGOING_PARTY_LIST><ONGOING_PARTY><ONGOING_PARTY_CHANGE>new</ONGOING_PARTY_CHANGE><PARTY><NAME>tttttttt</NAME><ID>0</ID><PHONE_LIST/><INTERFACE>h323</INTERFACE><CONNECTION>dial_out</CONNECTION><MEET_ME_METHOD>party</MEET_ME_METHOD><NUM_TYPE>taken_from_service</NUM_TYPE><BONDING>auto</BONDING><MULTI_RATE>auto</MULTI_RATE><NET_CHANNEL_NUMBER>auto</NET_CHANNEL_NUMBER><VIDEO_PROTOCOL>auto</VIDEO_PROTOCOL><CALL_CONTENT>framed</CALL_CONTENT><ALIAS><NAME></NAME><ALIAS_TYPE>323_id</ALIAS_TYPE></ALIAS><IP>10.1.3.150</IP><SIGNALING_PORT>1024</SIGNALING_PORT><VOLUME>5</VOLUME><MCU_PHONE_LIST/><BONDING_PHONE></BONDING_PHONE><SERVICE_NAME>IP Network Service</SERVICE_NAME><AUTO_DETECT>false</AUTO_DETECT><RESTRICT>false</RESTRICT><VIDEO_BIT_RATE>automatic</VIDEO_BIT_RATE><LAYOUT_TYPE>conference</LAYOUT_TYPE><PERSONAL_LAYOUT>1x1</PERSONAL_LAYOUT><PERSONAL_FORCE_LIST/><FORCE><LAYOUT>1x1</LAYOUT></FORCE><VIP>false</VIP><CONTACT_INFO_LIST/><LISTEN_VOLUME>5</LISTEN_VOLUME><AGC>true</AGC><SIP_ADDRESS></SIP_ADDRESS><SIP_ADDRESS_TYPE>uri_type</SIP_ADDRESS_TYPE><UNDEFINED>false</UNDEFINED><NODE_TYPE>terminal</NODE_TYPE><ENCRYPTION_EX>auto</ENCRYPTION_EX><IS_RECORDING_LINK_PARTY>false</IS_RECORDING_LINK_PARTY><USER_IDENTIFIER_STRING></USER_IDENTIFIER_STRING><IDENTIFICATION_METHOD>called_phone_number</IDENTIFICATION_METHOD><MAX_RESOLUTION>auto</MAX_RESOLUTION><CASCADE><CASCADE_ROLE>none</CASCADE_ROLE></CASCADE><TELEPRESENCE_MODE>none</TELEPRESENCE_MODE><IP_V6>::</IP_V6><SUB_IP_SERVICE>primary</SUB_IP_SERVICE></PARTY><L_SYNC_LOSS>0</L_SYNC_LOSS><R_SYNC_LOSS>0</R_SYNC_LOSS><L_VIDEO_SYNC_LOSS>0</L_VIDEO_SYNC_LOSS><R_VIDEO_SYNC_LOSS>0</R_VIDEO_SYNC_LOSS><H323_VIDEO_INTRA_SYNC>false</H323_VIDEO_INTRA_SYNC><H323_SYNC>0</H323_SYNC><ONGOING_PARTY_STATUS><ID>0</ID><DESCRIPTION>idle</DESCRIPTION></ONGOING_PARTY_STATUS><DISCONNECTION_CAUSE><ID>0</ID><DESCRIPTION>None</DESCRIPTION><DESCRIPTION_EX>0</DESCRIPTION_EX></DISCONNECTION_CAUSE><DISCONNECTING_OPERATOR></DISCONNECTING_OPERATOR><CONNECT_RETRY>3</CONNECT_RETRY><AUDIO_MUTE>false</AUDIO_MUTE><AUDIO_SELF_MUTE>false</AUDIO_SELF_MUTE><AUDIO_MCU_MUTE>false</AUDIO_MCU_MUTE><AUDIO_BLOCK>false</AUDIO_BLOCK><VIDEO_MUTE>false</VIDEO_MUTE><VIDEO_SELF_MUTE>false</VIDEO_SELF_MUTE><VIDEO_MCU_MUTE>false</VIDEO_MCU_MUTE><ATTENDING_STATE>inconf</ATTENDING_STATE><OPERATOR_PARTY>false</OPERATOR_PARTY><AUTO_ADD>false</AUTO_ADD><CHANNELS><CH_1>false</CH_1><CH_2>false</CH_2><CH_3>false</CH_3><CH_4>false</CH_4><CH_5>false</CH_5><CH_6>false</CH_6><CHANNEL_LIST_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX><CHANNEL_EX>false</CHANNEL_EX></CHANNEL_LIST_EX></CHANNELS><ACTUAL_MCU_PHONES/><ACTUAL_PARTY_PHONES/><AUDIO_MEMBER>false</AUDIO_MEMBER><VIDEO_MEMBER>false</VIDEO_MEMBER><LEADER>false</LEADER><WAIT_FOR_ASSISTANCE>assitance_type_none</WAIT_FOR_ASSISTANCE><FORCE><LAYOUT>1x1</LAYOUT></FORCE><GK_STATUS><GK_STATE>arq</GK_STATE><ALLOC_BANDWIDTH>0</ALLOC_BANDWIDTH><REQ_BANDWIDTH>0</REQ_BANDWIDTH><REQ_INTERVAL>0</REQ_INTERVAL><GK_ROUTED>false</GK_ROUTED></GK_STATUS><TX_BAUD_RATE>0</TX_BAUD_RATE><RX_BAUD_RATE>0</RX_BAUD_RATE><NOISY>false</NOISY><CONTENT_MEMBER>false</CONTENT_MEMBER><CONTENT_PROVIDER>false</CONTENT_PROVIDER><VISUAL_NAME></VISUAL_NAME><SECONDARY_CAUSE_PARAMS><CAP_CODE>g711Alaw64k</CAP_CODE><FRAME_RATE_VALUE>0</FRAME_RATE_VALUE><LINE_RATE_VALUE>0</LINE_RATE_VALUE><VIDEO_RESOLUTION>qcif</VIDEO_RESOLUTION><SECONDARY_PROBLEM>unknown</SECONDARY_PROBLEM><SECONDARY_PROBLEM_VALUE>0</SECONDARY_PROBLEM_VALUE><REMOTE_SECONDARY_PROBLEM_VALUE>0</REMOTE_SECONDARY_PROBLEM_VALUE><SIP_CONFERENCING_LIMITATION>unknown</SIP_CONFERENCING_LIMITATION></SECONDARY_CAUSE_PARAMS><PARTY_CHANGE_TYPE>party_new_info</PARTY_CHANGE_TYPE><IS_RV_SYNC_LOSS>false</IS_RV_SYNC_LOSS><IS_LV_SYNC_LOSS>false</IS_LV_SYNC_LOSS><PARTY_CONF_FORCE><LAYOUT>1x1</LAYOUT></PARTY_CONF_FORCE><IS_CURRENTLY_ENCRYPTED>false</IS_CURRENTLY_ENCRYPTED><R_LPR_ACTIVATION>false</R_LPR_ACTIVATION><L_LPR_ACTIVATION>false</L_LPR_ACTIVATION><IS_VALID_HOME_CONF>true</IS_VALID_HOME_CONF><IS_EXCLUSIVE_CONTENT>false</IS_EXCLUSIVE_CONTENT><REQUEST_TO_SPEAK>false</REQUEST_TO_SPEAK><IS_EVENT_MODE_INTRA_SUPPRESSED>false</IS_EVENT_MODE_INTRA_SUPPRESSED><EVENT_MODE_LEVEL>0</EVENT_MODE_LEVEL><LPR_HEADERS_ACTIVATION>false</LPR_HEADERS_ACTIVATION></ONGOING_PARTY></ONGOING_PARTY_LIST><DELETED_PARTIES/></CONFERENCE></GET></ACTION></RESPONSE_TRANS_CONF>";
		ArrayList<TerminalVO> list = new ArrayList<TerminalVO>();
		
		TerminalVO terminalVO = new TerminalVO();

		Document document	=	XMLProcessor.getDocumentForString(reStr);
		
		//meetingInfoVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/ID"));
		
		list.add(terminalVO);
		meetingInfoVO.setTerminalVOList(list);
		return meetingInfoVO;
	}
	
	/**
	 *  提取mcu上的会议室列表---组建命令
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @param obj_token
	 * @return
	 */
	public static	String	produceGetMeetingRoomFromMcuCommand_2000(String mcuToken,String mcuUserToken,String messageID,String obj_token){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.getMeetingRoomFromMcu_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		//document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_LIST/ACTION/GET_MEETING_ROOM_LIST/OBJ_TOKEN",obj_token);
		return	document.asXML();
	}
	
	/**
	 * 提取mcu上的会议室列表---解析返回值
	 * @param meetingInfoVO
	 * @param reStr
	 * @return
	 */
	public static	ArrayList<MeetingRoomVO> assayGetMeetingRoomFromMcuReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
//		<RESPONSE_TRANS_RES_LIST>
//		<RETURN_STATUS>
//			<ID>0</ID>
//			<DESCRIPTION>Status OK</DESCRIPTION>
//			<YOUR_TOKEN1>0</YOUR_TOKEN1>
//			<YOUR_TOKEN2>0</YOUR_TOKEN2>
//			<MESSAGE_ID>0</MESSAGE_ID>
//			<DESCRIPTION_EX></DESCRIPTION_EX>
//		</RETURN_STATUS>
//		<ACTION>
//			<GET_MEETING_ROOM_LIST>
//				<MEETING_ROOM_SUMMARY_LS>
//					<OBJ_TOKEN>28</OBJ_TOKEN>
//					<CHANGED>true</CHANGED>
//					<DELETED_RES_LIST />
//					<DEFAULT_EQ_NAME>DefaultEQ</DEFAULT_EQ_NAME>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>DefaultEQ</NAME>
//						<ID>0</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>true</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1000</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>5</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>test</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>Maple_Room</NAME>
//						<ID>1</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1001</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>Maple_Room</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>Oak_Room</NAME>
//						<ID>2</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1002</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>Oak_Room</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>Juniper_Room</NAME>
//						<ID>3</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1003</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>Juniper_Room</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>Fig_Room</NAME>
//						<ID>4</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1004</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>Fig_Room</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>DefaultFactory</NAME>
//						<ID>5</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1005</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>true</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>1</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>DefaultFactory</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>POLYCOM_1498549428</NAME>
//						<ID>129</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>1008</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>5</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>POLYCOM_1498549428</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>POLYCOM_95664438</NAME>
//						<ID>144</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>true</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>2000</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>6</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>POLYCOM_95664438</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>false</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//					<MEETING_ROOM_SUMMARY>
//						<NAME>Default_GW_Session</NAME>
//						<ID>352</ID>
//						<RES_CHANGE>update</RES_CHANGE>
//						<DURATION>
//							<HOUR>1</HOUR>
//							<MINUTE>0</MINUTE>
//							<SECOND>0</SECOND>
//						</DURATION>
//						<MEET_ME_PHONE></MEET_ME_PHONE>
//						<MR_STATE>passive</MR_STATE>
//						<OPERATOR_CONF>false</OPERATOR_CONF>
//						<ENTRY_QUEUE>false</ENTRY_QUEUE>
//						<ENTRY_PASSWORD></ENTRY_PASSWORD>
//						<PASSWORD></PASSWORD>
//						<NUMERIC_ID>53427</NUMERIC_ID>
//						<CONTACT_INFO_LIST />
//						<NUM_PARTIES>0</NUM_PARTIES>
//						<NUM_UNDEFINED_PARTIES>0</NUM_UNDEFINED_PARTIES>
//						<ENCRYPTION>false</ENCRYPTION>
//						<SIP_FACTORY>false</SIP_FACTORY>
//						<AD_HOC_PROFILE_ID>9</AD_HOC_PROFILE_ID>
//						<DISPLAY_NAME>Default_GW_Session</DISPLAY_NAME>
//						<IS_TELEPRESENCE_MODE>false</IS_TELEPRESENCE_MODE>
//						<GATEWAY>true</GATEWAY>
//						<RES_STATUS>ok</RES_STATUS>
//					</MEETING_ROOM_SUMMARY>
//				</MEETING_ROOM_SUMMARY_LS>
//			</GET_MEETING_ROOM_LIST>
//		</ACTION>
//	</RESPONSE_TRANS_RES_LIST>
		return null;
	}
	
	/**
	 * 提取mcu上的终端列表---组建命令
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @param obj_token
	 * @return
	 */
	public static	String	produceGetVenueFromMcuCommand_2000(String mcuToken,String mcuUserToken,String messageID,String obj_token){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.getVenueFromMcu_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_PARTY/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_PARTY/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_PARTY/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		return	document.asXML();
	}
	
	/**
	 * 提取mcu上的终端列表---解析返回值
	 * @param meetingInfoVO
	 * @param reStr
	 * @return
	 */
	public static	MeetingInfoVO assayGetVenueFromMcuReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
		
		return null;
	}
	/**
	 * 会议中添加会场--组建命令
	 * @param meetingInfoVO
	 * @param terminalVO
	 * @param mcuToken
	 * @param mcuUserToken
	 * @param messageID
	 * @return
	 */
	public static	String	produceCallVenueCommand_2000(MeetingInfoVO	meetingInfoVO,TerminalVO	terminalVO,String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.addVenueForMeeting_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/ACTION/ADD_PARTY/ID",meetingInfoVO.getMeetingID());
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/ACTION/ADD_PARTY/PARTY/NAME",terminalVO.getName());
		//document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/ACTION/ADD_PARTY/PARTY/ID",terminalVO.getId());
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/ACTION/ADD_PARTY/PARTY/IP",terminalVO.getIp());
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_1/ACTION/ADD_PARTY/PARTY/SIGNALING_PORT",meetingInfoVO.getSpeed()+"");
		return	document.asXML();
	}
	
	/**
	 * 会议中添加会场--解析返回值
	 * @param meetingInfoVO
	 * @param reStr
	 * @return
	 */
	public static	MeetingInfoVO assayCallVenueReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
		Document document	=	XMLProcessor.getDocumentForString(reStr);
		meetingInfoVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/ID"));
		meetingInfoVO.setDescription(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/DESCRIPTION"));
		meetingInfoVO.setMessageID(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/MESSAGE_ID"));
		return meetingInfoVO;
	}
	
	public static	String	produceModifyMeetingEndTimeCommand_2000(String id,Timestamp endTime,String mcuToken,String mcuUserToken,String messageID){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.modifyMeetingEndTime_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		
		if(messageID!=null&&messageID.length()>0){
			document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);	
		}
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/ACTION/SET_END_TIME/ID",id);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_CONF_2/ACTION/SET_END_TIME/END_TIME","2011-04-06T4:32:15");
		return	document.asXML();
	}
	
	public static	MeetingInfoVO	assayModifyMeetingEndTimeReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
		Document document	=	XMLProcessor.getDocumentForString(reStr);
		meetingInfoVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/ID"));
		meetingInfoVO.setDescription(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/DESCRIPTION"));
		meetingInfoVO.setMessageID(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_CONF/RETURN_STATUS/MESSAGE_ID"));
		return meetingInfoVO;
	}
	
	
	public static	String	produceCreatMeetingCommand_2000(MeetingInfoVO meetingInfoVO,String mcuToken,String mcuUserToken,String messageID){
		if(mcuToken==null||mcuToken.length()<0||mcuUserToken==null||mcuUserToken.length()<0) return null;
		
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.ceateMeeting_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/TRANS_COMMON_PARAMS/MCU_TOKEN",mcuToken);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/TRANS_COMMON_PARAMS/MCU_USER_TOKEN",mcuUserToken);
		if(messageID!=null&&messageID.length()>0){
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/TRANS_COMMON_PARAMS/MESSAGE_ID",messageID);
		}
		
		//document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/ACTION/START/RESERVATION/NAME",name);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_RES_1/ACTION/START/RESERVATION/DISPLAY_NAME",meetingInfoVO.getMeetingName());
		
		return	document.asXML();
	}
	
	public static	MeetingInfoVO	assayCreatMeetingReStr_2000(MeetingInfoVO meetingInfoVO,String reStr){
		Document document	=	XMLProcessor.getDocumentForString(reStr);
		meetingInfoVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/RETURN_STATUS/ID"));
		meetingInfoVO.setDescription(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/RETURN_STATUS/DESCRIPTION"));
		meetingInfoVO.setMessageID(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/RETURN_STATUS/MESSAGE_ID"));
		if(!IDEnum.succeed.equalsIgnoreCase(meetingInfoVO.getId()))	return null;
		
		meetingInfoVO.setObj_token(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/OBJ_TOKEN"));
		meetingInfoVO.setMeetingID(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/ID"));
		meetingInfoVO.setRoutingName(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/NAME"));
		meetingInfoVO.setStartTime(null);//XMLProcessor.getLeafElementValue(reStr, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/START_TIME"));//2011-04-02T07:29:27
		meetingInfoVO.setLayout(XMLProcessor.getLeafElementValue(reStr, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/LAYOUT"));
		meetingInfoVO.setNumeric_ID(XMLProcessor.getLeafElementValue(reStr, "/RESPONSE_TRANS_RES/ACTION/START/RESERVATION/NUMERIC_ID"));
		return meetingInfoVO;
	}
	
	public static	String	produceLoginCommand_1000(String mcuIP,String	loginName,String	loginPassword){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_1000,MCUHelpUtil.login_1000);
		return	document.asXML();
	}
	
	public static	ControlLoginVO	assayLoginReStr_1000(ControlLoginVO	loginVO,String reStr){
		return loginVO;
	}
	
	/**
	 *	组建2000版本的登录命令 
	 * @param mcuIP
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */
	public static	String	produceLoginCommand_2000(String mcuIP,String	loginName,String	loginPassword){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000,MCUHelpUtil.login_2000);
		if(document==null) return null;
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_MCU/ACTION/LOGIN/MCU_IP/IP",mcuIP);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_MCU/ACTION/LOGIN/USER_NAME",loginName);
		document	=	XMLProcessor.setLeafElementValue(document,"/TRANS_MCU/ACTION/LOGIN/PASSWORD",loginPassword);
		
		return	document.asXML();
	}
	
	/**
	 * 解析2000版本登录返回的信息
	 * @param loginVO
	 * @param reStr
	 * @return
	 */
	public static	ControlLoginVO	assayLoginReStr_2000(ControlLoginVO	loginVO,String reStr){
		Document document	=	XMLProcessor.getDocumentForString(reStr);
		loginVO.setId(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/RETURN_STATUS/ID"));
		loginVO.setDescription(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/RETURN_STATUS/DESCRIPTION"));
		loginVO.setYour_token1(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/RETURN_STATUS/YOUR_TOKEN1"));
		loginVO.setYour_token2(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/RETURN_STATUS/YOUR_TOKEN2"));
		loginVO.setMessage_id(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/RETURN_STATUS/MESSAGE_ID"));
		loginVO.setMcu_token(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/ACTION/LOGIN/MCU_TOKEN"));//41
		loginVO.setMcu_user_token(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/ACTION/LOGIN/MCU_USER_TOKEN"));//41
		loginVO.setAuthorization_group(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/ACTION/LOGIN/AUTHORIZATION_GROUP"));
		loginVO.setApi_number(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/ACTION/LOGIN/API_NUMBER"));
		loginVO.setProduct_type(XMLProcessor.getLeafElementValue(document, "/RESPONSE_TRANS_MCU/ACTION/LOGIN/PRODUCT_TYPE"));
		return loginVO;
	}
	
	public static	String	produceLoginCommand_2000C(String mcuIP,String	loginName,String	loginPassword){
		Document document	=	MCUHelpUtil.getCommand(McuObject.MCU_TYPE_2000C,MCUHelpUtil.login_2000C);
		return	document.asXML();
	}
	
	public static	ControlLoginVO	assayLoginReStr_2000C(ControlLoginVO	loginVO,String reStr){
		return loginVO;
	}
}