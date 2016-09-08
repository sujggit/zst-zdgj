package com.zzst.model.project.avic.applyConference;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: ApplyConference Object
 * @date Wed Sep 19 16:15:16 CST 2012
 * @author ryan
 */
public class ApplyConferenceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String applyID;
	private String departmentID;
	private String departmentName;
	private String departmentCode;
	private String linkManID;
	private String linkManName;
	private String linkManPhone;
	private String linkManCellPhone;
	private String linkManFax;
	private int security = Integer.MIN_VALUE;
	private Timestamp startTime;
	private Timestamp endTime;
	private String conferenceName;
	private String conferenceAgenda;
	private String graphicsDepartmentName;
	private String splitScreent;
	private String poll;
	private int videotape = Integer.MIN_VALUE;
	private String otherRequire;
	private String departmentGroupLeadIDs;
	private String departmentGroupLeadNames;
	private String departmentGroupIDS;
	private String departmentGroupNames;
	private String departmentDirectlyIDS;
	private String departmentDirectlyNames;
	private String departmentMemberIDS;
	private String departmentMemberNames;
	private String departmentOutMemberIDS;
	private String departmentOutMemberNames;
	private String createUserID;
	private String mainVenueNumber;
	private String venueNumber;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;
	private String venueConference;
	private String mainConference;
	private String mainConferenceID;//20130802添加主会场ID及分会场IDs
	private String venueConferenceIDs;
	private String countNumber;
	private String flowId;
	//关联会议室新加
	private String meetingDetailID;
	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}

	public String getApplyID() {
		return applyID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getLinkManID() {
		return linkManID;
	}

	public void setLinkManID(String linkManID) {
		this.linkManID = linkManID;
	}

	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}

	public String getLinkManName() {
		return linkManName;
	}

	public void setLinkManPhone(String linkManPhone) {
		this.linkManPhone = linkManPhone;
	}

	public String getLinkManPhone() {
		return linkManPhone;
	}

	public void setLinkManCellPhone(String linkManCellPhone) {
		this.linkManCellPhone = linkManCellPhone;
	}

	public String getLinkManCellPhone() {
		return linkManCellPhone;
	}

	public void setLinkManFax(String linkManFax) {
		this.linkManFax = linkManFax;
	}

	public String getLinkManFax() {
		return linkManFax;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

	public int getSecurity() {
		return security;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceAgenda(String conferenceAgenda) {
		this.conferenceAgenda = conferenceAgenda;
	}

	public String getConferenceAgenda() {
		return conferenceAgenda;
	}

	public void setGraphicsDepartmentName(String graphicsDepartmentName) {
		this.graphicsDepartmentName = graphicsDepartmentName;
	}

	public String getGraphicsDepartmentName() {
		return graphicsDepartmentName;
	}

	public void setSplitScreent(String splitScreent) {
		this.splitScreent = splitScreent;
	}

	public String getSplitScreent() {
		return splitScreent;
	}

	public void setPoll(String poll) {
		this.poll = poll;
	}

	public String getPoll() {
		return poll;
	}

	public void setVideotape(int videotape) {
		this.videotape = videotape;
	}

	public int getVideotape() {
		return videotape;
	}

	public void setOtherRequire(String otherRequire) {
		this.otherRequire = otherRequire;
	}

	public String getOtherRequire() {
		return otherRequire;
	}

	public void setDepartmentGroupLeadIDs(String departmentGroupLeadIDs) {
		this.departmentGroupLeadIDs = departmentGroupLeadIDs;
	}

	public String getDepartmentGroupLeadIDs() {
		return departmentGroupLeadIDs;
	}

	public void setDepartmentGroupLeadNames(String departmentGroupLeadNames) {
		this.departmentGroupLeadNames = departmentGroupLeadNames;
	}

	public String getDepartmentGroupLeadNames() {
		return departmentGroupLeadNames;
	}

	public void setDepartmentGroupIDS(String departmentGroupIDS) {
		this.departmentGroupIDS = departmentGroupIDS;
	}

	public String getDepartmentGroupIDS() {
		return departmentGroupIDS;
	}

	public void setDepartmentGroupNames(String departmentGroupNames) {
		this.departmentGroupNames = departmentGroupNames;
	}

	public String getDepartmentGroupNames() {
		return departmentGroupNames;
	}

	public void setDepartmentDirectlyIDS(String departmentDirectlyIDS) {
		this.departmentDirectlyIDS = departmentDirectlyIDS;
	}

	public String getDepartmentDirectlyIDS() {
		return departmentDirectlyIDS;
	}

	public void setDepartmentDirectlyNames(String departmentDirectlyNames) {
		this.departmentDirectlyNames = departmentDirectlyNames;
	}

	public String getDepartmentDirectlyNames() {
		return departmentDirectlyNames;
	}

	public void setDepartmentMemberIDS(String departmentMemberIDS) {
		this.departmentMemberIDS = departmentMemberIDS;
	}

	public String getDepartmentMemberIDS() {
		return departmentMemberIDS;
	}

	public void setDepartmentMemberNames(String departmentMemberNames) {
		this.departmentMemberNames = departmentMemberNames;
	}

	public String getDepartmentMemberNames() {
		return departmentMemberNames;
	}

	public void setDepartmentOutMemberIDS(String departmentOutMemberIDS) {
		this.departmentOutMemberIDS = departmentOutMemberIDS;
	}

	public String getDepartmentOutMemberIDS() {
		return departmentOutMemberIDS;
	}

	public void setDepartmentOutMemberNames(String departmentOutMemberNames) {
		this.departmentOutMemberNames = departmentOutMemberNames;
	}

	public String getDepartmentOutMemberNames() {
		return departmentOutMemberNames;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	public String getCreateUserID() {
		return createUserID;
	}

	public void setMainVenueNumber(String mainVenueNumber) {
		this.mainVenueNumber = mainVenueNumber;
	}

	public String getMainVenueNumber() {
		return mainVenueNumber;
	}

	public void setVenueNumber(String venueNumber) {
		this.venueNumber = venueNumber;
	}

	public String getVenueNumber() {
		return venueNumber;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
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

	public void setVenueConference(String venueConference) {
		this.venueConference = venueConference;
	}

	public String getVenueConference() {
		return venueConference;
	}

	public void setMainConference(String mainConference) {
		this.mainConference = mainConference;
	}

	public String getMainConference() {
		return mainConference;
	}

	public void setCountNumber(String countNumber) {
		this.countNumber = countNumber;
	}

	public String getCountNumber() {
		return countNumber;
	}

	public String getMainConferenceID() {
		return mainConferenceID;
	}

	public void setMainConferenceID(String mainConferenceID) {
		this.mainConferenceID = mainConferenceID;
	}

	public String getVenueConferenceIDs() {
		return venueConferenceIDs;
	}

	public void setVenueConferenceIDs(String venueConferenceIDs) {
		this.venueConferenceIDs = venueConferenceIDs;
	}

}
