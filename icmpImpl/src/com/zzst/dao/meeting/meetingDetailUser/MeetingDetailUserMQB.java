package com.zzst.dao.meeting.meetingDetailUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;

/**
 * class description: MeetingDetailUser MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailUserMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDetailUserMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGDETAILUSER = 1;

	private MeetingDetailUserVO vMeetingDetailUserVO;

	private ArrayList<MeetingDetailUserVO> lstMeetingDetailUser = new ArrayList<MeetingDetailUserVO>();

	private int _operatorType = -1;

	public MeetingDetailUserMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
 
	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGDETAILUSER == _operatorType) {
			vMeetingDetailUserVO = new MeetingDetailUserVO();
			vMeetingDetailUserVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			vMeetingDetailUserVO.setUserID(rs.getString("userID"));
			vMeetingDetailUserVO.setUserName(rs.getString("userName"));
			vMeetingDetailUserVO.setStatus(rs.getInt("status"));
			vMeetingDetailUserVO.setAppraisalID(rs.getString("appraisalID"));
			vMeetingDetailUserVO.setDescription(rs.getString("description"));
			vMeetingDetailUserVO.setRevision(rs.getLong("revision"));
			lstMeetingDetailUser.add(vMeetingDetailUserVO);
		}
	}

	public ArrayList<MeetingDetailUserVO> getMeetingDetailUserList() {
		return lstMeetingDetailUser;

	}

	public MeetingDetailUserVO getMeetingDetailUserVO() {
		return vMeetingDetailUserVO;
	}

}
