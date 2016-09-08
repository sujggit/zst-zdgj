package com.zzst.dao.meeting.userDepartment;

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
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;

/**
 * class description: UserDepartment DAO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDepartmentDAO {

	private static Logger logger = CbfLogger.getLogger(UserDepartmentDAO.class
			.getName());

	/**
	 * 
	 * @param vUserDepartmentVO
	 * @param tManager
	 * @return vUserDepartmentVO
	 * @throws SQLException
	 */
	public static UserDepartmentVO addUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException {
		UserDepartmentTO vUserDepartmentTO = new UserDepartmentTO(
				UserDepartmentTO.ADD_USERDEPARTMENT, vUserDepartmentVO);
		vUserDepartmentTO.setSqlStr();
		logger.info("add sql is :" + vUserDepartmentTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, tManager);
		}

		return vUserDepartmentVO;
	}

	/**
	 * 
	 * @param vUserDepartmentVO
	 * @param mPageController
	 * @return ArrayList<UserDepartmentVO>
	 * @throws SQLException
	 */
	public static ArrayList<UserDepartmentVO> getUserDepartmentList(
			UserDepartmentVO vUserDepartmentVO, PageController mPageController)
			throws SQLException {

		String sql = setSql(vUserDepartmentVO);
		logger.info("query sql is :" + sql);

		UserDepartmentMQB vUserDepartmentMQB = new UserDepartmentMQB(
				UserDepartmentMQB.QUERY_FROM_USERDEPARTMENT);
		vUserDepartmentMQB.setSql(sql);

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vUserDepartmentMQB, mPageController);

		return vUserDepartmentMQB.getUserDepartmentList();
	}

	/**
	 * 
	 * @param vUserDepartmentVO
	 * @param tManager
	 * @return UserDepartmentVO
	 * @throws SQLException
	 */
	public static UserDepartmentVO modifyUserDepartment(
			UserDepartmentVO vUserDepartmentVO, TransactionManager tManager)
			throws SQLException {
		UserDepartmentTO vUserDepartmentTO = new UserDepartmentTO(
				UserDepartmentTO.MODIFY_USERDEPARTMENT, vUserDepartmentVO);
		
		vUserDepartmentTO.setSqlStr();
		logger.info("modify sql is :" + vUserDepartmentTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, tManager);
		}

		return vUserDepartmentVO;
	}

	/**
	 * 
	 * @param vUserDepartmentVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delUserDepartment(UserDepartmentVO vUserDepartmentVO,
			TransactionManager tManager) throws SQLException {
		UserDepartmentTO vUserDepartmentTO = new UserDepartmentTO(
				UserDepartmentTO.DEL_USERDEPARTMENT, vUserDepartmentVO);
		vUserDepartmentTO.setSqlStr();
		logger.info("delete sql is :" + vUserDepartmentTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, tManager);
		}
		return vUserDepartmentTO.getexecuteResult();
	}

	public static String setSql(UserDepartmentVO vUserDepartmentVO) {

		

		StringBuffer strsql = new StringBuffer();
		strsql.append("select "
						+ " b.userID,b.userNO,b.email,b.loginName,b.password,b.name,b.nameSpelling,b.age,b.sex,b.title,b.mobile,b.tel,b.fax,b.lastLoginTime,b.state,b.description,b.revision userRevision,"
						+ " a.userDepartmentID,a.departmentID,a.departmentName,a.corpID,a.corpName,a.revision userDepartmentRevision");
		strsql.append(" from t_department_user a left join t_user  b on ");
		strsql.append(" a.userID=b.userID  left join t_department  c on c.departmentID=a.departmentID where 1=1 ");

		if (null != vUserDepartmentVO) {
			if (!IntegerUtils.isNullOrMIN_VALUE(vUserDepartmentVO.getUserDepartmentID())) {
				strsql.append(" and a.userDepartmentID="
						+ vUserDepartmentVO.getUserDepartmentID());
			}

			if (!IntegerUtils.isNullOrMIN_VALUE( vUserDepartmentVO.getDepartmentVO().getId())) {
				strsql.append(" and (a.departmentID="
						+ vUserDepartmentVO.getDepartmentVO().getId() + " or c.linkCode like '%"  + vUserDepartmentVO.getDepartmentVO().getId() + "%')");
			}
			
			if (!StringUtils.isNullOrBlank(vUserDepartmentVO.getDepartmentVO().getTitle())) {
				strsql.append(" and (a.departmentName='"
						+ vUserDepartmentVO.getDepartmentVO().getTitle() + "' or c.linkCodeName like '%" + vUserDepartmentVO.getDepartmentVO().getTitle() + "%')");
			}
			
			if (!IntegerUtils.isNullOrMIN_VALUE(vUserDepartmentVO.getCorpID())) {
				strsql.append(" and a.corpID=" + vUserDepartmentVO.getCorpID());
			}
			if (!StringUtils.isNullOrBlank(vUserDepartmentVO.getCorpName())) {
				strsql.append(" and a.corpName='"
						+ vUserDepartmentVO.getCorpName() + "'");
			}

			//设置用户的查询条件,待删除
			UserVO vUserVO = vUserDepartmentVO.getUserVO();
			
//			if (!IntegerUtils.isNullOrMIN_VALUE(vUserVO.getUserID())) {
//				strsql.append(" and b.userID=" + vUserVO.getUserID());
//			}
//
//			if (!StringUtils.isNullOrBlank(vUserVO.getEmail())) {
//				strsql.append(" and b.email='" + vUserVO.getEmail() + "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getLoginName())) {
//				strsql.append(" and b.loginName='" + vUserVO.getLoginName()
//								+ "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getPassWord())) {
//				strsql.append(" and b.password='" + vUserVO.getPassWord() + "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getName())) {
//				strsql.append(" and  b.name like '%" + vUserVO.getName() + "%'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getNameSpelling())) {
//				strsql.append(" and b.nameSpelling='" + vUserVO.getNameSpelling()
//						+ "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getTitle())) {
//				strsql.append(" and b.title='" + vUserVO.getTitle() + "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getMobile())) {
//				strsql.append(" and b.mobile='" + vUserVO.getMobile() + "'");
//			}
//			if (!StringUtils.isNullOrBlank(vUserVO.getTel())) {
//				strsql.append(" and b.tel='" + vUserVO.getTel() + "'");
//			}
//
//			if (!StringUtils.isNullOrBlank(vUserVO.getDescription())) {
//				strsql.append(" and b.description='" + vUserVO.getDescription()
//						+ "'");
//			}
//			if (!IntegerUtils.isNullOrMIN_VALUE(vUserVO.getState())) {
//				strsql.append(" and b.state=" + vUserVO.getState());
//			}
		}
		strsql.append(" order by b.name");
		return strsql.toString();
	}
	
	public static int delAllDepUser(TransactionManager tManager) throws SQLException {
		UserDepartmentTO vUserDepartmentTO = new UserDepartmentTO(
				UserDepartmentTO.DEL_ALL);
		vUserDepartmentTO.setSqlStr();
		logger.info("delAllDepUser sql is :" + vUserDepartmentTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, true);
		} else {
			TransactionTemplate.executeTransaction(vUserDepartmentTO, tManager);
		}
		return vUserDepartmentTO.getexecuteResult();
	}

	
}
