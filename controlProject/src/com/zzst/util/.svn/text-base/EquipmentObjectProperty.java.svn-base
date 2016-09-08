package com.zzst.util;

import java.util.ArrayList;


/**
 *@Description 
 *设备的公用方法及不对外显示的方法
 *@date 2014-2-25下午04:11:30
 *@author ryan
 */
public interface EquipmentObjectProperty {

	/**
	 * 提取正在使用的线程情况
	 * 没有实现
	 * @return	int
	 * add by ryan on 20140224
	 */
	public abstract	ArrayList<String[]> getThreads() ;
	
	
	/**
	 * 开启设备的状态检测线程，达到正常控制本设备的目标
	 * 没有实现
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public abstract	boolean startEquipmentNetStatusThreads(String[] ips) ;
	
	/**
	 * 关闭设备的状态检测线程,不控制本设备
	 * 没有实现
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public abstract boolean stopEquipmentNetStatusThreads(String[] ips) ;
	
	/**
	 * 开启设备的状态检测线程，达到正常控制本设备的目标
	 * 没有实现
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public abstract	boolean startEquipmentNetStatusThreads(String equipmentType) ;
	
	/**
	 * 关闭设备的状态检测线程,不控制本设备
	 * 没有实现
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public abstract boolean stopEquipmentNetStatusThreads(String equipmentType) ;
	
}
