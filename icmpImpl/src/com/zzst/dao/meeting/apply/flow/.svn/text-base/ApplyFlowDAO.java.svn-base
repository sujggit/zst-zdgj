package com.zzst.dao.meeting.apply.flow;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyFlow DAO
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlowDAO {
	private static Logger logger = CjfLogger.getLogger(ApplyFlowDAO.class
			.getName());

	private static final String id = "FlowID";

	/**
	 * add ApplyFlowVO object
	 * 
	 * @param ApplyFlowVO
	 * @param TransactionManager
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public static ApplyFlowVO add(ApplyFlowVO applyFlowVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		applyFlowVO.setFlowID(UtilDAO.getUUid());
		ApplyFlowTO applyFlowTO = new ApplyFlowTO(ApplyFlowTO.ADD_APPLYFLOW,
				applyFlowVO);

		applyFlowTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlowTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlowTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlowTO, tManager);
		}
		logger.info("DAO	add	end");
		return applyFlowVO;
	}

	/**
	 * query ApplyFlowVO list
	 * 
	 * @param ApplyFlowVO
	 * @param PageController
	 * @return ArrayList<ApplyFlowVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyFlowVO> query(ApplyFlowVO applyFlowVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		ApplyFlowMQB applyFlowMQB = new ApplyFlowMQB(
				ApplyFlowMQB.QUERY_FROM_APPLYFLOW, applyFlowVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyFlowMQB.getSql());
		QueryTemplate.executeQueryForList(applyFlowMQB, pageController);
		logger.info("list size	:	" + applyFlowMQB.getApplyFlowList().size());
		logger.info("DAO	query	end");
		return applyFlowMQB.getApplyFlowList();
	}

	/**
	 * query ApplyFlowVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplyFlowVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyFlowVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ApplyFlowMQB applyFlowMQB = new ApplyFlowMQB(
				ApplyFlowMQB.QUERY_FROM_APPLYFLOW_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyFlowMQB.getSql());
		QueryTemplate.executeQueryForList(applyFlowMQB, pageController);
		logger.info("list size	:	" + applyFlowMQB.getApplyFlowList().size());
		logger.info("DAO	queryByIDs	end");
		return applyFlowMQB.getApplyFlowList();
	}

	/**
	 * modify ApplyFlowVO column by ID
	 * 
	 * @param ApplyFlowVO
	 * @param TransactionManager
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public static ApplyFlowVO modify(ApplyFlowVO applyFlowVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ApplyFlowTO applyFlowTO = new ApplyFlowTO(ApplyFlowTO.MODIFY_APPLYFLOW,
				applyFlowVO);
		applyFlowTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlowTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlowTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlowTO, tManager);
		}
		logger.info("DAO	modify	end");
		return applyFlowVO;
	}

	/**
	 * delete ApplyFlowVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ApplyFlowVO applyFlowVO = new ApplyFlowVO();
		applyFlowVO.setFlowID(id);
		ApplyFlowTO applyFlowTO = new ApplyFlowTO(ApplyFlowTO.DEL_APPLYFLOW,
				applyFlowVO);

		applyFlowTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlowTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlowTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlowTO, tManager);
		}
		logger.info("result	:	" + applyFlowTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return applyFlowTO.getexecuteResult();
	}
}
