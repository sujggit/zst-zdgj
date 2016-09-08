<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧菜单</title>
<style>
	.fontmenu{font-size:16px; color:#07487f; font-family:\5FAE\8F6F\96C5\9ED1; font-weight:bold;}

	.menuBlue{ background: #4169E1;}
	.styleblue{ background: #4169B1;}
</style>
<script type="text/javascript">
$(document).ready(function() {
$(".lefttd.fontmenu.ac").hover(function() {
	// $("#orderedlist li:last").hover(function() {
		$(this).addClass("menuBlue");
	}, function() {
		$(this).removeClass("menuBlue");
	});
$(".lefttd.fontstyle.ac").hover(function() {
	// $("#orderedlist li:last").hover(function() {
		$(this).addClass("styleblue");
	}, function() {
		$(this).removeClass("styleblue");
	});
});
</script>
<script>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
  function openNewCurrentFunction(obj,navigat){
  		// selectedTd(obj);
		var currentFrame =  parent.frames["currentFrame"];
	    var divObj = currentFrame.document.getElementById("currentDiv");
	    divObj.innerText = "当前位置："+navigat;
  }//currentFrame中显示当前位置
</script>
</head>

<body>
<div class="left">

	<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td class="lefttitle ac " style="font-size:22px; color:#07487f; font-family:\82F9\679C\4E3D\4E2D\9ED1; font-weight:bold;" id="muteName">功能菜单</td>
	    </tr>
    </table>
    
  <table id="menuTable" width="100%" border="0" cellspacing="0" cellpadding="0">

    <%--<tr>
      <td class="lefttd fontstyle ac" id="td2">
      	<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../detail/manageMeetingTemplateList.action');window.parent.openNewCurrentFunction(this,'常用菜单 &rArr; 会议模板')">会议模板</span>
      </td>
    </tr>--%>
     <tr>
      	<td class="lefttd fontmenu ac"  id="td1">
      		<span  style="cursor:pointer" onclick="showsubmenu(1);">预定会议</span>
		</td>
    </tr>
    <TR>
          <TD><TABLE id=submenu1 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center" style="display: none;">
              <TBODY>
     <tr>
      <td class="lefttd fontstyle ac" id="td11">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../conference/conferenceList.action');openNewCurrentFunction(this,'预定会议 &rArr; 会议预约')">会议预约</span>
	  </td>
    </tr>
              </TBODY>
          </TABLE></TD>
        </TR>
    
    <tr>
      	<td class="lefttd fontmenu ac"  id="td2">
      		<span  style="cursor:pointer" onclick="showsubmenu(2);">会议过程管理</span>
		</td><!-- 视频会议系统、视频监控系统 -->
    </tr>
    <TR>
          <TD><TABLE id=submenu2 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center" style="display: none;">
              <TBODY>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td21">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../detailf7/queryLocalConference.action'); openNewCurrentFunction(this,'会议过程管理 &rArr; 会议信息')">会议信息</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td22">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../mcuControlf7/getClassifiedRoomList.action'); openNewCurrentFunction(this,'会议过程管理 &rArr; 会议控制')">会议控制</span>
		</td>
    </tr>
              </TBODY>
          </TABLE></TD>
        </TR>
    
    <tr>
      	<td class="lefttd fontmenu ac"  id="td3">
      		<span  style="cursor:pointer" onclick="">预警监测</span>
		</td>
    </tr>
    
    <tr>
      	<td class="lefttd fontmenu ac"  id="td4">
      		<span  style="cursor:pointer" onclick="showsubmenu(4);">统计分析</span>
		</td>
    </tr>
    <TR>
          <TD><TABLE id=submenu4 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center" style="display: none;">
              <TBODY>
                 <tr>
      <td class="lefttd fontstyle ac" id="td41">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../statistics/queryNum.action'); openNewCurrentFunction(this,'统计分析 &rArr; 会议室使用次数')">会议室使用次数</span>
	  </td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td42">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../statistics/query.action'); openNewCurrentFunction(this,'统计分析 &rArr; 会议室使用时长')">会议室使用时长</span>
		</td>
    </tr>
     <tr>
      	<td class="lefttd fontstyle ac" id="td43">
      		<span style="cursor:pointer"  onclick="window.parent.openNewFunction('../log/query.action'); openNewCurrentFunction(this,'统计分析 &rArr; 日志管理')">日志管理 </span>
		</td>
    </tr>
              </TBODY>
          </TABLE></TD>
        </TR>
        
    <tr>
      	<td class="lefttd fontmenu ac"  id="td5">
      		<span  style="cursor:pointer" onclick="showsubmenu(5);">配置管理</span>
		</td>
    </tr>
    <TR>
          <TD><TABLE id=submenu5 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center" style="display: none;">
              <TBODY>
     <tr>
      <td class="lefttd fontstyle ac" id="td51">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../config/getConfigInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 系统配置')">系统配置</span>
	  </td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td52">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../baseInfo/mcuAdd.action'); openNewCurrentFunction(this,'配置管理 &rArr; 添加MCU模板')">添加MCU模板</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td53">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../user/getUserBaseInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 修改密码')">修改密码</span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td54">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../user/getUserBaseInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 提取MCU模板')">提取MCU模板</span>
		</td>
    </tr>
     <tr>
      	<td class="lefttd fontstyle ac" id="td55">
      		<span style="cursor:pointer"  onclick="window.parent.openNewFunction('../email/addEmailBefore.action'); openNewCurrentFunction(this,'配置管理 &rArr; 邮件配置')">邮件配置 </span>
		</td>
    </tr>
    <tr>
      <td class="lefttd fontstyle ac" id="td56">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../equipmentControl/fixedTimeBefore.action'); .openNewCurrentFunction(this,'配置管理 &rArr; 定时开关')">定时开关</span>
	  </td>
    </tr>
    
              </TBODY>
          </TABLE></TD>
        </TR>
    
    <tr>
      	<td class="lefttd fontmenu ac"  id="td6">
      		<span  style="cursor:pointer" onclick="showsubmenu(6);">系统管理</span>
		</td>
    </tr>
    <TR>
          <TD><TABLE id=submenu6 cellSpacing=0 cellPadding=0 width="90%" border=0 align="center" style="display: none;">
              <TBODY>
      <tr>
      	<td class="lefttd fontstyle ac" id="td61">
      		<span style="cursor:pointer"  onclick="window.parent.openNewFunction('../meetingRoom/query.action'); openNewCurrentFunction(this,'系统管理 &rArr; 会议室管理')">会议室管理 </span>
		</td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td62">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../equipment/query.action'); openNewCurrentFunction(this,'系统管理 &rArr; 设备管理')">设备管理</span>
		</td>
    </tr>
     <tr>
      <td class="lefttd fontstyle ac" id="td63">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../meeting/department/departmentTreeEdit.jsp'); openNewCurrentFunction(this,'系统管理 &rArr; 部门管理')">部门管理</span>
	  </td>
    </tr>
    <tr>
      	<td class="lefttd fontstyle ac"  id="td64">
      		<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../meeting/address/addressTreeEdit.jsp'); openNewCurrentFunction(this,'系统管理 &rArr; 添加MCU模板')">区域管理</span>
		</td>
    </tr>
    <tr>
      <td class="lefttd fontstyle ac" id="td65">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../user/manageUserList.action'); openNewCurrentFunction(this,'系统管理 &rArr; 用户管理')">用户管理</span>
	  </td>
    </tr>
     <tr>
      <td class="lefttd fontstyle ac" id="td66">
			<span  style="cursor:pointer" onclick="window.parent.openNewFunction('../role/manageRoleList.action'); openNewCurrentFunction(this,'系统管理 &rArr; 权限管理')">权限管理</span>
	  </td>
    </tr>
            </TBODY>
          </TABLE></TD>
        </TR>
    
  </table>
</div>
</body>
</html>
