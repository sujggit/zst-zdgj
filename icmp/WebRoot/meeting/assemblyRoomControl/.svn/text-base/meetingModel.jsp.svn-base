<%@ page language="java"  pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/common/common_header.jsp"%>
    <title>会议模式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${swh_ctx }/conference/meetingControl/css/css.css">
	<script type='text/javascript' src='${swh_ctx }/dwr/interface/ControlAction.js'></script>	
  <style type="text/css">
      body{
          background-color:#EBF6FC;
      }
      
  </style>
  <script type="text/javascript">
      function chageBgStyle(modelNumber){
          var model1 = document.getElementById("model1");
          var model2 = document.getElementById("model2");
          var model3 = document.getElementById("model3");
          var model4 = document.getElementById("model4");
         
          var equipmentID = window.parent.currentEquipmentID;
         
          if(modelNumber=="1"){
              model1.className="model_button_on";
              model2.className="model_button";
              model3.className="model_button";
              model4.className="model_button";
              ControlAction.setMeetingRoomModel(equipmentID,"1",calback);
          }
          if(modelNumber=="2"){
              model2.className="model_button_on";
              model1.className="model_button";
              model3.className="model_button";
              model4.className="model_button";
              ControlAction.setMeetingRoomModel(equipmentID,"2",calback);
          }
          if(modelNumber=="3"){
              model3.className="model_button_on";
              model2.className="model_button";
              model1.className="model_button";
              model4.className="model_button";
              ControlAction.setMeetingRoomModel(equipmentID,"3",calback);
          }
          if(modelNumber=="4"){
              model4.className="model_button_on";
              model2.className="model_button";
              model1.className="model_button";
              model3.className="model_button";
              ControlAction.setMeetingRoomModel(equipmentID,"4",calback);
          }
      
      }
      function calback(content){
         alert(content);
      }
  </script>
  </head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
         <div style="margin-top:80px;">
            <table>
                <tr>
                    <td><input type="button" class="model_button" value="本地普通会议" id="model1" onclick="chageBgStyle(1)" onfocus="this.blur()"/></td>
                    <td style="width:120px">&nbsp;</td>
                  
                    <td><input type="button" class="model_button" value="本地多媒体会议" id="model2" onclick="chageBgStyle(2)" onfocus="this.blur()"/></td>
                </tr>
                <tr ><td>&nbsp;</td></tr>
                <tr ><td>&nbsp;</td></tr>
                <tr>
                    <td><input type="button" class="model_button" value="普通视频会议" id="model3" onclick="chageBgStyle(3)" onfocus="this.blur()"/></td>
                    <td style="width:120px">&nbsp;</td>
                   
                    <td><input type="button" class="model_button" value="双流视频会议" id="model4" onclick="chageBgStyle(4)" onfocus="this.blur()"/></td>
                </tr>
                
            </table>
            
         </div>
  </body>
</html>
