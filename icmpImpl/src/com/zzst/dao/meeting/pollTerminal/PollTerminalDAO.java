package com.zzst.dao.meeting.pollTerminal;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;

/**
 * class description: PollTerminal DAO
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTerminalDAO {
	private static Logger logger = CjfLogger.getLogger(PollTerminalDAO.class
			.getName());

	private static final String id = "PollTerminalID";

	/**
	 * add PollTerminalVO object
	 * 
	 * @param PollTerminalVO
	 * @param TransactionManager
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public static PollTerminalVO add(PollTerminalVO pollTerminalVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		pollTerminalVO.setPollTerminalID(UtilDAO.getUUid());
		PollTerminalTO pollTerminalTO = new PollTerminalTO(
				PollTerminalTO.ADD_POLLTERMINAL, pollTerminalVO);

		pollTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTerminalTO, tManager);
		}
		logger.info("DAO	add	end");
		return pollTerminalVO;
	}

	/**
	 * query PollTerminalVO list
	 * 
	 * @param PollTerminalVO
	 * @param PageController
	 * @return ArrayList<PollTerminalVO>
	 * @throws Exception
	 */
	public static ArrayList<PollTerminalVO> query(
			PollTerminalVO pollTerminalVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		PollTerminalMQB pollTerminalMQB = new PollTerminalMQB(
				PollTerminalMQB.QUERY_FROM_POLLTERMINAL, pollTerminalVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(pollTerminalMQB, pageController);
		logger.info("list size	:	"
				+ pollTerminalMQB.getPollTerminalList().size());
		logger.info("DAO	query	end");
		return pollTerminalMQB.getPollTerminalList();
	}

	/**
	 * query PollTerminalVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<PollTerminalVO>
	 * @throws Exception
	 */
	public static ArrayList<PollTerminalVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		PollTerminalMQB pollTerminalMQB = new PollTerminalMQB(
				PollTerminalMQB.QUERY_FROM_POLLTERMINAL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(pollTerminalMQB, pageController);
		logger.info("list size	:	"
				+ pollTerminalMQB.getPollTerminalList().size());
		logger.info("DAO	queryByIDs	end");
		return pollTerminalMQB.getPollTerminalList();
	}

	/**
	 * modify PollTerminalVO column by ID
	 * 
	 * @param PollTerminalVO
	 * @param TransactionManager
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public static PollTerminalVO modify(PollTerminalVO pollTerminalVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		PollTerminalTO pollTerminalTO = new PollTerminalTO(
				PollTerminalTO.MODIFY_POLLTERMINAL, pollTerminalVO);
		pollTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTerminalTO, tManager);
		}
		logger.info("DAO	modify	end");
		return pollTerminalVO;
	}

	/**
	 * delete PollTerminalVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return PollTerminalVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		PollTerminalVO pollTerminalVO = new PollTerminalVO();
		pollTerminalVO.setPollTerminalID(ids);
		PollTerminalTO pollTerminalTO = new PollTerminalTO(
				PollTerminalTO.DEL_POLLTERMINAL, pollTerminalVO);

		pollTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTerminalTO, tManager);
		}
		logger.info("result	:	" + pollTerminalTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return pollTerminalTO.getexecuteResult();
	}
	
	public static ArrayList<PollTerminalVO> queryWithEquipment(PollTerminalVO pollTerminalVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryWithEquipment	begin");
		PollTerminalMQB pollTerminalMQB = new PollTerminalMQB(
				PollTerminalMQB.QUERY_FROM_POLLTERMINAL_WITH_EQUIPMENT, pollTerminalVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(pollTerminalMQB, pageController);
		logger.info("list size	:	"
				+ pollTerminalMQB.getPollTerminalList().size());
		logger.info("DAO	queryWithEquipment	end");
		return pollTerminalMQB.getPollTerminalList();
	}
	
	
	public static ArrayList<PollTerminalVO> queryTerminal(PollTerminalVO pollTerminalVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryTerminal	begin");
		PollTerminalMQB pollTerminalMQB = new PollTerminalMQB(
				PollTerminalMQB.QUERY_FROM_POLLTERMINAL_RIGHTJOIN_EQUIPMENT, pollTerminalVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(pollTerminalMQB, pageController);
		logger.info("list size	:	"
				+ pollTerminalMQB.getPollTerminalList().size());
		logger.info("DAO	queryTerminal	end");
		return pollTerminalMQB.getPollTerminalList();
	}
	
	
	
	public static int deleteByVO(PollTerminalVO pollTerminalVO, TransactionManager tManager)
	throws Exception {
		logger.info("DAO	deleteByVO	begin");
		PollTerminalTO pollTerminalTO = new PollTerminalTO(
				PollTerminalTO.DEL_BYVO, pollTerminalVO);
		
		pollTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTerminalTO, tManager);
		}
		logger.info("result	:	" + pollTerminalTO.getexecuteResult());
		logger.info("DAO	deleteByVO	end");
		return pollTerminalTO.getexecuteResult();
	}
}
