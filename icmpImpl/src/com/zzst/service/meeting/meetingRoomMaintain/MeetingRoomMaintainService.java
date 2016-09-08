package com.zzst.service.meeting.meetingRoomMaintain;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;

/**
 * class description: MeetingRoomMaintain Service
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public interface MeetingRoomMaintainService {

	/**
	 * method description : add MeetingRoomMaintainVO object
	 * 
	 * @param MeetingRoomMaintainVO
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainVO add(MeetingRoomMaintainVO meetingRoomMaintainVO)
			throws Exception;

	/**
	 * method description : query MeetingRoomMaintain list
	 * 
	 * @param MeetingRoomMaintainVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomMaintainVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainVO> query(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingRoomMaintainVO by id
	 * 
	 * @param id
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingRoomMaintainVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify MeetingRoomMaintainVO by id
	 * 
	 * @param MeetingRoomMaintainVO
	 * @return MeetingRoomMaintainVO
	 * @throws Exception
	 */
	public MeetingRoomMaintainVO modify(
			MeetingRoomMaintainVO meetingRoomMaintainVO) throws Exception;

	/**
	 * method description : delete MeetingRoomMaintainVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(MeetingRoomMaintainVO meetingRoomMaintainVO) throws Exception;

	/**
	 * method description : delete MeetingRoomMaintainVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;

	/**
	 * 会场记录~与会议相关,检查项明细
	 * @param meetingRoomMaintainVO
	 * @param pControler
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainVO> queryRoomMaintainConference(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pControler) throws Exception;
	
	/**
	 * 会场记录~与会议相关，group by 会议、会议室
	 * @param meetingRoomMaintainVO
	 * @param pControler
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingRoomMaintainVO> queryRoomMaintain(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pControler) throws Exception;
}
