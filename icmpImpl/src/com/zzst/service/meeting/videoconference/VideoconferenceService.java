package com.zzst.service.meeting.videoconference;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Videoconference Service
 * 
 * @author ryan
 * @date Mon Aug 17 16:17:45 CST 2009
 */

public interface VideoconferenceService {

	/**
	 * method description : addVideoconference
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO addVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : delVideoconference
	 * 
	 * @param VideoconferenceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delVideoconference(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException;

	public boolean delVideoconferenceByDetailId(VideoconferenceVO vVideoconferenceVO,
			TransactionManager tManager) throws SQLException ;
	
	/**
	 * method description : modify Videoconference state by id
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO delVideoconferenceForState(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify Videoconference all columns by id
	 * 
	 * @param VideoconferenceVO
	 * @return VideoconferenceVO
	 * @throws SQLException
	 */
	public VideoconferenceVO modifyVideoconference(
			VideoconferenceVO vVideoconferenceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : getVideoconferenceList
	 * 
	 * @param VideoconferenceVO
	 * @return ArrayList<VideoconferenceVO>
	 * @throws SQLException
	 */
	public ArrayList<VideoconferenceVO> getVideoconferenceList(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController)
			throws SQLException;
	
	public ArrayList<VideoconferenceVO> getVideoconferenceListNoMeetingroom(
			VideoconferenceVO vVideoconferenceVO, PageController mPageController) throws SQLException;

}

