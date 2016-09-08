package com.zzst.dao.meeting.dataInterface.department;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;

/**
 * class description: DepartmentInterface TO
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public class DepartmentInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(DepartmentInterfaceTO.class.getName());
	private int operatorType = -1;

	public static int ADD_DEPARTMENTINTERFACE = 1;
	public static int MODIFY_DEPARTMENTINTERFACE = 2;
	public static int DEL_DEPARTMENTINTERFACE = 3;
	public static int DEL_ALL = 4;
	
	private int result = 0;

	private DepartmentInterfaceVO departmentInterfaceVO;
	private String ids = "";

	public DepartmentInterfaceTO(int operatorType,
			DepartmentInterfaceVO departmentInterfaceVO) {
		this.operatorType = operatorType;
		this.departmentInterfaceVO = departmentInterfaceVO;
	}

	public DepartmentInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_DEPARTMENTINTERFACE == operatorType) {
			sqlstr.append("insert into z_t_interface_in_department ");
			sqlstr
					.append("(departmentid,departmentcode,departmentname,fullname,parentid,ordernum,parentcode,parentname,linkids,departmenttype,nodeproperty,telephone,fax,address,postcode,email,createtime,departmentdesc,revision,creatorid,creatorname,importstatus,importdesc)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(departmentInterfaceVO.getDepartmentid());
			super.addStringForField(departmentInterfaceVO.getDepartmentcode());
			super.addStringForField(departmentInterfaceVO.getDepartmentname());
			super.addStringForField(departmentInterfaceVO.getFullname());
			super.addStringForField(departmentInterfaceVO.getParentid());
			super.addIntForField(departmentInterfaceVO.getOrdernum());
			super.addStringForField(departmentInterfaceVO.getParentcode());
			super.addStringForField(departmentInterfaceVO.getParentname());
			super.addStringForField(departmentInterfaceVO.getLinkids());
			super.addStringForField(departmentInterfaceVO.getDepartmenttype());
			super.addStringForField(departmentInterfaceVO.getNodeproperty());
			super.addStringForField(departmentInterfaceVO.getTelephone());
			super.addStringForField(departmentInterfaceVO.getFax());
			super.addStringForField(departmentInterfaceVO.getAddress());
			super.addStringForField(departmentInterfaceVO.getPostcode());
			super.addStringForField(departmentInterfaceVO.getEmail());
			super.addTimestampForField(departmentInterfaceVO.getCreatetime());
			super.addStringForField(departmentInterfaceVO.getDepartmentdesc());
			super.addLongForField(departmentInterfaceVO.getRevision());
			super.addStringForField(departmentInterfaceVO.getCreatorid());
			super.addStringForField(departmentInterfaceVO.getCreatorname());
			super.addIntForField(departmentInterfaceVO.getImportstatus());
			super.addStringForField(departmentInterfaceVO.getImportdesc());
		} else if (MODIFY_DEPARTMENTINTERFACE == operatorType) {
			sqlstr.append("update  z_t_interface_in_department set ");
			sqlstr.append(" departmentid = departmentid ");

			if (departmentInterfaceVO.getDepartmentcode() != null) {
				sqlstr.append(" , departmentcode=? ");
				super.addStringForField(departmentInterfaceVO
						.getDepartmentcode());
			}

			if (departmentInterfaceVO.getDepartmentname() != null) {
				sqlstr.append(" , departmentname=? ");
				super.addStringForField(departmentInterfaceVO
						.getDepartmentname());
			}

			if (departmentInterfaceVO.getFullname() != null) {
				sqlstr.append(" , fullname=? ");
				super.addStringForField(departmentInterfaceVO.getFullname());
			}

			if (departmentInterfaceVO.getParentid() != null) {
				sqlstr.append(" , parentid=? ");
				super.addStringForField(departmentInterfaceVO.getParentid());
			}

			if (departmentInterfaceVO.getOrdernum() != Integer.MIN_VALUE) {
				sqlstr.append(" , ordernum=?");
				super.addIntForField(departmentInterfaceVO.getOrdernum());
			}

			if (departmentInterfaceVO.getParentcode() != null) {
				sqlstr.append(" , parentcode=? ");
				super.addStringForField(departmentInterfaceVO.getParentcode());
			}

			if (departmentInterfaceVO.getParentname() != null) {
				sqlstr.append(" , parentname=? ");
				super.addStringForField(departmentInterfaceVO.getParentname());
			}

			if (departmentInterfaceVO.getLinkids() != null) {
				sqlstr.append(" , linkids=? ");
				super.addStringForField(departmentInterfaceVO.getLinkids());
			}

			if (departmentInterfaceVO.getDepartmenttype() != null) {
				sqlstr.append(" , departmenttype=? ");
				super.addStringForField(departmentInterfaceVO
						.getDepartmenttype());
			}

			if (departmentInterfaceVO.getNodeproperty() != null) {
				sqlstr.append(" , nodeproperty=? ");
				super
						.addStringForField(departmentInterfaceVO
								.getNodeproperty());
			}

			if (departmentInterfaceVO.getTelephone() != null) {
				sqlstr.append(" , telephone=? ");
				super.addStringForField(departmentInterfaceVO.getTelephone());
			}

			if (departmentInterfaceVO.getFax() != null) {
				sqlstr.append(" , fax=? ");
				super.addStringForField(departmentInterfaceVO.getFax());
			}

			if (departmentInterfaceVO.getAddress() != null) {
				sqlstr.append(" , address=? ");
				super.addStringForField(departmentInterfaceVO.getAddress());
			}

			if (departmentInterfaceVO.getPostcode() != null) {
				sqlstr.append(" , postcode=? ");
				super.addStringForField(departmentInterfaceVO.getPostcode());
			}

			if (departmentInterfaceVO.getEmail() != null) {
				sqlstr.append(" , email=? ");
				super.addStringForField(departmentInterfaceVO.getEmail());
			}

			if (departmentInterfaceVO.getCreatetime() != null) {
				sqlstr.append(" , createtime=? ");
				super.addTimestampForField(departmentInterfaceVO
						.getCreatetime());
			}

			if (departmentInterfaceVO.getDepartmentdesc() != null) {
				sqlstr.append(" , departmentdesc=? ");
				super.addStringForField(departmentInterfaceVO
						.getDepartmentdesc());
			}

			if (departmentInterfaceVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(departmentInterfaceVO.getRevision());
			}

			if (departmentInterfaceVO.getCreatorid() != null) {
				sqlstr.append(" , creatorid=? ");
				super.addStringForField(departmentInterfaceVO.getCreatorid());
			}

			if (departmentInterfaceVO.getCreatorname() != null) {
				sqlstr.append(" , creatorname=? ");
				super.addStringForField(departmentInterfaceVO.getCreatorname());
			}

			if (departmentInterfaceVO.getImportstatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , importstatus=?");
				super.addIntForField(departmentInterfaceVO.getImportstatus());
			}

			if (departmentInterfaceVO.getImportdesc() != null) {
				sqlstr.append(" , importdesc=? ");
				super.addStringForField(departmentInterfaceVO.getImportdesc());
			}

			sqlstr.append(" where departmentid in (?) ");
			if (departmentInterfaceVO.getDepartmentid() != null) {
				super
						.addStringForField(departmentInterfaceVO
								.getDepartmentid());
			}
		} else if (DEL_DEPARTMENTINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_department ");
			sqlstr.append(" where departmentid in (?) ");
			super.addStringForField(departmentInterfaceVO.getDepartmentid());
		} else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_t_interface_in_department ");
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
