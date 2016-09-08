<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>会议管理</title>
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
	<h3 class="pagetitle">当前位置：会议管理</h3>
</div>
<div class="contentwrapper">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" align="center">
		<tr>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>会议名称</option>
					<option>开始时间</option>
					<option>结束时间</option>
					<option>主会议室</option>
					<option>会议模式</option>
					<option>常办单位</option>
					<option>会议资料管理员</option>
					<option>预约人</option>
					<option>参会会场</option>
					<option>主会场名称</option>
					<option>会议服务</option>
					<option>会议标签</option>
					<option>参与人员</option>
					<option>会议描述</option>
				</select>
			</td>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>等于</option>
					<option>不等于</option>
					<option>包含</option>
					<option>不包含</option>
				</select>
			</td>
			<td class="tableaddtitle searched"><input type="text" /></td>
			<td class="searched searchs">
				<a href="#" class="lvse">+</a>
			</td>
		</tr>
		<tr>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>会议名称</option>
					<option>开始时间</option>
					<option>结束时间</option>
					<option>主会议室</option>
					<option>会议模式</option>
					<option>常办单位</option>
					<option>会议资料管理员</option>
					<option>预约人</option>
					<option>参会会场</option>
					<option>主会场名称</option>
					<option>会议服务</option>
					<option>会议标签</option>
					<option>参与人员</option>
					<option>会议描述</option>
				</select>
			</td>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>等于</option>
					<option>不等于</option>
					<option>包含</option>
					<option>不包含</option>
				</select>
			</td>
			<td class="tableaddtitle searched"><input type="text" /></td>
			<td class="searched searchs">
				<a href="#" class="lvse">+</a>
				<a href="#" class="hongse"></a>
			</td>
		</tr>
		<tr>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>会议名称</option>
					<option>开始时间</option>
					<option>结束时间</option>
					<option>主会议室</option>
					<option>会议模式</option>
					<option>常办单位</option>
					<option>会议资料管理员</option>
					<option>预约人</option>
					<option>参会会场</option>
					<option>主会场名称</option>
					<option>会议服务</option>
					<option>会议标签</option>
					<option>参与人员</option>
					<option>会议描述</option>
				</select>
			</td>
			<td class="tableaddtitle searched">
				<select>
					<option>请选择</option>
					<option>等于</option>
					<option>不等于</option>
					<option>包含</option>
					<option>不包含</option>
				</select>
			</td>
			<td class="tableaddtitle searched"><input type="text" /></td>
			<td class="searched searchs">
				<a href="#" class="lvse">+</a>
				<a href="#" class="hongse"></a>
			</td>
		</tr>
		<tr>
			<td class="tableaddtitle" colspan="4"><input type="reset" class="stdbtn mlr10" value="查 询" /></td>
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
</div>          
	<div id="basicform" class="contentwrapper">
		<div class="contenttitle2">
			<h5 class="fwb fl10">会议记录</h5>
			<h5 class="fwb fr10"><a href="minutes_add.jsp">添加</a> <a href="#">导出</a></h5>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
			<thead>
				<tr>
					<th width="38" class="head1">序号</th>
					<th width="%">会议名称</th>
					<th width="%">会场名称</th>
					<th width="%">时间</th>
					<th width="%">检查项</th>
					<th width="%">类型</th>
					<th width="150" class="head1">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="gradeA">
					<td width="38" class="alc">1</td>
					<td>a</td>
					<td>1</td>
					<td>2012-09-09 13:20</td>
					<td>f</td>
					<td>网络故障</td>
					<td class="alc">
						<a href="#">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td width="38" class="alc">2</td>
					<td>a</td>
					<td>1</td>
					<td></td>
					<td>d</td>
					<td>正常</td>
					<td class="alc">
						<a href="#">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td width="38" class="alc">3</td>
					<td>a</td>
					<td>2</td>
					<td></td>
					<td>f</td>
					<td></td>
					<td class="alc">
						<a href="#">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
			</tbody>
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