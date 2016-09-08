package com.zzst.service.meeting.dataInterface.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: EquipmentInterface Service
 * 
 * @date Mon Jul 01 16:11:19 CST 2013
 * @author ryan
 */
public interface EquipmentInterfaceService {

	/**
	 * method description : add EquipmentInterfaceVO object
	 * 
	 * @param EquipmentInterfaceVO
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public EquipmentInterfaceVO add(EquipmentInterfaceVO equipmentInterfaceVO)
			throws Exception;

	/**
	 * method description : query EquipmentInterface list
	 * 
	 * @param EquipmentInterfaceVO
	 * @param PageController
	 * @return ArrayList<EquipmentInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentInterfaceVO> query(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query EquipmentInterfaceVO by id
	 * 
	 * @param id
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public EquipmentInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentInterfaceVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify EquipmentInterfaceVO by id
	 * 
	 * @param EquipmentInterfaceVO
	 * @return EquipmentInterfaceVO
	 * @throws Exception
	 */
	public EquipmentInterfaceVO modify(EquipmentInterfaceVO equipmentInterfaceVO)
			throws Exception;

	/**
	 * method description : delete EquipmentInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<EquipmentInterfaceVO> queryAvailable(
			EquipmentInterfaceVO equipmentInterfaceVO,
			PageController pageController) throws Exception;
	
	public void deleteAll() throws Exception;
}
