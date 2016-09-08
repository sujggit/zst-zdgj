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
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
	
  </head>
  <body onload="venueSortable()">
    <input id="meetingDetailID" type="hidden" value="${meetingDetailID }"/>
    <input id="mcuMode" type="hidden" value="${mcuMode }"/>
    <input id="layoutMode" type="hidden" value="${LAYOUT_MODE }"/>
    <input id="confListValue1" type="hidden" value=""/>
    <input id="confListValue2" type="hidden" value=""/>
    <input id="meetings" type="hidden" value="${meetings }"/>
    <div class="contenttitle2" >
		<h5 class="fwb fl10">会议分配</h5>
	</div>
    <div id="intervalTimeDiv" class="pollTemplate">
    	<span>间隔时间：</span>
   	     <select id="intervalTime">
   				<option value="10">10</option>
   				<option value="30">30</option>
   				<option value="60">60</option>
   				<option value="120">120</option>
   				<option value="300">300</option>
   				<option value="600">600</option>
   			</select> 秒
    </div>
    <div id="screenContainer" class="participantsContainerDiv">
      <div id="participantsContainer1" style="width:50%;height:50%;" class="participants">
       <c:out value="${defaultVenue1}"></c:out>
	    <ul id="terList1">
		   	<c:forEach items="${tList1}" var="ter1" varStatus="k">
			   	<li id="ter1${k.count }">
				   	<input type="hidden" value="${ter1.mcu_participant_id }_${ter1.mcuMeetingID}_${ter1.confFlagId}_${ter1.mcuIp}_${ter1.mcu_participant_name}"/>
				   	<input type="button" value="删除" class="participantsDelBtn" onclick="delTerminal('ter1${k.count}')"/>
			   		<span class="participantsSpan">${ter1.mcu_participant_name }</span>
			   	</li>
		   	</c:forEach>
	   	</ul>
     </div>
     <div id="participantsContainer2" style="width:49%;height:50%;" class="participants">
      <c:out value="${defaultVenue2}"></c:out>
	    <ul id="terList2">
		   	<c:forEach items="${tList2}" var="ter2" varStatus="s">
		   		<li id="ter2${s.count }">
			   		<input type="hidden" value="${ter2.mcu_participant_id }_${ter2.mcuMeetingID}_${ter2.confFlagId}_${ter2.mcuIp}_${ter2.mcu_participant_name}"/>
			   		<input type="button" value="删除" class="participantsDelBtn" onclick="delTerminal('ter2${s.count}')"/>
		   			<span class="participantsSpan">${ter2.mcu_participant_name }</span>
		   		</li>
	   		</c:forEach>
	   	</ul>
     </div>
     <div id="participantsContainer3" style="width:50%;height:50%;" class="participants">
      <c:out value="${defaultVenue3}"></c:out>
	    <ul id="terList3">
		   	<c:forEach items="${tList3}" var="ter3" varStatus="s">
		   		<li id="ter3${s.count }">
			   		<input type="hidden" value="${ter3.mcu_participant_id }_${ter3.mcuMeetingID}_${ter3.confFlagId}_${ter3.mcuIp}_${ter3.mcu_participant_name}"/>
			   		<input type="button" value="删除" class="participantsDelBtn" onclick="delTerminal('ter3${s.count}')"/>
		   			<span class="participantsSpan">${ter3.mcu_participant_name }</span>
		   		</li>
	   		</c:forEach>
	   	</ul>
     </div>
     <div id="participantsContainer4" style="width:49%;height:50%;" class="participants">
      <c:out value="${defaultVenue4}"></c:out>
	    <ul id="terList4">
		   	<c:forEach items="${tList4}" var="ter4" varStatus="s">
		   		<li id="ter4${s.count }">
			   		<input type="hidden" value="${ter4.mcu_participant_id }_${ter4.mcuMeetingID}_${ter4.confFlagId}_${ter4.mcuIp}_${ter4.mcu_participant_name}"/>
			   		<input type="button" value="删除" class="participantsDelBtn" onclick="delTerminal('ter4${s.count}')"/>
		   			<span class="participantsSpan">${ter4.mcu_participant_name }</span>
		   		</li>
	   		</c:forEach>
	   	</ul>
     </div>
   </div>
   <div class="nextStepDiv"><button onclick="callPoll()" class="nextStepBtn">轮 询</button></div>
  <script>
     setGlobalProjectName('${sys_ctx }');
     setGlobalMeetingDetailId('${meetingDetailID }');
   </script>
  </body>
</html>