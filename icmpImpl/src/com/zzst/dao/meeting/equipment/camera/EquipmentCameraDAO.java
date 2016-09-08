package com.zzst.dao.meeting.equipment.camera;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;

import org.apache.log4j.Logger;

/**
 * class description: EquipmentCamera DAO
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public class EquipmentCameraDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentCameraDAO.class
			.getName());

	private static final String id = "TemplateID";

	/**
	 * add EquipmentCameraVO object
	 * 
	 * @param EquipmentCameraVO
	 * @param TransactionManager
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public static EquipmentCameraVO add(EquipmentCameraVO equipmentCameraVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//equipmentCameraVO.setTemplateID(UtilDAO.getUUid());
		EquipmentCameraTO equipmentCameraTO = new EquipmentCameraTO(
				EquipmentCameraTO.ADD_EQUIPMENTCAMERA, equipmentCameraVO);

		equipmentCameraTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentCameraTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentCameraTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentCameraTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentCameraVO;
	}

	/**
	 * query EquipmentCameraVO list
	 * 
	 * @param EquipmentCameraVO
	 * @param PageController
	 * @return ArrayList<EquipmentCameraVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentCameraVO> query(
			EquipmentCameraVO equipmentCameraVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		EquipmentCameraMQB equipmentCameraMQB = new EquipmentCameraMQB(
				EquipmentCameraMQB.QUERY_FROM_EQUIPMENTCAMERA,
				equipmentCameraVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentCameraMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentCameraMQB, pageController);
		logger.info("list size	:	"
				+ equipmentCameraMQB.getEquipmentCameraList().size());
		logger.info("DAO	query	end");
		return equipmentCameraMQB.getEquipmentCameraList();
	}

	/**
	 * query EquipmentCameraVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentCameraVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentCameraVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentCameraMQB equipmentCameraMQB = new EquipmentCameraMQB(
				EquipmentCameraMQB.QUERY_FROM_EQUIPMENTCAMERA_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentCameraMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentCameraMQB, pageController);
		logger.info("list size	:	"
				+ equipmentCameraMQB.getEquipmentCameraList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentCameraMQB.getEquipmentCameraList();
	}

	/**
	 * modify EquipmentCameraVO column by ID
	 * 
	 * @param EquipmentCameraVO
	 * @param TransactionManager
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public static EquipmentCameraVO modify(EquipmentCameraVO equipmentCameraVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentCameraTO equipmentCameraTO = new EquipmentCameraTO(
				EquipmentCameraTO.MODIFY_EQUIPMENTCAMERA, equipmentCameraVO);
		equipmentCameraTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentCameraTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentCameraTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentCameraTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentCameraVO;
	}

	/**
	 * delete EquipmentCameraVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentCameraVO equipmentCameraVO = new EquipmentCameraVO();
		equipmentCameraVO.setTemplateID(id);
		EquipmentCameraTO equipmentCameraTO = new EquipmentCameraTO(
				EquipmentCameraTO.DEL_EQUIPMENTCAMERA, equipmentCameraVO);

		equipmentCameraTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentCameraTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentCameraTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentCameraTO, tManager);
		}
		logger.info("result	:	" + equipmentCameraTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentCameraTO.getexecuteResult();
	}
}
