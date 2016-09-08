package com.zzst.util.timerTask;

import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 
 * package：com.gsiec.cjf.timer
 * desc：
 * date：	Sep 29, 2010
 */
public class CjfRunTimerTask extends TimerTask {
	private static Logger 		logger = Logger.getLogger(CjfRunTimerTask.class.getName());
	
	 private	CjfTimeTask	p_cjfTimeTask;
	
	public CjfRunTimerTask(CjfTimeTask cjfTimeTask){
		p_cjfTimeTask=cjfTimeTask;
	}
	 
	
	
	public void run() {
		try{
			p_cjfTimeTask.excuteTask();
			CjfTimerHelper.finishTimerTask(p_cjfTimeTask.getTimeTaskID());

			//logger.info(p_cjfTimeTask.getTimeTaskID()+"任务已完成");
		}catch(Exception e){
			logger.error("执行任务失败："+e.toString());
			 
		}
	}

}
