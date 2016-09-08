package com.zzst.dao.meeting.equipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;

/**
 * class description: EquipmentTerminal TO
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentTerminalTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentTerminalTO.class.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTTERMINAL = 1;
	public static int MODIFY_EQUIPMENTTERMINAL = 2;
	public static int DEL_EQUIPMENTTERMINAL = 3;
	private int result = 0;

	private EquipmentTerminalVO equipmentTerminalVO;
	//private String ids = "";

	public EquipmentTerminalTO(int operatorType, EquipmentTerminalVO equipmentTerminalVO) {
		this.operatorType = operatorType;
		this.equipmentTerminalVO = equipmentTerminalVO;
	}

//	public EquipmentTerminalTO(int operatorType, String ids) {
//		this.operatorType = operatorType;
//		this.ids = ids;
//	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTTERMINAL == operatorType) {
			sqlstr.append("insert into z_t_Equipment_Terminal ");
			sqlstr.append("(equipmentID,loginName,loginPassword,createTime,pstn,speed,videoTreaty,radioTreaty,equipmentMCUID,description,revision,dialingType,dialingDirection,aliasName,aliasType,maxPesolution,cascadeRole,agc,ptsNumber,isCheck,mcuResourse,useRole,controlParameter)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentTerminalVO.getEquipmentID());
			super.addStringForField(equipmentTerminalVO.getLoginName());
			super.addStringForField(equipmentTerminalVO.getLoginPassword());
			super.addTimestampForField(equipmentTerminalVO.getCreateTime());
			super.addStringForField(equipmentTerminalVO.getPstn());
			super.addStringForField(equipmentTerminalVO.getSpeed());
			super.addStringForField(equipmentTerminalVO.getVideoTreaty());
			super.addStringForField(equipmentTerminalVO.getRadioTreaty());
			super.addStringForField(equipmentTerminalVO.getEquipmentMCUID());
			super.addStringForField(equipmentTerminalVO.getDescription());
			super.addLongForField(equipmentTerminalVO.getRevision());
			super.addStringForField(equipmentTerminalVO.getDialingType());
			super.addStringForField(equipmentTerminalVO.getDialingDirection());
			super.addStringForField(equipmentTerminalVO.getAliasName());
			super.addStringForField(equipmentTerminalVO.getAliasType());
			super.addStringForField(equipmentTerminalVO.getMaxPesolution());
			super.addStringForField(equipmentTerminalVO.getCascadeRole());
			super.addStringForField(equipmentTerminalVO.getAgc());
			super.addStringForField(equipmentTerminalVO.getPtsNumber());
			super.addIntForField(equipmentTerminalVO.getIsCheck());
			super.addStringForField(equipmentTerminalVO.getMcuResourse());
			super.addStringForField(equipmentTerminalVO.getUseRole());
			super.addStringForField(equipmentTerminalVO.getControlParameter());
		} else if (MODIFY_EQUIPMENTTERMINAL == operatorType) {
			sqlstr.append("update  z_t_Equipment_Terminal set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (equipmentTerminalVO.getLoginName() != null) {
				sqlstr.append(" , loginName=? ");
				super.addStringForField(equipmentTerminalVO.getLoginName());
			}

			if (equipmentTerminalVO.getLoginPassword() != null) {
				sqlstr.append(" , loginPassword=? ");
				super.addStringForField(equipmentTerminalVO.getLoginPassword());
			}

			if (equipmentTerminalVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(equipmentTerminalVO.getCreateTime());
			}

			if (equipmentTerminalVO.getPstn() != null) {
				sqlstr.append(" , pstn=? ");
				super.addStringForField(equipmentTerminalVO.getPstn());
			}

			if (equipmentTerminalVO.getSpeed() != null) {
				sqlstr.append(" , speed=?");
				super.addStringForField(equipmentTerminalVO.getSpeed());
			}

			if (equipmentTerminalVO.getVideoTreaty() != null) {
				sqlstr.append(" , videoTreaty=? ");
				super.addStringForField(equipmentTerminalVO.getVideoTreaty());
			}

			if (equipmentTerminalVO.getRadioTreaty() != null) {
				sqlstr.append(" , radioTreaty=? ");
				super.addStringForField(equipmentTerminalVO.getRadioTreaty());
			}

			if (equipmentTerminalVO.getEquipmentMCUID() != null) {
				sqlstr.append(" , equipmentMCUID=? ");
				super.addStringForField(equipmentTerminalVO.getEquipmentMCUID());
			}

			if (equipmentTerminalVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentTerminalVO.getDescription());
			}

			if (equipmentTerminalVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(equipmentTerminalVO.getRevision());
			}
			
			//新增字段
			if (equipmentTerminalVO.getDialingType() != null) {
				sqlstr.append(" , dialingType=? ");
				super.addStringForField(equipmentTerminalVO.getDialingType());
			}
			if (equipmentTerminalVO.getDialingDirection() != null) {
				sqlstr.append(" , dialingDirection=? ");
				super.addStringForField(equipmentTerminalVO.getDialingDirection());
			}
			if (equipmentTerminalVO.getAliasName() != null) {
				sqlstr.append(" , aliasName=? ");
				super.addStringForField(equipmentTerminalVO.getAliasName());
			}
			if (equipmentTerminalVO.getAliasType() != null) {
				sqlstr.append(" , aliasType=? ");
				super.addStringForField(equipmentTerminalVO.getAliasType());
			}
			if (equipmentTerminalVO.getMaxPesolution() != null) {
				sqlstr.append(" , maxPesolution=? ");
				super.addStringForField(equipmentTerminalVO.getMaxPesolution());
			}
			if (equipmentTerminalVO.getCascadeRole() != null) {
				sqlstr.append(" , cascadeRole=? ");
				super.addStringForField(equipmentTerminalVO.getCascadeRole());
			}
			if (equipmentTerminalVO.getAgc() != null) {
				sqlstr.append(" , agc=? ");
				super.addStringForField(equipmentTerminalVO.getAgc());
			}
			if (equipmentTerminalVO.getPtsNumber() != null) {
				sqlstr.append(" , ptsNumber=? ");
				super.addStringForField(equipmentTerminalVO.getPtsNumber());
			}
			if (equipmentTerminalVO.getIsCheck() != Integer.MIN_VALUE) {
				sqlstr.append(" , isCheck=?");
				super.addIntForField(equipmentTerminalVO.getIsCheck());
			}
			if (equipmentTerminalVO.getMcuResourse() != null) {
				sqlstr.append(" , mcuResourse=? ");
				super.addStringForField(equipmentTerminalVO.getMcuResourse());
			}
			if (equipmentTerminalVO.getUseRole() != null) {
				sqlstr.append(" , useRole=? ");
				super.addStringForField(equipmentTerminalVO.getUseRole());
			}
			if (equipmentTerminalVO.getControlParameter() != null) {
				sqlstr.append(" , controlParameter=? ");
				super.addStringForField(equipmentTerminalVO.getControlParameter());
			}
			
			sqlstr.append(" where equipmentID = ? ");
			if (equipmentTerminalVO.getEquipmentID() != null) {
				super.addStringForField(equipmentTerminalVO.getEquipmentID());
			}
		} else if (DEL_EQUIPMENTTERMINAL == operatorType) {
			sqlstr.append("delete  from  z_t_Equipment_Terminal ");
			sqlstr.append(" where equipmentID = ? ");
			super.addStringForField(equipmentTerminalVO.getEquipmentID());
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
