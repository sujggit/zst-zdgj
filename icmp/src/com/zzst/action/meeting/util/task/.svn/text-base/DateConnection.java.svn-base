package com.zzst.action.meeting.util.task;

import java.net.Socket;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.filter.ActiveUserListener;

public class DateConnection {
	public static boolean isBak=false;
	public static boolean isCleanSession=false;
	public static boolean tempboolean=true;
	private static Logger logger = CbfLogger.getLogger(ScanDateState.class.getName());
	public static boolean getcon(String url,String userName,String password){
		boolean ifpress=true;
		try {
			
			String[] strs=url.split(":");
			int port=Integer.parseInt(strs[3].split("/")[0]);
			Socket socket=new Socket(strs[2].substring(2),port);
			ifpress=socket.isConnected();
			socket.close();
			
		} catch (Exception e) {
			ifpress=false;
		}
		if(ifpress!=tempboolean){
			isCleanSession=true;
		}else{
			isCleanSession=false;
		}
		if(isCleanSession){
			logger.info("==清空用户会话==");
			ActiveUserListener.sessionInterval();
		}
		tempboolean=ifpress;
		isBak=!ifpress;
		return ifpress;
	}

}
