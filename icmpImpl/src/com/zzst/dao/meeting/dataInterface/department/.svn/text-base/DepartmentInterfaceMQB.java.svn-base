package com.zzst.dao.meeting.dataInterface.department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;

/**
 * class description: DepartmentInterface MQB
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public class DepartmentInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(DepartmentInterfaceMQB.class
			.getName());

	public static int QUERY_FROM_DEPARTMENTINTERFACE = 1;
	public static int QUERY_FROM_DEPARTMENTINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_DEPARTMENTINTERFACE_AVAILABLE = 3;

	private DepartmentInterfaceVO departmentInterfaceVO;
	private ArrayList<DepartmentInterfaceVO> listDepartmentInterface = new ArrayList<DepartmentInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public DepartmentInterfaceMQB(int operatorType,
			DepartmentInterfaceVO departmentInterfaceVO) {
		_operatorType = operatorType;
		this.departmentInterfaceVO = departmentInterfaceVO;
		makeSql();
	}

	public DepartmentInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select departmentid,departmentcode,departmentname,fullname,parentid,ordernum,parentcode,parentname,linkids,departmenttype,nodeproperty,telephone,fax,address,postcode,email,createtime,departmentdesc,revision,creatorid,creatorname,importstatus,importdesc ");
		strsql.append(" from z_t_interface_in_department ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_DEPARTMENTINTERFACE == _operatorType) {
			if (null != departmentInterfaceVO) {
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getDepartmentid())) {
					strsql.append(" and departmentid= ? ");
					super.addStringForField(departmentInterfaceVO
							.getDepartmentid());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getDepartmentcode())) {
					strsql.append(" and departmentcode= ? ");
					super.addStringForField(departmentInterfaceVO
							.getDepartmentcode());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getDepartmentname())) {
					strsql.append(" and departmentname like ? ");
					super.addStringForField("%"+departmentInterfaceVO
							.getDepartmentname().trim() +"%");
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getFullname())) {
					strsql.append(" and fullname= ? ");
					super
							.addStringForField(departmentInterfaceVO
									.getFullname());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getParentid())) {
					strsql.append(" and parentid= ? ");
					super
							.addStringForField(departmentInterfaceVO
									.getParentid());
				}
				if (Integer.MIN_VALUE != departmentInterfaceVO.getOrdernum()) {
					strsql.append(" and ordernum= ? ");
					super.addIntForField(departmentInterfaceVO.getOrdernum());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getParentcode())) {
					strsql.append(" and parentcode= ? ");
					super.addStringForField(departmentInterfaceVO
							.getParentcode());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getParentname())) {
					strsql.append(" and parentname= ? ");
					super.addStringForField(departmentInterfaceVO
							.getParentname());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getLinkids())) {
					strsql.append(" and linkids= ? ");
					super.addStringForField(departmentInterfaceVO.getLinkids());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getDepartmenttype())) {
					strsql.append(" and departmenttype= ? ");
					super.addStringForField(departmentInterfaceVO
							.getDepartmenttype());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getNodeproperty())) {
					strsql.append(" and nodeproperty= ? ");
					super.addStringForField(departmentInterfaceVO
							.getNodeproperty());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getTelephone())) {
					strsql.append(" and telephone= ? ");
					super.addStringForField(departmentInterfaceVO
							.getTelephone());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO.getFax())) {
					strsql.append(" and fax= ? ");
					super.addStringForField(departmentInterfaceVO.getFax());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getAddress())) {
					strsql.append(" and address= ? ");
					super.addStringForField(departmentInterfaceVO.getAddress());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getPostcode())) {
					strsql.append(" and postcode= ? ");
					super
							.addStringForField(departmentInterfaceVO
									.getPostcode());
				}
				if (!StringUtils
						.isNullOrBlank(departmentInterfaceVO.getEmail())) {
					strsql.append(" and email= ? ");
					super.addStringForField(departmentInterfaceVO.getEmail());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getDepartmentdesc())) {
					strsql.append(" and departmentdesc= ? ");
					super.addStringForField(departmentInterfaceVO
							.getDepartmentdesc());
				}
				if (Long.MIN_VALUE != departmentInterfaceVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(departmentInterfaceVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getCreatorid())) {
					strsql.append(" and creatorid= ? ");
					super.addStringForField(departmentInterfaceVO
							.getCreatorid());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getCreatorname())) {
					strsql.append(" and creatorname= ? ");
					super.addStringForField(departmentInterfaceVO
							.getCreatorname());
				}
				if (Integer.MIN_VALUE != departmentInterfaceVO
						.getImportstatus()) {
					strsql.append(" and importstatus= ? ");
					super.addIntForField(departmentInterfaceVO
							.getImportstatus());
				}
				if (!StringUtils.isNullOrBlank(departmentInterfaceVO
						.getImportdesc())) {
					strsql.append(" and importdesc= ? ");
					super.addStringForField(departmentInterfaceVO
							.getImportdesc());
				}
			}
		} else if (QUERY_FROM_DEPARTMENTINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and departmentid in (?) ");
			super.addStringForField(ids);
		} else if ( QUERY_FROM_DEPARTMENTINTERFACE_AVAILABLE== _operatorType){
			strsql.append(" and importstatus != 1");
			
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
		departmentInterfaceVO = new DepartmentInterfaceVO();
		departmentInterfaceVO.setDepartmentid(rs.getString("departmentid"));
		departmentInterfaceVO.setDepartmentcode(rs.getString("departmentcode"));
		departmentInterfaceVO.setDepartmentname(rs.getString("departmentname"));
		departmentInterfaceVO.setFullname(rs.getString("fullname"));
		departmentInterfaceVO.setParentid(rs.getString("parentid"));
		departmentInterfaceVO.setOrdernum(rs.getInt("ordernum"));
		departmentInterfaceVO.setParentcode(rs.getString("parentcode"));
		departmentInterfaceVO.setParentname(rs.getString("parentname"));
		departmentInterfaceVO.setLinkids(rs.getString("linkids"));
		departmentInterfaceVO.setDepartmenttype(rs.getString("departmenttype"));
		departmentInterfaceVO.setNodeproperty(rs.getString("nodeproperty"));
		departmentInterfaceVO.setTelephone(rs.getString("telephone"));
		departmentInterfaceVO.setFax(rs.getString("fax"));
		departmentInterfaceVO.setAddress(rs.getString("address"));
		departmentInterfaceVO.setPostcode(rs.getString("postcode"));
		departmentInterfaceVO.setEmail(rs.getString("email"));
		departmentInterfaceVO.setCreatetime(rs.getTimestamp("createtime"));
		departmentInterfaceVO.setDepartmentdesc(rs.getString("departmentdesc"));
		departmentInterfaceVO.setRevision(rs.getLong("revision"));
		departmentInterfaceVO.setCreatorid(rs.getString("creatorid"));
		departmentInterfaceVO.setCreatorname(rs.getString("creatorname"));
		departmentInterfaceVO.setImportstatus(rs.getInt("importstatus"));
		departmentInterfaceVO.setImportdesc(rs.getString("importdesc"));
		listDepartmentInterface.add(departmentInterfaceVO);
	}

	public ArrayList<DepartmentInterfaceVO> getDepartmentInterfaceList() {
		return listDepartmentInterface;
	}

	public DepartmentInterfaceVO getDepartmentInterfaceVO() {
		return departmentInterfaceVO;
	}

}
