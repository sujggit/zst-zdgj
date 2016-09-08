<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>列表</title>
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
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 列表</h3>
</div>
<div class="contentwrapper">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle">发布标题</td>
			<td class="tableadd_data"><input id="datepicker2" type="text" class="most" /></td>
			<td class="tableaddtitle">发布人</td>
			<td class="tableadd_data"><input id="datepicker2" type="text" class="most" /></td>
			<td class="tableaddtitle" rowspan="2" ><input type="reset" class="stdbtn mlr10" value="查 询" /></td>
		</tr>
		<tr>
			<td class="tableaddtitle">开始时间</td>
			<td class="tableadd_data"><img src="../images/c2.png" /><input class="most" readonly="readonly" id="startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'endTime\',{d:0})}'});"></td>
			<td class="tableaddtitle">结束时间</td>
			<td class="tableadd_data"><img src="../images/c2.png" /><input class="most" readonly="readonly" id="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\',{m:0})}'});"></td>
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
			<h5 class="fwb fl10">列表</h5>
			<h5 class="fwb fr10"><a href="listing_add.jsp">增加</a></h5>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
			<thead>
				<tr>
					<th width="10" class="head1"><input class="most" id="chkA03" onClick="ChkA03Click('chkSon','chkA03')" type="checkbox" /></th>
					<th width="30" class="head1">序号</th>
					<th width="%">角色</th>
					<th width="%">用户</th>
					<th width="%">MCU个数</th>
					<th width="%">配置名称</th>
					<th width="%">描述</th>
					<th width="150" class="head1">操作</th>
				</tr>
			</thead>
			<tbody>
				<tr class="gradeA">
					<td class="alc">
						<input class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">1</td>
					<td>角色1</td>
					<td>张三</td>
					<td>40</td>
					<td>app_name</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">2</td>
					<td>角色2</td>
					<td>李四</td>
					<td>30</td>
					<td>query_view_end_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeA">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">3</td>
					<td>角色3</td>
					<td>王五</td>
					<td>20</td>
					<td>query_view_start_hour</td>
					<td></td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
					</td>
				</tr>
				<tr class="gradeC">
					<td class="alc">
						<INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" />
					</td>
					<td class="alc">4</td>
					<td>角色</td>
					<td>孙二</td>
					<td>10</td>
					<td>statistics_image_width</td>
					<td>hijian</td>
					<td class="alc">
						<a href="listing_list.jsp">查看</a> | <a href="#">修改</a> | <a href="#" onclick="drag.init().move('drag')">删除</a>
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