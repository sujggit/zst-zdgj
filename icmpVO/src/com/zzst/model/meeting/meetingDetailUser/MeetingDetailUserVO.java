package com.zzst.model.meeting.meetingDetailUser;

import java.io.Serializable;

/**
 * class description: MeetingDetailUser VO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String meetingDetailID;//meetingDetailID

	private String userID; //userID
	
	private Integer status=Integer.MIN_VALUE;//status

	private String appraisalID;//appraisalID

	private String description;

	private Long revision=Long.MIN_VALUE;
	
	private String userName;//页面传值使用
	
	//------------以下字段不建议使用-------------
	private String meetingDetailUserID;

	private String participatorID;

	private String participatorName;

	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setParticipatorName(String participatorName) {
		this.participatorName = participatorName;
	}

	public String getParticipatorName() {
		return participatorName;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
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

	public String getMeetingDetailUserID() {
		return meetingDetailUserID;
	}

	public void setMeetingDetailUserID(String meetingDetailUserID) {
		this.meetingDetailUserID = meetingDetailUserID;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getParticipatorID() {
		return participatorID;
	}

	public void setParticipatorID(String participatorID) {
		this.participatorID = participatorID;
	}

	public String getAppraisalID() {
		return appraisalID;
	}

	public void setAppraisalID(String appraisalID) {
		this.appraisalID = appraisalID;
	}

}
