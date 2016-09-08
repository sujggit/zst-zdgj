<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
	</head >
 <body style='OVERFLOW-Y:AUTO;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">会议室查看</h5>
      </div>
         <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议室名称</td>
          <td width="35%" class="tableadd_data" ><c:out value="${meetingRoomVO.meetingRoomName}"></c:out></td>
          <td width="15%" class="tableaddtitle">会议室类型</td>
          <td width="35%" class="tableadd_data">
               <zzst:lable type="meetingRoomType" value="${meetingRoomVO.meetingRoomType}"></zzst:lable>	         
            </td>
        </tr>
        <tr>
          <td class="tableaddtitle">网络拓扑</td>
          <td class="tableadd_data" ><c:out value="${meetingRoomVO.addressVO.name}"></c:out></td>
          <td class="tableaddtitle">所属单位</td>
          <td class="tableadd_data"><c:out value="${meetingRoomVO.departmentVO.title}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">状态</td>
          <td class="tableadd_data" ><zzst:lable type="meetingRoomStatus" value="${meetingRoomVO.status}"></zzst:lable></td>
          <td class="tableaddtitle">管理员</td>
          <td class="tableadd_data"><c:out value="${meetingRoomVO.userVO.name}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">容纳人数</td>
          <td class="tableadd_data" ><c:out value="${meetingRoomVO.capacity }"></c:out></td>
          <td class="tableaddtitle">会议室编号</td>
          <td class="tableadd_data"><c:out value="${meetingRoomVO.roomNO }"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">会议室描述</td>
          <td colspan="3" class="tableadd_data" ><c:out value="${meetingRoomVO.description}"></c:out></td>
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
