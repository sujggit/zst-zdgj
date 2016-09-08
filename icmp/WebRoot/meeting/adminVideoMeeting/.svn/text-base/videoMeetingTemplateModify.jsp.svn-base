<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.zzst.action.meeting.util.*"%>
<%@ page import="com.zzst.model.enums.MeetingStatus"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="/js/prototype.js" language="JavaScript" type="text/javascript"></script>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript" src="/icmp/common/seeyon/common/js/V3X.js"></script>
		<script src="/icmp/js/self_common.js" type="text/javascript"></script>
		<title>模板修改</title>
		
		<script type="text/javascript">

		
		function postData(isCheckMeetingRoom){
		    var meetingDescription = document.getElementById("meetingDescription");
		    var mainMeetingRoom = document.getElementById('selectedMainMeetingRoomID');
			var meetingType = document.getElementById('meetingTypeID');
			var meetingName = document.getElementById('meetingName');
			var meetingRoomNames = "";
			var meetingRoomNameIDs = "";
			var selectedMeetingRoom = "";
		    var myDate = new Date();
			var year=myDate.getFullYear();
			var month=myDate.getMonth()+1; 
			var date=myDate.getDate();       
			var hour=myDate.getHours();
			var minutes=myDate.getMinutes();
			var seconds=myDate.getSeconds();
			var val1=year+"-"+month+"-"+date+" "+hour+":"+minutes;
			if(meetingName.value.length>50){
				alert("会议名称不能超过50个字");
				return;
			}
		  	if(meetingDescription.value==""){
			  	alert("请选择会议时长");
			  	return;
		  	}
			if(mainMeetingRoom.value=="-1"){
				alert("请选择主会场");
				return;
			}
			if(meetingName.value==""){
				alert("请输入会议名称");
				return;
			}else
				
					selectedMeetingRoom = document.getElementById('selectedMeetingRoomID');
					for(var i=0; i < selectedMeetingRoom.length; i++){
						var textName = selectedMeetingRoom.options[i].text;
						meetingRoomNames += textName;

						var arrayID =  selectedMeetingRoom.options[i].value.split("##");
						if(meetingRoomNameIDs.indexOf(arrayID[0])>=0){
//							alert("重复选择会场："+textName);
							continue;
						}
						
						meetingRoomNameIDs += arrayID[0];
						if(i != selectedMeetingRoom.length-1){
							meetingRoomNames += ",";
							meetingRoomNameIDs += ",";
						}
					}
				
					document.getElementById('meetingRoomNames').value = meetingRoomNames;
					document.getElementById('meetingRoomNameIDs').value = meetingRoomNameIDs;
				
				var meetingType = document.getElementById('meetingTypeID').value;
				if(meetingType == detailVideoMeetingType){
					var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
					if(meetingRoomNameIDs == ""){
						alert("请选择视频会议室");
						return;
					}
				}
				
				<!--set notifyType value and then submit form-->
				
				checkMeetingRoom();
			
			
		}
			
		function checkMeetingRoom(){
			var duration = document.getElementById('meetingDescription').value;
			var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
			var meetingRoomNames = document.getElementById('meetingRoomNames').value;
				
			DwrMethod.checkMeetingRoom(null, meetingRoomNameIDs, meetingRoomNames, duration, checkMeetingRoomCallBack);			
		}
		
		function checkMeetingRoomCallBack(lst){
			/*if(lst != null && lst.length > 0){
				var meetingRoomNames = "";
 				for(var i = 0; i < lst.length; i++){
 	 				if(i > 0){
 	 					meetingRoomNames += ", ";
 	 				}
 					meetingRoomNames += lst[i];
 				}
 				alert(meetingRoomNames + " 已经被其他会议占用！\n");
 				return;
			}else{*/
				$("#subbtn").val("请等待").attr("disabled","disabled");
				document.all.form.submit();	
				window.close();			
			//}
		}
		
