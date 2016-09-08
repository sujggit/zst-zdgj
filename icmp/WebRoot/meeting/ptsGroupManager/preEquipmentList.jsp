<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.EquipmentEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会议组列表</title>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<script type="text/javascript">
	function templateEquipmentSave(){
		var groupId=$("#groupId").val()
		var input =document.getElementsByTagName("input");
		var list=new Array();
		var j=0;
		for(var i=0;i<input.length;i++){
			if(input[i].type=="checkbox"&&input[i].checked==true&&input[i].value!="selAll"){
			list[j]=input[i].value;
			++j;
		}
	}
	
	DwrMethod.preAddEquipent(groupId,list,back);
	
	}
	
	function back(data){
	window.returnValue=1;
	window.close();
	}
	
	function selAll(all){

	var input =document.getElementsByTagName("input");
	for(var i=0;i<input.length;i++){
	if(all.checked&&input[i].type=="checkbox"&&input[i].style.display!="none"){
	   input[i].checked=true;
	}

if(!all.checked&&input[i].type=="checkbox"&&input[i].style.display!="none"){
	   input[i].checked=false;
	}

	}
	
	
	}
     </script>
</head>
<body style="OVERFLOW: AUTO; OVERFLOW-X: HIDDEN">
	<form action="${sys_ctx}/templateEquipment/MeetingEquipmentQuery.action" method="post" name="pageform" id="pageform">
		<input type="hidden" id="groupId" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}" />
		<div id="basicform" class="contentwrapper" style="overflow:hidden">
			<div class="contenttitle2" >
				<h5 class="fwb fl10">地址薄</h5>
			</div>
			<table border="0" cellspacing="1" cellpadding="0" class="buttoncontainer">
				<tr>
				<td>
					<input type="button" class="submit1 radius2" value="保 存" onclick="templateEquipmentSave();" />
					<input type="button" class="reset1 radius2" value="关 闭" onclick="window.close();" />
					<input type="hidden" id="groupId" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}" />
				</td>
			  </tr>
			</table>
			<table width="100%" cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
				<thead>
					<tr>
						<th class="head1" width="10%">全选<input type="checkbox" value="selAll" onclick="selAll(this)"/></th>
						<th class="head1" width="10%">
							序号
						</th>
						<th class="head1" width="40%">
							参会单位名称
						</th>
						<th class="head1" width="40%">
							ip
						</th>
					</tr>
				</thead>
				<tfoot>
				</tfoot>
				<tbody>
					<c:forEach items="${equipmentVOList}" var="equipmentVO" varStatus="status">
					  <tr>
						<td class="alc">
							<input type="checkbox" name="equipmentID" id="equipmentID" value="${equipmentVO.equipmentID}" />
						</td>
						<td>
							<c:out value="${status.index+1}">
							</c:out>
						</td>
						<td>
							<c:out value="${equipmentVO.equipmentNO}" />
						</td>
						<td>
							<c:out value="${equipmentVO.ip}"></c:out>
						</td>
					  </tr>
					</c:forEach>									
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>
