package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;

/**
 * class description: EquipmentTerminal Service
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public interface EquipmentTerminalService {

	/**
	 * method description : add EquipmentTerminalVO object
	 * 
	 * @param EquipmentTerminalVO
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public EquipmentTerminalVO add(EquipmentTerminalVO equipmentTerminalVO) throws Exception;

	/**
	 * method description : query EquipmentTerminal list
	 * 
	 * @param EquipmentTerminalVO
	 * @param PageController
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentTerminalVO> query(EquipmentTerminalVO equipmentTerminalVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query EquipmentTerminalVO by id
	 * 
	 * @param id
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public EquipmentTerminalVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentTerminalVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentTerminalVO> queryByIDs(String ids) throws Exception;
	
	/**
	 * query by roomids
	 * @param ids
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentTerminalVO> queryByRoomIDs(String ids) throws Exception;
	/**
	 * 
	 * @param ips
	 * @return ArrayList<EquipmentTerminalVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentTerminalVO> queryByIPs(String ips) throws Exception;
	public ArrayList<EquipmentTerminalVO> queryByMeetingID(String ips) throws Exception;

	/**
	 * method description :modify EquipmentTerminalVO by id
	 * 
	 * @param EquipmentTerminalVO
	 * @return EquipmentTerminalVO
	 * @throws Exception
	 */
	public EquipmentTerminalVO modify(EquipmentTerminalVO equipmentTerminalVO) throws Exception;

	/**
	 * method description : delete EquipmentTerminalVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentTerminalVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
}
