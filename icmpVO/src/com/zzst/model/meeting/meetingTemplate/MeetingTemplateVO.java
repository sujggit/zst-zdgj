package com.zzst.model.meeting.meetingTemplate;

import java.io.Serializable;

/**
 * class description: MeetingTemplate VO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingTemplateVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer meetingTemplateID=Integer.MIN_VALUE;

	private String templateName;

	private Integer meetingDetailID=Integer.MIN_VALUE;

	private String description;

	private Long revision=Long.MIN_VALUE;

	private String creatUserID;
	
	private String creatUserName;
	
	public void setMeetingTemplateID(Integer meetingTemplateID) {
		this.meetingTemplateID = meetingTemplateID;
	}

	public Integer getMeetingTemplateID() {
		return meetingTemplateID;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setMeetingDetailID(Integer meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public Integer getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

	public String getCreatUserName() {
		return creatUserName;
	}

	public void setCreatUserName(String creatUserName) {
		this.creatUserName = creatUserName;
	}

	/**
	 * @return the creatUserID
	 */
	public String getCreatUserID() {
		return creatUserID;
	}

	/**
	 * @param creatUserID the creatUserID to set
	 */
	public void setCreatUserID(String creatUserID) {
		this.creatUserID = creatUserID;
	}

}
