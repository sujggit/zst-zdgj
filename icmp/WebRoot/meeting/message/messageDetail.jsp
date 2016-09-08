<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>告警详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">告警信息查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">消息标题</td>
          <td width="35%" class="tableadd_data" >${ifVO.title}</td>
          <td width="15%" class="tableaddtitle">消息内容</td>
          <td width="35%" class="tableadd_data">${ifVO.content}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">告警类型</td>
          <td class="tableadd_data" >
          	<zzst:lable type="infoType" value="${ifVO.infoType}"></zzst:lable> 
          </td>
          <td class="tableaddtitle">告警级别</td>
          <td class="tableadd_data">${ifVO.rank}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">告警时间</td>
          <td class="tableadd_data" ><fmt:formatDate value="${ifVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
          <td class="tableaddtitle">告警状态</td>
          <td class="tableadd_data">${ifVO.status}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">推送状态</td>
          <td class="tableadd_data" >${ifVO.scanStatus}</td>
          <td class="tableaddtitle">所属会议</td>
          <td class="tableadd_data">${ifVO.meetingDetailId}</td>
        </tr>
        
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