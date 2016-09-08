package com.zzst.model.meeting.post;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: Post Object
 * 
 * @date Fri Jun 28 15:38:38 CST 2013
 * @author ryan
 */
public class PostVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String postNO;
	private String postName;
	private String parentNO;
	private String createUserID;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}

	public String getPostNO() {
		return postNO;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostName() {
		return postName;
	}

	public void setParentNO(String parentNO) {
		this.parentNO = parentNO;
	}

	public String getParentNO() {
		return parentNO;
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

}
