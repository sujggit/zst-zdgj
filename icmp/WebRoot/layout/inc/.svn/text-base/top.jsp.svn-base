<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script language="javascript">
	function retshouye(){
		var a = window.top.document.getElementById("rightFrame");
		var b = window.top.document.getElementById("leftFrame");
		a.src = "${sys_ctx }/layout/inc/welcom.jsp";
		b.src = "${sys_ctx }/layout/inc/left.jsp";
		var c = window.top.document.getElementById("menueFrame");
		c.src = "${sys_ctx }/layout/inc/menu.jsp";
	}

	//add by yangyi
	function exit(){
		if(confirm("确定退出吗？")){
			window.parent.location.href = "${sys_ctx }/user/userExit.action";
		}
	}
	
</script>
</head>
<body>
<div class="header">
  <div class="headerlogo">
  <div class="headerlogobg"><img src="${sys_ctx }/images/blue/logobg.png" width="69" height="67" /></div>
  <div class="titlehome fr font40wb">${sys_viewName }</div>
  </div>
  <div class="headertext">
    <ul>
      <li class="font12wb" onclick="retshouye();" style="cursor:pointer" ><img src="${sys_ctx }/images/blue/top_home.gif" width="16" height="15" alt="首页" />首页</li>
      <%--<li class="font12wb" style="cursor:pointer" ><img src="${sys_ctx }/images/blue/top_help.gif" width="16" height="15" alt="帮助" />帮助</li>--%>
      <li class="font12wb" onclick="exit();" style="cursor:pointer" ><img src="${sys_ctx }/images/blue/top_exit.gif" width="16" height="15" alt="退出" />退出</li>
    </ul>
  </div>
</div>
</body>
</html>
