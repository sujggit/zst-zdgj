<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonDetailVO"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.meetingDetail.MeetingDetailVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<%@ page
	import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@include file="/common/common.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pathData = basePath + "meeting/meetingManage/viewCompare/";

	String meetingRoomNo = request.getParameter("meetingRoomNo").trim();
	String compareDetailId = request.getParameter("compareDetailId");
	String meetingDetailId = request.getParameter("meetingDetailId");
	String equipIp = request.getParameter("equipIp");
	//out.println(meetingRoomNo+" | "+compareDetailId+" | "+meetingDetailId+" | "+equipIp);
	MeetingRoomVO mrv = ServiceFactory.getMeetingRoomService()
			.queryByID(meetingRoomNo);
	String meetingRoomName = mrv.getMeetingRoomName();

	//主会场roomId
	EquipmentVO seachEV = new EquipmentVO();
	seachEV.setIp(equipIp);
	EquipmentVO evo = ((EquipmentVO) (ServiceFactory
			.getEquipmentService().query(seachEV, null).get(0)));
	String mainMeetingRoomId = evo.getMeetingRoomVO()
			.getMeetingRoomID();
	//点名详情
	ComparisonDetailVO cd = new ComparisonDetailVO();
	ComparisonDetailVO cdv = ServiceFactory
			.getConparisonDetailService().queryByID(compareDetailId);

	//主会场标准
	ComparisonReferenceVO miancr = new ComparisonReferenceVO();
	miancr.setMeetingRoomID(mainMeetingRoomId);
	ComparisonReferenceVO mainCrv = ((ComparisonReferenceVO) (ServiceFactory
			.getConparisonReferenceService().query(miancr, null).get(0)));
	//分会场标准
	ComparisonReferenceVO detailcr = new ComparisonReferenceVO();
	detailcr.setMeetingRoomID(meetingRoomNo);
	ComparisonReferenceVO detailCrv = ((ComparisonReferenceVO) (ServiceFactory.getConparisonReferenceService().query(detailcr, null).get(0)));

	ComparisonCriteriaVO ccv = ((ComparisonCriteriaVO) (ServiceFactory
			.getConparisonCriteriaService().query(null, null).get(0)));
%>

<html>
	<head>
		<title>综合会议管理平台</title>
		<script type="text/javascript" src="FusionCharts.js"></script>
		<style type="text/css">
.explain {
	font-size: 12px;
	color: #f00
}

.explain h5 {
	float: left
}

.explain span {
	display: block;
	float: left;
	margin-right: 20px
}

.popping {
	text-align: left;
	padding: 20px 10px;
	border: 1px solid #ccc;
	border-top: none
}

.popping img {
	margin-right: 10px;
}

.popping table tr td ul li {
	margin: 0 auto;
	text-align: center
}

