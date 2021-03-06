<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.CenterControlEnum"%>
<%@page import="com.zzst.centerContor.vo.SysPowerVO"%>
<%@page import="com.zzst.centerContor.vo.ViewScreentVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>系统电源</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
	 var falg = true; 

	 var powerStatus = "${powerStatus}";
	var powerStatuss = powerStatus.split(",");
	function go(){
		for(var i=0;i<powerStatuss.length;i++){
			if(powerStatuss[i] == "<%=CenterControlEnum.type_sysPower_id%>"){
				document.getElementById("sysPowerDiv").style.display = "block";
			}else if(powerStatuss[i] == "<%=CenterControlEnum.type_screent_id%>"){
				document.getElementById("dpPowerDiv").style.display = "block";
			}
		}
	  //window.setInterval("runit()",'${sys_refreshTime}'); 2016年9月6日 11:18:28 
	}
	
	function runit(){
	  var ips = document.getElementById("ips").value;
	  for(var i=0;i<powerStatuss.length;i++){
			if(powerStatuss[i] == "<%=CenterControlEnum.type_sysPower_id%>"){
				DwrMethod.getpowerlist(ips,sysPwback);//系统电源
			}else if(powerStatuss[i] == "<%=CenterControlEnum.type_screent_id%>"){
				setTimeout("dpRunit()",1000);//大屏电源
			}
		}
	}
	function dpRunit(){
		 var ips = document.getElementById("ips").value;
		  DwrMethod.getScreenPowerlist(ips,dpPwback);
	}
	function sysPwback(lst)
	{
		for(var i=0;i<lst.length;i++)
		{
			var ipAndStatus = lst[i];
			var ip_status = ipAndStatus.split(";");
			var status = ip_status[1];
			var ip = "pw"+ip_status[0];
			
			var logo = document.getElementById(ip);
			
			if(status=="<%=SysPowerVO.status_on%>")
			{
				logo.src ="${sys_ctx }/style/normal/images/fjy_1.png";
				$("#openpw").attr("style","background:url(${sys_style1 }/images/ansNew.png) no-repeat center;color:#fff");
			  	$("#closepw").removeAttr("style");
			  	$(logo).attr("title","系统电源开启");
			  	flag = true;
			}
			else if(status=="<%=SysPowerVO.status_off%>")
			{
			  	logo.src ="${sys_ctx }/style/normal/images/jy_1.png";
			  	$("#closepw").attr("style","background:url(${sys_style1 }/images/ansNew.png) no-repeat center;color:#fff");
			  	$("#openpw").removeAttr("style");
			  	$(logo).attr("title","系统电源关闭");
			  	//$("option").attr("disabled","disabled");
			  	flag = false;
			}
			/* else
			{
			    logo.src ="${sys_ctx }/meeting/equipmentControl/image/wait.gif";
			    $("#openpw").removeAttr("style");
			    $("#closepw").removeAttr("style");
			    $(logo).attr("title","系统电源状态未知");
			    //$("option").attr("disabled","disabled");
			    flag = false;
			} */
		}
	}
	function dpPwback(lst){
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
	
	function controlMethod(op,param,ccIP){
		//if(flag==true){
			var hour = $("#hour"+param).val();
			var mi = $("#mi"+param).val();
			if(param=="on"){
				if(op=="open"){
				$("#onopen").attr("class","k2");
				$("#onclose").removeAttr("class");
				$("#"+param+"span").show();
				DwrMethod.fixedTimeControl("on","on",ccIP,hour,mi,function(){});
				}else{
				$("#onclose").attr("class","k2");
				$("#onopen").removeAttr("class");
				$("#"+param+"span").hide();
				DwrMethod.fixedTimeControl("on","off",ccIP,hour,mi,function(){});
				}
			}
			
			if(param=="off"){
				if(op=="open"){
				$("#offopen").attr("class","k2");
				$("#offclose").removeAttr("class");
				$("#"+param+"span").show();
				DwrMethod.fixedTimeControl("off","on",ccIP,hour,mi,function(){});
				}else{
				$("#offclose").attr("class","k2");
				$("#offopen").removeAttr("class");
				$("#"+param+"span").hide();
				DwrMethod.fixedTimeControl("off","off",ccIP,hour,mi,function(){});
				}
			}
		//}
	}

	function saveTime(param,ccIP){
		var hour = $("#hour"+param).val();
		var mi = $("#mi"+param).val();
		
		 
		DwrMethod.fixedTimeControl("on","on",ccIP,hour,mi,function(){
			
		});
	}
	function offControlMethod(param,num,ccIP){
		var spanID = "offspan"+num;
		var hourID = "offhour"+num;
		var miID = "offmi"+num;
		
		if(param.value=="0"){
			$("#"+spanID).show();
			DwrMethod.fixedTimeControl("off","on",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){

			});
		}
		
		if(param.value=="1"){
			$("#"+spanID).hide();
			DwrMethod.fixedTimeControl("off","off",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){
				
			});
		}
	}

	function offSaveTime(param,ccIP){
		var hour = $("#hour"+param).val();
		var mi = $("#mi"+param).val();
		 
		DwrMethod.fixedTimeControl("off","on",ccIP,hour,mi,function(){
			
		});
	}
	$(document).ready(function(){
		$("#houron").val("${ccVO.mac}");
		$("#mion").val("${ccVO.description}");
		$("#houroff").val("${ccVO.equipmentNO}");
		$("#mioff").val("${ccVO.equipmentModel}");
	})
	
	function sysPowerName(){
		var ids=document.getElementById("cameraNames").value;
		document.getElementById("pageform").submit();
	}
