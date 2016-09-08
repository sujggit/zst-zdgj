package com.zzst.model.meeting.equipment;

import java.io.Serializable;

/**
 * class description: EquipmentGroup Object
 * 
 * @date Thu Apr 24 11:13:16 CST 2014
 * @author ryan
 */
public class EquipmentGroupVO implements Serializable {

	public final static int STATUS_INVALID = 0;//无效
	public final static int STATUS_VALID   = 1;//有效
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String groupname;
	private String equipmentID;
	private int status = Integer.MIN_VALUE;
	private String description;
	private String rank;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentID() {
		return equipmentID;
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

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRank() {
		return rank;
	}

}
