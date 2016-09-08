<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
	<title>查看会议详情</title>
	<script type="text/javascript">
		$(document).ready(function(){
			var participator = $('#canhuizhe').val();
			var p=participator.split("；");//主持人，前排，参会者
			$('#zcr').text(p[0]);
			$('#zxt').text(p[1]);
			$('#chz').text(p[2]);
		});
	</script>
  </head >
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<input type="hidden" id="canhuizhe" value="${meetingDetailVO.info3}"/>
    <input type="hidden" name="meetingDetailVO.meetingDetailID" id="meetingDetailID" value="${meetingDetailVO.meetingDetailID}">
     <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会议查看</h5>
      </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" >
              <c:out value='${meetingDetailVO.meetingName }'/>
          </td>
          <td width="15%" class="tableaddtitle">会议室</td>
          <td width="35%" class="tableadd_data">
          	<c:out value='${meetingDetailVO.meetingRoomNames}'/>
          </td>
          </tr>
          <tr>
            <td class="tableaddtitle">开始时间</td>
            <td class="tableadd_data" >
            	<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td class="tableaddtitle">结束时间</td>
            <td class="tableadd_data">  
            	<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>
       	  </td>
          </tr>
          <tr <c:if test="${sms!=true and email != true and billboard != true and meetingservice != true}">style="display:none"</c:if>>
                   <td class="tableaddtitle" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if>>会议通知</td>
                   <td class="tableadd_data" <c:if test="${sms!=true and email != true and billboard != true}">style="display:none"</c:if><c:if test="${meetingservice != true}">colspan="3"</c:if>>
                   <span <c:if test="${sms!=true }">style="display:none"</c:if>><input type="checkbox" value="1" id="sms" <c:if test="${meetingSms == true }">checked</c:if> disabled/>短信&nbsp;&nbsp;</span>
                   <span <c:if test="${email != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="email" <c:if test="${meetingEmail == true }">checked</c:if> disabled/>邮件&nbsp;&nbsp;</span>
                   <span <c:if test="${billboard != true}">style="display:none"</c:if>><input type="checkbox" value="1" id="billboard" <c:if test="${meetingBillboard == true }">checked</c:if> disabled/>告示&nbsp;&nbsp;</span>
                   <input type="hidden" value="000" id="notify" name="meetingDetailVO.notifyType"/>
                   <td class="tableaddtitle" >会议服务</td>
                   <td class="tableadd_data">
                   <select id="level"  class="select200 fontstyle" name="meetingDetailVO.grade" disabled="disabled">
                   <zzst:option type="meetingServiceType" value="${meetingDetailVO.grade}" required="false"/>
                   </select>
                   </td>
                   </tr>
         
          <%
                    DictionaryVO dv=new DictionaryVO();
			        dv.setDicType("meetLable");
			        ArrayList dvList=ServiceFactory.getDictionaryService().query(dv, null);
			        int nums=3;
			        if(dvList.size()>0){
			        	nums=0;
                     %>
                     
               <tr>
               <td class="tableaddtitle">会议资料管理员</td>
                   <td class="tableadd_data" colspan="<%=nums %>">
                   
                    <input  name="meetingDetailVO.confDocAdminId" value="${meetingDetailVO.confDocAdminId }" id="confDocAdminId" type="hidden" class="areatran"/>
                     <input type="text" name="meetingDetailVO.confDocAdminName" id="confDocAdminName" class="inputtran" style="cursor:pointer" readonly="readonly" value="${meetingDetailVO.confDocAdminName }" onclick="selectUsers(this,'radio')" />
                   
                   </td>
               <td class="tableaddtitle">会议标签</td>
               <td class="tableadd_data"><c:out value="${meetingDetailVO.info1}"/></td>
               </tr>  
               <%} %> 
               
          <tr>
             <td class="tableaddtitle" >预约人</td>
           <td colspan="3" class="tableadd_data" >${meetingDetailVO.info1}</td>
           
                   
           </tr>
           
          <tr>
            <td class="tableaddtitle">主持人</td>
            <%-- <td colspan="3" class="tableadd_data" title="${meetingDetailVO.participators}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out value="${meetingDetailVO.participators}"/></td> --%>
            <td id="zcr" colspan="3" class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"></td>
          </tr>
          <tr>
            <td class="tableaddtitle">主席台</td>
            <td id="zxt" colspan="3" class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"></td>
          </tr>
          <tr>
            <td class="tableaddtitle">参会人员</td>
            <td id="chz" colspan="3" class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"></td>
          </tr>
          
          <tr style="display: none;">
            <td class="tableaddtitle">参会单位</td>
            <td colspan="3" class="tableadd_data" title="${meetingDetailVO.departmentNames}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"><c:out  value="${meetingDetailVO.departmentNames}"></c:out></td>
          </tr>
               
          <tr>
            <td class="tableaddtitle" style="vertical-align:top;">会议描述</td>
            <td colspan="3" class="tableadd_data" ><textarea name="datepicker" rows="5" class="areatran" id="datepicker" readonly><c:out value="${meetingDetailVO.meetingDescription }"/></textarea></td>
          </tr>
      </table>      
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2" value="关 闭"  onclick="javascript:window.close();"/>
             </td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>