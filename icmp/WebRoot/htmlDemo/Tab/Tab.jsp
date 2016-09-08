<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>选项卡</title>
<link rel="stylesheet" type="text/css" href="../js/DataTables-1.9.4/demo_table_jui.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/DataTables-1.9.4/jquery.dataTables.js" language="javascript"></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>

</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 选项卡</h3>
</div>
<div id="basicform" class="contentwrapper">
<div id="m">
		<ul>
            <li id="m1" onmousedown="menu(1)" style="background:#fff">MCU备份管理</li> 
            <li id="m2" onmousedown="menu(2)">终端备份管理</li> 
        </ul>
	</div>
	<div id="k1" class="k" style="display:block">
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable" style="overflow-y:auto">
			<thead>
                <tr>
                    <th width="20" class="head1"><input class="most" id="chkA03" onClick="ChkA03Click('chkSon','chkA03')" type="checkbox" /></th>
                    <th width="50" class="head1">序号</th>
                    <th width="%" class="">MCU个数</th>
                    <th width="%" class="">角色</th>
                    <th width="%" class="">用户</th>
                    <th width="%" class="">配置名称</th>
                    <th width="%" class="">描述</th>
                </tr>
			</thead>
			<tbody>
				<tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">1</td>
                    <td>40</td>
                    <td>角色1</td>
                    <td>张三</td>
                    <td>app_name</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">2</td>
                    <td>30</td>
                    <td>角色2</td>
                    <td>李四</td>
                    <td>query_view_end_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">3</td>
                    <td>20</td>
                    <td>角色3</td>
                    <td>王五</td>
                    <td>query_view_start_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">4</td>
                    <td>10</td>
                    <td>角色</td>
                    <td>孙二</td>
                    <td>statistics_image_width</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">1</td>
                    <td>40</td>
                    <td>角色1</td>
                    <td>张三</td>
                    <td>app_name</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">2</td>
                    <td>30</td>
                    <td>角色2</td>
                    <td>李四</td>
                    <td>query_view_end_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">3</td>
                    <td>20</td>
                    <td>角色3</td>
                    <td>王五</td>
                    <td>query_view_start_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">4</td>
                    <td>10</td>
                    <td>角色</td>
                    <td>孙二</td>
                    <td>statistics_image_width</td>
                    <td></td>
                </tr>
				<tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">1</td>
                    <td>40</td>
                    <td>角色1</td>
                    <td>张三</td>
                    <td>app_name</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">2</td>
                    <td>30</td>
                    <td>角色2</td>
                    <td>李四</td>
                    <td>query_view_end_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">3</td>
                    <td>20</td>
                    <td>角色3</td>
                    <td>王五</td>
                    <td>query_view_start_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">4</td>
                    <td>10</td>
                    <td>角色</td>
                    <td>孙二</td>
                    <td>statistics_image_width</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">1</td>
                    <td>40</td>
                    <td>角色1</td>
                    <td>张三</td>
                    <td>app_name</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">2</td>
                    <td>30</td>
                    <td>角色2</td>
                    <td>李四</td>
                    <td>query_view_end_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">3</td>
                    <td>20</td>
                    <td>角色3</td>
                    <td>王五</td>
                    <td>query_view_start_hour</td>
                    <td></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td class="alc">4</td>
                    <td>10</td>
                    <td>角色</td>
                    <td>孙二</td>
                    <td>statistics_image_width</td>
                    <td></td>
                </tr>
			</tbody>
		</table>
	</div>
	<div id="k2" class="k">
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable">
			<thead>
				<tr>
                    <th width="8%">备份终端</th>
                    <th width="24%">被备份终端</th>
                    <th width="24%">描述</th>
                </tr>
			</thead>
			<tbody>
                <tr class="gradeA">
                    <td class="">备份终端1</td>
                    <td>备份终端1</td>
                    <td><textarea name="datepicker" class="areatran2" id="datepicker7"></textarea></td>
                </tr>
                <tr class="gradeC">
                    <td>备份终端2</td>
                    <td>备份终端2</td>
                    <td><textarea name="datepicker" class="areatranwrite" id="datepicker7"></textarea></td>
                </tr>
                <tr class="gradeA">
                    <td>备份终端3</td>
                    <td>备份终端3</td>
                    <td><textarea name="datepicker" class="areatran2" id="datepicker7"></textarea></td>
                </tr>
                <tr class="gradeC">
                    <td>备份终端4</td>
                    <td>备份终端4</td>
                    <td><textarea name="datepicker" class="areatranwrite" id="datepicker7"></textarea></td>
                </tr>
			</tbody>
		</table>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var oTable = $('.dataTable').dataTable({
			//"iDisplayLength": 20,//每页默认显示数量
			"aLengthMenu": [[5,10, 20, 50, -1], [5,10, 20, 50, "All"]],//下拉框
			"bJQueryUI": true,
			"aaSorting": [[0,'desc']],
			"sPaginationType": "full_numbers"//分页样式 
		});
	} );
	//--选项卡切换
   function menu(m){
     for(var x=1;x<=2;x++){
       document.getElementById("k"+x).style.display="none";
       document.getElementById("m"+x).style.backgroundColor="";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
      }
       document.getElementById("k"+m).style.display="block";
       document.getElementById("m"+m).style.backgroundColor="#fff";
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
   }
</script>

</body>
</html>