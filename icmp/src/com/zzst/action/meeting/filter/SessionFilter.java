/**
 * Created on 2005-9-23
 */
package com.zzst.action.meeting.filter;

/**
 * @author xdq
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.auth.FuncServiceImpl;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

public class SessionFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
	
    public SessionFilter() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    {
        try
        {
        	HttpServletRequest re = (HttpServletRequest)request;
        	HttpServletResponse rs = (HttpServletResponse)response;
        	HttpSession session = re.getSession();
        	String uid = (String) session.getAttribute("cn.com.hkgt.idp.client.filter.user");
        	String path = re.getServletPath();
        	
////        	授权过滤
//        	if(!MeetingAppConfig.authorizatione){
//        		re.setAttribute("info", "缺少授权，请联系系统管理员");
//        		re.setAttribute("authorizatione", "no");
//        		re.getRequestDispatcher("/index3.jsp").forward(re, rs);
//        	}
        	if(uid==null){
	        	if(path.equals("/about.jsp") ||path.equals("/main.jsp") || path.equals("/index3.jsp")||path.indexOf("/js")>=0||path.indexOf("style")>=0||path.indexOf("images")>=0||path.indexOf("/project/dcm/")>=0||path.indexOf("/user/userLoginSSO")>=0){
	        		filterChain.doFilter(re, rs);
	        	}else{
	            	
		        	
		        	UserVO vo = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		        	if(vo==null){
		        		if(path.indexOf("user/userLogin.action")>=0 ){
		        			filterChain.doFilter(re, rs);
		        		}else{
		        			re.getRequestDispatcher("/index3.jsp").forward(re, rs);
		        		}
		        	}else{
		        		if(vo.getLoginName().equals("administrator")){
		        			response.setContentType("text/html; charset=utf-8");
				            request.setCharacterEncoding("utf-8");
				            response.setCharacterEncoding("utf-8");
				            filterChain.doFilter(re, rs);
		        		}else{
			        		if(path.indexOf("user/userLogin.action")>=0 ){
			        			re.getRequestDispatcher("/layout/index.jsp").forward(re, rs);
			        		}else{
					        	response.setContentType("text/html; charset=utf-8");
					            request.setCharacterEncoding("utf-8");
					            response.setCharacterEncoding("utf-8");
					            filterChain.doFilter(re, rs);
			        		}
		        		}
		        	}
	        	}
        	}else{
        		UserService userservice = ServiceFactory.getUserService();
        		UserVO userVO = new UserVO();
        		UserVO userVO1 = new UserVO();
        		userVO.setUserID(uid);
				userVO1 = userservice.getUserInfo(userVO, null);
				if(userVO1 == null){
					re.setAttribute("failure_message", "用户不存在");
	        		re.getRequestDispatcher("/error/warning.jsp").forward(re, rs);
				}else{
					UserRoleVO userRoleVO = new UserRoleVO();
					userRoleVO.setUserID(userVO1.getUserID());
					
					ArrayList<UserRoleVO> roleList = new UserRoleServiceImpl().getUserRoleList(userRoleVO, null);

					if(roleList != null && roleList.size()>0){
						userVO1.setUserRoleVOList(roleList);
						
						//查询用户功能
						ArrayList<FuncVO> ulist = new FuncServiceImpl().getFuncList(userVO1, null);
						userVO1.setFuncVOList(ulist);
					}
					
					session.setAttribute(UserEnum.USER_SESSION_ID, userVO1);
	        		response.setContentType("text/html; charset=utf-8");
		            request.setCharacterEncoding("utf-8");
		            response.setCharacterEncoding("utf-8");
		            filterChain.doFilter(re, rs);
				}
        	}
        }
        catch(ServletException sEx)
        {
            //Log4j.log(com.dareway.servlet.EncodingFilter.class, Log4j.ERROR, "EncodingFilter\u6355\u83B7Servlet\u5F02\u5E38", sEx);
            Throwable cause = sEx.getRootCause();
            //if(cause != null) 
                //Log4j.log(com.dareway.servlet.EncodingFilter.class, Log4j.ERROR, "EncodingFilter\u6355\u83B7Servlet\u5F02\u5E38,\u6700\u7EC8\u5F02\u5E38\u4E3A", cause);
        }
        catch(IOException ioEx)
        {
            //Log4j.log(com.dareway.servlet.EncodingFilter.class, Log4j.ERROR, "EncodingFilter\u6355\u83B7IO\u5F02\u5E38", ioEx);
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void destroy()
    {
    }

    private FilterConfig filterConfig;
}
