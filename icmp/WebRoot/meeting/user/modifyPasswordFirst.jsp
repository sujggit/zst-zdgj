<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'></script>
	<title>密码修改</title>
	<style>
		.pw-strength {background-color: #FFD099;height: 14px; margin-top: 3px; overflow: hidden;position: relative;width: 183px}
		.pw-weak .pw-bar {width: 60px;}
		.pw-bar {background-color: #FF6600;height: 14px;overflow: hidden;transition: all 0.4s linear 0s;}
		.pw-letter {left:0;position:absolute;top:0;}
		.pw-strength span {border-right: 1px solid #FFFFFF;color: #FFFFFF;display: inline;float:left;font-size:12px;height:14px;line-height:14px;text-align:center;width:60px;}
	</style>
	<script type="text/javascript">
			function selectDepartments(thisDom){
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectType:'radio',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
			
		    function getReturnDepartMethod(departList){
		    	var departmentID="";
	            var departmentName="";
	            var depLength = departList.length;
	            for(var i=0;i<depLength;i++){
	              departmentID+=departList[i].departmentID;
	              departmentName+=departList[i].departmentName;
	              //alert(departList[i].departmentName+" + "+departList[i].departmentID);
	            }
	          	$("#corpID").attr("value",departmentID);
               	$("#corpName").attr("value",departmentName);
		    }
			
			function pageInit(){
			    var obj = new htmlUtil();
			    
				obj.title("name","不能修改");	
				obj.title("passwordOld","请输入正确的原密码");
				obj.title("passwordNew","新密码合法长度为6-25个字符");	
				obj.title("password2","请确定两次输入的新密码一致");
			}
			
			function add(id){
			 var passWordOld=document.getElementById("passwordOld").value;
			  var password=document.getElementById("password").value;
			 var passWordNew=document.getElementById("passwordNew").value;
		     var passWord2=document.getElementById("password2").value;
		     var promptSpan = document.getElementById("promptSpan");
			 var  userId; 
	         userId=id;
			var delayed = 3000;		
				if(passWordOld==""){
					   // alert("请输入原密码");
					   promptSpan.innerHTML="*原密码不能为空";
					  setTimeout("clearSpan()",delayed);
					    return false;
					    
					  }else if(passWordOld!=password){
						  promptSpan.innerHTML="*原密码不正确";
						  setTimeout("clearSpan()",delayed);
					    return false;
					  }
					
					  else if(passWordNew==""||passWordNew==null){
					 //alert("新密码不能为空");
					 promptSpan.innerHTML="*新密码不能为空";
					 setTimeout("clearSpan()",delayed);
					  return false;
					 }
					 else if(passWordNew.length<6||passWordNew.length>25){
					 //alert("密码合法长度为1-25个字符");
					 promptSpan.innerHTML="*密码合法长度为6-25个字符";
					 setTimeout("clearSpan()",delayed);
					  return false;
					 } else if(passWord2!==passWordNew){
					  //alert("您输入的新密码和密码确认不一致");
					  promptSpan.innerHTML="*您输入的两次新密码不一致";
					  setTimeout("clearSpan()",delayed);
					  return false;
					  
					  }
					UserAction.modifyPasswordFirst(userId,passWordNew,callback);
				}
			
				function callback(){
					window.close();
				}

				function clearSpan(){
					document.getElementById("promptSpan").innerHTML = "";
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
		</script>
	</head>
  	<body onload="pageInit();" style='OVERFLOW:auto;OVERFLOW-X:HIDDEN'>
  	  <input type="hidden" id="pwdAuth" value="<%=MeetingAppConfig.PWDAUTH %>"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">修改密码</h5>
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
          <input type="password" class="inputtran" name="passwordOld" id="passwordOld" />
		  <input type="hidden" name="password" id="password" value="${userVO.passWord}"/> 
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>新密码</td>
          <td class="tableadd_data" >
          <input type="password" class="inputtran" id="passwordNew" name="userVO.passWord" />
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
           <input name="passWord2" class="inputtran" type="password" id="password2" />
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
              <input type="button" class="submit1 radius2" id="submitBtn" value="确 定" onclick="add('${userVO.userID}');"/>
            </td>
          </tr>
        </tbody>
      </table>
	</body>
</html>


