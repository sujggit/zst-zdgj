package com.zzst.util;


/**
 * 设备对象
 * 
 *@author	ryan
 *@since	2010-11-15下午03:19:45
 *@version	1.0
 */

public abstract class EquipmentObject {

	public static	final	int	EQUIPMENT_TYPE_TERMINAL	=0;
	public static	final	int	EQUIPMENT_TYPE_MCU	=1;
	public static	final	int	EQUIPMENT_TYPE_RSS	=2;//polycom rss
	public static	final	int	EQUIPMENT_TYPE_AUDIO	=3;//音频处理器
	public static	final	int	EQUIPMENT_TYPE_CENTERCONTROL	=4;//amx中控
	public static	final	int	EQUIPMENT_TYPE_ENC	=5;//元嘉的告示服务器
	public static	final	int	EQUIPMENT_TYPE_VTRON	=6;//威创图像处理器
	public static	final	int	EQUIPMENT_TYPE_KST	=7;//可视通INS
	public static	final	int	EQUIPMENT_TYPE_KST_VIDEOCARD	=8;//可视通视频对比卡
	public static	final	int	EQUIPMENT_TYPE_REACH	=9;//锐取录播服务器
	public static	final	int	EQUIPMENT_TYPE_OTHER	=10;//其他设备
	
	public static final	String ip_reachable ="网络不通";
	public static final	String vo_reachable ="没有该设备";
	public static final	String support ="不支持该功能";
	
}
