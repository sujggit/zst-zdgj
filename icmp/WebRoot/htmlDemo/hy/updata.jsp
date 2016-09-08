<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>公告管理</title>
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
	<h3 class="pagetitle">当前位置：公告管理</h3>
</div>       
	<div id="basicform" class="contentwrapper">
		<div class="contenttitle2">
			<h5 class="fwb fl10">公告管理</h5>
			<h5 class="fwb fr10"><a href="minutes_add.jsp">添加</a></h5>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
			<thead>
				<tr>
					<th width="38" class="head1">排序</th>
					<th width="%">字段名称</th>
					<th width="%">字段类型</th>
					<th width="%">数据字典</th>
					<th width="%">是否必填</th>
					<th width="150" class="head1">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="gradeA updata">
					<td width="50" class="alc"><input type="text" class="text" value="0" /></td>
					<td><input type="text" class="text" value="CPU品牌" /></td>
					<td><select><option></option><option>文本</option><option>数字</option><option>日期</option><option>图片</option></select></td>
					<td><select><option></option><option>INTEL</option><option>500Hz</option></select></td>
					<td><input type="radio" name="radio" class="radio" />是<input type="radio" name="radio" class="radio"  />否</td>
					<td class="alc">
						<a href="#">删除</a>
					</td>
				</tr>
				<tr class="gradeC updata">
					<td width="50" class="alc"><input type="text" class="text" value="10"/></td>
					<td><input type="text" class="text" value="CPU型号"/></td>
					<td><select><option></option><option>文本</option><option>数字</option><option>日期</option><option>图片</option></select></td>
					<td><select><option></option><option>INTEL</option><option>500Hz</option></select></td>
					<td><input type="radio" name="radio" class="radio" />是<input type="radio" name="radio" class="radio"  />否</td>
					<td class="alc">
						<a href="#">删除</a>
					</td>
				</tr>
				<tr class="gradeA updata">
					<td width="50" class="alc"><input type="text" class="text" value="20"/></td>
					<td><input type="text" class="text" value="CPU缓存"/></td>
					<td><select><option></option><option>文本</option><option>数字</option><option>日期</option><option>图片</option></select></td>
					<td><select><option></option><option>INTEL</option><option>500Hz</option></select></td>
					<td><input type="radio" name="radio" class="radio" />是<input type="radio" name="radio" class="radio"  />否</td>
					<td class="alc">
						<a href="#">删除</a>
					</td>
				</tr>
			</tbody>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		  <tr>
			<td>
				<input type="button" class="submit1 radius2" value="保 存" onclick="commit()"/>
				<input type="button" class="reset1 radius2" value="取 消" onclick="window.history.back()" />
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