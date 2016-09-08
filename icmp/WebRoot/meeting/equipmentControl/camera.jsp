<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>摄像头控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	var cameraStatus = "";
	function direction(op) { 
		var id = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
	
		if(op=="add"||op=="subtract"){
			$("#"+op).attr("class","f_"+op);
			op = "stop";
		}else if(op=="up"||op=="down"||op=="left"||op=="right"){
			$("#"+op).attr("class","span_"+op+"_act");
		}else{
			$("#up").attr("class","span_up");
			$("#down").attr("class","span_down");
			$("#left").attr("class","span_left");
			$("#right").attr("class","span_right");
		}
		DwrMethod.directionKey(id, ids, op, opback);
	}
	
	function opback(para) {
		if (para == "") {
			alert("失败");
		}else if(para == "stop"){
		}else{
			$("#up").attr("class","span_up");
			$("#down").attr("class","span_down");
			$("#left").attr("class","span_left");
			$("#right").attr("class","span_right");
			$("#"+para).attr("class","span_"+para+"_act");
		}
	}
		
	function speed(op) {
		var id = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
		$(".c_1").removeAttr("class");
		$("#speed"+op).attr("class","c_1");
		DwrMethod.speed(id,ids,op,sback);
	}
	
	function sback(para) {
		/* if (para!= "") {
			alert("失败");
			$(".c_1").removeAttr("class");
		} */
	}
	/**	
	function speed(op) {
		alert(2);
		var id = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
		$(".k3").removeAttr("class");
		$("#speed"+op).attr("class","k3");
		DwrMethod.speed(id,ids,op,sback);
	}
	
	function sback(para) {
		if (para!= "") {
			alert("失败");
		}
	}
	*/	
	function cameraName(){
		var ids=document.getElementById("cameraNames").value;
		document.getElementById("pageform").submit();
	}
	    
	function btnchClick(id){
		if($("#"+id).hasClass("k2")){
			$(".k2").removeAttr("class");
		}else{
			$(".k2").removeAttr("class");
			$("#"+id).attr("class","k2");
			cameraStatus=id;
		}
	}
	
	function cameraRecalls(op){
		if(cameraStatus==""){
			alert("请选择预置位！");
			return;
		}
		var ids = getSelectedCCIP();
		var idss=document.getElementById("cameraNames").value;
		//alert(ids);
		//alert(idss);
		//alert(cameraStatus);
		DwrMethod.cameraRecalls( op,ids,idss,cameraStatus,callsback);
	}
	 
	function callsback(result){
		if(result!=true){
			alert("操作失败！");
		}else if(result=true){
			//alert("操作成功！");
			$(".k2").removeAttr("class");
		}
	}
	//变焦
	function zoomss(op){
		var id = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
		$("#"+op).attr("class","f_"+op+"_act");
		DwrMethod.zooms(op,id,ids,zoomsback);
	}
	
	function zoomsback(result){
		if(result == ""){
			alert("失败！");
		}else{
			$("#add").attr("class","f_add");
			$("#subtract").attr("class","f_subtract");
			$("#"+result).attr("class","f_"+result+"_act");
		}
	}
	//跟踪
	function track(op){
		var ip = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
		DwrMethod.cameraOperation(op,ip, ids);
	}
		
	function getSelectedCCIP(){
		var selectedCCIP = document.getElementById("ccip").value;
		return selectedCCIP;
	}
	
	/* function preferences(){
		var id = getSelectedCCIP();
		var ids=document.getElementById("cameraNames").value;
		window.showModalDialog("${sys_ctx }/meeting/equipmentControl/camera_preferences.jsp?cId="+ids+"&ccIp="+id,window,'dialogWidth=690px;dialogHeight=428px;');
	} */
	window.onload=function (){
		var cameraId = $("#cameraNames").val();
		var ip = getSelectedCCIP();
		DwrMethod.sendCommand(cameraId,ip);
		window.setTimeout("speed(2)", 1000);
	};
  </script>
