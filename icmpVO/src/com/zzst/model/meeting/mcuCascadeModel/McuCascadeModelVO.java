package com.zzst.model.meeting.mcuCascadeModel;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: McuCascadeModel Object
 * @date Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public class McuCascadeModelVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String CascadeID;
	private String cascadeName;
	private String mcuName;
	private String mcuIp;
	private String modelID;
	private String modelName;
	private String createUserID;
	private Timestamp createDate;
	private int status = Integer.MIN_VALUE;
	private String description;
	private String confModel;
	///////////////////////
	private String equipmentNO;
	
	public void setCascadeID(String CascadeID) {
		this.CascadeID = CascadeID;
	}

	public String getCascadeID() {
		return CascadeID;
	}

	public void setCascadeName(String cascadeName) {
		this.cascadeName = cascadeName;
	}

	public String getCascadeName() {
		return cascadeName;
	}

	public void setMcuName(String mcuName) {
		this.mcuName = mcuName;
	}

	public String getMcuName() {
		return mcuName;
	}

	public void setMcuIp(String mcuIp) {
		this.mcuIp = mcuIp;
	}

	public String getMcuIp() {
		return mcuIp;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
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

	public String getConfModel() {
		return confModel;
	}

	public void setConfModel(String confModel) {
		this.confModel = confModel;
	}

	public String getEquipmentNO() {
		return equipmentNO;
	}

	public void setEquipmentNO(String equipmentNO) {
		this.equipmentNO = equipmentNO;
	}
	
	

}
