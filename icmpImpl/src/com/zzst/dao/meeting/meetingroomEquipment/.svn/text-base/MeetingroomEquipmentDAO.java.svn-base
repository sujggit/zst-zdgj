package com.zzst.dao.meeting.meetingroomEquipment;


import java.util.ArrayList;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingroomEquipment DAO
 * 
 * @date Fri Jul 19 14:33:03 CST 2013
 * @author ryan
 */
public class MeetingroomEquipmentDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingroomEquipmentDAO.class.getName());

	private static final String id = "RoomId";

	/**
	 * add MeetingroomEquipmentVO object
	 * 
	 * @param MeetingroomEquipmentVO
	 * @param TransactionManager
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public static MeetingroomEquipmentVO add(
			MeetingroomEquipmentVO meetingroomEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		//meetingroomEquipmentVO.setRoomId(UtilDAO.getUUid());
		MeetingroomEquipmentTO meetingroomEquipmentTO = new MeetingroomEquipmentTO(
				MeetingroomEquipmentTO.ADD_MEETINGROOMEQUIPMENT,
				meetingroomEquipmentVO);

		meetingroomEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingroomEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingroomEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingroomEquipmentTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingroomEquipmentVO;
	}

	/**
	 * query MeetingroomEquipmentVO list
	 * 
	 * @param MeetingroomEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingroomEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingroomEquipmentVO> query(
			MeetingroomEquipmentVO meetingroomEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingroomEquipmentMQB meetingroomEquipmentMQB = new MeetingroomEquipmentMQB(
				MeetingroomEquipmentMQB.QUERY_FROM_MEETINGROOMEQUIPMENT,
				meetingroomEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingroomEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingroomEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingroomEquipmentMQB.getMeetingroomEquipmentList().size());
		logger.info("DAO	query	end");
		return meetingroomEquipmentMQB.getMeetingroomEquipmentList();
	}

	/**
	 * query MeetingroomEquipmentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingroomEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingroomEquipmentVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingroomEquipmentMQB meetingroomEquipmentMQB = new MeetingroomEquipmentMQB(
				MeetingroomEquipmentMQB.QUERY_FROM_MEETINGROOMEQUIPMENT_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingroomEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingroomEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingroomEquipmentMQB.getMeetingroomEquipmentList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingroomEquipmentMQB.getMeetingroomEquipmentList();
	}

	/**
	 * modify MeetingroomEquipmentVO column by ID
	 * 
	 * @param MeetingroomEquipmentVO
	 * @param TransactionManager
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public static MeetingroomEquipmentVO modify(
			MeetingroomEquipmentVO meetingroomEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingroomEquipmentTO meetingroomEquipmentTO = new MeetingroomEquipmentTO(
				MeetingroomEquipmentTO.MODIFY_MEETINGROOMEQUIPMENT,
				meetingroomEquipmentVO);
		meetingroomEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingroomEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingroomEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingroomEquipmentTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingroomEquipmentVO;
	}

	/**
	 * delete MeetingroomEquipmentVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public static int deleteByID(String id, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingroomEquipmentVO meetingroomEquipmentVO = new MeetingroomEquipmentVO();
		meetingroomEquipmentVO.setEquipmentId(id);
		MeetingroomEquipmentTO meetingroomEquipmentTO = new MeetingroomEquipmentTO(
				MeetingroomEquipmentTO.DEL_MEETINGROOMEQUIPMENT,
				meetingroomEquipmentVO);

		meetingroomEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingroomEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate
					.executeTransaction(meetingroomEquipmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingroomEquipmentTO,
					tManager);
		}
		logger.info("result	:	" + meetingroomEquipmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingroomEquipmentTO.getexecuteResult();
	}
}
