<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>列表_添加</title>
<link rel="stylesheet" href="../js/jquery-validation-1.11.1/validate-default.css" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>
<script type="text/javascript" src="../js/IpV4.js" ></script>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" ></script>
<script type="text/javascript" src="../js/jquery-validation-1.11.1/jquery.validate.js" ></script>
</head>
<body>
	<div class="pageheader notab">
		<h3 class="pagetitle">当前位置：视频会议 ⇒ 列表</h3>
	</div>
	<div id="basicform" class="contentwrapper">
	  <form action="http://www.baidu.com" method="get" name="form" id="form">
		<div class="contenttitle2">
			<h5 class="fwb fl10">列表增加</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td width="15%" class="tableaddtitle"><span>*</span>25个字符</td>
				<td width="35%" class="tableadd_data">
					<input name="textfield1Name" id="textfield1" value="不能超出25个字符" onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出25个字符'){this.style.color='#000';value=''}" maxlength="25" class="mosts"/>
				</td>
				<td width="15%" class="tableaddtitle"><span>*</span>50个字符</td>
				<td width="35%" class="tableadd_data">
					<input name="textfield2Name" id="textfield2" value="不能超出50个字符" onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出50个字符'){this.style.color='#000';value=''}" maxlength="50" class="mosts"/>
				</td>
			</tr>
            <tr>
				<td class="tableaddtitle"><span>*</span>密码</td>
				<td class="tableadd_data"><input type="password" name="pwd1Name" id="pwd1" class="most" /></td>
				<td class="tableaddtitle"><span>*</span>确认密码</td>
				<td class="tableadd_data"><input type="password" name="pwd2Name" id="pwd2" class="most" /></td>
			</tr>
			<tr>
                <td class="tableaddtitle"><span>*</span>开始时间</td>
				<td class="tableadd_data">
                	<img src="../images/c2.png" /><input class="most" readonly="readonly" id="startTime" name="time1Name" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'endTime\',{d:0})}'});">
                </td>
				<td class="tableaddtitle"><span>*</span>结束时间</td>
				<td class="tableadd_data">
                	<img src="../images/c2.png" /><input class="most" readonly="readonly" id="endTime" name="time2Name" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\',{m:0})}'});">
                </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>手机</td>
				<td class="tableadd_data"><input id="mobilephone" name="mobilephoneName" maxlength="14" class="most" /></td>
				<td class="tableaddtitle"><span>*</span>电话</td>
				<td class="tableadd_data"><input id="telephone" name="telephoneName" class="most" /></td>
			</tr>
            <tr>
            	<td class="tableaddtitle"><span>*</span>邮箱</td>
				<td class="tableadd_data"><input name="emailName" id="email" class="most" /></td>
				<td class="tableaddtitle"><span>*</span>下拉框</td>
				<td class="tableadd_data">
                	<select name="selName" id="sel"><option value="-1">--请选择--</option><option value="0">内容_1</option><option value="1">内容_2</option></select>
                </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>单选</td>
				<td class="tableadd_data"><input type="radio" name="sex" checked="checked" class="most"  /> 男 <input type="radio" name="sex" class="most"  /> 女 </td>
				<td class="tableaddtitle">多选</td>
				<td class="tableadd_data">
					<input type="checkbox" name="country" class="most" /> 中国  <input type="checkbox" name="country" class="most" /> 英国  
					<input type="checkbox" name="country" class="most" /> 美国  <input type="checkbox" name="country" class="most" /> 德国  
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>MCU个数</td>
				<td class="tableadd_data">
					<div class="acquiesce"><input id="number" name="numberName" value="10" /></div>
					<div class="acquiesce_list">
						<span class="acquiesce_list_1"><input type="button" value="" onClick="plus();" /></span>
					<span class="acquiesce_list_2"><input type="button" value="" onClick="reduce();" /></span>
					</div>
				</td>
				<td class="tableaddtitle"><span>*</span>IP地址</td>
				<td class="tableadd_data">
					<span id="ipSpan"></span>
					<input type="text" id="ip" name="ipName" style="display:none"/>
					<span id="ipValiSpan" class="promptSpan"></span>
				</td>
			</tr>
            <tr>
				<td class="tableaddtitle">描述</td>
				<td class="tableadd_data" colspan="3">
                	<textarea onmouseover="this.style.borderColor='#ccc'" onmouseout="this.style.borderColor=''" onFocus="if (value =='不能超出500个字符'){this.style.color='#000';value=''}" maxlength="500" class="mosts">不能超出500个字符</textarea>
                </td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tr>
				<td>
					<input type="button" class="submit1 radius2" value="确 定" onclick="commit()"/></button>
					<input type="button" class="reset1 radius2" value="取 消" onclick="window.history.back()"/></button>
				</td>
			</tr>
		</table>
	  </form>
	</div>
	<!--上箭头加一，下箭头减一-->
	<script>
		$(document).ready(function(){
			var ip1 = new IpV4Box("ip1" , "ipSpan");//引用IpV4.js
			var ip = document.getElementById("ip");
			ip1.onChange = function(){
				ip.value=ip1.getValue();
			}
			var obj = new htmlUtil();
			obj.title("textfield1","请输入至少6位字符");
			obj.title("textfield2","请输入至少6位字符");
			obj.title("startTime","请选择开始时间");
			obj.title("endTime","请选择结束时间");
			obj.title("pwd1","请输入至少6位的密码");
			obj.title("pwd2","请再次输入相同的密码");
			obj.title("mobilephone","请输入正确的手机格式");
			obj.title("telephone","请输入正确的电话格式");
			obj.title("email","请输入正确的邮箱格式");
			obj.title("sel","请选择");
			obj.title("number","只能是大于0的整数");
			//‘ip1’即var ip1 = new IpV4Box("ip1" , "ipSpan");所定义，‘_4’即是第4个IP框
			obj.title("ip1_4","请输入正确的IP格式（介于0~255间的整数）");
			$("#form").validate({
				rules:{
					textfield1Name: {
						required: true,
						minlength: 6
					},
					textfield2Name: {
						required: true,
						minlength: 6
					},
					time1Name: "required",
					time2Name: "required",
					pwd1Name: {
						required: true,
						minlength: 6
					},
					pwd2Name: {
						required: true,
						minlength: 6,
						equalTo: "#pwd1"
				    },
					mobilephoneName: {
						required: true,
						isMobilephone: true
					},
					telephoneName: {
						required: true,
						isTelephone: true
					},
					emailName: {
						required : true,
						email : true
					},
					selName: {
						required : true,
						min: 0
					},
					numberName: {
						required : true,
						digits: true,
						min: 1
					},
					ip4Name: {
						required : true,
						isIp: true
					}
				}
			});
		})

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

		function commit(){
			document.getElementById("textfield1").value="";
			document.getElementById("textfield2").value="";
			$("#form").submit();
		}
	</script>
</body>
</html>