<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.zzst.action.meeting.util.*"%>
<%@ page import="com.zzst.model.enums.MeetingStatus"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="/icmp/style/main.css" rel="stylesheet" type="text/css"/>
		<script src="/icmp/js/jquery-1.4.2.js" type="text/javascript"></script>
		<script src="/js/prototype.js" language="JavaScript" type="text/javascript"></script>
		<script type='text/javascript' src='/icmp/dwr/engine.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/util.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript" src="/icmp/common/seeyon/common/js/V3X.js"></script>
		<script src="/icmp/js/self_common.js" type="text/javascript"></script>
<title>模板修改</title>

		<script type="text/javascript">
		function time(){
	
			var beginTime=document.getElementById("start_time").value
			
			var endTime=document.getElementById("end_time").value
			
			if(beginTime!=""&&endTime!=""){		
				var beginTimes=beginTime.substring(0,10).split('-');
				var endTimes=endTime.substring(0,10).split('-');
				
				beginTime=beginTimes[1]+'-'+beginTimes[2]+'-'+beginTimes[0]+' '+beginTime.substring(10,19);
				endTime=endTimes[1]+'-'+endTimes[2]+'-'+endTimes[0]+' '+endTime.substring(10,19);
				
				
				 
				var a =(Date.parse(endTime)-Date.parse(beginTime))/3600/1000;
				
				if(a<0){
				
				alert("结束时间需晚于开始时间");
				
						
				endTime=document.getElementById("end_time").value="";
				}else if (a>0){
				
				
				}else if (a==0){
				alert("结束时间需晚于开始时间");
				
						
				endTime=document.getElementById("end_time").value="";
				}else{
				alert("exception");
				}		
			}	
	}
	
			function participatorTree(participatorIDs, participatorNames, showParticipatorNames, attendanceID){
			window.open('/icmp/department/userGroup/group.jsp?participatorIDs=' + participatorIDs + '&participatorNames=' + participatorNames + '&showParticipatorNames=' + showParticipatorNames + '&attendanceID=' + attendanceID,'example03','width=613,height=582,directories,scrollbars=yes');
		}
		
				function neededService(neededServiceNames, neededServiceIDs){
			var retVal=window.showModalDialog('/icmp/service/serviceTree.jsp?neededServiceNames=' + neededServiceNames + '&neededServiceIDs=' + neededServiceIDs, 'serviceTree', 'dialogWidth=600px;dialogHeight=541px;directories;scrollbars=yes');
		     if(retVal==undefined){
			return;
			}
		     var arrayValue = retVal.split("-");
	         if(arrayValue.length>=2){

			   document.getElementById("neededServiceNames").value=arrayValue[0];
			   document.getElementById("neededServiceIDs").value=arrayValue[1];
			   
			   }
			   else if (arrayValue.length==1 && arrayValue[0]=="1"){
			   document.getElementById("neededServiceNames").value="";
			   document.getElementById("neededServiceIDs").value="";
			   
			   }
		
		}
		
		
		
		function postData(isCheckMeetingRoom){
		  
		    var meetingDescription = document.getElementById("meetingDescription");
			var meetingType = document.getElementById('meetingTypeID');
			var meetingRoomNames = "";
			var meetingRoomNameIDs = "";
			var selectedMeetingRoom = "";
			var s= document.getElementById("start_time").value;
			var e= document.getElementById("end_time").value;
			var meetingName= document.getElementById("meetingNameID").value;
		    var myDate = new Date();
			var year=myDate.getFullYear();
			var month=myDate.getMonth()+1; 
			var date=myDate.getDate();       
			var hour=myDate.getHours();
			var minutes=myDate.getMinutes();
			var seconds=myDate.getSeconds();
			var val1=year+"-"+month+"-"+date+" "+hour+":"+minutes;
            var beginTime=document.getElementById("start_time").value;          
		  	if(meetingDescription.value==""){
		  	alert("请选择会议时长");
		  	return;
		  	}
			if(meetingName==""){
				alert("请输入会议名称");
			}else{
				
					selectedMeetingRoom = document.getElementById('selectedMeetingRoomID');
					for(var i=0; i < selectedMeetingRoom.length; i++){
						meetingRoomNames += selectedMeetingRoom.options[i].text;
						meetingRoomNameIDs += selectedMeetingRoom.options[i].value;
						
						
						if(i != selectedMeetingRoom.length-1){
							meetingRoomNames += "、";
							meetingRoomNameIDs += "-";
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
				}else{
					var meetingRoom= document.getElementById("availableMeetingRoomName").value;
					if(meetingRoom==""){
						alert("请选择会议室");
						return;
					}
				}
				
				<!--set notifyType value and then submit form-->
				var result = "";
				var message = document.getElementById('messageID');
				if(message.checked){
					result += "1";
				}else{
					result +="0";
				}
				
				
				var email = document.getElementById('emailID');
				if(email.checked){
					result +="1";
				}else{
					result +="0";
				}
				
				var oa = document.getElementById('oaID');
				if(oa.checked){
					result +="1";
				}else{
					result +="0";
				}
				
				document.getElementById('notifyTypeID').value = result;
				
				if(isCheckMeetingRoom){
				document.all.form.submit();
				
				}else{
					document.all.form.submit();
				
				}
			}
			
		}
				
		function checkMeetingRoom(){
			var startTime = document.getElementById('start_time').value;
			var endTime = document.getElementById('end_time').value;
			var meetingType = document.getElementById('meetingTypeID').value;
		
			if(meetingType ==detailVideoMeetingType){
		
				var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
				DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomNameIDs, startTime, endTime, checkMeetingRoomCallBack);
			}else{
		
				var meetingRoomID = document.getElementById('availableMeetingRoomID').value;
				DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomID, startTime, endTime, checkMeetingRoomCallBack);
			}
		}
		
		function checkMeetingRoomCallBack(lst){
			if(lst != null && lst.length > 0){
				for(var i = 0; i < lst.length; i++){
					var meetingRoomId = lst[i];
					var meetingRoomName = document.getElementById(meetingRoomId).innerHTML;
					alert(meetingRoomName + "已经被其他会议占用！\n");
				}
				return;
			}else{
				document.all.form.submit();	
				window.close();			
			}
		}
		
		function availableMeetingRoomTree(availableMeetingRoomID){
		var time1=document.getElementById("start_time").value;
		    var time2=document.getElementById("end_time").value;
			var retVal=window.showModalDialog('/icmp/meetingRoom/meetingRoomEmptyTree.action?time1='+time1+'&time2='+time2, 'availableMeetingRoomTree', 'dialogWidth=278px;dialogHeight=671px;directories;scrollbars=yes');
            if(retVal==undefined){
			return;
			}
			if(retVal==undefined){
			return;
			}
			var arrayValue = retVal.split("-");
	         if(arrayValue.length>=2){

			   document.getElementById("availableMeetingRoomName").value=arrayValue[0];
			   document.getElementById("availableMeetingRoomID").value=arrayValue[1];
			   }
			   else if (arrayValue.length==1 && arrayValue[0]=="1"){
			   document.getElementById("availableMeetingRoomName").value="";
			   document.getElementById("availableMeetingRoomID").value="";
			   }
		}
		
		function neededEquipments(availableMeetingRoomID){
			var meetingRoom = document.getElementById(availableMeetingRoomID);
			if(meetingRoom.value == null || meetingRoom.value == ""){
				alert("请先选择会议室");
				return;
			}
			
			var retVal=window.showModalDialog('/icmp/equipment/getOnlyEquipmentVOList.action?equipmentVO.meetingRoomID=' + meetingRoom.value +'&noticeNum=' +noticeNum, 'availableMeetingRoomID', 'dialogWidth=620px;dialogHeight=548px;directories;scrollbars=no');
		    if(retVal==undefined){
				return;
			}
		    var arrayValue = retVal.split("|");
	         if(arrayValue.length>=3){
				   document.getElementById("neededEquipmentNames").value=arrayValue[0];
				   document.getElementById("neededEquipmentIDs").value=arrayValue[1];
				   document.getElementById("neededEquipModelNames").value=arrayValue[2];
			   }
			   else if (arrayValue.length==1 && arrayValue[0]=="1"){
				   document.getElementById("neededEquipmentNames").value="";
				   document.getElementById("neededEquipmentIDs").value="";
				   document.getElementById("neededEquipModelNames").value="";
			   }
		
		}
		
		function setMeetingRoomAndEquip(meetingTypeID, availableMeetingRoomName, availableMeetingRoomID, neededEquipmentNames, neededEquipmentIDs, neededEquipModelNames){
			    var obj=document.getElementById("meetingTypeID");		    
			    openVideoCon('meetingTypeID');
			    var meetingTypeID = document.getElementById(meetingTypeID);
			if(meetingTypeID.value == detailVideoMeetingType){
				<%--set local meeting room and equipment invalid--%>
				document.getElementById(availableMeetingRoomName).disabled = "disabled";
				document.getElementById(availableMeetingRoomName).value = "";
			    document.getElementById(neededEquipmentNames).style.background = "#EBECE4";
	            document.getElementById(availableMeetingRoomName).style.background = "#EBECE4";
				document.getElementById(availableMeetingRoomID).disabled = "disabled";
				document.getElementById(neededEquipmentIDs).disabled = false;
				document.getElementById("meetingmust").style.display = "none";
				document.getElementById(neededEquipmentNames).disabled = "disabled";
				document.getElementById(neededEquipmentNames).value = "";
				document.getElementById(neededEquipmentIDs).disabled = "disabled";
				document.getElementById(neededEquipModelNames).disabled = "disabled";
				<%-- set video conference equipment information and main conference room valid--%>
				document.getElementById('neededVideoEquipsShow').disabled = false;
				document.getElementById('neededVideoEquipmentNames').disabled = false;
				document.getElementById('neededVideoEquipmentIDs').disabled = false;
				document.getElementById('neededVideoEquipModelNames').disabled = false;
				document.getElementById('selectedMainMeetingRoomID').disabled = false;
 	 			document.getElementById('mainMeetingRoomName').disabled = false;	
			} else{
				if(meetingTypeID.value == detailLocalMeetingType){
					<%--set local meeting room and equipment valid--%>
					document.getElementById(availableMeetingRoomName).disabled = false;
					document.getElementById(availableMeetingRoomID).disabled = false;
					document.getElementById("availableMeetingRoomName").style.background = "";
					document.getElementById("meetingmust").style.display = "";
					
					document.getElementById("neededEquipmentNames").style.background = "";
					document.getElementById(neededEquipmentNames).disabled = false;
					
					document.getElementById(neededEquipModelNames).disabled = false;
					
					<%-- set video conference equipment information invalid--%>
					document.getElementById('neededVideoEquipsShow').disabled = "disabled";
					document.getElementById('neededVideoEquipmentNames').disabled = "disabled";
					document.getElementById('neededVideoEquipmentIDs').disabled = "disabled";
					document.getElementById('neededVideoEquipModelNames').disabled = "disabled";
					
					document.getElementById('selectedMainMeetingRoomID').disabled = "disabled";
 	 				document.getElementById('mainMeetingRoomName').disabled = "disabled";
				}
			}
		}
		
		function change1(){
		
		document.getElementById('neededVideoEquipsShow').disabled = "disabled";
		}
		
		function callTemplate(){
			window.open('/icmp/template/manageMeetingTemplateList.action', 'manageMeetingTemplateList', 'width=633,height=368,directories,scrollbars=yes');
		}
		
		<!--temporarily save meeting -->
		function saveMeeting(){
			document.getElementById('meetingStatusID').value = '<%=MeetingStatus.SAVED%>';
			postData(false);
		}
		
		function getPeriodMeeting(){
			var meetingRoomName = document.getElementById('availableMeetingRoomName').value;
			var meetingRoomID = document.getElementById('availableMeetingRoomID').value;
			
<%--			window.open('<%=MeetingConfig.CONTENT_PATH%>/meeting/detail/periodMeeting.jsp?meetingName=meetingNameID&meetingRoomName=availableMeetingRoomName&meetingRoomID=availableMeetingRoomID&start_time=start_time&end_time=end_time', 'manageMeetingTempl', '');--%>
			window.open('/icmp/meeting/detail/periodMeeting.jsp', 'manageMeetingTempl', '');
		}
		
