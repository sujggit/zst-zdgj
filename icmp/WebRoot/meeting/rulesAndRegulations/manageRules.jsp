<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<title>规章制度管理</title>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/rules/manageRulesList.action" id="pageform" name="pageform" method="post">  
	    <div id="basicform" class="contentwrapper">
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
	        <tr>
	          <td width="15%" class="tableaddtitle">文件名称</td>
	          <td width="35%" class="tableadd_data">
	          	<input id="fileName" type="text" class="inputtran" name="uploadFileVO.fileName" value="${uploadFileVO.fileName}" title="请输入查询条件"/>
	          </td>
	          <td width="15%" class="tableaddtitle">颁发时间</td>
	          <td width="35%" class="tableadd_data">
	          	<img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	          	<input class="inputtran" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" name="uploadFileVO.createTime" id="createTime" type="text" value="<fmt:formatDate value="${uploadFileVO.createTime }" pattern="yyyy-MM-dd"/>" readonly="readonly" title="请选择"/>
	          </td>
	          <td class="tableaddtitle" rowspan="2"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
	        </tr>
	        <tr>
	          <td width="15%" class="tableaddtitle">颁发单位</td>
	          <td width="35%" class="tableadd_data">
	          	<input type="hidden" name="uploadFileVO.uploadKey" id="corpID" value="${ uploadFileVO.uploadKey}" />
		        <input name="uploadFileVO.departmentVO.title" id="corpName" class="inputtran" onclick="selectDepartments(this);" readonly="readonly" value="${uploadFileVO.departmentVO.title}" title="请选择"/>
	          </td>
	          <td width="15%" class="tableaddtitle">发布人</td>
	          <td width="35%" class="tableadd_data">
	          	<input type="hidden" name="uploadFileVO.createUserID" id="userID" class="" value="${ uploadFileVO.createUserID}" />
	          	<input class="inputtran" name="uploadFileVO.userVO.name" id="names" readonly="readonly"  onclick="selectUsers(this);" value="${uploadFileVO.userVO.name}" title="请选择" />
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
	        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor:pointer" title="增加" onclick="javascript:addRules();;">增加</a></h5>
	      </div>
	      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table" style="table-layout: fixed">
	        <thead>
	          <tr>
	            <th width="8%" class="head1">序 号</th>
	            <th width="18%" class="head1">文件名称</th>
	            <th width="12%" class="head1">颁发单位</th>
	            <th width="12%" class="head1">颁发时间</th>
	            <th width="12%" class="head1">发布人</th>
	            <th width="24%" class="head1">备 注</th>
	            <th width="14%" class="head1">操 作</th>
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
					<td title="${rules.departmentVO.title}">
						${rules.departmentVO.title}
					</td>
					<td title="${rules.createTime}">
						<fmt:formatDate value="${rules.createTime }"  pattern="yyyy-MM-dd"/>
					</td>
					<td title="${rules.userVO.name}">
						${rules.userVO.name}
					</td>
					<td title="${rules.description}" style="white-space: nowrap;overflow: hidden;text-overflow:ellipsis">
						${rules.description}
					</td>
					<td class="alc">
						<a class="funcOper <%= FuncEnum.FUNC_NO_DOWNLOAD%>" style="cursor: pointer;color:#000000" class="cx_Modify" title="下载文档" href="${sys_ctx }/rules/download.action?fileName=${rules.fileUrl}" >下载</a>
						<!-- | <a style="cursor: pointer" title="查看" onclick="javascript:viewRole('${rules.uploadID}');">查看</a> -->
						<!-- | <a style="cursor:pointer" title="权限分配" onclick="javascript:updateImpowerTree('${rules.uploadID}','${rules.uploadType}','${rules.uploadKey}','${rules.fileName}');">授权</a>-->
						  <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="cursor:pointer" title="删除" onclick="javascript:delRules('${rules.uploadID}');">删除</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	      </table>
	      <jsp:include page="/common/pageFooter.jsp" />
	    </div>  
	  </form>
	  <script type="text/javascript">
			function delRules(id){
			    if(!confirm("确定要删除吗？")){
					return;
				}		
			   location.href="delRules.action?uploadFileVO.uploadID=" + id;
			}
			//添加
			function addRules(){
				document.location.href = "${sys_ctx}/meeting/rulesAndRegulations/addRules.jsp";
			}
			//查看 
			function viewRules(id){
				//document.location.href = "${sys_ctx}/meeting/role/viewRole.jsp";
				window.showModalDialog("viewRules.action?uploadFileVO.uploadID=" + id);
			}
			//修改
			function modifyRules(id){
				location.href="editRules.action?uploadFileVO.uploadID=" + id;
			}

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
	          	$("#corpID").attr("value",departmentID);
            	$("#corpName").attr("value",departmentName);
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

	         function updateImpowerTree(uploadId,uploadType,uploadKey,fileName){
	        	 window.location.href = "${sys_ctx}/meeting/File/checkFileImpower.jsp?id="+uploadId+"&type="+uploadType+"&key="+uploadKey+"&mName="+null+"&fName="+fileName;
				//window.location.href  ="${sys_ctx}/func/queryCheck.action?roleVO.roleID=" + id;
				//window.showModalDialog("${sys_ctx}/func/getFuncList.action?roleVO.roleID=" + id,window,'dialogWidth=600px;dialogHeight=620px;');
			}
			/**
			function download(fileUrl){
				document.getElementById("pageform").action = "${sys_ctx }/rules/download.action?fileUrl=/file/upload/myeclipse8.5Svn以及优化.txt";
				document.getElementById("pageform").submit();
				document.getElementById("pageform").action = "${sys_ctx }/rules/manageRulesList.action";
			}
			*/
		</script>
	</body>
</html>