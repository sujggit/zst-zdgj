package com.zzst.dao.meeting.dataInterface.user;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.dataInterface.role.RoleInterfaceMQB;
import com.zzst.dao.meeting.dataInterface.role.RoleInterfaceTO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;

/**
 * class description: UserInterface DAO
 * 
 * @date Tue Jun 18 18:58:24 CST 2013
 * @author ryan
 */
public class UserInterfaceDAO {
	private static Logger logger = CjfLogger.getLogger(UserInterfaceDAO.class
			.getName());

	private static final String id = "Userid";

	/**
	 * add UserInterfaceVO object
	 * 
	 * @param UserInterfaceVO
	 * @param TransactionManager
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public static UserInterfaceVO add(UserInterfaceVO userInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		
		UserInterfaceTO userInterfaceTO = new UserInterfaceTO(
				UserInterfaceTO.ADD_USERINTERFACE, userInterfaceVO);

		userInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + userInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(userInterfaceTO, tManager);
		}
		logger.info("DAO	add	end");
		return userInterfaceVO;
	}
	
	public static UserInterfaceVO addByCreateId(UserInterfaceVO userInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//userInterfaceVO.setUserid(UtilDAO.getUUid());
		UserInterfaceTO userInterfaceTO = new UserInterfaceTO(
				UserInterfaceTO.ADD_USERINTERFACE, userInterfaceVO);

		userInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + userInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(userInterfaceTO, tManager);
		}
		logger.info("DAO	add	end");
		return userInterfaceVO;
	}

	/**
	 * query UserInterfaceVO list
	 * 
	 * @param UserInterfaceVO
	 * @param PageController
	 * @return ArrayList<UserInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<UserInterfaceVO> query(
			UserInterfaceVO userInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		UserInterfaceMQB userInterfaceMQB = new UserInterfaceMQB(
				UserInterfaceMQB.QUERY_FROM_USERINTERFACE, userInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + userInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(userInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ userInterfaceMQB.getUserInterfaceList().size());
		logger.info("DAO	query	end");
		return userInterfaceMQB.getUserInterfaceList();
	}

	/**
	 * query UserInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<UserInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<UserInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		UserInterfaceMQB userInterfaceMQB = new UserInterfaceMQB(
				UserInterfaceMQB.QUERY_FROM_USERINTERFACE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + userInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(userInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ userInterfaceMQB.getUserInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return userInterfaceMQB.getUserInterfaceList();
	}

	/**
	 * modify UserInterfaceVO column by ID
	 * 
	 * @param UserInterfaceVO
	 * @param TransactionManager
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public static UserInterfaceVO modify(UserInterfaceVO userInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		UserInterfaceTO userInterfaceTO = new UserInterfaceTO(
				UserInterfaceTO.MODIFY_USERINTERFACE, userInterfaceVO);
		userInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + userInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(userInterfaceTO, tManager);
		}
		logger.info("DAO	modify	end");
		return userInterfaceVO;
	}

	/**
	 * delete UserInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		UserInterfaceVO userInterfaceVO = new UserInterfaceVO();
		userInterfaceVO.setUserid(ids);
		UserInterfaceTO userInterfaceTO = new UserInterfaceTO(
				UserInterfaceTO.DEL_USERINTERFACE, userInterfaceVO);

		userInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + userInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(userInterfaceTO, tManager);
		}
		logger.info("result	:	" + userInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return userInterfaceTO.getexecuteResult();
	}
	
	public static ArrayList<UserInterfaceVO> queryAvailable(
			UserInterfaceVO userInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("DAO	queryAvailable	begin");
		UserInterfaceMQB userInterfaceMQB = new UserInterfaceMQB(
				UserInterfaceMQB.QUERY_FROM_USERINTERFACE_AVAILABLE, userInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + userInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(userInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ userInterfaceMQB.getUserInterfaceList().size());
		logger.info("DAO	queryAvailable	end");
		return userInterfaceMQB.getUserInterfaceList();
	}
	
	
	public static int deleteAll(TransactionManager tManager)throws Exception {
		logger.info("DAO	deleteAll	begin");
		UserInterfaceVO userInterfaceVO = new UserInterfaceVO();
		UserInterfaceTO userInterfaceTO = new UserInterfaceTO(
				UserInterfaceTO.DEL_ALL, userInterfaceVO);
		
		userInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + userInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(userInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(userInterfaceTO, tManager);
		}
		logger.info("result	:	" + userInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return userInterfaceTO.getexecuteResult();
}
}
