package com.zzst.dao.meeting.equipment.maintain;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;

/**
 * class description: EquipmentMaintain TO
 * 
 * @date Mon May 06 13:35:59 CST 2013
 * @author ryan
 */
public class EquipmentMaintainTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentMaintainTO.class.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTMAINTAIN = 1;
	public static int MODIFY_EQUIPMENTMAINTAIN = 2;
	public static int DEL_EQUIPMENTMAINTAIN = 3;
	private int result = 0;

	private EquipmentMaintainVO equipmentMaintainVO;

	public EquipmentMaintainTO(int operatorType, EquipmentMaintainVO equipmentMaintainVO) {
		this.operatorType = operatorType;
		this.equipmentMaintainVO = equipmentMaintainVO;
	}

 

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTMAINTAIN == operatorType) {
			sqlstr.append("insert into z_t_Equipment_maintain ");
			sqlstr
					.append("(maintainID,equipmentID,roomID,status,updateUserID,updateTime,maintainCost,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentMaintainVO.getMaintainID());
			super.addStringForField(equipmentMaintainVO.getEquipmentID());
			super.addStringForField(equipmentMaintainVO.getRoomID());
			super.addIntForField(equipmentMaintainVO.getStatus());
			super.addStringForField(equipmentMaintainVO.getUpdateUserID());
			super.addTimestampForField(equipmentMaintainVO.getUpdateTime());
			super.addIntForField(equipmentMaintainVO.getMaintainCost());
			super.addStringForField(equipmentMaintainVO.getDescription());
			super.addLongForField(equipmentMaintainVO.getRevision());
		} else if (MODIFY_EQUIPMENTMAINTAIN == operatorType) {
			sqlstr.append("update  z_t_Equipment_maintain set ");
			sqlstr.append(" maintainID = maintainID ");

			if (equipmentMaintainVO.getEquipmentID() != null) {
				sqlstr.append(" , equipmentID=? ");
				super.addStringForField(equipmentMaintainVO.getEquipmentID());
			}

			if (equipmentMaintainVO.getRoomID() != null) {
				sqlstr.append(" , roomID=? ");
				super.addStringForField(equipmentMaintainVO.getRoomID());
			}

			if (equipmentMaintainVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentMaintainVO.getStatus());
			}

			if (equipmentMaintainVO.getUpdateUserID() != null) {
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(equipmentMaintainVO.getUpdateUserID());
			}

			if (equipmentMaintainVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(equipmentMaintainVO.getUpdateTime());
			}

			if (equipmentMaintainVO.getMaintainCost() != Integer.MIN_VALUE) {
				sqlstr.append(" , maintainCost=?");
				super.addIntForField(equipmentMaintainVO.getMaintainCost());
			}

			if (equipmentMaintainVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentMaintainVO.getDescription());
			}

			if (equipmentMaintainVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(equipmentMaintainVO.getRevision());
			}

			sqlstr.append(" where maintainID in (?) ");
			if (equipmentMaintainVO.getMaintainID() != null) {
				super.addStringForField(equipmentMaintainVO.getMaintainID());
			}
		} else if (DEL_EQUIPMENTMAINTAIN == operatorType) {
			sqlstr.append("delete  from  z_t_Equipment_maintain ");
			sqlstr.append(" where maintainID in (?) ");
			super.addStringForField(equipmentMaintainVO.getMaintainID());
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
