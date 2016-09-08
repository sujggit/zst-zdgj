<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.MeetingStatus" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
<title>会议列表</title>
<script type="text/javascript">
    
       //查询
     function queryForm(){
     
         document.getElementById("pageform").submit();
     }
     
 
       
     //修改
     function modify(meetingID,types){
           if(types == 1){
            window.location.href="${sys_ctx }/detail/gentoExam.action?meetingDetailID="+meetingID;
            }else if(types==2){
             window.location.href="${sys_ctx }/detail/videotobeExam.action?meetingDetailID="+meetingID;
            }
     }
    //显示隐藏查询域
	function disquery(){
		var obj = document.getElementById("queryid");
		if(obj){
			if(obj.style.display==""){
				obj.style.display = "none";
			}else{
				obj.style.display = "";
			}
			
		}
	}
	   //选择时间
			function selectMeetingTime(thisDom,timeType){
			     
			     var parameters = {
			         dateType : "datetime",
			         isNeedInfo:"true"
			     }
			     
			    creatCalendar(thisDom,parameters);
			  
			}
	
	//结束会议		
	function endMeeting(meetingDetailID){
		if(meetingDetailID !="" && meetingDetailID != null) {
			if(!confirm("确定要结束该会议吗？")){
				return;
			}
			window.location.href = "${sys_ctx }/detail/endMeeting.action?meetingDetailVO.meetingDetailID="+meetingDetailID;
			//McuDwrMethod.deleteConf(meetingDetailID, function(){window.location.reload();});
		}
	}
</script>
</head>

<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx }/detail/queryLocalConference.action" id="pageform" name="pageform" method="post">
 <div id="container">
<div class="content">
<div class="contenttitle fontstyle ">
  <div class="fl"><img src="${sys_page_list_down}" width="20" height="25" /></div>
  <div class="fl fontb">&nbsp;查询条件</div>
  <div class="fr"><input name="" type="button" class="stdbtn mlr10" value="查 询"  onclick="queryForm();"/></div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
    <tr>
      <td  class="ar fontstyle fontb pr3 tdhight">会议名称</td>
             <td  class="al pl3 tdhight">
               <input type="text" name="meetingDetailVO.meetingName" id="meetingName" value="${meetingDetailVO.meetingName}" class="select200 fontstyle" />
               </td>
             <td  class="ar fontstyle fontb pr3 tdhight">会议状态</td>
            <td  class="al pl3 tdhight">
              <select name="meetingDetailVO.status" id="status"  class="select200 fontstyle">
            	<zzst:option type="meetingStatus" value="${meetingDetailVO.status}" required="false"/>
			   </select>
			 </td>   
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">开始时间</td>
      		<td class="al pl3 tdhight">
               <input type="text" name="meetingDetailVO.meetingStartTime" style="cursor:pointer;" readonly onclick="selectMeetingTime(this)"value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>' id="textfield2"  class="input200 fontstyle" />
            </td>
            <td class="ar fontstyle fontb pr3 tdhight">结束时间</td>
      		<td class="al pl3 tdhight">
              <input type="text" name="meetingDetailVO.meetingEndTime" style="cursor:pointer;" readonly onclick="selectMeetingTime(this)" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>' id="textfield"  class="input200 fontstyle" />
            </td>
          </tr>         
        </table>
 <div class="contenttitle fontstyle ">
  	<div class="fl"><img src="${sys_page_list_table }" width="20" height="25" /></div>
  	<div class="fl fontb">&nbsp;查询结果</div>
  </div>

<div class="tablesdiv">
<table width="100%" border="0" id="query_table" cellspacing="0" cellpadding="0" class="listsearch">
         <thead>
	        <tr>
           	<th width="65px" class="titlehome ac fontstyle" >序号</th>
            <th class="titlehome ac fontstyle" style="border-left:0px">会议名称</th>
            <th width="120px" class="titlehome ac fontstyle" >开始时间</th>
            <th width="120px" class="titlehome ac fontstyle" >结束时间</th>
            <th width="90px" class="titlehome ac fontstyle" >会议类型</th>
            <th width="90px" class="titlehome ac fontstyle" >会议状态</th>
            <th width="110px" class="titlehome ac fontstyle" >操作</th>
          </tr>
          </thead>
          <tbody>
	          <c:forEach items="${lst_conference}" var="meedingDetailVO" 	varStatus="state">
		              <tr >
		              		<td class="alc"><c:out value="${state.index+1}"></c:out></td>
		                    <td class="ac fontstyle ">&nbsp;<c:out value="${meedingDetailVO.meetingName}"/></td>
				            <td class="ac fontstyle ">&nbsp;<fmt:formatDate value="${meedingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
				            <td class="ac fontstyle ">&nbsp;<fmt:formatDate value="${meedingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
				            <td class="ac fontstyle ">&nbsp;<zzst:lable type="meetingType" value="${meedingDetailVO.meetingType}"></zzst:lable></td>
				            <td class="ac fontstyle ">&nbsp;${meedingDetailVO.status}</td>	
				            <td class="alc ">				            
				                
				                <img src="${sys_ctx }/images/main/edit-icon.gif" style="cursor:pointer" onclick="modify('${meedingDetailVO.meetingDetailID}','${meedingDetailVO.meetingType}')" title="审批" />
			
				            
				            </td>
		              </tr>
	          </c:forEach>
          </tbody>
       </table>
</div>
    <jsp:include page="/common/pageFooter.jsp"/>

</div>
</div>
 </form>
</body>
</html>