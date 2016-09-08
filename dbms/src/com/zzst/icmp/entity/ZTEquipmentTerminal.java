package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTEquipmentTerminal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_equipment_terminal")
public class ZTEquipmentTerminal implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String equipmentId;
	private String loginName;
	private String loginPassword;
	private Timestamp createTime;
	private String pstn;
	private String speed;
	private String videoTreaty;
	private String radioTreaty;
	private String equipmentMcuid;
	private String description;
	private Long revision;
	private String dialingType;
	private String dialingDirection;
	private String aliasName;
	private String aliasType;
	private String maxPesolution;
	private String cascadeRole;
	private String agc;
	private Integer isCheck;
	private String ptsNumber;
	private String mcuResourse;
	private String useRole;
	private String controlParameter;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTEquipmentTerminal() {
	}

	/** full constructor */
	public ZTEquipmentTerminal(String loginName, String loginPassword,
			Timestamp createTime, String pstn, String speed,
			String videoTreaty, String radioTreaty, String equipmentMcuid,
			String description, Long revision, String dialingType,
			String dialingDirection, String aliasName, String aliasType,
			String maxPesolution, String cascadeRole, String agc,
			Integer isCheck, String ptsNumber, String mcuResourse,
			String useRole, String controlParameter, Timestamp dbmsTime) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.createTime = createTime;
		this.pstn = pstn;
		this.speed = speed;
		this.videoTreaty = videoTreaty;
		this.radioTreaty = radioTreaty;
		this.equipmentMcuid = equipmentMcuid;
		this.description = description;
		this.revision = revision;
		this.dialingType = dialingType;
		this.dialingDirection = dialingDirection;
		this.aliasName = aliasName;
		this.aliasType = aliasType;
		this.maxPesolution = maxPesolution;
		this.cascadeRole = cascadeRole;
		this.agc = agc;
		this.isCheck = isCheck;
		this.ptsNumber = ptsNumber;
		this.mcuResourse = mcuResourse;
		this.useRole = useRole;
		this.controlParameter = controlParameter;
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

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "pstn", length = 50)
	public String getPstn() {
		return this.pstn;
	}

	public void setPstn(String pstn) {
		this.pstn = pstn;
	}

	@Column(name = "speed", length = 50)
	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
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

	@Column(name = "equipmentMCUID", length = 50)
	public String getEquipmentMcuid() {
		return this.equipmentMcuid;
	}

	public void setEquipmentMcuid(String equipmentMcuid) {
		this.equipmentMcuid = equipmentMcuid;
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

	@Column(name = "isCheck")
	public Integer getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

	@Column(name = "ptsNumber", length = 50)
	public String getPtsNumber() {
		return this.ptsNumber;
	}

	public void setPtsNumber(String ptsNumber) {
		this.ptsNumber = ptsNumber;
	}

	@Column(name = "mcuResourse", length = 50)
	public String getMcuResourse() {
		return this.mcuResourse;
	}

	public void setMcuResourse(String mcuResourse) {
		this.mcuResourse = mcuResourse;
	}

	@Column(name = "useRole", length = 50)
	public String getUseRole() {
		return this.useRole;
	}

	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}

	@Column(name = "controlParameter", length = 1000)
	public String getControlParameter() {
		return this.controlParameter;
	}

	public void setControlParameter(String controlParameter) {
		this.controlParameter = controlParameter;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}