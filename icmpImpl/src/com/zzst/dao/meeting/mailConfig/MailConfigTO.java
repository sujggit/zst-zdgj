package com.zzst.dao.meeting.mailConfig;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.mailConfig.MailConfigVO;

/**
 * class description: MailConfig TO
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public class MailConfigTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MailConfigTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_MAILCONFIG = 1;
	public static int MODIFY_MAILCONFIG = 2;
	public static int DEL_MAILCONFIG = 3;
	private int result = 0;

	private MailConfigVO mailConfigVO;

	public MailConfigTO(int operatorType, MailConfigVO mailConfigVO) {
		this.operatorType = operatorType;
		this.mailConfigVO = mailConfigVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MAILCONFIG == operatorType) {
			sqlstr.append("insert into z_t_mailconfig ");
			sqlstr.append("(id,mailSmtp,mailName,mailPass)");
			sqlstr.append(" values (?,?,?,?)");
			super.addIntForField(mailConfigVO.getId());
			super.addStringForField(mailConfigVO.getMailSmtp());
			super.addStringForField(mailConfigVO.getMailName());
			super.addStringForField(mailConfigVO.getMailPass());
		} else if (MODIFY_MAILCONFIG == operatorType) {
			sqlstr.append("update  z_t_mailconfig set ");
			sqlstr.append(" id = id ");

			if (mailConfigVO.getMailSmtp() != null) {
				sqlstr.append(" , mailSmtp=? ");
				super.addStringForField(mailConfigVO.getMailSmtp());
			}

			if (mailConfigVO.getMailName() != null) {
				sqlstr.append(" , mailName=? ");
				super.addStringForField(mailConfigVO.getMailName());
			}

			if (mailConfigVO.getMailPass() != null) {
				sqlstr.append(" , mailPass=? ");
				super.addStringForField(mailConfigVO.getMailPass());
			}

			sqlstr.append(" where id in (?) ");
			if (mailConfigVO.getId() != Integer.MIN_VALUE) {
				super.addIntForField(mailConfigVO.getId());
			}
		} else if (DEL_MAILCONFIG == operatorType) {
			sqlstr.append("delete  from  z_t_mailconfig ");
			sqlstr.append(" where id in (?) ");
			super.addIntForField(mailConfigVO.getId());
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
