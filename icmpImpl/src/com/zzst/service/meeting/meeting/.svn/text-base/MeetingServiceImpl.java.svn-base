package com.zzst.service.meeting.meeting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meeting.MeetingDAO;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.dao.meeting.meetingDetailUser.MeetingDetailUserDAO;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.enums.UseStatusEnum;
import com.zzst.model.meeting.meeting.MeetingVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserService;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.meeting.videoconference.VideoconferenceService;
import com.zzst.service.meeting.videoconference.VideoconferenceServiceImpl;

/**
 * class description: Meeting Impl
 * 
 * @author wangle
 * @date Mon Aug 17 15:06:56 CST 2009
 */

public class MeetingServiceImpl implements MeetingService {

	private static Logger logger = CbfLogger.getLogger(MeetingServiceImpl.class
			.getName());

	/**
	 * method description : addMeeting
	 * @param assignVO is not null, that means this meeting is assigned by other person. and admin help to subscribe meeting
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingDetailVO addMeeting(MeetingVO vMeetingVO, ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> serviceList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception {
		
		if (tManager == null) {
			tManager = new TransactionManager();
		}
		
		// 会议表
		if(vMeetingVO.getUseNotice() == Integer.MIN_VALUE){
			vMeetingVO.setUseNotice(UseStatusEnum.INVALID);
		}
		if(vMeetingVO.getUseReach() == Integer.MIN_VALUE){
			vMeetingVO.setUseReach(UseStatusEnum.INVALID);
		}
		if(vMeetingVO.getStatus() != MeetingStatus.SAVED){
			vMeetingVO.setStatus(MeetingStatus.BE_ATTENDING);//modify at 2012 9-5 by chenshuo
		}
//		MeetingVO meetingVO = MeetingDAO.addMeeting(vMeetingVO, null);
//		ArrayList meetingList = MeetingDAO.getMeetingList(vMeetingVO, null);
//		MeetingVO meetingVO = new MeetingVO();
//		if(meetingList.size() > 0){
//			meetingVO = (MeetingVO) meetingList.get(meetingList.size() - 1);
//			
//			vMeetingVO.setCreateUserID(meetingVO.getCreateUserID());
//			vMeetingVO.setCreateUserName(meetingVO.getCreateUserName());
//		}
		// 会议明细
		MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();

		vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));//设置创建时间
		vMeetingDetailVO.setMeetingID(vMeetingVO.getMeetingID());
		vMeetingDetailVO.setMeetingRoomID(vMeetingVO.getMeetingRoomID());
		vMeetingDetailVO.setMeetingRoomName(vMeetingVO.getMeetingRoomName());
		vMeetingDetailVO.setMeetingName(vMeetingVO.getMeetingName());
		vMeetingDetailVO.setMeetingStartTime(vMeetingVO.getMeetingStartTime());
		vMeetingDetailVO.setMeetingEndTime(vMeetingVO.getMeetingEndTime());
		vMeetingDetailVO.setUseNotice(vMeetingVO.getUseNotice());
		vMeetingDetailVO.setUseReach(vMeetingVO.getUseReach());
		vMeetingDetailVO.setMeetingType(vMeetingVO.getMeetingType());
		//meeting table don't have grade field, meeting class has this field.
		vMeetingDetailVO.setGrade(vMeetingVO.getGrade());
		vMeetingDetailVO.setStatus(vMeetingVO.getStatus()+"");
		vMeetingDetailVO.setNotifyType(vMeetingVO.getNotifyType());
		vMeetingDetailVO.setMeetingDescription(vMeetingVO.getMeetingDescription());
		vMeetingDetailVO.setRevision(vMeetingVO.getRevision());
		
		
		vMeetingDetailVO.setCreateUserID(vMeetingVO.getCreateUserID());
		vMeetingDetailVO.setCreateUserName(vMeetingVO.getCreateUserName());
		vMeetingDetailVO.setConfProfileID(vMeetingVO.getConfProfileID());
		MeetingDetailVO meetingDetailVO = MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, null);
//		ArrayList meetingDetailList = MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO, null);
//		MeetingDetailVO meetingDetailVO = (MeetingDetailVO) meetingDetailList.get(0);

		//设置与会人员
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				UserVO userVO = (UserVO) userList.get(i);
				MeetingDetailUserVO vo = new MeetingDetailUserVO();
				vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				vo.setUserID(userVO.getUserID());
				vo.setUserName(userVO.getName());
				vo.setParticipatorID(userVO.getUserID());
				vo.setParticipatorName(userVO.getName());
				MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
				service.addMeetingDetailUser(vo, tManager);
			}
		}
		
		//视频会议需要的会议室
		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
			if (roomList != null && roomList.size() > 0) {
				VideoconferenceService service = new VideoconferenceServiceImpl();
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					service.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
		}
		
//		vMeetingDetailVO.setSendEmailFormat(vMeetingVO.getSendEmailFormat());
//		vMeetingDetailVO.setSendSMSFormat(vMeetingVO.getSendSMSFormat());
//		sendEmail(vMeetingDetailVO,userList,"会议通知！");
		return meetingDetailVO;
	}
	
	
	public MeetingDetailVO modifyMeetingTemplate(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> serviceList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception {
		if (tManager == null) {
			tManager = new TransactionManager();
		}
		
		if(vMeetingVO.getUseNotice() == Integer.MIN_VALUE){
			vMeetingVO.setUseNotice(UseStatusEnum.INVALID);
		}
		if(vMeetingVO.getUseReach() == Integer.MIN_VALUE){
			vMeetingVO.setUseReach(UseStatusEnum.INVALID);
		}
		
		//update meeting detail info
		vMeetingDetailVO.setMeetingID(vMeetingVO.getMeetingID());
		vMeetingDetailVO.setMeetingRoomID(vMeetingVO.getMeetingRoomID());
		vMeetingDetailVO.setMeetingRoomName(vMeetingVO.getMeetingRoomName());
		vMeetingDetailVO.setMeetingName(vMeetingVO.getMeetingName());
		vMeetingDetailVO.setMeetingStartTime(vMeetingVO.getMeetingStartTime());
		vMeetingDetailVO.setMeetingEndTime(vMeetingVO.getMeetingEndTime());
		vMeetingDetailVO.setUseNotice(vMeetingVO.getUseNotice());
		vMeetingDetailVO.setUseReach(vMeetingVO.getUseReach());
		vMeetingDetailVO.setMeetingType(vMeetingVO.getMeetingType());
		//meeting table don't have grade field, meeting class has this field.
		vMeetingDetailVO.setGrade(vMeetingVO.getGrade());
		
		vMeetingDetailVO.setNotifyType(vMeetingVO.getNotifyType());
		vMeetingDetailVO.setMeetingDescription(vMeetingVO.getMeetingDescription());
		vMeetingDetailVO.setRevision(vMeetingVO.getRevision());
		vMeetingDetailVO.setCreateUserID(vMeetingVO.getCreateUserID());
		MeetingDetailDAO.modifyMeetingDetail(vMeetingDetailVO, tManager);
	
		
		//update meeting users : delete all users and add users
		MeetingDetailUserVO temp = new MeetingDetailUserVO();
		temp.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		MeetingDetailUserDAO.delMeetingDetailUserByDetailId(temp, tManager);
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				UserVO userVO = (UserVO) userList.get(i);
				MeetingDetailUserVO vo = new MeetingDetailUserVO();
				vo.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				vo.setUserID(userVO.getUserID());
				vo.setUserName(userVO.getName());
				vo.setParticipatorID(userVO.getUserID());
				vo.setParticipatorName(userVO.getName());
				MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
				service.addMeetingDetailUser(vo, tManager);
			}
		}
		
		//视频会议需要的会议室
		VideoconferenceService videoconferenceService = new VideoconferenceServiceImpl();
		VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
		tempVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		videoconferenceService.delVideoconferenceByDetailId(tempVideoconferenceVO, tManager);
		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
			if (roomList != null && roomList.size() > 0) {
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
					videoconferenceService.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
		}

		return vMeetingDetailVO;
	}

	
	public MeetingDetailVO modifyMeeting(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> serviceList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception {
		if (tManager == null) {
			tManager = new TransactionManager();
		}
		
		//update meeting info
		MeetingVO tempMeetingVO = new MeetingVO();
		tempMeetingVO.setMeetingID(vMeetingVO.getMeetingID());
		ArrayList<MeetingVO> meetingVOList = MeetingDAO.getMeetingList(tempMeetingVO, null);
		if(meetingVOList != null && meetingVOList.size() > 0){
			tempMeetingVO = meetingVOList.get(0);
			
			vMeetingVO.setCreateUserID(tempMeetingVO.getCreateUserID());
			vMeetingVO.setCreateUserName(tempMeetingVO.getCreateUserName());
		}
		if(vMeetingVO.getUseNotice() == Integer.MIN_VALUE){
			vMeetingVO.setUseNotice(UseStatusEnum.INVALID);
		}
		if(vMeetingVO.getUseReach() == Integer.MIN_VALUE){
			vMeetingVO.setUseReach(UseStatusEnum.INVALID);
		}
		
		//because period meeting, so we don't have to modify meeting, we just modify meeting's meetingDetail and I think it's ok.
		if(tempMeetingVO.getPeriodType() == Integer.MIN_VALUE || tempMeetingVO.getPeriodDate() == Integer.MIN_VALUE){ 
			MeetingDAO.modifyMeeting(vMeetingVO, tManager);
		}
		//update meeting detail info
		vMeetingDetailVO.setMeetingID(vMeetingVO.getMeetingID());
		vMeetingDetailVO.setMeetingRoomID(vMeetingVO.getMeetingRoomID());
		vMeetingDetailVO.setMeetingRoomName(vMeetingVO.getMeetingRoomName());
		vMeetingDetailVO.setMeetingName(vMeetingVO.getMeetingName());
		vMeetingDetailVO.setMeetingStartTime(vMeetingVO.getMeetingStartTime());
		vMeetingDetailVO.setMeetingEndTime(vMeetingVO.getMeetingEndTime());
		vMeetingDetailVO.setUseNotice(vMeetingVO.getUseNotice());
		vMeetingDetailVO.setUseReach(vMeetingVO.getUseReach());
		vMeetingDetailVO.setMeetingType(vMeetingVO.getMeetingType());
		//meeting table don't have grade field, meeting class has this field.
		vMeetingDetailVO.setGrade(vMeetingVO.getGrade());
		
		vMeetingDetailVO.setNotifyType(vMeetingVO.getNotifyType());
		vMeetingDetailVO.setMeetingDescription(vMeetingVO.getMeetingDescription());
		vMeetingDetailVO.setRevision(vMeetingVO.getRevision());
		
		vMeetingDetailVO.setParticipatorIDs(vMeetingVO.getParticipatorIDs());
		vMeetingDetailVO.setParticipators(vMeetingVO.getParticipators());
		vMeetingDetailVO.setShowParticipatorNames(vMeetingVO.getShowParticipatorNames());
		vMeetingDetailVO.setNeededEquipmentIDs(vMeetingVO.getNeededEquipmentIDs());
		vMeetingDetailVO.setNeededEquipmentNames(vMeetingVO.getNeededEquipmentNames());
		vMeetingDetailVO.setNeededEquipModelNames(vMeetingVO.getNeededEquipModelNames());
		vMeetingDetailVO.setNeededServiceIDs(vMeetingVO.getNeededServiceIDs());
		vMeetingDetailVO.setNeededServiceNames(vMeetingVO.getNeededServiceNames());
		vMeetingDetailVO.setMeetingRoomNameIDs(vMeetingVO.getMeetingRoomNameIDs());
		vMeetingDetailVO.setMeetingRoomNames(vMeetingVO.getMeetingRoomNames());
		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
			vMeetingDetailVO.setNeededVideoEquipsShow(vMeetingVO.getNeededVideoEquipsShow());
			vMeetingDetailVO.setNeededRooms4Equip(vMeetingVO.getNeededRooms4Equip());
		}
		boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
		//不是周期会议
		if(tempMeetingVO.getPeriodType() == Integer.MIN_VALUE && tempMeetingVO.getPeriodDate() == Integer.MIN_VALUE){
			if(isAvailable){
				//common use
				vMeetingDetailVO.setStatus(MeetingStatus.APPROVED+"");
			}else{
				vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
			}
		}else{
			//周期会议，且是修改会议室冲突的话，检查
			if(isAvailable){
				//meeting in db is invalid, we can change it. this condition is in period meeting confirming.
				if(tempMeetingVO.getStatus() == MeetingStatus.INVALID){
					vMeetingDetailVO.setStatus(MeetingStatus.TO_BE_APPROVED+"");
				}else{
					vMeetingDetailVO.setStatus(tempMeetingVO.getStatus()+"");
				}
				
			}else{
				vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
			}
		}
		vMeetingDetailVO.setCreateUserID(vMeetingVO.getCreateUserID());
		vMeetingDetailVO.setCreateUserName(vMeetingVO.getCreateUserName());
		if(vMeetingVO.getStatus() == MeetingStatus.TEMPLATE){
			// call meeting tempalte to add a meeting.
			vMeetingDetailVO.setMeetingDetailID(null);
			vMeetingDetailVO.setStatus(MeetingStatus.APPROVED+"");
			vMeetingDetailVO.setConfProfileID(vMeetingVO.getConfProfileID());
			MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
			ArrayList<MeetingDetailVO> meetingDettailVOList = MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO, null);
			if(meetingDettailVOList != null && meetingDettailVOList.size() > 0){
				vMeetingDetailVO = meetingDettailVOList.get(meetingDettailVOList.size() - 1);
			}
		}else{
			vMeetingDetailVO.setConfProfileID(vMeetingVO.getConfProfileID());
			MeetingDetailDAO.modifyMeetingDetail(vMeetingDetailVO, tManager);
		}
		if(tempMeetingVO.getPeriodType() != Integer.MIN_VALUE && tempMeetingVO.getPeriodDate() != Integer.MIN_VALUE && vMeetingDetailVO.getStatus() == MeetingStatus.TO_BE_APPROVED+"" ){
			//周期会议中确认页面修改，到此结束
			return vMeetingDetailVO;
		}
		
		//update meeting users : delete all users and add users
		MeetingDetailUserVO temp = new MeetingDetailUserVO();
		temp.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		MeetingDetailUserDAO.delMeetingDetailUserByDetailId(temp, tManager);
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				UserVO userVO = (UserVO) userList.get(i);
				MeetingDetailUserVO vo = new MeetingDetailUserVO();
				vo.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				vo.setUserID(userVO.getUserID());
				vo.setUserName(userVO.getName());
				vo.setParticipatorID(userVO.getUserID());
				vo.setParticipatorName(userVO.getName());
				MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
				service.addMeetingDetailUser(vo, tManager);
			}
		}
		
		//视频会议需要的会议室
		VideoconferenceService videoconferenceService = new VideoconferenceServiceImpl();
		VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
		tempVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		videoconferenceService.delVideoconferenceByDetailId(tempVideoconferenceVO, tManager);
		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
			if (roomList != null && roomList.size() > 0) {
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
					videoconferenceService.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
		}
		/*useless. wangle 2011-11-24
		MeetingServiceService service = new MeetingServiceServiceImpl();
		MeetingServiceVO tempMeetingServiceVO = new MeetingServiceVO();
		tempMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		service.delMeetingService(tempMeetingServiceVO, tManager);
		
		//会议需要的服务
		if (serviceList != null && serviceList.size() > 0) {
			for (int i = 0; i < serviceList.size(); i++) {
				MeetingServiceVO vMeetingServiceVO=serviceList.get(i);
				vMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				service.addMeetingService(vMeetingServiceVO, tManager);
			}
		}
		*/
		vMeetingDetailVO.setSendEmailFormat(vMeetingVO.getSendEmailFormat());
		vMeetingDetailVO.setSendSMSFormat(vMeetingVO.getSendSMSFormat());
		sendEmail(vMeetingDetailVO,userList,"会议调整通知！");
		return vMeetingDetailVO;
	}

	/**
	 * add period meeting's participators, services and video conferences where period meeting status is APPROVED  
	 * @param meetingVO
	 * @param vMeetingDetailVO
	 * @throws SQLException
	 * @author wangle
	 * @since Sep 5, 2009
	 */
	public void addMeetingUVSInfo(MeetingVO meetingVO, MeetingDetailVO vMeetingDetailVO) throws SQLException{
		TransactionManager tManager = new TransactionManager();
		ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
		ArrayList<MeetingServiceVO> meetingServiceVOList = new ArrayList<MeetingServiceVO>();
		ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
		
		//organize users
		String[] participatorIDArray = splitID(vMeetingDetailVO.getParticipatorIDs(), "-");
		if(participatorIDArray != null && participatorIDArray.length > 0){
			String[] participatorArray = splitName(vMeetingDetailVO.getParticipators());
			for(int i=0; i < participatorIDArray.length; i++){
				UserVO userVO = new UserVO();
				userVO.setUserID(participatorIDArray[i]);
				userVO.setName(participatorArray[i]);
				
				userVOList.add(userVO);
			}
		}
		
		/*useless. wangle 2011-11-2
		//organize equipments
		String[] neededEquipmentIDArray = splitID(vMeetingDetailVO.getNeededEquipmentIDs());
		String[] neededRooms4Equip = splitID(vMeetingDetailVO.getNeededRooms4Equip());
		if(neededEquipmentIDArray != null && neededEquipmentIDArray.length > 0){
			String[] neededEquipmentNameArray = splitName(vMeetingDetailVO.getNeededEquipmentNames());
			String[] neededEquipModelNameArray = splitName(vMeetingDetailVO.getNeededEquipModelNames());
			
			int i = 0;
			if(MeetingTypeEnum.isHostMeeting(vMeetingDetailVO.getMeetingType())){
				for(; i < neededEquipmentIDArray.length; i++){
					MeetingServiceVO meetingServiceVO = new MeetingServiceVO();
					meetingServiceVO.setServiceType(MeetinServiceEnum.EQUIPMENT);
					meetingServiceVO.setEquipmentID(Integer.parseInt(neededEquipmentIDArray[i]));
					meetingServiceVO.setEquipmentNameCaption(neededEquipmentNameArray[i]);
					meetingServiceVO.setModelName(neededEquipModelNameArray[i]);
					meetingServiceVO.setMeetingRoomID(vMeetingDetailVO.getMeetingRoomID());
					meetingServiceVOList.add(meetingServiceVO);
				}
			}else{
				if(MeetingTypeEnum.isPolycomMeeting(vMeetingDetailVO.getMeetingType())){
					for(; i < neededEquipmentIDArray.length; i++){
						MeetingServiceVO meetingServiceVO = new MeetingServiceVO();
						meetingServiceVO.setServiceType(MeetinServiceEnum.EQUIPMENT);
						meetingServiceVO.setEquipmentID(Integer.parseInt(neededEquipmentIDArray[i]));
						meetingServiceVO.setEquipmentNameCaption(neededEquipmentNameArray[i]);
						meetingServiceVO.setModelName(neededEquipModelNameArray[i]);
						if(neededRooms4Equip[i] != null && !neededRooms4Equip[i].trim().equals("")){
							meetingServiceVO.setMeetingRoomID(Integer.parseInt(neededRooms4Equip[i]));
						}
						meetingServiceVOList.add(meetingServiceVO);
					}
				}
			}
			
			//check if we should add other equips
			if((i+1) == neededEquipmentNameArray.length){
				MeetingServiceVO meetingServiceVO = new MeetingServiceVO();
				meetingServiceVO.setServiceType(MeetinServiceEnum.EQUIPMENT);
				meetingServiceVO.setDescription(neededEquipmentNameArray[i]);
				
				meetingServiceVOList.add(meetingServiceVO);
			}
		}
		
		//organize services
		String[] neededServiceIDArray = splitID(vMeetingDetailVO.getNeededServiceIDs());
		if(neededServiceIDArray != null && neededServiceIDArray.length > 0){
			String[] neededServiceNameArray = splitName(vMeetingDetailVO.getNeededServiceNames());
			int i = 0;
			for(; i < neededServiceIDArray.length; i++){
				MeetingServiceVO meetingServiceVO = new MeetingServiceVO();
				meetingServiceVO.setServiceType(MeetinServiceEnum.SERVICE);
				meetingServiceVO.setServiceID(Integer.parseInt(neededServiceIDArray[i]));
				meetingServiceVO.setServiceName(neededServiceNameArray[i]);
				
				meetingServiceVOList.add(meetingServiceVO);
			}
			
			if(i < neededServiceNameArray.length){
				String names = "";
				for(int j = i; j < neededServiceNameArray.length; j++){
					if(!names.equals("")){
						names += "、";
					}
					names += neededServiceNameArray[j];
				}
				MeetingServiceVO meetingServiceVO = new MeetingServiceVO();
				meetingServiceVO.setServiceType(MeetinServiceEnum.SERVICE);
				meetingServiceVO.setDescription(names);
				
				meetingServiceVOList.add(meetingServiceVO);
			}
		}
		*/
		
		//organize video conference room
		if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
			String[] meetingRoomNameIDArray = splitID(vMeetingDetailVO.getMeetingRoomNameIDs(), "-");
			int i = 0;
			if(i < meetingRoomNameIDArray.length){
				String[] meetingRoomNameArray = splitName(vMeetingDetailVO.getMeetingRoomNames());
				
				for(; i < meetingRoomNameIDArray.length; i++){
					VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
					videoconferenceVO.setSubmeetingRoomID(meetingRoomNameIDArray[i]);
					videoconferenceVO.setSubmeetingRoomName(meetingRoomNameArray[i]);
					
					videoconferenceVOList.add(videoconferenceVO);
				}
				
				//add the first meting info into meeting table. actually it's unuseful, if we can't choose main conference room 
				if(meetingVO.getMeetingRoomID() != null && meetingVO.getMeetingRoomID().equals("-1")){
					meetingVO.setMeetingRoomID(meetingRoomNameIDArray[0]);
					meetingVO.setMeetingRoomName(meetingRoomNameArray[0]);					
				}
			}	
		}
		
