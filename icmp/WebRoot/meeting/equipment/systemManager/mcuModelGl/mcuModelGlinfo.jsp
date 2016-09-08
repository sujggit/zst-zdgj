<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@ page import="com.zzst.model.enums.UserEnum" %>
<%@ page import="com.zzst.model.meeting.user.UserVO" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>

		<title>MCU备份模板对应关系</title>
		<link rel="stylesheet" href="split.css" type="text/css" />
		 <script type="text/javascript">  
	      function save(formobj){
	      if(document.getElementById("mainMcuID").value=="")return alert('空值无法提交!');
	      if(document.getElementById("backMcuID").value=="")return alert('空值无法提交!');
	      formobj.submit();
	      }
	      
	      function modeDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/equipmentBackup/delMcuModelGl.action?mcuCascadeModelVO.cascadeID="+id;
			}
	      </script>
		
		
	</head>

	<body>
		<div class="contentwrapper">
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					MCU备份模板对应关系
				</h5>
			</div>
			<form id="form1" name="form1" action="/icmp/equipmentBackup/addMcuModelGl.action" method="post">
			<input type="hidden" name="equipmentBackupVO.equipmentName" id="equipmentBackupVOequipmentName" value="${equipmentBackupVO.equipmentName }"/>
			<input type="hidden" name="equipmentBackupVO.backupEquipmentName" id="equipmentBackupVObackupEquipmentName" value="${equipmentBackupVO.backupEquipmentName }" />
			<input type="hidden" name="equipmentBackupVO.ip" id="equipmentBackupVOip" value="${equipmentBackupVO.ip }"/>
			<input type="hidden" name="equipmentBackupVO.backupip" id="equipmentBackupVObackupip" value="${equipmentBackupVO.backupip }" />
			
				<div id="container">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="stdtable" id="query_table">
						 	<thead>
						<tr>
						<td class="head1" width="10%">
						序号		
						</td>
							<td class="head1" width="40%">
								主MCU:${equipmentBackupVO.equipmentName}
								</td>
							<td class="head1" width="40%">
								备MCU:${equipmentBackupVO.backupEquipmentName }
							</td>
							<td class="head1" width="10%">操作</td>
						</tr>
						</thead>
						<tbody>
						 <c:forEach items="${mcuModelList}" var="mml" 	varStatus="state">
						 <tr>
						 <td>${state.index+1 }</td>
						 <td class="alc">${fn:split(mml.modelName,",")[0] }</td>
						 <td class="alc">${fn:split(mml.modelName,",")[1] }</td>
						 <td class="alc"><img src="${sys_ctx}/images/screenModel/infopub_11.jpg" onclick="modeDele('${mml.cascadeID }');" /></td>
						 </tr>
						 </c:forEach>
						</tbody>
						 	<tfoot>
						<tr>
						<td class="alc">&nbsp;</td>
							<td  class="alc">
								<select id="mainMcuID" name="baseInfoVO.infoValue" style="width:80%" >
			      		
			      	  <c:forEach items="${mainMucList}" var="bav" 	varStatus="state">
			      		<option value="${bav.infoValue },${bav.description }">
			      		${bav.description }
			      		</option>
			      	</c:forEach>
		            </select>
							</td>
							<td class="alc">
								<select id="backMcuID" name="baseInfoVO.description" style="width:80%">
						<c:forEach items="${backMucList}" var="bav" 	varStatus="state">
			      		<option value="${bav.infoValue },${bav.description }">
			      		${bav.description }
			      		</option>
			      	</c:forEach>
								</select>
							</td>
							<td class="alc">
								<img src="${sys_ctx}/images/screenModel/plus.gif" onclick="save(document.form1);" />
							</td>
						</tr>
                       </tfoot>
					</table>
				</div>

			</form>

		</div>
	</body>
</html>
