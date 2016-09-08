<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>会议资料管理列表</title>
  <script type="text/javascript">
function onloadWindow(){
window.location.reload();
}
</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/file/manageMeetingFileList.action" id="pageform" name="pageform" method="post">
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

      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="onloadWindow();"> 刷新</a></h5>
      </div>
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">会议名称</th>
            <th width="122px" class="head1">开始时间</th>
            <th width="122px" class="head1">结束时间</th>
            <th width="69px" class="head1">会议类型</th>
            <th width="82px" class="head1">会议状态</th>
            <th width="222px" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${lst_conference}" var="meedingDetailVO" varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td title="${meedingDetailVO.meetingName}"><c:out value="${meedingDetailVO.meetingName}"/></td>
	            <td title="${meedingDetailVO.meetingStartTime}"><fmt:formatDate value="${meedingDetailVO.meetingStartTime }" pattern="yyyy-MM-dd HH:mm"/></td>
	            <td title="${meedingDetailVO.meetingEndTime}"><fmt:formatDate value="${meedingDetailVO.meetingEndTime }" pattern="yyyy-MM-dd HH:mm"/></td>
	            <td><zzst:lable type="meetingType" value="${meedingDetailVO.meetingType}"></zzst:lable></td>
	            <td>
					<c:if test="${meetingDetailVO.status==0}">待审批</c:if>
		            <c:if test="${meetingDetailVO.status==13}">审批中</c:if>
		            <c:if test="${meetingDetailVO.status==14}">审批不通过</c:if>
		            <c:if test="${meetingDetailVO.status==15}">审批被撤销</c:if>
		            <zzst:lable type="MeetingStatus" value="${meedingDetailVO.status}"></zzst:lable></td>	
	            <td class="alc">
	            	<c:if test="${meedingDetailVO.status!=11}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="detail('${meedingDetailVO.meetingDetailID}','${meedingDetailVO.meetingType}')" title="查看">查看</a>
	            	</c:if>
	            	<c:if test="${meedingDetailVO.endTDNumber==1}">
        	          <a class="funcOper <%= FuncEnum.FUNC_NO_UPLOAD%>" onclick="fileuploadload('${meedingDetailVO.meetingName}','${meedingDetailVO.meetingDetailID}');">  上传</a>
                    </c:if>
                    <!--  <a onclick="download('${meedingDetailVO.meetingName}','${meedingDetailVO.meetingDetailID}');">| 下载</a> -->
                    <c:if test="${meedingDetailVO.startTDNumber==2}">
	            		<a class="funcOper <%= FuncEnum.FUNC_NO_UPDATEIMPOWERTREE%>" onclick="updateImpowerTree('${meedingDetailVO.meetingDetailID}','${meedingDetailVO.meetingName}');" title="批量授权">  批量授权</a>
	            	</c:if>
	            	<!-- 
	            	<c:if test="${meedingDetailVO.endTDNumber==1}">
        	          <a class="funcOper <%= FuncEnum.FUNC_NO_RECORDRELATION%>" onclick="recordRelation('${meedingDetailVO.meetingName}','${meedingDetailVO.meetingDetailID}');">  视频关联</a>
                    </c:if>
                     -->
	            </td>
              </tr>
	       </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
    </div>
  </form>
  <script type="text/javascript">

     function updateImpowerTree(meetingDetailID,meetingName){
    	 window.location.href = "${sys_ctx}/meeting/File/checkFileImpowerBatch.jsp?id="+meetingDetailID+"&meetingName="+meetingName;
		//window.location.href  ="${sys_ctx}/func/queryCheck.action?roleVO.roleID=" + id;
		//window.showModalDialog("${sys_ctx}/func/getFuncList.action?roleVO.roleID=" + id,window,'dialogWidth=600px;dialogHeight=620px;');
	}
     
     //详细页面
     function detail(meetingID,meetingTpyes){
         if(meetingTpyes==1){
           window.showModalDialog("${sys_ctx }/detail/generalDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=700px;dialogHeight=470px;');
         }else if(meetingTpyes==2){
           window.showModalDialog("${sys_ctx }/detail/vedioDetail.action?meetingDetailID="+meetingID,window,'dialogWidth=700px;dialogHeight=470px;');
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

	
	 function fileuploadload(meetingName,meetingId){
		 var result = window.showModalDialog("${sys_ctx }/meeting/File/fileUpload.jsp?meetingName="+meetingName+"&meetingDetailID="+meetingId,window,'dialogWidth=700px;dialogHeight=470px;');
    	 //window.showModalDialog("${sys_ctx }/meeting/conferenceManager/upload.jsp",window,'dialogWidth=600px;dialogHeight=470px;');
		 if( result == "1" ){
				window.location.href = "${sys_ctx }/file/manageMeetingFileList.action";
		 }
	 }
    /**                   
	function download(meetingName,meetingId){
      window.showModalDialog("${sys_ctx }/detail/getdownloadlist.action?meetingName="+meetingName+"&meetingDetailID="+meetingId,window,'dialogWidth=600px;dialogHeight=470px;');
      //location.href="${sys_ctx }/meeting/conferenceManager/download.jsp";
      //window.showModalDialog("${sys_ctx }/meeting/conferenceManager/download.jsp",window,'dialogWidth=600px;dialogHeight=470px;');    
    }
	function exportMeetingInfo(){
		document.getElementById('pageform').action="${sys_ctx}/detail/exportQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx }/detail/queryLocalConference.action";
	}
    */
    
    function recordRelation(meetingName,meetingId){
    	window.open("${sys_ctx }/file/beforeRecordRelation.action?meetingDetailID="+meetingId+"&meetingName="+meetingName,"hhh","width:700px,height:470px,scrollbars=yes");
    }
  </script>
 </body>
</html>