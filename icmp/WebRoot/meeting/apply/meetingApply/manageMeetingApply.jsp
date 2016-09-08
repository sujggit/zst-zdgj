<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>会议预约审批管理列表</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/apply/manageMeetingApply.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" ><input type="text" name="meetingDetailVO.meetingName" class="inputtran" value="${meetingDetailVO.meetingName}" id="meetingName"/></td>
          <td width="15%" class="tableaddtitle" >会议状态</td>
          <td width="35%" class="tableadd_data" >
          	<select name="meetingDetailVO.status" id="status"  class="select200 fontstyle">
          	  <option value="-2147483648">请选择</option>
          	  <option value="0" <c:if test="${meetingDetailVO.status==0}">selected</c:if> >待审批</option>
          	  <option value="13" <c:if test="${meetingDetailVO.status==13}">selected</c:if> >审批中</option>
          	  <option value="14" <c:if test="${meetingDetailVO.status==14}">selected</c:if> >审批不通过</option>
          	  <option value="15" <c:if test="${meetingDetailVO.status==15}">selected</c:if> >审批被撤销</option>
              <zzst:option type="meetingStatus" value="${meetingDetailVO.status}" required="true"/>
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

      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <!--  <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="exportMeetingInfo();"> 导出</a></h5>-->
      </div>
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">会议名称</th>
            <th width="122px" class="head1">开始时间</th>
            <th width="122px" class="head1">结束时间</th>
            <th width="69px" class="head1">申请人</th>
            <th width="122px" class="head1">申请时间</th>
            <th width="82px" class="head1">会议类型</th>
            <th width="82px" class="head1">会议状态</th>
            <th width="122px" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${lst_conference}" var="meetingDetailVO" varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td title="${meetingDetailVO.meetingName}"><c:out value="${meetingDetailVO.meetingName}"/></td>
	            <td title="${meetingDetailVO.meetingStartTime}"><fmt:formatDate value="${meetingDetailVO.meetingStartTime }" pattern="yyyy-MM-dd HH:mm"/></td>
	            <td title="${meetingDetailVO.meetingEndTime}"><fmt:formatDate value="${meetingDetailVO.meetingEndTime }" pattern="yyyy-MM-dd HH:mm"/></td>
	            <td title="${meetingDetailVO.createUserName}"><c:out value="${meetingDetailVO.createUserName}"/></td>
	            <td title="${meetingDetailVO.createTime}"><fmt:formatDate value="${meetingDetailVO.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
	            <td><zzst:lable type="meetingType" value="${meetingDetailVO.meetingType}"></zzst:lable></td>
	            <td><c:if test="${meetingDetailVO.status==0}">待审批</c:if><c:if test="${meetingDetailVO.status==13}">审批中</c:if><c:if test="${meetingDetailVO.status==14}">审批不通过</c:if><c:if test="${meetingDetailVO.status==15}">审批被撤销</c:if>
	              <zzst:lable type="MeetingStatus" value="${meetingDetailVO.status}"></zzst:lable>
	            </td>	
	            <td class="alc">
	            	<c:if test="${meetingDetailVO.status!=11}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="applyDetail('${meetingDetailVO.meetingDetailID}','${meetingDetailVO.meetingType}')" title="查看">查看</a>
	            	</c:if>
	            	<c:if test="${meetingDetailVO.applyDetailVO.status==2&&(meetingDetailVO.status==0||meetingDetailVO.status==13)}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_APPLYAPPROVE%>" onclick="applyApprove('${meetingDetailVO.meetingDetailID}')" title="审批">  <span style="color: #f00">审批</span></a>
	            	</c:if>
	            	<c:if test="${meetingDetailVO.status==0&&meetingDetailVO.createUserID==sys_userSession.userID}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="applyDel('${meetingDetailVO.meetingDetailID}')" title="撤销申请">撤销申请</a>
	            	</c:if>
	            </td>
              </tr>
	       </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
    </div>
  </form>
  <script type="text/javascript">
  
     //详细页面
     function detail(meetingID,meetingTpyes){
         if(meetingTpyes==1){
           window.showModalDialog("${sys_ctx }/detail/generalDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=700px;dialogHeight=470px;');
         }else if(meetingTpyes==2){
           window.showModalDialog("${sys_ctx }/detail/vedioDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=700px;dialogHeight=470px;');
         }
     }

     //审批
     function applyApprove(id) {
		window.location.href = "${sys_ctx}/apply/meetingApplyDetail.action?meetingDetailVO.meetingDetailID="+id+"&type=1";
	 }

   //查看详情
     function applyDetail(id,meetingTpye) {
		window.location.href = "${sys_ctx}/apply/meetingApplyDetail.action?meetingDetailVO.meetingDetailID="+id+"&type=2";
	 }

	 //撤销申请
	 function applyDel(id){
		 if(!window.confirm("是否确认撤销申请？")) return;
			window.location.href="${sys_ctx}/apply/meetingApplyDel.action?meetingDetailVO.meetingDetailID="+id;
	}
  </script>
 </body>
</html>