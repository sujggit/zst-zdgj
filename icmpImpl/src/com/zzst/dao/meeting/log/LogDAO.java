package com.zzst.dao.meeting.log;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.log.LogVO;

/**
 * class description: Log DAO
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public class LogDAO {
	private static Logger logger = CjfLogger.getLogger(LogDAO.class.getName());


	/**
	 * add LogVO object
	 * 
	 * @param LogVO
	 * @param TransactionManager
	 * @return LogVO
	 * @throws Exception
	 */
	public static LogVO add(LogVO logVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		logVO.setLogID(UtilDAO.getUUid());
		LogTO logTO = new LogTO(LogTO.ADD_LOG, logVO);

		logTO.setSqlStr();
		logger.info("sqlStr	:	" + logTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(logTO, true);
		} else {
			TransactionTemplate.executeTransaction(logTO, tManager);
		}
		logger.info("DAO	add	end");
		return logVO;
	}

	/**
	 * query LogVO list
	 * 
	 * @param LogVO
	 * @param PageController
	 * @return ArrayList<LogVO>
	 * @throws Exception
	 */
	public static ArrayList<LogVO> query(LogVO logVO, PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		
		StringBuffer strsql = new StringBuffer();
		
		strsql.append("SELECT a.*,b.fullName userName from z_t_log a left" +
				" join z_t_user b on a.userID = b.userID where 1=1");
		if (null != logVO) {
			if (logVO.getUserID()!=null && !"".equals(logVO.getUserID())) {
				strsql.append(" and a.userID='" + logVO.getUserID()+"'");
			}
			if (-1 != logVO.getLogType() && Integer.MIN_VALUE != logVO.getLogType()){
				strsql.append(" and a.logType=" + logVO.getLogType());
			}
			
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//判断数据库类型
				if(logVO.getStarTime()!= null){
					strsql.append(" and a.operatorDate>" + UtilDAO.oracleToDate(logVO.getStarTime()));
				}
				if(logVO.getEndTime()!= null){
					strsql.append(" and a.operatorDate<" + UtilDAO.oracleToDate(logVO.getEndTime()));
				}
			}else {
				if(logVO.getStarTime()!= null){
					strsql.append(" and a.operatorDate>'" + logVO.getStarTime()+"'");
				}
				if(logVO.getEndTime()!= null){
					strsql.append(" and a.operatorDate<'" + logVO.getEndTime()+"'");
				}
			}
		}
		
		strsql.append(" order by a.operatorDate DESC");
		
		
		
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		LogMQB logMQB = new LogMQB(LogMQB.QUERY_FROM_LOG);
		logMQB.setSql(strsql.toString());
		logger.info("sqlStr	:	" + logMQB.getSql());
		QueryTemplate.executeQueryForList(logMQB, pageController);
		
		return logMQB.getLogList();
	}
	
	/**
	 * query LogVO list by logVO
	 * @param logVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<LogVO> queryInital(LogVO logVO, PageController pageController) throws Exception {
		logger.info("DAO	queryInital	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT a.*,b.fullName userName from z_t_log a left" +
				" join z_t_user b on a.userID = b.userID where 1=1");
		if (null != logVO) {
			if (logVO.getLogID()!=null && !"".equals(logVO.getLogID())) {
				strsql.append(" and a.logID='" + logVO.getLogID()+"'");
			}
		}
		strsql.append(" order by a.operatorDate DESC");
		
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		LogMQB logMQB = new LogMQB(LogMQB.QUERY_FROM_LOG);
		logMQB.setSql(strsql.toString());
		logger.info("sqlStr	:	" + logMQB.getSql());
		QueryTemplate.executeQueryForList(logMQB, pageController);
		
		return logMQB.getLogList();
	}
	
//	public static ArrayList<LogVO> query(LogVO logVO, PageController pageController) throws Exception {
//		logger.info("DAO	query	begin");
//		LogMQB logMQB = new LogMQB(LogMQB.QUERY_FROM_LOG, logVO);
//
//		if (pageController == null) {
//			pageController = new PageController();
//			pageController.setAll(true);
//		}
//		logger.info("sqlStr	:	" + logMQB.getSql());
//		QueryTemplate.executeQueryForList(logMQB, pageController);
//		logger.info("list size	:	" + logMQB.getLogList().size());
//		logger.info("DAO	query	end");
//		return logMQB.getLogList();
//	}

	/**
	 * query LogVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<LogVO>
	 * @throws Exception
	 */
	public static ArrayList<LogVO> queryByIDs(String ids, PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		LogMQB logMQB = new LogMQB(LogMQB.QUERY_FROM_LOG_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + logMQB.getSql());
		QueryTemplate.executeQueryForList(logMQB, pageController);
		logger.info("list size	:	" + logMQB.getLogList().size());
		logger.info("DAO	queryByIDs	end");
		return logMQB.getLogList();
	}

	/**
	 * modify LogVO column by ID
	 * 
	 * @param LogVO
	 * @param TransactionManager
	 * @return LogVO
	 * @throws Exception
	 */
	public static LogVO modify(LogVO logVO, TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		LogTO logTO = new LogTO(LogTO.MODIFY_LOG, logVO);
		logTO.setSqlStr();
		logger.info("sqlStr	:	" + logTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(logTO, true);
		} else {
			TransactionTemplate.executeTransaction(logTO, tManager);
		}
		logger.info("DAO	modify	end");
		return logVO;
	}

	/**
	 * delete LogVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return LogVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager) throws Exception {
		logger.info("DAO	deleteByID	begin");
		LogVO logVO = new LogVO();
		logVO.setLogID(ids);
		LogTO logTO = new LogTO(LogTO.DEL_LOG, logVO);

		logTO.setSqlStr();
		logger.info("sqlStr	:	" + logTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(logTO, true);
		} else {
			TransactionTemplate.executeTransaction(logTO, tManager);
		}
		logger.info("result	:	" + logTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return logTO.getexecuteResult();
	}
}
