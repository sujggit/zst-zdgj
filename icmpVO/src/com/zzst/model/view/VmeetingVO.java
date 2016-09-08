package com.zzst.model.view;

import java.sql.Timestamp;



public class VmeetingVO {
	private String viewMeetingName;
	private Integer viewMeetingYear;
	private Integer viewMeetingMonth;
	private String viewMeetingDeptName;
	private Integer viewMeetingType;
	private String viewMeetingInfo;
	private String viewMeetingRoomName;
	private float viewTimeLong;
	private int meetingNum;
	private String ViewDeptId;
	private String ViewDeptPid;
	
	private Timestamp viewStartTime;
	private Timestamp viewEndTime;
	private String viewUserName;
	private String viewMeetingId;
	private String viewMeetRoomId;
	private int viewManNum;
	
	private String strsql;
	//分级分权
	private boolean isLevel;
	private String lsql;


	public VmeetingVO() {
		super();
	}

	public String getViewMeetingName() {
		return this.viewMeetingName;
	}

	public void setViewMeetingName(String viewMeetingName) {
		this.viewMeetingName = viewMeetingName;
	}

	public Integer getViewMeetingYear() {
		return this.viewMeetingYear;
	}

	public void setViewMeetingYear(Integer viewMeetingYear) {
		this.viewMeetingYear = viewMeetingYear;
	}

	public Integer getViewMeetingMonth() {
		return this.viewMeetingMonth;
	}

	public void setViewMeetingMonth(Integer viewMeetingMonth) {
		this.viewMeetingMonth = viewMeetingMonth;
	}

	public String getViewMeetingDeptName() {
		return this.viewMeetingDeptName;
	}

	public void setViewMeetingDeptName(String viewMeetingDeptName) {
		this.viewMeetingDeptName = viewMeetingDeptName;
	}

	public Integer getViewMeetingType() {
		return this.viewMeetingType;
	}

	public void setViewMeetingType(Integer viewMeetingType) {
		this.viewMeetingType = viewMeetingType;
	}

	public String getViewMeetingInfo() {
		return this.viewMeetingInfo;
	}

	public void setViewMeetingInfo(String viewMeetingInfo) {
		this.viewMeetingInfo = viewMeetingInfo;
	}

	public String getViewMeetingRoomName() {
		return this.viewMeetingRoomName;
	}

	public void setViewMeetingRoomName(String viewMeetingRoomName) {
		this.viewMeetingRoomName = viewMeetingRoomName;
	}

	public float getViewTimeLong() {
		return this.viewTimeLong;
	}

	public void setViewTimeLong(float viewTimeLong) {
		this.viewTimeLong = viewTimeLong;
	}

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

	public String getViewDeptId() {
		return ViewDeptId;
	}

	public void setViewDeptId(String viewDeptId) {
		ViewDeptId = viewDeptId;
	}

	public String getViewDeptPid() {
		return ViewDeptPid;
	}

	public void setViewDeptPid(String viewDeptPid) {
		ViewDeptPid = viewDeptPid;
	}

	public int getMeetingNum() {
		return meetingNum;
	}

	public void setMeetingNum(int meetingNum) {
		this.meetingNum = meetingNum;
	}

	public Timestamp getViewStartTime() {
		return viewStartTime;
	}

	public void setViewStartTime(Timestamp viewStartTime) {
		this.viewStartTime = viewStartTime;
	}

	public Timestamp getViewEndTime() {
		return viewEndTime;
	}

	public void setViewEndTime(Timestamp viewEndTime) {
		this.viewEndTime = viewEndTime;
	}

	public String getViewUserName() {
		return viewUserName;
	}

	public void setViewUserName(String viewUserName) {
		this.viewUserName = viewUserName;
	}

	public String getViewMeetingId() {
		return viewMeetingId;
	}

	public void setViewMeetingId(String viewMeetingId) {
		this.viewMeetingId = viewMeetingId;
	}

	public String getViewMeetRoomId() {
		return viewMeetRoomId;
	}

	public void setViewMeetRoomId(String viewMeetRoomId) {
		this.viewMeetRoomId = viewMeetRoomId;
	}

	public String getStrsql() {
		return strsql;
	}

	public void setStrsql(String strsql) {
		this.strsql = strsql;
	}

	public int getViewManNum() {
		return viewManNum;
	}

	public void setViewManNum(int viewManNum) {
		this.viewManNum = viewManNum;
	}

	

	
	
}
