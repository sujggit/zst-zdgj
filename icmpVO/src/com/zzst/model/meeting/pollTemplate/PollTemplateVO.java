package com.zzst.model.meeting.pollTemplate;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: PollTemplate Object
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTemplateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pollTemplateID;
	private String pollTemplateName;
	private String createUserID;
	private Timestamp createTime;
	private String description;
	private int status = Integer.MIN_VALUE;

	public void setPollTemplateID(String pollTemplateID) {
		this.pollTemplateID = pollTemplateID;
	}

	public String getPollTemplateID() {
		return pollTemplateID;
	}

	public void setPollTemplateName(String pollTemplateName) {
		this.pollTemplateName = pollTemplateName;
	}

	public String getPollTemplateName() {
		return pollTemplateName;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	public String getCreateUserID() {
		return createUserID;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
