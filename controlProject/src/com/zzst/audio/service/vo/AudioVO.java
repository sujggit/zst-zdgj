package com.zzst.audio.service.vo;


/**
 *@Description 音频设备对象
 *@date 2012-10-27下午07:26:59
 *@author ryan
 */
public class AudioVO {

	public static final int port_c16_def=52774;
	public static final int mute_on=0;
	public static final int mute_off=1;
	
	private String id;
	private String viewName;
	private String ip;
	private String login_name;
	private String login_pass;
	private int port = port_c16_def;
	private String outLevelNum ;
	private String outFaderNum ;
	private String inLevelNum ;
	private int MuteStatus	=	 Integer.MIN_VALUE;
	
	/**
	 * 设备是否可用
	 */
	private boolean available = true;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getOutFaderNum() {
		return outFaderNum;
	}
	public void setOutFaderNum(String outFaderNum) {
		this.outFaderNum = outFaderNum;
	}
	public String getInLevelNum() {
		return inLevelNum;
	}
	public void setInLevelNum(String inLevelNum) {
		this.inLevelNum = inLevelNum;
	}
	public int getMuteStatus() {
		return MuteStatus;
	}
	public void setMuteStatus(int muteStatus) {
		MuteStatus = muteStatus;
	}
	public String getOutLevelNum() {
		return outLevelNum;
	}
	public void setOutLevelNum(String outLevelNum) {
		this.outLevelNum = outLevelNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
