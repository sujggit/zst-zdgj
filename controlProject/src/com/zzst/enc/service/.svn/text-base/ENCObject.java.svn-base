package com.zzst.enc.service;


import com.zzst.util.EquipmentObject;


/**
 *@Description	元嘉告示终端
 *@date 2012-4-17下午03:35:21
 *@author ryan
 */
public abstract	class ENCObject extends EquipmentObject{
	
	
	protected  String ip;
	protected  int 	port = 1234;
	protected  String mac;
	protected  String url;
	
	/**
	 * 终端显示url地址
	 */
	public abstract void setURLView(String mac,String url);
	
	/**
	 * 取消终端显示url地址
	 */
	public abstract void setView(String mac,String url,String tvSys);
	
	
	/**
	 * String[] obj
	 * 0 ip
	 * 1 mac
	 * 2 url
	 * @param obj
	 */
//	public ENCObject(String[] obj){
//		this.ip = obj[0];
//		this.mac = obj[1];
//		this.url = obj[2];
//	}

	public String getIp() {
		return ip;
	}
}
