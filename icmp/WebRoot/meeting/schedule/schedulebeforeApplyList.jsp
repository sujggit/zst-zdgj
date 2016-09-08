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
	<script type="text/javascript">
		function scheduleDetail(scheduleTime,createTime){
			//window.location.href="?scheduleVO.scheduleTime="+scheduleTime+"&scheduleVO.createTime="+createTime;
			$("#scheduleTime").val(scheduleTime);
			$("#createTime").val(createTime);
			$("#subForm").attr("action","/icmp/schedule/scheduleQuery.action");
			$("#subForm").submit();
		}
		function apply(scheduleTime,createTime){
			$("#scheduleTime").val(scheduleTime);
			$("#createTime").val(createTime);
			$("#subForm").attr("action","/icmp/schedule/beforeApply.action");
			$("#subForm").submit();
		}
		function querySchedule(status){
			$("#status").val(status);
			$("#subForm").attr("action","/icmp/schedule/meetingScheduleQuery.action");
			$("#subForm").submit();
		}
	</script>
  </head>
  
  <body>
    <h3 style="color: #486494; font-family: 微软雅黑;">&nbsp;会议日程安排查询</h3>
    <br>
    <hr size="2px;">
    <form action="${sys_ctx }/schedule/toApply.action" id="pageform" name="pageform" method="post">
  <div align="center" style="text-align: center;">
    	<table width="98%;" border="0">
    		<tr>
    			<td align="left">
    				日期：<select>
						<c:forEach items="${scheduleVOList }" var="schedule" varStatus="state">
							<option>${schedule.scheduleTime }</option>
						</c:forEach>
		 			</select>
    			</td>
    			<td align="right">
    				<button class="stdbtn mlr10">查询</button>
    			</td>
    		</tr>
    		<tr>
    		  <td align="left">
    			<input type="button" class="stdbtn mlr10" onClick="javascript:querySchedule('${1}');" value="已完成安排"/>
    			<input type="button" class="stdbtn mlr10" onClick="javascript:querySchedule('${0}');" value="未完成安排"/>
    		  </td>
    		</tr>
    	</table>
  	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="9%" class="head1">序号</th>
            <th width="14%" class="head1">日期</th>
            <th width="14%" class="head1">联络员</th>
            <th width="17%" class="head1">提交时间</th>
            <th width="12%" class="head1">审批状态</th>
            <th width="25%" class="head1">操作</th>
          </tr>
        </thead>
		<tbody>
		  <c:forEach items="${scheduleVOList }" var="schedule" varStatus="state">
		  	<tr>
		  		<td>${state.index+1}</td>
		  		<td>${schedule.scheduleTime }</td>
	  			<td>${schedule.fullName }</td>
	  			<td>${schedule.createTime }</td>
	  			<td><c:if test="${schedule.status==1 }">已审批</c:if>
	  				<c:if test="${schedule.status==0 }">已审批，未通过</c:if>
	  				<c:if test="${schedule.status!=1&&schedule.status!=0 }">未审批</c:if>
	  			</td>
	  			<td>
	  				<a class="funcOper" onclick="javascript:scheduleDetail('${schedule.scheduleTime }','${schedule.createTime }');">查看详情</a><!-- | -->
	  				<%-- <a class="funcOper" onclick="javascript:meetingRoomDetail('${meetingRoomVO.meetingRoomID}');">修改</a> --%>
	  				<c:if test="${sys_userSession.userRoleVOList[0].roleID=='a'&&schedule.status!=1&&schedule.status!=0 }">|</c:if>
	  				<c:if test="${sys_userSession.userRoleVOList[0].roleID=='a'&&schedule.status!=1&&schedule.status!=0 }">
						<a class="funcOper" onclick="javascript:apply('${schedule.scheduleTime }','${schedule.createTime }');">审批</a>
					</c:if>
	  			</td>
	  		</tr>
		  	</c:forEach>
		 </tbody>
	  </table>
	  <!-- 页码，有动态数据之后添加 -->
	  <jsp:include page="/common/pageFooter.jsp" />
  </div>
  </form>
	  <!-- 查询方法用form表单 -->
	  <form action="" id="subForm" method="post">
    		<input type="hidden" name="scheduleVO.scheduleTime" id="scheduleTime">
    		<input type="hidden" name="createTime" id="createTime">
    		<input type="hidden" name="status" id="status">
      </form>
  </body>
</html>
