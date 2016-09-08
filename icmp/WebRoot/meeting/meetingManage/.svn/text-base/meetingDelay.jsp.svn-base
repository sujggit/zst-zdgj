<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/common/common_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${sys_ctx }/style/css.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${sys_ctx }/js1/Common.js"></script>
		<script src="${sys_ctx }/js1/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuHelpDwrMethod.js'> </script>
<title>延时</title>
<script type="text/javascript">
	function meetingDetail(){
	var delayTime = document.getElementById("select");
	var meetingDetailID = document.getElementById("meetingDetailID");
	McuDwrMethod.setEndTime(meetingDetailID.value, delayTime.value , function(){
				 		window.setTimeout("refreshOpener()", 5000);
	<%--	window.close();--%>
	});
	}
	
	function refreshOpener(){
	 		window.opener.location.reload();
	 		window.close();
	}
</script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
<table  border="1" width="100%" cellspacing="0" cellpadding="0" >
 <input type="hidden" name="meetingDetailVO.meetingDetailID" value="${param.meetingDetailID }" id="meetingDetailID">
  <tr>
    <td colspan="2" class="cx_bgsx4">延时</td>
  </tr>
  <tr>
    <td width="30%" height="52" class="cx_bgsx2">延时</td>
    <td width="70%" class="cx_bgsx2"><select name="select" id="select" class="tableselect" >
      <option value="0.5" selected="selected">0.5</option>
      <option value="1">1</option>
      <option value="1.5">1.5</option>
      <option value="2">2</option>
      <option value="10">最长延时</option>
    </select>小时</td>
  </tr>
  <tr>
    <td height="52" colspan="2" class="cx_bgsx2"><input type="button" class="submit1 radius2" value="确认" onclick="meetingDetail();"/> 
       &nbsp;&nbsp;
    <input type="button" class="reset1 radius2" value="取消" onclick="window.close();"/></td>
  </tr>
</table>
</body>
</html>