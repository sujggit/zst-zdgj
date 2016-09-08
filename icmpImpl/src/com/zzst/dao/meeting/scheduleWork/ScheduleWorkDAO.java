



	    	            
         
        	
		
	        
        	
		
        

    
    		

    package com.zzst.dao.meeting.scheduleWork;
    
	import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;

	/**
	 * class description:	ScheduleWork DAO
	 * @date Mon Aug 22 16:03:33 CST 2016
	 * @author ryan
	 */
    public class ScheduleWorkDAO {
		private static Logger logger = CjfLogger.getLogger(ScheduleWorkDAO.class.getName());

		private static 	final	String	id="WorkId";
		
		/**
		 * add ScheduleWorkVO	object
		 * @param ScheduleWorkVO
		 * @param TransactionManager
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public static ScheduleWorkVO add(ScheduleWorkVO scheduleWorkVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			scheduleWorkVO.setWorkId(UtilDAO.getUUid());
			ScheduleWorkTO scheduleWorkTO=new ScheduleWorkTO(ScheduleWorkTO.ADD_SCHEDULEWORK,scheduleWorkVO);
			
			scheduleWorkTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleWorkTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleWorkTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleWorkTO, tManager);
			}
			logger.info("DAO	add	end");
			return scheduleWorkVO;
		}
	

	
		/**
		 * query ScheduleWorkVO	list
		 * @param ScheduleWorkVO
		 * @param PageController
		 * @return ArrayList<ScheduleWorkVO> 
		 * @throws Exception
		 */
		public static ArrayList<ScheduleWorkVO> query(ScheduleWorkVO scheduleWorkVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		ScheduleWorkMQB scheduleWorkMQB=new ScheduleWorkMQB(ScheduleWorkMQB.QUERY_FROM_SCHEDULEWORK,scheduleWorkVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleWorkMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleWorkMQB, pageController);
			logger.info("list size	:	"+scheduleWorkMQB.getScheduleWorkList().size());
			logger.info("DAO	query	end");
			return scheduleWorkMQB.getScheduleWorkList();
		}
		
		/**
		 * query ScheduleWorkVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<ScheduleWorkVO> 
		 * @throws Exception
		 */
		public static ArrayList<ScheduleWorkVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		ScheduleWorkMQB scheduleWorkMQB=new ScheduleWorkMQB(ScheduleWorkMQB.QUERY_FROM_SCHEDULEWORK_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleWorkMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleWorkMQB, pageController);
			logger.info("list size	:	"+scheduleWorkMQB.getScheduleWorkList().size());
			logger.info("DAO	queryByIDs	end");
			return scheduleWorkMQB.getScheduleWorkList();
		}

		/**
		 * modify ScheduleWorkVO column by ID
		 * @param ScheduleWorkVO
		 * @param TransactionManager
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public static ScheduleWorkVO modify(ScheduleWorkVO scheduleWorkVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			ScheduleWorkTO scheduleWorkTO=new ScheduleWorkTO(ScheduleWorkTO.MODIFY_SCHEDULEWORK,scheduleWorkVO);		
			scheduleWorkTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleWorkTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleWorkTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleWorkTO, tManager);
			}
			logger.info("DAO	modify	end");
			return scheduleWorkVO;
		}
		
		
		
		/**
		 * delete	ScheduleWorkVO by id
		 * @param String
		 * @param TransactionManager
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public static int deleteByID(String id,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			ScheduleWorkVO scheduleWorkVO = new ScheduleWorkVO();
			scheduleWorkVO.setWorkId(id);
			ScheduleWorkTO scheduleWorkTO=new ScheduleWorkTO(ScheduleWorkTO.DEL_SCHEDULEWORK,scheduleWorkVO);
			
			scheduleWorkTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleWorkTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleWorkTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleWorkTO, tManager);
			}
			logger.info("result	:	"+scheduleWorkTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return scheduleWorkTO.getexecuteResult();
		}
    }

    