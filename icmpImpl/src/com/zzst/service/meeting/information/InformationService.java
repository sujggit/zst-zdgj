package com.zzst.service.meeting.information;
    
	import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.information.InformationVO;
	
 /**	
 * class description: Information Service 
 * @date  Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
    public interface InformationService {
		 
		/**
		 * method description : add InformationVO	object
		 * @param InformationVO
		 * @return InformationVO
		 * @throws Exception
		 */
		public InformationVO add(InformationVO informationVO ) throws Exception;

		/**
		 * method description : query	Information	list
		 * @param InformationVO
		 * @param PageController
		 * @return ArrayList<InformationVO>
		 * @throws Exception
		 */
		public  ArrayList<InformationVO> query(InformationVO informationVO,PageController pageController) throws Exception;

		/**
		 * method description : query	Information	list
		 * @param InformationVO
		 * @param PageController
		 * @return ArrayList<InformationVO>
		 * @throws Exception
		 */
		public  ArrayList<InformationVO> queryNew(InformationVO informationVO,PageController pageController) throws Exception;

		
		/**
		 * method description : query	InformationVO	by	id
		 * @param id
		 * @return InformationVO
		 * @throws Exception
		 */
		public  InformationVO queryByID(String id) throws Exception;

		/**
		 * method description : query	InformationVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return InformationVO
		 * @throws Exception
		 */
		public   ArrayList<InformationVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	InformationVO	by id
		 * @param InformationVO
		 * @return InformationVO
		 * @throws Exception
		 */
		public InformationVO modify(InformationVO informationVO )throws Exception;


		/**
		 * method description : delete InformationVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete InformationVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public int deleteByIDs(String id )throws Exception;
	}

    