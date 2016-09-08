<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
			/**
			*	设置页面参数，友好提示
			*@return	null	
			*/
			function pageInit(){
				var obj = new htmlUtil();
				obj.title("meetingName","不超过25个字符");
				obj.title("meetingRoomName","请选择");	
//				obj.title("model","点击选择模板");
				obj.title("meetingStartTime","请选择");	
				obj.title("meetingEndTime","请选择");
				obj.title("participators","请选择");
				obj.title("meetingDescription","不超过500个字符");
//				DwrMethod.getMcuTemplateByMeetingRoomID(document.getElementById("meetingRoomID").value,getTemplateCallBack);
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
 				var notify = sms + email + billboard;
 				document.getElementById("notify").value = notify;
 				var record = document.getElementById("record").checked;
 				if(record){
 					document.getElementById("recordval").value = "1";
 				}else{
 					document.getElementById("recordval").value = "0";
 				}
  				 $('#addForm').submit();			
  			}
  		}
         
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/detail/queryMyConference.action";
            }
		
         window.onload=function(){
              pageInit();
         }

    	</script>
	</head >
	
	
	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/detail/mymodifyVedioConference.action" id="addForm" name="addForm" method="post">
   <input name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID}" type="hidden" id="meetingDetailID"/>
   <input name="meetingDetailVO.meetingType" value="${meetingDetailVO.meetingType}"  type="hidden"/>
   <input name="meetingDetailVO.status" value="${meetingDetailVO.status}"  type="hidden"/>
   <div id="k2">
                                      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                                        <tr>
                                          <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
                                          <td colspan="3" class="tableadd_data" >
                                          	 <input  name="meetingDetailVO.meetingName" class="inputtran" id="meetingName" value="${meetingDetailVO.meetingName }"/>
                
                                          </td>
                                        </tr>
                                        <tr>
                                          <td class="tableaddtitle"><span>*</span>开始时间</td>
                                          <td width="35%" class="tableadd_data" >
                                          <img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
                                             <input name="meetingDetailVO.meetingStartTime" id=meetingStartTime type="text"
						class="inputtran" style="cursor:pointer" readonly onfocus="var meetingEndTime=$dp.$('meetingEndTime');meetingEndTime.value='';WdatePicker({onpicked:function(){meetingEndTime.focus();meetingEndTime.value='';},dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:%m',maxDate:'#F{$dp.$D(\'meetingEndTime\',{d:0})}'});" value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
					
                                            </td>
                                          <td width="15%" class="tableaddtitle"><span>*</span>结束时间</td>
                                          <td width="35%" class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
                                             <input  name="meetingDetailVO.meetingEndTime" style="cursor:pointer" id="meetingEndTime" type="text" class="inputtran"
												 readonly onfocus="getEndTime();" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
             
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
               								 <input  name="meetingDetailVO.meetingRoomName" value="${meetingDetailVO.meetingRoomName }" style="cursor:pointer" readonly onclick="javascript:selectConference(this)" class="inputtran"  id="meetingRoomName" type="text"/>
                
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
			            //  DwrMethod.getMcuTemplateByMeetingRoomID(conferenceID,getTemplateCallBack);
			          }
			          
			        //  function getTemplateCallBack( result ){
	 	    		//	document.getElementById('mySelect_02').innerHTML='<select name="meetingDetailVO.confProfileID" id="model" class="select200 fontstyle" >'+ result+'</select>';
	 			    // }
                </script>
                                          </td>
                                          <td class="tableaddtitle">会议模式</td>
                                          <td class="tableadd_data" id="mySelect_02" >
                                          
                                           <select name="meetingDetailVO.confProfileID" id="select" class="select200 fontstyle" >
            								 <zzst:option type="linkMeetingModel" value="${meetingDetailVO.confProfileID}" required="true"/>
            							   </select>	
                                          
                                          </td>
                                        </tr>
                   <tr <c:if test="${sms!=true and email != true and billboard != true and meetingservice != true}">style="display:none"</c:if>>
                   <td class="tableaddtitle" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if>>会议通知</td>
                   <td class="tableadd_data" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if><c:if test="${meetingservice != true}">colspan="3"</c:if>>
                   <span <c:if test="${sms!=true }">style="display:none"</c:if>><input type="checkbox" value="1" id="sms" <c:if test="${meetingSms == true }">checked</c:if> disabled/>短信&nbsp;&nbsp;</span>
                   <span <c:if test="${email != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="email" <c:if test="${meetingEmail == true }">checked</c:if> disabled/>邮件&nbsp;&nbsp;</span>
                   <span <c:if test="${billboard != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="billboard" <c:if test="${meetingBillboard == true }">checked</c:if> disabled/>告示&nbsp;&nbsp;</span>
                   <input type="hidden" value="000" id="notify" name="meetingDetailVO.notifyType"/>
                   <td class="tableaddtitle" <c:if test="${meetingservice != true }">style="display:none"</c:if>>会议服务</td>
                   <td class="tableadd_data" <c:if test="${meetingservice != true }">style="display:none"</c:if> <c:if test="${sms!=true and email != true and billboard != true}">colspan="3"</c:if>>
                   <select id="level"  class="select200 fontstyle" name="meetingDetailVO.grade">
                    <zzst:option type="meetingServiceType" value="${meetingDetailVO.grade}" required="false"/>
                   </select>
                   </tr>
                   <tr <c:if test="${record!=true}">style="display:none"</c:if>>
                   <td class="tableaddtitle" <c:if test="${record!=true}">style="display:none"</c:if>>录播</td>
                   <td class="tableadd_data" <c:if test="${record!=true }">style="display:none"</c:if> colspan="3">
                   <span ><input type="checkbox" id="record" <c:if test="${meetingDetailVO.useReach == 1 }">checked</c:if> />开启&nbsp;&nbsp;</span>
                   <input type="hidden" value="0" name="meetingDetailVO.useReach" id="recordval"/>
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
                   
                    <input  name="meetingDetailVO.confDocAdminId" value="${meetingDetailVO.confDocAdminId }" id="confDocAdminId" type="hidden" class="areatran"/>
                     <input type="text" name="meetingDetailVO.confDocAdminName" id="confDocAdminName" class="inputtran" style="cursor:pointer" readonly="readonly" value="${meetingDetailVO.confDocAdminName }" onclick="selectUsers(this,'radio')" />
                   
                   </td>
                    <%if(nums==0){ %>
                   <td class="tableaddtitle">会议标签</td>
                   <td class="tableadd_data">
                    <select id="levelinfos"  class="select200 fontstyle" name="meetingDetailVO.info1">
                   <option value="${meetingDetailVO.info1 }">${meetingDetailVO.info1 }</option>
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
                                          <td class="tableaddtitle" style="vertical-align:top;">参会会场</td>
                                          <td colspan="3" class="tableadd_data" >
                                           <input  name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs" type="hidden" class="input200 fontstyle" value="${meetingDetailVO.meetingRoomNameIDs }"/>
                						   <textarea class="areatran" name="meetingDetailVO.meetingRoomNames" readOnly style="cursor:pointer;width:85%" onclick="javascript:selectVenue(this)" id="meetingRoomNames" >${meetingDetailVO.meetingRoomNames }</textarea>
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
                                          	
                                          	 <input  name="meetingDetailVO.participatorIDs" id="participatorIDs" type="hidden" class="areatran" value="${meetingDetailVO.participatorIDs}"/>
                <textarea class="areatran" name="meetingDetailVO.participators" readOnly style="cursor:pointer;width:85%" onclick="javascript:selectUsers(this,'multiple')" id="participators"  ><c:out  value="${meetingDetailVO.participators}"></c:out></textarea>
                <script type="text/javascript">
                var type = "";
			          function selectUsers(thisDom,selectType){
			          type=selectType;
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
                                      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                                        <tfoot>
                                        </tfoot>
                                        <tbody>
                                          <tr>
                                            <td>
                                            	<input type="button" name="button" id="addButton" value="预约会议"  onclick="modifyMeeting()" class="submit1 radius2"/>
                                            	<input type="button" name="button2" id="button2" value="返回"  class="reset1 radius2" onclick="backHistory();"/>
                                            </td>
                                          </tr>
                                        </tbody>
                                      </table>
    </div>
  </form>
</body>

</html>