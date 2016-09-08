package com.zzst.dao.view;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.model.view.VmeetingDetailVO;

public class VmeetingDetailDAO {
	private static Logger logger = CbfLogger.getLogger(VmeetingDetailDAO.class.getName());
	
	public static List<VmeetingDetailVO> getAll(VmeetingDetailVO mv,PageController mPageController){
		String sqls="SELECT	meetingDetailID,startTime,endTime,meetingType,STATUS,meetingName,info1,meetingroomName,meetingroomID,ismain,fullName,depName,depid,userID,loginName";
        sqls+=" FROM view_meetingdetail where 1=1 "; 
        if(mv.getMeetingName()!=null&&!(mv.getMeetingName().equals(""))){
        	sqls+=" "+mv.getMeetingName();
        }
		//////////////////////分级分权@author:zhangjy/////////////////////////
		  if(mv.isLevel()){
			 sqls+=" and meetingroomID in("+mv.getLsql()+") ";
		   }
		  //////////////////////////////end//////////////////////////////////////////
		
           sqls+=" GROUP BY meetingDetailID";

		  VmeetingDetailMQB vmMQB = new VmeetingDetailMQB();
         vmMQB.setSql(sqls);
		logger.info("====VmeetingDetailMQB query sql is :" + sqls);

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		try {
			QueryTemplate.executeQueryForList(vmMQB, mPageController);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vmMQB.getLstMeetingDetail();
	}
	
	
	
	
}
