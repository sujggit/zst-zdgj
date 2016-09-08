<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
  <title>添加岗位 </title>
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
		check("postNO");
		checkName("postName");
		$("#form").submit();
	}
	<%--判断岗位名是否唯一--%>
	function check(id){
		var postNO = document.getElementById(id).value;
		if(postNO==""||postNO==null){
			return;
		}
		DwrMethod.checkPostNo(postNO,callbackNO);
	}
	function callbackNO(lst){
		if(!lst){
			alert("岗位编号已经存在，请重新输入新的岗位编号");
			document.getElementById("postNO").value="";
		}
	}
	<%--判断岗位名称是否唯一--%>
	function checkName(id){
		   var a=document.getElementById(id);	  
		   if(a.value==""||a.value==null){
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
  </script>
</head>
<body onload="pageInit();">
  <div id="basicform" class="contentwrapper">
	<form action="${sys_ctx }/post/addPost.action" 	method="post" name="form" id="form">
	  <input type="hidden" name="postVO.createUserID" id="userID" value="${sys_userSession.userID}"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">岗位增加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="25%" class="tableaddtitle"><span>*</span>岗位编号</td>
          <td width="75%" class="tableadd_data" ><input id="postNO" class="inputtran" name="postVO.postNO" onblur="javascript:check('postNO');"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>岗位名称</td>
          <td class="tableadd_data"><input id="postName" class="inputtran" name="postVO.postName" onblur="javascript:checkName('postName');"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle" style="vertical-align:top;">描述</td>
          <td class="tableadd_data"><textarea rows="5" class="areatran" name="postVO.description" id="description"></textarea></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
  </form>
  </div>
</body>
</html>