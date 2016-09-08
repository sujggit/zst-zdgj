package com.zzst.model.meeting.videoconference;

import java.io.Serializable;

/**
 * class description: Videoconference VO
 * 
 * @author ryan
 * @date Mon Aug 24 13:32:23 CST 2009
 */

public class VideoconferenceVO implements Serializable {

	private static final long serialVersionUID = 1L;


	private String meetingDetailID;//meetingDetailID
	
	private Integer ismain=Integer.MIN_VALUE;//ismain
	
	private Integer rate=Integer.MIN_VALUE;//speed

	private String description;

	private Long revision=Long.MIN_VALUE;

	private String submeetingRoomID;
	private String submeetingRoomName;
	private String rank;//排序

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setSubmeetingRoomName(String submeetingRoomName) {
		this.submeetingRoomName = submeetingRoomName;
	}

	public String getSubmeetingRoomName() {
		return submeetingRoomName;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getRate() {
		return rate;
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

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getSubmeetingRoomID() {
		return submeetingRoomID;
	}

	public void setSubmeetingRoomID(String submeetingRoomID) {
		this.submeetingRoomID = submeetingRoomID;
	}

	public Integer getIsmain() {
		return ismain;
	}

	public void setIsmain(Integer ismain) {
		this.ismain = ismain;
	}

	 

}