.popping table tr td ul li table {
	margin-left: 0px
}
</style>

	</head>
	<body class="withvernav">
		<div id="contentwrapper" class="contentwrapper">
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					查询列表&nbsp;&nbsp;
					<select class="radius3">
						<option value="" selected="selected">
							图表模式
						</option>
						<option value="">
							列表模式
						</option>
					</select>
				</h5>
			</div>

			<div class="popping">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td width="20%" class="tableaddtitle">
							X轴的有效值区间
						</td>
						<td width="80%" class="tableadd_data">
							<%=ccv.getX_min()%>
							至
							<%=ccv.getX_max()%>
						</td>
					</tr>
				</table>
				
				<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr style="height: 260px" >
						<td   style="background-color: #cef572;">
							<ul>
								<li>
									主会场标准直方图
								</li>
								<li>
									<div id="chartdivMainRenfenceDIV" align="center">
										Chart will load here
									</div>
									<script type="text/javascript">
                       var chartdivMainRenfence = new FusionCharts("MSArea.swf", "chartdivMainRenfenceID", "500", "220", "0", "0");
		               chartdivMainRenfence.setDataURL('<%=pathData+"referenceCompareViewDate.jsp?meetingRoomNo="+mainMeetingRoomId%>');		   
		               chartdivMainRenfence.render("chartdivMainRenfenceDIV");
                       </script>

								</li>
								<li>
								<div align="center">
									<table width="500px" border="0" cellspacing="1" cellpadding="0"
										class="tableadd" >
										<tr>
											<td width="100px" class="tableaddtitle">
												S有效面积
											</td>
											<td width="400px" class="tableadd_data">
												S
												<font size="1px">R</font>=<%=mainCrv.getS_R()%>
												, S
												<font size="1px">G</font>=<%=mainCrv.getS_G()%>
												, S
												<font size="1px">B</font>=<%=mainCrv.getS_B()%>
											</td>
										</tr>
									</table>
									</div>
								</li>
							</ul>
						</td>
						<td>
							<ul>
								<li>
									主会场实时直方图
								</li>
								<li>
									<div id="chartdivMainDetial" align="center">
										Chart will load here
									</div>

									<script type="text/javascript">
         var chartdivMainDetial = new FusionCharts("MSArea.swf", "chartdivMainDetialID", "500", "220", "0", "0");
		  chartdivMainDetial.setDataURL('<%=pathData
					+ "mainDetailCompareViewDate.jsp?compareDetailId="
					+ compareDetailId%>');	   
		  chartdivMainDetial.render("chartdivMainDetial");
                       </script>

								</li>
								<li>
								<div align="center">
									<table width="500px" border="0" cellspacing="1" cellpadding="0"
										class="tableadd" >
										<tr>
											<td width="100px" class="tableaddtitle">
												S有效面积
											</td>
											<td width="400px" class="tableadd_data">
												S
												<font size="1px">R</font>=<%=cdv.getS_R()%>
												, S
												<font size="1px">G</font>=<%=cdv.getS_G()%>
												, S
												<font size="1px">B</font>=<%=cdv.getS_B()%>
											</td>
										</tr>
									</table>
									</div>
								</li>
							</ul>
						</td>
					</tr>
					
					<tr style="height: 260px">
						<td   style="background-color: #cef572;">
							<ul>
								<li>
									<%=meetingRoomName%>标准直方图
								</li>
								<li>
									<div id="chartdivRenfence" align="center">
										Chart will load here
									</div>
									<script type="text/javascript">
 var chartdivRenfence = new FusionCharts("MSArea.swf", "chartdivRenfenceid", "500", "220", "0", "0");
		  chartdivRenfence.setDataURL('<%=pathData + "referenceCompareViewDate.jsp?meetingRoomNo="
					+ meetingRoomNo%>');	   
		  chartdivRenfence.render("chartdivRenfence");
                       </script>
								</li>
								<li>
									<div align="center">
									<table width="500px" border="0" cellspacing="1" cellpadding="0"
										class="tableadd" >
										<tr>
											<td width="100px" class="tableaddtitle">
												S有效面积
											</td>
											<td width="400px" class="tableadd_data">
												S
												<font size="1px">R</font>=<%=detailCrv.getS_R()%>
												, S
												<font size="1px">G</font>=<%=detailCrv.getS_G()%>
												, S
												<font size="1px">B</font>=<%=detailCrv.getS_B()%>
											</td>
										</tr>
									</table>
									</div>
								</li>
							</ul>
						</td>
						<td>
							<ul>
								<li>
									<%=meetingRoomName%>实时直方图
								</li>
								<li>
									<div id="chartdivDetial" align="center">
										Chart will load here
									</div>
									<script type="text/javascript">
			           var chartdivDetial = new FusionCharts("MSArea.swf", "chartdivDetialID", "500", "220", "0", "0");
	                 chartdivDetial.setDataURL('<%=pathData + "detailCompareViewDate.jsp?compareDetailId="
					+ compareDetailId%>');	   
		             chartdivDetial.render("chartdivDetial");
		  </script>
								</li>
								<li>
								<div align="center">
									<table width="500px" border="0" cellspacing="1" cellpadding="0"
										class="tableadd" >
										<tr>
											<td width="100px" class="tableaddtitle">
												S有效面积
											</td>
											<td width="400px" class="tableadd_data">
												S
												<font size="1px">R</font>=<%=cdv.getUplinkS_R()%>
												, S
												<font size="1px">G</font>=<%=cdv.getUplinkS_G()%>
												, S
												<font size="1px">B</font>=<%=cdv.getUplinkS_B()%>
											</td>
										</tr>
									</table>
									</div>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</div>

	</body>
</html>
