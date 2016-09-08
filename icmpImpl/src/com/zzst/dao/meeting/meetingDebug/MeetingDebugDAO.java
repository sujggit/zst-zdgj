package com.zzst.dao.meeting.meetingDebug;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingDebug DAO
 * 
 * @date Tue May 28 15:03:30 CST 2013
 * @author ryan
 */
public class MeetingDebugDAO {
	private static Logger logger = CjfLogger.getLogger(MeetingDebugDAO.class
			.getName());

	private static final String id = "Id";

	/**
	 * add MeetingDebugVO object
	 * 
	 * @param MeetingDebugVO
	 * @param TransactionManager
	 * @return MeetingDebugVO
	 * @throws Exception
	 */
	public static MeetingDebugVO add(MeetingDebugVO meetingDebugVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		meetingDebugVO.setId(UtilDAO.getUUid());
		MeetingDebugTO meetingDebugTO = new MeetingDebugTO(
				MeetingDebugTO.ADD_MEETINGDEBUG, meetingDebugVO);

		meetingDebugTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDebugTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDebugTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDebugTO, tManager);
		}
		logger.info("DAO	add	end");
		return meetingDebugVO;
	}

	/**
	 * query MeetingDebugVO list
	 * 
	 * @param MeetingDebugVO
	 * @param PageController
	 * @return ArrayList<MeetingDebugVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDebugVO> query(
			MeetingDebugVO meetingDebugVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		MeetingDebugMQB meetingDebugMQB = new MeetingDebugMQB(
				MeetingDebugMQB.QUERY_FROM_MEETINGDEBUG, meetingDebugVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDebugMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDebugMQB, pageController);
		logger.info("list size	:	"
				+ meetingDebugMQB.getMeetingDebugList().size());
		logger.info("DAO	query	end");
		return meetingDebugMQB.getMeetingDebugList();
	}

	/**
	 * query MeetingDebugVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingDebugVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDebugVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingDebugMQB meetingDebugMQB = new MeetingDebugMQB(
				MeetingDebugMQB.QUERY_FROM_MEETINGDEBUG_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDebugMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDebugMQB, pageController);
		logger.info("list size	:	"
				+ meetingDebugMQB.getMeetingDebugList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingDebugMQB.getMeetingDebugList();
	}

	/**
	 * modify MeetingDebugVO column by ID
	 * 
	 * @param MeetingDebugVO
	 * @param TransactionManager
	 * @return MeetingDebugVO
	 * @throws Exception
	 */
	public static MeetingDebugVO modify(MeetingDebugVO meetingDebugVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingDebugTO meetingDebugTO = new MeetingDebugTO(
				MeetingDebugTO.MODIFY_MEETINGDEBUG, meetingDebugVO);
		meetingDebugTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDebugTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDebugTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDebugTO, tManager);
		}
		logger.info("DAO	modify	end");
		return meetingDebugVO;
	}

	/**
	 * delete MeetingDebugVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingDebugVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingDebugVO meetingDebugVO = new MeetingDebugVO();
		meetingDebugVO.setId(id);
		MeetingDebugTO meetingDebugTO = new MeetingDebugTO(
				MeetingDebugTO.DEL_MEETINGDEBUG, meetingDebugVO);

		meetingDebugTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDebugTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDebugTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDebugTO, tManager);
		}
		logger.info("result	:	" + meetingDebugTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingDebugTO.getexecuteResult();
	}
}
