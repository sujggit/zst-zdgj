package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTPollTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_poll_template")
public class ZTPollTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String pollTemplateId;
	private String pollTemplateName;
	private String createUserId;
	private Timestamp createTime;
	private String description;
	private Integer status;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTPollTemplate() {
	}

	/** full constructor */
	public ZTPollTemplate(String pollTemplateName, String createUserId,
			Timestamp createTime, String description, Integer status,
			Timestamp dbmsTime) {
		this.pollTemplateName = pollTemplateName;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.description = description;
		this.status = status;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pollTemplateID", unique = true, nullable = false, length = 50)
	public String getPollTemplateId() {
		return this.pollTemplateId;
	}

	public void setPollTemplateId(String pollTemplateId) {
		this.pollTemplateId = pollTemplateId;
	}

	@Column(name = "pollTemplateName", length = 50)
	public String getPollTemplateName() {
		return this.pollTemplateName;
	}

	public void setPollTemplateName(String pollTemplateName) {
		this.pollTemplateName = pollTemplateName;
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

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}