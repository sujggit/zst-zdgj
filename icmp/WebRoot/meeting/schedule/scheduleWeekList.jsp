<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file="/common/common.jsp"%>
    <title>领导日程查询</title>
    
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
			margin: 5px;
		}
	</style>
  </head>
  
  <body>
    <h3 style="color: #486494; font-family: 微软雅黑;">&nbsp;会议日程安排查询</h3>
    <br>
    <hr size="2px;">
    <div align="right">${scheduleVOList[0].scheduleTime }&nbsp;领导：${scheduleVOList[0].leaderName }</div>
  <div align="center" style="text-align: center;">
  	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="12%" class="head1">时间</th>
            <th width="14%" class="head1">工作安排</th>
            <th width="14%" class="head1">参加大会名称</th>
            <th width="10%" class="head1">会议室</th>
            <th width="13%" class="head1">会议时间</th>
            <th width="12%" class="head1">是否列入大事记</th>
            <th width="25%" class="head1">备注</th>
          </tr>
        </thead>
		<tbody>
		  <c:forEach items="${scheduleVOList }" var="schedule" varStatus="state">
		  	<tr>
		  		<td>${schedule.weekTime }</td>
	  			<td>${schedule.workName }</td>
	  			<td>${schedule.meetingName }</td>
	  			<td>${schedule.roomName }</td>
	  			<td><fmt:formatDate value="${schedule.startTime }" pattern="HH:mm"/>
	  				<c:if test="${schedule.startTime!=null }">-</c:if>
	  				<fmt:formatDate value="${schedule.endTime }" pattern="HH:mm"/></td>
	  			<td><c:if test="${schedule.isEvent==1 }">是</c:if>
	  				<c:if test="${schedule.isEvent==0 }">否</c:if>
	  			</td>
	  			<td>${schedule.mark }</td>
	  		</tr>
		  	
		  	</c:forEach>
			
		 </tbody>
	  </table>
	  <!-- 已经审批的带上审批历史  !=null -->
	  <c:if test="${scheduleVOList[0].applyPeopleId!=null&&scheduleVOList[0].applyPeopleId!='' }">
	  	<div align="center">
		  审批信息
	  	<table cellpadding="0" cellspacing="0" border="1" style="width: 60%;color: #3A5066;">
	        <thead>
	          <tr>
	            <th width="12%" class="head1">审批人</th>
	            <th width="14%" class="head1">审批结果</th>
	            <th width="14%" class="head1">审批备注</th>
	          </tr>
	        </thead>
			<tbody>
			  <tr>
				<td>${scheduleVOList[0].applyPeople }</td>
				<td>${scheduleVOList[0].applyTime }</td>
				<td>${scheduleVOList[0].applysug }</td>
			  </tr>
			 </tbody>
		  </table>
	    </div>
	  </c:if>
	  
	  <!-- 页码，有动态数据之后添加 -->
	  <%-- <jsp:include page="/common/pageFooter.jsp" /> --%>
	  <button class="submit1" onclick="javascript:history.back(-1);">确定</button>
 	  <button class="submit1" onclick="javascript:history.back(-1);">取消</button>
  </div>
  </body>
</html>
