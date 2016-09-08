package com.zzst.model.meeting.user;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.level.LevelVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.post.PostVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;
import com.zzst.model.meeting.userRole.UserRoleVO;

/**
 * class description: User VO
 * 
 * @author ryan
 * @ modify by zhangliang 2011-11-14
 * @date Mon Aug 03 18:32:47 CST 2009
 */

public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userID ;

	private String email;
	//change db email into the following  email list by split ','
	private ArrayList<String> emailList = new ArrayList<String>() ;		

	private String loginName;

	private String passWord;

	private String name;

	private String nameSpelling;

	private String title;

	private String mobile;

	private String tel;

	private Timestamp lastLoginTime;

	private Integer state=Integer.MIN_VALUE;

	private String description;
	/////分级分权
	private LevelConfigVO levelConfigVO = new LevelConfigVO();
	private String lvoids;
	private boolean openlevel;

	private Long revision=Long.MIN_VALUE;
	
	private ArrayList<UserRoleVO> userRoleVOList = new ArrayList<UserRoleVO>();

	private ArrayList<UserDepartmentVO> UserDepartmentVOList = new ArrayList<UserDepartmentVO>();
	
	private ArrayList<FuncVO> funcVOList = new ArrayList<FuncVO>();
	
	private DepartmentVO departmentVO = new DepartmentVO();
	
	//认证类型
	private Integer authenticateType=UserEnum.INTERNAL_AUTHENTICATE;
	
	private Timestamp changePwdTime;
	private int errorTimes=Integer.MIN_VALUE;
	
	//////
	private String roleid;//add on 6-25
	
	//岗位
	private PostVO postVO = new PostVO();
	
	/**
	 * 20140819操作按钮可控制的优化
	 * 1登录后第一次使用时将所有funcUrl信息存入缓存Map，
	 * 2每次需要的时候直接取出来使用，不再依次查询数据库，
	 * 3退出登录的时候此缓存map消失
	 */
	private Map<String, String> funcMap = new HashMap<String, String>();
	
	public Map<String, String> getFuncMap() {
		return funcMap;
	}


	public void setFuncMap(Map<String, String> funcMap) {
		this.funcMap = funcMap;
	}


	public ArrayList<FuncVO> getFuncVOList() {
		return funcVOList;
	}


	public void setFuncVOList(ArrayList<FuncVO> funcVOList) {
		this.funcVOList = funcVOList;
	}


	public void splitEmails(String email){
		if(email != null && !email.trim().equals("")){
			String[] emailArray = email.split(",");
			for(int i = 0; i < emailArray.length; i++){
				emailList.add(emailArray[i].trim());
			}
		}
	}
	
	
	public ArrayList<UserDepartmentVO> getUserDepartmentVOList() {
		return UserDepartmentVOList;
	}

	public void setUserDepartmentVOList(
			ArrayList<UserDepartmentVO> userDepartmentVOList) {
		UserDepartmentVOList = userDepartmentVOList;
	}

	public ArrayList<UserRoleVO> getUserRoleVOList() {
		return this.userRoleVOList;
	}

	public void setUserRoleVOList(ArrayList<UserRoleVO> userRoleVOList) {
		this.userRoleVOList = userRoleVOList;
	}


	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}


	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNameSpelling(String nameSpelling) {
		this.nameSpelling = nameSpelling;
	}

	public String getNameSpelling() {
		return nameSpelling;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}

	/**
	 * @return the departmentVO
	 */
	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	/**
	 * @param departmentVO the departmentVO to set
	 */
	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public Integer getAuthenticateType() {
		return authenticateType;
	}

	public void setAuthenticateType(Integer authenticateType) {
		this.authenticateType = authenticateType;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public PostVO getPostVO() {
		return postVO;
	}

	public void setPostVO(PostVO postVO) {
		this.postVO = postVO;
	}


	public Timestamp getChangePwdTime() {
		return changePwdTime;
	}


	public void setChangePwdTime(Timestamp changePwdTime) {
		this.changePwdTime = changePwdTime;
	}


	public int getErrorTimes() {
		return errorTimes;
	}


	public void setErrorTimes(int errorTimes) {
		this.errorTimes = errorTimes;
	}


	public void setLvoids(String lvoids) {
		this.lvoids = lvoids;
	}


	public String getLvoids() {
		return lvoids;
	}


	public void setOpenlevel(boolean openlevel) {
		this.openlevel = openlevel;
	}

	public boolean getOpenlevel() {
		return openlevel;
	}


	public LevelConfigVO getLevelConfigVO() {
		return levelConfigVO;
	}


	public void setLevelConfigVO(LevelConfigVO levelConfigVO) {
		this.levelConfigVO = levelConfigVO;
	}


}
