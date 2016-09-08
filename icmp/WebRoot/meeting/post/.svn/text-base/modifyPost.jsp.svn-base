<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/common/common.jsp"%>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<title>岗位详细信息</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<div id="basicform" class="contentwrapper">
	 <form action="${sys_ctx }/post/modifyPost.action" method="post" name="form" id="form">
	 <input type="hidden" name="postVO.id" value="${postVO.id }"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">岗位修改</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="25%" class="tableaddtitle"><span>*</span>岗位编号</td>
          <td width="75%" class="tableadd_data">
          	<input type="hidden" id="postNO" name="postVO.postNO" value="${postVO.postNO}" />
            <input id="postNO" class="inputtran" name="postVO.postNO" value="${postVO.postNO}" disabled="disabled"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>岗位名称</td>
          <td class="tableadd_data">
            <input id="postName" class="inputtran" name="postVO.postName" value="${postVO.postName}" onblur="javascript:checkName('postName');"/>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle" style="vertical-align:top;">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 述</td>
          <td class="tableadd_data" title="${postVO.description}">
          	<textarea rows="5" class="areatran" name="postVO.description" id="description">${postVO.description}</textarea>
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
     </form>
    </div>
    <script type="text/javascript">
	 function backHistory(){
        window.location.href="${sys_ctx}/post/managePostList.action";
     }
		
	function pageInit(){
	    var obj = new htmlUtil();
		obj.title("postNO","输入长度不超过25个字符");	
		obj.title("postName","输入长度不超过25个字符");	
		obj.title("description","输入长度不超过300个字符");	
	}
	
	function add(){
		$('#form').validate({    
		rules:{ 
			"postVO.postNO":{
				required: true,
				minlength:1,
           		maxlength:25
           		},
			"postVO.postName":    {
				required: true,
				minlength:1,
           		maxlength:25
           		},
           	"postVO.description":    {
               	maxlength:300
              }
		  	}
		});
		$("#form").submit();
	}

	<%--判断岗位名称是否唯一--%>
	function checkName(id){
		   var a=document.getElementById(id);
		   if(a.value==""||a.value==null||a.value=="${postVO.postName}"){
			 return;
		   }
		   DwrMethod.checkPostName(a.value,callback);
		}
			
	    function callback(lst){
	    	if(lst.length > 0){
		    	alert("此岗位名称已被占用");
		    	document.getElementById("postName").value="";  	
	    	}
		}

	$(document).ready(function(){
		pageInit();
	})
  </script>
</body>
</html>