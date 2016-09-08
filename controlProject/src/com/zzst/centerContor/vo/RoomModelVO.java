package com.zzst.centerContor.vo;


/**
 *@Description	会议室组合键
 *@date 2013-4-22上午11:13:13
 *@author ryan
 */
public class RoomModelVO {
	
	private String id;
	private String name;
	private String[][] modelList ;//模板集合 0是ID；1是显示名称
	private String model ;//当前调用的模式
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
