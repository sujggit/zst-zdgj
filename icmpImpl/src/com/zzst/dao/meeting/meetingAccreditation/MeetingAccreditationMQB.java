package com.zzst.dao.meeting.meetingAccreditation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;

/**
 * class description: MeetingAccreditation MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingAccreditationMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingAccreditationMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGACCREDITATION = 1;

	private MeetingAccreditationVO vMeetingAccreditationVO;

	private ArrayList<MeetingAccreditationVO> lstMeetingAccreditation = new ArrayList<MeetingAccreditationVO>();

	private int _operatorType = -1;

	public MeetingAccreditationMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGACCREDITATION == _operatorType) {
			vMeetingAccreditationVO = new MeetingAccreditationVO();
			vMeetingAccreditationVO.setMeetingAccreditationID(rs
					.getInt("meetingAccreditationID"));
			vMeetingAccreditationVO.setMeetingDetailID(rs
					.getInt("meetingDetailID"));
			vMeetingAccreditationVO.setUserFromID(rs.getInt("userFromID"));
			vMeetingAccreditationVO.setUserFromName(rs
					.getString("userFromName"));
			vMeetingAccreditationVO.setUserToID(rs.getInt("userToID"));
			vMeetingAccreditationVO.setUserToName(rs.getString("userToName"));
			vMeetingAccreditationVO.setDescription(rs.getString("description"));
			vMeetingAccreditationVO.setRevision(rs.getLong("revision"));
			lstMeetingAccreditation.add(vMeetingAccreditationVO);
		}

	}

	public ArrayList<MeetingAccreditationVO> getMeetingAccreditationList() {
		return lstMeetingAccreditation;

	}

	public MeetingAccreditationVO getMeetingAccreditationVO() {
		return vMeetingAccreditationVO;
	}

}
