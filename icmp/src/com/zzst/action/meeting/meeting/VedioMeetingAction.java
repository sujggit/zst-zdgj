package com.zzst.action.meeting.meeting;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.ApplyDetailUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.notice.SendMessageInstance;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;


/**
 *@Description
 *@date 2011-12-7上午11:41:13
 *@author ryan  
 */
public class VedioMeetingAction  extends CjfAction {
 
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(VedioMeetingAction.class.getName());
	
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
	private VideoconferenceVO meetingDetailVenueVO = new VideoconferenceVO();
	private ArrayList<MeetingDetailVO>  lst_conference = new ArrayList<MeetingDetailVO>();
	private ArrayList<MeetingDetailUserVO> listuser=new ArrayList<MeetingDetailUserVO>();
	private int meetingRoomsLength;
	private String redirectType;
	private int applyStatus;//1代表不需要审批，0代表需要审批，2没有流程节点。
	
	public ArrayList<MeetingDetailUserVO> getListuser() {
		return listuser;
	}

	public void setListuser(ArrayList<MeetingDetailUserVO> listuser) {
		this.listuser = listuser;
	}

	/**
	 * 跳转到视频会议预订页面
	 * @return
	 */
	public	String	vedioAddBefor(){
		logger.info("VedioMeetingAction	vedioAddBefor		begin");
		//meetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()+Long.valueOf(MeetingAppConfig.meeting_space_time)*1000));
		//meetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis()+Long.valueOf(MeetingAppConfig.meeting_space_time+MeetingAppConfig.meeting_space_time)*1000));
		
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEEITNG_TYPE);
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		try {
			ArrayList<BaseInfoVO> baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			this.getServletRequest().setAttribute("baseInfoList", baseInfoList);
		
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("record", MeetingAppConfig.record_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			
			//判断是否配置流程’视频会议预约审批‘add by xiongshun 20130904 14:32
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			ApplyFlowVO applyFlowVO = new ApplyFlowVO();
			List<ApplyFlownodeVO> afnList = new ArrayList<ApplyFlownodeVO>();
			List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
			applyFlowVO.setFlowType(ApplyEnum.VIDEO_CONFERENCE);
			applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
			applyFlownodeVO.setApplyFlowVO(applyFlowVO); 
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null && afList.size()>0){
				applyFlownodeVO.setFlowID(afList.get(0).getFlowID());//一个类型的申请表单若有多个流程，则默认取第一个
				afnList = ServiceFactory.getApplyFlownodeService().queryWithOthTab(applyFlownodeVO, null);//根据flowtype找到相应的流程VO
				if(afnList!=null&&afnList.size()>0){
					this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_USE);
				}else{
					this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_NOFLOWNODE);
				}
			}else{
				this.getServletRequest().setAttribute("isApply",ApplyEnum.STATUS_STOPUSE);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("VedioMeetingAction	vedioAddBefor		end");
		return "SUCCESS";
	}

	/**
	 * 添加视频会议模板
	 * @return
	 */
	public String vedioTemplateAdd(){
		logger.info("VedioMeetingAction	vedioTemplateAdd		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
			}
			
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");//设置状态为模板标识
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();
			ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();
			String[] userIDs = {};
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
			}
			
			boolean isExisted = false;
			String[] roomIDs = {};
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				
			}
			
			MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
			MeetingThread addMeeting = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.ADD);
			Thread thread = new Thread(addMeeting);
			thread.start();
			
		}catch(Exception e){
			logger.error("VedioMeetingAction	vedioTemplateAdd		error："+e.getMessage());
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	vedioTemplateAdd		end");
		return "SUCCESS";
	}
	/**
	 * 保存视频会议
	 * @return
	 */
	public	String	vedioAdd(){
		logger.info("VedioMeetingAction	vedioAdd		begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
//				if(meetingDetailVO.getConfDocAdminId()==null||"".equals(meetingDetailVO.getConfDocAdminId())){
//					meetingDetailVO.setConfDocAdminId(sessionUserVO.getUserID());
//					meetingDetailVO.setConfDocAdminName(sessionUserVO.getName());
//				}
			}
			
			String[] userIDs = {};
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				
			
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				
			}
			meetingDetailVO.setInfo2(""+userIDs.length);
			
			String[] roomIDs = {};
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				
			}
			
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			
			//add by xiongshun on 2013-09-04
			//meetingDetailVO.setMeetingDetailID(UtilDAO.getUUid());
			if(applyStatus==ApplyEnum.STATUS_USE){//启用流程
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED+"");
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
				MeetingThread addMeeting = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.ADD);
				Thread thread = new Thread(addMeeting);
				thread.start();
				ApplyDetailUtil.addApplyDetailInfo(ApplyEnum.VIDEO_CONFERENCE, null, meetingDetailVO.getMeetingDetailID(), ApplyEnum.SECURITY_LEVEL1, sessionUserVO.getUserID());
				logger.info("VedioMeetingAction		vedioAdd		end");
				this.getServletRequest().setAttribute("failure_message", "视频会议预约的申请已经提交！");
				return "SUCCESS";
			}
			else if(applyStatus==ApplyEnum.STATUS_STOPUSE){//禁用流程，则直接预约成功
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");//审批通过状态设为审批通过(status=1)
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
				//使用线程存储参会人和会场
				MeetingThread addMeeting = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.ADD);
				Thread thread = new Thread(addMeeting);
				thread.start();
				MeetingDebugVO meetingDebugVO = new MeetingDebugVO();
				meetingDebugVO.setMeetingDetailId(meetingDetailVO.getMeetingDetailID());
				meetingDebugVO.setNoticeStatus(0);
				ServiceFactory.getMeetingDebugService().add(meetingDebugVO);
				//			发送邮件及短信
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				List<UserVO> userList = new ArrayList<UserVO>();
				for(int i=0;i<userIDs.length;i++){
					UserVO uVO = new UserVO();
					uVO.setUserID(userIDs[i]);
					userList.add(uVO);
				}
				SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING , meetingDetailVO , userList );
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();
				//add 20120416 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.meetingStartTask(meetingDetailVO);
				//MeetingTaskOperate.meetingEndTask(meetingDetailVO);
			}
		}catch(Exception e){
			logger.error("VedioMeetingAction	vedioAdd		error："+e.getMessage());
			this.getServletRequest().setAttribute("failure_message", "预定失败！");
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	vedioAdd		end");
		this.getServletRequest().setAttribute("failure_message", "预定成功！");
		return "SUCCESS";
	}
	
	/**
	 * 查询待审批详情
	 * @return
	 */
	public String videotobeExam()
	{
		logger.info("VedioMeetingAction	videotobeExam		begin");
		try{
			String meetingDetailId=this.getParameter("meetingDetailID").trim();
			//String meetingDetailId=meetingDetailVO.getMeetingDetailID();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			MeetingDetailUserVO meetingDetailUserVOs=new MeetingDetailUserVO();
			meetingDetailUserVOs.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVOs, null);
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
		}catch(Exception e){
			logger.error("VedioMeetingAction	videotobeExam		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	videotobeExam		end");
		return "SUCCESS";
	}
	
	public String beforeModifyConference(){
		logger.info("VedioMeetingAction	beforeModifyConference		begin");
		try{
			String meetingDetailId=this.getParameter("meetingDetailID").trim();
			//String meetingDetailId=meetingDetailVO.getMeetingDetailID();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			MeetingDetailUserVO meetingDetailUserVOs=new MeetingDetailUserVO();
			meetingDetailUserVOs.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVOs, null);
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
			this.getServletRequest().setAttribute("record", MeetingAppConfig.record_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			if(meetingDetailVO.getNotifyType()!=null&&meetingDetailVO.getNotifyType().charAt(0)=='1'){
				this.getServletRequest().setAttribute("meetingSms", true);
			}else{
				this.getServletRequest().setAttribute("meetingSms", false);
			}
			if(meetingDetailVO.getNotifyType()!=null&&meetingDetailVO.getNotifyType().charAt(1)=='1'){
				this.getServletRequest().setAttribute("meetingEmail", true);
			}else{
				this.getServletRequest().setAttribute("meetingEmail", false);
			}
			if(meetingDetailVO.getNotifyType()!=null&&meetingDetailVO.getNotifyType().charAt(2)=='1'){
				this.getServletRequest().setAttribute("meetingBillboard", true);
			}else{
				this.getServletRequest().setAttribute("meetingBillboard", false);
			}
		}catch(Exception e){
			logger.error("VedioMeetingAction	beforeModifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	beforeModifyConference		end");
		return "SUCCESS";
	}
	
	public String mybeforeModifyConference(){
		logger.info("VedioMeetingAction	beforeModifyConference		begin");
		try{
			String meetingDetailId=this.getParameter("meetingDetailID").trim();
			//String meetingDetailId=meetingDetailVO.getMeetingDetailID();
			meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			MeetingDetailUserVO meetingDetailUserVOs=new MeetingDetailUserVO();
			meetingDetailUserVOs.setMeetingDetailID(meetingDetailId);
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVOs, null);
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
			this.getServletRequest().setAttribute("record", MeetingAppConfig.record_status);
			this.getServletRequest().setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.getServletRequest().setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
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
		}catch(Exception e){
			logger.error("VedioMeetingAction	beforeModifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	beforeModifyConference		end");
		return "SUCCESS";
	}
	/**
	 * 修改视频会议
	 * @return
	 */
	public String modifyConference(){
		logger.info("VedioMeetingAction	modifyConference		begin");
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
			
			
			//ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();
			String[] userIDs = {};
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				/*int userLength = userIDs.length;
				for(int i=0;i<userLength;i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(userIDs[i].trim());
//					modify by ryan on 2012-08-01 query email
					ArrayList<UserVO> lis = ServiceFactory.getUserService().getUserList(userVO, null);
					if(lis!=null&&lis.size()==1){
						userVO = lis.get(0);
					}
					listUser.add(userVO);
				}*/
			}
			
			//boolean isExisted = false;
			String[] roomIDs = {};
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				/*int userLength = roomIDs.length;
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					if(meetingDetailVO.getMeetingRoomID() != null && meetingDetailVO.getMeetingRoomID().equals(roomIDs[i])){
						venueVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
						isExisted = true;
					}else{
						venueVO.setIsmain(VideoconferenceEnum.mainVenue_invalid);
					}
					listRoom.add(venueVO);
				}*/
			}

			/*if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
				VideoconferenceVO venueVO = new VideoconferenceVO();
				venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
				venueVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
				listRoom.add(venueVO);
			}*/
			
			boolean isUpdate = false;
			String oldMeetingroomIds =null;
			MeetingDetailVO mVO = new MeetingDetailVO();
			mVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			List<MeetingDetailVO> detailList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(mVO, null);
			if(detailList!=null&&detailList.size()>0){
				MeetingDetailVO mdVO = detailList.get(0);
				oldMeetingroomIds = mdVO.getMeetingRoomNameIDs();
				
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
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();
			List<UserVO> userListNew = new ArrayList<UserVO>();
			List<UserVO> userListOld = new ArrayList<UserVO>();
			for(int i=0;i<userIDs.length;i++){
				UserVO uVO = new UserVO();
				uVO.setUserID(userIDs[i]);
				listUser.add(uVO);
			}
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
			String newMeetingroomIds = meetingDetailVO.getMeetingRoomNameIDs();
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			
			MeetingThread modifyThread = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.MODIFY);
			Thread thread = new Thread(modifyThread);
			thread.start();
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(meetingDetailVO, null);
			//ServiceFactory.getMeetingDetailService().modifyVedioMeetingDetail(meetingDetailVO,userIDs,roomIDs);
			
			if(!meetingDetailVO.getStatus().equals(MeetingDetailEnum.STATUS_APPROVED+"")){//状态不是待审批
//				发送邮件
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				/*SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING , meetingDetailVO , userList , userListNew , userListOld ,  isUpdate,oldMeetingroomIds,newMeetingroomIds);
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();*/
			
			
			//add 20120416 增加定时器，以便会议状态的定时修改
			MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
			MeetingTaskOperate.meetingStartTask(meetingDetailVO);
			//MeetingTaskOperate.meetingEndTask(meetingDetailVO);
			redirectType = "modifyVideoConference";//记录删除操作
		
//			ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(meetingDetailVO);
			}
		}catch(Exception e){
			logger.error("VedioMeetingAction	modifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	modifyConference		end");
		return "SUCCESS";
	}
	
	
	public String mymodifyConference(){
		logger.info("VedioMeetingAction	mymodifyConference		begin");
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
			
			
			//ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();
			String[] userIDs = {};
			if(null!=meetingDetailVO.getParticipatorIDs()&&!meetingDetailVO.getParticipatorIDs().trim().equals("")){
				
				userIDs = meetingDetailVO.getParticipatorIDs().split(",");
				/*int userLength = userIDs.length;
				for(int i=0;i<userLength;i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(userIDs[i].trim());
//					modify by ryan on 2012-08-01 query email
					ArrayList<UserVO> lis = ServiceFactory.getUserService().getUserList(userVO, null);
					if(lis!=null&&lis.size()==1){
						userVO = lis.get(0);
					}
					listUser.add(userVO);
				}*/
			}
			
			//boolean isExisted = false;
			String[] roomIDs = {};
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				/*int userLength = roomIDs.length;
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					if(meetingDetailVO.getMeetingRoomID() != null && meetingDetailVO.getMeetingRoomID().equals(roomIDs[i])){
						venueVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
						isExisted = true;
					}else{
						venueVO.setIsmain(VideoconferenceEnum.mainVenue_invalid);
					}
					listRoom.add(venueVO);
				}*/
			}

			/*if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
				VideoconferenceVO venueVO = new VideoconferenceVO();
				venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
				venueVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
				listRoom.add(venueVO);
			}*/
			
			boolean isUpdate = false;
			String oldMeetingroomIds =null;
			MeetingDetailVO mVO = new MeetingDetailVO();
			mVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			List<MeetingDetailVO> detailList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(mVO, null);
			if(detailList!=null&&detailList.size()>0){
				MeetingDetailVO mdVO = detailList.get(0);
				oldMeetingroomIds = mdVO.getMeetingRoomNameIDs();
				
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
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();
			List<UserVO> userListNew = new ArrayList<UserVO>();
			List<UserVO> userListOld = new ArrayList<UserVO>();
			for(int i=0;i<userIDs.length;i++){
				UserVO uVO = new UserVO();
				uVO.setUserID(userIDs[i]);
				listUser.add(uVO);
			}
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
			String newMeetingroomIds = meetingDetailVO.getMeetingRoomNameIDs();
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			
			MeetingThread modifyThread = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.MODIFY);
			Thread thread = new Thread(modifyThread);
			thread.start();
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(meetingDetailVO, null);
			//ServiceFactory.getMeetingDetailService().modifyVedioMeetingDetail(meetingDetailVO,userIDs,roomIDs);
			
			if(!meetingDetailVO.getStatus().equals(MeetingDetailEnum.STATUS_APPROVED+"")){//状态不是待审批
	//			发送邮件
				//InformationHelper.sendInfo(listUser,meetingDetailVO);
				SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING , meetingDetailVO , userList , userListNew , userListOld ,  isUpdate,oldMeetingroomIds,newMeetingroomIds);
				Thread sdMessageThread = new Thread(sdMessage);
				sdMessageThread.start();
				
				//add 20120416 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.removeMeetingEndTask(meetingDetailVO.getMeetingDetailID());
				MeetingTaskOperate.meetingStartTask(meetingDetailVO);
				//MeetingTaskOperate.meetingEndTask(meetingDetailVO);
				redirectType = "modifyVideoConference";//记录删除操作
			
	//			ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(meetingDetailVO);
			}
		}catch(Exception e){
			logger.error("VedioMeetingAction	mymodifyConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	mymodifyConference		end");
		return "SUCCESS";
	}
	/**
	 * 查询视频会议详细信息
	 * @return
	 */
	public String vedioDetail(){
		logger.info("VedioMeetingAction	vedioDetail		begin");
		try{
			meetingDetailVO.setMeetingDetailID(this.getParameter("meetingDetailID").trim());
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO,null).get(0);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			listuser=ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
	
			if( meetingDetailVO.getMeetingRoomNames() != null){
				meetingDetailVO.setMeetingRoomNamesTrim(meetingDetailVO.getMeetingRoomNames());//会场过长时 用于页面显示的两个会场
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
				meetingDetailVO.setMeetingUserNamesTrim(names.toString());
			}
			this.getServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
			this.getServletRequest().setAttribute("record", MeetingAppConfig.record_status);
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
			logger.error("VedioMeetingAction	vedioDetail		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("VedioMeetingAction	vedioDetail		end");
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

	public int getMeetingRoomsLength() {
		return meetingRoomsLength;
	}

	public void setMeetingRoomsLength(int meetingRoomsLength) {
		this.meetingRoomsLength = meetingRoomsLength;
	}

	public String getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(String redirectType) {
		this.redirectType = redirectType;
	}

	public int getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}

}