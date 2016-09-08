<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>会议分配</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${sys_ctx }/meeting/meetingManage/poll/poll.css"/>    
	<script type='text/javascript' src='${sys_ctx }/meeting/meetingManage/poll/poll.js'></script>
	
  </head>
  <body onload="init()" style="overflow:hidden"  >
    <input id="meetingDetailID" type="hidden" value="${meetingDetailID }"/>
    <input id="mcuMode" type="hidden" value="${mcuMode }"/>
    <input id="layoutMode" type="hidden" value="${LAYOUT_MODE }"/>
    <input id="confListValue1" type="hidden" value=""/>
    <input id="confListValue2" type="hidden" value=""/>
    <div class="contenttitle2" >
		<h5 class="fwb fl10">会议分配</h5>
	</div>
	<div class="pollTemplate">
   	   	<span>会场顺序：</span>
   		<select id="pollTemplate">
			<option value="">默认排序</option>
			<c:forEach items="${plist}" var="t" >
			    <option value="${t.pollTemplateID }">${t.pollTemplateName }</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;<input id="ifShow" type="checkbox" value="1" style="margin-left: 10px" checked="checked"/>显示不在线终端
	</div>
    <div id="screenContainer" class="screenContainerDiv" >
      <div id="screen1" style="width:100%;height:100%;" class="screen">
        <ul id="confList1" class="screenUl">
   	      <c:forEach items="${confVOList}" var="conf" varStatus="k">
   	        <li id="conf${k.count }">
   	        <input type="hidden" value="${conf.confID }"/>
   	        <input type="button" class="participantsDelBtn" value="删除" onclick="delMeeting('conf${k.count }')"/>
   	        ${conf.confName }
   	        </li>
   	      </c:forEach>
   	   </ul>
     </div>
   </div>
   <div class="nextStepDiv"><button onclick="nextStep()" class="nextStepBtn">下一步</button></div>
   <script>
     setGlobalProjectName('${sys_ctx }');
     setGlobalMeetingDetailId('${meetingDetailID }');
   </script>
  </body>
</html>