package com.zzst.icmp.entity;

import java.util.Date;

/**
 * ZTMeetingroomEquipment generated by MyEclipse Persistence Tools
 */

public class ZTMeetingroomEquipment implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;

	private ZTMeetingroomEquipmentId id;

	private String description;

	private String revision;

	private Date dbmsTime;

	// Constructors

	/** default constructor */
	public ZTMeetingroomEquipment() {
	}

	/** minimal constructor */
	public ZTMeetingroomEquipment(ZTMeetingroomEquipmentId id) {
		this.id = id;
	}

	/** full constructor */
	public ZTMeetingroomEquipment(ZTMeetingroomEquipmentId id,
			String description, String revision, Date dbmsTime) {
		this.id = id;
		this.description = description;
		this.revision = revision;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors

	public ZTMeetingroomEquipmentId getId() {
		return this.id;
	}

	public void setId(ZTMeetingroomEquipmentId id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRevision() {
		return this.revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Date getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Date dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}