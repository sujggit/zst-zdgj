<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会议模板列表</title>
	<script type="text/javascript">
		function addMeeting(id){	
		location.href="/icmp/detail/getMeetingTemplateInfo.action?meetingDetailVO.meetingDetailID=" + id;
		}
		function createConfCallback(){
		   parent.window.location.href = "/icmp/meetingControl.jsp";
		}
       function back(){
      	alert("模板添加成功");
     	location.href = "/icmp/template/manageMeetingTemplateList.action?date=" + new Date();
        
       }

       function backRe(){
        	location.href = "/icmp/template/manageMeetingTemplateList.action?date=" + new Date();
           
          }
   		function modifyTemplate(id){
        location.href="/icmp/detail/meetingTemplateBeforeModify.action?meetingDetailVO.meetingDetailID=" + id;
       }
       
       function delTemplate(meetingDetailID){
	       if(confirm("确认删除此模板？")){
	       	  location.href="/icmp/detail/delMeetingTemplate.action?meetingDetailVO.meetingDetailID=" + meetingDetailID;
	       }else{
	       	  return;
	       }
       }


       function addTemplate(){
           location.href = "/icmp/detail/meetingTemplateBeforeAdd.action";
       }

       function addVideoMeeting(id){
           location.href = "/icmp/detail/addVideoConference.action?meetingDetailVO.meetingDetailID="+id;
       }

       function exportMeetingTemplateInfo(){
   		document.getElementById('pageform').action="${sys_ctx}/detail/exportTemplateQuery.action";
   		document.getElementById('pageform').submit();
   		document.getElementById('pageform').action="${sys_ctx }/detail/manageMeetingTemplateList.action";
   	   }
    </script>  
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="/icmp/detail/manageMeetingTemplateList.action" method="post" name="pageform" id="pageform">
    <div id="basicform" class="contentwrapper">  
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td class="tableadd_data"><input id="meetingName" name="meetingDetailVO.meetingName" type="text" class="inputtran" value="${meetingDetailVO.meetingName }"/></td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
        </tr>
      </table>
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="addTemplate();">增加|</a><a style="cursor: pointer;" onclick="exportMeetingTemplateInfo();">导出</a></h5>
      </div>
      <!--contenttitle-->
      
      <!--<div class="tableoptions">
       <span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
      </div>-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th class="head1" width="3px" >序号</th>
            <th class="head1" width="30%" >会议名称</th>
            <%--<th width="16%" class="head1">会议模板</th>--%>
            <th  class="head1" width="25%">主会场</th>
            <th class="head1" width="9px" >立即召开</th>
            <th  class="head1" width="10px">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
           <c:forEach items="${meetingDetailVOList}" var="meetingDetailVO" varStatus="status">
		        <tr>
		          	<td class="alc"><c:out value="${status.index+1}"></c:out></td>
		          	<td>
		          		<c:out value="${meetingDetailVO.meetingName}" />
		          	</td>
		          	<%--<td>
		          		<c:out value="${meetingDetailVO.meetingName}" />
		          	</td>--%>
		          	<td>
		          		<c:out value="${meetingDetailVO.meetingRoomName}" />
		          	</td>
		          	<td>
		          		<input type="button" class="stdbtn" value="立即召开" onclick="addVideoMeeting('${meetingDetailVO.meetingDetailID}');"/>
		          	</td>
		          	 <td class="alc"><a style="cursor: pointer;" onclick="modifyTemplate('${meetingDetailVO.meetingDetailID}')">修改</a> | <a style="cursor: pointer;" onclick="delTemplate('${meetingDetailVO.meetingDetailID}')">删除</a></td>
		          	
<%--				          	<
				          	<td class="ac fontstyle ">&nbsp;
				          		<input type="button" style="cursor:pointer" onclick="delTemplate('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingDetailID}')" value="删除" name="button2" id="button2" value="" class="button fontstyle fontb"/>
				               <%-- <input type="button" style="cursor:pointer" onclick="delTemplate('${MeetingDetailVO.meetingDetailID}','${MeetingDetailVO.meetingDetailID}')" title="删除" name="button2" id="button2" value="" class="cx_delete" />
		          	</td>
		          	--%>
		        </tr>
			</c:forEach>
        </tbody>
      </table>
     <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
	</div>
   </form>
  </body>
</html>
