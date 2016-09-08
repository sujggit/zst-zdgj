package com.zzst.dao.meeting.equipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: Equipment TO
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public class EquipmentTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENT = 1;
	public static int MODIFY_EQUIPMENT = 2;
	public static int DEL_EQUIPMENT = 3;
	
	public static int MODIFY_STATE=4;
	
	public static int MODIFY_EQUIPMENTNAME =5;
	private int result = 0;

	private EquipmentVO equipmentVO;
	//private String ids = "";

	public EquipmentTO(int operatorType, EquipmentVO equipmentVO) {
		this.operatorType = operatorType;
		this.equipmentVO = equipmentVO;
	}

//	public EquipmentTO(int operatorType, String ids) {
//		this.operatorType = operatorType;
//		this.ids = ids;
//	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENT == operatorType) {
			sqlstr.append("insert into z_t_Equipment ");
			sqlstr.append("(equipmentID,equipmentType,equipmentName,equipmentModel,status,mac,ip,port,equipmentNO,roomID,adminID,createDate,description,revision,serialNumber,equipmentIdentifier,maintenanceStartTime,maintenanceEndTime,loginName,password,equroomID");
			
			
			
			sqlstr.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
			
			
			
			sqlstr.append(")");
			super.addStringForField(equipmentVO.getEquipmentID());
			super.addIntForField(equipmentVO.getEquipmentType());
			super.addStringForField(equipmentVO.getEquipmentName());
			super.addStringForField(equipmentVO.getEquipmentModel());
			super.addIntForField(equipmentVO.getStatus());
			super.addStringForField(equipmentVO.getMac());
			super.addStringForField(equipmentVO.getIp());
			super.addIntForField(equipmentVO.getPort());
			super.addStringForField(equipmentVO.getEquipmentNO());
			super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			super.addStringForField(equipmentVO.getUserVO().getUserID());
			super.addTimestampForField(equipmentVO.getCreateDate());
			super.addStringForField(equipmentVO.getDescription());
			super.addLongForField(equipmentVO.getRevision());
			
			//add by chenshuo 2013-5-6
			super.addStringForField(equipmentVO.getSerialNumber());
			super.addStringForField(equipmentVO.getEquipmentIdentifier());
			super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
			super.addTimestampForField(equipmentVO.getMaintenanceEndTime());
			
			//添加设备名和设备密码
			super.addStringForField(equipmentVO.getLoginName());
			super.addStringForField(equipmentVO.getPassword());
			super.addStringForField(equipmentVO.getEquroomID());
			
		} else if (MODIFY_EQUIPMENT == operatorType) {
			sqlstr.append("update  z_t_Equipment set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (equipmentVO.getEquipmentType() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentType=?");
				super.addIntForField(equipmentVO.getEquipmentType());
			}

			if (equipmentVO.getEquipmentName() != null) {
				sqlstr.append(" , equipmentName=? ");
				super.addStringForField(equipmentVO.getEquipmentName());
			}

			if (equipmentVO.getEquipmentModel() != null) {
				sqlstr.append(" , equipmentModel=? ");
				super.addStringForField(equipmentVO.getEquipmentModel());
			}

			if (equipmentVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentVO.getStatus());
			}

			if (equipmentVO.getIp() != null) {
				sqlstr.append(" , ip=? ");
				super.addStringForField(equipmentVO.getIp());
			}

			if (equipmentVO.getPort() != Integer.MIN_VALUE) {
				sqlstr.append(" , port=?");
				super.addIntForField(equipmentVO.getPort());
			}

			if (equipmentVO.getEquipmentNO() != null) {
				sqlstr.append(" , equipmentNO=?");
				super.addStringForField(equipmentVO.getEquipmentNO());
			}

			if (equipmentVO.getMeetingRoomVO().getMeetingRoomID() != null) {
				sqlstr.append(" , roomID=? ");
				super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			}

			if (equipmentVO.getUserVO().getUserID()!=null) {
				sqlstr.append(" , adminID=?");
				super.addStringForField(equipmentVO.getUserVO().getUserID());
			}

			if (equipmentVO.getCreateDate() != null) {
				sqlstr.append(" , createDate=? ");
				//if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				//	UtilDAO.oracleToDate(equipmentVO.getCreateDate());
				//}else{
					super.addTimestampForField(equipmentVO.getCreateDate());
			//	}
			}

			if (equipmentVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentVO.getDescription());
			}

			if (equipmentVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(equipmentVO.getRevision());
			}
			if (equipmentVO.getMac() != null) {
				sqlstr.append(" , mac=? ");
				super.addStringForField(equipmentVO.getMac());
			}
			if (equipmentVO.getSerialNumber() != null) {
				sqlstr.append(" , serialNumber=? ");
				super.addStringForField(equipmentVO.getSerialNumber());
			}
			if (equipmentVO.getEquipmentIdentifier() != null) {
				sqlstr.append(" , equipmentIdentifier=? ");
				super.addStringForField(equipmentVO.getEquipmentIdentifier());
			}
			if (equipmentVO.getMaintenanceStartTime() != null ) {
				sqlstr.append(" , maintenanceStartTime=? ");
				super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
			}
			if (equipmentVO.getMaintenanceEndTime() != null) {
				sqlstr.append(" , maintenanceEndTime=? ");
				super.addTimestampForField(equipmentVO.getMaintenanceEndTime());
			}
			
			if (equipmentVO.getLoginName() != null) {
				sqlstr.append(" , loginName=? ");
				super.addStringForField(equipmentVO.getLoginName());
			}
			if (equipmentVO.getPassword() != null) {
				sqlstr.append(" , password=? ");
				super.addStringForField(equipmentVO.getPassword());
			}
			if (equipmentVO.getEquroomID() != null) {
				sqlstr.append(" , equrommID=? ");
				super.addStringForField(equipmentVO.getEquroomID());
			}
			
			sqlstr.append(" where equipmentID = ? ");
			if (equipmentVO.getEquipmentID() != null) {
				super.addStringForField(equipmentVO.getEquipmentID());
			}
		} else if (DEL_EQUIPMENT == operatorType) {
			sqlstr.append("delete  from  z_t_Equipment ");
			sqlstr.append(" where equipmentID = ? ");
			super.addStringForField(equipmentVO.getEquipmentID());
		}else if(MODIFY_STATE==operatorType){
			sqlstr.append("update  z_t_Equipment set ");
			sqlstr.append("  status= '"+EquipmentEnum.STATUS_INVALID+"'"+" where equipmentID=?");
			super.addStringForField(equipmentVO.getEquipmentID());
		}else if(MODIFY_EQUIPMENTNAME==operatorType){
			sqlstr.append("update  z_t_Equipment set ");
			if (equipmentVO.getEquipmentName() != null) {
				sqlstr.append(" equipmentName=? ");
				super.addStringForField(equipmentVO.getEquipmentName());
			}
			if (equipmentVO.getEquipmentType() != Integer.MIN_VALUE) {
				sqlstr.append(" where equipmentType=?");
				super.addIntForField(equipmentVO.getEquipmentType());
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
