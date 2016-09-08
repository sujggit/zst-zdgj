package com.zzst.dao.meeting.dataInterface.role;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;

/**
 * class description: RoleInterface DAO
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public class RoleInterfaceDAO {
	private static Logger logger = CjfLogger.getLogger(RoleInterfaceDAO.class
			.getName());

	private static final String id = "Roleid";

	/**
	 * add RoleInterfaceVO object
	 * 
	 * @param RoleInterfaceVO
	 * @param TransactionManager
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public static RoleInterfaceVO add(RoleInterfaceVO roleInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		roleInterfaceVO.setRoleid(UtilDAO.getUUid());
		RoleInterfaceTO roleInterfaceTO = new RoleInterfaceTO(
				RoleInterfaceTO.ADD_ROLEINTERFACE, roleInterfaceVO);

		roleInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + roleInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(roleInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(roleInterfaceTO, tManager);
		}
		logger.info("DAO	add	end");
		return roleInterfaceVO;
	}
	
	
	public static RoleInterfaceVO addByCreateId(RoleInterfaceVO roleInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		RoleInterfaceTO roleInterfaceTO = new RoleInterfaceTO(
				RoleInterfaceTO.ADD_ROLEINTERFACE, roleInterfaceVO);

		roleInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + roleInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(roleInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(roleInterfaceTO, tManager);
		}
		logger.info("DAO	add	end");
		return roleInterfaceVO;
	}

	/**
	 * query RoleInterfaceVO list
	 * 
	 * @param RoleInterfaceVO
	 * @param PageController
	 * @return ArrayList<RoleInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<RoleInterfaceVO> query(
			RoleInterfaceVO roleInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		RoleInterfaceMQB roleInterfaceMQB = new RoleInterfaceMQB(
				RoleInterfaceMQB.QUERY_FROM_ROLEINTERFACE, roleInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + roleInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(roleInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ roleInterfaceMQB.getRoleInterfaceList().size());
		logger.info("DAO	query	end");
		return roleInterfaceMQB.getRoleInterfaceList();
	}

	/**
	 * query RoleInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<RoleInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<RoleInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		RoleInterfaceMQB roleInterfaceMQB = new RoleInterfaceMQB(
				RoleInterfaceMQB.QUERY_FROM_ROLEINTERFACE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + roleInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(roleInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ roleInterfaceMQB.getRoleInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return roleInterfaceMQB.getRoleInterfaceList();
	}

	/**
	 * modify RoleInterfaceVO column by ID
	 * 
	 * @param RoleInterfaceVO
	 * @param TransactionManager
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public static RoleInterfaceVO modify(RoleInterfaceVO roleInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		RoleInterfaceTO roleInterfaceTO = new RoleInterfaceTO(
				RoleInterfaceTO.MODIFY_ROLEINTERFACE, roleInterfaceVO);
		roleInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + roleInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(roleInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(roleInterfaceTO, tManager);
		}
		logger.info("DAO	modify	end");
		return roleInterfaceVO;
	}

	/**
	 * delete RoleInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return RoleInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		RoleInterfaceVO roleInterfaceVO = new RoleInterfaceVO();
		roleInterfaceVO.setRoleid(ids);
		RoleInterfaceTO roleInterfaceTO = new RoleInterfaceTO(
				RoleInterfaceTO.DEL_ROLEINTERFACE, roleInterfaceVO);

		roleInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + roleInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(roleInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(roleInterfaceTO, tManager);
		}
		logger.info("result	:	" + roleInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return roleInterfaceTO.getexecuteResult();
	}
	
	public static ArrayList<RoleInterfaceVO> queryAvailable(
			RoleInterfaceVO roleInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("DAO	queryAvailable	begin");
		RoleInterfaceMQB roleInterfaceMQB = new RoleInterfaceMQB(
				RoleInterfaceMQB.QUERY_FROM_ROLEINTERFACE_AVAILABLE, roleInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + roleInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(roleInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ roleInterfaceMQB.getRoleInterfaceList().size());
		logger.info("DAO	queryAvailable	end");
		return roleInterfaceMQB.getRoleInterfaceList();
	}
	
	
	public static int deleteAll(TransactionManager tManager)throws Exception {
		logger.info("DAO	deleteAll	begin");
		RoleInterfaceVO roleInterfaceVO = new RoleInterfaceVO();
		RoleInterfaceTO roleInterfaceTO = new RoleInterfaceTO(
				RoleInterfaceTO.DEL_ALL, roleInterfaceVO);
		
		roleInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + roleInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(roleInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(roleInterfaceTO, tManager);
		}
		logger.info("result	:	" + roleInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteAll	end");
		return roleInterfaceTO.getexecuteResult();
}

	
}
