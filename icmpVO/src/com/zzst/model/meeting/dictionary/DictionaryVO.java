package com.zzst.model.meeting.dictionary;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: Dictionary Object
 * 
 * @date Tue Feb 19 17:00:51 CST 2013
 * @author ryan
 */
public class DictionaryVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dicID;
	private String dicType;
	private String dicViewName;
	private String dicValue;
	private int sysValue = Integer.MIN_VALUE;
	private String createUserID;
	private Timestamp createTime;
	private String description;

	public void setDicID(String dicID) {
		this.dicID = dicID;
	}

	public String getDicID() {
		return dicID;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getDicType() {
		return dicType;
	}

	public void setDicViewName(String dicViewName) {
		this.dicViewName = dicViewName;
	}

	public String getDicViewName() {
		return dicViewName;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setSysValue(int sysValue) {
		this.sysValue = sysValue;
	}

	public int getSysValue() {
		return sysValue;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	public String getCreateUserID() {
		return createUserID;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
