<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<title>用户管理</title>
		<script type="text/javascript">
			function selectDepartments(thisDom){
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectType:'radio',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
		    function getReturnDepartMethod(departList){
		    	var departmentID="";
	            var departmentName="";
	            var depLength = departList.length;
	            for(var i=0;i<depLength;i++){
	              departmentID+=departList[i].departmentID;
	              departmentName+=departList[i].departmentName;
	              //alert(departList[i].departmentName+" + "+departList[i].departmentID);
	            }
	          	$("#corpID").attr("value",departmentID);
               	$("#corpName").attr("value",departmentName);
		    }
		function delUser(id){
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="dellUserForState.action?userVO.userID=" + id;
		}
		
		
	function modifyUser(id){
		var url="${sys_ctx }/user/getUserInfo.action?userVO.userID=" + id;
		location.href=url;
	}
	//重置密码
	function setPassword(id){
		if(!confirm("确定重置密码吗？")){
			return；
		}
		location.href="setPassword.action?userVO.userID=" + id;
	}
	function tijiao(){
      var path=document.getElementById("fileName");
      document.getElementById("pathID").value = path.value;
      document.getElementById("form").submit();
   }
   	//添加
   	function addnew(){
   		document.location.href = "${sys_ctx }/user/beforeAdd.action";
   	}
   
	/**
	*查看详细信息
	*/
	function detail(id){
		window.showModalDialog("${sys_ctx }/user/detail.action?userVO.userID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	}
	
	function exportLog(){
		document.getElementById('pageform').action="${sys_ctx}/user/exportQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx}/user/manageUserList.action";
	}
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx }/user/manageUserList.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
        <tr>
          <td width="15%" class="tableaddtitle">部门</td>
          <td width="35%" class="tableadd_data" >
          <input type="hidden" name="userVO.departmentVO.id" id="corpID" value="${userVO.departmentVO.id }" />
          <input type="text" name="userVO.departmentVO.title" value="${userVO.departmentVO.title }" class="inputtran" id="corpName" onclick="selectDepartments(this);" readonly="readonly" />
          </td>
          <td width="15%" class="tableaddtitle">用户名</td>
          <td width="35%" class="tableadd_data"><input id="datepicker" type="text" class="inputtran"  name="userVO.loginName" value="${userVO.loginName}"/></td>
          <td class="tableaddtitle"><input type="button"  class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
        </tr>
      </table>
      
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="addnew();">增加  </a><span></span><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportLog();">导出</a></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="24%" class="head1">用户名</th>
            <th width="24%" class="head1">姓名</th>
            <th width="24%" class="head1">部门</th>
            <th width="20%" class="head1">操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user" varStatus="state">
              <tr>
              		<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                    <td>&nbsp;<c:out value="${user.loginName}"/></td>
		            <td>&nbsp;<c:out value="${user.name}"/></td>
		            <td>&nbsp;<c:out value="${user.departmentVO.title}"/></td>
		            
		            <td class="alc">
		            	<c:if test="${user.loginName!='admin' }">
			            	<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:detail('${user.userID}');"/> 查看
							<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:modifyUser('${user.userID}');" /> 修改
							<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:delUser('${user.userID}');"/> 删除
							<a class="funcOper <%= FuncEnum.FUNC_NO_SETPASSWORD %>" onclick="javascript:setPassword('${user.userID}');"/> 重置密码
						</c:if>				
					</td>
              </tr>
          </c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      </div>
	</form>
  </body>
</html>
