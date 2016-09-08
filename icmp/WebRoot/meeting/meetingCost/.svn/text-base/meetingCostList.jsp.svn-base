<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>会议费用列表</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/meetingCost/meetingCostList.action" id="pageform" name="pageform" method="post">
    <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" >
            <input type="text" name="meetingDetailCostVO.meetingDetailVO.meetingName" class="inputtran" value="${meetingDetailCostVO.meetingDetailVO.meetingName}" id="meetingName"/>
          </td>
          <td width="15%" class="tableaddtitle">会议开始时间</td>
          <td width="35%" class="tableadd_data" >
            <input type="text" name="meetingDetailCostVO.meetingDetailVO.meetingStartTime" class="inputtran" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"
              value='<fmt:formatDate value="${meetingDetailCostVO.meetingDetailVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/>' id="meetingStartName"/>
          </td>
          <td class="tableaddtitle">
              <input type="button" class="stdbtn mlr10" value="查 询" onclick="javascript:queryForm()" />
          </td>
        </tr>
      </table>

      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
      
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <!--  <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="exportMeetingCostInfo();"> 导出</a></h5>-->
      </div>
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="66px" class="head1">序号</th>
            <th width="%" class="head1">会议名称</th>
            <th width="156px" class="head1">会议开始时间</th>
            <th width="156px" class="head1">会议结束时间</th>
            <th width="128px" class="head1">费用（元）</th>
            <th width="128px" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${mcList}" var="meetingDetailCostVO" varStatus="state">
              <tr >
             	<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                <td><c:out value="${meetingDetailCostVO.meetingDetailVO.meetingName}"/></td>
                <td><fmt:formatDate value="${meetingDetailCostVO.meetingDetailVO.meetingStartTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${meetingDetailCostVO.meetingDetailVO.meetingEndTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
	            <c:if test="${meetingDetailCostVO.costValue == 0}">
	            	<td class="ac fontstyle ">&nbsp;</td>
	            </c:if>
	            <c:if test="${meetingDetailCostVO.costValue != 0}">
	            	<td>&nbsp;<c:out value="${meetingDetailCostVO.costValue}"/></td>
	            </c:if>
	            <td class="alc">
	            	<c:if test="${meetingDetailCostVO.createUserId != null}">
	            	  <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="detail('${meetingDetailCostVO.meetingDetailId}','${meetingDetailCostVO.meetingDetailVO.meetingName}')" title="查看费用详情">查看 </a>
	            	  <a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modify('${meetingDetailCostVO.meetingDetailId}','${meetingDetailCostVO.meetingDetailVO.meetingName}')" title="修改费用明细">修改 </a>
	            	  <!--  <a onclick="del('${meetingDetailCostVO.meetingDetailId}')" title="删除"> | 删除 </a>-->
	            	</c:if>
	            	<c:if test="${meetingDetailCostVO.createUserId == null}">
	            	  <a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="meetingCostSetting('${meetingDetailCostVO.meetingDetailId}','${meetingDetailCostVO.meetingDetailVO.meetingName}')" title="添加费用"> 费用 </a>
	            	</c:if>
	            </td>
              </tr>
	       </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
    </div>
  </form>
  <script>
  	function queryForm(){
  		document.pageform.currentPage.value=1;
  		document.getElementById("pageform").submit();
  	}

  	function detail(meetingDetailId,meetingName){
  		window.showModalDialog("${sys_ctx }/meetingCost/meetingCostDetail.action?meetingDetailId="+meetingDetailId+"&meetingName="+meetingName,window,'dialogWidth=660px;dialogHeight=420px;');
  	}

  	function modify(meetingDetailId,meetingName){
  		location.href="${sys_ctx }/meetingCost/modifyMeetingCostBefore.action?meetingDetailId="+meetingDetailId+"&meetingName="+meetingName;
  	}

  	function meetingCostSetting(meetingDetailId,meetingName){
  		location.href="${sys_ctx }/meetingCost/addMeetingCostBefore.action?meetingDetailId="+meetingDetailId+"&meetingName="+meetingName;
  	}
  </script>
 </body>
</html>