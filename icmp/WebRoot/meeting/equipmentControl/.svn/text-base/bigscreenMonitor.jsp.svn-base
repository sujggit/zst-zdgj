<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common_header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${sys_ctx }/meeting/equipmentControl/css/lg.css"
			rel="stylesheet" type="text/css" />
		<title>大屏</title>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
	function chooseModel(ips){
   		var valuess=document.getElementById(ips).value;
	 	//alert("1选择模式时"+valuess+"，弹出矩阵切换页面"+ips);
     	TerminalDwrMethod.bigscreenMonitor(ips,valuess,bigscreenMonitorback);
    }
  	function bigscreenMonitorback(result){	
    	//result = "10.232.1.198";	
        if(result!=null&&result!=""){
    		var valuess=document.getElementById(result).value;
	        window.location.href="${sys_ctx}/equipmentControl/bigscreenMonitorBefore.action?equipmentVO.ip="+result+"&equipmentVO.description="+valuess;
	        alert("成功！");
		}else{
	    	alert("失败！");
		}		
	}
	
	function chooseBsInput(ips,desc,bgNOs){
		var valuess=document.getElementById(ips).value;
		$("#ip").attr("value",ips);
		//alert(ips+":"+valuess+":"+desc);
		window.location.href="${sys_ctx}/equipmentControl/bigScreenInputChooseBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess+"&equipmentVO.description="+desc+"&equipmentVO.equipmentNO="+bgNOs;
		//window.showModalDialog("${sys_ctx}/equipmentControl/bigScreenInputChooseBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess+"&equipmentVO.description="+desc+"&equipmentVO.equipmentNO="+bgNOs,window,'dialogWidth=800px;dialogHeight=570px;');
	}
	
   
   function bigScreeninputs(ips){
     // document.getElementById('message_box').style.visibility='visible';
      var valuess=document.getElementById("equipmentModel").value;
      $("#ip").attr("value",ips);
      window.showModalDialog("${sys_ctx}/equipmentControl/bigscreenInputBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess,window,'dialogWidth=600px;dialogHeight=470px;');
       
   }
   
   	function screenShareUp(ip){
		DwrMethod.screenShareUp(ip,screenShareBack);
   	}
   	
   	function screenShareDown(ip){
		DwrMethod.screenShareDown(ip,screenShareBack);
   	}
   	
   	function screenShareBack(result){
   		alert(result);
   	}
</script>
	</head>
	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg">
	 
		<div style="background: url(image/bg2.jpg)">
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="srcmtable">
				<c:forEach items="${equipmentList}" var="equipmentVO"
					varStatus="status">
					<c:if test="${status.count % 4 == 1}">
						<tr>
					</c:if>
					<td>
						<div class="scrmdiv" style="cursor:pointer" onclick="chooseBsInput('${equipmentVO.ip}','${equipmentVO.description}','${equipmentVO.equipmentNO}');">
							${equipmentVO.meetingRoomVO.description }
						</div>
						<br />
						<div>
						<c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}" />
						<select name="equipmentVO.equipmentModel" id="${equipmentVO.ip}"
							class="dataselect" onchange="chooseModel('${equipmentVO.ip}');">
							<zzst:option type="screentModel"
								value="${equipmentVO.ip},${equipmentVO.description}"
								required="true" />
						</select>
						</div>
						<input type="button" value="共享上行" class="searbutton fontstyle fontb" onclick="screenShareUp('${equipmentVO.ip}')"/>
						<input type="button" value="共享下行" class="searbutton fontstyle fontb" onclick="screenShareDown('${equipmentVO.ip}')"/>
					</td>
					<c:if test="${status.count % 4 == 0 || status.last}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
