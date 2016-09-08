package com.zzst.service.meeting.equipment.maintain;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.dao.meeting.equipment.maintain.EquipmentMaintainDAO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;

/**
 * class description: EquipmentMaintain Service
 * 
 * @date Mon May 06 13:58:37 CST 2013
 * @author ryan
 */
public interface EquipmentMaintainService {

	/**
	 * method description : add EquipmentMaintainVO object
	 * 
	 * @param EquipmentMaintainVO
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public EquipmentMaintainVO add(EquipmentMaintainVO equipmentMaintainVO) throws Exception;

	/**
	 * method description : query EquipmentMaintain list
	 * 
	 * @param EquipmentMaintainVO
	 * @param PageController
	 * @return ArrayList<EquipmentMaintainVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentMaintainVO> query(EquipmentMaintainVO equipmentMaintainVO, PageController pageController)
			throws Exception;

	/**
	 * 
	 * @param equipmentMaintainVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<EquipmentMaintainVO> queryWhereSQLS(EquipmentMaintainVO equipmentMaintainVO, PageController pageController)
	throws Exception;
	/**
	 * method description : query EquipmentMaintainVO by id
	 * 
	 * @param id
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public EquipmentMaintainVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentMaintainVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentMaintainVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify EquipmentMaintainVO by id
	 * 
	 * @param EquipmentMaintainVO
	 * @return EquipmentMaintainVO
	 * @throws Exception
	 */
	public EquipmentMaintainVO modify(EquipmentMaintainVO equipmentMaintainVO) throws Exception;

	/**
	 * method description : delete EquipmentMaintainVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentMaintainVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
	
	public ArrayList<EquipmentMaintainVO> queryEquipmentMaintain(EquipmentMaintainVO equipmentMaintainVO,PageController pageController) throws Exception;
	
	public ArrayList<EquipmentMaintainVO> queryDetail(EquipmentMaintainVO equipmentMaintainVO,PageController pageController) throws Exception; 

}
