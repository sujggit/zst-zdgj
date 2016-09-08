package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentMcu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_mcu")
public class ZTEquipmentMcu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	private String parentId;
	private String loginName;
	private String loginPassword;
	private String commandIp;
	private String description;
	private Long revision;
	private String dialingType;
	private String dialingDirection;
	private String aliasName;
	private String aliasType;
	private String maxPesolution;
	private String cascadeRole;
	private String agc;
	private String ptsNumber;
	private Integer allResourceNumber;
	private Integer useResourceNumber;
	private String videoTreaty;
	private String radioTreaty;
	private String speed;
	private Integer isCheck;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentMcu() {
	}

	/** full constructor */
	public ZTEquipmentMcu(String parentId, String loginName,
			String loginPassword, String commandIp, String description,
			Long revision, String dialingType, String dialingDirection,
			String aliasName, String aliasType, String maxPesolution,
			String cascadeRole, String agc, String ptsNumber,
			Integer allResourceNumber, Integer useResourceNumber,
			String videoTreaty, String radioTreaty, String speed,
			Integer isCheck, Timestamp dbmsTime) {
		this.parentId = parentId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.commandIp = commandIp;
		this.description = description;
		this.revision = revision;
		this.dialingType = dialingType;
		this.dialingDirection = dialingDirection;
		this.aliasName = aliasName;
		this.aliasType = aliasType;
		this.maxPesolution = maxPesolution;
		this.cascadeRole = cascadeRole;
		this.agc = agc;
		this.ptsNumber = ptsNumber;
		this.allResourceNumber = allResourceNumber;
		this.useResourceNumber = useResourceNumber;
		this.videoTreaty = videoTreaty;
		this.radioTreaty = radioTreaty;
		this.speed = speed;
		this.isCheck = isCheck;
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

	@Column(name = "parentID", length = 50)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "loginName", length = 50)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "loginPassword", length = 50)
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Column(name = "commandIP", length = 50)
	public String getCommandIp() {
		return this.commandIp;
	}

	public void setCommandIp(String commandIp) {
		this.commandIp = commandIp;
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

	@Column(name = "dialingType", length = 50)
	public String getDialingType() {
		return this.dialingType;
	}

	public void setDialingType(String dialingType) {
		this.dialingType = dialingType;
	}

	@Column(name = "dialingDirection", length = 50)
	public String getDialingDirection() {
		return this.dialingDirection;
	}

	public void setDialingDirection(String dialingDirection) {
		this.dialingDirection = dialingDirection;
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

	@Column(name = "maxPesolution", length = 50)
	public String getMaxPesolution() {
		return this.maxPesolution;
	}

	public void setMaxPesolution(String maxPesolution) {
		this.maxPesolution = maxPesolution;
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

	@Column(name = "ptsNumber", length = 50)
	public String getPtsNumber() {
		return this.ptsNumber;
	}

	public void setPtsNumber(String ptsNumber) {
		this.ptsNumber = ptsNumber;
	}

	@Column(name = "allResourceNumber")
	public Integer getAllResourceNumber() {
		return this.allResourceNumber;
	}

	public void setAllResourceNumber(Integer allResourceNumber) {
		this.allResourceNumber = allResourceNumber;
	}

	@Column(name = "useResourceNumber")
	public Integer getUseResourceNumber() {
		return this.useResourceNumber;
	}

	public void setUseResourceNumber(Integer useResourceNumber) {
		this.useResourceNumber = useResourceNumber;
	}

	@Column(name = "videoTreaty", length = 50)
	public String getVideoTreaty() {
		return this.videoTreaty;
	}

	public void setVideoTreaty(String videoTreaty) {
		this.videoTreaty = videoTreaty;
	}

	@Column(name = "radioTreaty", length = 50)
	public String getRadioTreaty() {
		return this.radioTreaty;
	}

	public void setRadioTreaty(String radioTreaty) {
		this.radioTreaty = radioTreaty;
	}

	@Column(name = "speed", length = 50)
	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@Column(name = "isCheck")
	public Integer getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}