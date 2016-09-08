package com.zzst.dao.meeting.meetingRoomMaintainDetail;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintainDetail DAO
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDetailDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomMaintainDetailDAO.class.getName());

	private static final String id = "DetailID";

	/**
	 * add MeetingRoomMaintainDetailVO object
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @param TransactionManager
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public static MeetingRoomMaintainDetailVO add(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		meetingRoomMaintainDetailVO.setDetailID(UtilDAO.getUUid());
		MeetingRoomMaintainDetailTO meetingRoomMaintainDetailTO = new MeetingRoomMaintainDetailTO(
				MeetingRoomMaintainDetailTO.ADD_MEETINGROOMMAINTAINDETAIL,
				meetingRoomMaintainDetailVO);

		meetingRoomMaintainDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingRoomMaintainDetailVO;
	}

	/**
	 * query MeetingRoomMaintainDetailVO list
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomMaintainDetailVO> query(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingRoomMaintainDetailMQB meetingRoomMaintainDetailMQB = new MeetingRoomMaintainDetailMQB(
				MeetingRoomMaintainDetailMQB.QUERY_FROM_MEETINGROOMMAINTAINDETAIL,
				meetingRoomMaintainDetailVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMaintainDetailMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomMaintainDetailMQB
						.getMeetingRoomMaintainDetailList().size());
		logger.info("DAO	query	end");
		return meetingRoomMaintainDetailMQB.getMeetingRoomMaintainDetailList();
	}

	/**
	 * query MeetingRoomMaintainDetailVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainDetailVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomMaintainDetailVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingRoomMaintainDetailMQB meetingRoomMaintainDetailMQB = new MeetingRoomMaintainDetailMQB(
				MeetingRoomMaintainDetailMQB.QUERY_FROM_MEETINGROOMMAINTAINDETAIL_BY_IDS,
				ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMaintainDetailMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingRoomMaintainDetailMQB
						.getMeetingRoomMaintainDetailList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingRoomMaintainDetailMQB.getMeetingRoomMaintainDetailList();
	}

	/**
	 * modify MeetingRoomMaintainDetailVO column by ID
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @param TransactionManager
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public static MeetingRoomMaintainDetailVO modify(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
//		meetingRoomMaintainDetailVO.setDetailID(UtilDAO.getUUid());
		MeetingRoomMaintainDetailTO meetingRoomMaintainDetailTO = new MeetingRoomMaintainDetailTO(
				MeetingRoomMaintainDetailTO.MODIFY_MEETINGROOMMAINTAINDETAIL,
				meetingRoomMaintainDetailVO);
		meetingRoomMaintainDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingRoomMaintainDetailVO;
	}

	/**
	 * delete MeetingRoomMaintainDetailVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
		meetingRoomMaintainDetailVO.setDetailID(ids);
		MeetingRoomMaintainDetailTO meetingRoomMaintainDetailTO = new MeetingRoomMaintainDetailTO(
				MeetingRoomMaintainDetailTO.DEL_MEETINGROOMMAINTAINDETAIL,
				meetingRoomMaintainDetailVO);

		meetingRoomMaintainDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					tManager);
		}
		logger.info("result	:	"
				+ meetingRoomMaintainDetailTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomMaintainDetailTO.getexecuteResult();
	}
	
/**
 * addby duting
 */
	
	public static int deleteByMaintainID(String maintainID, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
		meetingRoomMaintainDetailVO.setMaintainID(maintainID);
		MeetingRoomMaintainDetailTO meetingRoomMaintainDetailTO = new MeetingRoomMaintainDetailTO(
				MeetingRoomMaintainDetailTO.DELETE_BY_MAINTAIID,
				meetingRoomMaintainDetailVO);

		meetingRoomMaintainDetailTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomMaintainDetailTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomMaintainDetailTO,
					tManager);
		}
		logger.info("result	:	"
				+ meetingRoomMaintainDetailTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomMaintainDetailTO.getexecuteResult();
	}
	
}
