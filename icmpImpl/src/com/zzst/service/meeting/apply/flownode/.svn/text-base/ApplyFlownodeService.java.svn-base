package com.zzst.service.meeting.apply.flownode;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

/**
 * class description: ApplyFlownode Service
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public interface ApplyFlownodeService {

	/**
	 * method description : add ApplyFlownodeVO object
	 * 
	 * @param ApplyFlownodeVO
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public ApplyFlownodeVO add(ApplyFlownodeVO applyFlownodeVO)
			throws Exception;

	/**
	 * method description : query ApplyFlownode list
	 * 
	 * @param ApplyFlownodeVO
	 * @param PageController
	 * @return ArrayList<ApplyFlownodeVO>
	 * @throws Exception
	 */
	public ArrayList<ApplyFlownodeVO> query(ApplyFlownodeVO applyFlownodeVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ApplyFlownodeVO by id
	 * 
	 * @param id
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public ApplyFlownodeVO queryByID(String id) throws Exception;

	/**
	 * method description : query ApplyFlownodeVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public ArrayList<ApplyFlownodeVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ApplyFlownodeVO by id
	 * 
	 * @param ApplyFlownodeVO
	 * @return ApplyFlownodeVO
	 * @throws Exception
	 */
	public ApplyFlownodeVO modify(ApplyFlownodeVO applyFlownodeVO)
			throws Exception;

	/**
	 * method description : delete ApplyFlownodeVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplyFlownodeVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
	
	/**
	 * method description :关联表查询，与z_t_apply_flow关联
	 * @param applyFlownodeVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ApplyFlownodeVO> queryWithOthTab(ApplyFlownodeVO applyFlownodeVO,
			PageController pageController) throws Exception;
	
	/**
	 * method description :根据flowID删除信息
	 * @param applyFlownodeVO
	 * @throws Exception
	 */
	public boolean deleteByFlowID(ApplyFlownodeVO applyFlownodeVO) throws Exception;
}
