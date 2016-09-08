package com.zzst.dao.meeting.userRole;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: UserRole DAO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserRoleDAO {

	private static Logger logger = CbfLogger.getLogger(UserRoleDAO.class
			.getName());

	/**
	 * 
	 * @param vUserRoleVO
	 * @param tManager
	 * @return vUserRoleVO
	 * @throws SQLException
	 */
	public static UserRoleVO addUserRole(ArrayList<UserRoleVO> urlist,TransactionManager tManager) throws SQLException {
		for(int i=0;i< urlist.size();i++)
		{
			UserRoleVO vUserRoleVO = (UserRoleVO) urlist.get(i);
			vUserRoleVO.setUid(UtilDAO.getUUid());//增加uid，确保数据唯一性
			UserRoleTO vUserRoleTO = new UserRoleTO(UserRoleTO.ADD_USERROLE,
					vUserRoleVO);
			vUserRoleTO.setSqlStr();
			logger.info("add sql is :" + vUserRoleTO.getSqlStr());

			if (tManager == null) {
				TransactionTemplate.executeTransaction(vUserRoleTO, true);
			} else {
				TransactionTemplate.executeTransaction(vUserRoleTO, tManager);
			}
		}
		return null;
	}
	
	/**
	 * ��ѯ�û��ҽӽ�ɫ
	 * @param vUserRoleVO
	 * @param mPageController
	 * @return ArrayList<UserRoleVO>
	 * @throws SQLException
	 */
	public static ArrayList<UserRoleVO> getUserRoleList(UserRoleVO vUserRoleVO,
			PageController mPageController) throws SQLException {
		if (null == vUserRoleVO ) {
			return null;
		}
		
		StringBuffer strsql = new StringBuffer();
		if(vUserRoleVO.getUserID()!=null){
			strsql.append("select userID,roleID from z_t_user_role where userID= ");
		
			if (vUserRoleVO.getUserID()!=null) {
				strsql.append( "'"+vUserRoleVO.getUserID()+"'");
			}
		}else if(vUserRoleVO.getRoleID()!=null){
			strsql.append("select userID,roleID from z_t_user_role where roleID= ");
			
			if (vUserRoleVO.getRoleID()!=null) {
				strsql.append( "'"+vUserRoleVO.getRoleID()+"'");
			}
		}
		UserRoleMQB vUserRoleMQB = new UserRoleMQB(UserRoleMQB.QUERY_FROM_USERROLE);
		vUserRoleMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserRoleMQB, mPageController);

		return vUserRoleMQB.getUserRoleList();
	}
	/**
	 * 根据角色查询用户
	 * @param mPageController
	 * @return ArrayList<UserRoleVO>
	 * @throws SQLException
	 */
	public static ArrayList<UserRoleVO> getUserByrole(UserRoleVO vUserRoleVO,PageController mPageController) throws SQLException 
	{
		if (null == vUserRoleVO ||vUserRoleVO.getRoleID() ==null) {
			logger.info("角色为空");
			return null;
		}
		
		StringBuffer strsql = new StringBuffer();

		strsql.append("select userID from z_t_user_role ");
	
		if (vUserRoleVO.getRoleID().length()>0) {
			strsql.append(" where roleID='"+vUserRoleVO.getRoleID()+"'");
		}

		UserRoleMQB vUserRoleMQB = new UserRoleMQB(UserRoleMQB.QUERY_FROM_ROLEUSER);
		vUserRoleMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserRoleMQB, mPageController);

		return vUserRoleMQB.getUserRoleList();
	}
	
	/**
	 * 
	 * @param vUserRoleVO
	 * @param tManager
	 * @return UserRoleVO
	 * @throws SQLException
	 */
	public static UserRoleVO modifyUserRole(UserRoleVO vUserRoleVO,
			TransactionManager tManager) throws SQLException {
         //
		return vUserRoleVO;
	}

	/**
	 * 
	 * @param vUserRoleVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delUserRole(UserVO userVO,
			TransactionManager tManager) throws SQLException {		
		UserRoleTO vUserRoleTO = new UserRoleTO(UserRoleTO.DEL_USERROLE,
				userVO);
		vUserRoleTO.setSqlStr();
		logger.info("delete sql is :" + vUserRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserRoleTO, tManager);
		}
		return vUserRoleTO.getexecuteResult();
	}
	
	public static int delAllUserRole(TransactionManager tManager) throws SQLException {		
		UserRoleTO vUserRoleTO = new UserRoleTO(UserRoleTO.DEL_ALL);
		vUserRoleTO.setSqlStr();
		logger.info("delAllUserRole sql is :" + vUserRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserRoleTO, tManager);
		}
		return vUserRoleTO.getexecuteResult();
	}
	
	public static int delUserRoleTwo(UserRoleVO urVO,
			TransactionManager tManager) throws SQLException {		
		UserRoleTO vUserRoleTO = new UserRoleTO(UserRoleTO.DEL_USERROLE_TWO,
				urVO);
		vUserRoleTO.setSqlStr();
		logger.info("delete sql is :" + vUserRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserRoleTO, tManager);
		}
		return vUserRoleTO.getexecuteResult();
	}
	
	
}
