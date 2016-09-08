package com.zzst.dao.meeting.equipment;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;

/**
 * class description: EquipmentGroup MQB
 * 
 * @date Thu Apr 24 11:27:32 CST 2014
 * @author ryan
 */
public class EquipmentGroupMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentGroupMQB.class
			.getName());

	public static int QUERY_FROM_EQUIPMENTGROUP = 1;
	public static int QUERY_FROM_EQUIPMENTGROUP_BY_IDS = 2;
	public static int QUERY_FROM_EQUIPMENTGROUP_BY_FUZZYSEARCH = 3;
	public static int QUERY_FROM_EQUIPMENTGROUP_group = 4;
	public static int QUERY_FROM_EQUIPMENTGROUP_GROUPNAME = 5;
	private EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
	private ArrayList<EquipmentGroupVO> listEquipmentGroup = new ArrayList<EquipmentGroupVO>();

	private int _operatorType = -1;

	public EquipmentGroupMQB(int operatorType, EquipmentGroupVO equipmentGroupVO) {
		_operatorType = operatorType;
		this.equipmentGroupVO = equipmentGroupVO;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,groupname,equipmentID,status,description,rank ");
		strsql.append(" from z_t_equipment_group ");
		strsql.append(" where 1=1 and status = "+EquipmentGroupVO.STATUS_VALID);

		if (QUERY_FROM_EQUIPMENTGROUP == _operatorType) {
			if (null != equipmentGroupVO) {
				if (!StringUtils.isNullOrBlank(equipmentGroupVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(equipmentGroupVO.getId());
				}
				if (!StringUtils.isNullOrBlank(equipmentGroupVO.getGroupname())) {
					strsql.append(" and groupname= ? ");
					super.addStringForField(equipmentGroupVO.getGroupname());
				}
				if (!StringUtils.isNullOrBlank(equipmentGroupVO
						.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(equipmentGroupVO.getEquipmentID());
				}
				if (Integer.MIN_VALUE != equipmentGroupVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(equipmentGroupVO.getStatus());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTGROUP_BY_IDS == _operatorType) {
			String[] idArray = equipmentGroupVO.getId().split(",");
			strsql.append(" and ( ");
			for (int i = 0; i < idArray.length; i++) {
				if (i != 0)
					strsql.append(" or ");
				strsql.append(" id = '" + idArray[i] + "'");
			}
			strsql.append(" ) ");
		}else if (QUERY_FROM_EQUIPMENTGROUP_group == _operatorType) {
			strsql.append(" group by groupname");
		}else if (QUERY_FROM_EQUIPMENTGROUP_GROUPNAME == _operatorType) {
			if(null != equipmentGroupVO){
				if (!StringUtils.isNullOrBlank(equipmentGroupVO.getGroupname())) {
					strsql.append(" and groupname like  '%"+equipmentGroupVO.getGroupname()+"%'");
				}
			}
			strsql.append(" group by groupname");
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
		equipmentGroupVO = new EquipmentGroupVO();
		equipmentGroupVO.setId(rs.getString("id"));
		equipmentGroupVO.setGroupname(rs.getString("groupname"));
		equipmentGroupVO.setEquipmentID(rs.getString("equipmentID"));
		equipmentGroupVO.setStatus(rs.getInt("status"));
		equipmentGroupVO.setDescription(rs.getString("description"));
		equipmentGroupVO.setRank(rs.getString("rank"));
		listEquipmentGroup.add(equipmentGroupVO);
	}

	public ArrayList<EquipmentGroupVO> getEquipmentGroupList() {
		return listEquipmentGroup;
	}

	public EquipmentGroupVO getEquipmentGroupVO() {
		return equipmentGroupVO;
	}

}
