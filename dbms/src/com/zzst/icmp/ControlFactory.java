package com.zzst.icmp;

import java.util.Timer;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.icmp.common.timerTask.CommonHelp;
import com.zzst.icmp.common.timerTask.MyTimerTask;


/**
 * 对外提供的所有接口
 * @author zhangdq
 *	2014-11-20
 */
public class ControlFactory {

	
	
	/**
	 * 首先，更新数据库表结构
	*/
	public static void updateStructure(){
		ControlFactoryHelp.updateStructure();
	}
	
	
	/**
	 * 系统启动时，维护远端节点数据库信息
	 * @param userName	info[0]		 
	 * @param passWord	info[1]		
	 * @param datasource	info[2]	格式：jdbc:mysql://10.1.8.7:3306/test
	 */
	public static boolean initNodeDBInfo(String[] farDBinfo,String[] localDBinfo){
		if(farDBinfo!=null&&farDBinfo.length>=3&&localDBinfo!=null&&localDBinfo.length>=3){
			ControlFactoryHelp.far_db_name = farDBinfo[0];
			ControlFactoryHelp.far_db_password = farDBinfo[1];
			ControlFactoryHelp.far_db_datasource = farDBinfo[2];
			
			ControlFactoryHelp.local_db_name = localDBinfo[0];
			ControlFactoryHelp.local_db_password = localDBinfo[1];
			ControlFactoryHelp.local_db_datasource = localDBinfo[2];
			return true;
		}
		return false;
	}
	
	/**
	 * 同步z_t_level表
	 * @param parentDBIP
	 * @param localNodeIP
	 * @param localNodeDBIP
	 * @return
	 */
	public static String updateDistributed(String parentDBIP,String localNodeIP,String localNodeDBIP){
		return ControlFactoryHelp.updateLevel(parentDBIP,localNodeIP,localNodeDBIP);
	}
	
	/**
	 * 同步z_t_level表
	 * @param parentDBIP
	 * @param localNodeIP
	 * @param localNodeDBIP
	 * @return
	 */
	public static void setLevelID(String levelID){
		CommonHelp.nodeID = levelID;
	}
	
	/**
	 * 启动定时同步现场
	 * @param period 同步周期，单位：秒。（最小时间60秒）
	 */
	public static void startTimerTask(long period){
		if(period<5) period = 5*1000; else period = period*1000;
		new Timer("同步数据现场",true).schedule(new MyTimerTask(), 100,period);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/applog4j.properties");//加载.properties文件
//		ControlFactory.updateStructure();
//		CommonHelp.getUpdateSysTime();
		String[] localDBinfo = new String[3];
		String[] farDBinfo = new String[3];
		localDBinfo[0] = "icmp";
		localDBinfo[1] = "icmp";
		localDBinfo[2] = "jdbc:mysql://10.1.8.7:3306/icmp_hbt2";
		farDBinfo[0] = "admin";
		farDBinfo[1] = "admin";
		farDBinfo[2] = "jdbc:mysql://10.1.5.133:3306/icmp_hbt1";
		com.zzst.icmp.ControlFactory.initNodeDBInfo(farDBinfo, localDBinfo);
		com.zzst.icmp.ControlFactory.updateDistributed("10.1.5.133","10.1.9.124","10.1.8.7");
//		CommonHelp.updateLastTime(new Timestamp(System.currentTimeMillis()+111111));
//		new MyTimerTask().run();
//		System.out.println();
	}

}
