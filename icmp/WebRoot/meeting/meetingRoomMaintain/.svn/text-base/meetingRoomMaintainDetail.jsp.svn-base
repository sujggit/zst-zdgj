<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/common/common.jsp"%>
	<title>会议室维护查看</title>
  </head >
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
   <div class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">会议室维护查看</h5>
      </div>
 	  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
          <tr>
          <td width="16%" class="tableaddtitle">会场名称</td>
          <td width="34%" class="tableadd_data" >
              <c:out value="${meetingRoomMaintainVO.meetingRoomVO.meetingRoomName}"></c:out>   
          </td>
           <td width="16%" class="tableaddtitle">维护日期</td>
           <td width="34%" class="tableadd_data">
           <fmt:formatDate value="${meetingRoomMaintainVO.createTime }"  pattern="yyyy-MM-dd HH:mm"/>
          </td>
          </tr>
          <tr>
           <td class="tableaddtitle">维护人员</td>
           <td class="tableadd_data" colspan="3">
             <c:out value="${meetingRoomMaintainVO.maintainUserName}"></c:out>	
            </td>
            
          </tr>
         
           <c:forEach items="${meetingRoomMaintainVO.meetingRoomMaintainDetailList}" var="meetingRoomMaintain">
          
			<c:if test="${meetingRoomMaintain.type == 1}">
           <tr>
            <td  class="tableaddtitle">设备开机</td>
            <td  class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
           <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis" title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 2}">
           <tr>
            <td  class="tableaddtitle">终端连接</td>
            <td  class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
           <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 3}">
           <tr>
            <td width="20%" class="tableaddtitle">本地图像</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 4}">
           <tr>
            <td width="20%" class="tableaddtitle">本地声音</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 5}">
           <tr>
            <td width="20%" class="tableaddtitle">远端图像</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 6}">
           <tr>
            <td width="20%" class="tableaddtitle">远端声音</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 7}">
           <tr>
            <td width="20%" class="tableaddtitle">双流测试</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle" >问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 8}">
           <tr>
            <td width="20%" class="tableaddtitle">设备关机</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 9}">
           <tr>
            <td width="20%" class="tableaddtitle">网络连接</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述：</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          <c:if test="${meetingRoomMaintain.type == 10}">
           <tr>
            <td width="20%" class="tableaddtitle">IP电话</td>
            <td width="30%" class="tableadd_data">
				<zzst:lable type="equipmentOpenStatus"  value="${meetingRoomMaintain.status}"></zzst:lable>
            </td>
            <td width="30%" class="tableaddtitle">问题描述</td>
				<td class="tableadd_data" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintain.questionDes}">${meetingRoomMaintain.questionDes}
            </td>
          </tr>
          </c:if>
          
          </c:forEach>
          
          <tr>
             <td width="20%" class="tableaddtitle"><span class="fonttsx"></span>其他问题</td>
             <td width="30%" class="tableadd_data"  colspan="3" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis"title="${meetingRoomMaintainVO.description}"><c:out value="${meetingRoomMaintainVO.description}"></c:out>
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