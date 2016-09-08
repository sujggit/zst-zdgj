<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript">
		
          function pass(){
           document.getElementById('status').value='1';
           $('#modifyForm').submit();
          
         }
         function unpass()
         {
            $('#status').value='11';
           $('#modifyForm').submit();
         }
                
         
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/detail/queryLocalConference.action";
            }
         
         
       
    	</script>
	</head >
	
	
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
  <form action="${sys_ctx}/detail/examgen.action" id="modifyForm" name="modifyForm" method="post">
    <input name="meetingDetailVO.meetingDetailID" value="${meetingDetailVO.meetingDetailID}" type="hidden" id="meetingDetailID"/>
   <input name="meetingDetailVO.meetingType" value="${meetingDetailVO.meetingType}"  type="hidden"/>
   <input name="meetingDetailVO.status" id="status" value="${meetingDetailVO.status}"  type="hidden"/>
     <div id="container">
<div class="content">
<div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_ctx}/images/blue/titleicon.gif" width="20" height="25" /></div>
  <div class="fl">&nbsp;本地会议审批</div>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>会议名称</td>
            <td width="30%" class="al pl3">
                <c:out value='${meetingDetailVO.meetingName }' />            
            </td>
            <td width="15%" class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>会议室</td>
            <td width="40%" class="al pl3">
                <input  name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs" type="hidden" class="input200 fontstyle" value="${meetingDetailVO.meetingRoomNameIDs}"/>
                <c:out value='${meetingDetailVO.meetingRoomNames}'/>
               
                <script type="text/javascript">
                    function selectConference(thisDom){
                          var selectedConference = document.getElementById("meetingRoomNameIDs").value;
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
			              document.getElementById("meetingRoomNames").value=conferenceName;
			              document.getElementById("meetingRoomNameIDs").value=conferenceID;
			          }
                </script>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>开始时间</td>
            <td class="al pl3">
			<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>					
            </td>
            <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>结束时间</td>
            <td class="al pl3">
              <fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>
            </td>
          </tr>
          
          <tr>
          <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>举办单位</td>
			<td class="al pl3" colspan="3">
				<input type="hidden" name="departmentIds" class="input200 fontstyle" id="corpID" value="" />
			
				
			</td>
		  </tr>
          <tr>
           
            <td class="ar fontstyle fontb pr3 tdhight">参会人员</td>
            <td class="al pl3" colspan="3">
              <c:out  value="${meetingDetailVO.participators}"></c:out>
            </td>
          </tr>
          
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">会议描述</td>
            <td class="al pl3" colspan="3">
              <c:out value="${meetingDetailVO.meetingDescription }"/>
            </td>
         </tr>
          
   </table>
    </div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
<tfoot>
</tfoot>        
<tbody>
  <tr>
    <td>
    <input type="button" name="button" id="button" value="审批通过" onclick="pass()"  class="submit1 radius2" />
    <input type="button" name="button" id="button" value="审批不通过" onclick="unpass()"  class="submit1 radius2" />
      <input type="button" name="button2" id="button2" value="返 回" onclick=" backHistory();" class="reset1 radius2" /></td>
  </tr>
</tbody>
</table>
</div>
</div>
  </form>
</body>

</html>