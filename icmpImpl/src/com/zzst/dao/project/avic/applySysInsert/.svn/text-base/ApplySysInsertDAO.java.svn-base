package com.zzst.dao.project.avic.applySysInsert;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;

/**
 * class description: ApplySysInsert DAO
 * 
 * @date Fri Sep 21 17:34:16 CST 2012
 * @author ryan
 */
public class ApplySysInsertDAO {
	private static Logger logger = CjfLogger.getLogger(ApplySysInsertDAO.class
			.getName());

	private static final String id = "ApplyID";

	/**
	 * add ApplySysInsertVO object
	 * 
	 * @param ApplySysInsertVO
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public static ApplySysInsertVO add(ApplySysInsertVO applySysInsertVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
//		applySysInsertVO.setApplyID(UtilDAO.getUUid());
		ApplySysInsertTO applySysInsertTO = new ApplySysInsertTO(
				ApplySysInsertTO.ADD_APPLYSYSINSERT, applySysInsertVO);

		applySysInsertTO.setSqlStr();
		logger.info("sqlStr	:	" + applySysInsertTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applySysInsertTO, true);
		} else {
			TransactionTemplate.executeTransaction(applySysInsertTO, tManager);
		}
		logger.info("DAO	add	end");
		return applySysInsertVO;
	}

	/**
	 * query ApplySysInsertVO list
	 * 
	 * @param ApplySysInsertVO
	 * @param PageController
	 * @return ArrayList<ApplySysInsertVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplySysInsertVO> query(
			ApplySysInsertVO applySysInsertVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		ApplySysInsertMQB applySysInsertMQB = new ApplySysInsertMQB(
				ApplySysInsertMQB.QUERY_FROM_APPLYSYSINSERT, applySysInsertVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applySysInsertMQB.getSql());
		QueryTemplate.executeQueryForList(applySysInsertMQB, pageController);
		logger.info("list size	:	"
				+ applySysInsertMQB.getApplySysInsertList().size());
		logger.info("DAO	query	end");
		return applySysInsertMQB.getApplySysInsertList();
	}

	/**
	 * query ApplySysInsertVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplySysInsertVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplySysInsertVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ApplySysInsertMQB applySysInsertMQB = new ApplySysInsertMQB(
				ApplySysInsertMQB.QUERY_FROM_APPLYSYSINSERT_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applySysInsertMQB.getSql());
		QueryTemplate.executeQueryForList(applySysInsertMQB, pageController);
		logger.info("list size	:	"
				+ applySysInsertMQB.getApplySysInsertList().size());
		logger.info("DAO	queryByIDs	end");
		return applySysInsertMQB.getApplySysInsertList();
	}

	/**
	 * modify ApplySysInsertVO column by ID
	 * 
	 * @param ApplySysInsertVO
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public static ApplySysInsertVO modify(ApplySysInsertVO applySysInsertVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ApplySysInsertTO applySysInsertTO = new ApplySysInsertTO(
				ApplySysInsertTO.MODIFY_APPLYSYSINSERT, applySysInsertVO);
		applySysInsertTO.setSqlStr();
		logger.info("sqlStr	:	" + applySysInsertTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applySysInsertTO, true);
		} else {
			TransactionTemplate.executeTransaction(applySysInsertTO, tManager);
		}
		logger.info("DAO	modify	end");
		return applySysInsertVO;
	}

	/**
	 * delete ApplySysInsertVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ApplySysInsertVO applySysInsertVO = new ApplySysInsertVO();
		applySysInsertVO.setApplyID(ids);
		ApplySysInsertTO applySysInsertTO = new ApplySysInsertTO(
				ApplySysInsertTO.DEL_APPLYSYSINSERT, applySysInsertVO);

		applySysInsertTO.setSqlStr();
		logger.info("sqlStr	:	" + applySysInsertTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applySysInsertTO, true);
		} else {
			TransactionTemplate.executeTransaction(applySysInsertTO, tManager);
		}
		logger.info("result	:	" + applySysInsertTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return applySysInsertTO.getexecuteResult();
	}
	
	/**
	 * add ApplySysInsertVO object
	 * 
	 * @param ApplySysInsertVO
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public static ApplySysInsertVO addByUUID(ApplySysInsertVO applySysInsertVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	addByUUID	begin");
		ApplySysInsertTO applySysInsertTO = new ApplySysInsertTO(
				ApplySysInsertTO.ADD_APPLYSYSINSERT, applySysInsertVO);

		applySysInsertTO.setSqlStr();
		logger.info("sqlStr	:	" + applySysInsertTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applySysInsertTO, true);
		} else {
			TransactionTemplate.executeTransaction(applySysInsertTO, tManager);
		}
		logger.info("DAO	addByUUID	end");
		return applySysInsertVO;
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplySysInsertVO> queryApplySysInsert(String ids,ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsert	begin");
		ApplySysInsertMQB applySysInsertMQB = new ApplySysInsertMQB(
				ApplySysInsertMQB.QUERY_FROM_BY_USERID,applySysInsertVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applySysInsertMQB.getSql());
		QueryTemplate.executeQueryForList(applySysInsertMQB, pageController);
		logger.info("list size	:	"
						+ applySysInsertMQB.getApplySysInsertList().size());
		logger.info("DAO	queryApplySysInsert	end");
		return applySysInsertMQB.getApplySysInsertList();
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息历史
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(String ids,ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsertHistory	begin");
		ApplySysInsertMQB applySysInsertMQB = new ApplySysInsertMQB(
				ApplySysInsertMQB.QUERY_HISTORY_FROM_BY_USERID,applySysInsertVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applySysInsertMQB.getSql());
		QueryTemplate.executeQueryForList(applySysInsertMQB, pageController);
		logger.info("list size	:	"
						+ applySysInsertMQB.getApplySysInsertList().size());
		logger.info("DAO	queryApplySysInsertHistory	end");
		return applySysInsertMQB.getApplySysInsertList();
	}
	
	
	
	/**
	 * 查询接入审批信息历史
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsert	begin");
		ApplySysInsertMQB applySysInsertMQB = new ApplySysInsertMQB(
				ApplySysInsertMQB.QUERY_HISTORY_ALL,applySysInsertVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applySysInsertMQB.getSql());
		QueryTemplate.executeQueryForList(applySysInsertMQB, pageController);
		logger.info("list size	:	"
						+ applySysInsertMQB.getApplySysInsertList().size());
		logger.info("DAO	queryApplySysInsert	end");
		return applySysInsertMQB.getApplySysInsertList();
	}
}
