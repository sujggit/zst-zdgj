<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/common_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link type="text/css" href="roomlist.css" rel="stylesheet" />


<title>会议室列表</title>
<style type="text/css">
   body{
       color:#454f58;font-size:12px; text-align: center;margin:0px; padding: 0px;}
   .roomList{
      background-color:#fff;
      height:40px;
      text-align:center;
      font-size:14px;
      cursor:pointer;
   }
   .roomList_on{
      background-color:#5Bb166;
      height:40px;
      text-align:center;
      font-size:14px;
      cursor:pointer;
   }
   
</style>
<script type="text/javascript">

   var tmpColor=""; 
   var clickcolor="#aac6f8"; 
   var arrBg=["#ffffff","#d8e9fd"]; //表格交替色
   var meetingRoomID = "";

     var oldRoomObj = "";
   
     function changeRoomControl(meetingRoomID){
           window.parent.frames[1].window.changeMeetingRoom(meetingRoomID);
           meetingRoomID = meetingRoomID;
          
           var currentDom = document.getElementById("td_roomList"+meetingRoomID);
           if(oldRoomObj==""){
              oldRoomObj = currentDom;
              currentDom.className = "roomList_on";
              oldRoomObj = currentDom;
              return ;
           }
         
           currentDom.className = "roomList_on";
           oldRoomObj.className = "roomList";
           oldRoomObj = currentDom;
           
     }
     
     function  pageReay(){
         if(window.parent.frames[1].window.frames[0]){
	        if(window.parent.frames[1].window.frames[0].document.readyState=="complete"){
		           if(document.getElementById("tr_roomList").childNodes[0]){
		                 document.getElementById("tr_roomList").childNodes[0].click(); 
		            }
		            
	               clearInterval(timeInterval); 
	               return;
	        }
	      } 
     }
     
     var timeInterval = "";
     window.onload = function(){
         timeInterval = setInterval("pageReay()",100);
     }
</script>

</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   <div class="bkys"  overflow-y:scroll style="height:487px;width:200px;border:0px solid green;overflow-y:scroll;background:#9dc4e1">
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="margin-top:10px;with:200px;">
          <tr>
            <td class="lgota" style="font-size:14px; text-align: center;">会议室列表</td>
          </tr>
          <tr>
            <td>
                <table width="80%" border="0"  cellpadding="0" cellspacing="1" align="center">
                 
                  <c:forEach  items='${lstZZZKMeetingEndpoints}' var = "endPointVO" varStatus = "vstatus">
                      <input type="hidden"  name="endPointName${endPointVO.roomID}"  id="${endPointVO.equipmentID}" value="${endPointVO.equipmentCaption}"/>
                      <input type="hidden"  name="endPointID${endPointVO.roomID}"    id="endPointID${endPointVO.equipmentID}" value="${endPointVO.equipmentID}"/>
                      
                  </c:forEach>
                  
                  <c:forEach  items='${lstZZZKMeetingModels}' var = "meetingModelVO" varStatus = "vstatus">
                      <input type="hidden"  name="modelName${meetingModelVO.roomID}"  id="${meetingModelVO.equipmentID}" value="${meetingModelVO.equipmentCaption}"/>
                      <input type="hidden"  name="modelID${meetingModelVO.roomID}"    id="modelID${meetingModelVO.equipmentID}" value="${meetingModelVO.equipmentID}"/>
                      
                  </c:forEach>
                
                  <c:forEach items='${meetingroomlist}' var = "meetingRoomVO" varStatus = "vstatus" >   
                  <tr id="tr_roomList">
                      <td align="left"  class="roomList" id="td_roomList${meetingRoomVO.meetingRoomID}" onclick="changeRoomControl('${meetingRoomVO.meetingRoomID}',this)" valign="middle"> <c:out value="${meetingRoomVO.meetingRoomName}" default="无"></c:out>  </td>
                  </tr>
                  </c:forEach>
               </table>
            </td>
          </tr>
    </table>
                
   </div>
</body>
</html>
