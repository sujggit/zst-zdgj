package com.zzst.dao.meeting.authorization;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.authorization.AuthorizationVO;

/**
 * class description: Authorization DAO
 * 
 * @date Tue May 28 11:26:12 CST 2013
 * @author ryan
 */
public class AuthorizationDAO {
	private static Logger logger = CjfLogger.getLogger(AuthorizationDAO.class
			.getName());

	private static final String id = "Id";

	/**
	 * add AuthorizationVO object
	 * 
	 * @param AuthorizationVO
	 * @param TransactionManager
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public static AuthorizationVO add(AuthorizationVO authorizationVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		authorizationVO.setId(UtilDAO.getUUid());
		AuthorizationTO authorizationTO = new AuthorizationTO(
				AuthorizationTO.ADD_AUTHORIZATION, authorizationVO);

		authorizationTO.setSqlStr();
		logger.info("sqlStr	:	" + authorizationTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(authorizationTO, true);
		} else {
			TransactionTemplate.executeTransaction(authorizationTO, tManager);
		}
		logger.info("DAO	add	end");
		return authorizationVO;
	}

	/**
	 * query AuthorizationVO list
	 * 
	 * @param AuthorizationVO
	 * @param PageController
	 * @return ArrayList<AuthorizationVO>
	 * @throws Exception
	 */
	public static ArrayList<AuthorizationVO> query(
			AuthorizationVO authorizationVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		AuthorizationMQB authorizationMQB = new AuthorizationMQB(
				AuthorizationMQB.QUERY_FROM_AUTHORIZATION, authorizationVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + authorizationMQB.getSql());
		QueryTemplate.executeQueryForList(authorizationMQB, pageController);
		logger.info("list size	:	"
				+ authorizationMQB.getAuthorizationList().size());
		logger.info("DAO	query	end");
		return authorizationMQB.getAuthorizationList();
	}

	/**
	 * query AuthorizationVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<AuthorizationVO>
	 * @throws Exception
	 */
	public static ArrayList<AuthorizationVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		AuthorizationMQB authorizationMQB = new AuthorizationMQB(
				AuthorizationMQB.QUERY_FROM_AUTHORIZATION_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + authorizationMQB.getSql());
		QueryTemplate.executeQueryForList(authorizationMQB, pageController);
		logger.info("list size	:	"
				+ authorizationMQB.getAuthorizationList().size());
		logger.info("DAO	queryByIDs	end");
		return authorizationMQB.getAuthorizationList();
	}

	/**
	 * modify AuthorizationVO column by ID
	 * 
	 * @param AuthorizationVO
	 * @param TransactionManager
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public static AuthorizationVO modify(AuthorizationVO authorizationVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		AuthorizationTO authorizationTO = new AuthorizationTO(
				AuthorizationTO.MODIFY_AUTHORIZATION, authorizationVO);
		authorizationTO.setSqlStr();
		logger.info("sqlStr	:	" + authorizationTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(authorizationTO, true);
		} else {
			TransactionTemplate.executeTransaction(authorizationTO, tManager);
		}
		logger.info("DAO	modify	end");
		return authorizationVO;
	}

	/**
	 * delete AuthorizationVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return AuthorizationVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		AuthorizationVO authorizationVO = new AuthorizationVO();
		authorizationVO.setId(id);
		AuthorizationTO authorizationTO = new AuthorizationTO(
				AuthorizationTO.DEL_AUTHORIZATION, authorizationVO);

		authorizationTO.setSqlStr();
		logger.info("sqlStr	:	" + authorizationTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(authorizationTO, true);
		} else {
			TransactionTemplate.executeTransaction(authorizationTO, tManager);
		}
		logger.info("result	:	" + authorizationTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return authorizationTO.getexecuteResult();
	}
}
