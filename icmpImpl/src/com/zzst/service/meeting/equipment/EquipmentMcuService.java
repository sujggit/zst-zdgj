package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;

/**
 * class description: EquipmentMcu Service
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public interface EquipmentMcuService {

	/**
	 * method description : add EquipmentMcuVO object
	 * 
	 * @param EquipmentMcuVO
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public EquipmentMcuVO add(EquipmentMcuVO equipmentMcuVO) throws Exception;

	/**
	 * method description : query EquipmentMcu list
	 * 
	 * @param EquipmentMcuVO
	 * @param PageController
	 * @return ArrayList<EquipmentMcuVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentMcuVO> query(EquipmentMcuVO equipmentMcuVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query EquipmentMcuVO by id
	 * 
	 * @param id
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public EquipmentMcuVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentMcuVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentMcuVO> queryByIDs(String ids) throws Exception;
	
	/**
	 * query by terminal ips
	 * @param ids
	 * @return  ArrayList<EquipmentMcuVO> 
	 * @throws Exception
	 */
	public ArrayList<EquipmentMcuVO> queryByIPs(String ips) throws Exception;
	public ArrayList<EquipmentMcuVO> queryByMeetingID(String id) throws Exception;

	/**
	 * method description :modify EquipmentMcuVO by id
	 * 
	 * @param EquipmentMcuVO
	 * @return EquipmentMcuVO
	 * @throws Exception
	 */
	public EquipmentMcuVO modify(EquipmentMcuVO equipmentMcuVO) throws Exception;

	/**
	 * method description : delete EquipmentMcuVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentMcuVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * 根据mcuid查询MCU对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EquipmentMcuVO queryByMCUID(String id) throws Exception;
}
