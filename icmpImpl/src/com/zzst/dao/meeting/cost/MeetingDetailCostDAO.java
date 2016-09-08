package com.zzst.dao.meeting.cost;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingDetailCost DAO
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public class MeetingDetailCostDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingDetailCostDAO.class.getName());

	private static final String id = "Id";

	/**
	 * add MeetingDetailCostVO object
	 * 
	 * @param MeetingDetailCostVO
	 * @param TransactionManager
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public static MeetingDetailCostVO add(
			MeetingDetailCostVO meetingDetailCostVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		meetingDetailCostVO.setId(UtilDAO.getUUid());
		MeetingDetailCostTO meetingDetailCostTO = new MeetingDetailCostTO(
				MeetingDetailCostTO.ADD_MEETINGDETAILCOST, meetingDetailCostVO);

		meetingDetailCostTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailCostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailCostTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailCostTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingDetailCostVO;
	}

	/**
	 * query MeetingDetailCostVO list
	 * 
	 * @param MeetingDetailCostVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailCostVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailCostVO> query(
			MeetingDetailCostVO meetingDetailCostVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingDetailCostMQB meetingDetailCostMQB = new MeetingDetailCostMQB(
				MeetingDetailCostMQB.QUERY_FROM_MEETINGDETAILCOST,
				meetingDetailCostVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailCostMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailCostMQB, pageController);
		logger.info("list size	:	"
				+ meetingDetailCostMQB.getMeetingDetailCostList().size());
		logger.info("DAO	query	end");
		return meetingDetailCostMQB.getMeetingDetailCostList();
	}

	/**
	 * query MeetingDetailCostVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingDetailCostVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailCostVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingDetailCostMQB meetingDetailCostMQB = new MeetingDetailCostMQB(
				MeetingDetailCostMQB.QUERY_FROM_MEETINGDETAILCOST_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailCostMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailCostMQB, pageController);
		logger.info("list size	:	"
				+ meetingDetailCostMQB.getMeetingDetailCostList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingDetailCostMQB.getMeetingDetailCostList();
	}

	/**
	 * modify MeetingDetailCostVO column by ID
	 * 
	 * @param MeetingDetailCostVO
	 * @param TransactionManager
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public static MeetingDetailCostVO modify(
			MeetingDetailCostVO meetingDetailCostVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		MeetingDetailCostTO meetingDetailCostTO = new MeetingDetailCostTO(
				MeetingDetailCostTO.MODIFY_MEETINGDETAILCOST,
				meetingDetailCostVO);
		meetingDetailCostTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailCostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailCostTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailCostTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingDetailCostVO;
	}

	/**
	 * delete MeetingDetailCostVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingDetailCostVO meetingDetailCostVO = new MeetingDetailCostVO();
		meetingDetailCostVO.setId(id);
		MeetingDetailCostTO meetingDetailCostTO = new MeetingDetailCostTO(
				MeetingDetailCostTO.DEL_MEETINGDETAILCOST, meetingDetailCostVO);

		meetingDetailCostTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailCostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailCostTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailCostTO,
					tManager);
		}
		logger.info("result	:	" + meetingDetailCostTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingDetailCostTO.getexecuteResult();
	}

	public static ArrayList<MeetingDetailCostVO> queryMeetingDetail(
			MeetingDetailCostVO meetingDetailCostVO, PageController pageController) throws Exception {
		logger.info("DAO	queryMeetingDetail	begin");
		MeetingDetailAndCostMQB meetingDetailAndCostMQB = new MeetingDetailAndCostMQB(
				MeetingDetailAndCostMQB.QUERY_FROM_MEETINGDETAILCOST_MEETINGDETAIL,
				meetingDetailCostVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailAndCostMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailAndCostMQB, pageController);
		logger.info("list size	:	"
				+ meetingDetailAndCostMQB.getMeetingDetailCostList().size());
		logger.info("DAO	queryMeetingDetail	end");
		return meetingDetailAndCostMQB.getMeetingDetailCostList();
	}

	public static MeetingDetailCostVO modifyCout(
			MeetingDetailCostVO meetingDetailCostVO, TransactionManager tManager) 
			throws Exception {
		logger.info("DAO	modifyCout	begin");
		MeetingDetailCostTO meetingDetailCostTO = new MeetingDetailCostTO(
				MeetingDetailCostTO.MODIFYCOUT_MEETINGDETAILCOST,
				meetingDetailCostVO);
		meetingDetailCostTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailCostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailCostTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailCostTO,
					tManager);
		}
		logger.info("DAO	modifyCout	end");
		return meetingDetailCostVO;
	}
}
