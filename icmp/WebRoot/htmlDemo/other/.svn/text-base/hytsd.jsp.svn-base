<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>会议调试单</title>
	<link rel="stylesheet" type="text/css" href="../js/DataTables-1.9.4/demo_table_jui.css" />
	<script type="text/javascript" src="../js/windowInit.js" ></script>
	<!--列表-->
	<script type="text/javascript" language="javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="../js/DataTables-1.9.4/jquery.dataTables.js"></script>
	<!--弹出框-->                                                                                                      
	<script type="text/javascript" src="../js/popup.js"></script>

</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：会议调试单</h3>
</div>
<div class="contentwrapper">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle">会议名称</td>
			<td class="tableadd_data"><input id="datepicker2" type="text" class="inputtran" value="文本输入..." /></td>
			<td class="tableadd_data" colspan="2"></td>
		</tr>
		<tr>
			<td class="tableaddtitle">开始时间</td>
			<td class="tableadd_data"><input id="datepicker2" type="text" class="inputtran" value="文本输入 ..." /></td>
			<td class="tableaddtitle">结束时间</td>
			<td class="tableadd_data"><input id="datepicker2" type="text" class="inputtran" value="文本输入 ..." /></td>
		</tr>
	</table>

	<div class="widgetcontent">
		<div class="msgmore" onclick="disquery();">
			<a href="javascript:void(0);">
				<img src="../../style/normal/images/calarrow_1.png" width="51" height="5" border="0" />
				
				<map name="Map" id="Map">
					<area shape="rect" coords="2,-1,6,7" href="" />
					<area shape="rect" coords="36,0,51,6" href="" />
				</map>
			</a>
		</div>
	</div>        
		<div class="contenttitle2">
			<h5 class="fwb fl10">会议调试单</h5>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
			<thead>
				<tr>
					<th width="%">会场名称</th>
					<th width="%"><input type="checkbox"/>状态</th>
					<th width="%">备注</th>
				</tr>
			</thead>
			<tbody>
				<tr class="gradeA">
					<td>a会场</td>
					<td><input type="checkbox"/>正常 ，<input type="checkbox"/>异常 ， <input type="checkbox"/>其他 </td>
					<td><input type="text" class="inputtran" style="width:100%" /></td>
				</tr>
				<tr class="gradeC">
					<td>b会场</td>
					<td><input type="checkbox"/>正常 ，<input type="checkbox"/>异常 ， <input type="checkbox"/>其他 </td>
					<td><input type="text" class="inputtran" style="width:100%" /></td>
				</tr>
				<tr class="gradeA">
					<td>c会场</td>
					<td><input type="checkbox"/>正常 ，<input type="checkbox"/>异常 ， <input type="checkbox"/>其他 </td>
					<td><input type="text" class="inputtran" style="width:100%" /></td>
				</tr>
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
	<script type="text/javascript" charset="utf-8">
		//$(document).ready(function(){
			var oTable = $('.dataTable').dataTable({
				//"iDisplayLength": 20,//每页默认显示数量
				"aLengthMenu": [[5,10, 20, 50, -1], [5,10, 20, 50, "All"]],//下拉框
				"bJQueryUI": true,
				"aaSorting": [[0,'desc']],
				"sPaginationType": "full_numbers"//分页样式 
			});
		//});
		function disquery(){
		}
	</script>
</body>
</html>