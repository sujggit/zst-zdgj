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
    <title>大事记列表</title>
    
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
    <h3 style="color: #486494; font-family: 微软雅黑;">&nbsp;公司领导参加会议情况汇总列表</h3>
    <br>
    <hr size="2px;">
  <div align="center" style="text-align: center;">
    	<table width="98%;" border="0">
    		<tr>
    			<td align="left">
    				日期：<select>
						<option>请选择</option>
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
    			<button class="stdbtn mlr10">未归档事迹</button>
    			<button class="stdbtn mlr10">已归档事迹</button>
    		  </td>
    		</tr>
    	</table>
  	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="9%" class="head1">序号</th>
            <th width="14%" class="head1">日期</th>
            <th width="14%" class="head1">参会领导名单</th>
            <th width="17%" class="head1">参加会议</th>
            <th width="12%" class="head1">大事记</th>
            <th width="25%" class="head1">操作</th>
          </tr>
        </thead>
		<tbody>
		  <c:forEach begin="1" step="1" end="7" varStatus="state">
		  	<tr>
		  		<td>${state.index}</td>
		  		<td>2016年${state.index}月</td>
		  		<td>xx,xx,xxx,xxx,xx</td>
	  			<td>xxxxx</td>
	  			<td>是</td>
	  			<td>
	  				<a class="funcOper" href="/icmp/meeting/schedule/event/eventDetail.jsp">编辑信息</a>
	  			</td>
	  		</tr>
		  	
		  	</c:forEach>
			
		 </tbody>
	  </table>
	  <!-- 页码，有动态数据之后添加 -->
	  <%-- <jsp:include page="/common/pageFooter.jsp" /> --%>
  </div>
  </body>
</html>
