



	    	            
         
        	
		
	        
        	
		
        

    
	
    package com.zzst.service.mobileInfo;
    

	import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.mobileInfo.MobileInfoVO;
	
 /**	
 * class description: MobileInfo Service 
 * @date  Mon Aug 01 09:37:00 CST 2016
 * @author ryan
 */
    public interface MobileInfoService {
		 
		/**
		 * method description : add MobileInfoVO	object
		 * @param MobileInfoVO
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public MobileInfoVO add(MobileInfoVO mobileInfoVO ) throws Exception;

		/**
		 * method description : query	MobileInfo	list
		 * @param MobileInfoVO
		 * @param PageController
		 * @return ArrayList<MobileInfoVO>
		 * @throws Exception
		 */
		public  ArrayList<MobileInfoVO> query(MobileInfoVO mobileInfoVO,PageController pageController) throws Exception;

		/**
		 * method description : query	MobileInfoVO	by	id
		 * @param id
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public  MobileInfoVO queryByID(String id) throws Exception;

		/**
		 * method description : query	MobileInfoVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public   ArrayList<MobileInfoVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	MobileInfoVO	by id
		 * @param MobileInfoVO
		 * @return MobileInfoVO
		 * @throws Exception
		 */
		public MobileInfoVO modify(MobileInfoVO mobileInfoVO )throws Exception;


		/**
		 * method description : delete MobileInfoVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete MobileInfoVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public void deleteByIDs(String id )throws Exception;
	}

    