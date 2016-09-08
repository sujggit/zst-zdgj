<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
  <title>会议调试列表</title>
  <script type="text/javascript">
     
    
     //显示隐藏查询域
	 function disquery(){
		var obj = document.getElementById("queryid");
		if(obj){
			if(obj.style.display==""){
				obj.style.display = "none";
			}else{
				obj.style.display = "";
			}
		}
	 }
	 //选择时间
	 function selectMeetingTime(thisDom,timeType){
	     var parameters = {
	         dateType : "datetime",
	         isNeedInfo:"true"
	     }
	    creatCalendar(thisDom,parameters);
	 }
	
	
	
	

	function disquery(){
		$(".tableadd").toggle();
	 }

	//调试通知
	function notice(id){
		window.open("${sys_ctx }/detail/beforeMeetingDebugNotice.action?meetingDetailVO.meetingDetailID="+id,"notice",'width=620px,height=445px,directories,top=200px,left=200px');
	}
	
	//立即召开调试会议
	function meetingDebug(id){
		if(confirm("是否确定立即进行调试？")){
			window.location.href="${sys_ctx }/detail/meetingDebug.action?meetingDetailVO.meetingDetailID="+id;
		}
	}
	
	//调试记录
    function confernceDebugMaintain(meetingDetailID,debuConferenceID){
		window.location.href = '${sys_ctx }/meetingRoomMaintain/addDebugConferenceMaintainBefore.action?meetingDetailVO.meetingDetailID=' + meetingDetailID+"&debugConferenceID="+debuConferenceID;
	}
	
	function backHistory(){
		window.location.href="${sys_ctx }/detail/queryLocalConference.action";
    }
    
  </script>
</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/detail/beforeMeetingDebug.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
				<td class="tableaddtitle">会议名称</td>
				<td class="tableadd_data">${meetingDetailVO.meetingName }</td>
				<td class="tableadd_data" colspan="2"></td>
			</tr>
			<tr>
				<td class="tableaddtitle">开始时间</td>
				<td class="tableadd_data">&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
				<td class="tableaddtitle">结束时间</td>
				<td class="tableadd_data">&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
        <%--<tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" ><input type="text" name="meetingDetailVO.meetingName" class="inputtran" value="${meetingDetailVO.meetingName}" id="meetingName"/></td>
          <td width="15%" class="tableaddtitle" >通知状态</td>
          <td width="35%" class="tableadd_data" >
          	<select name="meetingDetailVO.meetingDebugVO.noticeStatus"  id="status"  class="select200 fontstyle">
            	<option value="-2147483648">请选择</option>
            	<option value="1" <c:if test="${meetingDetailVO.meetingDebugVO.noticeStatus == '1' }">selected</c:if>>已通知</option>
            	<option value="0" <c:if test="${meetingDetailVO.meetingDebugVO.noticeStatus == '0' }">selected</c:if>>未通知</option>
			  </select>
          </td>
          <td rowspan="2" class="tableaddtitle">
              <input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" />
          </td>
        </tr>--%>
        <%--<tr>
          <td class="tableaddtitle">开始时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="meetingDetailVO.meetingStartTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'/></td>
          <td class="tableaddtitle">结束时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="meetingDetailVO.meetingEndTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime}"  pattern="yyyy-MM-dd HH:mm"/>'/></td>
        </tr>--%>
      </table>
           
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">调试会议列表</h5>
        <h5 class="fwb fr10">
			<a onclick="backHistory();" title="返回列表">返回列表</a> 
			<a class="funcOper<%= FuncEnum.FUNC_NO_NOTICE%>" onclick="notice('${meetingDetailVO.meetingDetailID}')" title="调试通知">调试通知</a> 
			<a class="funcOper<%= FuncEnum.FUNC_NO_MEETINGDEBUG%>" onclick="meetingDebug('${meetingDetailVO.meetingDetailID}')" title="召开调试会议">召开调试会议</a> 
     	</h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="28%" class="head1">会议名称</th>
            <th width="14%" class="head1">调试时间</th>
            <th width="14%" class="head1">结束时间</th>
            <%--<th width="9%" class="head1">通知状态</th>--%>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${meetingDetailList}" var="debugConferenceVO" 	varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td>&nbsp;<c:out value="${debugConferenceVO.meetingName}"/></td>
	            <td>&nbsp;<fmt:formatDate value="${debugConferenceVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <td>&nbsp;<fmt:formatDate value="${debugConferenceVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <%--<td>&nbsp;<fmt:formatDate value="${meedingDetailVO.meetingDebugVO.debugStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>--%>
	            <%--<td>&nbsp;<c:if test="${meedingDetailVO.meetingDebugVO.noticeStatus==1}">已通知</c:if><c:if test="${meedingDetailVO.meetingDebugVO.noticeStatus==0}">未通知</c:if></td>--%>
	            <td class="alc">
            		<a class="funcOper<%= FuncEnum.FUNC_NO_DEBUG_CONFERENCE_MAINTAIN%>" onclick="confernceDebugMaintain('${meetingDetailVO.meetingDetailID}','${debugConferenceVO.meetingDetailID }');" title="调试记录">调试记录</a>
 	            </td>
              </tr>
	       </c:forEach>
        </tbody>
      </table>
    </div>
  </form>
 </body>
</html>