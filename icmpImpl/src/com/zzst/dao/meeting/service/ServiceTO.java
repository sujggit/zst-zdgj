package com.zzst.dao.meeting.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.service.ServiceVO;

/**
 * class description: Service TO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class ServiceTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(ServiceTO.class.getName());

	private int operatorType = -1;

	public static int ADD_SERVICE = 1;

	public static int MODIFY_SERVICE = 2;

	public static int DEL_SERVICE = 3;

	private int result = 0;

	private ServiceVO vServiceVO;

	public ServiceTO(int operatorType, ServiceVO vServiceVO) {
		this.operatorType = operatorType;
		this.vServiceVO = vServiceVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_SERVICE == operatorType) {
			sqlstr.append("insert into t_Service ");
			sqlstr
					.append("(parentID,serviceName,serviceUnit,price,serviceDescription,orderNO,state,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_SERVICE == operatorType) {
			sqlstr.append("update  t_Service set ");
			sqlstr
					.append(" parentID=?,serviceName=?,serviceUnit=?,price=?,serviceDescription=?,orderNO=?,state=?");
			sqlstr.append(" where serviceID= ? ");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_SERVICE == operatorType) {
				int colNum = 1; 
				this.stmt.setInt(colNum++, vServiceVO.getParentID());
				this.stmt.setString(colNum++, vServiceVO.getServiceName());
				this.stmt.setString(colNum++, vServiceVO.getServiceUnit());
				this.stmt.setFloat(colNum++, vServiceVO.getPrice());
				this.stmt.setString(colNum++, vServiceVO
						.getServiceDescription());
				this.stmt.setInt(colNum++, vServiceVO.getOrderNO());
				this.stmt.setInt(colNum++, vServiceVO.getState());
				this.stmt.setLong(colNum++, vServiceVO.getRevision());
			} else if (MODIFY_SERVICE == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vServiceVO.getParentID());
				
				this.stmt.setString(colNum++, vServiceVO.getServiceName());

				this.stmt.setString(colNum++, vServiceVO.getServiceUnit());
				
				this.stmt.setFloat(colNum++, vServiceVO.getPrice());
				
				this.stmt.setString(colNum++, vServiceVO
						.getServiceDescription());

				this.stmt.setInt(colNum++, vServiceVO.getOrderNO()); 
				this.stmt.setInt(colNum++, vServiceVO.getState());
				
				this.stmt.setInt(colNum++, vServiceVO.getServiceID());

			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" SERVICETO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" SERVICETO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
