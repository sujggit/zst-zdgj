package com.zzst.service.meeting.mcuCascadeModel;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;

/**
 * class description: McuCascadeModel Service
 * 
 * @date Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public interface McuCascadeModelService {

	/**
	 * method description : add McuCascadeModelVO object
	 * 
	 * @param McuCascadeModelVO
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public McuCascadeModelVO add(McuCascadeModelVO mcuCascadeModelVO)
			throws Exception;

	/**
	 * method description : query McuCascadeModel list
	 * 
	 * @param McuCascadeModelVO
	 * @param PageController
	 * @return ArrayList<McuCascadeModelVO>
	 * @throws Exception
	 */
	public ArrayList<McuCascadeModelVO> query(
			McuCascadeModelVO mcuCascadeModelVO, PageController pageController)
			throws Exception;

	/**
	 * method description : 查询该MCU下的所有模式
	 * 
	 * @param McuCascadeModelVO
	 * @param PageController
	 * @return ArrayList<McuCascadeModelVO>
	 * @throws Exception
	 */
	public ArrayList<McuCascadeModelVO> queryByMCUIP(
			String ip, PageController pageController)
			throws Exception;
	
	/**
	 * method description : query McuCascadeModelVO by id
	 * 
	 * @param id
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public McuCascadeModelVO queryByID(String id) throws Exception;

	/**
	 * method description : query McuCascadeModelVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public ArrayList<McuCascadeModelVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify McuCascadeModelVO by id
	 * 
	 * @param McuCascadeModelVO
	 * @return McuCascadeModelVO
	 * @throws Exception
	 */
	public McuCascadeModelVO modify(McuCascadeModelVO mcuCascadeModelVO)
			throws Exception;

	/**
	 * method description : delete McuCascadeModelVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete McuCascadeModelVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByMcuIP(String ip) throws Exception;

	/**
	 * method description : delete McuCascadeModelVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
