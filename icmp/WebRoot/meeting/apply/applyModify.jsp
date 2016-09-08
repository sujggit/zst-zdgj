<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>审批节点修改 </title>
    <%@include file="/common/common.jsp"%>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
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
	   	 $("#departmentID").attr("value",departmentID);
	     $("#departmentName").attr("value",departmentName);
	   }

		function backHistory(){
		   	window.location.href="${sys_ctx}/apply/queryApplys.action";
		}
		
		function pageInit(){
		    var obj = new htmlUtil();
		    obj.title("applyName","输入长度不超过25个字符");	
			obj.title("departmentName","请选择部门");
			obj.title("applyType","请选择流程类别");
			obj.title("description","输入长度不超过200个字符");
		}
			
		function modify(){
			$('#form').validate({    
				rules:{ 
					"applyVO.applyName":{
						required: true,
						minlength:1,
		           		maxlength:25
	           		},
					"applyVO.departmentName":{
						required: true
		           		},
		           	"applyVO.applyType":{
		           		required: true
		           	},
			        "applyVO.description":{
		           		maxlength:200
				    }
				  }
				});
			$("#form").submit();
		}
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit(); ">
<form action="${sys_ctx}/apply/modifyApply.action" method="post" name="form" id="form">
<div class="contenttitle2">
    <h5 class="fwb fl10">审批流程修改</h5>
</div>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>流程名称：</td>
          <td width="35%" class="tableadd_data" >
          <input class="inputtran" type="text" name="applyVO.applyName" id="applyName" value="${applyVO.applyName }" />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>所属单位：</td>
          <td width="35%" class="tableadd_data">
	          <input class="inputtran" onclick="selectDepartments(this);" id="departmentName"  name="applyVO.departmentName" type="text" readonly="readonly" value="<zzst:lable type="department" value="${applyVO.departmentID}"></zzst:lable>" />
	          <input id="departmentID"  name="applyVO.departmentID" type="hidden" value="${applyVO.departmentID}"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>流程类别：</td>
          <td class="tableadd_data" colspan="3">
          	<select name="applyVO.applyType" id="applyType">
				<zzst:option type="applyType" value="${applyVO.applyType }"/>
			</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">描述信息：</td>
          <td colspan="3" class="tableadd_data" ><textarea name="applyVO.description" class="areatran" id="description">${applyVO.description }</textarea></td>
        </tr>
        <input class="input200 fontstyle" id="applyID"  name="applyVO.applyID" type="hidden" value="${applyVO.applyID }"/>
   		<input class="input200 fontstyle" id="createUserID"  name="applyVO.createUserID" type="hidden" value="${applyVO.createUserID}"/>
   		<input class="input200 fontstyle" id="createTime"  name="applyVO.createTime" type="hidden" value="${applyVO.createTime }"/>
   		<input class="input200 fontstyle" id="status"  name="applyVO.status" type="hidden" value="${applyVO.status}"/>
   		<input class="input200 fontstyle" id="revision"  name="applyVO.revision" type="hidden" value="${applyVO.revision}"/>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="modify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
  </form>
</body>
</html>