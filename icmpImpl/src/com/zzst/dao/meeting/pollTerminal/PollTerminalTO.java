package com.zzst.dao.meeting.pollTerminal;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;

/**
 * class description: PollTerminal TO
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTerminalTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(PollTerminalTO.class
			.getName());
	private int operatorType = -1;
	

	public static int ADD_POLLTERMINAL = 1;
	public static int MODIFY_POLLTERMINAL = 2;
	public static int DEL_POLLTERMINAL = 3;
	public static int DEL_BYVO = 4;
	private int result = 0;

	private PollTerminalVO pollTerminalVO;
	private String ids = "";

	public PollTerminalTO(int operatorType, PollTerminalVO pollTerminalVO) {
		this.operatorType = operatorType;
		this.pollTerminalVO = pollTerminalVO;
	}

	public PollTerminalTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}
	
	

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_POLLTERMINAL == operatorType) {
			sqlstr.append("insert into z_t_poll_terminal ");
			sqlstr
					.append("(pollTerminalID,pollTemplateID,equipmentID,createUserID,createTime,orderNum,description,status,orgType)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			super.addStringForField(pollTerminalVO.getPollTerminalID());
			super.addStringForField(pollTerminalVO.getPollTemplateID());
			super.addStringForField(pollTerminalVO.getEquipmentID());
			super.addStringForField(pollTerminalVO.getCreateUserID());
			super.addTimestampForField(pollTerminalVO.getCreateTime());
			super.addIntForField(pollTerminalVO.getOrderNum());
			super.addStringForField(pollTerminalVO.getDescription());
			super.addIntForField(pollTerminalVO.getStatus());
			super.addIntForField(pollTerminalVO.getOrgType());
		} else if (MODIFY_POLLTERMINAL == operatorType) {
			sqlstr.append("update  z_t_poll_terminal set ");
			sqlstr.append(" pollTerminalID = pollTerminalID ");

			if (pollTerminalVO.getPollTemplateID() != null) {
				sqlstr.append(" , pollTemplateID=? ");
				super.addStringForField(pollTerminalVO.getPollTemplateID());
			}

			if (pollTerminalVO.getEquipmentID() != null) {
				sqlstr.append(" , equipmentID=? ");
				super.addStringForField(pollTerminalVO.getEquipmentID());
			}

			if (pollTerminalVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(pollTerminalVO.getCreateUserID());
			}

			if (pollTerminalVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(pollTerminalVO.getCreateTime());
			}

			if (pollTerminalVO.getOrderNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , orderNum=?");
				super.addIntForField(pollTerminalVO.getOrderNum());
			}

			if (pollTerminalVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(pollTerminalVO.getDescription());
			}

			if (pollTerminalVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(pollTerminalVO.getStatus());
			}

			sqlstr.append(" where pollTerminalID in (?) ");
			if (pollTerminalVO.getPollTerminalID() != null) {
				super.addStringForField(pollTerminalVO.getPollTerminalID());
			}
		} else if (DEL_POLLTERMINAL == operatorType) {
			sqlstr.append("delete  from  z_t_poll_terminal ");
			sqlstr.append(" where pollTerminalID in (?) ");
			super.addStringForField(pollTerminalVO.getPollTerminalID());
		} else if( DEL_BYVO == operatorType){
			sqlstr.append("delete  from  z_t_poll_terminal ");
			sqlstr.append(" where pollTemplateID = ?  ");
			super.addStringForField(pollTerminalVO.getPollTemplateID());
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
