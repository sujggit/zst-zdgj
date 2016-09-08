package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;

/**
 * class description: EquipmentBackup Service
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author ryan
 */
public interface EquipmentBackupService {

	/**
	 * method description : add EquipmentBackupVO object
	 * 
	 * @param EquipmentBackupVO
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public EquipmentBackupVO add(EquipmentBackupVO equipmentBackupVO)
			throws Exception;

	/**
	 * method description : query EquipmentBackup list
	 * 
	 * @param EquipmentBackupVO
	 * @param PageController
	 * @return ArrayList<EquipmentBackupVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentBackupVO> query(
			EquipmentBackupVO equipmentBackupVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query EquipmentBackupVO by id
	 * 
	 * @param id
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public EquipmentBackupVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentBackupVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentBackupVO> queryByIDs(String ids) throws Exception;

	
	/**
	 * method description :modify EquipmentBackupVO by id
	 * 
	 * @param EquipmentBackupVO
	 * @return EquipmentBackupVO
	 * @throws Exception
	 */
	public EquipmentBackupVO modify(EquipmentBackupVO equipmentBackupVO)
			throws Exception;

	/**
	 * method description : delete EquipmentBackupVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id, String bakcupId) throws Exception;

	public ArrayList<EquipmentBackupVO> queryByMeetingID(String meetingID)
			throws Exception;



	
}
