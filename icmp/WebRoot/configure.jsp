<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>配置</title>
<script type="text/javascript">
	function saveConfiguration(){

		var objArray = new Array();
		$(".most").each(function(i){
		//alert(i);
		//	var obj = new Object();
			
		//	obj.key = $(this).attr("id");
			
		//	obj.value = $(this).val();
			objArray.push($(this).attr("id")+"__"+$(this).val());
		});
		
		DwrMethod.modifyConfiguration(objArray,function(data){
			if(data){
				alert("保存成功！");
				window.location.reload();
			}else{
				alert("保存失败！");
			}
			
		});
	}


</script>
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
	<div id="basicform" class="contentwrapper">
    	<div class="contenttitle2"><h5 class="fwb fl10">配置</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<c:forEach items="${map}" var="configure">
        	<tr>
          		<td class="tableaddtitle" style="width:20%">${configure.key}</td>
          		<td class="tableadd_data"><input type="text" class="most" value="${fn:split(configure.value,',')[0] }" id="${configure.key}" style="width:80%" /></td>
        	    <td class="tableadd_data"> ${fn:split(configure.value,',')[1] }</td>
        	</tr>
        	</c:forEach>
        	
		</table>
		
    	<div class="contenttitle2"><h5 class="fwb fl10">主数据源配置</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<c:forEach items="${map1}" var="configure1">
        	<tr>
          		<td class="tableaddtitle" style="width:20%">${configure1.key }</td>
          		<td class="tableadd_data"><input type="text" class="most" value="${configure1.value }" id="${configure1.key}" style="width:80%" /></td>
        	</tr>
        	</c:forEach>
		</table>
		<div class="contenttitle2"><h5 class="fwb fl10">备（从）数据源配置</h5></div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<c:forEach items="${mapBak}" var="configurebak">
        	<tr>
          		<td class="tableaddtitle" style="width:20%">${configurebak.key }</td>
          		<td class="tableadd_data"><input type="text" class="most" value="${configurebak.value }" id="${configurebak.key}" style="width:80%" /></td>
        	</tr>
        	</c:forEach>
		</table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	<tfoot>
          	</tfoot>
          	<tbody>
            	<tr>
              		<td><input type="button" class="submit1 radius2" value="保存" onclick="saveConfiguration()"/></button></td>
            	</tr>
       		</tbody>
        </table>
	</div>
</form>
</body>
</html>