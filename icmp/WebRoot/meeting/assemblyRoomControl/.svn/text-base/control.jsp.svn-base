<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/common_header.jsp"%>
<zzst:authority func="meetingRoomControl" action="control"  pagehead="true"	/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/control.css" />
<link rel="stylesheet" type="text/css" href="css/control1.css" />
<link rel="stylesheet" type="text/css" href="roomlist.css" />
<title>会场控制</title>
<script>

function a()
{
	var ln_screenWidth = screen.width;
	var ln_screenHeight = screen.height;
	var lo_frameLeft = document.getElementById("leftFrame");
	var lo_frameRight = document.getElementById("rightFrame"); 
	with(lo_frameLeft.style)
	{
		left="0px";
		top="0px";
		width="202px";
		height = "488px";
	}
	with(lo_frameRight.style)
	{
		left="202px";
		top="0px";
		//width=(ln_screenWidth-202)+"px";
		width="950px";
		height = "488px";
	}
	
}

</script>

</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' style="border:0px solid green">
  <iframe id="leftFrame" frameborder="0" name="left" scrolling="no" style="width:20%;height:488px;border:0px solid red;margin-left:0px;" src="${swh_ctx }/control/toControlPage.action" > </iframe> 
  <iframe id="rightFrame" frameborder="0" name="frmright" src="headeren.jsp" style="width:80%;height:488px;border:0px solid red"></iframe> 
</body>
</html>
