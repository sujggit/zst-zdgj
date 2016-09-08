package com.zzst.service.meeting.log;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.log.LogVO;

/**
 * class description: Log Service
 * 
 * @date Tue Nov 29 14:55:07 CST 2011
 * @author ryan
 */
public interface LogService {

	/**
	 * method description : add LogVO object
	 * 
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	public LogVO add(LogVO logVO) throws Exception;

	/**
	 * method description : query Log list
	 * 
	 * @param LogVO
	 * @param PageController
	 * @return ArrayList<LogVO>
	 * @throws Exception
	 */
	public ArrayList<LogVO> query(LogVO logVO, PageController pageController) throws Exception;

	/**
	 * method description : query LogVO by id
	 * 
	 * @param id
	 * @return LogVO
	 * @throws Exception
	 */
	public LogVO queryByID(String id) throws Exception;

	/**
	 * method description : query LogVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return LogVO
	 * @throws Exception
	 */
	public ArrayList<LogVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify LogVO by id
	 * 
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	public LogVO modify(LogVO logVO) throws Exception;

	/**
	 * method description : delete LogVO by id
	 * 物理删除
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete LogVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<LogVO> queryInital(LogVO logVO, PageController pageController) throws Exception;
}
