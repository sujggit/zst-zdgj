package com.zzst.dao.meeting.apply.flownode;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyFlownode DAO
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlownodeDAO {
	private static Logger logger = CjfLogger.getLogger(ApplyFlownodeDAO.class
			.getName());

	private static final String id = "FlownodeID";

	/**
	 * add ApplyFlownodeVO object
	 * 
	 * @param ApplyFlownodeVO
	 * @param TransactionManager
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public static ApplyFlownodeVO add(ApplyFlownodeVO applyFlownodeVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		applyFlownodeVO.setFlownodeID(UtilDAO.getUUid());
		ApplyFlownodeTO applyFlownodeTO = new ApplyFlownodeTO(
				ApplyFlownodeTO.ADD_APPLYFLOWNODE, applyFlownodeVO);

		applyFlownodeTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlownodeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlownodeTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlownodeTO, tManager);
		}
		logger.info("DAO	add	end");
		return applyFlownodeVO;
	}

	/**
	 * query ApplyFlownodeVO list
	 * 
	 * @param ApplyFlownodeVO
	 * @param PageController
	 * @return ArrayList<ApplyFlownodeVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyFlownodeVO> query(
			ApplyFlownodeVO applyFlownodeVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		ApplyFlownodeMQB applyFlownodeMQB = new ApplyFlownodeMQB(
				ApplyFlownodeMQB.QUERY_FROM_APPLYFLOWNODE, applyFlownodeVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyFlownodeMQB.getSql());
		QueryTemplate.executeQueryForList(applyFlownodeMQB, pageController);
		logger.info("list size	:	"
				+ applyFlownodeMQB.getApplyFlownodeList().size());
		logger.info("DAO	query	end");
		return applyFlownodeMQB.getApplyFlownodeList();
	}

	/**
	 * query ApplyFlownodeVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplyFlownodeVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyFlownodeVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ApplyFlownodeMQB applyFlownodeMQB = new ApplyFlownodeMQB(
				ApplyFlownodeMQB.QUERY_FROM_APPLYFLOWNODE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyFlownodeMQB.getSql());
		QueryTemplate.executeQueryForList(applyFlownodeMQB, pageController);
		logger.info("list size	:	"
				+ applyFlownodeMQB.getApplyFlownodeList().size());
		logger.info("DAO	queryByIDs	end");
		return applyFlownodeMQB.getApplyFlownodeList();
	}

	/**
	 * modify ApplyFlownodeVO column by ID
	 * 
	 * @param ApplyFlownodeVO
	 * @param TransactionManager
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public static ApplyFlownodeVO modify(ApplyFlownodeVO applyFlownodeVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ApplyFlownodeTO applyFlownodeTO = new ApplyFlownodeTO(
				ApplyFlownodeTO.MODIFY_APPLYFLOWNODE, applyFlownodeVO);
		applyFlownodeTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlownodeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlownodeTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlownodeTO, tManager);
		}
		logger.info("DAO	modify	end");
		return applyFlownodeVO;
	}

	/**
	 * delete ApplyFlownodeVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
		applyFlownodeVO.setFlownodeID(id);
		ApplyFlownodeTO applyFlownodeTO = new ApplyFlownodeTO(
				ApplyFlownodeTO.DEL_APPLYFLOWNODE, applyFlownodeVO);

		applyFlownodeTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlownodeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlownodeTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlownodeTO, tManager);
		}
		logger.info("result	:	" + applyFlownodeTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return applyFlownodeTO.getexecuteResult();
	}

	public static ArrayList<ApplyFlownodeVO> queryWithOthTab(
			ApplyFlownodeVO applyFlownodeVO, PageController pageController) throws Exception{
			logger.info("DAO	queryWithOthTab	begin");
			ApplyFlownodeMQB1 applyFlownodeMQB = new ApplyFlownodeMQB1(
					ApplyFlownodeMQB1.QUERY_FROM_APPLYFLOWNODE_APPLYFLOW, applyFlownodeVO);

			if (pageController == null) {
				pageController = new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	" + applyFlownodeMQB.getSql());
			QueryTemplate.executeQueryForList(applyFlownodeMQB, pageController);
			logger.info("list size	:	"
					+ applyFlownodeMQB.getApplyFlownodeList().size());
			logger.info("DAO	queryWithOthTab	end");
			return applyFlownodeMQB.getApplyFlownodeList();
	}

	public static int deleteByFlowID(ApplyFlownodeVO applyFlownodeVO, TransactionManager tManager) throws Exception{
		logger.info("DAO	deleteByFlowID	begin");
		ApplyFlownodeTO applyFlownodeTO = new ApplyFlownodeTO(
				ApplyFlownodeTO.DEL_APPLYFLOWNODE_BYFLOWID, applyFlownodeVO);

		applyFlownodeTO.setSqlStr();
		logger.info("sqlStr	:	" + applyFlownodeTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyFlownodeTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyFlownodeTO, tManager);
		}
		logger.info("result	:	" + applyFlownodeTO.getexecuteResult());
		logger.info("DAO	deleteByFlowID	end");
		return applyFlownodeTO.getexecuteResult();
	}
}
