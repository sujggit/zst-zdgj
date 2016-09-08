package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentDictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_dictionary")
public class ZTEquipmentDictionary implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String dicId;
	private String dicName;
	private Integer dicValue;
	private String parentId;
	private Integer status;
	private Integer sysValue;
	private Timestamp updateTime;
	private String updateUser;
	private String description;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentDictionary() {
	}

	/** full constructor */
	public ZTEquipmentDictionary(String dicName, Integer dicValue,
			String parentId, Integer status, Integer sysValue,
			Timestamp updateTime, String updateUser, String description,
			Timestamp dbmsTime) {
		this.dicName = dicName;
		this.dicValue = dicValue;
		this.parentId = parentId;
		this.status = status;
		this.sysValue = sysValue;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
		this.description = description;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "dicID", unique = true, nullable = false, length = 50)
	public String getDicId() {
		return this.dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	@Column(name = "dicName", length = 50)
	public String getDicName() {
		return this.dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	@Column(name = "dicValue")
	public Integer getDicValue() {
		return this.dicValue;
	}

	public void setDicValue(Integer dicValue) {
		this.dicValue = dicValue;
	}

	@Column(name = "parentID", length = 50)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "sysValue")
	public Integer getSysValue() {
		return this.sysValue;
	}

	public void setSysValue(Integer sysValue) {
		this.sysValue = sysValue;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "updateUser", length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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