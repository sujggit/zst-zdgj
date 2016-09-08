package com.zzst.meeting.service.comparison;


import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.comparison.ComparisonVO;


/**	
 * class description: Comparison Service 
 * @date  Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public interface ComparisonService {

	/**
	 * method description : add ComparisonVO	object
	 * @param ComparisonVO
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public ComparisonVO add(ComparisonVO comparisonVO ) throws Exception;
	/**
	 * method description : add ComparisonVO	object
	 * @param ComparisonVO
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public ComparisonVO replace(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception;
	
	/**
	 * method description : 更新音频比对数据
	 * @param ComparisonVO
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public ComparisonVO replaceAudio(ComparisonVO comparisonVO,TransactionManager tManager)throws Exception;

	/**
	 * method description : query	Comparison	list
	 * @param ComparisonVO
	 * @param PageController
	 * @return ArrayList<ComparisonVO>
	 * @throws Exception
	 */
	public  ArrayList<ComparisonVO> query(ComparisonVO comparisonVO,PageController pageController) throws Exception;
	/**
	 * method description : query	Comparison	list
	 * @param ComparisonVO
	 * @param PageController
	 * @return ArrayList<ComparisonVO>
	 * @throws Exception
	 */
	public  ArrayList<ComparisonVO> queryHistory(ComparisonVO comparisonVO,PageController pageController) throws Exception;

	/**
	 * method description : query	ComparisonVO	by	id
	 * @param id
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public  ComparisonVO queryByID(String id) throws Exception;

	/**
	 * method description : query	ComparisonVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public   ArrayList<ComparisonVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	ComparisonVO	by id
	 * @param ComparisonVO
	 * @return ComparisonVO
	 * @throws Exception
	 */
	public ComparisonVO modify(ComparisonVO comparisonVO )throws Exception;


	/**
	 * method description : delete ComparisonVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id )throws Exception;

	/**
	 * method description : delete ComparisonVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id )throws Exception;
	/**
	 * method description : delete ComparisonVO by	MeetingDetailID
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByMeetingDetailID(String ids,TransactionManager tManager)throws Exception;
}

