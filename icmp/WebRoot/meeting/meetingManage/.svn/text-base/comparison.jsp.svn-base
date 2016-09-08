 <%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common.jsp"%>


		<script type="text/javascript">
		function exportComparison(){
		window.location.href="${sys_ctx}/detail/exportComparisonList.action";
 	
		}

		function refresh(){		
         window.location.reload();
			}
		
		</script>

</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' onload="setInterval('refresh()',60*1000)">
<form action="${sys_ctx}/statistics/queryNum.action" id="pageform" name="pageform" method="post">
 <div id="basicform" class="contentwrapper">
    
     
      
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;
        </h5>
        <h5 class="fwb fr10"><a style="cursor:pointer" onclick="exportComparison();">导出</a></h5>
      </div>
    
    
       <div id="tableShow">
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
             <th width="8%" class="head1">序号</th>
            <th width="13%" class="head1">会场名称</th>
            <th width="13%" class="head1">上行视频</th>
             <th width="13%" class="head1">下行视频</th>
            <th width="13%" class="head1">上行音频</th>
            <th width="13%" class="head1">下行音频</th>
            <th width="13%" class="head1">发送丢包率</th>
            <th width="13%" class="head1">接收丢包率</th>
             <th width="10%" class="head1">结果</th>
            <th width="5%" class="head1">操作</th>
          
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${comparisonVOList}" var="comparisonVO" varStatus="status">
							
									<tr>
										<td class="alc">
										<c:out value="${status.index+1}"></c:out>
										</td>
										<td>
										<c:out value="${comparisonVO.meetingRoomName}"></c:out>
										</td>
										<td>
										<c:out value="${comparisonVO.upVideoQuality}"></c:out>
										</td>
										<td>
										<c:out value="${comparisonVO.downVideoQuality}"></c:out>
										</td>
										<td>
										
										</td>
										<td>
										
										</td>
										<td>
										<c:out value="${comparisonVO.sendPacketLoss}"></c:out>
										</td>
										<td>
										<c:out value="${comparisonVO.receivePacketLoss}"></c:out>
										</td>
										<td>
										<c:out value="${comparisonVO.result}"></c:out>
										</td>
										<td class="alc">
										<a href="/icmp/meeting/meetingManage/viewCompare/RviewCompare.jsp">再确认 </a>
										</td>
										
									</tr>
							</c:forEach>
         
        
        </tbody>
      </table>
       <jsp:include page="/common/pageFooter.jsp" />
       </div>
       
      </div>
      </form>
      </body>
      </html>