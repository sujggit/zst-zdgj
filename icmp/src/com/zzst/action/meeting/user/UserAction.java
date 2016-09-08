package com.zzst.action.meeting.user;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.action.meeting.level.LevelConfigAction;
import com.zzst.action.meeting.util.LDAPUtil;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.tools.MD5;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.cbfImpl.util.DES;
import com.zzst.dao.meeting.auth.FuncDAO;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.level.LevelVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.post.PostVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;
import com.zzst.model.meeting.userPost.UserPostVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.auth.RoleService;
import com.zzst.service.meeting.auth.RoleServiceImpl;
import com.zzst.service.meeting.level.LevelServiceImpl;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.meeting.userDepartment.UserDepartmentService;
import com.zzst.service.meeting.userDepartment.UserDepartmentServiceImpl;
import com.zzst.service.meeting.userPost.UserPostService;
import com.zzst.service.meeting.userPost.UserPostServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

/**
 * @author wangle
 * @date 2010-10-20
 */
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(UserAction.class.getName());
	
	private ArrayList<RoleVO> roleVOList = new ArrayList<RoleVO>();
	private UserVO userVO = new UserVO();
	private UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
	private UserRoleVO userRoleVO = new UserRoleVO();
	private ArrayList<UserVO> userList = new ArrayList<UserVO>();
	
	private ArrayList<FuncVO> treelist  = new ArrayList<FuncVO>();
	private String info;
	private InputStream  excelStream;
	private int dispatherType;
	
	private String formId;
	private String entryId;
	
	private List<PostVO> postVOList = new ArrayList<PostVO>();
	private UserPostVO userPostVO = new UserPostVO();
	
	//add by yangyi
	public String userExit(){
		logger.info("UserAction    userExit   begin");
		UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(sessionUserVO != null){
			request.getSession().removeAttribute(UserEnum.USER_SESSION_ID);
		}
		try{
			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_LOGIN);
			vLogVO.setUserIP(request.getRemoteHost());
			vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
			vLogVO.setUserName(sessionUserVO.getLoginName());
			vLogVO.setUserID(sessionUserVO.getUserID());
			vLogVO.setOperatorContent(sessionUserVO.getLoginName() + "退出登录");
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			logger.info("UserAction		userExit	error："+e.getMessage());
		}
		return "success";
	}
	public String userLoginSSO(){
		logger.info("UserAction		userLoginSSO	begin");
		logger.info("===========================UserAction		userLogin	formId = "+formId+";entryId = "+entryId);
		String loginName = userVO.getLoginName();
		System.out.println(loginName);
		return "success";
	}
	public String userLogin() {
		logger.info("UserAction		userLogin	begin");
		logger.info("===========================UserAction		userLogin	formId = "+formId+";entryId = "+entryId);
		try{
			if(("administrator").equals(userVO.getLoginName())&&(MeetingAppConfig.PWDINITADMIN).equals(userVO.getPassWord())){
				request.getSession().setAttribute(UserEnum.USER_SESSION_ID, userVO);
				return "CONFIGURATION";
			}
			logger.info("授权日期："+MeetingAppConfig.authorization_date);
			
			if(MeetingAppConfig.authorization_date!=null&&MeetingAppConfig.authorization_date.before(new Timestamp(System.currentTimeMillis()))){
				info = "授权到期";
				return "fail";
			}
			logger.info("拥有软件授权");
			
			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_LOGIN);
			vLogVO.setUserIP(request.getRemoteHost());
			vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
			vLogVO.setUserName(userVO.getLoginName());
			
			if(StringUtils.isNullOrBlank(userVO.getLoginName()) || StringUtils.isNullOrBlank(userVO.getPassWord())){
				logger.info("登录名或者密码为空，退出");
				return "HOME_PAGE";
			}
			
			
			UserServiceImpl userService = new UserServiceImpl();
			UserVO reUserVO = new UserVO();
			List<UserVO> userList = userService.getUserListbyName(userVO, null);
			UserVO vo1 = new UserVO();
			if(userList != null && userList.size() > 0){
				reUserVO = userList.get(0);
				vo1 = userList.get(0);
				vLogVO.setUserID(reUserVO.getUserID());
				if (reUserVO.getState().intValue() == UserEnum.lock) {
					logger.info("用户被锁定");
					long xMinute = 60*1000*MeetingAppConfig.PWDUNLOCKTIMES;//xx分钟的毫秒数
					long lastLoginTime = vo1.getLastLoginTime().getTime();
					long currentTime = System.currentTimeMillis();
					if(xMinute+lastLoginTime < currentTime){
						logger.info("锁定后第一次登录");
						vo1.setState(UserEnum.VALID);
						vo1.setErrorTimes(0);//初始化登陆错误次数为0
						vo1.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
						userService.modifyUser(vo1, null);
					}else{
						logger.info("锁定后再登录");
						int lockTime = (int)Math.floor((xMinute+lastLoginTime-currentTime)/60000);
						if(lockTime==0){
							lockTime = 1;
						}
						info = "用户已锁定，请于"+lockTime+"分钟后重试";
						vLogVO.setOperatorContent(userVO.getLoginName() + info);
						vLogVO.setLogType(LogEnum.TYPE_INFORMATION);
						vLogVO.setUserID(userVO.getUserID());
//						ServiceFactory.getLogService().add(vLogVO);
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						logger.info("UserAction		userLogin	end ");
						request.setAttribute("errorMsg", info);
						return "fail";
					}
				}
				//if(!userVO.getLoginName().equals(UserEnum.SUPER_ADMIN) && MeetingAppConfig.LDAP_VALID.equals(MeetingAppConfig.LDAP_VALID_TEXT)){
				if(reUserVO.getAuthenticateType() == UserEnum.CENTRAL_AUTHENTICATE){	
					logger.info("AD域集中验证");
					LDAPUtil util = new LDAPUtil(MeetingAppConfig.LDAP_IP, MeetingAppConfig.LDAP_PORT);
					boolean isSuccessful = util.authenticate(reUserVO.getEmail(), userVO.getPassWord());
					if(!isSuccessful){
						reUserVO = null;
					}
				}else{
					logger.info("ICMP系统验证");
					userVO.setPassWord(MD5.GetMD5Code2(userVO.getPassWord()));// 加密
					reUserVO = userService.userLogin(userVO);
				}
			}else{
				info = "用户名不存在或没有权限";
				logger.info("UserAction		userLogin	end ");
				request.setAttribute("errorMsg", info);
				return "fail";
			}
			
			if (reUserVO == null) {
				info = "密码错误";
				if("true".equals(MeetingAppConfig.PWDAUTH)){
					if(vo1.getErrorTimes()<4&&vo1.getErrorTimes()>=0){
						vo1.setErrorTimes(vo1.getErrorTimes()+1);
						info = "密码错误"+vo1.getErrorTimes()+"次，错误5次将锁定用户";
					}else if(vo1.getErrorTimes()>=4){
						vo1.setState(UserEnum.lock);
						vo1.setErrorTimes(5);
						info = "用户已锁定，请于"+MeetingAppConfig.PWDUNLOCKTIMES+"分钟后重试";
					}else{
						vo1.setErrorTimes(1);
						info = "密码错误"+vo1.getErrorTimes()+"次，错误5次将锁定用户";
					}
					vo1.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
					userService.modifyUser(vo1, null);
				}
				
				vLogVO.setOperatorContent(userVO.getLoginName() + info);
				vLogVO.setLogType(LogEnum.TYPE_INFORMATION);
				vLogVO.setUserID(userVO.getUserID());
				LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
				logger.info("UserAction		userLogin	end ");
				request.setAttribute("errorMsg", info);
				return "fail";
			}
			
			if (reUserVO.getState().intValue() == UserEnum.INVALID) {
				info = "用户名已失效";
				logger.info("UserAction		userLogin	end ");
				vLogVO.setOperatorContent(userVO.getLoginName() + info);
				//ServiceFactory.getLogService().add(vLogVO);
				return REQUEST_FAILURE;
			}
			
			if(reUserVO!=null&&reUserVO.getLoginName()!=null){
				//第一次登陆时强行修改密码的判断
				if(!MeetingAppConfig.LDAP_VALID.equals(MeetingAppConfig.LDAP_VALID_TEXT) && reUserVO.getLastLoginTime()==null){
					dispatherType = 1;
				}
				
				//口令（登录密码）鉴别：定期更换口令、更换周期不得长于一周(7天)
				if("true".equals(MeetingAppConfig.PWDAUTH)){
					if(reUserVO.getChangePwdTime()==null){
						dispatherType = 1;
					}else{
						long oneWeek = 60*1000*60*24*7;//一周7天的毫秒数
						long changePwdTime = reUserVO.getChangePwdTime().getTime();
						long currentTime = System.currentTimeMillis();
						if(oneWeek+changePwdTime < currentTime){
							dispatherType = 1;
						}
					}
				}

               /*///////////////  添加分级分权管理 author:zhangjy/////////////////////   */
				if(MeetingAppConfig.LEVEL_IS_POEN){
					LevelConfigServiceImpl lcsi=new LevelConfigServiceImpl();
					LevelConfigVO levelConfigVO=new LevelConfigVO();
					levelConfigVO.setLevelType(LevelEnum.LEVEL_USER);
					levelConfigVO.setStatus(LevelEnum.STATUS_LEVELCONFIG_VALID);
					levelConfigVO.setLevelKey(reUserVO.getUserID());
					List<LevelConfigVO> lcvoList=lcsi.query(levelConfigVO, null);
					if(lcvoList.size()<1){
						info = "用户没有分级授权";
						return "fail";
					}else{
						//给用户一个默认的分级levelVO,应付中建材一对一的分级关系，为了能添加会议室给个默认的分级
						reUserVO.setLevelConfigVO(lcvoList.get(0));
						
						Set<String> liSet=new HashSet<String>();
						LevelServiceImpl lsi=new LevelServiceImpl();
						for(LevelConfigVO tempLV:lcvoList){
							if(!(MeetingAppConfig.HOST_LEVEL_ID.equals("-1"))){
								if(!(tempLV.getLevelID().equals(MeetingAppConfig.HOST_LEVEL_ID))){
									continue;	
								}
							}
							if(tempLV.getSuperPower()==LevelEnum.LEVELCONFIG_SUPERPOWER){//是否向下兼容
								if(tempLV.getLevelID().equals(DateBaseEnum.Default_ID)){
									liSet.add(LevelEnum.IS_LEVEL_FATHER);
								}
								List<LevelVO> lvList=lsi.queryInLevelPath(tempLV.getLevelID());
								
								for(LevelVO lvo:lvList){
									liSet.add(lvo.getLevelID());
								}
							}else{
								liSet.add(tempLV.getLevelID());	
							}
						}
						StringBuffer lidsb=new StringBuffer();
						if(liSet.size()==0){
							info = "无效用户";
							return "fail";
						}
						for(String str:liSet){
							lidsb.append("'"+str+"',");
						}
						String lids=lidsb.toString();
						lids=lids.toString().substring(0, lids.length()-1);
						reUserVO.setLvoids(lids);
						reUserVO.setOpenlevel(true);
					}
				}else{
				    reUserVO.setLvoids("zzst_radc");
				    reUserVO.setOpenlevel(false);
				}
			////////////////////////////////////end//////////////////////////////////////	
				reUserVO.setErrorTimes(0);//初始化登陆错误次数为0
				reUserVO.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				userService.modifyUser(reUserVO,null);
				//添加日志
				vLogVO.setOperatorContent(userVO.getLoginName() + "登录成功");
				vLogVO.setUserID(reUserVO.getUserID());
//				ServiceFactory.getLogService().add(vLogVO);
				LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
	//			reUserVO.setPassWord(DES.decryptPassword(reUserVO.getPassWord()));// 解密
				
//				List<FuncVO> fList = ServiceFactory.getFuncService().query(null, null);
//				request.getSession().setAttribute(UserEnum.USER_FUNC_SESSION_ID, fList);
				request.getSession().setAttribute(UserEnum.USER_SESSION_ID, reUserVO);
				
				return this.REQUEST_SUCCESS;
			}
		}catch(Exception e){
			logger.error("UserAction		userLogin	error:  "+e.getMessage());
			return this.REQUEST_FAILURE;
		}
		logger.info("UserAction		userLogin	end");
		return this.REQUEST_SUCCESS;
	}
	
    //query role before add
	public String beforeAdd() {
		logger.info("UserAction		beforeAdd	begin");
		try {
			RoleService roleService = new RoleServiceImpl();
			roleVOList = roleService.getRoleList(null, null);
			postVOList = ServiceFactory.getPostService().query(null, null);
		} catch (Exception e) {
			request.setAttribute("info", "添加用户失败");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("UserAction		beforeAdd	end");
		return this.REQUEST_SUCCESS;
	}
	//add user
	public String addUser() {
		logger.info("UserAction		addUser	begin");
		TransactionManager tManager = null;
		try {
			if(checkToken()){
				request.setAttribute("info", "请不要重复提交");
				return INVALID_TOKEN;
			}
			tManager = new TransactionManager();
			tManager.beginTransaction();
			userVO.setState(UserEnum.VALID);
			UserService userService = new UserServiceImpl();
			userVO.setPassWord(MD5.GetMD5Code2(userVO.getPassWord()));
			userVO = userService.addUser(userVO,tManager);
			
//			userVO = userService.getUserInfo(userVO,tManager);
			userDepartmentVO.setUserVO(userVO);
			//department
			UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
			userDepartmentService.addUserDepartment(userDepartmentVO, tManager);
			if(MeetingAppConfig.PWDAUTH.equals("false")){
			userRoleVO.setUserID(userVO.getUserID());
			//userRoleVO.setUserName(userVO.getName());
			//role
			ArrayList<UserRoleVO> urlist = new ArrayList<UserRoleVO>();
			urlist.add(userRoleVO);
			UserRoleService userRoleService = new UserRoleServiceImpl();
			userRoleService.addUserRole(urlist, tManager);
			}
			//岗位
			UserPostService userPostService = new UserPostServiceImpl();
			userPostVO.setUserID(userVO.getUserID());
			userPostService.add(userPostVO);
			
			//默认分级的添加
			if(MeetingAppConfig.LEVEL_IS_POEN){
				LevelConfigVO levelConfigVO = new LevelConfigVO();
				UserVO usersessionVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
				if(!usersessionVO.getUserID().equals(DateBaseEnum.Default_ID)){
				if(usersessionVO.getLevelConfigVO()!=null){
					levelConfigVO.setLevelID(usersessionVO.getLevelConfigVO().getLevelID());
					levelConfigVO.setLevelKey(userVO.getUserID());
					levelConfigVO.setLevelType(LevelEnum.LEVEL_USER);
					levelConfigVO.setSuperPower(usersessionVO.getLevelConfigVO().getSuperPower());
					levelConfigVO.setCreateUserId(usersessionVO.getUserID());
					levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					LevelConfigAction.levelConfigDefaultAdd(levelConfigVO);
				}
				}
			}
			
			//back to add page
			request.setAttribute("retMsg", "已成功添加用户:" + userVO.getName() );
			request.setAttribute("returl", "/icmp/user/beforeAdd.action");
			
			tManager.commit();
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("添加用户:"+userVO.getName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
		} catch (Exception e) {
			request.setAttribute("info", "添加用户失败");
			logger.error(e.getMessage());
			if(tManager!=null){
				 tManager.rollback();
			}
			return REQUEST_FAILURE;
		}finally{
			if(tManager!=null){
				 tManager.endTransaction();
			}
		}
		
		logger.info("UserAction		addUser	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * list users;
	 * @return
	 */
	public String manageUserList(){
		logger.info("UserAction		userList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			
			userVO.setState(UserEnum.VALID);	
			///////////////////////////////////level@author:zhangjy/////////////////
			UserVO pUserVO = (UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(pUserVO.getOpenlevel()){
				if(!(pUserVO.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
					userVO.setOpenlevel(pUserVO.getOpenlevel());
					userVO.setLvoids(lcs.queryByTypeAndLid(pUserVO.getLvoids(),LevelEnum.LEVEL_USER));
				}
			}
			////////////////////////////////////////////////////////////////////////
			UserService userService = new UserServiceImpl();
	        
			userList = userService.getUserList(userVO, pSplittor.getPControler());
			request.setAttribute("userList",userList);
		
		}catch(Exception e){
			request.setAttribute("info", "获取用户列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("UserAction		userList	end");	
		return this.REQUEST_SUCCESS;
	}
	/**
	 * edit a user
	 */
		public String getUserInfo(){
			logger.info("UserAction  getUserinfo	begin");
			try{
				UserService userService = new UserServiceImpl();
				userVO = userService.getUserInfo(userVO,null);
				
				UserRoleService userRoleService = new UserRoleServiceImpl();
				userRoleVO.setUserID(userVO.getUserID());
				ArrayList<UserRoleVO> userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
				if(userRoleVOList != null && userRoleVOList.size() > 0){
					userRoleVO = userRoleVOList.get(0);
				}
				RoleService roleService = new RoleServiceImpl();
				roleVOList = roleService.getRoleList(null, null);
				postVOList = ServiceFactory.getPostService().query(null, null);
				UserPostService userPostService = new UserPostServiceImpl();
				userPostVO = userPostService.queryByID(userVO.getUserID());
				
				userVO.setPassWord(userVO.getPassWord());//解密
			}catch(Exception e){
				request.setAttribute("info", "获取用户信息时发生异常！");
				logger.error(e.getMessage());
				return REQUEST_FAILURE;
			}
			
			logger.info("UserAction		getUserinfo	end");
			return REQUEST_SUCCESS;
		}
		/**
		 * view a user
		 */
			public String detail(){
				logger.info("UserAction  detail	begin");
				try{
					UserService userService = new UserServiceImpl();
					userVO = userService.getUserInfo(userVO,null);
					
					UserRoleService userRoleService = new UserRoleServiceImpl();
					userRoleVO.setUserID(userVO.getUserID());
					ArrayList<UserRoleVO> userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
					if(userRoleVOList != null && userRoleVOList.size() > 0){
						userRoleVO = userRoleVOList.get(0);
					}
					RoleService roleService = new RoleServiceImpl();
					roleVOList = roleService.getRoleList(null, null);
					for(int i=0;i<roleVOList.size();i++ )
					{
						RoleVO role = roleVOList.get(i);
						if(role.getRoleID().equalsIgnoreCase(userRoleVO.getRoleID()))
						{
							userRoleVO.setRoleName(role.getRoleName());
							break;
						}
					}
					
					userVO.setPassWord(userVO.getPassWord());//解密
				}catch(Exception e){
					request.setAttribute("info", "获取用户信息时发生异常！");
					logger.error(e.getMessage());
					return REQUEST_FAILURE;
				}
				
				logger.info("UserAction		detail	end");
				return REQUEST_SUCCESS;
			}
		
		//add by yangyi
		/**
		 * get user's passWord
		 * @return
		 */
		public String getUserBaseInfo(){
		//取出session中的用户信息
			Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			
			if(pUserVO == null){
				return "failed";
			}else{
				UserVO userVO1 = (UserVO)pUserVO;
				try {
					UserService userService = new UserServiceImpl();
					userVO.setUserID(userVO1.getUserID());
					ArrayList<UserVO> list = userService.getUserList(userVO, null);
					if(list.size()!=1){
						return "failed";
					}
					userVO = list.get(0);
					userVO.setPassWord(userVO.getPassWord());
					UserRoleService userRoleService = new UserRoleServiceImpl();
					userRoleVO.setUserID(userVO.getUserID());
					ArrayList<UserRoleVO> userRoleVOList;
					
						userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
						if(userRoleVOList != null && userRoleVOList.size() > 0){
							userRoleVO = userRoleVOList.get(0);
						}
						RoleService roleService = new RoleServiceImpl();
						roleVOList = roleService.getRoleList(null, null);
					} catch (SQLException e) {
						request.setAttribute("info", "获取用户信息时发生异常！");
						logger.error(e.getMessage());
						return "failed";
					}
					return "success";
				}
		}
		
		
		
		/**
		 * modify a user
		 * @return
		 */
		public String modifyUser(){
			logger.info("UserAction		modifyUser	begin");
			try{
				userVO.setPassWord(userVO.getPassWord());
				userVO.setState(UserEnum.VALID);
				userVO.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				
				UserService userService = new UserServiceImpl();
				userService.modifyUser(userVO,null);
				
				userDepartmentVO.setUserVO(userVO);

				UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
				userDepartmentService.modifyUserDepartment(userDepartmentVO, null);
				if(MeetingAppConfig.PWDAUTH.equals("false")){
				userRoleVO.setUserID(userVO.getUserID());
			//	userRoleVO.setUserName(userVO.getName());
				userVO.getUserRoleVOList().add(userRoleVO);
				UserRoleService userRoleService = new UserRoleServiceImpl();
			//	userRoleService.modifyUserRole(userRoleVO, null);
				userRoleService.modifyUserRole(userVO, null);
				}
				//岗位
				UserPostService userPostService = new UserPostServiceImpl();
				userPostVO.setUserID(userVO.getUserID());
				if(userPostService.queryByID(userVO.getUserID())==null){
					userPostService.add(userPostVO);
				}else{
					userPostService.modify(userPostVO);
				}
				UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
				LogUtil.addLogForOperate("修改用户:"+userVO.getName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
			
			}catch(Exception e){
				request.setAttribute("info", "修改用户信息时发生异常！");
				logger.error(e.getMessage());
				return REQUEST_FAILURE;
			}
			
			logger.info("UserAction		modifyUser	end");
			return REQUEST_SUCCESS;
		}
	
		/**
		 * 用户自己修改密码
		 * @return
		 */
		public String modifyUserPassword(){
			logger.info("UserAction		modifyUserPassword	begin");
			try{
				UserService userService = new UserServiceImpl();
				UserVO userVO1 = new UserVO();
				userVO1.setUserID(userVO.getUserID());
				ArrayList<UserVO> list = userService.getUserList(userVO1, null);
				if(list.size()!=1){
					return REQUEST_FAILURE;
				}
				userVO1 = list.get(0);
				userVO1.setPassWord(MD5.GetMD5Code2(userVO.getPassWord()));
				userVO1.setChangePwdTime(new Timestamp(System.currentTimeMillis()));
				userService.modifyUser(userVO1,null);
				
				//添加日志
				LogVO vLogVO = new LogVO();
				vLogVO.setLogType(LogEnum.TYPE_CYCLE);
				vLogVO.setUserIP(request.getRemoteHost());
				vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
				vLogVO.setUserName(userVO1.getLoginName());
				
				vLogVO.setOperatorContent(userVO1.getLoginName() + "修改密码成功");
				vLogVO.setUserID(userVO1.getUserID());
//				ServiceFactory.getLogService().add(vLogVO);
				LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
			}catch(Exception e){
				request.setAttribute("info", "修改用户密码时发生异常！");
				logger.error(e.getMessage());
				return REQUEST_FAILURE;
			}
			
			logger.info("UserAction		modifyUserPassword	end");
			return REQUEST_SUCCESS;
		}	
		
	/**
	 * list users;
	 * @return
	 */
	public String dellUserForState(){
		logger.info("UserAction		dellUserForState	begin");
		try{
			UserService userService = new UserServiceImpl();
			UserVO u = new UserVO();
		
			u.setUserID(userVO.getUserID());
			u.setState(UserEnum.INVALID);
			
			userService.delUserForState(u,null);
			u=userService.getUserList(u, null).get(0);
			//	list();
		
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("删除用户:"+u.getName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
		
		}catch(Exception e){
			request.setAttribute("info", "删除用户时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("UserAction		dellUserForState	end");
		return REQUEST_SUCCESS;
	}
	/**
	 * 重置用户密码add by liujf 20131219
	 * @return
	 */
	public String setPassword(){
		logger.info("UserAction		setPassword	begin");
		try{
			UserService userService = new UserServiceImpl();
			userVO = userService.getUserInfo(userVO,null);
			
			UserRoleService userRoleService = new UserRoleServiceImpl();
			userRoleVO.setUserID(userVO.getUserID());
			ArrayList<UserRoleVO> userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
			if(userRoleVOList != null && userRoleVOList.size() > 0){
				userRoleVO = userRoleVOList.get(0);
			}
			RoleService roleService = new RoleServiceImpl();
			roleVOList = roleService.getRoleList(null, null);
			for(int i=0;i<roleVOList.size();i++ )
			{
				RoleVO role = roleVOList.get(i);
				if(role.getRoleID().equalsIgnoreCase(userRoleVO.getRoleID()))
				{
					userRoleVO.setRoleName(role.getRoleName());
					break;
				}
			}
			
			userVO.setPassWord(MD5.GetMD5Code2(MeetingAppConfig.PWDINIT));
			userService.modifyUser(userVO,null);
			UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			LogUtil.addLogForOperate("重置密码:"+userVO.getName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
		
			//	list();
		
			
		}catch(Exception e){
			request.setAttribute("info", "重置用户密码时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("UserAction		setPassword	end");
		return REQUEST_SUCCESS;
	}
	/**
	 * 
	 * @param departmentID
	 * @return
	 */
	public ArrayList<UserVO> getUserListByDepartmentID(String departmentID){
		UserService userService = new UserServiceImpl();
		ArrayList<UserVO> list_user = new ArrayList<UserVO>();
		try {
			UserVO userVO = new UserVO();
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setId(departmentID);
			userVO.setDepartmentVO(departmentVO);
			userVO.setState(UserEnum.VALID);
			list_user = userService.getUserList(userVO, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_user;
	}
	
	/**
	 * delect by ryan on 2012-01-18
	 * @return
	 */
	public String getFunTree(){
		//菜单初始化
		//查询全部功能
		try {
			String parentID = request.getParameter("parentID");
			ArrayList<FuncVO> lst_fun = FuncDAO.getFuncList(null, null);

			for(int i=0;i<lst_fun.size();i++){
				FuncVO fv = lst_fun.get(i);
				//if(String.valueOf(fv.getParent_id()).equals(parentID)){
				if(fv.getParent_id().equals(parentID)){
					treelist = userVO.getFuncVOList();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return REQUEST_SUCCESS;
	}
	
	/**
	 * modify by ryan on 2012-01-18
	 * @param parentID
	 * @return
	 */
	public ArrayList<FuncVO> getFunTreeByID(String parentID){
		//菜单初始化
		ArrayList<FuncVO> reList = new ArrayList<FuncVO>();
		try {
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 

			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if(userVO!=null){
				ArrayList<FuncVO> lst_fun = userVO.getFuncVOList(); //FuncDAO.getFuncList(null, null);
				for(int i=0;i<lst_fun.size();i++){
					FuncVO fv = lst_fun.get(i);
					if(fv.getParent_id().equals(parentID)){
						reList.add(fv);
					}
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("UserAction		getFunTreeByID		end");
		return reList;
	}
	// addby duting
	//第一次登陆强制修改密码--获得信息
	public String getUserBaseInfoFirst(){
		//取出session中的用户信息
		Object pUserVO = request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
		
		if(pUserVO == null){
			return "failed";
		}else{
			userVO = (UserVO)pUserVO;
			UserRoleService userRoleService = new UserRoleServiceImpl();
			userRoleVO.setUserID(userVO.getUserID());
			ArrayList<UserRoleVO> userRoleVOList;
			try {
				userRoleVOList = userRoleService.getUserRoleList(userRoleVO, null);
				if(userRoleVOList != null && userRoleVOList.size() > 0){
					userRoleVO = userRoleVOList.get(0);
				}
				RoleService roleService = new RoleServiceImpl();
				roleVOList = roleService.getRoleList(null, null);
				UserVO uv=(UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
				LogUtil.addLogForOperate("第一次修改密码:"+userVO.getName(), uv.getUserID(), "", LogEnum.TYPE_DB, 1);
			    
			} catch (SQLException e) {
				request.setAttribute("info", "获取用户信息时发生异常！");
				logger.error(e.getMessage());
				return "failed";
			}
			return "success";
		}
	}
	//第一次登陆强制修改密码
	public boolean modifyPasswordFirst(String userId,String passWordNew){
		try{
			UserService userService = new UserServiceImpl();
			UserVO userVO1 = new UserVO();
			userVO1.setUserID(userId);
			ArrayList<UserVO> list = userService.getUserList(userVO1, null);
			if(list.size()!=1){
				return false;
			}
			userVO1 = list.get(0);
			
			userVO1.setPassWord(MD5.GetMD5Code2(passWordNew));
			userVO1.setChangePwdTime(new Timestamp(System.currentTimeMillis()));//修改密码时间
			//userVO1.setPassWord(DES.decryptPassword(userVO1.getPassWord()));// 解密
			
			//userVO1.setPassWord(DES.encryptPassword(userVO1.getPassWord()));
			userService.modifyUser(userVO1,null);
			System.out.println(userVO1.getPassWord());
			
			//添加日志
			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_CYCLE);
//			vLogVO.setUserIP(request.getRemoteHost());
			vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
			vLogVO.setUserName(userVO1.getLoginName());
			
			vLogVO.setOperatorContent(userVO1.getLoginName() + "修改密码成功");
			vLogVO.setUserID(userId);
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	//addby duting
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery(){
		logger.info("LoginAction	exportQuery	begin");
		try{
			userVO.setState(UserEnum.VALID);						
			userList = ServiceFactory.getUserService().getUserList(userVO, null);
			String fileName = "user.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(userList!=null&&userList.size()>0){
				
				for (int i = 0; i < userList.size(); i++) {
					UserVO uVO = userList.get(i);
					CellVO[] cell = new CellVO[5];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(uVO.getLoginName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(uVO.getName());
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(uVO.getDepartmentVO().getTitle());
					cell[3] = ex3;
					
//					CellVO ex4 = new CellVO();
//					String roleName = "";
//					ArrayList<UserRoleVO> listRole = uVO.getUserRoleVOList();
//					for(int j=0;j<listRole.size();j++){
//						roleName +=listRole.get(j).getRoleName();
//					}
//					ex4.setValue(roleName);
//					cell[4] = ex4;
					
					list.add(cell);
					
				}
				
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);// ByteArrayInputStream(excelString.getBytes(), 0, excelString.length());
		}catch(Exception e){
			logger.error("LoginAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	exportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[5];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("用户名");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("姓名");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("部门");
		cellTitle[3] = ex0;
//		ex0 = new CellVO();
//		ex0.setValue("角色");
//		cellTitle[4] = ex0;
		list.add(cellTitle);
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

	public int getDispatherType() {
		return dispatherType;
	}

	public void setDispatherType(int dispatherType) {
		this.dispatherType = dispatherType;
	}

	public List<PostVO> getPostVOList() {
		return postVOList;
	}

	public void setPostVOList(List<PostVO> postVOList) {
		this.postVOList = postVOList;
	}

	public UserPostVO getUserPostVO() {
		return userPostVO;
	}
	
	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public void setUserPostVO(UserPostVO userPostVO) {
		this.userPostVO = userPostVO;
	}
	
}
