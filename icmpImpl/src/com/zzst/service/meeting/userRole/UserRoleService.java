package com.zzst.service.meeting.userRole;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: UserRole Service
 * 
 * @author ryan
 * @date Mon Jul 27 11:45:14 CST 2009
 */

public interface UserRoleService {

	/**
	 * method description : addUserRole
	 * 
	 * @param UserRoleVO
	 * @return UserRoleVO
	 * @throws SQLException
	 */
	public UserRoleVO addUserRole(ArrayList<UserRoleVO> urlist,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : delUserRole
	 * 
	 * @param UserRoleVO
	 * @return boolean
	 * @throws SQLException
	 */
//	public boolean delUserRole(UserRoleVO vUserRoleVO,
//			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify UserRole state by id
	 * 
	 * @param UserRoleVO
	 * @return UserRoleVO
	 * @throws SQLException
	 */
//	public UserRoleVO delUserRoleForState(UserRoleVO vUserRoleVO,
//			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify UserRole all columns by id
	 * 
	 * @param UserRoleVO
	 * @return UserRoleVO
	 * @throws SQLException
	 */
	public UserRoleVO modifyUserRole(UserVO user,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : getUserRoleList
	 * 
	 * @param UserRoleVO
	 * @return ArrayList<UserRoleVO>
	 * @throws SQLException
	 */
	public ArrayList<UserRoleVO> getUserRoleList(UserRoleVO vUserRoleVO,
			PageController mPageController) throws SQLException;
	
    //	��ݽ�ɫ��ѯ�û� 
	public ArrayList<UserRoleVO> getUserByRole(UserRoleVO vUserRoleVO,
			PageController mPageController) throws SQLException;
	
	public void delAllUserRole(TransactionManager tManager) throws SQLException;
	
	public void delUserRole(UserRoleVO vUserRoleVO,TransactionManager tManager) throws SQLException;
}
