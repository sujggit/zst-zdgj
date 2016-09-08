package com.zzst.dao.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.MasterQueryObject;
import com.zzst.model.view.VmeetingDetailVO;

public class VmeetingDetailMQB extends MasterQueryObject {
	
	private ArrayList<VmeetingDetailVO> lstMeetingDetail = new ArrayList<VmeetingDetailVO>();
	
	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
	
	@Override
	public void getDataForRow(ResultSet rs) throws SQLException {
		    VmeetingDetailVO vMeetingDetailVO = new VmeetingDetailVO();
			vMeetingDetailVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			vMeetingDetailVO.setStartTime(rs.getTimestamp("startTime"));//rs.getDate("startTime")
			vMeetingDetailVO.setEndTime(rs.getTimestamp("endTime"));
			vMeetingDetailVO.setMeetingType(rs.getString("meetingType"));
			vMeetingDetailVO.setStatus(rs.getString("status"));
			vMeetingDetailVO.setMeetingName(rs.getString("meetingName"));
			vMeetingDetailVO.setInfo1(rs.getString("info1"));
			vMeetingDetailVO.setMeetingroomName(rs.getString("meetingRoomName"));
			vMeetingDetailVO.setMeetingroomID(rs.getString("meetingRoomID"));
			vMeetingDetailVO.setIsmain(rs.getString("ismain"));//是否为主会场
			vMeetingDetailVO.setFullName(rs.getString("fullName"));
			vMeetingDetailVO.setDepName(rs.getString("depName"));
			vMeetingDetailVO.setDepid(rs.getString("depid"));
			vMeetingDetailVO.setUserID(rs.getString("userID"));
			vMeetingDetailVO.setLoginName(rs.getString("loginName"));
			lstMeetingDetail.add(vMeetingDetailVO);
	}
	
	
	public ArrayList<VmeetingDetailVO> getLstMeetingDetail() {
		return lstMeetingDetail;
	}
	public void setLstMeetingDetail(ArrayList<VmeetingDetailVO> lstMeetingDetail) {
		this.lstMeetingDetail = lstMeetingDetail;
	}
	
	
	
	

	
	
}
