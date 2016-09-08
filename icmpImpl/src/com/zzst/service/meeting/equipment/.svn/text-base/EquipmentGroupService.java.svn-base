package com.zzst.service.meeting.equipment;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: EquipmentGroup Service
 * 
 * @date Thu Apr 24 11:55:59 CST 2014
 * @author ryan
 */
public interface EquipmentGroupService {

	/**
	 * method description : add EquipmentGroupVO object
	 * 
	 * @param EquipmentGroupVO
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public EquipmentGroupVO add(EquipmentGroupVO equipmentGroupVO)
			throws Exception;

	/**
	 * method description : query EquipmentGroup list 注意：
	 * 查询当前表状态不为失效的数据，如果包含关联查询不过滤其状态。如：关联用户信息，不管用户是否正常都需要查询出该数据。 需要把关联信息的状态带到前台
	 * 
	 * @param EquipmentGroupVO
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentGroupVO> query(EquipmentGroupVO equipmentGroupVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query EquipmentGroup list 注意：
	 * 查询当前表状态不为失效的数据，如果包含关联查询不过滤其状态。如：关联用户信息，不管用户是否正常都需要查询出该数据。 需要把关联信息的状态带到前台
	 * 查询组的信息
	 * @param EquipmentGroupVO
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentGroupVO> query(PageController pageController) throws Exception;

	/**
	 * method description : query EquipmentGroupVO by id
	 * 
	 * @param id
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public EquipmentGroupVO queryByID(String id) throws Exception;

	/**
	 * method description : query EquipmentGroupVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public ArrayList<EquipmentGroupVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify EquipmentGroupVO by id
	 * 
	 * @param EquipmentGroupVO
	 * @return EquipmentGroupVO
	 * @throws Exception
	 */
	public EquipmentGroupVO modify(EquipmentGroupVO equipmentGroupVO)
			throws Exception;

	/**
	 * method description : delete EquipmentGroupVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete EquipmentGroupVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;

	/**
	 * method description : query EquipmentGroup list 注意： 全表模糊查询，效率差，谨慎使用。
	 * 
	 * @param EquipmentGroupVO
	 * @param PageController
	 * @return ArrayList<EquipmentGroupVO>
	 * @throws Exception
	 */
	public ArrayList<EquipmentGroupVO> queryFuzzySearch(String str,
			PageController pageController) throws Exception;

	
	public void deleteByName(String groupname) throws Exception;
}
