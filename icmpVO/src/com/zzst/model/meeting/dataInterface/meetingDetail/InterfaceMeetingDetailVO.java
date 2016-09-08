package com.zzst.model.meeting.dataInterface.meetingDetail;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: InterfaceMeetingDetail Object
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public class InterfaceMeetingDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String meetingname;
	private Timestamp starttime;
	private Timestamp endtime;
	private int meetingType = Integer.MIN_VALUE;
	private int isRecord = Integer.MIN_VALUE;
	private int level = Integer.MIN_VALUE;
	private int meetingStatus = Integer.MIN_VALUE;
	private int notifyType = Integer.MIN_VALUE;
	private String createUserName;
	private Timestamp createTime;
	private String roomNos;
	private String confProfileID;
	private String modelID;
	private int status = Integer.MIN_VALUE;
	private String description;
	private String ref1;
	private String ref2;
	private String mainRoomNO;
	
	public String getMainRoomNO() {
		return mainRoomNO;
	}

	public void setMainRoomNO(String mainRoomNO) {
		this.mainRoomNO = mainRoomNO;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setMeetingType(int meetingType) {
		this.meetingType = meetingType;
	}

	public int getMeetingType() {
		return meetingType;
	}

	public void setIsRecord(int isRecord) {
		this.isRecord = isRecord;
	}

	public int getIsRecord() {
		return isRecord;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setMeetingStatus(int meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	public int getMeetingStatus() {
		return meetingStatus;
	}

	public void setNotifyType(int notifyType) {
		this.notifyType = notifyType;
	}

	public int getNotifyType() {
		return notifyType;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setRoomNos(String roomNos) {
		this.roomNos = roomNos;
	}

	public String getRoomNos() {
		return roomNos;
	}

	public void setConfProfileID(String confProfileID) {
		this.confProfileID = confProfileID;
	}

	public String getConfProfileID() {
		return confProfileID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public String getModelID() {
		return modelID;
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

	public void setRef1(String ref1) {
		this.ref1 = ref1;
	}

	public String getRef1() {
		return ref1;
	}

	public void setRef2(String ref2) {
		this.ref2 = ref2;
	}

	public String getRef2() {
		return ref2;
	}

}
