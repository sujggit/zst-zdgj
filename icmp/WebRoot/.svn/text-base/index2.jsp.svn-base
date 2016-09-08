<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<title>${sys_viewName }</title>
<link href="${sys_ctx }/style/blue/login.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="${sys_ctx }/style/blue/reset.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx }/style/blue/layout.css" type="text/css" />
<link rel="stylesheet" href="${sys_ctx }/style/blue/font.css" type="text/css" />


<script type="text/javascript">
	
		//add by yangyi
		document.onkeydown = function(e){
			//火狐
        	if(!e) e = window.event;
        	if((e.keyCode || e.which) == 13){
            	var login = document.getElementById("login1");
            	login.focus();
            	login.click();
        	}
    	}

		

		function pageInit(){
			var obj = new htmlUtil();
			obj.title("loginName","请输入登录用户名");
			obj.title("password","请输入登录密码");
			$("#loginName").focus();
		}
		
		
	
		function login(){
			var validator = $("#form").validate({   			
   		 		rules: {
       				"userVO.loginName":    {required: true,rangelength: [2, 100]},
					"userVO.passWord":    {required: true,rangelength: [2, 100]}
   			  	}
   	   		 });
			
       		$("#form").submit();
		}
	</script>
</head>
<body onload="pageInit();">
	<form action="${sys_ctx }/user/userLogin2.action" method="post" id="form" name="form" runat="server">
	<div class="header">
  <div class="headerlogo">
      <div class="headerlogobg"><img src="${sys_ctx }/images/blue/logobg.png" width="69" height="67" /></div><div class="titlehome fr font40wb">${sys_viewName }</div>
  </div>
</div>
 <div class="loginbg">
  <div class="dlbg">
    <div class="dltitle font40wb ac">用 户 登 录</div>
    <div class="user font18wb ac">       
      <ul><div><center><font color="red" size="2px">${info }</font></center></div>
        <li>用户名：
          <input type="text" name="userVO.loginName" id="loginName" class="input fontstyle"  value="" />
        </li>
        <li>密&nbsp;&nbsp;&nbsp;&nbsp;码：
          <input type="password" name="userVO.passWord" id="password"  class="input fontstyle" value="" />
        </li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="button" name="login1" id="login1" style="cursor:hand" value="登 录" onclick="login();"  class="botton font18wb" />
        </li>
      </ul>
    </div>
  </div>
</div>   
	</form>
</body>
</html>
