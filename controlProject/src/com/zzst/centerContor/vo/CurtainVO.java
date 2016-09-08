package com.zzst.centerContor.vo;

/**
 *@Description	窗帘对象
 *@date 2012-10-16下午03:40:38
 *@author yangyi
 */
public class CurtainVO {
	
	public static final String status_on = "0";
	public static final String status_off = "1";
	public static final String status_def = "-1";
	
	private String id;
	private String name;
	private String status = status_def;
	
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static String getStatusOn() {
		return status_on;
	}
	public static String getStatusOff() {
		return status_off;
	}
	public static String getStatusDef() {
		return status_def;
	}
	
	
}
