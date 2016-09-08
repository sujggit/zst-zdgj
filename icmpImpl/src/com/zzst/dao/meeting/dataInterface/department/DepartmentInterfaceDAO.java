package com.zzst.dao.meeting.dataInterface.department;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceTO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: DepartmentInterface DAO
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public class DepartmentInterfaceDAO {
	private static Logger logger = CjfLogger
			.getLogger(DepartmentInterfaceDAO.class.getName());

	private static final String id = "Departmentid";

	/**
	 * add DepartmentInterfaceVO object
	 * 
	 * @param DepartmentInterfaceVO
	 * @param TransactionManager
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public static DepartmentInterfaceVO add(
			DepartmentInterfaceVO departmentInterfaceVO,boolean ifAutoId,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		if( ifAutoId ){
			departmentInterfaceVO.setDepartmentid(UtilDAO.getUUid());
		}
		
		DepartmentInterfaceTO departmentInterfaceTO = new DepartmentInterfaceTO(
				DepartmentInterfaceTO.ADD_DEPARTMENTINTERFACE,
				departmentInterfaceVO);

		departmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + departmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(departmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(departmentInterfaceTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return departmentInterfaceVO;
	}

	/**
	 * query DepartmentInterfaceVO list
	 * 
	 * @param DepartmentInterfaceVO
	 * @param PageController
	 * @return ArrayList<DepartmentInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<DepartmentInterfaceVO> query(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DepartmentInterfaceMQB departmentInterfaceMQB = new DepartmentInterfaceMQB(
				DepartmentInterfaceMQB.QUERY_FROM_DEPARTMENTINTERFACE,
				departmentInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + departmentInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(departmentInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ departmentInterfaceMQB.getDepartmentInterfaceList().size());
		logger.info("DAO	query	end");
		return departmentInterfaceMQB.getDepartmentInterfaceList();
	}

	/**
	 * query DepartmentInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<DepartmentInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<DepartmentInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		DepartmentInterfaceMQB departmentInterfaceMQB = new DepartmentInterfaceMQB(
				DepartmentInterfaceMQB.QUERY_FROM_DEPARTMENTINTERFACE_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + departmentInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(departmentInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ departmentInterfaceMQB.getDepartmentInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return departmentInterfaceMQB.getDepartmentInterfaceList();
	}

	/**
	 * modify DepartmentInterfaceVO column by ID
	 * 
	 * @param DepartmentInterfaceVO
	 * @param TransactionManager
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public static DepartmentInterfaceVO modify(
			DepartmentInterfaceVO departmentInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		DepartmentInterfaceTO departmentInterfaceTO = new DepartmentInterfaceTO(
				DepartmentInterfaceTO.MODIFY_DEPARTMENTINTERFACE,
				departmentInterfaceVO);
		departmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + departmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(departmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(departmentInterfaceTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return departmentInterfaceVO;
	}

	/**
	 * delete DepartmentInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		DepartmentInterfaceVO departmentInterfaceVO = new DepartmentInterfaceVO();
		departmentInterfaceVO.setDepartmentid(ids);
		DepartmentInterfaceTO departmentInterfaceTO = new DepartmentInterfaceTO(
				DepartmentInterfaceTO.DEL_DEPARTMENTINTERFACE,
				departmentInterfaceVO);

		departmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + departmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(departmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(departmentInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + departmentInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return departmentInterfaceTO.getexecuteResult();
	}
	
	public static int deleteAll( TransactionManager tManager ) throws Exception {
		logger.info("DAO	deleteByID	begin");
		DepartmentInterfaceVO departmentInterfaceVO = new DepartmentInterfaceVO();
		DepartmentInterfaceTO departmentInterfaceTO = new DepartmentInterfaceTO(
				DepartmentInterfaceTO.DEL_ALL,
				departmentInterfaceVO);

		departmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + departmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(departmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(departmentInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + departmentInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return departmentInterfaceTO.getexecuteResult();
	}
	
	
	public static ArrayList<DepartmentInterfaceVO> queryAvailable(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		DepartmentInterfaceMQB departmentInterfaceMQB = new DepartmentInterfaceMQB(
				DepartmentInterfaceMQB.QUERY_FROM_DEPARTMENTINTERFACE_AVAILABLE,
				departmentInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + departmentInterfaceMQB.getSql());
		QueryTemplate.executeQueryForList(departmentInterfaceMQB,
				pageController);
		logger.info("list size	:	"
				+ departmentInterfaceMQB.getDepartmentInterfaceList().size());
		logger.info("DAO	query	end");
		return departmentInterfaceMQB.getDepartmentInterfaceList();
	}
}
