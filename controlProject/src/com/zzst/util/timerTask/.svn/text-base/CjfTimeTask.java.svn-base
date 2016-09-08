package com.zzst.util.timerTask;

/**
 * CJF 专用定时任务对象，每个任务需要继承该方法
 * package：com.gsiec.cjf.timer
 * desc：
 * date：	Oct 8, 2010
 */
public abstract class CjfTimeTask {
	private	String	timeTaskID	;
	private	String	timeTaskName;
	
	private	Object	taskObject	;
	
	public CjfTimeTask(String timeTaskID,String timeTaskName,Object taskObject){
		this.setTimeTaskID(timeTaskID);
		this.setTimeTaskName(timeTaskName);
		this.setTaskObject(taskObject);
	}
	
	public Object getTaskObject() {
		return taskObject;
	}

	public void setTaskObject(Object taskObject) {
		this.taskObject = taskObject;
	}

	public String getTimeTaskID() {
		return timeTaskID;
	}

	public void setTimeTaskID(String timeTaskID) {
		this.timeTaskID = timeTaskID;
	}

	public String getTimeTaskName() {
		return timeTaskName;
	}

	public void setTimeTaskName(String timeTaskName) {
		this.timeTaskName = timeTaskName;
	}

	public	abstract boolean	excuteTask();
}
