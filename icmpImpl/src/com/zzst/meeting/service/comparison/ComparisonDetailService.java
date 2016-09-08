package com.zzst.meeting.service.comparison;


import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;

/**	
 * class description: ComparisonDetail Service 
 * @date  Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public interface ComparisonDetailService {

	/**
	 * method description : add ComparisonDetailVO	object
	 * @param ComparisonDetailVO
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public ComparisonDetailVO add(ComparisonDetailVO comparisonDetailVO ) throws Exception;

	/**
	 * method description : query	ComparisonDetail	list
	 * @param ComparisonDetailVO
	 * @param PageController
	 * @return ArrayList<ComparisonDetailVO>
	 * @throws Exception
	 */
	public  ArrayList<ComparisonDetailVO> query(ComparisonDetailVO comparisonDetailVO,PageController pageController) throws Exception;

	/**
	 * method description : query	ComparisonDetailVO	by	id
	 * @param id
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public  ComparisonDetailVO queryByID(String id) throws Exception;

	/**
	 * method description : query	ComparisonDetailVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public   ArrayList<ComparisonDetailVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	ComparisonDetailVO	by id
	 * @param ComparisonDetailVO
	 * @return ComparisonDetailVO
	 * @throws Exception
	 */
	public ComparisonDetailVO modify(ComparisonDetailVO comparisonDetailVO )throws Exception;


	/**
	 * method description : delete ComparisonDetailVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id )throws Exception;

	/**
	 * method description : delete ComparisonDetailVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id )throws Exception;
}

