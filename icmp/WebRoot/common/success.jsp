<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String returl = (String)request.getAttribute("returl"); 
	String retMsg = (String)request.getAttribute("retMsg");
	if(returl==null||"".equals(returl)){
		 returl = request.getParameter("returl");
		 retMsg = request.getParameter("retMsg");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <p>业务受理成功!<%=retMsg %></p>
  <%
		 if(!(returl==null||"".equals(returl))){
    	%>
	         <input type="button" class="btn-style2" value="返回" onclick="window.location.href='<%=returl %>';"/>&nbsp;
	        <%} %> 
			<input type="button" class="btn-style2" value="返回到首页" />
  </body>
</html>
