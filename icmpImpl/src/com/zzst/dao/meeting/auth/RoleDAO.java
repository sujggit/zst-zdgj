package com.zzst.dao.meeting.auth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.auth.RoleVO;

/**
 * class description: Role DAO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:46 CST 2009
 */

public class RoleDAO {

	private static Logger logger = CbfLogger.getLogger(RoleDAO.class.getName());

	/**
	 * 
	 * @param vRoleVO
	 * @param tManager
	 * @return vRoleVO
	 * @throws SQLException
	 */
	public static RoleVO addRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		vRoleVO.setRoleID(UtilDAO.getUUid());
		RoleTO vRoleTO = new RoleTO(RoleTO.ADD_ROLE, vRoleVO);
		vRoleTO.setSqlStr();
		logger.info("add sql is :" + vRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vRoleTO, tManager);
		}

		return vRoleVO;
	}
	
	public static RoleVO addRoleCreateId(RoleVO vRoleVO, TransactionManager tManager)
	throws SQLException {
		//vRoleVO.setRoleID(UtilDAO.getUUid());
		RoleTO vRoleTO = new RoleTO(RoleTO.ADD_ROLE, vRoleVO);
		vRoleTO.setSqlStr();
		logger.info("add sql is :" + vRoleTO.getSqlStr());
		
		if (tManager == null) {
			TransactionTemplate.executeTransaction(vRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vRoleTO, tManager);
		}
		
		return vRoleVO;
}
	

	/**
	 * 
	 * @param vRoleVO
	 * @param mPageController
	 * @return ArrayList<RoleVO>
	 * @throws SQLException
	 */
	public static ArrayList<RoleVO> getRoleList(RoleVO vRoleVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();
		
			strsql.append("select d.role_id ,d.role_name ,d.create_date ,d.create_by ,d.status,d.note,c.cc,c.userNames ");
			strsql.append("from z_t_role  d left join  ");
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
			strsql.append(" (select b.roleID,wmsys.wm_concat(c.fullName) userNames, COUNT(b.roleID) cc ");
			}else{
				strsql.append(" (select b.roleID,GROUP_CONCAT(c.fullName) userNames, COUNT(b.roleID) cc ");
			}
			//strsql.append(" from z_t_role a left join z_t_user_role b on  a.role_id=b.roleID  left join z_t_user  c on b.userID =c.userID ");
			//strsql.append(" where  c.status =1 GROUP BY b.roleID ) ");
			//strsql.append("  c on  d.role_id=c.roleID  ");
			//strsql.append(" where 1=1 ");
		
		//strsql.append("select d.role_id ,d.role_name ,d.create_date ,d.create_by ,d.status,d.note,c.cc,c.userNames ");
		//strsql.append("from z_t_role as d left join  ");
		
		strsql.append(" from z_t_role a left join z_t_user_role b on  a.role_id=b.roleID  left join z_t_user  c on b.userID =c.userID ");
		strsql.append(" where  c.status =1 GROUP BY b.roleID ) ");
		strsql.append("  c on  d.role_id=c.roleID  ");
		strsql.append(" where 1=1 ");
		
		
		if (null != vRoleVO) {

			if (!StringUtils.isNullOrBlank(vRoleVO.getRoleID())) {
				strsql.append(" and d.role_id='" + vRoleVO.getRoleID().trim()+"'");
			}
			/**
			 * 模糊查询，根据用户名和角色名进行查询,去除首尾空格
			 */
			if (!StringUtils.isNullOrBlank(vRoleVO.getRoleName())) {
				strsql.append(" and d.role_name like '%" + vRoleVO.getRoleName().trim() + "%'");
			}
			if(!StringUtils.isNullOrBlank(vRoleVO.getUserNames())){
				strsql.append(" and c.userNames LIKE '%" + vRoleVO.getUserNames().trim() + "%'");
			}
		
//			if (!StringUtils.isNullOrBlank(vRoleVO.getRoleDescription())) {
//				strsql.append(" and note='"
//						+ vRoleVO.getRoleDescription() + "'");
//			}
		}

		RoleMQB vRoleMQB = new RoleMQB(RoleMQB.QUERY_FROM_ROLE);
		vRoleMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vRoleMQB, mPageController);

		return vRoleMQB.getRoleList();
	}

	/**
	 * 
	 * @param vRoleVO
	 * @param tManager
	 * @return RoleVO
	 * @throws SQLException
	 */
	public static RoleVO modifyRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		RoleTO vRoleTO = new RoleTO(RoleTO.MODIFY_ROLE, vRoleVO);
		vRoleTO.setSqlStr();
		logger.info("modify sql is :" + vRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vRoleTO, tManager);
		}

		return vRoleVO;
	}

	/**
	 * 
	 * @param vRoleVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delRole(RoleVO vRoleVO, TransactionManager tManager)
			throws SQLException {
		RoleTO vRoleTO = new RoleTO(RoleTO.DEL_ROLE, vRoleVO);
		vRoleTO.setSqlStr();
		logger.info("delete sql is :" + vRoleTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vRoleTO, true);
		} else {
			TransactionTemplate.executeTransaction(vRoleTO, tManager);
		}
		return vRoleTO.getexecuteResult();
	}

}