</head>
<body>
  <div id="k3" class="k" style="display:block">
	<form action="${sys_ctx}/equipmentControl/cameraBefore.action" id="pageform" name="pageform" method="post">
	<p class="cd"><span>摄像头选择</span>
		<input type="hidden" id="ccip" value="${equipmentVO.ip }" name="equipmentVO.ip"/>
		<select name="cameraVO.id" id="cameraNames" style="margin-top:5px" onchange="cameraName()">
		 <c:forEach items="${cameraList}" var="camera" varStatus="state">
	   		  <option value="${camera.id}"  ${cameraVO.id==camera.id ? "selected" : "" } ><c:out value="${camera.name}"/></option>
	     </c:forEach>
		</select>
		<!-- <input type="button" class="stdbtn mlr10" style="margin-top: 0px" value="参数设置"  onclick="preferences()"/> -->
	</p>
	</form>
	<div class="dd_5">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
			<tr>
				<td> </td>
				<td><span onmouseup=window.setTimeout("direction('stop')",260) id="up" onmousedown="direction('up')" class="span_up"></span></td>
				<td> </td>
			</tr>
            <tr>
                <td><span onmouseup=window.setTimeout("direction('stop')",260) id="left" onmousedown="direction('left')" class="span_left"></span></td>
                <td><span id="ok" class="span_ok" style="cursor: default"></span></td>
                <td><span onmouseup=window.setTimeout("direction('stop')",260) id="right" onmousedown="direction('right')" class="span_right"></span></td>
            </tr>
            <tr>
                <td> </td>
                <td><span onmouseup=window.setTimeout("direction('stop')",260) id="down" onmousedown="direction('down')" class="span_down"></span></td>
                <td> </td>
            </tr>
        </table>
	</div>
	<div class="dd_4">
        <table width="100%" cellspacing="0" cellpadding="0" class="con_2" align="center">
            <tr>
                <td align="center" onmousedown="zoomss('add')" id="add" onmouseup=window.setTimeout("direction('add')",260) class="f_add" >+</td>
            </tr>
            <tr>
                <th align="center" style="font-size:14px;font-weight:normal">变焦</th>
            </tr>
            <tr>
                <td align="center" onmousedown="zoomss('subtract')" id="subtract" onmouseup=window.setTimeout("direction('subtract')",260) class="f_subtract" >-</td>
            </tr>
        </table>
	</div>
	<div class="dd_1" style="padding-top:50px">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
            <tr>
                <td align="center">
                <span onclick="speed('3')" id="speed3">快</span>
                <span onclick="speed('2')" id="speed2" class="c_1">中</span>
                <span onclick="speed('1')" id="speed1">慢</span></td>
            </tr>
		</table>
	</div>
	<div class="dd">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
            <tr><td colspan="4">预置位</td></tr>
            <tr>
            <c:forEach items="${cameraVO.storeAll}" var="vo"  varStatus="status">
                <td align="center"><a id="${vo[0] }" onclick="btnchClick('${vo[0] }')"><c:out value="${vo[1]}"/></a></td>
               <c:if test="${status.index>0&&(status.index+1)%2==0&&status.last==false}">
          	  	</tr>
          	  	<tr>
          	  </c:if>
          	   <c:if test="${status.index>0&&status.last==true}">
          		</tr>
          	  </c:if>
           </c:forEach>
		</table>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer" style="border:none; background:none;" >
		<tfoot>
        </tfoot>        
        <tbody>
		<tr>
			<td colspan="6">
			<c:if test="${cameraVO.id==40||cameraVO.id==41}">
			 	<input type="button" class="submit1 radius2" value="全景"  onclick="track('allview')"/>
	        </c:if>
            <input type="button" class="submit1 radius2" value="开启跟踪"  onclick="track('start')"/>
            <input type="button" class="submit1 radius2" value="关闭跟踪"  onclick="track('close')"/>
            <input type="button" class="submit1 radius2" value="调 用"  onclick="cameraRecalls('recalls')"/>
            <input type="button" class="submit1 radius2" value="存 储"  onclick="cameraRecalls('store')"/>
            </td>
            <td></td>
		</tr>
		</tbody>
	</table>
  </div>
</body>
</html>