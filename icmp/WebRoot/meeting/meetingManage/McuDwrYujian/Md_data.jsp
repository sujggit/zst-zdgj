<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.meeting.dwr.CallPollThread1"%>
<%@page import="com.zzst.meeting.dwr.McuDwrHelper"%>
<%
String meetingID=request.getParameter("meetingID");
  CallPollThread1 ct1=new CallPollThread1();
  String[][] infos=ct1.getInfos();
  String nowInfo=ct1.getNowInfo();
  //System.out.println("------------------------------"+nowInfo);
  int nowIndex=0;
  String[] tempInfos=infos[0];
  String returnCont="null";
  McuDwrHelper mdh=new McuDwrHelper();
  for(int i=0;i<tempInfos.length;i++){
  if(tempInfos[i].equals(nowInfo)){ 
    nowIndex=i+1;
    if(nowIndex==tempInfos.length){
    nowIndex=0;
    }
    while(mdh.getMcuOnLine(meetingID,tempInfos[nowIndex]).equals("outLine")){
    nowIndex++;
    if(nowIndex==tempInfos.length){
    nowIndex=0;
    }
    }
    }
 }

    returnCont=tempInfos[nowIndex]+"_"+mdh.getMcuOnLine("",tempInfos[nowIndex]);

 
 
out.println(returnCont);
%>
