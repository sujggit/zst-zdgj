package com.zzst.dao.meeting.log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.log.LogVO;

/**
 * class description: Log MQB
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public class LogMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(LogMQB.class.getName());

	public static int QUERY_FROM_LOG = 1;
	public static int QUERY_FROM_LOG_BY_IDS = 2;

	private LogVO logVO;
	private ArrayList<LogVO> listLog = new ArrayList<LogVO>();

	private int _operatorType = -1;
	private String ids = "";

	public LogMQB(int operatorType, LogVO logVO) {
		_operatorType = operatorType;
		this.logVO = logVO;
		makeSql();
	}

	public LogMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	public LogMQB(int operatorType) {
		_operatorType = operatorType;
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select logID,userID,logType,operatorDate,operatorContent,userIP,description,revision");
		if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
			strsql.append(",level_ ");//level在oracle中是关键字
		}else{
			strsql.append(",level ");
		}
		strsql.append(" from z_t_log ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_LOG == _operatorType) {
			if (null != logVO) {
				if (!StringUtils.isNullOrBlank(logVO.getLogID())) {
					strsql.append(" and logID= ? ");
					super.addStringForField(logVO.getLogID());
				}
				if (!StringUtils.isNullOrBlank(logVO.getUserID())) {
					strsql.append(" and userID= ? ");
					super.addStringForField(logVO.getUserID());
				}
				if (Integer.MIN_VALUE != logVO.getLogType()) {
					strsql.append(" and logType= ? ");
					super.addIntForField(logVO.getLogType());
				}
				if (Integer.MIN_VALUE != logVO.getLevel()) {
					strsql.append(" and logLevel= ? ");
					super.addIntForField(logVO.getLevel());
				}
				if (!StringUtils.isNullOrBlank(logVO.getOperatorContent())) {
					strsql.append(" and operatorContent= ? ");
					super.addStringForField(logVO.getOperatorContent());
				}
				if (!StringUtils.isNullOrBlank(logVO.getUserIP())) {
					strsql.append(" and userIP= ? ");
					super.addStringForField(logVO.getUserIP());
				}
				if (!StringUtils.isNullOrBlank(logVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(logVO.getDescription());
				}
				if (Long.MIN_VALUE != logVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(logVO.getRevision());
				}
			}
		} else if (QUERY_FROM_LOG_BY_IDS == _operatorType) {
			strsql.append(" and logID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		logVO = new LogVO();
		logVO.setLogID(rs.getString("logID"));
		logVO.setUserName(rs.getString("userName"));
		logVO.setUserID(rs.getString("userID"));
		logVO.setLogType(rs.getInt("logType"));
		logVO.setLevel(rs.getInt("logLevel"));
		logVO.setOperatorDate(rs.getTimestamp("operatorDate"));
		logVO.setOperatorContent(rs.getString("operatorContent"));
		logVO.setUserIP(rs.getString("userIP"));
		logVO.setDescription(rs.getString("description"));
		logVO.setRevision(rs.getLong("revision"));
		listLog.add(logVO);
	}

	public ArrayList<LogVO> getLogList() {
		return listLog;
	}

	public LogVO getLogVO() {
		return logVO;
	}

}
