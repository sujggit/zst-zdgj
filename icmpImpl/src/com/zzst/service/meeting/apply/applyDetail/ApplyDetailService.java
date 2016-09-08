package com.zzst.service.meeting.apply.applyDetail;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;

/**
 * class description: ApplyDetail Service
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public interface ApplyDetailService {

	/**
	 * method description : add ApplyDetailVO object
	 * 
	 * @param ApplyDetailVO
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public ApplyDetailVO add(ApplyDetailVO applyDetailVO) throws Exception;

	/**
	 * method description : query ApplyDetail list
	 * 
	 * @param ApplyDetailVO
	 * @param PageController
	 * @return ArrayList<ApplyDetailVO>
	 * @throws Exception
	 */
	public ArrayList<ApplyDetailVO> query(ApplyDetailVO applyDetailVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ApplyDetailVO by id
	 * 
	 * @param id
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public ApplyDetailVO queryByID(String id) throws Exception;

	/**
	 * method description : query ApplyDetailVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public ArrayList<ApplyDetailVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ApplyDetailVO by id
	 * 
	 * @param ApplyDetailVO
	 * @return ApplyDetailVO
	 * @throws Exception
	 */
	public ApplyDetailVO modify(ApplyDetailVO applyDetailVO) throws Exception;

	/**
	 * method description : delete ApplyDetailVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplyDetailVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
