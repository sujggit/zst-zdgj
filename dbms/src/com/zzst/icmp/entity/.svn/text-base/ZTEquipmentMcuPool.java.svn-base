package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentMcuPool entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_mcu_pool")
public class ZTEquipmentMcuPool implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	private Integer resourceNum;
	private Integer weight;
	private Integer useNum;
	private Integer status;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentMcuPool() {
	}

	/** full constructor */
	public ZTEquipmentMcuPool(Integer resourceNum, Integer weight,
			Integer useNum, Integer status, Timestamp dbmsTime) {
		this.resourceNum = resourceNum;
		this.weight = weight;
		this.useNum = useNum;
		this.status = status;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "equipmentID", unique = true, nullable = false, length = 50)
	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	@Column(name = "resourceNum")
	public Integer getResourceNum() {
		return this.resourceNum;
	}

	public void setResourceNum(Integer resourceNum) {
		this.resourceNum = resourceNum;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "useNum")
	public Integer getUseNum() {
		return this.useNum;
	}

	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
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