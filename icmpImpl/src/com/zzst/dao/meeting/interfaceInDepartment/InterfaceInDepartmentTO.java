package com.zzst.dao.meeting.interfaceInDepartment;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.interfaceInDepartment.InterfaceInDepartmentVO;

/**
 * class description: InterfaceInDepartment TO
 * 
 * @date Mon Jun 17 16:54:25 CST 2013
 * @author ryan
 */
public class InterfaceInDepartmentTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(InterfaceInDepartmentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_INTERFACEINDEPARTMENT = 1;
	public static int MODIFY_INTERFACEINDEPARTMENT = 2;
	public static int DEL_INTERFACEINDEPARTMENT = 3;
	private int result = 0;

	private InterfaceInDepartmentVO interfaceInDepartmentVO;

	public InterfaceInDepartmentTO(int operatorType,
			InterfaceInDepartmentVO interfaceInDepartmentVO) {
		this.operatorType = operatorType;
		this.interfaceInDepartmentVO = interfaceInDepartmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_INTERFACEINDEPARTMENT == operatorType) {
			sqlstr.append("insert into z_t_interface_in_department ");
			sqlstr
					.append("(departmentid,departmentcode,departmentname,fullname,parentid,ordernum,parentcode,parentname,linkids,departmenttype,nodeproperty,telephone,fax,address,postcode,email,createtime,departmentdesc,revision,creatorid,creatorname)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(interfaceInDepartmentVO.getDepartmentId());
			super
					.addStringForField(interfaceInDepartmentVO
							.getDepartmentCode());
			super
					.addStringForField(interfaceInDepartmentVO
							.getDepartmentName());
			super.addStringForField(interfaceInDepartmentVO.getFullName());
			super.addStringForField(interfaceInDepartmentVO.getParentId());
			super.addIntForField(interfaceInDepartmentVO.getOrderNum());
			super.addStringForField(interfaceInDepartmentVO.getParentcCode());
			super.addStringForField(interfaceInDepartmentVO.getParentName());
			super.addStringForField(interfaceInDepartmentVO.getLinkIds());
			super
					.addStringForField(interfaceInDepartmentVO
							.getDepartmentType());
			super.addStringForField(interfaceInDepartmentVO.getNodeProperty());
			super.addStringForField(interfaceInDepartmentVO.getTelephone());
			super.addStringForField(interfaceInDepartmentVO.getFax());
			super.addStringForField(interfaceInDepartmentVO.getAddress());
			super.addStringForField(interfaceInDepartmentVO.getPostcode());
			super.addStringForField(interfaceInDepartmentVO.getEmail());
			super.addStringForField(interfaceInDepartmentVO.getCreatorId());
			super.addStringForField(interfaceInDepartmentVO.getCreatorName());
		} else if (MODIFY_INTERFACEINDEPARTMENT == operatorType) {
			sqlstr.append("update  z_t_interface_in_department set ");
			sqlstr.append(" departmentid = departmentid ");

			if (interfaceInDepartmentVO.getDepartmentCode() != null) {
				sqlstr.append(" , departmentcode=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getDepartmentCode());
			}

			if (interfaceInDepartmentVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentname=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getDepartmentName());
			}

			if (interfaceInDepartmentVO.getFullName() != null) {
				sqlstr.append(" , fullname=? ");
				super.addStringForField(interfaceInDepartmentVO.getFullName());
			}

			if (interfaceInDepartmentVO.getParentId() != null) {
				sqlstr.append(" , parentid=? ");
				super.addStringForField(interfaceInDepartmentVO.getParentId());
			}

			if (interfaceInDepartmentVO.getOrderNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , ordernum=?");
				super.addIntForField(interfaceInDepartmentVO.getOrderNum());
			}

			if (interfaceInDepartmentVO.getParentcCode() != null) {
				sqlstr.append(" , parentcode=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getParentcCode());
			}

			if (interfaceInDepartmentVO.getParentName() != null) {
				sqlstr.append(" , parentname=? ");
				super
						.addStringForField(interfaceInDepartmentVO
								.getParentName());
			}

			if (interfaceInDepartmentVO.getLinkIds() != null) {
				sqlstr.append(" , linkids=? ");
				super.addStringForField(interfaceInDepartmentVO.getLinkIds());
			}

			if (interfaceInDepartmentVO.getDepartmentType() != null) {
				sqlstr.append(" , departmenttype=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getDepartmentType());
			}

			if (interfaceInDepartmentVO.getNodeProperty() != null) {
				sqlstr.append(" , nodeproperty=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getNodeProperty());
			}

			if (interfaceInDepartmentVO.getTelephone() != null) {
				sqlstr.append(" , telephone=? ");
				super.addStringForField(interfaceInDepartmentVO.getTelephone());
			}

			if (interfaceInDepartmentVO.getFax() != null) {
				sqlstr.append(" , fax=? ");
				super.addStringForField(interfaceInDepartmentVO.getFax());
			}

			if (interfaceInDepartmentVO.getAddress() != null) {
				sqlstr.append(" , address=? ");
				super.addStringForField(interfaceInDepartmentVO.getAddress());
			}

			if (interfaceInDepartmentVO.getPostcode() != null) {
				sqlstr.append(" , postcode=? ");
				super.addStringForField(interfaceInDepartmentVO.getPostcode());
			}

			if (interfaceInDepartmentVO.getEmail() != null) {
				sqlstr.append(" , email=? ");
				super.addStringForField(interfaceInDepartmentVO.getEmail());
			}

			if (interfaceInDepartmentVO.getCreatorId() != null) {
				sqlstr.append(" , creatorid=? ");
				super.addStringForField(interfaceInDepartmentVO.getCreatorId());
			}

			if (interfaceInDepartmentVO.getCreatorName() != null) {
				sqlstr.append(" , creatorname=? ");
				super.addStringForField(interfaceInDepartmentVO
						.getCreatorName());
			}

			sqlstr.append(" where departmentid in (?) ");
			if (interfaceInDepartmentVO.getDepartmentId() != null) {
				super.addStringForField(interfaceInDepartmentVO
						.getDepartmentId());
			}
		} else if (DEL_INTERFACEINDEPARTMENT == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_department ");
			sqlstr.append(" where departmentid in (?) ");
			super.addStringForField(interfaceInDepartmentVO.getDepartmentId());
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
