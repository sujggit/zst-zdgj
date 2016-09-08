package com.zzst.dao.meeting.meetingroomEquipment;


import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;

/**
 * class description: MeetingroomEquipment TO
 * 
 * @date Fri Jul 19 14:33:03 CST 2013
 * @author ryan
 */
public class MeetingroomEquipmentTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(MeetingroomEquipmentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGROOMEQUIPMENT = 1;
	public static int MODIFY_MEETINGROOMEQUIPMENT = 2;
	public static int DEL_MEETINGROOMEQUIPMENT = 3;
	private int result = 0;

	private MeetingroomEquipmentVO meetingroomEquipmentVO;

	public MeetingroomEquipmentTO(int operatorType,
			MeetingroomEquipmentVO meetingroomEquipmentVO) {
		this.operatorType = operatorType;
		this.meetingroomEquipmentVO = meetingroomEquipmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGROOMEQUIPMENT == operatorType) {
			sqlstr.append("insert into z_t_meetingroom_equipment ");
			sqlstr.append("(roomId,equipmentId,description,revision)");
			sqlstr.append(" values (?,?,?,?)");
			super.addStringForField(meetingroomEquipmentVO.getRoomId());
			super.addStringForField(meetingroomEquipmentVO.getEquipmentId());
			super.addStringForField(meetingroomEquipmentVO.getDescription());
			super.addLongForField(meetingroomEquipmentVO.getRevision());
		} else if (MODIFY_MEETINGROOMEQUIPMENT == operatorType) {
			sqlstr.append("update  z_t_meetingroom_equipment set ");
//			sqlstr.append(" roomId = roomId ");

			if (meetingroomEquipmentVO.getRoomId() != null) {
				sqlstr.append(" roomId=? ");
				super
						.addStringForField(meetingroomEquipmentVO
								.getRoomId());
			}
			if (meetingroomEquipmentVO.getEquipmentId() != null) {
				sqlstr.append(" , equipmentId=? ");
				super
						.addStringForField(meetingroomEquipmentVO
								.getEquipmentId());
			}

			if (meetingroomEquipmentVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super
						.addStringForField(meetingroomEquipmentVO
								.getDescription());
			}

			if (meetingroomEquipmentVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(meetingroomEquipmentVO.getRevision());
			}

			sqlstr.append(" where equipmentId in (?) ");
			if (meetingroomEquipmentVO.getEquipmentId() != null) {
				super.addStringForField(meetingroomEquipmentVO.getEquipmentId());
			}
		} else if (DEL_MEETINGROOMEQUIPMENT == operatorType) {
			sqlstr.append("delete  from  z_t_meetingroom_equipment ");
			sqlstr.append(" where equipmentId in (?) ");
			super.addStringForField(meetingroomEquipmentVO.getEquipmentId());
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
