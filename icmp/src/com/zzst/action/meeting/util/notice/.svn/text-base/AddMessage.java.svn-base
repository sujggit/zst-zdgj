package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;
import java.util.List;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.messageContent.MessageContentVO;

public class AddMessage {
	

	
	private String getMailSwitch(){
		String sysEmailSwitch =null;
		try {
			BaseInfoVO biVO = new BaseInfoVO();
			biVO.setInfoType("base_info_email");
			List<BaseInfoVO> baseList = ServiceFactory.getBaseInfoService().query(biVO, null);
			for(BaseInfoVO biVO1 : baseList){
				sysEmailSwitch = biVO1.getInfoValue();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return sysEmailSwitch;
	}
	
	public void addMessage(String flowType,String flowIdCont,String messageSubject,String messageAddress,int messageType,String messageBody,Timestamp sendTime,Timestamp endTime){
		try {
		MessageContentVO messageContent = new MessageContentVO();
		messageContent.setMessageType(messageType);

		messageContent.setFlowType(flowType);
		
		messageContent.setFlowIdCont(flowIdCont);
		messageContent.setMessageSubject(messageSubject);
		messageContent.setMessageBody(messageBody);
		messageContent.setInsertTime(new Timestamp(System.currentTimeMillis()));

		messageContent.setMessageAdress(messageAddress);
		messageContent.setSendTime(sendTime);
		messageContent.setWorkTypeEleven(endTime);
		ServiceFactory.getMessageContentService().add(messageContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加日志
	 * @param messageAddress  发送地址
	 * @param messageType	短信、邮件、告示等
	 */
	public void addLog(String messageAddress,String messageType){
		String logContent = "系统向" + messageAddress + "发送了" + messageType;
		ServiceFactory.addLog(LogEnum.LEVEL_2, Integer.toString(LogEnum.TYPE_DB), DateBaseEnum.Default_ID, logContent);
	}


}
