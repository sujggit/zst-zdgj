<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<%@ page
	import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>


<?xml version="1.0" encoding="UTF-8"?>
<chart bgColor="E9E9E9" labelStep="15" outCnvBaseFontColor="666666"
	caption="测试" xAxisName="" yAxisName="Sales" numberPrefix=""
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
                ComparisonReferenceVO crv=ServiceFactory.getConparisonReferenceService().queryByID("8a81832f3d34836a013d3485b04a0004");
			    String items=crv.getR_Pr();
			   String Rs="6742,193,233,212,192,171,209,210,266,176,227,223,140,244,191,212,242,225,202,157,211,239,281,178,196,200,93,124,80,62,69,57,31,31,29,29,40,31,25,35,19,34,27,22,34,21,24,19,21,21,25,14,18,22,13,23,26,17,18,22,19,19,15,18,20,21,26,19,17,10,15,10,16,19,10,13,14,10,14,9,10,13,18,14,24,19,10,12,5,9,8,5,8,7,6,7,7,6,6,5,6,5,5,8,5,5,8,8,6,7,6,4,3,3,3,4,2,4,4,3,4,3,3,3,2,2,2,2,3,3,3,3,3,4,3,2,5,3,3,2,3,2,4,5,3,4,6,3,8,5,7,8,3,1,2,2,1,2,2,2,3,3,3,2,2,2,1,1,1,2,2,2,2,3,3,2,3,2,2,2,3,2,3,1,2,2,2,2,3,2,2,2,2,2,2,2,1,1,2,1,2,1,1,0,1,1,1,0,2,1,2,3,11,11,4,6,3,3,1,3,1,3,2,2,3,1,4,2,3,14,13,47,14,4,3,1,1,3,12,6,28,7,21,11,10,10,8,5,4,2,3,1,0,0,0,3";
			    items=Rs;
			    String[] itemViewS=items.split(",");
			    String categories="";
			    String datasets="";
			    
			    for(int i=0;i<itemViewS.length;i++){			  
			   out.println("<set value=\""+itemViewS[i].trim()+"\" />");
			    }


 %>


</dataset> 

<dataset seriesName="G" color="00b450"	plotBorderColor="00b450"> 

<%
                ComparisonReferenceVO crvr=ServiceFactory.getConparisonReferenceService().queryByID("8a81832f3d34836a013d3485b04a0004");
			    String itemsr=crv.getR_Pr();
			    String Gsr="11,10,40,248,402,1385,556,447,265,366,252,149,138,108,127,183,155,182,115,179,176,202,194,191,261,241,325,259,274,315,251,318,220,282,234,254,227,189,264,214,248,185,191,233,176,175,103,133,108,90,82,73,97,68,69,56,45,38,27,27,21,20,27,20,26,23,28,30,32,29,30,35,22,20,23,21,27,18,20,21,21,24,19,21,17,20,16,28,36,17,16,13,14,19,16,14,10,12,12,13,12,11,16,18,15,9,10,10,9,12,14,14,10,9,6,8,10,8,8,7,8,8,6,7,8,10,24,27,14,6,8,5,5,4,47,5,4,4,3,4,4,26,3,3,3,3,3,3,4,4,6,13,12,8,3,3,5,5,9,18,30,44,12,4,7,6,12,8,9,7,4,4,3,4,4,4,3,3,3,2,3,2,2,2,2,2,3,5,5,4,7,8,6,4,6,6,5,6,4,4,3,6,6,9,7,6,4,4,4,5,3,5,6,3,3,1,1,3,2,1,1,1,1,2,1,1,1,0,0,0,0,0,1,2,1,2,1,2,1,2,2,3,4,2,1,1,1,0,1,0,0,0,0,0,0,59";
			    items=Gsr;
			    String[] itemViewSr=items.split(",");
			    String categoriesr="";
			    String datasetsr="";
			  
			  
			    for(int i=0;i<itemViewSr.length;i++){			  
			   out.println("<set value=\""+itemViewSr[i].trim()+"\" />");
			    }


 %>


</dataset> 


<dataset seriesName="B" color="0275C6"	plotBorderColor="0275C6"> 

<%
                ComparisonReferenceVO crvrb=ServiceFactory.getConparisonReferenceService().queryByID("8a81832f3d34836a013d3485b04a0004");
			    String itemsrb=crv.getR_Pr();
			  String bsr="6583,168,201,185,194,195,159,263,230,259,223,245,199,200,200,196,251,198,218,153,169,139,186,166,197,184,142,155,109,170,157,102,79,66,51,27,28,29,27,27,21,23,20,26,21,23,22,21,23,17,20,17,22,20,17,19,14,20,14,16,15,20,17,19,18,14,20,12,18,19,19,22,24,25,16,19,17,14,15,14,23,15,21,9,10,11,13,14,14,10,11,11,10,8,10,9,8,11,7,10,9,8,10,10,10,8,8,10,7,7,9,4,9,8,7,13,7,9,11,6,7,9,6,6,4,4,4,3,10,7,5,4,3,4,4,3,4,3,3,3,3,3,3,2,2,2,2,2,2,4,2,11,5,5,3,4,3,3,6,2,5,2,5,2,2,1,2,2,2,3,2,13,12,10,11,1,1,1,2,1,2,2,2,2,3,3,2,1,1,1,2,2,2,1,2,1,2,1,2,1,1,2,1,2,2,2,2,1,1,1,1,0,1,1,2,1,1,2,1,1,1,0,0,1,0,1,1,0,1,0,1,1,2,2,2,1,1,1,1,2,2,1,3,0,1,0,1,0,11,0,23,0,6,0,0,17";
			  items=bsr;
			    String[] itemViewSrb=items.split(",");
			    String categoriesrb="";
			    String datasetsrb="";
			  
			  
			    for(int i=0;i<itemViewSrb.length;i++){			  
			   out.println("<set value=\""+itemViewSrb[i].trim()+"\" />");
			    }


 %>


</dataset> 
	
</chart>

