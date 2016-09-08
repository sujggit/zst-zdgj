package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_template")
public class ZTTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	private String templateName;
	private String duration;
	private String createUserId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer status;
	private String description;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTTemplate() {
	}

	/** full constructor */
	public ZTTemplate(String templateName, String duration,
			String createUserId, Timestamp createTime, Timestamp updateTime,
			Integer status, String description, Timestamp dbmsTime) {
		this.templateName = templateName;
		this.duration = duration;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.description = description;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "templateName", length = 50)
	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "duration", length = 50)
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}