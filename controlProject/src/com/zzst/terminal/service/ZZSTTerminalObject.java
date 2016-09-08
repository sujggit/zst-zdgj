package com.zzst.terminal.service;

import java.util.HashMap;
import java.util.Map;

import com.zzst.util.EquipmentObject;


/**
 * 终端对象
 *@author	ryan
 *@since	2010-10-5下午01:57:19
 *@version	1.0
 */

public abstract class ZZSTTerminalObject extends EquipmentObject{
	
	public static Map<String,String[]> equipment_map = new HashMap<String,String[]>();
	

	public String	 terminalIp ;
	public int 		 terminalPort	=24 ;
	
	public	ZZSTTerminalObject(String ip){
		this.terminalIp	=	ip;
	}
	
	
	/**
	 * 非静音
	 */
	public static final int MUTE_STATUS_ON  = 1;	
	/**
	 * 静音
	 */
	public static final int MUTE_STATUS_OFF = 2;
	
	/**
	 * 没有任何通话
	 */
	public static final String CALL_NO 	= "1";
	
	/**
	 * 只有视频通话
	 */
	public static final String CALL_VIDEO  = "2";
	
	/**
	 * 只有语言通话
	 */
	public static final String CALL_AUDIO 	= "3";
	
	/**
	 * 有视频通话、语言通话
	 */
	public static final String CALL_ALL 	= "4";
	

	/**
	 * 存储声音检测的音量值 
	 */
	public static Map<String,String[]> soundMap = new HashMap<String,String[]>();
	
	/**
	 * 存储通话中信息的状态 
	 */
	public static Map<String,String[]> callMap = new HashMap<String,String[]>();
	
	/**
	 * 提取终端声音音量值
	 * @param ip
	 * @return String[]
	 * 
	 * 
	 */
	public static String[] getEquipmentSoundInfo(String ip){
		String[] equip = soundMap.get(ip);
		if(equip==null) {
			equip = new String[5];
			soundMap.put(ip, equip);
			return equip;
		}else{
			return soundMap.get(ip);	
		}
	}
	
	/**
	 * 提取终端通话信息
	 * @param ip
	 * @return String[]
	 * 数组说明
	 * 0：输出速率
	 * 1：输入速率
	 * 2：输出视频协议
	 * 3：输入视频协议
	 * 4：输出视频格式
	 * 5：输入视频格式
	 * 6：输出音频协议
	 * 7：输入音频协议
	 * 8：总丢包率
	 * 9：数据包丢失百分比
	 * 10：tcp
	 * 11：输出音频速率
	 * 12：输入音频速率
	 * 13：输出视频速率
	 * 14：输入视频速率
	 * 15：输出使用中的视频速率
	 * 16：输入使用中的视频速率
	 * 17：输出视频帧速率
	 * 18：输入视频帧速率
	 * 19：输出视频数据包丢失
	 * 20：输入视频数据包丢失
	 * 21：输出视频抖动
	 * 22：输入视频抖动
	 * 23：输出音频数据包丢失
	 * 24：输入音频数据包丢失
	 * 25：输出音频抖动
	 * 26：输入音频抖动
	 * 28：dc
	 * 29：rcp
	 * 30: rsid
	 * 31：ccaps
	 */
	public static String[] getEquipmentCallInfo(String ip){
		String[] equip = callMap.get(ip);
		if(equip==null) {
			equip = new String[32];
			callMap.put(ip, equip);
			return equip;
		}else{
			return callMap.get(ip);	
		}
	}
	
	/**
	 * 提取设备的相关信息
	 * @param ip
	 * @return String[]
	 * 数组说明
	 * 0:设备id
	 * 1:设备ip
	 * 2:呼叫状态(1,2,3,4)1：没有任何通话；2：视频通话；3：语音通话；4：语音、视频通话
	 * 3:静音状态(1,2)1：非静音;2：静音
	 */
	public static String[] getEquipmentInfo(String ip){
		String[] equip = equipment_map.get(ip);
		if(equip==null) {
			equip = new String[4]; 
			equipment_map.put(ip,equip);
			return equip;
		}else{
			return equipment_map.get(ip);	
		}
	}
	
	public static void setEquipmentInfo(String[] equip,String ip){
		equipment_map.put(ip, equip);
	}
}
