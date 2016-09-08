package com.zzst.action.meeting.meeting.task;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.McuControlHelper;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.timerTask.CjfTimeTask;
import com.zzst.util.timerTask.CjfTimerHelper;


	/**
	 *@Description
	 *@date 2011-12-5上午10:19:23
	 *@author ryan
	 *
	 */
	public class MeetingStartForEquipmentTask extends CjfTimeTask {
		private static Logger logger = CjfLogger.getLogger(MeetingStartForEquipmentTask.class.getName());
		
		public MeetingStartForEquipmentTask(String timeTaskID, String timeTaskName, Object taskObject) {
			super(timeTaskID, timeTaskName, taskObject);
		}
		 
		public boolean excuteTask() {
			logger.info("召开会议开始…………===MeetingStartForEquipmentTask");
			
			MeetingDetailVO vMeetingDetailVO = (MeetingDetailVO)super.getTaskObject();
			
			String content = "";
			try {
				if(vMeetingDetailVO.getMeetingType()==MeetingDetailEnum.TYPE_VEDIO){//视频会议
					//ZZOResultVO resultVO = new McuControlHelper().creatConfInMcuLevelTwo(vMeetingDetailVO.getMeetingDetailID());
					List<ZZOResultVO> resultVOList = new McuControlHelper().createRapidConf(vMeetingDetailVO.getMeetingDetailID());
					//if( resultVO == null ){//建会成功
					if(resultVOList == null || resultVOList.size()== 0){
						vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_ING+"");
						ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);
						
						MeetingTaskOperate.meetingEndTask(vMeetingDetailVO);//增加定时器 到时间后修改会议状态
						
						//会议结束前提醒  add by ryan  on 2013-02-27
						Timestamp t = vMeetingDetailVO.getMeetingEndTime();
						CjfTimerHelper.addTimerTask(
								new Timestamp(t.getTime()-MeetingAppConfig.meeting_ent_time)
								, new NoticeTask(vMeetingDetailVO.getMeetingDetailID(),"会议结束提醒开始",vMeetingDetailVO));
						
						//日志内容
						content = super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"    成功";
						
					}else if( resultVOList != null ){
						logger.error(resultVOList.get(0).getDescription());
						//日志内容
						content = super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败";
					}
					
				}else if(vMeetingDetailVO.getMeetingType()==MeetingDetailEnum.TYPE_GENERAL){//本地会议
					//日志内容
					content = super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"    成功";
				}
		} catch (Exception e) {
				//日志内容
				content = super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败";
				logger.error("会议开始异常："+e.getMessage());
				e.printStackTrace();
			}
		  //插入日志
			LogUtil.addLogForOperate(content, DateBaseEnum.Default_ID, "10.1.1.1", LogEnum.TYPE_CONTROL_OPERATION, LogEnum.LEVEL_DeFAULT);
			return false;
		}
	}
