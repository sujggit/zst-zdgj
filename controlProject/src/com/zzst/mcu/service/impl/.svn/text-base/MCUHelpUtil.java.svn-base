package com.zzst.mcu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;

import com.zzst.mcu.service.McuObject;
import com.zzst.util.tools.XMLProcessor;

/**
 *@Description
 *@date 2011-3-18下午12:19:30
 *@author ryan
 */
public class MCUHelpUtil {
	//public static Map<String,Object> mcuServiceImplMap = new HashMap<String,Object>();
	public static Map<String,Document> mcuCommandMap = new HashMap<String,Document>();
	public static final	String test	="test";
	
	public static final	String login_1000	="login_1000";
	public static final	String login_2000	="login_2000";
	public static final	String login_2000C	="login_2000C";
	
	public static final	String ceateMeeting_1000	="ceateMeeting_1000";
	public static final	String ceateMeeting_2000	="ceateMeeting_2000";
	public static final	String ceateMeeting_2000C	="ceateMeeting_2000C";
	
	public static final	String deleteMeeting_1000	="deleteMeeting_1000";
	public static final	String deleteMeeting_2000	="deleteMeeting_2000";
	public static final	String deleteMeeting_2000C	="deleteMeeting_2000C";
	
	public static final	String modifyMeetingEndTime_1000	="modifyMeetingEndTime_1000";
	public static final	String modifyMeetingEndTime_2000	="modifyMeetingEndTime_2000";
	public static final	String modifyMeetingEndTime_2000C	="modifyMeetingEndTime_2000C";
	
	public static final	String addVenueForMeeting_1000	="addVenueForMeeting_1000";
	public static final	String addVenueForMeeting_2000	="addVenueForMeeting_2000";
	public static final	String addVenueForMeeting_2000C	="addVenueForMeeting_2000C";
	
	public static final	String getMeetingListFromMcu_1000	="getMeetingListFromMcu_1000";
	public static final	String getMeetingListFromMcu_2000	="getMeetingListFromMcu_2000";
	public static final	String getMeetingListFromMcu_2000C	="getMeetingListFromMcu_2000C";
	
	public static final	String getRESListFromMcu_1000	="getRESListFromMcu_1000";
	public static final	String getRESListFromMcu_2000	="getRESListFromMcu_2000";
	public static final	String getRESListFromMcu_2000C	="getRESListFromMcu_2000C";
	
	public static final	String getVenueFromMeeting_1000	="callVenue_2000C";
	public static final	String getVenueFromMeeting_2000	="callVenue_2000C";
	public static final	String getVenueFromMeeting_2000C	="callVenue_2000C";
	
	public static final	String getMeetingRoomFromMcu_1000		="getMeetingRoomFromMcu_1000";
	public static final	String getMeetingRoomFromMcu_2000		="getMeetingRoomFromMcu_2000";
	public static final	String getMeetingRoomFromMcu_2000C		="getMeetingRoomFromMcu_2000C";
	
	public static final	String getVenueFromMcu_1000		="getVenueFromMcu_1000";
	public static final	String getVenueFromMcu_2000		="getVenueFromMcu_2000";
	public static final	String getVenueFromMcu_2000C		="getVenueFromMcu_2000C";
	
	public static final	String registerVenueToMcu_1000		="registerVenueToMcu_1000";
	public static final	String registerVenueToMcu_2000		="registerVenueToMcu_2000";
	public static final	String registerVenueToMcu_2000C		="registerVenueToMcu_2000C";
	
	public static final	String addModConfProfile_1000	="addModConfProfile_1000";
	public static final	String addModConfProfile_2000	="addModConfProfile_2000";
	public static final	String addModConfProfile_2000C	="addModConfProfile_2000C";
	
	/**
	 * 根据mcu型号、key提取相应命令
	 * @param mcuType
	 * @param key
	 * @return	
	 */
	public static Document	getCommand(String mcuType, String key){
		Document document = null;
		if(mcuCommandMap.isEmpty()){
			//加载数据到缓存
			if(!initCommandData(mcuType))	return null;
		}
		document	=mcuCommandMap.get(key);
		return document;
	}
	
	public static void main(String[] args) {

	}
	
	
	public static boolean	initCommandData(String mcuType){
		
		if(McuObject.MCU_TYPE_500.equalsIgnoreCase(mcuType)){
		
		}else if(McuObject.MCU_TYPE_1000.equalsIgnoreCase(mcuType)){
			
		}else if(McuObject.MCU_TYPE_2000.equalsIgnoreCase(mcuType)){
			String classPath = MCUHelpUtil.class.getResource("/").getPath()+"com/zzst/mcu/service/impl/rmx2000/command/";
			classPath = classPath.substring(1,classPath.length());
			mcuCommandMap.put(test, XMLProcessor.getDocumentForURL(classPath+"test.xml"));
			
			mcuCommandMap.put(login_2000,				 XMLProcessor.getDocumentForURL(classPath+"login_control.xml"));
			mcuCommandMap.put(ceateMeeting_2000, 		 XMLProcessor.getDocumentForURL(classPath+"meeting_creat.xml"));
			mcuCommandMap.put(deleteMeeting_2000,	 	 XMLProcessor.getDocumentForURL(classPath+"meeting_delete.xml"));
			mcuCommandMap.put(modifyMeetingEndTime_2000, XMLProcessor.getDocumentForURL(classPath+"meeting_modifyEndTime.xml"));
			mcuCommandMap.put(addModConfProfile_2000, XMLProcessor.getDocumentForURL(classPath+"addModConfProfile.xml"));
			mcuCommandMap.put(addVenueForMeeting_2000, XMLProcessor.getDocumentForURL(classPath+"meeting_addVenue.xml"));
			mcuCommandMap.put(getMeetingRoomFromMcu_2000, XMLProcessor.getDocumentForURL(classPath+"getMeetingRoomFromMcuList.xml"));
			mcuCommandMap.put(getVenueFromMeeting_2000, XMLProcessor.getDocumentForURL(classPath+"meeting_getVenue.xml"));
			mcuCommandMap.put(registerVenueToMcu_2000, XMLProcessor.getDocumentForURL(classPath+"registerVenue.xml"));
			mcuCommandMap.put(getVenueFromMcu_2000, XMLProcessor.getDocumentForURL(classPath+"getVenueFromMcu.xml"));
			mcuCommandMap.put(getMeetingListFromMcu_2000, XMLProcessor.getDocumentForURL(classPath+"meeting_getMeetingList.xml"));
			mcuCommandMap.put(getRESListFromMcu_2000, XMLProcessor.getDocumentForURL(classPath+"meeting_getRESList.xml"));
			
		}else if(McuObject.MCU_TYPE_2000C.equalsIgnoreCase(mcuType)){
			
		}
		return true;
	}
	
}
