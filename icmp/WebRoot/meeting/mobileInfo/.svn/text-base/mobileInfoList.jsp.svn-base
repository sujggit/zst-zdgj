<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <title>电话列表</title>
  <script type="text/javascript">
  	function mobileInfoDele(id){
  		window.location.href = "${sys_ctx }/mobileInfo/deleteMobileInfo.action?mobileInfoVO.id="+id;
  	}
  	function mobileInfoModify(id){
  		window.location.href = "${sys_ctx }/mobileInfo/beforeModifyMobileInfo.action?mobileInfoVO.id="+id;
  	}
  	function addMobileInfo(){
  		window.location.href = "${sys_ctx }/meeting/mobileInfo/mobileInfoAdd.jsp";
  	}
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/mobileInfo/querymobileInfo.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">      
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="" onclick="javascript:addMobileInfo();">增加</a></h5>
      </div>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="20%" class="head1">姓名</th>
            <th width="40%" class="head1">电话</th>
            <th width="30%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${mobileInfoList}" var="mobileInfoVO" 	varStatus="state">
			<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${mobileInfoVO.name}"/></td>
				<td><c:out value="${mobileInfoVO.mobile}"/></td>
          	    <td class="alc">
          	    	<a class="" onclick="javascript:mobileInfoModify('${mobileInfoVO.id}');"  >修改</a>  
          	        <a class="" onclick="javascript:mobileInfoDele('${mobileInfoVO.id}');" >删除</a>
          	   	</td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
      <%-- <jsp:include page="/common/pageFooter.jsp" /> --%>
    </div>
 </form>
</body>
</html>