package com.zzst.service.meeting.equipmentMCUPool;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.equipmentMCUPool.EquipmentMCUPoolVO;

/**
 * class description: EquipmentMCUPool Service
 * 
 * @date Thu Jan 31 09:29:38 CST 2013
 * @author ryan
 */
public interface EquipmentMCUPoolService {

	/**
	 * method description : add EquipmentMCUPoolVO object
	 * 
	 * @param EquipmentMCUPoolVO
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public EquipmentMCUPoolVO add(EquipmentMCUPoolVO equipmentMCUPoolVO)
			throws Exception;

	/**
	 * method description : query EquipmentMCUPool list
	 * 
	 * @param EquipmentMCUPoolVO
	 * @param PageController
	 * @return ArrayList<EquipmentMCUPoolVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentMCUPoolVO> query(
			EquipmentMCUPoolVO equipmentMCUPoolVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query EquipmentMCUPoolVO by id
	 * 
	 * @param id
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public EquipmentMCUPoolVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentMCUPoolVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentMCUPoolVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify EquipmentMCUPoolVO by id
	 * 
	 * @param EquipmentMCUPoolVO
	 * @return EquipmentMCUPoolVO
	 * @throws Exception
	 */
	public EquipmentMCUPoolVO modify(EquipmentMCUPoolVO equipmentMCUPoolVO)
			throws Exception;

	/**
	 * method description : delete EquipmentMCUPoolVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentMCUPoolVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
