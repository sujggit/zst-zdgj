<%@ page language="java" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String pathData=basePath+"meeting/meetingManage/viewCompare/";
%>


<html>
  <head>
   
    
    <title>viewCompare.jsp</title>
     <script type="text/javascript" src="FusionCharts.js" ></script>

  </head>
  
  <body>
   
<h3 class="chart-title" align="center">测试ss</h3>

        <div id="chartdiv" align="center">Chart will load here</div>
        <div id="chartdiv2" align="center">Chart will load here</div>
        <script type="text/javascript">
          var chart = new FusionCharts("MSArea.swf", "ChartId", "1120", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"Rdata.jsp" %>');	   
		   chart.render("chartdiv");
		   
		    var chart = new FusionCharts("MSArea.swf", "ss", "1120", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"Rdata2.jsp" %>');	   
		   chart.render("chartdiv2");
		</script>
		  
		
		
  </body>
</html>
