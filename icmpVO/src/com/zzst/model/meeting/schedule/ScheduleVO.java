package com.zzst.model.meeting.schedule;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: Schedule Object
 * 
 * @date Mon Aug 29 16:18:14 CST 2016
 * @author ryan
 */
public class ScheduleVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String scheduleId;
	private String scheduleTime;
	private String weekTime;
	private String meetingId;
	private String workId;
	private String isEvent;
	private String mark;
	private String status;
	private String applyId;
	private String leaderId;
	private Timestamp createTime;
	//增加字段，查询用
	private String fullName;//联络员名字
	private String workName;//工作名称
	private String meetingName;
	private Timestamp startTime;
	private Timestamp endTime;
	private String leaderName;//领导名字
	private String roomName;
	//--------
	private String applyPeopleId;//审批人id
	private String applysug;//审批意见
	private String applyPeople;//审批人名字
	private Timestamp applyTime;//审批时间
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setWeekTime(String weekTime) {
		this.weekTime = weekTime;
	}

	public String getWeekTime() {
		return weekTime;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getWorkId() {
		return workId;
	}

	public void setIsEvent(String isEvent) {
		this.isEvent = isEvent;
	}

	public String getIsEvent() {
		return isEvent;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return mark;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getApplyPeopleId() {
		return applyPeopleId;
	}

	public void setApplyPeopleId(String applyPeopleId) {
		this.applyPeopleId = applyPeopleId;
	}

	public String getApplysug() {
		return applysug;
	}

	public void setApplysug(String applysug) {
		this.applysug = applysug;
	}

	public String getApplyPeople() {
		return applyPeople;
	}

	public void setApplyPeople(String applyPeople) {
		this.applyPeople = applyPeople;
	}

	public Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	
}
