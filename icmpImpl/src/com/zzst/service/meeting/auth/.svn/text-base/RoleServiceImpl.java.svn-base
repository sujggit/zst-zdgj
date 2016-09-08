package com.zzst.service.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.dao.meeting.auth.RoleDAO;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

/**
 * class description: Role Impl
 * 
 * @author ryan
 * @date Mon Jul 27 11:45:13 CST 2009
 */

public class RoleServiceImpl implements RoleService {

	private static Logger logger = CbfLogger.getLogger(RoleServiceImpl.class.getName());

	/**
	 * method description : addRole
	 * 
	 * @param RoleVO
	 * @return RoleVO
	 * @throws SQLException
	 */
	public RoleVO addRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		return RoleDAO.addRole(vRoleVO, tManager);
	}

	/**
	 * method description : getRoleList
	 * 
	 * @param RoleVO
	 * @return ArrayList<RoleVO>
	 * @throws SQLException
	 */
	public ArrayList<RoleVO> getRoleList(RoleVO vRoleVO,
			PageController mPageController) throws SQLException {
		return RoleDAO.getRoleList(vRoleVO, mPageController);
	}

	/**
	 * method description : delRole
	 * 
	 * @param RoleVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		UserRoleVO vo = new UserRoleVO();
		vo.setRoleID(vRoleVO.getRoleID());
		ArrayList list=new UserRoleServiceImpl().getUserByRole(vo,null);
		 
		//如果角色存在关联，不能删除
		if(list!=null&&list.size()>0){
			return false;
		}
		 
		if (1 == RoleDAO.delRole(vRoleVO, tManager)) {
			return  true;
		}
		return false;
	}

	/**
	 * method description : modify Role all columns by id
	 * 
	 * @param RoleVO
	 * @return RoleVO
	 * @throws SQLException
	 */
	public RoleVO modifyRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		return RoleDAO.modifyRole(vRoleVO, tManager);
	}

	@Override
	public RoleVO addRoleByCreateId(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		return RoleDAO.addRoleCreateId(vRoleVO, tManager);
	}

	
}
