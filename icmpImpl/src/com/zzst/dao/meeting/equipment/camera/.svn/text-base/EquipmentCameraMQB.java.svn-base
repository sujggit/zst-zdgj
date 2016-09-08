package com.zzst.dao.meeting.equipment.camera;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;

/**
 * class description: EquipmentCamera MQB
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public class EquipmentCameraMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentCameraMQB.class
			.getName());

	public static int QUERY_FROM_EQUIPMENTCAMERA = 1;
	public static int QUERY_FROM_EQUIPMENTCAMERA_BY_IDS = 2;

	private EquipmentCameraVO equipmentCameraVO;
	private ArrayList<EquipmentCameraVO> listEquipmentCamera = new ArrayList<EquipmentCameraVO>();

	private int _operatorType = -1;
	private String ids = "";

	public EquipmentCameraMQB(int operatorType,
			EquipmentCameraVO equipmentCameraVO) {
		_operatorType = operatorType;
		this.equipmentCameraVO = equipmentCameraVO;
		makeSql();
	}

	public EquipmentCameraMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select templateID,ccIP,cameraId,templateName,backlight,exposure,gain,speed,iris,whiteBalance,red,blue,createTime,createUserId,updateTime,status,revision,description ");
		strsql.append(" from z_t_equipment_camera ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_EQUIPMENTCAMERA == _operatorType) {
			if (null != equipmentCameraVO) {
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getTemplateID())) {
					strsql.append(" and templateID= ? ");
					super.addStringForField(equipmentCameraVO.getTemplateID());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getCcIP())) {
					strsql.append(" and ccIP= ? ");
					super.addStringForField(equipmentCameraVO.getCcIP());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getCameraId())) {
					strsql.append(" and cameraId= ? ");
					super.addStringForField(equipmentCameraVO.getCameraId());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO
						.getTemplateName())) {
					strsql.append(" and templateName= ? ");
					super.addStringForField(equipmentCameraVO.getTemplateName());
				}
				if (!StringUtils
						.isNullOrBlank(equipmentCameraVO.getBacklight())) {
					strsql.append(" and backlight= ? ");
					super.addStringForField(equipmentCameraVO.getBacklight());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getExposure())) {
					strsql.append(" and exposure= ? ");
					super.addStringForField(equipmentCameraVO.getExposure());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getGain())) {
					strsql.append(" and gain= ? ");
					super.addStringForField(equipmentCameraVO.getGain());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getSpeed())) {
					strsql.append(" and speed= ? ");
					super.addStringForField(equipmentCameraVO.getSpeed());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getIris())) {
					strsql.append(" and iris= ? ");
					super.addStringForField(equipmentCameraVO.getIris());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getWhiteBalance())) {
					strsql.append(" and whiteBalance= ? ");
					super.addStringForField(equipmentCameraVO.getWhiteBalance());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getRed())) {
					strsql.append(" and red= ? ");
					super.addStringForField(equipmentCameraVO.getRed());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO.getBlue())) {
					strsql.append(" and blue= ? ");
					super.addStringForField(equipmentCameraVO.getBlue());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO
						.getCreateUserId())) {
					strsql.append(" and createUserId= ? ");
					super
							.addStringForField(equipmentCameraVO
									.getCreateUserId());
				}
				if (Integer.MIN_VALUE != equipmentCameraVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(equipmentCameraVO.getStatus());
				}
				if (Long.MIN_VALUE != equipmentCameraVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(equipmentCameraVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(equipmentCameraVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(equipmentCameraVO.getDescription());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTCAMERA_BY_IDS == _operatorType) {
			strsql.append(" and templateID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		equipmentCameraVO = new EquipmentCameraVO();
		equipmentCameraVO.setTemplateID(rs.getString("templateID"));
		equipmentCameraVO.setCcIP(rs.getString("ccIP"));
		equipmentCameraVO.setCameraId(rs.getString("cameraId"));
		equipmentCameraVO.setTemplateName(rs.getString("templateName"));
		equipmentCameraVO.setBacklight(rs.getString("backlight"));
		equipmentCameraVO.setExposure(rs.getString("exposure"));
		equipmentCameraVO.setGain(rs.getString("gain"));
		equipmentCameraVO.setSpeed(rs.getString("speed"));
		equipmentCameraVO.setIris(rs.getString("iris"));
		equipmentCameraVO.setWhiteBalance(rs.getString("whiteBalance"));
		equipmentCameraVO.setRed(rs.getString("red"));
		equipmentCameraVO.setBlue(rs.getString("blue"));
		equipmentCameraVO.setCreateTime(rs.getTimestamp("createTime"));
		equipmentCameraVO.setCreateUserId(rs.getString("createUserId"));
		equipmentCameraVO.setCreateTime(rs.getTimestamp("updateTime"));
		equipmentCameraVO.setStatus(rs.getInt("status"));
		equipmentCameraVO.setRevision(rs.getLong("revision"));
		equipmentCameraVO.setDescription(rs.getString("description"));
		listEquipmentCamera.add(equipmentCameraVO);
	}

	public ArrayList<EquipmentCameraVO> getEquipmentCameraList() {
		return listEquipmentCamera;
	}

	public EquipmentCameraVO getEquipmentCameraVO() {
		return equipmentCameraVO;
	}

}
