package com.zzst.dao.meeting.equipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;

/**
 * class description: EquipmentBackup TO
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author ryan
 */
public class EquipmentBackupTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentBackupTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTBACKUP = 1;
	public static int MODIFY_EQUIPMENTBACKUP = 2;
	public static int DEL_EQUIPMENTBACKUP = 3;
	private int result = 0;

	private EquipmentBackupVO equipmentBackupVO;
	private String ids = "";

	public EquipmentBackupTO(int operatorType,
			EquipmentBackupVO equipmentBackupVO) {
		this.operatorType = operatorType;
		this.equipmentBackupVO = equipmentBackupVO;
	}

	public EquipmentBackupTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTBACKUP == operatorType) {
			sqlstr.append("insert into z_t_equipment_backup ");
			sqlstr
					.append("(equipmentID,BackupEquipmentID,createUserID,createDate,backupLevel,employ,status,description,equipmentType)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentBackupVO.getEquipmentID());
			super.addStringForField(equipmentBackupVO.getBackupEquipmentID());
			super.addStringForField(equipmentBackupVO.getCreateUserID());
			super.addTimestampForField(equipmentBackupVO.getCreateDate());
			super.addIntForField(equipmentBackupVO.getBackupLevel());
			super.addIntForField(equipmentBackupVO.getEmploy());		
			super.addIntForField(equipmentBackupVO.getStatus());
			super.addStringForField(equipmentBackupVO.getDescription());
			super.addIntForField(equipmentBackupVO.getEquipmentType());
		} else if (MODIFY_EQUIPMENTBACKUP == operatorType) {
			sqlstr.append("update  z_t_equipment_backup set ");
			sqlstr.append(" equipmentID = equipmentID ");
			sqlstr.append(" ,BackupEquipmentID = BackupEquipmentID ");

			if (equipmentBackupVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(equipmentBackupVO.getCreateUserID());
			}

			if (equipmentBackupVO.getCreateDate() != null) {
				sqlstr.append(" , createDate=? ");
				super.addTimestampForField(equipmentBackupVO.getCreateDate());
			}

			if (equipmentBackupVO.getBackupLevel() != Integer.MIN_VALUE) {
				sqlstr.append(" , backupLevel=?");
				super.addIntForField(equipmentBackupVO.getBackupLevel());
			}

			if (equipmentBackupVO.getEmploy() != Integer.MIN_VALUE) {
				sqlstr.append(" , employ=?");
				super.addIntForField(equipmentBackupVO.getEmploy());
			}
			if (equipmentBackupVO.getEquipmentType() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentType=?");
				super.addIntForField(equipmentBackupVO.getEquipmentType());
			}
			if (equipmentBackupVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentBackupVO.getStatus());
			}

			if (equipmentBackupVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentBackupVO.getDescription());
			}

			sqlstr.append(" where equipmentID in (?) ");
			if (equipmentBackupVO.getEquipmentID() != null) {
				super.addStringForField(equipmentBackupVO.getEquipmentID());
			}
			sqlstr.append(" and backupEquipmentID in (?) ");
			if (equipmentBackupVO.getBackupEquipmentID() != null) {
				super.addStringForField(equipmentBackupVO.getBackupEquipmentID());
			}
		} else if (DEL_EQUIPMENTBACKUP == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_backup ");
			sqlstr.append(" where equipmentID = ? and BackupEquipmentID = ? ");
			
			super.addStringForField(equipmentBackupVO.getEquipmentID());
			super.addStringForField(equipmentBackupVO.getBackupEquipmentID());
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
