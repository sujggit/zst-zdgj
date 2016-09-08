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
	ComparisonReferenceVO detailCrv = ((ComparisonReferenceVO) (ServiceFactory
			.getConparisonReferenceService().query(detailcr, null)
			.get(0)));

	ComparisonCriteriaVO ccv = ((ComparisonCriteriaVO) (ServiceFactory
			.getConparisonCriteriaService().query(null, null).get(0)));
String viewUrl=pathData+"detailCompareView.jsp?meetingRoomNo="+meetingRoomNo+"&meetingDetailId="+meetingDetailId+"&compareDetailId="+compareDetailId+"&equipIp="+equipIp;
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
<script type="text/javascript">
function loadJSP(herfs)
{
alert(herfs);
document.getElementById("myContIframe").src=herfs;
}

</script>

	</head>
	<body class="withvernav">
		<div id="contentwrapper" class="contentwrapper">
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					查询列表&nbsp;&nbsp;
					<select class="radius3" onchange="loadJSP(this.value)">
						<option value="<%=viewUrl %>">
							图表模式
						</option>
						<option value="" selected >
							列表模式
						</option>
					</select>
				</h5>
			</div>
			<div style="height: 800px;width:1100px">
			<iframe id="myContIframe" src="" frameborder="0" scrolling="auto" height="800px" width="1100px"></iframe>
</div>
</div>
	</body>
</html>
