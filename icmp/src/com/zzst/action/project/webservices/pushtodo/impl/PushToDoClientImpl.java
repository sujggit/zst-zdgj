package com.zzst.action.project.webservices.pushtodo.impl;

import com.zzst.action.project.webservices.pushtodo.PushToDoClient;
import com.zzst.action.project.webservices.pushtodo.webservices.TaskMgrControlLocator;


public class PushToDoClientImpl implements PushToDoClient{
	TaskMgrControlLocator task = new TaskMgrControlLocator();
	/**
	 * @param appID 	应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @param taskName	待办事项名称
	 * @param appTaskID	应用系统中的待办事项唯一的ID
	 * @param taskType	所属待办类型,由各应用系统自己分配，必须是中文名称。
	 * @param appSendUID应用系统发送者ID
	 * @param appReceiveUID 接收者对应的应用系统用户ID，需要处理该项待办事项的用户，多个用户用;分隔
	 * @param sendTime	待办事项信息启用时间yyyy-mm-dd hh:MM:ss，如果为空，则使用当时日期
	 * @param endTime	待办事项信息结束时间yyyy-mm-dd hh:MM:ss，如果为空，则使用应用系统待办事项的默认超期时间计算
	 * @param url		待办事项处理链接，能够通过该链接直接定位到待办事项的处理界面
	 * @param taskDesc	待办事项描述，如果没有可与taskName保持一致
	 * @param priorityID	待办事项信息紧急程度，越小越紧急,0:特急 1:紧急 2:一般,缺省2
	 */
	public String addTask(String appID, String taskName, String appTaskID,String taskType, String appSendUID, String appReceiveUID,	String sendTime, String endTime, String url, String taskDesc,String priorityID) {
		String returnInfo = "";
		try {
			returnInfo = task.getTaskMgrControlHttpPort().addTask(appID, taskName, appTaskID, taskType, appSendUID, appReceiveUID, sendTime, endTime, url, taskDesc, priorityID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnInfo;
	}

	@Override
	public String cancelTask(String appTaskID, String appID, String handleTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String completeTask(String appTaskID, String appID, String handleTime) {
		String returnInfo = "";
		try {
			returnInfo = task.getTaskMgrControlHttpPort().completeTask(appTaskID, appID, handleTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnInfo;
	}


	@Override
	public String completeTaskUpdate(String userId, String appTaskID,
			String appID, String handleTime) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String sychTaskSmall(String appID, String handleTime, String taskStr) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
