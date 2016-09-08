<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="com.zzst.model.enums.DictionaryEnum" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>

<!-- 增加  取消演讲者的图标 -->
<!-- <style type="text/css">
.qxswyjzys{ 
	background:url(${sys_ctx }/meeting/meetingManage/image/report/qxswyjz.png) no-repeat; 
	width:24px;
	height:24px;
	display:inline-block}
</style> -->

<%

        DictionaryVO rightdv = new DictionaryVO();
		rightdv.setDicType(DictionaryEnum.CONTROLRightMENU);
		rightdv.setDescription("checked");
		String tempStr="";
		try {
			List rightdvlist=ServiceFactory.getDictionaryService().query(rightdv, null);
			for(int i=0;i<rightdvlist.size();i++){
			DictionaryVO righttdv=(DictionaryVO)rightdvlist.get(i);
			tempStr+="~"+righttdv.getDicValue()+"~,";
			
			}
	     }catch(Exception e){
	     
	     }


 %>
<div id="rightMenu" style="position:absolute;z-index: 9999;display: none;">
   <div class="topys" style="overflow:hidden">&nbsp;</div>
    <div class="midys">
    <div class="midlineys" id="rightMenuMeetingRoomName">会场名称</div>
    <ul id="mcuConveterList">
    <% if(tempStr.contains("~call~")){ %>
      <li id="call"><a href="#" onclick="call();" title="连接"><span class="ljys"></span></a></li>
      <%} if(tempStr.contains("~handUP~")){%>
      <li id="handUP"><a href="#" onclick="hangUP();" title="挂断"><span class="gdys"></span></a></li>
       <%} if(tempStr.contains("~mute~")){%>
      <li id="mute"><a href="#" onclick="mute();" title="静音"><span class="jyys"></span></a></li>
      <%} if(tempStr.contains("~unMute~")){%>
      <li id="unMute"><a href="#" onclick="unMute();" title="取消静音"><span class="qxjyys"></span></a></li>
      <%} if(tempStr.contains("~blockParticipants~")){%>
      <li id="blockParticipants"><a href="#" onclick="blockParticipants();" title="闭音"><span class="byys"></span></a></li>
      <%} if(tempStr.contains("~unBlockParticipants~")){%>
      <li id="unBlockParticipants"><a href="#" onclick="unBlockParticipants();" title="取消闭音"><span class="qxbyys"></span></a></li>      
      <%} if(tempStr.contains("~suspendParticipants~")){%>
      <li id="suspendParticipants"><a href="#" onclick="suspendParticipants();" title="视频屏蔽"><span class="sppbys"></span></a></li>
      <%} if(tempStr.contains("~unSuspendParticipants~")){%>
      <li id="unSuspendParticipants"><a href="#" onclick="unSuspendParticipants();" title="取消视频屏蔽"><span class="qxsppbys"></span></a></li>
      <%} if(tempStr.contains("~contentToken~")){%>
      <li id="contentToken"><a href="#" onclick="contentToken();" title="双流发送"><span class="slfsys"></span></a></li>
      <%} if(tempStr.contains("~unContentToken~")){%>
      <li id="unContentToken"><a href="#" onclick="unContentToken();" title="取消双流发送"><span class="qxslfsys"></span></a></li>
      <%} if(tempStr.contains("~broadcast~")){%>
      <li id="broadcast"><a href="#" onclick="broadcast();" title="广播"><span class="gbys"></span></a></li>
      <%} if(tempStr.contains("~rollCall~")){%>
      <li id="rollCall"><a href="#" onclick="rollCalls();" title="点名"><span class="dmys"></span></a></li>
      <%} if(tempStr.contains("~president~")){%>
      <li id="president"><a href="#" onclick="president();" title="设为演讲者"><span class="swyjzys"></span></a></li>
      <%} if(tempStr.contains("~cancelPresident~")){%>
      <li id="cancelPresident"><a href="#" onclick="cancelPresident();" title="取消演讲者"><span class="qxswyjzys"></span></a></li>
      <%} if(tempStr.contains("~speaker~")){%>
      <li id="speaker"><a href="#" onclick="speaker();" title="设为发言人"><span class="swfyrys"></span></a></li>
      <%} if(tempStr.contains("~packetLoss~")){%>
      <li id="packetLoss"><a href="#" onclick="packetLoss();" title="丢包率"><span class="dblys"></span></a></li>
      <%} if(tempStr.contains("~seeNearImg~")){%>
      <li id='seeNearImg'><a href="#" onclick="seeNearImg();" title="查看近端图像"><span class="ckjdtxys"></span></a></li>
      <%} if(tempStr.contains("~seeFarawayImg~")){%>
      <li id='seeFarawayImg'><a href="#" onclick="seeFarawayImg();" title="查看远端图像"><span class="ckydtxys"></span></a></li>
      <%} if(tempStr.contains("~roomAttr~")){%>
      <li id='roomAttr'><a href="#" onclick="roomAttr();" title="会场属性"><span class="hcsxys"></span></a></li>
      <%} if(tempStr.contains("~addComment~")){%>
      <li id="addComment"><a href="#" onclick="addComment();" title="备注"><span class="bzys"></span></a></li>
      <%} if(tempStr.contains("~delMeetrRoom~")){%>
      <li id="delMeetrRoom"><a href="#" onclick="delMeetrRoom();" title="删除会场"><span class="schcys"></span></a></li>
      <%} if(tempStr.contains("~meetingRoomFP~")){%>
      <li id="meetingRoomFP"><a href="#" onclick="meetingRoomFP();" title="会场分屏"><span class="hcfpys"></span></a></li>
      <%} if(tempStr.contains("~zdBakUP~")){%>
      <li id="zdBakUP"><a href="#" onclick="zdBakUP()" title="终端备份"><span class="zdbfys"></span></a></li>
      <%} if(tempStr.contains("~watchMeetingroom~")){%>
      <li id="watchMeetingroom"><a href="#" onclick="watchMeetingroom()" title="选看会场"><span class="xkhc"></span></a></li>
      <%} if(tempStr.contains("~roomMaintain~")){%>
      <li id="roomMaintain"><a href="#" onclick="roomMaintainAdd();" title="会场记录"><span class="hcjl"></span></a></li>
    <%} if(tempStr.contains("~setrollCallForYJmenu~")){%>
     <li id="setrollCallForYJmenu"><a href="#" onclick="setrollCallForYJpage();" title="设为监控终端"><span class="gkydhc"></span></a></li>
     <%} if(tempStr.contains("~rollCallForYJmenu~")){%>
     <li id="rollCallForYJmenu"><a href="#" onclick="rollCallForYJpage();" title="监控此会场"><span class="ckydtxys"></span></a></li>
    <%} %>
    </ul>
    </div>
    <div class="downys">&nbsp;</div>
