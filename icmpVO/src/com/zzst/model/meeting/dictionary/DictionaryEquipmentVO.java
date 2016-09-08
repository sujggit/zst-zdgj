package com.zzst.model.meeting.dictionary;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: DictionaryEquipment Object
 * 
 * @date Tue Jan 14 10:15:59 CST 2014
 * @author ryan
 */
public class DictionaryEquipmentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dicID;
	private String dicName;
	private String parentID;
	private Timestamp updateTime;
	private String updateUser;
	private String description;
	private int dicValue = Integer.MIN_VALUE;
	private int sysValue = Integer.MIN_VALUE;
	public int getDicValue() {
		return dicValue;
	}

	public void setDicValue(int dicValue) {
		this.dicValue = dicValue;
	}

	public int getSysValue() {
		return sysValue;
	}

	public void setSysValue(int sysValue) {
		this.sysValue = sysValue;
	}

	private int status = Integer.MIN_VALUE;

	public void setDicID(String dicID) {
		this.dicID = dicID;
	}

	public String getDicID() {
		return dicID;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicName() {
		return dicName;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
