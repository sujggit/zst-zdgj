package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment")
public class ZTEquipment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	private Integer equipmentType;
	private String equipmentName;
	private String equipmentModel;
	private String equipmentNo;
	private Integer status;
	private String mac;
	private String ip;
	private Integer port;
	private String roomId;
	private String adminId;
	private Timestamp createDate;
	private String description;
	private Long revision;
	private String serialNumber;
	private String equipmentIdentifier;
	private Timestamp maintenanceStartTime;
	private Timestamp maintenanceEndTime;
	private String levelIp;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipment() {
	}

	/** full constructor */
	public ZTEquipment(Integer equipmentType, String equipmentName,
			String equipmentModel, String equipmentNo, Integer status,
			String mac, String ip, Integer port, String roomId, String adminId,
			Timestamp createDate, String description, Long revision,
			String serialNumber, String equipmentIdentifier,
			Timestamp maintenanceStartTime, Timestamp maintenanceEndTime,
			String levelIp, Timestamp dbmsTime) {
		this.equipmentType = equipmentType;
		this.equipmentName = equipmentName;
		this.equipmentModel = equipmentModel;
		this.equipmentNo = equipmentNo;
		this.status = status;
		this.mac = mac;
		this.ip = ip;
		this.port = port;
		this.roomId = roomId;
		this.adminId = adminId;
		this.createDate = createDate;
		this.description = description;
		this.revision = revision;
		this.serialNumber = serialNumber;
		this.equipmentIdentifier = equipmentIdentifier;
		this.maintenanceStartTime = maintenanceStartTime;
		this.maintenanceEndTime = maintenanceEndTime;
		this.levelIp = levelIp;
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

	@Column(name = "equipmentType")
	public Integer getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Column(name = "equipmentName", length = 50)
	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "equipmentModel", length = 50)
	public String getEquipmentModel() {
		return this.equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	@Column(name = "equipmentNO", length = 50)
	public String getEquipmentNo() {
		return this.equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "mac", length = 50)
	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Column(name = "ip", length = 50)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "port")
	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Column(name = "roomID", length = 4000)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "adminID", length = 50)
	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

	@Column(name = "serialNumber", length = 50)
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "equipmentIdentifier", length = 50)
	public String getEquipmentIdentifier() {
		return this.equipmentIdentifier;
	}

	public void setEquipmentIdentifier(String equipmentIdentifier) {
		this.equipmentIdentifier = equipmentIdentifier;
	}

	@Column(name = "maintenanceStartTime", length = 19)
	public Timestamp getMaintenanceStartTime() {
		return this.maintenanceStartTime;
	}

	public void setMaintenanceStartTime(Timestamp maintenanceStartTime) {
		this.maintenanceStartTime = maintenanceStartTime;
	}

	@Column(name = "maintenanceEndTime", length = 19)
	public Timestamp getMaintenanceEndTime() {
		return this.maintenanceEndTime;
	}

	public void setMaintenanceEndTime(Timestamp maintenanceEndTime) {
		this.maintenanceEndTime = maintenanceEndTime;
	}

	@Column(name = "levelIP", length = 50)
	public String getLevelIp() {
		return this.levelIp;
	}

	public void setLevelIp(String levelIp) {
		this.levelIp = levelIp;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}