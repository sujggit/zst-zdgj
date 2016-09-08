package com.zzst.terminal.service.impl.vo;



/**
 *@Description
 *@date 2011-5-25上午11:37:54
 *@author ryan
 */
public class TerminalMeetingVO {
	public static final	String key	=	"NEARIP^_^FARIP";
	
	public static final	String	TYPE_MANUAL_IN	="dial_manual_in";
	public static final	String	TYPE_MANUAL_OUT	="dial_manual_out";
	public static final	String	TYPE_HPONE_IN	="dial_phone_in";
	public static final	String	TYPE_HPONE_OUT	="dial_phone_out";
	
	public TerminalMeetingVO(){
		
	}
	
	/**
	 * 	多个回话时会议ID
	 */
	private String	id;
	/**
	 * 	多个回话时会议顺序
	 */
	private int		order;
	private String	meetingType;
	private String  farIP;
	private String  farPhone;
	private int		speed;
	private String  dialstr;//auto状态下
	
//	private CallDetailVO detailVO = new CallDetailVO();//


	public String getId() {
		return id;
	}


	public String getDialstr() {
		return dialstr;
	}


	public void setDialstr(String dialstr) {
		this.dialstr = dialstr;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public String getMeetingType() {
		return meetingType;
	}


	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}


	public String getFarIP() {
		return farIP;
	}


	public void setFarIP(String farIP) {
		this.farIP = farIP;
	}


	public String getFarPhone() {
		return farPhone;
	}


	public void setFarPhone(String farPhone) {
		this.farPhone = farPhone;
	}


//	public CallDetailVO getDetailVO() {
//		return detailVO;
//	}
//
//
//	public void setDetailVO(CallDetailVO detailVO) {
//		this.detailVO = detailVO;
//	}


	
	
}
