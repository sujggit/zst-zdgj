<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.MeetingDetailEnum" %>
<%@ page import="com.zzst.model.meeting.meetingDetail.MeetingDetailVO"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO" %>
<%@ page import="com.zzst.model.enums.MeetingRoomEnum" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript'>
	function go(){
	  //alert("55");
	  window.setInterval("runit()",'1000');
	  //window.setInterval("pageFresh()",1*60*1000);
	}
	function pageFresh(){
		window.location.href="${sys_ctx}/meeting/notice/noticeTodayList.jsp";
		
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
<%
	MeetingDetailVO vo = new MeetingDetailVO();
	Calendar c = Calendar.getInstance();
	c.set(Calendar.HOUR,0);
	c.clear(Calendar.SECOND);
	c.clear(Calendar.MINUTE);
	c.clear(Calendar.MILLISECOND);
	vo.setMeetingStartTime(new Timestamp(c.getTimeInMillis()));

	c.set(Calendar.HOUR,23);
	c.set(Calendar.SECOND,59);
	c.set(Calendar.MINUTE,59);
	c.set(Calendar.MILLISECOND,0);
	vo.setMeetingEndTime(new Timestamp(c.getTimeInMillis()));
	vo.setStatus(MeetingDetailEnum.STATUS_ING+","+MeetingDetailEnum.STATUS_APPROVED_PASS);
	ArrayList listConference = ServiceFactory.getMeetingDetailService().query(vo,null);
%>
  
 <body  class="dp_bg" onload="go();">
 <table border="0" cellpadding="0" cellspacing="0" class="dp_bg3">
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
            <div  class="mindivkz2">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="listsearch">
         <thead>
	        <tr>
           	<th width="65px" class="titlehome2 ac fontstyle3" >序号</th>
            <th class="titlehome2 ac fontstyle3" style="border-left:0px">会议主题</th>
            <th width="150px" class="titlehome2 ac fontstyle3" >会议室名称</th>
            <th width="180px" class="titlehome2 ac fontstyle3" >开始时间</th>
            <th width="180px" class="titlehome2 ac fontstyle3" >结束时间</th>
          </tr> 
          </thead>
          </table>
          <MARQUEE BOTTOM=20px HEIGHT= 400px  scrollAmount="1" scrollDelay=20 direction="up"  border="2" >
	          <%
	          if(listConference!=null){
	        	  for(int i=0;i<listConference.size();i++){
	        		  MeetingDetailVO detailVO  =  (MeetingDetailVO)listConference.get(i);
	        		  if((i+1)%2==0){
	        		  %>
					  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="listsearch">
	        		   <tr>
	              		<td width="65px" class="ac fontstyle2 tdss"><%=i+1 %></td>
	                    <td class="ac fontstyle2 tdss" style="border-left:0px"><%=detailVO.getMeetingName() %></td>
	                    <td width="150px" class="ac fontstyle2 tdss"><%=detailVO.getMeetingRoomName() %></td>
			            <td width="180px" class="ac fontstyle2 tdss"><fmt:formatDate value="<%=detailVO.getMeetingStartTime() %>" pattern="yyyy-MM-dd HH:mm "/></td>
			            <td width="180px" class="ac fontstyle2 tdss"><fmt:formatDate value="<%=detailVO.getMeetingEndTime() %>" pattern="yyyy-MM-dd HH:mm "/></td>
	             	  </tr>
	             	 </table>
	        		  <%
	        		  }else{
	        		  	%>
					  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="listsearch">
	        		   <tr>
	              		<td width="65px" class="ac fontstyle2 tdhh"><%=i+1 %></td>
	                    <td class="ac fontstyle2 tdhh" style="border-left:0px"><%=detailVO.getMeetingName() %></td>
	                    <td width="150px" class="ac fontstyle2 tdhh"><%=detailVO.getMeetingRoomName() %></td>
			            <td width="180px" class="ac fontstyle2 tdhh"><fmt:formatDate value="<%=detailVO.getMeetingStartTime() %>" pattern="yyyy-MM-dd HH:mm "/></td>
			            <td width="180px" class="ac fontstyle2 tdhh"><fmt:formatDate value="<%=detailVO.getMeetingEndTime() %>" pattern="yyyy-MM-dd HH:mm "/></td>
	             	  </tr>
	             	 </table>
	        		  <%
	        		  }
	        	  }
	          }
	          %>
	          </MARQUEE>
            </div>
            </td>
         </tr>
        </table>
        </td>
     </tr> 
 </table>
</body>
</html>
