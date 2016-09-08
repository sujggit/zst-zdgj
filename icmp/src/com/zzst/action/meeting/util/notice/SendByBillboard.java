package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.meeting.log.LogVO;
/**
 * 发布告示
 * @author zhangjz
 *
 */
public class SendByBillboard extends AddMessage implements Send{
	
	private boolean sysBillboardSwitch = MeetingAppConfig.billboard_status; //系统告示开关
	
	@Override
	public void send(Object[] obj, Message message,String messageAddress) {
		if(sysBillboardSwitch){
			String messageBody = message.getMessage(obj);
			int messageType = 3;
			String messageSubject = message.getMessageSubject();
			String flowType = message.getFlowType();
			String flowIdCont = message.getFlowIdCont(obj);
			Timestamp sendTime = message.getSendTime(obj);
			Timestamp endTime = message.getEndTime(obj);
			addMessage(flowType,flowIdCont,messageSubject,messageAddress,messageType,messageBody,sendTime,endTime);
			addLog(messageAddress,"告示");
			
		}

	}
	
}
