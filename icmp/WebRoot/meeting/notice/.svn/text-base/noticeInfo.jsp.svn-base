<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.meetingDetail.MeetingDetailVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@ page import="com.zzst.model.enums.MeetingDetailEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<%
	String meetingID = request.getParameter("meetingID");
	MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	if(meetingID!=null&&meetingID.length()>0){
		meetingDetailVO.setMeetingDetailID(meetingID);
		meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_ING+","+MeetingDetailEnum.STATUS_APPROVED_PASS);
		ArrayList list = ServiceFactory.getMeetingDetailService().queryForDepartment(meetingDetailVO,null);
		if(list!=null&&list.size()>0){
			meetingDetailVO = (MeetingDetailVO)list.get(0);
		}
	}
 %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript'>
	function go(){
	  //alert("55");
	  window.setInterval("runit()",'1000');
	}
	
	function runit(){
		//alert(new Date().getTime());
		var myDate = (new Date().getFullYear()+"年"+new Date().getMonth()+"月"+new Date().getDate()+"日");
		
		var weekDay = new Date().getDay();
		var x = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
		var myWeek = x[weekDay];
		
		var myHours = new Date().getHours();
		var myMinutes = new Date().getMinutes();
		var mySeconds = new Date().getSeconds();
		
		var myHH = "";
		var myMM = "";
		var mySS = "";
		
		if(myHours<10){
			myHH = '0'+myHours;
		}else{
			myHH = myHours;
		}
		
		if(myMinutes<10){
			myMM = "0"+myMinutes;
		}else{
			myMM = myMinutes;
		}
		
		if(mySeconds<10){
			mySS = "0"+mySeconds;
		}else{
			mySS = mySeconds;
		}
		
		var myTime = (myHH+":"+myMM+":"+mySS);
		var showTime = myDate+"    "+myWeek+"   "+myTime;
		
		
		document.getElementById("currentTime").innerHTML = showTime;
	}
	
	
</script>	
<title>告示信息</title>
</head>
  
 <body  class="dp_bg" onload="go();">
 <table border="0" cellpadding="0" cellspacing="0" class="dp_bg2">
     <tr>
        <td class="top_ys">
        	<span id="currentTime"></span>
        </td>
     </tr> 
     <tr>
        <td align="center">
        <table width="99%" border="0" cellspacing="0" cellpadding="0">
         <tr class="top_left">
            <td class="text_sx"><img src="${sys_ctx }/images/blue/login_10.png" width="90" height="90" /></td>
            <td class="tt_sz">${sys_viewName }</td>
            <td class="weiz"><img src="${sys_ctx }/images/blue/mid_cengte.png" width="402" height="110" /></td>
        </tr>
        </table>
        </td>
     </tr>
     <tr>
        <td align="center">
        <table width="99%" border="0" cellspacing="0" cellpadding="0" class="tabdx">
         <tr>
            <td valign="center" class="mie_cente">
            <div  class="mindivkz">
            
            <%
            if(meetingID!=null&&meetingID.length()>0){
            	%>
            	<ul class="min_ztys">
            	<li>会议主题：<%=meetingDetailVO.getMeetingName() %></li> 
            	<li>举办单位：<%=meetingDetailVO.getDepartmentNames() %></li> 
            	<li>会议时间：<fmt:formatDate value="<%=meetingDetailVO.getMeetingStartTime() %>" pattern="yyyy年/MM月/dd日 HH:mm"/>—<fmt:formatDate value="<%=meetingDetailVO.getMeetingEndTime() %>" pattern="HH:mm"/></li>
            	</ul>
            	<%
            }else {
            	 %>
            	会议室空闲 
            	 <%
            }
            %>
            
            </div>
            </td>
         </tr>
        </table>
        </td>
     </tr> 
 </table>
</body>
</html>
