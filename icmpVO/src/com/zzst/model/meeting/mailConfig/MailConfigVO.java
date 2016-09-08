package com.zzst.model.meeting.mailConfig;

import java.io.Serializable;

/**
 * class description: MailConfig Object
 * 
 * @date Mon Nov 11 14:59:57 CST 2013
 * @author ryan
 */
public class MailConfigVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id = Integer.MIN_VALUE;
	private String mailSmtp;
	private String mailName;
	private String mailPass;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setMailSmtp(String mailSmtp) {
		this.mailSmtp = mailSmtp;
	}

	public String getMailSmtp() {
		return mailSmtp;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getMailName() {
		return mailName;
	}

	public void setMailPass(String mailPass) {
		this.mailPass = mailPass;
	}

	public String getMailPass() {
		return mailPass;
	}

}
