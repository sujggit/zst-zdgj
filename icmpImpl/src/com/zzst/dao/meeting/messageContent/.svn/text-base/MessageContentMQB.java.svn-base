package com.zzst.dao.meeting.messageContent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.messageContent.MessageContentVO;

/**
 * class description: MessageContent MQB
 * 
 * @date Thu May 09 09:33:18 CST 2013
 * @author ryan
 */
public class MessageContentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MessageContentMQB.class
			.getName());

	public static int QUERY_FROM_MESSAGECONTENT = 1;
	public static int QUERY_FROM_MESSAGECONTENT_BY_IDS = 2;
	public static int QUERY_FROM_MESSAGECONTENT_THREE = 3;

	private MessageContentVO messageContentVO;
	private ArrayList<MessageContentVO> listMessageContent = new ArrayList<MessageContentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public MessageContentMQB(int operatorType, MessageContentVO messageContentVO) {
		_operatorType = operatorType;
		this.messageContentVO = messageContentVO;
		makeSql();
	}

	public MessageContentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,messageSubject,messageBody,messageAdress,ifSuccess,messageComment,sendTime,insertTime,messageType,flowIdcont,flowType,nextClearTime ");
		strsql.append(" from z_t_messagescontent ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_MESSAGECONTENT == _operatorType) {
			if (null != messageContentVO) {
				if (!StringUtils.isNullOrBlank(messageContentVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(messageContentVO.getId());
				}
				if (!StringUtils.isNullOrBlank(messageContentVO
						.getMessageSubject())) {
					strsql.append(" and messageSubject= ? ");
					super.addStringForField(messageContentVO
							.getMessageSubject());
				}
				if (!StringUtils.isNullOrBlank(messageContentVO
						.getMessageBody())) {
					strsql.append(" and messageBody= ? ");
					super.addStringForField(messageContentVO.getMessageBody());
				}
				if (!StringUtils.isNullOrBlank(messageContentVO
						.getMessageAdress())) {
					strsql.append(" and messageAdress= ? ");
					super
							.addStringForField(messageContentVO
									.getMessageAdress());
				}
				if (Integer.MIN_VALUE != messageContentVO.getIfSuccess()) {
					strsql.append(" and ifSuccess= ? ");
					super.addIntForField(messageContentVO.getIfSuccess());
				}
				if (!StringUtils.isNullOrBlank(messageContentVO.getComment())) {
					strsql.append(" and messageComment= ? ");
					super.addStringForField(messageContentVO.getComment());
				}
				if (Integer.MIN_VALUE != messageContentVO
						.getMessageType()) {
					strsql.append(" and messageType= ? ");
					super.addIntForField(messageContentVO.getMessageType());
				}
				if (!StringUtils
						.isNullOrBlank(messageContentVO.getFlowIdCont())) {
					strsql.append(" and flowIdcont= ? ");
					super.addStringForField(messageContentVO.getFlowIdCont());
				}
				if (!StringUtils.isNullOrBlank(messageContentVO.getFlowType())) {
					strsql.append(" and flowType= ? ");
					super.addStringForField(messageContentVO.getFlowType());
				}
			}
		} else if (QUERY_FROM_MESSAGECONTENT_THREE == _operatorType) {
			strsql.append(ids);
		} else if (QUERY_FROM_MESSAGECONTENT_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		messageContentVO = new MessageContentVO();
		messageContentVO.setId(rs.getString("id"));
		messageContentVO.setMessageSubject(rs.getString("messageSubject"));
		messageContentVO.setMessageBody(rs.getString("messageBody"));
		messageContentVO.setMessageAdress(rs.getString("messageAdress"));
		messageContentVO.setIfSuccess(rs.getInt("ifSuccess"));
		messageContentVO.setComment(rs.getString("messageComment"));
		messageContentVO.setSendTime(rs.getTimestamp("sendTime"));
		messageContentVO.setInsertTime(rs.getTimestamp("insertTime"));
		messageContentVO.setMessageType(rs.getInt("messageType"));
		messageContentVO.setFlowIdCont(rs.getString("flowIdcont"));
		messageContentVO.setFlowType(rs.getString("flowType"));
		messageContentVO.setNextClearTime(rs.getTimestamp("nextClearTime"));
		listMessageContent.add(messageContentVO);
	}

	public ArrayList<MessageContentVO> getMessageContentList() {
		return listMessageContent;
	}

	public MessageContentVO getMessageContentVO() {
		return messageContentVO;
	}

}
