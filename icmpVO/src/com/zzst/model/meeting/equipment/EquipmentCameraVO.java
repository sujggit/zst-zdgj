package com.zzst.model.meeting.equipment;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: EquipmentCamera Object
 * 
 * @date Fri Jun 21 16:34:00 CST 2013
 * @author ryan
 */
public class EquipmentCameraVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String templateID;
	private String ccIP;
	private String cameraId;
	private String templateName;
	private String backlight;
	private String exposure;
	private String gain;
	private String speed;
	private String iris;
	private String whiteBalance;
	private String red;
	private String blue;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp updateTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setBacklight(String backlight) {
		this.backlight = backlight;
	}

	public String getBacklight() {
		return backlight;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public String getExposure() {
		return exposure;
	}

	public void setGain(String gain) {
		this.gain = gain;
	}

	public String getGain() {
		return gain;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getSpeed() {
		return speed;
	}

	public void setIris(String iris) {
		this.iris = iris;
	}

	public String getIris() {
		return iris;
	}

	public void setWhiteBalance(String whiteBalance) {
		this.whiteBalance = whiteBalance;
	}

	public String getWhiteBalance() {
		return whiteBalance;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getRed() {
		return red;
	}

	public void setBlue(String blue) {
		this.blue = blue;
	}

	public String getBlue() {
		return blue;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCcIP() {
		return ccIP;
	}

	public void setCcIP(String ccIP) {
		this.ccIP = ccIP;
	}

}
