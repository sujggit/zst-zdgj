package com.zzst.dao.meeting.mcuCascadeModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;

/**
 * class description:	McuCascadeModel MQB
 * @date Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public class McuCascadeModelMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(McuCascadeModelMQB.class
			.getName());

	public static int QUERY_FROM_MCUCASCADEMODEL = 1;
	public static int QUERY_FROM_MCUCASCADEMODEL_BY_IDS = 2;
	public static int QUERY_FROM_MCUCASCADEMODEL_BACK = 3;
	public static int QUERY_FROM_MCUCASCADEMODEL_BY_MCUIP = 4;
	
	private McuCascadeModelVO mcuCascadeModelVO;
	private ArrayList<McuCascadeModelVO> listMcuCascadeModel = new ArrayList<McuCascadeModelVO>();

	private int _operatorType = -1;
	private String ids = "";

	public McuCascadeModelMQB(int operatorType,
			McuCascadeModelVO mcuCascadeModelVO) {
		_operatorType = operatorType;
		this.mcuCascadeModelVO = mcuCascadeModelVO;
		makeSql();
	}

	public McuCascadeModelMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select zm.CascadeID,zm.cascadeName,zm.mcuName,zm.mcuIp,zm.modelID,zm.modelName,zm.createUserID,zm.createDate,zm.status,zm.description ,zm.confModel,ze.equipmentNO");
		strsql.append(" from z_t_mcucascademodel zm inner join   z_t_equipment ze on zm.description=ze.equipmentID    ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MCUCASCADEMODEL == _operatorType) {
			if (null != mcuCascadeModelVO) {
				if (!StringUtils
						.isNullOrBlank(mcuCascadeModelVO.getCascadeID())) {
					strsql.append(" and zm.CascadeID= ? ");
					super.addStringForField(mcuCascadeModelVO.getCascadeID());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getCascadeName())) {
					strsql.append(" and zm.cascadeName LIKE '%" + mcuCascadeModelVO.getCascadeName().trim() + "%'");
					//super.addStringForField(mcuCascadeModelVO.getCascadeName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getMcuName())) {
					strsql.append(" and zm.mcuName= ? ");
					super.addStringForField(mcuCascadeModelVO.getMcuName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getMcuIp())) {
					strsql.append(" and zm.mcuIp= ? ");
					super.addStringForField(mcuCascadeModelVO.getMcuIp());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getModelID())) {
					strsql.append(" and zm.modelID = ? ");
					super.addStringForField(mcuCascadeModelVO.getModelID());
				}
				if (!StringUtils
						.isNullOrBlank(mcuCascadeModelVO.getModelName())) {
					strsql.append(" and zm.modelName= ? ");
					super.addStringForField(mcuCascadeModelVO.getModelName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getCreateUserID())) {
					strsql.append(" and zm.createUserID= ? ");
					super
							.addStringForField(mcuCascadeModelVO
									.getCreateUserID());
				}
				if (Integer.MIN_VALUE != mcuCascadeModelVO.getStatus()) {
					strsql.append(" and ze.status= ? ");
					super.addIntForField(mcuCascadeModelVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getDescription())) {
					strsql.append(" and zm.description= ? ");
					super.addStringForField(mcuCascadeModelVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getConfModel())) {
					strsql.append(" and zm.confModel= ? ");
					super.addStringForField(mcuCascadeModelVO.getConfModel());
				}
			}
		} else if (QUERY_FROM_MCUCASCADEMODEL_BACK == _operatorType) {
			strsql = new StringBuffer();
			strsql.append("select zm.CascadeID,zm.cascadeName,zm.mcuName,zm.mcuIp,zm.modelID,zm.modelName,zm.createUserID,zm.createDate,zm.status,zm.description ,zm.confModel,zm.modelName as 'equipmentNO'");
			strsql.append(" from z_t_mcucascademodel zm ");
			strsql.append(" where 1=1 ");
			if (null != mcuCascadeModelVO) {
				if (!StringUtils
						.isNullOrBlank(mcuCascadeModelVO.getCascadeID())) {
					strsql.append(" and zm.CascadeID= ? ");
					super.addStringForField(mcuCascadeModelVO.getCascadeID());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getCascadeName())) {
					strsql.append(" and zm.cascadeName LIKE '%" + mcuCascadeModelVO.getCascadeName().trim() + "%'");
					//super.addStringForField(mcuCascadeModelVO.getCascadeName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getMcuName())) {
					strsql.append(" and zm.mcuName= ? ");
					super.addStringForField(mcuCascadeModelVO.getMcuName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getMcuIp())) {
					strsql.append(" and zm.mcuIp= ? ");
					super.addStringForField(mcuCascadeModelVO.getMcuIp());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO.getModelID())) {
					strsql.append(" and zm.modelID like ? ");
					super.addStringForField(mcuCascadeModelVO.getModelID());
				}
				if (!StringUtils
						.isNullOrBlank(mcuCascadeModelVO.getModelName())) {
					strsql.append(" and zm.modelName= ? ");
					super.addStringForField(mcuCascadeModelVO.getModelName());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getCreateUserID())) {
					strsql.append(" and zm.createUserID= ? ");
					super.addStringForField(mcuCascadeModelVO
									.getCreateUserID());
				}
				if (Integer.MIN_VALUE != mcuCascadeModelVO.getStatus()) {
					strsql.append(" and zm.status= ? ");
					super.addIntForField(mcuCascadeModelVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getDescription())) {
					strsql.append(" and zm.description= ? ");
					super.addStringForField(mcuCascadeModelVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(mcuCascadeModelVO
						.getConfModel())) {
					strsql.append(" and zm.confModel= ? ");
					super.addStringForField(mcuCascadeModelVO.getConfModel());
				}
			}
		} else if (QUERY_FROM_MCUCASCADEMODEL_BY_IDS == _operatorType) {
			strsql.append(" and CascadeID in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_FROM_MCUCASCADEMODEL_BY_MCUIP == _operatorType) {
			strsql.append(" and mcuip like (%"+mcuCascadeModelVO.getMcuIp()+"%) ");
			super.addStringForField(ids);
		}
		
		strsql.append("order by zm.createDate desc");
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		mcuCascadeModelVO = new McuCascadeModelVO();
		mcuCascadeModelVO.setCascadeID(rs.getString("CascadeID"));
		mcuCascadeModelVO.setCascadeName(rs.getString("cascadeName"));
		mcuCascadeModelVO.setMcuName(rs.getString("mcuName"));
		mcuCascadeModelVO.setMcuIp(rs.getString("mcuIp"));
		mcuCascadeModelVO.setModelID(rs.getString("modelID"));
		mcuCascadeModelVO.setModelName(rs.getString("modelName"));
		mcuCascadeModelVO.setCreateUserID(rs.getString("createUserID"));
		mcuCascadeModelVO.setCreateDate(rs.getTimestamp("createDate"));
		mcuCascadeModelVO.setStatus(rs.getInt("status"));
		mcuCascadeModelVO.setDescription(rs.getString("description"));
		mcuCascadeModelVO.setEquipmentNO(rs.getString("equipmentNO"));
		mcuCascadeModelVO.setConfModel(rs.getString("confModel"));
		listMcuCascadeModel.add(mcuCascadeModelVO);
	}

	public ArrayList<McuCascadeModelVO> getMcuCascadeModelList() {
		return listMcuCascadeModel;
	}

	public McuCascadeModelVO getMcuCascadeModelVO() {
		return mcuCascadeModelVO;
	}

}
