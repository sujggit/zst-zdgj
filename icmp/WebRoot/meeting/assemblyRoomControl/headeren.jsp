<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
	<%@include file="/common/common_header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>dvd1</title>
		<link href="css/main.css" type="text/css" rel="stylesheet"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
        <link type="text/css" href="control.css" rel="stylesheet" />
        <link type="text/css" href="css/control1.css" rel="stylesheet" />
        
	</head>

	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' style="text-align:left">
		<div class="poptabmsg" style="width:101.9%; height:488px;">
			<ul class="xgtab" id="lst_room_funtcion">
			   
			</ul>
			
			<div id="myDIV" >
               <iframe id="frmright" frameborder="0" name="frmright" src="endpoint.jsp" style="width:100%;height:456px;"></iframe>
            </div>
		</div>
		<script type="text/javascript">
            var currentEquipmentID = "";
            var oldEquipmentID = "";
            var currentMeetingRoomID = "";
            
            function changeFramContent(name,id){
                    
                    if(oldEquipmentID==""){
                        oldEquipmentID = id;
                    }
                    
                    currentEquipmentID = id;
                    
                    document.getElementById("listEquipment"+oldEquipmentID).className="";
                    document.getElementById("listEquipment"+currentEquipmentID).className = "on";
                   
                    oldEquipmentID = id;
                    if(name=="endPoint"){
                       document.getElementById("frmright").src="endpoint.jsp";
                    }
                    
                    if(name=="model"){
                        document.getElementById("frmright").src="meetingModel.jsp";
                    }
            }
            function changeMeetingRoom(roomID){
                  oldEquipmentID ="";
                  currentMeetingRoomID = roomID;
                 if(window.parent.frames[0].window.document.getElementsByName("endPointName"+roomID)){

                	 var list = document.getElementById("lst_room_funtcion");
                	 var appendULList = "";
                	 var endPoints= window.parent.frames[0].window.document.getElementsByName("endPointName"+roomID);
                	 var length = endPoints.length;
                	 
                     for(var i=0;i<length;i++){
                         var endPointID = window.parent.frames[0].window.document.getElementById("endPointID"+endPoints[i].id).value;
                    	 appendULList=appendULList+"<li name='listEquipment' id='listEquipment"+endPointID+"'   style='cursor:pointer' onclick=\"changeFramContent('endPoint','"+endPointID+"')\">"+endPoints[i].value+"</li>"; 
                     }
                 }
                 if(window.parent.frames[0].window.document.getElementsByName("modelName"+roomID)){
                     var model= window.parent.frames[0].window.document.getElementsByName("modelName"+roomID);
                	 var length2 = model.length;
                	
                     for(var i=0;i<length2;i++){
                         var modelID = window.parent.frames[0].window.document.getElementById("modelID"+model[i].id).value;
                    	 appendULList=appendULList+"<li name='listEquipment' id='listEquipment"+modelID+"'  style='cursor:pointer' onclick=\"changeFramContent('model','"+modelID+"')\">"+model[i].value+"</li>"; 
                     }
                     
                	 list.innerHTML = appendULList;       	 
                 }
                 if(document.getElementById("lst_room_funtcion").childNodes[0]){
                       
                       document.getElementById("lst_room_funtcion").childNodes[0].click();
                      
                  }else{
                       document.getElementById("frmright").src="noEquipment.jsp";
                  }
            }
            
        </script>
	</body>
 
</html>