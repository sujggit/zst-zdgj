<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file="/common/common.jsp"%>
    <title>工作安排</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			margin: 15px;
		}
	</style>
	<script type="text/javascript">
		function query(){
		location.href="/icmp/scheduleWork/query.action";
		};
	</script>
  </head>
  
  <body>
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">工作安排增加</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="25%" class="tableaddtitle"><span>*</span>工作安排</td>
	          <td width="75%" class="tableadd_data" >${ScheduleWorkVO.workName }</td>
	        </tr>
	      </table>
	      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	        <tfoot>
	        </tfoot>
	        <tbody>
	          <tr>
	            <td>
	              <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="query();"/>
	            </td>
	          </tr>
	        </tbody>
	      </table>
  </body>
</html>
