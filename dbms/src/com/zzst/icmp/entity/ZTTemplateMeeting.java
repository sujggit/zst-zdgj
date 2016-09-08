package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTTemplateMeeting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_template_meeting")
public class ZTTemplateMeeting implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	private String templateId;
	private String meetingName;
	private String meetingNumber;
	private String mcuEquipmentId;
	private Integer isMain;
	private String parentId;
	private String groupId;
	private String mcuTemplateId;
	private String createUserId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer status;
	private String description;
	private Integer rank;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTTemplateMeeting() {
	}

	/** full constructor */
	public ZTTemplateMeeting(String templateId, String meetingName,
			String meetingNumber, String mcuEquipmentId, Integer isMain,
			String parentId, String groupId, String mcuTemplateId,
			String createUserId, Timestamp createTime, Timestamp updateTime,
			Integer status, String description, Integer rank, Timestamp dbmsTime) {
		this.templateId = templateId;
		this.meetingName = meetingName;
		this.meetingNumber = meetingNumber;
		this.mcuEquipmentId = mcuEquipmentId;
		this.isMain = isMain;
		this.parentId = parentId;
		this.groupId = groupId;
		this.mcuTemplateId = mcuTemplateId;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.description = description;
		this.rank = rank;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "templateId", length = 50)
	public String getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	@Column(name = "meetingName", length = 100)
	public String getMeetingName() {
		return this.meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	@Column(name = "meetingNumber", length = 50)
	public String getMeetingNumber() {
		return this.meetingNumber;
	}

	public void setMeetingNumber(String meetingNumber) {
		this.meetingNumber = meetingNumber;
	}

	@Column(name = "mcuEquipmentId", length = 50)
	public String getMcuEquipmentId() {
		return this.mcuEquipmentId;
	}

	public void setMcuEquipmentId(String mcuEquipmentId) {
		this.mcuEquipmentId = mcuEquipmentId;
	}

	@Column(name = "isMain")
	public Integer getIsMain() {
		return this.isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	@Column(name = "parentId", length = 50)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "groupId", length = 50)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "mcuTemplateID", length = 50)
	public String getMcuTemplateId() {
		return this.mcuTemplateId;
	}

	public void setMcuTemplateId(String mcuTemplateId) {
		this.mcuTemplateId = mcuTemplateId;
	}

	@Column(name = "createUserID", length = 50)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}