package com.zzst.model.meeting.dataInterface.department;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: DepartmentInterface Object
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public class DepartmentInterfaceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String departmentid;
	private String departmentcode;
	private String departmentname;
	private String fullname;
	private String parentid;
	private int ordernum = Integer.MIN_VALUE;
	private String parentcode;
	private String parentname;
	private String linkids;
	private String departmenttype;
	private String nodeproperty;
	private String telephone;
	private String fax;
	private String address;
	private String postcode;
	private String email;
	private Timestamp createtime;
	private String departmentdesc;
	private long revision = Long.MIN_VALUE;
	private String creatorid;
	private String creatorname;
	private int importstatus = Integer.MIN_VALUE;
	private String importdesc;

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getParentname() {
		return parentname;
	}

	public void setLinkids(String linkids) {
		this.linkids = linkids;
	}

	public String getLinkids() {
		return linkids;
	}

	public void setDepartmenttype(String departmenttype) {
		this.departmenttype = departmenttype;
	}

	public String getDepartmenttype() {
		return departmenttype;
	}

	public void setNodeproperty(String nodeproperty) {
		this.nodeproperty = nodeproperty;
	}

	public String getNodeproperty() {
		return nodeproperty;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return fax;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setDepartmentdesc(String departmentdesc) {
		this.departmentdesc = departmentdesc;
	}

	public String getDepartmentdesc() {
		return departmentdesc;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setImportstatus(int importstatus) {
		this.importstatus = importstatus;
	}

	public int getImportstatus() {
		return importstatus;
	}

	public void setImportdesc(String importdesc) {
		this.importdesc = importdesc;
	}

	public String getImportdesc() {
		return importdesc;
	}

}
