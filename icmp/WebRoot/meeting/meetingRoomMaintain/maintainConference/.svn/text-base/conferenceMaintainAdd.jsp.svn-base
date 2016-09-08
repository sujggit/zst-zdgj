<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%>
  <title>会议记录</title>
</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：会议记录</h3>
</div>
<div class="contentwrapper">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle">会议名称</td>
			<td class="tableadd_data">${meetingDetailVO.meetingName }</td>
			<td class="tableadd_data" colspan="2"></td>
		</tr>
		<tr>
			<td class="tableaddtitle">开始时间</td>
			<td class="tableadd_data"><fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
			<td class="tableaddtitle">结束时间</td>
			<td class="tableadd_data"><fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
		</tr>
	</table>
	            
		<div class="contenttitle2">
			<h5 class="fwb fl10">会议记录</h5>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
			<thead>
				<tr>
					<th width="50px" class="head1">序号</th>
					<th width="%" class="head1">会场名称</th>
					<c:forEach items="${dListType}" var="dictionaryVO" 	varStatus="state">
						<th width="%" class="head1">${dictionaryVO.dicViewName }</th>
					</c:forEach>
					<th width="%" class="head1">备注</th>
				</tr>
			</thead>
			<tbody>
			 
			</tbody>
		</table>
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		<tr>
			<td>
				<input type="button" class="submit1 radius2" value="确 定" onclick="add();" />
				<input type="button" class="reset1 radius2" value="取 消" onclick="backMethod();" />
			</td>
		</tr>
	</table>
</div>
</body>
</html>