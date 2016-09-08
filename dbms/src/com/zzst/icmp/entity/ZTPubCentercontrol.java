package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTPubCentercontrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_pub_centercontrol")
public class ZTPubCentercontrol implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String equipmentIp;
	private String command;
	private String ccIp;
	private String equipmentType;
	private String euipmentName;
	private String ccNo;
	private String controlInitDate;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTPubCentercontrol() {
	}

	/** full constructor */
	public ZTPubCentercontrol(String equipmentIp, String command, String ccIp,
			String equipmentType, String euipmentName, String ccNo,
			String controlInitDate, Timestamp dbmsTime) {
		this.equipmentIp = equipmentIp;
		this.command = command;
		this.ccIp = ccIp;
		this.equipmentType = equipmentType;
		this.euipmentName = euipmentName;
		this.ccNo = ccNo;
		this.controlInitDate = controlInitDate;
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

	@Column(name = "equipmentIP", length = 50)
	public String getEquipmentIp() {
		return this.equipmentIp;
	}

	public void setEquipmentIp(String equipmentIp) {
		this.equipmentIp = equipmentIp;
	}

	@Column(name = "command", length = 100)
	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Column(name = "ccIP", length = 50)
	public String getCcIp() {
		return this.ccIp;
	}

	public void setCcIp(String ccIp) {
		this.ccIp = ccIp;
	}

	@Column(name = "equipmentType", length = 50)
	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Column(name = "euipmentName", length = 100)
	public String getEuipmentName() {
		return this.euipmentName;
	}

	public void setEuipmentName(String euipmentName) {
		this.euipmentName = euipmentName;
	}

	@Column(name = "ccNO", length = 50)
	public String getCcNo() {
		return this.ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	@Column(name = "controlInitDate", length = 1000)
	public String getControlInitDate() {
		return this.controlInitDate;
	}

	public void setControlInitDate(String controlInitDate) {
		this.controlInitDate = controlInitDate;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}