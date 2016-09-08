package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.cbf.log.CbfLogger;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.centerControl.CenterControlVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

public class LogUtil {
	private static Logger logger = CbfLogger.getLogger(LogUtil.class.getName());
	/**
	 * 添加操作日志
	 * @param operatorContent
	 */
	public static void addLogForOperate(String operatorContent){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}
			ServiceFactory.getLogService().add(vLogVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加日志公用方法（可开启可关闭）
	 * @param operatorContent日志内容
	 * @param userID用户ID（操作人的ID）
	 * @param userIP操作人IP
	 * @param logType日志类型
	 * @param level日志级别
	 * （lofType和level参考LogEnum.java；operatorContent和userID必填，否则拒绝插入日志）
	 */
	public static Boolean addLogForOperate(String operatorContent,String userID,String userIP,int logType,int level){
		logger.info("LogUtil	addLogForOperate		begin");
		if(operatorContent==null||"".equals(operatorContent) || userID==null||"".equals(userID)){
			logger.info("LogUtil	addLogForOperate		end ");
			return false;
		}
		try{
			//日志是否开启
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			baseInfoVO.setInfoName(BaseInfoEnum.IF_OPENLOG);
			ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if(baseInfoList!=null&&baseInfoList.size()>0){
				String if_openLog = baseInfoList.get(0).getInfoValue();
				if(BaseInfoEnum.IF_OPENLOG_TRUE.equals(if_openLog)){//开启日志则存入z_t_log表
					LogVO vLogVO = new LogVO();
					//公用
					vLogVO.setUserID(userID);
					vLogVO.setUserIP(userIP);
					vLogVO.setOperatorDate(new Timestamp(System.currentTimeMillis()));
					//传值
					if(logType == vLogVO.getLogType()){
						logType = LogEnum.TYPE_DEFAULT;
					}
					if(level == vLogVO.getLevel()){
						level = LogEnum.LEVEL_DeFAULT;
					}
					vLogVO.setLogType(logType);
					vLogVO.setLevel(level);
					vLogVO.setOperatorContent(operatorContent);	
					ServiceFactory.getLogService().add(vLogVO);
					logger.info("sysLog		insert		successful");
				}else{
					logger.info("sysLog		is		closed");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		logger.info("LogUtil	addLogForOperate		end");
		return true;
	}
	
	/**
	 * 根据meetingDetailId获取MeetingDetailVO，输出日志调用
	 * @param meetingDetailId
	 * @return
	 */
	public static MeetingDetailVO getMeetingDetailVO(String meetingDetailId){
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailVO.setMeetingDetailID(meetingDetailId);
		try {
			meetingDetailVO = ServiceFactory.getMeetingDetailService().query(meetingDetailVO, null).get(0);
		} catch (Exception e) {
			meetingDetailVO.setMeetingName("");
			e.printStackTrace();
		}
		return meetingDetailVO;
	}
	
	/**
	 * 根据ccIp，equimentNO，equipmentType获取设备所属会议室以及该设备名字
	 * @param ccIp
	 * @param equimentNO
	 * @param equipmentType
	 * @return
	 */
	public static String[] getMeetingRoomNameandEquimentName(String ccIp, String equimentNO, String equipmentType){
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setIp(ccIp);
		try {
			ArrayList<EquipmentVO> equVO = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if(equVO!=null&&equVO.size()>0){
				String[] str = new String[2];
				str[0] = equVO.get(0).getMeetingRoomVO().getMeetingRoomName();
				CenterControlVO ccVO = new CenterControlVO();
				ccVO.setCcIP(ccIp);
				ccVO.setCcNO(equimentNO);
				ccVO.setEquipmentType(equipmentType);
				ArrayList<CenterControlVO> ccList = ServiceFactory.getCenterControlService().query(ccVO, null);
				if(ccList!=null&&ccList.size()>0){
					str[1] = ccList.get(0).getEquipmentName();
					return str;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
