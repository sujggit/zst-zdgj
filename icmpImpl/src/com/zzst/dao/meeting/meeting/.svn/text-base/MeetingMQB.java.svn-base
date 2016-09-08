package com.zzst.dao.meeting.meeting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meeting.MeetingVO;

/**
 * class description: Meeting MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingMQB.class.getName());

	public static int QUERY_FROM_MEETING = 1;

	private MeetingVO vMeetingVO;

	private ArrayList<MeetingVO> lstMeeting = new ArrayList<MeetingVO>();

	private int _operatorType = -1;

	public MeetingMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
//createUserID,createTime,status,description,revision 
	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETING == _operatorType) {
			vMeetingVO = new MeetingVO();
			vMeetingVO.setMeetingID(rs.getString("meetingID"));
			vMeetingVO.setMeetingName(rs.getString("meetingName"));
			vMeetingVO.setMeetingType(rs.getInt("meetingType"));
			vMeetingVO.setPeriodType(rs.getInt("temlyType"));
			vMeetingVO.setStartTime(rs.getTimestamp("startDate"));
			vMeetingVO.setEndTime(rs.getTimestamp("endDate"));
			vMeetingVO.setCreateUserID(rs.getString("createUserID"));
			vMeetingVO.setCreateUserName(rs.getString("loginName"));
			vMeetingVO.setCreateTime(rs.getTimestamp("createTime"));
			vMeetingVO.setStatus(rs.getInt("status"));
			vMeetingVO.setMeetingDescription(rs.getString("description"));
			vMeetingVO.setRevision(rs.getLong("revision"));
			
			lstMeeting.add(vMeetingVO);
		}

	}

	public ArrayList<MeetingVO> getMeetingList() {
		return lstMeeting;

	}

	public MeetingVO getMeetingVO() {
		return vMeetingVO;
	}

}
