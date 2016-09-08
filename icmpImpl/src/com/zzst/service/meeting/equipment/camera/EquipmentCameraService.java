package com.zzst.service.meeting.equipment.camera;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;

/**
 * class description: EquipmentCamera Service
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public interface EquipmentCameraService {

	/**
	 * method description : add EquipmentCameraVO object
	 * 
	 * @param EquipmentCameraVO
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public EquipmentCameraVO add(EquipmentCameraVO equipmentCameraVO)
			throws Exception;

	/**
	 * method description : query EquipmentCamera list
	 * 
	 * @param EquipmentCameraVO
	 * @param PageController
	 * @return ArrayList<EquipmentCameraVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentCameraVO> query(
			EquipmentCameraVO equipmentCameraVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query EquipmentCameraVO by id
	 * 
	 * @param id
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public EquipmentCameraVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentCameraVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentCameraVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify EquipmentCameraVO by id
	 * 
	 * @param EquipmentCameraVO
	 * @return EquipmentCameraVO
	 * @throws Exception
	 */
	public EquipmentCameraVO modify(EquipmentCameraVO equipmentCameraVO)
			throws Exception;

	/**
	 * method description : delete EquipmentCameraVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentCameraVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
