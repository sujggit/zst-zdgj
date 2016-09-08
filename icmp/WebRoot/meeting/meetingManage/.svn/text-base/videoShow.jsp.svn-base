<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
	<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>	

<title>会场监测</title>
		<script type="text/javascript">
			function test(ip){
				
				ip = document.getElementById("meetingRoomID").value;
				var now=new Date();
				var number = now.getTime();
				McuDwrMethod.getBlowUp(ip, function(nameIP){
				if(ip != "" && ip != null && name!=""){
				
				document.getElementById("farview").src= "" +nameIP +"?"+number; 
				}else{
				document.getElementById("farview").src="${sys_ctx }/images/lineOut.png"; 
				
				}
				McuDwrMethod.getBlowDown(ip, function(nameIP1){
				document.getElementById("nearview").src= "" +nameIP1 +"?"+number; 
				})
				});
				
			}
			function stopImg(){
			document.getElementById("farview").src="${sys_ctx }/images/lineOut.png";
			document.getElementById("nearview").src="${sys_ctx }/images/lineOut.png";
			}

		

		</script>
</head>

<body >

<input type="hidden" value="${param.message }" id="meetingRoomID"/>
<input type="hidden" value="${param.meetingDetailID }" id="meetingDetailID"/>
<table width="236" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  colspan="2" class="mainTableTitle_hc"><font size="4">会场监测</font></td>
    
  </tr>
  <tr>
    <td colspan="2" align="left">
    <table width="99%" border="0" cellspacing="0" cellpadding="0">
     
      <tr>
        <td  align="left" valign="top" class="marginData1">
          	<span id="near"></span>会场近端 <span id="near"></span>
          
          </td>
          <td   align="left" valign="top" class="marginData1">
        	<span id="far"></span>会场远端 <span id="far"></span>
        	</td>
          </tr>
          <td  align="left" valign="top" class="marginData1">
          <img id="nearview" src="${sys_ctx }/images/lineOut.png" height="187" width="220">
          </td>
        <td  align="left" valign="top" class="marginData1">
        <img id="farview" src="${sys_ctx }/images/lineOut.png" height="187" width="220">&nbsp;&nbsp;
        </td>
      
    </table></td>
    </tr>
</table>
<center>
<div id="meetingName"></div>
</center>
</body>
<script type="text/javascript">

		window.setInterval("test('ip')", 1000);
		
		
		document.body.oncontextmenu=function(){return false;};

		document.body.ondragstart=function(){return false;};
		
		document.body.onselectstart=function(){return false;};
		
		document.body.onbeforecopy=function(){return false;};
		
		document.body.onselect=function(){document.selection.empty();};
		
		document.body.oncopy=function(){document.selection.empty();};
		
		//MEETINGROOM NAME 
		
		var meetingDetail = document.getElementById("meetingDetailID").value;
		//var roomID = document.getElementById("roomID").value;
		var meeting = document.getElementById("meetingName");
		//McuHelpDwrMethod.cameraControl(meetingDetail,roomID,function(roomIP){
		//meeting.innerHTML = roomIP;
		//});
</script>
</html>