//		update meeting users : delete all users and add users
		MeetingDetailUserVO temp = new MeetingDetailUserVO();
		temp.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		MeetingDetailUserDAO.delMeetingDetailUserByDetailId(temp, tManager);
		if (userVOList != null && userVOList.size() > 0) {
			for (int i = 0; i < userVOList.size(); i++) {
				UserVO userVO = (UserVO) userVOList.get(i);
				MeetingDetailUserVO vo = new MeetingDetailUserVO();
				vo.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				vo.setUserID(userVO.getUserID());
				vo.setUserName(userVO.getName());
				vo.setParticipatorID(userVO.getUserID());
				vo.setParticipatorName(userVO.getName());
				MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
				service.addMeetingDetailUser(vo, tManager);
			}
		}
		
		//视频会议需要的会议室
		VideoconferenceService videoconferenceService = new VideoconferenceServiceImpl();
		VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
		tempVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		videoconferenceService.delVideoconferenceByDetailId(tempVideoconferenceVO, tManager);
		if(MeetingTypeEnum.isPolycomMeeting(meetingVO.getMeetingType())){
			if (videoconferenceVOList != null && videoconferenceVOList.size() > 0) {
				for (int i = 0; i < videoconferenceVOList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) videoconferenceVOList.get(i);
					vVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
					videoconferenceService.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
		}
		/*useless. wangle 2011-11-24
		MeetingServiceService service = new MeetingServiceServiceImpl();
		MeetingServiceVO tempMeetingServiceVO = new MeetingServiceVO();
		tempMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		service.delMeetingService(tempMeetingServiceVO, tManager);
		
		//会议需要的服务
		if (meetingServiceVOList != null && meetingServiceVOList.size() > 0) {
			for (int i = 0; i < meetingServiceVOList.size(); i++) {
				MeetingServiceVO vMeetingServiceVO=meetingServiceVOList.get(i);
				vMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				service.addMeetingService(vMeetingServiceVO, tManager);
			}
		}
		*/
		
	}
	
	public String[] splitName(String names){
		if(names == null || names.trim().equals("")){
			return null;
		}
		
		String[] result = names.split("、");
		return result;
	}
	
	public String[] splitID(String IDs, String spliter){
		if(IDs == null || IDs.trim().equals("")){
			return null;
		}
		
		String[] result = IDs.split(spliter);
		return result;
	}

	/**
	 * method description : getMeetingList
	 * 
	 * @param MeetingVO
	 * @return ArrayList<MeetingVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingVO> getMeetingList(MeetingVO vMeetingVO,
			PageController mPageController) throws SQLException {
		return MeetingDAO.getMeetingList(vMeetingVO, mPageController);
	}

	/**
	 * method description : delMeeting
	 * 
	 * @param MeetingVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeeting(MeetingVO vMeetingVO, TransactionManager tManager)
			throws SQLException {
		boolean re = false;
		if (1 == MeetingDAO.delMeeting(vMeetingVO, tManager)) {
			re = true;
		}
		return re;
	}
	
	/**
	 * method description : delete Meeting 
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public boolean delMeeting(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
	throws SQLException{
		boolean re = false;
		if (tManager == null) {
			tManager = new TransactionManager();
		}
		
		ArrayList<MeetingVO> meetingVOList = MeetingDAO.getMeetingList(vMeetingVO, null);
		if(meetingVOList != null && meetingVOList.size() > 0){
			vMeetingVO = meetingVOList.get(0);
			
			//delete all users 
			MeetingDetailUserVO temp = new MeetingDetailUserVO();
			temp.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
			MeetingDetailUserDAO.delMeetingDetailUserByDetailId(temp, tManager);
			
			//视频会议需要的会议室
			if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
				VideoconferenceService service = new VideoconferenceServiceImpl();
				VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
				tempVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				service.delVideoconferenceByDetailId(tempVideoconferenceVO, tManager);	
			}
			/*useless. wangle 2011-11-24
			//会议需要的服务
			MeetingServiceService service = new MeetingServiceServiceImpl();
			MeetingServiceVO tempMeetingServiceVO = new MeetingServiceVO();
			tempMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
			service.delMeetingService(tempMeetingServiceVO, tManager);
			*/
			
			//delete meeting detail
			ArrayList<MeetingDetailVO> meetingDetailVOList = MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				MeetingDetailVO meetingDetailDB = meetingDetailVOList.get(0);
				meetingDetailDB.setStatus(MeetingStatus.INVALID+"");
				MeetingDetailDAO.modifyMeetingDetail(meetingDetailDB, tManager);
			}
			
			//delete meeting 
			//consider this condition : a meeeting has many meetingDetails
			
