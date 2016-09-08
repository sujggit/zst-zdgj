package com.zzst.dao.meeting.interfaceInDepartment;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.cjf.util.CjfSequenceUtil;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.interfaceInDepartment.InterfaceInDepartmentVO;

import org.apache.log4j.Logger;

/**
 * class description: InterfaceInDepartment DAO
 * 
 * @date Mon Jun 17 16:54:25 CST 2013
 * @author ryan
 */
public class InterfaceInDepartmentDAO {
	private static Logger logger = CjfLogger
			.getLogger(InterfaceInDepartmentDAO.class.getName());

	private static final String id = "DepartmentId";

	/**
	 * add InterfaceInDepartmentVO object
	 * 
	 * @param InterfaceInDepartmentVO
	 * @param TransactionManager
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public static InterfaceInDepartmentVO add(
			InterfaceInDepartmentVO interfaceInDepartmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		interfaceInDepartmentVO.setDepartmentId(UtilDAO.getUUid());
		InterfaceInDepartmentTO interfaceInDepartmentTO = new InterfaceInDepartmentTO(
				InterfaceInDepartmentTO.ADD_INTERFACEINDEPARTMENT,
				interfaceInDepartmentVO);

		interfaceInDepartmentTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceInDepartmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return interfaceInDepartmentVO;
	}

	/**
	 * query InterfaceInDepartmentVO list
	 * 
	 * @param InterfaceInDepartmentVO
	 * @param PageController
	 * @return ArrayList<InterfaceInDepartmentVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceInDepartmentVO> query(
			InterfaceInDepartmentVO interfaceInDepartmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		InterfaceInDepartmentMQB interfaceInDepartmentMQB = new InterfaceInDepartmentMQB(
				InterfaceInDepartmentMQB.QUERY_FROM_INTERFACEINDEPARTMENT,
				interfaceInDepartmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceInDepartmentMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceInDepartmentMQB,
				pageController);
		logger.info("list size	:	"
				+ interfaceInDepartmentMQB.getInterfaceInDepartmentList()
						.size());
		logger.info("DAO	query	end");
		return interfaceInDepartmentMQB.getInterfaceInDepartmentList();
	}

	/**
	 * query InterfaceInDepartmentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<InterfaceInDepartmentVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceInDepartmentVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		InterfaceInDepartmentMQB interfaceInDepartmentMQB = new InterfaceInDepartmentMQB(
				InterfaceInDepartmentMQB.QUERY_FROM_INTERFACEINDEPARTMENT_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceInDepartmentMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceInDepartmentMQB,
				pageController);
		logger.info("list size	:	"
				+ interfaceInDepartmentMQB.getInterfaceInDepartmentList()
						.size());
		logger.info("DAO	queryByIDs	end");
		return interfaceInDepartmentMQB.getInterfaceInDepartmentList();
	}

	/**
	 * modify InterfaceInDepartmentVO column by ID
	 * 
	 * @param InterfaceInDepartmentVO
	 * @param TransactionManager
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public static InterfaceInDepartmentVO modify(
			InterfaceInDepartmentVO interfaceInDepartmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		InterfaceInDepartmentTO interfaceInDepartmentTO = new InterfaceInDepartmentTO(
				InterfaceInDepartmentTO.MODIFY_INTERFACEINDEPARTMENT,
				interfaceInDepartmentVO);
		interfaceInDepartmentTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceInDepartmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return interfaceInDepartmentVO;
	}

	/**
	 * delete InterfaceInDepartmentVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		InterfaceInDepartmentVO interfaceInDepartmentVO = new InterfaceInDepartmentVO();
		interfaceInDepartmentVO.setDepartmentId(id);
		InterfaceInDepartmentTO interfaceInDepartmentTO = new InterfaceInDepartmentTO(
				InterfaceInDepartmentTO.DEL_INTERFACEINDEPARTMENT,
				interfaceInDepartmentVO);

		interfaceInDepartmentTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceInDepartmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(interfaceInDepartmentTO,
					tManager);
		}
		logger.info("result	:	" + interfaceInDepartmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return interfaceInDepartmentTO.getexecuteResult();
	}
}
