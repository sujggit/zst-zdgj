package com.zzst.service.meeting.meetingDetailRoom;

import java.sql.SQLException;
import java.util.ArrayList;


import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.dao.meeting.meetingDetailRoom.MeetingDetailRoomDAO;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;
/**
 * 
 * @author zhangjy
 * @date 2014-01-15
 */
public  class MeetingDetailRoomServiceImpl implements MeetingDetailRoomService {

	

	
	@Override
	public ArrayList<MeetingDetailRoomVO> getMeetingDetailRoomList(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			PageController mPageController) throws SQLException {
		// TODO Auto-generated method stub
		return MeetingDetailRoomDAO.getMeetingDetailRoomList(vMeetingDetailRoomVO, mPageController);
	}

	@Override
	public MeetingDetailRoomVO modifyMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		return MeetingDetailRoomDAO.modifyMeetingDetailRoom(vMeetingDetailRoomVO, tManager);
	}

	@Override
	public MeetingDetailRoomVO addMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		vMeetingDetailRoomVO =MeetingDetailRoomDAO.addMeetingDetailRoom(vMeetingDetailRoomVO, tManager);
		return vMeetingDetailRoomVO;
	}
	@Override
	public int delMeetingDetailRoom(MeetingDetailRoomVO vMeetingDetailRoomVO,
			PageController mPageController) throws SQLException{
		int num = MeetingDetailRoomDAO.delMeetingDetailRoom(vMeetingDetailRoomVO, null);
		return num;
	}

}
