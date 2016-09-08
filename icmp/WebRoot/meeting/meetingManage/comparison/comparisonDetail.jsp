<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonDetailVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonVO"%>
<%@ page import="com.zzst.model.enums.*"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@include file="/common/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${sys_ctx}/meeting/meetingManage/comparison/css/comparisonCss.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>会议比对列表</title>
		
		<%
		ComparisonReferenceVO comparisonReferenceVO=(ComparisonReferenceVO)request.getAttribute("comparisonReferenceVO");
		ComparisonDetailVO comparisonDetailVO=(ComparisonDetailVO)request.getAttribute("comparisonDetailVO");	
		ComparisonReferenceVO mainComparisonReferenceVO=(ComparisonReferenceVO)request.getAttribute("mainComparisonReferenceVO");	  
		%>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
		<script type="text/javascript">
		
		function toview(masterEpIp){
			
      var selId=$("#selId").val();
      var  compDetailID=$("#compareDid").val();
      var  comparisonID=$("#compareId").val();
      var  meetingRoomID=$("#meetingRoomID").val();
      var  meetingDetailId=$("#meetingDetailId").val();

     if(selId=="picShow"){
    	 window.location.href="${sys_ctx}/meeting/meetingManage/viewCompare/detailCompareView.jsp?meetingRoomNo="+meetingRoomID+"&meetingDetailId="+meetingDetailId+"&compareDetailId="+compDetailID+"&equipIp="+masterEpIp+"&compareId="+comparisonID;
         }
     else{
         
    	 window.location.href=" ${sys_ctx}/videoCardCompare/comparisonDetail.action?comparisonVO.compDetailID="+compDetailID+"&comparisonVO.ID="+comparisonID+"&masterEpIp="+masterEpIp;
         }
			}
     </script>  
     
