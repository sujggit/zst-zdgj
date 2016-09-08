package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentMaintain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_maintain")
public class ZTEquipmentMaintain implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maintainId;
	private String equipmentId;
	private String roomId;
	private String updateUserId;
	private Timestamp updateTime;
	private Integer maintainCost;
	private String description;
	private Long revision;
	private Integer status;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentMaintain() {
	}

	/** full constructor */
	public ZTEquipmentMaintain(String equipmentId, String roomId,
			String updateUserId, Timestamp updateTime, Integer maintainCost,
			String description, Long revision, Integer status,
			Timestamp dbmsTime) {
		this.equipmentId = equipmentId;
		this.roomId = roomId;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
		this.maintainCost = maintainCost;
		this.description = description;
		this.revision = revision;
		this.status = status;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "maintainID", unique = true, nullable = false, length = 50)
	public String getMaintainId() {
		return this.maintainId;
	}

	public void setMaintainId(String maintainId) {
		this.maintainId = maintainId;
	}

	@Column(name = "equipmentID", length = 50)
	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	@Column(name = "roomID", length = 50)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "updateUserID", length = 50)
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "maintainCost")
	public Integer getMaintainCost() {
		return this.maintainCost;
	}

	public void setMaintainCost(Integer maintainCost) {
		this.maintainCost = maintainCost;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "revision")
	public Long getRevision() {
		return this.revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
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