package com.zzst.service.meeting.meetingroomEquipment;


import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;

/**
 * class description: MeetingroomEquipment Service
 * 
 * @date Fri Jul 19 14:33:03 CST 2013
 * @author ryan
 */
public interface MeetingroomEquipmentService {

	/**
	 * method description : add MeetingroomEquipmentVO object
	 * 
	 * @param MeetingroomEquipmentVO
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public MeetingroomEquipmentVO add(
			MeetingroomEquipmentVO meetingroomEquipmentVO) throws Exception;

	/**
	 * method description : query MeetingroomEquipment list
	 * 
	 * @param MeetingroomEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingroomEquipmentVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingroomEquipmentVO> query(
			MeetingroomEquipmentVO meetingroomEquipmentVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query MeetingroomEquipmentVO by id
	 * 
	 * @param id
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public MeetingroomEquipmentVO queryByID(String id) throws Exception;

	/**
	 * method description : query MeetingroomEquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public ArrayList<MeetingroomEquipmentVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify MeetingroomEquipmentVO by id
	 * 
	 * @param MeetingroomEquipmentVO
	 * @return MeetingroomEquipmentVO
	 * @throws Exception
	 */
	public MeetingroomEquipmentVO modify(
			MeetingroomEquipmentVO meetingroomEquipmentVO) throws Exception;

	/**
	 * method description : delete MeetingroomEquipmentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete MeetingroomEquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
