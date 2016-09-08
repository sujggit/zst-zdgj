package com.zzst.dao.project.avic.applyVideoExport;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.project.avic.applyVideoExport.ApplyVideoExportVO;

/**
 * class description: ApplyVideoExport DAO
 * 
 * @date Tue Sep 25 16:50:34 CST 2012
 * @author ryan
 */
public class ApplyVideoExportDAO {
	private static Logger logger = CjfLogger.getLogger(ApplyVideoExportDAO.class
			.getName());

	private static final String id = "ApplyID";

	/**
	 * add ApplyVideoExportVO object
	 * 
	 * @param ApplyVideoExportVO
	 * @param TransactionManager
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public static ApplyVideoExportVO add(ApplyVideoExportVO applyVideoExportVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
//		applyVideoExportVO.setApplyID(UtilDAO.getUUid());
		ApplyVideoExportTO applyVideoExportTO = new ApplyVideoExportTO(
				ApplyVideoExportTO.ADD_APPLYVIDEOEXPORT, applyVideoExportVO);

		applyVideoExportTO.setSqlStr();
		logger.info("sqlStr	:	" + applyVideoExportTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyVideoExportTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyVideoExportTO, tManager);
		}
		logger.info("DAO	add	end");
		return applyVideoExportVO;
	}

	/**
	 * query ApplyVideoExportVO list
	 * 
	 * @param ApplyVideoExportVO
	 * @param PageController
	 * @return ArrayList<ApplyVideoExportVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyVideoExportVO> query(
			ApplyVideoExportVO applyVideoExportVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		ApplyVideoExportMQB applyVideoExportMQB = new ApplyVideoExportMQB(
				ApplyVideoExportMQB.QUERY_FROM_APPLY_VIDEO_EXPORT, applyVideoExportVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyVideoExportMQB.getSql());
		QueryTemplate.executeQueryForList(applyVideoExportMQB, pageController);
		logger.info("list size	:	"
				+ applyVideoExportMQB.getApplyVideoExportList().size());
		logger.info("DAO	query	end");
		return applyVideoExportMQB.getApplyVideoExportList();
	}

	/**
	 * query ApplyVideoExportVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ApplyVideoExportVO>
	 * @throws Exception
	 */
	public static ArrayList<ApplyVideoExportVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ApplyVideoExportMQB applyVideoExportMQB = new ApplyVideoExportMQB(
				ApplyVideoExportMQB.QUERY_FROM_APPLY_VIDEO_EXPORT_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyVideoExportMQB.getSql());
		QueryTemplate.executeQueryForList(applyVideoExportMQB, pageController);
		logger.info("list size	:	"
				+ applyVideoExportMQB.getApplyVideoExportList().size());
		logger.info("DAO	queryByIDs	end");
		return applyVideoExportMQB.getApplyVideoExportList();
	}

	/**
	 * modify ApplyVideoExportVO column by ID
	 * 
	 * @param ApplyVideoExportVO
	 * @param TransactionManager
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public static ApplyVideoExportVO modify(ApplyVideoExportVO applyVideoExportVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ApplyVideoExportTO applyVideoExportTO = new ApplyVideoExportTO(
				ApplyVideoExportTO.MODIFY_APPLYVIDEOEXPORT, applyVideoExportVO);
		applyVideoExportTO.setSqlStr();
		logger.info("sqlStr	:	" + applyVideoExportTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyVideoExportTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyVideoExportTO, tManager);
		}
		logger.info("DAO	modify	end");
		return applyVideoExportVO;
	}

	/**
	 * delete ApplyVideoExportVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ApplyVideoExportVO applyVideoExportVO = new ApplyVideoExportVO();
		applyVideoExportVO.setApplyID(ids);
		ApplyVideoExportTO applyVideoExportTO = new ApplyVideoExportTO(
				ApplyVideoExportTO.DEL_APPLYVIDEOEXPORT, applyVideoExportVO);

		applyVideoExportTO.setSqlStr();
		logger.info("sqlStr	:	" + applyVideoExportTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyVideoExportTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyVideoExportTO, tManager);
		}
		logger.info("result	:	" + applyVideoExportTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return applyVideoExportTO.getexecuteResult();
	}
	
	/**
	 * add ApplyVideoExportVO object
	 * 
	 * @param ApplyVideoExportVO
	 * @param TransactionManager
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public static ApplyVideoExportVO addByUUID(ApplyVideoExportVO applyVideoExportVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	addByUUID	begin");
		ApplyVideoExportTO applyVideoExportTO = new ApplyVideoExportTO(
				ApplyVideoExportTO.ADD_APPLYVIDEOEXPORT, applyVideoExportVO);

		applyVideoExportTO.setSqlStr();
		logger.info("sqlStr	:	" + applyVideoExportTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(applyVideoExportTO, true);
		} else {
			TransactionTemplate.executeTransaction(applyVideoExportTO, tManager);
		}
		logger.info("DAO	addByUUID	end");
		return applyVideoExportVO;
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplyVideoExportVO> queryApplyVideoExport(String ids,ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyVideoExport	begin");
		ApplyVideoExportMQB applyVideoExportMQB = new ApplyVideoExportMQB(
				ApplyVideoExportMQB.QUERY_FROM_BY_USERID,applyVideoExportVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyVideoExportMQB.getSql());
		QueryTemplate.executeQueryForList(applyVideoExportMQB, pageController);
		logger.info("list size	:	"
						+ applyVideoExportMQB.getApplyVideoExportList().size());
		logger.info("DAO	queryApplyVideoExport	end");
		return applyVideoExportMQB.getApplyVideoExportList();
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息历史
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(String ids,ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyVideoExportHistory	begin");
		ApplyVideoExportMQB applyVideoExportMQB = new ApplyVideoExportMQB(
				ApplyVideoExportMQB.QUERY_HISTORY_FROM_BY_USERID,applyVideoExportVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyVideoExportMQB.getSql());
		QueryTemplate.executeQueryForList(applyVideoExportMQB, pageController);
		logger.info("list size	:	"
						+ applyVideoExportMQB.getApplyVideoExportList().size());
		logger.info("DAO	queryApplyVideoExportHistory	end");
		return applyVideoExportMQB.getApplyVideoExportList();
	}
	
	
	/**
	 * 查询资料导出审批信息历史
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplyVideoExportHistory	begin");
		ApplyVideoExportMQB applyVideoExportMQB = new ApplyVideoExportMQB(
				ApplyVideoExportMQB.QUERY_HISTORY_ALL,applyVideoExportVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + applyVideoExportMQB.getSql());
		QueryTemplate.executeQueryForList(applyVideoExportMQB, pageController);
		logger.info("list size	:	"
						+ applyVideoExportMQB.getApplyVideoExportList().size());
		logger.info("DAO	queryApplyVideoExportHistory	end");
		return applyVideoExportMQB.getApplyVideoExportList();
	}
}
