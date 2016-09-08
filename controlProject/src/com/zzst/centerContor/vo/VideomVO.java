package com.zzst.centerContor.vo;


/**
 *@Description	画面分割器设备
 *@date 2013-2-18下午03:28:58
 *@author ryan
 */
public class VideomVO {
 
	private String id;
	private String name;
	
	//第一位：ID；第二位：显示名称；第三位：格式
	private String[][] modelList;
	private String modleID;//当前调用的模式ID
	
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
	public String getModleID() {
		return modleID;
	}
	public void setModleID(String modleID) {
		this.modleID = modleID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String[][] getModelList() {
		return modelList;
	}
	public void setModelList(String[][] modelList) {
		this.modelList = modelList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
