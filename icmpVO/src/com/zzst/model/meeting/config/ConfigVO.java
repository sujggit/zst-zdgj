package com.zzst.model.meeting.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConfigVO implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Map<String,String> map = new HashMap<String,String>();
	
	private int qUERY_VIEW_START_HOUR;//会议预约开始时间
	private int qUERY_VIEW_END_HOUR;//会议预约结束时间
	private String sTATISTICS_COUNT_NAME;//生成使用次数统计的文件名称
	private String sTATISTICS_TIME_NAME ;//生成使用时长统计的文件名称
	private	int	sTATISTICS_IMAGE_WIDTH;//生成统计图片的宽
	private	int	sTATISTICS_IMAGE_HEIGTH;//生成统计图片的高
	private	String	tASK_PERIOD_HOUR ;//周期执行时间--小时
	private String appName;//系统名称
	
	private int autoMute;//是否自动静音
	private boolean email;	//是否发送邮件
	private boolean sms;	//是否发送短信
	private boolean meetingbook_service;	//预定会议时是否需要服务
	private boolean record;
	private boolean billboard;
	private boolean ifcallin;
	private int billboardTime;
//	private int meetingDebugDuration;
	private String meetingDebugDuration;
	private String copyright;//版权信息
	private boolean ifOpenLog;//是否开启日志
	public ConfigVO(){
		int width = 100;
		int height = 100;
		int width_num = 2;
		int height_num = 6;
		String modelID = "103";
		int screen_num = 2;
		
		String key = width_num+"*"+height_num+"*"+modelID;
		String value = "view1,0,0,"+width_num*width+"px,"+height_num*height+"px";
		
		String[] viewx_y = new String[screen_num];
		viewx_y[0] ="";
		viewx_y[0] ="";
		
		map.put(key, value);
		map.put("2*6*204", "");
		map.put("2*6*205", "");
	}
	
	public int getqUERY_VIEW_START_HOUR() {
		return qUERY_VIEW_START_HOUR;
	}
	public void setqUERY_VIEW_START_HOUR(int qUERYVIEWSTARTHOUR) {
		qUERY_VIEW_START_HOUR = qUERYVIEWSTARTHOUR;
	}
	public int getqUERY_VIEW_END_HOUR() {
		return qUERY_VIEW_END_HOUR;
	}
	public void setqUERY_VIEW_END_HOUR(int qUERYVIEWENDHOUR) {
		qUERY_VIEW_END_HOUR = qUERYVIEWENDHOUR;
	}
	public String getsTATISTICS_COUNT_NAME() {
		return sTATISTICS_COUNT_NAME;
	}
	public void setsTATISTICS_COUNT_NAME(String sTATISTICSCOUNTNAME) {
		sTATISTICS_COUNT_NAME = sTATISTICSCOUNTNAME;
	}
	public String getsTATISTICS_TIME_NAME() {
		return sTATISTICS_TIME_NAME;
	}
	public void setsTATISTICS_TIME_NAME(String sTATISTICSTIMENAME) {
		sTATISTICS_TIME_NAME = sTATISTICSTIMENAME;
	}
	public int getsTATISTICS_IMAGE_WIDTH() {
		return sTATISTICS_IMAGE_WIDTH;
	}
	public void setsTATISTICS_IMAGE_WIDTH(int sTATISTICSIMAGEWIDTH) {
		sTATISTICS_IMAGE_WIDTH = sTATISTICSIMAGEWIDTH;
	}
	public int getsTATISTICS_IMAGE_HEIGTH() {
		return sTATISTICS_IMAGE_HEIGTH;
	}
	public void setsTATISTICS_IMAGE_HEIGTH(int sTATISTICSIMAGEHEIGTH) {
		sTATISTICS_IMAGE_HEIGTH = sTATISTICSIMAGEHEIGTH;
	}
	public String gettASK_PERIOD_HOUR() {
		return tASK_PERIOD_HOUR;
	}
	public void settASK_PERIOD_HOUR(String tASKPERIODHOUR) {
		tASK_PERIOD_HOUR = tASKPERIODHOUR;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppName() {
		return appName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAutoMute() {
		return autoMute;
	}

	public void setAutoMute(int autoMute) {
		this.autoMute = autoMute;
	}

	public void setMeetingbook_service(boolean meetingbook_service) {
		this.meetingbook_service = meetingbook_service;
	}

	public boolean isMeetingbook_service() {
		return meetingbook_service;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public boolean isEmail() {
		return email;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}

	public boolean isSms() {
		return sms;
	}

	public void setRecord(boolean record) {
		this.record = record;
	}

	public boolean isRecord() {
		return record;
	}

	public void setBillboard(boolean billboard) {
		this.billboard = billboard;
	}

	public boolean isBillboard() {
		return billboard;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public boolean isIfcallin() {
		return ifcallin;
	}

	public void setIfcallin(boolean ifcallin) {
		this.ifcallin = ifcallin;
	}

	public void setBillboardTime(int billboardTime) {
		this.billboardTime = billboardTime;
	}

	public int getBillboardTime() {
		return billboardTime;
	}

//	public void setMeetingDebugDuration(int meetingDebugDuration) {
//		this.meetingDebugDuration = meetingDebugDuration;
//	}
//
//	public int getMeetingDebugDuration() {
//		return meetingDebugDuration;
//	}
	
	public void setMeetingDebugDuration(String meetingDebugDuration) {
		this.meetingDebugDuration = meetingDebugDuration;
	}

	public String getMeetingDebugDuration() {
		return meetingDebugDuration;
	}

	public boolean isIfOpenLog() {
		return ifOpenLog;
	}

	public void setIfOpenLog(boolean ifOpenLog) {
		this.ifOpenLog = ifOpenLog;
	}
	
}
