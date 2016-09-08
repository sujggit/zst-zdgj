<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <title>会议费用详情 </title>
</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
    <%
      String meetingName=request.getParameter("meetingName");
	  //判断浏览器是IE还是google或者其他；若是IE则UTF-8为乱码，若是google则GB2312是乱码
	  String ie = request.getHeader("User-Agent");
	  if(ie.indexOf("MSIE")!=-1){
		  meetingName = new String(meetingName.getBytes("ISO8859-1"), "gb2312");
	  }else{
		  meetingName = new String(meetingName.getBytes("ISO8859-1"), "UTF-8");
	  }
	  String meetingDetailId = new String(request.getParameter("meetingDetailId").getBytes("ISO8859-1"),"gb2312");
    %>
	<div id="basicform" class="contentwrapper">
		<form action="${sys_ctx }/meetingCost/meetingCostList.action" method="post" name="form" id="form">
		  <input type="hidden" name="meetingDetailCostVO.createUserID" id="createUserID" value="${sys_userSession.userID}"/>
          <div class="contenttitle2">
            <h5 class="fwb fl10">会议费用详情</h5>
          </div>
          <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td class="tableaddtitle">会议名称</td>
	          <td class="tableadd_data" colspan="3"><%=meetingName%></td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">创建人</td>
	          <td class="tableadd_data" >
	            <c:out value="${meetingDetailCostVO.userVO.name }" />
	          </td>
	          <td class="tableaddtitle">创建时间</td>
	          <td class="tableadd_data" >
	            <fmt:formatDate value="${meetingDetailCostVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/>
	          </td>
	        </tr>
	        <c:forEach items="${mcList}" var="meetingDetailCostVO" varStatus="state">
	        <tr>
	          <td class="tableaddtitle"><c:out value="${meetingDetailCostVO.costItem }" />（人*天）</td>
	          <td class="tableadd_data" >
	            <input type="hidden" id="costValue${state.index+1}" name="meetingDetailCostVO.costValue" value="${meetingDetailCostVO.costValue }"/>
	            <c:out value="${meetingDetailCostVO.cout }" />
	            <!--  <span id="unit" style="margin-right: 50px"> （单位：个） </span>-->
	          </td>
	          <td class="tableaddtitle">费用（元/天）</td>
	          <td class="tableadd_data" >${meetingDetailCostVO.costValue }</td>
	        </tr>
          </c:forEach>
          </table>
          <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
                </td>
             </tr>
           </tbody>
      </table>
    </form>
  </div>
</body>
</html>