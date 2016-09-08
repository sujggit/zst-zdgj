<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>左侧菜单</title>
	<style>
		.left1{margin: 0px;padding: 0;color: #616161;font-size:14px;background:#f1f1f0;}
		.leftTitle{ background:url(images/topbg.png); color:#3D3D3D; height: 43;font-family:"微软雅黑";font-size:18px;font-weight:bold; line-height:34px;text-shadow:1px 1px 1px #999999;text-align: center;}
		.header{ padding: 10px;border-bottom:1px solid #7a7b79;min-height:20px;display:block; height:44px; weight:220px;font-family:"微软雅黑";font-size:16px;
				background:url(images/left.jpg) repeat-x ;cursor: pointer}
		.headerHover{background:url(images/left_2.jpg) repeat-x;cursor: pointer}
		.label { padding-left: 24px; background: no-repeat;float:left; font-family:"微软雅黑";font-size:16px;font-weight:bold;}
		.arrow{ display: block;width: 16px; height: 16px; background: no-repeat center; float: right;}
		.arrow.down{ background-image: url(images/arrow_d.png);}
		.arrow.up{ background-image: url(images/arrow_u.png);}
				
		tr td ul li { background-color: #ececec; padding: 12px; border-bottom: 1px solid #dcdcdc; border-top: 1px solid #fff; color: #727272; text-shadow: 0px 1px 0px rgba(255, 255, 255, 0.8);cursor:pointer;
					font-family:"微软雅黑";font-size:14px;font-weight:bold;}
		.liHover{ background-color: #D9D9D9; /* Old browsers */}
		.liActive{ background-color: #C0C0C0;}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
		$(".header").hover(function(){
			// $("#orderedlist li:last").hover(function() {~hover(over,out)
				$(this).addClass("headerHover");
			}, function() {
				$(this).removeClass("headerHover");
			});
		$("tr td ul li").hover(function() {
				$(this).addClass("liHover");
			}, function() {
				$(this).removeClass("liHover");
			});
		});
		function showmenu(div,sid){
		  var menu = document.getElementById("menu"+sid);
		  var uls = document.getElementsByTagName("ul");
		  var divs = document.getElementsByTagName("div");
		  if(menu.style.display == "none"){
		  	for(var i = 0;i < uls.length;i++){ //每次打开一个目录层级就代表着关闭剩余目录（互斥）
		  		uls[i].style.display = "none";
		  		} 
		  	menu.style.display="block";
		  	}else{ 
		  	menu.style.display="none";
		  }
		  	
		  var arrow = $(div).find("span.arrow");
				if(arrow.hasClass("up")){
					arrow.removeClass("up");
					arrow.addClass("down");
				} else if(arrow.hasClass("down")){ 
					$(".arrow").removeClass("up");
					$(".arrow").addClass("down");//修正部分细节
					arrow.removeClass("down");
					arrow.addClass("up");
				}
			}
		  function openNewCurrentFunction(obj,navigat){
				$("tr td ul li").removeClass("liActive");
				$(obj).addClass("liActive");
				var currentFrame =  parent.frames["currentFrame"];
			    var divObj = currentFrame.document.getElementById("currentLocation");
			    divObj.innerText = "当前位置："+navigat;
		  }//currentFrame中显示当前位置
	</script>
</head>
<body class="left1">
	<table width="180px" border="0" cellspacing="0" cellpadding="0" >
  		<tr>
			<td class="leftTitle" id="muteName">功能菜单</td>
 		 </tr>
	</table>
	<table width="180px" border="0" cellspacing="0" cellpadding="0" id="table" >
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,1);"> <span class="label" style="background-image: url(images/messages.png);" >预定会议</span> 
					<span  class="arrow down"></span> </div>
			</td>
		</tr>
		<tr>
			<td>
				<ul style="display:none" id="menu1">
	                <li onclick="window.parent.openNewFunction('../conference/conferenceList.action');openNewCurrentFunction(this,'预定会议 &rArr; 会议预约')">
	                	会议预约</li>
	             </ul>
			</td>
		</tr>
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,2);"> <span class="label" style="background-image: url(images/messages.png);" >会议过程管理</span> 
					<span class="arrow down"></span> </div>
			</td>
		</tr>
		<tr>
			<td>
				<ul style="display:none" id="menu2">
	            	<li class="selected" onclick="window.parent.openNewFunction('../detailf7/queryLocalConference.action'); openNewCurrentFunction(this,'会议过程管理 &rArr; 会议信息')">
	                	会议信息</li>
	                <li onclick="window.parent.openNewFunction('../mcuControlf7/getClassifiedRoomList.action'); openNewCurrentFunction(this,'会议过程管理 &rArr; 会议控制')">
	                	会议控制</li>
	           	</ul>
			</td>
		</tr>
				
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,3);"> <span class="label" style="background-image: url(images/messages.png);" >预警监测</span> 
					<span class="arrow down"></span> </div>
			</td>
		</tr>
				
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,4);"> <span class="label" style="background-image: url(images/messages.png);" >统计分析</span> 
					<span class="arrow down"></span> </div>
			</td>
		</tr>
		<tr>
			<td>
				<ul style="display:none" id="menu4">
	                <li class="selected" onclick="window.parent.openNewFunction('../statistics/queryNum.action'); openNewCurrentFunction(this,'统计分析 &rArr; 会议室使用次数')">
	                	会议室使用次数</li>
	                <li onclick="window.parent.openNewFunction('../statistics/query.action'); openNewCurrentFunction(this,'统计分析 &rArr; 会议室使用时长')">
	                	会议室使用时长</li>
					<li onclick="window.parent.openNewFunction('../log/query.action'); openNewCurrentFunction(this,'统计分析 &rArr; 日志管理')">
						日志管理</li>
	             </ul>
			</td>
		</tr>
				
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,5);"> <span class="label" style="background-image: url(images/messages.png);" >配置管理</span> 
					<span class="arrow down"></span> </div>
			</td>
		</tr>
		<tr>
			<td>
				<ul style="display:none" id="menu5">
	               	<li class="selected" onclick="window.parent.openNewFunction('../config/getConfigInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 系统配置')">
	                	系统配置</li>
	                <li onclick="window.parent.openNewFunction('../baseInfo/mcuAdd.action'); openNewCurrentFunction(this,'配置管理 &rArr; 添加MCU模板')">
						添加MCU模板</li>
					<li onclick="window.parent.openNewFunction('../user/getUserBaseInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 修改密码')">
						修改密码</li>
					<li onclick="window.parent.openNewFunction('../user/getUserBaseInfo.action'); openNewCurrentFunction(this,'配置管理 &rArr; 提取MCU模板')">
						提取MCU模板</li>
					<li onclick="window.parent.openNewFunction('../email/addEmailBefore.action'); openNewCurrentFunction(this,'配置管理 &rArr; 邮件配置')">
						邮件配置</li>
					<li onclick="window.parent.openNewFunction('../equipmentControl/fixedTimeBefore.action'); .openNewCurrentFunction(this,'配置管理 &rArr; 定时开关')">
						定时开关</li>
	          	</ul>
			</td>
		</tr>
				
		<tr style=" width: 180px; height: 44px;">
			<td>
				<div class="header" onclick="showmenu(this,6);"> <span class="label" style="background-image: url(images/messages.png);" >系统管理</span> 
					<span class="arrow down"></span> </div>
			</td>
		</tr>
		<tr>
			<td>
				<ul style="display:none" id="menu6">
	                <li class="selected" onclick="window.parent.openNewFunction('../meetingRoom/query.action'); openNewCurrentFunction(this,'系统管理 &rArr; 会议室管理')">
	                	会议室管理</li>
	                <li onclick="window.parent.openNewFunction('../equipment/query.action'); openNewCurrentFunction(this,'系统管理 &rArr; 设备管理')">
						设备管理</li>
					<li onclick="window.parent.openNewFunction('../meeting/department/departmentTreeEdit.jsp'); openNewCurrentFunction(this,'系统管理 &rArr; 部门管理')">
						部门管理</li>
					<li onclick="window.parent.openNewFunction('../meeting/address/addressTreeEdit.jsp'); openNewCurrentFunction(this,'系统管理 &rArr; 添加MCU模板')">
						区域管理</li>
					<li onclick="window.parent.openNewFunction('../user/manageUserList.action'); openNewCurrentFunction(this,'系统管理 &rArr; 用户管理')">
						用户管理</li>
					<li onclick="window.parent.openNewFunction('../role/manageRoleList.action'); openNewCurrentFunction(this,'系统管理 &rArr; 权限管理')">
						权限管理</li>
	         	</ul>
			</td>
		</tr>		
	</table>
</body>
</html>