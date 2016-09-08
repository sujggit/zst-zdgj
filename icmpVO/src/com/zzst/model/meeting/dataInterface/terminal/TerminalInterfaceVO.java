package com.zzst.model.meeting.dataInterface.terminal;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: TerminalInterface Object
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public class TerminalInterfaceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String equipmentID;
	private String equipmentModel;
	private String equipmentNO;
	private int equipmentStatus = Integer.MIN_VALUE;
	private String mac;
	private String ip;
	private int port = Integer.MIN_VALUE;
	private String roomName;
	private String adminName;
	private String mcuIp;
	private String description;
	private String serialNumber;
	private String equipmentIdentifier;
	private Timestamp maintainceStartTime;
	private int maintainMonth = Integer.MIN_VALUE;
	private int status = Integer.MIN_VALUE;
	
	
	/////////////
	private int sqlType;
	private String adminID;//管理员ID
	private String roomID;//所属会议室ID
	private String mcuID;//所属MCUID

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentNO(String equipmentNO) {
		this.equipmentNO = equipmentNO;
	}

	public String getEquipmentNO() {
		return equipmentNO;
	}

	public void setEquipmentStatus(int equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public int getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setMcuIp(String mcuIp) {
		this.mcuIp = mcuIp;
	}

	public String getMcuIp() {
		return mcuIp;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setEquipmentIdentifier(String equipmentIdentifier) {
		this.equipmentIdentifier = equipmentIdentifier;
	}

	public String getEquipmentIdentifier() {
		return equipmentIdentifier;
	}

	public void setMaintainceStartTime(Timestamp maintainceStartTime) {
		this.maintainceStartTime = maintainceStartTime;
	}

	public Timestamp getMaintainceStartTime() {
		return maintainceStartTime;
	}

	public void setMaintainMonth(int maintainMonth) {
		this.maintainMonth = maintainMonth;
	}

	public int getMaintainMonth() {
		return maintainMonth;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public int getSqlType() {
		return sqlType;
	}

	public void setSqlType(int sqlType) {
		this.sqlType = sqlType;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getMcuID() {
		return mcuID;
	}

	public void setMcuID(String mcuID) {
		this.mcuID = mcuID;
	}
	
	

}
