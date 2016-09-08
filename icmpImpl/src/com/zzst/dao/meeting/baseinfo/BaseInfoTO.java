package com.zzst.dao.meeting.baseinfo;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.config.BaseInfoVO;

/**
 * class description: BaseInfo TO
 * 
 * @date Fri Jun 15 13:43:00 CST 2012
 * @author ryan
 */
public class BaseInfoTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(BaseInfoTO.class.getName());
	private int operatorType = -1;

	public static int ADD_BASEINFO = 1;
	public static int MODIFY_BASEINFO = 2;
	public static int DEL_BASEINFO = 3;
	private int result = 0;

	private BaseInfoVO baseInfoVO;
	private String ids = "";

	public BaseInfoTO(int operatorType, BaseInfoVO baseInfoVO) {
		this.operatorType = operatorType;
		this.baseInfoVO = baseInfoVO;
	}

	public BaseInfoTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_BASEINFO == operatorType) {
			sqlstr.append("insert into z_t_baseinfo ");
			sqlstr.append("(id,infotype,infoname,infovalue,description,ordernum)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			super.addStringForField(baseInfoVO.getId());
			super.addStringForField(baseInfoVO.getInfoType());
			super.addStringForField(baseInfoVO.getInfoName());
			super.addStringForField(baseInfoVO.getInfoValue());
			super.addStringForField(baseInfoVO.getDescription());
			super.addStringForField(baseInfoVO.getOrder());
		} else if (MODIFY_BASEINFO == operatorType) {
			sqlstr.append("update  z_t_baseinfo set ");
			sqlstr.append(" id = id ");

			if (baseInfoVO.getInfoType() != null) {
				sqlstr.append(" , infotype=? ");
				super.addStringForField(baseInfoVO.getInfoType());
			}

			if (baseInfoVO.getInfoName() != null) {
				sqlstr.append(" , infoname=? ");
				super.addStringForField(baseInfoVO.getInfoName());
			}

			if (baseInfoVO.getInfoValue() != null) {
				sqlstr.append(" , infovalue=? ");
				super.addStringForField(baseInfoVO.getInfoValue());
			}

			if (baseInfoVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(baseInfoVO.getDescription());
			}

			if (baseInfoVO.getOrder() != null) {
				sqlstr.append(" , ordernum=? ");
				super.addStringForField(baseInfoVO.getOrder());
			}

			sqlstr.append(" where id in (?) ");
			if (baseInfoVO.getId() != null) {
				super.addStringForField(baseInfoVO.getId());
			}
		} else if (DEL_BASEINFO == operatorType) {
			sqlstr.append("delete  from  z_t_baseinfo ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(baseInfoVO.getId());
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
