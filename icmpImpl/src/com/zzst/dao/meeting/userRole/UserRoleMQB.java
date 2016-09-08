package com.zzst.dao.meeting.userRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: UserRole MQB
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserRoleMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(UserRoleMQB.class.getName());

	public static int QUERY_FROM_USERROLE = 1;
    public static int QUERY_FROM_ROLEUSER = 2;
	
	private UserRoleVO vUserRoleVO;

	private ArrayList<UserRoleVO> lstUserRole = new ArrayList<UserRoleVO>();

	private int _operatorType = -1;

	public UserRoleMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_USERROLE == _operatorType) {
			vUserRoleVO = new UserRoleVO();
			vUserRoleVO.setUserID(rs.getString("userID"));
			vUserRoleVO.setRoleID(rs.getString("roleID"));
			lstUserRole.add(vUserRoleVO);
		}else if(QUERY_FROM_ROLEUSER == _operatorType)
		{
			vUserRoleVO = new UserRoleVO();

			vUserRoleVO.setUserID(rs.getString("userID"));
			lstUserRole.add(vUserRoleVO);
		}

	}

	public ArrayList<UserRoleVO> getUserRoleList() {
		return lstUserRole;

	}

	public UserRoleVO getUserRoleVO() {
		return vUserRoleVO;
	}

}
