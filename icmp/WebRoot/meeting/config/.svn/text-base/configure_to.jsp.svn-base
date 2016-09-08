<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>通知配置</title>
<script type="text/javascript">
	$(document).ready(function(){
	        var obj = new htmlUtil();
			obj.title("dxAddress","输入长度不能超过100个字符");
			obj.title("dxName","输入长度不能超过50个字符");
			obj.title("dxPass","输入长度不能超过50个字符");
			obj.title("gsAddress","输入长度不能超过100个字符");
			obj.title("gsName","输入长度不能超过50个字符");
			obj.title("gsPass","输入长度不能超过50个字符");
			obj.title("smtpAddress","输入长度不能超过50个字符");
			obj.title("mailUser","输入正确的邮箱");
			obj.title("mailPass","输入长度不能超过50个字符");
		});
		
function commit(){
	
	$('#configForm').validate({    
						rules:{   
						 "configTcipVO1.address" : {
								   required:true,
						           maxlength:100
						           },
						 "configTcipVO1.name" : {
								   required:true,
							       maxlength:50
							       },
					     "configTcipVO1.password" : {
								   required:true,
								   maxlength:50
								   },
						 "configTcipVO2.address" : {
						           required:true,				          
						           maxlength:100
						           },
						 "configTcipVO2.name" : {
							       required:true,				          
							       maxlength:50
							       },
					     "configTcipVO2.password" : {
								   required:true,				          
								   maxlength:50
								   },
						 "mailConfigVO.mailSmtp" : {
						        	required:true,			           
						            maxlength:50
						           },
						 "mailConfigVO.mailName" : {
						        	required:true,
						        	email:true,			           
						            maxlength:50
						           },
						 "mailConfigVO.mailPass" : {
						        	required:true,				          
						            maxlength:50
						           }
						}  
					  });

	$("#configForm").submit();
}
</script>
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx}/config/modifyNoticeConfig.action" id="configForm" name="configForm" method="post">
	<div id="basicform" class="contentwrapper">
    	<div class="contenttitle2"><h5 class="fwb fl10">短信配置</h5>&nbsp;&nbsp; <span style="color:red"><c:if test="${configVO.sms == false }">未启用</c:if></span></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle"><span>*</span>Webservice地址</td>
          		<td class="tableadd_data">
          		<input style="width:70%" type="text" class="most" name="configTcipVO1.address" value="${configTcipVO1.address }" id="dxAddress" <c:if test="${configVO.sms == false }">disabled="disabled"</c:if> maxlength="100"/>
          		<input type="hidden" value="${configTcipVO1.id }" name="configTcipVO1.id"/></td>
        	</tr>  
        	<tr>
          		<td class="tableaddtitle"><span>*</span>用户名</td>
          		<td class="tableadd_data"><input style="width:70%" type="text" class="most" name="configTcipVO1.name" value="${configTcipVO1.name }" id="dxName" <c:if test="${configVO.sms == false }">disabled="disabled"</c:if> maxlength="50"/></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle"><span>*</span>密码</td>
          		<td class="tableadd_data"><input style="width:70%" type="password" class="most" name="configTcipVO1.password" value="${configTcipVO1.password }" id="dxPass" <c:if test="${configVO.sms == false }">disabled="disabled"</c:if> maxlength="50"/></td>
        	</tr>      	
		</table>
		<div class="contenttitle2"><h5 class="fwb fl10">告示配置</h5>&nbsp;&nbsp; <span style="color:red"><c:if test="${configVO.billboard == false }">未启用</c:if></span></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle"><span>*</span>Webservice地址</td>
          		<td class="tableadd_data">
          		<input style="width:70%" type="text" class="most" name="configTcipVO2.address" value="${configTcipVO2.address }" id="gsAddress" <c:if test="${configVO.billboard == false }">disabled="disabled"</c:if> maxlength="100"/>
          		<input type="hidden" value="${configTcipVO2.id }" name="configTcipVO2.id"/>
          		</td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle"><span>*</span>用户名</td>
          		<td class="tableadd_data"><input style="width:70%" type="text" class="most" name="configTcipVO2.name" value="${configTcipVO2.name }" id="gsName" <c:if test="${configVO.billboard == false }">disabled="disabled"</c:if> maxlength="50"/></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle"><span>*</span>密码</td>
          		<td class="tableadd_data"><input style="width:70%" type="password" class="most" name="configTcipVO2.password" value="${configTcipVO2.password }" id="gsPass" <c:if test="${configVO.billboard == false }">disabled="disabled"</c:if> maxlength="50"/></td>
        	</tr>          	
		</table>
    	<div class="contenttitle2"><h5 class="fwb fl10">邮件配置</h5>&nbsp;&nbsp; <span style="color:red"><c:if test="${configVO.email == false }">未启用</c:if></span></div>
    	<input type="hidden" value="${mailConfigVO.id }" name="mailConfigVO.id"/>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">        	
        	<tr>
          		<td class="tableaddtitle"><span>*</span>SMTP地址</td>
          		<td class="tableadd_data"><input style="width:70%" type="text" class="most" name="mailConfigVO.mailSmtp" value="${mailConfigVO.mailSmtp }" id="smtpAddress" <c:if test="${configVO.email == false }">disabled="disabled"</c:if> maxlength="50"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DEMO：smtp.163.com</td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle"><span>*</span>用户名</td>
          		<td class="tableadd_data"><input style="width:70%" type="text" class="most" name="mailConfigVO.mailName" value="${mailConfigVO.mailName }" id="mailUser" <c:if test="${configVO.email == false }">disabled="disabled"</c:if> maxlength="50"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DEMO：support@163.com</td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle"><span>*</span>密码</td>
          		<td class="tableadd_data"><input style="width:70%" type="password" class="most" name="mailConfigVO.mailPass" value="${mailConfigVO.mailPass }" id="mailPass" <c:if test="${configVO.email == false }">disabled="disabled"</c:if> maxlength="50"/></td>
        	</tr>
		</table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	<tfoot>
          	</tfoot>
          	<tbody>
            	<tr>
              		<td><input type="button" class="submit1 radius2" value="保存" onclick="commit()"/></td>
            	</tr>
       		</tbody>
        </table>
	</div>
</form>
</body>
</html>