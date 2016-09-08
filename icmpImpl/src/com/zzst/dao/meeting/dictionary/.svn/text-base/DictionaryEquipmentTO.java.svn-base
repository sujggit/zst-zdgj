package com.zzst.dao.meeting.dictionary;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;

/**
 * class description: DictionaryEquipment TO
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public class DictionaryEquipmentTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(DictionaryEquipmentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_DICTIONARYEQUIPMENT = 1;
	public static int MODIFY_DICTIONARYEQUIPMENT = 2;
	public static int DEL_DICTIONARYEQUIPMENT = 3;
	private int result = 0;

	private DictionaryEquipmentVO dictionaryEquipmentVO;

	public DictionaryEquipmentTO(int operatorType,
			DictionaryEquipmentVO dictionaryEquipmentVO) {
		this.operatorType = operatorType;
		this.dictionaryEquipmentVO = dictionaryEquipmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_DICTIONARYEQUIPMENT == operatorType) {
			sqlstr.append("insert into z_t_equipment_dictionary ");
			sqlstr
					.append("(dicID,dicName,parentID,updateTime,updateUser,description,status,dicValue,sysValue)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(dictionaryEquipmentVO.getDicID());
			super.addStringForField(dictionaryEquipmentVO.getDicName());
			super.addStringForField(dictionaryEquipmentVO.getParentID());
			super.addTimestampForField(dictionaryEquipmentVO.getUpdateTime());
			super.addStringForField(dictionaryEquipmentVO.getUpdateUser());
			super.addStringForField(dictionaryEquipmentVO.getDescription());
			super.addIntForField(dictionaryEquipmentVO.getStatus());
			super.addIntForField(dictionaryEquipmentVO.getDicValue());
			super.addIntForField(dictionaryEquipmentVO.getSysValue());
		} else if (MODIFY_DICTIONARYEQUIPMENT == operatorType) {
			sqlstr.append("update  z_t_equipment_dictionary set ");
			sqlstr.append(" dicID = dicID ");

			if (dictionaryEquipmentVO.getDicName() != null) {
				sqlstr.append(" , dicName=? ");
				super.addStringForField(dictionaryEquipmentVO.getDicName());
			}

			if (dictionaryEquipmentVO.getParentID() != null) {
				sqlstr.append(" , parentID=? ");
				super.addStringForField(dictionaryEquipmentVO.getParentID());
			}

			if (dictionaryEquipmentVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(dictionaryEquipmentVO
						.getUpdateTime());
			}

			if (dictionaryEquipmentVO.getUpdateUser() != null) {
				sqlstr.append(" , updateUser=? ");
				super.addStringForField(dictionaryEquipmentVO.getUpdateUser());
			}

			if (dictionaryEquipmentVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(dictionaryEquipmentVO.getDescription());
			}

			if (dictionaryEquipmentVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(dictionaryEquipmentVO.getStatus());
			}
			
			if (dictionaryEquipmentVO.getDicValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , dicValue=?");
				super.addIntForField(dictionaryEquipmentVO.getDicValue());
			}
			
			if (dictionaryEquipmentVO.getSysValue() != Integer.MIN_VALUE) {
				sqlstr.append(" , sysValue=?");
				super.addIntForField(dictionaryEquipmentVO.getSysValue());
			}

			sqlstr.append(" where dicID in (?) ");
			if (dictionaryEquipmentVO.getDicID() != null) {
				super.addStringForField(dictionaryEquipmentVO.getDicID());
			}
		} else if (DEL_DICTIONARYEQUIPMENT == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_dictionary ");
			sqlstr.append(" where dicID in (?) ");
			super.addStringForField(dictionaryEquipmentVO.getDicID());
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
