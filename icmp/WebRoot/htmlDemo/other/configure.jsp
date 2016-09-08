<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>配置</title>
		
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
	<div id="basicform" class="contentwrapper">
    	<div class="contenttitle2"><h5 class="fwb fl10">FTP配置</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle">FTP服务器</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">FTP用户名</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">FTP密码</td>
          		<td class="tableadd_data"><input type="password" class="most" style="border:none" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">目录路径</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">FTP端口</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">FTP目录的绝对路径</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
		</table>
		<div class="contenttitle2"><h5 class="fwb fl10">数据同步</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle">数据开关</td>
          		<td class="tableadd_data"><input type="radio" name="radio" />开启&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" /> 关闭</td>
        	</tr>        	
		</table>
    	<div class="contenttitle2"><h5 class="fwb fl10">数据源配置</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle">DB_URL</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">DB_USER</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">DB_PASSWD</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">DB_JNDI</td>
          		<td class="tableadd_data"><input type="text" class="most" /></td>
        	</tr>
		</table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	<tfoot>
          	</tfoot>
          	<tbody>
            	<tr>
              		<td><input type="button" class="submit1 radius2" value="保存" onclick="commit()"/></button></td>
            	</tr>
       		</tbody>
        </table>
	</div>
</form>
</body>
</html>