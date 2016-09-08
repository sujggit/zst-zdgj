<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>会场维护修改 </title>
  <script language="JavaScript">
				/**
			*	设置页面参数
			*@return	null	
			*/
            function pageInit(){
			    var obj = new htmlUtil();
				obj.title("meetingRoomName","输选择");	
				obj.title("maintainUserName","输入长度不超过25个字符");	
				obj.title("createTime","选择时间");	
				
			};
			/**
			*	修改会议室
			*@return	null	
			*/
   			function  MeetingRoomMaintainModify(){
   			  $('#modifyForm').validate({    
					rules:{    
					   "meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
					   "meetingRoomMaintainVO.createTime" : {
						           required:true
						         
						       },
					     "meetingRoomMaintainVO.maintainUserName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           }
					  
					}
				  });
                     $('#modifyForm').submit();
           	};
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/meetingRoomMaintain/query.action";
            };
             
	          function selectMeetingRoomMaintainTime(thisDom,timeType){
			     
			     var parameters = {
			         dateType : "datetime",
			         isNeedInfo:"true"
			     }
			     
			    creatCalendar(thisDom,parameters);
			  
			}
	          
	         function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectType:'radio'
              }
             creatConferenceSelect(thisDom,conferenceParameters); 
          }
     
          
          function getReturnConferenceMethod(conferenceArray){
              //alert(userArray);
            //  alert(conferenceArray[0].conferenceID);
            //  alert(conferenceArray[0].conferenceName+"//"+conferenceArray[0].conferenceName);
                  var meetingRoomID="";
	              var meetingRoomName="";
	              var conferenceLength = conferenceArray.length;
	              for(var i=0;i<conferenceLength;i++){
	            	  meetingRoomID=conferenceArray[i].conferenceID;
	            	  meetingRoomName=conferenceArray[i].conferenceName;
	              }
	          	$("#meetingRoomID").attr("value",meetingRoomID);
               	$("#meetingRoomName").attr("value",meetingRoomName);
              
          }
    </script>	
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="pageInit();">
  <div class="contentwrapper">
    <form action="${sys_ctx}/meetingRoomMaintain/modify.action" id="modifyForm" name="modifyForm"  method="post">
      <input type="hidden" name="meetingRoomMaintainVO.maintainID" id="maintainID"  value="${meetingRoomMaintainVO.maintainID}"/>
      <input type="hidden" name="meetingRoomMaintainVO.roomID" id="meetingRoomID" value="${meetingRoomMaintainVO.roomID}" />
      <div class="contenttitle2">
        <h5 class="fwb fl10">会场维护修改</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>会场名称</td>
          <td width="35%" class="tableadd_data" >
             <input class="inputtran" name="meetingRoomMaintainVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" readonly="readonly"  onclick="selectConference(this);" value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName}"/>                                                        
		  </td>
          <td width="15%" class="tableaddtitle"><span>*</span>维护日期</td>
          <td width="35%" class="tableadd_data">
          <input name="meetingRoomMaintainVO.createTime" class="inputtran" style="cursor:pointer;" readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:#{%m+1}'});" value=" <fmt:formatDate value="${meetingRoomMaintainVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/>" id="createTime"   />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>维护人员</td>
          <td class="tableadd_data" colspan="3">
           <input class="inputtran" name="meetingRoomMaintainVO.maintainUserName" id="maintainUserName" value="${meetingRoomMaintainVO.maintainUserName}" />
          </td>
        </tr>
       
        <c:forEach items="${meetingRoomMaintainVO.meetingRoomMaintainDetailList}" var="meetingRoomMaintain">
         
         <c:if test="${meetingRoomMaintain.type == 1}">
           <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>设备开机</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status1" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status1" value="1" ${meetingRoomMaintain.status==1 ? "checked" : "" } />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description1" rows="1" cols="19" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
         </c:if>  
         
         <c:if test="${meetingRoomMaintain.type == 2}">
        <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>终端连接</td>
           <td class="tableadd_data" colspan="3">

						<input type="radio" name="status2" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status2" value="1" ${meetingRoomMaintain.status==1 ? "checked" : "" } />存在故障
            </td>
            </tr>
            <tr>
            
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description2" rows="1" cols="20" class="areatran"style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
         </c:if>  
         
         <c:if test="${meetingRoomMaintain.type == 3}">
        <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>本地图像</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status3" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status3" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td></tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description3" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        <c:if test="${meetingRoomMaintain.type == 4}">
          <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>本地声音</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status4" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status4" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td></tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description4" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}"style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        <c:if test="${meetingRoomMaintain.type == 5}">
            <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>远端图像</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status5" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status5" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description5" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        
        <c:if test="${meetingRoomMaintain.type == 6}">
          <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>远端声音</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status6" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status6" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle" ><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description6" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        
        <c:if test="${meetingRoomMaintain.type == 7}">
        <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>双流测试</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status7" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status7" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述：</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description7" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        <c:if test="${meetingRoomMaintain.type == 8}">
          <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>设备关机</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status8" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status8" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description8" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        <c:if test="${meetingRoomMaintain.type == 9}">
             <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>网络连接</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status9" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status9" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description9" rows="1" cols="20" class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
         </c:if>
          <c:if test="${meetingRoomMaintain.type == 10}">
            <tr class="tdhight">
           <td class="tableaddtitle"><span class="fonttsx">*</span>IP电话</td>
           <td class="tableadd_data" colspan="3">
						<input type="radio" name="status10" value="0" ${meetingRoomMaintain.status==0 ? "checked" : "" } />正常
                        <input type="radio" name="status10" value="1" ${meetingRoomMaintain.status==1 ? "checked" : ""} />存在故障
           
            </td>
            </tr>
            <tr>
            <td class="tableaddtitle"><span class="fonttsx"></span>问题描述</td>                   
             <td class="tableadd_data" colspan="3"><textarea name="description10" rows="1" cols="20" class="areatran"  style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}</textarea>
             </td>
        </tr>
        </c:if>
        
        </c:forEach>
        
        <tr class="tdhight">
             <td class="tableaddtitle"><span class="fonttsx"></span>其他问题</td>
             <td class="tableadd_data" colspan="3">
             <textarea name="meetingRoomMaintainVO.description" id="questionDes"  class="areatran" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;width:90%" title="${meetingRoomMaintain.questionDes}" >${meetingRoomMaintainVO.description}</textarea>
             </td>
           </tr>  
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" name="button" id="button" class="submit1 radius2" value="确 定" onclick="MeetingRoomMaintainModify();"/>
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>