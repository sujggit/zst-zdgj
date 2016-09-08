<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonDetailVO"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.meetingDetail.MeetingDetailVO"  %>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"  %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
  <%@include file="/common/common.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pathData = basePath + "meeting/meetingManage/viewCompare/";

	String meetingRoomNo = request.getParameter("meetingRoomNo").trim();
	String compareDetailId=request.getParameter("compareDetailId");
	String meetingDetailId=request.getParameter("meetingDetailId");
	String equipIp=request.getParameter("equipIp");
	MeetingRoomVO mrv=ServiceFactory.getMeetingRoomService().queryByID(meetingRoomNo);
	String meetingRoomName = mrv.getMeetingRoomName();
	
	EquipmentVO seachEV=new EquipmentVO();
	seachEV.setIp(equipIp);
	
	EquipmentVO evo=((EquipmentVO)(ServiceFactory.getEquipmentService().query(seachEV,null).get(0)));
	String mainMeetingRoomId=evo.getMeetingRoomVO().getMeetingRoomID();
	
	
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
		   chart.setDataURL('<%=pathData + "detailCompareViewDate.jsp?compareDetailId="+ compareDetailId %>);	   
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
						5 至 200
					</td>

					<td width="15%" class="tableaddtitle">
						S有效面积
					</td>
					<td width="35%" class="tableadd_data">
						S
						<font size="1px">R</font>=100 , S
						<font size="1px">G</font>=200 , S
						<font size="1px">B</font>=300
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
