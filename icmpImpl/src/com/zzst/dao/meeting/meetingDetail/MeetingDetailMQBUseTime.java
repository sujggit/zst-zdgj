package com.zzst.dao.meeting.meetingDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

/**
 * class description: MeetingDetail MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailMQBUseTime extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(MeetingDetailMQB.class.getName());

	public static int QUERY_FROM_MEETINGDETAIL = 1;

	private MeetingDetailVO vMeetingDetailVO;

	private ArrayList<MeetingDetailVO> lstMeetingDetail = new ArrayList<MeetingDetailVO>();

	private int _operatorType = -1;

	public MeetingDetailMQBUseTime(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGDETAIL == _operatorType) {
			vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingRoomID(rs.getString("meetingRoomID"));
			vMeetingDetailVO
					.setMeetingRoomName(rs.getString("meetingRoomName"));
			vMeetingDetailVO.setMeetingStartTime(rs
					.getTimestamp("meetingStartTime"));
			vMeetingDetailVO.setMeetingEndTime(rs
					.getTimestamp("meetingEndTime"));
			vMeetingDetailVO.setUseTime(rs.getLong("use_time"));
			lstMeetingDetail.add(vMeetingDetailVO);
		}

	}

	public ArrayList<MeetingDetailVO> getMeetingDetailList() {
		return lstMeetingDetail;

	}

	public MeetingDetailVO getMeetingDetailVO() {
		return vMeetingDetailVO;
	}

}
