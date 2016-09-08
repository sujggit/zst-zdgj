package com.zzst.model.meeting.config;

public class EmailVO {
	
	private String isEffective;//是否有效
	private String emailAddress;//电子邮箱地址
	private String smtp;//发信服务器地址
	private String smtpPort;//发信服务器端口
	private String userName;//用户名
	private String passWord;//密码
	private String format;//格式
	
	public String getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public String getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getFormat() {
		return format;
	}
	
}
