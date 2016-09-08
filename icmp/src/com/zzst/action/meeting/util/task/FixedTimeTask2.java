package com.zzst.action.meeting.util.task;

import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description
 *@date 2013-5-8上午08:51:15
 *@author ryan
 */
public class FixedTimeTask2 extends TimerTask{
	private static Logger logger = CjfLogger.getLogger(FixedTimeTask2.class.getName());
	
	private String timeTaskID;
	private String timeTaskName;
	private Object taskObject;
	
	public	FixedTimeTask2(String timeTaskID,String timeTaskName,Object taskObject){
		this.timeTaskID = timeTaskID;
		this.timeTaskName = timeTaskName;
		this.taskObject = taskObject;
	}
	
	
	@Override
	public void run() {
		try{
			logger.info("定时开关机开始…………");
			//调用中控接口
			String str = (String)taskObject;
			//str = "on;ip;hour;mi";
			if(str==null) return ;
			if(str.split(";").length!=4) return ;
			String[] info = str.split(";");
			
			CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(info[1]);
			
			if(info[0].equalsIgnoreCase("on")){
				logger.info("定时开机开始…………");
				//获取电源状态
				ExcuteResultVO vo = obj.sysPowerOn(MeetingAppConfig.CC_DEF_ID);
				if (vo.isSuccess()) {
					addLog(timeTaskName+"（"+info[1]+"）成功");
				} else {
					addLog(timeTaskName+"（"+info[1]+"）失败");
				}
			}else if(info[0].equalsIgnoreCase("off")){
				logger.info("定时关机开始…………");
				//获取电源状态
				ExcuteResultVO vo = obj.sysPowerOff(MeetingAppConfig.CC_DEF_ID);
				if (vo.isSuccess()) {
					addLog(timeTaskName+"（"+info[1]+"）成功");
				} else {
					addLog(timeTaskName+"（"+info[1]+"）失败");
				}
			}
		}catch(Exception e){
			logger.error("FixedTimeTask	excuteTask	定时开关机异常："+e.getMessage());
			return  ;
		}
		logger.info("定时开关机结束…………");
		return  ;
	}
	
	
	/**
	 * 添加操作日志
	 * @param operatorContent
	 */
	private void addLog(String operatorContent){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 

			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_CYCLE);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			vLogVO.setOperatorContent(operatorContent);	
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			
		}
	}
}
