package com.zzst.dao.meeting.userPost;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.meeting.userPost.UserPostVO;

import org.apache.log4j.Logger;

/**
 * class description: UserPost DAO
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public class UserPostDAO {
	private static Logger logger = CjfLogger.getLogger(UserPostDAO.class
			.getName());

	private static final String id = "UserID";

	/**
	 * add UserPostVO object
	 * 
	 * @param UserPostVO
	 * @param TransactionManager
	 * @return UserPostVO
	 * @throws Exception
	 */
	public static UserPostVO add(UserPostVO userPostVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//userPostVO.setUserID(UtilDAO.getUUid());
		UserPostTO userPostTO = new UserPostTO(UserPostTO.ADD_USERPOST,
				userPostVO);

		userPostTO.setSqlStr();
		logger.info("sqlStr	:	" + userPostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userPostTO, true);
		} else {
			TransactionTemplate.executeTransaction(userPostTO, tManager);
		}
		logger.info("DAO	add	end");
		return userPostVO;
	}

	/**
	 * query UserPostVO list
	 * 
	 * @param UserPostVO
	 * @param PageController
	 * @return ArrayList<UserPostVO>
	 * @throws Exception
	 */
	public static ArrayList<UserPostVO> query(UserPostVO userPostVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		UserPostMQB userPostMQB = new UserPostMQB(
				UserPostMQB.QUERY_FROM_USERPOST, userPostVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + userPostMQB.getSql());
		QueryTemplate.executeQueryForList(userPostMQB, pageController);
		logger.info("list size	:	" + userPostMQB.getUserPostList().size());
		logger.info("DAO	query	end");
		return userPostMQB.getUserPostList();
	}

	/**
	 * query UserPostVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<UserPostVO>
	 * @throws Exception
	 */
	public static ArrayList<UserPostVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		UserPostMQB userPostMQB = new UserPostMQB(
				UserPostMQB.QUERY_FROM_USERPOST_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + userPostMQB.getSql());
		QueryTemplate.executeQueryForList(userPostMQB, pageController);
		logger.info("list size	:	" + userPostMQB.getUserPostList().size());
		logger.info("DAO	queryByIDs	end");
		return userPostMQB.getUserPostList();
	}

	/**
	 * modify UserPostVO column by ID
	 * 
	 * @param UserPostVO
	 * @param TransactionManager
	 * @return UserPostVO
	 * @throws Exception
	 */
	public static UserPostVO modify(UserPostVO userPostVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		UserPostTO userPostTO = new UserPostTO(UserPostTO.MODIFY_USERPOST,
				userPostVO);
		userPostTO.setSqlStr();
		logger.info("sqlStr	:	" + userPostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userPostTO, true);
		} else {
			TransactionTemplate.executeTransaction(userPostTO, tManager);
		}
		logger.info("DAO	modify	end");
		return userPostVO;
	}

	/**
	 * delete UserPostVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return UserPostVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		UserPostVO userPostVO = new UserPostVO();
		userPostVO.setUserID(id);
		UserPostTO userPostTO = new UserPostTO(UserPostTO.DEL_USERPOST,
				userPostVO);

		userPostTO.setSqlStr();
		logger.info("sqlStr	:	" + userPostTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userPostTO, true);
		} else {
			TransactionTemplate.executeTransaction(userPostTO, tManager);
		}
		logger.info("result	:	" + userPostTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return userPostTO.getexecuteResult();
	}
}
