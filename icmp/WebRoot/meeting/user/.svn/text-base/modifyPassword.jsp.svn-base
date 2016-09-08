<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp" %>
	<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
	<style>
		.pw-strength {background-color: #FFD099;height: 14px; margin-top: 3px; overflow: hidden;position: relative;width: 183px}
		.pw-weak .pw-bar {width: 60px;}
		.pw-bar {background-color: #FF6600;height: 14px;overflow: hidden;transition: all 0.4s linear 0s;}
		.pw-letter {left:0;position:absolute;top:0;}
		.pw-strength span {border-right: 1px solid #FFFFFF;color: #FFFFFF;display: inline;float:left;font-size:12px;height:14px;line-height:14px;text-align:center;width:60px;}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<title>密码修改</title>
	<script type="text/javascript">
		//add by yangyi
		//取消按钮
		function backHistory(){
			window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
		}
		
		//add by yangyi
		function pageInit(){
		    var obj = new htmlUtil();
		    
			obj.title("name","不能修改");	
			obj.title("passwordOld","请输入正确的原密码");
			//obj.title("passwordNew","新密码合法长度为6-25个字符");	
			obj.title("password2","请确认两次输入的新密码一致");

			if('${userVO.authenticateType}' == 1){
				$("#buttonId").attr("disabled", "disabled");
			}
		}
		
		//modify by yangyi
		function add(){
			var validator = $("#form").validate({
						rules: {
							"userVO.loginName":{
								required: true,
								minlength:1,
				           		maxlength:25
				           		},
				           		
							"passwordOld": {
								required: true,
								minlength:2,
				           		maxlength:25
				           		//passwdChk: true,
					//			equalTo:'#password'
								},
							"userVO.passWord":    {
								required: true,
								minlength:6,
				           		maxlength:25
				           		//passwdChk: true
				           		},
							"passWord2":   {
								required: true,
								minlength:6,
				           		maxlength:25,
				           		equalTo:'#passwordNew'
				           		}
					  	},
					//  	messages:{passwordOld:{equalTo:"原始密码输入不正确"}}
					});
				$("#form").submit();
			}

		function checkStrong(id){
			var str = document.getElementById(id).value;
			var strongLev;
			if(str.length<10){
				strongLev = 1;
			}else{
				strongLev = (/\d+/i.test(str) ? 1 : 0) + (/[a-z]+/i.test(str) ? 1 : 0)  + ( str.replace(/\d+/g).replace(/[a-z]+/ig)=='undefined' ? 0 : 1);
			}
			if(strongLev<=1){
				$("#"+id+"_L").attr("class","pw-bar");
				$("#"+id+"_M").removeClass("pw-bar");
				$("#"+id+"_H").removeClass("pw-bar");
				$("#promptSpan").html("新密码长度为10~25个字符，请使用字母加数字或符号的组合密码");
				$("#submitBtn").attr("disabled","disabled");
				return strongLev;
			}else if(strongLev == 2){
				$("#"+id+"_L").attr("class","pw-bar");
				$("#"+id+"_M").attr("class","pw-bar");
				$("#"+id+"_H").removeClass("pw-bar");
				$("#promptSpan").html("");
				$("#submitBtn").removeAttr("disabled");
				return strongLev;
			}else if(strongLev == 3){
				$("#"+id+"_L").attr("class","pw-bar");
				$("#"+id+"_M").attr("class","pw-bar");
				$("#"+id+"_H").attr("class","pw-bar");
				$("#promptSpan").html("");
				$("#submitBtn").removeAttr("disabled");
				return strongLev;
			}
		}

		$(document).ready(function(){
			var pwdAuth = document.getElementById("pwdAuth");
			if(pwdAuth.value == "true"){
				$("#J_PwdStrength").prev().remove();
				$("#J_PwdStrength").before("<input type='password' class='inputtran' id='passwordNew' name='userVO.passWord' onkeydown='checkStrong(\"passwordNew\")' onkeyup='checkStrong(\"passwordNew\")' onblur='checkStrong(\"passwordNew\")' title='10~25个字符，请使用字母加数字或符号的组合密码'/>");
			}else{
				$("#J_PwdStrength").remove();
			}
		})	
		
		<%--判断原始密码是否正确--%>
		function checkPassword(id){
		   var b=document.getElementById("userID");
		   var a=document.getElementById(id);
		   if(a.value==""||a.value==null){
			 return;
		   }
		   DwrMethod.checkPassword(a.value,b.value,callback);
		}
			
	    function callback(lst){
	    	if(lst==false){
		    	alert("请输入正确的原始密码");
		    	document.getElementById("passwordOld").value="";  	
	    	}			
 		}	
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
  <form action="${sys_ctx }/user/modifyUserPassword.action" method="post" name="form" id="form">
    <input type="hidden" id="pwdAuth" value="<%=MeetingAppConfig.PWDAUTH %>"/>
	<input type="hidden" name="userVO.userID" value="${userVO.userID }" id="userID"/>
	<input type="hidden" name="userRoleVO.userRoleID"  value="${userRoleVO.userRoleID }" />
	<input type="hidden" name="userRoleVO.roleName" id="roleName" value="${userRoleVO.roleName}" />
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">修改密码&nbsp;&nbsp;&nbsp;&nbsp;(注：集中验证的账号密码不能在此修改！)</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle" >用户名</td>
          <td width="85%" class="tableadd_data" >
          <input type="text" class="inputtran inputtran_gray"  id="name" value="${userVO.loginName}" disabled="disabled" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle" ><span>*</span>原密码</td>
          <td class="tableadd_data" >
          <input type="password" class="inputtran" name="passwordOld" id="passwordOld" onblur="javascript:checkPassword('passwordOld');"/>
		  <input type="hidden" name="password" id="password" value="${userVO.passWord}"/> 
          
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>新密码</td>
          <td class="tableadd_data">
          	<input type="password" class="inputtran" id="passwordNew" name="userVO.passWord" title="新密码合法长度为6-25个字符"/>
			<div id="J_PwdStrength" class="pw-strength pw-weak" title="10~25个字符，请使用字母加数字或符号的组合密码，不能单独使用字母、数字或符号。">
				<div class="pw-bar"></div>
				<div class="pw-letter">
					<span id="passwordNew_L">弱</span>
					<span id="passwordNew_M">中</span>
					<span id="passwordNew_H">强</span>
				</div>
			</div>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>密码确认</td>
          <td class="tableadd_data" >
           <input name="passWord2" class="inputtran" type="password"	id="password2" />
          </td>
          </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
              <input type="button" id="submitBtn" class="submit1 radius2" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div style="height:200px;"></div>
  </form>
</body>
</html>
