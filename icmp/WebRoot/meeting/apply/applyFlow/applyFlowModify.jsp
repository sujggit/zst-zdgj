<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zzst.model.enums.ApplyEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <%@include file="/common/common.jsp"%>
    <title>审批流程修改 </title>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
	<div id="basicform" class="contentwrapper">
	  <form action="${sys_ctx }/applyFlow/modifyApplyFlow.action" method="post" name="form" id="form">
	    <input id="flowID"  name="applyFlowVO.flowID" type="hidden" value="${applyFlowVO.flowID }"/>
	  	<div class="contenttitle2">
	      <h5 class="fwb fl10">审批流程修改</h5>
	  	</div>
  		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		    <tr>
		      <td width="25%" class="tableaddtitle"><span>*</span>流程名称</td>
		      <td width="75%" class="tableadd_data" ><input name="applyFlowVO.flowName" id="flowName" value="${applyFlowVO.flowName}" class="inputtran" /></td>
		    </tr>
		    <tr>
		      <td class="tableaddtitle"><span>*</span>流程类别</td>
		      <td class="tableadd_data">
				<select name="applyFlowVO.flowType" id="flowType" style="margin-top:5px">
				 <c:forEach items="${dictionaryList}" var="dictionaryVO" varStatus="state">
			   		  <option value="${dictionaryVO.dicValue}" ${applyFlowVO.flowType==dictionaryVO.dicValue ? "selected" : "" }><c:out value="${dictionaryVO.dicViewName}"/></option>
			     </c:forEach>
				</select>
			  </td>
		    </tr>
		    <tr>
	          <td class="tableaddtitle">启用状态</td>
	          <td class="tableadd_data">
	          	<input type="radio" name="applyFlowVO.status" value="<%=ApplyEnum.STATUS_USE %>" <c:if test="${applyFlowVO.status==0}">checked="checked"</c:if> />启用
	          	<input type="radio" name="applyFlowVO.status" value="<%=ApplyEnum.STATUS_STOPUSE %>" <c:if test="${applyFlowVO.status==1}">checked="checked"</c:if>/>禁用
	          </td>
	        </tr>
		    <tr>
		      <td class="tableaddtitle">描述信息</td>
		      <td class="tableadd_data"><textarea class="areatran" name="applyFlowVO.description" id="description">${applyFlowVO.description}</textarea></td>
		    </tr>
		  </table>
		  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		    <tfoot>
		    </tfoot>
		    <tbody>
		      <tr>
		        <td>
		        	<input type="submit" class="submit1 radius2" value="确 定" onclick="modify();"/>
		            <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
		        </td>
		      </tr>
    	    </tbody>
  		  </table>
		</form>
	</div>
	<script type="text/javascript">
	    function backHistory(){
	    	window.location.href="${sys_ctx}/applyFlow/queryApplyFlows.action";
	    }
		
		function pageInit(){
		    var obj = new htmlUtil();
			obj.title("flowName","输入长度不超过25个字符");
			obj.title("flowType","请选择流程");		
			obj.title("description","输入长度不超过300个字符");
		}
		
		function modify(){
			$('#form').validate({    
			rules:{ 
					"applyFlowVO.flowName":{
						required: true,
						minlength:1,
		           		maxlength:25
		           	},
					"applyFlowVO.flowType":{
	           			required: true
	           		},
		           	"applyFlowVO.description":{
		           		maxlength:300
				    }
			  	}
			});
			$("#form").submit();
		}
	</script>
</body>
</html>