package com.zzst.dao.meeting.meetingroomEquipment;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;

/**
 * class description: MeetingroomEquipment MQB
 * 
 * @date Fri Jul 19 14:33:03 CST 2013
 * @author ryan
 */
public class MeetingroomEquipmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingroomEquipmentMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGROOMEQUIPMENT = 1;
	public static int QUERY_FROM_MEETINGROOMEQUIPMENT_BY_IDS = 2;

	private MeetingroomEquipmentVO meetingroomEquipmentVO;
	private ArrayList<MeetingroomEquipmentVO> listMeetingroomEquipment = new ArrayList<MeetingroomEquipmentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MeetingroomEquipmentMQB(int operatorType,
			MeetingroomEquipmentVO meetingroomEquipmentVO) {
		_operatorType = operatorType;
		this.meetingroomEquipmentVO = meetingroomEquipmentVO;
		makeSql();
	}

	public MeetingroomEquipmentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select roomId,equipmentId,description,revision ");
		strsql.append(" from z_t_meetingroom_equipment ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MEETINGROOMEQUIPMENT == _operatorType) {
			if (null != meetingroomEquipmentVO) {
				if (!StringUtils.isNullOrBlank(meetingroomEquipmentVO
						.getRoomId())) {
					strsql.append(" and roomId= ? ");
					super.addStringForField(meetingroomEquipmentVO.getRoomId());
				}
				if (!StringUtils.isNullOrBlank(meetingroomEquipmentVO
						.getEquipmentId())) {
					strsql.append(" and equipmentId= ? ");
					super.addStringForField(meetingroomEquipmentVO
							.getEquipmentId());
				}
				if (!StringUtils.isNullOrBlank(meetingroomEquipmentVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingroomEquipmentVO
							.getDescription());
				}
				if (Long.MIN_VALUE != meetingroomEquipmentVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(meetingroomEquipmentVO.getRevision());
				}
			}
		} else if (QUERY_FROM_MEETINGROOMEQUIPMENT_BY_IDS == _operatorType) {
			strsql.append(" and roomId in (?) ");
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
		meetingroomEquipmentVO = new MeetingroomEquipmentVO();
		meetingroomEquipmentVO.setRoomId(rs.getString("roomId"));
		meetingroomEquipmentVO.setEquipmentId(rs.getString("equipmentId"));
		meetingroomEquipmentVO.setDescription(rs.getString("description"));
		meetingroomEquipmentVO.setRevision(rs.getLong("revision"));
		listMeetingroomEquipment.add(meetingroomEquipmentVO);
	}

	public ArrayList<MeetingroomEquipmentVO> getMeetingroomEquipmentList() {
		return listMeetingroomEquipment;
	}

	public MeetingroomEquipmentVO getMeetingroomEquipmentVO() {
		return meetingroomEquipmentVO;
	}

}
