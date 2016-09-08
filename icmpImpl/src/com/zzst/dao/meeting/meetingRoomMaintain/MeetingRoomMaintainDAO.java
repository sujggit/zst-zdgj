package com.zzst.dao.meeting.meetingRoomMaintain;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;

/**
 * class description: MeetingRoomMaintain DAO
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomMaintainDAO.class.getName());


	/**
	 * add MeetingRoomMaintainVO object
	 * 
	 * @param MeetingRoomMaintainVO
	 * @param TransactionManager
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public static MeetingRoomMaintainVO add(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		meetingRoomMaintainVO.setMaintainID(UtilDAO.getUUid());
		MeetingRoomMaintainTO meetingRoomMaintainTO = new MeetingRoomMaintainTO(
				MeetingRoomMaintainTO.ADD_MEETINGROOMMAINTAIN,
				meetingRoomMaintainVO);

		meetingRoomMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingRoomMaintainVO;
	}

	/**
	 * query MeetingRoomMaintainVO list
	 * 
	 * @param MeetingRoomMaintainVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomMaintainVO> query(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingRoomMaintainMQB meetingRoomMaintainMQB = new MeetingRoomMaintainMQB(
				MeetingRoomMaintainMQB.QUERY_FROM_MEETINGROOMMAINTAIN,
				meetingRoomMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMaintainMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomMaintainMQB.getMeetingRoomMaintainList().size());
		logger.info("DAO	query	end");
		return meetingRoomMaintainMQB.getMeetingRoomMaintainList();
	}

	/**
	 * query MeetingRoomMaintainVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomMaintainVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingRoomMaintainMQB meetingRoomMaintainMQB = new MeetingRoomMaintainMQB(
				MeetingRoomMaintainMQB.QUERY_FROM_MEETINGROOMMAINTAIN_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMaintainMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomMaintainMQB.getMeetingRoomMaintainList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingRoomMaintainMQB.getMeetingRoomMaintainList();
	}

	/**
	 * modify MeetingRoomMaintainVO column by ID
	 * 
	 * @param MeetingRoomMaintainVO
	 * @param TransactionManager
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public static MeetingRoomMaintainVO modify(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingRoomMaintainTO meetingRoomMaintainTO = new MeetingRoomMaintainTO(
				MeetingRoomMaintainTO.MODIFY_MEETINGROOMMAINTAIN,
				meetingRoomMaintainVO);
		meetingRoomMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingRoomMaintainVO;
	}

	/**
	 * delete MeetingRoomMaintainVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomMaintainVO meetingRoomMaintainVO = new MeetingRoomMaintainVO();
		meetingRoomMaintainVO.setMaintainID(ids);
		MeetingRoomMaintainTO meetingRoomMaintainTO = new MeetingRoomMaintainTO(
				MeetingRoomMaintainTO.DEL_MEETINGROOMMAINTAIN,
				meetingRoomMaintainVO);

		meetingRoomMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO,
					tManager);
		}
		logger.info("result	:	" + meetingRoomMaintainTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomMaintainTO.getexecuteResult();
	}

	/**
	 * @param key
	 * @param type
	 * @param tManager
	 * @return
	 * @throws Exception
	 */
	public static int deleteByKey(String key,String type, TransactionManager tManager)
	throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomMaintainVO meetingRoomMaintainVO = new MeetingRoomMaintainVO();
		meetingRoomMaintainVO.setMaintainKey(key);
		meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
		MeetingRoomMaintainTO meetingRoomMaintainTO = new MeetingRoomMaintainTO(
				MeetingRoomMaintainTO.DEL_MEETINGROOMMAINTAIN_KEY,
				meetingRoomMaintainVO);
		
		meetingRoomMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainTO,
					tManager);
		}
		logger.info("result	:	" + meetingRoomMaintainTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomMaintainTO.getexecuteResult();
}
	
	public static ArrayList<MeetingRoomMaintainVO> queryRoomMaintainConference(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryRoomMaintainConference	begin");
		RoomMaintainConferenceMQB roomMaintainConferenceMQB = new RoomMaintainConferenceMQB(
				RoomMaintainConferenceMQB.QUERY_FROM_ROOMMAINTAINCONFERENCE, meetingRoomMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + roomMaintainConferenceMQB.getSql());
		QueryTemplate.executeQueryForList(roomMaintainConferenceMQB, pageController);
		logger.info("list size	:	" + roomMaintainConferenceMQB.getMeetingRoomMaintainList().size());
		logger.info("DAO	queryRoomMaintainConference	end");
		return roomMaintainConferenceMQB.getMeetingRoomMaintainList();
	}
	
	public static ArrayList<MeetingRoomMaintainVO> queryRoomMaintain(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryRoomMaintainConference	begin");
		RoomMaintainConferenceMQB roomMaintainConferenceMQB = new RoomMaintainConferenceMQB(
				RoomMaintainConferenceMQB.QUERY_ROOMMAINTAIN, meetingRoomMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + roomMaintainConferenceMQB.getSql());
		QueryTemplate.executeQueryForList(roomMaintainConferenceMQB, pageController);
		logger.info("list size	:	" + roomMaintainConferenceMQB.getMeetingRoomMaintainList().size());
		logger.info("DAO	queryRoomMaintainConference	end");
		return roomMaintainConferenceMQB.getMeetingRoomMaintainList();
	}
}
