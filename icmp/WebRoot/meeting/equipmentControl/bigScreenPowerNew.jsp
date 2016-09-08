<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.centerContor.vo.ViewScreentVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<link href="${sys_ctx }/meeting/equipmentControl/css/lg.css" rel="stylesheet" type="text/css" />
<title>大屏电源</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
	function DPpwopen(id)//打开大屏电源
	{
	//alert("id:"+id);
	   DwrMethod.openScreenPowerbyIP(id,function(para){
	  	 if(para !=null){
				document.getElementById("pwlogo").src ="${sys_ctx }/style/normal/images/fjy_1.png";	
				$("#dpPowerOff").removeClass("k2");
				$("#dpPowerOn").addClass("k2");	
	   	}	
	   });
	}
			
	function DPpwclose(id)//关闭大屏电源
	{
	//alert("id:"+id);
	//var status="<%=ViewScreentVO.status_on%>";
	//alert("status:"+status);
	   DwrMethod.closeScreenPowerbyIP(id,function(para){
		   if(para !=null){
				document.getElementById("pwlogo").src ="${sys_ctx }/style/normal/images/jy_1.png";	
				$("#dpPowerOn").removeClass("k2");
	 			$("#dpPowerOff").addClass("k2");    	
	    	}
		});
	}
	
	function go()
	{
	  window.setInterval("runit()",'${sys_refreshTime}');
	}
	
	function runit()
	{
	  var ips = document.getElementById("ips").value;
	  DwrMethod.getScreenPowerlist(ips,rback);
	}
	function rback(lst)
	{
		var ipAndStatus = lst[0];
		var ip_status = ipAndStatus.split(";");
		var status = ip_status[1];
		//var ip = "pw"+ip_status[0];
		var logo = document.getElementById("pwlogo");
		if(status=="<%=ViewScreentVO.status_on%>")
		{
			logo.src = "${sys_ctx }/style/normal/images/fjy_1.png" ;
	 		$("#dpPowerOff").removeClass("k2");
	 		$("#dpPowerOn").addClass("k2");
	 		$(logo).attr("title","大屏电源开启");
		}
		else if(status=="<%=ViewScreentVO.status_off%>")
		{
			logo.src = "${sys_ctx }/style/normal/images/jy_1.png" ;
			$("#dpPowerOn").removeClass("k2");
	 		$("#dpPowerOff").addClass("k2");
	 		$(logo).attr("title","大屏电源关闭");
		}
		else
		{
			logo.src ="${sys_ctx }/meeting/equipmentControl/image/wait.gif";
			$("#dpPowerOn").removeClass("k2");
			$("#dpPowerOff").removeClass("k2");
			$(logo).attr("title","大屏电源状态未知");
		}
	}
</script>
<script type="text/javascript">
	function chooseModel(ips){
   		var valuess=document.getElementById(ips).value;
	 	//alert("1选择模式时"+valuess+"，弹出矩阵切换页面"+ips);
     	TerminalDwrMethod.bigscreenMonitor(ips,valuess,bigscreenMonitorback);
    }
  	function bigscreenMonitorback(result){	
    	//result = "10.232.1.198";	
        if(result!=null&&result!=""){
    		var valuess=document.getElementById(result).value;
	        window.parent.location.href="${sys_ctx}/equipmentControl/bigscreenMonitorBefore.action?equipmentVO.ip="+result+"&equipmentVO.description="+valuess;
	        alert("成功！");
		}else{
	    	alert("失败！");
		}		
	}
	
	function chooseModelNew(ips){
		var valuess=document.getElementById(ips).value;
		//alert("ips:"+ips+"==valuess:"+valuess);
		TerminalDwrMethod.changeScreent(ips,valuess,changeScreentBack);
	}
	function changeScreentBack(equipmentVO){
		if(equipmentVO!=null ){
			var templateTd = document.getElementById("chooseBsInputID");
			var html = "<div class='scrmdiv' style='cursor:pointer' onclick='chooseBsInput(\""+equipmentVO.ip+"\",\""+equipmentVO.description+"\",\""+equipmentVO.equipmentNO+"\");'>";
			html +=equipmentVO.descriptionNew;
			html +="</div>";
			templateTd.innerHTML = html;
			alert("成功！");
		}else{
			alert("失败！");
		}
	}
	
	function chooseBsInput(ips,desc,bgNOs){
		//alert("bgNOS:"+bgNOs);
		//var valuess=document.getElementById(ips).value;
		var valuess=ips+","+desc;
		//alert("valuess:"+ips);
		$("#ip").attr("value",ips);
		TerminalDwrMethod.bigscreenMonitor(ips,desc,function bigscreenback(result){
			if(result!=null){
				window.location.href="${sys_ctx}/equipmentControl/bigScreenInputChooseBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess+"&equipmentVO.description="+desc+"&equipmentVO.equipmentNO="+bgNOs;
			}else{
				alert("操作失败");
			}
		});
		//window.showModalDialog("${sys_ctx}/equipmentControl/bigScreenInputChooseBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess+"&equipmentVO.description="+desc+"&equipmentVO.equipmentNO="+bgNOs,window,'dialogWidth=800px;dialogHeight=570px;');
	}
	
   
   function bigScreeninputs(ips){
     // document.getElementById('message_box').style.visibility='visible';
      var valuess=document.getElementById("equipmentModel").value;
      $("#ip").attr("value",ips);
      window.showModalDialog("${sys_ctx}/equipmentControl/bigscreenInputBefore.action?equipmentVO.ip="+ips+"&equipmentVO.equipmentModel="+valuess,window,'dialogWidth=600px;dialogHeight=470px;');
       
   }
   
   	function screenShareUp(ip){
		DwrMethod.screenShareUp(ip,screenShareBack);
   	}
   	
   	function screenShareDown(ip){
		DwrMethod.screenShareDown(ip,screenShareBack);
   	}
   	
   	function screenShareBack(result){
   		alert(result);
   	}
</script>
</head>

<body onload="go()" style="background-color: #F7F7F7">
	<div id="k9" class="k" style="display:block">
		<table width="99%" border="0" cellspacing="0" cellpadding="0" align="center" class="con_2">
			<tr>
				<td width="25%" align="center"><b class="downs">大屏电源状态</b></td>
				<td width="25%">
					<input type="hidden" id="ips" name="ips" value="${equipmentVO.ip }" />
				 	<image src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo"  id="pwlogo" />
				</td>
				<td width="25%" align="center"><a id="dpPowerOn" class="k2" title="打开大屏电源" alt="打开大屏电源" onclick="DPpwopen('${equipmentVO.ip }')">电源开</a></td>
				<td width="25%" align="center"><a id="dpPowerOff" title="关闭大屏电源" alt="关闭大屏电源" onclick="DPpwclose('${equipmentVO.ip }')">电源关</a></td>
			</tr>
			<tr>
				<c:forEach items="${equipmentModelList}" var="equipmentVO" varStatus="status">
				<td align="center">
			  		<div class="scrmdiv" style="cursor:pointer" onclick="chooseBsInput('${equipmentVO.ip}','${equipmentVO.description}','${equipmentVO.equipmentNO}');">
										${equipmentVO.meetingRoomVO.description }
					</div>
			  	</td>
			  	<c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}"> 
          		</tr>
          		<tr>
          	  	</c:if>
          	  	<c:if test="${status.index>0&&status.last==true}">
          		</tr>
          	  </c:if>
			</c:forEach>
		</table>
			<script type="text/javascript">
          		runit();
          	</script> 
	</div>
</body>
</html>