package com.zzst.service.meeting.videoconference;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.videoconference.VideoconferenceDAO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Videoconference Impl
 * 
 * @author ryan
 * @date Mon Aug 17 16:17:45 CST 2009
 */

public class VideoconferenceServiceImpl implements VideoconferenceService {

	private static Logger logger = CbfLogger
			.getLogger(VideoconferenceServiceImpl.class.getName());

	/**
	 * method description : addVideoconference
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO addVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException {
		return VideoconferenceDAO.addVideoconference(vVideoconferenceVO, tManager);
	}

	/**
	 * method description : getVideoconferenceList
	 * 
	 * @param VideoconferenceVO
	 * @return ArrayList<VideoconferenceVO>
	 * @throws SQLException
	 */
	public ArrayList<VideoconferenceVO> getVideoconferenceList(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController)
			throws SQLException {
		return VideoconferenceDAO.getVideoconferenceList(vVideoconferenceVO,
				mPageController);
	}

	public ArrayList<VideoconferenceVO> getVideoconferenceListNoMeetingroom(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController)
			throws SQLException {
		return VideoconferenceDAO.getVideoconferenceListNoMeetingroom(vVideoconferenceVO,
				mPageController);
	}

	/**
	 * method description : delVideoconference
	 * 
	 * @param VideoconferenceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delVideoconference(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == VideoconferenceDAO.delVideoconference(vVideoconferenceVO,
				tManager)) {
			re = true;
		}
		return re;
	}
	
	public boolean delVideoconferenceByDetailId(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == VideoconferenceDAO.delVideoconferenceByDetailId(vVideoconferenceVO,
				tManager)) {
			re = true;
		}
		return re;
	}
	/**
	 * method description : modify Videoconference state by id
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO delVideoconferenceForState(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException {
		return modifyVideoconference(vVideoconferenceVO, tManager);
	}

	/**
	 * method description : modify Videoconference all columns by id
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO modifyVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException {
		return VideoconferenceDAO.modifyVideoconference(vVideoconferenceVO,
				tManager);
	}

}
