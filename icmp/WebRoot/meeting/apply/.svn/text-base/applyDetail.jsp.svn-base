<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>审批流程详情</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript">
			function backHistory(){
	        	window.location.href="${sys_ctx}/apply/queryApplys.action";
	        }
		</script>
		<link rel="stylesheet" href="${sys_ctx }/plug-in/applyFlow/applyFlow.css" type="text/css"/> 
	</head >
 <body style='OVERFLOW-Y:AUTO;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
     <div class="contenttitle2" style="width:98%">
        <h5 class="fwb fl10">审批流程详情：</h5>
      </div>
     <table width="98%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        <tr>
          <td width="15%" class="tableaddtitle">流程名称：</td>
          <td width="35%" class="tableadd_data" >
             <c:out value="${applyVO.applyName }"></c:out> 
          </td>
          <td width="15%" class="tableaddtitle">所属单位：</td>
          <td width="35%" class="tableadd_data">
          	<zzst:lable type="department" value="${applyVO.departmentID}"></zzst:lable>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">创建人：</td>
          <td class="tableadd_data" >
          	<zzst:lable type="createUser" value="${applyVO.createUserID}"></zzst:lable>	
          </td>
          <td class="tableaddtitle">创建时间：</td>
          <td class="tableadd_data">
          	<fmt:formatDate value="${applyVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle">流程类别：</td>
          <td class="tableadd_data" colspan="3">
          	<zzst:lable type="applyType" value="${applyVO.applyType}"></zzst:lable>	
          </td>
         </tr>
         <tr>
          <td class="tableaddtitle">描述信息：</td>
          <td class="tableadd_data" colspan="3" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;" title='${applyVO.description}'>
          	<c:out value="${applyVO.description}"></c:out></td>
        </tr>
      </table>
      <c:forEach items="${flst}" var="flowVO" varStatus="state">
		    <div class="divbg" style="margin-top:6px"  >
		       <span style="font-size:12px;">${flowVO.flowName }<c:if test="${state.index != 0 }">(
			       <c:forEach items="${flowVO.flowMemberList}" var="flowMemberVO" >
			       	  ${flowMemberVO.userVO.name }
			       </c:forEach>
		       ) 
		       </c:if></span>
		    </div>
		    <div class="divarr">
		      <div class="arrsty"></div>
		    </div>
      </c:forEach>
      <div class="divbg" >结束</div>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/></td>
          </tr>
        </tbody>
     </table>
     </div>
	</body>
</html>
