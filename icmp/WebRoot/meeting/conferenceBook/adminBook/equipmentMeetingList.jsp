<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <title>设备列表</title>
  <script type="text/javascript">
  function exitMeeting(id,equipmentID,meetingdetailID,roomID){
  	DwrMethod.exitMeeting(id,equipmentID,meetingdetailID,roomID);
  	window.location.reload();
  }
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <div id="basicform" class="contentwrapper">      
     
      <div class="contenttitle2">
        <h5 class="fwb fl10">设备所在会议</h5>
        <h5 class="fwb fr10"></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="14%" class="head1">设备名称</th>
            <th width="16%" class="head1">会议名称</th>
            <th width="19%" class="head1">开始时间</th>
            <th width="19%" class="head1">结束时间</th>
            <th width="12%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${mList}" var="equipmentVO" 	varStatus="state">
			<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentVO.equipmentNo}"/></td>
				<td>
					<c:out value="${equipmentVO.meetingName }"/>
			    </td>
				<td><fmt:formatDate value="${equipmentVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${equipmentVO.meetingEndTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
          	    <td class="alc">
          	        <a onclick="javascript:exitMeeting('${equipmentVO.id }','${equipmentVO.equipmentID}','${equipmentVO.meetingDetailID}','${equipmentVO.roomID }');" >退出会议</a> 
          	   	</td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
      <!--<jsp:include page="/common/pageFooter.jsp" />-->
      <!--contenttitle--> 
    </div>
</body>
</html>
