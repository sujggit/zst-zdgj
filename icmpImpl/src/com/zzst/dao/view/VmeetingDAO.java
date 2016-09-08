package com.zzst.dao.view;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.model.view.VmeetingVO;

public class VmeetingDAO {
	private static Logger logger = CbfLogger.getLogger(VmeetingDAO.class.getName());
	
	public static List<VmeetingVO> getAll(VmeetingVO mv,PageController mPageController){
		String sqls="SELECT view_meeting_name,view_meeting_year,view_meeting_month,view_meeting_type," +
				"view_meeting_info,view_meeting_room_name,view_time_long,view_startTime,view_endTime," +
				"meetingroomID,view_meeting_id,view_manNum FROM view_meeting where 1=1 " ;
				//"and view_meeting_year='2016' and view_meeting_room_name='中电四会';
/*		String sqls="SELECT view_meeting_name,view_meeting_year,view_meeting_month," +
				"view_meeting_dept_name,view_meeting_type,view_meeting_info," +
				"view_meeting_room_name,view_time_long,view_deptId,view_deptPid,"+
				"view_startTime,view_endTime,view_userName,meetingroomID,view_meeting_id,view_manNum FROM view_meeting where 1=1 ";
*/           //////////////////////分级分权@author:zhangjy/////////////////////////
		  if(mv.isLevel()){
			 sqls+=" and meetingroomID in("+mv.getLsql()+") ";
		   }
		  //////////////////////////////end//////////////////////////////////////////
		
        if(mv.getViewMeetingName()!=null&&!mv.getViewMeetingName().equals("")){
		    sqls+=" and view_meeting_name='"+mv.getViewMeetingName()+"'";	
		}
        if(mv.getViewMeetingYear()!=null&&!mv.getViewMeetingYear().equals("")){
        	sqls+=" and view_meeting_year='"+mv.getViewMeetingYear()+"'";	
        }
        if(mv.getViewMeetingMonth()!=null&&!mv.getViewMeetingMonth().equals("")){
        	sqls+=" and view_meeting_month='"+mv.getViewMeetingMonth()+"'";	
        }
        if(mv.getViewMeetingDeptName()!=null&&!mv.getViewMeetingDeptName().equals("")){
        	sqls+=" and view_meeting_dept_name='"+mv.getViewMeetingDeptName()+"'";	
        }
        if(mv.getViewMeetingType()!=null&&!mv.getViewMeetingType().equals("")){
        	sqls+=" and view_meeting_type='"+mv.getViewMeetingType()+"'";		
        }
        if(mv.getViewMeetingInfo()!=null&&!mv.getViewMeetingInfo().equals("")){
        	sqls+=" and view_meeting_info='"+mv.getViewMeetingInfo()+"'";		
        }
        if(mv.getViewMeetingRoomName()!=null&&!mv.getViewMeetingRoomName().equals("")){
        	sqls+=" and view_meeting_room_name='"+mv.getViewMeetingRoomName()+"'";
        }
        if(mv.getViewDeptPid()!=null&&!mv.getViewDeptPid().equals("")){
        	sqls+=" and view_deptPid='"+mv.getViewDeptPid()+"'";
        }
        if(mv.getViewDeptId()!=null&&!mv.getViewDeptId().equals("")){
        	sqls+=" and view_deptId='"+mv.getViewDeptId()+"'";
        }
       if(mv.getViewMeetRoomId()!=null&&!(mv.getViewMeetRoomId().equals(""))){
    	   sqls+=" and meetingroomID='"+mv.getViewMeetRoomId()+"'";
       }
       if(mv.getStrsql()!=null&&!(mv.getStrsql().equals(""))){
    	   try {
			sqls+=URLDecoder.decode(mv.getStrsql(),"UTF-8");
			sqls=sqls.replace("Percent", "%");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
        VmeetingMQB vmMQB = new VmeetingMQB(VmeetingMQB.QUERY_FROM_VM);
        vmMQB.setSql(sqls);
		logger.info("====query sql is :" + sqls);

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		try {
			QueryTemplate.executeQueryForList(vmMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vmMQB.getVmeetList();
	}
	
	
	
	public static List<VmeetingVO> getAllGroupBY(VmeetingVO mv,PageController mPageController){
		/*String sqls="SELECT view_meeting_name,view_meeting_year,view_meeting_month," +
				"view_meeting_dept_name,view_meeting_type,view_meeting_info," +
				"view_meeting_room_name,view_time_long,view_deptId,view_deptPid,"+
				"view_startTime,view_endTime,view_userName,meetingroomID,view_meeting_id,view_manNum"+
				" FROM view_meeting where 1=1 ";*/
		String sqls = "SELECT view_meeting_name,view_meeting_year,view_meeting_month," +
				"view_meeting_type,view_meeting_info,view_meeting_room_name," +
				"view_time_long,view_startTime,view_endTime,meetingroomID," +
				"view_meeting_id,view_manNum FROM view_meeting where 1=1";
		  //////////////////////分级分权@author:zhangjy/////////////////////////
		  if(mv.isLevel()){
			 sqls+=" and meetingroomID in("+mv.getLsql()+") ";
		   }
		  //////////////////////////////end//////////////////////////////////////////
		
        if(mv.getViewMeetingName()!=null&&!mv.getViewMeetingName().equals("")){
		    sqls+=" and view_meeting_name='"+mv.getViewMeetingName()+"'";	
		}
        if(mv.getViewMeetingYear()!=null&&!mv.getViewMeetingYear().equals("")){
        	sqls+=" and view_meeting_year='"+mv.getViewMeetingYear()+"'";	
        }
        if(mv.getViewMeetingMonth()!=null&&!mv.getViewMeetingMonth().equals("")){
        	sqls+=" and view_meeting_month='"+mv.getViewMeetingMonth()+"'";	
        }
        if(mv.getViewMeetingDeptName()!=null&&!mv.getViewMeetingDeptName().equals("")){
        	sqls+=" and view_meeting_dept_name='"+mv.getViewMeetingDeptName()+"'";	
        }
        if(mv.getViewMeetingType()!=null&&!mv.getViewMeetingType().equals("")){
        	sqls+=" and view_meeting_type='"+mv.getViewMeetingType()+"'";		
        }
        if(mv.getViewMeetingInfo()!=null&&!mv.getViewMeetingInfo().equals("")){
        	sqls+=" and view_meeting_info='"+mv.getViewMeetingInfo()+"'";		
        }
        if(mv.getViewMeetingRoomName()!=null&&!mv.getViewMeetingRoomName().equals("")){
        	sqls+=" and view_meeting_room_name='"+mv.getViewMeetingRoomName()+"'";
        }
        if(mv.getViewDeptPid()!=null&&!mv.getViewDeptPid().equals("")){
        	sqls+=" and view_deptPid='"+mv.getViewDeptPid()+"'";
        }
        if(mv.getViewDeptId()!=null&&!mv.getViewDeptId().equals("")){
           sqls+=" and view_deptId='"+mv.getViewDeptId()+"'";
        }
        if(mv.getViewMeetRoomId()!=null&&!mv.getViewMeetRoomId().equals("")){
     	   sqls+=" and meetingroomID='"+mv.getViewMeetRoomId()+"'";
        }
        if(mv.getStrsql()!=null&&!(mv.getStrsql().equals(""))){
        	 try {
     			sqls+=URLDecoder.decode(mv.getStrsql(),"UTF-8");
     			sqls=sqls.replace("Percent", "%");
     		} catch (UnsupportedEncodingException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }
        if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
           sqls+=" GROUP BY view_meeting_id,view_meeting_name,view_meeting_year,view_meeting_month,view_meeting_dept_name,view_meeting_type,view_meeting_info,view_meeting_room_name,view_time_long ";
        }else{
           sqls+=" GROUP BY view_meeting_id ";
        }
        
        VmeetingMQB vmMQB = new VmeetingMQB(VmeetingMQB.QUERY_FROM_VM);
        vmMQB.setSql(sqls);
		logger.info("===query sql is :" + sqls);

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		try {
			QueryTemplate.executeQueryForList(vmMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vmMQB.getVmeetList();
	}
	
	
	public static List<VmeetingVO> getNumAndTime(VmeetingVO mv,PageController mPageController){
		String sqls="SELECT count(*) as tiaoshu,sum(view_time_long) as longtime FROM `view_meeting` where 1=1 ";
		  //////////////////////分级分权@author:zhangjy/////////////////////////
		  if(mv.isLevel()){
			 sqls+=" and meetingroomID in("+mv.getLsql()+") ";
		   }
		  //////////////////////////////end//////////////////////////////////////////
		
        if(mv.getViewMeetingName()!=null&&!mv.getViewMeetingName().equals("")){
		    sqls+=" and view_meeting_name='"+mv.getViewMeetingName()+"'";	
		}
        if(mv.getViewMeetingYear()!=null&&!mv.getViewMeetingYear().equals("")){
        	sqls+=" and view_meeting_year='"+mv.getViewMeetingYear()+"'";	
        }
        if(mv.getViewMeetingMonth()!=null&&!mv.getViewMeetingMonth().equals("")){
        	sqls+=" and view_meeting_month='"+mv.getViewMeetingMonth()+"'";	
        }
        if(mv.getViewMeetingDeptName()!=null&&!mv.getViewMeetingDeptName().equals("")){
        	sqls+=" and view_meeting_dept_name='"+mv.getViewMeetingDeptName()+"'";	
        }
        if(mv.getViewMeetingType()!=null&&!mv.getViewMeetingType().equals("")){
        	sqls+=" and view_meeting_type='"+mv.getViewMeetingType()+"'";		
        }
        if(mv.getViewMeetingInfo()!=null&&!mv.getViewMeetingInfo().equals("")){
        	sqls+=" and view_meeting_info='"+mv.getViewMeetingInfo()+"'";		
        }
        if(mv.getViewMeetingRoomName()!=null&&!mv.getViewMeetingRoomName().equals("")){
        	sqls+=" and view_meeting_room_name='"+mv.getViewMeetingRoomName()+"'";
        }
        if(mv.getViewDeptPid()!=null&&!mv.getViewDeptPid().equals("")){
        	sqls+=" and view_deptPid='"+mv.getViewDeptPid()+"'";
        }
        if(mv.getViewDeptId()!=null&&!mv.getViewDeptId().equals("")){
        	sqls+=" and view_deptId='"+mv.getViewDeptId()+"'";
        }
       
        
        VmeetingMQB vmMQB = new VmeetingMQB(VmeetingMQB.QUERY_FROM_NUM_TIME);
        vmMQB.setSql(sqls);
		logger.info("===query sql is :" + sqls);

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		try {
			QueryTemplate.executeQueryForList(vmMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vmMQB.getVmeetList();
	}
	public static List<VmeetingVO> getAllChildGroupBY(VmeetingVO mv,
			PageController mPageController) {
		String sqls="SELECT view_meeting_name,view_meeting_year,view_meeting_month," +
		"view_meeting_dept_name,view_meeting_type,view_meeting_info," +
		"view_meeting_room_name,view_time_long,view_deptId,view_deptPid FROM view_meeting where 1=1 ";
		  //////////////////////分级分权@author:zhangjy/////////////////////////
		  if(mv.isLevel()){
			 sqls+=" and meetingroomID in("+mv.getLsql()+") ";
		   }
		  //////////////////////////////end//////////////////////////////////////////

		if(mv.getViewMeetingName()!=null&&!mv.getViewMeetingName().equals("")){
		    sqls+=" and view_meeting_name='"+mv.getViewMeetingName()+"'";	
		}
		if(mv.getViewMeetingYear()!=null&&!mv.getViewMeetingYear().equals("")){
			sqls+=" and view_meeting_year='"+mv.getViewMeetingYear()+"'";	
		}
		if(mv.getViewMeetingMonth()!=null&&!mv.getViewMeetingMonth().equals("")){
			sqls+=" and view_meeting_month='"+mv.getViewMeetingMonth()+"'";	
		}
		if(mv.getViewMeetingDeptName()!=null&&!mv.getViewMeetingDeptName().equals("")){
			sqls+=" and view_meeting_dept_name='"+mv.getViewMeetingDeptName()+"'";	
		}
		if(mv.getViewMeetingType()!=null&&!mv.getViewMeetingType().equals("")){
			sqls+=" and view_meeting_type='"+mv.getViewMeetingType()+"'";		
		}
		if(mv.getViewMeetingInfo()!=null&&!mv.getViewMeetingInfo().equals("")){
			sqls+=" and view_meeting_info='"+mv.getViewMeetingInfo()+"'";		
		}
		if(mv.getViewMeetingRoomName()!=null&&!mv.getViewMeetingRoomName().equals("")){
			sqls+=" and view_meeting_room_name='"+mv.getViewMeetingRoomName()+"'";
		}
		if(mv.getViewDeptPid()!=null&&!mv.getViewDeptPid().equals("")){
			sqls+=" and view_deptPid='"+mv.getViewDeptPid()+"'";
		}
		if(mv.getViewDeptId()!=null&&!mv.getViewDeptId().equals("")){
			sqls+=" and view_deptId in("+mv.getViewDeptId()+")";
		}
		if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
		   sqls+=" GROUP BY view_meeting_id,view_meeting_name,view_meeting_year,view_meeting_month,view_meeting_dept_name,view_meeting_type,view_meeting_info,view_meeting_room_name,view_time_long ";
		}else{
			 sqls+=" GROUP BY view_meeting_id ";
		}
		
		VmeetingMQB vmMQB = new VmeetingMQB(VmeetingMQB.QUERY_FROM_VM);
		vmMQB.setSql(sqls);
		logger.info("===query sql is :" + sqls);
		
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}
		
		try {
			QueryTemplate.executeQueryForList(vmMQB, mPageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vmMQB.getVmeetList();
	}
	
}
