package com.zzst.model.meeting.equipment;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: EquipmentBackup Object
 * 
 * @date Tue Jan 22 19:50:35 CST 2013
 * @author wangle
 */
public class EquipmentBackupVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String equipmentID;
	private String equipmentName;
	private String backupEquipmentID;
	private String backupEquipmentName;
	private String createUserID;
	private Timestamp createDate;
	private int backupLevel = Integer.MIN_VALUE;
	private int employ = Integer.MIN_VALUE;
	private int status = Integer.MIN_VALUE;
	private String description;
	private int equipmentType;
	private String  ip;
	private String backupip;

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	public String getCreateUserID() {
		return createUserID;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setBackupLevel(int backupLevel) {
		this.backupLevel = backupLevel;
	}

	public int getBackupLevel() {
		return backupLevel;
	}

	public void setEmploy(int employ) {
		this.employ = employ;
	}

	public int getEmploy() {
		return employ;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getBackupEquipmentID() {
		return backupEquipmentID;
	}

	public void setBackupEquipmentID(String backupEquipmentID) {
		this.backupEquipmentID = backupEquipmentID;
	}

	public String getBackupEquipmentName() {
		return backupEquipmentName;
	}

	public void setBackupEquipmentName(String backupEquipmentName) {
		this.backupEquipmentName = backupEquipmentName;
	}

	public int getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(int equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBackupip() {
		return backupip;
	}

	public void setBackupip(String backupip) {
		this.backupip = backupip;
	}
  
}
