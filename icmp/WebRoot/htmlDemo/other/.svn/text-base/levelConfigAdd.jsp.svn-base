<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>分级配置_增加</title>
<link rel="stylesheet" type="text/css" href="../js/DataTables-1.9.4/demo_table_jui.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>
<!--上箭头加一，下箭头减一-->
<script>
	function plus(){
		var num = document.getElementById("number");
		if(num.value){
			num.value = Number(num.value) +1;
		}
	}
	function reduce(){
		var num = document.getElementById("number");
		if(num.value){
			num.value = num.value - 1;
		}
	}
</script>
</head>
<body>
<div id="basicform" class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">分级配置</h5>
	</div>
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td class="tableaddtitle">分级名称</td>
			<td class="tableadd_data" ><input id="mobilephone" name="mobilephoneName" class="inputtran" /></td>
		</tr>
		<tr>
			<td class="tableaddtitle">人员名称</td>
			<td class="tableadd_data" ><input id="mobilephone" name="mobilephoneName" class="inputtran" /></td>
		</tr>
		<tr>
			<td class="tableaddtitle">描述</td>
			<td class="tableadd_data"><textarea onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出500个字符'){this.style.color='#000';value=''}" maxlength="500" class="mosts">不能超出500个字符</textarea></td>
		</tr>		
	</table>
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		<tr>
			<td>
				<input type="reset" class="submit1 radius2" value="确 定" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
				<input type="reset" class="reset1 radius2" value="取 消" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>