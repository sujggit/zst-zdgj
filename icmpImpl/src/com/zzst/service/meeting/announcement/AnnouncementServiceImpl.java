package com.zzst.service.meeting.announcement;

import java.sql.SQLException;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.announcement.AnnouncementDAO;
import com.zzst.model.meeting.announcement.AnnouncementVO;

/**
 * class description: Announcement Impl
 * 
 * @author ryan
 * @date Fri Aug 28 10:29:05 CST 2009
 */

public class AnnouncementServiceImpl implements AnnouncementService {

	private static Logger logger = CbfLogger
			.getLogger(AnnouncementServiceImpl.class.getName());
	/**
	 * method description : addAnnouncement
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO addAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException {
		return AnnouncementDAO.addAnnouncement(vAnnouncementVO, tManager);
	}

	/**
	 * method description : getAnnouncementList
	 * 
	 * @param AnnouncementVO
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public ArrayList<AnnouncementVO> getAnnouncementList(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException {
		 
		return AnnouncementDAO.getAnnouncementList(vAnnouncementVO,
				mPageController);
	}
	/**
	 * 没有时间的查询
	 * @param vAnnouncementVO
	 * @param mPageController
	 * @return ArrayList<AnnouncementVO>
	 * @throws SQLException
	 */
	public ArrayList<AnnouncementVO> getAnnouncementListNotForTime(
			AnnouncementVO vAnnouncementVO, PageController mPageController)
			throws SQLException {
		return AnnouncementDAO.getAnnouncementListNotForTime(vAnnouncementVO,
				mPageController);
	}
	/**
	 * method description : delAnnouncement
	 * 
	 * @param AnnouncementVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == AnnouncementDAO.delAnnouncement(vAnnouncementVO, tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify Announcement state by id
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO delAnnouncementForState(
			AnnouncementVO vAnnouncementVO, TransactionManager tManager)
			throws SQLException {
		return modifyAnnouncement(vAnnouncementVO, tManager);
	}

	/**
	 * method description : modify Announcement all columns by id
	 * 
	 * @param AnnouncementVO
	 * @return AnnouncementVO
	 * @throws SQLException
	 */
	public AnnouncementVO modifyAnnouncement(AnnouncementVO vAnnouncementVO,
			TransactionManager tManager) throws SQLException {
		return AnnouncementDAO.modifyAnnouncement(vAnnouncementVO, tManager);
	}

	public static void main(String args[]) throws SQLException {
		AnnouncementVO vAnnouncementVO = new AnnouncementVO();
	 
		vAnnouncementVO.setUserID(1);
		vAnnouncementVO.setUserName("userName");
		vAnnouncementVO.setTitle("title");
		vAnnouncementVO.setContent("content");
		vAnnouncementVO.setDescription("description");
		vAnnouncementVO.setRevision(new Long(1));

		new AnnouncementServiceImpl().addAnnouncement(vAnnouncementVO, null);
		System.out.println("=========add Success!");

		ArrayList<AnnouncementVO> lstAnnouncement = new AnnouncementServiceImpl()
				.getAnnouncementList(vAnnouncementVO, null);

		if (lstAnnouncement.size() > 0) {
			System.out.println("=========query Result:");
			AnnouncementVO vvAnnouncementVO = (AnnouncementVO) lstAnnouncement
					.get(0);
			System.out.println("announcementID="
					+ vvAnnouncementVO.getAnnouncementID());
			System.out.println("userID=" + vvAnnouncementVO.getUserID());
			System.out.println("userName=" + vvAnnouncementVO.getUserName());
			System.out
					.println("createTime=" + vvAnnouncementVO.getCreateTime());
			System.out.println("startTime=" + vvAnnouncementVO.getStartTime());
			System.out.println("endTime=" + vvAnnouncementVO.getEndTime());
			System.out.println("title=" + vvAnnouncementVO.getTitle());
			System.out.println("content=" + vvAnnouncementVO.getContent());
			System.out.println("description="
					+ vvAnnouncementVO.getDescription());
			System.out.println("revision=" + vvAnnouncementVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
