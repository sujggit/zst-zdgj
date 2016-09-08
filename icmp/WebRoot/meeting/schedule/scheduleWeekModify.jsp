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
		function meetingInfo(mvo,num){
			$("#meetingId_"+num).val(mvo.value.split("_")[0]);
			//alert(mvo.value);
			if(mvo.value!="0"){
				var strs = mvo.value.split("_");
				var id = strs[0];
				$("#meetingId_"+num).val(id);//修改隐藏域
				var room = strs[3];
				var temps = strs[1].split(" ")[1].split(".")[0].split(":");
				var tempe = strs[2].split(" ")[1].split(".")[0].split(":");
				var time = temps[0]+":"+temps[1]+"-"+tempe[0]+":"+tempe[1];
				$("#room_"+num).text(room);
				$("#time_"+num).text(time);
				return;
			}else{
				$("#room_"+num).text("");
				$("#time_"+num).text("");
				$("#meetingId_"+num).val("");//修改隐藏域
			}
		}
		function scheduleModify(){
			$("#modifyForm").attr("action","/icmp/schedule/scheduleModify.action");
			$("#modifyForm").submit();
		}
		function backHistory(){
        	window.location.href="${sys_ctx}/schedule/meetingScheduleQuery.action";
        }
	</script>
  </head>
  
  <body>
  <form id="modifyForm" action="" method="post">
    <h3 style="color: #486494; font-family: 微软雅黑;">&nbsp;会议日程安排查询</h3>
    <br>
    <hr size="2px;">
    <!-- 添加所需信息 -->
    <input type="hidden" value="${scheduleVOList[0].scheduleTime }">
    <input type="hidden" value="${scheduleVOList[0].leaderName }">
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
		  		<td>${schedule.weekTime }
		  			<input type="hidden" name="sv${state.index+1 }.scheduleId" value="${schedule.scheduleId }">
		  		</td>
	  			<td>
	  				<select style="width: 100%;" name="sv${state.index+1 }.workId">
	  					<option value="0" >请选择工作安排</option><!-- 未选择时，按0处理，对比会议的选择  -->
	  					<c:forEach items="${scheduleWorkVOList }" var="scheduleWorkVO">
	  						<option value="${scheduleWorkVO.workId }" <c:if test="${schedule.workId==scheduleWorkVO.workId }">selected="selected"</c:if> >${scheduleWorkVO.workName }</option>
	  					</c:forEach>
		  			</select>
	  			</td>
	  			<td>
	  				<input value="${schedule.meetingId }" id="meetingId_${state.index+1 }" name="sv${state.index+1 }.meetingId" type="hidden">
	  				<select style="width: 100%;" onchange="meetingInfo(this,${state.index+1 })">
	  					<option value="0" >选择大会</option>
	  					<c:forEach items="${meetingDetailVOList }" var="meetingDetailVO">
	  						<option <c:if test="${schedule.meetingId==meetingDetailVO.meetingDetailID }">selected="selected"</c:if> value="${meetingDetailVO.meetingDetailID }_${meetingDetailVO.meetingStartTime }_${meetingDetailVO.meetingEndTime }_${meetingDetailVO.meetingRoomName }">${meetingDetailVO.meetingName }</option>
	  					</c:forEach>
	  				</select>
	  			</td>
	  			<td id="room_${state.index+1 }">${schedule.roomName }</td>
	  			<td id="time_${state.index+1 }"><fmt:formatDate value="${schedule.startTime }" pattern="HH:mm"/>
	  				<c:if test="${schedule.startTime!=null }">-</c:if>
	  				<fmt:formatDate value="${schedule.endTime }" pattern="HH:mm"/></td>
	  			<td><c:if test="${schedule.isEvent==1 }">是</c:if>
	  				<c:if test="${schedule.isEvent==0 }">否</c:if>
	  				<select name="sv${state.index+1 }.isEvent">
	  					<option <c:if test="${schedule.isEvent==0 }">selected="selected"</c:if> value="0">否</option>
	  					<option <c:if test="${schedule.isEvent==1 }">selected="selected"</c:if> value="1">是</option>
	  				</select>
	  			</td>
	  			<td>
	  				<input value="${schedule.mark }" name="sv${state.index+1 }.mark" id="mark_${state.index+1 }" style="width: 98%;">
	  			</td>
	  		</tr>
		  	
		  	</c:forEach>
			
		 </tbody>
	  </table>
  </div>
  </form>
  <div align="center"><!-- 如果放到form里面，会产生重复提交的问题 -->
	  <button onclick="scheduleModify();" class="submit1 radius2">确定</button>
 	  <button class="reset1 radius2" onclick="javascript:history.back(-1);">取消</button>
  </div>
  </body>
</html>
