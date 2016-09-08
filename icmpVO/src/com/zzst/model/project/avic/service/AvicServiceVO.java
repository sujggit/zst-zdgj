package com.zzst.model.project.avic.service;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

/**
 * class description: AvicService Object
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String recordID;
	private String departmentID;
	private String departmentName;
	private String departmentCode;
	private String meetingDetailID;
	private String meetingDetailName;
	private int headQuarterLeaderNumber = Integer.MIN_VALUE;
	private int departmentLeaderNumber = Integer.MIN_VALUE;
	private int headQuarterEastNumber = Integer.MIN_VALUE;
	private int headQuarterWestNumber = Integer.MIN_VALUE;
	private int jinHangNetWorkNumber = Integer.MIN_VALUE;
	private int otherVenueNumber = Integer.MIN_VALUE;
	private int netWorkNumber = Integer.MIN_VALUE;
	private String recordService;
	private String otherDes;
	private int realityVenueNumber = Integer.MIN_VALUE;
	private int realityPersonnelNumber = Integer.MIN_VALUE;
	private String venuePrincipal;
	private String createUserID;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;

	private String flowId;
	
	///////////关联会议申请会议名称
	private String applyMeetingName;
	
	////关联会议的视频会议申请信息
	private ApplyConferenceVO applyConferenceVO;
	
	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}

	public String getRecordID() {
		return recordID;
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

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailName(String meetingDetailName) {
		this.meetingDetailName = meetingDetailName;
	}

	public String getMeetingDetailName() {
		return meetingDetailName;
	}

	public void setHeadQuarterLeaderNumber(int headQuarterLeaderNumber) {
		this.headQuarterLeaderNumber = headQuarterLeaderNumber;
	}

	public int getHeadQuarterLeaderNumber() {
		return headQuarterLeaderNumber;
	}

	public void setDepartmentLeaderNumber(int departmentLeaderNumber) {
		this.departmentLeaderNumber = departmentLeaderNumber;
	}

	public int getDepartmentLeaderNumber() {
		return departmentLeaderNumber;
	}

	public void setHeadQuarterEastNumber(int headQuarterEastNumber) {
		this.headQuarterEastNumber = headQuarterEastNumber;
	}

	public int getHeadQuarterEastNumber() {
		return headQuarterEastNumber;
	}

	public void setHeadQuarterWestNumber(int headQuarterWestNumber) {
		this.headQuarterWestNumber = headQuarterWestNumber;
	}

	public int getHeadQuarterWestNumber() {
		return headQuarterWestNumber;
	}

	public void setJinHangNetWorkNumber(int jinHangNetWorkNumber) {
		this.jinHangNetWorkNumber = jinHangNetWorkNumber;
	}

	public int getJinHangNetWorkNumber() {
		return jinHangNetWorkNumber;
	}

	public void setOtherVenueNumber(int otherVenueNumber) {
		this.otherVenueNumber = otherVenueNumber;
	}

	public int getOtherVenueNumber() {
		return otherVenueNumber;
	}

	public void setNetWorkNumber(int netWorkNumber) {
		this.netWorkNumber = netWorkNumber;
	}

	public int getNetWorkNumber() {
		return netWorkNumber;
	}

	public void setRecordService(String recordService) {
		this.recordService = recordService;
	}

	public String getRecordService() {
		return recordService;
	}

	public void setOtherDes(String otherDes) {
		this.otherDes = otherDes;
	}

	public String getOtherDes() {
		return otherDes;
	}

	public void setRealityVenueNumber(int realityVenueNumber) {
		this.realityVenueNumber = realityVenueNumber;
	}

	public int getRealityVenueNumber() {
		return realityVenueNumber;
	}

	public void setRealityPersonnelNumber(int realityPersonnelNumber) {
		this.realityPersonnelNumber = realityPersonnelNumber;
	}

	public int getRealityPersonnelNumber() {
		return realityPersonnelNumber;
	}

	public void setVenuePrincipal(String venuePrincipal) {
		this.venuePrincipal = venuePrincipal;
	}

	public String getVenuePrincipal() {
		return venuePrincipal;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	public String getCreateUserID() {
		return createUserID;
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

	public String getApplyMeetingName() {
		return applyMeetingName;
	}

	public void setApplyMeetingName(String applyMeetingName) {
		this.applyMeetingName = applyMeetingName;
	}

	public ApplyConferenceVO getApplyConferenceVO() {
		return applyConferenceVO;
	}

	public void setApplyConferenceVO(ApplyConferenceVO applyConferenceVO) {
		this.applyConferenceVO = applyConferenceVO;
	}

}
