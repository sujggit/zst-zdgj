<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src='<%=request.getContextPath() %>/dwr/engine.js'></script>
 <script src='<%=request.getContextPath() %>/dwr/util.js'></script>
 <script src='<%=request.getContextPath() %>/dwr/interface/DataPollService.js'></script>
 <script type="text/javascript">
 function clickMe(){
    //alert()
     dwr.engine.setActiveReverseAjax(true);
	DataPollService.pollDataToAllPage();

 }
 function clickMe1(){
	// alert()
   dwr.engine.setActiveReverseAjax(true);
	DataPollService.pollDataToSpePage();
}
 </script>
 <title>A页面</title>
 </head>
 <body>


 <input type="button" value="请求服务器推送数据给所有的页面" onclick="clickMe()">
 <input type="button" value="请求服务器推送数据给D页面" onclick="clickMe1()">
 <button style="VISIBILITY: hidden">按钮</button>
 </body>
 </html>