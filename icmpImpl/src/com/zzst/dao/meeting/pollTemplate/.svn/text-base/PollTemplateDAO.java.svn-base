package com.zzst.dao.meeting.pollTemplate;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;

/**
 * class description: PollTemplate DAO
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTemplateDAO {
	private static Logger logger = CjfLogger.getLogger(PollTemplateDAO.class
			.getName());

	private static final String id = "PollTemplateID";

	/**
	 * add PollTemplateVO object
	 * 
	 * @param PollTemplateVO
	 * @param TransactionManager
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public static PollTemplateVO add(PollTemplateVO pollTemplateVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		pollTemplateVO.setPollTemplateID(UtilDAO.getUUid());
		PollTemplateTO pollTemplateTO = new PollTemplateTO(
				PollTemplateTO.ADD_POLLTEMPLATE, pollTemplateVO);

		pollTemplateTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTemplateTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTemplateTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTemplateTO, tManager);
		}
		logger.info("DAO	add	end");
		return pollTemplateVO;
	}

	/**
	 * query PollTemplateVO list
	 * 
	 * @param PollTemplateVO
	 * @param PageController
	 * @return ArrayList<PollTemplateVO>
	 * @throws Exception
	 */
	public static ArrayList<PollTemplateVO> query(
			PollTemplateVO pollTemplateVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		PollTemplateMQB pollTemplateMQB = new PollTemplateMQB(
				PollTemplateMQB.QUERY_FROM_POLLTEMPLATE, pollTemplateVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTemplateMQB.getSql());
		QueryTemplate.executeQueryForList(pollTemplateMQB, pageController);
		logger.info("list size	:	"
				+ pollTemplateMQB.getPollTemplateList().size());
		logger.info("DAO	query	end");
		return pollTemplateMQB.getPollTemplateList();
	}

	/**
	 * query PollTemplateVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<PollTemplateVO>
	 * @throws Exception
	 */
	public static ArrayList<PollTemplateVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		PollTemplateMQB pollTemplateMQB = new PollTemplateMQB(
				PollTemplateMQB.QUERY_FROM_POLLTEMPLATE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + pollTemplateMQB.getSql());
		QueryTemplate.executeQueryForList(pollTemplateMQB, pageController);
		logger.info("list size	:	"
				+ pollTemplateMQB.getPollTemplateList().size());
		logger.info("DAO	queryByIDs	end");
		return pollTemplateMQB.getPollTemplateList();
	}

	/**
	 * modify PollTemplateVO column by ID
	 * 
	 * @param PollTemplateVO
	 * @param TransactionManager
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public static PollTemplateVO modify(PollTemplateVO pollTemplateVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		PollTemplateTO pollTemplateTO = new PollTemplateTO(
				PollTemplateTO.MODIFY_POLLTEMPLATE, pollTemplateVO);
		pollTemplateTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTemplateTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTemplateTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTemplateTO, tManager);
		}
		logger.info("DAO	modify	end");
		return pollTemplateVO;
	}

	/**
	 * delete PollTemplateVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return PollTemplateVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		PollTemplateVO pollTemplateVO = new PollTemplateVO();
		pollTemplateVO.setPollTemplateID(ids);
		PollTemplateTO pollTemplateTO = new PollTemplateTO(
				PollTemplateTO.DEL_POLLTEMPLATE, pollTemplateVO);

		pollTemplateTO.setSqlStr();
		logger.info("sqlStr	:	" + pollTemplateTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(pollTemplateTO, true);
		} else {
			TransactionTemplate.executeTransaction(pollTemplateTO, tManager);
		}
		logger.info("result	:	" + pollTemplateTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return pollTemplateTO.getexecuteResult();
	}
}
