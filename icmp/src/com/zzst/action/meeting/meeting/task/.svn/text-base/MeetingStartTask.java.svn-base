package com.zzst.action.meeting.meeting.task;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.McuControlHelper;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.timerTask.CjfTimeTask;
import com.zzst.util.timerTask.CjfTimerHelper;


/**
 *@Description
 *@date 2011-12-5上午10:19:23
 *@author ryan
 *
 */
public class MeetingStartTask extends CjfTimeTask {
	private static Logger logger = CjfLogger.getLogger(MeetingStartTask.class.getName());
	
	public MeetingStartTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	
	 
	 
	public boolean excuteTask() {
		logger.info("召开会议开始…………");
		
		MeetingDetailVO vMeetingDetailVO = (MeetingDetailVO)super.getTaskObject();
		String meetingRoomIDs = "'" + vMeetingDetailVO.getMeetingRoomNameIDs().replace(",", "','") + "'";
		
		vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_ING+"");
		LogVO vLogVO = new LogVO();
		vLogVO.setUserID(vMeetingDetailVO.getCreateUserID());
		vLogVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
		vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
		try {
		
		ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);//修改会议状态
		
		ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = ServiceFactory.getEquipmentTerminalService().queryByRoomIDs(meetingRoomIDs);		
		if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
			Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = McuControlHelper.getMcuAndTeminalMap(equipmentTerminalVOList);//所有MCU及其终端集合
			if( map !=null && map.size() == 1 ){//单MCU会议
				ZZOResultVO resultVO = new McuControlHelper().creatConfInMcu(vMeetingDetailVO);
				if( resultVO == null ){//建会成功
					MeetingTaskOperate.meetingEndTask(vMeetingDetailVO);//增加定时器 到时间后修改会议状态
					
					//会议结束前提醒  add by ryan  on 2013-02-27
					Timestamp t = vMeetingDetailVO.getMeetingEndTime();
					CjfTimerHelper.addTimerTask(
							   new Timestamp(t.getTime()-MeetingAppConfig.meeting_ent_time)
							, new NoticeTask(vMeetingDetailVO.getMeetingDetailID(),"会议结束提醒开始",vMeetingDetailVO));
					
					//日志内容
					vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"    成功");
//					ServiceFactory.getLogService().add(vLogVO);
				}else if( resultVO != null ){
					vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
					ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);//建会失败删除该条会议记录
					
					//日志内容
					vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败");
//					ServiceFactory.getLogService().add(vLogVO);
					
				}else if( map !=null && map.size()>1 ){//级联会议
					
					List<ZZOResultVO> resultVOList = new McuControlHelper().creatLinkConfInMcu(vMeetingDetailVO, 1);
					if( map.size() == resultVOList.size()){//建会失败
						vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
						ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);//建会失败删除该条会议记录
						
						//日志内容
						vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败");
//						ServiceFactory.getLogService().add(vLogVO);
					}else{
						MeetingTaskOperate.meetingEndTask(vMeetingDetailVO);//增加定时器 到时间后修改会议状态
						
						//会议结束前提醒  add by ryan  on 2013-02-27
						Timestamp t = vMeetingDetailVO.getMeetingEndTime();
						CjfTimerHelper.addTimerTask(
								   new Timestamp(t.getTime()-MeetingAppConfig.meeting_ent_time)
								, new NoticeTask(vMeetingDetailVO.getMeetingDetailID(),"会议结束提醒开始",vMeetingDetailVO));
						
						//日志内容
						vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"    成功");
//						ServiceFactory.getLogService().add(vLogVO);
					}
				}
			}
		}else if(vMeetingDetailVO.getMeetingType()==2){
			//日志内容
			vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败");
			logger.error("名称为"+vMeetingDetailVO.getMeetingName()+"的建会失败");
			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
			ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);//建会失败删除该条会议记录
		}else if(vMeetingDetailVO.getMeetingType()==1){
			//日志内容
			vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"    成功");
//			ServiceFactory.getLogService().add(vLogVO);
		}
			
	} catch (Exception e) {
			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
			try {
				ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(vMeetingDetailVO);
				//日志内容
				vLogVO.setOperatorContent(super.getTimeTaskName()+"："+vMeetingDetailVO.getMeetingName()+"  失败");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//建会失败删除该条会议记录
			logger.error("会议开始异常："+e.getMessage());
		}
	  //插入日志
		LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		return false;
	}
}
