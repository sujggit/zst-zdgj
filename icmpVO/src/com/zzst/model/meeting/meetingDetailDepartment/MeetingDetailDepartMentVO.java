package com.zzst.model.meeting.meetingDetailDepartment;

import java.io.Serializable;

/**
 * class description: MeetingDetailDepartMent Object
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public class MeetingDetailDepartMentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String meetingDetailID;
	private String departMentID;
	private String description;

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setDepartMentID(String departMentID) {
		this.departMentID = departMentID;
	}

	public String getDepartMentID() {
		return departMentID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
