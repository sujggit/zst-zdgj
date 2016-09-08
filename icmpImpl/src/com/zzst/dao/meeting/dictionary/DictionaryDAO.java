package com.zzst.dao.meeting.dictionary;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.user.UserTO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: Dictionary DAO
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public class DictionaryDAO {
	private static Logger logger = CjfLogger.getLogger(DictionaryDAO.class
			.getName());

	private static final String id = "DicID";

	/**
	 * add DictionaryVO object
	 * 
	 * @param DictionaryVO
	 * @param TransactionManager
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public static DictionaryVO add(DictionaryVO dictionaryVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		dictionaryVO.setDicID(UtilDAO.getUUid());
		DictionaryTO dictionaryTO = new DictionaryTO(
				DictionaryTO.ADD_DICTIONARY, dictionaryVO);

		dictionaryTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryTO, tManager);
		}
		logger.info("DAO	add	end");
		return dictionaryVO;
	}

	/**
	 * query DictionaryVO list
	 * 
	 * @param DictionaryVO
	 * @param PageController
	 * @return ArrayList<DictionaryVO>
	 * @throws Exception
	 */
	public static ArrayList<DictionaryVO> query(DictionaryVO dictionaryVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DictionaryMQB dictionaryMQB = new DictionaryMQB(
				DictionaryMQB.QUERY_FROM_DICTIONARY, dictionaryVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryMQB, pageController);
		logger.info("list size	:	" + dictionaryMQB.getDictionaryList().size());
		logger.info("DAO	query	end");
		return dictionaryMQB.getDictionaryList();
	}

	/**
	 * query DictionaryVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<DictionaryVO>
	 * @throws Exception
	 */
	public static ArrayList<DictionaryVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		DictionaryMQB dictionaryMQB = new DictionaryMQB(
				DictionaryMQB.QUERY_FROM_DICTIONARY_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + dictionaryMQB.getSql());
		QueryTemplate.executeQueryForList(dictionaryMQB, pageController);
		logger.info("list size	:	" + dictionaryMQB.getDictionaryList().size());
		logger.info("DAO	queryByIDs	end");
		return dictionaryMQB.getDictionaryList();
	}

	/**
	 * modify DictionaryVO column by ID
	 * 
	 * @param DictionaryVO
	 * @param TransactionManager
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public static DictionaryVO modify(DictionaryVO dictionaryVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		DictionaryTO dictionaryTO = new DictionaryTO(
				DictionaryTO.MODIFY_DICTIONARY, dictionaryVO);
		dictionaryTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryTO, tManager);
		}
		logger.info("DAO	modify	end");
		return dictionaryVO;
	}

	/**
	 * delete DictionaryVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return DictionaryVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		DictionaryVO dictionaryVO = new DictionaryVO();
		dictionaryVO.setDicID(ids);
		DictionaryTO dictionaryTO = new DictionaryTO(
				DictionaryTO.DEL_DICTIONARY, dictionaryVO);

		dictionaryTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryTO, tManager);
		}
		logger.info("result	:	" + dictionaryTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return dictionaryTO.getexecuteResult();
	}

	public static DictionaryVO modifyDicValue(DictionaryVO dictionaryVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		DictionaryTO dictionaryTO = new DictionaryTO(
				DictionaryTO.MODIFY_DICVALUE_DICTIONARY, dictionaryVO);
		dictionaryTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(dictionaryTO, true);
		} else {
			TransactionTemplate.executeTransaction(dictionaryTO, tManager);
		}
		logger.info("DAO	modify	end");
		return dictionaryVO;
	}

	public static int deleteByVO(DictionaryVO dictionaryVO) throws Exception{
		logger.info("DAO	deleteByVO	begin");
		DictionaryTO dictionaryTO = new DictionaryTO(
				DictionaryTO.DEL_DICTIONARY_BYVO, dictionaryVO);

		dictionaryTO.setSqlStr();
		logger.info("sqlStr	:	" + dictionaryTO.getSqlStr());
		TransactionTemplate.executeTransaction(dictionaryTO, true);
		logger.info("result	:	" + dictionaryTO.getexecuteResult());
		logger.info("DAO	deleteByVO	end");
		return dictionaryTO.getexecuteResult();
	}
	
}
