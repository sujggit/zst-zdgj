package com.zzst.dao.meeting.address;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.address.AddressVO;

/**
 * class description: Address TO
 * 
 * @date Tue Jul 10 17:01:48 CST 2012
 * @author ryan
 */
public class AddressTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(AddressTO.class.getName());
	private int operatorType = -1;

	public static int ADD_ADDRESS = 1;
	public static int MODIFY_ADDRESS = 2;
	public static int DEL_ADDRESS = 3;
	private int result = 0;

	private AddressVO addressVO;
	private String ids = "";

	public AddressTO(int operatorType, AddressVO addressVO) {
		this.operatorType = operatorType;
		this.addressVO = addressVO;
	}

	public AddressTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_ADDRESS == operatorType) {
			sqlstr.append("insert into z_t_address ");
			sqlstr.append("(addressID,name,parentID,status,description,revision,leaf)");
			sqlstr.append(" values (?,?,?,?,?,?,?)");
			super.addStringForField(addressVO.getAddressID());
			super.addStringForField(addressVO.getName());
			super.addStringForField(addressVO.getParentID());
			super.addIntForField(addressVO.getStatus());
			super.addStringForField(addressVO.getDescription());
			super.addLongForField(addressVO.getRevision());
			super.addIntForField(addressVO.getLeaf());
		} else if (MODIFY_ADDRESS == operatorType) {
			sqlstr.append("update  z_t_address set ");
			sqlstr.append(" addressID = addressID ");
			
			if (addressVO.getLeaf() != Integer.MIN_VALUE) {
				sqlstr.append(" , leaf=?");
				super.addIntForField(addressVO.getLeaf());
			}
			
			if (addressVO.getName() != null) {
				sqlstr.append(" , name=? ");
				super.addStringForField(addressVO.getName());
			}

			if (addressVO.getParentID() != null) {
				sqlstr.append(" , parentID=? ");
				super.addStringForField(addressVO.getParentID());
			}

			if (addressVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(addressVO.getStatus());
			}

			if (addressVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(addressVO.getDescription());
			}

			if (addressVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(addressVO.getRevision());
			}

			sqlstr.append(" where addressID in (?) ");
			if (addressVO.getAddressID() != null) {
				super.addStringForField(addressVO.getAddressID());
			}
		} else if (DEL_ADDRESS == operatorType) {
			sqlstr.append("delete  from  z_t_address ");
			sqlstr.append(" where addressID in (?) ");
			super.addStringForField(addressVO.getAddressID());
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
