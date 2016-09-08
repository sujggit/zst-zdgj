package com.zzst.action.meeting.meeting;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.task.MeetingEndTask;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.ApplyDetailUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.notice.SendMessageInstance;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.meeting.dwr.McuDwrMethod;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;


/**
 *@Description
 *@date 2011-11-30下午02:33:28
 *@author ryan    
 */
public class GeneralMeetingAction extends CjfAction{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(GeneralMeetingAction.class.getName());
	private DictionaryVO dictionaryVO;
	private ArrayList<DictionaryVO> dvList;
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
	private VideoconferenceVO meetingDetailVenueVO = new VideoconferenceVO();
	private ArrayList<MeetingDetailVO>  lst_conference = new ArrayList<MeetingDetailVO>();
	private VideoconferenceVO videoconferenceVO=new VideoconferenceVO();
	private ArrayList<MeetingDetailUserVO> listuser=new ArrayList<MeetingDetailUserVO>();
	private String redirectType;
	private int applyStatus;//1代表不需要审批，0代表需要审批，2没有流程节点。
	
	public ArrayList<MeetingDetailUserVO> getListuser() {
		return listuser;
	}

	public void setListuser(ArrayList<MeetingDetailUserVO> listuser) {
		this.listuser = listuser;
	}

	/**
	 * 跳转到本地会议预订页面
	 * @return
	 */
	public	String	generalAddBefor(){
		logger.info("GeneralMeetingAction	generalAddBefor		begin");
		//meetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()+Long.valueOf(MeetingAppConfig.meeting_space_time)*1000));
		//meetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis()+Long.valueOf(MeetingAppConfig.meeting_space_time+MeetingAppConfig.meeting_space_time)*1000));
		if(meetingDetailVO.getMeetingRoomID() != null){
			meetingDetailVO.setMeetingRoomNameIDs(meetingDetailVO.getMeetingRoomID());
		}
		if(meetingDetailVO.getMeetingRoomName() != null){
			meetingDetailVO.setMeetingRoomNames(meetingDetailVO.getMeetingRoomName());
		}
		
	
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEEITNG_TYPE);
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		try {
			ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			this.getServletRequest().setAttribute("baseInfoList", baseInfoList);
		
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);//短信
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("record", MeetingAppConfig.record_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			
			//判断是否配置流程’本地会议预约审批‘add by xiongshun 20131021 10:28
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			ApplyFlowVO applyFlowVO = new ApplyFlowVO();
			List<ApplyFlownodeVO> afnList = new ArrayList<ApplyFlownodeVO>();
			List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
			applyFlowVO.setFlowType(ApplyEnum.CONFERENCE_BOOK);//6;//视频会议预约
			applyFlowVO.setStatus(ApplyEnum.STATUS_USE);//0;		//流程启用
			applyFlownodeVO.setApplyFlowVO(applyFlowVO); //applyFlowVO 是 applyFlownodeVO 中的一个属性
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null && afList.size()>0){
				applyFlownodeVO.setFlowID(afList.get(0).getFlowID());//一个类型的申请表单若有多个流程，则默认取第一个
				afnList = ServiceFactory.getApplyFlownodeService().queryWithOthTab(applyFlownodeVO, null);//根据flowtype找到相应的流程VO
				if(afnList!=null&&afnList.size()>0){
					this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_USE);
				}else{
					this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_NOFLOWNODE);////流程启用，但是没有流程节点
				}
			}else{
				this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_STOPUSE);//停用
			}
		} catch (Exception e) {
			
		}
		logger.info("GeneralMeetingAction	generalAddBefor		end");
		return "SUCCESS";
	}

	/**
	 * 保存本地会议
	 * @return
	 */
	public	String	generalAdd(){
		logger.info("GeneralMeetingAction	generalAdd		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
				// if(meetingDetailVO.getConfDocAdminId()==null||"".equals(meetingDetailVO.getConfDocAdminId())){
				// meetingDetailVO.setConfDocAdminId(sessionUserVO.getUserID());
				// meetingDetailVO.setConfDocAdminName(sessionUserVO.getName());
				// }
			}
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();//存储参会人员，只有ID被赋值了
			ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();//存储会议室信息
			
			//add by ryan on 2012-05-10
			if(MeetingAppConfig.conference_approved_status)
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
			else
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			String[] userIDs = {};
			//参会人员
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				
				String[] names = {};
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				names  = meetingDetailVO.getParticipators().split(",");
				int userLength = userIDs.length;
				
				for(int i=0;i<userLength;i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(userIDs[i].trim());
					//modify by ryan on 2012-08-01 query email
					//ArrayList<UserVO> lis = ServiceFactory.getUserService().getUserList(userVO, null);
					//if(lis!=null&&lis.size()==1){
					//	userVO = lis.get(0);
					//}
					listUser.add(userVO);
				}
			}
			meetingDetailVO.setInfo2(""+userIDs.length);//参会人数
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				String[] roomIDs = {};
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				int userLength = roomIDs.length;
				
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					listRoom.add(venueVO);
				}
			}
			//add by yangyi 获取部门ids
			String depIds = ServletActionContext.getRequest().getParameter("depIds");
			
			//add by xiongshun on 2013-09-04
			//meetingDetailVO.setMeetingDetailID(UtilDAO.getUUid());
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_GENERAL);
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			if(applyStatus==ApplyEnum.STATUS_USE){//启用流程
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
				//ServiceFactory.getMeetingDetailService().addGeneralMeetingDetail(meetingDetailVO,listUser,listRoom,depIds);
				MeetingThread gAddThread = new MeetingThread(meetingDetailVO,listUser,listRoom,depIds,MeetingThread.GENERAL_ADD);
				Thread thread = new Thread(gAddThread);
				thread.start();
				ApplyDetailUtil.addApplyDetailInfo(ApplyEnum.CONFERENCE_BOOK, null, meetingDetailVO.getMeetingDetailID(), ApplyEnum.SECURITY_LEVEL1, sessionUserVO.getUserID());
				logger.info("GeneralMeetingAction	generalAdd		end");
				this.getServletRequest().setAttribute("failure_message", "本地会议预约的申请已经提交！");
				return "SUCCESS";
			}
			else if(applyStatus==ApplyEnum.STATUS_STOPUSE){//禁用流程，则直接预约成功
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);//插入z_t_meetingdetail表信息
				MeetingThread gAddThread = new MeetingThread(meetingDetailVO,listUser,listRoom,depIds,MeetingThread.GENERAL_ADD);//与会人员，会议室，部门
				Thread thread = new Thread(gAddThread);
				thread.start();
				//ServiceFactory.getMeetingDetailService().addGeneralMeetingDetail(meetingDetailVO,listUser,listRoom,depIds);
				
