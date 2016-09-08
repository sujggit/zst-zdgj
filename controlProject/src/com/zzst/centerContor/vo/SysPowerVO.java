package com.zzst.centerContor.vo;


/**
 *@Description	系统电源
 *@date 2011-12-16下午04:30:07
 *@author ryan
 */
public class SysPowerVO {

	public static final String status_on = "0";
	public static final String status_off = "1";
	public static final String status_def = "-1";
	
	private String id;
	private String name;
	private String status = status_def;
	private String ip;
	
	
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
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
