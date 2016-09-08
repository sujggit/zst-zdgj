package com.zzst.model.meeting.templateMeeting;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: TemplateMeeting Object
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateMeetingVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String templateId;
	private String meetingName;
	private String meetingNumber;
	private String mcuEquipmentId;
	private int isMain = Integer.MIN_VALUE;
	private String parentId;
	private String groupId;
	private int status = Integer.MIN_VALUE;
	private String description;
	private int rank = Integer.MIN_VALUE;
	private String createUserID;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String mcuTemplateID;
	
	//////////页面传递参数用到的字段
	private String mcuEquipmentName;
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingNumber(String meetingNumber) {
		this.meetingNumber = meetingNumber;
	}

	public String getMeetingNumber() {
		return meetingNumber;
	}

	public void setMcuEquipmentId(String mcuEquipmentId) {
		this.mcuEquipmentId = mcuEquipmentId;
	}

	public String getMcuEquipmentId() {
		return mcuEquipmentId;
	}

	public void setIsMain(int isMain) {
		this.isMain = isMain;
	}

	public int getIsMain() {
		return isMain;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
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

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public String getMcuTemplateID() {
		return mcuTemplateID;
	}

	public void setMcuTemplateID(String mcuTemplateID) {
		this.mcuTemplateID = mcuTemplateID;
	}

	public String getMcuEquipmentName() {
		return mcuEquipmentName;
	}

	public void setMcuEquipmentName(String mcuEquipmentName) {
		this.mcuEquipmentName = mcuEquipmentName;
	}
	
	
	
}
