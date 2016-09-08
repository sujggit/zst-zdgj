package com.zzst.model.meeting.config;

import java.io.Serializable;

/**
 * class description: BaseInfo Object
 * 
 * @date Fri Jun 15 10:26:01 CST 2012
 * @author ryan
 */
public class BaseInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String infoType;
	private String infoName;
	private String infoValue;
	private String description;
	private String order;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoValue(String infoValue) {
		this.infoValue = infoValue;
	}

	public String getInfoValue() {
		return infoValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrder() {
		return order;
	}

}
