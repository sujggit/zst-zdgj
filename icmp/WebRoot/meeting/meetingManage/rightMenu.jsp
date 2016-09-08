 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<div style="display:none" id="meetingControlMenu">
      <ul>
      	<li id="roomName" style="font-weight: bold;"></li>
        <li id="call">呼叫</li>
        <li id="hangUP">挂断</li>
        <li id="mute">静音</li>
        <li id="unMute">非静音</li>
        <li id="blockParticipants">闭音</li>
        <li id="unBlockParticipants">取消闭音</li>
        <li id="suspendParticipants">视频屏蔽</li>
        <li id="unSuspendParticipants">取消视频屏蔽</li>
        <li id="contentToken">双流发送</li>
        <li id="unContentToken">取消双流发送</li>
        <li id="broadcast">广播</li>
      	<li id="rollCall">点名</li>
        <li id="president">设为演讲者</li>
        <li id="speaker">设为发言人</li>
        <li id="packetLoss">丢包率</li>
        <li id='seeNearImg'>查看近端图像</li>
        <li id='seeFarawayImg'>查看远端图像</li>
        <li id='roomAttr'>会场属性</li>
        <li id="addComment">备注</li>
      </ul>
    </div>

	<script type="text/javascript">
      
      //记录需要右键的行ID
      var trIDS="";
      function addRightMenuID(trID){
		trIDS +=trID+",";
      }
      
      //加载右键
      function	InitRightMenu(){
      	if(trIDS=="")	return;

      	var tr = trIDS.split(",");
      	for(var i=0;i<tr.length;i++){
	      	addRightMenu(tr[i]);
      	}
      }
      
      //实现右键功能
      function addRightMenu(parame){
          /**
    	  var IPConnectStatus = $("#"+parame+"_IPConnectStatus").val();
    	  if(IPConnectStatus!=null&&IPConnectStatus=="1"){
    		  $("#meetingControlMenu ul").append("<li id='seeNearImg'>查看近端图像</li><li id='seeFarawayImg'>查看远端图像</li>");
          }
          */
    	  $("#"+parame).contextMenu("meetingControlMenu", {
              bindings: {
    		   'unContentToken': function(t) {
			    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomIP, false, function(isSuccessful){
    						 
    				});
          		},
          		'contentToken': function(t) {
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.changeContentTokenOwner(meetingDetailId, roomIP, true, function(isSuccessful){
    						 
    				});
                },
          		'call': function(t) {
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议"); 
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.dialParticipants(meetingDetailId, roomIP, true, function(isSuccessful){
    						 
    				});
                },
                'hangUP': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.dialParticipants(meetingDetailId, roomIP, false, function(isSuccessful){
						 
    				});
                },
                'mute': function(t) {
    		    	var meetingDetailId = getMeetingDetailId();
    		    	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.muteParticipants(meetingDetailId, roomIP, true, function(isSuccessful){
    						 
    				});
                },
                'unMute': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.muteParticipants(meetingDetailId, roomIP, false, function(isSuccessful){
    						 
    				});
                },
                'president': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
                	mcuControlMethod.setLecturer(meetingDetailId, roomIP,function(isSuccessful){
    						 
    				});
                },
                'speaker': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	
                	setSpeaker(roomIP);
                },
                'blockParticipants': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.blockParticipants(meetingDetailId, roomIP, true, function(isSuccessful){

        		    });
                },
                'unBlockParticipants': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.blockParticipants(meetingDetailId, roomIP, false, function(isSuccessful){

        		    });
                },    			
                'suspendParticipants': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.suspendParticipants(meetingDetailId, roomIP, true, function(isSuccessful){

        		    });
                },
                'unSuspendParticipants': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	mcuControlMethod.suspendParticipants(meetingDetailId, roomIP, false, function(isSuccessful){

        		    });
                },
                'packetLoss': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	window.open(globalProjectName + '/mcuControl/getPtsChannel.action?meetingDetailID=' + meetingDetailId +'&roomID=' + roomIP   ,'03','width=700px,height=475px,directories,scrollbars=yes');
                },
                'addComment': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_checkbox").val();
    		    	var participantIp = document.getElementById("participantIp_"+roomIP);
    		    	McuDwrMethod.getCommentByIp(meetingDetailId,participantIp.value,function gcb(result){
    		    		viewDIV("comments");
        		    	document.getElementById("commentsAdd").onclick=function(){addComments(participantIp,meetingDetailId);};
						if( result != null ){
							document.getElementById("commentText").value=result;
						}else{
							document.getElementById("commentText").value="请输入备注";
						}
        		    });
    		    	
                },
                'seeNearImg': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_roomIP").val();
					
					/*modified by wangle 2013-07-17 fix bug.
    		    	McuDwrMethod.getBlowDown(roomIP,ipBack);
    		    	function ipBack(ip){
        		    	window.open(ip,'03','width=500px,height=375px,directories,scrollbars=yes');
        		    }
    		    	*/
    		    	window.open(globalProjectName + "/meeting/meetingManage/roomNearImage.jsp?message=" + roomIP, '03', 'width=500px,height=375px,directories,scrollbars=yes');
                },
                'seeFarawayImg': function(t) {
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
    		    	var roomIP = $("#"+t.id+"_roomIP").val();
    		    	/*modified by wangle 2013-07-17 fix bug.
    		    	McuDwrMethod.getBlowUp(roomIP,ipBack);
    		    	function ipBack(ip){
        		    	window.open(ip,'03','width=500px,height=375px,directories,scrollbars=yes');
        		    }
        		    */
    		    	window.open(globalProjectName + "/meeting/meetingManage/roomFarImage.jsp?message=" + roomIP, '03', 'width=500px,height=375px,directories,scrollbars=yes');
                },
                 'rollCall':function(t){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var roomIP = $("#"+t.id+"_checkbox").val();
                	rollCall(roomIP);
                },
                'broadcast':function(t){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var roomIP = $("#"+t.id+"_checkbox").val();
                	setVideo(roomIP);
                },
                'roomAttr':function(t){
                	var meetingDetailId = getMeetingDetailId();
                	if(meetingDetailId==null||meetingDetailId=="") return alert("请选择会议");
                	var valInfo = $("#"+t.id+"_participant_id").val();
                	window.open(globalProjectName + '/mcuControl/getMeetinRoomAttr.action?meetingDetailID=' + meetingDetailId +'&roomInfo=' + valInfo  ,'03','width=800px,height=475px,directories,scrollbars=yes');
                }
              },
              onContextMenu: function(e){
            	  var roomName = $("#"+$(e.currentTarget).attr("id")+"_roomName").val();
            	  if(roomName){
                	  if(roomName.length>7){
                		  document.getElementById('roomName').innerHTML = '会场名：'+roomName.substring(0,6)+'...';
                      }else{
                    	  document.getElementById('roomName').innerHTML = '会场名：'+roomName;
                      }
                	  document.getElementById('roomName').title = '会场名：'+roomName;
                  }else{
                	  document.getElementById('roomName').display = 'none';
                  }
            	  return true;
              },
    		  onShowMenu:function(e,menu){
            	  var IPConnectStatus = $("#"+$(e.currentTarget).attr("id")+"_IPConnectStatus").val();
            	  var video = $("#"+$(e.currentTarget).attr("id")+"_video").val();
            	  var contentToken = $("#"+$(e.currentTarget).attr("id")+"_contentToken").val();
            	  var audio = $("#"+$(e.currentTarget).attr("id")+"_audio").val();
            	  if(IPConnectStatus == "1"){
            	  	$("#call",menu).remove();
            	  	if(video == "1"){
            	  		$("#suspendParticipants",menu).remove();
                	}else{
                		$("#unSuspendParticipants",menu).remove();
                    }
                    if(contentToken == "1" || contentToken == "3"){
                    	$("#contentToken",menu).remove();
                    }else{
                    	$("#unContentToken",menu).remove();
                    }
                    if(audio == "0"|| audio == "4"|| audio == "8"|| audio == "12"){//blank
                    	$("#unMute,#unBlockParticipants",menu).remove();
                    }else if(audio == "1"|| audio == "5"|| audio == "9"|| audio == "13"){//mute
                    	$("#mute,#unBlockParticipants",menu).remove();
                    }else if(audio == "2"|| audio == "6"|| audio == "10"|| audio == "14"){//block
                    	$("#unMute,#blockParticipants",menu).remove();
                    }else if(audio == "3"|| audio == "6"|| audio == "11"|| audio == "15"){//muteAndBlock
                    	$("#mute,#blockParticipants",menu).remove();
                    }
               	  }else{
               		$("#seeNearImg,#seeFarawayImg,#hangUP,#mute,#unMute,#broadcast,#rollCall,#president,#speaker,#suspendParticipants,#unSuspendParticipants,#blockParticipants,#unBlockParticipants,#contentToken,#unContentToken,#packetLoss",menu).remove();
                  }
                  return menu;  
        	  }
            }
          );
      }
	</script>