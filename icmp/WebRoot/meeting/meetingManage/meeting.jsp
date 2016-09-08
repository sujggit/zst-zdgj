<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/common/common_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${sys_ctx }/style/css.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${sys_ctx }/js1/Common.js"></script>
		<script src="${sys_ctx }/js1/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuHelpDwrMethod.js'> </script>
		<title>无标题文档</title>
<script type="text/javascript">
				function bgChange(){
				  if(!document.getElementsByTagName) return false;
				  var tables = document.getElementsByTagName("table");
				  for(var i=0; i<tables.length; i++){
				    var odd = false;
				    trs = tables[i].getElementsByTagName("tr");
				    for(var j=0; j<trs.length; j++){
				      if(odd==true){
				        trs[j].style.background = "#393939";
				        odd = false;
				      }else{
				       	trs[j].style.background = "#2C2C2C";
				        odd = true;
				      }
				    }
				  }
				}
				</script>
<script type="text/javascript">
	function show(id){
	
		$("#"+id).toggle();
	}
	
 	function deleteConf(meetingDetail){
		/*var meetingDetailIDs = "";
		var meetingDetails = document.getElementsByName(meetingDetail).value;
		alert("asdfas");*/
		
		//var meetingDetails = document.getElementsByTagName('input');
		var meetingDetails = document.getElementsByName("confRadioName");
		var isSelected = false;
		for(i = 0; i < meetingDetails.length; i++) {
			if(meetingDetails[i].type == 'radio' && meetingDetails[i].checked == true) {
				if(!confirm("确定要结束序号为"+[i+1]+"的会议吗？")){
					return;
				}
				isSelected = true;
				var meetingArray = new Array();
				meetingArray = meetingDetails[i].value.split("_");
				if(meetingArray.length >= 1){
					McuDwrMethod.deleteConf(meetingArray[1], function(){window.location.reload();});
				}
			}
		}
		if(!isSelected){
			alert("请选择需要结束的会议");
			return;
		}
	}
	function meetingDelay(meetingDetail){
		//var meetingDelayID = document.getElementsByTagName('input');
		var meetingDetails = document.getElementsByName("confRadioName");
		var isSelected = false;
		for(i = 0; i < meetingDetails.length; i++) {
			if(meetingDetails[i].type == 'radio' && meetingDetails[i].checked == true) {
				isSelected = true;
				var meetingArray = new Array();
				meetingArray = meetingDetails[i].value.split("_");
				if(meetingArray.length == 2){
					window.open('${sys_ctx }/meeting/meetingManage/meetingDelay.jsp?meetingDetailID=' + meetingArray[1] ,'04','width=300px,height=145px,directories,scrollbars=yes');
				}	
			}
		}
		if(!isSelected){
			alert("请选择需要延时的会议");
			return;
		}
	}
	
	
	function screenType(confID){
		//var meetingDelayID = document.getElementsByTagName('input');
		var meetingDetails = document.getElementsByName("confRadioName");
		var isSelected = false;
		for(i = 0; i < meetingDetails.length; i++) {
			if(meetingDetails[i].type == 'radio' && meetingDetails[i].checked == true) {
				isSelected = true;
				var meetingArray = new Array();
				meetingArray = meetingDetails[i].value.split("_");
				if(meetingArray.length == 2){
				 window.open('${sys_ctx }/meetingManage/dech.jsp?confID=' + meetingArray[0] +'&mark=0','03','width=700px,height=475px,directories,scrollbars=yes');
				 }
				}	
			}
		
		if(!isSelected){
			alert("请选择需要分屏的会议");
			return;
		}
	}
	
	
	function getMessageOverlay(){
		//var confIDs = document.getElementsByTagName('input');
		var confIDs = document.getElementsByName("confRadioName");
		var isSelected = false;
		for(i = 0; i < confIDs.length; i++) {
			if(confIDs[i].type == 'radio' && confIDs[i].checked == true) {
				isSelected = true;
				var meetingArray = new Array();
				meetingArray = confIDs[i].value.split("_");
				if(meetingArray.length >= 1){
					window.open('${sys_ctx }/conf/getMessageOverlay.action?confID=' + meetingArray[0] ,'02','width=600px,height=250px,directories,scrollbars=yes');
				}	
			}
		}
		if(!isSelected){
			alert("请选择一个会议");
			return;
		}
	}

	function getMeetingRoomName(){
		//var confID = document.getElementsByTagName('input');
		var confIDs = document.getElementsByName("confRadioName");
		var isSelected = false;
		for(i = 0; i < confIDs.length; i++) {
			if(confIDs[i].type == 'radio' && confIDs[i].checked == true) {
				isSelected = true;
				var meetingArray = new Array();
				meetingArray = confIDs[i].value.split("_");
				if(meetingArray.length >= 1){
					window.open('${sys_ctx }/conf/getMeetingRoomName.action?confID=' + meetingArray[0] ,'06','width=600px,height=250px,directories,scrollbars=yes');
				}	
			}
		}
		if(!isSelected){
			alert("请选择需要修改会议名称的会议");
			return;
		}
	}
		
		var mark
	var blowUpIp
	var bName
	var meetingRoomid
	var bID
	function setMark(id,ip,name,meetingRoomid){
		mark=id;
		blowUpIp = ip;
		bName = name;
		bID = meetingRoomid;
	}
	
</script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
	<form action="${sys_ctx }/mcuControl/manageMeetingListFor.action" method="post" name="pageform" id="pageform">
		<table  border="0" cellspacing="0" cellpadding="0" class="cx_tab">
			<tr>
				<td   valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="cx_tab" >
					   <tr>
						   <td  class="cx_bgsx4">过滤条件：
					          <select name="select" id="select" class="cx_textsx3">
					             <option>请选择过滤条件</option>
					          </select>
					             <a href="javascript:void(0)" onclick="javascript:deleteConf('');">结束会议</a>
					             <a href="javascript:void(0)" onclick="javascript:meetingDelay('');">延时会议</a>
						    </td>
					   </tr>
				    </table>
				    <table width="99%" border="0" cellspacing="1" cellpadding="0" align="center" class="cx_tab">
				        <tr>
				        	<td  class="cx_bgsx">选择</td>
				            <td  class="cx_bgsx">序号</td>
				            <td  class="cx_bgsx">会议名称</td>
				            <td  class="cx_bgsx">开始时间</td>
				            <td  class="cx_bgsx">结束时间</td>
				            <td  class="cx_bgsx">会议号码</td>
				        </tr>
				           <c:forEach items="${confVOList}" var="conf" varStatus="status">
				        <tr>
				            <td class="cx_bgsx2">
				               <input type="radio" name="confRadioName" value="${conf.confID}_${conf.confFlagId }" ${status.count == 1 ? "checked" : "" }/>
				            </td>
				          	<td class="cx_bgsx2"><c:choose>
								<c:when test="${totalPages > 1}">${(currentPage-1) * pageSize + status.count} </c:when>
								<c:otherwise>${status.count } </c:otherwise>
						    </c:choose>
						  	</td>
				          	<td class="cx_bgsx2">
				          		<c:out value="${conf.confName}" />
				          	</td>
				          	<td class="cx_bgsx2">
				          		<fmt:formatDate value="${conf.startTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
				          	<td class="cx_bgsx2">
				          		<fmt:formatDate value="${conf.endTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
				          	<td class="cx_bgsx2">&nbsp;
				          		<c:out value="${conf.e164}" />
				          	</td>
				        </tr>
				          </c:forEach>
				     </table>
				 </td>
			</tr>
		</table>
	</form>
</body>
</html>
