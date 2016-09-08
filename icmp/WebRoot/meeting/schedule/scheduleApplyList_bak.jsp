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
    <title>领导日程录入</title>
    
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
  <div align="center" style="text-align: center;">
    	<table width="98%;" border="0">
    		<tr>
    			<td align="left">
    				日期：<select>
						<option>2016年8月第一周</option>
						<option>2016年8月第二周</option>
						<option>2016年8月第三周</option>
						<option>2016年8月第四周</option>
		 			</select>
    			</td>
    			<td align="right">
    				<button class="stdbtn mlr10">查询</button>
    			</td>
    		</tr>
    		<tr>
    		  <td align="left">
    			<button class="stdbtn mlr10">已完成安排</button>
    			<button class="stdbtn mlr10">未完成安排</button>
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
		  <c:forEach begin="1" step="1" end="7" varStatus="state">
		  	<tr>
		  		<td>${state.index}</td>
		  		<td>2016年8月第四周</td>
	  			<td>张三</td>
	  			<td>2016/8/22 11:47</td>
	  			<td>未审批</td>
	  			<td>查看详情|修改</td>
	  		</tr>
		  	
		  	</c:forEach>
			<%-- <c:forEach items="${meetingRoomVOList}" var="meetingRoomVO" varStatus="state">
				<tr>
					<td class="alc">
						<c:out value="${state.index+1}"></c:out>
					</td>
					<td>
						<c:out value="${meetingRoomVO.meetingRoomName }" />
					</td>
					<td>
						<zzst:lable type="meetingRoomType" value="${meetingRoomVO.meetingRoomType}"></zzst:lable>
					</td>
					<td>
						<c:out value="${meetingRoomVO.addressVO.name}" />
					</td>
					<td >
						<c:out value="${meetingRoomVO.departmentVO.title}" />
					</td>
					<td class="alc">
						<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:meetingRoomDetail('${meetingRoomVO.meetingRoomID}');"/>查看   
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:meetingRoomModify('${meetingRoomVO.meetingRoomID}');" />修改   
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:meetingRoomDele('${meetingRoomVO.meetingRoomID}');"/> 删除    
						<a class="funcOper <%= FuncEnum.FUNC_NO_COPY%>" onclick="javascript:meetingRoomCopy('${meetingRoomVO.meetingRoomID}');"/> 复制
					</td>
				</tr>
			</c:forEach> --%>
		 </tbody>
	  </table>
	  页码，有动态数据之后添加
	  <%-- <jsp:include page="/common/pageFooter.jsp" /> --%>
  </div>
  </body>
</html>
