package com.zzst.model.meeting.uploadFile;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: UploadFile Object
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public class UploadFileVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uploadID;
	private int uploadType = Integer.MIN_VALUE;
	private String uploadKey;//颁发部门ID
	private String fileName;
	private String fileType;
	private String fileUrl;
	private String createUserID;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;
	
	private UserVO userVO = new UserVO();
	private DepartmentVO departmentVO = new DepartmentVO();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private EquipmentVO equipmentVO = new EquipmentVO();
	private UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
	
	private MeetingRoomVO meetingRoomVO = new MeetingRoomVO();

	public void setUploadID(String uploadID) {
		this.uploadID = uploadID;
	}

	public String getUploadID() {
		return uploadID;
	}

	public void setUploadType(int uploadType) {
		this.uploadType = uploadType;
	}

	public int getUploadType() {
		return uploadType;
	}

	public void setUploadKey(String uploadKey) {
		this.uploadKey = uploadKey;
	}

	public String getUploadKey() {
		return uploadKey;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() {
		return fileUrl;
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

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public UploadFileImpowerVO getUploadFileImpowerVO() {
		return uploadFileImpowerVO;
	}

	public void setUploadFileImpowerVO(UploadFileImpowerVO uploadFileImpowerVO) {
		this.uploadFileImpowerVO = uploadFileImpowerVO;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

}
