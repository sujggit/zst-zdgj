package com.zzst.model.meeting.address;

import java.io.Serializable;

/**
 * class description: Address Object
 * 
 * @date Tue Jul 10 17:01:48 CST 2012
 * @author ryan
 */
public class AddressVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String addressID;
	private String name;
	private String parentID;
	private int status = Integer.MIN_VALUE;
	private String description;
	private long revision = Long.MIN_VALUE;
//	是否叶子节点
	private int leaf = Integer.MIN_VALUE;
	

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getAddressID() {
		return addressID;
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
