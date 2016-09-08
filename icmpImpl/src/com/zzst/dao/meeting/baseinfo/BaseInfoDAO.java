package com.zzst.dao.meeting.baseinfo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.config.BaseInfoVO;

/**
 * class description: BaseInfo DAO
 * 
 * @date Fri Jun 15 13:43:00 CST 2012
 * @author ryan
 */
public class BaseInfoDAO {
	private static Logger logger = CjfLogger.getLogger(BaseInfoDAO.class.getName());


	/**
	 * add BaseInfoVO object
	 * 
	 * @param BaseInfoVO
	 * @param TransactionManager
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public static BaseInfoVO add(BaseInfoVO baseInfoVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		baseInfoVO.setId(UtilDAO.getUUid());
		BaseInfoTO baseInfoTO = new BaseInfoTO(BaseInfoTO.ADD_BASEINFO, baseInfoVO);

		baseInfoTO.setSqlStr();
		logger.info("sqlStr	:	" + baseInfoTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(baseInfoTO, true);
		} else {
			TransactionTemplate.executeTransaction(baseInfoTO, tManager);
		}
		logger.info("DAO	add	end");
		return baseInfoVO;
	}

	/**
	 * query BaseInfoVO list
	 * 
	 * @param BaseInfoVO
	 * @param PageController
	 * @return ArrayList<BaseInfoVO>
	 * @throws Exception
	 */
	public static ArrayList<BaseInfoVO> query(BaseInfoVO baseInfoVO, PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		BaseInfoMQB baseInfoMQB = new BaseInfoMQB(BaseInfoMQB.QUERY_FROM_BASEINFO, baseInfoVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + baseInfoMQB.getSql());
		QueryTemplate.executeQueryForList(baseInfoMQB, pageController);
		logger.info("list size	:	" + baseInfoMQB.getBaseInfoList().size());
		logger.info("DAO	query	end");
		return baseInfoMQB.getBaseInfoList();
	}

	/**
	 * query BaseInfoVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<BaseInfoVO>
	 * @throws Exception
	 */
	public static ArrayList<BaseInfoVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		BaseInfoMQB baseInfoMQB = new BaseInfoMQB(BaseInfoMQB.QUERY_FROM_BASEINFO_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + baseInfoMQB.getSql());
		QueryTemplate.executeQueryForList(baseInfoMQB, pageController);
		logger.info("list size	:	" + baseInfoMQB.getBaseInfoList().size());
		logger.info("DAO	queryByIDs	end");
		return baseInfoMQB.getBaseInfoList();
	}

	/**
	 * modify BaseInfoVO column by ID
	 * 
	 * @param BaseInfoVO
	 * @param TransactionManager
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public static BaseInfoVO modify(BaseInfoVO baseInfoVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		BaseInfoTO baseInfoTO = new BaseInfoTO(BaseInfoTO.MODIFY_BASEINFO, baseInfoVO);
		baseInfoTO.setSqlStr();
		logger.info("sqlStr	:	" + baseInfoTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(baseInfoTO, true);
		} else {
			TransactionTemplate.executeTransaction(baseInfoTO, tManager);
		}
		logger.info("DAO	modify	end");
		return baseInfoVO;
	}

	/**
	 * delete BaseInfoVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setId(ids);
		BaseInfoTO baseInfoTO = new BaseInfoTO(BaseInfoTO.DEL_BASEINFO, baseInfoVO);

		baseInfoTO.setSqlStr();
		logger.info("sqlStr	:	" + baseInfoTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(baseInfoTO, true);
		} else {
			TransactionTemplate.executeTransaction(baseInfoTO, tManager);
		}
		logger.info("result	:	" + baseInfoTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return baseInfoTO.getexecuteResult();
	}

	public static ArrayList<BaseInfoVO> queryForKstInit(BaseInfoVO baseInfoVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryForKstInit 	begin");
		BaseInfoMQB baseInfoMQB = new BaseInfoMQB(BaseInfoMQB.QUERY_FOR_KST_INIT, baseInfoVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + baseInfoMQB.getSql());
		QueryTemplate.executeQueryForList(baseInfoMQB, pageController);
		logger.info("list size	:	" + baseInfoMQB.getBaseInfoList().size());
		logger.info("DAO	queryForKstInit 	end");
		return baseInfoMQB.getBaseInfoList();
	}
}
