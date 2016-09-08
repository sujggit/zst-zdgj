package com.zzst.dao.meeting.dataInterface.role;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;

/**
 * class description: RoleInterface TO
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public class RoleInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(RoleInterfaceTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_ROLEINTERFACE = 1;
	public static int MODIFY_ROLEINTERFACE = 2;
	public static int DEL_ROLEINTERFACE = 3;
	public static int DEL_ALL = 4;
	
	private int result = 0;

	private RoleInterfaceVO roleInterfaceVO;
	private String ids = "";

	public RoleInterfaceTO(int operatorType, RoleInterfaceVO roleInterfaceVO) {
		this.operatorType = operatorType;
		this.roleInterfaceVO = roleInterfaceVO;
	}

	public RoleInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_ROLEINTERFACE == operatorType) {
			sqlstr.append("insert into z_t_interface_in_role ");
			sqlstr
					.append("(roleid,rolecode,rolename,ordernum,parentid,parentcode,parentname,description,depid,depcode,depname,createtime,creatorid,creatorname,revision,importstatus,importdesc)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(roleInterfaceVO.getRoleid());
			super.addStringForField(roleInterfaceVO.getRolecode());
			super.addStringForField(roleInterfaceVO.getRolename());
			super.addIntForField(roleInterfaceVO.getOrdernum());
			super.addStringForField(roleInterfaceVO.getParentid());
			super.addStringForField(roleInterfaceVO.getParentcode());
			super.addStringForField(roleInterfaceVO.getParentname());
			super.addStringForField(roleInterfaceVO.getDescription());
			super.addStringForField(roleInterfaceVO.getDepid());
			super.addStringForField(roleInterfaceVO.getDepcode());
			super.addStringForField(roleInterfaceVO.getDepname());
			super.addTimestampForField(roleInterfaceVO.getCreatetime());
			super.addStringForField(roleInterfaceVO.getCreatorid());
			super.addStringForField(roleInterfaceVO.getCreatorname());
			super.addLongForField(roleInterfaceVO.getRevision());
			super.addIntForField(roleInterfaceVO.getImportstatus());
			super.addStringForField(roleInterfaceVO.getImportdesc());
		} else if (MODIFY_ROLEINTERFACE == operatorType) {
			sqlstr.append("update  z_t_interface_in_role set ");
			sqlstr.append(" roleid = roleid ");

			if (roleInterfaceVO.getRolecode() != null) {
				sqlstr.append(" , rolecode=? ");
				super.addStringForField(roleInterfaceVO.getRolecode());
			}

			if (roleInterfaceVO.getRolename() != null) {
				sqlstr.append(" , rolename=? ");
				super.addStringForField(roleInterfaceVO.getRolename());
			}

			if (roleInterfaceVO.getOrdernum() != Integer.MIN_VALUE) {
				sqlstr.append(" , ordernum=?");
				super.addIntForField(roleInterfaceVO.getOrdernum());
			}

			if (roleInterfaceVO.getParentid() != null) {
				sqlstr.append(" , parentid=? ");
				super.addStringForField(roleInterfaceVO.getParentid());
			}

			if (roleInterfaceVO.getParentcode() != null) {
				sqlstr.append(" , parentcode=? ");
				super.addStringForField(roleInterfaceVO.getParentcode());
			}

			if (roleInterfaceVO.getParentname() != null) {
				sqlstr.append(" , parentname=? ");
				super.addStringForField(roleInterfaceVO.getParentname());
			}

			if (roleInterfaceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(roleInterfaceVO.getDescription());
			}

			if (roleInterfaceVO.getDepid() != null) {
				sqlstr.append(" , depid=? ");
				super.addStringForField(roleInterfaceVO.getDepid());
			}

			if (roleInterfaceVO.getDepcode() != null) {
				sqlstr.append(" , depcode=? ");
				super.addStringForField(roleInterfaceVO.getDepcode());
			}

			if (roleInterfaceVO.getDepname() != null) {
				sqlstr.append(" , depname=? ");
				super.addStringForField(roleInterfaceVO.getDepname());
			}

			if (roleInterfaceVO.getCreatetime() != null) {
				sqlstr.append(" , createtime=? ");
				super.addTimestampForField(roleInterfaceVO.getCreatetime());
			}

			if (roleInterfaceVO.getCreatorid() != null) {
				sqlstr.append(" , creatorid=? ");
				super.addStringForField(roleInterfaceVO.getCreatorid());
			}

			if (roleInterfaceVO.getCreatorname() != null) {
				sqlstr.append(" , creatorname=? ");
				super.addStringForField(roleInterfaceVO.getCreatorname());
			}

			if (roleInterfaceVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(roleInterfaceVO.getRevision());
			}

			if (roleInterfaceVO.getImportstatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , importstatus=?");
				super.addIntForField(roleInterfaceVO.getImportstatus());
			}

			if (roleInterfaceVO.getImportdesc() != null) {
				sqlstr.append(" , importdesc=? ");
				super.addStringForField(roleInterfaceVO.getImportdesc());
			}

			sqlstr.append(" where roleid in (?) ");
			if (roleInterfaceVO.getRoleid() != null) {
				super.addStringForField(roleInterfaceVO.getRoleid());
			}
		} else if (DEL_ROLEINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_role ");
			sqlstr.append(" where roleid in (?) ");
			super.addStringForField(roleInterfaceVO.getRoleid());
		} else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_t_interface_in_role ");
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
