package com.zzst.dao.meeting.equipment.maintain;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;

/**
 * class description: EquipmentMaintain DAO
 * 
 * @date Mon May 06 13:27:29 CST 2013
 * @author ryan
 */
public class EquipmentMaintainDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentMaintainDAO.class.getName());

	private static final String id = "MaintainID";

	/**
	 * add EquipmentMaintainVO object
	 * 
	 * @param EquipmentMaintainVO
	 * @param TransactionManager
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public static EquipmentMaintainVO add(EquipmentMaintainVO equipmentMaintainVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		equipmentMaintainVO.setMaintainID(UtilDAO.getUUid());
		EquipmentMaintainTO equipmentMaintainTO = new EquipmentMaintainTO(EquipmentMaintainTO.ADD_EQUIPMENTMAINTAIN,
				equipmentMaintainVO);

		equipmentMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentMaintainVO;
	}

	/**
	 * query EquipmentMaintainVO list
	 * 
	 * @param EquipmentMaintainVO
	 * @param PageController
	 * @return ArrayList<EquipmentMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMaintainVO> query(EquipmentMaintainVO equipmentMaintainVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		EquipmentMaintainMQB equipmentMaintainMQB = new EquipmentMaintainMQB(
				EquipmentMaintainMQB.QUERY_FROM_EQUIPMENTMAINTAIN, equipmentMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMaintainMQB, pageController);
		logger.info("list size	:	" + equipmentMaintainMQB.getEquipmentMaintainList().size());
		logger.info("DAO	query	end");
		return equipmentMaintainMQB.getEquipmentMaintainList();
	}
	
	public static ArrayList<EquipmentMaintainVO> queryWhereSQLS(EquipmentMaintainVO equipmentMaintainVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		EquipmentMaintainMQB equipmentMaintainMQB = new EquipmentMaintainMQB(
				EquipmentMaintainMQB.QUERY_FROM_EQUIPMENTMAINTAIN_BY_SQLS, equipmentMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMaintainMQB, pageController);
		logger.info("list size	:	" + equipmentMaintainMQB.getEquipmentMaintainList().size());
		logger.info("DAO	query	end");
		return equipmentMaintainMQB.getEquipmentMaintainList();
	}

	/**
	 * query EquipmentMaintainVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMaintainVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMaintainMQB equipmentMaintainMQB = new EquipmentMaintainMQB(
				EquipmentMaintainMQB.QUERY_FROM_EQUIPMENTMAINTAIN_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMaintainMQB, pageController);
		logger.info("list size	:	" + equipmentMaintainMQB.getEquipmentMaintainList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMaintainMQB.getEquipmentMaintainList();
	}

	/**
	 * modify EquipmentMaintainVO column by ID
	 * 
	 * @param EquipmentMaintainVO
	 * @param TransactionManager
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public static EquipmentMaintainVO modify(EquipmentMaintainVO equipmentMaintainVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentMaintainTO equipmentMaintainTO = new EquipmentMaintainTO(EquipmentMaintainTO.MODIFY_EQUIPMENTMAINTAIN,
				equipmentMaintainVO);
		equipmentMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentMaintainVO;
	}

	/**
	 * delete EquipmentMaintainVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentMaintainVO equipmentMaintainVO = new EquipmentMaintainVO();
		equipmentMaintainVO.setMaintainID(id);
		EquipmentMaintainTO equipmentMaintainTO = new EquipmentMaintainTO(EquipmentMaintainTO.DEL_EQUIPMENTMAINTAIN,
				equipmentMaintainVO);

		equipmentMaintainTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMaintainTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentMaintainTO, tManager);
		}
		logger.info("result	:	" + equipmentMaintainTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentMaintainTO.getexecuteResult();
	}
	
	
	
	
	/**
	 * query EquipmentMaintainVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMaintainVO> queryAll(EquipmentMaintainVO equipmentMaintainVO,PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMaintainMQB equipmentMaintainMQB = new EquipmentMaintainMQB(
				EquipmentMaintainMQB.QUERY_FROM_EQUIPMENTMAINTAIN_ALL,equipmentMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMaintainMQB, pageController);
		logger.info("list size	:	" + equipmentMaintainMQB.getEquipmentMaintainList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMaintainMQB.getEquipmentMaintainList();
	}
	
	
	
	/**
	 * query EquipmentMaintainVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentMaintainVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMaintainVO> queryDetail(EquipmentMaintainVO equipmentMaintainVO,PageController pageController) throws Exception {
		logger.info("DAO	queryDetail	begin");
		EquipmentMaintainMQB equipmentMaintainMQB = new EquipmentMaintainMQB(
				EquipmentMaintainMQB.QUERY_FROM_EQUIPMENTMAINTAIN_JOIN_EQUIPMENT,equipmentMaintainVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMaintainMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMaintainMQB, pageController);
		logger.info("list size	:	" + equipmentMaintainMQB.getEquipmentMaintainList().size());
		logger.info("DAO	queryDetail	end");
		return equipmentMaintainMQB.getEquipmentMaintainList();
	}
	
}
