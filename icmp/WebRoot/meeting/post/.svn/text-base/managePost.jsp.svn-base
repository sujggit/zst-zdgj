<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<title>岗位管理</title>
		<script type="text/javascript">
		function delPost(id){
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="delPost.action?postVO.id=" + id;
		}
		
		function modifyPost(postNO){
			location.href = "${sys_ctx }/post/modifyPostBefore.action?postVO.id=" + postNO;
		}
		
	   	//添加
	   	function addPost(){
	   		document.location.href = "${sys_ctx }/meeting/post/addPost.jsp";
	   	}
	   
		/**
		*查看详细信息
		*/
		function detail(postNO){
			window.showModalDialog("${sys_ctx }/post/postDetail.action?postVO.id="+postNO,window,'dialogWidth=600px;dialogHeight=470px;');
		}
	
		/**
		function exportLog(){
			document.getElementById('pageform').action="${sys_ctx}/user/exportQuery.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/user/manageUserList.action";
		}
		*/
  </script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx }/post/managePostList.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" >
        <tr>
          <td width="15%" class="tableaddtitle">岗位编号</td>
          <td width="35%" class="tableadd_data">
          	
          	<input name="postVO.postNO" value="${postVO.postNO }" class="inputtran" id="postNO" />
          </td>
          <td width="15%" class="tableaddtitle">岗位名称</td>
          <td width="35%" class="tableadd_data"><input id="postName" class="inputtran" name="postVO.postName" value="${postVO.postName}"/></td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
        </tr>
      </table>
      
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />
        </a></div>
      </div>
      
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="addPost();"> 增加  </a><!--  <span>|</span><a onclick="exportLog();" style="cursor:pointer">导出</a>--></h5>
      </div>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="9%" class="head1">序号</th>
            <th width="35%" class="head1">岗位编号</th>
            <th width="36%" class="head1">岗位名称</th>
            <th width="20%" class="head1">操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${postVOList}" var="post" varStatus="state">
              <tr>
              		<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                    <td>&nbsp;<c:out value="${post.postNO}"/></td>
		            <td>&nbsp;<c:out value="${post.postName}"/></td>
		            <td class="alc">
		            	<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:detail('${post.id}');"/> 查看  
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:modifyPost('${post.id}');" /> 修改  
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:delPost('${post.id}');"/> 删除
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
