package com.zzst.dao.project.avic.staffsRecord;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.project.avic.StaffsRecordVO;

/**
 * class description: StaffsRecord DAO
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public class StaffsRecordDAO {
	private static Logger logger = CjfLogger.getLogger(StaffsRecordDAO.class
			.getName());

	private static final String id = "StaffsRecordID";

	/**
	 * add StaffsRecordVO object
	 * 
	 * @param StaffsRecordVO
	 * @param TransactionManager
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public static StaffsRecordVO add(StaffsRecordVO staffsRecordVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		staffsRecordVO.setStaffsRecordID(UtilDAO.getUUid());
		StaffsRecordTO staffsRecordTO = new StaffsRecordTO(
				StaffsRecordTO.ADD_STAFFSRECORD, staffsRecordVO);

		staffsRecordTO.setSqlStr();
		logger.info("sqlStr	:	" + staffsRecordTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(staffsRecordTO, true);
		} else {
			TransactionTemplate.executeTransaction(staffsRecordTO, tManager);
		}
		logger.info("DAO	add	end");
		return staffsRecordVO;
	}

	/**
	 * query StaffsRecordVO list
	 * 
	 * @param StaffsRecordVO
	 * @param PageController
	 * @return ArrayList<StaffsRecordVO>
	 * @throws Exception
	 */
	public static ArrayList<StaffsRecordVO> query(
			StaffsRecordVO staffsRecordVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		StaffsRecordMQB staffsRecordMQB = new StaffsRecordMQB(
				StaffsRecordMQB.QUERY_FROM_STAFFSRECORD, staffsRecordVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + staffsRecordMQB.getSql());
		QueryTemplate.executeQueryForList(staffsRecordMQB, pageController);
		logger.info("list size	:	"
				+ staffsRecordMQB.getStaffsRecordList().size());
		logger.info("DAO	query	end");
		return staffsRecordMQB.getStaffsRecordList();
	}

	/**
	 * query StaffsRecordVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<StaffsRecordVO>
	 * @throws Exception
	 */
	public static ArrayList<StaffsRecordVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		StaffsRecordMQB staffsRecordMQB = new StaffsRecordMQB(
				StaffsRecordMQB.QUERY_FROM_STAFFSRECORD_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + staffsRecordMQB.getSql());
		QueryTemplate.executeQueryForList(staffsRecordMQB, pageController);
		logger.info("list size	:	"
				+ staffsRecordMQB.getStaffsRecordList().size());
		logger.info("DAO	queryByIDs	end");
		return staffsRecordMQB.getStaffsRecordList();
	}

	/**
	 * modify StaffsRecordVO column by ID
	 * 
	 * @param StaffsRecordVO
	 * @param TransactionManager
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public static StaffsRecordVO modify(StaffsRecordVO staffsRecordVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		StaffsRecordTO staffsRecordTO = new StaffsRecordTO(
				StaffsRecordTO.MODIFY_STAFFSRECORD, staffsRecordVO);
		staffsRecordTO.setSqlStr();
		logger.info("sqlStr	:	" + staffsRecordTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(staffsRecordTO, true);
		} else {
			TransactionTemplate.executeTransaction(staffsRecordTO, tManager);
		}
		logger.info("DAO	modify	end");
		return staffsRecordVO;
	}

	/**
	 * delete StaffsRecordVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return StaffsRecordVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		StaffsRecordVO staffsRecordVO = new StaffsRecordVO();
		staffsRecordVO.setStaffsRecordID(ids);
		StaffsRecordTO staffsRecordTO = new StaffsRecordTO(
				StaffsRecordTO.DEL_STAFFSRECORD, staffsRecordVO);

		staffsRecordTO.setSqlStr();
		logger.info("sqlStr	:	" + staffsRecordTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(staffsRecordTO, true);
		} else {
			TransactionTemplate.executeTransaction(staffsRecordTO, tManager);
		}
		logger.info("result	:	" + staffsRecordTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return staffsRecordTO.getexecuteResult();
	}
}
