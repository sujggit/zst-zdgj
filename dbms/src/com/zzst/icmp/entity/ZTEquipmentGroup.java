package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_group")
public class ZTEquipmentGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String groupname;
	private String equipmentId;
	private Integer status;
	private String description;
	private String rank;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentGroup() {
	}

	/** minimal constructor */
	public ZTEquipmentGroup(String groupname, String equipmentId, Integer status) {
		this.groupname = groupname;
		this.equipmentId = equipmentId;
		this.status = status;
	}

	/** full constructor */
	public ZTEquipmentGroup(String groupname, String equipmentId,
			Integer status, String description, String rank, Timestamp dbmsTime) {
		this.groupname = groupname;
		this.equipmentId = equipmentId;
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

	@Column(name = "groupname", nullable = false, length = 50)
	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Column(name = "equipmentID", nullable = false, length = 50)
	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	@Column(name = "status", nullable = false)
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

	@Column(name = "rank", length = 50)
	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
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