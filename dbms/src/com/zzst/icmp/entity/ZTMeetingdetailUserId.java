package com.zzst.icmp.entity;

/**
 * ZTMeetingdetailUserId generated by MyEclipse Persistence Tools
 */

public class ZTMeetingdetailUserId implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;

	private String userId;

	private String meetingDetailId;

	// Constructors

	/** default constructor */
	public ZTMeetingdetailUserId() {
	}

	/** full constructor */
	public ZTMeetingdetailUserId(String userId, String meetingDetailId) {
		this.userId = userId;
		this.meetingDetailId = meetingDetailId;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMeetingDetailId() {
		return this.meetingDetailId;
	}

	public void setMeetingDetailId(String meetingDetailId) {
		this.meetingDetailId = meetingDetailId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZTMeetingdetailUserId))
			return false;
		ZTMeetingdetailUserId castOther = (ZTMeetingdetailUserId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getMeetingDetailId() == castOther
						.getMeetingDetailId()) || (this.getMeetingDetailId() != null
						&& castOther.getMeetingDetailId() != null && this
						.getMeetingDetailId().equals(
								castOther.getMeetingDetailId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getMeetingDetailId() == null ? 0 : this.getMeetingDetailId()
						.hashCode());
		return result;
	}

}