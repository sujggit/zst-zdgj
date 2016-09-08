<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<title>比对卡查看</title>
	</head>
	<body STYLE='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>

		<table width="100%" border="0" cellspacing="1" cellpadding="0"
			class="tableadd">
			<tr>
				<td width="15%" class="tableaddtitle">
					<span>*</span>设备类型
				</td>
				<td width="35%" class="tableadd_data">
					<zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentType}"></zzst:lable>
				</td>
				<td width="15%" class="tableaddtitle">
					<span>*</span>设备厂家
				</td>
				<td width="35%" class="tableadd_data">
					${equipmentVO.equipmentName}
				</td>
			</tr>
			<tr>
			<td class="tableaddtitle">
					<span>*</span>状态
				</td>
				<td class="tableadd_data">
					<zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable>
				</td>
				<!--<td class="tableaddtitle">
					<span>*</span>设备型号
				</td>
				<td class="tableadd_data">-->

					<td class="tableaddtitle">
						<span>*</span>设备名称
					</td>
					<td class="tableadd_data">
						<c:out value="${equipmentVO.equipmentNO}"></c:out>

					</td>
			</tr>
			<tr>
				<td class="tableaddtitle">
					<span>*</span>管理IP
				</td>
				<td class="tableadd_data">
					<c:out value="${equipmentVO.ip}"></c:out>

				</td>
				<td class="tableaddtitle">
					<span>*</span>端口号
				</td>
				<td class="tableadd_data">
					<c:out value="${equipmentVO.port}"></c:out>

				</td>
			</tr>
			
			<tr>
				<td class="tableaddtitle">
					<span>*</span>所属会议室
				</td>
				<td class="tableadd_data">
					${equipmentVO.meetingRoomVO.meetingRoomName}
				</td>
				<td class="tableaddtitle">
					<span>*</span>管理员
				</td>
				<td class="tableadd_data">
					${equipmentVO.userVO.name}
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle">
					<span>*</span>用户名
				</td>
				<td class="tableadd_data">
					<c:out value="${videoCardVO.loginName}"></c:out>

				</td>
				<td class="tableaddtitle">
					<span>*</span>密码
				</td>
				<td class="tableadd_data">
					<c:out value="${videoCardVO.loginPassWord}"></c:out>

				</td>
			</tr>

			<tr>
				<td class="tableaddtitle">
					<span>*</span>评测任务号
				</td>
				<td class="tableadd_data">
				<c:if test="${videoCardVO.appraisalTaskNum=='A0'}">全白</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A1'}">全灰</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A2'}">全黑</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A3'}">全红</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A4'}">全绿</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A5'}">全蓝</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A6'}">标准</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A7'}">方格</c:if>
				<c:if test="${videoCardVO.appraisalTaskNum=='A8'}">冻结帧</c:if>

				</td>
				<td class="tableaddtitle">
					<span>*</span>显示格式
				</td>
				<td class="tableadd_data">
					
                   <c:if test="${videoCardVO.showFormatFlag=='B0'}">1080p@60Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='B1'}">1080p@50Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='B2'}">1080p@30Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='B3'}">1080p@25Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='B4'}">1080p@24Hz</c:if>
				
				<c:if test="${videoCardVO.showFormatFlag=='B5'}">1080i@60Hz</c:if>
					
                <c:if test="${videoCardVO.showFormatFlag=='B6'}">1080i@50Hz</c:if>
                <c:if test="${videoCardVO.showFormatFlag=='B7'}">720p@60Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='B8'}">720p@50Hz</c:if>
				
				<c:if test="${videoCardVO.showFormatFlag=='BA'}">1280*1024@60Hz</c:if>
				<c:if test="${videoCardVO.showFormatFlag=='BB'}">1024*768@60Hz</c:if>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle">
					<span>*</span>输入方式
				</td>
				<td class="tableadd_data">
				<c:if test="${videoCardVO.inputModel=='D0'}">DVI</c:if>
				<c:if test="${videoCardVO.inputModel=='D1'}">[VGA]</c:if>
				<c:if test="${videoCardVO.inputModel=='D2'}">YPbPr</c:if>
				</td>
				<td class="tableaddtitle">
					<span>*</span>输出方式
				</td>
				<td class="tableadd_data">
				<c:if test="${videoCardVO.outputModel=='C0'}">DVI</c:if>
				<c:if test="${videoCardVO.outputModel=='C1'}">[VGA]</c:if>
				<c:if test="${videoCardVO.outputModel=='C2'}">YPbPr</c:if>
				</td>
			</tr>
			<tr>
				<td class="tableaddtitle">
					<span>*</span>评价方式
				</td>
				<td class="tableadd_data" >
				<c:if test="${videoCardVO.appraisalModel=='E0'}">绝对偏差</c:if>
				<c:if test="${videoCardVO.appraisalModel=='E1'}">平均偏差</c:if>
				<c:if test="${videoCardVO.appraisalModel=='E2'}">自标准差</c:if>
				<c:if test="${videoCardVO.appraisalModel=='E3'}">自平均</c:if>
				<c:if test="${videoCardVO.appraisalModel=='E4'}">源标准差</c:if>
				<c:if test="${videoCardVO.appraisalModel=='E5'}">源平均</c:if>
				</td>
            <td class="tableaddtitle"><span>*</span>采集方式</td>
                       <td class="tableadd_data">
                       <c:if test="${videoCardVO.collectModel=='F0'}">单帧采集</c:if>
				      <c:if test="${videoCardVO.collectModel=='F1'}">多帧采集</c:if>            
                      </td>
			</tr>
			<tr>
				<td class="tableaddtitle">
					描述
				</td>
				<td colspan="3" class="tableadd_data">
					<c:out value="${equipmentVO.description}"></c:out>
				</td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tfoot>
			</tfoot>
			<tbody>
				<tr>
					<td>
						<input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();" />
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>