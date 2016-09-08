package com.zzst.model.meeting.apply.flow;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.user.UserVO;

/**
 * class description: ApplyFlow Object
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlowVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String flowID;
	private String flowName;
	private int flowType = Integer.MIN_VALUE;
	private String createUserID;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp startTime;
	private Timestamp endTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;
	private UserVO userVO;
	private int isDelete = Integer.MIN_VALUE;

	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}

	public String getFlowID() {
		return flowID;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowType(int flowType) {
		this.flowType = flowType;
	}

	public int getFlowType() {
		return flowType;
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

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
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

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
