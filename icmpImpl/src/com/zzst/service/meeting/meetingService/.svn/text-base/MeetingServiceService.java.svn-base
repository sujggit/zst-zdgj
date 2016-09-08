package com.zzst.service.meeting.meetingService;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService Service
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public interface MeetingServiceService {

	/**
	 * method description : addMeetingService
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO addMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : delMeetingService
	 * 
	 * @param MeetingServiceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingService(MeetingServiceVO vMeetingServiceVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify MeetingService state by id
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO delMeetingServiceForState(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify MeetingService all columns by id
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO modifyMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : getMeetingServiceList
	 * 
	 * @param MeetingServiceVO
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingServiceVO> getMeetingServiceList(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException;
	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param mPageController
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingServiceVO> getMeetingServiceListAllVO(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException;
}
