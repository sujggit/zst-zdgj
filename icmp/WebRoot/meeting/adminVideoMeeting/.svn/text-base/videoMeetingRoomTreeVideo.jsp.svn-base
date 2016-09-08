<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.*"%>
<%@ page import="com.zzst.model.enums.DateBaseEnum"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.action.meeting.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@include file="/common/common.jsp"%>
	<title>会议室树结构</title>
		<link href="/icmp/style/blue/selectRoom/contact.css" rel="stylesheet" type="text/css"/>
		<link href="/icmp/style/blue/selectRoom/content.css" rel="stylesheet" type="text/css"/>
  	    <SCRIPT language=javascript src="/icmp/js/dtree.js"></SCRIPT>
    	<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
     <style>
		.bSelectNode{
			padding-top: 0px;
			background-color: #FFE6B0;
			color: black;
			border: 1px #FFB951 solid;
			opacity: 0.8;
		}
		.glass {
			background: white url(../images/icons/glass.png) no-repeat right;
			border: 1px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
		
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
    		//var nodes = document.getElementsByName('nodeName');
 			//for(var i=0; i<nodes.length; i++){
 			//	nodes[i].className = "";
 			//}
 			$(".bSelectNode").each(function(i){
				this.className = $(this).attr("id").split("##")[1];
			});
 			var selectedColor = 'bSelectNode';
 			var node = document.getElementById(id);
 			node.className = selectedColor;
	 	}
 	
    function selectMeetingRoom(nodeName, selectedMeetingRoomID, selectedMainMeetingRoomID){
 		if(nodeName == "" || selectedMeetingRoomID == "" || selectedMainMeetingRoomID=="" ){
 			nodeName = 'nodeName';
 			selectedMeetingRoomID = 'selectedMeetingRoomID';
 			selectedMainMeetingRoomID = 'selectedMainMeetingRoomID';
 		}
 		var nodes = document.getElementsByName(nodeName);
 		var selectedNode = new Array();
 		for(var i=0; i < nodes.length; i++){
 			if(nodes[i].className =="bSelectNode" ){
 				selectedNode.push(nodes[i]);
 			}
 		}
 		if(selectedNode.length == 0){
 			alert("必须选择一个会议室！");
 			return;
 		}
 		
 		var toMeetingRooms = document.getElementById(selectedMeetingRoomID);
 		for(var i=0; i < toMeetingRooms.length; i++){
	 		if(toMeetingRooms.options[i].text == ""){
	 			toMeetingRooms.remove(i);	
	 		}
 		}

 		for( var i=0; i<selectedNode.length; i++ ){
	 		var selectedNodeIndex = selectedNode[i];
 			var definedCheck = document.getElementById(selectedNodeIndex.id + "_" + selectedNodeIndex.id);
	 		if(definedCheck.value == '3'){
	 			var elements = document.getElementsByName(selectedNodeIndex.innerHTML);
	 			for(var i=0; i < elements.length; i++){
					<%--elements[i].id format is "defined_" + id, so we split it.--%>
	 				var ids = elements[i].id.split("_");
	 				insertOption(selectedMeetingRoomID, elements[i].value, ids[1]);
	 			}
	 		}else{
	 			insertOption(selectedMeetingRoomID, selectedNodeIndex.innerHTML, selectedNodeIndex.id);
	 		}
<%--	 		insertOption(selectedMainMeetingRoomID, selectedNode.innerHTML, selectedNode.id);--%>
				
	 	}
 		
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
	 			if( toUsers.options[i].value == o.value){
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
 		
	 	
	 	
	 	function changeMainRoomName(selectedMainMeetingRoomID, mainMeetingRoomName){
	 		var selectedMeetingRooms = document.getElementById(selectedMainMeetingRoomID);

	 		document.getElementById(mainMeetingRoomName).value = selectedMeetingRooms.options[selectedMeetingRooms.selectedIndex].text;
	 		
	 		var meetingRoomID = selectedMeetingRooms.options[selectedMeetingRooms.selectedIndex].value;
	 
	 	}
	 	
	 	function serachRoom1(op){
	 		var searchRoom = op.value;//搜索条件
			var selectRoom = document.getElementById("selectedMeetingRoomID");//右边select框
			var options = selectRoom.options;
			for( var i=0; i<options.length; i++ ){
					options[i].selected = false;
				
			}
			if( options.length == 0 ){
				return;
			}
			if( searchRoom == "" ){
				return;
			}
			for( var j=0; j<options.length; j++ ){
				var strIndex = options[j].text.indexOf(searchRoom);
				if( strIndex != -1 ){
					options[j].selected = true;
				}
			}
		}
	 	
	 function dbselectNode(id){
		var selectedColor = "bSelectNode";
			$(".bSelectNode").each(function(i){
				this.className = $(this).attr("id").split("##")[1];
			});
			$("."+id).each(function(){
					this.className = selectedColor;
				});
			
		}
    </script>
	</head>

	<body>
	<span id="addressID"></span>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #ccc">
        <tr>
          <td width="48%" class="">
          	<h5 class="fwb fl10" >
          	请选择会场&nbsp;&nbsp;共<span style="font-weight:bold;text-align:center;color:red" id="allVenueSpan">0</span>个会场</h5><h5 class="fwb fl10" style="margin-left:40px;height:5px;" >搜索:&nbsp;&nbsp;&nbsp;<input id="searchMeeingRoom"  type="text" class="glass" value="" onkeyup="serachRoom(this)"/>
            </h5>
          </td>
          <td>	  </td>
          <td width="48%" class="">
          	<h5 class="fwb fl10">已选择<span style="color:#F00" id="roomCount">0</span>个会场</h5><h5 class="fwb fl10" style="margin-left:40px;height:5px;" >搜索:&nbsp;&nbsp;&nbsp;<input id="searchMeeingRoom"  type="text" class="glass" value="" onkeyup="serachRoom1(this)"/></h5>
          </td>
        </tr>
        <tr>
        <td><div style="text-align:left;border:#ddd 1px solid; width:100%; height:250px; margin:0 auto; overflow:auto;background-color:white">
  
		<script type="text/javascript">
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
							d.add('<%=vo.getAddressID()%>','<%=vo.getParentID()%>','<a ondblclick="dbselectNode(\'<%=vo.getAddressID()%>\')"><%=vo.getName() %></a>');
			<%
				if(roomList!=null&&roomList.size()>0){
				for(int j=0;j<roomList.size();j++){
					MeetingRoomVO roomVO = (MeetingRoomVO)roomList.get(j);
					EquipmentVO eVO = (EquipmentVO)amequip.get(roomVO.getMeetingRoomID());
					if( eVO != null){%>
					d.add('<%=roomVO.getMeetingRoomID()%>','<%=vo.getAddressID() %>','<a  onclick="selected(\'<%=roomVO.getMeetingRoomID()%>##<%=vo.getAddressID() %>\',\'<%=vo.getAddressID() %>\');" ondblclick="dblClickSelect(\'<%=roomVO.getMeetingRoomID()%>##<%=vo.getAddressID() %>\');" style="cursor:pointer" id="<%=roomVO.getMeetingRoomID()%>##<%=vo.getAddressID() %>" name="nodeName" class="<%=vo.getAddressID() %>"><%=roomVO.getMeetingRoomName()%><%if(eVO != null){%>(ip:<%=eVO.getIp()%>)<%}%></a>');
													meetingRoomAddress += '<input type="hidden" id="<%=roomVO.getMeetingRoomID()%>##<%=vo.getAddressID()%>_<%=roomVO.getMeetingRoomID()%>##<%=vo.getAddressID()%>" name="corp"  value="<%=roomVO.getMeetingRoomName() %>"/>';
										venueNum++;
					
					<%
					}
					
							}
						}
					}
				}
			%>    				
		  	document.write(d);
		  	document.getElementById('addressID').innerHTML = meetingRoomAddress;
		  	
		  	document.getElementById('allVenueSpan').innerHTML = venueNum;

		  	function serachRoom(op){
				var searchRoom = op.value;//搜索条件
				var allA = document.getElementsByName("nodeName");//全部url
				var allNodes = d.aNodes;//全部节点
				for( var i=0; i<allA.length; i++ ){
					allA[i].className="";
				}
				d.closeAll();//收起所有节点
				if( searchRoom ==""){
					return;
				}
				
				for( var i=0; i<allA.length; i++ ){
					var aIndex =allA[i];
					
					var strIndex = aIndex.innerHTML.indexOf(searchRoom);
					if( strIndex != -1){//匹配到节点
						for( var j=0; j<allNodes.length; j++){
							if( (aIndex.id).indexOf(allNodes[j].id)>=0){
									d.openTo(allNodes[j].id ,false);//展开父节点
									aIndex.className="bSelectNode";
							}
						}
					}
				}
			  	
		 	}
			</script>         
          
          </div></td>
          <td style="vertical-align:middle;"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px;">
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="selectMeetingRoomAll('nodeName', 'selectedMeetingRoomID', 'selectedMainMeetingRoomID');" /></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="selectMeetingRoom('nodeName', 'selectedMeetingRoomID', 'selectedMainMeetingRoomID');"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="removeSelectedOptions('selectedMeetingRoomID', 'selectedMainMeetingRoomID');"/></td>
            </tr>
            <tr>
              <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="removeSelectedOptionsAll('selectedMeetingRoomID', 'selectedMainMeetingRoomID');" /></td>
            </tr>
          </table></td>
          <td><div style="border:#ddd 1px solid; width:100%; height:240px; margin:0 auto;">
			   <select id="selectedMeetingRoomID" style=" width:100%; height:250px; margin:0 auto;" multiple="multiple" ondblclick="dblClickDelete('selectedMeetingRoomID','selectedMainMeetingRoomID');">
			   </select>
          </div></td>
        </tr>
        <tr>
          
        </tr>
        <tr >
          <td colspan="3" height="10"></td>
        </tr>
          <td><span style="color: red;">*</span>主会场&nbsp;
          	 <span>
          	 	<select name="meetingDetailVO.meetingRoomID" id="selectedMainMeetingRoomID" class="" onchange="changeMainRoomName('selectedMainMeetingRoomID', 'mainMeetingRoomName');" style="width:140px;">
	              <option value="-1">请选择...</option>
	           </select>
          	 </span>
          </td> 
          <td style="vertical-align:middle;">&nbsp;</td>
		<td height="39" id="mySelect_02">会议模式&nbsp;
            <select name="meetingDetailVO.confProfileID" id="select" class="select200 fontstyle" style="width:140px;">
             <zzst:option type="linkMeetingModel" value="${meetingDetailVO.confProfileID}" required="true"/>
            </select> 
        </td>
               
        </table>
		  <input type="hidden" name="meetingDetailVO.meetingRoomName" id="mainMeetingRoomName" value="${meetingDetailVO.meetingRoomName }">
	</body>
</html>
