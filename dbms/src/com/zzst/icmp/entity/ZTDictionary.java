package com.zzst.icmp.entity;

import java.util.Date;

/**
 * ZTDictionary generated by MyEclipse Persistence Tools
 */

public class ZTDictionary implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;

	private String dicId;

	private String dicType;

	private String dicViewName;

	private String dicValue;

	private Integer sysValue;

	private String createUserId;

	private Date createTime;

	private String description;

	private Date dbmsTime;

	// Constructors

	/** default constructor */
	public ZTDictionary() {
	}

	/** full constructor */
	public ZTDictionary(String dicType, String dicViewName, String dicValue,
			Integer sysValue, String createUserId, Date createTime,
			String description, Date dbmsTime) {
		this.dicType = dicType;
		this.dicViewName = dicViewName;
		this.dicValue = dicValue;
		this.sysValue = sysValue;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.description = description;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors

	public String getDicId() {
		return this.dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public String getDicType() {
		return this.dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getDicViewName() {
		return this.dicViewName;
	}

	public void setDicViewName(String dicViewName) {
		this.dicViewName = dicViewName;
	}

	public String getDicValue() {
		return this.dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public Integer getSysValue() {
		return this.sysValue;
	}

	public void setSysValue(Integer sysValue) {
		this.sysValue = sysValue;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Date dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}