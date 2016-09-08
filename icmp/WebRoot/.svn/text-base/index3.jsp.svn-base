<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.action.meeting.util.MeetingAppConfig" %>
<%@ page import="java.sql.Timestamp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<%@include file="/common/common.jsp"%>
	<script type="text/javascript" src="${sys_ctx }/style/normal/js/plugins/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="${sys_ctx }/style/normal/js/custom/index.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>${sys_viewName }</title>
	<script type="text/javascript">
		//add by yangyi
		document.onkeydown = function(e){
			//火狐
        	if(!e) e = window.event;
        	if((e.keyCode || e.which) == 13){
            	var login = document.getElementById("login3");
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
       				"userVO.loginName":    {required: true,rangelength: [1, 100]},
					"userVO.passWord":    {required: true,rangelength: [1, 100]}
   			  	}
   	   		 });
       		$("#form").submit();
		}
	</script>
  </head>
  <body class="loginpage" onload="pageInit();">
	<div class="loginbox">
    	<div class="loginboxinner">
            <div class="logo">
           	  <div class="logoImg"></div>
              <div class="divline"></div>
              <p>
              <h1><span>${sys_viewName }</span></h1>
              </p>
          </div>
          <!--logo-->
            <form action="/icmp/user/userLogin.action" method="post" id="form" name="form" runat="server">
            <input type="hidden" name="formId" id="formId" value="${param.formId }"/>
  			<input type="hidden" name="entryId" id="entryId" value="${param.entryId }"/>
           <ul>
             <div><center><font color="red" size="2px">${info }</font></center></div> 
                <li class="username">
                	<div class="usernameinner">
                    	<input type="text" name="userVO.loginName" id="loginName" value=""/>                    	
                    </div>
                </li>
                <li class="password">
                	<div class="passwordinner">
                    	<input type="password" name="userVO.passWord" id="password" value="" />
                    </div>
                </li>
           </ul> 
           
           <!-- 授权验证 -->
           <c:if test="${authorizatione == 'no' }">
           		<button type="button" name="login1" id="login3"  onclick="login();" disabled="disabled">登 录</button>
           </c:if>
           <c:if test="${authorizatione != 'no' }">
                 <button type="button" name="login1" id="login3" onclick="login();">登 录</button>
           </c:if>

               
         <!--   <div class="keep" align="center">${sys_copyright }</div> -->
         <div class="keep" align="center" >
         <%
         if(MeetingAppConfig.authorization_date!=null&&MeetingAppConfig.authorization_date.before(new Timestamp(System.currentTimeMillis()))){
         %>
         	<a href="#"  onclick="javascript:window.showModalDialog('/icmp/about.jsp',window,'dialogHeight:400px;dialogWidth:650px')"; style="cursor:pointer">关&nbsp;&nbsp;于</a>
         <%
         }
          %>
         </div>
         </form>
       </div><!--loginboxinner-->
    </div><!--loginbox-->
  </body>
</html>