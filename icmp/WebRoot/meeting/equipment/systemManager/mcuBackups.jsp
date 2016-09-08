<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentBackupVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <%@include file="/common/common.jsp"%>
    <script type="text/javascript">
		function add(){
		  window.location.href="${sys_ctx}/equipmentBackup/mcuquery.action";
		}
	    function delBackup(equipmentid,backupID){
		  if(!window.confirm("是否确认删除？")) return;
		  window.location.href="${sys_ctx}/equipmentBackup/mcuBackupqueryDel.action?equipmentBackupVO.equipmentID="+equipmentid+"&equipmentBackupVO.backupEquipmentID="+backupID;
	    }    
	      function modelBackGl(equipmentid,backupID){
	    window.open("${sys_ctx}/equipmentBackup/mcuBackGl.action?equipmentBackupVO.equipmentID="+equipmentid+"&equipmentBackupVO.backupEquipmentID="+backupID, "window",'Width=700px,Height=500px,scrollbars=yes');     
						}      
    </script>
  </head>
  <body>
    <form action="${sys_ctx }/equipmentBackup/mcuBackupquery.action" id="pageform" name="pageform" method="post">
	  <div id="basicform" class="contentwrapper">       
         <div id="m" style="border:none;background:none">
           <%@include file="./head.jsp"%>
         </div>
                
         <div class="contenttitle2">
            <h5 class="fwb fl10">查询列表&nbsp;&nbsp; </h5>
            <h5 class="fwb fr10"><a onclick="add()" style="cursor: pointer;">增加</a></h5>
         </div>
		<div>
			<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
				id="query_table">
				<thead>
				  <tr>
					 <th width="8%" class="head1">序号</th>
					  <th width="41%" class="head1">主MCU</th>
                     <th width="41%" class="head1">备份MCU</th>
                     <th width="10%" class="head1">操作</th>
				  </tr>
				</thead>
				<tfoot>
				</tfoot>
				<tbody>
                   <c:forEach items="${equipmentBackupVOList}" var="equipmentBackupVO" 	varStatus="state">
                      <tr>
                         <td class="alc">${state.index+1}</td>
                         <td>${equipmentBackupVO.equipmentName}(${equipmentBackupVO.ip})</td>
                         <td class="alc">${equipmentBackupVO.backupEquipmentName}(${equipmentBackupVO.backupip})</td>
                         <td class="alc">
	        	        	<a onclick="javascript:delBackup('${equipmentBackupVO.equipmentID}','${equipmentBackupVO.backupEquipmentID}');" style="cursor:pointer"  >删除</a>
	        	        	<a onclick="javascript:modelBackGl('${equipmentBackupVO.equipmentID}','${equipmentBackupVO.backupEquipmentID}');" style="cursor:pointer"  > | 配置</a>
                         </td>
                      </tr> 
                  </c:forEach>
                </tbody>
                <jsp:include page="/common/pageFooter.jsp"/>	
			</table>
            
          </div>            
   		</div>
      </form>
    </body>
</html>