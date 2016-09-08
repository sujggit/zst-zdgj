package com.zzst.action.meeting.meeting;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.model.portal.session.UserSessionVO;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.notice.SendMessageInstance;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.meeting.dwr.McuDwrMethod;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meeting.MeetingVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingTemplate.MeetingTemplateVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.address.AddressServiceImpl;
import com.zzst.service.meeting.meeting.MeetingService;
import com.zzst.service.meeting.meeting.MeetingServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;
import com.zzst.service.meeting.videoconference.VideoconferenceService;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;
/**
 * 
 * The class <code>UserAction</code><br><br>
 * $log$<br><br>
 * @author $Author: devdelta $
 * @version $Revision: 1.1$ $Date: 2006/12/07 01:31:51 $
 * @see
 */
public class MeetingAction extends CjfAction{
//	public String "FAILURE" = "FAILURE";
//	public String "SUCCESS" = "SUCCESS";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(MeetingAction.class.getName());

	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private MeetingVO meetingVO = new MeetingVO();
	private MeetingTemplateVO meetingTemplateVO;
	private Integer vTime;
	private List<MeetingDetailVO> meetingDetailVOList = new ArrayList<MeetingDetailVO>();
	private int type ;//建会模式 1-子MCU上模板为演讲者模板 2-子MCU上模板为无模式模板(默认)
	private InputStream  excelStream;
	
	public String beforeAddVideoMeeting(){
		logger.info("MeetingAction	beforeAdmin addMeeting begin");
		try {
			//为页面会议开始结束时间设置初始值
			Calendar currentTime = Calendar.getInstance();
			int minutes = currentTime.get(Calendar.MINUTE);
			if(minutes < 30){
				currentTime.set(Calendar.MINUTE, 30);
			}else{
				currentTime.add(Calendar.HOUR_OF_DAY, 1);
				currentTime.set(Calendar.MINUTE, 0);
			}
			meetingDetailVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
			currentTime.add(Calendar.HOUR_OF_DAY, 1);
			meetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
			
			//获取所有视频会议室
			prepareMeetingRoomTree(new UserVO());
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加视频会议错误！");
			logger.error(e.getMessage());
			return "FAILURE";
		}

		logger.info("MeetingAction	beforeAdmin addMeeting	end");
		return "SUCCESS";
	}
 
	/**
	 * get meeting room tree's list data
	 * 
	 * @author wangle
	 * @since Aug 25, 2009
	 */
	public void prepareMeetingRoomTree(UserVO suv){
		logger.info("MeetingAction		prepareMeetingRoomTree	begin");
		try {
			
			ArrayList<AddressVO> alist = new ArrayList<AddressVO>();					
//			ArrayList<MeetingRoomVO> meetingRoomVOList =  new ArrayList<MeetingRoomVO>();		
//			//
//			ArrayList<MeetingRoomVO> treelist = new ArrayList<MeetingRoomVO>();
			
			Map<String,ArrayList<MeetingRoomVO>> amap = new HashMap<String,ArrayList<MeetingRoomVO>>();
			Map<String,EquipmentVO> amequip = new HashMap<String,EquipmentVO>();//roomID-终端集合
//			Map rmap = new HashMap();
			//查询地址关系
			AddressService addservice = new AddressServiceImpl();
			AddressVO addressVO = new AddressVO();
//			addressVO.setParentID("1");
			alist= addservice.query(addressVO, null);//区域集合
			ArrayList<MeetingRoomVO> list = null;
			MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
			
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			//set start time and end time
			Calendar c = Calendar.getInstance();
			meetingDetailVO.setMeetingStartTime(new Timestamp(c.getTimeInMillis()));
			int iDuration = MeetingAppConfig.SysMeetTime;
			c.add(Calendar.MINUTE, iDuration);
			meetingDetailVO.setMeetingEndTime(new Timestamp(c.getTimeInMillis()));
			//当前空闲会场
			ArrayList<MeetingRoomVO> meetingRoomVOList = meetingRoomService.getEmptyMeetingRoomList(meetingDetailVO, null);
			Map<String,MeetingRoomVO> emptyRoomMap = new HashMap<String,MeetingRoomVO>();
			if( meetingRoomVOList !=null && meetingRoomVOList.size()>0 ){
				for( MeetingRoomVO rvo : meetingRoomVOList ){
					emptyRoomMap.put(rvo.getMeetingRoomID(), rvo);
				}
			}
			
			
			if(alist.size()>0)
			{
				for(int i=0;i<alist.size();i++)
				{
					AddressVO add = alist.get(i);//当前区域
					
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
					meetingRoomVO.setAddressVO(add);
					////////////////////////@author:zhangjy 分级分权///////////////////
					if(MeetingAppConfig.LEVEL_IS_POEN){
						if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
							meetingRoomVO.setLevel(true);
							meetingRoomVO.setLsql(suv.getLvoids());
						}
					}
					////////////////////////////////////////////
					list = meetingRoomService.query(meetingRoomVO, null);//当前区域下所有视频会场
					if(list!=null&&list.size()>0){
						if(emptyRoomMap !=null && emptyRoomMap.size()>0){//有空闲会场
							for( MeetingRoomVO rvo : list ){
								if( emptyRoomMap.get(rvo.getMeetingRoomID()) !=null ){
									rvo.setMeetingRoomName(rvo.getMeetingRoomName()+"(空闲)");
								}else{
									rvo.setMeetingRoomName(rvo.getMeetingRoomName()+"(已被其他会议占用)");
								}
							}
						}else{
							for( MeetingRoomVO rvo : list ){
									rvo.setMeetingRoomName(rvo.getMeetingRoomName()+"(已被其他会议占用)");
							}
						}
						amap.put(add.getAddressID(), list);//区域会议室集合
					}
					
				}
			}
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
			list = meetingRoomService.query(meetingRoomVO, null);//会议室集合
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					MeetingRoomVO mro = list.get(i);
					
					EquipmentVO ev = new EquipmentVO();
					ev.setMeetingRoomVO(mro);
					ev.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					ArrayList<EquipmentVO> listEqu = ServiceFactory.getEquipmentService().query(ev, null);
					if(listEqu!=null&&listEqu.size()>0)
						amequip.put(mro.getMeetingRoomID(), listEqu.get(0));//会议室终端集合(1会议室对应1个终端的情况)
				}
			}
			
