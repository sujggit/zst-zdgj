<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common_header.jsp"%>

<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.css" type="text/css" rel="stylesheet" />
<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.round.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.dependClass.js"></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.slider-min.js"></script>
<title>视频监控系统</title>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg">
 <table align="center" cellpadding="0"  cellspacing="0" class="cter_bg2">
  <tr>
    <td class="cx_bg" height="26px">视频监控系统
    </td>
    <td class="cx_bg2"></td>
  </tr>
  <tr>
    <td colspan="2" valign="top" >
        <table class="cx_tab" cellspacing="0" id="query_table" cellpadding="0" border="0">
          <thead>
          <tr valign="top">
            <td width="10%" class="cx_bgsx" >会场名称</td>
            <td width="12%" class="cx_bgsx" >状态</td>
            <td width="12%" class="cx_bgsx" >查看</td>
          </tr>
          </thead>
          <tbody>
	         <c:forEach items="${roomList}" var="meetingRoomVO" 	varStatus="state">
				<tr class="cx_bgsx2">
				 <td><c:out value="${meetingRoomVO.meetingRoomName}"></c:out></td>
				 <td>
				 	<input type="button" style="cursor:pointer" onclick="" title="" name="button2" id="button2" value="" class="cx_delete" />
				 </td>
				 <td><input type="button" value="查看"/></td>
				</tr>
				</c:forEach>
          </tbody>
        </table>
    </td>
  </tr>
 </table>

</body>
</html>