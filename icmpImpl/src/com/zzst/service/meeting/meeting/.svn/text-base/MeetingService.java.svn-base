package com.zzst.service.meeting.meeting;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meeting.MeetingVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Meeting Service
 * 
 * @author ryan
 * @date Mon Aug 17 15:06:56 CST 2009
 */

public interface MeetingService {

	/**
	 * method description : addMeeting
	 * @param assignVO is not null, that means this meeting is assigned by other person. and admin help to subscribe meeting
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingDetailVO addMeeting(MeetingVO vMeetingVO, ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> equipmentList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception;

	/**
	 * method description : delMeeting
	 * 
	 * @param MeetingVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeeting(MeetingVO vMeetingVO, TransactionManager tManager)
			throws SQLException;
	
	/**
	 * method description : delMeeting
	 * 
	 * @param MeetingVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeeting(MeetingVO vMeetingVO, MeetingDetailVO meetingDetailVO, TransactionManager tManager)
			throws SQLException;

	
	/**
	 * method description : unDelMeeting
	 * 
	 * @param MeetingVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean unDelMeeting(MeetingVO vMeetingVO, MeetingDetailVO meetingDetailVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify Meeting state by id
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingVO delMeetingForState(MeetingVO vMeetingVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify Meeting all columns by id
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingVO modifyMeeting(MeetingVO vMeetingVO,
			TransactionManager tManager) throws Exception;

	/**
	 * method description : modifyMeetingTemplate
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingDetailVO modifyMeetingTemplate(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> equipmentList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception;
	
	
	/**
	 * method description : addMeeting
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
	public MeetingDetailVO modifyMeeting(MeetingVO vMeetingVO, MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<MeetingServiceVO> equipmentList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager) throws Exception;
	
	/**
	 * method description : getMeetingList
	 * 
	 * @param MeetingVO
	 * @return ArrayList<MeetingVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingVO> getMeetingList(MeetingVO vMeetingVO,
			PageController mPageController) throws SQLException;

	
	/**
	 * method description : add period Meeting
	 * 
	 * @param MeetingVO
	 * @return MeetingVO
	 * @throws SQLException
	 */
//	public MeetingVO preSubscribePeriodMeeting(MeetingVO vMeetingVO, TransactionManager tManager) throws Exception;
	
	/**
	 * add period meeting's participators, services and video conferences where period meeting status is APPROVED  
	 * @param meetingVO
	 * @param vMeetingDetailVO
	 * @throws SQLException
	 * @author wangle
	 * @since Sep 5, 2009
	 */
	public void addMeetingUVSInfo(MeetingVO meetingVO, MeetingDetailVO vMeetingDetailVO) throws SQLException;
	
	
	/**
	 * check if a  meeting's  room is available.  
	 * @param vMeetingDetailVO
	 * @return
	 * @author wangle
	 * @since Sep 8, 2009
	 */
	public boolean checkAvailableMeetingRoom(MeetingDetailVO vMeetingDetailVO, ArrayList<String> invalidList);
	
	/**
	 * @author chenshuo
	 * @param vMeetingDetailVO 会议对象
	 * @param userList 参会人员集合
	 * @param roomList 参会会场集合
	 * @param meetingType 会议状态(进行中 会议结束  会议模板)
	 * @param tManager
	 * @return
	 * @throws Exception
	 */
	public MeetingDetailVO addMeetingByStatus(MeetingDetailVO vMeetingDetailVO, ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList,
			TransactionManager tManager, int meetingType) throws Exception;
	

}

