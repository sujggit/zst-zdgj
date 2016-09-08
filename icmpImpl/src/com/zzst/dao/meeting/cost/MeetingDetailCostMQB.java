package com.zzst.dao.meeting.cost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: MeetingDetailCost MQB
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public class MeetingDetailCostMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDetailCostMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGDETAILCOST = 1;
	public static int QUERY_FROM_MEETINGDETAILCOST_BY_IDS = 2;

	private MeetingDetailCostVO meetingDetailCostVO;
	private ArrayList<MeetingDetailCostVO> listMeetingDetailCost = new ArrayList<MeetingDetailCostVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingDetailCostMQB(int operatorType,
			MeetingDetailCostVO meetingDetailCostVO) {
		_operatorType = operatorType;
		this.meetingDetailCostVO = meetingDetailCostVO;
		makeSql();
	}

	public MeetingDetailCostMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select mc.*,md.meetingName,md.startTime,md.endTime,u.fullName,u.loginName ");
		strsql.append(" from z_t_meetingdetail_cost mc,z_t_meetingdetail md,z_t_user u ");
		strsql.append(" where 1=1 and mc.status=0 and mc.meetingDetailId = md.meetingDetailID and mc.createUserId=u.userID");

		if (QUERY_FROM_MEETINGDETAILCOST == _operatorType) {
			if (null != meetingDetailCostVO) {
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO.getId())) {
					strsql.append(" and mc.id= ? ");
					super.addStringForField(meetingDetailCostVO.getId());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO
						.getMeetingDetailId())) {
					strsql.append(" and mc.meetingDetailId= ? ");
					super.addStringForField(meetingDetailCostVO.getMeetingDetailId());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO
						.getCostItem())) {
					strsql.append(" and mc.costItem= ? ");
					super.addStringForField(meetingDetailCostVO.getCostItem());
				}
				if (Integer.MIN_VALUE != meetingDetailCostVO.getCout()) {
					strsql.append(" and mc.cout= ? ");
					super.addIntForField(meetingDetailCostVO.getCout());
				}
				if (Integer.MIN_VALUE != meetingDetailCostVO.getCostValue()) {
					strsql.append(" and mc.costValue= ? ");
					super.addIntForField(meetingDetailCostVO.getCostValue());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO.getCreateUserId())) {
					strsql.append(" and mc.createUserId= ? ");
					super.addStringForField(meetingDetailCostVO.getCreateUserId());
				}
				if (Integer.MIN_VALUE != meetingDetailCostVO.getStatus()) {
					strsql.append(" and mc.status= ? ");
					super.addIntForField(meetingDetailCostVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO.getDescription())) {
					strsql.append(" and mc.description= ? ");
					super.addStringForField(meetingDetailCostVO
							.getDescription());
				}
				if (Long.MIN_VALUE != meetingDetailCostVO.getRevision()) {
					strsql.append(" and mc.revision= ? ");
					super.addLongForField(meetingDetailCostVO.getRevision());
				}
				if(!StringUtils.isNullOrBlank(meetingDetailCostVO.getMeetingDetailVO().getMeetingName())){
					strsql.append(" and md.meetingName like '%"+meetingDetailCostVO.getMeetingDetailVO().getMeetingName().trim()+"%'");
				}
				strsql.append(" order by mc.createTime desc ");
			}
		} else if (QUERY_FROM_MEETINGDETAILCOST_BY_IDS == _operatorType) {
			strsql.append(" and mc.id in (?) ");
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
		meetingDetailCostVO = new MeetingDetailCostVO();
		UserVO userVO = new UserVO();
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailCostVO.setId(rs.getString("id"));
		meetingDetailCostVO.setMeetingDetailId(rs.getString("meetingDetailId"));
		meetingDetailCostVO.setCostItem(rs.getString("costItem"));
		meetingDetailCostVO.setCout(rs.getInt("cout"));
		meetingDetailCostVO.setCostValue(rs.getInt("costValue"));
		meetingDetailCostVO.setCreateUserId(rs.getString("createUserId"));
		meetingDetailCostVO.setCreateTime(rs.getTimestamp("createTime"));
		meetingDetailCostVO.setStatus(rs.getInt("status"));
		meetingDetailCostVO.setDescription(rs.getString("description"));
		meetingDetailCostVO.setRevision(rs.getLong("revision"));
		
		userVO.setName(rs.getString("fullName"));
		userVO.setLoginName(rs.getString("loginName"));
		meetingDetailCostVO.setUserVO(userVO);
		
		meetingDetailVO.setMeetingName(rs.getString("meetingName"));
		meetingDetailVO.setMeetingStartTime(rs.getTimestamp("startTime"));
		meetingDetailVO.setMeetingEndTime(rs.getTimestamp("endTime"));
		meetingDetailCostVO.setMeetingDetailVO(meetingDetailVO);
		
		listMeetingDetailCost.add(meetingDetailCostVO);
	}

	public ArrayList<MeetingDetailCostVO> getMeetingDetailCostList() {
		return listMeetingDetailCost;
	}

	public MeetingDetailCostVO getMeetingDetailCostVO() {
		return meetingDetailCostVO;
	}

}
