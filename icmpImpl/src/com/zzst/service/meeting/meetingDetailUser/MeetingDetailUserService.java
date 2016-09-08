package com.zzst.service.meeting.meetingDetailUser;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;

/**
 * class description: MeetingDetailUser Service
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public interface MeetingDetailUserService {

	/**
	 * method description : addMeetingDetailUser
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO addMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : delMeetingDetailUser
	 * 
	 * @param MeetingDetailUserVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * delete a meeting's users
	 * @param vMeetingDetailUserVO
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public boolean delMeetingDetailUserByDetailId(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException;
	/**
	 * method description : modify MeetingDetailUser state by id
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO delMeetingDetailUserForState(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify MeetingDetailUser all columns by id
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO modifyMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : getMeetingDetailUserList
	 * 
	 * @param MeetingDetailUserVO
	 * @return ArrayList<MeetingDetailUserVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingDetailUserVO> getMeetingDetailUserList(
			MeetingDetailUserVO vMeetingDetailUserVO,
			PageController mPageController) throws SQLException;

}

