<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@include file="/common/common.jsp"%>
<head>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>Mcu端口使用率</title>
		
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx}/config/modifyCenterControlInfo.action" id="centerControlAddForm" name="centerControlAddForm" method="post">
	<div id="basicform" class="contentwrapper">
    	<div class="contenttitle2"><h5 class="fwb fl10">Mcu端口使用率</h5></div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" style="table-layout: fixed">
        	<tr>
          		<td class="tableaddtitle" style="width:30%">MCU名称</td>
          		<td class="tableadd_data"><span style="width:130px;display:inline-block">语音音频：0/0</span><span>视频：6/30</span></td>
        	</tr>  
        	<tr>
          		<td class="tableaddtitle">MCU名称2</td>
          		<td class="tableadd_data"><span style="width:130px;display:inline-block">语音音频：1/10</span><span>视频：7/35</span></td>
        	</tr>
        	<tr>
          		<td class="tableaddtitle">MCU名称3</td>
          		<td class="tableadd_data"><span style="width:130px;display:inline-block">语音音频：2/20</span><span>视频：8/40</span></td>
        	</tr>      	
		</table>		
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	<tfoot>
          	</tfoot>
          	<tbody>
            	<tr>
              		<td><input type="button" class="submit1 radius2" value="关闭" onclick="commit()"/></button></td>
            	</tr>
       		</tbody>
        </table>
	</div>
</form>
</body>
</html>