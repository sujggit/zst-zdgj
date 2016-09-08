package com.zzst.dao.meeting.userRole;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: UserRole TO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserRoleTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(UserRoleTO.class.getName());

	private int operatorType = -1;

	public static int  ADD_USERROLE = 1;
	public static int  DEL_USERROLE = 2;
	public static int  DEL_ALL = 3;
	public static int DEL_USERROLE_TWO = 4;
	
	private int result = 0;

	private UserRoleVO vUserRoleVO;
	private UserVO userVO;
	
	public UserRoleTO(int operatorType) {
		this.operatorType = operatorType;
	}

	public UserRoleTO(int operatorType, UserRoleVO vUserRoleVO) {
		this.operatorType = operatorType;
		this.vUserRoleVO = vUserRoleVO;
	}
	
	public UserRoleTO(int operatorType, UserVO userVO) {
		this.operatorType = operatorType;
		this.userVO = userVO;
	}
	
	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		 if (DEL_USERROLE == operatorType) {			
			sqlstr.append("delete from z_t_user_role where userID= ?");	
			this.sqlStr = sqlstr.toString();
		}else if(ADD_USERROLE == operatorType)
		{
			sqlstr.append("insert into z_t_user_role(roleID,userID,uid) values(?,?,?)");	
			this.sqlStr = sqlstr.toString();
		}else if(DEL_ALL == operatorType){
			sqlstr.append("delete from z_t_user_role where userID != 1");	
			this.sqlStr = sqlstr.toString();
		}else if(DEL_USERROLE_TWO == operatorType){
			sqlstr.append("delete from z_t_user_role where userID= ?");	
			if(vUserRoleVO.getRoleID()!=null){
				sqlstr.append(" and roleID = ?");
			}
			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_USERROLE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vUserRoleVO.getRoleID());
				this.stmt.setString(colNum++, vUserRoleVO.getUserID());	
				this.stmt.setString(colNum++, vUserRoleVO.getUid());

			} else if (DEL_USERROLE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, userVO.getUserID());			
			}else if (DEL_USERROLE_TWO == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vUserRoleVO.getUserID());
				if(vUserRoleVO.getRoleID()!=null){
				this.stmt.setString(colNum++, vUserRoleVO.getRoleID());	
				}
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" USERROLETO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" USERROLETO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
