package com.zzst.model.meeting.log;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.enums.LogEnum;

/**
 * class description: Log Object
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public class LogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String logID;
	private String userID;
	private int logType = LogEnum.TYPE_DEFAULT;
	private int level = LogEnum.LEVEL_DeFAULT;
	private Timestamp operatorDate;
	
	//add by yangyi
	private Timestamp starTime;
	private Timestamp endTime;
	private String userName;
	
	private String operatorContent;
	private String userIP;
	private String description;
	private long revision = Long.MIN_VALUE;
	
	
	public Timestamp getStarTime() {
		return starTime;
	}

	public void setStarTime(Timestamp starTime) {
		this.starTime = starTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public void setLogID(String logID) {
		this.logID = logID;
	}

	public String getLogID() {
		return logID;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}
	
	public void setLogType(String logType){
		this.logType = Integer.parseInt(logType);
	}

	public int getLogType() {
		return logType;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setOperatorDate(Timestamp operatorDate) {
		this.operatorDate = operatorDate;
	}

	public Timestamp getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorContent(String operatorContent) {
		this.operatorContent = operatorContent;
	}

	public String getOperatorContent() {
		return operatorContent;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public String getUserIP() {
		return userIP;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

}
