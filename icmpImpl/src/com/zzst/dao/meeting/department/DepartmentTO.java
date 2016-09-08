package com.zzst.dao.meeting.department;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.department.DepartmentVO;

/**
 * class description: Department TO
 * 
 * @author ryan
 * @date Mon Aug 03 17:54:12 CST 2009
 */

public class DepartmentTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(DepartmentTO.class.getName());

	private int operatorType = -1;

	public static int ADD_DEPARTMENT = 1;

	public static int MODIFY_DEPARTMENT = 2;
    
	public static int DEL_DEPARTMENT = 3;
    public static int MODIFY_TITLE = 4;
    public static int MODIFY_PARENT = 5;
    
    public static int DEL_ALL = 6;
    
	private int result = 0;

	private DepartmentVO vDepartmentVO;

	public DepartmentTO(int operatorType, DepartmentVO vDepartmentVO) {
		this.operatorType = operatorType;
		this.vDepartmentVO = vDepartmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_DEPARTMENT == operatorType) {
			sqlstr.append("insert into z_t_department (id,parentID,name,leaf,linkCodeID) ");
			sqlstr.append(" values (?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_DEPARTMENT == operatorType) {
			sqlstr.append("update  z_t_department set ");
			sqlstr.append(" parentID=?,name=?,leaf=? ,linkcodeid=? where id= ? ");
			this.sqlStr = sqlstr.toString();
		} else if (DEL_DEPARTMENT == operatorType) {
			sqlstr.append("delete  from z_t_department ");
			sqlstr.append(" where id= ? ");
			this.sqlStr = sqlstr.toString();
		}else if(MODIFY_TITLE == operatorType )
		{
			sqlstr.append("update  z_t_department set name=? ,linkcodeid=? where id= ? ");
			this.sqlStr = sqlstr.toString();
		}else if (MODIFY_PARENT == operatorType) {
			sqlstr.append("update  z_t_department set ");
			sqlstr.append(" parentID=? ,linkcodeid=? where id= ? ");
			this.sqlStr = sqlstr.toString();
		}else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete from  z_t_department  ");
			this.sqlStr = sqlstr.toString();
		}
		
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_DEPARTMENT == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++,vDepartmentVO.getId() );
				this.stmt.setString(colNum++, vDepartmentVO.getParentId());
				this.stmt.setString(colNum++, vDepartmentVO.getTitle());
				this.stmt.setInt(colNum++, vDepartmentVO.getLeaf());
				this.stmt.setString(colNum++, vDepartmentVO.getLinkCodeID());
			} else if (MODIFY_DEPARTMENT == operatorType) {
				int colNum = 1;

				this.stmt.setString(colNum++, vDepartmentVO.getParentId());

				this.stmt.setString(colNum++, vDepartmentVO.getTitle());

				this.stmt.setInt(colNum++, vDepartmentVO.getLeaf());
				this.stmt.setString(colNum++, vDepartmentVO.getLinkCodeID());
				this.stmt.setString(colNum++, vDepartmentVO.getId());

			} else if (DEL_DEPARTMENT == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vDepartmentVO.getId());
			} else if(MODIFY_TITLE == operatorType )
			{
				int colNum = 1;

				this.stmt.setString(colNum++, vDepartmentVO.getTitle());
				this.stmt.setString(colNum++, vDepartmentVO.getLinkCodeID());
				this.stmt.setString(colNum++, vDepartmentVO.getId());
			} else if (MODIFY_PARENT == operatorType) {
				int colNum = 1;

				this.stmt.setString(colNum++, vDepartmentVO.getParentId());
				this.stmt.setString(colNum++, vDepartmentVO.getLinkCodeID());
				this.stmt.setString(colNum++, vDepartmentVO.getId());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" DEPARTMENTTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" DEPARTMENTTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
