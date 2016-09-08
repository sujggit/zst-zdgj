package com.zzst.dao.meeting.meetingDetailDepartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;

/**
 * class description: MeetingDetailDepartMent MQB
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public class MeetingDetailDepartMentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDetailDepartMentMQB.class.getName());

	public static int QUERY_FROM_MEETINGDETAILDEPARTMENT = 1;
	public static int QUERY_FROM_MEETINGDETAILDEPARTMENT_BY_IDS = 2;

	private MeetingDetailDepartMentVO meetingDetailDepartMentVO;
	private ArrayList<MeetingDetailDepartMentVO> listMeetingDetailDepartMent = new ArrayList<MeetingDetailDepartMentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingDetailDepartMentMQB(int operatorType, MeetingDetailDepartMentVO meetingDetailDepartMentVO) {
		_operatorType = operatorType;
		this.meetingDetailDepartMentVO = meetingDetailDepartMentVO;
		makeSql();
	}

	public MeetingDetailDepartMentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select meetingDetailID,departID,description ");
		strsql.append(" from z_t_meetingdetail_department ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MEETINGDETAILDEPARTMENT == _operatorType) {
			if (null != meetingDetailDepartMentVO) {
				if (!StringUtils.isNullOrBlank(meetingDetailDepartMentVO.getMeetingDetailID())) {
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(meetingDetailDepartMentVO.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailDepartMentVO.getDepartMentID())) {
					strsql.append(" and departID= ? ");
					super.addStringForField(meetingDetailDepartMentVO.getDepartMentID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailDepartMentVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingDetailDepartMentVO.getDescription());
				}
			}
		} else if (QUERY_FROM_MEETINGDETAILDEPARTMENT_BY_IDS == _operatorType) {
			strsql.append(" and meetingDetailID in (?) ");
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
		meetingDetailDepartMentVO = new MeetingDetailDepartMentVO();
		meetingDetailDepartMentVO.setMeetingDetailID(rs.getString("meetingDetailID"));
		meetingDetailDepartMentVO.setDepartMentID(rs.getString("departID"));
		meetingDetailDepartMentVO.setDescription(rs.getString("description"));
		listMeetingDetailDepartMent.add(meetingDetailDepartMentVO);
	}

	public ArrayList<MeetingDetailDepartMentVO> getMeetingDetailDepartMentList() {
		return listMeetingDetailDepartMent;
	}

	public MeetingDetailDepartMentVO getMeetingDetailDepartMentVO() {
		return meetingDetailDepartMentVO;
	}

}
