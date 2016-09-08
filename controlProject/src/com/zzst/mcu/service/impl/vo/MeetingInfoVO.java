package com.zzst.mcu.service.impl.vo;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *@Description
 *@date 2011-3-27下午02:19:08
 *@author ryan
 */
public class MeetingInfoVO {
	public static final	String key	=	"mcuIP^_^meetingID";
	public static final String defMeetingID	= "-99999999";
	
	private	boolean	hasMeeting;
	private String  id;
	private String	description;
	
	private String	meetingName;
	private	String	messageID;
	private String	routingName;
	private	String	meetingID	=	defMeetingID;//必须默认为-1
	private String	obj_token;
	private Timestamp	startTime;
	private	Timestamp	endTime;
	private String	numeric_ID;
	private	String	layout;
	private int		speed	=	Integer.MIN_VALUE;
	
	private	 ArrayList<ExceptionVO>	exceptionVOList =	new ArrayList<ExceptionVO>();//系统异常列表
	private  ArrayList<TerminalVO>	terminalVOList	=   new ArrayList<TerminalVO>();
	
	/**
	 * 设置mcu操作异常信息
	 * @param content
	 */
	public void setException(String content,String messageID){
		ExceptionVO ev= new ExceptionVO();
		ev.setMessageType(ExceptionVO.EXCEPTION_CONTROL);
		ev.setMessageContent(content);
		ev.setMessageID(messageID);
		
		exceptionVOList.add(ev);
	}
	
	public ArrayList<ExceptionVO> getExceptionVOList() {
		return exceptionVOList;
	}

	public boolean gasMeeting() {
		return hasMeeting;
	}

	public void setHasMeeting(boolean hasMeeting) {
		this.hasMeeting = hasMeeting;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getRoutingName() {
		return routingName;
	}

	public void setRoutingName(String routingName) {
		this.routingName = routingName;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getMeetingID() {
		return meetingID;
	}

	public void setMeetingID(String meetingID) {
		this.meetingID = meetingID;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getObj_token() {
		return obj_token;
	}

	public void setObj_token(String objToken) {
		obj_token = objToken;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getNumeric_ID() {
		return numeric_ID;
	}

	public void setNumeric_ID(String numericID) {
		numeric_ID = numericID;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public ArrayList<TerminalVO> getTerminalVOList() {
		return terminalVOList;
	}

	public void setTerminalVOList(ArrayList<TerminalVO> terminalVOList) {
		this.terminalVOList.clear();
		this.terminalVOList = terminalVOList;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
