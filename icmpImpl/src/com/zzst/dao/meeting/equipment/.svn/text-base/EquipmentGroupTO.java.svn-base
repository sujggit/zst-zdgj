package com.zzst.dao.meeting.equipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;

/**
 * class description: EquipmentGroup TO
 * 
 * @date Thu Apr 24 11:55:59 CST 2014
 * @author ryan
 */
public class EquipmentGroupTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentGroupTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTGROUP = 1;
	public static int MODIFY_EQUIPMENTGROUP = 2;
	public static int DEL_EQUIPMENTGROUP = 3;
	public static int DEL_BYGROUPNAME = 4;
	private int result = 0;

	private EquipmentGroupVO equipmentGroupVO;

	public EquipmentGroupTO(int operatorType, EquipmentGroupVO equipmentGroupVO) {
		this.operatorType = operatorType;
		this.equipmentGroupVO = equipmentGroupVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTGROUP == operatorType) {
			sqlstr.append("insert into z_t_equipment_group ");
			sqlstr.append("(id,groupname,equipmentID,status,description,rank)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			super.addStringForField(equipmentGroupVO.getId());
			super.addStringForField(equipmentGroupVO.getGroupname());
			super.addStringForField(equipmentGroupVO.getEquipmentID());
			super.addIntForField(equipmentGroupVO.getStatus());
			super.addStringForField(equipmentGroupVO.getDescription());
			super.addStringForField(equipmentGroupVO.getRank());
		} else if (MODIFY_EQUIPMENTGROUP == operatorType) {
			sqlstr.append("update  z_t_equipment_group set ");
			sqlstr.append(" id = id ");

			if (equipmentGroupVO.getGroupname() != null) {
				sqlstr.append(" , groupname=? ");
				super.addStringForField(equipmentGroupVO.getGroupname());
			}

			if (equipmentGroupVO.getEquipmentID() != null) {
				sqlstr.append(" , equipmentID=? ");
				super.addStringForField(equipmentGroupVO.getEquipmentID());
			}

			if (equipmentGroupVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentGroupVO.getStatus());
			}

			if (equipmentGroupVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentGroupVO.getDescription());
			}

			if (equipmentGroupVO.getRank() != null) {
				sqlstr.append(" , rank=? ");
				super.addStringForField(equipmentGroupVO.getRank());
			}

			sqlstr.append(" where id = ? ");
			if (equipmentGroupVO.getId() != null) {
				super.addStringForField(equipmentGroupVO.getId());
			}
		} else if (DEL_EQUIPMENTGROUP == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_group where ");
			String[] idArray = equipmentGroupVO.getId().split(",");
			for (int i = 0; i < idArray.length; i++) {
				if (i != 0)
					sqlstr.append(" or ");
				sqlstr.append(" id = '" + idArray[i] + "'");
			}
		}else if (DEL_BYGROUPNAME == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_group where ");
			if (equipmentGroupVO.getGroupname() != null) {
				sqlstr.append(" groupname=? ");
				super.addStringForField(equipmentGroupVO.getGroupname());
			}
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
