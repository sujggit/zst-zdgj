<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
			/**
			*	设置页面参数，友好提示
			*@return	null	
			*/
			function pageInit(){
				var obj = new htmlUtil();
				obj.title("meetingName","输入长度为1-25的汉字或字符");
				obj.title("meetingRoomName","点击选择会议室");	
				obj.title("meetingStartTime","点击选择开始时间");	
				obj.title("meetingEndTime","点击选择结束时间");
				obj.title("participators","点击选择参会人员");
				obj.title("meetingDescription","输入长度小于500的汉字或字符");
			}


         function modifyMeeting(){
            $('#addForm').validate({    
					rules:{    
					   "meetingDetailVO.meetingName" : {
					           required:true,
					           minlength:1,//如果为数字 最小值是多少
					           maxlength:25  //如果为数字 最大值是多少
					           },
					   "meetingDetailVO.meetingRoomName":{
					       required:true
					   },
					   "meetingDetailVO.meetingStartTime":{
					      required:true
					   } ,
					   "meetingDetailVO.meetingEndTime":{
					      required:true
					   } ,
					   "meetingDetailVO.meetingDescription":{
					       maxlength:500
					   }   
					},    
					messages:{meetingName:{required :"必填"}}    
				});
           //$('#addForm').submit();
           checkMeetingRoom();
         }
         function checkMeetingRoom(){
            var meetingDetailID = document.getElementById('meetingDetailID').value;
  			var startTime = document.getElementById('meetingStartTime').value;
  			var endTime = document.getElementById('meetingEndTime').value;
  			var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
 			var meetingRoomNames = document.getElementById('meetingRoomNames').value;
 			
 			meetingRoomNameIDs = document.getElementById('meetingRoomID').value+","+meetingRoomNameIDs ;
 			meetingRoomNames = document.getElementById('meetingRoomName').value+","+meetingRoomNames;
 			
 			DwrMethod.checkMeetingRoom(meetingDetailID, meetingRoomNameIDs, meetingRoomNames, startTime, endTime, checkMeetingRoomCallBack);
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
  				 $('#addForm').submit();			
  			}
  		}
         
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/detail/queryLocalConference.action";
            }
		
         window.onload=function(){
              pageInit();
         }

         //选择时间
			function selectMeetingTime(thisDom){
			     
			     var parameters = {
			         dateType : "datetime",
			         isNeedInfo:"true"
			     }
			  
			     creatCalendar(thisDom,parameters);
			     
			     var currentTime = new Date().getTime();   
		        var startTime = new Date(document.getElementById('meetingStartTime').value.replace(/\-/g, "\/")).getTime();
             var endTime = new Date(document.getElementById('meetingEndTime').value.replace(/\-/g, "\/")).getTime(); 
             
			    
             var sysTimeGap = ${swh_meeting_space_time};
			    if(startTime<=currentTime){
                     alert("开始时间必须晚于当前时间");
                     document.getElementById('meetingStartTime').value="";
                     return;
             }
			 if(endTime-startTime<sysTimeGap*60000){
               alert("结束时间必须晚于开始时间"+sysTimeGap+"分钟！");
               document.getElementById('meetingEndTime').value="";
               return;
             }
			}

			function selectConference(thisDom){
                var selectedConference = document.getElementById("meetingRoomID").value;
	              var conferenceParameters = {
	                  methodName:'getReturnConferenceMethod',
	                  selectedConference:selectedConference,
	                  selectType:'radio'
	              }
	             creatConferenceSelect(thisDom,conferenceParameters); 
	          }
	          //返回方法
	          //用于获取返回参数
	          //返回参数为数组类型
	          //用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
	          //以提供的参数：conferenceID,conferenceName
	          
	          function getReturnConferenceMethod(conferenceArray){
	              //alert(userArray);
	              var conferenceName = "";
	              var conferenceID = "";
	              var length = conferenceArray.length;
	              for(var i=0;i<length;i++){
	                      conferenceName =conferenceName+conferenceArray[i].conferenceName;
	                      conferenceID = conferenceID+conferenceArray[i].conferenceID;
	              }
	              document.getElementById("meetingRoomName").value=conferenceName;
	              document.getElementById("meetingRoomID").value=conferenceID;
	          }
    	</script>
	</head >
	
	
	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/detail/modifyVedioConference.action" id="addForm" name="addForm" method="post">
   <input name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID}" type="hidden" id="meetingDetailID"/>
   <input name="meetingDetailVO.meetingType" value="${meetingDetailVO.meetingType}"  type="hidden"/>
   <input name="meetingDetailVO.status" value="${meetingDetailVO.status}"  type="hidden"/>
   <div id="container">
