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
  
  <body onload="init()">
    <input id="meetingDetailID" type="hidden" value="${meetingDetailID }"/>
    <input id="layoutMode" type="hidden" value="${LAYOUT_MODE }"/>
    <input id="confListValue1" type="hidden" value=""/>
    <input id="confListValue2" type="hidden" value=""/>
    <div class="contenttitle2" >
		<h5 class="fwb fl10">会议分配</h5>
	</div>
	<div class="pollTemplate">
   	   	<span>顺序模板：</span>
    <select id="pollTemplate">
    <option value="">请选择...</option>
    	<c:forEach items="${plist}" var="t" >
    	<option value="${t.pollTemplateID }">${t.pollTemplateName }</option>
    	</c:forEach>
    </select>
    </div>
    <div id="screenContainer" class="screenContainerDivNoColor">
      <div id="screen1" style="width:50%;height:50%;margin-top: 25%" class="screen">
        <ul id="confList1" class="screenUl">
   	      <c:forEach items="${confVOList}" var="conf" varStatus="k">
   	        <li id="conf${k.count }">${conf.confName }<input type="hidden" value="${conf.confID }"/></li>
   	      </c:forEach>
   	   </ul>
     </div>
     <div id="screen2" style="width:50%;height:50%;margin-top: 25%" class="screen">
       <ul id="confList2" class="screenUl">
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