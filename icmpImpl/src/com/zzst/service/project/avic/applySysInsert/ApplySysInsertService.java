package com.zzst.service.project.avic.applySysInsert;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;

/**
 * class description: ApplySysInsert Service
 * 
 * @date Fri Sep 21 17:34:16 CST 2012
 * @author ryan
 */
public interface ApplySysInsertService {

	/**
	 * method description : add ApplySysInsertVO object
	 * 
	 * @param ApplySysInsertVO
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public ApplySysInsertVO add(ApplySysInsertVO applySysInsertVO)
			throws Exception;

	/**
	 * method description : query ApplySysInsert list
	 * 
	 * @param ApplySysInsertVO
	 * @param PageController
	 * @return ArrayList<ApplySysInsertVO>
	 * @throws Exception
	 */
	public ArrayList<ApplySysInsertVO> query(ApplySysInsertVO applySysInsertVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ApplySysInsertVO by id
	 * 
	 * @param id
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public ApplySysInsertVO queryByID(String id) throws Exception;

	/**
	 * method description : query ApplySysInsertVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public ArrayList<ApplySysInsertVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ApplySysInsertVO by id
	 * 
	 * @param ApplySysInsertVO
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public ApplySysInsertVO modify(ApplySysInsertVO applySysInsertVO)
			throws Exception;

	/**
	 * method description : delete ApplySysInsertVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplySysInsertVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * add ApplySysInsertVO object
	 * action中需要自己生成uuid
	 * @param ApplySysInsertVO
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public ApplySysInsertVO addByUUID(ApplySysInsertVO applySysInsertVO)throws Exception;
	
	/**
	 * 根据用户id查出该人要审批的视频会议申请会议
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplySysInsertVO> queryApplySysInsert(UserVO userVO,ApplySysInsertVO applySysInsertVO, PageController pageController) throws Exception;
	/**
	 * 根据用户id查出该人审批的系统接入申请历史
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(UserVO userVO,ApplySysInsertVO applySysInsertVO, PageController pageController) throws Exception;
	
	
	/**
	 * 查出所有审批的系统接入申请历史
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplySysInsertVO> queryApplySysInsertHistory(ApplySysInsertVO applySysInsertVO, PageController pageController) throws Exception;


}
