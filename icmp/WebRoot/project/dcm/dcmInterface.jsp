<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.zzst.model.meeting.user.UserVO" %>
<%@ page import="com.zzst.model.enums.UserEnum" %>
<%
String path = request.getParameter("jumpURL");
	System.out.println("跳转路径："+path);
UserVO vo = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
if(vo!=null){
	path = path+"&u="+vo.getLoginName();
	System.out.println("跳转路径:::："+path);
	response.sendRedirect(path);
}else{
	System.out.println("没有登陆");
}
%>