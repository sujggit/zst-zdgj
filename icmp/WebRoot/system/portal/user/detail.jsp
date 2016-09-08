<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="/common/common_header.jsp" %>
		<zzst:authority func="meetingManage" action="generalBookDetail"  pagehead="true"	/>
		<title>人员信息</title>
		<script type="text/javascript">
		
		/**
		*	返回
		*@return	null	
		*/
		function cancel(){
			window.close();
		}
		</script>
	</head>

	<body>
		<div class="popwin">
			<table border="0" cellspacing="0" cellpadding="0" class="tabel2_th" >
				<tr>
					<td width="14" class="tabel2_th_left">&nbsp;</td>
					<td class="tabel2_th_middle"><h3><c:out value="${userVO.loginName }"></c:out> 详细信息</h3></td>
					<td width="6" class="tabel2_th_right"></td>
				</tr>
			</table>
			<table cellpadding="5" cellspacing="0" class="tabel2_left" >							
				<tr>
					<td class="searchtd1">姓名：</td>
					<td class="searchtd2"><c:out value="${userVO.fullName }" default="无"></c:out></td>
					<td class="searchtd2">职位：</td>
					<td class="searchtd3"><c:out value='${userVO.positionName}' default="无"></c:out></td>	
				</tr>	
				<tr>
					<td class="searchtd1" valign="top">电话：</td>
					<td class="searchtd2">
					 <c:out value='${userVO.mobilePhone}' default="无"></c:out>
					</td>
					<td class="searchtd2">座机：</td>
				  <td class="searchtd3"> 
					<c:out value='${userVO.telPhone}' default="无"></c:out>
				</td>
				</tr>
				<tr>
				  <td class="searchtd1" valign="top">邮箱：</td>
				  <td class="searchtd2"> <c:out value='${userVO.email}' default="无"></c:out></td>
				  <td class="searchtd2">部门：</td>
				  <td class="searchtd3"> <c:out value='${userVO.departmentName}' default="无"></c:out></td>
			  </tr>
			  <tr>		 
			</table>
		</div>
		<table width="99%" border="0" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td align="center">
						<input type="button" name="button2" id="button2" value="返回" onclick="cancel();"
							class="tableBtn" />
					</td>
				</tr>
			</table>
	</body>

</html>
