<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.meeting.dwr.CallPollThread1" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String[][] infos=CallPollThread1.getInfos();
String nowInfo=CallPollThread1.getNowInfo();
int nowIndex=0;

 out.println(nowInfo+"  |  "+nowIndex+"  |  "+infos[nowIndex][0]);
 out.println("<br />-----------------------------------"+infos[0].length+"<br />");
  String[] tempInfos=infos[0];
  String returnCont="";
  
 for(int i=0;i<tempInfos.length;i++){
 out.println(tempInfos[i]+" |是否在线："+CallPollThread1.getMcuOnLine(tempInfos[i])+"<br/>");
 if(tempInfos[i].equals(nowInfo)){ 
    nowIndex=i;
     }
 
 }
out.println(nowInfo+"  |  "+nowIndex+"  |  "+tempInfos[nowIndex]);
%>
