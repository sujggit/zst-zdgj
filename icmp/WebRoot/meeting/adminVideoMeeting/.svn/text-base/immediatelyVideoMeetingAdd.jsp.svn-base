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
		<title>立即召开</title>
		<style type="text/css">
			.bodybg{border:0px;position:absolute;z-index: 10;}
			.tckbgys{background:url(/icmp/images/advance/tccbg.png) no-repeat; width:313px; height:199px; border:0px;}
			.fontone{padding-top:60px; font-size:24px; color:#a90d19; font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;}
			.fonttwo{text-align:right; padding-right:30px; color:414243; width:280px; font-size:18px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif;}
			.fonttwo a { text-decoration: none; color: #414243; outline: none; }
			.fonttwo a:hover { text-decoration: underline; color: #000000; outline: none; }
		</style>
		<script type="text/javascript"> 
	//显示灰色JS遮罩层 
	function showBg(ct,content){ 
	    var bH=$("body").height()+20; 
	    var bW=$("body").width()+16; 
	    var objWH=getObjWh(ct); 
	    $("#fullbg").css({width:bW,height:bH,display:"block"}); 
	    var tbT=objWH.split("|")[0]+"px"; 
	    var tbL=objWH.split("|")[1]+"px"; 
	    $("#"+ct).css({top:tbT,left:tbL,display:"block"}); 
	    //$(window).scroll(function(){resetBg()}); 
	   // $(window).resize(function(){resetBg()}); 
	} 
	function getObjWh(obj){ 
	    var st=document.documentElement.scrollTop;//滚动条距顶部的距离 
	    var sl=document.documentElement.scrollLeft;//滚动条距左边的距离 
	    var ch=document.documentElement.clientHeight;//屏幕的高度 
	    var cw=document.documentElement.clientWidth;//屏幕的宽度 
	    var objH=$("#"+obj).height();//浮动对象的高度 
	    var objW=$("#"+obj).width();//浮动对象的宽度 
	    var objT=Number(st)+(Number(ch)-Number(objH))/2; 
	    var objL=Number(sl)+(Number(cw)-Number(objW))/2; 
	    return objT+"|"+objL; 
	} 

	function resetBg(){ 
	    var fullbg=$("#fullbg").css("display"); 
	    if(fullbg=="block"){ 
	        var bH2=$("body").height(); 
	        var bW2=$("body").width()+16; 
	        $("#fullbg").css({width:bW2,height:bH2}); 
	        var objV=getObjWh("dialog"); 
	        var tbT=objV.split("|")[0]+"px"; 
	        var tbL=objV.split("|")[1]+"px"; 
	        $("#dialog").css({top:tbT,left:tbL}); 
	    } 
	} 

	//关闭灰色JS遮罩层和操作窗口 
	function closeBg(){ 
	    $("#fullbg").css("display","none"); 
	    $("#bodybg").css("display","none"); 
	    $("#dialog").css("display","none"); 
	} 

</script>
<style type="text/css">
* {
    font-family:Arial, Helvetica, sans-serif;
    font-size:12px;
}
#fullbg {
    background-color: Gray;
    display:none;
    z-index:3;
    position:absolute;
    left:0px;
    top:0px;
    filter:Alpha(Opacity=30);
    /* IE */ 
    -moz-opacity:0.4;
    /* Moz + FF */ 
    opacity: 0.4;
}
</style>
		
		
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
			}
			if($("#select").val()==""){
				alert("请选择会议模式");
				return;
			}
				
					selectedMeetingRoom = document.getElementById('selectedMeetingRoomID');
					for(var i=0; i < selectedMeetingRoom.length; i++){
						meetingRoomNames += selectedMeetingRoom.options[i].text;
						meetingRoomNameIDs += selectedMeetingRoom.options[i].value.split("##")[0];
						
						
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
			if(lst != null && lst.length > 0){
				var meetingRoomNames = "";
 				for(var i = 0; i < lst.length; i++){
 	 				if(i > 0){
 	 					meetingRoomNames += ", ";
 	 				}
 					meetingRoomNames += lst[i];
 				}
 				alert(meetingRoomNames + " 已经被其他会议占用！\n");
 				return;
			}else{
				$("#subbtn").val("请等待").attr("disabled","disabled");
				showBg('dialog','dialog_content');
				document.all.form.submit();	
				window.close();			
			}
		}
		
</script>
  </head>
  
  <body>
<!-- JS遮罩层 -->
  	<form action="/icmp/detail/immediatelyVideoMeetingAdd.action" method="post" name="form" id="form">
    <input type="hidden" name="meetingDetailVO.meetingRoomNames" id="meetingRoomNames"/>
    <input type="hidden" name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs"/>
    <input type="hidden" name="meetingDetailVO.status" value="${meetingDetailVO.status }" id="meetingStatusID"/>
    <input type="hidden" name="meetingDetailVO.meetingID" value="${meetingDetailVO.meetingID }"/>
    <input type="hidden" name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID }"/>
    <c:if test="${meetingDetailVO.createUserID != Integer.MIN_VALUE }">
    	<input type="hidden" name="assignID" value="${assignID }"/>
    	<input type="hidden" name="revision" value="${revision }"/>
     </c:if>	
    	
   <select name="meetingDetailVO.meetingType" style="display:none" class="ws120" id="meetingTypeID" >
		    				<option value="2">视频会议</option>
   </select>
   
  
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
      	 <input name="type" value="1" type="hidden"></input><!-- 建会模式 1为子MCU演讲者模式模板 2为子MCU无模式模板 -->
        <tr>
          <td width="15%" class="tableaddtitle">时长/时</td>
          <td width="35%" class="tableadd_data" >
            <select class="inputtran"  name="meetingDetailVO.meetingDescription" id="meetingDescription">
    <%--<option value="23">请选择...</option>--%>
    <%--<option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>--%>
			    <zzst:option type="meetingtime" value="" />
    		</select>        
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
          <td width="35%" class="tableadd_data"><input maxlength="25" id="meetingName" name="meetingDetailVO.meetingName" type="text" class="inputtran" value="${meetingDetailVO.meetingName }"/></td>
        </tr>
      </table>
      
      <%@include file="videoMeetingRoomTreeVideo1.jsp" %>
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
            <td ><input type="button" id="subbtn" class="submit1 radius2" value="确 定" onclick="postData(false);"/>
         
              <input type="button" class="reset1 radius2" value="取 消" onclick=" javascript:history.go(-1)"/>
            </td>
          </tr>
        </tbody>
      </table>
      
      <!--contenttitle--> 
    </div>
    <!--contentwrapper--> 
    </form>
    <div id="fullbg"></div>
<!-- end JS遮罩层 -->
<!-- 对话框 -->
<div class="bodybg" style="display:none" id="dialog">
<div  class="tckbgys" id="dialog_content">
 <p class="fontone">正在建会，请稍等...</p>
 <p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
 <p class="fonttwo"></p>
</div>
</div>
</body>
</html>
