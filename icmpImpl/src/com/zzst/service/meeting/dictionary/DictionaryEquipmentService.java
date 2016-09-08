package com.zzst.service.meeting.dictionary;

import java.sql.SQLException;
import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;

/**
 * class description: DictionaryEquipment Service
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public interface DictionaryEquipmentService {

	/**
	 * method description : add DictionaryEquipmentVO object
	 * 
	 * @param DictionaryEquipmentVO
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public DictionaryEquipmentVO add(DictionaryEquipmentVO dictionaryEquipmentVO)
			throws Exception;

	/**
	 * method description : query DictionaryEquipment list
	 * 
	 * @param DictionaryEquipmentVO
	 * @param PageController
	 * @return ArrayList<DictionaryEquipmentVO>
	 * @throws Exception
	 */
	public ArrayList<DictionaryEquipmentVO> query(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception;
	
	/**
	 * 根据value值提取子节点列表
	 * @param value
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<DictionaryEquipmentVO> queryByDicValue(
			int value,
			PageController pageController) throws Exception;

	/**
	 * method description : query DictionaryEquipmentVO by id
	 * 
	 * @param id
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public DictionaryEquipmentVO queryByID(String id) throws Exception;

	/**
	 * method description : query DictionaryEquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public ArrayList<DictionaryEquipmentVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify DictionaryEquipmentVO by id
	 * 
	 * @param DictionaryEquipmentVO
	 * @return DictionaryEquipmentVO
	 * @throws Exception
	 */
	public DictionaryEquipmentVO modify(
			DictionaryEquipmentVO dictionaryEquipmentVO) throws Exception;

	/**
	 * method description : delete DictionaryEquipmentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete DictionaryEquipmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
	
	/**
	 * method description : 根据父节点的id查找其子节点
	 * athor:tanzanlong
	 * @return ArrayList；
	 * @throws Exception
	 */
	public ArrayList<DictionaryEquipmentVO> queryAllchildrenByID(String id) throws Exception;
	
	/**
	 * 根据pid查询网络拓扑树的一级节点。
	 * @param dictionaryEquipmentVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<DictionaryEquipmentVO> queryByPid(DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception;
	
	public ArrayList<DictionaryEquipmentVO> queryByStatusAndSysvalue(
			DictionaryEquipmentVO dictionaryEquipmentVO,
			PageController pageController) throws Exception;
}
