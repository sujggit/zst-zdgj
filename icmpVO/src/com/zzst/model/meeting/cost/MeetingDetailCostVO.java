package com.zzst.model.meeting.cost;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

public class MeetingDetailCostVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String meetingDetailId;
	private String costItem;
	private int cout	=	Integer.MIN_VALUE;    
	private int costValue	=	Integer.MIN_VALUE;    
	private String createUserId;
	private Timestamp createTime;	            	
	private int status	=	Integer.MIN_VALUE;    
	private String description;
	private long revision	=	Long.MIN_VALUE;
	
	private UserVO userVO = new UserVO();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMeetingDetailId() {
		return meetingDetailId;
	}

	public void setMeetingDetailId(String meetingDetailId) {
		this.meetingDetailId = meetingDetailId;
	}

	public String getCostItem() {
		return costItem;
	}

	public void setCostItem(String costItem) {
		this.costItem = costItem;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getCostValue() {
		return costValue;
	}

	public void setCostValue(int costValue) {
		this.costValue = costValue;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRevision() {
		return revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
	
}
