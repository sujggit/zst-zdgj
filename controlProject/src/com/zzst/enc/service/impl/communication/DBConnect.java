package com.zzst.enc.service.impl.communication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.zzst.util.initDate.DBHelp;

public class DBConnect {
	 private static Logger logger = Logger.getLogger(DBConnect.class
			.getName());
	
	 public static final String type_mysql = "mysql";
	 public static final String type_oracle = "oracle";
	
	 public static Connection conn=null;
	 public Statement stmt = null; // 声明Statement对象的实例
	 public ResultSet rs = null; // 声明ResultSet对象的实例
	 
	 public  static  Connection getConnection(){
		  Connection conn = null;
		  try{
			  if(DBHelp.type_mysql.equalsIgnoreCase(DBHelp.enc_db_type)){
				  Class.forName("com.mysql.jdbc.Driver");
				   String url=DBHelp.enc_db_url;//"jdbc:mysql://10.19.249.2:3306/MediaDB?auotReconnect=true&useUnicode=true&characterEncoding=GB2312";
				   String user=DBHelp.enc_db_name;//"root";
				   String pwd=DBHelp.enc_db_password;//"1234";
				   conn=(Connection) DriverManager.getConnection(url, user, pwd);
			  }
		  }catch(Exception e){
			  logger.info("数据库连接失败...."+e.getMessage());
		  } 
		   return conn;
	 }
	      
	  public ResultSet executeQuery(String sql) {
	     try { 
	          conn = getConnection(); // 调用getConnection()方法构造Connection对象的一个实例conn
	          stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,//创建语句
	                  ResultSet.CONCUR_READ_ONLY);
	          rs = stmt.executeQuery(sql);//执行查询
	      } catch (SQLException ex) {
	          System.err.println(ex.getMessage()); // 输出异常信息
	      }
	     return rs; // 返回结果集对象
	  }
	  
	 public int executeUpdate(String sql) {
		   int result = 0; // 定义保存返回值的变量
		   try { // 捕捉异常
		       conn = getConnection(); // 调用getConnection()方法构造Connection对象的一个实例conn
		       stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		               ResultSet.CONCUR_READ_ONLY);
		      result = stmt.executeUpdate(sql); // 执行更新操作
		   } catch (SQLException ex) {
		      result = 0; // 将保存返回值的变量赋值为0
		  }
	          return result; // 返回保存返回值的变量
	 }
	 
	 public void close() {
		         try { // 捕捉异常
		              try {
		                 if (rs != null) { // 当ResultSet对象的实例rs不为空时
		                     rs.close(); // 关闭ResultSet对象
	                 }
		              } finally {
		                  try {
		                      if (stmt != null) { // 当Statement对象的实例stmt不为空时
		                        stmt.close(); // 关闭Statement对象
		                      }
		                 } finally {
		                      if (conn != null) { // 当Connection对象的实例conn不为空时
		                          conn.close(); // 关闭Connection对象
		                      }
		                  }
		              }
		          } catch (Exception e) {
		              e.printStackTrace(System.err); // 输出异常信息
	    	          }
	   }
	
}
