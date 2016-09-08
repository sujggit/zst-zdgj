package com.zzst.dao.meeting.dataInterface.equipment;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;

/**
 * class description: EquipmentInterface TO
 * 
 * @date Mon Jul 01 16:11:19 CST 2013
 * @author ryan
 */
public class EquipmentInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(EquipmentInterfaceTO.class.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTINTERFACE = 1;
	public static int MODIFY_EQUIPMENTINTERFACE = 2;
	public static int DEL_EQUIPMENTINTERFACE = 3;
	public static int DEL_ALL = 4;
	private int result = 0;

	private EquipmentInterfaceVO equipmentInterfaceVO;
	private String ids = "";

	
	public EquipmentInterfaceTO(int operatorType){
		this.operatorType = operatorType;
	}
	
	public EquipmentInterfaceTO(int operatorType,
			EquipmentInterfaceVO equipmentInterfaceVO) {
		this.operatorType = operatorType;
		this.equipmentInterfaceVO = equipmentInterfaceVO;
	}

	public EquipmentInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTINTERFACE == operatorType) {
			sqlstr.append("insert into z_t_interface_in_equipment ");
			sqlstr
					.append("(equipmentID,equipmentType,equipmentModel,equipmentNO,equipmentStatus,mac,ip,commandIP,port,roomNO,adminName,loginName,loginPassword,mcuIp,appraisalTaskNum,showFormatFlag,inputModel,outputModel,appraisalModel,collectModel,equipmentDesc,serialNumber,equipmentIdentifier,maintainceStartTime,maintainMonth,status,description,creatorId)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentInterfaceVO.getEquipmentID());
			super.addIntForField(equipmentInterfaceVO.getEquipmentType());
			super.addStringForField(equipmentInterfaceVO.getEquipmentModel());
			super.addStringForField(equipmentInterfaceVO.getEquipmentNO());
			super.addIntForField(equipmentInterfaceVO.getEquipmentStatus());
			super.addStringForField(equipmentInterfaceVO.getMac());
			super.addStringForField(equipmentInterfaceVO.getIp());
			super.addStringForField(equipmentInterfaceVO.getCommandIP());
			super.addIntForField(equipmentInterfaceVO.getPort());
			super.addStringForField(equipmentInterfaceVO.getRoomNO());
			super.addStringForField(equipmentInterfaceVO.getAdminName());
			super.addStringForField(equipmentInterfaceVO.getLoginName());
			super.addStringForField(equipmentInterfaceVO.getLoginPassword());
			super.addStringForField(equipmentInterfaceVO.getMcuIp());
			super.addStringForField(equipmentInterfaceVO.getAppraisalTaskNum());
			super.addStringForField(equipmentInterfaceVO.getShowFormatFlag());
			super.addStringForField(equipmentInterfaceVO.getInputModel());
			super.addStringForField(equipmentInterfaceVO.getOutputModel());
			super.addStringForField(equipmentInterfaceVO.getAppraisalModel());
			super.addStringForField(equipmentInterfaceVO.getCollectModel());
			super.addStringForField(equipmentInterfaceVO.getEquipmentDesc());
			super.addStringForField(equipmentInterfaceVO.getSerialNumber());
			super.addStringForField(equipmentInterfaceVO
					.getEquipmentIdentifier());
			super.addTimestampForField(equipmentInterfaceVO
					.getMaintainceStartTime());
			super.addIntForField(equipmentInterfaceVO.getMaintainMonth());
			super.addIntForField(equipmentInterfaceVO.getStatus());
			super.addStringForField(equipmentInterfaceVO.getDescription());
			super.addStringForField(equipmentInterfaceVO.getCreatorId());
		} else if (MODIFY_EQUIPMENTINTERFACE == operatorType) {
			sqlstr.append("update  z_t_interface_in_equipment set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (equipmentInterfaceVO.getEquipmentType() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentType=?");
				super.addIntForField(equipmentInterfaceVO.getEquipmentType());
			}

			if (equipmentInterfaceVO.getEquipmentModel() != null) {
				sqlstr.append(" , equipmentModel=? ");
				super.addStringForField(equipmentInterfaceVO
						.getEquipmentModel());
			}

			if (equipmentInterfaceVO.getEquipmentNO() != null) {
				sqlstr.append(" , equipmentNO=? ");
				super.addStringForField(equipmentInterfaceVO.getEquipmentNO());
			}

			if (equipmentInterfaceVO.getEquipmentStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentStatus=?");
				super.addIntForField(equipmentInterfaceVO.getEquipmentStatus());
			}

			if (equipmentInterfaceVO.getMac() != null) {
				sqlstr.append(" , mac=? ");
				super.addStringForField(equipmentInterfaceVO.getMac());
			}

			if (equipmentInterfaceVO.getIp() != null) {
				sqlstr.append(" , ip=? ");
				super.addStringForField(equipmentInterfaceVO.getIp());
			}

			if (equipmentInterfaceVO.getCommandIP() != null) {
				sqlstr.append(" , commandIP=? ");
				super.addStringForField(equipmentInterfaceVO.getCommandIP());
			}

			if (equipmentInterfaceVO.getPort() != Integer.MIN_VALUE) {
				sqlstr.append(" , port=?");
				super.addIntForField(equipmentInterfaceVO.getPort());
			}

			if (equipmentInterfaceVO.getRoomNO() != null) {
				sqlstr.append(" , roomNO=? ");
				super.addStringForField(equipmentInterfaceVO.getRoomNO());
			}

			if (equipmentInterfaceVO.getAdminName() != null) {
				sqlstr.append(" , adminName=? ");
				super.addStringForField(equipmentInterfaceVO.getAdminName());
			}

			if (equipmentInterfaceVO.getLoginName() != null) {
				sqlstr.append(" , loginName=? ");
				super.addStringForField(equipmentInterfaceVO.getLoginName());
			}

			if (equipmentInterfaceVO.getLoginPassword() != null) {
				sqlstr.append(" , loginPassword=? ");
				super
						.addStringForField(equipmentInterfaceVO
								.getLoginPassword());
			}

			if (equipmentInterfaceVO.getMcuIp() != null) {
				sqlstr.append(" , mcuIp=? ");
				super.addStringForField(equipmentInterfaceVO.getMcuIp());
			}

			if (equipmentInterfaceVO.getAppraisalTaskNum() != null) {
				sqlstr.append(" , appraisalTaskNum=? ");
				super.addStringForField(equipmentInterfaceVO
						.getAppraisalTaskNum());
			}

			if (equipmentInterfaceVO.getShowFormatFlag() != null) {
				sqlstr.append(" , showFormatFlag=? ");
				super.addStringForField(equipmentInterfaceVO
						.getShowFormatFlag());
			}

			if (equipmentInterfaceVO.getInputModel() != null) {
				sqlstr.append(" , inputModel=? ");
				super.addStringForField(equipmentInterfaceVO.getInputModel());
			}

			if (equipmentInterfaceVO.getOutputModel() != null) {
				sqlstr.append(" , outputModel=? ");
				super.addStringForField(equipmentInterfaceVO.getOutputModel());
			}

			if (equipmentInterfaceVO.getAppraisalModel() != null) {
				sqlstr.append(" , appraisalModel=? ");
				super.addStringForField(equipmentInterfaceVO
						.getAppraisalModel());
			}

			if (equipmentInterfaceVO.getCollectModel() != null) {
				sqlstr.append(" , collectModel=? ");
				super.addStringForField(equipmentInterfaceVO.getCollectModel());
			}

			if (equipmentInterfaceVO.getEquipmentDesc() != null) {
				sqlstr.append(" , equipmentDesc=? ");
				super
						.addStringForField(equipmentInterfaceVO
								.getEquipmentDesc());
			}

			if (equipmentInterfaceVO.getSerialNumber() != null) {
				sqlstr.append(" , serialNumber=? ");
				super.addStringForField(equipmentInterfaceVO.getSerialNumber());
			}

			if (equipmentInterfaceVO.getEquipmentIdentifier() != null) {
				sqlstr.append(" , equipmentIdentifier=? ");
				super.addStringForField(equipmentInterfaceVO
						.getEquipmentIdentifier());
			}

			if (equipmentInterfaceVO.getMaintainceStartTime() != null) {
				sqlstr.append(" , maintainceStartTime=? ");
				super.addTimestampForField(equipmentInterfaceVO
						.getMaintainceStartTime());
			}

			if (equipmentInterfaceVO.getMaintainMonth() != Integer.MIN_VALUE) {
				sqlstr.append(" , maintainMonth=?");
				super.addIntForField(equipmentInterfaceVO.getMaintainMonth());
			}

			if (equipmentInterfaceVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentInterfaceVO.getStatus());
			}

			if (equipmentInterfaceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentInterfaceVO.getDescription());
			}

			if (equipmentInterfaceVO.getCreatorId() != null) {
				sqlstr.append(" , creatorId=? ");
				super.addStringForField(equipmentInterfaceVO.getCreatorId());
			}

			sqlstr.append(" where equipmentID in (?) ");
			if (equipmentInterfaceVO.getEquipmentID() != null) {
				super.addStringForField(equipmentInterfaceVO.getEquipmentID());
			}
		} else if (DEL_EQUIPMENTINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_equipment ");
			sqlstr.append(" where equipmentID in (?) ");
			super.addStringForField(equipmentInterfaceVO.getEquipmentID());
		} else if(DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_t_interface_in_equipment");
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
