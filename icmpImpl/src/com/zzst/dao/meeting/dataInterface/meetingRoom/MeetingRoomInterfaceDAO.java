package com.zzst.dao.meeting.dataInterface.meetingRoom;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: MeetingRoomInterface DAO
 * 
 * @date Fri May 24 16:23:45 CST 2013
 * @author ryan
 */
public class MeetingRoomInterfaceDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomInterfaceDAO.class.getName());

	private static final String id = "Id";

	/**
	 * add MeetingRoomInterfaceVO object
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @param TransactionManager
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public static MeetingRoomInterfaceVO add(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		meetingRoomInterfaceVO.setId(UtilDAO.getUUid());
		MeetingRoomInterfaceTO meetingRoomInterfaceTO = new MeetingRoomInterfaceTO(
				MeetingRoomInterfaceTO.ADD_MEETINGROOMINTERFACE,
				meetingRoomInterfaceVO);

		meetingRoomInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingRoomInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomInterfaceTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingRoomInterfaceVO;
	}

	/**
	 * query MeetingRoomInterfaceVO list
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomInterfaceVO> query(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingRoomInterfaceMQB meetingRoomInterfaceMQB = new MeetingRoomInterfaceMQB(
				MeetingRoomInterfaceMQB.QUERY_FROM_MEETINGROOMINTERFACE,
				meetingRoomInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomInterfaceMQB.getMeetingRoomInterfaceList().size());
		logger.info("DAO	query	end");
		return meetingRoomInterfaceMQB.getMeetingRoomInterfaceList();
	}

	/**
	 * query MeetingRoomInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingRoomInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingRoomInterfaceMQB meetingRoomInterfaceMQB = new MeetingRoomInterfaceMQB(
				MeetingRoomInterfaceMQB.QUERY_FROM_MEETINGROOMINTERFACE_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomInterfaceMQB.getMeetingRoomInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingRoomInterfaceMQB.getMeetingRoomInterfaceList();
	}

	/**
	 * modify MeetingRoomInterfaceVO column by ID
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @param TransactionManager
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public static MeetingRoomInterfaceVO modify(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingRoomInterfaceTO meetingRoomInterfaceTO = new MeetingRoomInterfaceTO(
				MeetingRoomInterfaceTO.MODIFY_MEETINGROOMINTERFACE,
				meetingRoomInterfaceVO);
		meetingRoomInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingRoomInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomInterfaceTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingRoomInterfaceVO;
	}

	/**
	 * delete MeetingRoomInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomInterfaceVO meetingRoomInterfaceVO = new MeetingRoomInterfaceVO();
		meetingRoomInterfaceVO.setId(ids);
		MeetingRoomInterfaceTO meetingRoomInterfaceTO = new MeetingRoomInterfaceTO(
				MeetingRoomInterfaceTO.DEL_MEETINGROOMINTERFACE,
				meetingRoomInterfaceVO);

		meetingRoomInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingRoomInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + meetingRoomInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomInterfaceTO.getexecuteResult();
	}

	public static ArrayList<MeetingRoomInterfaceVO> queryAvailable(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryAvailable	begin");
		MeetingRoomInterfaceMQB meetingRoomInterfaceMQB = new MeetingRoomInterfaceMQB(
				MeetingRoomInterfaceMQB.QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE,
				meetingRoomInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomInterfaceMQB.getMeetingRoomInterfaceList().size());
		logger.info("DAO	queryAvailable	end");
		return meetingRoomInterfaceMQB.getMeetingRoomInterfaceList();
	}

	public static int deleteAll( TransactionManager tManager ) throws Exception {
		logger.info("DAO	deleteAll	begin");
		MeetingRoomInterfaceVO meetingRoomInterfaceVO = new MeetingRoomInterfaceVO();
		MeetingRoomInterfaceTO meetingRoomInterfaceTO = new MeetingRoomInterfaceTO(
				MeetingRoomInterfaceTO.DEL_ALL,
				meetingRoomInterfaceVO);

		meetingRoomInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingRoomInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + meetingRoomInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return meetingRoomInterfaceTO.getexecuteResult();
	}
}
