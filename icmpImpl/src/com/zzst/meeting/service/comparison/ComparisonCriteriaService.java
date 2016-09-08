package com.zzst.meeting.service.comparison;


	import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
	
 /**	
 * class description: ComparisonCriteria Service 
 * @date  Fri Apr 26 16:04:41 CST 2013
 * @author ryan
 */
    public interface ComparisonCriteriaService {
		 
		/**
		 * method description : add ComparisonCriteriaVO	object
		 * @param ComparisonCriteriaVO
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public ComparisonCriteriaVO add(ComparisonCriteriaVO comparisonCriteriaVO ) throws Exception;

		/**
		 * method description : query	ComparisonCriteria	list
		 * @param ComparisonCriteriaVO
		 * @param PageController
		 * @return ArrayList<ComparisonCriteriaVO>
		 * @throws Exception
		 */
		public  ArrayList<ComparisonCriteriaVO> query(ComparisonCriteriaVO comparisonCriteriaVO,PageController pageController) throws Exception;

		/**
		 * method description : query	ComparisonCriteriaVO	by	id
		 * @param id
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public  ComparisonCriteriaVO queryByID(String id) throws Exception;

		/**
		 * method description : query	ComparisonCriteriaVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public   ArrayList<ComparisonCriteriaVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	ComparisonCriteriaVO	by id
		 * @param ComparisonCriteriaVO
		 * @return ComparisonCriteriaVO
		 * @throws Exception
		 */
		public ComparisonCriteriaVO modify(ComparisonCriteriaVO comparisonCriteriaVO )throws Exception;


		/**
		 * method description : delete ComparisonCriteriaVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete ComparisonCriteriaVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public int deleteByIDs(String id )throws Exception;
	}

    