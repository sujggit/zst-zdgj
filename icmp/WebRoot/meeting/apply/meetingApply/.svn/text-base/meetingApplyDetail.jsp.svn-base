<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.application.mcuVO.ZZOConfProfileVO" %>
<%@ page import="com.zzst.model.meeting.config.BaseInfoVO"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>
<%@page import="com.zzst.model.enums.ApplyEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="/common/common.jsp"%>
    <title>本地会议查看</title>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  </head>
  <body>
    <div id="contentwrapper" class="contentwrapper">
       <form action="${sys_ctx }/apply/meetingApplyApprove.action?meetingDetailVO.meetingDetailID=${meetingDetailVO.meetingDetailID }" id="addForm" name="addForm" method="post">
        <input type="hidden" name="applyStatus" id="applyStatus" value="${isApply}" /><!-- 审批状态 -->
        <input type="hidden" name="meetingDetailVO.meetingType" id="meetingType" value="${meetingDetailVO.meetingType }" />
        <div id="k1">
	          <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
	            <tr>
	              <td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
	              <td width="35%" class="tableadd_data" >${meetingDetailVO.meetingName }
	              	<input type="hidden" name="meetingDetailVO.meetingName" id="meetingName" value="${meetingDetailVO.meetingName }"/>
	              </td>
	              <td width="15%" class="tableaddtitle"><span>*</span>会议室</td>
	              <td width="35%" class="tableadd_data">${meetingDetailVO.meetingRoomNames }
	              	<input name="meetingDetailVO.meetingRoomNameIDs" id="meetingRoomNameIDs" type="hidden"  value="${meetingDetailVO.meetingRoomNameIDs }"/>
					<input name="meetingDetailVO.meetingRoomNames" type="hidden" value="${meetingDetailVO.meetingRoomNames }" id="meetingRoomNames"/>
       			</td>
               </tr>
               <tr>
                 <td class="tableaddtitle"><span>*</span>开始时间</td>
                 <td class="tableadd_data" >
                 <input name="meetingDetailVO.meetingStartTime" class="inputtran" id="meetingStartTime" readonly="readonly" value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>' style="cursor:default;"/>
                 </td>
                 <td class="tableaddtitle"><span>*</span>结束时间</td>
                 <td class="tableadd_data" >
                   <input name="meetingDetailVO.meetingEndTime" id="meetingEndTime" class="inputtran" readonly="readonly" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/>' style="cursor:default;"/>
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
			         <select id="level"  class="select200 fontstyle" name="meetingDetailVO.grade" disabled="disabled">
			          <zzst:option type="meetingServiceType" value="${meetingDetailVO.grade}" required="false"/>
			         </select>
			         <input name="meetingDetailVO.grade" type="hidden" value="${meetingDetailVO.grade }"/>
		         </tr>  
                    <tr>
                    <%
                    DictionaryVO dv=new DictionaryVO();
			        dv.setDicType("meetLable");
			        ArrayList dvList=ServiceFactory.getDictionaryService().query(dv, null);
			        int nums=3;
                    if(dvList.size()>0){
                    nums=0;
                    }
                     %>
                   <td class="tableaddtitle" >会议资料管理员</td>
                   <td class="tableadd_data" colspan="<%=nums %>">${meetingDetailVO.confDocAdminName }
                     <input name="meetingDetailVO.confDocAdminId" id="confDocAdminId" type="hidden" value="${meetingDetailVO.confDocAdminId }"/>
                     <input name="meetingDetailVO.confDocAdminName" id="confDocAdminName" type="hidden" value="${meetingDetailVO.confDocAdminName }" />
                   </td>
                    <%if(nums==0){ %>
                   <td class="tableaddtitle">会议标签</td>
                   <td class="tableadd_data">
                    <select id="levelinfos"  class="select200 fontstyle" name="meetingDetailVO.info1" disabled="disabled">
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
                   <td class="tableaddtitle" style="vertical-align:top;"><span>*</span>举办单位</td>
                   <td colspan="3" class="tableadd_data" title="${ meetingDetailVO.departmentNames}">
                     <input type="hidden" name="meetingDetailVO.departmentIDs" id="corpID" value="${ meetingDetailVO.departmentIDs}" />
				     <textarea class="areatran" name="meetingDetailVO.departmentNames" id="corpName" readonly="readonly" style="cursor:pointer;width:85%" >${meetingDetailVO.departmentNames}</textarea>
                 </td>
               </tr>
               <tr>
                 <td class="tableaddtitle" style="vertical-align:top;">参与人员</td>
                 <td colspan="3" class="tableadd_data" title="${ meetingDetailVO.participators}">
                 <input name="meetingDetailVO.participatorIDs" id="participatorIDs" type="hidden" value="${ meetingDetailVO.participatorIDs}"/>
                 <textarea class="areatran" name="meetingDetailVO.participators" readonly="readonly" style="cursor:pointer;width:85%" id="participators" >${meetingDetailVO.participators}</textarea>
                </td>
                  </tr>
                  <tr>
                    <td class="tableaddtitle" style="vertical-align:top;" >会议描述</td>
                    <td colspan="3" class="tableadd_data" title="${ meetingDetailVO.meetingDescription}">
                  	<textarea name="meetingDetailVO.meetingDescription" class="areatran" style="width:85%" id="meetingDescription" >${meetingDetailVO.meetingDescription }</textarea>
          		  </td>
                  </tr>
               <c:forEach items="${applyDetailList}" var="adVO" varStatus="state">
			   <c:if test="${state.index>0&&adVO.userID!='none'}">
			     <tr>
		   			<td class="tableaddtitle" style="color: red;" title="${adVO.userID }">${adVO.userID }</td>
					<td class="tableadd_data" style="color: red;white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${adVO.suggestion}">
						<c:out value="${adVO.suggestion}"></c:out>
					</td>
					<td class="tableaddtitle">审批时间</td>
					<td class="tableadd_data" >
						<fmt:formatDate value="${adVO.createTime }"  pattern="yyyy-MM-dd HH:mm"/>
					</td>
				  </tr>
			   </c:if>
	        </c:forEach>
		    <c:if test="${applyDetailVO.status == 2 }">
	        	<tr>		   
					<td class="tableaddtitle" style="color: red;"><span class="fonttsx" ></span>处理意见</td>
					<td class="tableadd_data">
	           			<input id="otherRequire" name="applyDetailVO.suggestion" type="text" value="${applyDetailVO.suggestion}" title="请填写处理意见" style="width: 88%;"/>
					</td>
					<td class="tableaddtitle" style="color: red;"><span class="fonttsx" ></span>是否同意</td>
	            	<td class="tableadd_data">
			    	 	<input type="radio" name="applyDetailVO.status" id="funcType1"
			    			 	value="<%=ApplyEnum.STATUS_INVALID %>"  checked="checked"/>是       
						<input type="radio" name="applyDetailVO.status" id="funcType2"
			     			 	value="<%=ApplyEnum.STATUS_REJECT %>"  />否<br/>
			     		<script>
				    	  	var status = ${applyDetailVO.status };
				    	  	if(status == <%= ApplyEnum.STATUS_REJECT%>){
								document.getElementById("funcType2").checked = "checked";
					    	}
			    	    </script>
			    	</td>
				</tr>
			</c:if>
	      </table>
    	</div>
    	 <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                  <tfoot>
                  </tfoot>
                  <tbody>
                    <tr>
		            <td>
		              <c:if test="${applyDetailVO.status == 2 }">
		            	<input type="button" name="button" id="addButton" value="提 交" onclick="meetingApplyApprove()" class="submit1 radius2"/>
		              </c:if>
		              <c:if test="${meetingDetailVO.status != 15 }">
		            	<input type="button" name="button" id="addButton" value="流 程" onclick="seeFlow('${meetingDetailVO.meetingDetailID}')" class="submit1 radius2"/>
		              </c:if>
		            	<input type="button" name="button2" id="button2" value="取 消"  class="reset1 radius2" onclick="backHistory();"/>
		            </td>
		          </tr>
                  </tbody>
                </table>
            </form>
    </div>
    <script type="text/javascript">
		/**
		*	返回列表
		*/
           function backHistory(){
           	//window.location.href="${sys_ctx}/detail/queryLocalConference.action";
           	window.location.href="${sys_ctx}/apply/manageMeetingApply.action";
           }

           function seeFlow(id){
            	window.showModalDialog("${sys_ctx}/meeting/apply/seeFlow.jsp?applyID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
            }

           $(document).ready(function(){
   			var startTime = document.getElementById('meetingStartTime').value;
     			var endTime = document.getElementById('meetingEndTime').value;

     			var currentTime = new Date().getTime();   
    	        var startTime1 = new Date(document.getElementById('meetingStartTime').value.replace(/\-/g, "\/")).getTime();
                var endTime1 = new Date(document.getElementById('meetingEndTime').value.replace(/\-/g, "\/")).getTime(); 
                
    		    //var sysTimeGap = ${swh_meeting_space_time};
    		    if(startTime1<=currentTime){
    	 		    $("#funcType1").attr("disabled","disabled");
    	 		    $("#funcType2").attr("checked","checked");
    	 		    $("#otherRequire").val("预约的会议开始时间已经过去了！");
                   //alert("开始时间必须晚于当前时间");
                }
   		})
            
 		function meetingApplyApprove(){
 				var depIds = document.getElementById("corpID").value;
 				var actionOld = $('#addForm').attr("action");
 				$('#addForm').attr("action",actionOld+"&depIds="+depIds);
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
 				$('#addForm').submit();			
 		}
   	</script>
  </body>
</html>