package com.zzst.action.meeting.util.notice;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.tools.DateFormat;
import com.zzst.util.tools.notice.email.MailSenderInfo;
import com.zzst.util.tools.notice.email.SimpleMailSender;


/**
 *@Description
 *@date 2011-9-15上午10:54:25
 *@author ryan
 */
public class SendMail {
	private static Logger logger = CbfLogger.getLogger(SendMail.class
			.getName());
	
	
	/**
	 * 给与会人员发送短信
	 * @param String[]
	 * @param String
	 * @return boolean[]
	 */
	public static boolean[] sendMail(String[] emails,MeetingDetailVO meetingDetailVO){
		boolean[] reBoolean= null;
		logger.info("SendMail		sendMail	begin");
		if(MeetingAppConfig.mail_status){
			logger.info("系统支持发送邮件");	
			 MailSenderInfo mailInfo = getServerMail();
			for(int i=0;i<emails.length;i++){
				reBoolean = new boolean[emails.length];
				
				if(emails[i]==null||emails[i].length()==0) continue;
				
				mailInfo.setToAddress(emails[i]);
			    mailInfo.setSubject(MeetingAppConfig.MAIL_SUBNAME);
			    String content = MeetingAppConfig.MAIL_FORMAT;
			    content = content.replaceFirst("##1", meetingDetailVO.getMeetingName());
			    content = content.replaceFirst("##2", DateFormat.format(meetingDetailVO.getMeetingStartTime()));
			    content = content.replaceFirst("##3", DateFormat.format(meetingDetailVO.getMeetingEndTime()));
			    content = content.replaceFirst("##4", meetingDetailVO.getMeetingRoomNames());
			    
			    mailInfo.setContent(content);
			   try{
				   SimpleMailSender.sendTextMail(mailInfo);
				   logger.error("系统发送邮件："+emails[i]+"成功!!");
				   reBoolean[i] = true;
			   }catch(Exception e){
				   reBoolean[i] = false;
				   logger.error("系统发送邮件异常："+e.getMessage());
			   }
			}
		}else{
			logger.info("系统不允许发送邮件");
		}
		return reBoolean;
	}
	
	private static MailSenderInfo getServerMail(){
		 MailSenderInfo mailInfo = new MailSenderInfo();
	      mailInfo.setMailServerHost(MeetingAppConfig.MAIL_SMTP);
	      mailInfo.setMailServerPort(MeetingAppConfig.MAIL_SMTP_PORT);
	      mailInfo.setValidate(true);
	      mailInfo.setUserName(MeetingAppConfig.MAIL_USERNAME);
	      mailInfo.setPassword(MeetingAppConfig.MAIL_PASSWORD);//您的邮箱密码
	      mailInfo.setFromAddress(MeetingAppConfig.MAIL_ADDRESS);
		return mailInfo;
	}
}
