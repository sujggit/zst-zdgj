package com.zzst.dao.meeting.pollTemplate;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;

/**
 * class description: PollTemplate TO
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTemplateTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(PollTemplateTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_POLLTEMPLATE = 1;
	public static int MODIFY_POLLTEMPLATE = 2;
	public static int DEL_POLLTEMPLATE = 3;
	private int result = 0;

	private PollTemplateVO pollTemplateVO;
	private String ids = "";

	public PollTemplateTO(int operatorType, PollTemplateVO pollTemplateVO) {
		this.operatorType = operatorType;
		this.pollTemplateVO = pollTemplateVO;
	}

	public PollTemplateTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_POLLTEMPLATE == operatorType) {
			sqlstr.append("insert into z_t_poll_template ");
			sqlstr
					.append("(pollTemplateID,pollTemplateName,createUserID,createTime,description,status)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			super.addStringForField(pollTemplateVO.getPollTemplateID());
			super.addStringForField(pollTemplateVO.getPollTemplateName());
			super.addStringForField(pollTemplateVO.getCreateUserID());
			super.addTimestampForField(pollTemplateVO.getCreateTime());
			super.addStringForField(pollTemplateVO.getDescription());
			super.addIntForField(pollTemplateVO.getStatus());
		} else if (MODIFY_POLLTEMPLATE == operatorType) {
			sqlstr.append("update  z_t_poll_template set ");
			sqlstr.append(" pollTemplateID = pollTemplateID ");

			if (pollTemplateVO.getPollTemplateName() != null) {
				sqlstr.append(" , pollTemplateName=? ");
				super.addStringForField(pollTemplateVO.getPollTemplateName());
			}

			if (pollTemplateVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(pollTemplateVO.getCreateUserID());
			}

			if (pollTemplateVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(pollTemplateVO.getCreateTime());
			}

			if (pollTemplateVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(pollTemplateVO.getDescription());
			}

			if (pollTemplateVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(pollTemplateVO.getStatus());
			}

			sqlstr.append(" where pollTemplateID in (?) ");
			if (pollTemplateVO.getPollTemplateID() != null) {
				super.addStringForField(pollTemplateVO.getPollTemplateID());
			}
		} else if (DEL_POLLTEMPLATE == operatorType) {
			sqlstr.append("delete  from  z_t_poll_template ");
			sqlstr.append(" where pollTemplateID in (?) ");
			super.addStringForField(pollTemplateVO.getPollTemplateID());
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
