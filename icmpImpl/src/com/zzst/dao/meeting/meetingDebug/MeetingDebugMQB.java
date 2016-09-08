package com.zzst.dao.meeting.meetingDebug;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;

/**
 * class description: MeetingDebug MQB
 * 
 * @date Tue May 28 15:03:30 CST 2013
 * @author ryan
 */
public class MeetingDebugMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDebugMQB.class.getName());

	public static int QUERY_FROM_MEETINGDEBUG = 1;
	public static int QUERY_FROM_MEETINGDEBUG_BY_IDS = 2;

	private MeetingDebugVO meetingDebugVO;
	private ArrayList<MeetingDebugVO> listMeetingDebug = new ArrayList<MeetingDebugVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingDebugMQB(int operatorType, MeetingDebugVO meetingDebugVO) {
		_operatorType = operatorType;
		this.meetingDebugVO = meetingDebugVO;
		makeSql();
	}

	public MeetingDebugMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select id,meetingDetailId,debugStartTime,noticeTime,noticeStatus ");
		strsql.append(" from z_t_meeting_debug ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MEETINGDEBUG == _operatorType) {
			if (null != meetingDebugVO) {
				if (!StringUtils.isNullOrBlank(meetingDebugVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(meetingDebugVO.getId());
				}
				if (!StringUtils.isNullOrBlank(meetingDebugVO
						.getMeetingDetailId())) {
					strsql.append(" and meetingDetailId= ? ");
					super
							.addStringForField(meetingDebugVO
									.getMeetingDetailId());
				}
				if (Integer.MIN_VALUE != meetingDebugVO.getNoticeStatus()) {
					strsql.append(" and noticeStatus= ? ");
					super.addIntForField(meetingDebugVO.getNoticeStatus());
				}
			}
		} else if (QUERY_FROM_MEETINGDEBUG_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		meetingDebugVO = new MeetingDebugVO();
		meetingDebugVO.setId(rs.getString("id"));
		meetingDebugVO.setMeetingDetailId(rs.getString("meetingDetailId"));
		meetingDebugVO.setDebugStartTime(rs.getTimestamp("debugStartTime"));
		meetingDebugVO.setNoticeTime(rs.getTimestamp("noticeTime"));
		meetingDebugVO.setNoticeStatus(rs.getInt("noticeStatus"));
		listMeetingDebug.add(meetingDebugVO);
	}

	public ArrayList<MeetingDebugVO> getMeetingDebugList() {
		return listMeetingDebug;
	}

	public MeetingDebugVO getMeetingDebugVO() {
		return meetingDebugVO;
	}

}
