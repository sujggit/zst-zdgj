package com.zzst.util.tools.notice.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 *@Description
 *@date 2012-7-29下午05:31:33
 *@author ryan
 */
public class MyAuthenticator  extends Authenticator{
	String userName=null;
	String password=null;

	public MyAuthenticator(){
	}
	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}


public static void main(String[] args){
         //这个类主要是设置邮件
      MailSenderInfo mailInfo = new MailSenderInfo();
      mailInfo.setMailServerHost("smtp.163.com");
      mailInfo.setMailServerPort("25");
      mailInfo.setValidate(true);
      mailInfo.setUserName("5211422@163.com");
      mailInfo.setPassword("35857222");//您的邮箱密码
      mailInfo.setFromAddress("5211422@163.com");
      mailInfo.setToAddress("214670187@qq.com");
      mailInfo.setSubject("测试邮件");
      mailInfo.setContent("测试邮件的内容");
         //这个类主要来发送邮件
      SimpleMailSender sms = new SimpleMailSender();
          sms.sendTextMail(mailInfo);//发送文体格式
          sms.sendHtmlMail(mailInfo);//发送html格式
    }  
}
