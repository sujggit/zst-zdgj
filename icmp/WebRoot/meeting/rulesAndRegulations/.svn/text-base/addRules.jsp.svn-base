<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>新增规章制度</title>
		<script type='text/javascript' src='/icmp/dwr/engine.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/util.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/rules/addRules.action" method="post" name="form" id="form" enctype="multipart/form-data" target="">
		<input type="hidden" name="res" id="res" value="" />
		<input type="hidden" id="isUploadFinished" value="" onclick="javascript:void(0)"/>
	    <div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">新增规章制度</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%" class="tableaddtitle"><span class="fonttsx">*</span>文件名称</td>
	          <td width="35%" class="tableadd_data" >
	                <input class="inputtran" id="fileName"  name="uploadFileVO.fileName" type="text" value="" />
	          </td>
	          <td width="15%" class="tableaddtitle"><span class="fonttsx">*</span>颁发单位</td>
	          <td width="35%" class="tableadd_data">
		          <input type="hidden" name="uploadFileVO.uploadKey" id="corpID" value="" />
		          <input name="uploadFileVO.departmentVO.title" id="corpName" type="text" class="inputtran" onclick="selectDepartments(this);" readonly="readonly"/>
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle"><span class="fonttsx">*</span>颁发时间</td>
	          <td class="tableadd_data"><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
	          	<input class="inputtran" onclick="WdatePicker({dateFmt:'yyyy-M-d'});" name="uploadFileVO.createTime" id="createTime" type="text" value="" readonly="readonly" />
	          </td>
	          <td class="tableaddtitle"><span class="fonttsx">*</span>发布人</td>
	          <td class="tableadd_data" >
	          	<input type="text" class="inputtran" name="uploadFileVO.userVO.name" id="names" readonly="readonly"  onclick="selectUsers(this);"/>
                <input type="hidden" name="uploadFileVO.createUserID" id="userID" class="" value=""/>
			 </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle"><span class="fonttsx">*</span>上传文件</td>
	          <td class="tableadd_data" colspan="3">
			    <input type="file" style="width: 48%" name="fileUrlTemp" id="upFileTemp" value="浏览" onchange="document.getElementById('uploadSpan').innerHTML='请上传文件'" />
			    <input type="button" value="点击上传" onclick="upload();" id="upFileBtn" class="stdbtn mlr10" style='padding: 3px 2px;' />
			    <input type="hidden" name="uploadFileVO.fileUrl" id="fileUrl1" value="" />
			    <span style="color: red" id="uploadSpan"></span><!-- id="fileUrl1" id="uploadSpan"都是上传的后台写入前台的id所以不可缺-->
			    <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
			    <img style="display: none" src="${sys_ctx }/meeting/File/img/empty.gif" title="" style="float: right" id="fileIco1"/>
			  </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">备注</td>
	          <td class="tableadd_data" colspan="3">
	          	<textarea class="areatran" name="uploadFileVO.description" id="description"></textarea>
			  </td>
	        </tr>
	       </table>
	       <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="javascript:backHistory();"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
	<script type="text/javascript">
		    <%--validate form--%>
	        function pageInit(){
				var obj = new htmlUtil();
				obj.title("fileName","输入长度为1-15的汉字或字符");
				obj.title("corpName","请选择");
				obj.title("createTime","请选择");
				obj.title("names","请选择");
				obj.title("upFileTemp","请上传文件");
				obj.title("description","不能超过500个字符");
	        }
	        $(document).ready(function(){
				pageInit();
				//默认显示当前日期
			     var curDate = new Date();
			     var curDateString = curDate.getFullYear()+"-"+(curDate.getMonth()+1)+"-"+curDate.getDate();
			     document.getElementById("createTime").value = curDateString;
			     //默认显示当前用户的姓名
	             document.getElementById("userID").value = "${sys_userSession.userID}";
	             document.getElementById("names").value = "${sys_userSession.name}";
		    })
		    
			function add(){    
				if(document.getElementById("fileUrl1").value){
					$('#form').validate({    
						rules:{    
						   "uploadFileVO.fileName" : {
					           required:true,
					           minlength:1,
					           maxlength:15
					           },
				           "uploadFileVO.departmentVO.title" : {
					           required:true
					           },
				           "uploadFileVO.createTime" : {
					           required:true
					           },
				           "uploadFileVO.userVO.name" : {
					           required:true
					           },
				           "fileUrlTemp" : {
					           required:true,
					           minlength:1,
					           maxlength:100
					           },
				           "uploadFileVO.description" : {
					           maxlength:500
					           }
							}
						});
					//$("#form").removeAttr("enctype");
					//防止struts解析file，因为struts2的普通request最大大小为200kb
					document.getElementById("upFileTemp").disabled = "disabled";
					document.getElementById("upFileBtn").disabled = "disabled";
					$("#form").submit();
				}else{
					alert("请上传文件！");
				}
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

	         //上传
	         function upload(){
				if(document.getElementById("upFileTemp").value){
					$("#form").attr("action","${sys_ctx }/fileupload?savePath=/file/upload/&maxSize=30&index=1");
					$("#form").attr("target","iframeTemp");
					document.getElementById('uploadSpan').innerHTML="正在上传...";
					document.getElementById('fileUrl1').value="";
					$("#form").submit();
					$("#form").attr("action","${sys_ctx }/rules/addRules.action");
					$("#form").attr("target","");
					//$("#form").removeAttr("enctype");
				}else{
					document.getElementById('uploadSpan').innerHTML="请先选择要上传的文件（MaxSize：30MB）";
				}
		     }

	         function backHistory(){
	           	window.location.href="${sys_ctx }/rules/manageRulesList.action";
	         }
		</script>
  </body>
</html>
