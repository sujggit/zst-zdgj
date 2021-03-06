<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>会议组列表</title>
		<script type="text/javascript">
			function add() {
				location.href = "${sys_ctx}/meeting/ptsGroupManager/meetingGroupAdd.jsp";
			}
		
			function equipmentadd(equipmentGroupID) {
				window.location.href = "${sys_ctx}/templateEquipment/MeetingEquipmentQuery.action?templateEquipmentGroupVO.ID="
						+ equipmentGroupID;
			}
		
			function equipmentdel(equipmentGroupID) {
				if (!window.confirm("是否确认删除？"))
					return;
				window.location.href = "${sys_ctx}/templateEquipmentGroup/MeetingGroupDel.action?templateEquipmentGroupVO.ID="
						+ equipmentGroupID;
			}
		
			function modifyGroup(equipmentGroupID) {
				window.location.href = "${sys_ctx}/templateEquipmentGroup/preMeetingGroupModify.action?templateEquipmentGroupVO.ID="
						+ equipmentGroupID;
			}
			//复制会场组
			function equipmentCopy(equipmentGroupID){
				window.location.href = "${sys_ctx}/templateEquipment/MeetingEquipmentCopy.action?templateEquipmentGroupVO.ID="
					+ equipmentGroupID;
			}
		</script>
	</head>
	<body style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
		<form action="/icmp/templateEquipmentGroup/MeetingGroupQuery.action" method="post" name="pageform" id="pageform">
			<div id="basicform" class="contentwrapper">
				<!--pageheader-->
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" align="center">
					<tr>
						<td width="15%" class="tableaddtitle">会场组名称</td>
						<td class="tableadd_data">
							<input id="name" name="groupName" type="text" value="${groupName}" class="inputtran" />
						</td>
						<td class="tableaddtitle">
							<input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" />
						</td>
					</tr>
				</table>
				<!--contenttitle-->
				<div class="widgetcontent">
					<div class="msgmore" onclick="disquery()";>
						<a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
							<map name="Map" id="Map">
								<area shape="rect" coords="2,-1,6,7" /><area shape="rect" coords="36,0,51,6" />
							</map></a>
					</div>
				</div>

				<!--contenttitle-->
				<div class="contenttitle2">
					<h5 class="fwb fl10">查询列表</h5>
					<h5 class="fwb fr10">
						<a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;" onclick="add();">增加</a>
					</h5>
				</div>

				<!--<div class="tableoptions">
       				<span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
      			</div>-->
				<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
					<thead>
						<tr>
							<th class="head1" width="10%">序号</th>
							<th class="head1" width="70%">会场组名称</th>
							<th class="head1" width="20%">操作</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<c:forEach items="${templateEquipmentGroupVOList}" var="templateEquipmentGroupVO" varStatus="status">
							<tr>
								<td class="alc">
									<c:out value="${status.index+1}"></c:out>
								</td>
								<td>
									<c:out value="${templateEquipmentGroupVO.name}" />
								</td>
								<%--<td>
					          		<c:out value="${meetingDetailVO.meetingName}" />
					          	</td>--%>
								<td class="alc">
									<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="modifyGroup('${templateEquipmentGroupVO.ID}');">修改</a>  
									<a class="funcOper <%= FuncEnum.FUNC_NO_EQUIPMENTADD%>" onclick="equipmentadd('${templateEquipmentGroupVO.ID}');"> 编辑</a>  
									<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="equipmentdel('${templateEquipmentGroupVO.ID}');"> 删除</a>
									<a class="funcOper <%= FuncEnum.FUNC_NO_COPY%>" onclick="equipmentCopy('${templateEquipmentGroupVO.ID}');"> 复制</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<jsp:include page="/common/pageFooter.jsp" />
				<!--contenttitle-->
			</div>
		</form>
	</body>
</html>
