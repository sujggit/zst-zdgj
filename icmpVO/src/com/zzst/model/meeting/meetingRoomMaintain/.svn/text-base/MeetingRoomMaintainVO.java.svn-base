package com.zzst.model.meeting.meetingRoomMaintain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintain Object
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String maintainID;
	private String roomID;
	private String maintainUserName;
	private String createUserID;
	private Timestamp createTime;
	private Timestamp endTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;
	private String maintainKey;//会场关联外键
	private int maintainType = Integer.MIN_VALUE;
	private int processStatus = Integer.MIN_VALUE;
    private MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
    private MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
    private ArrayList<MeetingRoomMaintainDetailVO> meetingRoomMaintainDetailList = new ArrayList<MeetingRoomMaintainDetailVO>();
    private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	public void setMaintainID(String maintainID) {
		this.maintainID = maintainID;
	}

	public String getMaintainID() {
		return maintainID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setMaintainUserName(String maintainUserName) {
		this.maintainUserName = maintainUserName;
	}

	public String getMaintainUserName() {
		return maintainUserName;
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

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public ArrayList<MeetingRoomMaintainDetailVO> getMeetingRoomMaintainDetailList() {
		return meetingRoomMaintainDetailList;
	}

	public void setMeetingRoomMaintainDetailList(
			ArrayList<MeetingRoomMaintainDetailVO> meetingRoomMaintainDetailList) {
		this.meetingRoomMaintainDetailList = meetingRoomMaintainDetailList;
	}

	public String getMaintainKey() {
		return maintainKey;
	}

	public void setMaintainKey(String maintainKey) {
		this.maintainKey = maintainKey;
	}

	public int getMaintainType() {
		return maintainType;
	}

	public void setMaintainType(int maintainType) {
		this.maintainType = maintainType;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public MeetingRoomMaintainDetailVO getMeetingRoomMaintainDetailVO() {
		return meetingRoomMaintainDetailVO;
	}

	public void setMeetingRoomMaintainDetailVO(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO) {
		this.meetingRoomMaintainDetailVO = meetingRoomMaintainDetailVO;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
