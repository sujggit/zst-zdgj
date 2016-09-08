package com.zzst.dao.meeting.dataInterface.meetingDetail;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailVO;

/**
 * class description: InterfaceMeetingDetail DAO
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public class InterfaceMeetingDetailDAO {
	private static Logger logger = CjfLogger.getLogger(InterfaceMeetingDetailDAO.class.getName());


	/**
	 * add InterfaceMeetingDetailVO object
	 * 
	 * @param InterfaceMeetingDetailVO
	 * @param TransactionManager
	 * @return InterfaceMeetingDetailVO
	 * @throws Exception
	 */
	public static InterfaceMeetingDetailVO add(InterfaceMeetingDetailVO interfaceMeetingDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		interfaceMeetingDetailVO.setId(UtilDAO.getUUid());
		InterfaceMeetingDetailTO interfaceMeetingDetailTO = new InterfaceMeetingDetailTO(
				InterfaceMeetingDetailTO.ADD_INTERFACEMEETINGDETAIL, interfaceMeetingDetailVO);

		interfaceMeetingDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, tManager);
		}
		logger.info("DAO	add	end");
		return interfaceMeetingDetailVO;
	}

	/**
	 * query InterfaceMeetingDetailVO list
	 * 
	 * @param InterfaceMeetingDetailVO
	 * @param PageController
	 * @return ArrayList<InterfaceMeetingDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceMeetingDetailVO> query(InterfaceMeetingDetailVO interfaceMeetingDetailVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		InterfaceMeetingDetailMQB interfaceMeetingDetailMQB = new InterfaceMeetingDetailMQB(
				InterfaceMeetingDetailMQB.QUERY_FROM_INTERFACEMEETINGDETAIL, interfaceMeetingDetailVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceMeetingDetailMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceMeetingDetailMQB, pageController);
		logger.info("list size	:	" + interfaceMeetingDetailMQB.getInterfaceMeetingDetailList().size());
		logger.info("DAO	query	end");
		return interfaceMeetingDetailMQB.getInterfaceMeetingDetailList();
	}

	/**
	 * query InterfaceMeetingDetailVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<InterfaceMeetingDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<InterfaceMeetingDetailVO> queryByIDs(String ids, PageController pageController)
			throws Exception {
		logger.info("DAO	queryByIDs	begin");
		InterfaceMeetingDetailMQB interfaceMeetingDetailMQB = new InterfaceMeetingDetailMQB(
				InterfaceMeetingDetailMQB.QUERY_FROM_INTERFACEMEETINGDETAIL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + interfaceMeetingDetailMQB.getSql());
		QueryTemplate.executeQueryForList(interfaceMeetingDetailMQB, pageController);
		logger.info("list size	:	" + interfaceMeetingDetailMQB.getInterfaceMeetingDetailList().size());
		logger.info("DAO	queryByIDs	end");
		return interfaceMeetingDetailMQB.getInterfaceMeetingDetailList();
	}

	/**
	 * modify InterfaceMeetingDetailVO column by ID
	 * 
	 * @param InterfaceMeetingDetailVO
	 * @param TransactionManager
	 * @return InterfaceMeetingDetailVO
	 * @throws Exception
	 */
	public static InterfaceMeetingDetailVO modify(InterfaceMeetingDetailVO interfaceMeetingDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		InterfaceMeetingDetailTO interfaceMeetingDetailTO = new InterfaceMeetingDetailTO(
				InterfaceMeetingDetailTO.MODIFY_INTERFACEMEETINGDETAIL, interfaceMeetingDetailVO);
		interfaceMeetingDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, tManager);
		}
		logger.info("DAO	modify	end");
		return interfaceMeetingDetailVO;
	}

	/**
	 * delete InterfaceMeetingDetailVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return InterfaceMeetingDetailVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		InterfaceMeetingDetailVO interfaceMeetingDetailVO = new InterfaceMeetingDetailVO();
		interfaceMeetingDetailVO.setId(id);
		InterfaceMeetingDetailTO interfaceMeetingDetailTO = new InterfaceMeetingDetailTO(
				InterfaceMeetingDetailTO.DEL_INTERFACEMEETINGDETAIL, interfaceMeetingDetailVO);

		interfaceMeetingDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + interfaceMeetingDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(interfaceMeetingDetailTO, tManager);
		}
		logger.info("result	:	" + interfaceMeetingDetailTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return interfaceMeetingDetailTO.getexecuteResult();
	}
}
