package com.zzst.model.meeting.announcement;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * AnnouncementVO
 * @author zhangliang
 * Nov 30, 2011 10:26:27 AM
 */
public class AnnouncementVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer announcementID=Integer.MIN_VALUE;

	private Integer userID=Integer.MIN_VALUE;

	private String userName;

	private Timestamp createTime;

	private Timestamp startTime;

	private Timestamp endTime;

	private String title;

	private String content;

	private String description;

	private Long revision=Long.MIN_VALUE;

	public void setAnnouncementID(Integer announcementID) {
		this.announcementID = announcementID;
	}

	public Integer getAnnouncementID() {
		return announcementID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getUserName() {
		return userName;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
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
