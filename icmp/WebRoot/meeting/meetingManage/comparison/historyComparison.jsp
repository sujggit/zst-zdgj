 <%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common.jsp"%>

<script type='text/javascript' src='${swh_ctx }/dwr/interface/StatisticsAction.js'></script>

		<script type="text/javascript">
		
			function exprotHistory(){
        window.location.href="${sys_ctx}/videoCardCompare/historyComparisonexport.action";
				}
		</script>

</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx}/videoCardCompare/historyComparison.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
                              <td class="tableaddtitle">开始时间</td>
						                 <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
						                 <input name="comparisonVO.startTime" value="<fmt:formatDate value="${comparisonVO.startTime }"  pattern="yyyy-MM-dd HH:mm"/>" class="inputtran" id="meetingStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="var meetingEndTime=$dp.$('meetingEndTime');WdatePicker({onpicked:function(){meetingEndTime.focus()},dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'meetingEndTime\',{d:0})}'});" />
						                 </td>
						                 <td class="tableaddtitle">结束时间</td>
						                 <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
						                   <input  name="comparisonVO.endTime" value="<fmt:formatDate value="${comparisonVO.endTime }"  pattern="yyyy-MM-dd HH:mm"/>" style="cursor:pointer" id="meetingEndTime" type="text" class="inputtran"
												readonly="readonly" onfocus="getEndTime();" />
						                   </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询"  onclick="queryForm()"/></td>          
        </tr>
      </table>
      
        <script type="text/javascript">
					                 	function getEndTime(){
					                 		if($('#meetingStartTime').val()==""){
					                     		$('#meetingStartTime').focus();
					                     		return;
					                     	}else{
					                     		WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'meetingStartTime\',{m:10})||\'%y-%M-%d %H:%m\'}'});
					                        }
					                    }
					                 </script> 
      
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />         
        </a>
        </div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表&nbsp;&nbsp;<!--select class="radius3">
                    	<option value="" selected="selected">列表模式</option>
                        <option value="">图表模式</option>
                    </select--> 
        </h5>
        <h5 class="fwb fr10"><a onclick="exprotHistory()">导出</a></h5>
      </div>
      <!--contenttitle-->

    
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
          	<th width="%" class="head1">会议名称</th>
            <th width="%" class="head1">会场名称</th>
            <th width="%" class="head1">结果</th>
           <!--   <th width="%" class="head1">上行音频</th>
            <th width="%" class="head1">下行音频</th>  
              <th width="%" class="head1">帧率</th>
            <th width="%" class="head1">时间</th>-->      
            <th width="%" class="head1">上行视频</th>
            <th width="%" class="head1">下行视频</th>
            <th width="%" class="head1">上行音频</th>
            <th width="%" class="head1">下行音频</th>
           
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
        
         <c:forEach items="${comparisonVOList}" var="comparisonVO"
									varStatus="state">
          <tr>
          	<td class="alc">
				<c:out value="${comparisonVO.meetingName}"></c:out>
				</td>
				<td>
				<c:out value="${comparisonVO.meetingRoomVO.meetingRoomName}"></c:out>
				</td>
				<td>
									<c:if test="${comparisonVO.result==3}">好</c:if>
										<c:if test="${comparisonVO.result==2}">中</c:if>
										<c:if test="${comparisonVO.result==1}">差</c:if>
										<c:if test="${comparisonVO.result==6}">
											<font color="red">手工确认好</font>
										</c:if>
										<c:if test="${comparisonVO.result==5}">
											<font color="red">手工确认中</font>
										</c:if>
										<c:if test="${comparisonVO.result==4}">
											<font color="red">手工确认差</font>
										</c:if>
										<c:if
											test="${comparisonVO.result!=1&&comparisonVO.result!=2&&comparisonVO.result!=3&&comparisonVO.result!=4&&comparisonVO.result!=5&&comparisonVO.result!=6}">无数据</c:if>
										
									</td>
				<td>
				<!--<c:out value="${comparisonVO.upVideoQuality}"></c:out>-->
				<c:if test="${comparisonVO.upVideoQuality==3}">好</c:if>
				<c:if test="${comparisonVO.upVideoQuality==2}">中</c:if>
				<c:if test="${comparisonVO.upVideoQuality==1}">差</c:if>
				<c:if test="${comparisonVO.upVideoQuality==6}"><font color="red">手工确认好</font></c:if>
				<c:if test="${comparisonVO.upVideoQuality==5}"><font color="red">手工确认中</font></c:if>
				<c:if test="${comparisonVO.upVideoQuality==4}"><font color="red">手工确认差</font></c:if>
				<c:if test="${comparisonVO.upVideoQuality!=1&&comparisonVO.upVideoQuality!=2&&comparisonVO.upVideoQuality!=3&&comparisonVO.upVideoQuality!=4&&comparisonVO.upVideoQuality!=5&&comparisonVO.upVideoQuality!=6}">无数据</c:if>
				
				</td>
				<td>
				<!--<c:out value="${comparisonVO.downVideoQuality}"></c:out>-->
				
				<c:if test="${comparisonVO.downVideoQuality==3}">好</c:if>
				<c:if test="${comparisonVO.downVideoQuality==2}">中</c:if>
				<c:if test="${comparisonVO.downVideoQuality==1}">差</c:if>
				<c:if test="${comparisonVO.downVideoQuality==6}"><font color="red">手工确认好</font></c:if>
				<c:if test="${comparisonVO.downVideoQuality==5}"><font color="red">手工确认中</font></c:if>
				<c:if test="${comparisonVO.downVideoQuality==4}"><font color="red">手工确认差</font></c:if>
				<c:if test="${comparisonVO.downVideoQuality!=1&&comparisonVO.downVideoQuality!=2&&comparisonVO.downVideoQuality!=3&&comparisonVO.downVideoQuality!=4&&comparisonVO.downVideoQuality!=5&&comparisonVO.downVideoQuality!=6}">无数据</c:if>
				</td>
				<!--  <td class="ac fontstyle ">
				<c:out value="${comparisonVO.upAudioQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.downAudioQuality}"></c:out>
				</td>-->
				<td>
					<c:if test="${comparisonVO.upAudioQuality==1}">
						有
					</c:if>	
					<c:if test="${comparisonVO.upAudioQuality==0}">
						无
					</c:if>		
					<c:if test="${comparisonVO.upAudioQuality==6}">
						<font color="red">手工确认好</font>
					</c:if>							
					<c:if test="${comparisonVO.upAudioQuality!=0&&comparisonVO.upAudioQuality!=1 &&comparisonVO.upAudioQuality!=6}">
						—
					</c:if>	
				</td>
				<td class="alc">
					<c:if test="${comparisonVO.downAudioQuality==1}">
						有
					</c:if>	
					<c:if test="${comparisonVO.downAudioQuality==0}">
						无
					</c:if>	
					<c:if test="${comparisonVO.downAudioQuality==6}">
						<font color="red">手工确认好</font>
					</c:if>										
					<c:if test="${comparisonVO.downAudioQuality!=0&&comparisonVO.downAudioQuality!=1&&comparisonVO.downAudioQuality!=6}">
						—
					</c:if>	
				</td>
				
			
          </tr>
        </c:forEach>
        
        
        </tbody>
      </table>
	
	<jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
      </form>
      </body>
      </html>