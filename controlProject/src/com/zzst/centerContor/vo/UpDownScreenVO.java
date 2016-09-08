package com.zzst.centerContor.vo;


/**
 *@Description	升降屏
 *@date 2012-2-28下午05:03:17
 *@author ryan
 */
public class UpDownScreenVO {
	public static final String all_id = "0";
	
	public static final String status_up = "0";
	public static final String status_down = "1";
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
