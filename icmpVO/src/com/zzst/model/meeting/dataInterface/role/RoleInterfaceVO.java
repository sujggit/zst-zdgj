package com.zzst.model.meeting.dataInterface.role;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: RoleInterface Object
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public class RoleInterfaceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String roleid;
	private String rolecode;
	private String rolename;
	private int ordernum = Integer.MIN_VALUE;
	private String parentid;
	private String parentcode;
	private String parentname;
	private String description;
	private String depid;
	private String depcode;
	private String depname;
	private Timestamp createtime;
	private String creatorid;
	private String creatorname;
	private long revision = Long.MIN_VALUE;
	private int importstatus = Integer.MIN_VALUE;
	private String importdesc;

	
	///////
	private int sqlType;
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolename() {
		return rolename;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentid() {
		return parentid;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepcode(String depcode) {
		this.depcode = depcode;
	}

	public String getDepcode() {
		return depcode;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getDepname() {
		return depname;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getCreatetime() {
		return createtime;
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

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
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

	public int getSqlType() {
		return sqlType;
	}

	public void setSqlType(int sqlType) {
		this.sqlType = sqlType;
	}

	
}
