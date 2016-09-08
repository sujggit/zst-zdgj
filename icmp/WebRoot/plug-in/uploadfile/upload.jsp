<%@ page language="java"  pageEncoding="UTF-8"%>
<%
	String excuteFileType = request.getParameter("excuteFileType");
	if(excuteFileType==null)excuteFileType="";
	String methodName = request.getParameter("methodName");
	if(methodName==null || "".equals(methodName))methodName="finish";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <%@include file="/common/common_header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>文件上传</title>
        <script type="text/javascript">
             function <%=methodName %>(param){
             	//eval("window.opener."+window.opener.d_xxx.methodName+"(param)");
             	eval("window.opener."+"<%=methodName %>"+"(param)");
             	window.close();
             }
            function cancelDepartment(){
            	window.close();
            } 
        </script> 
	</head>
	<body class="id_bg">
		<div>
			<table align="center" style="background:#e8e8e8;" cellpadding="0"  cellspacing="0" width="100%">
				<tr><td height="2"></td></tr>
				<tr>
					<td class="cx_bg" ><span style="color:red;font-weight:bolder;">&equiv;</span>文件上传</td>
				  </tr>
			</table>
			<table align="center" cellpadding="0" cellspacing="0" width="100%">
			<tr><td height="123" align="center" style="font-size:15px;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请点击"浏览"按钮,并选择相关文件;<P>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;然后点击"上传"按钮即可：</td></tr>
			  <tr>
			  <td align="center">
					<zzst:uploadFile fileType="all" excuteFileType="<%=excuteFileType %>" processID="" callMethod="<%=methodName %>">
					</zzst:uploadFile>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
