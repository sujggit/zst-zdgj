package com.zzst.service.meeting.dataInterface.department;

import java.util.ArrayList;
import com.cbf.db.PageController;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: DepartmentInterface Service
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public interface DepartmentInterfaceService {

	/**
	 * method description : add DepartmentInterfaceVO object
	 * 
	 * @param DepartmentInterfaceVO
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public DepartmentInterfaceVO add(DepartmentInterfaceVO departmentInterfaceVO,boolean ifAutoId)
			throws Exception;

	/**
	 * method description : query DepartmentInterface list
	 * 
	 * @param DepartmentInterfaceVO
	 * @param PageController
	 * @return ArrayList<DepartmentInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<DepartmentInterfaceVO> query(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query DepartmentInterfaceVO by id
	 * 
	 * @param id
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public DepartmentInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query DepartmentInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<DepartmentInterfaceVO> queryByIDs(String ids)
			throws Exception;

	/**
	 * method description :modify DepartmentInterfaceVO by id
	 * 
	 * @param DepartmentInterfaceVO
	 * @return DepartmentInterfaceVO
	 * @throws Exception
	 */
	public DepartmentInterfaceVO modify(
			DepartmentInterfaceVO departmentInterfaceVO) throws Exception;

	/**
	 * method description : delete DepartmentInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete DepartmentInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public int deleteAll() throws Exception; 
	
	public ArrayList<DepartmentInterfaceVO> queryAvailable(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception;
}
