package com.zzst.model.meeting.department;

import java.io.Serializable;

/**
 * class description: Department VO
 * 
 * @author zhangliang
 * @date Mon Aug 03 17:54:12 CST 2009
 */

public class DepartmentVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final int CORPORATION_ID = 1;//父节点为1的是子公司
	//部门ID
	private String id ;
    //父ID
	private String parentId;
    //部门名称
	private String title;
	//是否叶子节点
	private int leaf = Integer.MIN_VALUE;
	/************以下为业务有关字段 *********************/

	private String linkCodeID;
	
	private String addressID;
	
	private long revision=Long.MIN_VALUE;

	private String depNo;//部门编号

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the linkCodeID
	 */
	public String getLinkCodeID() {
		return linkCodeID;
	}

	/**
	 * @param linkCodeID the linkCodeID to set
	 */
	public void setLinkCodeID(String linkCodeID) {
		this.linkCodeID = linkCodeID;
	}

	/**
	 * @return the addressID
	 */
	public String getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getDepNo() {
		return depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}

}
