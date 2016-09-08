package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.LogEnum;

public class SendBySMS extends AddMessage implements Send {
	private boolean sysSMSSwitch = MeetingAppConfig.sms_status;
	@Override
	public void send(Object[] obj, Message message, String messageAddress) {
		if(sysSMSSwitch){
			String messageBody = message.getMessage(obj);
			int messageType = 2;
			String messageSubject = message.getMessageSubject();
			String flowType = message.getFlowType();
			String flowIdCont = message.getFlowIdCont(obj);
			Timestamp sendTime = message.getSendTime(obj);
			addMessage(flowType,flowIdCont,messageSubject,messageAddress,messageType,messageBody,sendTime,null);
			addLog(messageAddress,"短信");
		}

	}
	
	
}
