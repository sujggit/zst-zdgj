<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/common/common_header.jsp"%>
<%@ page import="com.zzst.model.meeting.department.DepartmentVO" %>
<%
DepartmentVO  obj = (DepartmentVO)request.getAttribute("obj");
%>
<html>
<head>
	<base href="${sys_ctx }">
	<title>菜单编辑</title>
	<link rel="stylesheet" type="text/css" href="js/ext/resources/css/ext-all.css">
	<script type="text/javascript" src="js/ext/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="js/ext/ext-all.js"></script>
	<script type="text/javascript">
		function checkForm(form){
			if(form.parentId.value == "" || form.leaf.value == ""){
				Ext.Msg.alert("错误提示","表单信息不健全！");
				return false;
			}
			if(form.title.value == ""){
				Ext.Msg.alert("错误提示","标题不能为空！");
				return false;
			}
		}
	</script>
</head>
<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' style="background-color: white">
	<br/><br/>
	<form action="navigatesave" method="post" onsubmit="return checkForm(this)">
		<input type="hidden" name="id" value="<%=obj.getId() %>"/>
		<input type="hidden" name="parentId" value="<%=obj.getParentId() %>"/>
		<input type="hidden" name="leaf" value="<%=obj.getLeaf() %>"/>
		<input type="hidden" name="number" value=""/>
		<table align="center">
			<tr><td width="60">标题</td>
				<td><input type="text" name="title" value="<%=obj.getTitle()==null?"":obj.getTitle() %>"/></td></tr>
			<%if(obj.getLeaf() ==1){ %>
			<tr><td>URL：</td>
				<td><input type="text" name="url" value=""/></td></tr>
			<%} %>
			<tr><td colspan="2" align="center">
					<br/>
					<input type="submit" name="submit" value="保存"/>
					&nbsp;&nbsp;
					<input type="reset" name="reset" value="重置"/>
					&nbsp;&nbsp;
					<input type="button" name="button" value="取消" onclick="window.parent.FormEditWin.close();">
				</td></tr>
		</table>
	</form>
</body>
</html>
