package com.zzst.dao.meeting.configTcip;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;

import org.apache.log4j.Logger;

/**
 * class description: ConfigTcip DAO
 * 
 * @date Mon Nov 11 14:59:54 CST 2013
 * @author ryan
 */
public class ConfigTcipDAO {
	private static Logger logger = CjfLogger.getLogger(ConfigTcipDAO.class
			.getName());

	private static final String id = "Id";

	/**
	 * add ConfigTcipVO object
	 * 
	 * @param ConfigTcipVO
	 * @param TransactionManager
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public static ConfigTcipVO add(ConfigTcipVO configTcipVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
//		configTcipVO.setId(1);
		ConfigTcipTO configTcipTO = new ConfigTcipTO(
				ConfigTcipTO.ADD_CONFIGTCIP, configTcipVO);

		configTcipTO.setSqlStr();
		logger.info("sqlStr	:	" + configTcipTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(configTcipTO, true);
		} else {
			TransactionTemplate.executeTransaction(configTcipTO, tManager);
		}
		logger.info("DAO	add	end");
		return configTcipVO;
	}

	/**
	 * query ConfigTcipVO list
	 * 
	 * @param ConfigTcipVO
	 * @param PageController
	 * @return ArrayList<ConfigTcipVO>
	 * @throws Exception
	 */
	public static ArrayList<ConfigTcipVO> query(ConfigTcipVO configTcipVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		ConfigTcipMQB configTcipMQB = new ConfigTcipMQB(
				ConfigTcipMQB.QUERY_FROM_CONFIGTCIP, configTcipVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + configTcipMQB.getSql());
		QueryTemplate.executeQueryForList(configTcipMQB, pageController);
		logger.info("list size	:	" + configTcipMQB.getConfigTcipList().size());
		logger.info("DAO	query	end");
		return configTcipMQB.getConfigTcipList();
	}

	/**
	 * query ConfigTcipVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<ConfigTcipVO>
	 * @throws Exception
	 */
	public static ArrayList<ConfigTcipVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		ConfigTcipMQB configTcipMQB = new ConfigTcipMQB(
				ConfigTcipMQB.QUERY_FROM_CONFIGTCIP_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + configTcipMQB.getSql());
		QueryTemplate.executeQueryForList(configTcipMQB, pageController);
		logger.info("list size	:	" + configTcipMQB.getConfigTcipList().size());
		logger.info("DAO	queryByIDs	end");
		return configTcipMQB.getConfigTcipList();
	}

	/**
	 * modify ConfigTcipVO column by ID
	 * 
	 * @param ConfigTcipVO
	 * @param TransactionManager
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public static ConfigTcipVO modify(ConfigTcipVO configTcipVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		ConfigTcipTO configTcipTO = new ConfigTcipTO(
				ConfigTcipTO.MODIFY_CONFIGTCIP, configTcipVO);
		configTcipTO.setSqlStr();
		logger.info("sqlStr	:	" + configTcipTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(configTcipTO, true);
		} else {
			TransactionTemplate.executeTransaction(configTcipTO, tManager);
		}
		logger.info("DAO	modify	end");
		return configTcipVO;
	}

	/**
	 * delete ConfigTcipVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return ConfigTcipVO
	 * @throws Exception
	 */
	public static int deleteByID(int id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		ConfigTcipVO configTcipVO = new ConfigTcipVO();
		configTcipVO.setId(id);
		ConfigTcipTO configTcipTO = new ConfigTcipTO(
				ConfigTcipTO.DEL_CONFIGTCIP, configTcipVO);

		configTcipTO.setSqlStr();
		logger.info("sqlStr	:	" + configTcipTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(configTcipTO, true);
		} else {
			TransactionTemplate.executeTransaction(configTcipTO, tManager);
		}
		logger.info("result	:	" + configTcipTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return configTcipTO.getexecuteResult();
	}
}
