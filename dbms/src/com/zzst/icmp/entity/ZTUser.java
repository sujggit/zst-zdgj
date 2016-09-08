package com.zzst.icmp.entity;

import java.util.Date;

/**
 * ZTUser generated by MyEclipse Persistence Tools
 */

public class ZTUser implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;

	private String userId;

	private String loginName;

	private String password;

	private String fullName;

	private String nameSpelling;

	private String email;

	private String title;

	private String mobile;

	private String tel;

	private Date lastLoginTime;

	private Integer status;

	private String description;

	private Long revision;

	private Integer authenticateType;

	private Date changePwdTime;

	private Integer errorTimes;

	private String addressId;

	private Date dbmsTime;

	private String hostip;

	// Constructors

	/** default constructor */
	public ZTUser() {
	}

	/** full constructor */
	public ZTUser(String loginName, String password, String fullName,
			String nameSpelling, String email, String title, String mobile,
			String tel, Date lastLoginTime, Integer status, String description,
			Long revision, Integer authenticateType, Date changePwdTime,
			Integer errorTimes, String addressId, Date dbmsTime, String hostip) {
		this.loginName = loginName;
		this.password = password;
		this.fullName = fullName;
		this.nameSpelling = nameSpelling;
		this.email = email;
		this.title = title;
		this.mobile = mobile;
		this.tel = tel;
		this.lastLoginTime = lastLoginTime;
		this.status = status;
		this.description = description;
		this.revision = revision;
		this.authenticateType = authenticateType;
		this.changePwdTime = changePwdTime;
		this.errorTimes = errorTimes;
		this.addressId = addressId;
		this.dbmsTime = dbmsTime;
		this.hostip = hostip;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNameSpelling() {
		return this.nameSpelling;
	}

	public void setNameSpelling(String nameSpelling) {
		this.nameSpelling = nameSpelling;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRevision() {
		return this.revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Integer getAuthenticateType() {
		return this.authenticateType;
	}

	public void setAuthenticateType(Integer authenticateType) {
		this.authenticateType = authenticateType;
	}

	public Date getChangePwdTime() {
		return this.changePwdTime;
	}

	public void setChangePwdTime(Date changePwdTime) {
		this.changePwdTime = changePwdTime;
	}

	public Integer getErrorTimes() {
		return this.errorTimes;
	}

	public void setErrorTimes(Integer errorTimes) {
		this.errorTimes = errorTimes;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Date getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Date dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

	public String getHostip() {
		return this.hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

}