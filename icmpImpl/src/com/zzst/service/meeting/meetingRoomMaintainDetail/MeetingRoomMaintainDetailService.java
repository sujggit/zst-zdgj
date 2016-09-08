package com.zzst.service.meeting.meetingRoomMaintainDetail;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintainDetail Service
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public interface MeetingRoomMaintainDetailService {

	/**
	 * method description : add MeetingRoomMaintainDetailVO object
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainDetailVO add(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO)
			throws Exception;

	/**
	 * method description : query MeetingRoomMaintainDetail list
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainDetailVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainDetailVO> query(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingRoomMaintainDetailVO by id
	 * 
	 * @param id
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainDetailVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingRoomMaintainDetailVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainDetailVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify MeetingRoomMaintainDetailVO by id
	 * 
	 * @param MeetingRoomMaintainDetailVO
	 * @return MeetingRoomMaintainDetailVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainDetailVO modify(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO)
			throws Exception;

	/**
	 * method description : delete MeetingRoomMaintainDetailVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * duting 20120926
	 */
	
	public int deleteByMaintainID(String maintainID) throws Exception;
	/**
	 * method description : delete MeetingRoomMaintainDetailVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
