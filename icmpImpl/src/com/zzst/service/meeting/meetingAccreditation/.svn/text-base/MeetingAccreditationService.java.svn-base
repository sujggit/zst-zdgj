package com.zzst.service.meeting.meetingAccreditation;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;

/**
 * class description: MeetingAccreditation Service
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public interface MeetingAccreditationService {

	/**
	 * method description : addMeetingAccreditation
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO addMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : delMeetingAccreditation
	 * 
	 * @param MeetingAccreditationVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify MeetingAccreditation state by id
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO delMeetingAccreditationForState(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify MeetingAccreditation all columns by id
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO modifyMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : getMeetingAccreditationList
	 * 
	 * @param MeetingAccreditationVO
	 * @return ArrayList<MeetingAccreditationVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingAccreditationVO> getMeetingAccreditationList(
			MeetingAccreditationVO vMeetingAccreditationVO,
			PageController mPageController) throws SQLException;

}

