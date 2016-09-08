package com.zzst.model.meeting.userDepartment;

import java.io.Serializable;

import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: UserDepartment VO
 * 
 * @author ryan
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserDepartmentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userDepartmentID=Integer.MIN_VALUE;

	private Integer corpID=Integer.MIN_VALUE;

	private String corpName;

	private Long revision=Long.MIN_VALUE;
	
	private UserVO userVO =new UserVO();
	
	private DepartmentVO departmentVO = new DepartmentVO();

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public void setUserDepartmentID(Integer userDepartmentID) {
		this.userDepartmentID = userDepartmentID;
	}

	public Integer getUserDepartmentID() {
		return userDepartmentID;
	}

	public void setCorpID(Integer corpID) {
		this.corpID = corpID;
	}

	public Integer getCorpID() {
		return corpID;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

}