</script>
</head>
<body onload="go()">
  <div id="k4" class="k" style="display:block">
    <input type="hidden" id="ips" value="${ccVO.ip }" />
    <form action="${sys_ctx}/equipmentControl/fixedTimeBeforeNew.action" id="pageform" name="pageform" method="post">
	<p class="cd"><span>电源选择</span>
		<input type="hidden" id="ccip" value="${equipmentVO.ip }" name="equipmentVO.ip"/>
		<select name="sysPowerVO.id" id="cameraNames" style="margin-top:5px" onchange="sysPowerName()">
		 <c:forEach items="${sysList}" var="sysPower" varStatus="state">
	   		  <option value="${sysPower.id}"  ${sysPowerVO.id==sysPower.id ? "selected" : "" } ><c:out value="${sysPower.name}"/></option>
	     </c:forEach>
		</select>
	</p>
	</form>
	<div class="k4" id="sysPowerDiv" style="width:80%;display:none">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><span>系统电源状态</span></td>
				<td><a id="openpw" onclick="pwopen('${ccVO.ip}','${sysPowerVO.id }')">打开</a>&nbsp;&nbsp;<a id="closepw" onclick="pwclose('${ccVO.ip}','${sysPowerVO.id }')">关闭</a></td>
				<td><img src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" id="pw${ccVO.ip }"/></td>
			</tr>
			<c:if test="${ccVO.status==1 }">
            <tr>
				<td><span>定时开机</span></td>
				<td><a id="onopen" onclick="controlMethod('open','on','${ccVO.ip }')" <c:if test="${ccVO.status==1 }"><c:out value="class=k2"></c:out></c:if>>启用</a>&nbsp;<a id="onclose" onclick="controlMethod('close','on','${ccVO.ip }')" <c:if test="${ccVO.status!=1 }"><c:out value="class=k2"></c:out></c:if>>禁用</a></td>
				<td><span id="onspan" <c:if test="${ccVO.status!=1 }"><c:out value="style=display:none"></c:out></c:if>>
				    <select id="houron" onchange="saveTime('on','${ccVO.ip }')">
					    <option value="1">1点</option>
					    <option value="2">2点</option>
					    <option value="3">3点</option>
					    <option value="4">4点</option>
					    <option value="5">5点</option>
					    <option value="6">6点</option>
					    <option value="7">7点</option>
					    <option value="8">8点</option>
					    <option value="9">9点</option>
					    <option value="10">10点</option>
					    <option value="11">11点</option>
					    <option value="12">12点</option>
					    <option value="13">13点</option>
					    <option value="14">14点</option>
					    <option value="15">15点</option>
					    <option value="16">16点</option>
					    <option value="17">17点</option>
					    <option value="18">18点</option>
					    <option value="19">19点</option>
					    <option value="20">20点</option>
					    <option value="21">21点</option>
					    <option value="22">22点</option>
					    <option value="23">23点</option>
					    <option value="24">24点</option>
				    </select>
				    <select id="mion"  onchange="saveTime('on','${ccVO.ip }');">
					    <option value="10">10分</option>
					    <option value="20">20分</option>
					    <option value="30">30分</option>
					    <option value="40">40分</option>
					    <option value="50">50分</option>
				    </select>
				    </span></td>
			</tr>
			<tr>
                <td><span>定时关机</span></td>
                <td><a id="offopen" onclick="controlMethod('open','off','${ccVO.ip }')" <c:if test="${ccVO.port==1 }"><c:out value="class=k2"></c:out></c:if>>启用</a>&nbsp;<a id="offclose" onclick="controlMethod('close','off','${ccVO.ip }')" <c:if test="${ccVO.port!=1 }"><c:out value="class=k2"></c:out></c:if>>禁用</a></td>
                <td><span id="offspan" <c:if test="${ccVO.port!=1 }"><c:out value="style=display:none"></c:out></c:if>>
				    <select id="houroff" onchange="offSaveTime('off','${ccVO.ip }');">
					    <option value="1">1点</option>
					    <option value="2">2点</option>
					    <option value="3">3点</option>
					    <option value="4">4点</option>
					    <option value="5">5点</option>
					    <option value="6">6点</option>
					    <option value="7">7点</option>
					    <option value="8">8点</option>
					    <option value="9">9点</option>
					    <option value="10">10点</option>
					    <option value="11">11点</option>
					    <option value="12">12点</option>
					    <option value="13">13点</option>
					    <option value="14">14点</option>
					    <option value="15">15点</option>
					    <option value="16">16点</option>
					    <option value="17">17点</option>
					    <option value="18">18点</option>
					    <option value="19">19点</option>
					    <option value="20">20点</option>
					    <option value="21">21点</option>
					    <option value="22">22点</option>
					    <option value="23">23点</option>
					    <option value="24">24点</option>
				    </select>
				    <select id="mioff"  onchange="offSaveTime('off','${ccVO.ip }');">
					    <option value="10">10分</option>
					    <option value="20">20分</option>
					    <option value="30">30分</option>
					    <option value="40">40分</option>
					    <option value="50">50分</option>
				    </select>
				    </span></td>
            </tr>
            </c:if>
		</table>
	</div>
	<div class="k4" id="dpPowerDiv" style="width:80%;display:none">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><span>大屏电源状态</span></td>
				<td>
					<a id="dpPowerOn" onclick="DPpwopen('${equipmentVO.ip }')">打开</a>&nbsp;&nbsp;<a id="dpPowerOff" onclick="DPpwclose('${equipmentVO.ip }')">关闭</a>
				</td>
				<td><img src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo" id="pwlogo"/></td>
			</tr>   
		</table>
	</div>
  </div>
  <script>
	runit();//加载即执行此方法
	function pwopen(id,sysPowerId){//系统电源开
	     DwrMethod.openpowerbyIP(id,sysPowerId,function(para){
	    	 if(para !=null){
	        	 var aa = "pw"+para;	 
	        	 document.getElementById(aa).src ="${sys_ctx }/style/normal/images/fjy_1.png";
	        	 $("#openpw").attr("style","background:url(${sys_style1 }/images/ansNew.png) no-repeat center;color:#fff");
	    		 $("#closepw").removeAttr("style");     	
	       	 }
		 });
	 }
			
	function pwclose(id,sysPowerId){//系统电源关
	   DwrMethod.closepowerbyIP(id,sysPowerId,function(para){
		   if(para !=null){
		    	 var aa = "pw"+para;	 
		    	 document.getElementById(aa).src ="${sys_ctx }/style/normal/images/jy_1.png";
		    	 $("#closepw").attr("style","background:url(${sys_style1 }/images/ansNew.png) no-repeat center;color:#fff");
				 $("#openpw").removeAttr("style");    	
		    }
	   });
	}
	
  function DPpwopen(id)//打开大屏电源
  {
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
	   DwrMethod.closeScreenPowerbyIP(id,function(para){
		   if(para !=null){
				document.getElementById("pwlogo").src ="${sys_ctx }/style/normal/images/jy_1.png";	
				$("#dpPowerOn").removeClass("k2");
	 			$("#dpPowerOff").addClass("k2");    	
	    	}
		});
	}
  </script> 
</body>
</html>
