/**
 * 
 */
package com.zzst.dao.meeting.auth;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleFunc;
import com.zzst.model.meeting.auth.RoleVO;

/**
 * @author zhangliang
 *Apr 19, 2011
 */
public class FuncTO extends TransactionObject {
	
	static Logger logger = CbfLogger.getLogger(FuncTO.class.getName());

	private int operatorType = -1;
	
	public static int ADD_ROLE_FUNC = 1;
	public static int DEL_ROLE_FUNC = 2;
	
	public static int 	ADD_FUNCTION=3;
	public static int 	MODIFY_FUNCTION=4;
	public static int 	DEL_FUNCTION=5;
	
	private int result = 0;
	
	private RoleFunc rolefunc;
	private RoleVO vRoleVO;
	private FuncVO functionVO;
	
	public FuncTO(int  operatorType,RoleFunc rolefunc)
	{
		this.operatorType = operatorType;
		this.rolefunc = rolefunc;
	}
	
	public FuncTO(int operatorType,RoleVO vRoleVO)
	{
		this.operatorType = operatorType;
		this.vRoleVO = vRoleVO;
	}
	
	public FuncTO(int operatorType, FuncVO functionVO) {
		this.operatorType = operatorType;
		this.functionVO = functionVO;
	}


	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if(ADD_ROLE_FUNC == operatorType)
		{
			sqlstr.append("insert into z_t_role_func(roleID,funcID,rid)");
			sqlstr.append("values (?,?,?)");
			this.sqlStr = sqlstr.toString();
		}
		else if (DEL_ROLE_FUNC == operatorType) {
			sqlstr.append("delete from z_t_role_func where roleID = ?");
			this.sqlStr = sqlstr.toString();
		}else if (ADD_FUNCTION == operatorType) {
			sqlstr.append("insert into z_t_function ");
			sqlstr.append("(funcID,funcName,funcURL,parentID,leaf,status,orderNum,description,className,funcNo)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(functionVO.getFunc_id());
			super.addStringForField(functionVO.getFunc_name());
			super.addStringForField(functionVO.getFunc_url());
			super.addStringForField(functionVO.getParent_id());
			super.addIntForField(functionVO.getLeaf());
			super.addIntForField(functionVO.getStatus());
			super.addStringForField(functionVO.getNumber());
			super.addStringForField(functionVO.getDescription());
			super.addStringForField(functionVO.getClassName());
			super.addStringForField(functionVO.getFuncNo());
		} else if (MODIFY_FUNCTION == operatorType) {
			sqlstr.append("update  z_t_function set ");
			sqlstr.append(" funcID = funcID ");

			if (functionVO.getFunc_name() != null) {
				sqlstr.append(" , funcName=? ");
				super.addStringForField(functionVO.getFunc_name());
			}

			if (functionVO.getFunc_url() != null) {
				sqlstr.append(" , funcURL=? ");
				super.addStringForField(functionVO.getFunc_url());
			}

			if (functionVO.getParent_id() != null) {
				sqlstr.append(" , parentID=? ");
				super.addStringForField(functionVO.getParent_id());
			}

			if (functionVO.getLeaf() != Integer.MIN_VALUE) {
				sqlstr.append(" , leaf=?");
				super.addIntForField(functionVO.getLeaf());
			}

			if (functionVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(functionVO.getStatus());
			}

			if (functionVO.getNumber() != null) {
				sqlstr.append(" , orderNum=? ");
				super.addStringForField(functionVO.getNumber());
			}

			if (functionVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(functionVO.getDescription());
			}
			
			if (functionVO.getClassName() != null) {
				sqlstr.append(" , className=? ");
				super.addStringForField(functionVO.getClassName());
			}
			
			if (functionVO.getFuncNo() != null) {
				sqlstr.append(" , funcNo=? ");
				super.addStringForField(functionVO.getFuncNo());
			}

			sqlstr.append(" where funcID in (?) ");
			if (functionVO.getFunc_id() != null) {
				super.addStringForField(functionVO.getFunc_id());
			}
		} else if (DEL_FUNCTION == operatorType) {
			sqlstr.append("delete  from  z_t_function ");
			sqlstr.append(" where funcID in (?) ");
			super.addStringForField(functionVO.getFunc_id());
		}
		this.sqlStr = sqlstr.toString();
	
	}
	
	public void setValues() throws SQLException {
		if (ADD_ROLE_FUNC == operatorType) {
			int colNum = 1;
			this.stmt.setString(colNum++, rolefunc.getRoleID()+"");
			this.stmt.setString(colNum++, rolefunc.getFuncID()+"");
			this.stmt.setString(colNum++, rolefunc.getRid()+"");
		}
		else if(DEL_ROLE_FUNC == operatorType)
		{
			int colNum = 1;
			this.stmt.setString(colNum++, vRoleVO.getRoleID()+"");
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
