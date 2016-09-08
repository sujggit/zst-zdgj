<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentBackupVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript">
function addTerminalBackup(){
window.location.href="${sys_ctx}/equipmentBackup/terminalquery.action";
}
function terminalBackupqueryDel(equipmentid,backupID){
if(!window.confirm("是否确认删除？")) return;
 window.location.href="${sys_ctx}/equipmentBackup/terminalBackupqueryDel.action?equipmentBackupVO.equipmentID="+equipmentid+"&equipmentBackupVO.backupEquipmentID="+backupID;
 
}

</script>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/equipmentBackup/terminalBackupquery.action" id="pageform" name="pageform" method="post">
        
				<div id="basicform" class="contentwrapper">     
			<div id="m" style="border:none;background:none">
				<%@include file="./head.jsp"%>
			</div>
			

			
				<div class="contenttitle2">
                <h5 class="fwb fl10">查询列表&nbsp;&nbsp; </h5>
                <h5 class="fwb fr10">
					<a onclick="addTerminalBackup()">增加</a>
				</h5>
                </div>
		
			<div>
				<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
					id="query_table">
					<thead>

						<tr>
							<th width="10%" class="head1">
								序号
							</th>
							<th width="40%" class="head1">
								备份终端
							</th>
							<th width="40%" class="head1">
					 			主用终端
							</th> 
							<th width="10%" class="head1">
								操作
							</th>

						</tr>

					</thead>
					<tfoot></tfoot>
					<tbody>
					
						   <c:forEach items="${equipmentBackupVOList}" var="equipmentBackupVO" 	varStatus="state">
                        <tr>
                           <td class="alc">${state.index+1}</td>
                            <td>${equipmentBackupVO.backupEquipmentName}(${equipmentBackupVO.backupip})</td>
                            <td>${equipmentBackupVO.equipmentName}(${equipmentBackupVO.ip})</td>
                           <td class="alc">
                             <!--<a style="cursor:pointer" >修改</a> |  -->
          	                 <a onclick="javascript:terminalBackupqueryDel('${equipmentBackupVO.equipmentID}','${equipmentBackupVO.backupEquipmentID}');" style="cursor:pointer" >删除</a>
          	    	    </td>
                        </tr> 
                    </c:forEach>
					</tbody>
					 <jsp:include page="/common/pageFooter.jsp"/>
				</table>
			</div>     

			<!--contenttitle-->
</div>
		</form>
	</body>

</html>