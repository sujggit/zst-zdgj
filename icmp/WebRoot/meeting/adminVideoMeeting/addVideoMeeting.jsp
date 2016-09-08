<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.zzst.action.meeting.util.*"%>
<%@ page import="com.zzst.model.enums.MeetingStatus"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>
<%
String templateName=(String)request.getAttribute("templateName");
pageContext.setAttribute("templateName",templateName);
System.out.println(templateName);

%>

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


<title>预定页面</title>

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

		function postData(isCheckMeetingRoom){
		if(isCheckMeetingRoom==true){
		    time();
		    }
		    var checkUp = document.getElementById("checkbox");
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
            if(isCheckMeetingRoom==true){         
		    if(beginTime!=""){		
							var beginTimes=beginTime.substring(0,10).split('-');
							var endTimes=val1.substring(0,10).split('-');
							beginTime=beginTimes[1]+'-'+beginTimes[2]+'-'+beginTimes[0]+' '+beginTime.substring(10,19);
							val1=endTimes[1]+'-'+endTimes[2]+'-'+endTimes[0]+' '+val1.substring(10,19);
							var a =(Date.parse(val1)-Date.parse(beginTime))/3600/1000;
							
							if(a>0||a==0){
							alert("会议开始时间需晚于当前时间");
							return;
							}
							}
				}			
							
							if(meetingDescription.value==""){
							alert("立即会议请选择会议时长");
							return;
							}
							
			if(meetingName==""){
				alert("请输入会议名称");
				return;
			}else if(s==""){
				alert("请选择开始时间");
				return;
			}else if(e==""){
				alert("请选择结束时间");
				return;
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
		
				var meetingType = document.getElementById('meetingTypeID');
			
				if(meetingType.value == detailVideoMeetingType){
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
				
					checkMeetingRoom();
				}else{
					document.all.form.submit();
<!--					window.opener.backRe();-->
<!--					window.close();	-->
					
				}
			}
			
		}
				
		function checkMeetingRoom(){
			var meetingType = document.getElementById('meetingTypeID').value;
			var checkUp = document.getElementById("checkbox");
			if(checkUp.checked==true){
				//create conference immediately
				var duration = document.getElementById('meetingDescription').value;
				if(meetingType ==detailVideoMeetingType){
					var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
					DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomNameIDs, duration, checkMeetingRoomCallBack);
				}else{
					var meetingRoomID = document.getElementById('availableMeetingRoomID').value;
					DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomID, duration, checkMeetingRoomCallBack);
				}
			}else{
				//subscrible conference
				var startTime = document.getElementById('start_time').value;
				var endTime = document.getElementById('end_time').value;
				if(meetingType ==detailVideoMeetingType){
					var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
					DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomNameIDs, startTime, endTime, checkMeetingRoomCallBack);
				}else{
					var meetingRoomID = document.getElementById('availableMeetingRoomID').value;
					DwrMethod.checkMeetingRoom(0, meetingType, meetingRoomID, startTime, endTime, checkMeetingRoomCallBack);
				}
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
<!--				window.opener.backRe();-->
<!--				window.close();	-->
					
			}
		}		
		
	
 function addtemplateName(){
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
			alert("存为模板之前请选择模板会议时长");
			return;
			}	
			if(meetingName==""){
				alert("请输入会议名称");
				return;
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

		postData(false);
		
		 }
 }
 
