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
		function workAdd(){
			location.href="/icmp/meeting/schedule/work/workAdd.jsp";
		}
		function workDetail(id){
			location.href="/icmp/scheduleWork/queryOne.action?scheduleWorkVO.workId="+id;
		}
		function workModify(id){
			location.href="/icmp/scheduleWork/modifyBefore.action?scheduleWorkVO.workId="+id;
		}
		function workDelete(id){
			location.href="/icmp/scheduleWork/delete.action?scheduleWorkVO.workId="+id;
		}
	</script>
  </head>
  
  <body>
  <div class="contenttitle2">
          <h5 class="fwb fl10">工作安排维护列表</h5>
          <h5 class="fwb fr10"><a class="funcOper" style="cursor: pointer;" onclick="workAdd();" class="endLine">增加</a></h5>
  </div>
  <div align="center" style="text-align: center;">
  	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="10%" class="head1">序号</th>
            <th width="60%" class="head1">工作内容</th>
            <th width="30%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
		<tbody>
		  <c:forEach items="${scheduleWorkVOList }" var="scheduleWorkVO" varStatus="state">
		  	<tr>
		  		<td>${state.index+1}</td>
		  		<td>${scheduleWorkVO.workName }</td>
	  			<td class="alc">
						<a class="funcOper" onclick="javascript:workDetail('${scheduleWorkVO.workId}');">查看</a>|   
						<a class="funcOper" onclick="javascript:workModify('${scheduleWorkVO.workId}');">修改</a>|   
						<a class="funcOper" onclick="javascript:workDelete('${scheduleWorkVO.workId}');">删除 </a> 
				</td>
	  		</tr>
		  	
		  	</c:forEach>
		 </tbody>
	  </table>
	  <%-- <jsp:include page="/common/pageFooter.jsp" /> --%>
  </div>
  </body>
</html>
