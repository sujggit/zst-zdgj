<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<c:set value="<%=com.zzst.model.enums.DateBaseEnum.SYSTEM_ADMIN_ID %>" var="sysadminId"/>
		<title>角色管理</title>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/role/manageRoleList.action" id="pageform" name="pageform" method="post">  
	    <div id="basicform" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
	        <tr>
	          <td width="15%" class="tableaddtitle">用户</td>
	          <td width="35%" class="tableadd_data">
	          	<input id="username" type="text" class="inputtran" name="roleVO.userNames" value="${roleVO.userNames}" title="请输入用户查询条件"/>
	          </td>
	          <td width="15%" class="tableaddtitle">角色</td>
	          <td width="35%" class="tableadd_data">
	          	<input id="rolename" type="text" class="inputtran" name="roleVO.roleName" value="${roleVO.roleName}" title="请输入角色查询条件"/>
	          </td>
	          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="listRole();"/></td>
	        </tr>
	      </table>
	
	     <div class="widgetcontent">
	        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"/>
		        </a></div>
	      </div>
	      
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">查询列表</h5>
	        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor:pointer" title="增加" onclick="javascript:addnew();;">增加</a></h5>
	      </div>
	      <!--  
	      <div class="tableoptions">
	                显示 &nbsp;<select class="radius3">
	                    	<option value="">10</option>
	                        <option value="">20</option>
	                        <option value="">30</option>
	                    </select> &nbsp;项
	                    <span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
	                </div>-->
	      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
	        <thead>
	          <tr>
	            <th width="8%" class="head1">序号</th>
	            <th width="24%" class="head1">角色</th>
	            <th width="48%" class="head1">用户</th>
	            <th width="280px" class="head1">操作</th>
	          </tr>
	        </thead>
	        <tfoot>
        	</tfoot>
	        <tbody>
			<c:forEach items="${roleVOList}" var="role" varStatus="status">
				<tr>
					<td class="alc">
						<c:out value="${status.index+1}"></c:out>
					</td>
					<td title="${role.roleName}">&nbsp;
						${role.roleName}
					</td>
					<td title="${role.userNames}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis">&nbsp;
						${role.userNames}
					</td>
					<td class="alc">&nbsp;
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" style="cursor: pointer" class="cx_Modify" title="修改角色名" onclick="javascript:modifyRole('${role.roleID}');" >修改</a>
							   <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" style="cursor: pointer" title="查看所属用户" onclick="javascript:viewRole('${role.roleID}');">查看</a>
							 <c:if test="${role.count ==0 and role.roleID != sysadminId }">
							    <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="cursor: pointer" class="cx_delete" title="删除角色" onclick="javascript:delRole('${role.roleID}');">删除</a> 
							  </c:if>
							    <a class="funcOper <%= FuncEnum.FUNC_NO_UPDATEFUNCTREE%>" style="cursor:pointer" title="权限分配" onclick="javascript:updateFunctree('${role.roleID}');">授权</a><!-- 挂接 -->
							    <a class="funcOper <%= FuncEnum.FUNC_NO_AUTHORIZATION%> " style="cursor:pointer" title="分配人员" onclick="javascript:authorization('${role.roleID}');">分配人员</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	      </table>
	      <jsp:include page="/common/pageFooter.jsp" />
	    </div>  
	  </form>
	  <script type="text/javascript">
		    function updateFunctree(id)
			{
				window.location.href  ="${sys_ctx}/func/queryCheck.action?roleVO.roleID=" + id;
				//window.showModalDialog("${sys_ctx}/func/getFuncList.action?roleVO.roleID=" + id,window,'dialogWidth=600px;dialogHeight=620px;');
			}
			function delRole(id)
			{
			 if(!confirm("确定要删除吗？")){
					return;
				}		
			   location.href="delRole.action?roleVO.roleID=" + id;
			}
			function modifyRole(id){
				location.href="editRole.action?roleVO.roleID=" + id;
			}
			function listRole(){
			   	var name = document.getElementById('roleName').value;
	             var validation_roleNameLength  = validation_form_length(document.getElementById('roleName'),"角色名称需小于32个字符","0","32","");
	             if(validation_roleNameLength){
	             return false;
	             }else{
				 document.getElementById("123").style.display= "none"; 
				document.all.pageform.submit();
				}
			}
			//check roleName when the roleName 'input' onblur
			function check_Role(id){
			
			DwrMethod.check_roleUse(id,calback);
			}
			function calback(para){
			roleName_result=para;
			if(para){
			alert("角色！");
			return ;
			}
			}
			//添加
			function addnew(){
				document.location.href = "${sys_ctx}/meeting/role/addRole.jsp";
			}
			//查看该角色的用户addBy xiongshun 
			function viewRole(id){
				//document.location.href = "${sys_ctx}/meeting/role/viewRole.jsp";
				window.showModalDialog("viewRole.action?roleVO.roleID=" + id);
			}
			//根据用户名或角色名模糊查询addBy xiongshun 查询规则：优先根据用户名进行搜索
			function listRole(){
				document.pageform.submit();
			}
			
			function authorization(roleID){
				window.location.href="${sys_ctx}/role/getAuthorization.action?roleID="+roleID;
			}
		</script>
	</body>
</html>