<div class="content">
<div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_ctx}/images/blue/titleicon.gif" width="20" height="25" /></div>
  <div class="fl">&nbsp;视频会议审批</div>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>会议名称</td>
            <td class="al pl3" >
                <input  name="meetingDetailVO.meetingName" class="input200 fontstyle" id="meetingName" value="${meetingDetailVO.meetingName }"/>
           
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>开始时间</td>
            <td class="al pl3">
                <input name="meetingDetailVO.meetingStartTime" id=meetingStartTime type="text"
						 class="input200 fontstyle" style="cursor:pointer" readonly onclick='javascript:selectMeetingTime(this)' value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>				
            </td>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>结束时间</td>
            <td class="al pl3">
                <input  name="meetingDetailVO.meetingEndTime" style="cursor:pointer" id="meetingEndTime" type="text" class="input200 fontstyle"
						readonly onclick='javascript:selectMeetingTime(this)' value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">选择模板</td>
            <td class="al pl3">
               <select name="meetingDetailVO.confProfileID" id="model" class="select200 fontstyle" >
					<zzst:option type="mcuConferenProfiles" value="" required="false"/>
				</select>					
            </td>
             <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>主会议室</td>
            <td class="al pl3">
                <input name="meetingDetailVO.meetingRoomID" value="${meetingDetailVO.meetingRoomID}" id="meetingRoomID" type="hidden"/>
                <input name="meetingDetailVO.meetingRoomName" value="<c:out value='${meetingDetailVO.meetingRoomName}'/>" style="cursor:pointer" readonly onclick="javascript:selectConference(this)" class="input200 fontstyle"  id="meetingRoomName" type="text"/>
            </td>
          </tr>
        <tr>
            <td class="ar fontstyle fontb pr3 tdhight">参会会场</td>
            <td class="al pl3" colspan="3">
                <input  name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs" type="hidden" class="input200 fontstyle" value="${meetingDetailVO.meetingRoomNameIDs}"/>
                <textarea class="areatext fontstyle" name="meetingDetailVO.meetingRoomNames" readOnly style="cursor:pointer" onclick="javascript:selectVenue(this)" id="meetingRoomNames" cols="60" ><c:out value="${meetingDetailVO.meetingRoomNames}" ></c:out></textarea>
                <script type="text/javascript">
                    function selectVenue(thisDom){
                          var selectedConference = document.getElementById("meetingRoomID").value;
              			  var conferenceParameters = {
			                  methodName:'getReturnVenueMethod',
			                  selectedConference:selectedConference,
			                  selectType:'multiple'
			              }
			             creatConferenceSelect(thisDom,conferenceParameters); 
			          }
			          //返回方法
			          //用于获取返回参数
			          //返回参数为数组类型
			          //用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
			          //以提供的参数：conferenceID,conferenceName
			          function getReturnVenueMethod(conferenceArray){
			              var conferenceName = "";
			              var conferenceID = "";
			              var length = conferenceArray.length;
			              for(var i=0;i<length;i++){
			                  if(i==(length-1)){
			                      conferenceName =conferenceName+conferenceArray[i].conferenceName;
			                      conferenceID = conferenceID+conferenceArray[i].conferenceID;
			                  }else{
			                      conferenceName =conferenceName+conferenceArray[i].conferenceName+",";
			                      conferenceID = conferenceID+conferenceArray[i].conferenceID+",";
			                  }
			              }
			              document.getElementById("meetingRoomNames").value=conferenceName;
			              document.getElementById("meetingRoomNameIDs").value=conferenceID;
			          }
                </script>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">参会人员</td>
            <td class="al pl3" colspan="3">
             <input name="meetingDetailVO.participatorIDs" id="participatorIDs" type="hidden" class="input200 fontstyle" value="${meetingDetailVO.participatorIDs}"/>
             <textarea class="areatext fontstyle" name="meetingDetailVO.participators" readOnly style="cursor:pointer" onclick="javascript:selectUsers(this)" id="participators" cols="60" >${meetingDetailVO.participators}</textarea>
                <script type="text/javascript">
			          function selectUsers(thisDom){
				          var selectedUser = document.getElementById("participatorIDs").value;
			                 var userParameters = {
				                  methodName:'getReturnUserMethod',
				                  selectedUser:selectedUser,
				                  selectType:'multiple'
			               }
				             creatUserSelect(thisDom,userParameters); 
				      }
			     
			          function getReturnUserMethod(userArray){
			              //alert(userArray);
			              var userName = "";
			              var userID = "";
			              var length = userArray.length;
			              for(var i=0;i<length;i++){
			                  if(i==(length-1)){
			                      userName =userName+userArray[i].userName;
			                      userID = userID+userArray[i].userID;
			                  }else{
			                      userName =userName+userArray[i].userName+",";
			                      userID = userID+userArray[i].userID+",";
			                  }
			              }
			              document.getElementById("participators").value=userName;
			              document.getElementById("participatorIDs").value=userID;
			          }
                </script>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">会议描述</td>
            <td class="al pl3" colspan="3">
                <textarea name="meetingDetailVO.meetingDescription" class="areatext fontstyle" id="meetingDescription" ><c:out value="${meetingDetailVO.meetingDescription }"/></textarea>							
            </td>
          </tr>
   
     </table>
     </div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
  <tfoot>
  </tfoot>        
   <tbody>
  <tr>
    <td><input type="button" name="button" id="button" value="确 定" onclick="modifyMeeting()"  class="submit1 radius2" />
      <input type="button" name="button2" id="button2" value="返 回" onclick=" backHistory();" class="reset1 radius2" /></td>
  </tr>
  </tbody>
</table>
</div>
</div>
  </form>
</body>

</html>