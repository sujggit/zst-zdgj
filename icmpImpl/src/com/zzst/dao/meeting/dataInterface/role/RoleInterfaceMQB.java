package com.zzst.dao.meeting.dataInterface.role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;

/**
 * class description: RoleInterface MQB
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public class RoleInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(RoleInterfaceMQB.class.getName());

	public static int QUERY_FROM_ROLEINTERFACE = 1;
	public static int QUERY_FROM_ROLEINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_ROLEINTERFACE_AVAILABLE = 3;

	private RoleInterfaceVO roleInterfaceVO;
	private ArrayList<RoleInterfaceVO> listRoleInterface = new ArrayList<RoleInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public RoleInterfaceMQB(int operatorType, RoleInterfaceVO roleInterfaceVO) {
		_operatorType = operatorType;
		this.roleInterfaceVO = roleInterfaceVO;
		makeSql();
	}

	public RoleInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select roleid,rolecode,rolename,ordernum,parentid,parentcode,parentname,description,depid,depcode,depname,createtime,creatorid,creatorname,revision,importstatus,importdesc ");
		strsql.append(" from z_t_interface_in_role ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_ROLEINTERFACE == _operatorType) {
			if (null != roleInterfaceVO) {
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getRoleid())) {
					strsql.append(" and roleid= ? ");
					super.addStringForField(roleInterfaceVO.getRoleid());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getRolecode())) {
					strsql.append(" and rolecode= ? ");
					super.addStringForField(roleInterfaceVO.getRolecode());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getRolename())) {
					strsql.append(" and rolename like ? ");
					super.addStringForField("%"+roleInterfaceVO.getRolename().trim()+"%");
				}
				if (Integer.MIN_VALUE != roleInterfaceVO.getOrdernum()) {
					strsql.append(" and ordernum= ? ");
					super.addIntForField(roleInterfaceVO.getOrdernum());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getParentid())) {
					strsql.append(" and parentid= ? ");
					super.addStringForField(roleInterfaceVO.getParentid());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getParentcode())) {
					strsql.append(" and parentcode= ? ");
					super.addStringForField(roleInterfaceVO.getParentcode());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getParentname())) {
					strsql.append(" and parentname= ? ");
					super.addStringForField(roleInterfaceVO.getParentname());
				}
				if (!StringUtils
						.isNullOrBlank(roleInterfaceVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(roleInterfaceVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getDepid())) {
					strsql.append(" and depid= ? ");
					super.addStringForField(roleInterfaceVO.getDepid());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getDepcode())) {
					strsql.append(" and depcode= ? ");
					super.addStringForField(roleInterfaceVO.getDepcode());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getDepname())) {
					strsql.append(" and depname= ? ");
					super.addStringForField(roleInterfaceVO.getDepname());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getCreatorid())) {
					strsql.append(" and creatorid= ? ");
					super.addStringForField(roleInterfaceVO.getCreatorid());
				}
				if (!StringUtils
						.isNullOrBlank(roleInterfaceVO.getCreatorname())) {
					strsql.append(" and creatorname= ? ");
					super.addStringForField(roleInterfaceVO.getCreatorname());
				}
				if (Long.MIN_VALUE != roleInterfaceVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(roleInterfaceVO.getRevision());
				}
				if (Integer.MIN_VALUE != roleInterfaceVO.getImportstatus()) {
					strsql.append(" and importstatus= ? ");
					super.addIntForField(roleInterfaceVO.getImportstatus());
				}
				if (!StringUtils.isNullOrBlank(roleInterfaceVO.getImportdesc())) {
					strsql.append(" and importdesc= ? ");
					super.addStringForField(roleInterfaceVO.getImportdesc());
				}
			}
		} else if (QUERY_FROM_ROLEINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and roleid in (?) ");
			super.addStringForField(ids);
		}else if ( QUERY_FROM_ROLEINTERFACE_AVAILABLE == _operatorType){
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
		roleInterfaceVO = new RoleInterfaceVO();
		roleInterfaceVO.setRoleid(rs.getString("roleid"));
		roleInterfaceVO.setRolecode(rs.getString("rolecode"));
		roleInterfaceVO.setRolename(rs.getString("rolename"));
		roleInterfaceVO.setOrdernum(rs.getInt("ordernum"));
		roleInterfaceVO.setParentid(rs.getString("parentid"));
		roleInterfaceVO.setParentcode(rs.getString("parentcode"));
		roleInterfaceVO.setParentname(rs.getString("parentname"));
		roleInterfaceVO.setDescription(rs.getString("description"));
		roleInterfaceVO.setDepid(rs.getString("depid"));
		roleInterfaceVO.setDepcode(rs.getString("depcode"));
		roleInterfaceVO.setDepname(rs.getString("depname"));
		roleInterfaceVO.setCreatetime(rs.getTimestamp("createtime"));
		roleInterfaceVO.setCreatorid(rs.getString("creatorid"));
		roleInterfaceVO.setCreatorname(rs.getString("creatorname"));
		roleInterfaceVO.setRevision(rs.getLong("revision"));
		roleInterfaceVO.setImportstatus(rs.getInt("importstatus"));
		roleInterfaceVO.setImportdesc(rs.getString("importdesc"));
		listRoleInterface.add(roleInterfaceVO);
	}

	public ArrayList<RoleInterfaceVO> getRoleInterfaceList() {
		return listRoleInterface;
	}

	public RoleInterfaceVO getRoleInterfaceVO() {
		return roleInterfaceVO;
	}

}
