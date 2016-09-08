/**
 * 
 */
package com.zzst.dao.meeting.kst;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.meeting.kst.CameraGroup;

/**
 * 可视通镜头dao
 * @author zhangliang
 * Mar 27, 2012 3:50:45 PM
 */
public class CameraDAO 
{
	private static Logger logger = CbfLogger.getLogger(CameraDAO.class.getName());
	public static void addCamera(ArrayList<CameraGroup> clist, TransactionManager tManager) throws Exception 
	{
		if(clist !=null)
		{
			for(int i=0;i<clist.size();i++)
			{
				CameraTO cameraTO = new CameraTO(CameraTO.ADD_CAMERA,clist.get(i));
				cameraTO.setSqlStr();
				TransactionTemplate.executeTransaction(cameraTO, true);
				
			}
		}	
	}
	
	public static ArrayList<CameraGroup> getallgroupList(CameraGroup cameraGroup,PageController pageController)
	{
		StringBuffer strsql = new StringBuffer();

		strsql.append("select * from z_kst_group  ");
		strsql.append("where 1=1 ");
		if (null != cameraGroup) {
			if (!StringUtils.isNullOrBlank(cameraGroup.getParent_id())) {
				strsql.append(" and parent_id=  '"+cameraGroup.getParent_id()+"'");
			}
			if (!StringUtils.isNullOrBlank(cameraGroup.getDomainid())) {
				strsql.append(" and domainid=  '"+cameraGroup.getDomainid()+"'");
			}
			if (!StringUtils.isNullOrBlank(cameraGroup.getGroupid())) {
				strsql.append(" and groupid=  '"+cameraGroup.getGroupid()+"'");
			}
		}
		
		strsql.append(" order by groupid");
		CameraMQB cameraMQB = new CameraMQB(CameraMQB.QUERY_FROM_CAMERA);
		cameraMQB.setSql(strsql.toString() );
		logger.info("query sql is :" + strsql.toString());
        if(pageController ==null)
        {
        	pageController = new PageController();
        	pageController.setAll(true);	
        }
        try {
			QueryTemplate.executeQueryForList(cameraMQB, pageController);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cameraMQB.getClist();
		
	}
	
	public static void delCamera(){
		try{
			CameraTO cameraTO = new CameraTO(CameraTO.DEL_CAMERA, null);
			cameraTO.setSqlStr();
			logger.info("delete begain");
			logger.info("delete sql is :"+cameraTO.getSqlStr());
			TransactionTemplate.executeTransaction(cameraTO, true);
			logger.info("delete end");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
