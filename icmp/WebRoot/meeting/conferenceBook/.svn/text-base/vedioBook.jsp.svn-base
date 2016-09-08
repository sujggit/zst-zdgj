<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@ page import="com.zzst.action.meeting.util.MeetingAppConfig" %>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <%@include file="/common/common.jsp"%>
    <title>视频会议</title>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
    <script type="text/javascript">
		/**
		*	设置页面参数，友好提示
		*@return	null	
		*/
		function pageInit(){
			var obj = new htmlUtil();
			obj.title("meetingName","不超过25个字符");
			obj.title("meetingRoomNames","请选择");
			obj.title("select","请选择");
			obj.title("meetingRoomName","请选择");	
			obj.title("meetingStartTime","请选择");	
			obj.title("meetingEndTime","请选择");
			obj.title("participators","请选择");
			obj.title("meetingDescription","不超过500个字符");
		    //DwrMethod.getMcuTemplateByMeetingRoomID(document.getElementById("meetingRoomID").value,getTemplateCallBack);
		}
		
		   /**
		*	返回列表
		*@return	null
		*/
         function backHistory(){
           	//window.location.href="${sys_ctx}/detail/queryLocalConference.action";
           	window.location.href="${sys_ctx}/conference/conferenceList.action";
         }

		//预约会议
         function addMeeting(){
        	$('#addForm').validate({    
					rules:{    
					   "meetingDetailVO.meetingName" : {
				           required:true,
				           minlength:1,
				           maxlength:25
			           },
					   "meetingDetailVO.meetingRoomName":{
					       required:true
					   },
					   "meetingDetailVO.meetingRoomNames":{
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
					   } ,
					   "meetingDetailVO.confProfileID":{
						   minlength:1,
						   required:true
						}  
					} 
				});
			if($("#addForm").valid()){
            checkMeetingRoom();
            }
         }

         function checkMeetingRoom(){
         	$("#button").attr("disabled",true);
 			var startTime = document.getElementById('meetingStartTime').value;
 			var endTime = document.getElementById('meetingEndTime').value;
 			if(!(startTime&&endTime)){//避免newDate()类型转换错误
				alert("时间必填！");
				$("#button").attr("disabled","");
				return;
 	 		}

 			var currentTime = new Date().getTime();   
	        var startTime1 = new Date(document.getElementById('meetingStartTime').value.replace(/\-/g, "\/")).getTime();
            var endTime1 = new Date(document.getElementById('meetingEndTime').value.replace(/\-/g, "\/")).getTime(); 
            
		    //var sysTimeGap = ${swh_meeting_space_time};
		    if(startTime1<=currentTime){
                    alert("开始时间必须晚于当前时间");
                    document.getElementById('meetingStartTime').value="";
                    document.getElementById('meetingEndTime').value="";
                    $("#button").attr("disabled","");
                    return;
            }
 			
 			var meetingRoomNameIDs = document.getElementById('meetingRoomNameIDs').value;
			var meetingRoomNames = document.getElementById('meetingRoomNames').value;

			if(document.getElementById('meetingRoomID').value !=""){
				meetingRoomNameIDs = document.getElementById('meetingRoomID').value + "," +meetingRoomNameIDs;
				meetingRoomNames =  document.getElementById('meetingRoomName').value + "," +meetingRoomNames;
			}
			DwrMethod.checkMeetingRoom(0, meetingRoomNameIDs, meetingRoomNames, startTime, endTime, checkMeetingRoomCallBack);
 		}
 		
 		function checkMeetingRoomCallBack(lst){
 			if(lst != null && lst.length > 0){
 	 			var meetingRoomNames = "";
 				for(var i = 0; i < lst.length; i++){
 	 				if(i > 0){
 	 					meetingRoomNames += ", ";
 	 				}
 					meetingRoomNames += lst[i];
 					//alert(meetingRoomNames + " 已经被其他会议占用！\n");
 				}
 				alert(meetingRoomNames + " 已经被其他会议占用！\n");
 				$("#button").attr("disabled","");
 				return;
 			}else{
 				var sms = document.getElementById("sms").checked;
 				if(sms){
 					sms="1";
 				}else{
 					sms="0";
 				}
 				var email = document.getElementById("email").checked;
 				if(email){
 					email="1";
 				}else{
 					email="0";
 				}
 				var billboard = document.getElementById("billboard").checked;
 				if(billboard){
 					billboard="1";
 				}else{
 					billboard="0";
 				}
 				var notify = sms + email+billboard;
 				document.getElementById("notify").value = notify;
 				var record = document.getElementById("record").checked;
 				if(record){
 					document.getElementById("recordval").value = "1";
 				}else{
 					document.getElementById("recordval").value = "0";
 				}
 				 $('#addForm').submit();
 				 $("#button").attr("disabled",true);	
 			}
 		}
 		
        $(document).ready(function(){
              pageInit();
              var applyStatus = document.getElementById("applyStatus");
          	  if(applyStatus.value==2){
          		$("#button").attr("disabled","disabled");
          		document.getElementById("promptSpan").innerHTML="没有相关审批人员；请联系流程管理人员，或禁用流程，或配置审批人";
              }
         })
         function switchTab(id)
         {
             //document.getElementById(id).className="Selected";
             if(id=="Tab2"){
               location.href="${sys_ctx }/detail/generalAddBefor.action";
             }
         }
    </script>	
    <script type="text/javascript">
       function menu(m){
	       document.getElementById("k"+m).style.display="block";
	       document.getElementById("m"+m).style.backgroundColor="#fff";
	       document.getElementById("m1").style.backgroundColor="";
	       $("#m"+m).attr("class","labelLiveSty");
	       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
	  }
	</script>
  </head>
  <body onload="menu(2);">
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
      <div class="center1">
       <form action="${sys_ctx }/detail/vedioAdd.action" id="addForm" name="addForm" method="post">
        <input type="hidden" name="applyStatus" id="applyStatus" value="${isApply}" /><!-- 审批状态 -->
        <div id="m">
            <ul>
                <%
            	ArrayList confRoomVectorTemp = (ArrayList)request.getAttribute("baseInfoList");
            	if(confRoomVectorTemp != null && confRoomVectorTemp.size() > 0){
            		for(int i=0; i<confRoomVectorTemp.size(); i++){
            			BaseInfoVO baseInfoVO = (BaseInfoVO)confRoomVectorTemp.get(i);
            			if(baseInfoVO.getInfoName().trim().equals("本地会议")){
            				%>
            				<li id="m1" onmousedown="switchTab('Tab2')" style="background:#fff;">本地会议</li> 
            				<%
            			}
            			if(baseInfoVO.getInfoName().trim().equals("视频会议")){
            				%>
            				 <li id="m2" onmousedown="switchTab('Tab1')">视频会议</li> 
            				<%
            			}
            		}
            	}
            	%>
          </ul>
        </div>
    	
        <div id="k2" class="k">
         
             <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
               <tr>
                 <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
                 <td colspan="3" class="tableadd_data" >
                 	 <input maxlength="25" name="meetingDetailVO.meetingName" class="inputtran" id="meetingName" value="${meetingDetailVO.meetingName }"/>
                 </td>
               </tr>
               <tr>
                 <td class="tableaddtitle"><span>*</span>开始时间</td>
                 <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
                 <input name="meetingDetailVO.meetingStartTime" class="inputtran" id="meetingStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="var meetingEndTime=$dp.$('meetingEndTime');meetingEndTime.value='';WdatePicker({onpicked:function(){meetingEndTime.focus();meetingEndTime.value='';},dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:%m',maxDate:'#F{$dp.$D(\'meetingEndTime\',{d:0})}'});" 
                	 value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
                 </td>
                 <td class="tableaddtitle"><span>*</span>结束时间</td>
                 <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
                   <input  name="meetingDetailVO.meetingEndTime" style="cursor:pointer" id="meetingEndTime" type="text" class="inputtran"
						readonly="readonly" onfocus="getEndTime();" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
                   </td>
                  </tr>
                  <script type="text/javascript">
                	function getEndTime(){
                		if($('#meetingStartTime').val()==""){
                    		$('#meetingStartTime').focus();
                    		return;
                    	}else{
                    		WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'meetingStartTime\',{m:${sys_date_num }})||\'%y-%M-%d %H:%m\'}'});
                       }
                     }
                   </script> 
                  <tr>
                     <td class="tableaddtitle"><span>*</span>主会议室</td>
                     <td class="tableadd_data">
                        <input name="meetingDetailVO.meetingRoomID" id="meetingRoomID" type="hidden" value="${meetingDetailVO.meetingRoomID }"/>
					    <input name="meetingDetailVO.meetingRoomName" value="${meetingDetailVO.meetingRoomName }" style="cursor:pointer;width:80%" readonly="readonly" onclick="javascript:selectConference(this)" class="inputtran"  id="meetingRoomName" type="text" />
                  <script type="text/javascript">
                    function selectConference(thisDom){
                          var selectedConference = document.getElementById("meetingRoomID").value;
			              var conferenceParameters = {
			                  methodName:'getReturnConferenceMethod',
			                  selectedConference:selectedConference,
			                  selectType:'radio'
			              }
			              creatConferenceSelectVedioBook(thisDom,conferenceParameters); 
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
			             // DwrMethod.getMcuTemplateByMeetingRoomID(conferenceID,getTemplateCallBack);
			          }
                	</script>
                     </td>
                     <td class="tableaddtitle"><span>*</span>会议模式</td>
                     <td class="tableadd_data" id="mySelect_02" >
                      <select name="meetingDetailVO.confProfileID" id="select" class="select200 fontstyle" >
                      	 <option value="">请选择...</option>
							<zzst:option type="linkMeetingModel" value="${meetingDetailVO.confProfileID}" required="true"/>
 						</select>	
                     </td>
                   </tr>
                   <tr <c:if test="${sms!=true and email != true and billboard!=true and meetingservice != true}">style="display:none"</c:if>>
                   <td class="tableaddtitle" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if>>会议通知</td>
                   <td class="tableadd_data" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if><c:if test="${meetingservice != true}">colspan="3"</c:if>>
                   <span <c:if test="${sms!=true }">style="display:none"</c:if>><input type="checkbox" value="1" id="sms" checked/>短信&nbsp;&nbsp;</span>
                   <span <c:if test="${email != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="email" checked/>邮件&nbsp;&nbsp;</span>
                   <span <c:if test="${billboard != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="billboard" checked/>告示&nbsp;&nbsp;</span>
                   <input type="hidden" value="000" id="notify" name="meetingDetailVO.notifyType"/>
                    <zzst:pageprompt type="meetingNoticeType"/>
                   </td>
                   
                   <td class="tableaddtitle" <c:if test="${meetingservice != true }">style="display:none"</c:if>>会议服务</td>
                   <td class="tableadd_data" <c:if test="${meetingservice != true }">style="display:none"</c:if> <c:if test="${sms!=true and email != true and billboard != true}">colspan="3"</c:if>>
                   <select id="level"  class="select200 fontstyle" name="meetingDetailVO.grade">
					<zzst:option type="meetingServiceType" value="<%=String.valueOf(Integer.MIN_VALUE) %>" required="false"/>
                   </select>
                   <zzst:pageprompt type="meetingServiceType"/>
                   </td>
                   </tr>
                   <tr <c:if test="${record!=true or billboard != true }">style="display:none"</c:if>>
                   <td class="tableaddtitle" <c:if test="${record!=true}">style="display:none"</c:if>>录播</td>
                   <td class="tableadd_data" <c:if test="${record!=true }">style="display:none"</c:if> colspan="3">
                   <span ><input type="checkbox" id="record" />开启&nbsp;&nbsp;</span>
                   <input type="hidden" value="0" name="meetingDetailVO.useReach" id="recordval"/>
                    <zzst:pageprompt type="meetingRecordType"/>
                   </td>
                   
                   </tr>
                   <%
                    DictionaryVO dv=new DictionaryVO();
			        dv.setDicType("meetLable");
			        ArrayList dvList=ServiceFactory.getDictionaryService().query(dv, null);
			        int nums=3;
                    if(dvList.size()>0){
                    nums=0;
                    }
                     %>
                   
                   <tr>
                   <td class="tableaddtitle" >会议资料管理员</td>
                   <td class="tableadd_data" colspan="<%=nums %>">
                     <input name="meetingDetailVO.confDocAdminId" id="confDocAdminId" type="hidden" class="areatran" value="${sys_userSession.userID}"/>
                     <input name="meetingDetailVO.confDocAdminName" id="confDocAdminName" class="inputtran" style="cursor:pointer" readonly="readonly" value="${sys_userSession.name}" onclick="selectUsers(this,'radio')" />
                   </td>
                    <%if(nums==0){ %>
                   <td class="tableaddtitle">会议标签</td>
                   <td class="tableadd_data">
                    <select id="levelinfos"  class="select200 fontstyle" name="meetingDetailVO.info1">
                  <%
                  for(int i=0;i<dvList.size();i++){
                  DictionaryVO dvs=(DictionaryVO)dvList.get(i);
                   %>
                    <option value="<%=dvs.getDicViewName() %>"><%=dvs.getDicViewName() %></option>
                    
                    <% }%>
                    </select>
                   
                   </td>
                   <%} %>
                   </tr>
                   <tr>
                     <td class="tableaddtitle" style="vertical-align:top;"><span>*</span>参会会场</td>
                     <td colspan="3" class="tableadd_data" >
                      <input  name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs" type="hidden" class="input200 fontstyle"/>
	   				  <textarea class="areatran" name="meetingDetailVO.meetingRoomNames" readonly="readonly" style="cursor:pointer;width:85%" onclick="javascript:selectVenue(this)" id="meetingRoomNames"  ></textarea>
                	<script type="text/javascript">
                       function selectVenue(thisDom){
                          var selectedConference = document.getElementById("meetingRoomNameIDs").value;
              			  var conferenceParameters = {
			                  methodName:'getReturnVenueMethod',
			                  selectedConference:selectedConference,
			                  selectType:'multiple'
			              }
              			creatConferenceSelectVedioBook(thisDom,conferenceParameters); 
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
                  <td class="tableaddtitle" style="vertical-align:top;">参与人员</td>
                  <td colspan="3" class="tableadd_data" >
                     <input  name="meetingDetailVO.participatorIDs" id="participatorIDs" type="hidden" class="areatran"/>
                     <textarea class="areatran" name="meetingDetailVO.participators" readonly="readonly" style="cursor:pointer;width:85%" onclick="javascript:selectUsers(this,'multiple')" id="participators"  ><c:out  value="${meetingDetailVO.participators}"></c:out></textarea>
                   <script type="text/javascript">
                   var type="";
			          function selectUsers(thisDom,selectType){
			          type = selectType;
				          var selectedUser = document.getElementById("participatorIDs").value;
			                 var userParameters = {
				                  methodName:'getReturnUserMethod',
				                  selectedUser:selectedUser,
				                  selectType:selectType
			               }
				             creatUserSelect(thisDom,userParameters); 
				      }
			     
			          function getReturnUserMethod(userArray){
			          if(type=='multiple'){
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
			            if(type=='radio'){
			            	 var userID="";
				              var userName="";
				              var userLength = userArray.length;
				              for(var i=0;i<userLength;i++){
				            	  userID=userArray[i].userID;
				            	  userName=userArray[i].userName;
				              }
				          	$("#confDocAdminId").attr("value",userID);
			               	$("#confDocAdminName").attr("value",userName);
			            }
			          }
                     </script>
                     </td>
                   </tr>
                   <tr>
                     <td class="tableaddtitle" style="vertical-align:top;" >会议描述</td>
                     <td colspan="3" class="tableadd_data" >
                     	<textarea class="areatran" name="meetingDetailVO.meetingDescription"  id="meetingDescription" style="cursor:pointer;width:85%" ><c:out value="${meetingDetailVO.meetingDescription }" /></textarea>
                     </td>
                   </tr>
                 </table>
                
        </div>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                   <tfoot>
                   </tfoot>
                   <tbody>
                     <tr>
                       <td>
                        <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
                       	<input type="button" name="button" id="button" value="预约会议" onclick="addMeeting()" class="submit1 radius2"/>
                       	<input type="reset" name="button2" id="button2" value="重 置"  class="reset1 radius2" />
                       </td>
                     </tr>
                   </tbody>
                 </table>
             </form>
      </div>
       
    </div>
  </body>
</html>