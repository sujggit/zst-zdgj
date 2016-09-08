<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file="/common/common.jsp"%>
    <title>大事记详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			margin: 5px;
		}
	</style>
    <script type="text/javascript" src="${sys_ctx }/dwr/interface/DwrMethod.js"></script>
    <script type="text/javascript">
    	function exportWord(){
    		window.location.href = "/icmp/schedule/exportSchedule.action";
    		return
    		DwrMethod.exporWord("1月20日_测试会议在本公司召开，xxx主持会议。===备注信息===。xxx，xxx，xxx等出席会议。,同日_测试会议在本公司召开，xxx主持会议。===备注信息===。xxx，xxx，xxx等出席会议。","C:/Users/wxw/Desktop",function callback(flag){
    			if(flag){
					alert("文件导出到C:/Users/wxw/Desktop");
				}else{
					alert("导出失败");
				}
    		
    		});
    	}
	function test(path) {
		document.execCommand("saveas", "",".htm");
	}
    </script>
  </head>
  
  <body>
    <h3 style="color: #486494; font-family: 微软雅黑;">&nbsp;2016年1月</h3>
    <br>
    <hr size="2px;"><br>
  <div> <!-- align="center" style="text-align: center;" -->
  	&nbsp;&nbsp;<input value="1月20日"><br>
  	&nbsp;&nbsp;&nbsp;<textarea rows="5" cols="">测试会议在本公司召开，xxx主持会议。===备注信息===。xxx,xxx,xxx等出席会议。</textarea>
  	&nbsp;&nbsp;<input value="同日"><br>
  	&nbsp;&nbsp;&nbsp;<textarea rows="5" cols="">测试会议在本公司召开，xxx主持会议。===备注信息===。xxx,xxx,xxx等出席会议。</textarea>
  	
  </div>
  <div align="center">
  	<button class="submit1" onclick="test();">保存</button>
 	<button class="submit1" onclick="exportWord('path');">列入大事记</button>
  </div>
  </body>
</html>
