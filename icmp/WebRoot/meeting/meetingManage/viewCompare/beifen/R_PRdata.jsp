<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<%@ page
	import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonDetailVO" %>


<?xml version="1.0" encoding="UTF-8"?>
<chart bgColor="E9E9E9" labelStep="15" outCnvBaseFontColor="666666"
	caption="R" xAxisName="" yAxisName="Sales" numberPrefix=""
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

<dataset seriesName="R_reference" color="b1d1dc"	plotBorderColor="b1d1dc"> 

<%
                ComparisonReferenceVO crv=ServiceFactory.getConparisonReferenceService().queryByID("1");
			    String reference=crv.getR_Pr().trim();
			    String[] references=reference.split(",");
			    out.println(references.length);
			    for(int i=0;i<references.length;i++){			  
			   int cont=Integer.parseInt(references[i].trim());
			    if(cont>=999){
			    cont=999;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }


 %>


</dataset> 

<dataset seriesName="R_detail" color="f50200"	plotBorderColor="f50200"> 

<%
                ComparisonDetailVO detail=ServiceFactory.getConparisonDetailService().queryByID("1");
			    String detailRs=detail.getR_Pr().trim();
			    String[] detailItems=detailRs.split(",");
			    out.println(detailItems.length);
			    for(int i=0;i<detailItems.length;i++){			  
			   int cont=Integer.parseInt(detailItems[i].trim());
			    if(cont>=999){
			    cont=999;
			    }	  
			   out.println("<set value=\""+cont+"\" />");
			    }


 %>


</dataset> 

</chart>