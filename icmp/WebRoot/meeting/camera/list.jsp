<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp" %>
<%@ page import="com.zzst.model.meeting.kst.Camera" %>
<%@ page import="com.zzst.model.meeting.kst.CameraGroup" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
ArrayList grouplist =(ArrayList) request.getAttribute("grouplist");
ArrayList clist =(ArrayList) request.getAttribute("clist");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设备管理查询页面</title>
		
		<script type="text/javascript">
	    function list(){
			document.pageform.submit();
		}
		
		function view(id){
		var url="http://10.6.22.202/Video.aspx?user=admin&system=ef7dd932-9a0a-4051-ae2c-2e1057f9eb21&camera=" + id+"&mode=3";
		location.href=url;
		}          
    
		</script>
</head>

 <frameset  rows="*" cols="20%,*" FRAMEBORDER="1" border="10"  >
	 <frame id="left"   name="left"  src="${sys_ctx}/camera/groupTree.action"  > </frame>
	 <frame id="frmright0" name="frmright0" src="${sys_ctx}/meeting/camera/welcome.jsp"  > </frame>
 </frameset>
</html>
