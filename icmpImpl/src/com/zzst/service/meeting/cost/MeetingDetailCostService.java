package com.zzst.service.meeting.cost;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;

/**
 * class description: MeetingDetailCost Service
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public interface MeetingDetailCostService {

	/**
	 * method description : add MeetingDetailCostVO object
	 * 
	 * @param MeetingDetailCostVO
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public MeetingDetailCostVO add(MeetingDetailCostVO meetingDetailCostVO)
			throws Exception;

	/**
	 * method description : query MeetingDetailCost list
	 * 
	 * @param MeetingDetailCostVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailCostVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailCostVO> query(
			MeetingDetailCostVO meetingDetailCostVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingDetailCostVO by id
	 * 
	 * @param id
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public MeetingDetailCostVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingDetailCostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailCostVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify MeetingDetailCostVO by id
	 * 
	 * @param MeetingDetailCostVO
	 * @return MeetingDetailCostVO
	 * @throws Exception
	 */
	public MeetingDetailCostVO modify(MeetingDetailCostVO meetingDetailCostVO)
			throws Exception;

	/**
	 * method description : delete MeetingDetailCostVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete MeetingDetailCostVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;

	/**
	 * method description : List MeetingDetailVO and MeetingDetailCostVO by ids
	 * @param meetingDetailCostVO
	 * @param pControler
	 * @return
	 * @throws Exception
	 */
	public List<MeetingDetailCostVO> queryMeetingDetail(
			MeetingDetailCostVO meetingDetailCostVO, PageController pControler) throws Exception;

	/**
	 * method description : only modify cout
	 * @param meetingDetailCostVO
	 * @throws Exception
	 */
	public MeetingDetailCostVO modifyCout(MeetingDetailCostVO meetingDetailCostVO) throws Exception;;
}
