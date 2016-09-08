<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>欢迎页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body class="bgsz">
<div class="topheader">
	<div class="left">
		<div class="toplogoimg"></div>
		<h1 class="logo">综合会议管理平台</h1>
		<span class="slogan">管理员您好，欢迎登录综合会议管理平台</span> <br clear="all" />
	</div>
		<!--left-->
	<div class="right">
		<ul class="buttonlist">
			<li>
                <div class="buttonlist_left"><img src="../style/normal/images/user.png" /></div>
                <div class="buttonlist_right">
                    <a href="welcome.jsp">首页</a> | <a href="#">帮助</a> | <a href="index.jsp">退出</a>
                </div>
            </li>
			<li>
				<div class="buttonlist_left"><img src="../style/normal/images/theme.png" /></div>
				<div class="buttonlist_right">
					<select>
						<option>更换主题</option><option>皮肤一</option><option>皮肤二</option>
					</select>
				</div>
			</li>
		</ul>
	</div>
</div>
<div class="header">
	<ul class="headermenu">
		<li><a href="main.jsp"><span class="icon icon-flatscreen"></span>视频会议</a></li>
		<li><a href="#"><span class="icon icon-znzyxt"></span>智能中央控制</a></li>
		<li><a href="#"><span class="icon icon-chart"></span>统计分析</a></li>
		<li><a href="#"><span class="icon icon-xtgl"></span>系统管理</a></li>
		<li><a href="#"><span class="icon icon-pzgl"></span>配置管理</a></li>
		<li><a href="#"><span class="icon icon-ssbs"></span>实施部署</a></li>
	</ul>
</div>
<div class="tables loginbg">
	<div class="loginmid">欢迎进入综合会议管理平台</div>
	<div class="loginmid2">Welcome To <span>I</span>ntegrated <span>C</span>onference <span>M</span>anagement <span>P</span>latform</div>
</div>
</body>
</html>