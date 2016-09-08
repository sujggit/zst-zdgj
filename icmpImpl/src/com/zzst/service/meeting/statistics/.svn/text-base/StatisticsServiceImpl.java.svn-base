package com.zzst.service.meeting.statistics;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meetingRoom.MeetingRoomDAO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: MeetingRoom Impl
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class StatisticsServiceImpl implements StatisticsService {
	private static Logger logger = CbfLogger.getLogger(StatisticsServiceImpl.class.getName());

	/**
	 * calculate meeting room counts and total using time 
	 * @param meetingRoomVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomVO> calculateMeetingRoom(
			MeetingRoomVO meetingRoomVO, PageController pageController)
			throws Exception {
		return MeetingRoomDAO.calculateMeetingRoom(meetingRoomVO, pageController);
	}
}
