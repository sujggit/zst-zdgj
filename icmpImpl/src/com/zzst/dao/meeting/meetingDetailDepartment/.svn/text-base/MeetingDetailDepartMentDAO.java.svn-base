package com.zzst.dao.meeting.meetingDetailDepartment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;

/**
 * class description: MeetingDetailDepartMent DAO
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public class MeetingDetailDepartMentDAO {
	private static Logger logger = CjfLogger.getLogger(MeetingDetailDepartMentDAO.class.getName());


	/**
	 * add MeetingDetailDepartMentVO object
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @param TransactionManager
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public static MeetingDetailDepartMentVO add(MeetingDetailDepartMentVO meetingDetailDepartMentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		MeetingDetailDepartMentTO meetingDetailDepartMentTO = new MeetingDetailDepartMentTO(
				MeetingDetailDepartMentTO.ADD_MEETINGDETAILDEPARTMENT, meetingDetailDepartMentVO);

		meetingDetailDepartMentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailDepartMentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, tManager);
		}
		logger.info("DAO	add	end");
		return meetingDetailDepartMentVO;
	}

	/**
	 * query MeetingDetailDepartMentVO list
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailDepartMentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailDepartMentVO> query(MeetingDetailDepartMentVO meetingDetailDepartMentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingDetailDepartMentMQB meetingDetailDepartMentMQB = new MeetingDetailDepartMentMQB(
				MeetingDetailDepartMentMQB.QUERY_FROM_MEETINGDETAILDEPARTMENT, meetingDetailDepartMentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailDepartMentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailDepartMentMQB, pageController);
		logger.info("list size	:	" + meetingDetailDepartMentMQB.getMeetingDetailDepartMentList().size());
		logger.info("DAO	query	end");
		return meetingDetailDepartMentMQB.getMeetingDetailDepartMentList();
	}

	/**
	 * query MeetingDetailDepartMentVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingDetailDepartMentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailDepartMentVO> queryByIDs(String ids, PageController pageController)
			throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingDetailDepartMentMQB meetingDetailDepartMentMQB = new MeetingDetailDepartMentMQB(
				MeetingDetailDepartMentMQB.QUERY_FROM_MEETINGDETAILDEPARTMENT_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailDepartMentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailDepartMentMQB, pageController);
		logger.info("list size	:	" + meetingDetailDepartMentMQB.getMeetingDetailDepartMentList().size());
		logger.info("DAO	queryByIDs	end");
		return meetingDetailDepartMentMQB.getMeetingDetailDepartMentList();
	}

	/**
	 * modify MeetingDetailDepartMentVO column by ID
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @param TransactionManager
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public static MeetingDetailDepartMentVO modify(MeetingDetailDepartMentVO meetingDetailDepartMentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingDetailDepartMentTO meetingDetailDepartMentTO = new MeetingDetailDepartMentTO(
				MeetingDetailDepartMentTO.MODIFY_MEETINGDETAILDEPARTMENT, meetingDetailDepartMentVO);
		meetingDetailDepartMentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailDepartMentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, tManager);
		}
		logger.info("DAO	modify	end");
		return meetingDetailDepartMentVO;
	}

	/**
	 * delete MeetingDetailDepartMentVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingDetailDepartMentVO meetingDetailDepartMentVO = new MeetingDetailDepartMentVO();
		meetingDetailDepartMentVO.setMeetingDetailID(ids);
		MeetingDetailDepartMentTO meetingDetailDepartMentTO = new MeetingDetailDepartMentTO(
				MeetingDetailDepartMentTO.DEL_MEETINGDETAILDEPARTMENT, meetingDetailDepartMentVO);

		meetingDetailDepartMentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailDepartMentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailDepartMentTO, tManager);
		}
		logger.info("result	:	" + meetingDetailDepartMentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingDetailDepartMentTO.getexecuteResult();
	}
}