</script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="cx_bgcolr">
<form action="/icmp/detail/addVideoMeeting.action" method="post" name="form" id="form">
    <input type="hidden" name="meetingVO.meetingRoomNames" id="meetingRoomNames"/>
    <input type="hidden"  name="checkUp" value="${checkUp}"  id="234"/>
    <input type="hidden" name="meetingVO.meetingRoomNameIDs" id="meetingRoomNameIDs"/>
    <input type="hidden" name="meetingVO.status" value="${meetingVO.status }" id="meetingStatusID"/>
    <c:if test="${meetingVO.createUserID != Integer.MIN_VALUE }">
    	<input type="hidden" name="meetingVO.createUserID" value="${meetingVO.createUserID }"/>
    	<input type="hidden" name="meetingVO.createUserName" value="${meetingVO.createUserName }"/>
    	<input type="hidden" name="assignID" value="${assignID }"/>
    	<input type="hidden" name="revision" value="${revision }"/>    	
     </c:if>
        <input type="hidden"   name="meetingTemplateVO.templateName" id="meetingModelName" value="" />
    	<input type="hidden"   name="meetingTemplateVO.description" id="ds" value="" />	
    	<select name="meetingVO.meetingType" style="display:none" class="ws120" id="meetingTypeID" >
		    				<option value="2">视频会议</option>
		</select>
  
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="mainTable">
  <tr>
    <td colspan="4" class="cx_bg">新建会议</td>
  </tr>
  <tr>
    <td width="16%" class="tabletitleLeft">时长：</td>
    <td width="32%" class="tabledata">
    <div style="width:100%; float:left;">
            <div style="width:152px; height:19px; float:left;">
              <div class="gselectdiv">
             <select class="dataselect"  name="meetingVO.meetingDescription" id="meetingDescription">
    <option value="0.5">0.5</option>
    <option value="1">1</option>
    <option value="1.5">1.5</option>
    <option value="2">2</option>
    <option value="2.5">2.5</option>
    <option value="3">3</option>
    <option value="3.5">3.5</option>
    <option value="4">4</option>
    <option value="4.5">4.5</option>
    <option value="5">5</option>
    <option value="23">24</option>
    </select>
          </div>
            </div>
            <div style="width:25px; float:left; text-align:left">小时</div>
          </div>
    </td>
    <td width="16%" class="tabletitleLeft">会议名称：</td>
    <td width="36%" class="tabledata"><input type="text" name="meetingVO.meetingName" value="${meetingVO.meetingName }" id="meetingNameID" class="tablexxInput" />
      <span style="color:#ff0000;">&nbsp;&nbsp;&nbsp;&nbsp;*必填</span></td>
  </tr>
  <tr id="time123">
    <td class="tabletitleLeft">开始时间：</td>
    <td class="tabledata">
    <input type="text" style="cursor:hand;" class="tablexxInput" readonly name="meetingVO.meetingStartTime" onclick="selectMeetingTime(this);" onPropertyChange="javascript:time();" id="start_time" readonly="readonly" value='<fmt:formatDate value="${meetingVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'>
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
    <input onclick="selectMeetingTime(this);" style="cursor:hand;" readonly type="text" class="tablexxInput" onPropertyChange="javascript:time();"  name="meetingVO.meetingEndTime" id="end_time" readonly="readonly" value='<fmt:formatDate value="${meetingVO.meetingEndTime}"  pattern="yyyy-MM-dd HH:mm"/>'>			    				
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
    <input type="text" style="cursor:hand;" readonly id="showParticipatorNames" class="tablexxInput" name="meetingVO.showParticipatorNames"  value="${meetingVO.showParticipatorNames }" onclick="participatorTree('participatorIDs', 'participatorNames', 'showParticipatorNames', 'attendanceID');">
			    				<input type="hidden" name="meetingVO.participators" id="participatorNames" value="${meetingVO.participators }"/>
			    				<input type="hidden" name="meetingVO.participatorIDs" id="participatorIDs"  value="${meetingVO.participatorIDs }"/>
			    				<input type="hidden" name="" id="attendanceID"/>
    
   </td>
    <td class="tabletitleLeft">通知方式：</td>
    <td class="tabledata">
    <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="emailID" checked>邮件　
				 <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="messageID">短信　
				 <input class="noborder" type="checkbox" name="RadioGroup1" value="单选" id="oaID" disabled="disabled">OA
    			 <input type="hidden" name="meetingVO.notifyType" id="notifyTypeID"/>
 </td>
  </tr>

  <tr>
    <td colspan="4"><%@include file="/meeting/adminVideoMeeting/videoMeetingRoomTreeVideo.jsp" %>
    </td>
  </tr>
</table>
<div class="buttoncontainer"><input type="button" class="submit1 radius2 submitBtn_Disa" value="确定提交" onclick="postData(true);" /><input type="button" class="submit1 radius2" value="存为模板" onclick="addtemplateName();"/><input type="button" class="reset1 radius2" value="返  回" onclick="javascript:history.go(-1)"/></div>
</body>
</html>
