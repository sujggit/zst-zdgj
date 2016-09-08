package com.zzst.model.meeting.meetingRoom;

import java.io.Serializable;
import java.sql.Timestamp;


import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;


/**
 * class description: MeetingRoom VO
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class MeetingRoomVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String meetingRoomID;
	private String meetingRoomName;
	private String roomNO;
	private int meetingRoomType	= Integer.MIN_VALUE;
	private int capacity	= Integer.MIN_VALUE;
	private String planeImg;
	private String pictureImg;
	private String meetingroomUrl;
	private int status = Integer.MIN_VALUE;
	private UserVO userVO = new UserVO();
	private DepartmentVO departmentVO = new  DepartmentVO();
	private AddressVO addressVO=new AddressVO();
	private String description;
	private Integer revision=Integer.MIN_VALUE;
	//is leaf
	private int isleaf =-1; 
	//parent id
	private String parentID;
	private String useTime;
	private String useCount;	
	private String	viewStr;
	//for statistic
	private Timestamp startTime;
	private Timestamp endTime;
	//会议室分级分权
	private boolean isLevel;
	private String lsql;
	
	//会议室位置
	private String roomPCA;
	
	public String getViewStr() {
		return viewStr;
	}
	public void setViewStr(String viewStr) {
		this.viewStr = viewStr;
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
	
	
	public AddressVO getAddressVO() {
		return addressVO;
	}
	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}
	public String getMeetingRoomID() {
		return meetingRoomID;
	}
	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}
	public String getMeetingRoomName() {
		return meetingRoomName;
	}
	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}
	public String getRoomNO() {
		return roomNO;
	}
	public void setRoomNO(String roomNO) {
		this.roomNO = roomNO;
	}



	public int getMeetingRoomType() {
		return meetingRoomType;
	}
	public void setMeetingRoomType(int meetingRoomType) {
		this.meetingRoomType = meetingRoomType;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getPlaneImg() {
		return planeImg;
	}
	public void setPlaneImg(String planeImg) {
		this.planeImg = planeImg;
	}
	public String getPictureImg() {
		return pictureImg;
	}
	public void setPictureImg(String pictureImg) {
		this.pictureImg = pictureImg;
	}
	public String getMeetingroomUrl() {
		return meetingroomUrl;
	}
	public void setMeetingroomUrl(String meetingroomUrl) {
		this.meetingroomUrl = meetingroomUrl;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRevision() {
		return revision;
	}
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	/**
	 * @return the isleaf
	 */
	public int getIsleaf() {
		return isleaf;
	}
	/**
	 * @param isleaf the isleaf to set
	 */
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return parentID;
	}
	/**
	 * @param parentID the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getUseCount() {
		return useCount;
	}
	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}
	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public void setLevel(boolean isLevel) {
		this.isLevel = isLevel;
	}
	public boolean isLevel() {
		return isLevel;
	}
	public void setLsql(String lsql) {
		this.lsql = lsql;
	}
	public String getLsql() {
		return lsql;
	}
	public String getRoomPCA() {
		return roomPCA;
	}
	public void setRoomPCA(String roomPCA) {
		this.roomPCA = roomPCA;
	}
	
	
	
	
	

}
