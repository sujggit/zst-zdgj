package com.zzst.dao.project.avic.videoConferenceFeedBack;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.project.avic.applySysInsert.ApplySysInsertDAO;
import com.zzst.model.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackVO;

/**
 * class description: VideoConferenceFeedBack DAO
 * 
 * @date Tue Sep 25 17:18:45 CST 2012
 * @author ryan
 */
public class VideoConferenceFeedBackDAO {
	private static Logger logger = CjfLogger.getLogger(ApplySysInsertDAO.class
			.getName());

	private static final String id = "ApplyID";

	/**
	 * add ApplySysInsertVO object
	 * 
	 * @param ApplySysInsertVO
	 * @param TransactionManager
	 * @return ApplySysInsertVO
	 * @throws Exception
	 */
	public static VideoConferenceFeedBackVO add(VideoConferenceFeedBackVO feedBackVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
//		feedBackVO.setFeedBackID(UtilDAO.getUUid());
		VideoConferenceFeedBackTO feedBackTO = new VideoConferenceFeedBackTO(
				VideoConferenceFeedBackTO.ADD_VIDEOCONFERENCEFEEDBACK, feedBackVO);

		feedBackTO.setSqlStr();
		logger.info("sqlStr	:	" + feedBackTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(feedBackTO, true);
		} else {
			TransactionTemplate.executeTransaction(feedBackTO, tManager);
		}
		logger.info("DAO	add	end");
		return feedBackVO;
	}

	/**
	 * query VideoConferenceFeedBackVO list
	 * 
	 * @param VideoConferenceFeedBackVO
	 * @param PageController
	 * @return ArrayList<VideoConferenceFeedBackVO>
	 * @throws Exception
	 */
	public static ArrayList<VideoConferenceFeedBackVO> query(
			VideoConferenceFeedBackVO feedBackVO, PageController pageController)
			throws Exception {
		logger.info("DAO	query	begin");
		VideoConferenceFeedBackMQB feedBackMQB = new VideoConferenceFeedBackMQB(
				VideoConferenceFeedBackMQB.QUERY_FROM_VIDEO_FEEDBACK, feedBackVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + feedBackMQB.getSql());
		QueryTemplate.executeQueryForList(feedBackMQB, pageController);
		logger.info("list size	:	"
				+ feedBackMQB.getListVideoConferenceFeedBack().size());
		logger.info("DAO	query	end");
		return feedBackMQB.getListVideoConferenceFeedBack();
	}

