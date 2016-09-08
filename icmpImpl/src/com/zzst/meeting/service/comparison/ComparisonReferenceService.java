package com.zzst.meeting.service.comparison;

  import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
	
 /**	
 * class description: ComparisonReference Service 
 * @date  Sat Apr 27 11:12:39 CST 2013
 * @author ryan
 */
    public interface ComparisonReferenceService {
		 
		/**
		 * method description : add ComparisonReferenceVO	object
		 * @param ComparisonReferenceVO
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public ComparisonReferenceVO add(ComparisonReferenceVO comparisonReferenceVO ) throws Exception;

		/**
		 * method description : query	ComparisonReference	list
		 * @param ComparisonReferenceVO
		 * @param PageController
		 * @return ArrayList<ComparisonReferenceVO>
		 * @throws Exception
		 */
		public  ArrayList<ComparisonReferenceVO> query(ComparisonReferenceVO comparisonReferenceVO,PageController pageController) throws Exception;

		/**
		 * method description : query	ComparisonReferenceVO	by	id
		 * @param id
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public  ComparisonReferenceVO queryByID(String id) throws Exception;

		/**
		 * method description : query	ComparisonReferenceVO	by	ids
		 * @param String example: 1,2,3,4
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public   ArrayList<ComparisonReferenceVO> queryByIDs(String ids) throws Exception;

		/**
		 * method description :modify	ComparisonReferenceVO	by id
		 * @param ComparisonReferenceVO
		 * @return ComparisonReferenceVO
		 * @throws Exception
		 */
		public ComparisonReferenceVO modify(ComparisonReferenceVO comparisonReferenceVO )throws Exception;


		/**
		 * method description : delete ComparisonReferenceVO by	id
		 * @param String	
		 * @return boolean
		 * @throws Exception
		 */
		public boolean deleteByID(String id )throws Exception;

		/**
		 * method description : delete ComparisonReferenceVO by	ids
		 * @param String example: 1,2,3,4
		 * @return int
		 * @throws Exception
		 */
		public int deleteByIDs(String id )throws Exception;
	}

    