<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
  <title>我的会议</title>
  <script type="text/javascript">
     function beforeAddMeeting(){
         window.location.href = "${sys_ctx }/detail/generalAddBefor.action";
     }
     //删除
     function deleteForm(meetingName,meetingID){
          if(confirm("确定删除 "+meetingName+" 会议吗？")){
              window.location.href="${sys_ctx }/detail/mydeleteConference.action?meetingDetailID="+meetingID;
          }
     }
     //详细页面
     function detail(meetingID,meetingTpyes){
           if(meetingTpyes==1){
           window.showModalDialog("${sys_ctx }/detail/generalDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=600px;dialogHeight=470px;');
           }else if(meetingTpyes==2){
           window.showModalDialog("${sys_ctx }/detail/vedioDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=600px;dialogHeight=470px;');
           }
     }
       
     //修改
     function modify(meetingID,types){
          if(types == 1){
           window.location.href="${sys_ctx }/detail/mybeforeModifyConference.action?meetingDetailID="+meetingID;
           }else if(types==2){
            window.location.href="${sys_ctx }/detail/mybeforeModifyVedioConference.action?meetingDetailID="+meetingID;
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
			window.location.href = "${sys_ctx }/detail/endMyMeeting.action?meetingDetailVO.meetingDetailID="+meetingDetailID;
			//McuDwrMethod.deleteConf(meetingDetailID, function(){window.location.reload();});
		}
	}
	
	//添加服务
	function addService(id,name){
		window.location.href = "${sys_ctx }/meetingService/serviceAddBefore.action?avicServiceVO.meetingDetailID="+id;
	}

	function exportMeetingInfo(){
		document.getElementById('pageform').action="${sys_ctx}/detail/exportMyConQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx }/detail/queryMyConference.action";
	}

    /**                   
	function download(meetingName,meetingId){
      //alert(1111);
      window.showModalDialog("${sys_ctx }/detail/getdownloadlist.action?meetingName="+meetingName+"&meetingDetailID="+meetingId,window,'dialogWidth=600px;dialogHeight=470px;');
      //location.href="${sys_ctx }/meeting/conferenceManager/download.jsp";
      //window.showModalDialog("${sys_ctx }/meeting/conferenceManager/download.jsp",window,'dialogWidth=600px;dialogHeight=470px;');    
    }  
    */
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/detail/queryMyConference.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" ><input maxlength="25" type="text" name="meetingDetailVO.meetingName" class="inputtran" value="${meetingDetailVO.meetingName}" id="meetingName"/></td>
          <td width="15%" class="tableaddtitle" >会议状态</td>
          <td width="35%" class="tableadd_data" >
          	<select name="meetingDetailVO.status" id="status"  class="select200 fontstyle">
            	<zzst:option type="meetingStatus" value="${meetingDetailVO.status}" required="false"/>
			  </select>
          </td>
          <td rowspan="2" class="tableaddtitle">
              <input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">开始时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="meetingDetailVO.meetingStartTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'/></td>
          <td class="tableaddtitle">结束时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="meetingDetailVO.meetingEndTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${meetingDetailVO.meetingEndTime}"  pattern="yyyy-MM-dd HH:mm"/>'/></td>
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
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportMeetingInfo();"> 导出</a></h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="19%" class="head1">会议名称</th>
            <th width="14%" class="head1">开始时间</th>
            <th width="14%" class="head1">结束时间</th>
            <th width="9%" class="head1">会议类型</th>
            <th width="9%" class="head1">会议状态</th>
            <th width="9%" class="head1">预约人</th>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${lst_conference}" var="meetingDetailVO" varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td>&nbsp;<c:out value="${meetingDetailVO.meetingName}"/></td>
	            <td>&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <td>&nbsp;<fmt:formatDate value="${meetingDetailVO.meetingEndTime }"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <td>&nbsp;<zzst:lable type="meetingType" value="${meetingDetailVO.meetingType}"></zzst:lable></td>
	            <td>&nbsp;<c:if test="${meetingDetailVO.status==0}">待审批</c:if><c:if test="${meetingDetailVO.status==13}">审批中</c:if><c:if test="${meetingDetailVO.status==14}">审批不通过</c:if><c:if test="${meetingDetailVO.status==15}">审批被撤销</c:if><zzst:lable type="MeetingStatus" value="${meetingDetailVO.status}"></zzst:lable>	
	            <td>&nbsp;${meetingDetailVO.fullName}</td>
	            <td class="alc">
	            	<c:if test="${meetingDetailVO.status!=11}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="detail('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingType}')" title="查看">查看</a>
	            	</c:if>
	            	<c:if test="${sys_userSession.userID == meetingDetailVO.createUserID}">
	            	  <c:if test="${meetingDetailVO.status!=3&&meetingDetailVO.status!=2&&meetingDetailVO.status!=11}">
	                   <c:if test="${isApplyGener==meetingDetailVO.meetingType&&meetingDetailVO.status==0}">
	                	<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modify('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingType}')" title="修改"> 修改</a>
	                   </c:if>
	                   <c:if test="${isApplyVideo==meetingDetailVO.meetingType&&meetingDetailVO.status==0}">
	                	<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modify('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingType}')" title="修改"> 修改</a>
	                   </c:if>
	                   <c:if test="${isApplyGener!=meetingDetailVO.meetingType&&isApplyVideo!=meetingDetailVO.meetingType}">
	                	<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modify('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingType}')" title="修改"> 修改</a>
	                   </c:if>
	                  </c:if>
	                </c:if>
	            	<c:if test="${meetingDetailVO.status!=2&&meetingDetailVO.status!=11}">
	            	 <c:if test="${sys_userSession.userID==meetingDetailVO.createUserID }">
		                <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="deleteForm('${meetingDetailVO.meetingName}','${meetingDetailVO.meetingDetailID}')" title="删除">删除</a>
	                 </c:if>
	            	</c:if>
	            	<c:if test="${meetingDetailVO.status==2}">
	            	<c:if test="${sys_userSession.userID==meetingDetailVO.createUserID }">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_ENDMEETING%>" onclick="endMeeting('${meetingDetailVO.meetingDetailID}')" title="结束会议">结束会议</a>
	            	</c:if>
	            	</c:if>
	            </td>
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