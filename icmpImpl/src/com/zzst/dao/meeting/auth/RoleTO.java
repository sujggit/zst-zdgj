package com.zzst.dao.meeting.auth;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.auth.RoleVO;

/**
 * class description: Role TO
 * 
 * @author ryan
 * modify by zhangliang@2011-4-14
 * @date Mon Aug 03 18:32:46 CST 2009
 */

public class RoleTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(RoleTO.class.getName());

	private int operatorType = -1;

	public static int ADD_ROLE = 1;

	public static int MODIFY_ROLE = 2;

	public static int DEL_ROLE = 3;

	private int result = 0;

	private RoleVO vRoleVO;

	public RoleTO(int operatorType, RoleVO vRoleVO) {
		this.operatorType = operatorType;
		this.vRoleVO = vRoleVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_ROLE == operatorType) {
			sqlstr.append("insert into z_t_role ");
			sqlstr.append("(role_id,role_name,create_date,create_by,note,status)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_ROLE == operatorType) {
			sqlstr.append("update  z_t_role set ");
			sqlstr.append(" role_name=?,note=?");
			sqlstr.append(" where role_id= ? ");

			this.sqlStr = sqlstr.toString();
		} else if (DEL_ROLE == operatorType) {
			sqlstr.append("delete from  z_t_role ");
			sqlstr.append(" where role_id= ? ");
			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_ROLE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vRoleVO.getRoleID());
				this.stmt.setString(colNum++, vRoleVO.getRoleName());
				this.stmt.setString(colNum++, vRoleVO.getCreate_date());
				this.stmt.setString(colNum++, vRoleVO.getCreate_by());
				this.stmt.setString(colNum++, vRoleVO.getNote());
				this.stmt.setString(colNum++, vRoleVO.getStatus());
			} else if (MODIFY_ROLE == operatorType) {
				int colNum = 1;

				this.stmt.setString(colNum++, vRoleVO.getRoleName());

				this.stmt.setString(colNum++, vRoleVO.getNote());

				this.stmt.setString(colNum++, vRoleVO.getRoleID());

			}else if (DEL_ROLE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vRoleVO.getRoleID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}
	}

	public void execute() throws SQLException {
		logger.info(" ROLETO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" ROLETO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
