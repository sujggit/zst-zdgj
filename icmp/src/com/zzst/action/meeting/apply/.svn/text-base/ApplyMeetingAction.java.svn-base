package com.zzst.action.meeting.apply;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.gsiec.model.portal.session.UserSessionVO;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.notice.SendMessageInstance;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

public class ApplyMeetingAction extends BaseAction{

	private static Logger logger = CbfLogger.getLogger(ApplyMeetingAction.class.getName());
	
	private List<ApplyDetailVO> applyDetailList = new ArrayList<ApplyDetailVO>();
	private ApplyDetailVO applyDetailVO = new ApplyDetailVO();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private List<MeetingDetailVO> lst_conference = new ArrayList<MeetingDetailVO>();
	private ArrayList<MeetingDetailUserVO> listuser=new ArrayList<MeetingDetailUserVO>();
	
	/**
	 * list MeetingFile;会议资料管理页面~会议级别
	 * @return
	 */
	public String manageMeetingApply(){
		logger.info("ApplyMeetingAction		manageMeetingApply		begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			//当查询条件为”请选择“时的第一次处理
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			//通过该人的userID关联节点人员表和流程节点 2.按视频会议申请流程查询
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailApplyList(meetingDetailVO,loginUser, pSplittor.getPControler());
			//会议管理的取会议列表方法，很慢，故而重新写一个20130809
			//lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, pSplittor.getPControler());
			//当查询条件为”请选择“时的第二次处理
			if("".equals(meetingDetailVO.getStatus())){
				meetingDetailVO.setStatus("-2147483648");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("ApplyMeetingAction	manageMeetingApply		end");
		return REQUEST_SUCCESS;
	}
	
	public String meetingApplyDetail(){
		logger.info("ApplyMeetingAction		meetingApplyDetail		begin");
		try{
			//String meetingDetailId = this.request.getParameter("meetingDetailID").trim();
			//String meetingDetailId=meetingDetailVO.getMeetingDetailID();
			//meetingDetailVO.setMeetingDetailID(meetingDetailId);
			meetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null).get(0);
			MeetingDetailUserVO meetingDetailUserVOs=new MeetingDetailUserVO();
			meetingDetailUserVOs.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
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
			this.request.setAttribute("sms", MeetingAppConfig.sms_status);
			this.request.setAttribute("email", MeetingAppConfig.mail_status);
			this.request.setAttribute("record", MeetingAppConfig.record_status);
			this.request.setAttribute("billboard", MeetingAppConfig.billboard_status);
			this.request.setAttribute("meetingservice", MeetingAppConfig.meetingservice_status);
			if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
				this.request.setAttribute("meetingSms", true);
			}else{
				this.request.setAttribute("meetingSms", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
				this.request.setAttribute("meetingEmail", true);
			}else{
				this.request.setAttribute("meetingEmail", false);
			}
			if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
				this.request.setAttribute("meetingBillboard", true);
			}else{
				this.request.setAttribute("meetingBillboard", false);
			}
			
			String type = request.getParameter("type");
			if(type.equals("1")){
				applyDetailVO.setStatus(ApplyEnum.STATUS_ING);
			}else{
				applyDetailVO.setStatus(ApplyEnum.STATUS_VALID);
			}
			ApplyDetailVO adVO = new ApplyDetailVO();
			adVO.setApplyDetailID(meetingDetailVO.getMeetingDetailID());
			applyDetailList = ServiceFactory.getApplyDetailService().query(adVO, null);
			for(ApplyDetailVO vo:applyDetailList){
				String desc = "none";
				if(vo.getUserID()!=null){
					UserVO uvo = new UserVO();
					UserVO uvo1 = new UserVO();
					uvo.setUserID(vo.getUserID());
					uvo1 = ServiceFactory.getUserService().getUserInfo(uvo, null);
					if(uvo1!=null){
						desc = uvo1.getName();
					}
				}
				vo.setUserID(desc);//userID借用显示处理人，如果尚未处理则显示”none“
			}
			this.request.setAttribute("isApply",true);
			if(meetingDetailVO.getMeetingType()==MeetingDetailEnum.TYPE_GENERAL){
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
				logger.info("ApplyMeetingAction		meetingApplyDetail		end");
				return "generalConference";
			}
		}catch(Exception e){
			logger.error("ApplyMeetingAction	meetingApplyDetail		error："+e.getMessage()+"/");
			e.printStackTrace();
		}
		logger.info("ApplyMeetingAction		meetingApplyDetail		end");
		return REQUEST_SUCCESS;
	}

	/**
	 * 预约审批
	 * @return
	 */
	public String meetingApplyApprove(){
		logger.info("ApplyMeetingAction		meetingApplyApprove		start");
		try{
			ApplyDetailVO applyDetailVOTemp = new ApplyDetailVO();
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);
			applyDetailVOTemp.setApplyDetailID(meetingDetailVO.getMeetingDetailID());
			applyDetailVOTemp.setStatus(ApplyEnum.STATUS_ING);
			applyDetailList = ServiceFactory.getApplyDetailService().query(applyDetailVOTemp, null);
			applyDetailVO.setDetailID(applyDetailList.get(0).getDetailID());
			applyDetailVO.setUserID(loginUser.getUserID());
			if(applyDetailVO.getStatus()==ApplyEnum.STATUS_INVALID){//同意
				if(applyDetailVO.getSuggestion()!=null&&applyDetailVO.getSuggestion().trim().length()>0){
					applyDetailVO.setSuggestion("同意，"+applyDetailVO.getSuggestion());
				}else{
					applyDetailVO.setSuggestion("同意");
				}
				if(applyDetailList.get(0).getOrderNum()==ApplyEnum.ORDERNUM_END){
					meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");//审批通过状态设为审批通过(status=1)
					ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO);
					
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
							userVO.setName(names[i].trim());
							listUser.add(userVO);
						}
					}
					
