package com.zzst.centerContor.vo;


/**
 *@Description	投影机设备对象
 *@date 2012-10-15下午04:55:38
 *@author ryan
 */
public class ProjVO {
	public static final String status_on = "0";
	public static final String status_off = "1";
	public static final String status_def = "-1";

	public static final String display_av = "AV";
	public static final String display_rgb = "RGB";
	public static final String display_dvi = "DVI";
	public static final String display_hdsdi = "HDSDI";
	public static final String display_yuv = "YUV";
	public static final String display_def = "-1";
	
	private String id; //中控控制设备定义ID
	private String name;
	private String status = status_def;
	private String display_type = display_def;
	private String useTime;//投影机使用时长
	private String lightUseTime;//灯泡使用时长
	
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
	
	public String getLightUseTime() {
		return lightUseTime;
	}
	public void setLightUseTime(String lightUseTime) {
		this.lightUseTime = lightUseTime;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
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
