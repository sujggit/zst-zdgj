package com.zzst.dao.meeting.configTcip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;

/**
 * class description: ConfigTcip MQB
 * 
 * @date Mon Nov 11 14:59:54 CST 2013
 * @author ryan
 */
public class ConfigTcipMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ConfigTcipMQB.class.getName());

	public static int QUERY_FROM_CONFIGTCIP = 1;
	public static int QUERY_FROM_CONFIGTCIP_BY_IDS = 2;

	private ConfigTcipVO configTcipVO;
	private ArrayList<ConfigTcipVO> listConfigTcip = new ArrayList<ConfigTcipVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ConfigTcipMQB(int operatorType, ConfigTcipVO configTcipVO) {
		_operatorType = operatorType;
		this.configTcipVO = configTcipVO;
		makeSql();
	}

	public ConfigTcipMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,address,name,password,status,portsName ");
		strsql.append(" from z_t_configtcip ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_CONFIGTCIP == _operatorType) {
			if (null != configTcipVO) {
				if (Integer.MIN_VALUE != configTcipVO.getId()) {
					strsql.append(" and id= ? ");
					super.addIntForField(configTcipVO.getId());
				}
				if (!StringUtils.isNullOrBlank(configTcipVO.getAddress())) {
					strsql.append(" and address= ? ");
					super.addStringForField(configTcipVO.getAddress());
				}
				if (!StringUtils.isNullOrBlank(configTcipVO.getName())) {
					strsql.append(" and name= ? ");
					super.addStringForField(configTcipVO.getName());
				}
				if (!StringUtils.isNullOrBlank(configTcipVO.getPassword())) {
					strsql.append(" and password= ? ");
					super.addStringForField(configTcipVO.getPassword());
				}
				if (Integer.MIN_VALUE != configTcipVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(configTcipVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(configTcipVO.getPortsName())) {
					strsql.append(" and portsName= ? ");
					super.addStringForField(configTcipVO.getPortsName());
				}
			}
		} else if (QUERY_FROM_CONFIGTCIP_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
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
		configTcipVO = new ConfigTcipVO();
		configTcipVO.setId(rs.getInt("id"));
		configTcipVO.setAddress(rs.getString("address"));
		configTcipVO.setName(rs.getString("name"));
		configTcipVO.setPassword(rs.getString("password"));
		configTcipVO.setStatus(rs.getInt("status"));
		configTcipVO.setPortsName(rs.getString("portsName"));
		listConfigTcip.add(configTcipVO);
	}

	public ArrayList<ConfigTcipVO> getConfigTcipList() {
		return listConfigTcip;
	}

	public ConfigTcipVO getConfigTcipVO() {
		return configTcipVO;
	}

}
