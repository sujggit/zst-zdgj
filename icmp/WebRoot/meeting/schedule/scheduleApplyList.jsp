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
	<script type="text/javascript">
		function apply(){
			var a = $("input:radio:checked");//被选中的radio
			if(!a.val()){
				alert("选择审批意见！");
				return
			}
			$("#applySug").val(a.val());
			$("#suggest").val($("#sugArea").html());
			$("#scheduleId_1").val($("#id_1").val());
			$("#scheduleId_2").val($("#id_2").val());
			$("#scheduleId_3").val($("#id_3").val());
			$("#scheduleId_4").val($("#id_4").val());
			$("#scheduleId_5").val($("#id_5").val());
			$("#scheduleId_6").val($("#id_6").val());
			$("#scheduleId_7").val($("#id_7").val());
			$("#appForm").submit();
		}
	</script>
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
		  		<td>${schedule.weekTime }<input value="${schedule.scheduleId }" type="hidden" id="id_${state.index+1 }"></td>
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
	  </div>
	  <br>
	  <hr>
	  <table  width="90%">
	  	<tr>
	  		<td width="10%" style="text-align: right;">联络员：</td>
	  		<td width="10%">${scheduleVOList[0].fullName }</td>
	  		<td width="10%"></td>
	  		<td width="60%"></td>
	  	</tr>
	  	<tr>
	  		<td style="text-align: right;">审批：</td>
	  		<td><input type="radio" name="shenpi" value="1">同意</td>
	  		<td><input type="radio" name="shenpi" value="0">不同意</td>
	  	</tr>
	  	<tr>
	  		<td></td>
	  		<td colspan="3">
	  			<textarea rows="" cols="3" id="sugArea"></textarea>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td colspan="4" style="text-align: center;">
	  			<button class="submit1" onclick="javascript:apply();">审批</button>
 	  			<button class="submit1" onclick="javascript:history.back(-1);">取消</button>
	  		</td>
	  	</tr>
	  </table>
	  <!-- 提交用action 将相关数据放到此处提交 -->
	  <form action="/icmp/schedule/apply.action" id="appForm" method="post">
		  <input name="sv1.applyPeopleId" type="hidden" id="applyPeopleId" value="${sys_userSession.userID }"><!-- 审批人id -->
		  <input name="applySug" type="hidden" id="applySug" value=""><!-- 意见 1同意2不同意 -->
		  <input name="suggest" type="hidden" id="suggest" value=""><!-- 意见内容 -->
		  <input name="sv1.scheduleId" type="hidden" id="scheduleId_1" value="">
		  <input name="sv2.scheduleId" type="hidden" id="scheduleId_2" value="">
		  <input name="sv3.scheduleId" type="hidden" id="scheduleId_3" value="">
		  <input name="sv4.scheduleId" type="hidden" id="scheduleId_4" value="">
		  <input name="sv5.scheduleId" type="hidden" id="scheduleId_5" value="">
		  <input name="sv6.scheduleId" type="hidden" id="scheduleId_6" value="">
		  <input name="sv7.scheduleId" type="hidden" id="scheduleId_7" value="">
	  </form>
	  <!-- <div align="left">
	  	&nbsp;&nbsp;审批：<input id="applySug" name="applySug" type="radio" value="1">同意&nbsp;<input id="applySug" name="applySug" type="radio" value="0">不同意<br>
	  </div>
	  <div align="right">
		  <textarea rows="4" cols="" name="suggest"></textarea>&nbsp;&nbsp;<br>
	  </div> -->
	  
  
  </body>
</html>
