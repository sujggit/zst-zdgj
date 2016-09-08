package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.equipmentControl.InitEquipmentControlDate;
import com.zzst.action.meeting.meeting.task.MeetingDayTaskPeriod;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.task.AuthorizationTask;
import com.zzst.action.meeting.util.task.ClearLogTask;
import com.zzst.action.meeting.util.task.EquipmentMaintenanceTask;
import com.zzst.action.meeting.util.task.SynchroDBDataTask;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.timerTask.CjfTimerHelper;


/**
 *@Description	系统启动是加载项
 *@date 2012-1-29上午11:46:00
 *@author ryan
 */
public class InitMeetingTaskDate {

	private static Logger logger = CjfLogger.getLogger(InitMeetingTaskDate.class.getName());
	
	public static void init(){ 
//		启动时，处理开始时间、结束时间已经过去的会议
		//pastMeetingDetail();
		
		//启动时，加载最近24小时的会议
		initMeetingDetailTaskDate();
		
		//启动时，加载每天定时提取会议的线程
		initMeetingDetailDayDate();
		
		//设备维保到期提醒
		initEquipmentMaintenanceNotice();
		
		//清理日志信息
		initClearLogTask();
		
		//启动snmp服务。增加页面设置后再放出
		if(MeetingAppConfig.SNMP_POEN)
			ControlFactory.snmpInitDate(MeetingAppConfig.webservice_ip);
				
//		定时同步标准接口数据到核心表数据。加载顺序89
		if(MeetingAppConfig.SynchroStatus)
			initSynchroDBDataTask();
		
		//加载中控部分数据。使用时需求单独启动检测线程
		InitEquipmentControlDate.initCCDBDate();
		InitEquipmentControlDate.initCenterControl();
		//加载终端数据。使用时需求单独启动检测线程
		InitEquipmentControlDate.initTerminalDate();
		
		//设置线程检测设备的数量，及线程循环完后的休眠时间
		ControlFactory.setEquipmentParam(MeetingAppConfig.EQUIPMENTPARAM_NUM,MeetingAppConfig.EQUIPMENTPARAM_SLEEP);
	}
	
	/**
	 * 处理掉开始时间在当前时间之前的会议
	 *
	 */
	public static void pastMeetingDetail(){ 
		logger.info("InitMeetingTaskDate	pastMeetingDetail	begin");
		try{
			ArrayList<MeetingDetailVO> list = ServiceFactory.getMeetingDetailService().queryPastSysTime(null);
			logger.info("清理垃圾数据个数（开始时间在当前时间之前的状态为会议中和预约成功的数据）："+list.size());
			for(MeetingDetailVO vo : list){
				logger.info("清理掉的会议名称："+vo.getMeetingName()+"会议开始时间："+vo.getMeetingStartTime());
				vo.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
				ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vo);
			}
		}catch(Exception e){
			logger.error("InitMeetingTaskDate	pastMeetingDetail	error："+e.getMessage());
		}
		logger.info("InitMeetingTaskDate	pastMeetingDetail	end");
	}
	
	/**
	 * 系统启动时读取24小时的会议数据
	 */
	public static void initMeetingDetailTaskDate(){ 
		logger.info("InitMeetingTaskDate	initMeetingDetailTaskDate	begin");
		try{
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis()+MeetingAppConfig.cache_hour*60*60*1000));
			vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+","+MeetingDetailEnum.STATUS_ING);
			ArrayList<MeetingDetailVO> list = ServiceFactory.getMeetingDetailService().getMeetingDetailList(vMeetingDetailVO, null);
			
			for(MeetingDetailVO vo : list){
				if(vo.getStatus()!=MeetingDetailEnum.STATUS_ING+""){
					MeetingTaskOperate.meetingEndTask(vo);
				}else{
					MeetingTaskOperate.meetingStartTask(vo);
					MeetingTaskOperate.meetingEndTask(vo);
				}
			}
		}catch(Exception e){
			logger.error("InitMeetingTaskDate	initMeetingDetailTaskDate	error："+e.getMessage());
		}
		logger.info("InitMeetingTaskDate	initMeetingDetailTaskDate	end");
	}
	
	/**
	 * 系统启动时,启动每天读取24小时的会议信息到缓存
	 */
	public static void initMeetingDetailDayDate(){ 
		logger.info("InitMeetingTaskDate	initMeetingDetailDayDate	begin");
		CjfTimerHelper.addDayTaskPeriod(Integer.valueOf(MeetingAppConfig.TASK_PERIOD_HOUR), 0, 0, 
				new MeetingDayTaskPeriod("addDayTaskPeriod","每天定时执行",""));
		logger.info("InitMeetingTaskDate	initMeetingDetailDayDate	end");
	}
	
	/**
	 * 系统启动时,启动每天需要提醒的设备维保日期
	 */
	public static void initEquipmentMaintenanceNotice(){
		logger.info("InitMeetingTaskDate	initEquipmentMaintenanceNotice	begin");
		CjfTimerHelper.addDayTaskPeriod(Integer.valueOf(MeetingAppConfig.TASK_PERIOD_HOUR).intValue(), 0, 0, 
				new EquipmentMaintenanceTask("equipmentMaintenanceNotice","",""));
		logger.info("InitMeetingTaskDate	initEquipmentMaintenanceNotice	end");
	}
	
	/**
	 * 系统启动时,启动每天需要同步接口表到核心表
	 */
	public static void initSynchroDBDataTask(){
		logger.info("InitMeetingTaskDate	initSynchroDBDataTask	begin");
		CjfTimerHelper.addTaskPeriod(0, MeetingAppConfig.SynchroDBDataTime*1000,
				new SynchroDBDataTask("synchroDBData","",""));
		logger.info("InitMeetingTaskDate	initSynchroDBDataTask	end");
	}
	
	/**
	 * 系统启动时,启动每天检查授权设置
	 */
	public static void initAuthorizationTask(){
		logger.info("InitMeetingTaskDate	initAuthorizationTask	begin");
		CjfTimerHelper.addDayTaskPeriod(Integer.valueOf(MeetingAppConfig.TASK_PERIOD_HOUR).intValue(), 0, 0, 
				new AuthorizationTask("authorizationTask","",""));
		logger.info("InitMeetingTaskDate	initAuthorizationTask	end");
	}
	
	/**
	 * 系统启动时,启动每天清理日志活动
	 */
	public static void initClearLogTask(){
		logger.info("InitMeetingTaskDate	initClearLogTask	begin");
		CjfTimerHelper.addDayTaskPeriod(Integer.valueOf(MeetingAppConfig.TASK_PERIOD_HOUR).intValue(), 0, 0, 
				new ClearLogTask("initClearLogTask","",""));
		logger.info("InitMeetingTaskDate	initClearLogTask	end");
	}
}
