package com.zzst.dao.meeting.messageContent;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.messageContent.MessageContentVO;

/**
 * class description: MessageContent TO
 * 
 * @date Thu May 09 09:33:18 CST 2013
 * @author ryan
 */
public class MessageContentTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MessageContentTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_MESSAGECONTENT = 1;
	public static int MODIFY_MESSAGECONTENT = 2;
	public static int DEL_MESSAGECONTENT = 3;
	private int result = 0;

	private MessageContentVO messageContentVO;

	public MessageContentTO(int operatorType, MessageContentVO messageContentVO) {
		this.operatorType = operatorType;
		this.messageContentVO = messageContentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MESSAGECONTENT == operatorType) {
			sqlstr.append("insert into z_t_messagescontent ");
			sqlstr
					.append("(id,messageSubject,messageBody,messageAdress,ifSuccess,messageComment,sendTime,insertTime,messageType,flowIdcont,flowType,nextClearTime,workTypeEleven)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(messageContentVO.getId());
			super.addStringForField(messageContentVO.getMessageSubject());
			super.addStringForField(messageContentVO.getMessageBody());
			super.addStringForField(messageContentVO.getMessageAdress());
			super.addIntForField(messageContentVO.getIfSuccess());
			super.addStringForField(messageContentVO.getComment());
			super.addTimestampForField(messageContentVO.getSendTime());
			super.addTimestampForField(messageContentVO.getInsertTime());
			super.addIntForField(messageContentVO.getMessageType());
			super.addStringForField(messageContentVO.getFlowIdCont());
			super.addStringForField(messageContentVO.getFlowType());
			super.addTimestampForField(messageContentVO.getNextClearTime());
			super.addTimestampForField(messageContentVO.getWorkTypeEleven());
		} else if (MODIFY_MESSAGECONTENT == operatorType) {
			sqlstr.append("update  z_t_messagescontent set ");
			sqlstr.append(" id = id ");

			if (messageContentVO.getMessageSubject() != null) {
				sqlstr.append(" , messageSubject=? ");
				super.addStringForField(messageContentVO.getMessageSubject());
			}

			if (messageContentVO.getMessageBody() != null) {
				sqlstr.append(" , messageBody=? ");
				super.addStringForField(messageContentVO.getMessageBody());
			}

			if (messageContentVO.getMessageAdress() != null) {
				sqlstr.append(" , messageAdress=? ");
				super.addStringForField(messageContentVO.getMessageAdress());
			}

			if (messageContentVO.getIfSuccess() != Integer.MIN_VALUE) {
				sqlstr.append(" , ifSuccess=?");
				super.addIntForField(messageContentVO.getIfSuccess());
			}

			if (messageContentVO.getComment() != null) {
				sqlstr.append(" , messageComment=? ");
				super.addStringForField(messageContentVO.getComment());
			}

			if (messageContentVO.getSendTime() != null) {
				sqlstr.append(" , sendTime=? ");
				super.addTimestampForField(messageContentVO.getSendTime());
			}

			if (messageContentVO.getInsertTime() != null) {
				sqlstr.append(" , insertTime=? ");
				super.addTimestampForField(messageContentVO.getInsertTime());
			}

			if (messageContentVO.getMessageType() != Integer.MIN_VALUE) {
				sqlstr.append(" , messageType=? ");
				super.addIntForField(messageContentVO.getMessageType());
			}

			if (messageContentVO.getFlowIdCont() != null) {
				sqlstr.append(" , flowIdcont=? ");
				super.addStringForField(messageContentVO.getFlowIdCont());
			}

			if (messageContentVO.getFlowType() != null) {
				sqlstr.append(" , flowType=? ");
				super.addStringForField(messageContentVO.getFlowType());
			}

			if (messageContentVO.getNextClearTime() != null) {
				sqlstr.append(" , nextClearTime=? ");
				super.addTimestampForField(messageContentVO.getNextClearTime());
			}

			sqlstr.append(" where id in (?) ");
			if (messageContentVO.getId() != null) {
				super.addStringForField(messageContentVO.getId());
			}
		} else if (DEL_MESSAGECONTENT == operatorType) {
			sqlstr.append("delete  from  z_t_messagescontent ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(messageContentVO.getId());
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
