package com.zzst.service.meeting.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.dao.meeting.service.ServiceDAO;
import com.zzst.model.meeting.service.ServiceVO;

/**
 * class description: Service Service
 * 
 * @author ryan
 * @date Tue Jul 28 15:13:08 CST 2009
 */

public interface ServiceService {

	/**
	 * method description : addService
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO addService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : delService
	 * 
	 * @param ServiceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delService(ServiceVO vServiceVO, TransactionManager tManager)
			throws SQLException;

	/**
	 * method description : modify Service state by id
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO delServiceForState(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : modify Service all columns by id
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO modifyService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException;

	/**
	 * method description : getServiceList
	 * 
	 * @param ServiceVO
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceList(ServiceVO vServiceVO,
			PageController mPageController) throws SQLException;
	/**
	 * method description : getServiceList by parent no in -1 1 and state !=1
	 * 
	 * @param 
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceListByParentAndState(
			PageController mPageController)throws SQLException;
	/**
	 * method description : getServiceList by parent no in -1 1 and state !=1
	 * 
	 * @param 
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceListByParentAndState(ServiceVO vServiceVO,
			PageController mPageController) throws SQLException;
}