//			//查询会议室列表
//			MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
//			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
//			meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
//			meetingRoomVOList = meetingRoomService.query(meetingRoomVO, null);
//			if(meetingRoomVOList.size() >0 )
//			{
//				//根据addressID 分组
//				for(int m=0;m<meetingRoomVOList.size();m++)
//				{
//					MeetingRoomVO room = meetingRoomVOList.get(m);
//					room.setIsleaf(1);//叶子
//					String addressID = room.getAddressVO().getAddressID();
//					
//					if(!rmap.containsKey(addressID))
//					{
//						ArrayList<MeetingRoomVO> tmplist = new ArrayList<MeetingRoomVO>();
//						tmplist.add(room);
//						rmap.put(addressID, tmplist);
//					}
//					else 
//					{
//						ArrayList<MeetingRoomVO> tmplist = (ArrayList<MeetingRoomVO>) rmap.get(addressID);
//						tmplist.add(room);
//					}						
//				}
//				
//			}
//			//组织页面展示逻辑关系
//			if(alist.size()>0)
//			{
//				for(int i=0;i<alist.size();i++)
//				{
//					AddressVO add = alist.get(i);
//					//地址转义赋值
//					MeetingRoomVO room = new MeetingRoomVO();
//					room.setIsleaf(0);
//					room.setMeetingRoomID(add.getAddressID());
//					room.setParentID(add.getParentID());
//					room.setMeetingRoomName(add.getName());
//					treelist.add(room);
//					// 查询对应的rooms
//					if(rmap.containsKey(add.getAddressID()))
//					{
//						treelist.addAll((ArrayList<MeetingRoomVO>)rmap.get(add.getAddressID()));
//					}					
//					
//				}
//			}
//				
			
			this.getCurHttpServletRequest().setAttribute("treelist", alist);//所有区域集合
			this.getCurHttpServletRequest().setAttribute("amap", amap);//区域下所有视频会议室集合(key:区域ID value:会议室List)
			this.getCurHttpServletRequest().setAttribute("amequip", amequip);//所有有终端的会议室Map(key:会议室id value:终端对象)
		
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "系统异常！");
			
		}

		logger.info("MeetingAction		prepareMeetingRoomTree	end");
	}
	
	/**
	 * add a video meeting
	 * @return
	 */
	public String addVideoMeeting() {
		logger.info("MeetingAction		addVideoMeeting	begin");
		TransactionManager tManager = null;
		try {
			tManager = new TransactionManager();
			tManager.beginTransaction();
			ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
			ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
//			AssignVO assignVO = null;
			if(meetingVO.getCreateUserID() ==null){
				UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);
				if(loginUser != null){
					meetingVO.setCreateUserID(loginUser.getUserID());
					meetingVO.setCreateUserName(loginUser.getName());
				}
			}else{
				//this meeting is assigned by other person. and admin help to subscribe meeting
				String assignID = this.getCurHttpServletRequest().getParameter("assignID");
//				if(assignID != null && !assignID.trim().equals("")){
//					String revision = request.getParameter("revision");
//					assignVO =new AssignVO();
//					assignVO.setAssignID(Integer.parseInt(assignID));
//					assignVO.setRevision(Long.parseLong(revision));
//				}
			}
			
			//organize users
			String[] participatorIDArray = splitID(meetingVO.getParticipatorIDs());
			if(participatorIDArray != null && participatorIDArray.length > 0){
				String[] participatorArray = splitName(meetingVO.getParticipators());
				for(int i=0; i < participatorIDArray.length; i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(participatorIDArray[i]);
					userVO.setName(participatorArray[i]);
					userVOList.add(userVO);
				}
			}
			
			//organize video conference room
			if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
				String[] meetingRoomNameIDArray = splitID(meetingVO.getMeetingRoomNameIDs());
				boolean isExisted = false;
				int i = 0;
				if(i < meetingRoomNameIDArray.length){
					String[] meetingRoomNameArray = splitName(meetingVO.getMeetingRoomNames());
					for(; i < meetingRoomNameIDArray.length; i++){
						VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
						videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
						videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
						if(meetingRoomNameIDArray[i] != null && meetingRoomNameIDArray[i].equals(meetingVO.getMeetingRoomID())){
							isExisted = true;
							videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						}else{
							videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
						}
						videoconferenceVOList.add(videoconferenceVO);
					}
				}	
				if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
					VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
					videoconferenceVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
					videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
					videoconferenceVOList.add(videoconferenceVO);
				}
			}
			
			MeetingService meetingService = new MeetingServiceImpl();
			meetingVO.setMeetingID("");//meetingid  设置为空主要防止，定完模版后的会议id进入影响添加会议功能。
		//	meetingVO.setSendEmailFormat(MeetingAppConfig.EMAIL_INFO_MEETING);
		//	meetingVO.setSendSMSFormat(MeetingAppConfig.SMS_INFO_MEETING);
			if(this.getCurHttpServletRequest().getParameter("checkUp").equals("1")){
				vTime = (int)((Float.parseFloat(meetingVO.getMeetingDescription())) * 60);
				Calendar currentTime = Calendar.getInstance();
				meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
				currentTime.add(Calendar.MINUTE, vTime);
				meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
			}
			  
			MeetingDetailVO vMeetingDetailVO = meetingService.addMeeting(meetingVO, userVOList, null, videoconferenceVOList, tManager);
			tManager.commit();
			//create meeting immediately in mcu or time control
