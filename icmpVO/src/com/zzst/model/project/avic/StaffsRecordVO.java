package com.zzst.model.project.avic;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: StaffsRecord Object
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public class StaffsRecordVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String staffsRecordID;
	private String departmentName;
	private String departmentID;
	private String departmentNo;
	private String facsimile;
	private String meetingRoomAddressOne;
	private int peopleCountOne = Integer.MIN_VALUE;
	private String meetingRoomAddressTwo;
	private int peopleCountTwo = Integer.MIN_VALUE;
	private String leaderName;
	private String leaderMobile;
	private String leaderTel;
	private String technicalName;
	private String technicalMobile;
	private String technicalTel;
	private String technicalEmail;
	private String netTechnicalName;
	private String netTechnicalMobile;
	private String netTechnicalTel;
	private String netTechnicalEmail;
	private String creatPersonID;
	private Timestamp createDate;
	private String description;
	private long revision = Long.MIN_VALUE;
	private int status = Integer.MIN_VALUE;

	public void setStaffsRecordID(String staffsRecordID) {
		this.staffsRecordID = staffsRecordID;
	}

	public String getStaffsRecordID() {
		return staffsRecordID;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}

	public String getFacsimile() {
		return facsimile;
	}

	public void setMeetingRoomAddressOne(String meetingRoomAddressOne) {
		this.meetingRoomAddressOne = meetingRoomAddressOne;
	}

	public String getMeetingRoomAddressOne() {
		return meetingRoomAddressOne;
	}

	public void setPeopleCountOne(int peopleCountOne) {
		this.peopleCountOne = peopleCountOne;
	}

	public int getPeopleCountOne() {
		return peopleCountOne;
	}

	public void setMeetingRoomAddressTwo(String meetingRoomAddressTwo) {
		this.meetingRoomAddressTwo = meetingRoomAddressTwo;
	}

	public String getMeetingRoomAddressTwo() {
		return meetingRoomAddressTwo;
	}

	public void setPeopleCountTwo(int peopleCountTwo) {
		this.peopleCountTwo = peopleCountTwo;
	}

	public int getPeopleCountTwo() {
		return peopleCountTwo;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderMobile(String leaderMobile) {
		this.leaderMobile = leaderMobile;
	}

	public String getLeaderMobile() {
		return leaderMobile;
	}

	public void setLeaderTel(String leaderTel) {
		this.leaderTel = leaderTel;
	}

	public String getLeaderTel() {
		return leaderTel;
	}

	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}

	public String getTechnicalName() {
		return technicalName;
	}

	public void setTechnicalMobile(String technicalMobile) {
		this.technicalMobile = technicalMobile;
	}

	public String getTechnicalMobile() {
		return technicalMobile;
	}

	public void setTechnicalTel(String technicalTel) {
		this.technicalTel = technicalTel;
	}

	public String getTechnicalTel() {
		return technicalTel;
	}

	public void setTechnicalEmail(String technicalEmail) {
		this.technicalEmail = technicalEmail;
	}

	public String getTechnicalEmail() {
		return technicalEmail;
	}

	public void setNetTechnicalName(String netTechnicalName) {
		this.netTechnicalName = netTechnicalName;
	}

	public String getNetTechnicalName() {
		return netTechnicalName;
	}

	public void setNetTechnicalMobile(String netTechnicalMobile) {
		this.netTechnicalMobile = netTechnicalMobile;
	}

	public String getNetTechnicalMobile() {
		return netTechnicalMobile;
	}

	public void setNetTechnicalTel(String netTechnicaTel) {
		this.netTechnicalTel = netTechnicaTel;
	}

	public String getNetTechnicalTel() {
		return netTechnicalTel;
	}

	public void setNetTechnicalEmail(String netTechnicalEmail) {
		this.netTechnicalEmail = netTechnicalEmail;
	}

	public String getNetTechnicalEmail() {
		return netTechnicalEmail;
	}

	public void setCreatPersonID(String creatPersonID) {
		this.creatPersonID = creatPersonID;
	}

	public String getCreatPersonID() {
		return creatPersonID;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
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

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
