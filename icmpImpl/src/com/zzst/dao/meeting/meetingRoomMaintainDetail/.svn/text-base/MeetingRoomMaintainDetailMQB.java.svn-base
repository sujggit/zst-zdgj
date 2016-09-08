package com.zzst.dao.meeting.meetingRoomMaintainDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintainDetail MQB
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDetailMQB extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(MeetingRoomMaintainDetailMQB.class.getName());

	public static int QUERY_FROM_MEETINGROOMMAINTAINDETAIL = 1;
	public static int QUERY_FROM_MEETINGROOMMAINTAINDETAIL_BY_IDS = 2;

	private MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO;
	private ArrayList<MeetingRoomMaintainDetailVO> listMeetingRoomMaintainDetail = new ArrayList<MeetingRoomMaintainDetailVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingRoomMaintainDetailMQB(int operatorType,
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO) {
		_operatorType = operatorType;
		this.meetingRoomMaintainDetailVO = meetingRoomMaintainDetailVO;
		makeSql();
	}

	public MeetingRoomMaintainDetailMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select *");
		strsql.append(" from z_t_meetingroom_maintain_info ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MEETINGROOMMAINTAINDETAIL == _operatorType) {
			if (null != meetingRoomMaintainDetailVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainDetailVO
						.getDetailID())) {
					strsql.append(" and detailID= ? ");
					super.addStringForField(meetingRoomMaintainDetailVO
							.getDetailID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainDetailVO
						.getMaintainID())) {
					strsql.append(" and maintainID= ? ");
					super.addStringForField(meetingRoomMaintainDetailVO
							.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainDetailVO
						.getMaintainName())) {
					strsql.append(" and maintainName= ? ");
					super.addStringForField(meetingRoomMaintainDetailVO
							.getMaintainName());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainDetailVO
						.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(meetingRoomMaintainDetailVO
							.getStatus());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainDetailVO
						.getQuestionDes())) {
					strsql.append(" and questionDes= ? ");
					super.addStringForField(meetingRoomMaintainDetailVO
							.getQuestionDes());
				}
				if (Long.MIN_VALUE != meetingRoomMaintainDetailVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(meetingRoomMaintainDetailVO
							.getRevision());
				}
				if(Integer.MIN_VALUE != meetingRoomMaintainDetailVO.getType()){
					strsql.append(" and type= ? ");
					super.addIntForField(meetingRoomMaintainDetailVO
							.getType());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainDetailVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingRoomMaintainDetailVO
							.getDescription());
				}
			}
		} else if (QUERY_FROM_MEETINGROOMMAINTAINDETAIL_BY_IDS == _operatorType) {
			strsql.append(" and detailID in (?) ");
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
		meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
		meetingRoomMaintainDetailVO.setDetailID(rs.getString("detailID"));
		meetingRoomMaintainDetailVO.setMaintainID(rs.getString("maintainID"));
		meetingRoomMaintainDetailVO.setMaintainName(rs
				.getString("maintainName"));
		meetingRoomMaintainDetailVO.setStatus(rs.getInt("status"));
		meetingRoomMaintainDetailVO
				.setQuestionDes(rs.getString("questionDes"));
		meetingRoomMaintainDetailVO.setRevision(rs.getLong("revision"));
		meetingRoomMaintainDetailVO.setType(rs.getInt("type"));
		meetingRoomMaintainDetailVO.setDescription(rs.getString("description"));
		listMeetingRoomMaintainDetail.add(meetingRoomMaintainDetailVO);
	}

	public ArrayList<MeetingRoomMaintainDetailVO> getMeetingRoomMaintainDetailList() {
		return listMeetingRoomMaintainDetail;
	}

	public MeetingRoomMaintainDetailVO getMeetingRoomMaintainDetailVO() {
		return meetingRoomMaintainDetailVO;
	}

}
