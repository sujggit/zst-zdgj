package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTTemplateEquipmentGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_template_equipment_group")
public class ZTTemplateEquipmentGroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	private String name;
	private Integer status;
	private String description;
	private Timestamp dbmsTime;
	private String levelid;
	// Constructors

	/** default constructor */
	public ZTTemplateEquipmentGroup() {
	}

	/** full constructor */
	public ZTTemplateEquipmentGroup(String name, Integer status,
			String description, Timestamp dbmsTime ,String levelid) {
		this.name = name;
		this.status = status;
		this.description = description;
		this.dbmsTime = dbmsTime;
		this.levelid = levelid;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	@Column(name = "levelid", length = 50)
	public String getLevelid() {
		return this.levelid;
	}

	public void setLevelid(String levelid) {
		this.levelid = levelid;
	}

}