package com.zzst.dao.meeting.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.EquipmentBackupEnum;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;

/**
 * class description: EquipmentBackup MQB
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author ryan
 */
public class EquipmentBackupMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentBackupMQB.class
			.getName());

	public static int QUERY_FROM_EQUIPMENTBACKUP = 1;
	public static int QUERY_FROM_EQUIPMENTBACKUP_BY_IDS = 2;
	public static int QUERY_MEETID=3;
	

	private EquipmentBackupVO equipmentBackupVO;
	private ArrayList<EquipmentBackupVO> listEquipmentBackup = new ArrayList<EquipmentBackupVO>();
	private int _operatorType = -1;
	private String ids = "";
	private String meetid="";

	public EquipmentBackupMQB(int operatorType,
			EquipmentBackupVO equipmentBackupVO) {
		_operatorType = operatorType;
		this.equipmentBackupVO = equipmentBackupVO;
		makeSql();
	}
	
	
	
	



	public EquipmentBackupMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	/**
	 * 2013-3-4
	 * add by tanzanlong 为了方便查询 ,backupequipment增加了字段equipmentType
	 * 
	 * */
	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select zteb.equipmentID,ea.equipmentNO  as equipmentName,ea.ip as ip ,zteb.BackupEquipmentID,eb.equipmentNO  as backupEquipmentName,eb.ip as backupip, zteb.createUserID,zteb.createDate,zteb.backupLevel,zteb.employ,zteb.status,zteb.equipmentType,zteb.description ");
		strsql.append(" from z_t_equipment ea, z_t_equipment_backup zteb, z_t_equipment eb  ");
		strsql.append(" where 1=1 and  ea.equipmentID = zteb.equipmentID and zteb.BackupEquipmentID = eb.equipmentID ");

		if (QUERY_FROM_EQUIPMENTBACKUP == _operatorType) {
			if (null != equipmentBackupVO) {
				if (!StringUtils.isNullOrBlank(equipmentBackupVO
						.getEquipmentID())) {
					strsql.append(" and zteb.equipmentID= ? ");
					super.addStringForField(equipmentBackupVO.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentBackupVO
						.getBackupEquipmentID())) {
					strsql.append(" and zteb.BackupEquipmentID= ? ");
					super.addStringForField(equipmentBackupVO
							.getBackupEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentBackupVO
						.getCreateUserID())) {
					strsql.append(" and zteb.createUserID= ? ");
					super
							.addStringForField(equipmentBackupVO
									.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(equipmentBackupVO
						.getDescription())) {
					strsql.append(" and zteb.description= ? ");
					super.addStringForField(equipmentBackupVO.getDescription());
				}
				if (Integer.MIN_VALUE != equipmentBackupVO.getBackupLevel()) {
					strsql.append(" and zteb.backupLevel= ? ");
					super.addIntForField(equipmentBackupVO.getBackupLevel());
				}
				if (Integer.MIN_VALUE != equipmentBackupVO.getEmploy()) {
					strsql.append(" and zteb.employ= ? ");
					super.addIntForField(equipmentBackupVO.getEmploy());
				}
				if (Integer.MIN_VALUE != equipmentBackupVO.getStatus()) {
					strsql.append(" and zteb.status= ? ");
					super.addIntForField(equipmentBackupVO.getStatus());
				}
			
				if (Integer.MIN_VALUE != equipmentBackupVO.getEquipmentType()) {
					strsql.append(" and zteb.equipmentType= ? ");
					super.addIntForField(equipmentBackupVO.getEquipmentType());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTBACKUP_BY_IDS == _operatorType) {
			strsql.append(" and zteb.equipmentID in (?) ");
			super.addStringForField(ids);
		}else if(QUERY_MEETID == _operatorType){
			String sqlstr=" and zteb.EquipmentID in (";
			sqlstr+=" SELECT z_t_equipment_backup.EquipmentID FROM zzo_mcu_conf ";
			sqlstr+=" INNER JOIN z_t_equipment ON zzo_mcu_conf.mcuIP = z_t_equipment.ip ";
			sqlstr+=" INNER JOIN z_t_equipment_backup ON z_t_equipment.equipmentID = z_t_equipment_backup.EquipmentID ";
			sqlstr+=" where zzo_mcu_conf.confFlagId='"+ids+"' )";
			strsql.append(sqlstr);
			
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
		equipmentBackupVO = new EquipmentBackupVO();
		equipmentBackupVO.setEquipmentID(rs.getString("equipmentID"));
		equipmentBackupVO.setBackupEquipmentID(rs.getString("BackupEquipmentID"));
		equipmentBackupVO.setCreateUserID(rs.getString("createUserID"));
		equipmentBackupVO.setCreateDate(rs.getTimestamp("createDate"));
		equipmentBackupVO.setBackupLevel(rs.getInt("backupLevel"));
		equipmentBackupVO.setEmploy(rs.getInt("employ"));
		equipmentBackupVO.setStatus(rs.getInt("status"));
		equipmentBackupVO.setDescription(rs.getString("description"));
		equipmentBackupVO.setEquipmentType(rs.getInt("equipmentType"));
		
		equipmentBackupVO.setBackupip(rs.getString("backupip"));
		equipmentBackupVO.setIp(rs.getString("ip"));
		equipmentBackupVO.setEquipmentName(rs.getString("equipmentName"));
		equipmentBackupVO.setBackupEquipmentName(rs.getString("backupEquipmentName"));
		listEquipmentBackup.add(equipmentBackupVO);
	}
	
	

	public ArrayList<EquipmentBackupVO> getEquipmentBackupList() {
		return listEquipmentBackup;
	}

	public EquipmentBackupVO getEquipmentBackupVO() {
		return equipmentBackupVO;
	}

}
