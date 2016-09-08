<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.action.meeting.util.DownUtil" %>
<%
String path = request.getParameter("url");
String type = request.getParameter("type");
DownUtil.download(path,type);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
   OK 
  </body>
</html>
