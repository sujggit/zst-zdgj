package com.zzst.dao.meeting.configTcip;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;

/**
 * class description: ConfigTcip TO
 * 
 * @date Mon Nov 11 14:59:54 CST 2013
 * @author ryan
 */
public class ConfigTcipTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ConfigTcipTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_CONFIGTCIP = 1;
	public static int MODIFY_CONFIGTCIP = 2;
	public static int DEL_CONFIGTCIP = 3;
	private int result = 0;

	private ConfigTcipVO configTcipVO;

	public ConfigTcipTO(int operatorType, ConfigTcipVO configTcipVO) {
		this.operatorType = operatorType;
		this.configTcipVO = configTcipVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_CONFIGTCIP == operatorType) {
			sqlstr.append("insert into z_t_configtcip ");
			sqlstr.append("(id,address,name,password,status,portsName)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			super.addIntForField(configTcipVO.getId());
			super.addStringForField(configTcipVO.getAddress());
			super.addStringForField(configTcipVO.getName());
			super.addStringForField(configTcipVO.getPassword());
			super.addIntForField(configTcipVO.getStatus());
			super.addStringForField(configTcipVO.getPortsName());
		} else if (MODIFY_CONFIGTCIP == operatorType) {
			sqlstr.append("update  z_t_configtcip set ");
			sqlstr.append(" id = id ");

			if (configTcipVO.getAddress() != null) {
				sqlstr.append(" , address=? ");
				super.addStringForField(configTcipVO.getAddress());
			}

			if (configTcipVO.getName() != null) {
				sqlstr.append(" , name=? ");
				super.addStringForField(configTcipVO.getName());
			}

			if (configTcipVO.getPassword() != null) {
				sqlstr.append(" , password=? ");
				super.addStringForField(configTcipVO.getPassword());
			}

			if (configTcipVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(configTcipVO.getStatus());
			}

			if (configTcipVO.getPortsName() != null) {
				sqlstr.append(" , portsName=? ");
				super.addStringForField(configTcipVO.getPortsName());
			}

			sqlstr.append(" where id in (?) ");
			if (configTcipVO.getId() != Integer.MIN_VALUE) {
				super.addIntForField(configTcipVO.getId());
			}
		} else if (DEL_CONFIGTCIP == operatorType) {
			sqlstr.append("delete  from  z_t_configtcip ");
			sqlstr.append(" where id in (?) ");
			super.addIntForField(configTcipVO.getId());
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
