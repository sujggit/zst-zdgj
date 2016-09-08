<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧菜单</title>

</head>

<body>
<div class="left">

	<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td class="lefttitle ac font12wb"  id="muteName">常用菜单</td>
	    </tr>
    </table>
    
  <table id="menuTable" width="100%" border="0" cellspacing="0" cellpadding="0">

    <%--<tr>
      <td class="lefttd fontstyle ac" id="td2">
      	<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../detail/manageMeetingTemplateList.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 会议模板')">会议模板</span>
      </td>
    </tr>
    --%><tr>
      <td class="lefttd fontstyle ac" id="td3">
			
				<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../conference/conferenceList.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 会议预约')">会议预约</span>
	  </td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td4">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../detail/queryLocalConference.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 会议管理')">会议管理</span>
		</td>
    </tr>
     <tr>
      	<td class="lefttd fontstyle ac" id="td5">
      		<span style="cursor:pointer"  onclick="window.parent.openNewFunction('../user/getUserBaseInfo.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 修改密码')">修改密码 </span>
		</td>
    </tr>
    
    <%--<tr>
      <td class="lefttd fontstyle ac" id="td3">
			
				<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../f7conference/conferenceList.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 会议预约')">我的会议预约</span>
	  </td>
    </tr>--%>
     <%--<tr>
      	<td class="lefttd fontstyle ac"  id="td6">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../config/getConfigInfo.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 修改配置')">修改配置</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td7">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../equipmentControl/getLiftingScreen.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 升降屏控制')">升降屏控制</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td8">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../equipmentControl/getPlasmaTV.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 等离子控制')">等离子控制</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td9">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../equipmentControl/getLightControl.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 灯光控制')">灯光控制</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td11">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../notice/queryLocalConference.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 告示发布')">告示发布</span>
		</td>
    </tr>
    <tr>
      <td class="lefttd fontstyle ac"  id="td12">
      	<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../notice/showNoticeInfo.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 告示信息')">告示信息</span>
	  </td>
    </tr>
    <tr>
      <td class="lefttd fontstyle ac"  id="td13">
      	<span  style="cursor:pointer" onclick="window.parent.openNewFunction('/icmp/meeting/notice/noticeTodayList.jsp');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 告示列表')">告示列表</span>
	  </td>
    </tr>
    --%>
  </table>
</div>
</body>
</html>
