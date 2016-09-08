package com.zzst.service.meeting.meetingDetailDepartment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;

/**
 * class description: MeetingDetailDepartMent Service
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public interface MeetingDetailDepartMentService {

	/**
	 * method description : add MeetingDetailDepartMentVO object
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public MeetingDetailDepartMentVO add(MeetingDetailDepartMentVO meetingDetailDepartMentVO,TransactionManager tManager) throws Exception;

	/**
	 * method description : query MeetingDetailDepartMent list
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailDepartMentVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailDepartMentVO> query(MeetingDetailDepartMentVO meetingDetailDepartMentVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingDetailDepartMentVO by id
	 * 
	 * @param id
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public MeetingDetailDepartMentVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingDetailDepartMentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailDepartMentVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify MeetingDetailDepartMentVO by id
	 * 
	 * @param MeetingDetailDepartMentVO
	 * @return MeetingDetailDepartMentVO
	 * @throws Exception
	 */
	public MeetingDetailDepartMentVO modify(MeetingDetailDepartMentVO meetingDetailDepartMentVO) throws Exception;

	/**
	 * method description : delete MeetingDetailDepartMentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete MeetingDetailDepartMentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