<%--		open video conference column--%>
		function openVideoCon(meetingTypeID){
			var meetingTypeID = document.getElementById(meetingTypeID);
			if(meetingTypeID.value == detailVideoMeetingType){
				
				$('.videomeeting').toggle();
				$(function(){ $('.mainArea').equalHeights(); });
				
				meetingTypeID.options[meetingTypeID.selectedIndex].text=="本地会议"
				
				
			}else{
				document.getElementById('videomeetingID').style.display = "none";
			}
		}
		function openVideoCon1(meetingTypeID){
			var meetingTypeID = document.getElementById(meetingTypeID);
			if(meetingTypeID.value == detailVideoMeetingType){
				
				$('.videomeeting').toggle();
				$(function(){ $('.mainArea').equalHeights(); });
				meetingTypeID.value=detailLocalMeetingType;
				document.getElementById("availableMeetingRoomName").disabled = false;
					document.getElementById("availableMeetingRoomID").disabled = false;
					document.getElementById("availableMeetingRoomName").style.background = "";
					document.getElementById("meetingmust").style.display = "";
					
					document.getElementById("neededEquipmentNames").style.background = "";
					document.getElementById("neededEquipmentNames").disabled = false;
					
					document.getElementById("neededEquipModelNames").disabled = false;
					
					<%-- set video conference equipment information invalid--%>
					document.getElementById('neededVideoEquipsShow').disabled = "disabled";
					document.getElementById('neededVideoEquipmentNames').disabled = "disabled";
					document.getElementById('neededVideoEquipmentIDs').disabled = "disabled";
					document.getElementById('neededVideoEquipModelNames').disabled = "disabled";
					
					document.getElementById('selectedMainMeetingRoomID').disabled = "disabled";
 	 				document.getElementById('mainMeetingRoomName').disabled = "disabled";
				
			}else{
				$('.videomeeting').toggle();
				$(function(){ $('.mainArea').equalHeights(); });
				meetingTypeID.value=detailVideoMeetingType;
				document.getElementById("availableMeetingRoomName").disabled = "disabled";
				document.getElementById("availableMeetingRoomName").value = "";
			    document.getElementById("neededEquipmentNames").style.background = "#EBECE4";
	            document.getElementById("availableMeetingRoomName").style.background = "#EBECE4";
				document.getElementById("availableMeetingRoomID").disabled = "disabled";
				document.getElementById("neededEquipmentIDs").disabled = false;
				document.getElementById("meetingmust").style.display = "none";
				document.getElementById("neededEquipmentNames").disabled = "disabled";
				document.getElementById("neededEquipmentNames").value = "";
				document.getElementById("neededEquipmentIDs").disabled = "disabled";
				document.getElementById("neededEquipModelNames").disabled = "disabled";
				
				<%-- set video conference equipment information and main conference room valid--%>
				document.getElementById('neededVideoEquipsShow').disabled = false;
				document.getElementById('neededVideoEquipmentNames').disabled = false;
				document.getElementById('neededVideoEquipmentIDs').disabled = false;
				document.getElementById('neededVideoEquipModelNames').disabled = false;
				
				document.getElementById('selectedMainMeetingRoomID').disabled = false;
 	 			document.getElementById('mainMeetingRoomName').disabled = false;
 	 			
			}
			
		}
		function time(){
	
			var beginTime=document.getElementById("start_time").value
			
			var endTime=document.getElementById("end_time").value
			
			if(beginTime!=""&&endTime!=""){		
				var beginTimes=beginTime.substring(0,10).split('-');
				var endTimes=endTime.substring(0,10).split('-');
				
				beginTime=beginTimes[1]+'-'+beginTimes[2]+'-'+beginTimes[0]+' '+beginTime.substring(10,19);
				endTime=endTimes[1]+'-'+endTimes[2]+'-'+endTimes[0]+' '+endTime.substring(10,19);
				
				
				 
				var a =(Date.parse(endTime)-Date.parse(beginTime))/3600/1000;
				
				if(a<0){
				
				alert("结束时间需晚于开始时间");
				
						
				endTime=document.getElementById("end_time").value="";
				}else if (a>0){
				
				
				}else if (a==0){
				alert("结束时间需晚于开始时间");
				
						
				endTime=document.getElementById("end_time").value="";
				}else{
				alert("exception");
				}		
			}	
	}
	
 function addtemplateName(){
      	    var meetingType = document.getElementById('meetingTypeID');
			var meetingRoomNames = "";
			var meetingRoomNameIDs = "";
			var selectedMeetingRoom = "";
			var s= document.getElementById("start_time").value;
			var e= document.getElementById("end_time").value;
			var meetingName= document.getElementById("meetingNameID").value;
		    var myDate = new Date();
			var year=myDate.getFullYear();
			var month=myDate.getMonth()+1; 
			var date=myDate.getDate();       
			var hour=myDate.getHours();
			var minutes=myDate.getMinutes();
			var seconds=myDate.getSeconds();
			var val1=year+"-"+month+"-"+date+" "+hour+":"+minutes;
            var beginTime=document.getElementById("start_time").value;
		            
			if(meetingName==""){
				alert("请输入会议名称");
			}else{
				if(meetingType.value == detailVideoMeetingType){
					selectedMeetingRoom = document.getElementById('selectedMeetingRoomID');
					for(var i=0; i < selectedMeetingRoom.length; i++){
						meetingRoomNames += selectedMeetingRoom.options[i].text;
						meetingRoomNameIDs += selectedMeetingRoom.options[i].value;
						
						
						if(i != selectedMeetingRoom.length-1){
							meetingRoomNames += "、";
							meetingRoomNameIDs += "-";
						}
					}
					document.getElementById('meetingRoomNames').value = meetingRoomNames;
					document.getElementById('meetingRoomNameIDs').value = meetingRoomNameIDs;
				}
				var meetingType = document.getElementById('meetingTypeID').value;
				if(meetingType == detailVideoMeetingType){
					var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
					if(meetingRoomNameIDs == ""){
						alert("请选择视频会议室");
						return;
					}
				}else{
					var meetingRoom= document.getElementById("availableMeetingRoomName").value;
					if(meetingRoom==""){
						alert("请选择会议室");
						return;
					}
				}
				
				<!--set notifyType value and then submit form-->
				var result = "";
				var message = document.getElementById('messageID');
				if(message.checked){
					result += "1";
				}else{
					result +="0";
				}
				
				var email = document.getElementById('emailID');
				if(email.checked){
					result +="1";
				}else{
					result +="0";
				}
				
				var oa = document.getElementById('oaID');
				if(oa.checked){
					result +="1";
				}else{
					result +="0";
				}
				
				document.getElementById('notifyTypeID').value = result;
				
       time();
      var info=window.showModalDialog("/icmp/meeting/detail/templateName.jsp","o3","dialogWidth=600px;dialogHeight=234px;directories;scrollbars=no");
       if(info==undefined){
		 return;
		 }
    	 var info1=info.split(",");
		 var modelname=info1[0];
		 var ds=info1[1];
		 document.getElementById("meetingModelName").value=modelname;
         document.getElementById("ds").value=ds;
		document.getElementById('meetingStatusID').value = '<%=MeetingStatus.TEMPLATE%>';
		var formInfo = document.getElementById("form");
		formInfo.action = "/icmp/template/addVideoMeetingTemplate.action";
		postData(false);
		 
		 }
 }
