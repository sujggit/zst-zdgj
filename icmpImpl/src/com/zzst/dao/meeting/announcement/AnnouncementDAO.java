package com.zzst.dao.meeting.announcement;

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
import com.zzst.model.meeting.announcement.AnnouncementVO;

/**
 * class description: Announcement DAO
 * 
 * @author ryan
 * @date Fri Aug 28 10:29:05 CST 2009
 */

public class AnnouncementDAO {

	private static Logger logger = CbfLogger.getLogger(AnnouncementDAO.class
			.getName());

	/**
	 * 
	 * @param vAnnouncementVO
	 * @param tManager
	 * @return vAnnouncementVO
	 * @throws SQLException
	 */
	public static AnnouncementVO addAnnouncement(
			AnnouncementVO vAnnouncementVO, TransactionManager tManager)
			throws SQLException {
		AnnouncementTO vAnnouncementTO = new AnnouncementTO(
				AnnouncementTO.ADD_ANNOUNCEMENT, vAnnouncementVO);
		vAnnouncementTO.setSqlStr();
		logger.info("add sql is :" + vAnnouncementTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vAnnouncementTO, true);
		} else {
			TransactionTemplate.executeTransaction(vAnnouncementTO, tManager);
		}

		return vAnnouncementVO;
	}

	/**
	 * 没有时间的查询
	 * @param vAnnouncementVO
	 * @param mPageController
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public static ArrayList<AnnouncementVO> getAnnouncementListNotForTime(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select announcementID,userID,userName,createTime,startTime,endTime,title,content,description,revision ");
		strsql.append(" from t_Announcement ");
		strsql.append(" where 1=1 ");
		if (null != vAnnouncementVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vAnnouncementVO
					.getAnnouncementID())) {
				strsql.append(" and announcementID="
						+ vAnnouncementVO.getAnnouncementID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vAnnouncementVO.getUserID())) {
				strsql.append(" and userID=" + vAnnouncementVO.getUserID());
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getUserName())) {
				strsql.append(" and userName='" + vAnnouncementVO.getUserName()
						+ "'");
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getTitle())) {
				strsql
						.append(" and title='" + vAnnouncementVO.getTitle()
								+ "'");
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getContent())) {
				strsql.append(" and content='" + vAnnouncementVO.getContent()
						+ "'");
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getDescription())) {
				strsql.append(" and description='"
						+ vAnnouncementVO.getDescription() + "'");
			}
			strsql.append(" order by startTime desc");
		}

		AnnouncementMQB vAnnouncementMQB = new AnnouncementMQB(
				AnnouncementMQB.QUERY_FROM_ANNOUNCEMENT);
		vAnnouncementMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vAnnouncementMQB, mPageController);

		return vAnnouncementMQB.getAnnouncementList();
	}
	
	/**
	 * 
	 * @param vAnnouncementVO
	 * @param mPageController
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public static ArrayList<AnnouncementVO> getAnnouncementList(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select announcementID,userID,userName,createTime,startTime,endTime,title,content,description,revision ");
		strsql.append(" from t_Announcement ");
		strsql.append(" where 1=1 ");
		if (null != vAnnouncementVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vAnnouncementVO
					.getAnnouncementID())) {
				strsql.append(" and announcementID="
						+ vAnnouncementVO.getAnnouncementID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vAnnouncementVO.getUserID())) {
				strsql.append(" and userID=" + vAnnouncementVO.getUserID());
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getUserName())) {
				strsql.append(" and userName='" + vAnnouncementVO.getUserName()
						+ "'");
			}
			
			if(vAnnouncementVO.getStartTime()==null){
				strsql.append(" and startTime <'3000-01-01'");
			}else{
				//strsql.append(" and startTime  between '" + vAnnouncementVO.getStartTime()+"' and '"+vAnnouncementVO.getEndTime()+"'");
				strsql.append(" and startTime <'" + vAnnouncementVO.getStartTime()+"'");
			}

			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getTitle())) {
				strsql
						.append(" and title='" + vAnnouncementVO.getTitle()
								+ "'");
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getContent())) {
				strsql.append(" and content='" + vAnnouncementVO.getContent()
						+ "'");
			}
			if (!StringUtils.isNullOrBlank(vAnnouncementVO.getDescription())) {
				strsql.append(" and description='"
						+ vAnnouncementVO.getDescription() + "'");
			}
			
			
			
			strsql.append(" order by startTime desc");
		}

		AnnouncementMQB vAnnouncementMQB = new AnnouncementMQB(
				AnnouncementMQB.QUERY_FROM_ANNOUNCEMENT);
		vAnnouncementMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vAnnouncementMQB, mPageController);

		return vAnnouncementMQB.getAnnouncementList();
	}

	/**
	 * 
	 * @param vAnnouncementVO
	 * @param tManager
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public static AnnouncementVO modifyAnnouncement(
			AnnouncementVO vAnnouncementVO, TransactionManager tManager)
			throws SQLException {
		AnnouncementTO vAnnouncementTO = new AnnouncementTO(
				AnnouncementTO.MODIFY_ANNOUNCEMENT, vAnnouncementVO);
		vAnnouncementTO.setSqlStr();
		logger.info("modify sql is :" + vAnnouncementTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vAnnouncementTO, true);
		} else {
			TransactionTemplate.executeTransaction(vAnnouncementTO, tManager);
		}

		return vAnnouncementVO;
	}

	/**
	 * 
	 * @param vAnnouncementVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException {
		AnnouncementTO vAnnouncementTO = new AnnouncementTO(
				AnnouncementTO.DEL_ANNOUNCEMENT, vAnnouncementVO);
		vAnnouncementTO.setSqlStr();
		logger.info("delete sql is :" + vAnnouncementTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vAnnouncementTO, true);
		} else {
			TransactionTemplate.executeTransaction(vAnnouncementTO, tManager);
		}
		return vAnnouncementTO.getexecuteResult();
	}

}
