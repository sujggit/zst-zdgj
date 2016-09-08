package com.zzst.model.meeting.uploadFile.directory;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.enums.FileDirectoryEnum;

/**
 * class description: FileDirectory Object
 * 
 * @date Mon May 06 14:16:25 CST 2013
 * @author ryan
 */
public class FileDirectoryVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dirID;
	private String name;
	private String parentID;
	private int status = FileDirectoryEnum.STATUS_VALID;
	private String updateUserID;
	private Timestamp updateTime;
	private String description;
	private long revision = Long.MIN_VALUE;

	public void setDirID(String dirID) {
		this.dirID = dirID;
	}

	public String getDirID() {
		return dirID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setUpdateUserID(String updateUserID) {
		this.updateUserID = updateUserID;
	}

	public String getUpdateUserID() {
		return updateUserID;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
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

}
