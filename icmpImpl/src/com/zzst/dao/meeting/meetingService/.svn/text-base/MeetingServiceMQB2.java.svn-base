package com.zzst.dao.meeting.meetingService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService MQB
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingServiceMQB2 extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingServiceMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGSERVICE = 1;

	private MeetingServiceVO vMeetingServiceVO;

	private ArrayList<MeetingServiceVO> lstMeetingService = new ArrayList<MeetingServiceVO>();

	private int _operatorType = -1;

	public MeetingServiceMQB2(int operatorType) {
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
			vMeetingServiceVO.setServiceType(rs.getInt("serviceType"));
			vMeetingServiceVO.setEquipmentID(rs.getInt("equipmentID"));
			vMeetingServiceVO.setModelName(rs.getString("modelName"));
			vMeetingServiceVO.setEquipmentNameCaption(rs
					.getString("equipmentNameCaption"));
			vMeetingServiceVO.setDescription(rs.getString("description"));
			vMeetingServiceVO.setRevision(rs.getLong("revision"));
			
			EquipmentVO equipmentVO = new EquipmentVO();
			//equipmentVO.setEquipmentIP(rs.getString("equipmentip"));
			equipmentVO.setStatus(rs.getInt("status"));
			//equipmentVO.setUplinkEquipmentID(rs.getInt("uplinkEquipmentID"));
			
			vMeetingServiceVO.setEquipmentVO(equipmentVO);
			
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
