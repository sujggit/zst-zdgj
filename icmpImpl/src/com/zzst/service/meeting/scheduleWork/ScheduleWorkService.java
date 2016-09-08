



	    	            
         
        	
		
	        
        	
		
        

    
	
    package com.zzst.service.meeting.scheduleWork;
    

        import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;
	
 /**	
 * class description: ScheduleWork Service 
 * @date  Mon Aug 22 16:03:33 CST 2016
 * @author ryan
 */
    public interface ScheduleWorkService {
		 
		/**
		 * method description : add ScheduleWorkVO	object
		 * @param ScheduleWorkVO
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public ScheduleWorkVO add(ScheduleWorkVO scheduleWorkVO ) throws Exception;

		/**
		 * method description : query	ScheduleWork	list
		 * @param ScheduleWorkVO
		 * @param PageController
		 * @return ArrayList<ScheduleWorkVO>
		 * @throws Exception
		 */
		public  ArrayList<ScheduleWorkVO> query(ScheduleWorkVO scheduleWorkVO,PageController pageController) throws Exception;

		/**
		 * method description : query	ScheduleWorkVO	by	id
		 * @param id
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public  ScheduleWorkVO queryByID(String id) throws Exception;

		/**
		 * method description : query	ScheduleWorkVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public   ArrayList<ScheduleWorkVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	ScheduleWorkVO	by id
		 * @param ScheduleWorkVO
		 * @return ScheduleWorkVO
		 * @throws Exception
		 */
		public ScheduleWorkVO modify(ScheduleWorkVO scheduleWorkVO )throws Exception;


		/**
		 * method description : delete ScheduleWorkVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete ScheduleWorkVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public void deleteByIDs(String id )throws Exception;
	}

    