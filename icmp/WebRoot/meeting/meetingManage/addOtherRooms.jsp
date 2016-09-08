<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common_header.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>添加会场</title>
		<link href="${sys_ctx }/style/css.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${sys_ctx }/js1/Common.js"></script>
		<script src="${sys_ctx }/js1/jquery-1.3.2.min.js" type="text/javascript"></script>

		<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
	
	
	<script type="text/javascript">
		<!--
			function selectRooms(fromID, toID, numberID){
		 		var fromUsers = document.getElementById(fromID);
		 		var toUsers = document.getElementById(toID);
		 		for(var i=0; i < toUsers.length; i++){
			 		if(toUsers.options[i].text == ""){
			 			toUsers.remove(i);	
			 		}
		 		}
		 		
		 		for(var j=0; j < fromUsers.length; j++){
		 			if(fromUsers.options[j].selected){
		 				insertOption(toID, fromUsers.options[j].text, fromUsers.options[j].value);
		 			}
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function selectAllRooms(fromID, toID, numberID){
		 		var fromUsers = document.getElementById(fromID);
		 		var toUsers = document.getElementById(toID);
		 		for(var i=0; i < toUsers.length; i++){
			 		if(toUsers.options[i].text == ""){
			 			toUsers.remove(i);	
			 		}
		 		}
		 		
		 		for(var i=0; i < fromUsers.length; i++){
		 			insertOption(toID, fromUsers.options[i].text, fromUsers.options[i].value);
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function insertOption(toID, name, value){
		 		var o = document.createElement('option');
		 		o.text = name;
		 		o.value= value;
	
		 		var toUsers = document.getElementById(toID);	
		 		for(var i=0; i < toUsers.length; i++){
		 			if(toUsers.options[i].text == o.text && toUsers.options[i].value == o.value){
				 		return;
		 			}
		 		}
		 		
		 		try{
		 			toUsers.add(o, null);
		 		}
		 		catch(ex){
		 			toUsers.add(o);
		 		}
		 	}
		 	
		 
		 	function removeAllOptions(toID, numberID){
		 		var toUsers = document.getElementById(toID);	
				for(var i=toUsers.length - 1; i >= 0; i--){
		 			if(toUsers.options[i].selected == true){
		 				toUsers.options[i] = null;
		 			}
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function operateRooms(selectedRoomIDs){
		 		if('${param.op}' == 'polling'){
		 			pollRooms(selectedRoomIDs);
		 		}else{
		 			if('${param.op}' == 'add'){
			 			addRooms(selectedRoomIDs);	 				
		 			}
		 		}
		 	}
		 	
		 	/**
		 	* poll rooms
		 	*/
		 	function pollRooms(selectedRoomIDs){
		 		var roomIDs = document.getElementById(selectedRoomIDs);
		 		var isAvailable = checkSelectedNumber(roomIDs);
		 		if(!isAvailable){
		 			return;
		 		}
		 		
		 		var finalRoomIDs = "";
		 		var finalRoomNames = "";
		 		for(var i=0; i < roomIDs.length; i++){
		 			if(finalRoomIDs != ""){
		 				finalRoomIDs += ",";
		 				finalRoomNames +="、";
		 			}
		 			finalRoomIDs += "'" +roomIDs.options[i].value + "'";
		 			finalRoomNames += roomIDs.options[i].text;
		 		}
		 		
		 		McuDwrMethod.pollParticipants('${chooseMeetingNumber}', finalRoomIDs, finalRoomNames, pollingCallBack);
		 	}
		 	
		 	/**
		 	*add rooms
		 	*/
		 	function addRooms(selectedRoomIDs){
		 		var roomIDs = document.getElementById(selectedRoomIDs);
		 		var isAvailable = checkSelectedNumber(roomIDs);
		 		if(!isAvailable){
		 			return;
		 		}
		 		
		 		var finalRoomIDs = "";
		 		var finalRoomNames = "";
		 		for(var i=0; i < roomIDs.length; i++){
		 			if(finalRoomIDs != ""){
		 				finalRoomIDs += ",";
		 				finalRoomNames +="、";
		 			}
		 			finalRoomIDs += "'" + roomIDs.options[i].value + "'";
		 			finalRoomNames += roomIDs.options[i].text;
		 		}
		 		
		 		McuDwrMethod.addParticipants('${chooseMeetingNumber}', finalRoomIDs, finalRoomNames, modifyMeetingCallBack);
		 	}
		 	
			function pollingCallBack(){
				window.close();
			}
		 	
		 	function modifyMeetingCallBack(){
		 		window.close();
<%--		 		window.setTimeout("refreshOpener()", 5000);--%>
		 		
		 	}
		 	
		 	function refreshOpener(){
<%--		 		window.opener.location.reload();--%>
		 		window.close();
		 	}
		 	
		 	function checkSelectedNumber(select){
	 			if(select == null){
	 				return false;
	 			}
	 			var count = 0;
	 			for(var i=0; i < select.length; i++){
	 				if(select.options[i].value != ""){
	 					count = count + 1;
	 					break;
	 				}
	 			}
	 			
	 			if(count == 0){
	 				alert("至少选择一个与会人");
	 				return false;
	 			}
	 			
	 			return true;
	 		}

	 	

	 	
	function dblClickDelete(fromID, toID, numberID){
	 			removeAllOptions(toID, numberID);
	 		}
		
	 		
	function dblClickSelect(fromID, toID, numberID){
			var fromUsers = document.getElementById(fromID);
			var toUsers = document.getElementById(toID);
 		for(var i=0; i < toUsers.length; i++){
	 		if(toUsers.options[i].text == ""){
	 			toUsers.remove(i);	
	 		}
 		}
 		
 		insertOption(toID, fromUsers.options[fromUsers.selectedIndex].text, fromUsers.options[fromUsers.selectedIndex].value);
 		document.getElementById(numberID).innerHTML = toUsers.length;
		}
	 	
	 	//-->
	 	</script>	
	</head>

	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="mainTable1">
			<tr>
	    		<td class="cx_bgsx4" colspan="5">添加会场</td>
	  		</tr>	
			<tr>
				<td class="cx_bgsx2">
					<table border="0" cellpadding="0" cellspacing="0">
			  			<tr id="dp2">
							<td width="45%"  class="cx_bgsx2" >请选择会场：</td>
							<td align="center" class="cx_bgsx2">&nbsp;</td>
							<td width="45%" class="cx_bgsx2">已选择<span class="red"  id="numberID">0</span>会场 </td>
			  			</tr>
			  			<tr>
							<td valign="top" align="center"   class="cx_bgsx2">
								<div  id="group1">
									<select id="roomIDs" style="width: 255px; height: 290px;" multiple="multiple"   ondblclick="dblClickSelect('roomIDs', 'selectedRoomIDs', 'numberID');" ondblclick="dblClickDelete('roomIDs', 'selectedRoomIDs', 'numberID');">
										<c:forEach items="${meetingRoomVOList}" var="meetingRoom">
											<option value="${meetingRoom.meetingRoomID }">${meetingRoom.meetingRoomName }</option>
										</c:forEach>
					    			</select>
								</div>
							</td>							   
							<td width="100" align="center" class="xxtabledatabg_m">
								<input type="button" class="xxtabledatabg_btn" value="添加>>" onclick="selectRooms('roomIDs', 'selectedRoomIDs', 'numberID');"><br /><br/>
				  				<br/><br/>
				  				<input type="button" class="xxtabledatabg_btn" value="所有>>" onclick="selectAllRooms('roomIDs', 'selectedRoomIDs', 'numberID');"><br/><br/>
				  				<br/></br>
				  				<input type="button" class="xxtabledatabg_btn" value="删除<<" onclick="removeAllOptions('selectedRoomIDs', 'numberID');">
							</td>
							<td rowspan="2" valign="top"  class="cx_bgsx2">
								<div>
									<select id="selectedRoomIDs" style="width: 255px; height: 290px;" multiple="multiple"  ondblclick="dblClickDelete('roomIDs', 'selectedRoomIDs', 'numberID');">
				   						<option value=""></option>
				   					</select>
								</div>
							</td>
						</tr>
				    </table>
				</td>								
			</tr>	
	   	</table>
	   	
	   	<!-- 					
	   	<div class="btntable">
		  <span style="margin:10px;">
   			  <input type="button" class="xxtabledatabg_btn" value="确认" onclick="operateRooms('selectedRoomIDs');">
    	  </span>
    	  <span style="margin:10px;">
       		  <input type="button" class="xxtabledatabg_btn" value="取消" onclick="window.close();">
      	  </span>
	   </div>	 -->	
	   
	   <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="operateRooms('selectedRoomIDs');"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="window.close();"/>
            </td>
          </tr>
        </tbody>
      </table>
	   
	</body>
</html>
