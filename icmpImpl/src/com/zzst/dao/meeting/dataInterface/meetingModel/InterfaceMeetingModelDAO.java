package com.zzst.dao.meeting.dataInterface.meetingModel;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.dataInterface.meetingModel.InterfaceMeetingModelVO;

/**
 * class description: InterfaceMeetingModel DAO
 * 
 * @date Thu May 30 11:17:02 CST 2013
 * @author ryan
 */
public class InterfaceMeetingModelDAO {
	private static Logger logger = CjfLogger.getLogger(InterfaceMeetingModelDAO.class.getName());


	/**
	 * add InterfaceMeetingModelVO object
	 * 
	 * @param InterfaceMeetingModelVO
	 * @param TransactionManager
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public static InterfaceMeetingModelVO add(InterfaceMeetingModelVO interfaceMeetingModelVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		interfaceMeetingModelVO.setModelID(UtilDAO.getUUid());
		InterfaceMeetingModelTO interfaceMeetingModelTO = new InterfaceMeetingModelTO(
				InterfaceMeetingModelTO.ADD_INTERFACEMEETINGMODEL, interfaceMeetingModelVO);

		interfaceMeetingModelTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, tManager);
		}
		logger.info("DAO	add	end");
		return interfaceMeetingModelVO;
	}

	/**
	 * query InterfaceMeetingModelVO list
	 * 
	 * @param InterfaceMeetingModelVO
	 * @param PageController
	 * @return ArrayList<InterfaceMeetingModelVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceMeetingModelVO> query(InterfaceMeetingModelVO interfaceMeetingModelVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		InterfaceMeetingModelMQB interfaceMeetingModelMQB = new InterfaceMeetingModelMQB(
				InterfaceMeetingModelMQB.QUERY_FROM_INTERFACEMEETINGMODEL, interfaceMeetingModelVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceMeetingModelMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceMeetingModelMQB, pageController);
		logger.info("list size	:	" + interfaceMeetingModelMQB.getInterfaceMeetingModelList().size());
		logger.info("DAO	query	end");
		return interfaceMeetingModelMQB.getInterfaceMeetingModelList();
	}

	/**
	 * query InterfaceMeetingModelVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<InterfaceMeetingModelVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceMeetingModelVO> queryByIDs(String ids, PageController pageController)
			throws Exception {
		logger.info("DAO	queryByIDs	begin");
		InterfaceMeetingModelMQB interfaceMeetingModelMQB = new InterfaceMeetingModelMQB(
				InterfaceMeetingModelMQB.QUERY_FROM_INTERFACEMEETINGMODEL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceMeetingModelMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceMeetingModelMQB, pageController);
		logger.info("list size	:	" + interfaceMeetingModelMQB.getInterfaceMeetingModelList().size());
		logger.info("DAO	queryByIDs	end");
		return interfaceMeetingModelMQB.getInterfaceMeetingModelList();
	}

	/**
	 * modify InterfaceMeetingModelVO column by ID
	 * 
	 * @param InterfaceMeetingModelVO
	 * @param TransactionManager
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public static InterfaceMeetingModelVO modify(InterfaceMeetingModelVO interfaceMeetingModelVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		InterfaceMeetingModelTO interfaceMeetingModelTO = new InterfaceMeetingModelTO(
				InterfaceMeetingModelTO.MODIFY_INTERFACEMEETINGMODEL, interfaceMeetingModelVO);
		interfaceMeetingModelTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, tManager);
		}
		logger.info("DAO	modify	end");
		return interfaceMeetingModelVO;
	}

	/**
	 * delete InterfaceMeetingModelVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return InterfaceMeetingModelVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		InterfaceMeetingModelVO interfaceMeetingModelVO = new InterfaceMeetingModelVO();
		interfaceMeetingModelVO.setModelID(id);
		InterfaceMeetingModelTO interfaceMeetingModelTO = new InterfaceMeetingModelTO(
				InterfaceMeetingModelTO.DEL_INTERFACEMEETINGMODEL, interfaceMeetingModelVO);

		interfaceMeetingModelTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingModelTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingModelTO, tManager);
		}
		logger.info("result	:	" + interfaceMeetingModelTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return interfaceMeetingModelTO.getexecuteResult();
	}
}
