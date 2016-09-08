<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>

	<title>字幕</title>
<script type="text/javascript">



 function changeMeetingDetail(id){
	 if(id==""){
		 alert("请选择会议");
		 return;
	 }
	 window.frmbot.window.location.href ="${sys_ctx }/mcuControl/getMessagePageByConId.action?confID="+id;
}

</script>
</head>

<body>
 <div id="basicform" class="contentwrapper">
        <div class="contenttitle2">
			<h5 class="fwb fl10">字幕</h5>
		</div>
      
     
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
 <input type="hidden" name="meetingMcuVO.meetingMcuKeyID" value="${meetingMcuVO.meetingMCUKeyID }" id="meetingMcuKeyID"/>
   
 
  
   <tr>
    <td width="20%" class="tableaddtitle">会议选择</td>
    <td class="tableadd_data">
      <span class="field">
          <select name="selection" id="filterSelectId" onchange="changeMeetingDetail(this.value);">
          		<option value="">请选择...</option>
              <c:forEach items="${confVOList}" var="meetingDetail">
				<option value="${meetingDetail.confID }" >
					<c:out value="${meetingDetail.confName }"></c:out>
					
				</option>
				"
			 </c:forEach>
          </select>
           <c:forEach items="${confVOList}" var="meetingDetail">
		 <input type="hidden" value="${meetingDetail.mcuType }" id="${meetingDetail.confID }"/>
				
			 </c:forEach>
         
      </span>

    </td>
  </tr>
  
</table>
</div> 
<iframe id="frmbot" frameborder="0"   name="frmbot" src="" style="HEIGHT: 395px;  WIDTH: 100%;  " align="middle"></iframe>
</body>

</html>