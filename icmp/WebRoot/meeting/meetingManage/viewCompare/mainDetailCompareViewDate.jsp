<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<%@ page
	import="com.zzst.model.meeting.comparison.ComparisonDetailVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%
request.setCharacterEncoding("utf-8");
String compareDetailId=request.getParameter("compareDetailId");
 %>

<?xml version="1.0" encoding="UTF-8"?>
<chart bgColor="E9E9E9" labelStep="15" outCnvBaseFontColor="666666"
	 xAxisName="" yAxisName="value" numberPrefix="" yAxisMaxValue="600"
	showLabels="1" showValues="0" plotFillAlpha="80" numVDivLines="0"
	unescapeLinks="0" baseFontColor="666666" showPlotBorder="1"
	plotBorderThickness="1" canvaspadding="0" labelDisplay="NONE">
<categories>
<% 
for(int i=0;i<256;i++){
out.println("<category label=\""+i+"\" />");
}

 %>

</categories> 

<dataset seriesName="R" color="f50200"	plotBorderColor="f50200"> 

<%
                ComparisonDetailVO cd=new  ComparisonDetailVO();
                ComparisonDetailVO cdv=ServiceFactory.getConparisonDetailService().queryByID(compareDetailId);
			    String detailR=cdv.getR_Pr().trim();
			    String[] detailRs=detailR.split(",");
			    for(int i=0;i<detailRs.length;i++){			  
			   int cont=Integer.parseInt(detailRs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 

<dataset seriesName="G" color="00b450"	plotBorderColor="00b450"> 

<%
                String detailG=cdv.getG_Y().trim();
			    String[] detailGs=detailG.split(",");
			    for(int i=0;i<detailGs.length;i++){			  
			   int cont=Integer.parseInt(detailGs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 


<dataset seriesName="B" color="0275C6"	plotBorderColor="0275C6"> 

<%
                String detailB=cdv.getB_Pb().trim();
			    String[] detailBs=detailB.split(",");
			    for(int i=0;i<detailBs.length;i++){			  
			   int cont=Integer.parseInt(detailBs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 
	
</chart>

