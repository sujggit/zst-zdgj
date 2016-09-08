package com.zzst.dao.meeting.meetingDetailUser;

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
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;

/**
 * class description: MeetingDetailUser DAO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailUserDAO {

	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailUserDAO.class.getName());

	/**
	 * 
	 * @param vMeetingDetailUserVO
	 * @param tManager
	 * @return vMeetingDetailUserVO
	 * @throws SQLException
	 */
	public static MeetingDetailUserVO addMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailUserTO vMeetingDetailUserTO = new MeetingDetailUserTO(
				MeetingDetailUserTO.ADD_MEETINGDETAILUSER, vMeetingDetailUserVO);
		vMeetingDetailUserTO.setSqlStr();
		logger.info("add sql is :" + vMeetingDetailUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO,
					tManager);
		}

		return vMeetingDetailUserVO;
	}

	/**
	 * 
	 * @param vMeetingDetailUserVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailUserVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailUserVO> getMeetingDetailUserList(
			MeetingDetailUserVO vMeetingDetailUserVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select meetingDetailID,mdu.userID,fullName  userName,  mdu.status,appraisalID,mdu.description,mdu.revision ");
		strsql.append(" from z_t_meetingdetail_user mdu, z_t_user where mdu.userID = z_t_user.userID ");
		//strsql.append(" where 1=1 ");
		if (null != vMeetingDetailUserVO) {
			if (!StringUtils.isNullOrBlank(vMeetingDetailUserVO.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID='" + vMeetingDetailUserVO.getMeetingDetailID() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailUserVO.getUserID())) {
				strsql.append(" and mdu.userID='" + vMeetingDetailUserVO.getUserID() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailUserVO.getUserName())) {
				strsql.append(" and loginName='" + vMeetingDetailUserVO.getUserName() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailUserVO.getStatus())) {
				strsql.append(" and mdu.status=" + vMeetingDetailUserVO.getStatus());
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailUserVO.getAppraisalID())) {
				strsql.append(" and appraisalID='" + vMeetingDetailUserVO.getAppraisalID() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailUserVO.getDescription())) {
				strsql.append(" and mdu.description='" + vMeetingDetailUserVO.getDescription() + "'");
			}
		}

		MeetingDetailUserMQB vMeetingDetailUserMQB = new MeetingDetailUserMQB(
				MeetingDetailUserMQB.QUERY_FROM_MEETINGDETAILUSER);
		vMeetingDetailUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailUserMQB, mPageController);
		return vMeetingDetailUserMQB.getMeetingDetailUserList();
	}

	/**
	 * 
	 * @param vMeetingDetailUserVO
	 * @param tManager
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public static MeetingDetailUserVO modifyMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailUserTO vMeetingDetailUserTO = new MeetingDetailUserTO(
				MeetingDetailUserTO.MODIFY_MEETINGDETAILUSER,
				vMeetingDetailUserVO);
		vMeetingDetailUserTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO,
					tManager);
		}

		return vMeetingDetailUserVO;
	}

	/**
	 * 
	 * @param vMeetingDetailUserVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailUserTO vMeetingDetailUserTO = new MeetingDetailUserTO(
				MeetingDetailUserTO.DEL_MEETINGDETAILUSER, vMeetingDetailUserVO);
		vMeetingDetailUserTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingDetailUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO,
					tManager);
		}
		return vMeetingDetailUserTO.getexecuteResult();
	}
	
	public static int delMeetingDetailUserByDetailId(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailUserTO vMeetingDetailUserTO = new MeetingDetailUserTO(
				MeetingDetailUserTO.DEL_ALLMEETINGDETAILUSERS, vMeetingDetailUserVO);
		vMeetingDetailUserTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingDetailUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailUserTO,
					tManager);
		}
		return vMeetingDetailUserTO.getexecuteResult();
	}
	
}
