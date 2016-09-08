<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>分级配置</title>
<link rel="stylesheet" type="text/css" href="../js/DataTables-1.9.4/demo_table_jui.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/DataTables-1.9.4/jquery.dataTables.js" language="javascript"></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>

</head>
<body>
<div id="basicform" class="contentwrapper">
<div id="m">
		<ul>
            <li id="m1" onmousedown="menu(1)" style="background:#fff">用户分级配置</li> 
            <li id="m2" onmousedown="menu(2)">会议室分级配置</li> 
        </ul>
	</div>
	<div id="k1" class="k" style="display:block">
		<table cellpadding="0" cellspacing="0" border="0" class="display dataTable" style="overflow-y:auto">
			<thead>
                <tr>
                    <th width="20" class="head1"><input class="most" id="chkA03" onClick="ChkA03Click('chkSon','chkA03')" type="checkbox" /></th>
                    <th width="150" class="head1">分级名称</th>
                    <th width="%" class="">用户名称</th>
                    <th width="150" class="head1">操作</th>
                </tr>
			</thead>
			<tbody>
				<tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon1" type="checkbox"  value='1' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td>省</td>
                    <td>U1,U2,U3,U4,U5,U6,U7</td>
                    <td class="alc"><a href="levelConfigDetail.jsp">查看</a> | <a href="levelConfigAdd.jsp">配置</a> | <a href="#">删除</a></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon2" type="checkbox"  value='2' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td>市</td>
                    <td>U1,U10,U12,U14,U15,U16,U17</td>
                    <td class="alc"><a href="levelConfigDetail.jsp">查看</a> | <a href="levelConfigAdd.jsp">配置</a> | <a href="#">删除</a></td>
                </tr>
                <tr class="gradeA">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon3" type="checkbox"  value='3' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td>县</td>
                    <td>U1,U11,U22,U24,U25,U26,U27</td>
                    <td class="alc"><a href="levelConfigDetail.jsp">查看</a> | <a href="levelConfigAdd.jsp">配置</a> | <a href="#">删除</a></td>
                </tr>
                <tr class="gradeC">
                    <td class="alc"><INPUT class="most" name="chkSon" id="chkSon4" type="checkbox"  value='4' onclick="ChkSonClick('chkSon','chkA03')" /></td>
                    <td>区</td>
                    <td>U1,U18,U32,U34,U15,U36,U37</td>
                    <td class="alc"><a href="levelConfigDetail.jsp">查看</a> | <a href="levelConfigAdd.jsp">配置</a> | <a href="#">删除</a></td>
                </tr>                
			</tbody>
		</table>
	</div>
	<!-- div id="k2" class="k"> 
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
    </div-->
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