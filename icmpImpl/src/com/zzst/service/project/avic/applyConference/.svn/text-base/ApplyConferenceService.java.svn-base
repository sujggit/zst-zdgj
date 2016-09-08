package com.zzst.service.project.avic.applyConference;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

/**	
 * class description: ApplyConference Service 
 * @date  Wed Sep 19 16:15:16 CST 2012
 * @author ryan
 */
public interface ApplyConferenceService {

	/**
	 * method description : add ApplyConferenceVO	object
	 * @param ApplyConferenceVO
	 * @return ApplyConferenceVO
	 * @throws Exception
	 */
	public ApplyConferenceVO add(ApplyConferenceVO applyConferenceVO)
			throws Exception;

	/**
	 * method description : query	ApplyConference	list
	 * @param ApplyConferenceVO
	 * @param PageController
	 * @return ArrayList<ApplyConferenceVO>
	 * @throws Exception
	 */
	public ArrayList<ApplyConferenceVO> query(
			ApplyConferenceVO applyConferenceVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query	ApplyConferenceVO	by	id
	 * @param id
	 * @return ApplyConferenceVO
	 * @throws Exception
	 */
	public ApplyConferenceVO queryByID(String id) throws Exception;

	/**
	 * method description : query	ApplyConferenceVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return ApplyConferenceVO
	 * @throws Exception
	 */
	public ArrayList<ApplyConferenceVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	ApplyConferenceVO	by id
	 * @param ApplyConferenceVO
	 * @return ApplyConferenceVO
	 * @throws Exception
	 */
	public ApplyConferenceVO modify(ApplyConferenceVO applyConferenceVO)
			throws Exception;

	/**
	 * method description : delete ApplyConferenceVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete ApplyConferenceVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * 查询未曾提交过服务申请的会议
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ApplyConferenceVO> getNoServiceConference() throws Exception;

	/**
	 * 根据用户id查出该人要审批的视频会议申请会议
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyConferenceVO> queryApplyConferences(ApplyConferenceVO applyConferenceVO ,UserVO userVO ,PageController pageController) throws Exception;
	/**
	 * 根据用户id查出该人审批的视频会议历史数据
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(ApplyConferenceVO applyConferenceVO,UserVO userVO ,PageController pageController) throws Exception;

	/**
	 * 查出所有审批的视频会议历史数据
	 * @param userVO
	 * @return
	 */
	public ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(ApplyConferenceVO applyConferenceVO,PageController pageController) throws Exception;

	/**
	 * 查出当前时间段的申请表记录
	 * @param applyConferenceVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ApplyConferenceVO> queryBusyMeetingRoom(
			ApplyConferenceVO applyConferenceVO, PageController pageController) throws Exception;
}
