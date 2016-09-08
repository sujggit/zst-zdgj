<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO "%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
  <%@include file="/common/common.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pathData = basePath + "meeting/meetingManage/viewCompare/";
	
	String meetingRoomNo = request.getParameter("meetingRoomNo");
	MeetingRoomVO Mrv=ServiceFactory.getMeetingRoomService().queryByID(meetingRoomNo);
	String meetingRoomName = Mrv.getMeetingRoomName();
	
	 ComparisonReferenceVO cr=new ComparisonReferenceVO();
     cr.setMeetingRoomID(meetingRoomNo);
     ComparisonReferenceVO crv=((ComparisonReferenceVO)(ServiceFactory.getConparisonReferenceService().query(cr,null).get(0)));
	 ComparisonCriteriaVO ccv=((ComparisonCriteriaVO)(ServiceFactory.getConparisonCriteriaService().query(null,null).get(0)));;
	 		    
%>


<html>
	<head>
		<title><%=meetingRoomName%>标准直方图</title>
		<script type="text/javascript" src="FusionCharts.js"></script>
		
	</head>
	<body class="withvernav">
		<div id="contentwrapper" class="contentwrapper">
			<div class="contenttitle2">
				<h5 class="fwb fl10"><%=meetingRoomName%>标准直方图
				</h5>
			</div>
			<div id="chartdiv" align="center">
				Chart will load here
			</div>
        <script type="text/javascript">
          var chart = new FusionCharts("MSArea.swf", "ChartId", "800", "350", "0", "0");
		   chart.setDataURL('<%=pathData + "referenceCompareViewDate.jsp?meetingRoomNo="
					+ meetingRoomNo + "&meetingRoomName=" + meetingRoomName%>');	   
		   chart.render("chartdiv");
		</script>
		</div>


		<div id="contentwrapper" class="contentwrapper">

			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="tableadd">
				<tr>
					<td width="15%" class="tableaddtitle">
						X轴的有效值区间
					</td>
					<td width="35%" class="tableadd_data">
				
						<%=ccv.getX_min() %>至 <%=ccv.getX_max() %>
					</td>

					<td width="15%" class="tableaddtitle">
						S有效面积
					</td>
					<td width="35%" class="tableadd_data">
						S<font size="1px">R</font>=<%=crv.getS_R() %> , 
						S<font size="1px">G</font>=<%=crv.getS_G() %> , 
						S<font size="1px">B</font>=<%=crv.getS_B() %>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
