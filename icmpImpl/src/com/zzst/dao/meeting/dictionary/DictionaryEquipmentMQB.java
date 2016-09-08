package com.zzst.dao.meeting.dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;

/**
 * class description: DictionaryEquipment MQB
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public class DictionaryEquipmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(DictionaryEquipmentMQB.class
			.getName());

	public static int QUERY_FROM_DICTIONARYEQUIPMENT = 1;
	public static int QUERY_FROM_DICTIONARYEQUIPMENT_BY_IDS = 2;
	public static int QUERY_FROM_DICTIONARYEQUIPMENT_BY_PID = 3;
	public static int QUERY_BY_VALUE = 4;
	public static int QUERY_FROM_DICTIONARYEQUIPMENTALL = 5;

	private DictionaryEquipmentVO dictionaryEquipmentVO;
	private ArrayList<DictionaryEquipmentVO> listDictionaryEquipment = new ArrayList<DictionaryEquipmentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public DictionaryEquipmentMQB(int operatorType,
			DictionaryEquipmentVO dictionaryEquipmentVO) {
		_operatorType = operatorType;
		this.dictionaryEquipmentVO = dictionaryEquipmentVO;
		makeSql();
	}

	public DictionaryEquipmentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	public DictionaryEquipmentMQB(int operatorType) {
		_operatorType = operatorType;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select dicID,dicName,parentID,updateTime,updateUser,description,status,dicValue,sysValue ");
		strsql.append(" from z_t_equipment_dictionary ");
		strsql.append(" where 1=1 and status!=0");

		if (QUERY_FROM_DICTIONARYEQUIPMENT == _operatorType) {
			if (null != dictionaryEquipmentVO) {
				if (!StringUtils
						.isNullOrBlank(dictionaryEquipmentVO.getDicID())) {
					strsql.append(" and dicID= ? ");
					super.addStringForField(dictionaryEquipmentVO.getDicID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryEquipmentVO
						.getDicName())) {
					strsql.append(" and dicName= ? ");
					super.addStringForField(dictionaryEquipmentVO.getDicName());
				}
				if (!StringUtils.isNullOrBlank(dictionaryEquipmentVO
						.getParentID())) {
					strsql.append(" and parentID= ? ");
					super
							.addStringForField(dictionaryEquipmentVO
									.getParentID());
				}
				if (!StringUtils.isNullOrBlank(dictionaryEquipmentVO
						.getUpdateUser())) {
					strsql.append(" and updateUser= ? ");
					super.addStringForField(dictionaryEquipmentVO
							.getUpdateUser());
				}
				if (!StringUtils.isNullOrBlank(dictionaryEquipmentVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(dictionaryEquipmentVO
							.getDescription());
				}
				if (Integer.MIN_VALUE != dictionaryEquipmentVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(dictionaryEquipmentVO.getStatus());
				}
				if (Integer.MIN_VALUE != dictionaryEquipmentVO.getDicValue()&& dictionaryEquipmentVO.getDicValue()!=-1) {
					strsql.append(" and dicValue= ? ");
					super.addIntForField(dictionaryEquipmentVO.getDicValue());
				}
				if (Integer.MIN_VALUE != dictionaryEquipmentVO.getSysValue()&& dictionaryEquipmentVO.getSysValue()!=-1) {
					strsql.append(" and sysValue= ? ");
					super.addIntForField(dictionaryEquipmentVO.getSysValue());
				}
			}
		} else if (QUERY_FROM_DICTIONARYEQUIPMENT_BY_IDS == _operatorType) {
			strsql.append(" and dicID in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_FROM_DICTIONARYEQUIPMENT_BY_PID == _operatorType) {
			if (null != dictionaryEquipmentVO) {
				if (!StringUtils.isNullOrBlank(dictionaryEquipmentVO
						.getParentID())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(dictionaryEquipmentVO.getParentID());
				}
			}
		} else if (QUERY_BY_VALUE == _operatorType) {
			strsql = new StringBuffer();
			strsql.append("select dicID,dicName,parentID,updateTime,updateUser,description,status,dicValue,sysValue ");
			strsql.append(" FROM z_t_equipment_dictionary WHERE 1=1 ");
			if (null != dictionaryEquipmentVO) {
				if (Integer.MIN_VALUE != dictionaryEquipmentVO.getDicValue()) {
					strsql.append(" and dicValue= ? ");
					super.addIntForField(dictionaryEquipmentVO.getDicValue());
				}
			}
			strsql.append(" and status!=0 ");
		}else if (QUERY_FROM_DICTIONARYEQUIPMENTALL == _operatorType) {
			strsql = new StringBuffer();
			strsql.append("select dicID,dicName,parentID,updateTime,updateUser,description,status,dicValue,sysValue ");
			strsql.append(" from z_t_equipment_dictionary ");
			strsql.append(" where 1=1 ");
			if (Integer.MIN_VALUE != dictionaryEquipmentVO.getStatus()) {
				strsql.append(" and status= ? ");
				super.addIntForField(dictionaryEquipmentVO.getStatus());
			}
			if (Integer.MIN_VALUE != dictionaryEquipmentVO.getSysValue()&& dictionaryEquipmentVO.getSysValue()!=-1) {
				strsql.append(" and sysValue= ? ");
				super.addIntForField(dictionaryEquipmentVO.getSysValue());
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
		dictionaryEquipmentVO = new DictionaryEquipmentVO();
		dictionaryEquipmentVO.setDicID(rs.getString("dicID"));
		dictionaryEquipmentVO.setDicName(rs.getString("dicName"));
		dictionaryEquipmentVO.setParentID(rs.getString("parentID"));
		dictionaryEquipmentVO.setUpdateTime(rs.getTimestamp("updateTime"));
		dictionaryEquipmentVO.setUpdateUser(rs.getString("updateUser"));
		dictionaryEquipmentVO.setDescription(rs.getString("description"));
		dictionaryEquipmentVO.setStatus(rs.getInt("status"));
		dictionaryEquipmentVO.setDicValue(rs.getInt("dicValue"));
		dictionaryEquipmentVO.setSysValue(rs.getInt("sysValue"));
		listDictionaryEquipment.add(dictionaryEquipmentVO);
	}

	public ArrayList<DictionaryEquipmentVO> getDictionaryEquipmentList() {
		return listDictionaryEquipment;
	}

	public DictionaryEquipmentVO getDictionaryEquipmentVO() {
		return dictionaryEquipmentVO;
	}

}
