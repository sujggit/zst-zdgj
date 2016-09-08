package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTTemplateEquipment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_template_equipment")
public class ZTTemplateEquipment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	private String groupId;
	private String equipmentName;
	private String equipmentIp;
	private String pinterface;
	private String aliasName;
	private String aliasType;
	private String ptsNumber;
	private String lineRate;
	private String maxResolution;
	private String videoProtocol;
	private String cascadeRole;
	private String agc;
	private String callDirection;
	private Integer isMain;
	private String description;
	private String meetingRoomId;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTTemplateEquipment() {
	}

	/** full constructor */
	public ZTTemplateEquipment(String groupId, String equipmentName,
			String equipmentIp, String pinterface, String aliasName,
			String aliasType, String ptsNumber, String lineRate,
			String maxResolution, String videoProtocol, String cascadeRole,
			String agc, String callDirection, Integer isMain,
			String description, String meetingRoomId, Timestamp dbmsTime) {
		this.groupId = groupId;
		this.equipmentName = equipmentName;
		this.equipmentIp = equipmentIp;
		this.pinterface = pinterface;
		this.aliasName = aliasName;
		this.aliasType = aliasType;
		this.ptsNumber = ptsNumber;
		this.lineRate = lineRate;
		this.maxResolution = maxResolution;
		this.videoProtocol = videoProtocol;
		this.cascadeRole = cascadeRole;
		this.agc = agc;
		this.callDirection = callDirection;
		this.isMain = isMain;
		this.description = description;
		this.meetingRoomId = meetingRoomId;
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

	@Column(name = "groupId", length = 1000)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "equipmentName", length = 50)
	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "equipmentIp", length = 15)
	public String getEquipmentIp() {
		return this.equipmentIp;
	}

	public void setEquipmentIp(String equipmentIp) {
		this.equipmentIp = equipmentIp;
	}

	@Column(name = "pInterface", length = 50)
	public String getPinterface() {
		return this.pinterface;
	}

	public void setPinterface(String pinterface) {
		this.pinterface = pinterface;
	}

	@Column(name = "aliasName", length = 50)
	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@Column(name = "aliasType", length = 50)
	public String getAliasType() {
		return this.aliasType;
	}

	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}

	@Column(name = "ptsNumber", length = 50)
	public String getPtsNumber() {
		return this.ptsNumber;
	}

	public void setPtsNumber(String ptsNumber) {
		this.ptsNumber = ptsNumber;
	}

	@Column(name = "lineRate", length = 50)
	public String getLineRate() {
		return this.lineRate;
	}

	public void setLineRate(String lineRate) {
		this.lineRate = lineRate;
	}

	@Column(name = "maxResolution", length = 50)
	public String getMaxResolution() {
		return this.maxResolution;
	}

	public void setMaxResolution(String maxResolution) {
		this.maxResolution = maxResolution;
	}

	@Column(name = "videoProtocol", length = 50)
	public String getVideoProtocol() {
		return this.videoProtocol;
	}

	public void setVideoProtocol(String videoProtocol) {
		this.videoProtocol = videoProtocol;
	}

	@Column(name = "cascadeRole", length = 50)
	public String getCascadeRole() {
		return this.cascadeRole;
	}

	public void setCascadeRole(String cascadeRole) {
		this.cascadeRole = cascadeRole;
	}

	@Column(name = "agc", length = 50)
	public String getAgc() {
		return this.agc;
	}

	public void setAgc(String agc) {
		this.agc = agc;
	}

	@Column(name = "callDirection", length = 50)
	public String getCallDirection() {
		return this.callDirection;
	}

	public void setCallDirection(String callDirection) {
		this.callDirection = callDirection;
	}

	@Column(name = "isMain")
	public Integer getIsMain() {
		return this.isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "meetingRoomID", length = 50)
	public String getMeetingRoomId() {
		return this.meetingRoomId;
	}

	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}