<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>查看设备资料相关信息</title>
		<%@include file="/common/common.jsp" %>
	</head>
	<body style="OVERFLOW:AUTO;OVERFLOW-X:HIDDEN">
		<div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">查看设备资料相关信息</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%" class="tableaddtitle">文件名称</td>
	          <td width="35%" class="tableadd_data" title="${uploadFileVO.fileName}">${uploadFileVO.fileName}</td>
	          <td width="15%" class="tableaddtitle">设备名称</td>
	          <td width="35%" class="tableadd_data" title="${uploadFileVO.equipmentVO.equipmentName}">
	            ${uploadFileVO.equipmentVO.equipmentName}
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">设备类型</td>
	          <td class="tableadd_data">
	            <zzst:lable type="equipmentType" value="${uploadFileVO.equipmentVO.equipmentType}"></zzst:lable>
	          </td>
	          <td class="tableaddtitle">显示名称</td>
	          <td class="tableadd_data" title="${uploadFileVO.equipmentVO.equipmentNO }">${uploadFileVO.equipmentVO.equipmentNO }</td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">所属会议室</td>
	          <td class="tableadd_data" title="${uploadFileVO.equipmentVO.meetingRoomVO.meetingRoomName }">
	            ${uploadFileVO.equipmentVO.meetingRoomVO.meetingRoomName}
	          </td>
	          <td class="tableaddtitle">设备管理员</td>
	          <td class="tableadd_data" title="${uploadFileVO.equipmentVO.userVO.name}">
	            ${uploadFileVO.equipmentVO.userVO.name}
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">设备IP</td>
	          <td class="tableadd_data" title="${uploadFileVO.equipmentVO.ip }">
	            ${uploadFileVO.equipmentVO.ip}
	          </td>
	          <td class="tableaddtitle">设备状态</td>
	          <td class="tableadd_data">
	            <zzst:lable type="equipmentStatus" value="${uploadFileVO.equipmentVO.status}"></zzst:lable>
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