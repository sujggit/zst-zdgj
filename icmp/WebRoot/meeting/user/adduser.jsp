<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <c:set var="auth" value="<%=MeetingAppConfig.PWDAUTH %>"></c:set>
  <title>添加用户 </title>
  <script type="text/javascript">
		function backHistory(){
        	window.location.href="${sys_ctx}/user/manageUserList.action";
        }
		
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
			obj.title("loginName","输入长度不超过25个字符");	
			obj.title("name","输入长度不超过25个字符");	
			obj.title("corpName","请选择");	
			if("${auth}"=="false"){
				obj.title("roleID","请选择");
			}
			obj.title("email","请输入正确的邮箱格式");	
			obj.title("mobile","请输入手机号码");
			obj.title("password","新密码合法长度为6-25个字符");	
			obj.title("password2","请确认两次输入的新密码一致");
		}
		
		function add(){
			$('#form').validate({    
			rules:{ 
					"userVO.name":{
						required: true,
						minlength:1,
		           		maxlength:25
		           		},
					"userVO.loginName":    {
						required: true,
						minlength:1,
		           		maxlength:25
		           		},
					"userDepartmentVO.departmentVO.title": {required: true}, 
					"userVO.email":{
					//	required: true,
						email:true
					},
					"userVO.mobile":{
						required:true,
						digits:true,
						max:19999999999,
						min:10000000000
					},
					
					"userRoleVO.roleID":{
					  required: true,
						minlength:1
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
		           		equalTo:'#password'
		           		}
			  	}
			});
				
			//部门
			if("${auth}"=="false"){
			var x=document.getElementById("roleID")
			var roleName = document.getElementById('roleName');
			roleName.value = x.options[x.selectedIndex].text;
			}
			$("#form").submit();
		}
		<%--判断用户名是否唯一--%>		
		function check(id){
		   var a=document.getElementById(id);	  
		   if(a.value==""||a.value==null){
			 return;
		   }
		   DwrMethod.checkUserName(a.value,callback);
		}
			
	    function callback(lst){
	    	if(lst.length > 0){
		    	alert("此用户名已被占用");
		    	document.getElementById("loginName").value="";  	
	    	}			
 		}
 		function textCounter( maxlimit){  
		    var length = document.form.description.value.length;
		    var description = document.form.description.value; 
		   
		    if (length > maxlimit)  
		     //如果元素区字符数大于最大字符数，按照最大字符数截断；  
		      form.description.value = form.description.value.substring(0, maxlimit);  
		
		      //在记数区文本框内显示剩余的字符数；  
		       var countfield = document.getElementById("remLen");
		       if(maxlimit - length>=0)
		     countfield.value = maxlimit - length;  
		} 			

 		function authenticateMatch(authenType){
			if(authenType == 1){
				$("#password").attr("readonly", "readonly");
				$("#password2").attr("readonly", "readonly");
			}else{
				$("#password").removeAttr("readonly");
				$("#password2").removeAttr("readonly");
			}
 		}
  </script>
</head>
<body onload="pageInit();">
  <div id="basicform" class="contentwrapper">
    <form action="${sys_ctx }/user/addUser.action" 	method="post" name="form" id="form">
	  <input type="hidden" name="userRoleVO.roleName" id="roleName" value="" />
      <div class="contenttitle2">
        <h5 class="fwb fl10">用户增加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>用户名</td>
          <td width="35%" class="tableadd_data" ><input id="loginName" type="text" class="inputtran" name="userVO.loginName" onblur="javascript:check('loginName');" /></td>
          <td width="15%" class="tableaddtitle"><span>*</span>姓名</td>
          <td width="35%" class="tableadd_data"><input  type="text" class="inputtran" name="userVO.name" id="name" /></td>
        </tr>
        <tr>
       	<c:if test="${!auth}">
          <td class="tableaddtitle" ><span>*</span>角色</td>
          <td class="tableadd_data"><select name="userRoleVO.roleID" class="select200 fontstyle" id="roleID">
                                 <option value="">请选择...</option>
								<c:forEach items="${roleVOList}" var="role">
									<option value="${role.roleID}">
										${role.roleName }
									</option>
								</c:forEach>
							</select>
		  </td>
		</c:if>
          <td class="tableaddtitle" ><span>*</span>验证方式</td>
          <td class="tableadd_data"  <c:if test="${auth=='true'}">colspan="3"</c:if>>
          	<select name="userVO.authenticateType" class="select200 fontstyle" onchange="authenticateMatch(this.value);">
          		 <option value="0" selected="selected">本地验证</option>
          		 <option value="1">集中验证</option>
          	</select>
          </td>
         </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>密码</td>
          <td class="tableadd_data" ><input name="userVO.passWord" id="password" type="password" class="inputtran" value="<%=MeetingAppConfig.PWDINIT %>"/></td>
          <td class="tableaddtitle"><span>*</span>密码确认</td>
          <td class="tableadd_data"><input name="passWord2" id="password2" type="password" class="inputtran" value="<%=MeetingAppConfig.PWDINIT %>"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>手机</td>
          <td class="tableadd_data" ><input name="userVO.mobile" id="mobile" type="text" class="inputtran" /></td>
          <td class="tableaddtitle">邮箱</td>
          <td class="tableadd_data"><input name="userVO.email" id="email"type="text" class="inputtran" /></td>
        </tr>
         <tr>
          <td class="tableaddtitle"><span>*</span>部门</td>
          <td class="tableadd_data">
          <input type="hidden" name="userDepartmentVO.departmentVO.id" id="corpID" value="" />
          <input name="userDepartmentVO.departmentVO.title" id="corpName" type="text" class="inputtran" onclick="selectDepartments(this);" readonly="readonly"/></td>

          <td class="tableaddtitle">岗位</td>
          <td class="tableadd_data">
			<select name="userPostVO.postNO" class="select200 fontstyle" id="postNO">
                <option value="">请选择...</option>
				<c:forEach items="${postVOList}" var="post">
					<option value="${post.postNO}">
						${post.postName }
					</option>
				</c:forEach>
			</select>
		  </td> 
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>