package com.zzst.action.project.webservices.pushtodo;
//门户提供的接口方法
public interface PushToDoClient {
	
	/**添加代办事项
	 * @param appID 	         应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @param taskName	        待办事项名称
	 * @param appTaskID	         应用系统中的待办事项唯一的ID
	 * @param taskType	          所属待办类型,由各应用系统自己分配，必须是中文名称。
	 * @param appSendUID    应用系统发送者ID
	 * @param appReceiveUID 接收者对应的应用系统用户ID，需要处理该项待办事项的用户，多个用户用;分隔
	 * @param sendTime	          待办事项信息启用时间yyyy-mm-dd hh:MM:ss，如果为空，则使用当时日期
	 * @param endTime	         待办事项信息结束时间yyyy-mm-dd hh:MM:ss，如果为空，则使用应用系统待办事项的默认超期时间计算
	 * @param url		         待办事项处理链接，能够通过该链接直接定位到待办事项的处理界面
	 * @param taskDesc	          待办事项描述，如果没有可与taskName保持一致
	 * @param priorityID	待办事项信息紧急程度，越小越紧急,0:特急 1:紧急 2:一般,缺省2
	 * 返回字符串 0 失败 1成功
	 */
	public String addTask(String appID,String taskName,String appTaskID,String taskType,String appSendUID,String appReceiveUID,String sendTime,String endTime,String url,String taskDesc,String priorityID);
	
	/* 撤销代办事项
	 * @param appTaskID	                       应用系统中的待办事项唯一的ID
	 * @param appID 	                       应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @handleTime               代办事项的处理时间，为空则已受到的时间为处理时间
	 * 返回字符串 0 失败 1成功
	 */
	public String cancelTask(String appTaskID,   String   appID,  String handleTime);
	
	/* 完成代办事项,将代办库中的记录移到历史记录表中
	 * @param appTaskID	                       应用系统中的待办事项唯一的ID
	 * @param appID 	                       应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @handleTime               代办事项的处理时间，为空则已受到的时间为处理时间
	 * 返回字符串 0 失败 1成功
	 */
	public String completeTask(String appTaskID,   String   appID,  String handleTime);
	
	/* 代办id相同,且多人处理的业务系统，完成代办时需要指定用户
	 * @userId                  完成代办的业务系统id
	 * @param appTaskID	                       应用系统中的待办事项唯一的ID
	 * @param appID 	                       应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @handleTime               代办事项的处理时间，为空则已受到的时间为处理时间
	 * 返回字符串 0 失败 1成功
	 */
	public String completeTaskUpdate(String userId, String appTaskID,   String   appID,  String handleTime );

	/* 小数据量代办同步接口
	 * @param appID 	                       应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @handleTime               业务系统中执行查询代办数据时的时间，或者查询到最近一条代办任务时产生的
	 * @taskStr                 组合字符串格式为taskId,userId,taskId,userId  
	 * 返回字符串不同
	 */
	public String sychTaskSmall(String appID, String handleTime,String taskStr);
}
