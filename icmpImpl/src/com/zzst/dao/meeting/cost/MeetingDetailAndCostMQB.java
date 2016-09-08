package com.zzst.dao.meeting.cost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: MeetingDetailCost MQB
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public class MeetingDetailAndCostMQB extends MasterQueryObject {
	public static final int QUERY_FROM_MEETINGDETAILCOST_MEETINGDETAIL = 0;

	static Logger logger = CbfLogger.getLogger(MeetingDetailAndCostMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGDETAILCOST = 1;
	public static int QUERY_FROM_MEETINGDETAILCOST_BY_IDS = 2;

	private MeetingDetailCostVO meetingDetailCostVO;
	private ArrayList<MeetingDetailCostVO> listMeetingDetailCost = new ArrayList<MeetingDetailCostVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingDetailAndCostMQB(int operatorType,
			MeetingDetailCostVO meetingDetailCostVO) {
		_operatorType = operatorType;
		this.meetingDetailCostVO = meetingDetailCostVO;
		makeSql();
	}

	public MeetingDetailAndCostMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT * FROM z_t_meetingdetail m LEFT JOIN ");
		strsql.append("(SELECT mc.meetingDetailId,SUM(mc.costValue*mc.cout) summary,MIN(mc.createTime) mcCreateTime,MIN(mc.createUserId) mcCreateUserId");
		strsql.append(" FROM z_t_meetingdetail_cost mc WHERE mc.status=0 GROUP BY mc.meetingDetailId) msj ");
		strsql.append("ON  msj.meetingDetailId=m.meetingDetailID");
		strsql.append(" where 1=1 and m.status= " + MeetingStatus.END);
		
		if (QUERY_FROM_MEETINGDETAILCOST_MEETINGDETAIL == _operatorType) {
			if (null != meetingDetailCostVO) {
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO
						.getMeetingDetailId())) {
					strsql.append(" and m.meetingDetailID= ? ");
					super.addStringForField(meetingDetailCostVO.getMeetingDetailId());
				}
				if(!StringUtils.isNullOrBlank(meetingDetailCostVO.getMeetingDetailVO().getMeetingName())){
					strsql.append(" and m.meetingName like '%"+meetingDetailCostVO.getMeetingDetailVO().getMeetingName().trim()+"%'");
				}
				if (!StringUtils.isNullOrBlank(meetingDetailCostVO.getMeetingDetailVO().getMeetingStartTime())) {
					strsql.append(" and m.startTime>'" + meetingDetailCostVO.getMeetingDetailVO().getMeetingStartTime()+"'");
				}
				strsql.append(" order by m.endTime desc ");
			}
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
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailCostVO.setMeetingDetailId(rs.getString("meetingDetailID"));
		meetingDetailCostVO.setCostValue(rs.getInt("summary"));
		meetingDetailCostVO.setCreateUserId(rs.getString("mcCreateUserId"));
		meetingDetailCostVO.setCreateTime(rs.getTimestamp("mcCreateTime"));
		
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
