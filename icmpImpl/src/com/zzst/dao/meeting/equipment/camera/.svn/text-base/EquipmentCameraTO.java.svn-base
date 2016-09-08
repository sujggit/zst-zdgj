package com.zzst.dao.meeting.equipment.camera;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;

/**
 * class description: EquipmentCamera TO
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public class EquipmentCameraTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentCameraTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTCAMERA = 1;
	public static int MODIFY_EQUIPMENTCAMERA = 2;
	public static int DEL_EQUIPMENTCAMERA = 3;
	private int result = 0;

	private EquipmentCameraVO equipmentCameraVO;

	public EquipmentCameraTO(int operatorType,
			EquipmentCameraVO equipmentCameraVO) {
		this.operatorType = operatorType;
		this.equipmentCameraVO = equipmentCameraVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTCAMERA == operatorType) {
			sqlstr.append("insert into z_t_equipment_camera ");
			sqlstr.append("(templateID,ccIP,cameraId,templateName,backlight,exposure,gain,speed,iris,whiteBalance,red,blue,createTime,createUserId,updateTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(equipmentCameraVO.getTemplateID());
			super.addStringForField(equipmentCameraVO.getCcIP());
			super.addStringForField(equipmentCameraVO.getCameraId());
			super.addStringForField(equipmentCameraVO.getTemplateName());
			super.addStringForField(equipmentCameraVO.getBacklight());
			super.addStringForField(equipmentCameraVO.getExposure());
			super.addStringForField(equipmentCameraVO.getGain());
			super.addStringForField(equipmentCameraVO.getSpeed());
			super.addStringForField(equipmentCameraVO.getIris());
			super.addStringForField(equipmentCameraVO.getWhiteBalance());
			super.addStringForField(equipmentCameraVO.getRed());
			super.addStringForField(equipmentCameraVO.getBlue());
			super.addTimestampForField(equipmentCameraVO.getCreateTime());
			super.addStringForField(equipmentCameraVO.getCreateUserId());
			super.addTimestampForField(equipmentCameraVO.getUpdateTime());
			super.addIntForField(equipmentCameraVO.getStatus());
			super.addLongForField(equipmentCameraVO.getRevision());
			super.addStringForField(equipmentCameraVO.getDescription());
		} else if (MODIFY_EQUIPMENTCAMERA == operatorType) {
			sqlstr.append("update  z_t_equipment_camera set ");
			sqlstr.append(" templateID = templateID ");

			if (equipmentCameraVO.getCcIP() != null) {
				sqlstr.append(" , ccIP=? ");
				super.addStringForField(equipmentCameraVO.getCcIP());
			}
			
			if (equipmentCameraVO.getCameraId() != null) {
				sqlstr.append(" , cameraId=? ");
				super.addStringForField(equipmentCameraVO.getCameraId());
			}

			if (equipmentCameraVO.getTemplateName() != null) {
				sqlstr.append(" , templateName=? ");
				super.addStringForField(equipmentCameraVO.getTemplateName());
			}

			if (equipmentCameraVO.getBacklight() != null) {
				sqlstr.append(" , backlight=? ");
				super.addStringForField(equipmentCameraVO.getBacklight());
			}

			if (equipmentCameraVO.getExposure() != null) {
				sqlstr.append(" , exposure=? ");
				super.addStringForField(equipmentCameraVO.getExposure());
			}

			if (equipmentCameraVO.getGain() != null) {
				sqlstr.append(" , gain=? ");
				super.addStringForField(equipmentCameraVO.getGain());
			}

			if (equipmentCameraVO.getSpeed() != null) {
				sqlstr.append(" , speed=? ");
				super.addStringForField(equipmentCameraVO.getSpeed());
			}

			if (equipmentCameraVO.getIris() != null) {
				sqlstr.append(" , iris=? ");
				super.addStringForField(equipmentCameraVO.getIris());
			}

			if (equipmentCameraVO.getWhiteBalance() != null) {
				sqlstr.append(" , whiteBalance=? ");
				super.addStringForField(equipmentCameraVO.getWhiteBalance());
			}

			if (equipmentCameraVO.getRed() != null) {
				sqlstr.append(" , red=? ");
				super.addStringForField(equipmentCameraVO.getRed());
			}

			if (equipmentCameraVO.getBlue() != null) {
				sqlstr.append(" , blue=? ");
				super.addStringForField(equipmentCameraVO.getBlue());
			}

			if (equipmentCameraVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(equipmentCameraVO.getCreateTime());
			}

			if (equipmentCameraVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(equipmentCameraVO.getCreateUserId());
			}

			if(equipmentCameraVO.getUpdateTime() != null){
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(equipmentCameraVO.getUpdateTime());
			}
			
			if (equipmentCameraVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentCameraVO.getStatus());
			}

			if (equipmentCameraVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(equipmentCameraVO.getRevision());
			}

			if (equipmentCameraVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(equipmentCameraVO.getDescription());
			}

			sqlstr.append(" where templateID in (?) ");
			if (equipmentCameraVO.getTemplateID() != null) {
				super.addStringForField(equipmentCameraVO.getTemplateID());
			}
		} else if (DEL_EQUIPMENTCAMERA == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_camera ");
			sqlstr.append(" where templateID in (?) ");
			super.addStringForField(equipmentCameraVO.getTemplateID());
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
