package com.zzst.dao.meeting.apply.applyDetail;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyDetail DAO
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public class ApplyDetailDAO {
	private static Logger logger = CjfLogger.getLogger(ApplyDetailDAO.class
			.getName());

	private static final String id = "DetailID";

	/**
	 * add ApplyDetailVO object
	 * 
	 * @param ApplyDetailVO
	 * @param TransactionManager
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public static ApplyDetailVO add(ApplyDetailVO applyDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		applyDetailVO.setDetailID(UtilDAO.getUUid());
		ApplyDetailTO applyDetailTO = new ApplyDetailTO(
				ApplyDetailTO.ADD_APPLYDETAIL, applyDetailVO);

		applyDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + applyDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyDetailTO, tManager);
		}
		logger.info("DAO	add	end");
		return applyDetailVO;
	}

	/**
	 * query ApplyDetailVO list
	 * 
	 * @param ApplyDetailVO
	 * @param PageController
	 * @return ArrayList<ApplyDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyDetailVO> query(ApplyDetailVO applyDetailVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		ApplyDetailMQB applyDetailMQB = new ApplyDetailMQB(
				ApplyDetailMQB.QUERY_FROM_APPLYDETAIL, applyDetailVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyDetailMQB.getSql());
		QueryTemplate.executeQueryForList(applyDetailMQB, pageController);
		logger
				.info("list size	:	"
						+ applyDetailMQB.getApplyDetailList().size());
		logger.info("DAO	query	end");
		return applyDetailMQB.getApplyDetailList();
	}

	/**
	 * query ApplyDetailVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplyDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyDetailVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ApplyDetailMQB applyDetailMQB = new ApplyDetailMQB(
				ApplyDetailMQB.QUERY_FROM_APPLYDETAIL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyDetailMQB.getSql());
		QueryTemplate.executeQueryForList(applyDetailMQB, pageController);
		logger
				.info("list size	:	"
						+ applyDetailMQB.getApplyDetailList().size());
		logger.info("DAO	queryByIDs	end");
		return applyDetailMQB.getApplyDetailList();
	}

	/**
	 * modify ApplyDetailVO column by ID
	 * 
	 * @param ApplyDetailVO
	 * @param TransactionManager
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public static ApplyDetailVO modify(ApplyDetailVO applyDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ApplyDetailTO applyDetailTO = new ApplyDetailTO(
				ApplyDetailTO.MODIFY_APPLYDETAIL, applyDetailVO);
		applyDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + applyDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyDetailTO, tManager);
		}
		logger.info("DAO	modify	end");
		return applyDetailVO;
	}

	/**
	 * delete ApplyDetailVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ApplyDetailVO applyDetailVO = new ApplyDetailVO();
		applyDetailVO.setDetailID(id);
		ApplyDetailTO applyDetailTO = new ApplyDetailTO(
				ApplyDetailTO.DEL_APPLYDETAIL, applyDetailVO);

		applyDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + applyDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyDetailTO, tManager);
		}
		logger.info("result	:	" + applyDetailTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return applyDetailTO.getexecuteResult();
	}
}
