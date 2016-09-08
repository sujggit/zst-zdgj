package com.zzst.service.meeting.meetingDetailRoom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;


public interface MeetingDetailRoomService {

	
	public MeetingDetailRoomVO addMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException;

	public MeetingDetailRoomVO modifyMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException;

	
	public ArrayList<MeetingDetailRoomVO> getMeetingDetailRoomList(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			PageController mPageController) throws SQLException;
	
	public int delMeetingDetailRoom(MeetingDetailRoomVO vMeetingDetailRoomVO,
			PageController mPageController) throws SQLException;

}

