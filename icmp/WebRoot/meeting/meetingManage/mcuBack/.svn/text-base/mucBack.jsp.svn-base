<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
    
<title>MCU备份</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
<script type="text/javascript">
function backMcu(meetid,mainMcu,BackMc){
	McuDwrMethod.backupMcu(meetid,mainMcu,BackMc,function(back){
		if(back == "success"){
			alert('操作成功');
		}else{
			if(back == "master"){
				alert('备份MCU失败!\n原因:备份核心MCU只能通过会议模板手动创建会议!');
			}else{
				alert("备份操作失败");
			}
		}
	})
}


</script>
		
</head>
  
<body>
<div class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">MCU备份</h5>
    </div>
   
    <form id="form1" name="form1" action="" method="post" >
    <input type="hidden" value="${meetingID }" />    	
        <div id="container">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="backups" >
            	<tr>
            		<th width="50%" style="text-align:left"><span>使用中的MCU</span><a><img src="${sys_ctx }/images/mcuback/use.gif"/></a></th>
            		<th width="120" class="backup_border"></th>
            		<th width="50%" style="text-align:left"><span>备份MCU</span><a><img src="${sys_ctx }/images/mcuback/backup.gif"/></a></th>
            	</tr>
            	 <c:forEach items="${equipmentBackupVOList}" var="equipmentBackupVO" 	varStatus="state">
            	 <tr>
            	   <td>${equipmentBackupVO.equipmentName}(${equipmentBackupVO.ip})</td>
            	   <td class="backup_border"><a onclick="backMcu('${meetingID}','${equipmentBackupVO.ip}','${equipmentBackupVO.backupip}')">切换到MCU</a></td>
            	    <td class="">${equipmentBackupVO.backupEquipmentName}(${equipmentBackupVO.backupip})</td>
            	 </tr>
            	 </c:forEach>
            	          
            </table>
        </div>
    </form>
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		<tr>
			<td>
				<!-- 
				<input type="button" class="submit1 radius2" value="确 定" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
				<input type="button" class="reset1 radius2" value="取 消" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
				 -->
				<input type="button" name="button2" id="cancelButton" value="关  闭" style="cursor:pointer"  class="submit1 radius2"  onclick="javascript:window.close();" />
			</td>
		</tr>
	</table>
</div>
</body>
</html>
