package com.zzst.service.project.avic.service;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService Service
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public interface AvicServiceService {

	/**
	 * method description : add AvicServiceVO object
	 * 
	 * @param AvicServiceVO
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public AvicServiceVO add(AvicServiceVO avicServiceVO) throws Exception;

	/**
	 * method description : query AvicService list
	 * 
	 * @param AvicServiceVO
	 * @param PageController
	 * @return ArrayList<AvicServiceVO>
	 * @throws Exception
	 */
	public ArrayList<AvicServiceVO> query(AvicServiceVO avicServiceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query AvicServiceVO by id
	 * 
	 * @param id
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public AvicServiceVO queryByID(String id) throws Exception;

	/**
	 * method description : query AvicServiceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public ArrayList<AvicServiceVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify AvicServiceVO by id
	 * 
	 * @param AvicServiceVO
	 * @return AvicServiceVO
	 * @throws Exception
	 */
	public AvicServiceVO modify(AvicServiceVO avicServiceVO) throws Exception;

	/**
	 * method description : delete AvicServiceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete AvicServiceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * 根据用户id查出该人要审批的表单
	 * @param userVO
	 * @return
	 */
	public ArrayList<AvicServiceVO> queryApplyServices(AvicServiceVO avicServiceVO ,UserVO userVO , PageController pageController) throws Exception;
	
	/**
	 * 根据用户id查出该人审批的历史数据
	 * @param userVO
	 * @return
	 */
	public ArrayList<AvicServiceVO> queryApplyServicesHistory(AvicServiceVO avicServiceVO,UserVO userVO ,PageController pageController) throws Exception;
	
	/**
	 * 查出所有审批的历史数据
	 * @param userVO
	 * @return
	 */
	public ArrayList<AvicServiceVO> queryApplyServicesHistory(AvicServiceVO avicServiceVO,PageController pageController) throws Exception;
	
	/**
	 * 查出服务和视频申请表的相关数据，以供费用统计使用
	 * @param avicServiceVO
	 * @param object
	 * @return
	 */
	public List<AvicServiceVO> queryForCostStatistices(
			AvicServiceVO avicServiceVO, PageController pageController) throws Exception;
}