//			if(request.getParameter("checkUp").equals("1")){
//				creatConfInMcu(vMeetingDetailVO);
//			}else{
//				//自动控制
//				creatMeetingForSelf(vMeetingDetailVO,"add");
//			}
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加详细预订时发生异常！ 如果是管理员帮助预订会议，则可能是用户已经修改委托预订会议内容，请重新帮助用户预订会议。");
			logger.error(e.getMessage());
			e.printStackTrace();
			if(tManager != null){
				tManager.rollback();
			}
			return "FAILURE";
		}finally{
			if(tManager != null){
				tManager.endTransaction();
			}
		}
		
		logger.info("MeetingAction		addVideoMeeting	end");
		return "SUCCESS";
	}
	
	
	
	private void creatMeetingForSelf(MeetingDetailVO vMeetingDetailVO,String mark)throws Exception{
//		自动控制
		
//		String s = TimeFormatUtil.getFormatDate(vMeetingDetailVO.getMeetingStartTime());
//		String e = TimeFormatUtil.getFormatDate(new Timestamp(System.currentTimeMillis()));
//		//如果是当天的会议，添加到队列
//		if(s.equals(e)){
//			new CreatMeetingTimer().setCreatMeetingTime(vMeetingDetailVO,mark);
//			//new DestroyMeetingTimer().setDestroyMeetingTime(vMeetingDetailVO);
//		}
	}
	
	/**

	 * list templates;
	 * @return
	 */
	public String manageMeetingTemplateList(){
		logger.info("MeetingAction		manageMeetingTemplateList	begin");
//		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			// operatorBegin();
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			meetingDetailVOList = meetingDetailService.queryMeetingDetailList2(meetingDetailVO, getPageControler());//.getMeetingDetailList(meetingDetailVO, pSplittor.getPControler());
			//// operatorEnd();
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "获取会议模板列表时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		
		logger.info("MeetingAction		manageMeetingTemplateList	end");
		return "SUCCESS";
	}
	
	public String manageMeetingTemplateListForAdmin(){
		logger.info("MeetingAction		manageMeetingTemplateListForAdmin	begin");
//		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			// operatorBegin();
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			meetingDetailVOList = meetingDetailService.queryMeetingDetailList2(meetingDetailVO, getPageControler());//.getMeetingDetailList(meetingDetailVO, pSplittor.getPControler());
			//// operatorEnd();
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "获取会议模板列表时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		
		logger.info("MeetingAction		manageMeetingTemplateListForAdmin	end");
		return "SUCCESS";
	}
	
	//级联会立即召开
	public String manageLinkMeetingTemplateList(){
		logger.info("MeetingAction		manageLinkMeetingTemplateList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(this.getCurHttpServletRequest());
		
		try{
			// operatorBegin();
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, pSplittor.getPControler());
		 
			//// operatorEnd();
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "获取会议模板列表时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		
		logger.info("MeetingAction		manageLinkMeetingTemplateList	end");
		return "SUCCESS";
	}
	
	
	public String getMeetingTemplate(){
		logger.info("MeetingAction		getMeetingInfoVideo	begin");
		try{
				if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
					MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
					ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
					if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
						meetingDetailVO = meetingDetailVOList.get(0);
						
						meetingVO.setMeetingRoomID(meetingDetailVO.getMeetingRoomID());
						meetingVO.setMeetingRoomName(meetingDetailVO.getMeetingRoomName());
						Calendar currentTime = Calendar.getInstance();
						
						meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
						currentTime.add(Calendar.HOUR_OF_DAY, 2);
						meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
						
						meetingDetailVO.setMeetingStartTime(meetingVO.getMeetingStartTime());
						meetingDetailVO.setMeetingEndTime(meetingVO.getMeetingEndTime());
						
//						MeetingService meetingService = new MeetingServiceImpl();
//						meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
//						
//						meetingVOList = meetingService.getMeetingList(meetingVO, null);
//						if(meetingVOList != null && meetingVOList.size() > 0){
//							meetingVO = meetingVOList.get(0);
//						}
					}
				}
			prepareMeetingRoomTree(new UserVO());
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ获取详细预订信息时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction		getMeetingInfoVideo	end");   
		if((MeetingDetailEnum.STATUS_TEMPLATE+"").equals(meetingDetailVO.getStatus())&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
			return "PERIODSUCCESS";
		}
		
		return "SUCCESS";
	}
	
	public String getMeetingTemplateInfo(){
		logger.info("MeetingAction		getMeetingTemplateInfo	begin");
		try{
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
				if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
					MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
					ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
					if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
						meetingDetailVO = meetingDetailVOList.get(0);
						
						meetingVO.setMeetingRoomID(meetingDetailVO.getMeetingRoomID());
						meetingVO.setMeetingRoomName(meetingDetailVO.getMeetingRoomName());
						Calendar currentTime = Calendar.getInstance();
						
						meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
						currentTime.add(Calendar.HOUR_OF_DAY, 2);
						meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
						
						meetingDetailVO.setMeetingStartTime(meetingVO.getMeetingStartTime());
						meetingDetailVO.setMeetingEndTime(meetingVO.getMeetingEndTime());
						
//						MeetingService meetingService = new MeetingServiceImpl();
//						meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
//						
//						meetingVOList = meetingService.getMeetingList(meetingVO, null);
//						if(meetingVOList != null && meetingVOList.size() > 0){
//							meetingVO = meetingVOList.get(0);
//						}
					}
				}
			prepareMeetingRoomTree(new UserVO());
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ获取详细预订信息时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction		getMeetingTemplateInfo	end");   
		if((MeetingDetailEnum.STATUS_TEMPLATE+"").equals(meetingDetailVO.getStatus())&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
			return "PERIODSUCCESS";
		}
		
		return "SUCCESS";
	}
	
	public String getLinkMeetingTemplateInfo(){
		logger.info("MeetingAction		getMeetingTemplateInfo	begin");
		try{
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
				if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
					MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
					ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
					if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
						meetingDetailVO = meetingDetailVOList.get(0);
						
						meetingVO.setMeetingRoomID(meetingDetailVO.getMeetingRoomID());
						meetingVO.setMeetingRoomName(meetingDetailVO.getMeetingRoomName());
						Calendar currentTime = Calendar.getInstance();
						
						meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
						currentTime.add(Calendar.HOUR_OF_DAY, 2);
						meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
						
						meetingDetailVO.setMeetingStartTime(meetingVO.getMeetingStartTime());
						meetingDetailVO.setMeetingEndTime(meetingVO.getMeetingEndTime());
						
//						MeetingService meetingService = new MeetingServiceImpl();
//						meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
//						
//						meetingVOList = meetingService.getMeetingList(meetingVO, null);
//						if(meetingVOList != null && meetingVOList.size() > 0){
//							meetingVO = meetingVOList.get(0);
//						}
					}
				}
			prepareMeetingRoomTree(new UserVO());
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ获取详细预订信息时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction		getMeetingTemplateInfo	end");   
		if((MeetingDetailEnum.STATUS_TEMPLATE+"").equals(meetingDetailVO.getStatus())&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
			return "PERIODSUCCESS";
		}
		
		return "SUCCESS";
	}
	
	
	/**
	 * delete meeting template
	 * @return
	 */
	public String delMeetingTemplate(){
		logger.info("MeetingAction		delMeetingTemplate	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(this.getCurHttpServletRequest());
		try{
			MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID + "");
			meetingDetailService.delMeetingDetail(meetingDetailVO);
			
			MeetingDetailUserVO temp = new MeetingDetailUserVO();//删除会议人员表相关数据
			temp.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			ServiceFactory.getMeetingDetailUserService().delMeetingDetailUserByDetailId(temp, null);
			
			VideoconferenceService videoconferenceService = ServiceFactory.getVideoconferenceService();
			VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
			tempVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			videoconferenceService.delVideoconferenceByDetailId(tempVideoconferenceVO, null);//删除meettingDetail-room表相关数据
			
			MeetingDetailVO meetingDetailVOTemp = new MeetingDetailVO();
			meetingDetailVOTemp.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVOTemp.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVOTemp, pSplittor.getPControler());
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "获取会议模板列表时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		
		logger.info("MeetingAction		delMeetingTemplate	end");
		return "SUCCESS";
	}
	
	/**
	 * modify a video template
	 * @return
	 */
	public String modifyVideoMeetingTemplate()
	{
		logger.info("MeetingTemplateAction		modifyVideoMeetingTemplate	begin");
		try {
			
			
			
			MeetingService meetingService = new MeetingServiceImpl();
			//get UserInfo
			UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name放入到模版表内
			if(loginUser != null){
				meetingDetailVO.setCreateUserID(loginUser.getUserID());
				meetingDetailVO.setCreateUserName(loginUser.getName());
			}
			
			//organize users
			ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
			String[] participatorIDArray = splitID(meetingVO.getParticipatorIDs());
			if(participatorIDArray != null && participatorIDArray.length > 0){
				String[] participatorArray = splitName(meetingVO.getParticipators());
				for(int i=0; i < participatorIDArray.length; i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(participatorIDArray[i]);
					userVO.setName(participatorArray[i]);
					userVOList.add(userVO);
				}
			}
			//organize video conference room
			ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
			if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
				String[] meetingRoomNameIDArray = splitID(meetingVO.getMeetingRoomNameIDs());
				boolean isExisted = false;
				int i = 0;
				if(i < meetingRoomNameIDArray.length){
					String[] meetingRoomNameArray = splitName(meetingVO.getMeetingRoomNames());
					for(; i < meetingRoomNameIDArray.length; i++){
						VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
						videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
						videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
						if(meetingRoomNameIDArray[i] != null && meetingRoomNameIDArray[i].equals(meetingVO.getMeetingRoomID())){
							isExisted = true;
							videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						}
						videoconferenceVOList.add(videoconferenceVO);
					}
				}
				if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
					VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
					videoconferenceVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
					videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
					videoconferenceVOList.add(videoconferenceVO);
				}
			}
			
			meetingDetailVO = meetingService.modifyMeetingTemplate(meetingVO, meetingDetailVO, userVOList, null, videoconferenceVOList, null);
		//	meetingDetailVO.setMeetingDetailID(meetingTemplateVO.getMeetingDetailID());
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(0);
				meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
			}
			prepareMeetingRoomTree(new UserVO());
			
			
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加会议模板时发生异常！");
			logger.error(e.getMessage());
		    e.printStackTrace();
			return "FAILURE";
		}
		
		logger.info("MeetingTemplateAction		modifyVideoMeetingTemplate	end");
		if(meetingVO.getPeriodType()!=null&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
		return "SUCCESS_PERIOD";
		}else{
			new McuControlHelper().creatConfInMcu(meetingDetailVO);
			return "SUCCESS";
		}
	}
	
	/**
	 * modify a video template 立即召开
	 * @return
	 */
	public String addCurrentVideoMeeting()
	{
		logger.info("MeetingAction		addCurrentVideoMeeting	begin");
		try {
			
			
			MeetingService meetingService = new MeetingServiceImpl();
			//get UserInfo
			UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name放入到模版表内
			if(loginUser != null){
				meetingDetailVO.setCreateUserID(loginUser.getUserID());
				meetingDetailVO.setCreateUserName(loginUser.getName());
				//modify by chenshuo 2012-8-31
				meetingVO.setCreateUserID(loginUser.getUserID());
				meetingVO.setCreateUserName(loginUser.getUserID());
			}
			
			//organize users
			ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
			String[] participatorIDArray = splitID(meetingVO.getParticipatorIDs());
			if(participatorIDArray != null && participatorIDArray.length > 0){
				String[] participatorArray = splitName(meetingVO.getParticipators());
				for(int i=0; i < participatorIDArray.length; i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(participatorIDArray[i]);
					userVO.setName(participatorArray[i]);
					userVOList.add(userVO);
				}
			}
			//organize video conference room
			ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
			if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
				String[] meetingRoomNameIDArray = splitID(meetingVO.getMeetingRoomNameIDs());
				int i = 0;
				if(i < meetingRoomNameIDArray.length){
					String[] meetingRoomNameArray = splitName(meetingVO.getMeetingRoomNames());
					for(; i < meetingRoomNameIDArray.length; i++){
						VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
						videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
						videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
						if(meetingRoomNameIDArray[i] != null && meetingRoomNameIDArray[i].equals(meetingVO.getMeetingRoomID())){
							videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						}
						videoconferenceVOList.add(videoconferenceVO);
					}
				}	
			}
			
			vTime = (int)((Float.parseFloat(meetingVO.getMeetingDescription())) * 60);
			Calendar currentTime = Calendar.getInstance();
			meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
			currentTime.add(Calendar.MINUTE, vTime);
			meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
				
			String profileId = meetingVO.getConfProfileID();
			meetingDetailVO = meetingService.addMeeting(meetingVO, userVOList, null, videoconferenceVOList, null);
		//	meetingDetailVO.setMeetingDetailID(meetingTemplateVO.getMeetingDetailID());
			meetingDetailVO.setMeetingRoomID(null);
			meetingDetailVO.setMeetingRoomName(null);
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(0);
				meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
			}
			prepareMeetingRoomTree(new UserVO());
			meetingDetailVO.setConfProfileID(profileId);
			meetingDetailVO.setMeetingRoomNameIDs(meetingVO.getMeetingRoomNameIDs().replace("-", ","));
			
			new McuControlHelper().creatConfInMcu(meetingDetailVO);
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加会议模板时发生异常！");
			logger.error(e.getMessage());
		    e.printStackTrace();
			return "FAILURE";
		}
		
		logger.info("MeetingAction		addCurrentVideoMeeting	end");
		if(meetingVO.getPeriodType()!=null&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
		return "SUCCESS_PERIOD";
		}else{
		return "SUCCESS";
		}
	}
	
	
	/**
	 * modify a video template 立即召开级联会
	 * @return
	 */
	public String addCurrentVideoLinkMeeting()
	{
		logger.info("MeetingAction		addCurrentVideoLinkMeeting	begin");
		try {
			
			
			
			MeetingService meetingService = new MeetingServiceImpl();
			//get UserInfo
			UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name放入到模版表内
			if(loginUser != null){
				meetingDetailVO.setCreateUserID(loginUser.getUserID());
				meetingDetailVO.setCreateUserName(loginUser.getName());
				//modify by chenshuo 2012-8-31
				meetingVO.setCreateUserID(loginUser.getUserID());
				meetingVO.setCreateUserName(loginUser.getUserID());
			}
			
			//organize users
			ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
			String[] participatorIDArray = splitID(meetingVO.getParticipatorIDs());
			if(participatorIDArray != null && participatorIDArray.length > 0){
				String[] participatorArray = splitName(meetingVO.getParticipators());
				for(int i=0; i < participatorIDArray.length; i++){
					UserVO userVO = new UserVO();
					userVO.setUserID(participatorIDArray[i]);
					userVO.setName(participatorArray[i]);
					userVOList.add(userVO);
				}
			}
			//organize video conference room
			ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
			if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
				String[] meetingRoomNameIDArray = splitID(meetingVO.getMeetingRoomNameIDs());
				int i = 0;
				if(i < meetingRoomNameIDArray.length){
					String[] meetingRoomNameArray = splitName(meetingVO.getMeetingRoomNames());
					for(; i < meetingRoomNameIDArray.length; i++){
						VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
						videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
						videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
						if(meetingRoomNameIDArray[i] != null && meetingRoomNameIDArray[i].equals(meetingVO.getMeetingRoomID())){
							videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						}
						videoconferenceVOList.add(videoconferenceVO);
					}
				}	
			}
			
			vTime = (int)((Float.parseFloat(meetingVO.getMeetingDescription())) * 60);
			Calendar currentTime = Calendar.getInstance();
			meetingVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
			currentTime.add(Calendar.MINUTE, vTime);
			meetingVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
				
			String profileId = meetingVO.getConfProfileID();
			meetingDetailVO = meetingService.addMeeting(meetingVO, userVOList, null, videoconferenceVOList, null);
		//	meetingDetailVO.setMeetingDetailID(meetingTemplateVO.getMeetingDetailID());
			meetingDetailVO.setMeetingRoomID(null);
			meetingDetailVO.setMeetingRoomName(null);
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(0);
				meetingVO.setMeetingID(meetingDetailVO.getMeetingDetailID());
			}
			prepareMeetingRoomTree(new UserVO());
			meetingDetailVO.setConfProfileID(profileId);
			meetingDetailVO.setMeetingRoomNameIDs(meetingVO.getMeetingRoomNameIDs().replace("-", ","));
			MeetingTaskOperate.meetingEndTask(meetingDetailVO);//定时器 到时间后修改会议状态
			new McuControlHelper().creatLinkConfInMcu(meetingDetailVO, type);
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加会议模板时发生异常！");
			logger.error(e.getMessage());
		    e.printStackTrace();
		    MeetingTaskOperate.meetingEndTask(meetingDetailVO);//定时器 到时间后修改会议状态
			return "FAILURE";
		}
		
		logger.info("MeetingAction		addCurrentVideoLinkMeeting	end");
		if(meetingVO.getPeriodType()!=null&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
		return "SUCCESS_PERIOD";
		}else{
		return "SUCCESS";
		}
	}
	
	
	/**
	 * 跳转到模板添加页面
	 * @author chenshuo
	 * @serialData 2013-1-25
	 * @return
	 */
	public String meetingTemplateBeforeAdd(){
		logger.info("MeetingAction		meetingTemplateBeforeAdd	begin");
		try{
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			prepareMeetingRoomTree(suv);
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ跳转到模板添加页面时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction		meetingTemplateBeforeAdd	end");   
		
		return "SUCCESS";
	}
	
	
	/**
	 * 添加会议模板
	 * @author chenshuo
	 * @serialData 2013-1-25
	 * @return
	 */
	public String meetingTemplateAdd(){
		logger.info("MeetingAction		meetingTemplateAdd	begin");
		try {
			setConfDetail(MeetingStatus.TEMPLATE);
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ添加会议模板时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		
		logger.info("MeetingAction		meetingTemplateAdd	end");
		if(meetingVO.getPeriodType()!=null&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
		return "SUCCESS_PERIOD";
		}else{
		return "SUCCESS";
		}
	}
	
	public String meetingTemplateBeforeModify(){
		logger.info("MeetingAction	meetingTemplateBeforeModify	begin");
		UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);
		try{
			
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
				MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
				ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
				if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
					meetingDetailVO = meetingDetailVOList.get(0);
					
					meetingVO.setMeetingRoomID(meetingDetailVO.getMeetingRoomID());
					meetingVO.setMeetingRoomName(meetingDetailVO.getMeetingRoomName());
					meetingDetailVO.setTime(Float.parseFloat(meetingDetailVO.getMeetingDescription()));
				}
			}
			prepareMeetingRoomTree(loginUser);
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "跳转修改会议模板页面时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction	meetingTemplateBeforeModify	end");   
		if((MeetingDetailEnum.STATUS_TEMPLATE+"").equals(meetingDetailVO.getStatus())&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
			return "PERIODSUCCESS";
		}
		
		return "SUCCESS";
	}
	
	
	/**
	 * 产品-修改会议模板
	 * @author chenshuo
	 * @serialData 2013-1-25
	 * @return
	 */
	public String meetingTemplateModify(){
		logger.info("MeetingAction	meetingTemplateModify	begin");
		try{
			//修改meetingDetail表
			UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name放入到模版表内
			if(loginUser != null){
				meetingDetailVO.setCreateUserID(loginUser.getUserID());
				meetingDetailVO.setCreateUserName(loginUser.getName());
			}
			
			//organize users
			String[] participatorIDArray = splitMeetingRoomString(meetingDetailVO.getParticipatorIDs());
			
			//organize video conference room
			String[] meetingRoomNameIDArray = splitMeetingRoomString(meetingDetailVO.getMeetingRoomNameIDs());
		
			String[] mainID = null;
			if(meetingDetailVO.getMeetingRoomID()!=null){
				mainID = meetingDetailVO.getMeetingRoomID().split("##");
			}
			
			meetingDetailVO.setMeetingRoomID(mainID[0]);
			MeetingThread modifyThread = new MeetingThread(meetingDetailVO,participatorIDArray,meetingRoomNameIDArray,MeetingThread.MODIFY);
			Thread thread = new Thread(modifyThread);
			thread.start();
			MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			ArrayList<MeetingDetailVO> list = meetingDetailService.query(vMeetingDetailVO, null);
			if(list!=null&&list.size()>0){
				vMeetingDetailVO = list.get(0);
				vMeetingDetailVO.setMeetingName(meetingDetailVO.getMeetingName());
				vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
				if(meetingDetailVO.getMeetingDescription()!=null){
					int hour = Integer.valueOf(meetingDetailVO.getMeetingDescription())*60*60*1000;
					vMeetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis()+hour));	
				}else{
					vMeetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis()));
				}
				
				vMeetingDetailVO.setMeetingDescription(meetingDetailVO.getMeetingDescription());
				vMeetingDetailVO.setConfProfileID(meetingDetailVO.getConfProfileID());
				meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(vMeetingDetailVO, null);	
			}
			
			
			
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "修改会议模板时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}		
		logger.info("MeetingAction	meetingTemplateModify	end");   
		if((MeetingDetailEnum.STATUS_TEMPLATE+"").equals(meetingDetailVO.getStatus())&&meetingVO.getPeriodType()!=Integer.MIN_VALUE){
			return "PERIODSUCCESS";
		}
		
		return "SUCCESS";
	}
	
	
	/**
	 * 模板管理-立即召开功能统一建会入口（包含级联和非级联会）
	 * @serialData 2013-1-24
	 * @author chenshuo
	 * @return
	 */
	public String addVideoConference(){
		//1.向meetingDetail表及其关联表插入数据 2.向MCU接口传递参数
		logger.info("MeetingAction	addVideoConference	begin");
		try{
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");//按模板类型查询
			meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_PTMB);
			if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
				MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
				ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
				if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
					meetingDetailVO = meetingDetailVOList.get(0);//得到会议模板对象VO
					meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_PTMB);
					setConfDetail(MeetingStatus.BE_ATTENDING);//向数据库插入数据
					//prepareMeetingRoomTree();
				    //MeetingTaskOperate.meetingEndTask(meetingDetailVO);//定时器 到时间后修改会议状态
						
					//2.向MCU传参时需要判断是单MCU会议还是多MCU级联会议（判断条件为传入的会场所属于几个MCU）
					String meetingRoomIDs = "'" + meetingDetailVO.getMeetingRoomNameIDs().replace(",", "','") + "'";
					ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = ServiceFactory.getEquipmentTerminalService().queryByRoomIDs(meetingRoomIDs);		
					//插入日志
					LogVO vLogVO = new LogVO();
					vLogVO.setLogType(LogEnum.TYPE_DB);
					vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
					vLogVO.setUserID(meetingDetailVO.getCreateUserID());
					if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
						Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = McuControlHelper.getMcuAndTeminalMap(equipmentTerminalVOList);//所有MCU及其终端集合
						
						if( map !=null && map.size() == 1 ){//单MCU会议
							ZZOResultVO resultVO = new McuControlHelper().creatConfInMcu(meetingDetailVO);
							if( resultVO == null ){//建会成功
								MeetingTaskOperate.meetingEndTask(meetingDetailVO);//增加定时器 到时间后修改会议状态
								vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 成功");
								LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
								
							}else if( resultVO != null ){//建会失败
								meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
								meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);//建会失败删除该条会议记录
								
								
								vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 失败");
								LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
								String errorMessage = McuControlHelper.getErrorMessage(resultVO.getDescription());
								
								this.getCurHttpServletRequest().setAttribute("failure_message", errorMessage);
								return "failure_meeting";//建会失败跳转到出错页面
							}
						}else if( map !=null && map.size()>1 ){//级联会议
							List<ZZOResultVO> resultVOList = new McuControlHelper().creatLinkConfInMcu(meetingDetailVO, type);
							if( resultVOList.size() !=0){//建会失败
								meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
								meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);//建会失败删除该条会议记录
								(new McuDwrMethod()).deleteConf(meetingDetailVO.getMeetingDetailID());//MCU上删会
								
								vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 失败");
								LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
								
								String errorMessage = McuControlHelper.getErrorMessage(resultVOList.get(0).getDescription());
								
								this.getCurHttpServletRequest().setAttribute("failure_message", errorMessage);
								return "failure_meeting";//建会失败跳转到出错页面
							}else{
								vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 成功");
								LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
								MeetingTaskOperate.meetingEndTask(meetingDetailVO);//增加定时器 到时间后修改会议状态
							}
						}
					}
				}
			}
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "用模板建会时发生异常！");
			logger.error(e.getMessage());
			 MeetingTaskOperate.meetingEndTask(meetingDetailVO);//定时器 到时间后修改会议状态
				
			return "FAILURE";
		}		
		logger.info("MeetingAction	addVideoConference	end");   
		
		return "SUCCESS";
	}

	
	
	
	/**
	 * 跳转到立即召开页面
	 * @author chenshuo 2013-1-25
	 * @return
	 */
	public String immediatelyVideoMeetingBeforeAdd(){
		logger.info("MeetingAction		immediatelyVideoMeetingBeforeAdd	begin");
		try {
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			prepareMeetingRoomTree(suv);
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ跳转到立即召开页面时发生异常！");
			logger.error(e.getMessage());
			return "FAILURE";
		}
		return "SUCCESS";
	}
	
	/**
	 * 立即召开
	 * @author chenshuo 2013-1-25
	 * @return
	 */
	public String immediatelyVideoMeetingAdd(){
		logger.info("MeetingAction		immediatelyVideoMeetingAdd	begin");
		
		//测试用
		//ServerContext sctx =   ServerContextFactory.get(ServletActionContext.getServletContext());
		
		////
		
		MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
		try {
			meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_LJZK);
			//1.向meetingDetail表插入数据  2.向MCU传参
			this.setConfDetail(MeetingStatus.BE_ATTENDING);//建会成功向数据库插入数据
			//prepareMeetingRoomTree();
			
			//2.向MCU传参时需要判断是单MCU会议还是多MCU级联会议（判断条件为传入的会场所属于几个MCU）
			String meetingRoomIDs = "'" + meetingDetailVO.getMeetingRoomNameIDs().replace(",", "','") + "'";
			ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = ServiceFactory.getEquipmentTerminalService().queryByRoomIDs(meetingRoomIDs);		
			if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = McuControlHelper.getMcuAndTeminalMap(equipmentTerminalVOList);//所有MCU及其终端集合
				//插入日志
				LogVO vLogVO = new LogVO();
				vLogVO.setLogType(LogEnum.TYPE_DB);
				vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
				vLogVO.setUserID(meetingDetailVO.getCreateUserID());
				if( map !=null && map.size() == 1 ){//单MCU会议

					
					
					ZZOResultVO resultVO = new McuControlHelper().creatConfInMcu(meetingDetailVO);
					if( resultVO == null ){//建会成功
						MeetingTaskOperate.meetingEndTask(meetingDetailVO);//增加定时器 到时间后修改会议状态 
						vLogVO.setOperatorContent("立即召开："+meetingDetailVO.getMeetingName()+" 成功");
						//new McuDwrMethod().getThread(sctx,meetingDetailVO.getMeetingDetailID()).start();
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
					}else if( resultVO != null ){
						meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
						meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);//建会失败删除该条会议记录
						
						
						vLogVO.setOperatorContent("立即召开："+meetingDetailVO.getMeetingName()+" 失败");
						
						
						
						String errorMessage = McuControlHelper.getErrorMessage(resultVO.getDescription());
						this.getCurHttpServletRequest().setAttribute("failure_message", errorMessage);
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						return "failure_meeting";//建会失败跳转到出错页面
					}
					
					
				}else if( map !=null && map.size()>1 ){//级联会议
					List<ZZOResultVO> resultVOList = new McuControlHelper().creatLinkConfInMcu(meetingDetailVO, type);
					
					if( resultVOList.size() != 0){//建会失败
						meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
						meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);//建会失败删除该条会议记录
						(new McuDwrMethod()).deleteConf(meetingDetailVO.getMeetingDetailID());//MCU上删会 
						//插入日志
						
						vLogVO.setOperatorContent("立即召开："+meetingDetailVO.getMeetingName()+" 失败");
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						String errorMessage = McuControlHelper.getErrorMessage(resultVOList.get(0).getDescription());
						
						this.getCurHttpServletRequest().setAttribute("failure_message", errorMessage);
						return "failure_meeting";//建会失败跳转到出错页面
					}else{
						vLogVO.setOperatorContent("立即召开："+meetingDetailVO.getMeetingName()+" 成功");
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						MeetingTaskOperate.meetingEndTask(meetingDetailVO);//增加定时器 到时间后修改会议状态
					}
				}
			}
			
			
			//prepareMeetingRoomTree();
		} catch (Exception e) {
			this.getCurHttpServletRequest().setAttribute("info", "ϵͳ立即召开时发生异常！");
			logger.error(e.getMessage());
		    e.printStackTrace();
		    MeetingTaskOperate.meetingEndTask(meetingDetailVO);//定时器 到时间后修改会议状态
			return "FAILURE";
		}
		return "SUCCESS";
	}
	
	
	/**
	 * 设置会议详细信息
	 */
	private MeetingDetailVO setConfDetail( int meetingType ) throws Exception{
		MeetingService meetingService = ServiceFactory.getMeetingService();
		//get UserInfo
		UserVO loginUser = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name放入到模版表内
		if(loginUser != null){
			meetingDetailVO.setCreateUserID(loginUser.getUserID());
			meetingDetailVO.setCreateUserName(loginUser.getUserID());
		}
		meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_PTMB);//普通模板
		meetingDetailVO.setTemplateType(MeetingDetailEnum.TYPE_TEMPLATETYPE_PUMB);//1为高级模板，0为普通模板
		//organize users
		ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
		String[] participatorIDArray = splitMeetingRoomString(meetingDetailVO.getParticipatorIDs());
		if(participatorIDArray != null && participatorIDArray.length > 0){
			String[] participatorArray = splitMeetingRoomString(meetingDetailVO.getParticipators());
			for(int i=0; i < participatorIDArray.length; i++){
				UserVO userVO = new UserVO();
				userVO.setUserID(participatorIDArray[i]);
				userVO.setName(participatorArray[i]);
				userVOList.add(userVO);
			}
		}
		//organize video conference room
		ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
		if(MeetingTypeEnum.isPolycomMeeting(meetingDetailVO.getMeetingType())){
			String[] meetingRoomNameIDArray = splitMeetingRoomString(meetingDetailVO.getMeetingRoomNameIDs());
			int i = 0;
			if(i < meetingRoomNameIDArray.length){
				String[] meetingRoomNameArray = splitMeetingRoomString(meetingDetailVO.getMeetingRoomNames());
				for(; i < meetingRoomNameIDArray.length; i++){
					VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
					videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
					videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
					if(meetingRoomNameArray[i] != null && meetingRoomNameArray[i].equals(meetingDetailVO.getMeetingRoomName())){
						videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
					}else{
						videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
					}
					videoconferenceVOList.add(videoconferenceVO);
				}
			}
		}
		
		//记录日志:用户添加会议模板
		//LogVO logVO = new LogVO();
		//logVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
		//logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		//logVO.setUserID(loginUser.getUserID());
		//logVO.setOperatorContent("用户添加会议模板");
		//ServiceFactory.getLogService().add(logVO);
		///////////////////////////////
		
		vTime = (int)((Float.parseFloat(meetingDetailVO.getMeetingDescription())) * 60);
		Calendar currentTime = Calendar.getInstance();
		meetingDetailVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
		currentTime.add(Calendar.MINUTE, vTime);
		meetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
		
		meetingDetailVO = meetingService.addMeetingByStatus(meetingDetailVO, userVOList,  videoconferenceVOList, null, meetingType);//向meetingDetail表插入记录
		return meetingDetailVO;
		
	}
	
	/**
	 * 会议调试
	 */
	public String beforeMeetingDebug(){
		try {
			logger.info("MeetingAction  beforeMeetingDebug begin");
			
			MeetingDetailVO	vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingID(meetingDetailVO.getMeetingDetailID());
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO_DEBUG);
			
			ArrayList<MeetingDetailVO> meetingDetailList = MeetingDetailDAO.queryMeetingDetailList(vMeetingDetailVO, null);
			meetingDetailVO=ServiceFactory.getMeetingDetailService().queryByID(meetingDetailVO.getMeetingDetailID());
			this.getCurHttpServletRequest().setAttribute("meetingDetailList", meetingDetailList);
			this.getCurHttpServletRequest().setAttribute("meetingDetailVO", meetingDetailVO);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return "FAILURE";
		}
		logger.info("MeetingAction  beforeMeetingDebug end");
		return "SUCCESS";
	}
	
	public String beforeMeetingDebugNotice(){
		try {
			logger.info("MeetingAction  beforeMeetingDebugNotice    begin");
			MeetingDetailVO detailVO = ServiceFactory.getMeetingDetailService().queryByID(meetingDetailVO.getMeetingDetailID());
			this.getCurHttpServletRequest().setAttribute("meetingDetailVO", detailVO);
			this.getCurHttpServletRequest().setAttribute("sms", MeetingAppConfig.sms_status);
			this.getCurHttpServletRequest().setAttribute("email", MeetingAppConfig.mail_status);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			return "FAILURE";
		}
		logger.info("MeetingAction  beforeMeetingDebugNotice end");
		return "SUCCESS";
	}
	
	public String addMeetingDebugNotice(){
		try {
			logger.info("MeetingAction  addMeetingDebugNotice    begin");
			meetingDetailVO.getMeetingDebugVO().setNoticeStatus(1);
			ServiceFactory.getMeetingDebugService().modify(meetingDetailVO.getMeetingDebugVO());
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingDetailID(meetingDetailVO.getMeetingDebugVO().getMeetingDetailId());
			List<MeetingDetailVO> mList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(vMeetingDetailVO, null);
			if(null!=mList){
				vMeetingDetailVO = mList.get(0);
				vMeetingDetailVO.setMeetingDebugVO(meetingDetailVO.getMeetingDebugVO());
			SendMessageInstance sendMessage = new SendMessageInstance(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG , vMeetingDetailVO);
			Thread sdMessageThread = new Thread(sendMessage);
			sdMessageThread.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILURE";
		}
		logger.info("MeetingAction  addMeetingDebugNotice end");
		return "SUCCESS";
	}
	/**
	 * 会议信息导出
	 * @author chenshuo on 2013-2-4
	 * @return
	 */
	public String exportQuery(){
		logger.info("MeetingAction	exportQuery	begin");
		try{
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			meetingDetailVOList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null);//按当前查询条件查询
			
			String fileName = "meetingDetail.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(meetingDetailVOList!=null&& meetingDetailVOList.size()>0){
				
				for (int i = 0; i < meetingDetailVOList.size(); i++) {
					MeetingDetailVO lVO = meetingDetailVOList.get(i);
					CellVO[] cell = new CellVO[10];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getMeetingName());//会议名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					//ex2.setValuetype(CellVO.TYPE_DATE);
					ex2.setValue(this.formatDate(lVO.getMeetingStartTime()));//会议开始时间
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					//ex3.setValuetype(CellVO.TYPE_DATE);
					ex3.setValue(this.formatDate(lVO.getMeetingEndTime()));//会议结束时间
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					for(String[] s : MeetingTypeEnum.getMeetingType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getMeetingType()+"")){
							 ex4.setValue(s[1]);//会议类型
							 continue;
						 }
					 }
					cell[4] = ex4;
					
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getMeetingRoomNames());//参会会议室
					cell[5] = ex5;
					
					CellVO ex6 = new CellVO();
					MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();//存储过程无法提取人员信息
					meetingDetailUserVO.setMeetingDetailID(lVO.getMeetingDetailID());
					ArrayList<MeetingDetailUserVO> listuser = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
					if(listuser != null && listuser.size() > 0){
						StringBuffer ids = new StringBuffer();
						StringBuffer names = new StringBuffer();
						MeetingDetailUserVO detailUser = null;
						for(int j=0; j< listuser.size(); j++){
							if(j != 0){
								ids.append(",");
								names.append(",");
							}
							detailUser = listuser.get(j);
							if(detailUser != null){
								ids.append(detailUser.getUserID());
								names.append(detailUser.getUserName());
							}
						}
						lVO.setParticipatorIDs(ids.toString());
						lVO.setParticipators(names.toString());
					}
					ex6.setValue(lVO.getParticipators());////参会人员
					cell[6] = ex6;
					
					CellVO ex7 = new CellVO();
					for(String[] s : MeetingDetailEnum.getMeetingStatus()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
							 ex7.setValue(s[1]);//会议状态
							 continue;
						 }
					 }
					cell[7] = ex7;
					
					
					CellVO ex8 = new CellVO();
					//ex5.setValue(lVO.getParticipators());//主会场
					ex8.setValue(lVO.getMeetingRoomName());
					cell[8] = ex8;
					
					CellVO ex9 = new CellVO();
					//ex5.setValue(lVO.getParticipators());//主会场
					ex9.setValue(lVO.getInfo2());
					cell[9] = ex9;
					list.add(cell);
					
				}
				//ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        //excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		}catch(Exception e){
			logger.error("MeetingAction	exportQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("MeetingAction	exportQuery	end");
		return "success";
	}
	/**
	 * 我的会议信息导出
	 * @author chenshuo on 2013-2-4
	 * @return
	 */
	public String exportMyConQuery(){
		logger.info("MeetingAction	exportMyConQuery	begin");
		try{
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			meetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			meetingDetailVOList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null);//按当前查询条件查询
			
			String fileName = "mymeetingDetail.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(meetingDetailVOList!=null&& meetingDetailVOList.size()>0){
				
				for (int i = 0; i < meetingDetailVOList.size(); i++) {
					MeetingDetailVO lVO = meetingDetailVOList.get(i);
					CellVO[] cell = new CellVO[10];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getMeetingName());//会议名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					//ex2.setValuetype(CellVO.TYPE_DATE);
					ex2.setValue(this.formatDate(lVO.getMeetingStartTime()));//会议开始时间
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					//ex3.setValuetype(CellVO.TYPE_DATE);
					ex3.setValue(this.formatDate(lVO.getMeetingEndTime()));//会议结束时间
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					for(String[] s : MeetingTypeEnum.getMeetingType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getMeetingType()+"")){
							 ex4.setValue(s[1]);//会议类型
							 continue;
						 }
					 }
					cell[4] = ex4;
					
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getMeetingRoomNames());//参会会议室
					cell[5] = ex5;
					
					CellVO ex6 = new CellVO();
					MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();//存储过程无法提取人员信息
					meetingDetailUserVO.setMeetingDetailID(lVO.getMeetingDetailID());
					ArrayList<MeetingDetailUserVO> listuser = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
					if(listuser != null && listuser.size() > 0){
						StringBuffer ids = new StringBuffer();
						StringBuffer names = new StringBuffer();
						MeetingDetailUserVO detailUser = null;
						for(int j=0; j< listuser.size(); j++){
							if(j != 0){
								ids.append(",");
								names.append(",");
							}
							detailUser = listuser.get(j);
							if(detailUser != null){
								ids.append(detailUser.getUserID());
								names.append(detailUser.getUserName());
							}
						}
						lVO.setParticipatorIDs(ids.toString());
						lVO.setParticipators(names.toString());
					}
					ex6.setValue(lVO.getParticipators());////参会人员
					cell[6] = ex6;
					
					CellVO ex7 = new CellVO();
					for(String[] s : MeetingDetailEnum.getMeetingStatus()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
							 ex7.setValue(s[1]);//会议状态
							 continue;
						 }
					 }
					cell[7] = ex7;
					
					
					CellVO ex8 = new CellVO();
					//ex5.setValue(lVO.getParticipators());//主会场
					ex8.setValue(lVO.getMeetingRoomName());
					cell[8] = ex8;
					
					CellVO ex9 = new CellVO();
					//ex5.setValue(lVO.getParticipators());//主会场
					ex9.setValue(lVO.getInfo2());
					cell[9] = ex9;
					list.add(cell);
					
				}
				//ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        //excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		}catch(Exception e){
			logger.error("MeetingAction	exportMyConQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("MeetingAction	exportMyConQuery	end");
		return "success";
	}
	
	/**
	 * 会议调试
	 * @return
	 */
	public String meetingDebug() {
		logger.info("MeetingAction	meetingDebug	begin");
		try {
			if (meetingDetailVO.getMeetingDetailID() != null&& !(meetingDetailVO.getMeetingDetailID().equals(""))) {
				MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
				ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);

				if (meetingDetailVOList != null&& meetingDetailVOList.size() > 0) {
					meetingDetailVO = meetingDetailVOList.get(0);// 得到会议对象VO
					meetingDetailVO.setMeetingID(meetingDetailVO.getMeetingDetailID());
					meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO_DEBUG);
					meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_DEBUG);
					
					meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
					meetingDetailVO.setMeetingName("调试会议："+meetingDetailVO.getMeetingName());
					Timestamp startTime = new Timestamp(System.currentTimeMillis());
					meetingDetailVO.setCreateTime(startTime);
					meetingDetailVO.setMeetingStartTime(startTime);
//					meetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis() + MeetingAppConfig.MEETING_DEBUG_DURATION * 60 * 60 * 1000));
					meetingDetailVO.setMeetingEndTime(new Timestamp(System.currentTimeMillis() + Integer.parseInt(MeetingAppConfig.MEETING_DEBUG_DURATION) * 60 * 60 * 1000));
					ArrayList<UserVO> listUser = new ArrayList<UserVO>();
					ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();

					boolean isExisted = false;
					if (null != meetingDetailVO.getMeetingRoomNameIDs()&& !meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")) {
						String[] roomIDs = {};
						roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
						int userLength = roomIDs.length;
						for (int i = 0; i < userLength; i++) {
							VideoconferenceVO venueVO = new VideoconferenceVO();
							venueVO.setSubmeetingRoomID(roomIDs[i]);
							if (meetingDetailVO.getMeetingRoomID() != null&& meetingDetailVO.getMeetingRoomID().equals(roomIDs[i])) {
								venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
								isExisted = true;
							} else {
								venueVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
							}
							listRoom.add(venueVO);
						}
					}
					if (!isExisted&& meetingDetailVO.getMeetingRoomID() != null) {
						VideoconferenceVO venueVO = new VideoconferenceVO();
						venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						listRoom.add(venueVO);
					}
					meetingDetailVO = ServiceFactory.getMeetingDetailService().addVedioMeetingDetail(meetingDetailVO,listUser,listRoom);
					MeetingTaskOperate.debugMeetingStartTask(meetingDetailVO);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		this.getCurHttpServletRequest().setAttribute("failure_message", "调试会议已创建！");
		logger.info("MeetingAction meetingDebug end");
		return "SUCCESS";

	}

	
	/**
	 * 模板导出
	 * @author chenshuo on 2013-2-4
	 * @return
	 */
	public String exportTemplateQuery(){
		logger.info("MeetingAction	exportTemplateQuery	begin");
		try{
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			meetingDetailVOList = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, null);//按当前查询条件查询
			
			String fileName = "meetingTemplate.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle1(list);//添加表头
			if(meetingDetailVOList!=null&& meetingDetailVOList.size()>0){
				
				for (int i = 0; i < meetingDetailVOList.size(); i++) {
					MeetingDetailVO lVO = meetingDetailVOList.get(i);
					CellVO[] cell = new CellVO[6];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getMeetingName());//会议名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					//ex2.setValuetype(CellVO.TYPE_DATE);
					ex2.setValue(lVO.getMeetingName());//模板名称
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					//ex3.setValuetype(CellVO.TYPE_DATE);
					ex3.setValue(lVO.getMeetingDescription());//会议时长
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getMeetingRoomNames());//参会会议室
					cell[4] = ex4;
					
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getMeetingRoomName());//主会议室
					cell[5] = ex5;
					
					list.add(cell);
					
				}
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);

		}catch(Exception e){
			e.printStackTrace();
			logger.error("MeetingAction	exportTemplateQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingAction	exportTemplateQuery	end");
		return "success";
	}
	
	/**
	 * 设置会议信息excel文件表头
	 * @param list
	 */
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[10];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("开始时间");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("结束时间");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议类型");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("参会会场");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		ex0.setValue("参会人员");
		cellTitle[6] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议状态");
		cellTitle[7] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("主会场");
		cellTitle[8] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("参会人数");
		cellTitle[9] = ex0;
		list.add(cellTitle);
	}
	
	/**
	 * 设置会议模板信息excel文件表头
	 * @param list
	 */
	private void setTitle1(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[6];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("模板名称");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议时长");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("参会会场");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("主会场");
		cellTitle[5] = ex0;
		list.add(cellTitle);
	}
	
	
	
	public String[] splitName(String names){
		if(names == null || names.trim().equals("")){
			return null;
		}
		
		String[] result = names.split("、");
		return result;
	}
	
	public String[] splitID(String IDs){
		if(IDs == null || IDs.trim().equals("")){
			return null;
		}
		
		String[] result = IDs.split("-");
		return result;
	}
	
	public String[] splitMeetingRoomString(String IDs){
		if(IDs == null || IDs.trim().equals("")){
			return null;
		}
		
		String[] result = IDs.split(",");
		return result;
	}
	
	private String formatDate(Timestamp time){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateStr= df.format(new Date(time.getTime()));
		return dateStr;
	}
	
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}
	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
	
	public MeetingVO getMeetingVO() {
		return meetingVO;
	}

	public void setMeetingVO(MeetingVO meetingVO) {
		this.meetingVO = meetingVO;
	}

	public Integer getvTime() {
		return vTime;
	}

	public void setvTime(Integer vTime) {
		this.vTime = vTime;
	}
	
	public List<MeetingDetailVO> getMeetingDetailVOList() {
		return meetingDetailVOList;
	}


	public void setMeetingDetailVOList(List<MeetingDetailVO> meetingDetailVOList) {
		this.meetingDetailVOList = meetingDetailVOList;
	}

	public Integer getVTime() {
		return vTime;
	}

	public void setVTime(Integer time) {
		vTime = time;
	}

	public MeetingTemplateVO getMeetingTemplateVO() {
		return meetingTemplateVO;
	}

	public void setMeetingTemplateVO(MeetingTemplateVO meetingTemplateVO) {
		this.meetingTemplateVO = meetingTemplateVO;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	
	
	
}
