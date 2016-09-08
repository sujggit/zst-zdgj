package com.zzst.dao.meeting.service;

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
import com.zzst.model.meeting.service.ServiceVO;

/**
 * class description: Service DAO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class ServiceDAO {

	private static Logger logger = CbfLogger.getLogger(ServiceDAO.class
			.getName());

	/**
	 * 
	 * @param vServiceVO
	 * @param tManager
	 * @return vServiceVO
	 * @throws SQLException
	 */
	public static ServiceVO addService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		ServiceTO vServiceTO = new ServiceTO(ServiceTO.ADD_SERVICE, vServiceVO);
		vServiceTO.setSqlStr();
		logger.info("add sql is :" + vServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vServiceTO, tManager);
		}

		return vServiceVO;
	}

	/**
	 * 
	 * @param vServiceVO
	 * @param mPageController
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public static ArrayList<ServiceVO> getServiceList(ServiceVO vServiceVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select serviceID,parentID,serviceName,serviceUnit,price,serviceDescription,orderNO,state,revision ");
		strsql.append(" from t_Service ");
		strsql.append(" where 1=1 ");
		if (null != vServiceVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getServiceID())) {
				strsql.append(" and serviceID=" + vServiceVO.getServiceID());
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceName())) {
				strsql.append(" and serviceName='"
						+ vServiceVO.getServiceName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceUnit())) {
				strsql.append(" and serviceUnit='"
						+ vServiceVO.getServiceUnit() + "'");
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceDescription())) {
				strsql.append(" and serviceDescription='"
						+ vServiceVO.getServiceDescription() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getOrderNO())) {
				strsql.append(" and orderNO=" + vServiceVO.getOrderNO());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getParentID())) {
				strsql.append(" and parentID="
						+ vServiceVO.getParentID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getState())) {
				strsql.append(" and state="
						+ vServiceVO.getState());
			}
		}

		ServiceMQB vServiceMQB = new ServiceMQB(ServiceMQB.QUERY_FROM_SERVICE);
		vServiceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vServiceMQB, mPageController);

		return vServiceMQB.getServiceList();
	}
	
	/**
	 * 
	 * @param vServiceVO
	 * @param mPageController
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public static ArrayList<ServiceVO> getServiceListByParentAndState(PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select serviceID,parentID,serviceName,serviceUnit,price,serviceDescription,orderNO,state,revision ");
		strsql.append(" from t_Service ");
		strsql.append(" where  parentID not in(-1,1) and state !=0");
		
		ServiceMQB vServiceMQB = new ServiceMQB(ServiceMQB.QUERY_FROM_SERVICE);
		vServiceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vServiceMQB, mPageController);

		return vServiceMQB.getServiceList();
	}
	
	/**
	 * 
	 * @param vServiceVO
	 * @param mPageController
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public static ArrayList<ServiceVO> getServiceListByParentAndState(ServiceVO vServiceVO,PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select serviceID,parentID,serviceName,serviceUnit,price,serviceDescription,orderNO,state,revision ");
		strsql.append(" from t_Service ");
		strsql.append(" where  parentID not in(-1,1) ");
		if (null != vServiceVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getServiceID())) {
				strsql.append(" and serviceID=" + vServiceVO.getServiceID());
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceName())) {
				strsql.append(" and serviceName='"
						+ vServiceVO.getServiceName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceUnit())) {
				strsql.append(" and serviceUnit='"
						+ vServiceVO.getServiceUnit() + "'");
			}
			if (!StringUtils.isNullOrBlank(vServiceVO.getServiceDescription())) {
				strsql.append(" and serviceDescription='"
						+ vServiceVO.getServiceDescription() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getOrderNO())) {
				strsql.append(" and orderNO=" + vServiceVO.getOrderNO());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getParentID())) {
				strsql.append(" and parentID="
						+ vServiceVO.getParentID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vServiceVO.getState())) {
				strsql.append(" and state="
						+ vServiceVO.getState());
			}
		}
		ServiceMQB vServiceMQB = new ServiceMQB(ServiceMQB.QUERY_FROM_SERVICE);
		vServiceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vServiceMQB, mPageController);

		return vServiceMQB.getServiceList();
	}
	
	/**
	 * 
	 * @param vServiceVO
	 * @param tManager
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public static ServiceVO modifyService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		ServiceTO vServiceTO = new ServiceTO(ServiceTO.MODIFY_SERVICE,
				vServiceVO);
		vServiceTO.setSqlStr();
		logger.info("modify sql is :" + vServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vServiceTO, tManager);
		}

		return vServiceVO;
	}

	/**
	 * 
	 * @param vServiceVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		ServiceTO vServiceTO = new ServiceTO(ServiceTO.DEL_SERVICE, vServiceVO);
		vServiceTO.setSqlStr();
		logger.info("delete sql is :" + vServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vServiceTO, tManager);
		}
		return vServiceTO.getexecuteResult();
	}

}
