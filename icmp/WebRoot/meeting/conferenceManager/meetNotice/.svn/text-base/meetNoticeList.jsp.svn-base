<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>公告管理列表</title>
  <script type="text/javascript">
     function beforeAddMeeting(){
         window.location.href = "${sys_ctx }/messageNotice/addMessageNoticeBefore.action";
     }
     //删除
     function deleteForm(meetingName,meetingID){
          if(confirm("确定删除 "+meetingName+" 信息吗？")){
              window.location.href="${sys_ctx }/messageNotice/delMessageNotice.action?messageContent.id="+meetingID;
          }
     }
     
     //详细页面
     function detail(meetingID){
        
           window.showModalDialog("${sys_ctx }/messageNotice/datilMessageNotice.action?messageContent.id="+meetingID,window,'dialogWidth=600px;dialogHeight=470px;');
           
     }
       
     //修改updateBefore
     function modify(meetingID){
        window.location.href="${sys_ctx }/messageNotice/updateBefore.action?messageContent.id="+meetingID;
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
		}
	}
	
	//添加服务
	function addService(id,name){
		window.location.href = "${sys_ctx }/meetingService/serviceAddBefore.action?avicServiceVO.meetingDetailID="+id;
	}

	function exportMeetingInfo(){
		document.getElementById('pageform').action="${sys_ctx}/detail/exportQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx }/detail/queryLocalConference.action";
	}
  
    function selectUsers(thisDom){
	              var userParameters = {
	                  methodName:'getReturnUserMethod',
	                  selectType:'radio'
	              }
	             creatUserSelect(thisDom,userParameters); 
	        }
	        
	 function getReturnUserMethod(userArray){
	              var userID="";
	              var loginName="";
	              var userLength = userArray.length;
	              for(var i=0;i<userLength;i++){
	            	  userID=userArray[i].userID;
	            	  loginName=userArray[i].userName;
	              }
	          	$("#userID").attr("value",userID);
            	$("#names").attr("value",loginName);
	         }
                          
  </script>
</head>
<body>
  <form action="${sys_ctx }/messageNotice/queryAll.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">公告标题</td>
          <td width="35%" class="tableadd_data" >
          <input type="text" name="messageContentquery.messageSubject" class="inputtran" value="${messageContentquery.messageSubject }" id="meetingName"/></td>
          <td width="15%" class="tableaddtitle" >发布人</td>
          <td width="35%" class="tableadd_data" >
                <input type="hidden" name="messageContentquery.flowIdCont" id="userID" class="" value="${messageContentquery.flowIdCont}" />
	          	<input class="inputtran" name="messageContentquery.flowType" id="names" readonly="readonly"  onclick="selectUsers(this);" value="${messageContentquery.flowType}" title="请选择" />
          </td>
          <td rowspan="2" class="tableaddtitle">
              <input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">开始时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="messageContentquery.insertTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value='<fmt:formatDate value="${messageContentquery.insertTime}"  pattern="yyyy-MM-dd"/>'/></td>
          <td class="tableaddtitle">结束时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="messageContentquery.sendTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value='<fmt:formatDate value="${messageContentquery.sendTime}"  pattern="yyyy-MM-dd"/>'/></td>
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
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;" onclick="beforeAddMeeting();"> 添 加</a></h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%"  class="head1">序号</th>
            <th width="19%" class="head1">公告标题</th>
            <th width="14%" class="head1">发布时间</th>
            <th width="14%" class="head1">发布人</th>
            <th width="14%" class="head1">公告内容</th>
            <th width="9%"  class="head1">状态</th>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${listMessageContent}" var="message" 	varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td>&nbsp;<c:out value="${message.messageSubject }"></c:out></td>
	            <td>&nbsp;<fmt:formatDate value="${message.insertTime }"  pattern="yyyy-MM-dd"/></td>
	            <td>&nbsp;${message.flowIdCont }</td>
	            <td>&nbsp;${message.messageBody }</td>	
	            <td>&nbsp;
	            <c:if test="${message.ifSuccess==0}">草稿</c:if>
	            <c:if test="${message.ifSuccess==1}">发布</c:if>
	            <c:if test="${message.ifSuccess==2}">已同步</c:if>
	            </td>
	            <td class="alc">
	            <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="detail('${message.id}')" title="查看">查看</a>
	            <c:if test="${message.ifSuccess==0}"> <a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modify('${message.id}')" title="修改">修改</a></c:if>
	            <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="deleteForm('${message.messageSubject}','${message.id }')" title="删除">  删除 </a>
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