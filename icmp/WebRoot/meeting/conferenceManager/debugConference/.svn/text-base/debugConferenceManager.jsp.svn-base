<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>调试会议列表</title>
</head>
<body>
  <form action="${sys_ctx }/detail/queryLocalConference.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10">
        	<a class="funcOper <%= FuncEnum.FUNC_NO_DEBUG_START_CONFERENCE%>" onclick="querymeeting()" style="cursor: pointer;">立即召开</a>
     	</h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="7%" class="head1">序号</th>
            <th width="15%" class="head1">会议名称</th>
            <th width="13%" class="head1">开始时间</th>
            <th width="13%" class="head1">结束时间</th>
            <th width="9%" class="head1">会议类型</th>
            <th width="9%" class="head1">会议状态</th>
            <th width="9%" class="head1">预约人</th>
            <th width="25%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${lst_conference}" var="meetingDetailVO" varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td>&nbsp;<c:out value="${meetingDetailVO.meetingName}"/></td>
	            <td>&nbsp;
	            	<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>
	            </td>
	            <td>&nbsp;
	            	<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>
	            	</td>
	            <td>&nbsp;<zzst:lable type="meetingType" value="${meetingDetailVO.meetingType}"></zzst:lable></td>
	            <td>&nbsp;
	            </td>	
	             <td>&nbsp;${meetingDetailVO.fullName}</td>
	            <td class="alc">
	            	<a class="funcOper <%= FuncEnum.FUNC_NO_DEBUG_CONFERENCE_MAINTAIN%>" onclick="confernceMaintain('${meetingDetailVO.meetingDetailID}');" title="调试记录">调试记录</a>
	            </td>
              </tr>
	       </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
    </div>
  </form>
 </body>
</html>