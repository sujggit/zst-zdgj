package com.zzst.dao.meeting.meetingAccreditation;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;

/**
 * class description: MeetingAccreditation DAO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingAccreditationDAO {

	private static Logger logger = CbfLogger
			.getLogger(MeetingAccreditationDAO.class.getName());

	/**
	 * 
	 * @param vMeetingAccreditationVO
	 * @param tManager
	 * @return vMeetingAccreditationVO
	 * @throws SQLException
	 */
	public static MeetingAccreditationVO addMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		MeetingAccreditationTO vMeetingAccreditationTO = new MeetingAccreditationTO(
				MeetingAccreditationTO.ADD_MEETINGACCREDITATION,
				vMeetingAccreditationVO);
		vMeetingAccreditationTO.setSqlStr();
		logger.info("add sql is :" + vMeetingAccreditationTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					tManager);
		}

		return vMeetingAccreditationVO;
	}

	/**
	 * 
	 * @param vMeetingAccreditationVO
	 * @param mPageController
	 * @return ArrayList<MeetingAccreditationVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingAccreditationVO> getMeetingAccreditationList(
			MeetingAccreditationVO vMeetingAccreditationVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select meetingAccreditationID,meetingDetailID,userFromID,userFromName,userToID,userToName,description,revision ");
		strsql.append(" from t_MeetingAccreditation ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingAccreditationVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingAccreditationVO
					.getMeetingAccreditationID())) {
				strsql.append(" and meetingAccreditationID="
						+ vMeetingAccreditationVO.getMeetingAccreditationID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingAccreditationVO
					.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID="
						+ vMeetingAccreditationVO.getMeetingDetailID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingAccreditationVO
					.getUserFromID())) {
				strsql.append(" and userFromID="
						+ vMeetingAccreditationVO.getUserFromID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingAccreditationVO
					.getUserFromName())) {
				strsql.append(" and userFromName='"
						+ vMeetingAccreditationVO.getUserFromName() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingAccreditationVO
					.getUserToID())) {
				strsql.append(" and userToID="
						+ vMeetingAccreditationVO.getUserToID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingAccreditationVO
					.getUserToName())) {
				strsql.append(" and userToName='"
						+ vMeetingAccreditationVO.getUserToName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingAccreditationVO
					.getDescription())) {
				strsql.append(" and description='"
						+ vMeetingAccreditationVO.getDescription() + "'");
			}
		}

		MeetingAccreditationMQB vMeetingAccreditationMQB = new MeetingAccreditationMQB(
				MeetingAccreditationMQB.QUERY_FROM_MEETINGACCREDITATION);
		vMeetingAccreditationMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingAccreditationMQB,
				mPageController);

		return vMeetingAccreditationMQB.getMeetingAccreditationList();
	}

	/**
	 * 
	 * @param vMeetingAccreditationVO
	 * @param tManager
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public static MeetingAccreditationVO modifyMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		MeetingAccreditationTO vMeetingAccreditationTO = new MeetingAccreditationTO(
				MeetingAccreditationTO.MODIFY_MEETINGACCREDITATION,
				vMeetingAccreditationVO);
		vMeetingAccreditationTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingAccreditationTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					tManager);
		}

		return vMeetingAccreditationVO;
	}

	/**
	 * 
	 * @param vMeetingAccreditationVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		MeetingAccreditationTO vMeetingAccreditationTO = new MeetingAccreditationTO(
				MeetingAccreditationTO.DEL_MEETINGACCREDITATION,
				vMeetingAccreditationVO);
		vMeetingAccreditationTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingAccreditationTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingAccreditationTO,
					tManager);
		}
		return vMeetingAccreditationTO.getexecuteResult();
	}

}