	/**
	 * query VideoConferenceFeedBackVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<VideoConferenceFeedBackVO>
	 * @throws Exception
	 */
	public static ArrayList<VideoConferenceFeedBackVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		VideoConferenceFeedBackMQB feedBackMQB = new VideoConferenceFeedBackMQB(
				VideoConferenceFeedBackMQB.QUERY_FROM_VIDEO_FEEDBACK_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + feedBackMQB.getSql());
		QueryTemplate.executeQueryForList(feedBackMQB, pageController);
		logger.info("list size	:	"
				+ feedBackMQB.getListVideoConferenceFeedBack().size());
		logger.info("DAO	queryByIDs	end");
		return feedBackMQB.getListVideoConferenceFeedBack();
	}

	/**
	 * modify VideoConferenceFeedBackVO column by ID
	 * 
	 * @param VideoConferenceFeedBackVO
	 * @param TransactionManager
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public static VideoConferenceFeedBackVO modify(VideoConferenceFeedBackVO feedBackVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		VideoConferenceFeedBackTO feedBackTO = new VideoConferenceFeedBackTO(
				VideoConferenceFeedBackTO.MODIFY_VIDEOCONFERENCEFEEDBACK, feedBackVO);
		feedBackTO.setSqlStr();
		logger.info("sqlStr	:	" + feedBackTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(feedBackTO, true);
		} else {
			TransactionTemplate.executeTransaction(feedBackTO, tManager);
		}
		logger.info("DAO	modify	end");
		return feedBackVO;
	}

	/**
	 * delete VideoConferenceFeedBackVO by ids
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		VideoConferenceFeedBackVO feedBackVO = new VideoConferenceFeedBackVO();
		feedBackVO.setFeedBackID(ids);
		VideoConferenceFeedBackTO feedBackTO = new VideoConferenceFeedBackTO(
				VideoConferenceFeedBackTO.DEL_VIDEOCONFERENCEFEEDBACK, feedBackVO);

		feedBackTO.setSqlStr();
		logger.info("sqlStr	:	" + feedBackTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(feedBackTO, true);
		} else {
			TransactionTemplate.executeTransaction(feedBackTO, tManager);
		}
		logger.info("result	:	" + feedBackTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return feedBackTO.getexecuteResult();
	}
	
	/**
	 * add VideoConferenceFeedBackVO object
	 * 
	 * @param VideoConferenceFeedBackVO
	 * @param TransactionManager
	 * @return VideoConferenceFeedBackVO
	 * @throws Exception
	 */
	public static VideoConferenceFeedBackVO addByUUID(VideoConferenceFeedBackVO feedBackVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	addByUUID	begin");
		VideoConferenceFeedBackTO feedBackTO = new VideoConferenceFeedBackTO(
				VideoConferenceFeedBackTO.ADD_VIDEOCONFERENCEFEEDBACK, feedBackVO);

		feedBackTO.setSqlStr();
		logger.info("sqlStr	:	" + feedBackTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(feedBackTO, true);
		} else {
			TransactionTemplate.executeTransaction(feedBackTO, tManager);
		}
		logger.info("DAO	addByUUID	end");
		return feedBackVO;
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<VideoConferenceFeedBackVO> queryApplySysInsert(String ids,VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsert	begin");
		VideoConferenceFeedBackMQB feedBackMQB = new VideoConferenceFeedBackMQB(
				VideoConferenceFeedBackMQB.QUERY_FROM_BY_USERID,feedBackVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + feedBackMQB.getSql());
		QueryTemplate.executeQueryForList(feedBackMQB, pageController);
		logger.info("list size	:	"
						+ feedBackMQB.getListVideoConferenceFeedBack().size());
		logger.info("DAO	queryApplySysInsert	end");
		return feedBackMQB.getListVideoConferenceFeedBack();
	}
	
	/**
	 * 根据用户登录id查询其接入审批信息历史
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<VideoConferenceFeedBackVO> queryApplySysInsertHistory(String ids,VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsertHistory	begin");
		VideoConferenceFeedBackMQB feedBackMQB = new VideoConferenceFeedBackMQB(
				VideoConferenceFeedBackMQB.QUERY_HISTORY_FROM_BY_USERID,feedBackVO, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + feedBackMQB.getSql());
		QueryTemplate.executeQueryForList(feedBackMQB, pageController);
		logger.info("list size	:	"
						+ feedBackMQB.getListVideoConferenceFeedBack().size());
		logger.info("DAO	queryApplySysInsertHistory	end");
		return feedBackMQB.getListVideoConferenceFeedBack();
	}
	
	
	/**
	 * 查询会议问题反馈审批信息历史
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<VideoConferenceFeedBackVO> queryApplySysInsertHistory(VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("DAO queryApplySysInsertHistory	begin");
		VideoConferenceFeedBackMQB feedBackMQB = new VideoConferenceFeedBackMQB(
				VideoConferenceFeedBackMQB.QUERY_HISTORY_ALL,feedBackVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + feedBackMQB.getSql());
		QueryTemplate.executeQueryForList(feedBackMQB, pageController);
		logger.info("list size	:	"
						+ feedBackMQB.getListVideoConferenceFeedBack().size());
		logger.info("DAO	queryApplySysInsertHistory	end");
		return feedBackMQB.getListVideoConferenceFeedBack();
	}
}
