



	    	            
         
        	
		
	        
        	
		
        

    
    		

    package com.zzst.dao.meeting.schedule;
    
    import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.schedule.ScheduleVO;

	/**
	 * class description:	Schedule DAO
	 * @date Mon Aug 29 16:18:14 CST 2016
	 * @author ryan
	 */
    public class ScheduleDAO {
		private static Logger logger = CjfLogger.getLogger(ScheduleDAO.class.getName());

		private static 	final	String	id="ScheduleId";
		
		/**
		 * add ScheduleVO	object
		 * @param ScheduleVO
		 * @param TransactionManager
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public static ScheduleVO add(ScheduleVO scheduleVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	add	begin");
			scheduleVO.setScheduleId(UtilDAO.getUUid());
			ScheduleTO scheduleTO=new ScheduleTO(ScheduleTO.ADD_SCHEDULE,scheduleVO);
			
			scheduleTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleTO, tManager);
			}
			logger.info("DAO	add	end");
			return scheduleVO;
		}
	

	
		/**
		 * query ScheduleVO	list
		 * @param ScheduleVO
		 * @param PageController
		 * @return ArrayList<ScheduleVO> 
		 * @throws Exception
		 */
		public static ArrayList<ScheduleVO> query(ScheduleVO scheduleVO,PageController pageController) throws Exception{
			logger.info("DAO	query	begin");
	 		ScheduleMQB scheduleMQB=new ScheduleMQB(ScheduleMQB.QUERY_FROM_SCHEDULE,scheduleVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleMQB, pageController);
			logger.info("list size	:	"+scheduleMQB.getScheduleList().size());
			logger.info("DAO	query	end");
			return scheduleMQB.getScheduleList();
		}
		
		/**
		 * query ScheduleVO	list	by	IDs
		 * @param String
		 * @param PageController
		 * @return ArrayList<ScheduleVO> 
		 * @throws Exception
		 */
		public static ArrayList<ScheduleVO> queryByIDs(String ids,PageController pageController) throws Exception{
			logger.info("DAO	queryByIDs	begin");
	 		ScheduleMQB scheduleMQB=new ScheduleMQB(ScheduleMQB.QUERY_FROM_SCHEDULE_BY_IDS,ids);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleMQB, pageController);
			logger.info("list size	:	"+scheduleMQB.getScheduleList().size());
			logger.info("DAO	queryByIDs	end");
			return scheduleMQB.getScheduleList();
		}

		/**
		 * modify ScheduleVO column by ID
		 * @param ScheduleVO
		 * @param TransactionManager
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public static ScheduleVO modify(ScheduleVO scheduleVO,TransactionManager tManager)throws Exception{
			logger.info("DAO	modify	begin");
			ScheduleTO scheduleTO=new ScheduleTO(ScheduleTO.MODIFY_SCHEDULE,scheduleVO);		
			scheduleTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleTO, tManager);
			}
			logger.info("DAO	modify	end");
			return scheduleVO;
		}
		
		
		
		/**
		 * delete	ScheduleVO by id
		 * @param String
		 * @param TransactionManager
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public static int deleteByID(String id,TransactionManager tManager)throws Exception{
			logger.info("DAO	deleteByID	begin");
			ScheduleVO scheduleVO = new ScheduleVO();
			scheduleVO.setScheduleId(id);
			ScheduleTO scheduleTO=new ScheduleTO(ScheduleTO.DEL_SCHEDULE,scheduleVO);
			
			scheduleTO.setSqlStr();
			logger.info("sqlStr	:	"+scheduleTO.getSqlStr());
			if (tManager == null) {
			   TransactionTemplate.executeTransaction(scheduleTO, true);
			}else{
			   TransactionTemplate.executeTransaction(scheduleTO, tManager);
			}
			logger.info("result	:	"+scheduleTO.getexecuteResult());
			logger.info("DAO	deleteByID	end");
			return scheduleTO.getexecuteResult();
		}
		public static ArrayList<ScheduleVO> queryByWeek(String scheduleTime,PageController pageController) throws Exception{
			logger.info("DAO	queryByWeek	begin");
			ScheduleVO scheduleVO = new ScheduleVO();
			scheduleVO.setScheduleTime(scheduleTime);
	 		ScheduleMQB scheduleMQB=new ScheduleMQB(ScheduleMQB.QUERY_BY_WEEK,scheduleVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleMQB, pageController);
			logger.info("list size	:	"+scheduleMQB.getScheduleList().size());
			logger.info("DAO	queryByWeek	end");
			return scheduleMQB.getScheduleList();
		}
		
		public static ArrayList<ScheduleVO> queryByWeek(String scheduleTime,String status,PageController pageController) throws Exception{
			logger.info("DAO	queryByWeek	begin");
			ScheduleVO scheduleVO = new ScheduleVO();
			scheduleVO.setScheduleTime(scheduleTime);
			if("1".equals(status))scheduleVO.setStatus(status);
	 		ScheduleMQB scheduleMQB=new ScheduleMQB(ScheduleMQB.QUERY_BY_WEEK_WITH_STATUS,scheduleVO);
			
			if(pageController==null){
				pageController=new PageController();
				pageController.setAll(true);
			}
			logger.info("sqlStr	:	"+scheduleMQB.getSql());
			QueryTemplate.executeQueryForList(scheduleMQB, pageController);
			logger.info("list size	:	"+scheduleMQB.getScheduleList().size());
			logger.info("DAO	queryByWeek	end");
			return scheduleMQB.getScheduleList();
		}
    }

    