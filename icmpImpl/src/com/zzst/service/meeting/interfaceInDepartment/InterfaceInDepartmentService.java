package com.zzst.service.meeting.interfaceInDepartment;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.model.meeting.interfaceInDepartment.InterfaceInDepartmentVO;

/**
 * class description: InterfaceInDepartment Service
 * 
 * @date Mon Jun 17 16:54:25 CST 2013
 * @author ryan
 */
public interface InterfaceInDepartmentService {

	/**
	 * method description : add InterfaceInDepartmentVO object
	 * 
	 * @param InterfaceInDepartmentVO
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public InterfaceInDepartmentVO add(
			InterfaceInDepartmentVO interfaceInDepartmentVO) throws Exception;

	/**
	 * method description : query InterfaceInDepartment list
	 * 
	 * @param InterfaceInDepartmentVO
	 * @param PageController
	 * @return ArrayList<InterfaceInDepartmentVO>
	 * @throws Exception
	 */
	public ArrayList<InterfaceInDepartmentVO> query(
			InterfaceInDepartmentVO interfaceInDepartmentVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query InterfaceInDepartmentVO by id
	 * 
	 * @param id
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public InterfaceInDepartmentVO queryByID(String id) throws Exception;

	/**
	 * method description : query InterfaceInDepartmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public ArrayList<InterfaceInDepartmentVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify InterfaceInDepartmentVO by id
	 * 
	 * @param InterfaceInDepartmentVO
	 * @return InterfaceInDepartmentVO
	 * @throws Exception
	 */
	public InterfaceInDepartmentVO modify(
			InterfaceInDepartmentVO interfaceInDepartmentVO) throws Exception;

	/**
	 * method description : delete InterfaceInDepartmentVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete InterfaceInDepartmentVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id) throws Exception;
}