</div>

	<script type="text/javascript">
	         function setrollCallForYJpage(){
	        
            var meetingDetailID = getMeetingDetailId();
            var roomID=document.getElementById('tempMeetingMcuKeyId').value
			var roomIP=document.getElementById('room_'+roomID+'_roomIP').value;
			document.getElementById('monitorMeetingRoomIP').value=roomIP;
			McuDwrMethod.setrollCallForYJ(meetingDetailID,roomIP);
            }
            function rollCallForYJpage(){
                document.getElementById('tempMeetingMcuKeyId').value=document.getElementById('tempMeetingMcuKeyId2').value;
            	var meetingDetailId = getMeetingDetailId();
                if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                var roomkey = $("#room_"+keyidtem+"_checkbox").val();
			    var roomIP=document.getElementById('monitorMeetingRoomIP').value;
			    var roomInfo = document.getElementById("personalInfo_"+roomkey).value;
			    document.getElementById('nowMonitorMeetRoom').value=roomInfo;
			    if(roomIP==""){alert('请设置监控终端');}else{
			     McuDwrMethod.rollCallForYJ(meetingDetailID,roomIP,roomInfo);
			    }
            }
	        function roomMaintainAdd(){
				var meetingDetailID = getMeetingDetailId();
				var meetingName = $("#filterSelectId").text();
				var roomID=document.getElementById('tempMeetingMcuKeyId').value
				var roomIP=document.getElementById('room_'+roomID+'_roomIP').value;
				window.open("${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceAddBefore.action?meetingDetailVO.meetingDetailID="+meetingDetailID+"&meetingDetailVO.meetingName="+meetingName+"&ip="+roomIP,"",'width=680px,height=470px');
			}
			
	          function delMeetrRoom(){
	          var meetingDetailID = getMeetingDetailId();
              if(confirm("你确定要删除此会场吗?")){
              var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
	          var roomID=document.getElementById("room_"+keyidtem+"_roomIds").value;
              McuDwrMethod.deleteParticipant(meetingDetailID, roomID, function delBackup(){});
              }
	          }
	          
	          function meetingRoomFP(){
	           var meetingDetailID = getMeetingDetailId();
	          var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
	          var roomID=document.getElementById("room_"+keyidtem+"_roomIds").value;
	          var pId = document.getElementById("mparticipantid_"+roomID).value;
		      roomID = roomID +"__"+pId;
		      window.open(globalProjectName + "/mcuControl/screenModelBefore.action?meetingDetailID ="+meetingDetailID +"&monitor="+roomID+"&type=meetingroom","setPersonal","width=790px,height=500px,directories,scrollbars=no");
			
	          
	          }
	          
	          function zdBakUP(){
	          var meetingDetailID =getMeetingDetailId();
	          var keyidtem=document.getElementById('tempMeetingMcuKeyId').value
	          var inoftemp=document.getElementById("room_"+keyidtem+"_backupInfo").value;
	          var infos=new Array();
	          infos[0]= inoftemp;
	          DwrMethod.terminalBackup(meetingDetailID,infos);
	          
	          }
    		   function unContentToken() {
			    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                   	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomIP, false, function(isSuccessful){});
          		     }
          	   function contentToken(){
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomIP, true, function(isSuccessful){});
                }
            	function call() {
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.dialParticipants(meetingDetailId, roomIP, true, function(isSuccessful){});
                }
                function hangUP() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.dialParticipants(meetingDetailId, roomIP, false, function(isSuccessful){});
                }
                function mute() {
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.muteParticipants(meetingDetailId, roomIP, true, function(isSuccessful){
    						 
    				});
                }
               function unMute() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.muteParticipants(meetingDetailId, roomIP, false, function(isSuccessful){
    						 
    				});
                }
               function president() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
                	mcuControlMethod.setLecturer(meetingDetailId, roomIP,function(isSuccessful){});
                }
               //增加取消演讲者的js函数
               function cancelPresident() {
               	var meetingDetailId = getMeetingDetailId();
               	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
               	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
   		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
   		    	mcuControlMethod.cancelPresident(meetingDetailId, roomIP,function(isSuccessful){});
   		    	var imgs = document.getElementsByName("role");
   		    	/* alert(imgs[0]); */
               }
               function speaker() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	
                	setSpeaker(roomIP);
                }
               function blockParticipants() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.blockParticipants(meetingDetailId, roomIP, true, function(isSuccessful){});
                }
              function unBlockParticipants() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.blockParticipants(meetingDetailId, roomIP, false, function(isSuccessful){});
                }    			
               function suspendParticipants() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.suspendParticipants(meetingDetailId, roomIP, true, function(isSuccessful){});
                }
                function unSuspendParticipants() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	mcuControlMethod.suspendParticipants(meetingDetailId, roomIP, false, function(isSuccessful){});
                }
               function packetLoss()  {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	window.open(globalProjectName + '/mcuControl/getPtsChannel.action?meetingDetailID=' + meetingDetailId +'&roomID=' + roomIP   ,'03','width=700px,height=475px,directories,scrollbars=yes');
                }
              function addComment() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
    		    	var participantIp = document.getElementById("participantIp_"+roomIP);
    		    	McuDwrMethod.getCommentByIp(meetingDetailId,participantIp.value,function gcb(result){
    		    		viewDIV("comments");
        		    	document.getElementById("commentsAdd").onclick=function(){addComments(keyidtem,meetingDetailId,roomIP);};
						if( result != null ){
							document.getElementById("commentText").value=result;
						}else{
							document.getElementById("commentText").value="请输入备注";
						}
        		    });
    		    	
                }
               function seeNearImg() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_roomIP").val();
					
    		    	window.open(globalProjectName + "/meeting/meetingManage/roomNearImage.jsp?message=" + roomIP, '03', 'width=500px,height=375px,directories,scrollbars=yes');
                }
              function seeFarawayImg() {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	 var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
    		    	var roomIP = $("#room_"+keyidtem+"_roomIP").val();
    		    	window.open(globalProjectName + "/meeting/meetingManage/roomFarImage.jsp?message=" + roomIP, '03', 'width=500px,height=375px,directories,scrollbars=yes');
                }
                 function rollCalls(){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
                	rollCall(roomIP,true);
                }
                function broadcast(){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
                	setVideo(roomIP);
                }
               function roomAttr(){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                	var valInfo = $("#room_"+keyidtem+"_participant_id").val();
                	window.open(globalProjectName + '/mcuControl/getMeetinRoomAttr.action?meetingDetailID=' + meetingDetailId +'&roomInfo=' + valInfo  ,'03','width=800px,height=475px,directories,scrollbars=yes');
                }
                //选看会场
                 function watchMeetingroom(){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                	var roomIP = $("#room_"+keyidtem+"_checkbox").val();
                	rollCall(roomIP,false);
                }
             
              function initMenuList(){
                  
                  var mcuConveterList=document.getElementById('mcuConveterList');
                  var mcuConveterLists=new Array();
                  mcuConveterLists=mcuConveterList.children;
                  for(var i=0;i<mcuConveterLists.length;i++){
                  mcuConveterLists[i].style.display="block";
                  }
                  
                  var keyidtem=document.getElementById('tempMeetingMcuKeyId').value;
                  var IPConnectStatus = $("#room_"+keyidtem+"_IPConnectStatus").val();
            	  var video = $("#room_"+keyidtem+"_video").val();
            	  var contentToken = $("#room_"+keyidtem+"_contentToken").val();
            	  var audio = $("#room_"+keyidtem+"_audio").val();
            	  var nodeType = $("#room_"+keyidtem+"_nodeType").val();
            	  if(IPConnectStatus == "1"){
            	      try{
            	      document.getElementById("call").style.display="none";
            	      }catch(e){}
            	  	if(video == "1"){
            	  	  try{
            	  	   document.getElementById("suspendParticipants").style.display="none";
            	  	   }catch(e){}
                	}else{
                	   try{
                	   document.getElementById("unSuspendParticipants").style.display="none";
                	   }catch(e){}
                    }
                    if(contentToken == "1" || contentToken == "3"){
                    try{
                    document.getElementById("contentToken").style.display="none";
                     }catch(e){}
                    }else{
                    try{
                    document.getElementById("unContentToken").style.display="none";
                     }catch(e){}
                    }
                    if(audio == "0"|| audio == "4"|| audio == "8"|| audio == "12"){//blank
                    try{
                    document.getElementById("unMute").style.display="none";
                     }catch(e){}
                     try{
                    document.getElementById("unBlockParticipants").style.display="none";
                     }catch(e){}
                    }else if(audio == "1"|| audio == "5"|| audio == "9"|| audio == "13"){//mute
                    try{
                     document.getElementById("mute").style.display="none";
                      }catch(e){}
                      try{
                     document.getElementById("unBlockParticipants").style.display="none";
                      }catch(e){}
                    }else if(audio == "2"|| audio == "6"|| audio == "10"|| audio == "14"){//block
                    try{
                     document.getElementById("unMute").style.display="none";
                      }catch(e){}
                      try{
                     document.getElementById("blockParticipants").style.display="none";
                       }catch(e){}
                     
                    	  
                    }else if(audio == "3"|| audio == "6"|| audio == "11"|| audio == "15"){//muteAndBlock
                         try{
                    	document.getElementById("mute").style.display="none";
                    	 }catch(e){}
                    	 try{
                    	document.getElementById("blockParticipants").style.display="none";
                    	 }catch(e){}
                    }
                    
                   if('<c:if test="${confVO.lectureName!='[None]' or confVO.videoMode=='4' }">1</c:if>'=='1'){
                    try{
                      document.getElementById("meetingRoomFP").style.display="none";
                       }catch(e){}
                   }
                   if(nodeType==1||nodeType==2){
                   try{
                    document.getElementById("broadcast").style.display="none";
                     }catch(e){}
                     try{
               	   document.getElementById("rollCall").style.display="none";
               	    }catch(e){}
               	    try{
               	   document.getElementById("watchMeetingroom").style.display="none";
               	    }catch(e){}
                   }
               	  }else{
               	     try{
               	   document.getElementById("handUP").style.display="none";
               	    }catch(e){}
               	    try{
               	   document.getElementById("seeNearImg").style.display="none";
               	   }catch(e){}
               	    try{
               	   document.getElementById("seeFarawayImg").style.display="none";
               	   }catch(e){}
               	    try{
               	   document.getElementById("mute").style.display="none";
               	   }catch(e){}
               	    try{
               	   document.getElementById("unMute").style.display="none";
               	   }catch(e){}
               	    try{
               	   document.getElementById("broadcast").style.display="none";
               	   }catch(e){}
               	    try{
               	   document.getElementById("rollCall").style.display="none";
				   }catch(e){}
               	    try{
               	   document.getElementById("president").style.display="none";
	               }catch(e){}
	               //增加取消演讲者功能
	                try{
               	   document.getElementById("cancelPresident").style.display="none";
	               }catch(e){}
               	    try{
               	   document.getElementById("speaker").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("unSuspendParticipants").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("suspendParticipants").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("blockParticipants").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("unBlockParticipants").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("contentToken").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("unContentToken").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("packetLoss").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("meetingRoomFP").style.display="none";
                   }catch(e){}
               	    try{
               	   document.getElementById("watchMeetingroom").style.display="none";
               	   }catch(e){}
                  }   
              
              }
                
                
  </script>

