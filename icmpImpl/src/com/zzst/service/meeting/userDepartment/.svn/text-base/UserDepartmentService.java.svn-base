package com.zzst.service.meeting.userDepartment;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;

/**
 * class description: UserDepartment Service
 * 
 * @author ryan
 * @date Thu Jul 30 09:56:08 CST 2009
 */

public interface UserDepartmentService {

	/**
	 * method description : addUserDepartment
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO addUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : delUserDepartment
	 * 
	 * @param UserDepartmentVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delUserDepartment(UserDepartmentVO vUserDepartmentVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify UserDepartment state by id
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO delUserDepartmentForState(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify UserDepartment all columns by id
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO modifyUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : getUserDepartmentList
	 * 
	 * @param UserDepartmentVO
	 * @return ArrayList<UserDepartmentVO>
	 * @throws SQLException
	 */
	public ArrayList<UserDepartmentVO> getUserDepartmentList(
			UserDepartmentVO vUserDepartmentVO, PageController mPageController)
			throws SQLException;
	
	public void delAllDepUser(TransactionManager tManager)throws SQLException;
	
}
