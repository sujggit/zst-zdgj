package com.zzst.service.meeting.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.service.ServiceDAO;
import com.zzst.model.meeting.service.ServiceVO;

/**
 * class description: Service Impl
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class ServiceServiceImpl implements ServiceService {

	private static Logger logger = CbfLogger.getLogger(ServiceServiceImpl.class
			.getName());

	/**
	 * method description : addService
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO addService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		return ServiceDAO.addService(vServiceVO, tManager);
	}

	/**
	 * method description : getServiceList
	 * 
	 * @param ServiceVO
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceList(ServiceVO vServiceVO,
			PageController mPageController) throws SQLException {
		return ServiceDAO.getServiceList(vServiceVO, mPageController);
	}
	
	/**
	 * method description : getServiceList by parent no in -1 1 and state !=1
	 * 
	 * @param 
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceListByParentAndState(
			PageController mPageController) throws SQLException {
		return ServiceDAO.getServiceListByParentAndState(mPageController);
	}
	
	/**
	 * method description : getServiceList by parent no in -1 1 and state !=1
	 * 
	 * @param 
	 * @return ArrayList<ServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<ServiceVO> getServiceListByParentAndState(ServiceVO vServiceVO,
			PageController mPageController) throws SQLException {
		return ServiceDAO.getServiceListByParentAndState(vServiceVO,mPageController);
	}
	/**
	 * method description : delService
	 * 
	 * @param ServiceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delService(ServiceVO vServiceVO, TransactionManager tManager)
			throws SQLException {
		boolean re = false;
		if (1 == ServiceDAO.delService(vServiceVO, tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify Service state by id
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO delServiceForState(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		return modifyService(vServiceVO, tManager);
	}

	/**
	 * method description : modify Service all columns by id
	 * 
	 * @param ServiceVO
	 * @return ServiceVO
	 * @throws SQLException
	 */
	public ServiceVO modifyService(ServiceVO vServiceVO,
			TransactionManager tManager) throws SQLException {
		return ServiceDAO.modifyService(vServiceVO, tManager);
	}

	public static void main(String args[]) throws SQLException {
		ServiceVO vServiceVO = new ServiceVO();
		
		vServiceVO.setServiceName("serviceName");
		vServiceVO.setServiceUnit("serviceUnit");
		vServiceVO.setServiceDescription("serviceDescription");
		vServiceVO.setOrderNO(8); 
		vServiceVO.setRevision(Long.MIN_VALUE);

		new ServiceServiceImpl().addService(vServiceVO, null);
		System.out.println("=========add Success!");

		ArrayList<ServiceVO> lstService = new ServiceServiceImpl()
				.getServiceList(vServiceVO, null);

		if (lstService.size() > 0) {
			System.out.println("=========query Result:");
			ServiceVO vvServiceVO = (ServiceVO) lstService.get(0);
			System.out.println("serviceID=" + vvServiceVO.getServiceID());
			System.out.println("serviceName=" + vvServiceVO.getServiceName());
			System.out.println("serviceUnit=" + vvServiceVO.getServiceUnit());
			System.out.println("price=" + vvServiceVO.getPrice());
			System.out.println("serviceDescription="
					+ vvServiceVO.getServiceDescription());
			System.out.println("orderNO=" + vvServiceVO.getOrderNO());
		 
			System.out.println("revision=" + vvServiceVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
