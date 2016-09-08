package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTPollTerminal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_poll_terminal")
public class ZTPollTerminal implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pollTerminalId;
	private String pollTemplateId;
	private String equipmentId;
	private String createUserId;
	private Timestamp createTime;
	private Integer orderNum;
	private String description;
	private Integer orgType;
	private Integer status;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTPollTerminal() {
	}

	/** full constructor */
	public ZTPollTerminal(String pollTemplateId, String equipmentId,
			String createUserId, Timestamp createTime, Integer orderNum,
			String description, Integer orgType, Integer status,
			Timestamp dbmsTime) {
		this.pollTemplateId = pollTemplateId;
		this.equipmentId = equipmentId;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.orderNum = orderNum;
		this.description = description;
		this.orgType = orgType;
		this.status = status;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pollTerminalID", unique = true, nullable = false, length = 50)
	public String getPollTerminalId() {
		return this.pollTerminalId;
	}

	public void setPollTerminalId(String pollTerminalId) {
		this.pollTerminalId = pollTerminalId;
	}

	@Column(name = "pollTemplateID", length = 50)
	public String getPollTemplateId() {
		return this.pollTemplateId;
	}

	public void setPollTemplateId(String pollTemplateId) {
		this.pollTemplateId = pollTemplateId;
	}

	@Column(name = "equipmentID", length = 50)
	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
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

	@Column(name = "orderNum")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "orgType")
	public Integer getOrgType() {
		return this.orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
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