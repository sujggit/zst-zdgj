



	    	            
         
        	
		
	        
        	
		
        

    
   
    package com.zzst.service.meeting.scheduleWork;
    
	import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.scheduleWork.ScheduleWorkDAO;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;

 /**	
 * class description: ScheduleWork ServiceImpl
 * @date  Mon Aug 22 16:03:33 CST 2016
 * @author ryan
 */
    public class ScheduleWorkServiceImpl implements ScheduleWorkService{
	private static Logger logger = CjfLogger.getLogger(ScheduleWorkServiceImpl.class.getName());

		@Override
		public ScheduleWorkVO add(ScheduleWorkVO scheduleWorkVO) throws Exception {
			logger.info("serviceImpl	add	begin");
			scheduleWorkVO=ScheduleWorkDAO.add(scheduleWorkVO, null);
			logger.info("serviceImpl	add	end");
			return scheduleWorkVO;
		}

		@Override
		public  ArrayList<ScheduleWorkVO> query(ScheduleWorkVO scheduleWorkVO,PageController pageController) throws Exception{
			logger.info("serviceImpl	query	begin");
			ArrayList<ScheduleWorkVO> listScheduleWork = ScheduleWorkDAO.query(scheduleWorkVO,pageController);
			logger.info("serviceImpl	query	end");
			return  listScheduleWork;
		}

		@Override
		public  ScheduleWorkVO queryByID(String id) throws Exception{
			logger.info("serviceImpl	queryByID	begin");
			ArrayList<ScheduleWorkVO> listScheduleWork = ScheduleWorkDAO.queryByIDs(id,null);
			if(listScheduleWork!=null&&listScheduleWork.size()==1){
				logger.info("serviceImpl	end");
				return listScheduleWork.get(0);
			}
			logger.info("serviceImpl	queryByID	end");
			return null;
		}

		@Override
		public  ArrayList<ScheduleWorkVO> queryByIDs(String ids) throws Exception{
			logger.info("serviceImpl	queryByIDs	begin");
			ArrayList<ScheduleWorkVO> listScheduleWork = ScheduleWorkDAO.queryByIDs(ids,null);
			logger.info("serviceImpl	queryByIDs	end");
			return listScheduleWork;
		}

		@Override
		public ScheduleWorkVO modify(ScheduleWorkVO scheduleWorkVO )throws Exception{
			logger.info("serviceImpl	modify	begin");
			scheduleWorkVO=ScheduleWorkDAO.modify(scheduleWorkVO,null);
			logger.info("serviceImpl	modify	end");
			return scheduleWorkVO;
		}
		
		@Override
		public boolean deleteByID(String id )throws Exception{
			logger.info("serviceImpl	deleteByID	begin");
			int num	= ScheduleWorkDAO.deleteByID(id,null);
			if(num==1){
				logger.info("serviceImpl	deleteByID	end");
				return true;
			}else{
				logger.info("serviceImpl	deleteByID	end");
				return false;
			}
		}

		@Override
		public void deleteByIDs(String ids )throws Exception{
			logger.info("serviceImpl	deleteByIDs	begin");
		if(ids!=null&&ids.length()>0){
			String[] id = ids.split(",");
			for(int i=id.length;i>=0;i--){
				deleteByID(id[i]);
			}
		}
			logger.info("serviceImpl	deleteByIDs	end");
		}

		public static void main(String args[]) throws Exception {
//			DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda", "cinda", "cinda");
			DBConnection.setDbInfo("jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312", "test", "123456");
			ScheduleWorkVO vScheduleWorkVO = new ScheduleWorkVO();
														vScheduleWorkVO.setWorkId("workId");
																			vScheduleWorkVO.setWorkName("workName");
																			vScheduleWorkVO.setStatus("status");
								
			new ScheduleWorkServiceImpl().add(vScheduleWorkVO);
			System.out.println("=========add Success!");

			ArrayList<ScheduleWorkVO> lstScheduleWork = new ScheduleWorkServiceImpl().query(vScheduleWorkVO,null);
			
			
			if(lstScheduleWork.size()>0){
				System.out.println("=========query Result:");
				ScheduleWorkVO vvScheduleWorkVO = (ScheduleWorkVO) lstScheduleWork.get(0);
				            		System.out.println("workId=" + vvScheduleWorkVO.getWorkId());	            	           			        
				            		System.out.println("workName=" + vvScheduleWorkVO.getWorkName());	            	           			        
				            		System.out.println("status=" + vvScheduleWorkVO.getStatus());	            	           			        
								
			}else{
				System.out.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
			}
		
		}
 
	}

    