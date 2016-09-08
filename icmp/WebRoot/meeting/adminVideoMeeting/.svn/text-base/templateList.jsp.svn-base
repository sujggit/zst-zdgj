<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common_header.jsp"%>
		<title>模板管理</title>
		
		<script type="text/javascript">
	  
		function modifyMeeting(id){
        location.href="/icmp/detail/getMeetingTemplate.action?meetingDetailVO.meetingDetailID=" + id;
       }
       
       function delTemplate(meetingTemplateID,meetingDetailID){
       if(confirm("确认删除此模板？")){
       
        location.href="delMeetingTemplateForVideo.action?meetingTemplateVO.meetingTemplateID=" + meetingTemplateID+ '&meetingTemplateVO.meetingDetailID=' + meetingDetailID;
       }else{
       return;
       }
       }
		
	</script>

	</head>
<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' class="id_bg">
<form action="" method="post" name="pageform" id="pageform">
 <table align="center" cellpadding="0"  cellspacing="0" class="cter_bg2">
  <tr>
    <td class="cx_bg" height="26px">查询条件</td>
    <td class="cx_bg2"><a href="/icmp/meeting/role/addRole.jsp" class="cx_textsh">增加</a></td>
  </tr>
    <tr>
     <td colspan="2" valign="top" >
         <table class="cx_tab" cellspacing="0" id="query_table" cellpadding="0" border="0">
         <thead>
	            <tr valign="top">
	           <td width="20%" class="cx_bgsx">名 称</td>	        
	            <td width="30%" class="cx_bgsx">功 能</td>	           
	          </tr>
          </thead>
          <tbody>
	 
			 <c:forEach items="${meetingDetailVOList}" var="MeetingDetailVO" varStatus="status">
                <tr class="cx_bgsx2">
                  <td width="25%" >
                  <c:out value="${MeetingDetailVO.meetingName}" />
                  </td>
                  	<input type="hidden" value="${MeetingDetailVO.meetingDetailID }" name="meetingTemplate.meetingDetailID"/>
                   <td width="50%" >
                      <input name="button" type="button" class="cx_oper" id="button" onclick="addMeeting('${MeetingDetailVO.meetingDetailID }');" title="立即召开" />&nbsp;&nbsp;
                   	  <input type="button" style="cursor:pointer" title="修改" onclick="modifyMeeting('${MeetingDetailVO.meetingDetailID}')" class="cx_Modify" />&nbsp;&nbsp;
           			  <input type="button" style="cursor:pointer" title="删除" onclick="delTemplate('${MeetingDetailVO.meetingDetailID}','${MeetingDetailVO.meetingDetailID}')" class="cx_delete" />
           		   </td>
            </tr>
            </c:forEach>				
			</tbody>
        </table>
        <jsp:include page="/common/pageFooter.jsp"></jsp:include>
    </td>
  </tr>
 </table>
 </form>
</body>
</html>