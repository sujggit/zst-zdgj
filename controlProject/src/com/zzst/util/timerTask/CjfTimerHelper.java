package com.zzst.util.timerTask;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;

/**
 * 
 * package：com.gsiec.cjf.util
 * desc：
 * date：	Sep 29, 2010
 */
public class CjfTimerHelper {
	public	static	HashMap<String,CjfRunTimerTask>	phm_timerTask	=	new	HashMap<String,CjfRunTimerTask>();
	public	static	HashMap<String,CjfRunTimerTask>	phm_repeatTask	=	new	HashMap<String,CjfRunTimerTask>();
	
	
	/**
	 * 周期工作，每天 某时某分某秒执行 cjfTimeTask 任务
	 * @param hour
	 * @param minute
	 * @param second
	 * @param cjfTimeTask
	 * date：Sep 29, 2010
	 */
	public	static	void	addDayTaskPeriod(int hour,int minute,int second,CjfTimeTask cjfTimeTask,String timeName){
		Calendar   cal   =   Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		 
		CjfRunTimerTask cjfRunTimerTask=new CjfRunTimerTask(cjfTimeTask);
		if(timeName==null)
			new Timer(true).schedule(cjfRunTimerTask,cal.getTimeInMillis()-System.currentTimeMillis(),24*60*60*1000);
		else
			new Timer(timeName,true).schedule(cjfRunTimerTask,cal.getTimeInMillis()-System.currentTimeMillis(),24*60*60*1000);
	}
	
	public	static	void	addDayTaskPeriod(int hour,int minute,int second,CjfTimeTask cjfTimeTask){
		addDayTaskPeriod( hour, minute, second, cjfTimeTask,null);
	}
	/**
	 * 延迟delay 后 定期period执行
	 * @param delay
	 * @param period
	 * @param cjfTimeTask
	 */
	public	static	void	addTaskPeriod(long delay,long period,CjfTimeTask cjfTimeTask,String timeName){
		CjfRunTimerTask cjfRunTimerTask=new CjfRunTimerTask(cjfTimeTask);
		if(timeName==null)
			new Timer(true).schedule(cjfRunTimerTask,delay,period);
		else
			new Timer(timeName,true).schedule(cjfRunTimerTask,delay,period);
	}
	public	static	void	addTaskPeriod(long delay,long period,CjfTimeTask cjfTimeTask){
		addTaskPeriod( delay, period, cjfTimeTask,null);
	}
	
	/**
	 * 增加定时任务
	 * @param millionSecond
	 * @param cjfTimeTask
	 * date：Oct 19, 2010
	 */
	public	static	void	addRepeatTask(int millionSecond,CjfTimeTask cjfTimeTask,String timeName){
		if(phm_repeatTask.get(cjfTimeTask.getTimeTaskID())!=null) return ;
		CjfRunTimerTask cjfRunTimerTask=new CjfRunTimerTask(cjfTimeTask);
		
		if(timeName==null)
			new Timer(true).schedule(cjfRunTimerTask,1,millionSecond);
		else
			new Timer(timeName,true).schedule(cjfRunTimerTask,1,millionSecond);
		phm_repeatTask.put(cjfTimeTask.getTimeTaskID(), cjfRunTimerTask);
	}
	
	public	static	void	addRepeatTask(int millionSecond,CjfTimeTask cjfTimeTask){
		addRepeatTask( millionSecond, cjfTimeTask,null);
	}
	
	
	/**
	 * 在指定时间执行指定命令
	 * @param excuteTime
	 * @param cjfTimerIfc
	 * date：Sep 29, 2010
	 */
	public	static	void	addTimerTask(Timestamp excuteTime, CjfTimeTask cjfTimeTask,String timeName){
		if(cjfTimeTask.getTimeTaskID()==null || cjfTimeTask.getTimeTaskID().trim().length()==0){
			cjfTimeTask.setTimeTaskID(System.currentTimeMillis()+"");
		}
		
		CjfRunTimerTask cjfRunTimerTask=new CjfRunTimerTask(cjfTimeTask);
		phm_timerTask.put(cjfTimeTask.getTimeTaskID(), cjfRunTimerTask);
		if(timeName==null)
			new Timer(true).schedule(cjfRunTimerTask, excuteTime);
		else
			new Timer(timeName,true).schedule(cjfRunTimerTask, excuteTime);
	}
	
	public	static	void	addTimerTask(Timestamp excuteTime, CjfTimeTask cjfTimeTask){
		addTimerTask( excuteTime,  cjfTimeTask,null);
	}
	
	/**
	 * 取消任务；
	 * @param timeTaskID
	 * date：Sep 29, 2010
	 */
	public	static	void removeTimerTask(String timeTaskID){
		if(phm_timerTask.get(timeTaskID)==null) return ;
		CjfRunTimerTask cjfRunTimerTask=phm_timerTask.get(timeTaskID);
		cjfRunTimerTask.cancel();
		phm_timerTask.remove(timeTaskID);
	}
	
	public	static	void	removeRepeatTask(String timeTaskID){
		removeTimerTask(timeTaskID);
	}
	
	/**
	 * 取消任务；与removeTimerTask一致
	 * @param timeTaskID
	 */
	public	static	void finishTimerTask(String timeTaskID){
		removeTimerTask(timeTaskID);
	}
}
