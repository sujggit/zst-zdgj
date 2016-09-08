package com.zzst.dao.meeting.equipment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;

/**
 * class description: EquipmentTerminal DAO
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentTerminalDAO {
	private static Logger logger = CjfLogger.getLogger(EquipmentTerminalDAO.class.getName());


	/**
	 * add EquipmentTerminalVO object
	 * 
	 * @param EquipmentTerminalVO
	 * @param TransactionManager
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public static EquipmentTerminalVO add(EquipmentTerminalVO equipmentTerminalVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	add	begin");
		//equipmentTerminalVO.setEquipmentID(UtilDAO.getUUid());
		EquipmentTerminalTO equipmentTerminalTO = new EquipmentTerminalTO(EquipmentTerminalTO.ADD_EQUIPMENTTERMINAL,
				equipmentTerminalVO);

		equipmentTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, tManager);
		}
		logger.info("DAO	add	end");
		return equipmentTerminalVO;
	}

	/**
	 * query EquipmentTerminalVO list
	 * 
	 * @param EquipmentTerminalVO
	 * @param PageController
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentTerminalVO> query(EquipmentTerminalVO equipmentTerminalVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		EquipmentTerminalMQB equipmentTerminalMQB = new EquipmentTerminalMQB(
				EquipmentTerminalMQB.QUERY_FROM_EQUIPMENTTERMINAL, equipmentTerminalVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentTerminalMQB, pageController);
		logger.info("list size	:	" + equipmentTerminalMQB.getEquipmentTerminalList().size());
		logger.info("DAO	query	end");
		return equipmentTerminalMQB.getEquipmentTerminalList();
	}

	/**
	 * query EquipmentTerminalVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentTerminalVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		EquipmentTerminalMQB equipmentTerminalMQB = new EquipmentTerminalMQB(
				EquipmentTerminalMQB.QUERY_FROM_EQUIPMENTTERMINAL_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentTerminalMQB, pageController);
		logger.info("list size	:	" + equipmentTerminalMQB.getEquipmentTerminalList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentTerminalMQB.getEquipmentTerminalList();
	}

	/**
	 * modify EquipmentTerminalVO column by ID
	 * 
	 * @param EquipmentTerminalVO
	 * @param TransactionManager
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public static EquipmentTerminalVO modify(EquipmentTerminalVO equipmentTerminalVO, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	modify	begin");
		EquipmentTerminalTO equipmentTerminalTO = new EquipmentTerminalTO(EquipmentTerminalTO.MODIFY_EQUIPMENTTERMINAL,
				equipmentTerminalVO);
		equipmentTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, tManager);
		}
		logger.info("DAO	modify	end");
		return equipmentTerminalVO;
	}

	/**
	 * delete EquipmentTerminalVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		EquipmentTerminalVO equipmentTerminalVO = new EquipmentTerminalVO();
		equipmentTerminalVO.setEquipmentID(ids);
		EquipmentTerminalTO equipmentTerminalTO = new EquipmentTerminalTO(EquipmentTerminalTO.DEL_EQUIPMENTTERMINAL,
				equipmentTerminalVO);

		equipmentTerminalTO.setSqlStr();
		logger.info("sqlStr	:	" + equipmentTerminalTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, true);
		} else {
			TransactionTemplate.executeTransaction(equipmentTerminalTO, tManager);
		}
		logger.info("result	:	" + equipmentTerminalTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return equipmentTerminalTO.getexecuteResult();
	}
	/**
     * query by roomids
     * @param ids
     * @param pageController
     * @return  ArrayList<EquipmentTerminalVO>
     * @throws Exception
     */
	public static ArrayList<EquipmentTerminalVO> queryByRoomIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByroomIDs	begin");
		EquipmentTerminalMQB equipmentTerminalMQB = new EquipmentTerminalMQB(
				EquipmentTerminalMQB.QUERY_TERMINAL_BY_ROOMS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentTerminalMQB, pageController);
		logger.info("list size	:	" + equipmentTerminalMQB.getEquipmentTerminalList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentTerminalMQB.getEquipmentTerminalList();
	}
	/**
	 * queryByIPs
	 * @param ips
	 * @param pageController
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public static ArrayList<EquipmentTerminalVO> queryByIPs(String ips, PageController pageController) throws Exception {
		logger.info("DAO	queryByroomIDs	begin");
		EquipmentTerminalMQB equipmentTerminalMQB = new EquipmentTerminalMQB(
				EquipmentTerminalMQB.QUERY_TERMINAL_BY_IPS, ips);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + equipmentTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentTerminalMQB, pageController);
		logger.info("list size	:	" + equipmentTerminalMQB.getEquipmentTerminalList().size());
		logger.info("DAO	queryByIDs	end");
		return equipmentTerminalMQB.getEquipmentTerminalList();
	}
	
	public static ArrayList<EquipmentTerminalVO> queryByMeetingDetailId(String meetingDetailId, PageController pageController) throws Exception {
		logger.info("DAO	queryByMeetingDetailId	begin");
		EquipmentTerminalMQB equipmentTerminalMQB = new EquipmentTerminalMQB(
				EquipmentTerminalMQB.QUERY_TERMINAL_BY_MID, meetingDetailId);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info(" queryByMeetingDetailId sqlStr	:	" + equipmentTerminalMQB.getSql());
		QueryTemplate.executeQueryForList(equipmentTerminalMQB, pageController);
		logger.info("list size	:	" + equipmentTerminalMQB.getEquipmentTerminalList().size());
		logger.info("DAO	queryByMeetingDetailId	end");
		return equipmentTerminalMQB.getEquipmentTerminalList();
	}
}
