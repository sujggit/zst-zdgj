package com.zzst.icmp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZTDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "z_t_department")
public class ZTDepartment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String parentId;
	private String name;
	private String depNo;
	private Integer leaf;
	private String url;
	private String linkCodeId;
	private String addressId;
	private String description;
	private Long revision;
	private Timestamp dbmsTime;

	// Constructors

	/** default constructor */
	public ZTDepartment() {
	}

	/** minimal constructor */
	public ZTDepartment(String parentId) {
		this.parentId = parentId;
	}

	/** full constructor */
	public ZTDepartment(String parentId, String name, String depNo,
			Integer leaf, String url, String linkCodeId, String addressId,
			String description, Long revision, Timestamp dbmsTime) {
		this.parentId = parentId;
		this.name = name;
		this.depNo = depNo;
		this.leaf = leaf;
		this.url = url;
		this.linkCodeId = linkCodeId;
		this.addressId = addressId;
		this.description = description;
		this.revision = revision;
		this.dbmsTime = dbmsTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "parentID", nullable = false, length = 50)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "depNo", length = 50)
	public String getDepNo() {
		return this.depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}

	@Column(name = "leaf")
	public Integer getLeaf() {
		return this.leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "linkCodeID", length = 65535)
	public String getLinkCodeId() {
		return this.linkCodeId;
	}

	public void setLinkCodeId(String linkCodeId) {
		this.linkCodeId = linkCodeId;
	}

	@Column(name = "addressID", length = 50)
	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "revision")
	public Long getRevision() {
		return this.revision;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	@Column(name = "dbms_time", length = 19)
	public Timestamp getDbmsTime() {
		return this.dbmsTime;
	}

	public void setDbmsTime(Timestamp dbmsTime) {
		this.dbmsTime = dbmsTime;
	}

}