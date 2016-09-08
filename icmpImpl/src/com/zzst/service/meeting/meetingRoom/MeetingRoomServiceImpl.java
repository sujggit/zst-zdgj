package com.zzst.service.meeting.meetingRoom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.equipment.EquipmentDAO;
import com.zzst.dao.meeting.meetingRoom.MeetingRoomDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;

import freemarker.core.ReturnInstruction.Return;

/**
 * class description: MeetingRoom Impl
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class MeetingRoomServiceImpl implements MeetingRoomService {

	private static Logger logger = CbfLogger.getLogger(MeetingRoomServiceImpl.class.getName());
	
	
	@Override
	public ArrayList<MeetingRoomVO> query(MeetingRoomVO meetingRoomVO,PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		//////////////////////////分级分权@author:zhangjy///////////////////////
		if(meetingRoomVO.isLevel()){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			meetingRoomVO.setLsql(lcs.queryByTypeAndLid(meetingRoomVO.getLsql(), LevelEnum.LEVEL_ROOM));
		}
		////////////////////////////////END////////////////////////////////////////
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.query(meetingRoomVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingRoom;
	}
	
	/**
	 * date：2012-12-11
	 * author：tanzanlong
	 * */
	//根据deptID找meeting
	public String queryBydeptID(DepartmentVO departmentVO, PageController  pageController) throws Exception {
		logger.info("serviceImpl	queryBydeptID	begin");
		String flag = MeetingRoomDAO.ishaveroomqueryByDeptID(departmentVO, pageController);
		if (flag != null && "yes".equals(flag)) {
			logger.info("serviceImpl	queryByID	end");
			return "yes";
		}else{
		logger.info("serviceImpl	queryByID	end");
		return "no";
		     }
	
	} 	
	@Override
	public MeetingRoomVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.queryByIDs(id, null);
		if (listMeetingRoom != null && listMeetingRoom.size() == 1) {
			logger.info("serviceImpl	queryByID	end");
			return listMeetingRoom.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}
	
	@Override
	public ArrayList<MeetingRoomVO> queryByIDs(String ids,PageController pageController) throws Exception {
		logger.info("serviceImpl	queryByIDs		begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.queryByIDs(
				ids, pageController);
		logger.info("serviceImpl	queryByIDs		end");
		return listMeetingRoom;
	}
	
	
	
	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs		begin");
		TransactionManager tManager = new TransactionManager();
		int num = Integer.MIN_VALUE;
		try {
			 tManager.beginTransaction();
			 num = MeetingRoomDAO.deleteByID(ids);		
			tManager.commit();
			tManager.endTransaction();
			logger.info("serviceImpl	deleteByIDs		end");
			return num;
			 
		}catch(Exception e){
			tManager.rollback();
			tManager.endTransaction();
			logger.error("serviceImpl	deleteByIDs		error	: "+e.getMessage());
			return num;
		}
	}

	

	@Override
	public MeetingRoomVO add(MeetingRoomVO meetingRoomVO) throws Exception {
		logger.info("serviceImpl	add		begin");
		TransactionManager tManager = new TransactionManager();
		try {
//			tManager.beginTransaction();
//			String departmentId=meetingRoomVO.getDepartmentVO().getId();
//			String title=meetingRoomVO.getDepartmentVO().getTitle();
//			DepartmentVO departmentVO=new DepartmentVO();
//			departmentVO.setId(departmentId);
//			departmentVO.setTitle(title);
//			UserVO userVO=new UserVO();
//			String userID=meetingRoomVO.getUserVO().getUserID();
//			String userName=meetingRoomVO.getUserVO().getName();
//			userVO.setUserID(userID);
//			userVO.setName(userName);
//			meetingRoomVO.setUserVO(userVO);
//			meetingRoomVO.setDepartmentVO(departmentVO);
			
//			DepartmentDAO.modifyDepartment(departmentVO);
//			UserDAO.modifyUser(userVO, null);
			meetingRoomVO = MeetingRoomDAO.add(meetingRoomVO, null);

		} catch (Exception e) {
			logger.error("serviceImpl	add		error	：" + e.toString());
		  //  tManager.rollback();
			throw e;
		}
		//tManager.commit();
		logger.info("serviceImpl	add		end");
		return meetingRoomVO;
		
	}

	

	@Override
	public MeetingRoomVO modify(MeetingRoomVO meetingRoomVO) throws Exception {
		logger.info("serviceImpl	modify		begin");
		TransactionManager tManager = new TransactionManager();
		try {
//            tManager.beginTransaction();
//			// 1、修改会议室基本信息
//			String departmentId=meetingRoomVO.getDepartmentVO().getId();
//			String title=meetingRoomVO.getDepartmentVO().getTitle();
//			DepartmentVO departmentVO=new DepartmentVO();
//			departmentVO.setId(departmentId);
//			departmentVO.setTitle(title);
//			UserVO userVO=new UserVO();
//			String userID=meetingRoomVO.getUserVO().getUserID();
//			String userName=meetingRoomVO.getUserVO().getName();
//			userVO.setUserID(userID);
//			userVO.setName(userName);
//			meetingRoomVO.setUserVO(userVO);
//			meetingRoomVO.setDepartmentVO(departmentVO);
//			
//			DepartmentDAO.modifyDepartment(departmentVO);
//			UserDAO.modifyUser(userVO, null);
			meetingRoomVO = MeetingRoomDAO.modify(meetingRoomVO, null);
		} catch (Exception e) {
		//	tManager.rollback();
			logger.error("serviceImpl	modify		error	：" + e.toString());
			
			throw e;
		}
	//	tManager.commit();
		logger.info("serviceImpl	modify		end");
		return meetingRoomVO;
	}

	@Override
	public boolean deleteByID(MeetingRoomVO meetingRoomVO) throws Exception {
		logger.info("serviceImpl	deleteByID		begin");
		TransactionManager tManager = new TransactionManager();
		try {
		//	tManager.beginTransaction();
			MeetingRoomDAO.modifystate(meetingRoomVO, null);
		//	int num = MeetingRoomDAO.deleteByID(id);
		
		}catch(Exception e){
		//	tManager.rollback();
		//	tManager.endTransaction();
			logger.error("serviceImpl	deleteByID		error	: "+e.getMessage());
			return false;
		}
		logger.info("serviceImpl	deleteByID		end");
	    return true;
	}
	
	public ArrayList<MeetingRoomVO> getEmptyMeetingRoomList(
			MeetingDetailVO vMeetingDetailVO, PageController pageController) throws SQLException{
		logger.info("serviceImpl	getEmptyMeetingRoomList		begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.getEmptyMeetingRoomList(
				vMeetingDetailVO, pageController);
		logger.info("serviceImpl	getEmptyMeetingRoomList		end");
		return listMeetingRoom;
	}
	
	public ArrayList<MeetingRoomVO> getEmptyMeetingRoomListForWs(
			MeetingDetailVO vMeetingDetailVO, PageController pageController) throws SQLException{
		logger.info("serviceImpl	getEmptyMeetingRoomList		begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.getEmptyMeetingRoomListForWs(
				vMeetingDetailVO, pageController);
		logger.info("serviceImpl	getEmptyMeetingRoomList		end");
		return listMeetingRoom;
	}

	@Override
	public ArrayList<MeetingRoomVO> validate(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	validate	begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.validate(meetingRoomVO, pageController);
		logger.info("serviceImpl	validate	end");
		return listMeetingRoom;
	}

	@Override
	public MeetingRoomVO updateByRoomNO(MeetingRoomVO meetingRoomVO)
			throws Exception {
		logger.info("MeetingRoomServiceImpl	updateByRoomNO	begin");
		meetingRoomVO = MeetingRoomDAO.updateByRoomNO(meetingRoomVO, null);
		logger.info("MeetingRoomServiceImpl	updateByRoomNO	end");
		return meetingRoomVO;
	}
	
	@Override
	public ArrayList<MeetingRoomVO> queryHaveTerminalMeetingRoom(MeetingRoomVO meetingRoomVO,PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingRoomVO> listMeetingRoom = MeetingRoomDAO.queryHaveTerminalMeetingRoom(meetingRoomVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingRoom;
	}

}
