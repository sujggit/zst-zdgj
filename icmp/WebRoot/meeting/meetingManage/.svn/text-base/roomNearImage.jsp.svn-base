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
				
				McuDwrMethod.getBlowDown(ip, function(nameIP1){
					if(ip != "" && ip != null && nameIP1!=""){
						
						document.getElementById("nearview").src= "" +nameIP1 +"?"+number; 
					}else{
						document.getElementById("nearview").src="${sys_ctx }/images/loading.gif"; 
					}
					
				});	
			}
			

		

		</script>
</head>

<body onload="test('ip');">

<input type="hidden" value="${param.message }" id="meetingRoomID"/>
<input type="hidden" value="${param.meetingDetailID }" id="meetingDetailID"/>
<table width="236" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  colspan="2" class="mainTableTitle_hc"><font size="4">会场近端</font></td>
    
  </tr>
  <tr>
    <td colspan="2" align="left">
    <table width="99%" border="0" cellspacing="0" cellpadding="0">
     
      <tr>
        
          
        
          <td  align="left" valign="top" class="marginData1">
          <img id="nearview" src="${sys_ctx }/images/loading.gif" >
          </td>
         </tr>
    </table></td>
    </tr>
</table>
<center>
<div id="meetingName"></div>
</center>
</body>
<script type="text/javascript">

		window.setInterval("test('ip')", 5000);
		
</script>
</html>
