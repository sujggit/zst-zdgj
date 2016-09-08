<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>设备详情</title>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>	

	</head>
	<!-- body style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN'-->
	<body style='overflow:auto'>
		<form action="${sys_ctx}/videoCardCompare/mamufactruerComparison.action" id="pageform" name="pageform" method="post">
		<div class="contentwrapper">
			<input type="hidden" name="comparisonVO.compDetailID" value="${comparisonVO.compDetailID}"/>
			<input type="hidden" name="comparisonVO.ID" value="${comparisonVO.ID}"/>
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					${comparisonVO.meetingRoomVO.meetingRoomName} 设备详情
				</h5>
			</div>
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="tableadd">
				
				
				<!-- 
				<tr>
					<td width="15%" class="tableaddtitle">中控</td>
					<td width="35%" class="tableadd_data">
						<img src="images/Faultred.png"/>
					</td>
				</tr>
				 -->
				<tr>
					<td width="15%" class="tableaddtitle">终端</td>
					<td width="35%" class="tableadd_data">
					<%
						String terCount = (String)request.getAttribute("TERMINAL");
						if( terCount != null &&  terCount.equals("0")){
					%>
						<img src="${sys_ctx }/images/Faultred.png"/>
						<%
						}else{
						%>
						<img src="${sys_ctx }/images/Normalgreen.png"/>
						<%} %>
					</td>
				</tr>
				<%
				String[][] items = (String[][])request.getAttribute("equipmentItems");
				
				if(items != null && items.length > 0){
					for(int i=0; i<items.length; i++){
						if(items[i][0]==null)continue;
							%>
					<tr>
					<td width="15%" class="tableaddtitle">
					<%
					if(items[i][0].equalsIgnoreCase("pla2")){	%>
					电视机1
					<%} %>
					<%
					if(items[i][0].equalsIgnoreCase("pla1")){	%>
					电视机2
					<%} %>
					<%
					if(items[i][0].contains("proj")){	%>
					投影
					<%} %>
					<%
					if(items[i][0].equalsIgnoreCase("sysPower")){	%>
					电源
					<%} %>
					<%
					if(items[i][0].equalsIgnoreCase("matrix")){	%>
					矩阵
					<%} %>
					<%
					if(items[i][0].equalsIgnoreCase("camera1")){	%>
					摄像机1
					<%} %>
					<%
					if(items[i][0].equalsIgnoreCase("camera2")){	%>
					摄像机2
					<%} %>
					<% 
					if(items[i][0].contains("audioHandler")){	%>
					音频处理器
					<%} %>
					</td>
					<td width="35%" class="tableadd_data">
					<%
						
						if(items[i][1].equalsIgnoreCase("true")){
							
					%>
					<img src="${sys_ctx }/images/Normalgreen.png"/>
					<%}else{ %>
						<img src="${sys_ctx }/images/Faultred.png"/>
					
				<%
						}
						%></td>
					</tr>	
				<%
					}
				}
				
				%>
				
			</table>
<%--			${equipmentStatus }--%>
			<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
				<tfoot>
				</tfoot>
				<tbody>
					<tr>
						<td>
							<input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</form>

</body>
</html>