//			if (1 == MeetingDAO.delMeeting(vMeetingVO, tManager)) {
//				re = true;
//			}
		}
		ArrayList userVOList = new ArrayList();
		String[] participatorIDArray = splitID(vMeetingVO.getParticipatorIDs(), "-");
		if(participatorIDArray != null && participatorIDArray.length > 0){
			String[] participatorArray = splitName(vMeetingVO.getParticipators());
			for(int i=0; i < participatorIDArray.length; i++){
				UserVO userVO = new UserVO();
				userVO.setUserID(participatorIDArray[i]);
				userVO.setName(participatorArray[i]);
				
				userVOList.add(userVO);
			}
		}
		
		vMeetingDetailVO.setSendEmailFormat(vMeetingVO.getSendEmailFormat());
		vMeetingDetailVO.setSendSMSFormat(vMeetingVO.getSendSMSFormat());
		sendEmail(vMeetingDetailVO,userVOList,"会议取消");
		return re;
	}

	
	/**
	 * method description : unDelMeeting Meeting 
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public boolean unDelMeeting(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
	throws SQLException{
		boolean re = false;
		if (tManager == null) {
			tManager = new TransactionManager();
		}
		
		ArrayList<MeetingVO> meetingVOList = MeetingDAO.getMeetingList(vMeetingVO, null);
		if(meetingVOList != null && meetingVOList.size() > 0){
			vMeetingVO = meetingVOList.get(0);
			
			//delete all users 
			MeetingDetailUserVO temp = new MeetingDetailUserVO();
			temp.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
			MeetingDetailUserDAO.delMeetingDetailUserByDetailId(temp, tManager);
			
			//视频会议需要的会议室
			if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
				VideoconferenceService service = new VideoconferenceServiceImpl();
				VideoconferenceVO tempVideoconferenceVO = new VideoconferenceVO();
				tempVideoconferenceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
				service.delVideoconferenceByDetailId(tempVideoconferenceVO, tManager);	
			}
			/*useless. wangle 2011-11-24
			//会议需要的服务
			MeetingServiceService service = new MeetingServiceServiceImpl();
			MeetingServiceVO tempMeetingServiceVO = new MeetingServiceVO();
			tempMeetingServiceVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
			service.delMeetingService(tempMeetingServiceVO, tManager);
			*/
			
			//delete meeting detail
			ArrayList<MeetingDetailVO> meetingDetailVOList = MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				MeetingDetailVO meetingDetailDB = meetingDetailVOList.get(0);
				meetingDetailDB.setStatus(MeetingStatus.END+"");
				
				MeetingDetailDAO.modifyMeetingDetail(meetingDetailDB, tManager);
			}
			
			//delete meeting 
			//consider this condition : a meeeting has many meetingDetails
			
