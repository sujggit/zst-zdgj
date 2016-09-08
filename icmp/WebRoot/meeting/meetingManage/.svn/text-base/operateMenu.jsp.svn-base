<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<%@include file="/common/common_header.jsp" %>

<script type='text/javascript' src='${sys_ctx }/dwr/interface/mcuControlMethod.js'></script>
<script type="text/javascript">
  var chooseNodeID="";		//选择会场ID
  var chooseNodeIP = "";	//选择会场IP
  

	function getAllNode(parame){
		mcuControlMethod.getAllMeetingRoom(createNodeList);
	}

	/**
		生成所有会场
	**/
	function createNodeList(list){
		if(list==null||list.length==0) return;
		$("#addNodeUL").empty();
		for(var i=0;i<list.length;i++){
			if(list[i].ip==null||list[i].ip.length==0) continue;
			var htmlStr = "<li  class='ac fontstyle' style='height:27px;cursor:pointer' id='"+list[i].equipmentID+"' ondblclick=addVenue('"+list[i].ip+"') title='双击添加会场' >"+list[i].meetingRoomVO.meetingRoomName+"("+list[i].ip+")</li>";
			$("#addNodeUL").append(htmlStr);
			
			cssOdd(list[i].equipmentID,i);
			/**拖动事件
			 $("#"+list[i].equipmentID).draggable({
			    	drag: function(event, ui){
				 		 chooseNodeID=this.id;
				 		 chooseNodeIP = this.title;
					},
					cursor: 'move' ,
					containment: 'document', 
					helper:'clone',
					opacity:1 ,
					revert:'invalid',
					scroll:false
			  });
			 **/ 
		}
	}
	
	/**
	双击，添加会场
	**/
	function addVenue(ip){
		var meetingDetailID = $("#filterSelectId").val();
		if(meetingDetailID==null||meetingDetailID=="") return alert("请选择会议"); 
		mcuControlMethod.addParticipants(meetingDetailID, ip, function(parame){
			if(!parame) alert("添加失败！");
		});
	}
	
	
  </script>
  
	
</head>
<body>
	<div>
		<ul id="addNodeUL" class="ztree"></ul>
	</div>
	<script type="text/javascript">getAllNode()</script>
</body>
</html>

 