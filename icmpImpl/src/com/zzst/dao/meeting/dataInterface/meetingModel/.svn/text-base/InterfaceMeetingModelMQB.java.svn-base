package com.zzst.dao.meeting.dataInterface.meetingModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.meetingModel.InterfaceMeetingModelVO;

/**
 * class description: InterfaceMeetingModel MQB
 * 
 * @date Thu May 30 11:17:02 CST 2013
 * @author ryan
 */
public class InterfaceMeetingModelMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(InterfaceMeetingModelMQB.class.getName());

	public static int QUERY_FROM_INTERFACEMEETINGMODEL = 1;
	public static int QUERY_FROM_INTERFACEMEETINGMODEL_BY_IDS = 2;

	private InterfaceMeetingModelVO interfaceMeetingModelVO;
	private ArrayList<InterfaceMeetingModelVO> listInterfaceMeetingModel = new ArrayList<InterfaceMeetingModelVO>();

	private int _operatorType = -1;
	private String ids = "";

	public InterfaceMeetingModelMQB(int operatorType, InterfaceMeetingModelVO interfaceMeetingModelVO) {
		_operatorType = operatorType;
		this.interfaceMeetingModelVO = interfaceMeetingModelVO;
		makeSql();
	}

	public InterfaceMeetingModelMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select modelID,modelName,modelDes,status,description,ref1,ref2 ");
		strsql.append(" from z_interface_out_meetingmodel ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_INTERFACEMEETINGMODEL == _operatorType) {
			if (null != interfaceMeetingModelVO) {
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getModelID())) {
					strsql.append(" and modelID= ? ");
					super.addStringForField(interfaceMeetingModelVO.getModelID());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getModelName())) {
					strsql.append(" and modelName= ? ");
					super.addStringForField(interfaceMeetingModelVO.getModelName());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getModelDes())) {
					strsql.append(" and modelDes= ? ");
					super.addStringForField(interfaceMeetingModelVO.getModelDes());
				}
				if (Integer.MIN_VALUE != interfaceMeetingModelVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(interfaceMeetingModelVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(interfaceMeetingModelVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getRef1())) {
					strsql.append(" and ref1= ? ");
					super.addStringForField(interfaceMeetingModelVO.getRef1());
				}
				if (!StringUtils.isNullOrBlank(interfaceMeetingModelVO.getRef2())) {
					strsql.append(" and ref2= ? ");
					super.addStringForField(interfaceMeetingModelVO.getRef2());
				}
			}
		} else if (QUERY_FROM_INTERFACEMEETINGMODEL_BY_IDS == _operatorType) {
			strsql.append(" and modelID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		interfaceMeetingModelVO = new InterfaceMeetingModelVO();
		interfaceMeetingModelVO.setModelID(rs.getString("modelID"));
		interfaceMeetingModelVO.setModelName(rs.getString("modelName"));
		interfaceMeetingModelVO.setModelDes(rs.getString("modelDes"));
		interfaceMeetingModelVO.setStatus(rs.getInt("status"));
		interfaceMeetingModelVO.setDescription(rs.getString("description"));
		interfaceMeetingModelVO.setRef1(rs.getString("ref1"));
		interfaceMeetingModelVO.setRef2(rs.getString("ref2"));
		listInterfaceMeetingModel.add(interfaceMeetingModelVO);
	}

	public ArrayList<InterfaceMeetingModelVO> getInterfaceMeetingModelList() {
		return listInterfaceMeetingModel;
	}

	public InterfaceMeetingModelVO getInterfaceMeetingModelVO() {
		return interfaceMeetingModelVO;
	}

}
