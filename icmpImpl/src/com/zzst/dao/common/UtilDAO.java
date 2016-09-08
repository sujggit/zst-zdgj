/**
 * 
 */
package com.zzst.dao.common;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.dao.CbfUtilMQB;
import com.gsiec.cbf.dao.CbfUtilTO;


/**
 * DAO
 * @author zhangliang
 * @date 2011-10-25
 */
public class UtilDAO {

	private static Logger logger = CbfLogger.getLogger(UtilDAO.class.getName());
	
	/**
	 * 生产唯一id
	 * @author	ryan
	 * @return String
	 */
	public static String	getUUid(){
		return new UUIDGenerator().generate().toString();  
	}
	
	
	/**
	 *  �������������ID
	 * @param sequenceName
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public synchronized static long getCurSequence(String sequenceName,
			TransactionManager tManager) throws SQLException {
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select curvalue from pub_sequence where sequenceName='"+sequenceName+"'");
		
		CbfUtilMQB cbfUtilMQB = new CbfUtilMQB(CbfUtilMQB.GET_CUR_SEQUENCE);
		cbfUtilMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		QueryTemplate.executeQueryForList(cbfUtilMQB, new PageController());

		
		CbfUtilTO cbfUtilTO = new CbfUtilTO(CbfUtilTO.NEXT_SEQUENCE,sequenceName);
		cbfUtilTO.setSqlStr();
		logger.info("modify sql is :" + cbfUtilTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(cbfUtilTO, true);
		} else {
			TransactionTemplate.executeTransaction(cbfUtilTO, tManager);
		}
		
		return cbfUtilMQB.getCurSequence();
	}
	/**
	 * oracle 查询日期时需要进行的转换操作
	 * @param ts
	 * @return
	 */
	public static String oracleToDate(Timestamp ts ){
		return "to_date('"+ts.toString().split("\\.")[0]+"','yyyy-mm-dd hh24:mi:ss') ";
	}
	
	public static void main(String[] args)
	{
		for(int i=0;i<1000;i++)
		{
			System.out.println(":"+getUUid());
		}
	}
}
