package com.zzst.service.meeting.meetingDetail;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.meetingDetailDepartment.MeetingDetailDepartMentService;
import com.zzst.service.meeting.meetingDetailDepartment.MeetingDetailDepartMentServiceImpl;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserService;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserServiceImpl;
import com.zzst.service.meeting.videoconference.VideoconferenceService;
import com.zzst.service.meeting.videoconference.VideoconferenceServiceImpl;

/**
 * class description: MeetingDetail Impl
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailServiceImpl implements MeetingDetailService {

	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailServiceImpl.class.getName());
	@Override
	public  ArrayList<MeetingDetailVO> queryForDepartment(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {
				return MeetingDetailDAO.queryForDepartment(vMeetingDetailVO,mPageController);
	}
	
	@Override
	public ArrayList<MeetingDetailVO> query(MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {
		return MeetingDetailDAO.query(vMeetingDetailVO,mPageController);
	}
	
	@Override
	public MeetingDetailVO queryByID(String id)
			throws SQLException {
			return MeetingDetailDAO.queryByID(id);
	}
	
	/**
	 * 会议总览专用
	 * @param vMeetingDetailVO
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailVO> queryForPandect(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws Exception {
		return MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO,vMeetingDetailVO.getStatus() , mPageController);
	}
	
	 
	
	/**
	 * 添加本地会议
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * String departIDs     以“,”分割
	 * @return MeetingDetailVO
	 */
	public MeetingDetailVO addGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList, String departIDs) {
		logger.info("MeetingDetailServiceImpl	addGeneralMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = null;
		TransactionManager tManager = null;
		try{
			tManager = new TransactionManager();
			tManager.beginTransaction();
			vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
//			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_GENERAL);
			meetingDetailVO = MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
	
			//设置与会人员
			if (userList != null && userList.size() > 0) {
				for (int i = 0; i < userList.size(); i++) {
					UserVO userVO = (UserVO) userList.get(i);
					MeetingDetailUserVO vo = new MeetingDetailUserVO();
					vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vo.setUserID(userVO.getUserID());
					MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
					service.addMeetingDetailUser(vo, tManager);
				}
			}
			
			//会议需要的会议室
			if (roomList != null && roomList.size() > 0) {
				VideoconferenceService service = new VideoconferenceServiceImpl();
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vVideoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
					service.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
			
			//会议需要的部门
			if (departIDs != null && departIDs.length() > 0) {
				MeetingDetailDepartMentService service = new MeetingDetailDepartMentServiceImpl();
				String[] ids = departIDs.split(",");
				for (int i = 0; i < ids.length; i++) {
					MeetingDetailDepartMentVO depart = new MeetingDetailDepartMentVO();
					depart.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					depart.setDepartMentID(ids[i]);
					service.add(depart,tManager);
				}
			}
			
		}catch(Exception e){
			tManager.endTransaction();
			tManager.rollback();
			logger.error("MeetingDetailServiceImpl	addGeneralMeetingDetail	error："+e.getMessage());
			return null;
		}
		
		tManager.endTransaction();
		tManager.commit();
		logger.info("MeetingDetailServiceImpl	addGeneralMeetingDetail	end");
		return meetingDetailVO;
	}


	public MeetingDetailVO addGeneralMeetingDetailThread(MeetingDetailVO meetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList, String departIDs) {
		logger.info("MeetingDetailServiceImpl	addGeneralMeetingDetail	begin");

		try{
			
	
			//设置与会人员
			if (userList != null && userList.size() > 0) {
				for (int i = 0; i < userList.size(); i++) {
					UserVO userVO = (UserVO) userList.get(i);
					MeetingDetailUserVO vo = new MeetingDetailUserVO();
					vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vo.setUserID(userVO.getUserID());
					MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
					service.addMeetingDetailUser(vo, null);
				}
			}
			
			//会议需要的会议室
			if (roomList != null && roomList.size() > 0) {
				VideoconferenceService service = new VideoconferenceServiceImpl();
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vVideoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
					service.addVideoconference(vVideoconferenceVO, null);
				}
			}
			
			//会议需要的部门
			if (departIDs != null && departIDs.length() > 0) {
				MeetingDetailDepartMentService service = new MeetingDetailDepartMentServiceImpl();
				String[] ids = departIDs.split(",");
				for (int i = 0; i < ids.length; i++) {
					MeetingDetailDepartMentVO depart = new MeetingDetailDepartMentVO();
					depart.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					depart.setDepartMentID(ids[i]);
					service.add(depart,null);
				}
			}
			
		}catch(Exception e){
			logger.error("MeetingDetailServiceImpl	addGeneralMeetingDetail	error："+e.getMessage());
			return null;
		}
		
		
		logger.info("MeetingDetailServiceImpl	addGeneralMeetingDetail	end");
		return meetingDetailVO;
	}
	

	/**
	 * 添加会议明细：包括模板、备用信息等  wangle 2013-8-22
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @return
	 */
	public MeetingDetailVO addMeetingDetail(MeetingDetailVO vMeetingDetailVO)  throws Exception{
		logger.info("serviceImpl	addMeetingDetail	begin");
		MeetingDetailDAO.addMeetingDetail2(vMeetingDetailVO, null);
		logger.info("serviceImpl	addMeetingDetail	end");
		return vMeetingDetailVO;
	}

	/**
	 * 提取会议明细：包括模板、备用信息等  wangle 2013-8-22
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> queryMeetingDetailList2(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException{
		logger.info("serviceImpl	addMeetingDetail	begin");
		ArrayList<MeetingDetailVO> list = MeetingDetailDAO.queryMeetingDetailList2(vMeetingDetailVO, mPageController);
		logger.info("serviceImpl	addMeetingDetail	end");
		return list;
	}
	
	
	/**
	 * 根据id修改状态
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public MeetingDetailVO ModifyMeetingDetailForState(
			MeetingDetailVO vMeetingDetailVO)throws SQLException {
		return MeetingDetailDAO.modifyMeetingDetailStatus(vMeetingDetailVO, null);
	}
	
	/**
	 * method description : getMeetingDetailList
	 * 
	 * @param MeetingDetailVO
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 * 我的会议本地会议查看wangyulong
	 */
	public ArrayList<MeetingDetailVO> getMeetingDetailList(MeetingDetailVO vMeetingDetailVO, PageController mPageController)throws SQLException {
		return MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO,mPageController);
	}
	
