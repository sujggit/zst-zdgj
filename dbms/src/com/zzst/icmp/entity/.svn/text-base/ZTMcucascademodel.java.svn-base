package com.zzst.icmp.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTMcucascademodel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_mcucascademodel")
public class ZTMcucascademodel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cascadeId;
	private String cascadeName;
	private String mcuName;
	private String mcuIp;
	private String modelId;
	private String modelName;
	private String createUserId;
	private Date createDate;
	private String status;
	private String description;
	private String confModel;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTMcucascademodel() {
	}

	/** full constructor */
	public ZTMcucascademodel(String cascadeName, String mcuName, String mcuIp,
			String modelId, String modelName, String createUserId,
			Date createDate, String status, String description,
			String confModel, Timestamp dbmsTime) {
		this.cascadeName = cascadeName;
		this.mcuName = mcuName;
		this.mcuIp = mcuIp;
		this.modelId = modelId;
		this.modelName = modelName;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.status = status;
		this.description = description;
		this.confModel = confModel;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CascadeID", unique = true, nullable = false, length = 50)
	public String getCascadeId() {
		return this.cascadeId;
	}

	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}

	@Column(name = "cascadeName", length = 4000)
	public String getCascadeName() {
		return this.cascadeName;
	}

	public void setCascadeName(String cascadeName) {
		this.cascadeName = cascadeName;
	}

	@Column(name = "mcuName", length = 4000)
	public String getMcuName() {
		return this.mcuName;
	}

	public void setMcuName(String mcuName) {
		this.mcuName = mcuName;
	}

	@Column(name = "mcuIp", length = 4000)
	public String getMcuIp() {
		return this.mcuIp;
	}

	public void setMcuIp(String mcuIp) {
		this.mcuIp = mcuIp;
	}

	@Column(name = "modelID", length = 2000)
	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Column(name = "modelName", length = 4000)
	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Column(name = "createUserID", length = 50)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createDate", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "confModel", length = 20)
	public String getConfModel() {
		return this.confModel;
	}

	public void setConfModel(String confModel) {
		this.confModel = confModel;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}