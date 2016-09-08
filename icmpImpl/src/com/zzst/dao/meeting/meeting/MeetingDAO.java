package com.zzst.dao.meeting.meeting;

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
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.meeting.MeetingVO;

/**
 * class description: Meeting DAO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDAO {

	private static Logger logger = CbfLogger.getLogger(MeetingDAO.class
			.getName());

	/**
	 * 
	 * @param vMeetingVO
	 * @param tManager
	 * @return vMeetingVO
	 * @throws SQLException
	 */
	public static MeetingVO addMeeting(MeetingVO vMeetingVO,
			TransactionManager tManager) throws Exception {
//		Long n = CjfSequenceUtil.getCurSequence("MEETING_ID");
//		vMeetingVO.setMeetingID(n.intValue());
		vMeetingVO.setMeetingID(UtilDAO.getUUid());
		MeetingTO vMeetingTO = new MeetingTO(MeetingTO.ADD_MEETING, vMeetingVO);
		vMeetingTO.setSqlStr();
		logger.info("add sql is :" + vMeetingTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingTO, tManager);
		}

		return vMeetingVO;
	}

	/**
	 * 
	 * @param vMeetingVO
	 * @param mPageController
	 * @return ArrayList<MeetingVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingVO> getMeetingList(MeetingVO vMeetingVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select meetingID,meetingName,meetingType, temlyType, startDate,endDate,createUserID, loginName, createTime,z_t_termlymeeting.status,z_t_termlymeeting.description,z_t_termlymeeting.revision ");
		strsql.append(" from z_t_termlymeeting, z_t_user where z_t_termlymeeting.createUserID = z_t_user.userID");
		strsql.append(" where 1=1 ");
		if (null != vMeetingVO) {
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingVO.getMeetingID())) {
				strsql.append(" and meetingID=" + vMeetingVO.getMeetingID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingVO.getMeetingName())) {
				strsql.append(" and meetingName='" + vMeetingVO.getMeetingName() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingVO.getMeetingType())) {
				strsql.append(" and meetingType="+ vMeetingVO.getMeetingType());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingVO.getPeriodType())) {
				strsql.append(" and temlyType=" + vMeetingVO.getPeriodType());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingVO.getCreateUserID())) {
				strsql.append(" and createUserID=" + vMeetingVO.getCreateUserID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingVO.getStatus())) {
				strsql.append(" and status=" + vMeetingVO.getStatus());
			}
			if (!StringUtils.isNullOrBlank(vMeetingVO.getMeetingDescription())) {
				strsql.append(" and description='" + vMeetingVO.getMeetingDescription() + "'");
			}
		}

		MeetingMQB vMeetingMQB = new MeetingMQB(MeetingMQB.QUERY_FROM_MEETING);
		vMeetingMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingMQB, mPageController);

		return vMeetingMQB.getMeetingList();
	}

	/**
	 * 
	 * @param vMeetingVO
	 * @param tManager
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public static MeetingVO modifyMeeting(MeetingVO vMeetingVO,
			TransactionManager tManager) throws SQLException {
		MeetingTO vMeetingTO = new MeetingTO(MeetingTO.MODIFY_MEETING,
				vMeetingVO);
		vMeetingTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingTO, tManager);
		}

		return vMeetingVO;
	}

	/**
	 * 
	 * @param vMeetingVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeeting(MeetingVO vMeetingVO,
			TransactionManager tManager) throws SQLException {
		MeetingTO vMeetingTO = new MeetingTO(MeetingTO.DEL_MEETING, vMeetingVO);
		vMeetingTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingTO, tManager);
		}
		return vMeetingTO.getexecuteResult();
	}

}
