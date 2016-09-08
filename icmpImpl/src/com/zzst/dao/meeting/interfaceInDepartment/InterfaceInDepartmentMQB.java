package com.zzst.dao.meeting.interfaceInDepartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.interfaceInDepartment.InterfaceInDepartmentVO;

/**
 * class description: InterfaceInDepartment MQB
 * 
 * @date Mon Jun 17 16:54:25 CST 2013
 * @author ryan
 */
public class InterfaceInDepartmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(InterfaceInDepartmentMQB.class
			.getName());

	public static int QUERY_FROM_INTERFACEINDEPARTMENT = 1;
	public static int QUERY_FROM_INTERFACEINDEPARTMENT_BY_IDS = 2;

	private InterfaceInDepartmentVO interfaceInDepartmentVO;
	private ArrayList<InterfaceInDepartmentVO> listInterfaceInDepartment = new ArrayList<InterfaceInDepartmentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public InterfaceInDepartmentMQB(int operatorType,
			InterfaceInDepartmentVO interfaceInDepartmentVO) {
		_operatorType = operatorType;
		this.interfaceInDepartmentVO = interfaceInDepartmentVO;
		makeSql();
	}

	public InterfaceInDepartmentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select departmentid,departmentcode,departmentname,fullname,parentid,ordernum,parentcode,parentname,linkids,departmenttype,nodeproperty,telephone,fax,address,postcode,email,createtime,departmentdesc,revision,creatorid,creatorname ");
		strsql.append(" from z_t_interface_in_department ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_INTERFACEINDEPARTMENT == _operatorType) {
			if (null != interfaceInDepartmentVO) {
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getDepartmentId())) {
					strsql.append(" and departmentid= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getDepartmentId());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getDepartmentCode())) {
					strsql.append(" and departmentcode= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getDepartmentName())) {
					strsql.append(" and departmentname= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getDepartmentName());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getFullName())) {
					strsql.append(" and fullname= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getFullName());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getParentId())) {
					strsql.append(" and parentid= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getParentId());
				}
				if (Integer.MIN_VALUE != interfaceInDepartmentVO.getOrderNum()) {
					strsql.append(" and ordernum= ? ");
					super.addIntForField(interfaceInDepartmentVO.getOrderNum());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getParentcCode())) {
					strsql.append(" and parentcode= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getParentcCode());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getParentName())) {
					strsql.append(" and parentname= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getParentName());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getLinkIds())) {
					strsql.append(" and linkids= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getLinkIds());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getDepartmentType())) {
					strsql.append(" and departmenttype= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getDepartmentType());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getNodeProperty())) {
					strsql.append(" and nodeproperty= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getNodeProperty());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getTelephone())) {
					strsql.append(" and telephone= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getTelephone());
				}
				if (!StringUtils
						.isNullOrBlank(interfaceInDepartmentVO.getFax())) {
					strsql.append(" and fax= ? ");
					super.addStringForField(interfaceInDepartmentVO.getFax());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getAddress())) {
					strsql.append(" and address= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getAddress());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getPostcode())) {
					strsql.append(" and postcode= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getPostcode());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getEmail())) {
					strsql.append(" and email= ? ");
					super.addStringForField(interfaceInDepartmentVO.getEmail());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getCreatorId())) {
					strsql.append(" and creatorid= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getCreatorId());
				}
				if (!StringUtils.isNullOrBlank(interfaceInDepartmentVO
						.getCreatorName())) {
					strsql.append(" and creatorname= ? ");
					super.addStringForField(interfaceInDepartmentVO
							.getCreatorName());
				}
			}
		} else if (QUERY_FROM_INTERFACEINDEPARTMENT_BY_IDS == _operatorType) {
			strsql.append(" and departmentid in (?) ");
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
		interfaceInDepartmentVO = new InterfaceInDepartmentVO();
		interfaceInDepartmentVO.setDepartmentId(rs.getString("departmentid"));
		interfaceInDepartmentVO.setDepartmentCode(rs
				.getString("departmentcode"));
		interfaceInDepartmentVO.setDepartmentName(rs
				.getString("departmentname"));
		interfaceInDepartmentVO.setFullName(rs.getString("fullname"));
		interfaceInDepartmentVO.setParentId(rs.getString("parentid"));
		interfaceInDepartmentVO.setOrderNum(rs.getInt("ordernum"));
		interfaceInDepartmentVO.setParentcCode(rs.getString("parentcode"));
		interfaceInDepartmentVO.setParentName(rs.getString("parentname"));
		interfaceInDepartmentVO.setLinkIds(rs.getString("linkids"));
		interfaceInDepartmentVO.setDepartmentType(rs
				.getString("departmenttype"));
		interfaceInDepartmentVO.setNodeProperty(rs.getString("nodeproperty"));
		interfaceInDepartmentVO.setTelephone(rs.getString("telephone"));
		interfaceInDepartmentVO.setFax(rs.getString("fax"));
		interfaceInDepartmentVO.setAddress(rs.getString("address"));
		interfaceInDepartmentVO.setPostcode(rs.getString("postcode"));
		interfaceInDepartmentVO.setEmail(rs.getString("email"));
		interfaceInDepartmentVO.setCreatorId(rs.getString("creatorid"));
		interfaceInDepartmentVO.setCreatorName(rs.getString("creatorname"));
		listInterfaceInDepartment.add(interfaceInDepartmentVO);
	}

	public ArrayList<InterfaceInDepartmentVO> getInterfaceInDepartmentList() {
		return listInterfaceInDepartment;
	}

	public InterfaceInDepartmentVO getInterfaceInDepartmentVO() {
		return interfaceInDepartmentVO;
	}

}
