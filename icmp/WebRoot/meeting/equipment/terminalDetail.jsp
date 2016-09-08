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
        <h5 class="fwb fl10">终端查看</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" ><zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentType}"></zzst:lable></td>
          <td width="15%" class="tableaddtitle">设备厂家</td>
          <td width="35%" class="tableadd_data">${equipmentVO.equipmentName}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">设备型号</td>
          <td class="tableadd_data" >  <zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentModel}"></zzst:lable></td>
          <td class="tableaddtitle">设备名称</td>
          <td class="tableadd_data">${equipmentVO.equipmentNO}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">管理IP</td>
          <td class="tableadd_data" >${equipmentVO.ip}</td>
          <td class="tableaddtitle">管理员</td>
          <td class="tableadd_data">${equipmentVO.userVO.name}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">所属会议室</td>
          <td class="tableadd_data" >${equipmentVO.meetingRoomVO.meetingRoomName}</td>
          <td class="tableaddtitle">状态</td>
          <td class="tableadd_data" >
          	<zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">所属MCU</td>
          <td class="tableadd_data" >
            <c:forEach items="${equipmentVOListsss}" var="eMcu" varStatus="status">
				  <c:if test="${eMcu.equipmentID==equipmentTerminalVO.equipmentMCUID}">
				  	<c:out value="${eMcu.equipmentNO}(${eMcu.ip})"></c:out>
				  </c:if>
			</c:forEach>
          </td>
          <td class="tableaddtitle">用户名</td>
          <td class="tableadd_data" colspan="3" >
          	${equipmentTerminalVO.loginName}
          </td>
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
          <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data">${equipmentVO.serialNumber}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">设备描述</td>
          <td colspan="3" class="tableadd_data" >${equipmentVO.description}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">控制参数</td>
          <td class="tableadd_data" colspan="3">
             <input type="checkbox" value="${equipmentTerminalVO.isCheck}" id="isCheck" name="equipmentTerminalVO.isCheck" <c:if test="${equipmentTerminalVO.isCheck==1}">checked="checked"</c:if> disabled="disabled"/>              
          </td>
          </tr>
      </table>
      <table id="table1" width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" <c:if test="${equipmentTerminalVO.isCheck==0}">style="display:none"</c:if>>
                      			<tr>
                      				<td width="15%" class="tableaddtitle">呼叫方式方向</td>
			          				<td width="35%" class="tableadd_data" >
			          					<zzst:lable type="dialingDirection" value="${equipmentTerminalVO.dialingDirection}"></zzst:lable>
			          				</td>
			          				<td class="tableaddtitle">类型</td>
			          				<td class="tableadd_data" >
			          					<zzst:lable type="dialingType" value="${equipmentTerminalVO.dialingType}"></zzst:lable>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">分辨率</td>
			          				<td class="tableadd_data" >
			          					<zzst:lable type="maxPesolution" value="${equipmentTerminalVO.maxPesolution}"></zzst:lable>
			          				</td>
			          				<td class="tableaddtitle">别名/类型</td>
			          				<td class="tableadd_data" >
			          					${equipmentTerminalVO.aliasName}
										<zzst:lable type="aliasType" value="${equipmentTerminalVO.aliasType}"></zzst:lable>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">视频协议</td>
			          				<td class="tableadd_data" >
			          					<zzst:lable type="videoTreaty" value="${equipmentTerminalVO.videoTreaty}"></zzst:lable>
			          				</td>
			          				<td class="tableaddtitle">级联</td>
			          				<td class="tableadd_data" >
			          					<zzst:lable type="cascadeRole" value="${equipmentTerminalVO.cascadeRole}"></zzst:lable>
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">连接速率</td>
			          				<td class="tableadd_data" >
			          					<zzst:lable type="speed" value="${equipmentTerminalVO.speed}"></zzst:lable>
			          				</td>
			          				<td class="tableaddtitle">端口号</td>
			          				<td class="tableadd_data" >
			          					${equipmentVO.port}
			          				</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">通信协议</td>
          							<td class="tableadd_data">
          								<zzst:lable type='radioTreaty' value='${equipmentTerminalVO.radioTreaty}'></zzst:lable>
          							</td>
          							<td class="tableaddtitle">模拟电话</td>
          							<td class="tableadd_data">${equipmentTerminalVO.pstn}</td>
                      			</tr>
                      			<tr>
                      				<td class="tableaddtitle">占用MCU资源数</td>
          							<td class="tableadd_data">
          								${equipmentTerminalVO.mcuResourse}
          							</td>
          							<td class="tableaddtitle">终端角色</td>
          							<td class="tableadd_data">${equipmentTerminalVO.useRole}</td>
                      			</tr>
                      			<tr>
						          <td class="tableaddtitle">控制参数</td>
						          <td colspan="3" class="tableadd_data" >${equipmentTerminalVO.controlParameter}</td>
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
