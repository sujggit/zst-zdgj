<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@page import="com.zzst.action.meeting.util.task.DateConnection"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="sys_ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="sys_viewName" value="<%=com.zzst.action.meeting.util.MeetingAppConfig.APP_NAME %>"></c:set>
<c:set var="sys_userSession" value="${user_session}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/engine.js'></script>
  <script type='text/javascript' src='${sys_ctx }/dwr/util.js'></script>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DataPollServiceDwr.js'></script>
  
  <title></title>
  <script language="javascript">
	function retshouye(){
		//window.parent.location.reload();
		parent.document.getElementById('leftMenu').cols="0,*";
		var a = window.top.document.getElementById("rightFrame");
		//var b = window.top.document.getElementById("leftFrame");
		var d=window.top.document.getElementById("topFrame");
		var e=window.top.document.getElementById("currentFrame");
		e.src = "${sys_ctx }/layout/inc1/current.jsp";
		d.src="${sys_ctx }/layout/inc1/top.jsp";
		a.src = "${sys_ctx }/layout/inc1/welcom.jsp";
		//b.src = "${sys_ctx }/layout/inc1/left.jsp";
		var c = window.top.document.getElementById("menueFrame");
		c.src = "${sys_ctx }/layout/inc1/menu.jsp";
		var c = window.top.document.getElementById("bottomFrame");
		c.src = "${sys_ctx }/layout/inc1/copyRight.jsp";
	}
	function goback(){
		window.parent.location.reload();
	}
	
	function exit(){
		if(confirm("确定退出吗？")){
			window.parent.location.href = "${sys_ctx }/user/userExit.action";
		}
	}
	function InitCss(){
	  var currentSkin=document.getElementById("currentSkin").value;
	 // alert(currentSkin);
	 clickMe();
	}
	
	
	$(document).ready(function(){
		var cssPath = getCookie("cssPath");
	    //var currentSkin = frames[0].document.getElementById("currentSkin");
	    $("#currentSkin").val(cssPath);
	})
	/*
	function changeCss(winObj, cssPath){  
	        //switchSkin(id); 
	        
	       alert("come in");
	        $("#cssfile").attr(" /icmp/style/"+cssPath+"/css/style.default.css"); //设置不同皮肤  
	        try{  
	            $(window.parent.frames['topFrame'].document).find("#cssfile")  
	                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给顶部换肤  
	            $(window.parent.frames['leftFrame'].document).find("#cssfile")  
	                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给左树换肤  
	            $(window.parent.frames['rightFrame'].document).find("#cssfile")  
                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给右窗体换肤  
                $(window.parent.frames['menueFrame'].document).find("#cssfile")  
                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给菜单窗体换肤 
                $(window.parent.frames['currentFrame'].document).find("#cssfile")  
                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给当前窗体换肤 
                $(window.parent.frames['bottomFrame'].document).find("#cssfile")  
                                    .attr(" /icmp/style/"+cssPath+"/css/style.default.css");//给底部窗体换肤 
	        }catch(e){ }  
	        $.cookie( "b2cPlatform" ,  cssPath , { path: '/', expires: 10 });//皮肤名称设置的cookie中  
	    }  
	
	*/
	
	//隐藏的点击事件
	function clickMe(){
	//    	alert("执行clickMe方法！");
     	dwr.engine.setActiveReverseAjax(true);
//		DataPollServiceDwr.pollDataToAllPage();

 	}
 	
 	function initNew(){
// 		alert("执行ONLOAD方法！");
 		clickMe();
 	}
  </script>
</head>
<body class="bodywrapper" onload="InitCss();">

  <div>
  	<div style="display:none">
  		<button style="VISIBILITY: hidden" onclick="clickMe();">请求服务器推送数据给当前登录的用户</button>
  	</div>
	<div class="topheader">
    	<div class="left">
      		<div class="toplogoimg"></div>
      		<%
      		String yjstr="";
      		if(DateConnection.isBak){
      		yjstr="(应急)";
      		}
      		 %>
      		<h1 class="logo">${sys_viewName }<font color="red"><%=yjstr %></font></h1>
      		<span class="slogan"><a style="color:#eee" onclick="window.parent.openNewFunction('/icmp/personConfig/getPersonInfo.action','修改个人信息','');">${sys_userSession.name}</a>&nbsp;&nbsp;您好!</span> <br clear="all" />
    	</div>
    <!--left-->
	    <!-- div class="right">
	      <ul class="buttonlist">
	        <li><a  onclick="window.parent.openNewFunction('/icmp/personConfig/getPersonInfo.action');window.parent.openNewCurrentFunction1('修改个人信息')"  class="btn btn_user"><span>${sys_userSession.loginName}</span></a></li>
	        <li onclick="retshouye();" style="cursor:pointer"><a  class="btn btn_home"><span>首页</span></a></li>
	        <li onclick="exit();" style="cursor:pointer"><a  class="btn btn_link"><span>退出</span></a></li>
	        <li>
	            <a class="btn btn_user">
	            <span>
	            <select style="border:none" onchange=changeCss(window.top,this.value)>
	               <option value="normal" selected="selected">默认皮肤</option>
	               <option value="normalNew">翠绿</option> 
	               </select>
	               </span>
	               </a>
	        </li>
	      </ul>
	       
	    </div-->
    <div class="right">
      <ul class="buttonlist">
      	<li>
        	<div class="buttonlist_left">
            	<a title="修改个人信息" onclick="window.parent.openNewFunction('/icmp/personConfig/getPersonInfo.action','修改个人信息','');" ><img src="${sys_style1}/images/user.png" /></a>
            </div>
            <div class="buttonlist_right">
                <a href="#" onclick="goback();" style="cursor:pointer">首页</a> | <a href="/icmp/helper/HerlperexportQuery.action">帮助</a> | <a href="#"  onclick="exit();" style="cursor:pointer">退出</a> | <a href="#"  onclick="javascript:window.showModalDialog('/icmp/about.jsp',window,'dialogHeight:400px;dialogWidth:650px')"; style="cursor:pointer">关于</a>
            </div>
        </li>
        <li>
        	<div class="buttonlist_left">
            	<img src="${sys_style1}/images/theme.png" />
            </div>
            <div class="buttonlist_right">
            	<select style="border:none" onchange=changeCss(window.top,this.value) id="currentSkin">
                	<zzst:option type="changeCSS" value="${dictionaryVO.dicType}"/>
                </select>
            </div>
        </li>
      </ul>
    </div>
    <!--right--> 
  	</div>
  </div>
</body>
</html>