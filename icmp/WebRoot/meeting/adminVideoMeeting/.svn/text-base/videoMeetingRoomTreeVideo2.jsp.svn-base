<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.*"%>
<%@ page import="com.zzst.model.enums.DateBaseEnum"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO" %>
<%@ page import="com.zzst.action.meeting.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>

	<title>部门树结构</title>
		<link href="/icmp/style/blue/selectRoom/contact.css" rel="stylesheet" type="text/css"/>
		<link href="/icmp/style/blue/selectRoom/content.css" rel="stylesheet" type="text/css"/>
  	    <SCRIPT language=javascript src="/icmp/js/dtree.js"></SCRIPT>
    	<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
     
    <script type="text/javascript">
		function selectMeetingRoomAll(nodeName, selectedMeetingRoomID, selectedMainMeetingRoomID){
	 	if(nodeName == "" || selectedMeetingRoomID == "" || selectedMainMeetingRoomID=="" ){
	 			nodeName = 'nodeName';
	 			selectedMeetingRoomID = 'selectedMeetingRoomID';
	 			selectedMainMeetingRoomID = 'selectedMainMeetingRoomID';
	 		}
	 	
	 		var nodes = document.getElementsByName(nodeName);
	 		var selectedNode = null;
	 		for(var i=0; i < nodes.length; i++){
	 				selectedNode = nodes[i];
	 				var definedCheck = document.getElementById(selectedNode.id + "_" + selectedNode.id);
	 			if(definedCheck.value != '3'){	
	 			insertOption(selectedMeetingRoomID, selectedNode.innerHTML, selectedNode.id);
	 			}
	 		}
	 		
	 		
	 		var toMeetingRooms = document.getElementById(selectedMeetingRoomID);
	 		for(var i=0; i < toMeetingRooms.length; i++){
		 		if(toMeetingRooms.options[i].text == ""){
		 			toMeetingRooms.remove(i);	
		 		}
	 		}
	 		
	 		var definedCheck = document.getElementById(selectedNode.id + "_" + selectedNode.id);
	 		if(definedCheck.value == '3'){
	 			var elements = document.getElementsByName(selectedNode.innerHTML);
	 			for(var i=0; i < elements.length; i++){
					<%--elements[i].id format is "defined_" + id, so we split it.--%>
	 				var ids = elements[i].id.split("_");
	 				insertOption(selectedMeetingRoomID, elements[i].value, ids[1]);
	 			}
	 		}else{
	 			insertOption(selectedMeetingRoomID, selectedNode.innerHTML, selectedNode.id);
	 		}
<%--	 		insertOption(selectedMainMeetingRoomID, selectedNode.innerHTML, selectedNode.id);--%>
	 	}
    
    function dblClickSelect(id){
	    	selected(id);
	    	selectMeetingRoom("", "" , "");
	    }
	    
	    function dblClickDelete(selectedMeetingRoomID,mainMeetingRoomName){
	    	removeSelectedOptions(selectedMeetingRoomID,mainMeetingRoomName);
	    }
    
    function selected(id){
    		var nodes = document.getElementsByName('nodeName');
 			for(var i=0; i<nodes.length; i++){
 				nodes[i].style.background="";
 			}
 		
 			var selectedColor = 'powderblue';
 			var node = document.getElementById(id);
 			node.style.background = selectedColor;
	 	}
	 	function selectMeetingRoom(nodeName, selectedMeetingRoomID, selectedMainMeetingRoomID){
	 		if(nodeName == "" || selectedMeetingRoomID == "" || selectedMainMeetingRoomID=="" ){
	 			nodeName = 'nodeName';
	 			selectedMeetingRoomID = 'selectedMeetingRoomID';
	 			selectedMainMeetingRoomID = 'selectedMainMeetingRoomID';
	 		}
	 	
	 		var nodes = document.getElementsByName(nodeName);
	 		var selectedNode = null;
	 		for(var i=0; i < nodes.length; i++){
	 			if(nodes[i].style.background =="powderblue"){
	 				selectedNode = nodes[i];
	 				 break;
	 			}
	 		}
	 		if(selectedNode == null){
	 			alert("必须选择一个会议室！");
	 			return;
	 		}
	 		
	 		var toMeetingRooms = document.getElementById(selectedMeetingRoomID);
	 		for(var i=0; i < toMeetingRooms.length; i++){
		 		if(toMeetingRooms.options[i].text == ""){
		 			toMeetingRooms.remove(i);	
		 		}
	 		}
	 		
	 		var definedCheck = document.getElementById(selectedNode.id + "_" + selectedNode.id);
	 		if(definedCheck.value == '3'){
	 			var elements = document.getElementsByName(selectedNode.innerHTML);
	 			for(var i=0; i < elements.length; i++){
					<%--elements[i].id format is "defined_" + id, so we split it.--%>
	 				var ids = elements[i].id.split("_");
	 				insertOption(selectedMeetingRoomID, elements[i].value, ids[1]);
	 			}
	 		}else{
	 			insertOption(selectedMeetingRoomID, selectedNode.innerHTML, selectedNode.id);
	 		}
<%--	 		insertOption(selectedMainMeetingRoomID, selectedNode.innerHTML, selectedNode.id);--%>
	 	}
	 	
	 	
	 	function insertOption(toID, name, value, selected){
	 	    
	 	    if(name=='')
	 	    {
	 	      return;
	 	    }
	 		var a= value;
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
	 		
		  	//add main room select
		
		 	var toUsers = document.getElementById(toID);
	 		document.getElementById('roomCount').innerHTML = toUsers.length;
	 		
	 		<%--add relative option into main room dialog--%>
	 		var obj=document.getElementById("selectedMainMeetingRoomID");
	 		
	 		obj.options.add(new Option(name,value));
	 		if(null != selected && selected != '') {
	 			obj.options[obj.options.length-1].selected='selected';
	 		}
	 		document.getElementById("mainMeetingRoomName").value = obj.options[obj.selectedIndex].text;
			
		}

		
	 	function removeSelectedOptionsAll(toID, mainSelectedID){
	 		var toUsers = document.getElementById(toID);	
	 		for(var i=toUsers.length - 1; i >= 0; i--){
	 			
	 				<!--delete main select meeting room-->
	 				removeMainSelectedOptions(mainSelectedID, toUsers.options[i].text, toUsers.options[i].value);
	 				toUsers.options[i] = null;
	 				
	 			
	 		}
	 		
	 		document.getElementById('roomCount').innerHTML = toUsers.length;
	 	}


	 	function removeSelectedOptions(toID, mainSelectedID){
	 		var toUsers = document.getElementById(toID);
	 		var deleID = -1 ;
	 		for(var i=toUsers.length - 1; i >= 0; i--){
	 			if(toUsers.options[i].selected == true){
	 				<!--delete main select meeting room-->
	 				removeMainSelectedOptions(mainSelectedID, toUsers.options[i].text, toUsers.options[i].value);
	 				toUsers.options[i] = null;
	 				deleID = i;
	 			}
	 		}

	 		//默认为下一个，或者最后一个
	 		if(deleID == -1) return alert("请选择要删除的会场");
			if(deleID>=toUsers.length){
				if(toUsers.length!=0)
					toUsers.options[deleID-1].selected = true;
			}else
				toUsers.options[deleID].selected = true;

			document.getElementById('roomCount').innerHTML = toUsers.length;
	 	}
    									
    	function removeMainSelectedOptions(mainSelectedID, name, value){
	 		<%--delete relative option into main room dialog--%>
	 		var meetingRooms=document.getElementById(mainSelectedID);
	 		for(var j=meetingRooms.length - 1; j >= 0; j--){
	 			if(meetingRooms.options[j].text == name && meetingRooms.options[j].value == value){
	 				meetingRooms.options[j] = null;
	 			}
	 		}
	 		meetingRooms.options[meetingRooms.options.length-1].selected='selected';	 		
	 		document.getElementById("mainMeetingRoomName").value = meetingRooms.options[meetingRooms.selectedIndex].text;
	 		var meetingRoomID = meetingRooms.options[meetingRooms.selectedIndex].value;
	 	    //DwrMethod.getMcuTemplateByMeetingRoomID(meetingRoomID,getTemplateCallBack);
	 		
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
 				alert("至少选择一个会议室");
 				return false;
 			}
 			
 			return true;
 		}
 		
		<%-- get needed video equipments--%>
 		function neededVideoEquipments(selectedMeetingRoomID){
 			var selectedMeetingRooms = document.getElementById(selectedMeetingRoomID);
 			var flag = checkSelectedNumber(selectedMeetingRooms);
 			if(flag == false){
	 			return;
	 		}
	 		
	 		var meetingRoomName = "";
	 		var meetingRoomID = "";
	 		var meetingRoomAddress = "";
	 		var bjMeetingRoomIDs = "";
	 		var bjCount = 0;
	 		for(var i=0; i < selectedMeetingRooms.length; i++){
	 			meetingRoomID = selectedMeetingRooms.options[i].value; 
 				meetingRoomAddress = document.getElementById(meetingRoomID + "_" + meetingRoomID);
	 			if(meetingRoomAddress.value == "北京新大楼"){
	 				if(bjCount != 0){
	 					bjMeetingRoomIDs +="-";
	 				}
	 				bjMeetingRoomIDs += meetingRoomID;
	 				bjCount++;
	 			}
	 		}
	 		if(bjCount == 0){
	 			alert("没有本地会场");
	 			return;
	 		}
				
	 		window.open('/icmp/equipment/getVideoEquipmentVOList.action?bjMeetingRoomIDs=' + bjMeetingRoomIDs+'&noticeNum=' +noticeNum, 'availableMeetingRoomID', '');
	 	}
	 	
	 	function defineMeetingRoomGroup(selectedMeetingRoomID){
	 		window.open('/icmp/meetingRoom/meetingRoomGroup/addGroup.jsp?selectedMeetingRoomID=' + selectedMeetingRoomID,'meetingRoomId1','width=613,height=263,directories,scrollbars=yes');
	 	}
	 	
	 	//addby  chenshuo 根据主会场终端对应MCU选择该MCU上的模板
	 	function changeMainRoomName(selectedMainMeetingRoomID, mainMeetingRoomName){
	 		var selectedMeetingRooms = document.getElementById(selectedMainMeetingRoomID);

	 		document.getElementById(mainMeetingRoomName).value = selectedMeetingRooms.options[selectedMeetingRooms.selectedIndex].text;
	 		
	 		var meetingRoomID = selectedMeetingRooms.options[selectedMeetingRooms.selectedIndex].value;
	 	    DwrMethod.getMcuTemplateByMeetingRoomID(meetingRoomID,getTemplateCallBack);
	 	   	
	 	    //document.getElementById('mySelect_02').innerHTML='<select name="meetingVO.confProfileID" id="select" class="select200 fontstyle" >'+ html+'</select>';
	 	}
	 	
	 	function getTemplateCallBack( result ){
	 	    	document.getElementById('mySelect_02').innerHTML='<select name="meetingVO.confProfileID" id="select" class="select200 fontstyle" >'+ result+'</select>';
	 	}
	 	
	 	function pageInit(){
	 			DwrMethod.getMcuTemplateByMeetingRoomID(document.getElementById('selectedMainMeetingRoomID').value,getTemplateCallBack);

	 	}
    </script>
	</head>

	<body>
	<span id="addressID"></span>

	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="table_css" style="_width:98.4%">
      <tr>
        <th width="49%" style="text-align:center;">请选择会场&nbsp;&nbsp;共<span style="font-weight:bold;text-align:center;color:red" id="allVenueSpan">0</span>个会场</th>
        <td width="100" rowspan="3"><div class="btn_nav">
            <input type="button" name="Submit" value="添加所有 &gt;&gt;" onclick="selectMeetingRoomAll('nodeName', 'selectedMeetingRoomID', 'selectedMainMeetingRoomID');" class="btn_navbtn" />
          </div>
          <div class="btn_nav">
            <input type="button" name="Submit" value="添加 &gt;" onclick="selectMeetingRoom('nodeName', 'selectedMeetingRoomID', 'selectedMainMeetingRoomID');" class="btn_navbtn" />
          </div>
          <div class="btn_nav">
            <input type="button" name="Submit" class="btn_navbtn" onclick="removeSelectedOptions('selectedMeetingRoomID', 'selectedMainMeetingRoomID');" value="&lt; 删除" />
        </div>
           <div class="btn_nav">
            <input type="button" name="Submit" value="&lt;&lt; 删除所有" onclick="removeSelectedOptionsAll('selectedMeetingRoomID', 'selectedMainMeetingRoomID');" class="btn_navbtn" />
          </div>
          </td>
        <th width="49%" style="text-align:center;">已选择&nbsp;&nbsp;<span id="roomCount" style="font-weight:bold;text-align:center;color:red">0</span>&nbsp;&nbsp;个会场</th>
      </tr>
      <tr>
        <td ><div class="input_txt" style="width:100%; height:295px;  overflow: auto;border:1px solid #666666;" >
            <SCRIPT LANGUAGE="JavaScript">
            var venueNum = 0;
            
	          d = new dTree('d');
	          d.config.folderLinks = false;
	          d.config.closeSameLevel = true;
	          var isOpen ;
	          var meetingRoomAddress = "";
			 	//d.add(0, -1, '视频会场');
	        	   	  <%
	        	   	ArrayList list = (ArrayList)request.getAttribute("treelist");
					if(list!=null&&list.size()>0){					
						for (int i = 0; i < list.size(); i++) {
							AddressVO vo = (AddressVO)list.get(i);
							
							Map roomMap = (Map)request.getAttribute("amap");
							Map amequip = (Map)request.getAttribute("amequip");
							ArrayList roomList = null;
							if(roomMap!=null){
								roomList = (ArrayList)roomMap.get(vo.getAddressID());
								if(!(vo.getAddressID().equals(DateBaseEnum.Default_ID))){
								if(roomList==null){continue;}
								}
							}
				%>
								d.add('<%=vo.getAddressID()%>','<%=vo.getParentID()%>','<%=vo.getName() %>');
				<%
						
						if(roomList!=null&&roomList.size()>0){
							for(int j=0;j<roomList.size();j++){
								MeetingRoomVO roomVO = (MeetingRoomVO)roomList.get(j);
								EquipmentVO eVO = (EquipmentVO)amequip.get(roomVO.getMeetingRoomID());
					%>
						d.add('<%=roomVO.getMeetingRoomID()%>','<%=vo.getAddressID() %>','<a onclick="selected(\'<%=roomVO.getMeetingRoomID()%>\');" ondblclick="dblClickSelect(\'<%=roomVO.getMeetingRoomID()%>\');" style="cursor:pointer" id="<%=roomVO.getMeetingRoomID()%>" name="nodeName"><%=roomVO.getMeetingRoomName()%><%if(eVO != null){%>(ip:<%=eVO.getIp()%>)<%}%></a>');
									meetingRoomAddress += '<input type="hidden" id="<%=roomVO.getMeetingRoomID()%>_<%=roomVO.getMeetingRoomID()%>" name="corp" value="<%=roomVO.getMeetingRoomName() %>"/>';
						venueNum++;
					<%
							//}
								}
							}
						}
					}
				%>    				
	          	document.write(d);
	          	document.getElementById('addressID').innerHTML = meetingRoomAddress;
	          	
	          	document.getElementById('allVenueSpan').innerHTML = venueNum;<!--记录所有会场数-->
	     	</script>
		
          </div></td>
        <td><div class="input_txt"  style="width:100%; height:295px;  overflow: auto;border:1px solid #666666;" >
          <select id="selectedMeetingRoomID" style="width:100%; height: 295px;" multiple="multiple" ondblclick="dblClickDelete('selectedMeetingRoomID','selectedMainMeetingRoomID');">
   		</select>
       </div></td>
      </tr>
      <tr>
        <td >
        <div class="textinput" >
      <ul style="margin:auto;">
        <li class="font">会议模式：</li>
        <li style="width:253px;_width:233px;">
          <div id="mySelect_02" style="margin:0px 0px 0px 0px; *margin:0;">
            <select name="meetingVO.confProfileID" id="select" class="select200 fontstyle" >
             <zzst:option type="linkMeetingModel" value="" required="true"/>
            </select> 
          </div>
        </li>
      </ul>
    </div></td>
        <td> <div class="textinput">
      <ul style="margin:auto;">
        <li class="font">主会场：</li>
        <li style="width:253px;_width:233px;">
          <div id="mySelect_03" style="margin:0px 0px 0px 0px; *margin:0;">
            <select name="meetingVO.meetingRoomID" id="selectedMainMeetingRoomID" class="select200 fontstyle"/>
     			<option value="-1">请选择...</option>
     		</select> 
          </div>
        </li>
      </ul>
    </div></td>
      </tr>
      <input type="hidden" name="meetingVO.meetingRoomName" id="mainMeetingRoomName" value="${meetingDetailVO.meetingRoomName }">
    </table>
	
	</body>
</html>
