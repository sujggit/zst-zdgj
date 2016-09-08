package com.zzst.service.meeting.meetingRoom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: MeetingRoom Service
 * 
 * @author linsha
 * @date 2011-11-15
 */

public interface MeetingRoomService {
	
	/**
	 * method description : add MeetingRoomVO object
	 * 
	 * @param MeetingRoomVO
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public MeetingRoomVO add(MeetingRoomVO meetingRoomVO) throws Exception;
	/**
	 * method description : query MeetingRoom list
	 * 
	 * @param MeetingRoomVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomVO> query(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingRoomVO by id
	 * 
	 * @param id
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public MeetingRoomVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingRoomVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomVO> queryByIDs(String ids,PageController pageController) throws Exception ;

	/**
	 * method description :modify MeetingRoomVO by id
	 * 
	 * @param MeetingRoomVO
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public MeetingRoomVO modify(MeetingRoomVO meetingRoomVO) throws Exception;

	/**
	 * method description : delete MeetingRoomVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(MeetingRoomVO meetingRoomVO) throws Exception;

	/**
	 * method description : delete MeetingRoomVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return boolean
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<MeetingRoomVO> getEmptyMeetingRoomList(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException;
	
	//2012-12-9
	public String queryBydeptID(DepartmentVO departmentVO, PageController  pageController) throws Exception;
	
	//验证会议室是否重复2013-05-16
	public ArrayList<MeetingRoomVO> validate(MeetingRoomVO meetingRoomVO,PageController pageController) throws Exception;
	
	public MeetingRoomVO updateByRoomNO(MeetingRoomVO meetingRoomVO) throws Exception;
	public ArrayList<MeetingRoomVO> queryHaveTerminalMeetingRoom(MeetingRoomVO meetingRoomVO,PageController pageController) throws Exception;
	public ArrayList<MeetingRoomVO> getEmptyMeetingRoomListForWs(MeetingDetailVO vMeetingDetailVO, PageController pageController) throws SQLException;
	
}



