package com.zzst.enc.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.enc.service.ENCObject;
import com.zzst.enc.service.ENCObjectHelp;
import com.zzst.enc.service.impl.communication.DBConnect;
import com.zzst.util.serverSocket.ServerSocketHelp;


/**
 *@Description
 *@date 2012-4-17下午03:36:04
 *@author ryan
 */
public class ENCObjectImpl extends ENCObject{
	private static Logger logger = Logger.getLogger(ENCObjectImpl.class
			.getName());
	
	/**
	 * String[] obj
	 * 0 ip
	 * 1 mac
	 * 2 url
	 * @param obj
	 */
//	public ENCObjectImpl(String[] obj) {
//		super(obj);
//	}
	
	@Override
	public void setURLView(String mac,String url) {
		modifyTerminalInfo( mac, url,"0");
		String[] macs = new String[1];
		macs[0] = mac;
		excute(macs);
	}
	
	@Override
	public void setView(String mac,String url,String tvSys) {
		modifyTerminalInfo( mac, url,tvSys);
		String[] macs = new String[1];
		macs[0] = mac;
		excute(macs);
	}
	//n-10hd
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 提取终端数据
	 */
	private void getTerminalInfo(){
		 DBConnect dbc = new DBConnect();
		 String query = "select * from `vm infor`";
		 ResultSet result =  dbc.executeQuery(query);
	     try {
			while (result.next())
			  {
			    String id = result.getString("id");
			    String URL = result.getString("URL");
			    
			    logger.info(" id" + id+"  URL:"+URL);
              }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     try {
			DBConnect.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改终端数据
	 */
	private void modifyTerminalInfo(String mac,String url,String tvSys){
		 DBConnect dbc = new DBConnect();
		 String sql = "update `vm infor` set url='"+url+"',TVSys='"+tvSys+"'  where id='"+mac+"'";
		 int result =  dbc.executeUpdate(sql);
		 logger.info("sql："+sql);
		 logger.info("修改结果："+result);
	     try {
			DBConnect.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量修改终端信息
	 * @param mac
	 * @param url
	 */
	private void modifyTerminalInfo(HashMap<?, ?> terminalInfoHash){
		// conn = DBConnect.getConnection();
		 DBConnect dbc = new DBConnect();
		 String query = "select * vm infor";
		//http://10.19.244.55:81/index.jsp
		 Iterator<?> iter = terminalInfoHash.entrySet().iterator();
		 while (iter.hasNext()){
				 Map.Entry entry = (Map.Entry) iter.next();
	             Object mac = entry.getKey();
	             Object url = entry.getValue();
	             int result =  dbc.executeUpdate("update `vm infor` set url='"+url+"',TVSys='0'  where id='"+mac+"'");
	             logger.info("MAC:"+mac+"修改成功！");
	             if(result ==1){
	            	 //执行
	            	 this.excute("91 #"+mac.toString()+"$||8#");//发布网页命令
	            	 logger.info("MAC:"+mac+"执行成功！");
	             }
             }
	     try {
			DBConnect.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param mac
	 */
	private boolean excute(String command){
		OutputStream socketOut = null;
		Socket socket = null;
		try {
			socket = ServerSocketHelp.getSocket(ENCObjectHelp.serverIp,ENCObjectHelp.serverPort);
			if(null!=socket){
                String tmpCommand = command;
				socketOut = socket.getOutputStream();
				socketOut.write(tmpCommand.getBytes());
			}else{
				logger.info("socket 建立失败");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				socketOut.flush();
				socketOut.close();
				socket.close();
			} catch (IOException e) {
				logger.info("send command error");
			}
		}
		logger.info("socket 发送命令:"+command+" 成功！");
		return true;
	}

	/**
	 * 修改后，终端执行
	 * @param macs
	 */
	private void excute(String[] macs){
		OutputStream socketOut = null;
		Socket socket = null;
		try {
			socket = ServerSocketHelp.getSocket(ENCObjectHelp.serverIp,ENCObjectHelp.serverPort);
		    for(int i=0;i<macs.length;i++){
		    	if(null!=socket){
	                String command = "91 #"+macs[0]+"$||8#";
					socketOut = socket.getOutputStream();
					socketOut.write(command.getBytes());
				}else{
					logger.info("socket 建立失败");
				}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socketOut.flush();
				socketOut.close();
				socket.close();
			} catch (IOException e) {
				logger.info("send command error");
			}
		}
		logger.info("socket 发送命令成功！");
	}
	
	/**
	 * 操作告示服务器执行
	 * @param macs
	 */
	private void excute(String ip,String macs[],String command){
		OutputStream socketOut = null;
		Socket socket = null;
		try {
			socket = ServerSocketHelp.getSocket(ENCObjectHelp.serverIp,ENCObjectHelp.serverPort);
		    for(int i=0;i<macs.length;i++){
		    	if(null!=socket){
					socketOut = socket.getOutputStream();
					socketOut.write(command.getBytes());
				}else{
					logger.info("socket 建立失败");
				}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				socketOut.flush();
				socketOut.close();
				socket.close();
			} catch (IOException e) {
				logger.info("send command error");
			}
		}
		logger.info("socket 发送命令成功！");
	}
	
	 
	 
	public static void main(String[] args){
		//new NoticeUtil().modifyTerminalInfo();
		String mac = "00:1c:c0:da:8a:63";
		String url = "http://10.19.244.55:81/index.jsp";
		String[] s = new String[2];
//		new ENCObjectImpl(s).modifyTerminalInfo();
//		new ENCObjectImpl(s).excute(mac);
	}
	
}
