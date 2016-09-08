<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>隐藏</title>
<style>
.middle{width:9px; height:auto; background:#C9C9C9;min-height:560px;
_height: 560px;display:table-cell; vertical-align:middle; border-right:1px solid #696969;padding-bottom: 32767px;
 margin-bottom: -32767px; 
}
</style>
<script type="text/javascript" language="JavaScript">
	var LEFT_MENU_VIEW=1;
	function leftmenu_open()
	{
	   LEFT_MENU_VIEW=0;
	   leftmenu_ctrl();
	}
	
	function leftmenu_ctrl()
	{
	   if(LEFT_MENU_VIEW==0){
		  parent.secmainbody.cols="180,10,*";
	      LEFT_MENU_VIEW=1;
		  switchpoint.innerHTML="<img style='cursor:pointer' src='${sys_ctx}/images/blue/to_left.gif' />";
	   }else{
	      parent.secmainbody.cols="0,10,*";
	      LEFT_MENU_VIEW=0;
		  switchpoint.innerHTML="<img style='cursor:pointer' src='${sys_ctx}/images/blue/to_right.gif' />";
	   }
	}
</script>
</head>

<body>
	<div class="middle" style="height:100%;" >
		<img src="images/main_18.gif" id=switchpoint title="显示/隐藏左导航" onclick="leftmenu_ctrl();" style="cursor:pointer"  width="9" height="158" />
	</div>
</body>
</html>