</head>

  
  <body>
   
    <form action="/icmp/videoCardCompare/queryCompareMeeting.action" method="post" name="pageform" id="pageform">
     <div id="contentwrapper" class="contentwrapper">
    
	<div class="contenttitle2">
		<h5 class="fwb fl10">查看详情&nbsp;&nbsp;
		<select class="radius3" id="selId"  onchange="toview('${masterEpIp}')" >
			<option value="tableShow" selected="selected" >列表模式</option>
			<option value="picShow">图表模式</option>
		</select> 
		<input type="hidden" id="compareDid" value="${compareDetailID}"/>
		<input type="hidden" id="compareId" value="${compareID}"/>
		<input type="hidden" id="meetingDetailId" value="${meetingDetailId}"/>
		<input type="hidden" id="meetingRoomID" value="${meetingRoomID }"/>
		
        </h5>
     </div>
    <div id="contentwrapper"  style="padding:0">
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
            <tr>
                <td width="15%" class="tableaddtitle">会场名称</td>
                <td width="35%" class="tableadd_data" >${meetingRoomVO.meetingRoomName}</td>
                <td width="15%" class="tableaddtitle">结果</td>
                <td width="35%" class="tableadd_data" >
                <c:if test="${comparisonVO_.result==1}">差</c:if><!--input type="text" id="datepicker2" class="inputtran" /-->
                  <c:if test="${comparisonVO_.result==2}">中</c:if>
              <c:if test="${comparisonVO_.result==3}">好</c:if>
              <c:if test="${comparisonVO_.result==6}">手工确认好</c:if>
			  <c:if test="${comparisonVO_.result==5}">手工确认中</c:if>
			  <c:if test="${comparisonVO_.result==4}">手工确认差</c:if>
              <c:if test="${comparisonVO_.result!=1&&comparisonVO_.result!=2&&comparisonVO_.result!=3&&comparisonVO_.result!=4&&comparisonVO_.result!=5&&comparisonVO_.result!=6}">未评定</c:if>
                </td>
             
            </tr>
        </table>
    </div>
	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="" style="text-align:center">
		<thead>
			<tr>
				<th width="20%" class="head1">比对项</th>		
				<th width="20%" class="head1">标准值</th>
					<th width="20%" class="head1">现场值</th>
                <th width="20%" class="head1">百分比</th>
                <th width="20%" class="head1">结果</th>
			</tr>
        </thead>
        <tbody>
        <tr class="gradeA">
                <td class="">主会场S<font size="1px">R</font></td>
                  <td><%=mainComparisonReferenceVO.getS_R() %></td>
                <td><%=comparisonDetailVO.getS_R() %></td>
              
                <td><%=comparisonDetailVO.getS_R_gap() %>%</td>
                <td>
              <c:if test="<%=comparisonDetailVO.getS_R_result()==3 %>">好</c:if>
				<c:if test="<%=comparisonDetailVO.getS_R_result()==2 %>">中</c:if>
				<c:if test="<%=comparisonDetailVO.getS_R_result()==1 %>">差</c:if>
				<c:if test="<%=comparisonDetailVO.getS_R_result()!=1&&comparisonDetailVO.getS_R_result()!=2&&comparisonDetailVO.getS_R_result()!=3%>">无数据</c:if>
                
                </td>
          	</tr>
          	<tr class="gradeX">
                <td class="">主会场S<font size="1px">G</font></td>
                 <td><%=mainComparisonReferenceVO.getS_G() %></td>
                <td><%=comparisonDetailVO.getS_G() %></td>
               
                <td><%=comparisonDetailVO.getS_G_gap() %>%</td>
                <td>
               <c:if test="<%=comparisonDetailVO.getS_G_result() ==3%>">好</c:if>
				<c:if test="<%=comparisonDetailVO.getS_G_result()==2 %>">中</c:if>
				<c:if test="<%=comparisonDetailVO.getS_G_result()==1 %>">差</c:if>
				<c:if test="<%=comparisonDetailVO.getS_G_result()!=1&&comparisonDetailVO.getS_G_result()!=2&&comparisonDetailVO.getS_G_result()!=3%>">无数据</c:if>
                </td>
          	</tr>
          	<tr class="gradeA">
                <td class="">主会场S<font size="1px">B</font></td>
                  <td><%=mainComparisonReferenceVO.getS_B() %></td>
                <td><%=comparisonDetailVO.getS_B() %></td>
              
                <td><%=comparisonDetailVO.getS_B_gap() %>%</td>
                <td>
                <c:if test="<%=comparisonDetailVO.getS_B_result()==3 %>">好</c:if>
				<c:if test="<%=comparisonDetailVO.getS_B_result()==2 %>">中</c:if>
				<c:if test="<%=comparisonDetailVO.getS_B_result()==1 %>">差</c:if>
				<c:if test="<%=comparisonDetailVO.getS_B_result()!=1&&comparisonDetailVO.getS_B_result()!=2&&comparisonDetailVO.getS_B_result()!=3%>">无数据</c:if>
              
                
                </td>
          	</tr>
			<tr class="gradeX">
				<td class="">${meetingRoomVO.meetingRoomName}S<font size="1px">R</font></td>
				<td><%=comparisonReferenceVO.getS_R() %></td>
				<td>${comparisonDetailVO.uplinkS_R}</td>
				
                <td>${comparisonDetailVO.uplinkS_R_gap}%</td>
				<td>
				<c:if test="${comparisonDetailVO.uplinkS_R_result==3}">好</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_R_result==2}">中</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_R_result==1}">差</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_R_result!=1&&comparisonDetailVO.uplinkS_R_result!=2&&comparisonDetailVO.uplinkS_R_result!=3}">无数据</c:if>
				</td>
			</tr>
                <tr class="gradeA">
                <td class="">${meetingRoomVO.meetingRoomName}S<font size="1px">G</font></td>
                <td><%=comparisonReferenceVO.getS_G() %></td>
                <td>${comparisonDetailVO.uplinkS_G}</td>
                
                <td>${comparisonDetailVO.uplinkS_G_gap}%</td>
                <td>
                <c:if test="${comparisonDetailVO.uplinkS_G_result==3}">好</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_G_result==2}">中</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_G_result==1}">差</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_G_result!=1&&comparisonDetailVO.uplinkS_G_result!=2&&comparisonDetailVO.uplinkS_G_result!=3}">无数据</c:if>
                </td>
			</tr>
          	<tr class="gradeX">
                <td class="">${meetingRoomVO.meetingRoomName}S<font size="1px">B</font></td>
                  <td><%=comparisonReferenceVO.getS_B() %></td>
                <td>${comparisonDetailVO.uplinkS_B}</td>
              
                <td>${comparisonDetailVO.uplinkS_B_gap}%</td>
                <td>
                <c:if test="${comparisonDetailVO.uplinkS_B_result==3}">好</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_B_result==2}">中</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_B_result==1}">差</c:if>
				<c:if test="${comparisonDetailVO.uplinkS_B_result!=1&&comparisonDetailVO.uplinkS_B_result!=2&&comparisonDetailVO.uplinkS_B_result!=3}">无数据</c:if>
                </td>
          	</tr>
          	
		</tbody>
	</table>
    <div class="explain">
		<div class="meet" style="border:none;width:99%">
			<h2 style="border:none">
				<span onclick="alt()" class="close" id="show" style="float:left;width:auto;height:auto;border:none;cursor:pointer;">说明：</span>
			</h2>
			<span style="padding-left:30px">S<font size="1px">R</font>的面积差值在${criteriaVO.rsGap_Good_lower}至${criteriaVO.rsGap_Good_upper}以内结果为好，在${criteriaVO.rsGap_Ok_lower}至${criteriaVO.rsGap_Ok_upper}以内结果为中；</span><br/>
			<span style="padding-left:30px">S<font size="1px">G</font>的面积差值在${criteriaVO.gsGap_Good_lower}至${criteriaVO.gsGap_Good_upper}以内结果为好，在${criteriaVO.gsGap_Ok_lower}至${criteriaVO.gsGap_Ok_upper}以内结果为中；</span><br/>
			<span style="padding-left:30px">S<font size="1px">B</font>的面积差值在${criteriaVO.bsGap_Good_lower}至${criteriaVO.bsGap_Good_upper}以内结果为好，在${criteriaVO.bsGap_Ok_lower}至${criteriaVO.bsGap_Ok_upper}以内结果为中；</span><br/>
			<span style="padding-left:30px">全部为好结果为好; 其中有一项为差，结果为差； 好和差以外的结果为中。</span>
		</div>
	</div>
    <!--div class="in" onclick="drag.init().move('drag')" /><a href="#">说明：</a></div-->

</div>
   </form>
  </body>
</html>
