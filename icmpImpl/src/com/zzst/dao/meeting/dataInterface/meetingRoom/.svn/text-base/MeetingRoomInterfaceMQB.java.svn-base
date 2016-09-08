package com.zzst.dao.meeting.dataInterface.meetingRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: MeetingRoomInterface MQB
 * 
 * @date Fri May 24 16:23:45 CST 2013
 * @author ryan
 */
public class MeetingRoomInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingRoomInterfaceMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGROOMINTERFACE = 1;
	public static int QUERY_FROM_MEETINGROOMINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE = 3;

	private MeetingRoomInterfaceVO meetingRoomInterfaceVO;
	private ArrayList<MeetingRoomInterfaceVO> listMeetingRoomInterface = new ArrayList<MeetingRoomInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingRoomInterfaceMQB(int operatorType,
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) {
		_operatorType = operatorType;
		this.meetingRoomInterfaceVO = meetingRoomInterfaceVO;
		makeSql();
	}

	public MeetingRoomInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,meetingroomName,roomNO,meetingRoomType,capacity,adminName,departmentName,addressName,status,meetingRoomStatus,description ");
		strsql.append(" from z_interface_in_meetingroom ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MEETINGROOMINTERFACE == _operatorType) {
			if (null != meetingRoomInterfaceVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(meetingRoomInterfaceVO.getId());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getMeetingroomName())) {
					strsql.append(" and meetingroomName like ? ");
					super.addStringForField("%"+meetingRoomInterfaceVO
							.getMeetingroomName()+"%");
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getRoomNO())) {
					strsql.append(" and roomNO= ? ");
					super.addStringForField(meetingRoomInterfaceVO.getRoomNO());
				}
				if (Integer.MIN_VALUE != meetingRoomInterfaceVO
						.getMeetingRoomType()) {
					strsql.append(" and meetingRoomType= ? ");
					super.addIntForField(meetingRoomInterfaceVO
							.getMeetingRoomType());
				}
				if (Integer.MIN_VALUE != meetingRoomInterfaceVO.getCapacity()) {
					strsql.append(" and capacity= ? ");
					super.addIntForField(meetingRoomInterfaceVO.getCapacity());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getAdminName())) {
					strsql.append(" and adminName= ? ");
					super.addStringForField(meetingRoomInterfaceVO
							.getAdminName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getDepartmentName())) {
					strsql.append(" and departmentName= ? ");
					super.addStringForField(meetingRoomInterfaceVO
							.getDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getAddressName())) {
					strsql.append(" and addressName= ? ");
					super.addStringForField(meetingRoomInterfaceVO
							.getAddressName());
				}
				if (Integer.MIN_VALUE != meetingRoomInterfaceVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(meetingRoomInterfaceVO.getStatus());
				}
				if (Integer.MIN_VALUE != meetingRoomInterfaceVO
						.getMeetingRoomStatus()) {
					strsql.append(" and meetingRoomStatus= ? ");
					super.addIntForField(meetingRoomInterfaceVO
							.getMeetingRoomStatus());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomInterfaceVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingRoomInterfaceVO
							.getDescription());
				}
			}
		} else if (QUERY_FROM_MEETINGROOMINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		} else if ( QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE == _operatorType){
			strsql.append(" and status != 1");
			
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
		meetingRoomInterfaceVO = new MeetingRoomInterfaceVO();
		meetingRoomInterfaceVO.setId(rs.getString("id"));
		meetingRoomInterfaceVO.setMeetingroomName(rs
				.getString("meetingroomName"));
		meetingRoomInterfaceVO.setRoomNO(rs.getString("roomNO"));
		meetingRoomInterfaceVO.setMeetingRoomType(rs.getInt("meetingRoomType"));
		meetingRoomInterfaceVO.setCapacity(rs.getInt("capacity"));
		meetingRoomInterfaceVO.setAdminName(rs.getString("adminName"));
		meetingRoomInterfaceVO
				.setDepartmentName(rs.getString("departmentName"));
		meetingRoomInterfaceVO.setAddressName(rs.getString("addressName"));
		meetingRoomInterfaceVO.setStatus(rs.getInt("status"));
		meetingRoomInterfaceVO.setMeetingRoomStatus(rs
				.getInt("meetingRoomStatus"));
		meetingRoomInterfaceVO.setDescription(rs.getString("description"));
		listMeetingRoomInterface.add(meetingRoomInterfaceVO);
	}

	public ArrayList<MeetingRoomInterfaceVO> getMeetingRoomInterfaceList() {
		return listMeetingRoomInterface;
	}

	public MeetingRoomInterfaceVO getMeetingRoomInterfaceVO() {
		return meetingRoomInterfaceVO;
	}

}
