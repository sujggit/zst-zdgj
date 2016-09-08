<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/common/common.jsp"%>
	<title>会场设备维护记录详情</title>
  </head >
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
   <div class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会场设备维护记录详情</h5>
      </div>
 	  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
 	    <tr>
			<td width="15%" class="tableaddtitle">会议名称</td>
			<td width="35%" class="tableadd_data" title="${meetingRoomMaintainVO.meetingDetailVO.meetingName }">
			  ${meetingRoomMaintainVO.meetingDetailVO.meetingName }
			</td>
			<td width="15%" class="tableaddtitle">会场名称</td>
			<td width="35%" class="tableadd_data" title="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName }">
			  ${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName }
			</td>
		</tr>
        <tr>
          <td class="tableaddtitle">会议开始时间</td>
          <td class="tableadd_data">
              <fmt:formatDate value="${meetingRoomMaintainVO.meetingDetailVO.meetingStartTime }" pattern="yyyy-MM-dd HH:mm"/>   
          </td>
          <td class="tableaddtitle">会议结束时间</td>
          <td class="tableadd_data">
           <fmt:formatDate value="${meetingRoomMaintainVO.meetingDetailVO.meetingEndTime }" pattern="yyyy-MM-dd HH:mm"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">检查人员</td>
          <td class="tableadd_data">
            <c:out value="${meetingRoomMaintainVO.maintainUserName}"></c:out>	
          </td>
          <td class="tableaddtitle">检查时间</td>
          <td class="tableadd_data">
            <fmt:formatDate value="${meetingRoomMaintainVO.createTime }" pattern="yyyy-MM-dd HH:mm"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">检查项</td>
          <td class="tableadd_data" title="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.maintainName}">
            <c:out value="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.maintainName}"></c:out>	
          </td>
          <td class="tableaddtitle">状态</td>
          <td class="tableadd_data" title="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.description}">
            ${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.description}
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">问题描述</td>
          <td class="tableadd_data" colspan="3" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.questionDes}">
            ${meetingRoomMaintainVO.meetingRoomMaintainDetailVO.questionDes}
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
              </td>
          </tr>
        </tbody>
      </table>
      </div>
	</body>
</html>