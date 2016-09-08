package com.zzst.dao.meeting.meetingService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingServiceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingServiceMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGSERVICE = 1;

	private MeetingServiceVO vMeetingServiceVO;

	private ArrayList<MeetingServiceVO> lstMeetingService = new ArrayList<MeetingServiceVO>();

	private int _operatorType = -1;

	public MeetingServiceMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGSERVICE == _operatorType) {
			vMeetingServiceVO = new MeetingServiceVO();
			vMeetingServiceVO
					.setMeetingServiceID(rs.getInt("meetingServiceID"));
			vMeetingServiceVO.setMeetingRoomID(rs.getInt("meetingRoomID"));				
			vMeetingServiceVO.setMeetingDetailID(rs.getInt("meetingDetailID"));
			vMeetingServiceVO.setServiceID(rs.getInt("serviceID"));
			vMeetingServiceVO.setServiceType(rs.getInt("serviceType"));
			vMeetingServiceVO.setEquipmentID(rs.getInt("equipmentID"));
			vMeetingServiceVO.setModelName(rs.getString("modelName"));
			vMeetingServiceVO.setEquipmentNameCaption(rs
					.getString("equipmentNameCaption"));
			vMeetingServiceVO.setServiceName(rs.getString("serviceName"));
			vMeetingServiceVO.setDescription(rs.getString("description"));
			vMeetingServiceVO.setRevision(rs.getLong("revision"));
			lstMeetingService.add(vMeetingServiceVO);
		}

	}

	public ArrayList<MeetingServiceVO> getMeetingServiceList() {
		return lstMeetingService;

	}

	public MeetingServiceVO getMeetingServiceVO() {
		return vMeetingServiceVO;
	}

}