//	/**
//	 * get meetingdetail list according to some statuses
//	 * @param vMeetingDetailVO
//	 * @param statusArray
//	 * @param mPageController
//	 * @return
//	 * @throws SQLException
//	 */
//	public ArrayList<MeetingDetailVO> getMeetingDetailList(
//			MeetingDetailVO vMeetingDetailVO, String[] statusArray, PageController mPageController) throws SQLException {
//		return MeetingDetailDAO.getMeetingDetailList(vMeetingDetailVO, statusArray,
//				mPageController);
//	}
	

//	/**
//	 * method description : delMeetingDetail
//	 * 
//	 * @param MeetingDetailVO
//	 * @return boolean
//	 * @throws SQLException
//	 */
//	public boolean delMeetingDetail(MeetingDetailVO vMeetingDetailVO,
//			TransactionManager tManager) throws SQLException {
//		boolean re = false;
//		if (1 == MeetingDetailDAO.delMeetingDetail(vMeetingDetailVO, tManager)) {
//			re = true;
//		}
//		return re;
//	}

	/**
	 * 修改本地会议--信息 add by ryan on 2011-12-02
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @return
	 */
	public MeetingDetailVO modifyGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO){
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = null;
		try{
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(vMeetingDetailVO, null);
		}catch(Exception e){
			logger.error("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	error："+e.getMessage());
			return null;
		}
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	end");
		return meetingDetailVO;
	}
	
	/**
	 * 审批本地会议
	 * @param vMeetingDetailVO
	 * @return MeetingDetailVO
	 */
	public MeetingDetailVO examGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO){
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = null;
		try{
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetailStatus(vMeetingDetailVO, null);
			MeetingDetailDAO.addExam(vMeetingDetailVO, null);
		}catch(Exception e){
			logger.error("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	error："+e.getMessage());
			return null;
		}
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	end");
		return meetingDetailVO;
	}

	/**
	 * 修改本地会议 add by ryan on 2011-12-02
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @String departIDs  以","分割
	 * @return
	 */
	public MeetingDetailVO modifyGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList, String departIDs){
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = vMeetingDetailVO;
		TransactionManager tManager = null;
		try{
			tManager = new TransactionManager();
			tManager.beginTransaction();
			
	
			
			MeetingDetailUserService Uervice = new MeetingDetailUserServiceImpl();
			MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
			vMeetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			Uervice.delMeetingDetailUserByDetailId(vMeetingDetailUserVO, tManager);
			
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
					Uervice.addMeetingDetailUser(vo, tManager);
				}
			}
			
			//会议需要的会议室
			VideoconferenceService fService = new VideoconferenceServiceImpl();
			VideoconferenceVO vVideoconferenceVO = new VideoconferenceVO();
			vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			fService.delVideoconferenceByDetailId(vVideoconferenceVO, tManager);
			if (roomList != null && roomList.size() > 0) {
				for (int i = 0; i < roomList.size(); i++) {
					vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					fService.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
			
			//会议需要的部门
			if (departIDs != null && departIDs.length() > 0) {
				MeetingDetailDepartMentService service = new MeetingDetailDepartMentServiceImpl();
				service.deleteByID(meetingDetailVO.getMeetingDetailID());
				String[] ids = departIDs.split(",");
				for (int i = 0; i < ids.length; i++) {
					MeetingDetailDepartMentVO depart = new MeetingDetailDepartMentVO();
					depart.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					depart.setDepartMentID(ids[i]);
					service.add(depart,tManager);
				}
			}
			
		}catch(Exception e){
			tManager.endTransaction();
			tManager.rollback();
			logger.error("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	error："+e.getMessage());
			return null;
		}
		tManager.endTransaction();
		tManager.commit();
		logger.info("MeetingDetailServiceImpl	modifyGeneralMeetingDetail	end");
		return meetingDetailVO;
	}
	
	/**
	 * 取现在正在开的会议
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> getMeetingListForToday(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {
		return MeetingDetailDAO.getMeetingListForToday(vMeetingDetailVO, mPageController);
	}

	@Override
	public MeetingDetailVO addVedioMeetingDetail(MeetingDetailVO meetingDetailVO, String[] userList,
			String[] roomList) {
		logger.info("MeetingDetailServiceImpl	addVedioMeetingDetail	begin");
		try{
			
	
			//设置与会人员
			if (userList != null && userList.length > 0) {
				for (int i = 0; i < userList.length; i++) {
					MeetingDetailUserVO vo = new MeetingDetailUserVO();
					vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vo.setUserID(userList[i]);
					
					MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
					service.addMeetingDetailUser(vo, null);
				}
			}
			
			//会议需要的分会场
			boolean isExisted = false;
			VideoconferenceService service = new VideoconferenceServiceImpl();
			if (roomList != null && roomList.length > 0) {
				for (int i = 0; i < roomList.length; i++) {
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomList[i]);
					if(meetingDetailVO.getMeetingRoomID() != null && meetingDetailVO.getMeetingRoomID().equals(roomList[i])){
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						isExisted = true;
					}else{
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
					}
					venueVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					service.addVideoconference(venueVO, null);
				}
			}
			if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
				VideoconferenceVO venueVO = new VideoconferenceVO();
				venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
				venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
				venueVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				service.addVideoconference(venueVO, null);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("MeetingDetailServiceImpl	addVedioMeetingDetail	error："+e.getMessage());
			return null;
		}
		
		logger.info("MeetingDetailServiceImpl	addVedioMeetingDetail	end");
		return meetingDetailVO;
	}

	@Override
	public MeetingDetailVO modifyVedioMeetingDetail(MeetingDetailVO meetingDetailVO,String[] userList,String[] roomList){ 
		logger.info("MeetingDetailServiceImpl	modifyVedioMeetingDetail	begin");
		try{
			
	
			MeetingDetailUserService Uervice = new MeetingDetailUserServiceImpl();
			MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
			vMeetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			Uervice.delMeetingDetailUserByDetailId(vMeetingDetailUserVO, null);
			
			//设置与会人员
			if (userList != null && userList.length > 0) {
				for (int i = 0; i < userList.length; i++) {
					MeetingDetailUserVO vo = new MeetingDetailUserVO();
					vo.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					vo.setUserID(userList[i]);
					
					MeetingDetailUserService service = new MeetingDetailUserServiceImpl();
					service.addMeetingDetailUser(vo, null);
				}
			}
			VideoconferenceService fService = new VideoconferenceServiceImpl();
			VideoconferenceVO vVideoconferenceVO1 = new VideoconferenceVO();
			vVideoconferenceVO1.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			fService.delVideoconferenceByDetailId(vVideoconferenceVO1, null);
			
			boolean isExisted = false;
			VideoconferenceService service = new VideoconferenceServiceImpl();
			if (roomList != null && roomList.length > 0) {
				for (int i = 0; i < roomList.length; i++) {
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomList[i]);
					if(meetingDetailVO.getMeetingRoomID() != null && meetingDetailVO.getMeetingRoomID().equals(roomList[i])){
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						isExisted = true;
					}else{
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
					}
					venueVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					service.addVideoconference(venueVO, null);
				}
			}
			if(!isExisted && meetingDetailVO.getMeetingRoomID() != null){
				VideoconferenceVO venueVO = new VideoconferenceVO();
				venueVO.setSubmeetingRoomID(meetingDetailVO.getMeetingRoomID());
				venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
				venueVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				service.addVideoconference(venueVO, null);
			}
		}catch(Exception e){
			logger.error("MeetingDetailServiceImpl	modifyVedioMeetingDetail	error："+e.getMessage());
			return null;
		}
		logger.info("MeetingDetailServiceImpl	modifyVedioMeetingDetail	end");
		return meetingDetailVO;
	}
	
	@Override
	public MeetingDetailVO modifyVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList){ 
		logger.info("MeetingDetailServiceImpl	modifyVedioMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = null;
		TransactionManager tManager = null;
		try{
			tManager = new TransactionManager();
			tManager.beginTransaction();
			vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailVO = MeetingDetailDAO.modifyMeetingDetail(vMeetingDetailVO, tManager);
	
			MeetingDetailUserService Uervice = new MeetingDetailUserServiceImpl();
			MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
			vMeetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			Uervice.delMeetingDetailUserByDetailId(vMeetingDetailUserVO, tManager);
			
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
					Uervice.addMeetingDetailUser(vo, tManager);
				}
			}
			
			//会议需要的会议室
			VideoconferenceService fService = new VideoconferenceServiceImpl();
			VideoconferenceVO vVideoconferenceVO = new VideoconferenceVO();
			vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			fService.delVideoconferenceByDetailId(vVideoconferenceVO, tManager);
			if (roomList != null && roomList.size() > 0) {
				for (int i = 0; i < roomList.size(); i++) {
					vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					fService.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
			
		}catch(Exception e){
			tManager.endTransaction();
			tManager.rollback();
			logger.error("MeetingDetailServiceImpl	modifyVedioMeetingDetail	error："+e.getMessage());
			return null;
		}
		tManager.endTransaction();
		tManager.commit();
		logger.info("MeetingDetailServiceImpl	modifyVedioMeetingDetail	end");
		return meetingDetailVO;
	}

	
	@Override
	public MeetingDetailVO addVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO, ArrayList<UserVO> userList,
			ArrayList<VideoconferenceVO> roomList) {
		logger.info("MeetingDetailServiceImpl	addVedioMeetingDetail	begin");
		MeetingDetailVO meetingDetailVO = null;
		TransactionManager tManager = null;
		try{
			tManager = new TransactionManager();
			tManager.beginTransaction();
//			vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			if(MeetingDetailEnum.TYPE_VEDIO_DEBUG!=vMeetingDetailVO.getMeetingType())
				vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailVO = MeetingDetailDAO.addMeetingDetail(vMeetingDetailVO, tManager);
	
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
			
			//会议需要的分会场
			VideoconferenceService service = new VideoconferenceServiceImpl();
			if (roomList != null && roomList.size() > 0) {
				for (int i = 0; i < roomList.size(); i++) {
					VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) roomList.get(i);
					vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					service.addVideoconference(vVideoconferenceVO, tManager);
				}
			}
		}catch(Exception e){
			tManager.endTransaction();
			tManager.rollback();
			logger.error("MeetingDetailServiceImpl	addVedioMeetingDetail	error："+e.getMessage());
			return null;
		}
		
		tManager.endTransaction();
		tManager.commit();
		logger.info("MeetingDetailServiceImpl	addVedioMeetingDetail	end");
		return meetingDetailVO;
	}

	@Override
	public MeetingDetailVO delMeetingDetail(MeetingDetailVO vMeetingDetailVO) throws SQLException {
		vMeetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
		return ModifyMeetingDetailForState(vMeetingDetailVO);
	}

	@Override
	public ArrayList<MeetingDetailVO> queryPastSysTime(PageController mPageController) throws Exception {
		return MeetingDetailDAO.pastSysTime(null, mPageController);
	}
	
@Override
public ArrayList<MeetingDetailVO> getMeetingDetailstatusList(MeetingDetailVO meetingDetailVO, PageController pageController)
		throws SQLException {
	return MeetingDetailDAO.getMeetingDetailListForStatus(meetingDetailVO, pageController);
}

public static void main(String[] args){
	MeetingDetailServiceImpl impl = new MeetingDetailServiceImpl();
	MeetingDetailVO vo = new MeetingDetailVO();
	vo.setMeetingID("2");
	try {
		impl.queryPastSysTime(null);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
public ArrayList<MeetingDetailVO> queryWithMeetingDebug(MeetingDetailVO vMeetingDetailVO,PageController mPageController) throws SQLException{
	return MeetingDetailDAO.getMeetingDetailWithMeetingDebug(vMeetingDetailVO, mPageController);
}

@Override
public List<MeetingDetailVO> getMeetingDetailAndFileList(
		MeetingDetailVO meetingDetailVO, PageController mPageController) throws SQLException {
	return MeetingDetailDAO.getMeetingDetailAndFileList(meetingDetailVO, mPageController);
}

@Override
public List<MeetingDetailVO> getMeetingDetailApplyList(
		MeetingDetailVO meetingDetailVO, UserVO loginUser,
		PageController pControler) throws SQLException {
	return MeetingDetailDAO.getMeetingDetailApplyList(meetingDetailVO, loginUser, pControler);
}

public List<MeetingDetailVO> getMeetingDetailByTimeAndName(
		MeetingDetailVO meetingDetailVO, Timestamp time)  throws SQLException{
	return MeetingDetailDAO.getMeetingDetailByTimeAndName(meetingDetailVO, time);
}

@Override
public ArrayList<MeetingDetailVO> queryMeetingOccupy(
		MeetingDetailVO meetingDetailVO, PageController pageController)
		throws Exception {
	return MeetingDetailDAO.queryMeetingOccupy(meetingDetailVO, pageController);
}

@Override
public MeetingDetailVO ModifyMeetingDetailForInfo2(
		MeetingDetailVO vMeetingDetailVO) throws SQLException {
	// TODO Auto-generated method stub
	return MeetingDetailDAO.modifyMeetingDetailInfo2(vMeetingDetailVO, null);
}

@Override
public String query(MeetingDetailVO vMeetingDetailVO) {
	// TODO Auto-generated method stub
	return MeetingDetailDAO.queryMeetingDetailID(vMeetingDetailVO);
}

@Override
public ArrayList<MeetingDetailVO> queryNextWeekMeeting(
		Timestamp meetingStartTime, Timestamp meetingEndTime) throws Exception {
	//MeetingDetailDAO.q
	return MeetingDetailDAO.queryNextWeekMeeting(meetingStartTime, meetingEndTime);
}

}
