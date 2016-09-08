package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.project.webservices.pushtodo.PushToDoClient;
import com.zzst.action.project.webservices.pushtodo.impl.PushToDoClientImpl;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;
import com.zzst.service.meeting.apply.applyDetail.ApplyDetailService;

public class ApplyDetailUtil {
	private static Logger logger = CjfLogger.getLogger(ApplyDetailUtil.class.getName());
	
	/**
	 * 每一次申请，都向申请过程表里插入相应的信息
	 * @param flowType	当前申请表的申请类型
	 * @param departmentID	当前申请表的部门ID
	 * @param applyDetailID	当前申请表的信息ID
	 * @param security	当前申请表的安全,int~不需要跳过涉密则任意一个值
	 * * @param userID	申请人
	 */
	public static String addApplyDetailInfo(int flowType, String departmentID, String applyDetailID, int security, String userID){
		String checkUserIds = "";
		try {
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			ApplyFlowVO applyFlowVO = new ApplyFlowVO();
			List<ApplyFlownodeVO> afnList = new ArrayList<ApplyFlownodeVO>();
			List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
			applyFlowVO.setFlowType(flowType);
			applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
			applyFlownodeVO.setApplyFlowVO(applyFlowVO);
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null && afList.size()>0){
				applyFlownodeVO.setFlowID(afList.get(0).getFlowID());//防止一个表有多个流程
				afnList = ServiceFactory.getApplyFlownodeService().queryWithOthTab(applyFlownodeVO, null);//根据flowtype找到相应的流程VO
				if(afnList!=null && afnList.size()>0){
					//如果存在相应的流程，就可以流程过程表中的每一个节点添加这些流程
					ApplyDetailService adService = ServiceFactory.getApplyDetailService();
					ApplyDetailVO applyDetailVO = new ApplyDetailVO();
					applyDetailVO.setFlowID(afnList.get(0).getFlowID());//流程id
					applyDetailVO.setFlowType(flowType);//申请表的类型 这里写视频会议申请
					applyDetailVO.setApplyDetailID(applyDetailID);//申请表单的ID
					applyDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					
					//申请人这一个节点
					applyDetailVO.setUserID(userID);
					//applyDetailVO.setSuggestion("申请人");//初始节点不需要填写
					applyDetailVO.setStatus(-1);//审批状态--待审批
					applyDetailVO.setOrderNum(ApplyEnum.ORDERNUM_START);
					applyDetailVO.setSuggestion(afList.get(0).getDescription());//将流程的描述信息带入-申请人的suggestion中（反正此人的sugg为null）
					adService.add(applyDetailVO);
					Boolean flag = true;
					for(ApplyFlownodeVO vo:afnList){
						if(security==ApplyEnum.SECURITY_LEVEL1){//如果不涉密则可跳过
							if(vo.getCheckRule().contains(ApplyEnum.CHECKRULE_SECRET)){
								continue;
							}
						}
						if(ApplyEnum.CHECKTYPE_POST == vo.getCheckType()){//该部门的该岗位下是否存在人员
							String checkUserIDs = "";
							if(vo.getCheckRule().contains(ApplyEnum.CHECKRULE_SECRET)){//涉密岗位
								checkUserIDs = ApplyDetailUtil.getBroDeptId(departmentID, vo.getPostNO());
							}else{
								checkUserIDs = getCheckUsersByPost(departmentID, vo.getPostNO());//其他岗位
							}
							if(checkUserIDs!=null&&checkUserIDs.length()>0){
								applyDetailVO.setCheckUserIDs(checkUserIDs);//处理人ID的集合
								applyDetailVO.setUserID(null);
							}
						}else{
							applyDetailVO.setCheckUserIDs(","+vo.getUserID()+",");
							applyDetailVO.setUserID(null);
						}
						if(flag){
							applyDetailVO.setOrderNum(ApplyEnum.ORDERNUM_START+1);
							applyDetailVO.setStatus(ApplyEnum.STATUS_ING);//审批状态--审批中
							flag = false;
							checkUserIds = applyDetailVO.getCheckUserIDs().substring(1,applyDetailVO.getCheckUserIDs().length()-1);
						}else{
							applyDetailVO.setStatus(ApplyEnum.STATUS_VALID);//审批状态--待审批
						}
						applyDetailVO.setCheckType(vo.getCheckType());
						applyDetailVO.setFlownodeName(vo.getFlownodeName());
						applyDetailVO.setCreateTime(null);
						applyDetailVO.setOrderNum(vo.getOrderNum());
						applyDetailVO.setFlownodeID(vo.getFlownodeID());
						applyDetailVO.setSuggestion(null);//初始节点不需要填写
						adService.add(applyDetailVO);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkUserIds;
	}
	
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
	//添加代办事项,taskName,appSendUID,appReceiveUID,sendTime
	public static String addTask(String applyDetailID, Timestamp sendTimestamp, int flowType) {
		logger.info("ApplyDetailUtil	addTask		begin");
		PushToDoClient pushToDoClient = new PushToDoClientImpl();
		ApplyDetailVO applyDetailVO = new ApplyDetailVO();
		ArrayList<ApplyDetailVO> adList = new ArrayList<ApplyDetailVO>();
		ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
		
		String appID = ApplyEnum.ZH_appID;
		String taskName = "";
		String appTaskID = "";
		String taskType  = "";
		String appSendUID = "";
		String appReceiveUID = "";
		String sendTime = getFormatDate(sendTimestamp, "yyyy-MM-dd HH:mm:ss");
		String endTime = "";
		String url = "http://"+MeetingAppConfig.webservice_ip+MeetingAppConfig.CONTENT_PATH;
//		String url = "http://196.168.129.236:8080"+MeetingAppConfig.CONTENT_PATH;
		String taskDesc = "";
		String priorityID = ApplyEnum.ZH_priorityID;
		try {
			applyConferenceVO = ServiceFactory.getApplyConferenceService().queryByID(applyDetailID);
			applyDetailVO.setApplyDetailID(applyDetailID);
			applyDetailVO.setStatus(ApplyEnum.STATUS_ING);
			adList = ServiceFactory.getApplyDetailService().query(applyDetailVO, null);
			if(adList!=null&&adList.size()>0&&applyConferenceVO!=null){
				applyDetailVO = adList.get(0);
			}else{
				logger.error("ApplyDetailUtil	addTask	error: null");
				return null;
			}
			if(ApplyEnum.ZH_VIDEO_CONFERENCE == flowType){
				taskType = ApplyEnum.flowType()[flowType][1]; //"视频会议申请"
				appTaskID = applyDetailVO.getDetailID();
				taskName = applyConferenceVO.getConferenceName();
				taskDesc = taskName;
				appSendUID = applyConferenceVO.getLinkManID();
				appReceiveUID = applyDetailVO.getCheckUserIDs().substring(1,applyDetailVO.getCheckUserIDs().length()-1).replaceAll(",", ";");
//				url += "/apply/applyConference/applyDetail.action?applyConferenceVO.applyID="+applyDetailID+"&type=1";
				url += "/index3.jsp?formId="+applyDetailID+"&entryId=0";
				/**集团人员推送代办
				if(appReceiveUID.indexOf("16500005")<0&&appReceiveUID.indexOf("17300007")<0&&appReceiveUID.indexOf("17400005")<0&&appReceiveUID.indexOf("27401666")<0){
					return null;
				}
				*/
				logger.info("推送代办的appTaskID为"+appTaskID);
				logger.info("推送代办的appID为"+appID);
				logger.info("推送代办的待办事项名称为"+taskName);
//				logger.info("推送代办的服务器地址为"+MeetingAppConfig.zh_Task_address);
				logger.info("推送代办的url地址为"+url);
				String returnInfo = pushToDoClient.addTask(appID, taskName, appTaskID, taskType, appSendUID, appReceiveUID, sendTime, endTime, url, taskDesc, priorityID);
				logger.info("推送代办的返回值为:"+returnInfo);
			}
		} catch (Exception e) {
			logger.error("ApplyDetailUtil	addTask		error:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		logger.info("ApplyDetailUtil	addTask		end");
		return "OK";
	}
	
	/* 完成代办事项,将代办库中的记录移到历史记录表中
	 * @param appTaskID	                       应用系统中的待办事项唯一的ID
	 * @param appID 	                       应用系统编号,由待办事项系统管理员分配给各应用系统  (ICMP)
	 * @handleTime               代办事项的处理时间，为空则已受到的时间为处理时间
	 * 返回字符串 0 失败 1成功
	 */
	//完成代办事项,将代办库中的记录移到历史记录表中
	public static String completeTask(String appTaskID, Timestamp handleTimestamp) {
		logger.info("ApplyDetailUtil	completeTask		begin");
		PushToDoClient pushToDoClient = new PushToDoClientImpl();
		String appID = ApplyEnum.ZH_appID;
		String handleTime = getFormatDate(handleTimestamp, "yyyy-MM-dd HH:mm:ss");
//		TaskMgrControlLocator task = new TaskMgrControlLocator();
		try {
			logger.info("完成代办的appTaskID为"+appTaskID);
			logger.info("推送代办的appID为"+appID);
			String returnInfo = pushToDoClient.completeTask(appTaskID, appID, handleTime);
			logger.info("完成代办的返回值为:"+returnInfo);
//			task.getTaskMgrControlHttpPort().completeTask(UtilDAO.getUUid(), "appID", "handleTime");
		} catch (Exception e) {
			logger.error("ApplyDetailUtil	completeTask		error:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		logger.info("ApplyDetailUtil	completeTask		end");
		return "OK";
	}
	
	/**
	 * format date
	 * @param date
	 * @param dateFormat
	 */
	public static String getFormatDate(Date date, String dateFormat) {
		if (date == null || dateFormat == null || dateFormat.trim().equals("")) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	public static String getBroDeptId(String deptId, String postId){//获取兄弟部门的id
		DepartmentVO dVo = new DepartmentVO();
		DepartmentVO dVo_Bro = new DepartmentVO();
		List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
		String returnStr = "";
		
		dVo.setId(deptId);
		try {
			//当前 部门是否有该岗位下的人员
			returnStr = getCheckUsersByPost(deptId, postId);
			if(returnStr!=null&&!"".equals(returnStr)){
				return returnStr;
			}
			//兄弟部门是否有该岗位下的人员
			dList = ServiceFactory.getDepartmentService().query(dVo,null);
			if(dList!=null&&dList.size()>0){
				String isRootID = dList.get(0).getParentId();
				if(isRootID.indexOf("-")>-1 || isRootID==null || "".equals(isRootID)){//当前节点为根节点
					return returnStr;
				}
				dVo.setId(isRootID);//判断当前节点的父节点是否为跟节点,即二级节点
				dList = ServiceFactory.getDepartmentService().query(dVo, null);
				if(dList!=null&&dList.size()>0){
					isRootID = dList.get(0).getParentId();
					if(isRootID.indexOf("-")>-1 || isRootID==null || "".equals(isRootID)){
						return returnStr;
					}
				}
				dVo_Bro.setParentId(dList.get(0).getId());
				dList = ServiceFactory.getDepartmentService().query(dVo_Bro, null);
				if(dList!=null&&dList.size()>0){
					for(DepartmentVO vo:dList){
						returnStr = getCheckUsersByPost(vo.getId(), postId);
						if(returnStr!=null&&!"".equals(returnStr)){
							return returnStr;
						}
					}
				}
			}else{
				return returnStr;
			}
			//上级部门是否有该岗位下的人员
			getBroDeptId(dList.get(0).getParentId(), postId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}
	
	public static String getCheckUsersByPost(String deptId, String postId) throws Exception{
		UserVO userVO = new UserVO();
		List<UserVO> uList = new ArrayList<UserVO>();
		StringBuffer sb = new StringBuffer();
		
		userVO.getDepartmentVO().setId(deptId);
		userVO.getPostVO().setPostNO(postId);
		uList = ServiceFactory.getUserService().getUsersByDeptPost(userVO, null);
		if(uList!=null&&uList.size()>0){
			sb.append(",");//查询语句“like ’,param,‘”防止ID太短
			for(UserVO uVO:uList){
				sb.append(uVO.getUserID()+",");
			}
		}
		return sb.toString();//处理人ID的集合
	}
}
