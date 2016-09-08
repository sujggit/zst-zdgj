<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.ApplyEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
  	<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
    <title>审批流程节点查询页面</title>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<form action="/icmp/applyFlow/queryApplyFlows.action" id="pageform" name="pageform" method="post">
		<div id="basicform" class="contentwrapper"/>
		  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
            <tr>
              <td class="tableaddtitle">流程名称</td>
              <td class="tableadd_data">
	            <input class="inputtran" name="applyFlowVO.flowName" id="flowName" value="${applyFlowVO.flowName}" />
			  </td>
			  <td class="tableaddtitle">启用状态</td>
              <td class="tableadd_data">
                <select name="applyFlowVO.status" id="status" style="margin-top:5px">
                  <option value="-2147483648">请选择</option>
			   	  <option value="<%=ApplyEnum.STATUS_USE %>">启用</option>
			   	  <option value="<%=ApplyEnum.STATUS_STOPUSE %>">禁用</option>
				</select>
			  </td>
              <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" /></td>
             </tr>
           </table>
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;"  onclick="addApplyFlow();">增加 </a></h5>
      </div>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="%" class="head1">流程名称</th>
            <th width="%" class="head1">流程类别</th>
            <th width="66px" class="head1">启用状态</th>
            <th width="80px" class="head1">创建人</th>
            <th width="122px" class="head1">创建时间</th>
            <th width="188px" class="head1">操作</th>
          </tr>
        </thead>
			<tbody>
				<c:forEach items="${applyFlowList}" var="applyFlowVO" varStatus="state">
					<tr>
						<td class="alc"><c:out value="${state.index+1}"></c:out></td>
						<td><c:out value="${applyFlowVO.flowName}" /></td>
						<td><zzst:lable type="flowType" value="${applyFlowVO.flowType}"></zzst:lable></td>
						<td><c:if test="${applyFlowVO.status==0}">启用</c:if><c:if test="${applyFlowVO.status==1}">禁用</c:if></td>
						<td><c:out value="${applyFlowVO.userVO.name}"></c:out></td>
						<td><fmt:formatDate value="${applyFlowVO.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td class="alc">
							<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:applyFlowDetail('${applyFlowVO.flowID}');" />查看  
							<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:applyFlowModify('${applyFlowVO.flowID}');" />修改  
							<a class="funcOper <%= FuncEnum.FUNC_NO_DESGINFLOWNODE%>" onclick="javascript:desginFlownode('${applyFlowVO.flowID}','${applyFlowVO.flowName}','${applyFlowVO.flowType}');" />编辑流程  
							<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:applyFlowDel('${applyFlowVO.flowID}');" />删除
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="/common/pageFooter.jsp" />
	</form>
	<script type="text/javascript">
		
		/**
		 *删除审批流程节点信息 
		 *@param		${String}	id
		 *@return	null	
		*/
		function applyFlowDel(id){
			if(!window.confirm("是否确认删除？")) return;
			window.location.href="${sys_ctx}/applyFlow/applyFlowDelete.action?applyFlowVO.flowID="+id;
		}
		/**
		*添加审批流程节点
		*/
		function addApplyFlow(){
			window.location.href="${sys_ctx}/applyFlow/applyFlowBeforeAdd.action";
		}
		
		/**
		*修改审批流程节点
		*/
		function applyFlowModify(id){
			window.location.href="${sys_ctx}/applyFlow/applyFlowBeforeModify.action?applyFlowVO.flowID="+id;
		}
		
		/**
		 *	查看审批流程节点详细信息
		 *@param		${String}	id
		 *@return	null	
		 */
		function applyFlowDetail(id){
			window.showModalDialog("${sys_ctx}/applyFlow/applyFlowDetail.action?applyFlowVO.flowID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
        }

		/**
		*编辑流程的节点
		*/
	    function desginFlownode(flowID,flowName,flowType){
	    	window.showModalDialog("${sys_ctx}/meeting/apply/applyFlow/designFlownode.jsp?flowID="+flowID+"&flowName="+flowName+"&flowType="+flowType,window,'dialogWidth=800px;dialogHeight=560px;');
		}
	</script>
  </body>
</html>
