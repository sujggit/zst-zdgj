<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<title>会议室资料下载管理</title>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/file/meetingRoomFileDownloadList.action" id="pageform" name="pageform" method="post">  
	    <div id="basicform" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
	        <tr>
	          <td width="15%" class="tableaddtitle">会议室名称</td>
	          <td width="35%" class="tableadd_data">
		        <input name="uploadFileVO.meetingRoomVO.meetingRoomName" id="meetingRoomName" class="inputtran" value="${uploadFileVO.meetingRoomVO.meetingRoomName}" title="请输入查询条件"/>
	          </td>
	          <td width="15%" class="tableaddtitle">文件上传时间</td>
	          <td width="35%" class="tableadd_data">
	          	<img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	          	<input class="inputtran" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" name="uploadFileVO.createTime" id="createTime" type="text" value="<fmt:formatDate value="${uploadFileVO.createTime }" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly" title="请选择"/>
	          </td>
	          <td class="tableaddtitle" rowspan="2"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
	        </tr>
	      </table>
	
	      <!--contenttitle-->
	     <div class="widgetcontent">
	        <div class="msgmore"  onclick="disquery()";>
	            <a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"/>
		        </a></div>
	      </div>
	      
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">查询列表</h5>
	      </div>
	      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
	        <thead>
	          <tr>
	            <th width="50px" class="head1">序 号</th>
	            <th width="%" class="head1">文件名称</th>
	            <th width="%" class="head1">会议室名称</th>
	            <th width="99px" class="head1">会议室位置</th>
	            <th width="122px" class="head1">所属单位</th>
	            <th width="122px" class="head1">文件上传时间</th>
	            <th width="69px" class="head1">发布人</th>
	            <th width="166px" class="head1">操 作</th>
	          </tr>
	        </thead>
	        <tfoot>
        	</tfoot>
	        <tbody>
			<c:forEach items="${uploadFileVOList}" var="vo" varStatus="status">
				<tr>
					<td class="alc">
						<c:out value="${status.index+1}"></c:out>
					</td>
					<td title="${vo.fileName}">
						${vo.fileName}
					</td>
					<td title="${vo.meetingRoomVO.meetingRoomName}">
						${vo.meetingRoomVO.meetingRoomName}
					</td>
					<td title="${vo.meetingRoomVO.addressVO.name}">
						${vo.meetingRoomVO.addressVO.name}
					</td>
					<td title="${vo.meetingRoomVO.departmentVO.title}">
						${vo.meetingRoomVO.departmentVO.title}
					</td>
					<td title="${vo.createTime}">
						<fmt:formatDate value="${vo.createTime }"  pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td title="${vo.userVO.name}">
						${vo.userVO.name}
					</td>
					<td class="alc">
					  <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" title="查看" onclick="javascript:detail('${vo.uploadID}','${vo.uploadType }');">查看</a>
					     <a class="funcOper <%= FuncEnum.FUNC_NO_DOWNLOAD%>" style="color:#000000" title="下载文档" href="${sys_ctx }/file/download.action?fileName=${vo.fileUrl}">下载</a>
				         <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" title="删除" onclick="javascript:delRules('${vo.uploadID}','${vo.uploadType}');">删除</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	      </table>
	      <jsp:include page="/common/pageFooter.jsp" />
	    </div>  
	  </form>
	  <script type="text/javascript">
			function delRules(id,uploadType){
			    if(!confirm("确定要删除吗？")){
					return;
				}	
			   location.href="{sys_ctx}/file/delFile.action?uploadFileVO.uploadID=" + id + "&uploadFileVO.uploadType=" + uploadType;
			}
		
			//查看 
			function detail(uploadId,uploadType){
				//document.location.href = "${sys_ctx}/meeting/role/viewRole.jsp";
				window.showModalDialog("${sys_ctx }/file/detailMeetingRoomFile.action?uploadFileVO.uploadID="+uploadId+"&uploadFileVO.uploadType="+uploadType,window,'dialogWidth=690px;dialogHeight=422px;');
			}
			
		    function selectUsers(thisDom){
	              var userParameters = {
	                  methodName:'getReturnUserMethod',
	                  selectType:'radio'
	              }
	             creatUserSelect(thisDom,userParameters); 
	        };
	    	function getReturnUserMethod(userArray){
	              var userID="";
	              var loginName="";
	              var userLength = userArray.length;
	              for(var i=0;i<userLength;i++){
	            	  userID=userArray[i].userID;
	            	  loginName=userArray[i].userName;
	              }
	          	$("#userID").attr("value",userID);
            	$("#names").attr("value",loginName);
	         };
		</script>
	</body>
</html>