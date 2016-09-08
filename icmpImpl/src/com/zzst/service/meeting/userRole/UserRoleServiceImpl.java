package com.zzst.service.meeting.userRole;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.userRole.UserRoleDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: UserRole Impl
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserRoleServiceImpl implements UserRoleService {

	private static Logger logger = CbfLogger
			.getLogger(UserRoleServiceImpl.class.getName());

	/**
	 * method description : addUserRole
	 * 
	 * @param UserRoleVO
	 * @return UserRoleVO
	 * @throws SQLException
	 */
	public UserRoleVO addUserRole(ArrayList<UserRoleVO> urlist,
			TransactionManager tManager) throws SQLException {
		return UserRoleDAO.addUserRole(urlist, tManager);
	}

	/**
	 * method description : getUserRoleList
	 * 
	 * @param UserRoleVO
	 * @return ArrayList<UserRoleVO>
	 * @throws SQLException
	 */
	public ArrayList<UserRoleVO> getUserRoleList(UserRoleVO vUserRoleVO,
			PageController mPageController) throws SQLException {
		return UserRoleDAO.getUserRoleList(vUserRoleVO, mPageController);
	}
	
	/**
	 * 根据角色查询用户
	 */
	public ArrayList<UserRoleVO> getUserByRole(UserRoleVO vUserRoleVO,
			PageController mPageController) throws SQLException{
		return UserRoleDAO.getUserByrole(vUserRoleVO, mPageController);
	}

	/**
	 * method description : delUserRole
	 * 
	 * @param UserRoleVO
	 * @return boolean
	 * @throws SQLException
	 */
//	public boolean delUserRole(UserRoleVO vUserRoleVO,
//			TransactionManager tManager) throws SQLException {
//		boolean re = false;
//		if (1 == UserRoleDAO.delUserRole(vUserRoleVO, tManager)) {
//			re = true;
//		}
//		return re;
//	}

	/**
	 * method description : modify UserRole all columns by id
	 * 
	 * @param UserRoleVO
	 * @return UserRoleVO
	 * @throws SQLException
	 */
	public UserRoleVO modifyUserRole(UserVO user,
			TransactionManager tManager) throws SQLException {
		UserRoleDAO.delUserRole(user, tManager);
		return UserRoleDAO.addUserRole(user.getUserRoleVOList(), tManager);
	}

	@Override
	public void delAllUserRole(TransactionManager tManager) throws SQLException {
		UserRoleDAO.delAllUserRole(tManager);
		
	}
	
	@Override
	public void delUserRole(UserRoleVO vUserRoleVO,TransactionManager tManager) throws SQLException {
		UserRoleDAO.delUserRoleTwo(vUserRoleVO,tManager);
		
	}

}
