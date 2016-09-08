package com.zzst.dao.meeting.equipmentMCUPool;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.equipmentMCUPool.EquipmentMCUPoolVO;

/**
 * class description: EquipmentMCUPool DAO
 * 
 * @date Thu Jan 31 09:29:38 CST 2013
 * @author ryan
 */
public class EquipmentMCUPoolDAO {
	private static Logger logger = CjfLogger
			.getLogger(EquipmentMCUPoolDAO.class.getName());

	private static final String id = "EquipmentID";

	/**
	 * add EquipmentMCUPoolVO object
	 * 
	 * @param EquipmentMCUPoolVO
	 * @param TransactionManager
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public static EquipmentMCUPoolVO add(EquipmentMCUPoolVO equipmentMCUPoolVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		equipmentMCUPoolVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentMCUPoolTO equipmentMCUPoolTO = new EquipmentMCUPoolTO(
				EquipmentMCUPoolTO.ADD_EQUIPMENTMCUPOOL, equipmentMCUPoolVO);

		equipmentMCUPoolTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMCUPoolTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMCUPoolTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(equipmentMCUPoolTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentMCUPoolVO;
	}

	/**
	 * query EquipmentMCUPoolVO list
	 * 
	 * @param EquipmentMCUPoolVO
	 * @param PageController
	 * @return ArrayList<EquipmentMCUPoolVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMCUPoolVO> query(
			EquipmentMCUPoolVO equipmentMCUPoolVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		EquipmentMCUPoolMQB equipmentMCUPoolMQB = new EquipmentMCUPoolMQB(
				EquipmentMCUPoolMQB.QUERY_FROM_EQUIPMENTMCUPOOL,
				equipmentMCUPoolVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMCUPoolMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMCUPoolMQB, pageController);
		logger.info("list size	:	"
				+ equipmentMCUPoolMQB.getEquipmentMCUPoolList().size());
		logger.info("DAO	query	end");
		return equipmentMCUPoolMQB.getEquipmentMCUPoolList();
	}

	/**
	 * query EquipmentMCUPoolVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentMCUPoolVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentMCUPoolVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentMCUPoolMQB equipmentMCUPoolMQB = new EquipmentMCUPoolMQB(
				EquipmentMCUPoolMQB.QUERY_FROM_EQUIPMENTMCUPOOL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentMCUPoolMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentMCUPoolMQB, pageController);
		logger.info("list size	:	"
				+ equipmentMCUPoolMQB.getEquipmentMCUPoolList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentMCUPoolMQB.getEquipmentMCUPoolList();
	}

	/**
	 * modify EquipmentMCUPoolVO column by ID
	 * 
	 * @param EquipmentMCUPoolVO
	 * @param TransactionManager
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public static EquipmentMCUPoolVO modify(
			EquipmentMCUPoolVO equipmentMCUPoolVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentMCUPoolTO equipmentMCUPoolTO = new EquipmentMCUPoolTO(
				EquipmentMCUPoolTO.MODIFY_EQUIPMENTMCUPOOL, equipmentMCUPoolVO);
		equipmentMCUPoolTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMCUPoolTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMCUPoolTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(equipmentMCUPoolTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentMCUPoolVO;
	}

	/**
	 * delete EquipmentMCUPoolVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentMCUPoolVO equipmentMCUPoolVO = new EquipmentMCUPoolVO();
		equipmentMCUPoolVO.setEquipmentID(ids);
		EquipmentMCUPoolTO equipmentMCUPoolTO = new EquipmentMCUPoolTO(
				EquipmentMCUPoolTO.DEL_EQUIPMENTMCUPOOL, equipmentMCUPoolVO);

		equipmentMCUPoolTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentMCUPoolTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentMCUPoolTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(equipmentMCUPoolTO, tManager);
		}
		logger.info("result	:	" + equipmentMCUPoolTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentMCUPoolTO.getexecuteResult();
	}
}
