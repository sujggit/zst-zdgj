package com.zzst.otherEquipment.service.vo;


/**
 *@Description
 *@date 2013-12-27下午04:58:38
 *@author ryan
 */
public class OtherEquipmentVO {
	private String id;
	private String ip;
	private int port = Integer.MIN_VALUE;
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
