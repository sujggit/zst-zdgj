<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>登录页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body class="loginpage">
	<div class="loginbox">
		<div class="loginboxinner">
			<div class="logo">
				<h1><span><img src="${sys_ctx }/images/zst.png" width="71" height="38" /></span></h1>
				<div class="divline"></div>
				<p>
					<h1><span>综合会议管理平台</span></h1>
				</p>
			</div>
			<br clear="all" />
			<div class="nousername">
				<div class="loginmsg">用户名不能为空！</div>
			</div>
			<div class="nopassword">
				<div class="loginmsg">密码不能为空！</div>
			</div>
			<form id="login" action="welcome.jsp" method="post">
				<ul>
					<li class="username">
						<div class="usernameinner">
							<input type="text" name="username" id="username" />
						</div>
					</li>
					<li class="password">
						<div class="passwordinner">
							<input type="password" name="password" id="password" />
						</div>
					</li>
				</ul>
				<button>登 录</button>
				<div class="keep" align="center">Copyright © Transtrue  Inc. All rights reserved.</div>
			</form>
		</div>
	</div>	
</body>
</html>






