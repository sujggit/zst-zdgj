package com.zzst.model.meeting.meetingRoomMaintainDetail;

import java.io.Serializable;

/**
 * class description: MeetingRoomMaintainDetail Object
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String detailID;
	private String maintainID;
	private String maintainName;
	private int status = Integer.MIN_VALUE;
	private String questionDes;
	private long revision = Long.MIN_VALUE;
	private String description;
    private int type  = Integer.MIN_VALUE;
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setDetailID(String detailID) {
		this.detailID = detailID;
	}

	public String getDetailID() {
		return detailID;
	}

	public void setMaintainID(String maintainID) {
		this.maintainID = maintainID;
	}

	public String getMaintainID() {
		return maintainID;
	}

	public void setMaintainName(String maintainName) {
		this.maintainName = maintainName;
	}

	public String getMaintainName() {
		return maintainName;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setQuestionDes(String questionDes) {
		this.questionDes = questionDes;
	}

	public String getQuestionDes() {
		return questionDes;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	
}
