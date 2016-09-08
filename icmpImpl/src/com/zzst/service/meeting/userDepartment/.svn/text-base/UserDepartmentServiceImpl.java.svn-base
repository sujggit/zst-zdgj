package com.zzst.service.meeting.userDepartment;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.userDepartment.UserDepartmentDAO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;

/**
 * class description: UserDepartment Impl
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDepartmentServiceImpl implements UserDepartmentService {

	private static Logger logger = CbfLogger
			.getLogger(UserDepartmentServiceImpl.class.getName());

	/**
	 * method description : addUserDepartment
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO addUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException {
		return UserDepartmentDAO.addUserDepartment(vUserDepartmentVO, tManager);
	}

	/**
	 * method description : getUserDepartmentList
	 * 
	 * @param UserDepartmentVO
	 * @return ArrayList<UserDepartmentVO>
	 * @throws SQLException
	 */
	public ArrayList<UserDepartmentVO> getUserDepartmentList(
			UserDepartmentVO vUserDepartmentVO, PageController mPageController)
			throws SQLException {
		return UserDepartmentDAO.getUserDepartmentList(vUserDepartmentVO,
				mPageController);
	}
	
	
	/**
	 * method description : delUserDepartment
	 * 
	 * @param UserDepartmentVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delUserDepartment(UserDepartmentVO vUserDepartmentVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == UserDepartmentDAO.delUserDepartment(vUserDepartmentVO,
				tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify UserDepartment state by id
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO delUserDepartmentForState(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException {
		return modifyUserDepartment(vUserDepartmentVO, tManager);
	}

	/**
	 * method description : modify UserDepartment all columns by id
	 * 
	 * @param UserDepartmentVO
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public UserDepartmentVO modifyUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException {
		return UserDepartmentDAO.modifyUserDepartment(vUserDepartmentVO,
				tManager);
	}

	@Override
	public void delAllDepUser(TransactionManager tManager) throws SQLException {
		UserDepartmentDAO.delAllDepUser(tManager);
	}

	

}
