package com.zzst.action.meeting.role;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.auth.RoleService;
import com.zzst.service.meeting.auth.RoleServiceImpl;

/**
 * ROLE action
 * @author zhangliang
 * Nov 4, 2011 11:24:59 AM
 */
public class RoleAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(RoleAction.class.getName());
	
	private RoleVO roleVO = new RoleVO();
	private List<RoleVO> roleVOList = new ArrayList<RoleVO>();
	private List<UserVO> uList = new ArrayList<UserVO>();
	
	private String roleID;
	/**
	 * add a role
	 * @return
	 */
	public String addRole() {
		logger.info("RoleAction		addRole	begin");
		try {	
			if(checkToken()){
				request.setAttribute("info", "不能重复提交");
				return INVALID_TOKEN;
			}
			Date tempDate = new Date(System.currentTimeMillis());
			roleVO.setCreate_date(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(tempDate));
			roleVO.setStatus(UserEnum.VALID+"");
			RoleService roleService = new RoleServiceImpl();
			roleService.addRole(roleVO, null);
			
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("添加角色:"+roleVO.getRoleName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
			request.setAttribute("info", "已添加一个" + roleVO.getRoleName() + "角色");
		} catch (Exception e) {
			request.setAttribute("info", "ϵͳ添加角色时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("RoleAction		addRole	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * edit a role
	 * @return
	 */
	public String getRoleInfo(){
		logger.info("RoleAction		getRoleInfo	begin");
		try{
			RoleService roleService = new RoleServiceImpl();
			roleVOList = roleService.getRoleList(roleVO, null);
			if(roleVOList != null && roleVOList.size() > 0){
				roleVO = roleVOList.get(0);
			}
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取角色信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("RoleAction		getRoleInfo	end");
		return REQUEST_SUCCESS;
	}
	
	
	/**
	 * modify a role
	 * @return
	 */
	public String modifyRole(){
		logger.info("RoleAction		modifyRole	begin");
		try{
			RoleService roleService = new RoleServiceImpl();
			roleService.modifyRole(roleVO, null);
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("修改角色信息:"+roleVO.getRoleName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ修改角色信息时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("RoleAction		modifyRole	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * list roles;
	 * @return
	 */
	public String manageRoleList(){
		logger.info("RoleAction		manageRoleList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		
		try{
			// operatorBegin();
			RoleService roleService = new RoleServiceImpl();
			roleVOList = roleService.getRoleList(roleVO,pSplittor.getPControler());
			request.setAttribute("list", roleVOList);
			//// operatorEnd();
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取角色列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("RoleAction		manageRoleList	end");
		return REQUEST_SUCCESS;
	}
	/**
	 * delete role;
	 * @return String
	 */
	public String delRole(){
		logger.info("RoleAction		delRole	begin");
		try{
			RoleService roleService = new RoleServiceImpl();
			roleService.delRole(roleVO,null);
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("删除角色", uv.getUserID(), "", LogEnum.TYPE_DB, 1);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ删除角色时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("RoleAction		delRole	end");
		return REQUEST_SUCCESS;
	}
	
	public String getAuthorization(){
		logger.info("RoleAction  authorization  begin");
		
		
		try {
			List<UserRoleVO> urList = new ArrayList<UserRoleVO>();
			List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
			UserRoleVO role = new UserRoleVO();
			role.setRoleID(roleID);
			urList = ServiceFactory.getUserRoleService().getUserRoleList(role, null);
			Map<String,String> map = new HashMap<String,String>();
			
			for(UserRoleVO urVO : urList){
				map.put(urVO.getUserID(), urVO.getUserID());
			}
			dList = ServiceFactory.getDepartmentService().query(null, null);
			UserVO uVO = new UserVO();
			uVO.setState(UserEnum.VALID);
			uList = ServiceFactory.getUserService().getUserList(uVO, null);
			request.setAttribute("dList", dList);
			request.setAttribute("authorizationMap", map);
			request.setAttribute("uList", uList);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return REQUEST_SUCCESS;
	}

	public RoleVO getRoleVO() {
		return roleVO;
	}

	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}

	public List<RoleVO> getRoleVOList() {
		return roleVOList;
	}

	public void setRoleVOList(List<RoleVO> roleVOList) {
		this.roleVOList = roleVOList;
	}

	public void setuList(List<UserVO> uList) {
		this.uList = uList;
	}

	public List<UserVO> getuList() {
		return uList;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
}
