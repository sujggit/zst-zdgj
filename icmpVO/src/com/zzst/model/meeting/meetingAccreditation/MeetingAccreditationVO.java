package com.zzst.model.meeting.meetingAccreditation;

import java.io.Serializable;

/**
 * class description: MeetingAccreditation VO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingAccreditationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer meetingAccreditationID=Integer.MIN_VALUE;

	private Integer meetingDetailID=Integer.MIN_VALUE;

	private Integer userFromID=Integer.MIN_VALUE;

	private String userFromName;

	private Integer userToID=Integer.MIN_VALUE;

	private String userToName;

	private String description;

	private Long revision=Long.MIN_VALUE;

	public void setMeetingAccreditationID(Integer meetingAccreditationID) {
		this.meetingAccreditationID = meetingAccreditationID;
	}

	public Integer getMeetingAccreditationID() {
		return meetingAccreditationID;
	}

	public void setMeetingDetailID(Integer meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public Integer getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setUserFromID(Integer userFromID) {
		this.userFromID = userFromID;
	}

	public Integer getUserFromID() {
		return userFromID;
	}

	public void setUserFromName(String userFromName) {
		this.userFromName = userFromName;
	}

	public String getUserFromName() {
		return userFromName;
	}

	public void setUserToID(Integer userToID) {
		this.userToID = userToID;
	}

	public Integer getUserToID() {
		return userToID;
	}

	public void setUserToName(String userToName) {
		this.userToName = userToName;
	}

	public String getUserToName() {
		return userToName;
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

}
