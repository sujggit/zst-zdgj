 package com.zzst.service.meeting.informationUser;
    

	import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.informationUser.InformationUserVO;
	
 /**	
 * class description: InformationUser Service 
 * @date  Tue Jan 29 18:25:43 CST 2013
 * @author ryan
 */
    public interface InformationUserService {
		 
		/**
		 * method description : add InformationUserVO	object
		 * @param InformationUserVO
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public InformationUserVO add(InformationUserVO informationUserVO ) throws Exception;

		/**
		 * method description : query	InformationUser	list
		 * @param InformationUserVO
		 * @param PageController
		 * @return ArrayList<InformationUserVO>
		 * @throws Exception
		 */
		public  ArrayList<InformationUserVO> query(InformationUserVO informationUserVO,PageController pageController) throws Exception;

		/**
		 * method description : query	InformationUserVO	by	id
		 * @param id
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public  InformationUserVO queryByID(String id) throws Exception;

		/**
		 * method description : query	InformationUserVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public   ArrayList<InformationUserVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	InformationUserVO	by id
		 * @param InformationUserVO
		 * @return InformationUserVO
		 * @throws Exception
		 */
		public InformationUserVO modify(InformationUserVO informationUserVO )throws Exception;


		/**
		 * method description : delete InformationUserVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete InformationUserVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public int deleteByIDs(String id )throws Exception;
	}

    