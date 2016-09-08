package com.zzst.service.meeting.statistics;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: MeetingRoom Service
 * 
 * @author linsha
 * @date 2011-11-15
 */

public interface StatisticsService {
	/**
	 * calculate meeting room counts and total using time 
	 * @param meetingRoomVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomVO> calculateMeetingRoom(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception;
}
