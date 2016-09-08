package com.zzst.util.initDate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;


/**
 *@Description
 *@date 2011-12-27上午10:48:05
 *@author ryan
 */
public class ConnnectDB {
	private static Logger logger = Logger.getLogger(ConnnectDB.class
			.getName());
	
	public static  Connection getConnect(){
		Connection conn = null;
		try{
			if(DBHelp.db_type==null||DBHelp.db_type.length()==0) return null;
				
			if(DBHelp.type_mysql.equalsIgnoreCase(DBHelp.db_type))  
				conn=getMysqlConnect();
			
			if(DBHelp.type_oracle.equalsIgnoreCase(DBHelp.db_type)) 
				conn=getOracleConnect();
		}catch(Exception e){
			logger.error("加载中控基础数据出错"+e.getMessage());
		}
		return conn;
	}
	
	private static  Connection getMysqlConnect(){
		Connection conn = null;
		try{
			//jdbc:mysql://localhost:5522/icmp?characterEncoding=gb2312
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(DBHelp.db_url,DBHelp.db_name,DBHelp.db_password);	
		}catch(Exception e){
			logger.error("加载中控基础数据出错"+e.getMessage());
		}
		return conn;
	}
	
	private static  Connection getOracleConnect(){
//		Connection conn = null;
//		try{
		//jdbc:oracle:thin:@80.46.8.3:1521:CINDA
//			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
//			conn = DriverManager.getConnection("", "", "");	
//		}catch(Exception e){
//			
//		}
		return null;
	}
}
