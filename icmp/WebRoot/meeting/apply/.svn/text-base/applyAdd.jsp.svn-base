<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>审批流程添加 </title>
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
		
		function add(){
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
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
	<div id="basicform" class="contentwrapper">
	<form action="${sys_ctx }/apply/addApply.action" method="post" name="form" id="form">
      <div class="contenttitle2">
        <h5 class="fwb fl10">审批流程添加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>流程名称：</td>
          <td width="35%" class="tableadd_data" ><input type="text" name="applyVO.applyName" id="applyName" value="${applyFlowVO.flowName}" class="inputtran" /></td>
          <td width="15%" class="tableaddtitle"><span>*</span>所属单位：</td>
          <td width="35%" class="tableadd_data">
          	<input type="hidden" id="departmentID"  name="applyVO.departmentID" value="" />
            <input id="departmentName"  name="applyVO.departmentName" type="text" class="inputtran" onclick="selectDepartments(this);" readonly="readonly"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>流程类别：</td>
          <td class="tableadd_data" colspan="3">
			<select name="applyVO.applyType" id="applyType">
			  <zzst:option type="applyType" value=""/>
   			</select>
		  </td>
        </tr>
        <tr>
          <td class="tableaddtitle">描述信息：</td>
          <td colspan="3" class="tableadd_data"><textarea class="areatran" name="applyVO.description" id="description"></textarea></td>
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