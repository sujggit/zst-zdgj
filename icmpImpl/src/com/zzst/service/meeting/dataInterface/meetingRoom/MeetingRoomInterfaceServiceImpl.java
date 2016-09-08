package com.zzst.service.meeting.dataInterface.meetingRoom;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.service.meeting.log.LogServiceImpl;

/**
 * class description: MeetingRoomInterface ServiceImpl
 * 
 * @date Fri May 24 16:23:45 CST 2013
 * @author ryan
 */
public class MeetingRoomInterfaceServiceImpl implements
		MeetingRoomInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomInterfaceServiceImpl.class.getName());

	@Override
	public MeetingRoomInterfaceVO add(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingRoomInterfaceVO = MeetingRoomInterfaceDAO.add(
				meetingRoomInterfaceVO, null);
		
		LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行insert操作");
		new LogServiceImpl().add(logVO);
		
		logger.info("serviceImpl	add	end");
		return meetingRoomInterfaceVO;
	}

	@Override
	public ArrayList<MeetingRoomInterfaceVO> query(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingRoomInterfaceVO> listMeetingRoomInterface = MeetingRoomInterfaceDAO
				.query(meetingRoomInterfaceVO, pageController);
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
		new LogServiceImpl().add(logVO);*/
		
		logger.info("serviceImpl	query	end");
		return listMeetingRoomInterface;
	}

	@Override
	public MeetingRoomInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
		new LogServiceImpl().add(logVO);*/
		
		ArrayList<MeetingRoomInterfaceVO> listMeetingRoomInterface = MeetingRoomInterfaceDAO
				.queryByIDs(id, null);
		if (listMeetingRoomInterface != null
				&& listMeetingRoomInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingRoomInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingRoomInterfaceVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingRoomInterfaceVO> listMeetingRoomInterface = MeetingRoomInterfaceDAO
				.queryByIDs(ids, null);
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
		new LogServiceImpl().add(logVO);*/
		
		
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingRoomInterface;
	}

	@Override
	public MeetingRoomInterfaceVO modify(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingRoomInterfaceVO = MeetingRoomInterfaceDAO.modify(
				meetingRoomInterfaceVO, null);
		
		logger.info("serviceImpl	modify	end");
		return meetingRoomInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingRoomInterfaceDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			
			/*LogVO  logVO  = new LogVO();
			logVO.setLogType(LogEnum.TYPE_DEFAULT);
			logVO.setLevel(LogEnum.LEVEL_DeFAULT);
			logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行delete操作");
			new LogServiceImpl().add(logVO);*/
			
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = MeetingRoomInterfaceDAO.deleteByID(ids, null);
		
		/*LogVO  logVO  = new LogVO();
		logVO.setLogType(LogEnum.TYPE_DEFAULT);
		logVO.setLevel(LogEnum.LEVEL_DeFAULT);
		logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行delete操作");
		new LogServiceImpl().add(logVO);*/
		
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ArrayList<MeetingRoomInterfaceVO> queryAvailable(MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception {
			logger.info("serviceImpl	queryAvailable	begin");
			ArrayList<MeetingRoomInterfaceVO> listMeetingRoomInterface = MeetingRoomInterfaceDAO
					.queryAvailable(meetingRoomInterfaceVO, pageController);
			
			/*LogVO  logVO  = new LogVO();
			logVO.setLogType(LogEnum.TYPE_DEFAULT);
			logVO.setLevel(LogEnum.LEVEL_DeFAULT);
			logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
			new LogServiceImpl().add(logVO);*/
			
			
			logger.info("serviceImpl	queryAvailable	end");
			return listMeetingRoomInterface;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = MeetingRoomInterfaceDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	
	
}
