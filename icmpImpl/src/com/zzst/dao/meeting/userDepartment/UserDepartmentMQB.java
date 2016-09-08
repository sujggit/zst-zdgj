package com.zzst.dao.meeting.userDepartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;

/**
 * class description: UserDepartment MQB
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDepartmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(UserDepartmentMQB.class
			.getName());

	public static int QUERY_FROM_USERDEPARTMENT = 1;

//	public static int QUERY_FROM_USERDEPARTMENTBYOTHER = 2;
	
	private UserDepartmentVO vUserDepartmentVO;

	private ArrayList<UserDepartmentVO> lstUserDepartment = new ArrayList<UserDepartmentVO>();

	private int _operatorType = -1;

	public UserDepartmentMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {

		if (QUERY_FROM_USERDEPARTMENT == _operatorType) {
			vUserDepartmentVO = new UserDepartmentVO();
			UserVO vUserVO = new UserVO();
			vUserVO.setUserID(rs.getString("userID"));
			vUserVO.setEmail(rs.getString("email"));
			vUserVO.setLoginName(rs.getString("loginName"));
			vUserVO.setPassWord(rs.getString("password"));
			vUserVO.setName(rs.getString("name"));
			vUserVO.setNameSpelling(rs.getString("nameSpelling"));
			vUserVO.setTitle(rs.getString("title"));
			vUserVO.setMobile(rs.getString("mobile"));
			vUserVO.setTel(rs.getString("tel"));
			vUserVO.setLastLoginTime(rs.getTimestamp("lastLoginTime"));
			vUserVO.setState(rs.getInt("state"));
			vUserVO.setDescription(rs.getString("description"));
			vUserVO.setRevision(rs.getLong("userRevision"));
			vUserDepartmentVO.setUserVO(vUserVO);
			
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setId(rs.getString("departmentID"));
			departmentVO.setTitle(rs.getString("departmentName"));
			vUserDepartmentVO.setDepartmentVO(departmentVO);
			
			vUserDepartmentVO.setUserDepartmentID(rs.getInt("userDepartmentID"));
			vUserDepartmentVO.setCorpID(rs.getInt("corpID"));
			vUserDepartmentVO.setCorpName(rs.getString("corpName"));
			vUserDepartmentVO.setRevision(rs.getLong("userDepartmentRevision"));
			lstUserDepartment.add(vUserDepartmentVO);
		}
	}

	public ArrayList<UserDepartmentVO> getUserDepartmentList() {
		return lstUserDepartment;

	}

	public UserDepartmentVO getUserDepartmentVO() {
		return vUserDepartmentVO;
	}

}
