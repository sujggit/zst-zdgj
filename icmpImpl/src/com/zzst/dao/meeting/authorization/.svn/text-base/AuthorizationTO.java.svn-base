package com.zzst.dao.meeting.authorization;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.authorization.AuthorizationVO;

/**
 * class description: Authorization TO
 * 
 * @date Tue May 28 11:26:12 CST 2013
 * @author ryan
 */
public class AuthorizationTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(AuthorizationTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_AUTHORIZATION = 1;
	public static int MODIFY_AUTHORIZATION = 2;
	public static int DEL_AUTHORIZATION = 3;
	private int result = 0;

	private AuthorizationVO authorizationVO;

	public AuthorizationTO(int operatorType, AuthorizationVO authorizationVO) {
		this.operatorType = operatorType;
		this.authorizationVO = authorizationVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_AUTHORIZATION == operatorType) {
			sqlstr.append("insert into z_t_authorization ");
			sqlstr
					.append("(id,Infotype,InfoKey,InfoValue,description,REF1,REF2,REF3)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(authorizationVO.getId());
			super.addStringForField(authorizationVO.getInfotype());
			super.addStringForField(authorizationVO.getInfoKey());
			super.addStringForField(authorizationVO.getInfoValue());
			super.addStringForField(authorizationVO.getDescription());
			super.addStringForField(authorizationVO.getREF1());
			super.addStringForField(authorizationVO.getREF2());
			super.addStringForField(authorizationVO.getREF3());
		} else if (MODIFY_AUTHORIZATION == operatorType) {
			sqlstr.append("update  z_t_authorization set ");
			sqlstr.append(" id = id ");

			if (authorizationVO.getInfotype() != null) {
				sqlstr.append(" , Infotype=? ");
				super.addStringForField(authorizationVO.getInfotype());
			}

			if (authorizationVO.getInfoKey() != null) {
				sqlstr.append(" , InfoKey=? ");
				super.addStringForField(authorizationVO.getInfoKey());
			}

			if (authorizationVO.getInfoValue() != null) {
				sqlstr.append(" , InfoValue=? ");
				super.addStringForField(authorizationVO.getInfoValue());
			}

			if (authorizationVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(authorizationVO.getDescription());
			}

			if (authorizationVO.getREF1() != null) {
				sqlstr.append(" , REF1=? ");
				super.addStringForField(authorizationVO.getREF1());
			}

			if (authorizationVO.getREF2() != null) {
				sqlstr.append(" , REF2=? ");
				super.addStringForField(authorizationVO.getREF2());
			}

			if (authorizationVO.getREF3() != null) {
				sqlstr.append(" , REF3=? ");
				super.addStringForField(authorizationVO.getREF3());
			}

			sqlstr.append(" where id in (?) ");
			if (authorizationVO.getId() != null) {
				super.addStringForField(authorizationVO.getId());
			}
		} else if (DEL_AUTHORIZATION == operatorType) {
			sqlstr.append("delete  from  z_t_authorization ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(authorizationVO.getId());
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
