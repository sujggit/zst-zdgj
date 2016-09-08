package com.zzst.action.meeting.user;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.auth.FuncServiceImpl;
import com.zzst.service.meeting.auth.RoleService;
import com.zzst.service.meeting.auth.RoleServiceImpl;

import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

public class PersonConfigAction extends BaseAction{
	private static final long serialVersionUID = 1L;
    private static Logger logger = CbfLogger.getLogger(PersonConfigAction.class.getName());
	private ArrayList<RoleVO> roleVOList = new ArrayList<RoleVO>();
	private UserVO userVO = new UserVO();
	private UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
	private UserRoleVO userRoleVO = new UserRoleVO();
	private ArrayList<UserVO> userList = new ArrayList<UserVO>();
	private ArrayList<FuncVO> treelist  = new ArrayList<FuncVO>();
	private String info;
	private InputStream  excelStream;
	
	public String getPersonInfo(){
		logger.info("PersonConfigAction  getPersonInfo	begin");
		try{
			userVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			
			if(userVO==null){
				return ERROR;
			}
			userVO.setUserID(userVO.getUserID());
//			userVO.setPassWord(userVO.getPassWord());
            UserRoleService userRoleService = new UserRoleServiceImpl();
			userRoleVO.setUserID(userVO.getUserID());
		    ArrayList<UserRoleVO> userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
			if(userRoleVOList != null && userRoleVOList.size() > 0){
				userRoleVO = userRoleVOList.get(0);
			}
			RoleService roleService = new RoleServiceImpl();
		    roleVOList = roleService.getRoleList(null, null);
		   
// 			userVO.setPassWord(DES.decryptPassword(userVO.getPassWord()));//解密
			
		}catch(Exception e){
			request.setAttribute("info", "获取用户信息时发生异常！");
			logger.error(e.getMessage());
			return ERROR;
		}
		
		logger.info("PersonConfigAction  getPersonInfo	end");
		return SUCCESS;
	}
	public String modifyPersonConfig(){
		logger.info("PersonConfigAction		modifyPersonConfig	begin");
		try{
			
			UserService userService = new UserServiceImpl();
			UserVO userVO1 = new UserVO();
			userVO1.setUserID(userVO.getUserID());
			ArrayList<UserVO> list = userService.getUserList(userVO1, null);
			if(list.size()!=1){
				return ERROR;
			}
			userVO1 = list.get(0);
			
			userVO1.setName(userVO.getName());
			userVO1.setEmail(userVO.getEmail());
			userVO1.setMobile(userVO.getMobile());
			//userVO1.setPassWord(DES.encryptPassword(userVO1.getPassWord()));// 加密
			ServiceFactory.getUserService().modifyUser(userVO1, null);
            
			UserRoleVO  userRoleVO =new UserRoleVO();
			userRoleVO.setUserID(userVO1.getUserID());
			ArrayList<UserRoleVO> roleList=new UserRoleServiceImpl().getUserRoleList(userRoleVO, null);
			if(roleList==null || roleList.size()==0){
				logger.debug("UserServiceImpl userLogin null");
				return null;
				
			}
			ArrayList<FuncVO> ulist = new FuncServiceImpl().getFuncList(userVO, null);
			userVO.setFuncVOList(ulist);
			userVO.setUserRoleVOList(roleList);
			
			
			request.getSession().setAttribute(UserEnum.USER_SESSION_ID,userVO);
		}catch(Exception e){
			request.setAttribute("info", "修改用户信息时发生异常！");
			logger.error(e.getMessage());
			return ERROR;
		}
		
		logger.info("PersonConfigAction		modifyPersonConfig	end");
		return SUCCESS;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	public ArrayList<RoleVO> getRoleVOList() {
		return roleVOList;
	}
	public void setRoleVOList(ArrayList<RoleVO> roleVOList) {
		this.roleVOList = roleVOList;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public UserDepartmentVO getUserDepartmentVO() {
		return userDepartmentVO;
	}
	public void setUserDepartmentVO(UserDepartmentVO userDepartmentVO) {
		this.userDepartmentVO = userDepartmentVO;
	}
	public UserRoleVO getUserRoleVO() {
		return userRoleVO;
	}
	public void setUserRoleVO(UserRoleVO userRoleVO) {
		this.userRoleVO = userRoleVO;
	}
	/**
	 * @return the userList
	 */
	public ArrayList<UserVO> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<UserVO> userList) {
		this.userList = userList;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	public ArrayList getTreelist() {
		return treelist;
	}
	public void setTreelist(ArrayList treelist) {
		this.treelist = treelist;
	}
}
