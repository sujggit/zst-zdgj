package com.zzst.service.meeting.centerControl;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.centerControl.CenterControlVO;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: CenterControl Service
 * 
 * @date Thu Jun 28 15:18:31 CST 2012
 * @author ryan
 */
public interface CenterControlService {

	/**
	 * method description : add CenterControlVO object
	 * 
	 * @param CenterControlVO
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public CenterControlVO add(CenterControlVO centerControlVO) throws Exception;

	/**
	 * method description : query CenterControl list
	 * 
	 * @param CenterControlVO
	 * @param PageController
	 * @return ArrayList<CenterControlVO>
	 * @throws Exception
	 */
	public ArrayList<CenterControlVO> query(CenterControlVO centerControlVO, PageController pageController)
			throws Exception;

	/**
	 * method description : query CenterControlVO by id
	 * 
	 * @param id
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public CenterControlVO queryByID(String id) throws Exception;

	/**
	 * method description : query CenterControlVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public ArrayList<CenterControlVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify CenterControlVO by id
	 * 
	 * @param CenterControlVO
	 * @return CenterControlVO
	 * @throws Exception
	 */
	public CenterControlVO modify(CenterControlVO centerControlVO) throws Exception;

	/**
	 * method description : delete CenterControlVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete CenterControlVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	/**
	 * method description : query CenterControlVO no duplicates
	 * @param CenterControlVO
	 * @return ArrayList<CenterControlVO>
	 * @throws Exception
	 */
	public ArrayList<CenterControlVO> queryNoDuplicates(CenterControlVO centerControlVO) throws Exception;
}
