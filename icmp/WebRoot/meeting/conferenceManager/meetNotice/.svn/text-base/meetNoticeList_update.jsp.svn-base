<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>修改公告</title>
		<script type='text/javascript' src='/icmp/dwr/engine.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/util.js'> </script>
		<script type='text/javascript' src='/icmp/dwr/interface/DwrMethod.js'></script>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/messageNotice/updateMessageNotice.action" method="post" name="form" id="form" enctype="multipart/form-data" target="">
		<input type="hidden" name="messageContent.id" id="res" value="${messageContent.id }" />
	    <div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">修改公告</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="15%" class="tableaddtitle"><span class="fonttsx">*</span>公告标题</td>
	          <td width="35%" class="tableadd_data" >
	           <input class="inputtran" id="messageSubject"  name="messageContent.messageSubject" type="text" value="${messageContent.messageSubject }" />
	          </td>
	          <td width="15%" class="tableaddtitle"><span class="fonttsx">*</span>发布人</td>
	          <td width="35%" class="tableadd_data">
		          <input name="flowIdContName" id="flowIdContName" type="text" class="inputtran" readonly="readonly" value="${messageContent.flowIdCont }"/>
	          </td>
	        </tr>
	        <%--<tr>
	          <td class="tableaddtitle"><span class="fonttsx">*</span>发布时间</td>
	          <td class="tableadd_data" colspan="3">
	          <fmt:formatDate value="${messageContent.insertTime }"  pattern="yyyy-MM-dd"/>
	          </td>
	          
	          
	        </tr>--%>
	       
	        <tr>
	          <td class="tableaddtitle"><span class="fonttsx">*</span>公告内容</td>
	          <td class="tableadd_data" colspan="3">
	          	<textarea class="areatran" name="messageContent.messageBody" id="messageBody">${messageContent.messageBody }</textarea>
			  </td>
	        </tr>
	       </table>
	       <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		                <input class="submit1 radius2" type="button" name="addButton" id="addButton" value="发布"  onclick="add('1');"/>
		            	<input class="submit1 radius2" type="button" name="addButton" id="addButton" value="保存为草稿"  onclick="add('0');"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="javascript:backHistory();"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
		<input type="hidden" name="messageContent.ifSuccess" id="ifSuccessID"/>
	</form>
	<script type="text/javascript">
		    <%--validate form--%>
	        function pageInit(){
				var obj = new htmlUtil();
				obj.title("messageSubject","输入长度为1-15的汉字或字符");
//				obj.title("flowIdContName","请选择");
				//obj.title("insertTime","请选择");
				obj.title("messageBody","不能超过500个字符");
	        }
	        $(document).ready(function(){
				pageInit();
				//默认显示当前日期
			     var curDate = new Date();
			     var curDateString = curDate.getFullYear()+"-"+(curDate.getMonth()+1)+"-"+curDate.getDate();
//			     document.getElementById("insertTime").value = curDateString;
			     //默认显示当前用户的姓名
//	             document.getElementById("flowIdCont").value = "${sys_userSession.userID}";
	             document.getElementById("flowIdContName").value = "${sys_userSession.name}";
		    })
		    
			function add(ifsuccess){  
			    if(ifsuccess=="0"){
			    document.getElementById("ifSuccessID").value="0";
			    }
			      if(ifsuccess=="1"){
			    document.getElementById("ifSuccessID").value="1";
			    }
			    
				if(1==1){
					$('#form').validate({    
						rules:{    
						   "messageContent.messageSubject" : {
					           required:true,
					           minlength:1,
					           maxlength:15
					           },
				           "messageContent.flowIdCont" : {
					           required:true
					           },
//				           "messageContent.insertTime" : {
//					           required:true
//					           },
				           "messageContent.messageBody" : {
					           required:true
					           }
							}
						});
					
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
	         

	         function backHistory(){
	           	window.location.href="${sys_ctx }/messageNotice/queryAll.action";
	         }
		</script>
  </body>
</html>
