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
   
<h3 class="chart-title" align="center">点名对比</h3>

        <div id="chartdivR" align="center">Chart will load here</div>
         <div id="chartdivG" align="center">Chart will load here</div>
          <div id="chartdivB" align="center">Chart will load here</div>
        <script type="text/javascript">
          var chart = new FusionCharts("MSArea.swf", "ChartIdR", "1120", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"R_PRdata.jsp" %>');	   
		   chart.render("chartdivR");
		   
		    var chart = new FusionCharts("MSArea.swf", "ChartIdG", "1120", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"G_Ydata.jsp" %>');	   
		   chart.render("chartdivG");
		   
		     var chart = new FusionCharts("MSArea.swf", "ChartIdB", "1120", "400", "0", "0");
		   chart.setDataURL('<%=pathData+"B_PDdata.jsp" %>');	   
		   chart.render("chartdivB");
		</script>
		  
		
		
  </body>
</html>
