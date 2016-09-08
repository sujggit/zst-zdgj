package com.zzst.service.meeting.dataInterface.user;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;

/**
 * class description: UserInterface Service
 * 
 * @date Tue Jun 18 18:58:24 CST 2013
 * @author ryan
 */
public interface UserInterfaceService {

	/**
	 * method description : add UserInterfaceVO object
	 * 
	 * @param UserInterfaceVO
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public UserInterfaceVO add(UserInterfaceVO userInterfaceVO,boolean isAuto)
			throws Exception;
	
	public UserInterfaceVO addByCreateId(UserInterfaceVO userInterfaceVO)
	throws Exception;

	/**
	 * method description : query UserInterface list
	 * 
	 * @param UserInterfaceVO
	 * @param PageController
	 * @return ArrayList<UserInterfaceVO>
	 * @throws Exception
	 */
	public ArrayList<UserInterfaceVO> query(UserInterfaceVO userInterfaceVO,
			PageController pageController) throws Exception;

	/**
	 * method description : query UserInterfaceVO by id
	 * 
	 * @param id
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public UserInterfaceVO queryByID(String id) throws Exception;

	/**
	 * method description : query UserInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public ArrayList<UserInterfaceVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify UserInterfaceVO by id
	 * 
	 * @param UserInterfaceVO
	 * @return UserInterfaceVO
	 * @throws Exception
	 */
	public UserInterfaceVO modify(UserInterfaceVO userInterfaceVO)
			throws Exception;

	/**
	 * method description : delete UserInterfaceVO by id
	 * 
	 * @param String
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id) throws Exception;

	/**
	 * method description : delete UserInterfaceVO by ids
	 * 
	 * @param String
	 *            example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public int deleteByIDs(String id) throws Exception;
	
	public ArrayList<UserInterfaceVO> queryAvailable( UserInterfaceVO userInterfaceVO,
			PageController pageController ) throws Exception;
	
	public int deleteAll() throws Exception;
}
