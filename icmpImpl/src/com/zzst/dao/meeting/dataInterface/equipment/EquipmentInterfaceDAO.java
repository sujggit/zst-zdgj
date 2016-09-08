package com.zzst.dao.meeting.dataInterface.equipment;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.dataInterface.terminal.TerminalInterfaceMQB;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: EquipmentInterface DAO
 * 
 * @date Mon Jul 01 16:11:19 CST 2013
 * @author ryan
 */
public class EquipmentInterfaceDAO {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentInterfaceDAO.class.getName());

	private static final String id = "EquipmentID";

	/**
	 * add EquipmentInterfaceVO object
	 * 
	 * @param EquipmentInterfaceVO
	 * @param TransactionManager
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public static EquipmentInterfaceVO add(
			EquipmentInterfaceVO equipmentInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		equipmentInterfaceVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentInterfaceTO equipmentInterfaceTO = new EquipmentInterfaceTO(
				EquipmentInterfaceTO.ADD_EQUIPMENTINTERFACE,
				equipmentInterfaceVO);

		equipmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return equipmentInterfaceVO;
	}

	/**
	 * query EquipmentInterfaceVO list
	 * 
	 * @param EquipmentInterfaceVO
	 * @param PageController
	 * @return ArrayList<EquipmentInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentInterfaceVO> query(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		EquipmentInterfaceMQB equipmentInterfaceMQB = new EquipmentInterfaceMQB(
				EquipmentInterfaceMQB.QUERY_FROM_EQUIPMENTINTERFACE,
				equipmentInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentInterfaceMQB.getSql());
		QueryTemplate
				.executeQueryForList(equipmentInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ equipmentInterfaceMQB.getEquipmentInterfaceList().size());
		logger.info("DAO	query	end");
		return equipmentInterfaceMQB.getEquipmentInterfaceList();
	}

	/**
	 * query EquipmentInterfaceVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentInterfaceVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentInterfaceVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentInterfaceMQB equipmentInterfaceMQB = new EquipmentInterfaceMQB(
				EquipmentInterfaceMQB.QUERY_FROM_EQUIPMENTINTERFACE_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentInterfaceMQB.getSql());
		QueryTemplate
				.executeQueryForList(equipmentInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ equipmentInterfaceMQB.getEquipmentInterfaceList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentInterfaceMQB.getEquipmentInterfaceList();
	}

	/**
	 * modify EquipmentInterfaceVO column by ID
	 * 
	 * @param EquipmentInterfaceVO
	 * @param TransactionManager
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public static EquipmentInterfaceVO modify(
			EquipmentInterfaceVO equipmentInterfaceVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentInterfaceTO equipmentInterfaceTO = new EquipmentInterfaceTO(
				EquipmentInterfaceTO.MODIFY_EQUIPMENTINTERFACE,
				equipmentInterfaceVO);
		equipmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentInterfaceVO;
	}

	/**
	 * delete EquipmentInterfaceVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentInterfaceVO equipmentInterfaceVO = new EquipmentInterfaceVO();
		equipmentInterfaceVO.setEquipmentID(ids);
		EquipmentInterfaceTO equipmentInterfaceTO = new EquipmentInterfaceTO(
				EquipmentInterfaceTO.DEL_EQUIPMENTINTERFACE,
				equipmentInterfaceVO);

		equipmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentInterfaceTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentInterfaceTO,
					tManager);
		}
		logger.info("result	:	" + equipmentInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentInterfaceTO.getexecuteResult();
	}

	public static ArrayList<EquipmentInterfaceVO> queryAvailable(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryAvailable	begin");
		EquipmentInterfaceMQB equipmentInterfaceMQB = new EquipmentInterfaceMQB(
				EquipmentInterfaceMQB.QUERY_FROM_EQUIPMENTINTERFACE_AVAILABLE,
				equipmentInterfaceVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentInterfaceMQB.getSql());
		QueryTemplate
				.executeQueryForList(equipmentInterfaceMQB, pageController);
		logger.info("list size	:	"
				+ equipmentInterfaceMQB.getEquipmentInterfaceList().size());
		logger.info("DAO	queryAvailable	end");
		return equipmentInterfaceMQB.getEquipmentInterfaceList();
	}

	public static void deleteAll() throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentInterfaceTO equipmentInterfaceTO = new EquipmentInterfaceTO(EquipmentInterfaceTO.DEL_ALL);

		equipmentInterfaceTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentInterfaceTO.getSqlStr());
		TransactionTemplate.executeTransaction(equipmentInterfaceTO, true);
		logger.info("result	:	" + equipmentInterfaceTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
	}
}
