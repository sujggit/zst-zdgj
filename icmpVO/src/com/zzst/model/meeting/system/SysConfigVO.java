package com.zzst.model.meeting.system;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: SysConfig VO
 * 
 * @author ryan
 * @date Mon Nov 23 16:41:52 CST 2009
 */

public class SysConfigVO implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static Integer USER_LOG=1;//启用日志
	public final static Integer NO_LOG=0;//不启用日志
	
	public final static Integer LEFT_VIEW_TOOLS=1;//显示工具
	public final static Integer LEFT_VIEW_NOTICE=0;//显示告示、日历
	
	private Integer sysID=Integer.MIN_VALUE;

	private Integer userID=Integer.MIN_VALUE;

	private String userName;

	private Timestamp creatDate;

	private Integer iflog=Integer.MIN_VALUE;

	private String webPort;

	private String ftpIP;

	private String ftpPort;

	private String ftpName;

	private String ftpPassword;

	private String ftpURL;

	private Integer adminleft=Integer.MIN_VALUE;

	private Integer systemValue=Integer.MIN_VALUE;

	private String description;

	private Long revision=Long.MIN_VALUE;

	public void setSysID(Integer sysID) {
		this.sysID = sysID;
	}

	public Integer getSysID() {
		return sysID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setCreatDate(Timestamp creatDate) {
		this.creatDate = creatDate;
	}

	public Timestamp getCreatDate() {
		return creatDate;
	}

	public void setIflog(Integer iflog) {
		this.iflog = iflog;
	}

	public Integer getIflog() {
		return iflog;
	}

	public void setWebPort(String webPort) {
		this.webPort = webPort;
	}

	public String getWebPort() {
		return webPort;
	}

	public void setFtpIP(String ftpIP) {
		this.ftpIP = ftpIP;
	}

	public String getFtpIP() {
		return ftpIP;
	}

	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpPort() {
		return ftpPort;
	}

	public void setFtpName(String ftpName) {
		this.ftpName = ftpName;
	}

	public String getFtpName() {
		return ftpName;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpURL(String ftpURL) {
		this.ftpURL = ftpURL;
	}

	public String getFtpURL() {
		return ftpURL;
	}

	public void setAdminleft(Integer adminleft) {
		this.adminleft = adminleft;
	}

	public Integer getAdminleft() {
		return adminleft;
	}

	public void setSystemValue(Integer systemValue) {
		this.systemValue = systemValue;
	}

	public Integer getSystemValue() {
		return systemValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

}
