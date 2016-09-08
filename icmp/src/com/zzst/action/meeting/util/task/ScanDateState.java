package com.zzst.action.meeting.util.task;


import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.datebase.DatebaseVO;

public class ScanDateState extends Thread {
	private static Logger logger = CbfLogger.getLogger(ScanDateState.class.getName());
	@Override
	public void run() {
		 super.run();
		 DatebaseVO dbvo=MeetingAppConfig.dbvo;
		 if(dbvo.isOpenbak()){
		 while (true) {
	      try {
			if(DateConnection.getcon(dbvo.getDb_url(), dbvo.getDb_name(), dbvo.getPass())){
			DBConnection.setDbInfo(dbvo.getDb_url(), dbvo.getDb_name(), dbvo.getPass());
			}else{
			logger.info("==========总部数据库断开，已连接本地数据库2=================");
			DBConnection.setDbInfo(dbvo.getBak_db_url(), dbvo.getBak_db_name(), dbvo.getBak_pass());
			}
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		  
		  try
	         {
	           Thread.sleep(6 * 1000);
	         }
	         catch (InterruptedException e) {
	           e.printStackTrace();
	         }
		
		
		 }
		 }
		
		
	}

}
