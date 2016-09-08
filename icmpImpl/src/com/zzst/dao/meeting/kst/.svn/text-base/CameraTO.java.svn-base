/**
 * 
 */
package com.zzst.dao.meeting.kst;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.kst.CameraGroup;

/**
 * @author zhangliang
 * Mar 27, 2012 4:25:45 PM
 */
public class CameraTO extends TransactionObject {
	
	static Logger logger = CbfLogger.getLogger(CameraTO.class.getName());

	private int operatorType = -1;

	public static int ADD_CAMERA = 1;
	public static int DEL_CAMERA = 3;
	
	private CameraGroup group ; 
	private int result = 0;
	
	public CameraTO(int operatorType,CameraGroup group)
	{
		this.operatorType = operatorType;
		this.group = group;
	}
	
	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_CAMERA == operatorType) {
			sqlstr.append("insert into z_kst_group ");
			sqlstr.append("(id,groupid,groupname,type,domainid,parent_id,leaf)");
			sqlstr.append(" values (?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		}
		if(DEL_CAMERA == operatorType){
			sqlstr.append("delete from z_kst_group where 1=1");
			this.sqlStr = sqlstr.toString();
		}
	}	
	
	public void setValues() throws SQLException {
		try {
			if (ADD_CAMERA == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, UtilDAO.getUUid());
				this.stmt.setString(colNum++, group.getGroupid());
				this.stmt.setString(colNum++, group.getGroupname());
				this.stmt.setString(colNum++, group.getType());
				this.stmt.setString(colNum++, group.getDomainid());
				this.stmt.setString(colNum++, group.getParent_id());
				this.stmt.setInt(colNum++, group.getLeaf());
				

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
