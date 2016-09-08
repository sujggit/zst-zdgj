package com.zzst.dao.meeting.meetingDetailRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;

/**
 * @author zhangjy
 * @date 2014-01-14
 */

public class MeetingDetailRoomMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDetailRoomMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGDETAILRoom = 1;

	private MeetingDetailRoomVO vmdrv;

	private ArrayList<MeetingDetailRoomVO> lstMeetingDetailRoom = new ArrayList<MeetingDetailRoomVO>();

	private int _operatorType = -1;

	public MeetingDetailRoomMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}
 
	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGDETAILRoom == _operatorType) {
			vmdrv = new MeetingDetailRoomVO();
			vmdrv.setMeetingDetailId(rs.getString("meetingDetailID"));
			vmdrv.setMeetingDetailName(rs.getString("meetingName"));
			vmdrv.setMeetingRoomId(rs.getString("meetingroomID"));
			vmdrv.setMeetingRoomName(rs.getString("meetingroomName"));
			vmdrv.setSpeed(rs.getInt("speed"));
			vmdrv.setIsmain(rs.getInt("ismain"));
			vmdrv.setDescription(rs.getString("description"));
			vmdrv.setRevision(rs.getString("revision"));
			vmdrv.setRank(rs.getString("rank"));
			vmdrv.setManNum(rs.getString("manNum"));
			vmdrv.setInfo1(rs.getString("info1"));
			vmdrv.setInfo2(rs.getString("info2"));
			vmdrv.setInfo3(rs.getString("info3"));
			vmdrv.setInfo4(rs.getString("info4"));
			vmdrv.setInfo5(rs.getString("info5"));
			lstMeetingDetailRoom.add(vmdrv);
		}
	}

	public ArrayList<MeetingDetailRoomVO> getMeetingDetailRoomList() {
		return lstMeetingDetailRoom;

	}

	public MeetingDetailRoomVO getVmdrv() {
		return vmdrv;
	}

	public void setVmdrv(MeetingDetailRoomVO vmdrv) {
		this.vmdrv = vmdrv;
	}

	
}