//			if (1 == MeetingDAO.delMeeting(vMeetingVO, tManager)) {
//				re = true;
//			}
		}
		ArrayList userVOList = new ArrayList();
		String[] participatorIDArray = splitID(vMeetingVO.getParticipatorIDs(), "-");
		if(participatorIDArray != null && participatorIDArray.length > 0){
			String[] participatorArray = splitName(vMeetingVO.getParticipators());
			for(int i=0; i < participatorIDArray.length; i++){
				UserVO userVO = new UserVO();
				userVO.setUserID(participatorIDArray[i]);
				userVO.setName(participatorArray[i]);
				
				userVOList.add(userVO);
			}
		}
		
		vMeetingDetailVO.setSendEmailFormat(vMeetingVO.getSendEmailFormat());
		vMeetingDetailVO.setSendSMSFormat(vMeetingVO.getSendSMSFormat());
		sendEmail(vMeetingDetailVO,userVOList,"会议取消");
		return re;
	}

	/**
	 * method description : modify Meeting state by id
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingVO delMeetingForState(MeetingVO vMeetingVO,
			TransactionManager tManager) throws SQLException {
		return modifyMeeting(vMeetingVO, tManager);
	}

	/**
	 * method description : modify Meeting all columns by id
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingVO modifyMeeting(MeetingVO vMeetingVO,
			TransactionManager tManager) throws SQLException {
		return MeetingDAO.modifyMeeting(vMeetingVO, tManager);
	}

	/**
	 * method description : add period Meeting
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
//	public MeetingVO preSubscribePeriodMeeting(MeetingVO vMeetingVO, TransactionManager tManager) throws Exception{
//		if (tManager == null) {
//			tManager = new TransactionManager();
//		}
//		
//		//select every day meeting, set periodDate value here. otherwise, value will be passed from the page.
//		if(vMeetingVO.getPeriodType().intValue() == PeriodMeetingTypeEnum.DAY){
//			vMeetingVO.setPeriodDate(PeriodMeetingDateEnum.PERIOD_MEETING_DATE_DAY);
//		}
//		
//		if(vMeetingVO.getPeriodType().intValue() == PeriodMeetingTypeEnum.MONTH){
//			vMeetingVO.setPeriodDate(vMeetingVO.getPeriodDateMonth());
//		}
//		
//		// 会议表
////		organize video conference room
//		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
//			String[] meetingRoomNameIDArray = splitID(vMeetingVO.getMeetingRoomNameIDs(), "-");
//			String[] meetingRoomNameArray = splitName(vMeetingVO.getMeetingRoomNames());
//		
//			if(meetingRoomNameIDArray.length > 0 && meetingRoomNameArray.length > 0){
//				//add the first meting info into meeting table. actually it's unuseful, if we can't choose main conference room 
//				if(vMeetingVO.getMeetingRoomID() != null && vMeetingVO.getMeetingRoomID().equals("-1")){
//					vMeetingVO.setMeetingRoomID(meetingRoomNameIDArray[0]);
//					vMeetingVO.setMeetingRoomName(meetingRoomNameArray[0]);					
//				}
//			}
//		}
//		if(vMeetingVO.getUseNotice() == Integer.MIN_VALUE){
//			vMeetingVO.setUseNotice(UseStatusEnum.INVALID);
//		}
//		if(vMeetingVO.getUseReach() == Integer.MIN_VALUE){
//			vMeetingVO.setUseReach(UseStatusEnum.INVALID);
//		}
//		String startTime = getTimeStandFormat(vMeetingVO.getStartTime());
//		startTime += " " + vMeetingVO.getPeriodStartHourMins().trim();
//		vMeetingVO.setStartTime(getDateFromStr(startTime));
//		
//		String endTime = getTimeStandFormat(vMeetingVO.getEndTime());
//		endTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//		vMeetingVO.setEndTime(getDateFromStr(endTime));
//		
//		vMeetingVO.setStatus(MeetingStatus.TO_BE_APPROVED);
//		MeetingVO meetingVO = MeetingDAO.addMeeting(vMeetingVO, tManager);
////		ArrayList meetingList = MeetingDAO.getMeetingList(vMeetingVO, null);
////		MeetingVO meetingVO = new MeetingVO();
////		if(meetingList.size() > 0){
////			meetingVO = (MeetingVO) meetingList.get(meetingList.size() - 1);
////			
////			vMeetingVO.setCreateUserID(meetingVO.getCreateUserID());
////			vMeetingVO.setCreateUserName(meetingVO.getCreateUserName());
////		}
//
//		// 会议明细
//		MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
//		vMeetingDetailVO.setMeetingID(meetingVO.getMeetingID());
//		vMeetingDetailVO.setMeetingName(meetingVO.getMeetingName());
//		vMeetingDetailVO.setMeetingRoomID(meetingVO.getMeetingRoomID());
//		vMeetingDetailVO.setMeetingRoomName(meetingVO.getMeetingRoomName());
//		vMeetingDetailVO.setUseNotice(meetingVO.getUseNotice());
//		vMeetingDetailVO.setUseReach(meetingVO.getUseReach());
//		vMeetingDetailVO.setMeetingType(meetingVO.getMeetingType());
//		//meeting table don't have grade field, meeting class has this field.
//		vMeetingDetailVO.setGrade(vMeetingVO.getGrade());
//		vMeetingDetailVO.setNotifyType(meetingVO.getNotifyType());
//		vMeetingDetailVO.setMeetingDescription(meetingVO
//				.getMeetingDescription());
//		vMeetingDetailVO.setRevision(meetingVO.getRevision());
//		
//		vMeetingDetailVO.setParticipatorIDs(vMeetingVO.getParticipatorIDs());
//		vMeetingDetailVO.setParticipators(vMeetingVO.getParticipators());
//		vMeetingDetailVO.setShowParticipatorNames(vMeetingVO.getShowParticipatorNames());
//		vMeetingDetailVO.setNeededEquipmentIDs(vMeetingVO.getNeededEquipmentIDs());
//		vMeetingDetailVO.setNeededEquipmentNames(vMeetingVO.getNeededEquipmentNames());
//		vMeetingDetailVO.setNeededEquipModelNames(vMeetingVO.getNeededEquipModelNames());
//		vMeetingDetailVO.setNeededServiceIDs(vMeetingVO.getNeededServiceIDs());
//		vMeetingDetailVO.setNeededServiceNames(vMeetingVO.getNeededServiceNames());
//		vMeetingDetailVO.setMeetingRoomNameIDs(vMeetingVO.getMeetingRoomNameIDs());
//		vMeetingDetailVO.setMeetingRoomNames(vMeetingVO.getMeetingRoomNames());
//		if(MeetingTypeEnum.isPolycomMeeting(vMeetingVO.getMeetingType())){
//			vMeetingDetailVO.setNeededVideoEquipsShow(vMeetingVO.getNeededVideoEquipsShow());
//			vMeetingDetailVO.setNeededRooms4Equip(vMeetingVO.getNeededRooms4Equip());
//		}
//		vMeetingDetailVO.setCreateUserID(vMeetingVO.getCreateUserID());
//		vMeetingDetailVO.setCreateUserName(vMeetingVO.getCreateUserName());
//		vMeetingDetailVO.setStatus(MeetingStatus.TO_BE_APPROVED+"");
//		
//		String firstStartTime = getTimeStandFormat(vMeetingVO.getStartTime());
//		firstStartTime += " " + vMeetingVO.getPeriodStartHourMins().trim();
//		Timestamp firstStartTimestamp = getDateFromStr(firstStartTime);
//		Calendar now = Calendar.getInstance();
//		
//		//select every day meeting
//		if(vMeetingVO.getPeriodType() == PeriodMeetingTypeEnum.DAY){
//			String firstEndTime = getTimeStandFormat(vMeetingVO.getStartTime());
//			firstEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//			Timestamp firstEndTimestamp = getDateFromStr(firstEndTime);
//			
//			String lastEndTime = getTimeStandFormat(vMeetingVO.getEndTime());
//			lastEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//			Timestamp lastEndTimestamp = getDateFromStr(lastEndTime);
//			
//			Calendar cFirstStartTime = Calendar.getInstance();
//			Calendar cFirstEndTime = Calendar.getInstance();
//			cFirstStartTime.setTime(new Date(firstStartTimestamp.getTime()));
//			cFirstEndTime.setTime(new Date(firstEndTimestamp.getTime()));
//			
//			//include first day and last day.
//			int days = (int)((lastEndTimestamp.getTime() - firstStartTimestamp.getTime())/(1000*60*60*24));
//			vMeetingDetailVO.setMeetingStartTime(new Timestamp(cFirstStartTime.getTimeInMillis()));
//			vMeetingDetailVO.setMeetingEndTime(new Timestamp(cFirstEndTime.getTimeInMillis()));
//			if(now.getTimeInMillis() <= cFirstStartTime.getTimeInMillis()){
//				//add the first day's meeting detail
//				boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//				if(!isAvailable){
//					vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//				}
//				MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
//			}
//			for(int i = 0; i < days; i++){
//				//add one day
//				cFirstStartTime.add(Calendar.DAY_OF_MONTH, 1);
//				cFirstEndTime.add(Calendar.DAY_OF_MONTH, 1);
//				vMeetingDetailVO.setMeetingStartTime(new Timestamp(cFirstStartTime.getTimeInMillis()));
//				vMeetingDetailVO.setMeetingEndTime(new Timestamp(cFirstEndTime.getTimeInMillis()));
//				
//				//add meeting detail
//				boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//				if(!isAvailable){
//					vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//				}
//				MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);	
//			}
//		}else{
//			Timestamp lastMeetingTime = vMeetingVO.getEndTime();
//			
//			//select every week meeting
//			if(vMeetingVO.getPeriodType() == PeriodMeetingTypeEnum.WEEK){
//				int periodDate = vMeetingVO.getPeriodDate();
//				firstStartTimestamp = getFirstAvailStartTime(firstStartTimestamp, periodDate);
//				vMeetingDetailVO.setMeetingStartTime(firstStartTimestamp);
//				
//				String firstEndTime = getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime());
//				firstEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//				Timestamp firstEndTimestamp = getDateFromStr(firstEndTime);
//				vMeetingDetailVO.setMeetingEndTime(firstEndTimestamp);
//				
//				Calendar cFirstStartTime = Calendar.getInstance();
//				Calendar cFirstEndTime = Calendar.getInstance();
//				cFirstStartTime.setTimeInMillis(firstStartTimestamp.getTime());
//				cFirstEndTime.setTimeInMillis(firstEndTimestamp.getTime());
//				//add the first day's meeting detail
//				if(now.getTimeInMillis() <= cFirstStartTime.getTimeInMillis()){
//					boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//					if(!isAvailable){
//						vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//					}
//					MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);	
//				}
//				//add 7 days
//				cFirstStartTime.add(Calendar.DAY_OF_MONTH, 7);
//				cFirstEndTime.add(Calendar.DAY_OF_MONTH, 7);
//				
//				vMeetingDetailVO.setMeetingStartTime(new Timestamp(cFirstStartTime.getTimeInMillis()));
//				vMeetingDetailVO.setMeetingEndTime(new Timestamp(cFirstEndTime.getTimeInMillis()));
//				
//				while(vMeetingDetailVO.getMeetingEndTime().getTime() < lastMeetingTime.getTime()){
//					//add meeting detail
//					boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//					if(!isAvailable){
//						vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//					}
//					MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
//					//add 7 days
//					cFirstStartTime.add(Calendar.DAY_OF_MONTH, 7);
//					cFirstEndTime.add(Calendar.DAY_OF_MONTH, 7);
//					
//					vMeetingDetailVO.setMeetingStartTime(new Timestamp(cFirstStartTime.getTimeInMillis()));
//					vMeetingDetailVO.setMeetingEndTime(new Timestamp(cFirstEndTime.getTimeInMillis()));
//				}
//			}else{
//				//select every month week
//				if(vMeetingVO.getPeriodType() == PeriodMeetingTypeEnum.MONTH){
//					int periodDate = vMeetingVO.getPeriodDate();
//					int maxDaysInMonth = 0;
//					
//					Calendar cFirstStartTimestamp = Calendar.getInstance();
//					cFirstStartTimestamp.setTimeInMillis(firstStartTimestamp.getTime());
//					
//					maxDaysInMonth = getDaysInMonth(cFirstStartTimestamp.get(Calendar.YEAR), cFirstStartTimestamp.get(Calendar.MONTH)+1);
//					if(periodDate > maxDaysInMonth){
//						//if this month's max days is less than periodDate(like 31), back to this month's last day
//						cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, maxDaysInMonth);
//						firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//					}else{
//						//set period date
//						cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, periodDate);
//						firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//					}
//					
//					//the first month: if the subscribing meeting is in the coming day of this month, add it. 
//					if(firstStartTimestamp.getTime() >= now.getTimeInMillis()){
//						vMeetingDetailVO.setMeetingStartTime(firstStartTimestamp);
//						String firstEndTime = getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime());
//						firstEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//						Timestamp firstEndTimestamp = getDateFromStr(firstEndTime);
//						vMeetingDetailVO.setMeetingEndTime(firstEndTimestamp);
//						
//						boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//						if(!isAvailable){
//							vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//						}
//						MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
//					}
//					
//					//internal months
//					now.setTimeInMillis(meetingVO.getEndTime().getTime());
//					cFirstStartTimestamp.setTimeInMillis(meetingVO.getStartTime().getTime());
//					int months = (now.get(Calendar.YEAR) - cFirstStartTimestamp.get(Calendar.YEAR)) * 12 + (now.get(Calendar.MONTH) - cFirstStartTimestamp.get(Calendar.MONTH) - 1);
//					cFirstStartTimestamp.setTimeInMillis(firstStartTimestamp.getTime());
//					for(int i = 0; i < months; i++){
//						//at first, set day into 1. To avoid this condition: add 1 monthsm, if this month has not 31 days, then month will add 1 automatically.
//						cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, 1);
//						cFirstStartTimestamp.add(Calendar.MONTH, 1);
//						firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//						System.out.println(" " + cFirstStartTimestamp.get(Calendar.YEAR)+ "-"+ cFirstStartTimestamp.get(Calendar.MONTH) + "-"+ cFirstStartTimestamp.get(Calendar.DAY_OF_MONTH));
//						
//						maxDaysInMonth = getDaysInMonth(cFirstStartTimestamp.get(Calendar.YEAR), cFirstStartTimestamp.get(Calendar.MONTH) + 1);
//						if(periodDate > maxDaysInMonth){
//							//if this month's max days is less than periodDate(like 31), back to this month's last day
//							cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, maxDaysInMonth);
//							firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//						}else{
//							//reset period date.
//							cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, periodDate);
//							firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//						}
//						
//						vMeetingDetailVO.setMeetingStartTime(firstStartTimestamp);
//						
//						String firstEndTime = getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime());
//						firstEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//						Timestamp firstEndTimestamp = getDateFromStr(firstEndTime);
//						vMeetingDetailVO.setMeetingEndTime(firstEndTimestamp);
//						
//						boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//						if(!isAvailable){
//							vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//						}
//						MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
//						
//					}
//					
//					//the last month
//					cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, 1);
//					cFirstStartTimestamp.add(Calendar.MONTH, 1);
//					firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//					
//					maxDaysInMonth = getDaysInMonth(cFirstStartTimestamp.get(Calendar.YEAR), cFirstStartTimestamp.get(Calendar.MONTH) + 1);
//					if(periodDate > maxDaysInMonth){
//						//if this month's max days is less than periodDate(like 31), back to this month's last day
//						cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, maxDaysInMonth);
//						firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//					}else{
//						//reset period date.
//						cFirstStartTimestamp.set(Calendar.DAY_OF_MONTH, periodDate);
//						firstStartTimestamp.setTime(cFirstStartTimestamp.getTimeInMillis());
//					}
//					vMeetingDetailVO.setMeetingStartTime(firstStartTimestamp);
//					
//					String firstEndTime = getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime());
//					firstEndTime += " " + vMeetingVO.getPeriodEndHourMins().trim();
//					Timestamp firstEndTimestamp = getDateFromStr(firstEndTime);
//					vMeetingDetailVO.setMeetingEndTime(firstEndTimestamp);
//					
//					if(meetingVO.getEndTime().getTime() >= vMeetingDetailVO.getMeetingEndTime().getTime()){
//						boolean isAvailable = checkAvailableMeetingRoom(vMeetingDetailVO, null);
//						if(!isAvailable){
//							vMeetingDetailVO.setStatus(MeetingStatus.INVALID+"");
//						}
//						MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
//					}
//				}
//			}
//		}
//		
//		return meetingVO;
//	}
	
	/**
	 * check if a  meeting's  room is available.  
	 * @param vMeetingDetailVO
	 * @return
	 * @author wangle
	 * @since Sep 8, 2009
	 
	public boolean checkAvailableMeetingRoom(MeetingDetailVO vMeetingDetailVO, ArrayList<String> invalidList){
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		meetingDetailVO.setMeetingStartTime(vMeetingDetailVO.getMeetingStartTime());
		meetingDetailVO.setMeetingEndTime(vMeetingDetailVO.getMeetingEndTime());
		MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
		boolean flag = false;
		try {
			ArrayList<MeetingRoomVO> meetingRoomVOList = meetingRoomService.getEmptyMeetingRoomList(meetingDetailVO, null);
			if(meetingRoomVOList != null && meetingRoomVOList.size() > 0){
				if(MeetingTypeEnum.isHostMeeting(vMeetingDetailVO.getMeetingType())){
					for(MeetingRoomVO meetingRoom : meetingRoomVOList){
						if(meetingRoom.getMeetingRoomID().equals(vMeetingDetailVO.getMeetingRoomID())){
							flag = true;
						}
					}
					if(!flag && invalidList != null){
						invalidList.add(String.valueOf(vMeetingDetailVO.getMeetingRoomID()));
					}
				}else{
					//handle video conference conditon: ask all rooms are free.
					if(MeetingTypeEnum.isPolycomMeeting(vMeetingDetailVO.getMeetingType())){
						String meetingRoomIDs = vMeetingDetailVO.getMeetingRoomNameIDs();
						String roomIDs[] = splitID(meetingRoomIDs, ",");
						for(int i = 0; i < roomIDs.length; i++){
							for(MeetingRoomVO meetingRoom : meetingRoomVOList){
								//System.out.println("meetingRoomID = " + meetingRoom.getMeetingRoomID());
								if(meetingRoom.getMeetingRoomID().equals(roomIDs[i].trim())){
									flag = true;
									break;
								}
							}
							
							if(!flag){
								if(invalidList != null){
									invalidList.add(roomIDs[i]);
								}
								break;
							}
							
							//reset
							if(i != roomIDs.length - 1){
								flag = false;
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	*/
	public boolean checkAvailableMeetingRoom(MeetingDetailVO vMeetingDetailVO, ArrayList<String> invalidList){
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		meetingDetailVO.setMeetingStartTime(vMeetingDetailVO.getMeetingStartTime());
		meetingDetailVO.setMeetingEndTime(vMeetingDetailVO.getMeetingEndTime());
		MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
		boolean flag = false;
		try {
			ArrayList<MeetingRoomVO> meetingRoomVOList = meetingRoomService.getEmptyMeetingRoomList(meetingDetailVO, null);
			if(meetingRoomVOList != null && meetingRoomVOList.size() > 0){
				String meetingRoomIDs = vMeetingDetailVO.getMeetingRoomNameIDs();
				String meetingRoomNames = vMeetingDetailVO.getMeetingRoomNames();
				String roomIDs[] = splitID(meetingRoomIDs, ",");
				String roomNames[] = splitID(meetingRoomNames, ",");
				if(roomIDs==null||roomNames==null){
				}else{
				for(int i = 0; i < roomIDs.length; i++){
					for(MeetingRoomVO meetingRoom : meetingRoomVOList){
						//System.out.println("meetingRoomID = " + meetingRoom.getMeetingRoomID());
						if(meetingRoom.getMeetingRoomID().equals(roomIDs[i].trim())){
							flag = true;
							break;
						}
					}
					
					if(!flag){
						if(invalidList != null){
							for(String name : invalidList){
								if(name.equals(roomNames[i])){
									flag = true;
									break;
								}
							}
							if(!flag){
								invalidList.add(roomNames[i]);
							}
						}
					}
					
					//reset
					if(i != roomIDs.length - 1){
						flag = false;
					}
				}
			}}else{
				if(invalidList != null){
					invalidList.add(vMeetingDetailVO.getMeetingRoomNames());
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	/**
	 * get max days.
	 * @param year
	 * @param mon
	 * @return
	 * @author wangle
	 * @since Feb 28, 2009
	 */
	public int getDaysInMonth(int year, int mon){   
	  java.util.GregorianCalendar date = new java.util.GregorianCalendar(year,mon-1,1);   
	  
	  return   (date.getActualMaximum(Calendar.DATE));   
	}
	
	/**
	 * get the first available meeting start time
	 * @param firstStartTimestamp
	 * @param periodDate
	 * @return
	 * @author wangle
	 * @since Aug 28, 2009
	 */
//	public Timestamp getFirstAvailStartTime(Timestamp firstStartTimestamp, int periodDate){
//		Calendar c = Calendar.getInstance();
//		c.setTimeInMillis(firstStartTimestamp.getTime());
//		
//		int weekDay = PeriodMeetingDateEnum.map.get(new Integer(periodDate));
//		if(c.get(Calendar.DAY_OF_WEEK) == weekDay){
//			return firstStartTimestamp;
//		}else{
//			for(int i = 0; i < 7; i++){
//				c.add(Calendar.DAY_OF_MONTH, 1);
//				if(c.get(Calendar.DAY_OF_WEEK) == weekDay){
//					break;
//				}
//			}
//		}
//		
//		return new Timestamp(c.getTimeInMillis());
//	}
	
	public static String getTimeStandFormat(Timestamp timestamp){
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(timestamp);
	}
	
	public static Timestamp getDateFromStr(String strdate){		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设定格式
	    dateFormat.setLenient(false);
		java.util.Date timeDate= new java.util.Date();
		try {
			timeDate = dateFormat.parse(strdate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}//util类型
		  java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
		  
		  return dateTime;
	}
	
	//取参会人员的邮箱
//	private String[] getToAdd(ArrayList<UserVO> list){
//		String[] toAdd=null;
//		try{
//			String add="";
//			String ids="";
//			if(list.size() > 0){//取参会人id
//				ids=list.get(0).getUserID()+"";
//				for(int i=1; i < list.size(); i++){
//					ids = ids+","+list.get(i).getUserID();
//				}
//				//根据参会人id的 查询参会人的Email
//				UserService service = new UserServiceImpl();
//				ArrayList eList=service.getListForIDS(ids, null);
//				if(eList.size() > 0){
//					for(int i=0; i < eList.size(); i++){
//						UserVO userVO =(UserVO)eList.get(i);
//						String u = userVO.getEmail();
//						if(u!=null){
//							String[] e=u.split(",");
//							if(e!=null&&e.length>0){
//								add=add+e[0]+",";
//							}
//						}
//					}
//					toAdd=add.split(",");
//				}
//			}
//		}catch(Exception e){
//					
//		}
//		return toAdd;
//	}
	
	private void sendEmail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,String title) throws SQLException{
		logger.info("MeetingServiceImpl sendEmail begin ");
//		
//		String emailFormat = vMeetingDetailVO.getSendEmailFormat();
//		String smsFormat = vMeetingDetailVO.getSendSMSFormat();
//		logger.info("发送格式............"+emailFormat+"----"+smsFormat);
//		UserService userService=new UserServiceImpl(); 
//		ArrayList<UserVO> userListInfo = new ArrayList<UserVO>();
//		logger.info("开始发送短信程序................");
//		for(int i=0;i<userList.size();i++){
//			UserVO tmpUserVO=userList.get(i);
//			ArrayList<UserVO> lstUser=userService.getUserList(tmpUserVO, null);
//			userListInfo.add(lstUser.get(0));
//
//		}
//		logger.info("MeetingServiceImpl sendEmail userList lize  : "+userListInfo.size());
//		logger.info("MeetingServiceImpl sendEmail  notice  type : "+vMeetingDetailVO.getNotifyType());
//		if(UseStatusEnum.VALID==Integer.parseInt(vMeetingDetailVO.getNotifyType().charAt(0)+"")){
//			logger.info("MeetingServiceImpl sendEmail sms ");
//			//短信通知
//			SmsInfoVO smsInfoVO=new SmsInfoVO();
//		 
//			
//			for(int i=0;i<userListInfo.size();i++){
//				UserVO userVO=userListInfo.get(i);
//				logger.info("开始发送短信................");
//				if(userVO.getMobile()!=null&&userVO.getMobile()!=""){
//					logger.info(userVO.getMobile());
//					smsInfoVO.setUserID(userVO.getUserID().toString());
//					smsInfoVO.setUserName(userVO.getName());
//					smsInfoVO.setMobile(userVO.getMobile());
//					SmsSendUtil smsSendUtil=new SmsSendUtil();
//					logger.info("检测端口开始............////////////");
//					smsSendUtil.test();
//					logger.info("检测端口结束//////////////???????????????");
//					if(smsFormat!=null&&smsFormat.length()>0){
//						smsFormat = smsFormat.replace("startime", vMeetingDetailVO.getMeetingStartTime().toString().substring(0,16));
//						smsFormat = smsFormat.replace("endtime", vMeetingDetailVO.getMeetingEndTime().toString().substring(0,16));
//						smsFormat = smsFormat.replace("meetingroom", vMeetingDetailVO.getMeetingRoomName());
//						smsFormat = smsFormat.replace("meeingname", vMeetingDetailVO.getMeetingName());
//						smsFormat = smsFormat.replace("creatmeetingUser", vMeetingDetailVO.getCreateUserName());
//						smsSendUtil.sendMsg(smsInfoVO.getMobile(), smsFormat);
//					}
//					
//			}
//			}
//		}
//		if(UseStatusEnum.VALID==Integer.parseInt(vMeetingDetailVO.getNotifyType().charAt(1)+"")){
//			logger.info("MeetingServiceImpl sendEmail email");
//			//发送邮件
//			String[] toAdd=getToAdd(userList);
//			if(emailFormat!=null&&emailFormat.length()>0){
//				emailFormat = emailFormat.replace("meetingType", MeetingTypeEnum.getMeetingTypeName(vMeetingDetailVO.getMeetingType())+"<br/>");
//				emailFormat = emailFormat.replace("meetingName", vMeetingDetailVO.getMeetingName()+"<br/>");
//				emailFormat = emailFormat.replace("meetingroomName", vMeetingDetailVO.getMeetingRoomName()+"<br/>");
//				emailFormat = emailFormat.replace("meetingStartTime", vMeetingDetailVO.getMeetingStartTime().toString().substring(0,16)+"<br/>");
//				emailFormat = emailFormat.replace("meetingEndTime", vMeetingDetailVO.getMeetingEndTime().toString().substring(0,16)+"<br/>");
//				emailFormat = emailFormat.replace("meetingGrade", MeetingGradeEnum.getGradeName(vMeetingDetailVO.getGrade().intValue())+"<br/>");
//				emailFormat = emailFormat.replace("meetingCreateUser", vMeetingDetailVO.getCreateUserName()+"<br/>");
//				emailFormat = emailFormat.replace("meetingDescription", vMeetingDetailVO.getMeetingDescription()+"<br/>");
//				
//				new SendEmail().sendEmail(toAdd,title,emailFormat);
//			}
//		}
//		if(UseStatusEnum.VALID==Integer.parseInt(vMeetingDetailVO.getNotifyType().charAt(2)+"")){
//			//发送OA
//			logger.info("MeetingServiceImpl sendEmail oa");
//		}
		logger.info("MeetingServiceImpl sendEmail end ");
	}


	@Override
	public MeetingDetailVO addMeetingByStatus(MeetingDetailVO vMeetingDetailVO,
			ArrayList<UserVO> userList, ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager, int meetingType) {
		
			try{
				if (tManager == null) {
					tManager = new TransactionManager();
				}
				
				// 会议表
				if(vMeetingDetailVO.getUseNotice() == Integer.MIN_VALUE){
					vMeetingDetailVO.setUseNotice(UseStatusEnum.INVALID);
				}
				if(vMeetingDetailVO.getUseReach() == Integer.MIN_VALUE){
					vMeetingDetailVO.setUseReach(UseStatusEnum.INVALID);
				}
				if("".equals(vMeetingDetailVO.getStatus()) || Integer.parseInt(vMeetingDetailVO.getStatus())!= MeetingStatus.SAVED){
					vMeetingDetailVO.setStatus(meetingType+"");
				}
				// 会议明细

				vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));//设置创建时间
				
				MeetingDetailVO meetingDetailVO = MeetingDetailDAO.addMeetingDetail2(vMeetingDetailVO, null);

				//设置与会人员
				if (userList != null && userList.size() > 0) {
					for (int i = 0; i < userList.size(); i++) {
						UserVO userVO = (UserVO) userList.get(i);
						MeetingDetailUserVO vo = new MeetingDetailUserVO();
						vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
						vo.setUserID(userVO.getUserID());
						vo.setUserName(userVO.getName());
						vo.setParticipatorID(userVO.getUserID());
						vo.setParticipatorName(userVO.getName());
						MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
						service.addMeetingDetailUser(vo, tManager);
					}
				}
				
				//视频会议需要的会议室
				if(MeetingTypeEnum.isPolycomMeeting(vMeetingDetailVO.getMeetingType())){
					if (roomList != null && roomList.size() > 0) {
						VideoconferenceService service = new VideoconferenceServiceImpl();
						for (int i = 0; i < roomList.size(); i++) {
							VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
							vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
							try{
								service.addVideoconference(vVideoconferenceVO, tManager);
							}catch( SQLException se){
								se.printStackTrace();//由于联合主键依然可能重复 导致无法插入
								continue;
							}
						}
					}
				}
				
//				vMeetingDetailVO.setSendEmailFormat(vMeetingVO.getSendEmailFormat());
//				vMeetingDetailVO.setSendSMSFormat(vMeetingVO.getSendSMSFormat());
//				sendEmail(vMeetingDetailVO,userList,"会议通知！");
				return meetingDetailVO;
			}catch( Exception e ){
				e.printStackTrace();
				return null;
			}	
		
	}

		

}
