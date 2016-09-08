package com.zzst.dao.meeting.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;

/**
 * class description: EquipmentMcu MQB
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentMcuMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentMcuMQB.class.getName());

	public static int QUERY_FROM_EQUIPMENTMCU = 1;
	public static int QUERY_FROM_EQUIPMENTMCU_BY_IDS = 2;
	public static int QUERY_MCU_BY_IPS = 3;
	public static int QUERY_FROM_EQUIPMENTMCU_BYMCUID = 4;
	private EquipmentMcuVO equipmentMcuVO;
	private ArrayList<EquipmentMcuVO> listEquipmentMcu = new ArrayList<EquipmentMcuVO>();

	private int _operatorType = -1;
	private String ids = "";
	private String ips = "";
	
	public EquipmentMcuMQB(int operatorType, EquipmentMcuVO equipmentMcuVO) {
		_operatorType = operatorType;
		this.equipmentMcuVO = equipmentMcuVO;
		makeSql();
	}

	public EquipmentMcuMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	public EquipmentMcuMQB( int operatorType)
	{
		_operatorType = operatorType;
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select equipmentID,parentID,loginName,loginPassword,commandIP,description,revision,dialingType,dialingDirection,aliasName,aliasType,maxPesolution,cascadeRole,agc,ptsNumber,allResourceNumber,useResourceNumber,videoTreaty,radioTreaty,isCheck,speed ");
		strsql.append(" from z_t_Equipment_Mcu ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_EQUIPMENTMCU == _operatorType) {
			if (null != equipmentMcuVO) {
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(equipmentMcuVO.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getParentID())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(equipmentMcuVO.getParentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getLoginName())) {
					strsql.append(" and loginName= ? ");
					super.addStringForField(equipmentMcuVO.getLoginName());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getLoginPassword())) {
					strsql.append(" and loginPassword= ? ");
					super.addStringForField(equipmentMcuVO.getLoginPassword());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getCommandIP())) {
					strsql.append(" and commandIP=? ");
					super.addStringForField(equipmentMcuVO.getCommandIP());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(equipmentMcuVO.getDescription());
				}
				if (Long.MIN_VALUE != equipmentMcuVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(equipmentMcuVO.getRevision());
				}
				//新增加的字段
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getDialingType())) {
					strsql.append(" and dialingType= ? ");
					super.addStringForField(equipmentMcuVO.getDialingType());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getDialingDirection())) {
					strsql.append(" and dialingDirection= ? ");
					super.addStringForField(equipmentMcuVO.getDialingDirection());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getAliasName())) {
					strsql.append(" and aliasName= ? ");
					super.addStringForField(equipmentMcuVO.getAliasName());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getAliasType())) {
					strsql.append(" and aliasType= ? ");
					super.addStringForField(equipmentMcuVO.getAliasType());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getMaxPesolution())) {
					strsql.append(" and maxPesolution= ? ");
					super.addStringForField(equipmentMcuVO.getMaxPesolution());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getCascadeRole())) {
					strsql.append(" and cascadeRole= ? ");
					super.addStringForField(equipmentMcuVO.getCascadeRole());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getAgc())) {
					strsql.append(" and agc= ? ");
					super.addStringForField(equipmentMcuVO.getAgc());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getPtsNumber())) {
					strsql.append(" and ptsNumber= ? ");
					super.addStringForField(equipmentMcuVO.getPtsNumber());
				}
//				if (Integer.MIN_VALUE != equipmentMcuVO.getAllResourceNumber()) {
//					strsql.append(" and allResourceNumber= ? ");
//					super.addIntForField(equipmentMcuVO.getAllResourceNumber());
//				}
//				if (Integer.MIN_VALUE != equipmentMcuVO.getUseResourceNumber()) {
//					strsql.append(" and useResourceNumber= ? ");
//					super.addIntForField(equipmentMcuVO.getUseResourceNumber());
//				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getVideoTreaty())) {
					strsql.append(" and videoTreaty= ? ");
					super.addStringForField(equipmentMcuVO.getVideoTreaty());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getRadioTreaty())) {
					strsql.append(" and radioTreaty= ? ");
					super.addStringForField(equipmentMcuVO.getRadioTreaty());
				}
				if (Integer.MIN_VALUE != equipmentMcuVO.getIsCheck()) {
					strsql.append(" and isCheck= ? ");
					super.addIntForField(equipmentMcuVO.getIsCheck());
				}
				if (!StringUtils.isNullOrBlank(equipmentMcuVO.getSpeed())) {
					strsql.append(" and speed= ? ");
					super.addStringForField(equipmentMcuVO.getSpeed());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTMCU_BY_IDS == _operatorType) {
			if(ids!=null){
				String[] idArray = ids.split(",");
				strsql.append(" and ( ");
				for (int i = 0; i < idArray.length; i++) {
					if (i != 0)
						strsql.append(" or ");
					strsql.append(" equipmentID = '" + idArray[i] + "'");
				}
				strsql.append(" ) ");
			}
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
		if(QUERY_MCU_BY_IPS == _operatorType)
		{
			equipmentMcuVO = new EquipmentMcuVO();
			//equipment
			equipmentMcuVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentMcuVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentMcuVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentMcuVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentMcuVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentMcuVO.setIp(rs.getString("ip"));
			equipmentMcuVO.setPort(rs.getInt("port"));
			//equipment-mcu
			equipmentMcuVO.setParentID(rs.getString("parentID"));
			equipmentMcuVO.setLoginName(rs.getString("loginName"));
			equipmentMcuVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentMcuVO.setCommandIP(rs.getString("CommandIP"));
			equipmentMcuVO.setDescription(rs.getString("description"));
			
			listEquipmentMcu.add(equipmentMcuVO);
		}else{
			equipmentMcuVO = new EquipmentMcuVO();
			equipmentMcuVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentMcuVO.setParentID(rs.getString("parentID"));
			equipmentMcuVO.setLoginName(rs.getString("loginName"));
			equipmentMcuVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentMcuVO.setCommandIP(rs.getString("CommandIP"));
			equipmentMcuVO.setDescription(rs.getString("description"));
			equipmentMcuVO.setRevision(rs.getLong("revision"));
			equipmentMcuVO.setDialingType(rs.getString("dialingType"));
			equipmentMcuVO.setDialingDirection(rs.getString("dialingDirection"));
			equipmentMcuVO.setAliasName(rs.getString("aliasName"));
			equipmentMcuVO.setAliasType(rs.getString("aliasType"));
			equipmentMcuVO.setMaxPesolution(rs.getString("maxPesolution"));
			equipmentMcuVO.setCascadeRole(rs.getString("cascadeRole"));
			equipmentMcuVO.setAgc(rs.getString("agc"));
			equipmentMcuVO.setPtsNumber(rs.getString("ptsNumber"));
			equipmentMcuVO.setAllResourceNumber(rs.getInt("allResourceNumber"));
			equipmentMcuVO.setUseResourceNumber(rs.getInt("useResourceNumber"));
			equipmentMcuVO.setVideoTreaty(rs.getString("videoTreaty"));
			equipmentMcuVO.setRadioTreaty(rs.getString("radioTreaty"));
			equipmentMcuVO.setIsCheck(rs.getInt("isCheck"));
			equipmentMcuVO.setSpeed(rs.getString("speed"));
			listEquipmentMcu.add(equipmentMcuVO);
		}
	}

	public ArrayList<EquipmentMcuVO> getEquipmentMcuList() {
		return listEquipmentMcu;
	}

	public EquipmentMcuVO getEquipmentMcuVO() {
		return equipmentMcuVO;
	}

}
