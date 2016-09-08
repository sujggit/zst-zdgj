<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%
request.setCharacterEncoding("utf-8");
String meetingRoomNo=request.getParameter("meetingRoomNo");
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
                ComparisonReferenceVO cr=new ComparisonReferenceVO();
                cr.setMeetingRoomID(meetingRoomNo);
                ComparisonReferenceVO crv=((ComparisonReferenceVO)(ServiceFactory.getConparisonReferenceService().query(cr,null).get(0)));
			    String referenceR=crv.getR_Pr().trim();
			    String[] referenceRs=referenceR.split(",");
			    for(int i=0;i<referenceRs.length;i++){			  
			   int cont=Integer.parseInt(referenceRs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 

<dataset seriesName="G" color="00b450"	plotBorderColor="00b450"> 

<%
                String referenceG=crv.getG_Y().trim();
			    String[] referenceGs=referenceG.split(",");
			    for(int i=0;i<referenceGs.length;i++){			  
			   int cont=Integer.parseInt(referenceGs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 


<dataset seriesName="B" color="0275C6"	plotBorderColor="0275C6"> 

<%
                String referenceB=crv.getB_Pb().trim();
			    String[] referenceBs=referenceB.split(",");
			    for(int i=0;i<referenceBs.length;i++){			  
			   int cont=Integer.parseInt(referenceBs[i].trim());
			    if(cont>=599){
			    cont=599;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }

 %>


</dataset> 
	
</chart>

