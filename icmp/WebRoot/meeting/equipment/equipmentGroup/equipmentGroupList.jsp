<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <title>设备组</title>
  <script type="text/javascript">	
		//add by chenshuo	
		
		function equipmentqeury(){
		  document.getElementById("pageform").submit();
		  
	    }
	    


			/**
			*删除设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDele(groupname){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/equipment/equipmentGroupdelete.action?equipmentGroupVO.groupname="+groupname;
			}
			
			
	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/equipment/equipmentGroup.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">      
     <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="15%" class="tableaddtitle">设备组名称</td>
          <td width="35%" class="tableadd_data" colspan="3">
         	 <input type="text" name="equipmentGroupVO.groupname" id="groupname" value="${equipmentGroupVO.groupname}"/>
          </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="equipmentqeury();" /></td>
        </tr>
      </table>
      <!--contenttitle-->
       <%@include file="/common/queryHidden.jsp"%>
      
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">设备组名称</th>
            <th width="88px" class="head1">级别</th>
            <th width="122px" class="head1">描述</th>
            <th width="%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${egList}" var="equipmentGroupVO" 	varStatus="state">
			<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentGroupVO.groupname}"/></td>
				<td>
					<c:out value="${equipmentGroupVO.rank}"/>
			    </td>
				<td><c:out value="${equipmentGroupVO.description}"/></td>
          	    <td class="alc">
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:equipmentDele('${equipmentGroupVO.groupname}');" >删除</a>
          	   	</td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
      <!--<jsp:include page="/common/pageFooter.jsp" />-->
      <!--contenttitle--> 
    </div>
 </form>
</body>
</html>