</script>
  </head>
  
  <body>
  	<form action="/icmp/detail/meetingTemplateModify.action" method="post" name="form" id="form">
    <input type="hidden" name="meetingDetailVO.meetingRoomNames" id="meetingRoomNames"/>
    <input type="hidden" name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs"/>
    <input type="hidden" name="meetingDetailVO.status" value="${meetingDetailVO.status }" id="meetingStatusID"/>
    <input type="hidden" name="meetingDetailVO.meetingID" value="${meetingDetailVO.meetingID }"/>
    <input type="hidden" name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID }"/>
    <c:if test="${meetingDetailVO.createUserID != Integer.MIN_VALUE }">
    	<input type="hidden" name="meetingDetailVO.createUserID" value="${meetingDetailVO.createUserID }"/>
    	<input type="hidden" name="meetingDetailVO.createUserName" value="${meetingDetailVO.createUserName }"/>
    	<input type="hidden" name="assignID" value="${assignID }"/>
    	<input type="hidden" name="revision" value="${revision }"/>
     </c:if>	
    	
   <select name="meetingDetailVO.meetingType" style="display:none" class="ws120" id="meetingTypeID" >
		    				<option value="2">视频会议</option>
   </select>
   
  
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
      <input name="type" value="2" type="hidden"></input><!-- 建会模式 1为子MCU演讲者模式模板 2为子MCU无模式模板 -->
        <tr>
          <td width="15%" class="tableaddtitle">时长/时</td>
          <td width="35%" class="tableadd_data" >
            <select class="inputtran"  name="meetingDetailVO.meetingDescription" id="meetingDescription">
    <%--<option value="23">请选择...</option>--%>
    <%--<option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>--%>
    			<zzst:option type="meetingtime" value="${meetingDetailVO.meetingDescription}" />
    		</select>        
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
          <td width="35%" class="tableadd_data"><input id="meetingName" name="meetingDetailVO.meetingName" type="text" class="inputtran" value="${meetingDetailVO.meetingName }"/></td>
        </tr>
      </table>
      
      <%@include file="videoMeetingRoomTreeVideo.jsp" %>
      <script type="text/javascript">
    				
    					var meetingRoomNameIDs = '${meetingDetailVO.meetingRoomNameIDs}';
    					var meetingRoomNames = '${meetingDetailVO.meetingRoomNames}';
    					var mainRoom = '${meetingDetailVO.meetingRoomName}';
    					
    					var ids = new Array();
    					var names = new Array();
    					ids = meetingRoomNameIDs.split(",");
    					names = meetingRoomNames.split(",");
    					
    					var toMeetingRooms = document.getElementById('selectedMeetingRoomID');
    					
				 		for(var i=0; i < toMeetingRooms.length; i++){
					 		if(toMeetingRooms.options[i].text == ""){
					 			toMeetingRooms.remove(i);	
					 		}
				 		}
    					for(var i=0; i<ids.length; i++){
	    					if(names[i]== mainRoom){
	    						
	    						insertOption('selectedMeetingRoomID' ,names[i], ids[i], 'selected');
	    					}else{
	    						insertOption('selectedMeetingRoomID' ,names[i], ids[i], null);
	    					}
    					}
    					/*
    					var toMainMeetingRooms = document.getElementById('selectedMainMeetingRoomID');
    					alert(toMainMeetingRooms.value);
    					for(var i=0; i < toMainMeetingRooms.length; i++){
					 		if(toMainMeetingRooms.options[i].text == mainRoom){
					 			toMainMeetingRooms.selectedIndex = i;
					 		
					 			alert(mainRoom);
					 		}
				 		}
    					*/
    					
    				//-->
    				</script>			
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableadd">
        <tr>
          <td width="64%" class="tableadd_data"></td>
          <td width="36%" class="tableadd_data"></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" id="subbtn" class="submit1 radius2" value="确 定" onclick="postData(false);"/>
         
              <input type="button" class="reset1 radius2" value="取 消" onclick=" javascript:history.go(-1)"/>
            </td>
          </tr>
        </tbody>
      </table>
      
      <!--contenttitle--> 
    </div>
    <!--contentwrapper--> 
    </form>
  </body>
</html>
