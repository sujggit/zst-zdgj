<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>警告页面</title>
		<link rel="stylesheet" href="/icmp/style/normal/css/style.default.css" type="text/css" />
		<script type="text/javascript" src="/icmp/js/jquery-1.4.2.js"></script>
	</head>
	<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<div id="basicform" class="contentwrapper">
		    <table width="100%" border="0" align="center" style="border:1px solid #ccc">
		  		<tr>
		            <td width="25%" align="center"><img src="/icmp/style/normal/images/error.png" alt="error"/></td>
		            <td width="10%" align="left"><img src="/icmp/style/normal/images/error_list.png" alt=""/></td>
		            <td width="60%" align="left">
		            	<h2><%=request.getAttribute("failure_message")%></h2>
			            <h3><a  onclick="javascript:history.back()">>>返回前页</a></h3>
		        </tr>
		    </table>
		</div>
	</body>
</html>
	
