package com.zzst.dao.meeting.videoconference;

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
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Videoconference DAO
 * 
 * @author ryan
 * @date Mon Aug 24 13:32:23 CST 2009
 */

public class VideoconferenceDAO {

	private static Logger logger = CbfLogger.getLogger(VideoconferenceDAO.class
			.getName());

	/**
	 * 
	 * @param vVideoconferenceVO
	 * @param tManager
	 * @return vVideoconferenceVO
	 * @throws SQLException
	 */
	public static VideoconferenceVO addVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException {
		VideoconferenceTO vVideoconferenceTO = new VideoconferenceTO(
				VideoconferenceTO.ADD_VIDEOCONFERENCE, vVideoconferenceVO);
		vVideoconferenceTO.setSqlStr();
		logger.info("add sql is :" + vVideoconferenceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vVideoconferenceTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(vVideoconferenceTO, tManager);
		}

		return vVideoconferenceVO;
	}

	/**
	 * 
	 * @param vVideoconferenceVO
	 * @param mPageController
	 * @return ArrayList<VideoconferenceVO>
	 * @throws SQLException
	 */
	public static ArrayList<VideoconferenceVO> getVideoconferenceList(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController)
			throws SQLException {
		StringBuffer strsql = new StringBuffer();

		strsql.append("select meetingDetailID,mdr.meetingroomID,meetingRoomName,speed  rate,ismain, mdr.description,mdr.revision,mdr.rank ");
		strsql.append(" from z_t_meetingdetail_room mdr, z_t_meetingroom mr ");
		strsql.append(" where 1=1 and mdr.meetingroomID= mr.meetingroomID ");
		if (null != vVideoconferenceVO) {
			if (!StringUtils.isNullOrBlank(vVideoconferenceVO.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID='" + vVideoconferenceVO.getMeetingDetailID() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vVideoconferenceVO.getSubmeetingRoomID())) {
				strsql.append(" and mdr.meetingroomID=" + vVideoconferenceVO.getSubmeetingRoomID());
			}
			if (!StringUtils.isNullOrBlank(vVideoconferenceVO.getSubmeetingRoomName())) {
				strsql.append(" and meetingRoomName='" + vVideoconferenceVO.getSubmeetingRoomName() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vVideoconferenceVO.getRate())) {
				strsql.append(" and speed=" + vVideoconferenceVO.getRate());
			}	
			if (!StringUtils.isNullOrBlank(vVideoconferenceVO.getDescription())) {
				strsql.append(" and description='" + vVideoconferenceVO.getDescription() + "'");
			}
		}

		VideoconferenceMQB vVideoconferenceMQB = new VideoconferenceMQB(
				VideoconferenceMQB.QUERY_FROM_VIDEOCONFERENCE);
		vVideoconferenceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vVideoconferenceMQB, mPageController);

		return vVideoconferenceMQB.getVideoconferenceList();
	}
	
	public static ArrayList<VideoconferenceVO> getVideoconferenceListNoMeetingroom(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController)
			throws SQLException {
		StringBuffer strsql = new StringBuffer();

		strsql.append("select meetingDetailID,mdr.meetingroomID,speed  rate,ismain, mdr.description,mdr.revision,mdr.rank ");
		strsql.append(" from z_t_meetingdetail_room mdr ");
		strsql.append(" where 1=1 ");
		if (null != vVideoconferenceVO) {
			if (!StringUtils.isNullOrBlank(vVideoconferenceVO.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID='" + vVideoconferenceVO.getMeetingDetailID() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vVideoconferenceVO.getSubmeetingRoomID())) {
				strsql.append(" and mdr.meetingroomID=" + vVideoconferenceVO.getSubmeetingRoomID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vVideoconferenceVO.getRate())) {
				strsql.append(" and speed=" + vVideoconferenceVO.getRate());
			}	
			if (!StringUtils.isNullOrBlank(vVideoconferenceVO.getDescription())) {
				strsql.append(" and description='" + vVideoconferenceVO.getDescription() + "'");
			}
		}

		VideoconferenceMQB vVideoconferenceMQB = new VideoconferenceMQB(VideoconferenceMQB.QUERY_FROM_VIDEOCONFERENCE_NOMEETINGROOM);
		vVideoconferenceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vVideoconferenceMQB, mPageController);

		return vVideoconferenceMQB.getVideoconferenceList();
	}
	/**
	 * 
	 * @param vVideoconferenceVO
	 * @param tManager
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public static VideoconferenceVO modifyVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException {
		VideoconferenceTO vVideoconferenceTO = new VideoconferenceTO(
				VideoconferenceTO.MODIFY_VIDEOCONFERENCE, vVideoconferenceVO);
		vVideoconferenceTO.setSqlStr();
		logger.info("modify sql is :" + vVideoconferenceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vVideoconferenceTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(vVideoconferenceTO, tManager);
		}

		return vVideoconferenceVO;
	}

	/**
	 * 
	 * @param vVideoconferenceVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delVideoconference(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException {
		VideoconferenceTO vVideoconferenceTO = new VideoconferenceTO(
				VideoconferenceTO.DEL_VIDEOCONFERENCE, vVideoconferenceVO);
		vVideoconferenceTO.setSqlStr();
		logger.info("delete sql is :" + vVideoconferenceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vVideoconferenceTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(vVideoconferenceTO, tManager);
		}
		return vVideoconferenceTO.getexecuteResult();
	}
	public static int delVideoconferenceByDetailId(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException {
		VideoconferenceTO vVideoconferenceTO = new VideoconferenceTO(
				VideoconferenceTO.DEL_ALLVIDEOCONFERENCEs, vVideoconferenceVO);
		vVideoconferenceTO.setSqlStr();
		logger.info("delete sql is :" + vVideoconferenceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vVideoconferenceTO, true);
		} else {
			TransactionTemplate
					.executeTransaction(vVideoconferenceTO, tManager);
		}
		return vVideoconferenceTO.getexecuteResult();
	}
}
