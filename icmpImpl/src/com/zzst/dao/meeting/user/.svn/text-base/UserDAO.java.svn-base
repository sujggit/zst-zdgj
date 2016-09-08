package com.zzst.dao.meeting.user;

import java.sql.SQLException;
import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.PostEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: User DAO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDAO {

	private static Logger logger = CbfLogger.getLogger(UserDAO.class.getName());

	/**
	 * 
	 * @param vUserVO
	 * @param mPageController
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
	public static ArrayList<UserVO> userLogin(UserVO vUserVO, PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();

		strsql.append("select b.userID,b.email,b.loginName,b.password,b.fullName,b.nameSpelling,b.mobile,b.lastLoginTime,b.status,b.description,b.authenticateType,b.changePwdTime,b.errorTimes,");
		strsql.append("  c.id,c.name from z_t_department_user a left join z_t_user  b on  a.userID=b.userID  left join z_t_department c on c.id=a.departmentID ");
		strsql.append(" where 1=1 ");
		strsql.append(" and b.loginName='" + vUserVO.getLoginName() + "'");
		strsql.append(" and b.password='" + vUserVO.getPassWord() + "'");
		strsql.append(" and b.status=1");


		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);

		return vUserMQB.getUserList();
	}
	
	public static ArrayList<UserVO> getUserListbyName(UserVO vUserVO, PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();

		strsql.append("select b.userID,b.email,b.loginName,b.password,b.fullName,b.nameSpelling,b.mobile,b.lastLoginTime,b.status,b.description,b.authenticateType,b.changePwdTime,b.errorTimes,");
		strsql.append("  c.id,c.name from z_t_department_user a left join z_t_user  b on  a.userID=b.userID  left join z_t_department c on c.id=a.departmentID ");
		strsql.append(" where 1=1 ");
		strsql.append(" and b.loginName='" + vUserVO.getLoginName() + "'");
		strsql.append(" and b.status!="+UserEnum.INVALID);
		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);

		return vUserMQB.getUserList();
	}

	/**
	 * 
	 * @param vUserVO
	 * @param tManager
	 * @return vUserVO
	 * @throws SQLException
	 */
	public static UserVO addUser(UserVO vUserVO, TransactionManager tManager) throws Exception {
		String n = UtilDAO.getUUid();
		vUserVO.setUserID(n);
		UserTO vUserTO = new UserTO(UserTO.ADD_USER, vUserVO);
		vUserTO.setSqlStr();
		logger.info("add sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}

		return vUserVO;
	}
	
	public static UserVO addUserByCreateId(UserVO vUserVO, TransactionManager tManager) throws Exception {
		//String n = UtilDAO.getUUid();
		//vUserVO.setUserID(n);
		UserTO vUserTO = new UserTO(UserTO.ADD_USER, vUserVO);
		vUserTO.setSqlStr();
		logger.info("add sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}

		return vUserVO;
	}
	

	/**
	 * 
	 * @param vUserVO
	 * @param mPageController
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
	public static ArrayList<UserVO> getUserList(UserVO vUserVO, PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql.append("select b.userID,b.email,b.loginName,b.password,b.fullName,b.nameSpelling,b.mobile,b.lastLoginTime,b.status,b.description,b.authenticateType,b.changePwdTime,b.errorTimes,");
		strsql.append("  c.id,c.name from z_t_department_user  a left join z_t_user b on  a.userID=b.userID  left join z_t_department c on c.id=a.departmentID ");
		strsql.append(" where 1=1 ");
		if (null != vUserVO) {

			if (vUserVO.getUserID() != null) {
				strsql.append(" and b.userID='" + vUserVO.getUserID() + "'");
			}

			if (!StringUtils.isNullOrBlank(vUserVO.getLoginName())) {
				strsql.append(" and b.loginName like '%" + vUserVO.getLoginName() + "%'");
			}
			if (!StringUtils.isNullOrBlank(vUserVO.getName())) {
				strsql.append(" and b.name like '%" + vUserVO.getName() + "%'");
			}

			if (!IntegerUtils.isNullOrMIN_VALUE(vUserVO.getState())) {
				strsql.append(" and b.status=" + vUserVO.getState());
			}else{
				strsql.append(" and b.status!=" + UserEnum.INVALID);
			}
			if (vUserVO.getDepartmentVO() != null && vUserVO.getDepartmentVO().getId() != null
					&& !vUserVO.getDepartmentVO().getId().equals("")) {
				strsql.append(" and c.id='" + vUserVO.getDepartmentVO().getId()+"'");
			}
			if(vUserVO.getOpenlevel()){
				strsql.append(" and b.userID IN(" + vUserVO.getLvoids()+")");
			}
		}
        
		strsql.append(" order by b.loginName");

		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);

		return vUserMQB.getUserList();
	}

	/**
	 * 
	 * 不能使用
	 * 根据id查询，多个id已‘,分开’ 如：1,2,3
	 * 
	 * @param String
	 *            id
	 * @param mPageController
	 * @return ArrayList<UserVO>
	 * @throws SQLException
	 */
//	public static ArrayList<UserVO> getListForIDS(String ids, PageController mPageController) throws SQLException {
//
//		StringBuffer strsql = new StringBuffer();
//
//		strsql
//				.append("select userID,userNO,email,loginName,password,name,nameSpelling,age,sex,title,mobile,tel,fax,lastLoginTime,state,description,revision,authenticateType ");
//		strsql.append("  from t_user ");
//		strsql.append(" where userID in(" + ids + ")");
//		strsql.append(" order by name");
//		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER);
//		vUserMQB.setSql(strsql.toString());
//		logger.info("query sql is :" + strsql.toString());
//
//		if (mPageController == null) {
//			mPageController = new PageController();
//			mPageController.setAll(true);
//		}
//
//		QueryTemplate.executeQueryForList(vUserMQB, mPageController);
//
//		return vUserMQB.getUserList();
//	}

	/**
	 * 
	 * @param vUserVO
	 * @param tManager
	 * @return UserVO
	 * @throws SQLException
	 */
	public static UserVO modifyUser(UserVO vUserVO, TransactionManager tManager) throws SQLException {
		UserTO vUserTO = new UserTO(UserTO.MODIFY_USER, vUserVO);
		vUserTO.setSqlStr();
		logger.info("modify sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}

		return vUserVO;
	}
	
	/**
	 * 
	 * @param vUserVO
	 * @param tManager
	 * @return UserVO
	 * @throws SQLException
	 */
	public static UserVO modifyUserByLoginName(UserVO vUserVO, TransactionManager tManager) throws SQLException {
		UserTO vUserTO = new UserTO(UserTO.MODIFY_USER_LG, vUserVO);
		vUserTO.setSqlStr();
		logger.info("modify sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}

		return vUserVO;
	}

	/**
	 * 
	 * @param vUserVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delUser(UserVO vUserVO, TransactionManager tManager) throws SQLException {
//		UserTO vUserTO = new UserTO(UserTO.DEL_USER, vUserVO);
//		vUserTO.setSqlStr();
//		logger.info("delete sql is :" + vUserTO.getSqlStr());
//
//		if (tManager == null) {
//			TransactionTemplate.executeTransaction(vUserTO, true);
//		} else {
//			TransactionTemplate.executeTransaction(vUserTO, tManager);
//		}
//		return vUserTO.getexecuteResult();
		modifyUserByStatus(vUserVO,tManager);
		return Integer.MIN_VALUE;
	}

	/**
	 * 根据ID修改状态
	 * @param vUserVO
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public static UserVO modifyUserByStatus(UserVO vUserVO, TransactionManager tManager) throws SQLException {
		UserTO vUserTO = new UserTO(UserTO.MODIFY_USER_STATUS, vUserVO);
		vUserTO.setSqlStr();
		logger.info("modify sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}
		return vUserVO;
	}
	
	public static ArrayList<UserVO> getUsers(UserVO vUserVO, PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql.append("select userID,fullName ");
		strsql.append(" from z_t_user ");
		strsql.append(" where 1=1 ");
		if (null != vUserVO) {

			if (vUserVO.getUserID() != null) {
				strsql.append(" and userID='" + vUserVO.getUserID() + "'");
			}

			if (!StringUtils.isNullOrBlank(vUserVO.getLoginName())) {
				strsql.append(" and loginName like '%" + vUserVO.getLoginName() + "%'");
			}
			if (!StringUtils.isNullOrBlank(vUserVO.getName())) {
				strsql.append(" and fullName like '%" + vUserVO.getName() + "%'");
			}

			if (!IntegerUtils.isNullOrMIN_VALUE(vUserVO.getState())) {
				strsql.append(" and status=" + vUserVO.getState());
			}
		}
		
		strsql.append(" order by userID");

		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER_1);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);

		return vUserMQB.getUserList();
	}
	
	
	public static ArrayList<UserVO> getUsersByDeprtmentID( String departmentID, PageController mPageController) throws SQLException{
		StringBuffer strsql = new StringBuffer();

		strsql.append(" SELECT a.departmentID,b.userID,b.email,b.loginName,b.password,b.fullName,b.nameSpelling,b.mobile,b.lastLoginTime,b.status,b.description,b.authenticateType");
		strsql.append(" FROM z_t_department_user a JOIN z_t_user b ON a.userID=b.userID  ");
		strsql.append(" WHERE 1=1  AND b.status = 1 ");
		if (null != departmentID ) {
			strsql.append(" AND a.departmentID = '" + departmentID + "'");
		}

		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER_2);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);

		return vUserMQB.getUserList();
	}
	
	public static void delAll(TransactionManager tManager) throws SQLException {
		UserTO vUserTO = new UserTO(UserTO.DEL_USER);
		vUserTO.setSqlStr();
		logger.info("delAll sql is :" + vUserTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserTO, tManager);
		}

	}

	public static ArrayList<UserVO> getUsersByDeptPost(UserVO vUserVO,
			PageController mPageController) throws Exception{
		logger.info("DAO	getUsersByDeptPost	begin");
		StringBuffer strsql = new StringBuffer();

		strsql.append(" select u.*,du.departmentID,up.postNO,d.name,p.postName");
		strsql.append(" from z_t_department_user du,z_t_user u,z_t_user_post up,z_t_department d,z_t_post p");
		strsql.append(" where 1=1  and u.status="+UserEnum.VALID);
		strsql.append(" and p.status="+PostEnum.STATUS_VALID);
		strsql.append(" and du.userID=u.userID and u.userID=up.userID and du.departmentID=d.id and up.postNO=p.postNO");
		if (null != vUserVO) {
			if (!StringUtils.isNullOrBlank(vUserVO.getUserID())) {
				strsql.append(" and u.userID='"+vUserVO.getUserID()+"'");
			}
			if (!StringUtils.isNullOrBlank(vUserVO.getDepartmentVO().getId())) {
				strsql.append(" and du.departmentID='"+vUserVO.getDepartmentVO().getId()+"'");
			}
			if (!StringUtils.isNullOrBlank(vUserVO.getPostVO().getPostNO())) {
				strsql.append(" and up.postNO='"+vUserVO.getPostVO().getPostNO()+"'");
			}
		}

		UserMQB vUserMQB = new UserMQB(UserMQB.QUERY_FROM_USER_3);
		vUserMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserMQB, mPageController);
		logger.info("list size	:	" + vUserMQB.getUserList().size());
		logger.info("DAO	getUsersByDeptPost	end");
		return vUserMQB.getUserList();
	}
	
}
