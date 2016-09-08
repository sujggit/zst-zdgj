package com.zzst.service.meeting.announcement;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.announcement.AnnouncementVO;

/**
 * class description: Announcement Service
 * 
 * @author ryan
 * @date Fri Aug 28 10:29:05 CST 2009
 */

public interface AnnouncementService {

	/**
	 * method description : addAnnouncement
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO addAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : delAnnouncement
	 * 
	 * @param AnnouncementVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify Announcement state by id
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO delAnnouncementForState(
			AnnouncementVO vAnnouncementVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify Announcement all columns by id
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO modifyAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : getAnnouncementList
	 * 
	 * @param AnnouncementVO
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public ArrayList<AnnouncementVO> getAnnouncementList(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException;
	/**
	 * 没有时间的查询
	 * @param vAnnouncementVO
	 * @param mPageController
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public ArrayList<AnnouncementVO> getAnnouncementListNotForTime(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException;
}
