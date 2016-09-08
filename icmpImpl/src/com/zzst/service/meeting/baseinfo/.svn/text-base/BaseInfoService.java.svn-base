package com.zzst.service.meeting.baseinfo;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.config.BaseInfoVO;

/**
 * class description: BaseInfo Service
 * 
 * @date Fri Jun 15 10:26:01 CST 2012
 * @author ryan
 */
public interface BaseInfoService {

	/**
	 * method description : add BaseInfoVO object
	 * 
	 * @param BaseInfoVO
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public BaseInfoVO add(BaseInfoVO baseInfoVO) throws Exception;

	/**
	 * method description : query BaseInfo list
	 * 
	 * @param BaseInfoVO
	 * @param PageController
	 * @return ArrayList<BaseInfoVO>
	 * @throws Exception
	 */
	public ArrayList<BaseInfoVO> query(BaseInfoVO baseInfoVO, PageController pageController) throws Exception;

	/**
	 * method description : query BaseInfo list
	 * 
	 * @param BaseInfoVO
	 * @param PageController
	 * @return ArrayList<BaseInfoVO>
	 * @throws Exception
	 */
	public ArrayList<BaseInfoVO> queryForKstInit(BaseInfoVO baseInfoVO, PageController pageController) throws Exception;

	
	/**
	 * method description : query BaseInfoVO by id
	 * 
	 * @param id
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public BaseInfoVO queryByID(String id) throws Exception;

	/**
	 * method description : query BaseInfoVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public ArrayList<BaseInfoVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify BaseInfoVO by id
	 * 
	 * @param BaseInfoVO
	 * @return BaseInfoVO
	 * @throws Exception
	 */
	public BaseInfoVO modify(BaseInfoVO baseInfoVO) throws Exception;

	/**
	 * method description : delete BaseInfoVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete BaseInfoVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public boolean delete(BaseInfoVO baseInfoVO) throws Exception;
}