					boolean isExisted = false;
					if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
						String[] roomIDs = {};
						roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
						int userLength = roomIDs.length;
						for(int i=0;i<userLength;i++){
							VideoconferenceVO venueVO = new VideoconferenceVO();
							venueVO.setSubmeetingRoomID(roomIDs[i]);
							if(meetingDetailVO.getMeetingRoomID() != null && meetingDetailVO.getMeetingRoomID().equals(roomIDs[i])){
								venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
								isExisted = true;
							}else{
								venueVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
							}
							listRoom.add(venueVO);
						}
						
					}
					if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
						VideoconferenceVO venueVO = new VideoconferenceVO();
						venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						listRoom.add(venueVO);
					}
					if(meetingDetailVO.getMeetingType()==MeetingDetailEnum.TYPE_VEDIO){
						MeetingDebugVO meetingDebugVO = new MeetingDebugVO();
						meetingDebugVO.setMeetingDetailId(meetingDetailVO.getMeetingDetailID());
						meetingDebugVO.setNoticeStatus(0);
						ServiceFactory.getMeetingDebugService().add(meetingDebugVO);
					}
					//			发送邮件及短信
					//InformationHelper.sendInfo(listUser,meetingDetailVO);
					SendMessageInstance sdMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING , meetingDetailVO , listUser );
					Thread sdMessageThread = new Thread(sdMessage);
					sdMessageThread.start();
					//add 20120416 增加定时器，以便会议状态的定时修改
					MeetingTaskOperate.meetingStartTask(meetingDetailVO);
					if(meetingDetailVO.getMeetingType()==MeetingDetailEnum.TYPE_GENERAL){
						MeetingTaskOperate.meetingEndTask(meetingDetailVO);
					}
					//MeetingTaskOperate.meetingEndTask(meetingDetailVO);
				}else{
					ApplyDetailVO applyDetailVOTemp2 = new ApplyDetailVO();
					applyDetailVOTemp2.setApplyDetailID(meetingDetailVO.getMeetingDetailID());
					applyDetailVOTemp2.setStatus(ApplyEnum.STATUS_VALID);
					String detailID = ServiceFactory.getApplyDetailService().query(applyDetailVOTemp2, null).get(0).getDetailID();
					applyDetailVOTemp2.setDetailID(detailID);
					applyDetailVOTemp2.setStatus(ApplyEnum.STATUS_ING);
					ServiceFactory.getApplyDetailService().modify(applyDetailVOTemp2);
					meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPLYING+"");;//审批中(status=13)
					ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO);
				}
				applyDetailVO.setStatus(ApplyEnum.STATUS_INVALID);
			}else if(applyDetailVO.getStatus()==ApplyEnum.STATUS_REJECT){
				if(applyDetailVO.getSuggestion()!=null&&applyDetailVO.getSuggestion().trim().length()>0){
					applyDetailVO.setSuggestion("不同意，"+applyDetailVO.getSuggestion());
				}else{
					applyDetailVO.setSuggestion("不同意");
				}
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_NOAPPROVED+"");;//审批不通过状态设为审批不通过(status=14)
				ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO);
				applyDetailVO.setStatus(ApplyEnum.STATUS_REJECT);
			}
			applyDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			ServiceFactory.getApplyDetailService().modify(applyDetailVO);
		}catch(Exception e){
			logger.error("ApplyMeetingAction	meetingApplyApprove		error:"+e.getMessage());
		}
		logger.info("ApplyMeetingAction		meetingApplyApprove		end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 撤销申请 申请人和管理员都可以撤销申请，以释放会议室资源
	 * @return
	 */
	public String meetingApplyDel(){
		logger.info("ApplyMeetingAction	meetingApplyDel		begin");
		try{
			ApplyDetailVO adVO = new ApplyDetailVO(); 
			adVO.setApplyDetailID(meetingDetailVO.getMeetingDetailID());
			ArrayList<ApplyDetailVO> detatils = ServiceFactory.getApplyDetailService().query(adVO, null);
			if(detatils!=null&&detatils.size()>0){
				for(ApplyDetailVO deteVO:detatils){
					deteVO.setStatus(ApplyEnum.STATUS_REVOKE);
					ServiceFactory.getApplyDetailService().modify(deteVO);
				}
			}
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVEDREVOKE+"");
			ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO);
		}catch(Exception e){
			logger.error("ApplyMeetingAction	meetingApplyDel	error:"+e.getMessage());
		}
		logger.info("ApplyMeetingAction	meetingApplyDel		end");
		this.request.setAttribute("failure_message","撤销审批成功！");
		return REQUEST_SUCCESS;//跳转到提示页面
	}
	
	public List<ApplyDetailVO> getApplyDetailList() {
		return applyDetailList;
	}

	public void setApplyDetailList(List<ApplyDetailVO> applyDetailList) {
		this.applyDetailList = applyDetailList;
	}

	public ApplyDetailVO getApplyDetailVO() {
		return applyDetailVO;
	}

	public void setApplyDetailVO(ApplyDetailVO applyDetailVO) {
		this.applyDetailVO = applyDetailVO;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public List<MeetingDetailVO> getLst_conference() {
		return lst_conference;
	}

	public void setLst_conference(List<MeetingDetailVO> lstConference) {
		lst_conference = lstConference;
	}
	
	public ArrayList<MeetingDetailUserVO> getListuser() {
		return listuser;
	}

	public void setListuser(ArrayList<MeetingDetailUserVO> listuser) {
		this.listuser = listuser;
	}
}
