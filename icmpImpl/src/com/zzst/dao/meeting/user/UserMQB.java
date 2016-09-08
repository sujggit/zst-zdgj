package com.zzst.dao.meeting.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: User MQB
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserMQB extends MasterQueryObject {

	static Logger logger = CbfLogger.getLogger(UserMQB.class.getName());

	public static int QUERY_FROM_USER = 1;
	public static int QUERY_FROM_USER_1 = 2;
	public static int QUERY_FROM_USER_2 = 3;
	public static int QUERY_FROM_USER_3 = 4;
	
	private UserVO vUserVO;

	private ArrayList<UserVO> lstUser = new ArrayList<UserVO>();

	private int _operatorType = -1;

	public UserMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_USER == _operatorType) {
			vUserVO = new UserVO();
			vUserVO.setUserID(rs.getString("userID"));
			vUserVO.setEmail(rs.getString("email"));
			vUserVO.setLoginName(rs.getString("loginName"));
			vUserVO.setPassWord(rs.getString("password"));
			vUserVO.setName(rs.getString("fullName"));
			vUserVO.setNameSpelling(rs.getString("nameSpelling"));	
			vUserVO.setMobile(rs.getString("mobile"));
			vUserVO.setLastLoginTime(rs.getTimestamp("lastLoginTime"));
			vUserVO.setState(rs.getInt("status"));
			vUserVO.setDescription(rs.getString("description"));
			vUserVO.getDepartmentVO().setId(rs.getString("id"));
			vUserVO.getDepartmentVO().setTitle(rs.getString("name"));
			vUserVO.setAuthenticateType(rs.getInt("authenticateType"));
			vUserVO.setChangePwdTime(rs.getTimestamp("changePwdTime"));
			vUserVO.setErrorTimes(rs.getInt("errorTimes"));
			lstUser.add(vUserVO);
		}else if( QUERY_FROM_USER_1 ==  _operatorType){
			vUserVO = new UserVO();
			vUserVO.setUserID(rs.getString("userID"));
			vUserVO.setName(rs.getString("fullName"));
			lstUser.add(vUserVO);
		}else if( QUERY_FROM_USER_2 == _operatorType){
			vUserVO = new UserVO();
			vUserVO.getDepartmentVO().setId(rs.getString("departmentID"));
			vUserVO.setUserID(rs.getString("userID"));
			vUserVO.setEmail(rs.getString("email"));
			vUserVO.setLoginName(rs.getString("loginName"));
			vUserVO.setPassWord(rs.getString("password"));
			vUserVO.setName(rs.getString("fullName"));	
			vUserVO.setNameSpelling(rs.getString("nameSpelling"));
			vUserVO.setMobile(rs.getString("mobile"));
			vUserVO.setLastLoginTime(rs.getTimestamp("lastLoginTime"));
			vUserVO.setState(rs.getInt("status"));
			vUserVO.setDescription(rs.getString("description"));
			lstUser.add(vUserVO);
		}else if( QUERY_FROM_USER_3 == _operatorType){
			vUserVO = new UserVO();
			vUserVO.getDepartmentVO().setId(rs.getString("departmentID"));
			vUserVO.getDepartmentVO().setTitle("name");
			vUserVO.setUserID(rs.getString("userID"));
			vUserVO.setEmail(rs.getString("email"));
			vUserVO.setLoginName(rs.getString("loginName"));
			vUserVO.setPassWord(rs.getString("password"));
			vUserVO.setName(rs.getString("fullName"));	
			vUserVO.setNameSpelling(rs.getString("nameSpelling"));
			vUserVO.setMobile(rs.getString("mobile"));
			vUserVO.setLastLoginTime(rs.getTimestamp("lastLoginTime"));
			vUserVO.setState(rs.getInt("status"));
			vUserVO.setDescription(rs.getString("description"));
			vUserVO.getPostVO().setPostNO(rs.getString("postNO"));
			vUserVO.getPostVO().setPostName(rs.getString("postName"));
			lstUser.add(vUserVO);
		}

	}

	public ArrayList<UserVO> getUserList() {
		return lstUser;

	}

	public UserVO getUserVO() {
		return vUserVO;
	}

}
