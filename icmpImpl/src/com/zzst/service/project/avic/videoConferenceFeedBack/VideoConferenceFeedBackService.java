package com.zzst.service.project.avic.videoConferenceFeedBack;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackVO;

/**
 * class description: VideoConferenceFeedBack Service
 * 
 * @date Tue Sep 25 17:18:45 CST 2012
 * @author ryan
 */
public interface VideoConferenceFeedBackService {

	/**
	 * method description : add ApplySysInsertVO object
	 * 
	 * @param ApplySysInsertVO
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public VideoConferenceFeedBackVO add(VideoConferenceFeedBackVO feedBackVO)
			throws Exception;

	/**
	 * method description : query ApplySysInsert list
	 * 
	 * @param feedBackVO
	 * @param PageController
	 * @return ArrayList<feedBackVO>
	 * @throws Exception
	 */
	public ArrayList<VideoConferenceFeedBackVO> query(VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query VideoConferenceFeedBackVO by id
	 * 
	 * @param id
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public VideoConferenceFeedBackVO queryByID(String id) throws Exception;

	/**
	 * method description : query VideoConferenceFeedBackVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public ArrayList<VideoConferenceFeedBackVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify VideoConferenceFeedBackVO by id
	 * 
	 * @param VideoConferenceFeedBackVO
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public VideoConferenceFeedBackVO modify(VideoConferenceFeedBackVO feedBackVO)
			throws Exception;

	/**
	 * method description : delete VideoConferenceFeedBackVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete VideoConferenceFeedBackVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * add VideoConferenceFeedBackVO object
	 * action中需要自己生成uuid
	 * @param VideoConferenceFeedBackVO
	 * @param TransactionManager
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public VideoConferenceFeedBackVO addByUUID(VideoConferenceFeedBackVO feedBackVO)throws Exception;
	
	/**
	 * 根据用户id查出该人要审批的视频会议申请会议
	 * @param userVO
	 * @return
	 */
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBack(UserVO userVO,VideoConferenceFeedBackVO feedBackVO, PageController pageController) throws Exception;
	/**
	 * 根据用户id查出该人审批的会议问题反馈申请历史
	 * @param userVO
	 * @return
	 */
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBackHistory(UserVO userVO,VideoConferenceFeedBackVO feedBackVO, PageController pageController) throws Exception;
	
	/**
	 * 查询所以会议问题反馈申请历史
	 * @return
	 */
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBackHistory(VideoConferenceFeedBackVO feedBackVO, PageController pageController) throws Exception;
}
