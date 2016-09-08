package com.zzst.dao.meeting.equipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;

/**
 * class description: EquipmentMcu TO
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentMcuTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentMcuTO.class.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTMCU = 1;
	public static int MODIFY_EQUIPMENTMCU = 2;
	public static int DEL_EQUIPMENTMCU = 3;
	private int result = 0;

	private EquipmentMcuVO equipmentMcuVO;
	//private String ids = "";

	public EquipmentMcuTO(int operatorType, EquipmentMcuVO equipmentMcuVO) {
		this.operatorType = operatorType;
		this.equipmentMcuVO = equipmentMcuVO;
	}

//	public EquipmentMcuTO(int operatorType, String ids) {
//		this.operatorType = operatorType;
//		this.ids = ids;
//	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTMCU == operatorType) {
			sqlstr.append("insert into z_t_Equipment_Mcu ");
			sqlstr.append("(equipmentID,parentID,loginName,loginPassword,commandIP,description,revision,dialingType,dialingDirection,aliasName,aliasType,maxPesolution,cascadeRole,agc,ptsNumber,allResourceNumber,useResourceNumber,videoTreaty,radioTreaty,isCheck,speed)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentMcuVO.getEquipmentID());
			super.addStringForField(equipmentMcuVO.getParentID());
			super.addStringForField(equipmentMcuVO.getLoginName());
			super.addStringForField(equipmentMcuVO.getLoginPassword());
			super.addStringForField(equipmentMcuVO.getCommandIP());
			super.addStringForField(equipmentMcuVO.getDescription());
			super.addLongForField(equipmentMcuVO.getRevision());
			super.addStringForField(equipmentMcuVO.getDialingType());
			super.addStringForField(equipmentMcuVO.getDialingDirection());
			super.addStringForField(equipmentMcuVO.getAliasName());
			super.addStringForField(equipmentMcuVO.getAliasType());
			super.addStringForField(equipmentMcuVO.getMaxPesolution());
			super.addStringForField(equipmentMcuVO.getCascadeRole());
			super.addStringForField(equipmentMcuVO.getAgc());
			super.addStringForField(equipmentMcuVO.getPtsNumber());
			super.addIntForField(equipmentMcuVO.getAllResourceNumber());
			super.addIntForField(equipmentMcuVO.getUseResourceNumber());
			super.addStringForField(equipmentMcuVO.getVideoTreaty());
			super.addStringForField(equipmentMcuVO.getRadioTreaty());
			super.addIntForField(equipmentMcuVO.getIsCheck());
			super.addStringForField(equipmentMcuVO.getSpeed());
		} else if (MODIFY_EQUIPMENTMCU == operatorType) {
			sqlstr.append("update  z_t_Equipment_Mcu set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (equipmentMcuVO.getParentID() != null) {
				sqlstr.append(" , parentID=?");
				super.addStringForField(equipmentMcuVO.getParentID());
			}
			if (equipmentMcuVO.getLoginName() != null) {
				sqlstr.append(" , loginName=? ");
				super.addStringForField(equipmentMcuVO.getLoginName());
			}

			if (equipmentMcuVO.getLoginPassword() != null) {
				sqlstr.append(" , loginPassword=? ");
				super.addStringForField(equipmentMcuVO.getLoginPassword());
			}

			if (equipmentMcuVO.getCommandIP() != null) {
				sqlstr.append(" , commandIP=?");
				super.addStringForField(equipmentMcuVO.getCommandIP());
			}

			if (equipmentMcuVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentMcuVO.getDescription());
			}

			if (equipmentMcuVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(equipmentMcuVO.getRevision());
			}
			//新增加的字段
			if (equipmentMcuVO.getDialingType() != null) {
				sqlstr.append(" , dialingType=? ");
				super.addStringForField(equipmentMcuVO.getDialingType());
			}
			if (equipmentMcuVO.getDialingDirection() != null) {
				sqlstr.append(" , dialingDirection=? ");
				super.addStringForField(equipmentMcuVO.getDialingDirection());
			}
			if (equipmentMcuVO.getAliasName() != null) {
				sqlstr.append(" , aliasName=? ");
				super.addStringForField(equipmentMcuVO.getAliasName());
			}
			if (equipmentMcuVO.getAliasType() != null) {
				sqlstr.append(" , aliasType=? ");
				super.addStringForField(equipmentMcuVO.getAliasType());
			}
			if (equipmentMcuVO.getMaxPesolution() != null) {
				sqlstr.append(" , maxPesolution=? ");
				super.addStringForField(equipmentMcuVO.getMaxPesolution());
			}
			if (equipmentMcuVO.getCascadeRole() != null) {
				sqlstr.append(" , cascadeRole=? ");
				super.addStringForField(equipmentMcuVO.getCascadeRole());
			}
			if (equipmentMcuVO.getAgc() != null) {
				sqlstr.append(" , agc=? ");
				super.addStringForField(equipmentMcuVO.getAgc());
			}
			if (equipmentMcuVO.getPtsNumber() != null) {
				sqlstr.append(" , ptsNumber=? ");
				super.addStringForField(equipmentMcuVO.getPtsNumber());
			}
			if (equipmentMcuVO.getAllResourceNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , allResourceNumber=?");
				super.addIntForField(equipmentMcuVO.getAllResourceNumber());
			}
			if (equipmentMcuVO.getUseResourceNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , useResourceNumber=?");
				super.addIntForField(equipmentMcuVO.getUseResourceNumber());
			}
			if (equipmentMcuVO.getVideoTreaty() != null) {
				sqlstr.append(" , videoTreaty=? ");
				super.addStringForField(equipmentMcuVO.getVideoTreaty());
			}
			if (equipmentMcuVO.getRadioTreaty() != null) {
				sqlstr.append(" , radioTreaty=? ");
				super.addStringForField(equipmentMcuVO.getRadioTreaty());
			}
			if (equipmentMcuVO.getIsCheck() != Integer.MIN_VALUE) {
				sqlstr.append(" , isCheck=?");
				super.addIntForField(equipmentMcuVO.getIsCheck());
			}
			if (equipmentMcuVO.getSpeed() != null) {
				sqlstr.append(" , speed=? ");
				super.addStringForField(equipmentMcuVO.getSpeed());
			}

			sqlstr.append(" where equipmentID = ? ");
			if (equipmentMcuVO.getEquipmentID() != null) {
				super.addStringForField(equipmentMcuVO.getEquipmentID());
			}
		} else if (DEL_EQUIPMENTMCU == operatorType) {
			sqlstr.append("delete  from  z_t_Equipment_Mcu ");
			sqlstr.append(" where equipmentID = ? ");
			super.addStringForField(equipmentMcuVO.getEquipmentID());
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
