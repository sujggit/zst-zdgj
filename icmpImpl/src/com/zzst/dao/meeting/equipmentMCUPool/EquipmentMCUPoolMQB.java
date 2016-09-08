package com.zzst.dao.meeting.equipmentMCUPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.equipmentMCUPool.EquipmentMCUPoolVO;

/**
 * class description: EquipmentMCUPool MQB
 * 
 * @date Thu Jan 31 09:29:38 CST 2013
 * @author ryan
 */
public class EquipmentMCUPoolMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentMCUPoolMQB.class
			.getName());

	public static int QUERY_FROM_EQUIPMENTMCUPOOL = 1;
	public static int QUERY_FROM_EQUIPMENTMCUPOOL_BY_IDS = 2;

	private EquipmentMCUPoolVO equipmentMCUPoolVO;
	private ArrayList<EquipmentMCUPoolVO> listEquipmentMCUPool = new ArrayList<EquipmentMCUPoolVO>();

	private int _operatorType = -1;
	private String ids = "";

	public EquipmentMCUPoolMQB(int operatorType,
			EquipmentMCUPoolVO equipmentMCUPoolVO) {
		_operatorType = operatorType;
		this.equipmentMCUPoolVO = equipmentMCUPoolVO;
		makeSql();
	}

	public EquipmentMCUPoolMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select equipmentID,resourceNum,weight,useNum,status ");
		strsql.append(" from z_t_equipment_MCU_pool ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_EQUIPMENTMCUPOOL == _operatorType) {
			if (null != equipmentMCUPoolVO) {
				if (!StringUtils.isNullOrBlank(equipmentMCUPoolVO
						.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super
							.addStringForField(equipmentMCUPoolVO
									.getEquipmentID());
				}
				if (Integer.MIN_VALUE != equipmentMCUPoolVO.getResourceNum()) {
					strsql.append(" and resourceNum= ? ");
					super.addIntForField(equipmentMCUPoolVO.getResourceNum());
				}
				if (Integer.MIN_VALUE != equipmentMCUPoolVO.getWeight()) {
					strsql.append(" and weight= ? ");
					super.addIntForField(equipmentMCUPoolVO.getWeight());
				}
				if (Integer.MIN_VALUE != equipmentMCUPoolVO.getUseNum()) {
					strsql.append(" and useNum= ? ");
					super.addIntForField(equipmentMCUPoolVO.getUseNum());
				}
				if (Integer.MIN_VALUE != equipmentMCUPoolVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(equipmentMCUPoolVO.getStatus());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTMCUPOOL_BY_IDS == _operatorType) {
			strsql.append(" and equipmentID in (?) ");
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
		equipmentMCUPoolVO = new EquipmentMCUPoolVO();
		equipmentMCUPoolVO.setEquipmentID(rs.getString("equipmentID"));
		equipmentMCUPoolVO.setResourceNum(rs.getInt("resourceNum"));
		equipmentMCUPoolVO.setWeight(rs.getInt("weight"));
		equipmentMCUPoolVO.setUseNum(rs.getInt("useNum"));
		equipmentMCUPoolVO.setStatus(rs.getInt("status"));
		listEquipmentMCUPool.add(equipmentMCUPoolVO);
	}

	public ArrayList<EquipmentMCUPoolVO> getEquipmentMCUPoolList() {
		return listEquipmentMCUPool;
	}

	public EquipmentMCUPoolVO getEquipmentMCUPoolVO() {
		return equipmentMCUPoolVO;
	}

}
