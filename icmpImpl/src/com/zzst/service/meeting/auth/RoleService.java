package com.zzst.service.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.auth.RoleVO;

/**
 * class description: Role Service
 * 
 * @author ryan
 * @date Mon Jul 27 11:45:13 CST 2009
 */

public interface RoleService {

	/**
	 * method description : addRole
	 * 
	 * @param RoleVO
	 * @return RoleVO
	 * @throws SQLException
	 */
	public RoleVO addRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException;
	
	public RoleVO addRoleByCreateId(RoleVO vRoleVO, TransactionManager tManager)
	throws SQLException;

	/**
	 * method description : delRole
	 * 
	 * @param RoleVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify Role all columns by id
	 * 
	 * @param RoleVO
	 * @return RoleVO
	 * @throws SQLException
	 */
	public RoleVO modifyRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : getRoleList
	 * 
	 * @param RoleVO
	 * @return ArrayList<RoleVO>
	 * @throws SQLException
	 */
	public ArrayList<RoleVO> getRoleList(RoleVO vRoleVO,
			PageController mPageController) throws SQLException;

}
