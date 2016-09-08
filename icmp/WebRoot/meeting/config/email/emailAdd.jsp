<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>邮件配置管理</title>
		<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/baseInfo/queryBaseInfoList.action";
            }

           function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("emailAddress","请输入正确的邮件地址，格式如：emailAddress@cnpc.com");	
			    obj.title("smtp","请输入正确的服务器地址，格式如：emailAddress@cnpc.com");	
			    obj.title("smtpPort","请输入正确的服务器端口号");	
			    obj.title("userName","请输入长度不超过25个字符");	
			    obj.title("passWord","请输入长度不超过25个字符");	
				obj.title("format","请输入长度不超过500个字符");	
				var isEffectivty = ${emailVO.isEffective};
				
				if(isEffectivty == "0"){
					
					setUnitsDisabled();
				}else {
					
					setUnitsEnabled();
				}
			}

			/**
			*	注册mcu添加事件，实现验证、友好提示功能
			*@return	null	
			*/
               function emailAdd(){
               	if(confirm("确定修改吗？")){
                  $('#emailForm').validate({    
					rules:{    
					   "emailVO.emailAddress" : {
					           required:true,
					           email:true
					           },
					     "emailVO.smtp" : {
					           required:true
					           },
					       "emailVO.smtpPort" : {
					       	   required:true
					           },
					       "emailVO.userName" : {
					           required:true,
					           minlength:1,
					           maxlength:25
					           },
					       "emailVO.passWord" : {
					           required:true,
					           minlength:1,
					           maxlength:25
					           },
					       "emailVO.format" : {
					           required:true,
					           minlength:1,
					           maxlength:500
					           }
					}  
				  });
                $('#emailForm').submit();
               }
             }
           	
           
 		
 		function setUnitsDisabled(){
 		
 			$("#emailAddress").attr("disabled","disabled");
 			$("#smtp").attr("disabled","disabled");
 			$("#smtpPort").attr("disabled","disabled");
 			$("#userName").attr("disabled","disabled");
 			$("#passWord").attr("disabled","disabled");
 			$("#format").attr("disabled","disabled");
 		}
 		
 		function setUnitsEnabled(){
 		
 			$("#emailAddress").attr("disabled","");
 			$("#smtp").attr("disabled","");
 			$("#smtpPort").attr("disabled","");
 			$("#userName").attr("disabled","");
 			$("#passWord").attr("disabled","");
 			$("#format").attr("disabled","");
 		}
 		

         
    	--></script>
</head>

<body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">

<form action="${sys_ctx}/email/addEmail.action" id="emailForm" name="emailForm" method="post">

<div class="contenttitle2">
        <h5 class="fwb fl10">邮件配置</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
         <tr>
		  	<td colspan="4" align="center" style="color:#EEEEEE">
		  		<c:if test="${emailVO.isEffective != 0}">
			  		<input type="radio" name="emailVO.isEffective" value="1" onclick="setUnitsEnabled();" checked="checked"/>启用
			  		<input type="radio" name="emailVO.isEffective" value="0" onclick="setUnitsDisabled();"/>禁用
		  		</c:if>
		  		<c:if test="${emailVO.isEffective == 0}">
			  		<input type="radio" name="emailVO.isEffective" value="1" onclick="setUnitsEnabled();"/>启用
			  		<input type="radio" name="emailVO.isEffective" value="0" checked="checked" onclick="setUnitsDisabled();"/>禁用
		  		</c:if>
		  	</td>
		  </tr>
        <tr>
          <td width="15%" class="tableaddtitle" ><span>*</span>电子邮箱地址</td>
          <td width="85%" class="tableadd_data" >
         <!--  <input id="emailAddress" type="text" class="inputtran" />-->
           <input type="text" name="emailVO.emailAddress" id="emailAddress" class="inputtran" value="${emailVO.emailAddress }"/> 
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle" ><span>*</span>发信服务器地址</td>
          <td class="tableadd_data" >
         
          <input type="text" name="emailVO.smtp" id="smtp" class="inputtran" value="${emailVO.smtp }" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>发件服务器端口</td>
          <td class="tableadd_data" >
          
          <input type="text" name="emailVO.smtpPort" id="smtpPort" class="inputtran" value="${emailVO.smtpPort }" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>邮箱用户名</td>
          <td class="tableadd_data" >
          <input type="text" name="emailVO.userName" id="userName" class="inputtran" value="${emailVO.userName }" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>邮箱密码</td>
          <td class="tableadd_data" >
          <input type="password" name="emailVO.passWord" id="passWord" class="inputtran" value="${emailVO.passWord }"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle" style="vertical-align:top;"><span>*</span>邮件格式</td>
          <td class="tableadd_data" >
         
           <textarea class="areatran" name="emailVO.format" id="format" cols="60" ><c:out value="${emailVO.format}"></c:out></textarea>
          </td>
          </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
          <div class="contenttitle2">
             <h5 class="fwb fl10" style="color:red">邮件格式说明：“##1表示会议名称，##2和##3表示开始和结束时间，##4表示会议室名称”</h5>
          </div>
            <td><input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" name="button" id="button" onclick="emailAdd();"/>
            
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
              </td>
          </tr>
        </tbody>
      </table>
  </form>
</body>

</html>