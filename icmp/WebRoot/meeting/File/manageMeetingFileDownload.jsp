<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<c:set var="ftpServer" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.FTP_SERVER %>"></c:set>
		<c:set var="ftpUser" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.FTP_USER %>"></c:set>
		<c:set var="ftpPsw" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.FTP_PSW %>"></c:set>
		<title>会议资料下载管理</title>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/file/meetingFileDownloadList.action" id="pageform" name="pageform" method="post">  
	    <div id="basicform" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
	        <tr>
	          <td width="15%" class="tableaddtitle">会议名称</td>
	          <td width="35%" class="tableadd_data">
		        <input name="uploadFileVO.meetingDetailVO.meetingName" id="meetingName" class="inputtran" value="${uploadFileVO.meetingDetailVO.meetingName}" title="请输入查询条件"/>
	          </td>
	          <td width="15%" class="tableaddtitle">发布人</td>
	          <td width="35%" class="tableadd_data">
	          	<input type="hidden" name="uploadFileVO.createUserID" id="userID" class="" value="${ uploadFileVO.createUserID}" />
	          	<input class="inputtran" name="uploadFileVO.userVO.name" id="names" readonly="readonly"  onclick="selectUsers(this);" value="${uploadFileVO.userVO.name}" title="请选择" />
	          </td>
	          <td class="tableaddtitle" rowspan="2"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">会议开始时间</td>
	          <td class="tableadd_data">
	          	<img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	          	<input class="inputtran" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" name="uploadFileVO.meetingDetailVO.meetingStartTime" id="startTime" type="text" value="<fmt:formatDate value="${uploadFileVO.meetingDetailVO.meetingStartTime }" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly" title="请选择"/>
	          </td>
	          <td class="tableaddtitle">文件上传时间</td>
	          <td class="tableadd_data">
	          	<img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	          	<input class="inputtran" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" name="uploadFileVO.createTime" id="createTime" type="text" value="<fmt:formatDate value="${uploadFileVO.createTime }" pattern="yyyy-MM-dd HH:mm"/>" readonly="readonly" title="请选择"/>
	          </td>
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
	            <th width="%" class="head1">会议名称</th>
	            <th width="116px" class="head1">会议开始时间</th>
	            <th width="138px" class="head1">文件上传时间</th>
	            <th width="59px" class="head1">发布人</th>
	            <th width="166px" class="head1">操 作</th>
	          </tr>
	        </thead>
	        <tfoot>
        	</tfoot>
	        <tbody>
			<c:forEach items="${uploadFileVOList}" var="rules" varStatus="status">
				<tr>
					<td class="alc">
						<c:out value="${status.index+1}"></c:out>
					</td>
					<td title="${rules.fileName}">
						${rules.fileName}
					</td>
					<td title="${rules.meetingDetailVO.meetingName}">
						${rules.meetingDetailVO.meetingName}
					</td>
					<td title="${rules.meetingDetailVO.meetingStartTime}">
						<fmt:formatDate value="${rules.meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td title="${rules.createTime}">
						<fmt:formatDate value="${rules.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td title="${rules.userVO.name}">
						${rules.userVO.name}
					</td>
					<td class="alc">
					  <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" title="查看" onclick="javascript:detail('${rules.uploadID}','${rules.uploadType }');">查看</a>
					  <c:if test="${rules.uploadFileImpowerVO.status==2 or rules.uploadFileImpowerVO.status == 3}">
					  <c:choose>
					  <c:when test="${rules.uploadType==3}">
					    <a class="funcOper <%= FuncEnum.FUNC_NO_DOWNLOAD%>" style="cursor: pointer;color:#000000" class="cx_Modify" title="下载文档" href="${sys_ctx }/file/getVideoFile.action?fileName=${rules.fileName}&path=${rules.fileUrl}" >下载</a>
					  </c:when>
					  <c:otherwise>
					    <a class="funcOper <%= FuncEnum.FUNC_NO_DOWNLOAD%>" style="cursor: pointer;color:#000000" class="cx_Modify" title="下载文档" href="${sys_ctx }/file/download.action?fileName=${rules.fileUrl}" >下载</a>
					  </c:otherwise>
					  </c:choose>
		               
	            	  </c:if>
					  <c:if test="${rules.uploadFileImpowerVO.status==3}">
					    
					     <a class="funcOper <%= FuncEnum.FUNC_NO_UPDATEIMPOWERTREE%>" title="权限分配" onclick="javascript:updateImpowerTree('${rules.uploadID}','${rules.uploadType}','${rules.uploadKey}','${rules.meetingDetailVO.meetingName}','${rules.fileName}');">授权</a>
				         <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" title="删除" onclick="javascript:delRules('${rules.uploadID}','${rules.uploadType}');">删除</a>
					  </c:if>
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
				window.showModalDialog("${sys_ctx }/file/detailMeetingFile.action?uploadId="+uploadId+"&uploadType="+uploadType,window,'dialogWidth=700px;dialogHeight=470px;');
			}
			//修改
			function modifyRules(id){
				location.href="editRules.action?uploadFileVO.uploadID=" + id;
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

	         function updateImpowerTree(uploadId,uploadType,uploadKey,meetingName,fileName){
	        	 window.location.href = "${sys_ctx}/meeting/File/checkFileImpower.jsp?id="+uploadId+"&type="+uploadType+"&key="+uploadKey+"&mName="+meetingName+"&fName="+fileName;
				//window.location.href  ="${sys_ctx}/func/queryCheck.action?roleVO.roleID=" + id;
				//window.showModalDialog("${sys_ctx}/func/getFuncList.action?roleVO.roleID=" + id,window,'dialogWidth=600px;dialogHeight=620px;');
			}
			
			function downloadRecordFile(fileurl){
				var result = false;
				  try{
				    var obj=new ActiveXObject("wscript.shell");
				    if(obj){
				    alert("文件将被下载到c:\\");
				    var fso = new ActiveXObject("Scripting.FileSystemObject");
				    var f1 = fso.createtextfile("c:\\myjstest.bat",true);
				    var f2 = fso.createtextfile("c:\\ftpcomand.ftp",true);
				    f2.WriteLine("open ${ftpServer}");
				    f2.WriteLine("user ${ftpUser} ${ftpPsw}");
				    f2.WriteLine("bin");
				    f2.WriteLine("prompt");
				   // f2.WriteLine("cd rss");
				    f2.WriteLine("lcd c:\\");
				    f2.WriteLine("get "+fileurl);
				    f2.WriteLine("bye");
				    f2.WriteLine("exit");
				    f2.Close();
				    f1.WriteLine("@echo off");
				    f1.WriteLine("echo =====ftp文件下载=====");
				    f1.WriteLine("ftp -i -n -s:c:\\ftpcomand.ftp");
				    //f1.WriteLine("pause");
				    f1.Close();
				      obj.Run('cmd /c C:/myjstest.bat',0);
				      obj=null;
				      result=true;
				    }
				  }
				 
				  catch(e){
				  	alert("下载失败！");
				  }
				   alert("文件已下载到c:\\");
				  return result;
							
			}
		</script>
	</body>
</html>