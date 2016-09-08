package com.zzst.service.meeting.dataInterface.meetingRoom;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: MeetingRoomInterface Service
 * 
 * @date Fri May 24 16:23:45 CST 2013
 * @author ryan
 */
public interface MeetingRoomInterfaceService {

	/**
	 * method description : add MeetingRoomInterfaceVO object
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public MeetingRoomInterfaceVO add(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) throws Exception;

	/**
	 * method description : query MeetingRoomInterface list
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomInterfaceVO> query(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingRoomInterfaceVO by id
	 * 
	 * @param id
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public MeetingRoomInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingRoomInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomInterfaceVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify MeetingRoomInterfaceVO by id
	 * 
	 * @param MeetingRoomInterfaceVO
	 * @return MeetingRoomInterfaceVO
	 * @throws Exception
	 */
	public MeetingRoomInterfaceVO modify(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) throws Exception;

	/**
	 * method description : delete MeetingRoomInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete MeetingRoomInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	
	public ArrayList<MeetingRoomInterfaceVO> queryAvailable(
			MeetingRoomInterfaceVO meetingRoomInterfaceVO,
			PageController pageController) throws Exception;
	
	public int deleteAll() throws Exception;
}
