<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>会议记录_添加</title>
<link rel="stylesheet" href="../js/jquery-validation-1.11.1/validate-default.css" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>
<script type="text/javascript" src="../js/IpV4.js" ></script>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js" ></script>
<script type="text/javascript" src="../js/jquery-validation-1.11.1/jquery.validate.js" ></script>
</head>
<body>
	<div class="pageheader notab">
		<h3 class="pagetitle">a当前位置：会议记录添加</h3>
	</div>
	<div id="basicform" class="contentwrapper">
	  <form action="http://www.baidu.com" method="get" name="form" id="form">
		<div class="contenttitle2">
			<h5 class="fwb fl10">会议记录添加</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td width="15%" class="tableaddtitle">会议名称</td>
				<td width="35%" class="tableadd_data">
					<input type="text" class="most" value="" />
				</td>
				<td width="15%" class="tableaddtitle"><span>*</span>会场名称</td>
				<td width="35%" class="tableadd_data">
					<input type="text" class="most" value="" />
				</td>
			</tr>
            <tr>
				<td class="tableaddtitle">音频设备</td>
				<td class="tableadd_data" colSpan="3">
					<select><option>网络故障</option><option>正常</option></select>
					<textarea style="margin-top:2px;display:block;min-height:50px;"></textarea>					
				</td>
			</tr>
			<tr>
                <td class="tableaddtitle">视频设备</td>
				<td class="tableadd_data" colSpan="3">
					<select><option>网络故障</option><option>正常</option></select>
					<textarea style="margin-top:2px;display:block;min-height:50px;"></textarea>	
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle">会管软件</td>
				<td class="tableadd_data" colSpan="3">
					<select><option>正常</option><option>网络故障</option></select>
					<textarea style="margin-top:2px;display:block;min-height:50px;"></textarea>	
				</td>
			</tr>
            <tr>
				<td class="tableaddtitle">。。。</td>
				<td class="tableadd_data" colSpan="3">
					<select><option>正常</option><option>网络故障</option></select>
					<textarea style="margin-top:2px;display:block;min-height:50px;"></textarea>	
				</td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tr>
				<td>
					<input type="button" class="submit1 radius2" value="确 定" onclick="commit()"/></button>
					<input type="button" class="reset1 radius2" value="返回" onclick="window.history.back()"/></button>
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