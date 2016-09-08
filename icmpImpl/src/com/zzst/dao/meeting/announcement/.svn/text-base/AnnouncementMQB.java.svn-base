package com.zzst.dao.meeting.announcement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.announcement.AnnouncementVO;

/**
 * class description: Announcement MQB
 * 
 * @author ryan
 * @date Fri Aug 28 10:29:05 CST 2009
 */

public class AnnouncementMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(AnnouncementMQB.class.getName());

	public static int QUERY_FROM_ANNOUNCEMENT = 1;

	private AnnouncementVO vAnnouncementVO;

	private ArrayList<AnnouncementVO> lstAnnouncement = new ArrayList<AnnouncementVO>();

	private int _operatorType = -1;

	public AnnouncementMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_ANNOUNCEMENT == _operatorType) {
			vAnnouncementVO = new AnnouncementVO();
			vAnnouncementVO.setAnnouncementID(rs.getInt("announcementID"));
			vAnnouncementVO.setUserID(rs.getInt("userID"));
			vAnnouncementVO.setUserName(rs.getString("userName"));
			vAnnouncementVO.setCreateTime(rs.getTimestamp("createTime"));
			vAnnouncementVO.setStartTime(rs.getTimestamp("startTime"));
			vAnnouncementVO.setEndTime(rs.getTimestamp("endTime"));
			vAnnouncementVO.setTitle(rs.getString("title"));
			vAnnouncementVO.setContent(rs.getString("content"));
			vAnnouncementVO.setDescription(rs.getString("description"));
			vAnnouncementVO.setRevision(rs.getLong("revision"));
			lstAnnouncement.add(vAnnouncementVO);
		}

	}

	public ArrayList<AnnouncementVO> getAnnouncementList() {
		return lstAnnouncement;

	}

	public AnnouncementVO getAnnouncementVO() {
		return vAnnouncementVO;
	}

}
