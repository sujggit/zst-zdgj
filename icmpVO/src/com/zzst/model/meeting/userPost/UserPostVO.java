package com.zzst.model.meeting.userPost;

import java.io.Serializable;

/**
 * class description: UserPost Object
 * 
 * @date Sun Jun 30 12:58:57 CST 2013
 * @author ryan
 */
public class UserPostVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userID;
	private String postNO;
	private int status = Integer.MIN_VALUE;
	private long revision = Long.MIN_VALUE;
	private String description;

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}

	public String getPostNO() {
		return postNO;
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
