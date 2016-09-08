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
  <body onload="venueSortable()" style="overflow:hidden">
    <input id="meetingDetailID" type="hidden" value="${meetingDetailID }"/>
    <input id="mcuMode" type="hidden" value="${mcuMode }"/>
    <input id="layoutMode" type="hidden" value="${LAYOUT_MODE }"/>
    <div class="contenttitle2" >
		<h5 class="fwb fl10"> 终端分配</h5>
	</div>
    <div class="pollTemplate">
   	    <span>间隔时间：</span>
   	     <select id="intervalTime">
	   			<zzst:option type="pollTimeSpan" value="${intervalTime}" />
   		</select> 秒
 </div>
    <div id="screenContainer" class="participantsContainerDiv">
      <div id="participantsContainer1" style="width:100%;height:100%;" class="participants">
	   	  <ul id="terList1">
	   	     <c:forEach items="${tList1}" var="ter1" varStatus="k">
			   	<li id="ter1${k.count }">
				   	<input type="hidden" value="${ter1.mcu_participant_id }_${ter1.mcuMeetingID}_${ter1.confFlagId}_${ter1.mcuIp}_${ter1.mcu_participant_name}"/>
				   	<!--<input type="button" class="participantsDelBtn" value="删除" onclick="delTerminal('ter1${k.count}')"/> -->
			   		<span class="participantsSpan">${ter1.mcu_participant_name }</span>
			   	</li>
			 </c:forEach>
		  </ul>
     </div>
   </div>
   <table width="100%" cellspacing="0" cellpadding="0" border="0" style="margin:10px 0" >
   	<tr>
   		<td align="center">
	   		增加会场<select id="1" class="addSelect" onchange="addTer(this)">
				<option value="-1">请选择...</option>
				<c:forEach items="${tAllList1}" var="tAll">
					<option value="${tAll.mcu_participant_id }_${tAll.mcuMeetingID}_${tAll.confFlagId}_${tAll.mcuIp}_${tAll.mcu_participant_name}">${tAll.mcu_participant_name }</option>
				</c:forEach>
			</select>
		</td>
   	</tr>
   </table>
   <div class="nextStepDiv"><button  onclick="modifyPoll()" class="nextStepBtn">轮 询</button></div>
  <script>
     setGlobalProjectName('${sys_ctx }');
     setGlobalMeetingDetailId('${meetingDetailID }');
    
   </script>
  </body>
</html>