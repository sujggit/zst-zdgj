<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>修改个人信息</title>		
  <script type="text/javascript">
		function backHistory(){
        	window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
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
			obj.title("corpName","不能修改");	
			obj.title("email","请输入正确的邮箱格式");
			obj.title("mobile","请输入手机号码");	
			
			
		};
		function modifyPersonConfig(){
			var validator = $("#modifyForm").validate({
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
		var x=document.getElementById("roleID")
		$("#modifyForm").submit();
	}	
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
  <form action="/icmp/personConfig/modifyPersonConfig.action" method="post" name="modifyForm" id="modifyForm">
	<div id="basicform" class="contentwrapper"> 
	<input type="hidden" name="userVO.userID" value="${userVO.userID }"/>
	<input type="hidden" name="userVO.passWord" value="${userVO.passWord }" />

    <div class="contenttitle2">
        <h5 class="fwb fl10">修改个人信息</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>用户名</td>
          <td width="35%" class="tableadd_data" >
          <input  class="inputtran inputtran_gray"  readonly="readonly" type="text" id="loginName" name="userVO.loginName" value="${userVO.loginName}" />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>姓名</td>
          <td width="35%" class="tableadd_data">
          <input  class="inputtran" type="text" id="name"  name="userVO.name"  value="${userVO.name}" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>部门</td>
          <td class="tableadd_data" >
          <input type="hidden" name="userVO.departmentVO.id" id="corpID" 	value="${userVO.departmentVO.id }" />
		  <input type="text" class="inputtran inputtran_gray" readonly="readonly" id="corpName" name="userVO.departmentVO.title" value="${userVO.departmentVO.title}" />
          </td>
          <td class="tableaddtitle"><span>*</span>手机</td>
          <td class="tableadd_data"><input  class="inputtran" type="text" id="mobile" name="userVO.mobile"  value="${userVO.mobile}" /></td>
        </tr>
         <tr>
          <td class="tableaddtitle">邮箱</td>
          <td colspan="3" class="tableadd_data" >
          <input name="userVO.email" class="inputtran" type="text" id="email" value="${userVO.email }"/>
          
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="modifyPersonConfig();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    <div style="height:200px;"></div>
    </div>
  </form>
</body>
</html>