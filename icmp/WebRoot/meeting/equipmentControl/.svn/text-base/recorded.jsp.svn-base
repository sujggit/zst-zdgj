<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>录播服务器控制</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
<script type="text/javascript">
	function recorded(type){
		var id = ${"equId"}.value;
		if(id == ""){
			alert("请选择录播服务器！");
			return;
		}
		TerminalDwrMethod.recorded(id,type,function(result){
			if(result != ""){
				alert("操作成功");
				if(result =="未知"){
					selectEqu();
				}else{
					document.getElementById("recordedState").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;当前状态：" + result;
				}
			}else{
				alert("操作失败，请重试！");
			}
		});
	}

	function selectEqu(){
		var id = ${"equId"}.value;
		if(id == ""){
			return;
		}
		TerminalDwrMethod.recorded(id,"state",function(result){
			if(result != ""){
				document.getElementById("recordedState").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;当前状态：" + result;
			}else{
				alert("获取状态失败！");
			}
		});
	}
	
</script>
</head>
<body>
<div id="k2" class="k" style="display:block">

	<p class="cd" style="margin:2px;"><span>录播服务器选择</span>
	<select id="equId" style="margin-top:5px" onchange="selectEqu()">
		<option value="" >请选择</option>
		<c:forEach items="${equipmentList}" var="temp" varStatus="state">
   		<option value="${temp.equipmentID}" ><c:out value="${temp.equipmentNO}"/></option>
        </c:forEach>
	</select>
	</p>
	
	<div class="dd" style="margin-top:3px;margin-left:1%;width:47%;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center" >
			<tr style="line-height:20px;height:20px;">
             	<td align="center" class="in" style="width:20px;">
                	<a  id="start" title="开始"  onclick="recorded('start')" >开始</a>
                </td>
                <td align="center" class="in" style="width:20px;">
                	<a  id="pause" title="暂停"  onclick="recorded('pause')" >暂停</a>
                	</td>
                <td align="center" class="in" style="width:20px;">
                	<a  id="continue" title="继续"  onclick="recorded('continue')" >继续</a>
                	</td>
                <td align="center" class="in" style="width:20px;">
                	<a  id="stop" title="停止"  onclick="recorded('stop')" >结束</a>
                </td>
          	</tr>
          	<tr style="line-height:20px;height:20px;">
          		<td id="recordedState" colspan="4" style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;当前状态：未知</td>
          	</tr>
		</table>
	</div>
</div>
</body>
</html>