//				发送邮件及短信
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING , meetingDetailVO , listUser );
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();
				
				//add 20120113 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.meetingStartTask(meetingDetailVO);
				MeetingTaskOperate.meetingEndTask(meetingDetailVO);
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	generalAdd		error："+e.getMessage());
			this.getServletRequest().setAttribute("failure_message", "预定失败！");
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	generalAdd		end");
		this.getServletRequest().setAttribute("failure_message", "预定成功！");
		return "SUCCESS";
	}
	/**
	 * 
	 */
	public	String	queryUnExamConference(){
		logger.info("GeneralMeetingAction	queryUnExamConference		begin");
		try{
		
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
			
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailstatusList(meetingDetailVO, getPageControler());
			
		}catch(Exception e){
			logger.error("GeneralMeetingAction	queryUnExamConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	queryUnExamConference		end");
		return "SUCCESS";
	}
	/**
	 * 查询本地会议
	 * @return
	 */
	public	String	queryLocalConference(){
		logger.info("GeneralMeetingAction	queryLocalConference		begin");
		try{
			if( "deleteConference".equals(redirectType) || "modifyGeneralConference".equals(redirectType) || "modifyVideoConference".equals(redirectType) || "endMeeting".equals(redirectType)){
				meetingDetailVO = (MeetingDetailVO)this.getServletRequest().getSession().getAttribute("queryLocalConference");//从session取出查询条件
			}
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, getPageControler());
			//保存查询条件到session中
			this.getServletRequest().getSession().setAttribute("queryLocalConference", meetingDetailVO);
			
			//判断是否配置流程’视频会议预约审批‘add by xiongshun 20130905 18:22
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			ApplyFlowVO applyFlowVO = new ApplyFlowVO();
			List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
//			applyFlowVO.setFlowType(ApplyEnum.VIDEO_CONFERENCE);视频会议预约申请以及本地会议预约申请
			applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
			applyFlownodeVO.setApplyFlowVO(applyFlowVO);
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null && afList.size()>0){
				for(ApplyFlowVO afvo:afList){
					if(afvo.getFlowType()==ApplyEnum.VIDEO_CONFERENCE){
						this.getServletRequest().setAttribute("isApplyVideo",MeetingDetailEnum.TYPE_VEDIO);
					}else if(afvo.getFlowType()==ApplyEnum.CONFERENCE_BOOK){
						this.getServletRequest().setAttribute("isApplyGener",MeetingDetailEnum.TYPE_GENERAL);
					}
				}
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	queryLocalConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	queryLocalConference		end");
		return "SUCCESS";
	}
	/**
	 * 删除本地会议
	 * @return
	 */
	public String deleteConference(){
		logger.info("GeneralMeetingAction	deleteConference		begin");
		McuDwrMethod mdm=new McuDwrMethod();
		String ip=this.getCurHttpServletRequest().getRemoteHost();
		UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		
		try{
			String meetingDetailID = this.getParameter("meetingDetailID");
			String deleteType = this.getParameter("deleteType");
			MeetingDetailVO meetingDetailVO1 = new MeetingDetailVO();
			meetingDetailVO1.setMeetingDetailID(meetingDetailID);
			meetingDetailVO1 = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO1, null).get(0);
			String status = meetingDetailVO1.getStatus();
			meetingDetailVO1.setStatus(MeetingDetailEnum.STATUS_INVALID+"");  //11为无效
			ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO1);
			//add 20120113 删除定时器，会议删除的同时删除其对应的定时器
			MeetingTaskOperate.removeMeetingEndTask(meetingDetailID);
			
			if( "deleteMyConference".equals(deleteType)){
				mdm.addSysLog("删除会议 ="+meetingDetailVO1.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
				return "MYCONFERENCELIST";
			}
			meetingDetailVO = (MeetingDetailVO)this.getCurHttpServletRequest().getSession().getAttribute("queryLocalConference");
			redirectType = "deleteConference";//记录删除操作
			mdm.addSysLog("删除会议 ="+meetingDetailVO1.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
			
			//发送邮件及短信
			/*if(Integer.parseInt(status)==MeetingStatus.APPROVED){
				
			SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING , meetingDetailVO1);
			Thread sdMessageThread = new Thread(sdMessage);
			sdMessageThread.start();
			}*/
		}catch(Exception e){
			logger.error("GeneralMeetingAction	deleteConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	deleteConference	end");
		
		return "SUCCESS";
	}
	
	/**
	 * zjy
	 */
	public String mydeleteConference(){
		logger.info("GeneralMeetingAction	mydeleteConference		begin");
		String meetingDetailID="";
		McuDwrMethod mdm=new McuDwrMethod();
		String ip=this.getCurHttpServletRequest().getRemoteHost();
		UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		try{
			 meetingDetailID = this.getParameter("meetingDetailID");
			String deleteType = this.getParameter("deleteType");
			MeetingDetailVO meetingDetailVO1 = new MeetingDetailVO();
			meetingDetailVO1.setMeetingDetailID(meetingDetailID);
			meetingDetailVO1 = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO1, null).get(0);
			String status = meetingDetailVO1.getStatus();
			meetingDetailVO1.setStatus(MeetingDetailEnum.STATUS_INVALID+"");  //11为无效
			ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO1);
			//add 20120113 删除定时器，会议删除的同时删除其对应的定时器
			MeetingTaskOperate.removeMeetingEndTask(meetingDetailID);
			if( "deleteMyConference".equals(deleteType)){
				mdm.addSysLog("删除会议 ="+meetingDetailVO1.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
				return "MYCONFERENCELIST";
			}
			mdm.addSysLog("删除会议 ="+meetingDetailVO1.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
			meetingDetailVO = (MeetingDetailVO)this.getCurHttpServletRequest().getSession().getAttribute("queryLocalConference");
			redirectType = "deleteConference";//记录删除操作
			
			//发送邮件及短信
			if(Integer.parseInt(status)==MeetingStatus.APPROVED){
				
			SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING , meetingDetailVO1);
			Thread sdMessageThread = new Thread(sdMessage);
			sdMessageThread.start();
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	deleteConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		
		
		logger.info("GeneralMeetingAction	mydeleteConference	end");
		
		return "SUCCESS";
	}
	/**
	 * 查询待审批详情
	 * @return
	 */
	public String gentoExam()
	{
		logger.info("GeneralMeetingAction	gentoExam		begin");
		try{
			String meetingDetailId=this.getParameter("meetingDetailID").trim();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			if(listuser != null && listuser.size() > 0){
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailUserVO detailUser = null;
				for(int i=0; i< listuser.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailUser = listuser.get(i);
					if(detailUser != null){
						ids.append(detailUser.getUserID());
						names.append(detailUser.getUserName());
					}
				}
				meetingDetailVO.setParticipatorIDs(ids.toString());
				meetingDetailVO.setParticipators(names.toString());
			}
//			videoconferenceVO.setMeetingDetailID(meetingDetailId);
//			videoconferenceVO=ServiceFactory.getVideoconferenceService().getVideoconferenceList(videoconferenceVO, null).get(0);
		}catch(Exception e){
			logger.error("GeneralMeetingAction	gentoExam		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	gentoExam		end");
		return "SUCCESS";
	}
	/**
	 *  审批本地会议
	 *  @author zhangliang
	 *  @return
	 */
	public String examgen(){
		logger.info("GeneralMeetingAction	modifyConference		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getLoginName()!=null){
				meetingDetailVO.setExamby(sessionUserVO.getLoginName());
			}
			meetingDetailVO.setExamtime(new Timestamp(System.currentTimeMillis()));			
			
			
			ServiceFactory.getMeetingDetailService().examGeneralMeetingDetail(meetingDetailVO);
		
		
		}catch(Exception e){
			logger.error("GeneralMeetingAction	modifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	modifyConference		end");
		return "SUCCESS";
	}
	
	public String beforeModifyConference(){
		logger.info("GeneralMeetingAction	beforeModifyConference		begin");
		try{
			String meetingDetailId=this.getParameter("meetingDetailID").trim();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			
			//add by chenshuo 查询举办单位
			ArrayList<MeetingDetailDepartMentVO> listdpt =ServiceFactory.getMeetingDetailDepartMentService().queryByIDs(meetingDetailVO.getMeetingDetailID());
			if( listdpt != null && listdpt.size()>0){//举办单位
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailDepartMentVO detailDpt = null;
				
				for( int i=0; i<listdpt.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailDpt = listdpt.get(i);
					DepartmentVO dvo = DepartmentDAO.get(detailDpt.getDepartMentID());
					if(dvo != null){
						ids.append(dvo.getId());
						names.append(dvo.getTitle());
					}
				}
				meetingDetailVO.setDepartmentIDs(ids.toString());
				meetingDetailVO.setDepartmentNames(names.toString());
			}
			
			if(listuser != null && listuser.size() > 0){
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailUserVO detailUser = null;
				for(int i=0; i< listuser.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailUser = listuser.get(i);
					if(detailUser != null){
						ids.append(detailUser.getUserID());
						names.append(detailUser.getUserName());
					}
				}
				meetingDetailVO.setParticipatorIDs(ids.toString());
				meetingDetailVO.setParticipators(names.toString());
			}
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			if(meetingDetailVO.getNotifyType()!=null){//查看是否有提醒类型
				if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
					this.getServletRequest().setAttribute("meetingSms", true);
				}else{
					this.getServletRequest().setAttribute("meetingSms", false);
				}
				if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
					this.getServletRequest().setAttribute("meetingEmail", true);
				}else{
					this.getServletRequest().setAttribute("meetingEmail", false);
				}
				if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
					this.getServletRequest().setAttribute("meetingBillboard", true);
				}else{
					this.getServletRequest().setAttribute("meetingBillboard", false);
				}
			}
//			videoconferenceVO.setMeetingDetailID(meetingDetailId);
//			videoconferenceVO=ServiceFactory.getVideoconferenceService().getVideoconferenceList(videoconferenceVO, null).get(0);
		}catch(Exception e){
			logger.error("GeneralMeetingAction	beforeModifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	beforeModifyConference		end");
		return "SUCCESS";
	}
	
	
	public String mybeforeModifyConference(){
		logger.info("GeneralMeetingAction	mybeforeModifyConference		begin");
		String meetingDetailId="";
		try{
			meetingDetailId=this.getParameter("meetingDetailID").trim();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			
			//add by chenshuo 查询举办单位
			ArrayList<MeetingDetailDepartMentVO> listdpt =ServiceFactory.getMeetingDetailDepartMentService().queryByIDs(meetingDetailVO.getMeetingDetailID());
			if( listdpt != null && listdpt.size()>0){//举办单位
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailDepartMentVO detailDpt = null;
				
				for( int i=0; i<listdpt.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailDpt = listdpt.get(i);
					DepartmentVO dvo = DepartmentDAO.get(detailDpt.getDepartMentID());
					if(dvo != null){
						ids.append(dvo.getId());
						names.append(dvo.getTitle());
					}
				}
				meetingDetailVO.setDepartmentIDs(ids.toString());
				meetingDetailVO.setDepartmentNames(names.toString());
			}
			
			if(listuser != null && listuser.size() > 0){
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailUserVO detailUser = null;
				for(int i=0; i< listuser.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailUser = listuser.get(i);
					if(detailUser != null){
						ids.append(detailUser.getUserID());
						names.append(detailUser.getUserName());
					}
				}
				meetingDetailVO.setParticipatorIDs(ids.toString());
				meetingDetailVO.setParticipators(names.toString());
			}
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
				this.getServletRequest().setAttribute("meetingSms", true);
			}else{
				this.getServletRequest().setAttribute("meetingSms", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
				this.getServletRequest().setAttribute("meetingEmail", true);
			}else{
				this.getServletRequest().setAttribute("meetingEmail", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
				this.getServletRequest().setAttribute("meetingBillboard", true);
			}else{
				this.getServletRequest().setAttribute("meetingBillboard", false);
			}
//			videoconferenceVO.setMeetingDetailID(meetingDetailId);
//			videoconferenceVO=ServiceFactory.getVideoconferenceService().getVideoconferenceList(videoconferenceVO, null).get(0);
		}catch(Exception e){
			logger.error("GeneralMeetingAction	beforeModifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		
		McuDwrMethod mdm=new McuDwrMethod();
		try {
			String ip=this.getCurHttpServletRequest().getRemoteHost();
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			mdm.addSysLog("update会议 ID="+meetingDetailId, LogEnum.TYPE_DB,sessionUserVO,ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("GeneralMeetingAction	mybeforeModifyConference		end");
		return "SUCCESS";
	}
	
	/**
	 * 修改本地会议
	 * @return
	 */
	public String modifyConference(){
		logger.info("GeneralMeetingAction	modifyConference		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
				if(meetingDetailVO.getConfDocAdminId()==null||"".equals(meetingDetailVO.getConfDocAdminId())){
					meetingDetailVO.setConfDocAdminId(sessionUserVO.getUserID());
					meetingDetailVO.setConfDocAdminName(sessionUserVO.getName());
				}
			}
			
			/**add by ryan on 2012-05-10
			if(MeetingAppConfig.conference_approved_status)
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
			else
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			*/
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();
			ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();
			
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				String[] userIDs = {};
				String[] names = {};
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				names  = meetingDetailVO.getParticipators().split(",");
				int userLength = userIDs.length;
				for(int i=0;i<userLength;i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(userIDs[i].trim());
//					modify by ryan on 2012-08-01 query email
					/*ArrayList<UserVO> lis = ServiceFactory.getUserService().getUserList(userVO, null);
					if(lis!=null&&lis.size()==1){
						userVO = lis.get(0);
					}*/
					listUser.add(userVO);
				}
			}
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				String[] roomIDs = {};
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				int userLength = roomIDs.length;
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					listRoom.add(venueVO);
				}
			}

			//add by yangyi 获取部门ids
			String depIds = ServletActionContext.getRequest().getParameter("depIds");
			
			boolean isUpdate = false;
			String oldMeetingrooms = null;
			List<MeetingDetailVO> detailList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null);
			if(detailList!=null&&detailList.size()>0){
				MeetingDetailVO mdVO = detailList.get(0);
				oldMeetingrooms = mdVO.getMeetingRoomNameIDs();
				if(!(mdVO.getMeetingStartTime().toString()).equals(meetingDetailVO.getMeetingStartTime().toString())){
					isUpdate = true;
				}
			}
			
			List<UserVO> userList = new ArrayList<UserVO>();
			MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
			meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			List<MeetingDetailUserVO> meetingDetailUserList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			if(meetingDetailUserList!=null&&meetingDetailUserList.size()>0){
				for(MeetingDetailUserVO muVO : meetingDetailUserList){
					UserVO uVO = new UserVO();
					uVO.setUserID(muVO.getUserID());
					//uVO = ServiceFactory.getUserService().getUserInfo(uVO, null);
					//if(uVO!=null){
						userList.add(uVO);
					//}
				}
			}
			List<UserVO> userListNew = new ArrayList<UserVO>();
			List<UserVO> userListOld = new ArrayList<UserVO>();
			userListNew.addAll(listUser);
			for(int i=0;i< userListNew.size();i++){
				for(int j=0;j< userList.size();j++){
					if((userListNew.get(i).getUserID()).equals(userList.get(j).getUserID())){
						userListOld.add(userList.get(j));
						userList.remove(j);
						userListNew.remove(i);
						i--;
						break;
					}
				}
				
			}
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(meetingDetailVO, null);
			MeetingThread gModifyThread = new MeetingThread(meetingDetailVO,listUser,listRoom,depIds,MeetingThread.GENERAL_MODIFY);
			Thread thread = new Thread(gModifyThread);
			thread.start();
			//ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(meetingDetailVO,listUser,listRoom,depIds);
			if(!meetingDetailVO.getStatus().equals(MeetingDetailEnum.STATUS_APPROVED+"")){//状态不是待审批
				String newMeetingrooms = meetingDetailVO.getMeetingRoomNameIDs();
	//			发送邮件
				
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING , meetingDetailVO , userList , userListNew , userListOld ,  isUpdate,oldMeetingrooms,newMeetingrooms);
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();
				
				//add 20120113 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
				MeetingTaskOperate.meetingStartTask(meetingDetailVO);
				MeetingTaskOperate.meetingEndTask(meetingDetailVO);
				redirectType = "modifyGeneralConference";
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	modifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	modifyConference		end");
		return "SUCCESS";
	}
	
	
	/**
	 * 修改my本地会议
	 * @return
	 */
	public String mymodifyConference(){
		logger.info("GeneralMeetingAction	mymodifyConference		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
				if(meetingDetailVO.getConfDocAdminId()==null||"".equals(meetingDetailVO.getConfDocAdminId())){
					meetingDetailVO.setConfDocAdminId(sessionUserVO.getUserID());
					meetingDetailVO.setConfDocAdminName(sessionUserVO.getName());
				}
			}
			
			/**add by ryan on 2012-05-10
			if(MeetingAppConfig.conference_approved_status)
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
			else
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			*/
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();
			ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();
			
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				String[] userIDs = {};
				String[] names = {};
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				names  = meetingDetailVO.getParticipators().split(",");
				int userLength = userIDs.length;
				for(int i=0;i<userLength;i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(userIDs[i].trim());
//					modify by ryan on 2012-08-01 query email
					ArrayList<UserVO> lis = ServiceFactory.getUserService().getUserList(userVO, null);
					if(lis!=null&&lis.size()==1){
						userVO = lis.get(0);
					}
					listUser.add(userVO);
				}
			}
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				String[] roomIDs = {};
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				int userLength = roomIDs.length;
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					listRoom.add(venueVO);
				}
			}

			//add by yangyi 获取部门ids
			String depIds = ServletActionContext.getRequest().getParameter("depIds");
			
			boolean isUpdate = false;
			String oldMeetingrooms = null;
			List<MeetingDetailVO> detailList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null);
			if(detailList!=null&&detailList.size()>0){
				MeetingDetailVO mdVO = detailList.get(0);
				oldMeetingrooms = mdVO.getMeetingRoomNameIDs();
				if(!(mdVO.getMeetingStartTime().toString()).equals(meetingDetailVO.getMeetingStartTime().toString())){
					isUpdate = true;
				}
			}
			
			List<UserVO> userList = new ArrayList<UserVO>();
			MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
			meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			List<MeetingDetailUserVO> meetingDetailUserList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			if(meetingDetailUserList!=null&&meetingDetailUserList.size()>0){
				for(MeetingDetailUserVO muVO : meetingDetailUserList){
					UserVO uVO = new UserVO();
					uVO.setUserID(muVO.getUserID());
					uVO = ServiceFactory.getUserService().getUserInfo(uVO, null);
					if(uVO!=null){
						userList.add(uVO);
					}
				}
			}
			List<UserVO> userListNew = new ArrayList<UserVO>();
			List<UserVO> userListOld = new ArrayList<UserVO>();
			userListNew.addAll(listUser);
			for(int i=0;i< userListNew.size();i++){
				for(int j=0;j< userList.size();j++){
					if((userListNew.get(i).getUserID()).equals(userList.get(j).getUserID())){
						userListOld.add(userList.get(j));
						userList.remove(j);
						userListNew.remove(i);
						i--;
						break;
					}
				}
				
			}
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(meetingDetailVO, null);
			MeetingThread gModifyThread = new MeetingThread(meetingDetailVO,listUser,listRoom,depIds,MeetingThread.GENERAL_MODIFY);
			Thread thread = new Thread(gModifyThread);
			thread.start();
			//ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(meetingDetailVO,listUser,listRoom,depIds);
			
			if(!meetingDetailVO.getStatus().equals(MeetingDetailEnum.STATUS_APPROVED+"")){//状态不是待审批
				String newMeetingrooms = meetingDetailVO.getMeetingRoomNameIDs();
	//			发送邮件
				
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING , meetingDetailVO , userList , userListNew , userListOld ,  isUpdate,oldMeetingrooms,newMeetingrooms);
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();
				
				//add 20120113 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
				MeetingTaskOperate.meetingStartTask(meetingDetailVO);
				MeetingTaskOperate.meetingEndTask(meetingDetailVO);
				redirectType = "modifyGeneralConference";
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	mymodifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	mymodifyConference		end");
		return "SUCCESS";
	}
	
	/**
	 * 查询本地会议详细信息
	 * @return
	 */
	public String generalDetail(){
		logger.info("GeneralMeetingAction	generalDetail		begin");
		try{
			
			meetingDetailVO.setMeetingDetailID(this.getParameter("meetingDetailID").trim());
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO,null).get(0);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			//add by chenshuo 查询举办单位
			ArrayList<MeetingDetailDepartMentVO> listdpt =ServiceFactory.getMeetingDetailDepartMentService().queryByIDs(meetingDetailVO.getMeetingDetailID());
			if( listdpt != null && listdpt.size()>0){//举办单位
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailDepartMentVO detailDpt = null;
				
				for( int i=0; i<listdpt.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailDpt = listdpt.get(i);
					DepartmentVO dvo = DepartmentDAO.get(detailDpt.getDepartMentID());
					if(dvo != null){
						ids.append(dvo.getId());
						names.append(dvo.getTitle());
					}
				}
				meetingDetailVO.setDepartmentIDs(ids.toString());
				meetingDetailVO.setDepartmentNames(names.toString());
			}
			if(listuser != null && listuser.size() > 0){
				StringBuffer ids = new StringBuffer();
				StringBuffer names = new StringBuffer();
				MeetingDetailUserVO detailUser = null;
				for(int i=0; i< listuser.size(); i++){
					if(i != 0){
						ids.append(",");
						names.append(",");
					}
					detailUser = listuser.get(i);
					if(detailUser != null){
						ids.append(detailUser.getUserID());
						names.append(detailUser.getUserName());
					}
				}
				meetingDetailVO.setParticipatorIDs(ids.toString());
				meetingDetailVO.setParticipators(names.toString());
			}
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			if(meetingDetailVO.getNotifyType()==null||meetingDetailVO.getNotifyType()==""){
				this.getServletRequest().setAttribute("meetingSms", false);
				this.getServletRequest().setAttribute("meetingEmail", false);
				this.getServletRequest().setAttribute("meetingBillboard", false);
			}else{
			if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
				this.getServletRequest().setAttribute("meetingSms", true);
			}else{
				this.getServletRequest().setAttribute("meetingSms", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
				this.getServletRequest().setAttribute("meetingEmail", true);
			}else{
				this.getServletRequest().setAttribute("meetingEmail", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
				this.getServletRequest().setAttribute("meetingBillboard", true);
			}else{
				this.getServletRequest().setAttribute("meetingBillboard", false);
			}
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	generalDetail		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	generalDetail		end");
		return "SUCCESS";
	}
	
	/**
	 * 结束会议
	 * @return
	 */
	public String endMeeting(){
		MeetingDetailVO newMeetingDetailVO = new MeetingDetailVO();
		String meetingDetailID = meetingDetailVO.getMeetingDetailID();
		meetingDetailVO.setMeetingDetailID(null);
		McuDwrMethod mdm=new McuDwrMethod();
		String ip=this.getCurHttpServletRequest().getRemoteHost();
		UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		try {
			TransactionManager tManager = null;
			tManager = new TransactionManager();
			tManager.beginTransaction();
			MeetingDetailService meetingDetailService=new MeetingDetailServiceImpl();
			newMeetingDetailVO = new MeetingDetailVO();
			newMeetingDetailVO.setMeetingDetailID(meetingDetailID);
			ArrayList<MeetingDetailVO> meetingDetailVOList =  new ArrayList<MeetingDetailVO>();
		
			meetingDetailVOList = meetingDetailService.getMeetingDetailList(newMeetingDetailVO, null);
			if(meetingDetailVOList!= null && meetingDetailVOList.size()>0){
				newMeetingDetailVO = meetingDetailVOList.get(0);
				Calendar currentTime = Calendar.getInstance();
				newMeetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
				newMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_END+"");
				//修改会议结束时间
				mdm.addSysLog("提前结束会议："+newMeetingDetailVO.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
				meetingDetailService.modifyGeneralMeetingDetail(newMeetingDetailVO);
			}
			tManager.commit();
			ZZOMcuFactory.getInstance().getMcuControlHelper().deleteConf(newMeetingDetailVO.getMeetingDetailID());
			//取消会议定时器
			MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
			redirectType = "endMeeting";
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "FAILURE";
		}
	
		return "SUCCESS";
	}
	
	/**
	 * 结束my会议
	 * @return
	 */
	public String endMyMeeting(){
		MeetingDetailVO newMeetingDetailVO = new MeetingDetailVO();
		String meetingDetailID = meetingDetailVO.getMeetingDetailID();
		meetingDetailVO.setMeetingDetailID(null);
		
		///
		McuDwrMethod mdm=new McuDwrMethod();
		String ip=this.getCurHttpServletRequest().getRemoteHost();
		UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		
		try {
			TransactionManager tManager = null;
			tManager = new TransactionManager();
			tManager.beginTransaction();
			MeetingDetailService meetingDetailService=new MeetingDetailServiceImpl();
			newMeetingDetailVO = new MeetingDetailVO();
			newMeetingDetailVO.setMeetingDetailID(meetingDetailID);
			ArrayList<MeetingDetailVO> meetingDetailVOList =  new ArrayList<MeetingDetailVO>();
		
			meetingDetailVOList = meetingDetailService.getMeetingDetailList(newMeetingDetailVO, null);
			if(meetingDetailVOList!= null && meetingDetailVOList.size()>0){
				newMeetingDetailVO = meetingDetailVOList.get(0);
				Calendar currentTime = Calendar.getInstance();
				newMeetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
				newMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_END+"");
				//修改会议结束时间
				mdm.addSysLog("提前结束会议："+newMeetingDetailVO.getMeetingName(), LogEnum.TYPE_DB,sessionUserVO,ip);
				meetingDetailService.modifyGeneralMeetingDetail(newMeetingDetailVO);
			}
			tManager.commit();
			ZZOMcuFactory.getInstance().getMcuControlHelper().deleteConf(newMeetingDetailVO.getMeetingDetailID());
			//取消会议定时器
			MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
			redirectType = "endMeeting";
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "FAILURE";
		}
	
		return "SUCCESS";
	}
	
	/**
	 * addby chenshuo 
	 * 查询我的会议
	 * 2013-8-28增加预约人
	 * @return
	 */
	public	String	queryMyConference(){
		UserVO sessionUserVO = (UserVO) this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
	//	meetingDetailVO.SET
		meetingDetailUserVO.setUserID(sessionUserVO.getUserID());

		logger.info("GeneralMeetingAction	queryMyConference		begin");
		try{
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, getPageControler());
			//listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
			
			//判断是否配置流程’视频会议预约审批‘add by xiongshun 20130905 18:22
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			ApplyFlowVO applyFlowVO = new ApplyFlowVO();
			List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
//			applyFlowVO.setFlowType(ApplyEnum.VIDEO_CONFERENCE);视频会议预约申请以及本地会议预约申请
			applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
			applyFlownodeVO.setApplyFlowVO(applyFlowVO);
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null && afList.size()>0){
				for(ApplyFlowVO afvo:afList){
					if(afvo.getFlowType()==ApplyEnum.VIDEO_CONFERENCE){
						this.getServletRequest().setAttribute("isApplyVideo",MeetingDetailEnum.TYPE_VEDIO);
					}else if(afvo.getFlowType()==ApplyEnum.CONFERENCE_BOOK){
						this.getServletRequest().setAttribute("isApplyGener",MeetingDetailEnum.TYPE_GENERAL);
					}
				}
			}
		}catch(Exception e){
			logger.error("GeneralMeetingAction	queryMyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	queryMyConference		end");
		return "SUCCESS";
	}
	
	
	
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public MeetingDetailUserVO getMeetingDetailUserVO() {
		return meetingDetailUserVO;
	}

	public void setMeetingDetailUserVO(MeetingDetailUserVO meetingDetailUserVO) {
		this.meetingDetailUserVO = meetingDetailUserVO;
	}

	public VideoconferenceVO getMeetingDetailVenueVO() {
		return meetingDetailVenueVO;
	}

	public void setMeetingDetailVenueVO(VideoconferenceVO meetingDetailVenueVO) {
		this.meetingDetailVenueVO = meetingDetailVenueVO;
	}

	public ArrayList<MeetingDetailVO> getLst_conference() {
		return lst_conference;
	}

	public void setLst_conference(ArrayList<MeetingDetailVO> lst_conference) {
		this.lst_conference = lst_conference;
	}

	public VideoconferenceVO getVideoconferenceVO() {
		return videoconferenceVO;
	}

	public void setVideoconferenceVO(VideoconferenceVO videoconferenceVO) {
		this.videoconferenceVO = videoconferenceVO;
	}

	public String getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(String redirectType) {
		this.redirectType = redirectType;
	}

	public DictionaryVO getDictionaryVO() {
		return dictionaryVO;
	}

	public void setDictionaryVO(DictionaryVO dictionaryVO) {
		this.dictionaryVO = dictionaryVO;
	}

	public ArrayList<DictionaryVO> getDvList() {
		return dvList;
	}

	public void setDvList(ArrayList<DictionaryVO> dvList) {
		this.dvList = dvList;
	}

	public int getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}

}
