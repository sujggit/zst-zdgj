package com.zzst.dao.meeting.centerControl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.centerControl.CenterControlVO;

/**
 * class description: CenterControl DAO
 * 
 * @date Thu Jun 28 15:18:31 CST 2012
 * @author ryan
 */
public class CenterControlDAO {
	private static Logger logger = CjfLogger.getLogger(CenterControlDAO.class.getName());


	/**
	 * add CenterControlVO object
	 * 
	 * @param CenterControlVO
	 * @param TransactionManager
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public static CenterControlVO add(CenterControlVO centerControlVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		centerControlVO.setId(UtilDAO.getUUid());
		CenterControlTO centerControlTO = new CenterControlTO(CenterControlTO.ADD_CENTERCONTROL, centerControlVO);

		centerControlTO.setSqlStr();
		logger.info("sqlStr	:	" + centerControlTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(centerControlTO, true);
		} else {
			TransactionTemplate.executeTransaction(centerControlTO, tManager);
		}
		logger.info("DAO	add	end");
		return centerControlVO;
	}

	/**
	 * query CenterControlVO list
	 * 
	 * @param CenterControlVO
	 * @param PageController
	 * @return ArrayList<CenterControlVO>
	 * @throws Exception
	 */
	public static ArrayList<CenterControlVO> query(CenterControlVO centerControlVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		CenterControlMQB centerControlMQB = new CenterControlMQB(CenterControlMQB.QUERY_FROM_CENTERCONTROL,
				centerControlVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + centerControlMQB.getSql());
		QueryTemplate.executeQueryForList(centerControlMQB, pageController);
		logger.info("list size	:	" + centerControlMQB.getCenterControlList().size());
		logger.info("DAO	query	end");
		return centerControlMQB.getCenterControlList();
	}

	/**
	 * query CenterControlVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<CenterControlVO>
	 * @throws Exception
	 */
	public static ArrayList<CenterControlVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		CenterControlMQB centerControlMQB = new CenterControlMQB(CenterControlMQB.QUERY_FROM_CENTERCONTROL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + centerControlMQB.getSql());
		QueryTemplate.executeQueryForList(centerControlMQB, pageController);
		logger.info("list size	:	" + centerControlMQB.getCenterControlList().size());
		logger.info("DAO	queryByIDs	end");
		return centerControlMQB.getCenterControlList();
	}

	/**
	 * modify CenterControlVO column by ID
	 * 
	 * @param CenterControlVO
	 * @param TransactionManager
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public static CenterControlVO modify(CenterControlVO centerControlVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		CenterControlTO centerControlTO = new CenterControlTO(CenterControlTO.MODIFY_CENTERCONTROL, centerControlVO);
		centerControlTO.setSqlStr();
		logger.info("sqlStr	:	" + centerControlTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(centerControlTO, true);
		} else {
			TransactionTemplate.executeTransaction(centerControlTO, tManager);
		}
		logger.info("DAO	modify	end");
		return centerControlVO;
	}

	/**
	 * delete CenterControlVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		CenterControlVO centerControlVO = new CenterControlVO();
		centerControlVO.setId(ids);
		CenterControlTO centerControlTO = new CenterControlTO(CenterControlTO.DEL_CENTERCONTROL, centerControlVO);

		centerControlTO.setSqlStr();
		logger.info("sqlStr	:	" + centerControlTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(centerControlTO, true);
		} else {
			TransactionTemplate.executeTransaction(centerControlTO, tManager);
		}
		logger.info("result	:	" + centerControlTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return centerControlTO.getexecuteResult();
	}
	
	/**
	 * method description : query CenterControlVO no duplicates
	 * @param CenterControlVO
	 * @return ArrayList<CenterControlVO>
	 * @throws Exception 
	 */
	public static ArrayList<CenterControlVO> queryNoDuplicates(CenterControlVO centerControlVO) throws Exception{
		logger.info("DAO    queryNoDuplicates begin");
		CenterControlMQB centerControlMQB = new CenterControlMQB(CenterControlMQB.QUERY_NO_DUPLICATES,
				centerControlVO);
		PageController pageController = null;
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + centerControlMQB.getSql());
		QueryTemplate.executeQueryForList(centerControlMQB, pageController);
		logger.info("list size	:	" + centerControlMQB.getCenterControlList().size());
		logger.info("DAO	query	end");
		return centerControlMQB.getCenterControlList();
	}
}
