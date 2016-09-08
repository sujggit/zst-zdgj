<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>表单</title>
<link rel="stylesheet" href="../js/jquery-validation-1.11.1/validate-default.css" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>
<script type="text/javascript" src="../js/IpV4.js" ></script>
<script type="text/javascript" src="../js/jquery-validation-1.11.1/jquery.validate.js" ></script>
</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 表单</h3>
</div>
<div id="basicform" class="contentwrapper">
	<form action="http://www.baidu.com" method="get" name="form" id="form">
		<div class="contenttitle2">
			<h5 class="fwb fl10">表单</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td class="tableaddtitle"><span>*</span>手机</td>
				<td class="tableadd_data"><input id="mobilephone" name="mobilephoneName" maxlength="14" class="most" /></td>
				<td class="tableaddtitle"><span>*</span>电话</td>
				<td class="tableadd_data"><input id="telephone" name="telephoneName" class="most" /></td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>邮箱</td>
				<td class="tableadd_data"><input name="emailName" id="email" class="most" /></td>
				<td class="tableaddtitle"><span>*</span>IP地址</td>
				<td class="tableadd_data">
					<span id="ipSpan"></span>
					<input type="text" id="ip" name="ipName" style="display:none"/>
					<span id="ipValiSpan" class="promptSpan"></span>
				</td>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>密码</td>
				<td class="tableadd_data" colspan="3"><input type="password" name="pwd1Name" id="pwd1" class="most" /></td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		  <tr>
			<td>
				<input type="button" class="submit1 radius2" value="确 定" onclick="commit()"/>
				<input type="button" class="reset1 radius2" value="取 消" onclick="window.history.back()" />
			</td>
			</tr>
		</table>
	</form>
</div>
	<script>
		$(document).ready(function(){
			var ip1 = new IpV4Box("ip1" , "ipSpan");//引用IpV4.js
			var ip = document.getElementById("ip");
			ip1.onChange = function(){
				ip.value=ip1.getValue();
			}
			var obj = new htmlUtil();
			obj.title("pwd1","请输入至少6位的密码");
			obj.title("mobilephone","请输入正确的手机格式");
			obj.title("telephone","请输入正确的电话格式");
			obj.title("email","请输入正确的邮箱格式");
			obj.title("ip","请输入正确的IP格式（由0到255之间的整数和.组成）");
			//‘ip1’即var ip1 = new IpV4Box("ip1" , "ipSpan");所定义，‘_4’即是第4个IP框
			obj.title("ip1_4","请输入正确的IP格式（介于0~255间的整数）");
			$("#form").validate({
				rules:{
					pwd1Name: {
						required: true,
						minlength: 6
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
					ip4Name: {
						required : true,
						isIp: true
					}
				}
			});
		})

		function commit(){
			$("#form").submit();
		}
	</script>
</body>
</html>