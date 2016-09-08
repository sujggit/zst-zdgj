<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.MeetingAppConfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <c:set var="auth" value="<%=MeetingAppConfig.PWDAUTH %>"></c:set>
  <title>添加用户 </title>
  <script type="text/javascript">
		function backHistory(){
        	window.location.href="/icmp/user/manageUserList.action";
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
			obj.title("loginName","不能修改");	
			obj.title("name","输入长度不超过25个字符");	
			obj.title("corpName","请选择");	
			if("${auth}"=="false"){
			obj.title("roleID","请选择");
			}
			obj.title("email","请输入正确的邮箱格式");
			obj.title("mobile","请输入手机号码");	
		}
			
		function add(){
			var validator = $("#form").validate({
					rules: {
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
						"userVO.departmentVO.title": {required: true}, 
						"userVO.email":{
//							required:true,
							email:true
						},
						"userVO.mobile":{
							required:true,
							digits:true,
							max:19999999999,
							min:10000000000
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
  </script>
</head>
<body onload="pageInit();">
	<div id="basicform" class="contentwrapper">
		<form action="/icmp/user/modifyUser.action" method="post" name="form" id="form">
			<input type="hidden" name="userVO.userID" value="${userVO.userID }"/>
			<input type="hidden" name="userRoleVO.userRoleID"  value="${userRoleVO.userRoleID }"/>
			<input type="hidden" name="userRoleVO.roleName" id="roleName" value="" />
		  
      <div class="contenttitle2">
        <h5 class="fwb fl10">用户修改</h5>
      </div>
      <!--  <td class="tableaddtitle"><span>*</span>密码</td>-->
          <input name="userVO.passWord" id="password" type="hidden" class="inputtran" value="${userVO.passWord}"/>
          <!-- <td class="tableaddtitle"><span>*</span>密码确认</td>-->
          <input name="passWord2" id="password2" type="hidden" class="inputtran" value="${userVO.passWord}"/>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>用户名</td>
          <td width="35%" class="tableadd_data" ><input id="loginName" type="text" class="inputtran"  value="${userVO.loginName}" onblur="javascript:check('loginName');"  disabled/>
          <input id="loginName" type="hidden" class="inputtran" name="userVO.loginName" value="${userVO.loginName}" /></td>
          <td width="15%" class="tableaddtitle"><span>*</span>姓名</td>
          <td width="35%" class="tableadd_data"><input type="text" class="inputtran" name="userVO.name" id="name" value="${userVO.name}" /></td>
        </tr>
        <tr>
        <c:if test="${!auth}">
          <td class="tableaddtitle"><span>*</span>角色</td>
          <td class="tableadd_data" ><select name="userRoleVO.roleID" class="select200 fontstyle" id="roleID">
								<c:forEach items="${roleVOList}" var="role">
									<option value="${role.roleID}" ${role.roleID==userRoleVO.roleID ? "selected" : "" }>
										${role.roleName }
									</option>
								</c:forEach>
							</select></td>
		</c:if>
          <td class="tableaddtitle" ><span>*</span>验证方式</td>
         <td class="tableadd_data" <c:if test="${auth=='true'}">colspan="3"</c:if>>
          	<select name="userVO.authenticateType" class="select200 fontstyle" onchange="authenticateMatch(this.value);">
          		 <option value="0" ${userVO.authenticateType==0 ? "selected" : "" }>本地验证</option>
          		 <option value="1" ${userVO.authenticateType==1 ? "selected" : "" }>集中验证</option>
          	</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>手机</td>
          <td class="tableadd_data" ><input name="userVO.mobile" id="mobile" type="text" class="inputtran" value="${userVO.mobile}"/></td>
          <td class="tableaddtitle">邮箱</td>
          <td class="tableadd_data"><input name="userVO.email" id="email"type="text" class="inputtran" value="${userVO.email}"/></td>
        </tr>
        <tr>
 		  <td class="tableaddtitle"><span>*</span>部门</td>
          <td class="tableadd_data">
          <input type="hidden" name="userVO.departmentVO.id" id="corpID" value="${userVO.departmentVO.id }" />
          <input name="userVO.departmentVO.title" id="corpName" type="text" class="inputtran" onclick="selectDepartments(this);" value="${userVO.departmentVO.title }" readonly="readonly"/></td>
 
          <td class="tableaddtitle">岗位</td>
          <td class="tableadd_data">
			<select name="userPostVO.postNO" class="select200 fontstyle" id="postNO">
                <option value="">请选择...</option>
				<c:forEach items="${postVOList}" var="post">
					<option value="${post.postNO}" ${post.postNO==userPostVO.postNO ? "selected" : "" }>
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
            <td align="right">
              <input type="button" class="submit1 radius2" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>