<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>会场维护详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会场维护查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" >${meetingName}</td>
          <td width="15%" class="tableaddtitle">会场名称</td>
          <td width="35%" class="tableadd_data">${meetingRoomName}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">检查人</td>
          <td class="tableadd_data" >${maintainUserName}</td>
          <td class="tableaddtitle">检查时间</td>
          <td class="tableadd_data"><fmt:formatDate value="${createTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <c:forEach items="${mrList}" var="dictionaryVO1" varStatus="state1">
        <tr>
          <td class="tableaddtitle"><c:out value="${dictionaryVO1.meetingRoomMaintainDetailVO.maintainName }"/></td>
          <td class="tableadd_data" colspan="3">${dictionaryVO1.meetingRoomMaintainDetailVO.description}
          <br/>
          <c:out value="${dictionaryVO1.meetingRoomMaintainDetailVO.questionDes}"/>					
          </td>
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
    </div>
</body>
</html>