<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>查看会议资料相关信息</title>
		<%@include file="/common/common.jsp" %>
	</head>
	<body style="OVERFLOW:AUTO;OVERFLOW-X:HIDDEN">
		<div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">查看会议资料相关信息</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%" class="tableaddtitle">会议名称</td>
	          <td width="35%" class="tableadd_data" title="${uploadFileVO.meetingDetailVO.meetingName }">${uploadFileVO.meetingDetailVO.meetingName }</td>
	          <td width="15%" class="tableaddtitle" style="vertical-align:top;">文件名称</td>
	          <td width="35%" class="tableadd_data" title="${uploadFileVO.fileName}">${uploadFileVO.fileName}</td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">会议开始时间</td>
	          <td class="tableadd_data" title="${uploadFileVO.meetingDetailVO.meetingStartTime }">
	            <fmt:formatDate value="${uploadFileVO.meetingDetailVO.meetingStartTime}" pattern="yyyy-MM-dd HH:mm"/>
	          </td>
	          <td class="tableaddtitle" style="vertical-align:top;">会议结束时间</td>
	          <td class="tableadd_data" title="${uploadFileVO.meetingDetailVO.meetingEndTime}">
	            <fmt:formatDate value="${uploadFileVO.meetingDetailVO.meetingEndTime}" pattern="yyyy-MM-dd HH:mm"/>
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">发布人</td>
	          <td class="tableadd_data" title="${uploadFileVO.userVO.name }">${uploadFileVO.userVO.name}</td>
	          <td class="tableaddtitle" style="vertical-align:top;">文件发布时间</td>
	          <td class="tableadd_data" title="${uploadFileVO.createTime}">
	            <fmt:formatDate value="${uploadFileVO.createTime}" pattern="yyyy-MM-dd HH:mm"/>
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle" style="vertical-align:top;">可下载人员</td>
	          <td colspan="3" class="tableadd_data" title="${uploadFileVO.uploadFileImpowerVO.description}">${uploadFileVO.uploadFileImpowerVO.description}</td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle" style="vertical-align:top;">会议描述</td>
	          <td colspan="3" class="tableadd_data" title="${uploadFileVO.meetingDetailVO.meetingDescription}">
	            <textarea name="datepicker" rows="5" class="areatran" id="datepicker" readonly="readonly"><c:out value="${uploadFileVO.meetingDetailVO.meetingDescription }"/></textarea>
	          </td>
	        </tr>
	      </table>
	      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	        <tfoot>
	        </tfoot>
	        <tbody>
	          <tr>
	            <td><input type="reset" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
	              </td>
	          </tr>
	        </tbody>
	      </table>
		</div>
	</body>
</html>