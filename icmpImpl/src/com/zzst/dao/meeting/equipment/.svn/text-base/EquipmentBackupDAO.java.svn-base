package com.zzst.dao.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;

/**
 * class description: EquipmentBackup DAO
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author ryan
 */
public class EquipmentBackupDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentBackupDAO.class
			.getName());

	private static final String id = "EquipmentID";

	/**
	 * add EquipmentBackupVO object
	 * 
	 * @param EquipmentBackupVO
	 * @param TransactionManager
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public static EquipmentBackupVO add(EquipmentBackupVO equipmentBackupVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//equipmentBackupVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentBackupTO equipmentBackupTO = new EquipmentBackupTO(
				EquipmentBackupTO.ADD_EQUIPMENTBACKUP, equipmentBackupVO);

		equipmentBackupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentBackupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentBackupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentBackupTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentBackupVO;
	}

	/**
	 * query EquipmentBackupVO list
	 * 
	 * @param EquipmentBackupVO
	 * @param PageController
	 * @return ArrayList<EquipmentBackupVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentBackupVO> query(
			EquipmentBackupVO equipmentBackupVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		EquipmentBackupMQB equipmentBackupMQB = new EquipmentBackupMQB(
				EquipmentBackupMQB.QUERY_FROM_EQUIPMENTBACKUP,
				equipmentBackupVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentBackupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentBackupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentBackupMQB.getEquipmentBackupList().size());
		logger.info("DAO	query	end");
		return equipmentBackupMQB.getEquipmentBackupList();
	}

/**
 * 
 * @author zhangjy 
 * @param equipmentBackupVO
 * @param pageController
 * @return
 * @throws Exception
 */
	
	public static ArrayList<EquipmentBackupVO> queryByMeetingID(String meetid)
			throws Exception {
		logger.info("DAO	queryBymeetingID	begin");
		EquipmentBackupMQB equipmentBackupMQB = new EquipmentBackupMQB(EquipmentBackupMQB.QUERY_MEETID,meetid);
		logger.info("sqlStr:" + equipmentBackupMQB.getSql());
		
			PageController pageController = new PageController();
			pageController.setAll(true);
		QueryTemplate.executeQueryForList(equipmentBackupMQB, pageController);
		logger.info("list size	:	"+ equipmentBackupMQB.getEquipmentBackupList().size());
		logger.info("DAO	queryBymeetingID	end");
		return equipmentBackupMQB.getEquipmentBackupList();
	}

	
	/**
	 * query EquipmentBackupVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentBackupVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentBackupVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentBackupMQB equipmentBackupMQB = new EquipmentBackupMQB(
				EquipmentBackupMQB.QUERY_FROM_EQUIPMENTBACKUP_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentBackupMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentBackupMQB, pageController);
		logger.info("list size	:	"
				+ equipmentBackupMQB.getEquipmentBackupList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentBackupMQB.getEquipmentBackupList();
	}

	/**
	 * modify EquipmentBackupVO column by ID
	 * 
	 * @param EquipmentBackupVO
	 * @param TransactionManager
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public static EquipmentBackupVO modify(EquipmentBackupVO equipmentBackupVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentBackupTO equipmentBackupTO = new EquipmentBackupTO(
				EquipmentBackupTO.MODIFY_EQUIPMENTBACKUP, equipmentBackupVO);
		equipmentBackupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentBackupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentBackupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentBackupTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentBackupVO;
	}

	/**
	 * delete EquipmentBackupVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, String backupId, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentBackupVO equipmentBackupVO = new EquipmentBackupVO();
		equipmentBackupVO.setEquipmentID(ids);
		equipmentBackupVO.setBackupEquipmentID(backupId);
		EquipmentBackupTO equipmentBackupTO = new EquipmentBackupTO(
				EquipmentBackupTO.DEL_EQUIPMENTBACKUP, equipmentBackupVO);

		equipmentBackupTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentBackupTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentBackupTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentBackupTO, tManager);
		}
		logger.info("result	:	" + equipmentBackupTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentBackupTO.getexecuteResult();
	}
}
