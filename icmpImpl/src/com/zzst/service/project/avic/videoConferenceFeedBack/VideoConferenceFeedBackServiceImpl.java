package com.zzst.service.project.avic.videoConferenceFeedBack;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.applySysInsert.ApplySysInsertDAO;
import com.zzst.dao.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;
import com.zzst.model.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackVO;
import com.zzst.service.project.avic.applySysInsert.ApplySysInsertServiceImpl;

/**
 * class description: VideoConferenceFeedBack ServiceImpl
 * 
 * @date Tue Sep 25 17:18:45 CST 2012
 * @author ryan
 */
public class VideoConferenceFeedBackServiceImpl implements
		VideoConferenceFeedBackService {
	private static Logger logger = CjfLogger
			.getLogger(ApplySysInsertServiceImpl.class.getName());

	@Override
	public VideoConferenceFeedBackVO add(VideoConferenceFeedBackVO feedBackVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		feedBackVO = VideoConferenceFeedBackDAO.add(feedBackVO, null);
		logger.info("serviceImpl	add	end");
		return feedBackVO;
	}

	@Override
	public ArrayList<VideoConferenceFeedBackVO> query(VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<VideoConferenceFeedBackVO> listApplySysInsert = VideoConferenceFeedBackDAO
				.query(feedBackVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplySysInsert;
	}

	@Override
	public VideoConferenceFeedBackVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<VideoConferenceFeedBackVO> listApplySysInsert = VideoConferenceFeedBackDAO
				.queryByIDs(id, null);
		if (listApplySysInsert != null && listApplySysInsert.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplySysInsert.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<VideoConferenceFeedBackVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<VideoConferenceFeedBackVO> listApplySysInsert = VideoConferenceFeedBackDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplySysInsert;
	}

	@Override
	public VideoConferenceFeedBackVO modify(VideoConferenceFeedBackVO feedBackVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		feedBackVO = VideoConferenceFeedBackDAO.modify(feedBackVO, null);
		logger.info("serviceImpl	modify	end");
		return feedBackVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = VideoConferenceFeedBackDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = VideoConferenceFeedBackDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public VideoConferenceFeedBackVO addByUUID(VideoConferenceFeedBackVO feedBackVO)
			throws Exception {
		logger.info("serviceImpl	addByUUID	begin");
		feedBackVO = VideoConferenceFeedBackDAO.addByUUID(feedBackVO, null);
		logger.info("serviceImpl	addByUUID	end");
		return feedBackVO;
	}

	/**
	 * 根据用户登录id查询其接入审批信息
	 * 
	 * @param ids
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBack(UserVO userVO,
			VideoConferenceFeedBackVO feedBackVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryVideoFeedBack	begin");
		ArrayList<VideoConferenceFeedBackVO> listApply;
		listApply = VideoConferenceFeedBackDAO.queryApplySysInsert(userVO.getUserID(),
				feedBackVO, pageController);
		logger.info("serviceImpl queryVideoFeedBack	end");
		return listApply;
	}

	@Override
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBackHistory(
			UserVO userVO, VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryVideoFeedBackHistory	begin");
		ArrayList<VideoConferenceFeedBackVO> listApply;
		listApply = VideoConferenceFeedBackDAO.queryApplySysInsertHistory(userVO
				.getUserID(), feedBackVO, pageController);
		logger.info("serviceImpl queryVideoFeedBackHistory	end");
		return listApply;
	}
	
	@Override
	public ArrayList<VideoConferenceFeedBackVO> queryVideoFeedBackHistory(
			VideoConferenceFeedBackVO feedBackVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryVideoFeedBackHistory	begin");
		ArrayList<VideoConferenceFeedBackVO> listApply;
		listApply = VideoConferenceFeedBackDAO.queryApplySysInsertHistory(feedBackVO, pageController);
		logger.info("serviceImpl queryVideoFeedBackHistory	end");
		return listApply;
	}

}
