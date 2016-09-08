package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;

/**
 * 
 * @author wangrl
 * @on 2011-12-20
 */
public class MessageVO {
	private static final long serialVersionUID = 1L;
	
	public	static	final	int	OTHER		=	2;		//部分成功
	public	static	final	int	SUCCESS		=	1;
	public	static	final	int	FAILURE		=	0;
	
	private		Timestamp	startTime	;
	private		Timestamp	endTime	    ;

	private		String		msID		;
	private     String      content     ;
    private     String      phoneNumber ;
    
    private		int			sendResult	=0;				//操作结果，默认为失败�?
	private		int			factSendNum	=0;				//实际发�?�条�?
	private		int			successNum	=0;				//成功发�?�条�?
	
	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getMsID() {
		return msID;
	}

	public void setMsID(String msID) {
		this.msID = msID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSendResult() {
		return sendResult;
	}

	public void setSendResult(int sendResult) {
		this.sendResult = sendResult;
	}

	public int getFactSendNum() {
		return factSendNum;
	}

	public void setFactSendNum(int factSendNum) {
		this.factSendNum = factSendNum;
	}

	public int getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}

	
 
	
	
}
