<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>审批流程查询页面</title>
 	<script type="text/javascript">
		
		/**
		 *删除审批流程信息 
		 *@param		${String}	id
		 *@return	null	
		*/
		function applyDelet(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/apply/applyDelete.action?applyVO.applyID="+id;
		}
		/**
		*添加审批流程
		*/
		function addApply(){
			window.location.href="${sys_ctx}/apply/applyBeforeAdd.action";
		}
		
		/**
		*修改审批流程
		*/
		function applyModify(id){
			window.location.href="${sys_ctx}/apply/applyBeforeModify.action?applyVO.applyID="+id;
		}
		
		/**
		 *	查看审批流程详细信息
		 *@param		${String}	id
		 *@return	null	
		 */
		function applyDetail(id){
			window.showModalDialog("${sys_ctx}/apply/applyDetail.action?applyVO.applyID="+id,window,'dialogWidth=800px;dialogHeight=670px;');
        }

		//add by xiongshun
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
           }
           $("#departmentID").attr("value",departmentID);
           $("#departmentName").attr("value",departmentName);
	    }

	    function applyFlowNode(id){
	    	window.showModalDialog("${sys_ctx}/meeting/apply/applyFlowNode.jsp",window,'dialogWidth=800px;dialogHeight=560px;');
		}
	</script>
  </head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
		<form action="/icmp/apply/queryApplys.action" id="pageform" name="pageform" method="post">
			<div id="basicform" class="contentwrapper">
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
                 <tr>
                   <td width="15%" class="tableaddtitle">流程名称：</td>
                   <td width="35%" class="tableadd_data" >
			        <input class="inputtran" name="applyVO.applyName" id="applyName" value="${applyVO.applyName}" />
					</td>
                   
                   <td width="15%" class="tableaddtitle">所属单位：</td>
                   <td width="35%" class="tableadd_data">
                   	 <input type="hidden" id="departmentID"  name="applyVO.departmentID" value="" />
          <input id="departmentName"  name="applyVO.departmentName" value="${applyVO.departmentName }" class="inputtran" onclick="selectDepartments(this);" readonly="readonly" />
				   </td>
                   <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" /></td>
                </tr>
             </table>
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
    <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;"  onclick="addApply();">增加 </a></h5>
      </div>
  <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="18%" class="head1">流程名称</th>
            <th width="18%" class="head1">流程类别</th>
            <th width="10%" class="head1">所属单位</th>
            <th width="10%" class="head1">创建人</th>
            <th width="14%" class="head1">创建时间</th>
            <th width="14%" class="head1">操作</th>
          </tr>
        </thead>
			<tbody>
				<c:forEach items="${applyList}" var="applyVO" varStatus="state">
					<tr>
						<td class="alc"><c:out value="${state.index+1}"></c:out></td>
						<td><c:out value="${applyVO.applyName}"></c:out></td>
						<td><zzst:lable type="applyType" value="${applyVO.applyType}"></zzst:lable></td>
						<td><zzst:lable type="department" value="${applyVO.departmentID}"></zzst:lable></td>
						<td><zzst:lable type="createUser" value="${applyVO.createUserID}"></zzst:lable></td>
						<td><fmt:formatDate value="${applyVO.createTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
						<td class="alc">
							<a style="cursor: pointer;" onclick="javascript:applyDetail('${applyVO.applyID}');" />查看 |
							<a style="cursor: pointer;" onclick="javascript:applyModify('${applyVO.applyID}');" />修改
							<a style="cursor: pointer;" onclick="javascript:applyFlowNode('${applyVO.applyID}');" /> | 编辑节点
							<c:if test="${applyVO.isDelete == 0}">
							  <a style="cursor: pointer;" onclick="javascript:applyDelet('${applyVO.applyID}');" /> |删除
							</c:if>
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
