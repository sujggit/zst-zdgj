package com.zzst.dao.meeting.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.service.ServiceVO;

/**
 * class description: Service MQB
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class ServiceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ServiceMQB.class.getName());

	public static int QUERY_FROM_SERVICE = 1;

	private ServiceVO vServiceVO;

	private ArrayList<ServiceVO> lstService = new ArrayList<ServiceVO>();

	private int _operatorType = -1;

	public ServiceMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_SERVICE == _operatorType) {
			vServiceVO = new ServiceVO();
			vServiceVO.setServiceID(rs.getInt("serviceID"));
			vServiceVO.setServiceName(rs.getString("serviceName"));
			vServiceVO.setPrice(rs.getFloat("price"));
			vServiceVO.setServiceUnit(rs.getString("serviceUnit"));
			vServiceVO.setServiceDescription(rs.getString("serviceDescription"));
			vServiceVO.setOrderNO(rs.getInt("orderNO"));
			vServiceVO.setParentID(rs.getInt("parentID"));
			vServiceVO.setState(rs.getInt("state"));
			lstService.add(vServiceVO);
		}

	}

	public ArrayList<ServiceVO> getServiceList() {
		return lstService;

	}

	public ServiceVO getServiceVO() {
		return vServiceVO;
	}

}
