package com.zzst.model.meeting.equipment.maintain;

import java.io.Serializable;
import java.sql.Timestamp;


import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: EquipmentMaintain Object
 * 
 * @date Mon May 06 13:27:29 CST 2013
 * @author ryan
 */
public class EquipmentMaintainVO implements Serializable {

	private static final long serialVersionUID = 1L;
   
	private String maintainID;
	private String equipmentID;
	private String roomID;
	private int status = Integer.MIN_VALUE;
	private String updateUserID;
	private Timestamp updateTime;
	private int maintainCost = Integer.MIN_VALUE;
	private String description;
	private long revision = Long.MIN_VALUE;
	
	private EquipmentVO equipmentVO = new EquipmentVO();
	private int sumCost = Integer.MIN_VALUE;//维修总共成本
	private int maintainTime = Integer.MIN_VALUE;;//维修次数
	
	private Timestamp updateStartTime;//起始时间
	private Timestamp updateEndTime;//结束时间
	private String sqls;
	//会议室分级分权
	private boolean isLevel;
	private String lsql;
	

	public boolean isLevel() {
		return isLevel;
	}

	public void setLevel(boolean isLevel) {
		this.isLevel = isLevel;
	}

	public String getLsql() {
		return lsql;
	}

	public void setLsql(String lsql) {
		this.lsql = lsql;
	}

	public void setMaintainID(String maintainID) {
		this.maintainID = maintainID;
	}

	public String getMaintainID() {
		return maintainID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setUpdateUserID(String updateUserID) {
		this.updateUserID = updateUserID;
	}

	public String getUpdateUserID() {
		return updateUserID;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setMaintainCost(int maintainCost) {
		this.maintainCost = maintainCost;
	}

	public int getMaintainCost() {
		return maintainCost;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public int getSumCost() {
		return sumCost;
	}

	public void setSumCost(int sumCost) {
		this.sumCost = sumCost;
	}

	public int getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(int maintainTime) {
		this.maintainTime = maintainTime;
	}

	public void setSqls(String sqls) {
		this.sqls = sqls;
	}

	public String getSqls() {
		return sqls;
	}

	public Timestamp getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Timestamp updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public Timestamp getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(Timestamp updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	
	
}
