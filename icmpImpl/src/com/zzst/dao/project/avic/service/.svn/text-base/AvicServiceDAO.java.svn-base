package com.zzst.dao.project.avic.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService DAO
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceDAO {
	private static Logger logger = CjfLogger.getLogger(AvicServiceDAO.class
			.getName());

	private static final String id = "RecordID";

	/**
	 * add AvicServiceVO object
	 * 
	 * @param AvicServiceVO
	 * @param TransactionManager
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public static AvicServiceVO add(AvicServiceVO avicServiceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
//		avicServiceVO.setRecordID(UtilDAO.getUUid());
		AvicServiceTO avicServiceTO = new AvicServiceTO(
				AvicServiceTO.ADD_AVICSERVICE, avicServiceVO);

		avicServiceTO.setSqlStr();
		logger.info("sqlStr	:	" + avicServiceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(avicServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(avicServiceTO, tManager);
		}
		logger.info("DAO	add	end");
		return avicServiceVO;
	}

	/**
	 * query AvicServiceVO list
	 * 
	 * @param AvicServiceVO
	 * @param PageController
	 * @return ArrayList<AvicServiceVO>
	 * @throws Exception
	 */
	public static ArrayList<AvicServiceVO> query(AvicServiceVO avicServiceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		AvicServiceMQB avicServiceMQB = new AvicServiceMQB(
				AvicServiceMQB.QUERY_FROM_AVICSERVICE, avicServiceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB, pageController);
		logger
				.info("list size	:	"
						+ avicServiceMQB.getAvicServiceList().size());
		logger.info("DAO	query	end");
		return avicServiceMQB.getAvicServiceList();
	}

	/**
	 * query AvicServiceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<AvicServiceVO>
	 * @throws Exception
	 */
	public static ArrayList<AvicServiceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		AvicServiceMQB avicServiceMQB = new AvicServiceMQB(
				AvicServiceMQB.QUERY_FROM_AVICSERVICE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB, pageController);
		logger.info("list size	:	" + avicServiceMQB.getAvicServiceList().size());
		logger.info("DAO	queryByIDs	end");
		return avicServiceMQB.getAvicServiceList();
	}

	/**
	 * modify AvicServiceVO column by ID
	 * 
	 * @param AvicServiceVO
	 * @param TransactionManager
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public static AvicServiceVO modify(AvicServiceVO avicServiceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		AvicServiceTO avicServiceTO = new AvicServiceTO(
				AvicServiceTO.MODIFY_AVICSERVICE, avicServiceVO);
		avicServiceTO.setSqlStr();
		logger.info("sqlStr	:	" + avicServiceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(avicServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(avicServiceTO, tManager);
		}
		logger.info("DAO	modify	end");
		return avicServiceVO;
	}

	/**
	 * delete AvicServiceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		AvicServiceVO avicServiceVO = new AvicServiceVO();
		avicServiceVO.setRecordID(ids);
		AvicServiceTO avicServiceTO = new AvicServiceTO(
				AvicServiceTO.DEL_AVICSERVICE, avicServiceVO);

		avicServiceTO.setSqlStr();
		logger.info("sqlStr	:	" + avicServiceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(avicServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(avicServiceTO, tManager);
		}
		logger.info("result	:	" + avicServiceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return avicServiceTO.getexecuteResult();
	}
	
	/**
	 * query queryApplyConferences	list	by	userId
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplyDetailVO> 
	 * @throws Exception
	 */
	public static ArrayList<AvicServiceVO> queryApplyServices(AvicServiceVO avicServiceVO,String ids,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyServices	begin");
		AvicServiceMQB avicServiceMQB = new AvicServiceMQB(
				AvicServiceMQB.QUERY_FROM_BY_USERID,avicServiceVO,ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB, pageController);
		logger.info("list size	:	"
						+ avicServiceMQB.getAvicServiceList().size());
		logger.info("DAO	queryApplyServices	end");
		return avicServiceMQB.getAvicServiceList();
	}
	
	public static ArrayList<AvicServiceVO> queryApplyServicesHistory(AvicServiceVO avicServiceVO,String ids,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyServicesHistory	begin");
		AvicServiceMQB avicServiceMQB = new AvicServiceMQB(
				AvicServiceMQB.QUERY_HISTORY,avicServiceVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB, pageController);
		logger.info("list size	:	"
						+ avicServiceMQB.getAvicServiceList().size());
		logger.info("DAO	queryApplyServicesHistory	end");
		return avicServiceMQB.getAvicServiceList();
	}
	
	public static ArrayList<AvicServiceVO> queryApplyServicesHistory(AvicServiceVO avicServiceVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyServicesHistory	begin");
		AvicServiceMQB avicServiceMQB = new AvicServiceMQB(
				AvicServiceMQB.QUERY_HISTORY_ALL,avicServiceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB, pageController);
		logger.info("list size	:	"
						+ avicServiceMQB.getAvicServiceList().size());
		logger.info("DAO	queryApplyServicesHistory	end");
		return avicServiceMQB.getAvicServiceList();
	}

	public static ArrayList<AvicServiceVO> queryForCostStatistices(
			AvicServiceVO avicServiceVO, PageController pageController) throws Exception{
		logger.info("DAO queryForCostStatistices	begin");
		AvicServiceMQB_ForCost avicServiceMQB_ForCost = new AvicServiceMQB_ForCost(
				AvicServiceMQB_ForCost.QUERY_FOR_COST_STATISTICES,avicServiceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + avicServiceMQB_ForCost.getSql());
		QueryTemplate.executeQueryForList(avicServiceMQB_ForCost, pageController);
		logger.info("list size	:	"
						+ avicServiceMQB_ForCost.getAvicServiceList().size());
		logger.info("DAO	queryForCostStatistices	end");
		return avicServiceMQB_ForCost.getAvicServiceList();
	}
}
