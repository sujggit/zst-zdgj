package com.zzst.dao.meeting.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.auth.RoleVO;

/**
 * class description: Role MQB
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:46 CST 2009
 */

public class RoleMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(RoleMQB.class.getName());

	public static int QUERY_FROM_ROLE = 1;

	private RoleVO vRoleVO;

	private ArrayList<RoleVO> lstRole = new ArrayList<RoleVO>();

	private int _operatorType = -1;

	public RoleMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_ROLE == _operatorType) {
			vRoleVO = new RoleVO();
			vRoleVO.setRoleID(rs.getString("role_id"));
			vRoleVO.setRoleName(rs.getString("role_name"));
			vRoleVO.setCreate_date(rs.getString("create_date"));
			vRoleVO.setCreate_by(rs.getString("create_by"));
			vRoleVO.setStatus(rs.getString("status"));
			vRoleVO.setNote(rs.getString("note"));
			vRoleVO.setCount(rs.getInt("cc"));
			vRoleVO.setUserNames(rs.getString("userNames"));
			lstRole.add(vRoleVO);
		}

	}

	public ArrayList<RoleVO> getRoleList() {
		return lstRole;

	}

	public RoleVO getRoleVO() {
		return vRoleVO;
	}

}
