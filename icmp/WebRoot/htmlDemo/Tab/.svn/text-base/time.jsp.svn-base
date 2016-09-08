<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>时间插件</title>
	<link rel="stylesheet" href="tree.css" type="text/css" />
	<!--树状图-->
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-zTree-v3.5.12/jquery.ztree.all-3.5.min.js"></script>
</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 时间插件</h3>
</div>
<div id="basicform" class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">时间插件</h5>
	</div>
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle"><span>*</span>开始时间</td>
			<td class="tableadd_data">
			  <img src="../images/c2.png" /><input class="most" readonly="readonly" id="startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'endTime\',{d:0})}'});">
			</td>
			<td class="tableaddtitle"><span>*</span>结束时间</td>
			<td class="tableadd_data">
			  <img src="../images/c2.png" /><input class="most" readonly="readonly" id="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\',{m:0})}'});">
			</td>
		</tr>
		<tr>
			<td class="tableaddtitle"><span>*</span>起止时间</td>
			<td colspan="3" class="tableadd_data">
			  <input readonly="readonly" id="startTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'endTime1\',{d:0})}'});"/>
               - <input readonly="readonly" id="endTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime1\',{m:0})}'});"/>
			</td>
        </tr>
	</table>	
</div>
</body>
</html>