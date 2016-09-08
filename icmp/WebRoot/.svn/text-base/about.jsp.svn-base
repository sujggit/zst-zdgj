<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ page import="com.zzst.action.meeting.util.tools.SoftWareUtils" %>
<%@ page import="com.zzst.action.meeting.util.MeetingAppConfig" %>
<%@ page import="com.zzst.action.meeting.util.tools.SoftWareUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于</title>
</head>
<%
Calendar newD = Calendar.getInstance();

Calendar c = Calendar.getInstance();
if(MeetingAppConfig.authorization_date!=null)
	c.setTimeInMillis(MeetingAppConfig.authorization_date.getTime());
	
 %>
<body class="about">
<center>
<div class="about_divbg">
	<div class="about_titleHome"><h1 class="logo"><img src="style/normal/images/default/zst.png" />${sys_viewName }</h1></div>
	<div class="about_divline"></div>
	<div class="about_datadiv">软件版本：V2.0</div>
	<div class="about_datadiv">到期时间：
	<%
	int newYea = c.get(Calendar.YEAR)-newD.get(Calendar.YEAR);
	if(newYea>=10){
	%>
		已授权
	<%
	}else{
	%>
		<%=c.get(Calendar.YEAR) %>&nbsp;年&nbsp;<%=c.get(Calendar.MONTH)+1 %>&nbsp;月&nbsp;<%=c.get(Calendar.DAY_OF_MONTH) %>&nbsp;日
	<%
	}
	 %>
	
	
	</div>
	<div class="about_datadiv">激活码：<%=	SoftWareUtils.getCode() %></div>	

	<%--<div class="about_datadiv">联系电话：010-59220168</div>--%>
    <%--<div class="about_datadiv">支持邮箱：support@zzstworld.com</div>--%>
	<div class="about_copyright">Copyright&copy;2007-<%=newD.get(Calendar.YEAR) %>北京真视通科技股份有限公司 &nbsp;版权所有</div>
	<%--<div class="about_button">
    	<input type="reset" class="submit1 radius2" value="关 闭" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
    </div>--%>
</div>
</center>
</body>
</html>
