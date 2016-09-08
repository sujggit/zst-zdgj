package com.zzst.dao.meeting.user;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: User TO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(UserTO.class.getName());

	private int operatorType = -1;

	public static int ADD_USER = 1;

	public static int MODIFY_USER = 2;

	public static int DEL_USER = 3;

	public static int MODIFY_USER_STATUS = 4;
	
	public static int MODIFY_USER_LG = 5;
	
	private int result = 0;

	private UserVO vUserVO;

	public UserTO( int operatorType ){
		this.operatorType = operatorType;
	}
	
	public UserTO(int operatorType, UserVO vUserVO) {
		this.operatorType = operatorType;
		this.vUserVO = vUserVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_USER == operatorType) {
			sqlstr.append("insert into z_t_user ");
			sqlstr.append("(userID,email,loginName,password,fullName,nameSpelling,title,mobile,tel,lastLoginTime,status,description,revision,authenticateType,changePwdTime,errorTimes)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_USER == operatorType) {
			sqlstr.append("update  z_t_user set ");
			sqlstr.append(" email=?,loginName=?,password=?,fullName=?,nameSpelling=?,title=?,mobile=?,tel=?,lastLoginTime=?,status=?,description=?,authenticateType=?,changePwdTime=?,errorTimes=?");
			sqlstr.append(" where userID= ? ");

			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_USER_STATUS == operatorType) {
			sqlstr.append("update  z_t_user set ");
			sqlstr.append(" status=? ");
			sqlstr.append(" where userID= ? ");
			this.sqlStr = sqlstr.toString();
		} else if ( MODIFY_USER_LG == operatorType){
			sqlstr.append("update  z_t_user set ");
			sqlstr.append(" email=?,loginName=?,password=?,fullName=?,mobile=?,status=?");
			sqlstr.append(" where loginName= ? ");
			this.sqlStr = sqlstr.toString();
		}else if ( DEL_USER == operatorType ){
			sqlstr.append("delete from z_t_user where userID != 1");
			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_USER == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vUserVO.getUserID());
				this.stmt.setString(colNum++, vUserVO.getEmail());
				this.stmt.setString(colNum++, vUserVO.getLoginName());
				this.stmt.setString(colNum++, vUserVO.getPassWord());
				this.stmt.setString(colNum++, vUserVO.getName());
				this.stmt.setString(colNum++, vUserVO.getNameSpelling());
				this.stmt.setString(colNum++, vUserVO.getTitle());
				this.stmt.setString(colNum++, vUserVO.getMobile());
				this.stmt.setString(colNum++, vUserVO.getTel());
				this.stmt.setTimestamp(colNum++, vUserVO.getLastLoginTime());
				this.stmt.setInt(colNum++, vUserVO.getState());
				this.stmt.setString(colNum++, vUserVO.getDescription());
				this.stmt.setLong(colNum++, vUserVO.getRevision());
				this.stmt.setInt(colNum++, vUserVO.getAuthenticateType());
				
				this.stmt.setTimestamp(colNum++, vUserVO.getChangePwdTime());
				this.stmt.setInt(colNum++, vUserVO.getErrorTimes());

			} else if (MODIFY_USER == operatorType) {
				int colNum = 1;

				this.stmt.setString(colNum++, vUserVO.getEmail());

				this.stmt.setString(colNum++, vUserVO.getLoginName());

				this.stmt.setString(colNum++, vUserVO.getPassWord());

				this.stmt.setString(colNum++, vUserVO.getName());

				this.stmt.setString(colNum++, vUserVO.getNameSpelling());

				this.stmt.setString(colNum++, vUserVO.getTitle());

				this.stmt.setString(colNum++, vUserVO.getMobile());

				this.stmt.setString(colNum++, vUserVO.getTel());

				this.stmt.setTimestamp(colNum++, vUserVO.getLastLoginTime());

				this.stmt.setInt(colNum++, vUserVO.getState());

				this.stmt.setString(colNum++, vUserVO.getDescription());
				this.stmt.setInt(colNum++, vUserVO.getAuthenticateType());
				
				this.stmt.setTimestamp(colNum++, vUserVO.getChangePwdTime());
				this.stmt.setInt(colNum++, vUserVO.getErrorTimes());

				this.stmt.setString(colNum++, vUserVO.getUserID());

			}else if (MODIFY_USER_STATUS == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vUserVO.getState());
				this.stmt.setString(colNum++, vUserVO.getUserID());
			}else if ( MODIFY_USER_LG == operatorType){
				int colNum = 1;

				this.stmt.setString(colNum++, vUserVO.getEmail());

				this.stmt.setString(colNum++, vUserVO.getLoginName());

				this.stmt.setString(colNum++, vUserVO.getPassWord());

				this.stmt.setString(colNum++, vUserVO.getName());

				this.stmt.setString(colNum++, vUserVO.getMobile());

				this.stmt.setInt(colNum++, vUserVO.getState());


				this.stmt.setString(colNum++, vUserVO.getLoginName());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" USERTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" USERTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
