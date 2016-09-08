package com.zzst.service.meeting.apply.flow;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;

/**
 * class description: ApplyFlow Service
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public interface ApplyFlowService {

	/**
	 * method description : add ApplyFlowVO object
	 * 
	 * @param ApplyFlowVO
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public ApplyFlowVO add(ApplyFlowVO applyFlowVO) throws Exception;

	/**
	 * method description : query ApplyFlow list
	 * 
	 * @param ApplyFlowVO
	 * @param PageController
	 * @return ArrayList<ApplyFlowVO>
	 * @throws Exception
	 */
	public ArrayList<ApplyFlowVO> query(ApplyFlowVO applyFlowVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ApplyFlowVO by id
	 * 
	 * @param id
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public ApplyFlowVO queryByID(String id) throws Exception;

	/**
	 * method description : query ApplyFlowVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public ArrayList<ApplyFlowVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ApplyFlowVO by id
	 * 
	 * @param ApplyFlowVO
	 * @return ApplyFlowVO
	 * @throws Exception
	 */
	public ApplyFlowVO modify(ApplyFlowVO applyFlowVO) throws Exception;

	/**
	 * method description : delete ApplyFlowVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplyFlowVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
