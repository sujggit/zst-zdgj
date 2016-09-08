package com.zzst.dao.meeting.log;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.log.LogVO;
import java.sql.Timestamp;
import java.sql.Date;
/**
 * class description: Log TO
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public class LogTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(LogTO.class.getName());
	private int operatorType = -1;

	public static int ADD_LOG = 1;
	public static int MODIFY_LOG = 2;
	public static int DEL_LOG = 3;
	private int result = 0;

	private LogVO logVO;
	private String ids = "";

	public LogTO(int operatorType, LogVO logVO) {
		this.operatorType = operatorType;
		this.logVO = logVO;
	}

	public LogTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_LOG == operatorType) {
			sqlstr.append("insert into z_t_log ");
			sqlstr.append("(logID,userID,logType");
			
			sqlstr.append(",logLevel");
			
			sqlstr.append(",operatorDate,operatorContent,userIP,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(logVO.getLogID());
			super.addStringForField(logVO.getUserID());
			super.addIntForField(logVO.getLogType());
			super.addIntForField(logVO.getLevel());
			super.addTimestampForField(logVO.getOperatorDate());
			super.addStringForField(logVO.getOperatorContent());
			super.addStringForField(logVO.getUserIP());
			super.addStringForField(logVO.getDescription());
			super.addLongForField(logVO.getRevision());
		} else if (MODIFY_LOG == operatorType) {
			sqlstr.append("update  z_t_log set ");
			sqlstr.append(" logID = logID ");

			if (logVO.getUserID() != null) {
				sqlstr.append(" , userID=? ");
				super.addStringForField(logVO.getUserID());
			}

			if (logVO.getLogType() != Integer.MIN_VALUE) {
				sqlstr.append(" , logType=?");
				super.addIntForField(logVO.getLogType());
			}

			if (logVO.getLevel() != Integer.MIN_VALUE) {
				sqlstr.append(" , logLevel=?");
				super.addIntForField(logVO.getLevel());
			}

			if (logVO.getOperatorDate() != null) {
				sqlstr.append(" , operatorDate=? ");
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					UtilDAO.oracleToDate(logVO.getOperatorDate());
				}else{
					super.addTimestampForField(logVO.getOperatorDate());
				}
			}

			if (logVO.getOperatorContent() != null) {
				sqlstr.append(" , operatorContent=? ");
				super.addStringForField(logVO.getOperatorContent());
			}

			if (logVO.getUserIP() != null) {
				sqlstr.append(" , userIP=? ");
				super.addStringForField(logVO.getUserIP());
			}

			if (logVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(logVO.getDescription());
			}

			if (logVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(logVO.getRevision());
			}

			sqlstr.append(" where logID in (?) ");
			if (logVO.getLogID() != null) {
				super.addStringForField(logVO.getLogID());
			}
		} else if (DEL_LOG == operatorType) {
			sqlstr.append("delete  from  z_t_log ");
			sqlstr.append(" where logID =? ");
			super.addStringForField(logVO.getLogID());
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
