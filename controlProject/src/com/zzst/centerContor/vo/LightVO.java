package com.zzst.centerContor.vo;


/**
 *@Description	灯光
 *@date 2012-2-28下午05:27:48
 *@author ryan
 */
public class LightVO {
	public static final String status_on = "0";
	public static final String status_off = "1";
	public static final String status_def = "-1";
	
	private String id; //中控控制设备定义ID
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
	
	
	
}
