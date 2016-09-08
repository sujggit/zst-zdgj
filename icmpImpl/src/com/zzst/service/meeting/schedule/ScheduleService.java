



	    	            
         
        	
		
	        
        	
		
        

    
	
    package com.zzst.service.meeting.schedule;
    

        import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.schedule.ScheduleVO;
	
 /**	
 * class description: Schedule Service 
 * @date  Mon Aug 29 16:18:14 CST 2016
 * @author ryan
 */
    public interface ScheduleService {
		 
		/**
		 * method description : add ScheduleVO	object
		 * @param ScheduleVO
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public ScheduleVO add(ScheduleVO scheduleVO ) throws Exception;

		/**
		 * method description : query	Schedule	list
		 * @param ScheduleVO
		 * @param PageController
		 * @return ArrayList<ScheduleVO>
		 * @throws Exception
		 */
		public  ArrayList<ScheduleVO> query(ScheduleVO scheduleVO,PageController pageController) throws Exception;

		/**
		 * method description : query	ScheduleVO	by	id
		 * @param id
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public  ScheduleVO queryByID(String id) throws Exception;

		/**
		 * method description : query	ScheduleVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public   ArrayList<ScheduleVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	ScheduleVO	by id
		 * @param ScheduleVO
		 * @return ScheduleVO
		 * @throws Exception
		 */
		public ScheduleVO modify(ScheduleVO scheduleVO )throws Exception;


		/**
		 * method description : delete ScheduleVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete ScheduleVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public void deleteByIDs(String id )throws Exception;
		/**
		 * 按周进行查询(以周为组进行查询)
		 * @throws Exception
		 */
		public ArrayList<ScheduleVO> queryByWeek(String scheduleTime,String status,PageController mPageController)throws Exception;
	}

    