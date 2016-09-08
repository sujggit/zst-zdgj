package com.zzst.dao.meeting.dataInterface.terminal;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceMQB;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceTO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: TerminalInterface DAO
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public class TerminalInterfaceDAO {
	private static Logger logger = CjfLogger
			.getLogger(TerminalInterfaceDAO.class.getName());

	private static final String id = "EquipmentID";

	/**
	 * add TerminalInterfaceVO object
	 * 
	 * @param TerminalInterfaceVO
	 * @param TransactionManager
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public static TerminalInterfaceVO add(
			TerminalInterfaceVO terminalInterfaceVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		terminalInterfaceVO.setEquipmentID(UtilDAO.getUUid());
		TerminalInterfaceTO terminalInterfaceTO = new TerminalInterfaceTO(
				TerminalInterfaceTO.ADD_TERMINALINTERFACE, terminalInterfaceVO);

		terminalInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + terminalInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(terminalInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(terminalInterfaceTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return terminalInterfaceVO;
	}

	/**
	 * query TerminalInterfaceVO list
	 * 
	 * @param TerminalInterfaceVO
	 * @param PageController
	 * @return ArrayList<TerminalInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<TerminalInterfaceVO> query(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		TerminalInterfaceMQB terminalInterfaceMQB = new TerminalInterfaceMQB(
				TerminalInterfaceMQB.QUERY_FROM_TERMINALINTERFACE,
				terminalInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + terminalInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(terminalInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ terminalInterfaceMQB.getTerminalInterfaceList().size());
		logger.info("DAO	query	end");
		return terminalInterfaceMQB.getTerminalInterfaceList();
	}

	/**
	 * query TerminalInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<TerminalInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<TerminalInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		TerminalInterfaceMQB terminalInterfaceMQB = new TerminalInterfaceMQB(
				TerminalInterfaceMQB.QUERY_FROM_TERMINALINTERFACE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + terminalInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(terminalInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ terminalInterfaceMQB.getTerminalInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return terminalInterfaceMQB.getTerminalInterfaceList();
	}

	/**
	 * modify TerminalInterfaceVO column by ID
	 * 
	 * @param TerminalInterfaceVO
	 * @param TransactionManager
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public static TerminalInterfaceVO modify(
			TerminalInterfaceVO terminalInterfaceVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		TerminalInterfaceTO terminalInterfaceTO = new TerminalInterfaceTO(
				TerminalInterfaceTO.MODIFY_TERMINALINTERFACE,
				terminalInterfaceVO);
		terminalInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + terminalInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(terminalInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(terminalInterfaceTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return terminalInterfaceVO;
	}

	/**
	 * delete TerminalInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return TerminalInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		TerminalInterfaceVO terminalInterfaceVO = new TerminalInterfaceVO();
		terminalInterfaceVO.setEquipmentID(ids);
		TerminalInterfaceTO terminalInterfaceTO = new TerminalInterfaceTO(
				TerminalInterfaceTO.DEL_TERMINALINTERFACE, terminalInterfaceVO);

		terminalInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + terminalInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(terminalInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(terminalInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + terminalInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return terminalInterfaceTO.getexecuteResult();
	}
	
	
	public static int deleteAll( TransactionManager tManager ) throws Exception {
		logger.info("DAO	deleteAll	begin");
		TerminalInterfaceVO terminalInterfaceVO = new TerminalInterfaceVO();
		TerminalInterfaceTO terminalInterfaceTO = new TerminalInterfaceTO(
				TerminalInterfaceTO.DEL_ALL,
				terminalInterfaceVO);

		terminalInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + terminalInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(terminalInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(terminalInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + terminalInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return terminalInterfaceTO.getexecuteResult();
	}
	
	public static ArrayList<TerminalInterfaceVO> queryAvailable(
			TerminalInterfaceVO terminalInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryAvailable	begin");
		TerminalInterfaceMQB terminalInterfaceMQB = new TerminalInterfaceMQB(
				TerminalInterfaceMQB.QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE,
				terminalInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + terminalInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(terminalInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ terminalInterfaceMQB.getTerminalInterfaceList().size());
		logger.info("DAO	queryAvailable	end");
		return terminalInterfaceMQB.getTerminalInterfaceList();
	}
}
