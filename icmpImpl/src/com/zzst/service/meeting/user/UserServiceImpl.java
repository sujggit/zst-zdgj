package com.zzst.service.meeting.user;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.user.UserDAO;
import com.zzst.dao.meeting.userRole.UserRoleDAO;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.auth.FuncService;
import com.zzst.service.meeting.auth.FuncServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

/**
 * class description: User Impl
 * 
 * @author ryan
 * @date Mon Jul 27 10:00:55 CST 2009
 */

public class UserServiceImpl implements UserService {

	private static Logger logger = CbfLogger.getLogger(UserServiceImpl.class
			.getName());

	/**
	 * method description : userLogin all
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO userLogin(UserVO vUserVO)throws SQLException {
		ArrayList<UserVO> list = UserDAO.userLogin(vUserVO, null);

			if (list == null || list.size() == 0){
				logger.debug("UserServiceImpl  userLogin  userList  is   null");
				return null;
			}
			UserVO reUserVO = (UserVO) list.get(0);
			
			//修改用户登录时间
			//reUserVO.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			//modifyUser(reUserVO,null);
			
			// 角色
			UserRoleVO userRoleVO = new UserRoleVO();
			userRoleVO.setUserID(reUserVO.getUserID());
			
			ArrayList<UserRoleVO> roleList = new UserRoleServiceImpl().getUserRoleList(userRoleVO, null);

			if(roleList == null || roleList.size()==0){
				logger.debug("UserServiceImpl  userLogin  roleList  is   null");
				return null;
			}
			reUserVO.setUserRoleVOList(roleList);
			
			//查询用户功能
			ArrayList<FuncVO> ulist = new FuncServiceImpl().getFuncList(reUserVO, null);
			reUserVO.setFuncVOList(ulist);
			
			// 部门
//			UserDepartmentVO vUserDepartmentVO= new UserDepartmentVO();
//			vUserDepartmentVO.setUserVO(reUserVO);
//			
//			ArrayList<UserDepartmentVO> userDepartmentVOList=new UserDepartmentServiceImpl().getUserDepartmentList(vUserDepartmentVO, null);
//			
//			if(userDepartmentVOList==null&&userDepartmentVOList.size()==0){
//				logger.debug("UserServiceImpl  userLogin  departmentList  is   null");
//				return null;
//			}
//			reUserVO.setUserDepartmentVOList(userDepartmentVOList);
			
			return reUserVO;
	}

	/**
	 * method description : addUser
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO addUser(UserVO vUserVO, TransactionManager tManager)
			throws Exception {
		vUserVO.setState(UserEnum.VALID);
		vUserVO.setRevision(Long.MIN_VALUE);
		return UserDAO.addUser(vUserVO, tManager);
	}

	/**
	 * method description : getUserList
	 * 
	 * @param UserVO
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
	public ArrayList<UserVO> getUserList(UserVO vUserVO,
			PageController mPageController) throws SQLException {
		return UserDAO.getUserList(vUserVO, mPageController);
	}

	/**
	 * method description : getUserList
	 * 
	 * @param UserVO
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
	public ArrayList<UserVO> getUserAllInfoList(UserVO vUserVO,
			PageController mPageController) throws SQLException {
		return UserDAO.getUserList(vUserVO, mPageController);
	}
	
	public ArrayList<UserVO> getUserListbyName(UserVO vUserVO,
			PageController mPageController) throws SQLException {
		//return UserDAO.getUserListbyName(vUserVO, mPageController);
		
		ArrayList<UserVO> list = UserDAO.getUserListbyName(vUserVO, null);

		if (list == null || list.size() == 0){
			logger.debug("UserServiceImpl  userLogin  userList  is   null");
			return null;
		}
		UserVO reUserVO = (UserVO) list.get(0);
		
		//修改用户登录时间
		//reUserVO.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		//modifyUser(reUserVO,null);
		
		// 角色
		UserRoleVO userRoleVO = new UserRoleVO();
		userRoleVO.setUserID(reUserVO.getUserID());
		
		ArrayList<UserRoleVO> roleList = new UserRoleServiceImpl().getUserRoleList(userRoleVO, null);

		if(roleList == null || roleList.size()==0){
			logger.debug("UserServiceImpl  userLogin  roleList  is   null");
			return null;
		}
		reUserVO.setUserRoleVOList(roleList);
		
		//查询用户功能
		ArrayList<FuncVO> ulist = new FuncServiceImpl().getFuncList(reUserVO, null);
		reUserVO.setFuncVOList(ulist);
		
		// 部门
//		UserDepartmentVO vUserDepartmentVO= new UserDepartmentVO();
//		vUserDepartmentVO.setUserVO(reUserVO);
//		
//		ArrayList<UserDepartmentVO> userDepartmentVOList=new UserDepartmentServiceImpl().getUserDepartmentList(vUserDepartmentVO, null);
//		
//		if(userDepartmentVOList==null&&userDepartmentVOList.size()==0){
//			logger.debug("UserServiceImpl  userLogin  departmentList  is   null");
//			return null;
//		}
//		reUserVO.setUserDepartmentVOList(userDepartmentVOList);
		
		return list;
		
	}
	
	/**
	 * method description : delUser
	 * 
	 * @param UserVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delUser(UserVO vUserVO, TransactionManager tManager)
			throws SQLException {
		boolean re = false;
		if (1 == UserDAO.delUser(vUserVO, tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify User state by id
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO delUserForState(UserVO vUserVO, TransactionManager tManager)
			throws SQLException {
		UserDAO.delUser(vUserVO, tManager);
		UserRoleDAO.delUserRole(vUserVO, tManager);
		return vUserVO;
	}

	/**
	 * method description : modify User all columns by id
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO modifyUser(UserVO vUserVO, TransactionManager tManager)
			throws SQLException {
		return UserDAO.modifyUser(vUserVO, tManager);
	}
	
	/**
	 * method description : modify User all columns by id
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO modifyUserByLoginName(UserVO vUserVO, TransactionManager tManager)
			throws SQLException {
		return UserDAO.modifyUserByLoginName(vUserVO, tManager);
	}
	
	/**
	 * method description : get User info
	 * 
	 * @param UserVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO getUserInfo(UserVO vUserVO, TransactionManager tManager)
			throws SQLException {
		if( getUserList(vUserVO, null).size()>0){
			return (UserVO) getUserList(vUserVO, null).get(0);
		}else{
			return null;
		}
		
	};
	
	
	/**
	 * 不能使用--有bug
	 * 根据id查询，多个id已‘,分开’ 如：1,2,3
	 * @param String id   
	 * @param mPageController
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
//	public ArrayList<UserVO> getListForIDS(String ids,
//			PageController mPageController) throws SQLException {
//		return UserDAO.getListForIDS(ids, mPageController);
//	}

	/**
	 * 根据部门id查询所有人员
	 */
	@Override
	public ArrayList<UserVO> getUsersByDeprtmentID(String departmentID,
			PageController mPageController) throws SQLException {
		
		return UserDAO.getUsersByDeprtmentID(departmentID, mPageController);
	}

	@Override
	public UserVO addUserByCreateId(UserVO vUserVO, TransactionManager tManager)
			throws Exception {
		vUserVO.setState(UserEnum.VALID);
		vUserVO.setRevision(Long.MIN_VALUE);
		return UserDAO.addUserByCreateId(vUserVO, tManager);
	}

	@Override
	public void delAllUser(TransactionManager tManager)
			throws SQLException {
		UserDAO.delAll(tManager);
		
	}

	@Override
	public ArrayList<UserVO> getUsersByDeptPost(UserVO vUserVO,
			PageController mPageController) throws Exception {
		return UserDAO.getUsersByDeptPost(vUserVO, mPageController);
	}
	
}
