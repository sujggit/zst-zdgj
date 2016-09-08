package com.zzst.service.project.avic.applyVideoExport;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applyVideoExport.ApplyVideoExportVO;

/**
 * class description: ApplyVideoExport Service
 * 
 * @date Tue Sep 25 16:50:34 CST 2012
 * @author ryan
 */
public interface ApplyVideoExportService {
	/**
	 * method description : add ApplyVideoExportVO object
	 * 
	 * @param ApplyVideoExportVO
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public ApplyVideoExportVO add(ApplyVideoExportVO applyVideoExportVO)
			throws Exception;

	/**
	 * method description : query ApplyVideoExport list
	 * 
	 * @param ApplyVideoExportVO
	 * @param PageController
	 * @return ArrayList<ApplyVideoExportVO>
	 * @throws Exception
	 */
	public ArrayList<ApplyVideoExportVO> query(ApplyVideoExportVO applyVideoExportVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query ApplyVideoExportVO by id
	 * 
	 * @param id
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public ApplyVideoExportVO queryByID(String id) throws Exception;

	/**
	 * method description : query ApplyVideoExportVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public ArrayList<ApplyVideoExportVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify ApplyVideoExportVO by id
	 * 
	 * @param ApplyVideoExportVO
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public ApplyVideoExportVO modify(ApplyVideoExportVO applyVideoExportVO)
			throws Exception;

	/**
	 * method description : delete ApplyVideoExportVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplyVideoExportVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * add ApplyVideoExportVO object
	 * action中需要自己生成uuid
	 * @param ApplyVideoExportVO
	 * @param TransactionManager
	 * @return ApplyVideoExportVO
	 * @throws Exception
	 */
	public ApplyVideoExportVO addByUUID(ApplyVideoExportVO applyVideoExportVO)throws Exception;
	
	/**
	 * 根据用户id查出该人要审批的视频会议申请会议
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExport(UserVO userVO,ApplyVideoExportVO applyVideoExportVO, PageController pageController) throws Exception;
	/**
	 * 根据用户id查出该人审批的资料导出申请会议历史
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(UserVO userVO,ApplyVideoExportVO applyVideoExportVO, PageController pageController) throws Exception;
	
	/**
	 * 查询所以资料导出申请历史
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyVideoExportVO> queryApplyVideoExportHistory(ApplyVideoExportVO applyVideoExportVO, PageController pageController) throws Exception;
}
