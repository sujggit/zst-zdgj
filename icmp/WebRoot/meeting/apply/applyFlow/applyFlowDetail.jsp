<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <%@include file="/common/common.jsp"%>
	<title>审批流程详情</title>
  </head >
  <body style='OVERFLOW-Y:AUTO;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
     <div class="contenttitle2">
        <h5 class="fwb fl10">审批流程详情</h5>
      </div>
     <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        <tr>
          <td width="15%" class="tableaddtitle">流程名称</td>
          <td width="35%" class="tableadd_data" >
             <c:out value="${applyFlowVO.flowName }"></c:out> 
          </td>
          <td width="15%" class="tableaddtitle">流程类别</td>
          <td width="35%" class="tableadd_data">
          	<zzst:lable type="flowType" value="${applyFlowVO.flowType}"></zzst:lable>	
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">创建人</td>
          <td class="tableadd_data" >
          	<c:out value="${applyFlowVO.userVO.name}"></c:out>
          </td>
          <td class="tableaddtitle">创建时间</td>
          <td class="tableadd_data">
          	<fmt:formatDate value="${applyFlowVO.createTime}" pattern="yyyy-MM-dd HH:mm"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">启用状态</td>
          <td class="tableadd_data" >
          <c:if test="${applyFlowVO.status == 0}"> 
                                启用</td>
          <td class="tableaddtitle">启用时间</td>
          <td class="tableadd_data">
          	<fmt:formatDate value="${applyFlowVO.startTime}" pattern="yyyy-MM-dd HH:mm"/>
          	</c:if>
          	<c:if test="${applyFlowVO.status == 1}">
          	  禁用</td>
             <td class="tableaddtitle">禁用时间</td>
             <td class="tableadd_data">
          	 <fmt:formatDate value="${applyFlowVO.endTime}" pattern="yyyy-MM-dd HH:mm"/>
          	</c:if>
          </td>
        </tr>
         <tr>
          <td class="tableaddtitle">描述信息</td>
          <td class="tableadd_data" colspan="3" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis;" title='${applyFlowVO.description}'>
          	<c:out value="${applyFlowVO.description}"></c:out>
          </td>
        </tr>
      </table>
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
