<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设备详情</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">告示查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" ><zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentType}"></zzst:lable></td>
          <td width="15%" class="tableaddtitle">设备厂家</td>
          <td width="35%" class="tableadd_data">${equipmentVO.equipmentName}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">设备名称</td>
          <td class="tableadd_data">${equipmentVO.equipmentNO}</td>
          <td class="tableaddtitle">mac</td>
          <td class="tableadd_data">${equipmentVO.mac}</td>
        </tr>
       
        <tr>
          <td class="tableaddtitle">管理IP</td>
          <td class="tableadd_data">${equipmentVO.ip}</td>
          <td class="tableaddtitle">状态</td>
          <td class="tableadd_data" ><zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable></td>
         
        </tr>
         <tr>
          <td class="tableaddtitle">所属会议室</td>
          <td class="tableadd_data" colspan="3">${equipmentVO.meetingRoomVO.meetingRoomName}</td>
         
        </tr>
        <tr>
           <td class="tableaddtitle">管理员</td>
          <td class="tableadd_data">${equipmentVO.userVO.name}</td>
         <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data">${equipmentVO.serialNumber}</td>
        </tr>
       
        <tr>
          <td class="tableaddtitle">维保开始日期</td>
          <td class="tableadd_data" >
          	 <fmt:formatDate value="${equipmentVO.maintenanceStartTime}"  pattern="yyyy-MM-dd HH:mm"/>
          </td>
          <td class="tableaddtitle">期限</td>
          <td class="tableadd_data">
          	 <zzst:lable type="maintenanceStartTime" value="${equipmentVO.maintenanceMonths}"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">资产编号</td>
          <td class="tableadd_data" >${equipmentVO.equipmentIdentifier}</td>
           <td class="tableaddtitle">启用时间</td>
          <td class="tableadd_data" ><fmt:formatDate value="${equipmentVO.createDate}"  pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle">设备描述</td>
          <td colspan="3" class="tableadd_data" >${equipmentVO.description}</td>
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
