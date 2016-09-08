package com.zzst.dao.meeting.userDepartment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;

/**
 * class description: UserDepartment TO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDepartmentTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(UserDepartmentTO.class.getName());

	private int operatorType = -1;

	public static int ADD_USERDEPARTMENT = 1;

	public static int MODIFY_USERDEPARTMENT = 2;

	public static int DEL_USERDEPARTMENT = 3;
	
	public static int DEL_ALL;

	private int result = 0;

	private UserDepartmentVO vUserDepartmentVO;
	
	public UserDepartmentTO(int operatorType) {
		this.operatorType = operatorType;
	}

	public UserDepartmentTO(int operatorType, UserDepartmentVO vUserDepartmentVO) {
		this.operatorType = operatorType;
		this.vUserDepartmentVO = vUserDepartmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_USERDEPARTMENT == operatorType) {
			sqlstr.append("insert into z_t_department_user ");
			sqlstr.append("(departmentID,userID,revision)");
			sqlstr.append(" values (?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_USERDEPARTMENT == operatorType) {
			sqlstr.append("update  z_t_department_user set ");
			sqlstr.append(" departmentID=? where userID=?");	

			this.sqlStr = sqlstr.toString();
		} else if (DEL_USERDEPARTMENT == operatorType) {
			sqlstr.append("delete  from z_t_department_user ");
			sqlstr.append(" where departmentID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if( DEL_ALL == operatorType){
			sqlstr.append("delete  from z_t_department_user where userID != 1 ");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_USERDEPARTMENT == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vUserDepartmentVO.getDepartmentVO().getId());
				this.stmt.setString(colNum++, vUserDepartmentVO.getUserVO().getUserID());
				this.stmt.setLong(colNum++, vUserDepartmentVO.getRevision());

			} else if (MODIFY_USERDEPARTMENT == operatorType) {
				int colNum = 1;

				this.stmt.setString(colNum++, vUserDepartmentVO.getUserVO().getDepartmentVO().getId());
				this.stmt.setString(colNum++, vUserDepartmentVO.getUserVO().getUserID());

			} else if (DEL_USERDEPARTMENT == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vUserDepartmentVO.getDepartmentVO().getId());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" USERDEPARTMENTTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" USERDEPARTMENTTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
