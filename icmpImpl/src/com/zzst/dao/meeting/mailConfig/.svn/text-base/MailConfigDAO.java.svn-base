package com.zzst.dao.meeting.mailConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.mailConfig.MailConfigVO;

import org.apache.log4j.Logger;

/**
 * class description: MailConfig DAO
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public class MailConfigDAO {
	private static Logger logger = CjfLogger.getLogger(MailConfigDAO.class
			.getName());

	private static final String id = "Id";

	/**
	 * add MailConfigVO object
	 * 
	 * @param MailConfigVO
	 * @param TransactionManager
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public static MailConfigVO add(MailConfigVO mailConfigVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		mailConfigVO.setId(1);
		MailConfigTO mailConfigTO = new MailConfigTO(
				MailConfigTO.ADD_MAILCONFIG, mailConfigVO);

		mailConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + mailConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mailConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(mailConfigTO, tManager);
		}
		logger.info("DAO	add	end");
		return mailConfigVO;
	}

	/**
	 * query MailConfigVO list
	 * 
	 * @param MailConfigVO
	 * @param PageController
	 * @return ArrayList<MailConfigVO>
	 * @throws Exception
	 */
	public static ArrayList<MailConfigVO> query(MailConfigVO mailConfigVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MailConfigMQB mailConfigMQB = new MailConfigMQB(
				MailConfigMQB.QUERY_FROM_MAILCONFIG, mailConfigVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + mailConfigMQB.getSql());
		QueryTemplate.executeQueryForList(mailConfigMQB, pageController);
		logger.info("list size	:	" + mailConfigMQB.getMailConfigList().size());
		logger.info("DAO	query	end");
		return mailConfigMQB.getMailConfigList();
	}

	/**
	 * query MailConfigVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MailConfigVO>
	 * @throws Exception
	 */
	public static ArrayList<MailConfigVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MailConfigMQB mailConfigMQB = new MailConfigMQB(
				MailConfigMQB.QUERY_FROM_MAILCONFIG_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + mailConfigMQB.getSql());
		QueryTemplate.executeQueryForList(mailConfigMQB, pageController);
		logger.info("list size	:	" + mailConfigMQB.getMailConfigList().size());
		logger.info("DAO	queryByIDs	end");
		return mailConfigMQB.getMailConfigList();
	}

	/**
	 * modify MailConfigVO column by ID
	 * 
	 * @param MailConfigVO
	 * @param TransactionManager
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public static MailConfigVO modify(MailConfigVO mailConfigVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MailConfigTO mailConfigTO = new MailConfigTO(
				MailConfigTO.MODIFY_MAILCONFIG, mailConfigVO);
		mailConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + mailConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mailConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(mailConfigTO, tManager);
		}
		logger.info("DAO	modify	end");
		return mailConfigVO;
	}

	/**
	 * delete MailConfigVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MailConfigVO
	 * @throws Exception
	 */
	public static int deleteByID(int id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MailConfigVO mailConfigVO = new MailConfigVO();
		mailConfigVO.setId(id);
		MailConfigTO mailConfigTO = new MailConfigTO(
				MailConfigTO.DEL_MAILCONFIG, mailConfigVO);

		mailConfigTO.setSqlStr();
		logger.info("sqlStr	:	" + mailConfigTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(mailConfigTO, true);
		} else {
			TransactionTemplate.executeTransaction(mailConfigTO, tManager);
		}
		logger.info("result	:	" + mailConfigTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return mailConfigTO.getexecuteResult();
	}
}