</script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="cx_bgcolr">
<form action="/icmp/detail/modifyVideoMeetingTemplate.action" method="post" name="form" id="form">
    <input type="" name="meetingVO.meetingRoomNames" id="meetingRoomNames"/>
    <input type="" name="meetingVO.meetingRoomNameIDs" id="meetingRoomNameIDs"/>
    <input type="" name="meetingVO.status" value="${meetingVO.status }" id="meetingStatusID"/>
    <input type="" name="meetingVO.meetingID" value="${meetingVO.meetingID }"/>
    <input type="" name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID }"/>
   	<input type="" name="meetingDetailVO.status" value="${meetingDetailVO.status }"/>
    <input type=""   name="meetingTemplateVO.templateName" id="meetingModelName" value="${meetingTemplateVO.templateName }">
    <input type=""   name="meetingTemplateVO.description" id="ds" value="${ meetingTemplateVO.description}">
    <c:if test="${meetingVO.createUserID != Integer.MIN_VALUE }">
    	<input type="hidden" name="meetingVO.createUserID" value="${meetingVO.createUserID }"/>
    	<input type="hidden" name="meetingVO.createUserName" value="${meetingVO.createUserName }"/>
    	<input type="hidden" name="assignID" value="${assignID }"/>
    	<input type="hidden" name="revision" value="${revision }"/>
     </c:if>	
    	
    	<select name="meetingVO.meetingType" style="display:none" class="ws120" id="meetingTypeID" >
		    				<option value="2">视频会议</option>
		</select>
   
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="mainTable">
  <tr>
    <td colspan="4" class="cx_bg">模板修改</td>
  </tr>
  <tr>
    <td class="tabletitleLeft">时长：</td>
    <td class="tabledata">
    <div style="width:100%; float:left;">
            <div style="width:152px; height:19px; float:left;">
              <div class="gselectdiv">
             <select class="gselect"  name="meetingVO.meetingDescription" id="meetingDescription">
    <option value="23">请选择...</option>
    <option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>
    <option value="0.5" ${meetingDetailVO.meetingDescription=="0.5" ? "selected" : "" }>0.5</option>
    <option value="1" ${meetingDetailVO.meetingDescription=="1" ? "selected" : "" }>1</option>
    <option value="1.5" ${meetingDetailVO.meetingDescription=="1.5" ? "selected" : "" }>1.5</option>
    <option value="2" ${meetingDetailVO.meetingDescription=="2" ? "selected" : "" }>2</option>
    <option value="2.5" ${meetingDetailVO.meetingDescription=="2.5" ? "selected" : "" }>2.5</option>
    <option value="3" ${meetingDetailVO.meetingDescription=="3" ? "selected" : "" }>3</option>
    <option value="3.5" ${meetingDetailVO.meetingDescription=="3.5" ? "selected" : "" }>3.5</option>
    <option value="4" ${meetingDetailVO.meetingDescription=="4" ? "selected" : "" }>4</option>
    <option value="4.5" ${meetingDetailVO.meetingDescription=="4.5" ? "selected" : "" }>4.5</option>
    <option value="5" ${meetingDetailVO.meetingDescription=="5" ? "selected" : "" }>5</option>
    <option value="23" ${meetingDetailVO.meetingDescription=="23" ? "selected" : "" }>24</option>
    </select>
          </div>
            </div>
            <div style="width:25px; float:left; text-align:left">小时</div>
          </div>
  
    </td>
    <td width="16%" class="tabletitleLeft">会议名称：</td>
    <td width="32%" class="tabledata"><input type="text" name="meetingVO.meetingName" value="${meetingDetailVO.meetingName }" id="meetingNameID" class="tablexxInput" />
      <span style="color:#ff0000;">&nbsp;&nbsp;*必填</span></td>
      
  </tr>
  <tr style="display:none;">
    <td class="tabletitleLeft">开始时间：</td>
    <td class="tabledata">
    <input type="text" style="cursor:hand;" class="tablexxInput" readonly name="meetingVO.meetingStartTime" onclick="selectMeetingTime(this);" onPropertyChange="javascript:time();" id="start_time" readonly="readonly" value='' />
								 <script type="text/javascript">
									var v3x = new V3X();
									v3x.init("/icmp/common/seeyon", "zh-cn");
									v3x.loadLanguage("/icmp/apps_res/meeting/js/i18n");
									_ = v3x.getMessage;
								</script>
								<script type="text/javascript">
								
								// 选择时间
									function selectMeetingTime(thisDom){
										var a=event.clientX;
										var b =event.clientY+100;
										whenstart('/icmp/common/seeyon',thisDom,a,b,'datetime');
									}
								</script>
    
     </td>
    <td class="tabletitleLeft">结束时间：</td>
    <td class="tabledata">
    <input onclick="selectMeetingTime(this);" style="cursor:hand;" readonly type="text" class="tablexxInput" onPropertyChange="javascript:time();"  name="meetingVO.meetingEndTime" id="end_time" readonly="readonly" value='' />			    				
							<script type="text/javascript">
								var v3x = new V3X();
								v3x.init("/icmp/common/seeyon", "zh-cn");
								v3x.loadLanguage("/icmp/apps_res/meeting/js/i18n");
								_ = v3x.getMessage;
							</script>
							<script type="text/javascript">
							
							// 选择时间
								function selectMeetingTime(thisDom){
									var a=event.clientX;
									var b =event.clientY+100;
									whenstart('/icmp/common/seeyon',thisDom,a,b,'datetime');
								}
							</script>
      </td>
  </tr>
    <tr style="display:none">
    <td class="tabletitleLeft">与会人员：</td>
    <td class="tabledata">
    <input type="text" style="cursor:hand;" readonly id="showParticipatorNames" class="tablexxInput" name="meetingVO.showParticipatorNames"  value="${meetingDetailVO.showParticipatorNames }" onclick="participatorTree('participatorIDs', 'participatorNames', 'showParticipatorNames', 'attendanceID');">
			    				<input type="hidden" name="meetingVO.participators" id="participatorNames" value="${meetingDetailVO.participators }"/>
			    				<input type="hidden" name="meetingVO.participatorIDs" id="participatorIDs"  value="${meetingDetailVO.participatorIDs }"/>
			    				<input type="hidden" name="" id="attendanceID"/>
    
   </td>
    <td class="tabletitleLeft">通知方式：</td>
    <td class="tabledata">
    <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="emailID" checked>邮件　
								 <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="messageID">短信　
								 <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="oaID" disabled="disabled">OA
				    			<input type="hidden" name="meetingVO.notifyType" id="notifyTypeID" value="${meetingDetailVO.notifyType}"/>
 </td>
  </tr>
  <script type="text/javascript">
			  <!--
			  		var notifyType = document.getElementById('notifyTypeID');
			  		if(notifyType.value.length >= 3){
						var messageID = notifyType.value.charAt(0);
						if(messageID == "1"){
							document.getElementById('messageID').checked = "checked";
						}
						var emailID = notifyType.value.charAt(1);
						if(emailID == "1"){
							document.getElementById('emailID').checked = "checked";
						}
						var oaID = notifyType.value.charAt(2);
						if(oaID == "1"){
							document.getElementById('oaID').checked = "checked";
						}
					}
			  	
			  //-->
			  </script>	
   <tr style="display:none">
   	<td class="tabletitleLeft"></td>
    <td class="tabledata">
  
    </td>
    <td class="tabletitleLeft">服务需求：</td>
    <td class="tabledata">
    <input type="text"  class="tablexxInput" style="cursor:hand" readonly name="meetingVO.neededServiceNames" value="${meetingDetailVO.neededServiceNames }" id="neededServiceNames" onclick="neededService('neededServiceNames', 'neededServiceIDs');">
    <input type="hidden" name="meetingVO.neededServiceIDs" value="${meetingDetailVO.neededServiceIDs }" id="neededServiceIDs">
    
    </td>
    
  </tr>
  <tr>
    <td colspan="4">
    
    </td>
  </tr>
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
</table>
<div class="buttoncontainer"><input type="button" class="submit1 radius2" value="确定提交" onclick="postData(false);" /><input type="button" class="reset1 radius2" value="取  消" onclick="javascript:history.go(-1)"/></div>
</body>
</html>
