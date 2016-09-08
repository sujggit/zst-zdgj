<%@ page language="java" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String pathData=basePath+"meeting/meetingManage/viewCompare/";

String meetingRoomName=request.getParameter("meetingRoomName");
String meetingRoomNo=request.getParameter("meetingRoomNo");
String str=new String(meetingRoomName.getBytes("iso-8859-1"),"utf-8");
meetingRoomName=str;
%>


<html>
  <head>
   
    
    <title><%=meetingRoomName %>标准直方图</title>
     <script type="text/javascript" src="FusionCharts.js" ></script>

  </head>
  
  <body>
   

        <div id="chartdiv" align="center">Chart will load here</div>
        <script type="text/javascript">
          var chart = new FusionCharts("MSArea.swf", "ChartId", "900", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"referenceCompareViewDate.jsp?meetingRoomNo="+meetingRoomNo+"&meetingRoomName="+meetingRoomName %>');	   
		   chart.render("chartdiv");
		   
		   
		</script>
		  
		
		
  </body>
</html>
