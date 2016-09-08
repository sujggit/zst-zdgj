<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.meeting.dwr.McuDwrMethod" %>
<%@ page import="java.net.URLDecoder" %>
<%
request.setCharacterEncoding("UTF-8");
String infos=request.getParameter("infos");
infos=URLDecoder.decode(infos,"UTF-8");
McuDwrMethod  mdm=new McuDwrMethod();
boolean ifsucc=mdm.setVideoScreenYJ(infos);
out.println("设置成功");

%>
