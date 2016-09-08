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
	out.println(meetingRoomNo+" | "+compareDetailId+" | "+meetingDetailId+" | "+equipIp);
	MeetingRoomVO mrv=ServiceFactory.getMeetingRoomService().queryByID(meetingRoomNo);
	String meetingRoomName = mrv.getMeetingRoomName();
	
	//主会场roomId
	EquipmentVO seachEV=new EquipmentVO();
	seachEV.setIp(equipIp);
	EquipmentVO evo=((EquipmentVO)(ServiceFactory.getEquipmentService().query(seachEV,null).get(0)));
	String mainMeetingRoomId=evo.getMeetingRoomVO().getMeetingRoomID();
	
	
%>
  
<html>
<head>
<title>综合会议管理平台</title>
<script type="text/javascript" src="FusionCharts.js"></script>

<script type="text/javascript">
         var chartdivMainRenfence = new FusionCharts("MSArea.swf", "chartdivMainRenfence", "400", "200", "0", "0");
		  chartdivMainRenfence.setDataURL('<%=pathData + "referenceCompareViewDate.jsp?meetingRoomNo="+ mainMeetingRoomId %>');	   
		  chartdivMainRenfence.render("chartdivMainRenfence");
		  
		// var chartdivMainDetial = new FusionCharts("MSArea.swf", "chartdivMainDetial", "400", "200", "0", "0");
		//  chartdivMainDetial.setDataURL('<%=pathData + "mainDetailCompareViewDate.jsp?compareDetailId="+ compareDetailId %>');	   
		//  chartdivMainDetial.render("chartdivMainDetial");
		  
		//  var chartdivRenfence = new FusionCharts("MSArea.swf", "chartdivRenfence", "400", "200", "0", "0");
		//  chartdivRenfence.setDataURL('<%=pathData + "referenceCompareViewDate.jsp?meetingRoomNo="+ meetingRoomNo %>');	   
		//  chartdivRenfence.render("chartdivRenfence");
		  
		/// var chartdivDetial = new FusionCharts("MSArea.swf", "chartdivDetial", "400", "200", "0", "0");
		// chartdivDetial.setDataURL('<%=pathData + "detailCompareViewDate.jsp?compareDetailId="+ compareDetailId %>');	   
		//  chartdivDetial.render("chartdivDetial");
		  
		  
</script>
</head>
<body class="withvernav">
<div id="contentwrapper" class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">查询列表&nbsp;&nbsp;<select class="radius3">
			<option value="" selected="selected">图表模式</option>
			<option value="">列表模式</option>
		</select> 
        </h5>
	</div>
    
	<div class="popping">
         <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
            <tr>
                <td width="20%" class="tableaddtitle">X轴的有效值区间</td>
                <td width="80%" class="tableadd_data" >5 至 200</td>
            </tr>
        </table>
        <table width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr style="height:260px">
                <td>
                    <ul>
                    	<li>主会场标准直方图</li>
                        <li>
                        <div id="chartdivMainRenfence" align="center">
				Chart will load here
			           </div>
			          
		  
			           </li>
                        <li>
                        	<table width="90%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                                <tr>
                                    <td width="15%" class="tableaddtitle">S有效面积</td>
                                    <td width="35%" class="tableadd_data" > S<font size="1px">R</font>=100 , S<font size="1px">G</font>=200 , S<font size="1px">B</font>=300</td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </td>
                <td>
                	<ul>
                    	<li>主会场实时直方图</li>
                        <li><div id="chartdivMainDetial" align="center">
				         Chart will load here
			           </div>
			           </li>
                        <li>
                        	<table width="90%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                                <tr>
                                    <td width="15%" class="tableaddtitle">S有效面积</td>
                                    <td width="35%" class="tableadd_data" > S<font size="1px">R</font>=100 , S<font size="1px">G</font>=200 , S<font size="1px">B</font>=300</td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr style="height:260px">
                <td>
                    <ul>
                    	<li>本会场标准直方图</li>
                        <li><div id="chartdivCompare" align="center">
				         Chart will load here
			           </div></li>
                        <li>
                        	<table width="90%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                                <tr>
                                    <td width="15%" class="tableaddtitle">S有效面积</td>
                                    <td width="35%" class="tableadd_data" > S<font size="1px">R</font>=100 , S<font size="1px">G</font>=200 , S<font size="1px">B</font>=300</td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </td>
                <td>
                	<ul>
                    	<li>本会场实时直方图</li>
                        <li><div id="chartdivDetial" align="center">
				         Chart will load here
			           </div></li>
                        <li>
                        	<table width="90%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                                <tr>
                                    <td width="15%" class="tableaddtitle">S有效面积</td>
                                    <td width="35%" class="tableadd_data" > S<font size="1px">R</font>=100 , S<font size="1px">G</font>=200 , S<font size="1px">B</font>=300</td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
