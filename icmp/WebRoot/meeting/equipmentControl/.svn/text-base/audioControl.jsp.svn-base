<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.centerContor.vo.AudioControlVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>音频系统</title>
<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.css" type="text/css" rel="stylesheet" />
<link href="${sys_ctx }/plug-in/jquery-slider/css/jslider.round.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.dependClass.js"></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.slider-min.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
  function unmute(audioId)//取消静音
  {
	var ccip = document.getElementById("ccip").value;
	DwrMethod.unmutebyIP(ccip,audioId,unmuteback);
	$("#k4 .k4 table tr td a").removeClass();
	var qxjy = "qxjy"+audioId;//点击之后样式改变
	$("#"+qxjy).addClass("k2");
  }
			
    function unmuteback(para)
    {
    	if(para !=null){
    		var aa = "audio"+para;
       	 	document.getElementById(aa).src ="${sys_ctx }/style/normal/images/fjy.png";
    	}else{
    		$("#k4 .k4 table tr td a").removeClass();
        }			
	}
	function mute(audioId)//静音
	{ 
		var ccip = document.getElementById("ccip").value;
	    DwrMethod.mutebyIP(ccip,audioId,muteback);
	    $("#k4 .k4 table tr td a").removeClass();
	    var jy = "jy"+audioId;
		$("#"+jy).addClass("k2");
	}
    
    function muteback(para)
    {
    	if(para !=null){
    		var aa = "audio"+para;
       	 	document.getElementById(aa).src ="${sys_ctx }/style/normal/images/jy.png";
   	 		$("#qxjy").removeClass("k2");
   	 		$("#jy").addClass("k2");
    	}else{
    		$("#k4 .k4 table tr td a").removeClass();
        }		
	}
	function go()
	{
	  window.setInterval("runit()",'${sys_refreshTime}');
	}
	
	function runit(){
		var ips = document.getElementById("ccip").value;
		//根据中控Ip获取该中控下的所有音频设备
	    DwrMethod.getaudiolist(ips,rback);
	}
	function rback(lst){
		for(var i=0;i<lst.length;i++){
			var ipAndStatus = lst[i];
			var ip_status = ipAndStatus.split(";");
			var status = ip_status[1];
			var ip = "audio"+ip_status[0];
			//获取静音与取消静音的对象用jquery进行操作，取代$("#qxjy")
			var qxjy = document.getElementById("qxjy"+ip_status[0]);
			var jy = document.getElementById("jy"+ip_status[0]);
			var logo = document.getElementById(ip);
			if(status=="<%=AudioControlVO.status_off%>"){
				logo.src = "${sys_ctx }/style/normal/images/fjy.png";
				$(jy).removeClass("k2");
    	 		$(qxjy).addClass("k2");
    	 		$(logo).attr("title","音频扩声打开");
			}
			else if(status=="<%=AudioControlVO.status_on%>"){
				logo.src = "${sys_ctx }/style/normal/images/jy.png";
				$(qxjy).removeClass("k2");
    	 		$(jy).addClass("k2");
    	 		$(logo).attr("title","音频扩声关闭");
			}
			else{
			   logo.src ="${sys_ctx }/meeting/equipmentControl/image/wait.gif";
			   $(qxjy).removeClass("k2");
			   $(jy).removeClass("k2");
			   $(logo).attr("title","音频扩声状态未知");
			}
		}
	}
	
</script>
</head>

<body onload="go()">
  <div id="k4" class="k" style="display:block">
  <input type="hidden" id="ccip" value="${equipmentVO.ip }" />
	<div class="k4" style="width:80%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<c:forEach items="${audioControlVOList}" var="audioControlVO" varStatus="status">
          		<tr>
				<td width="30%"><span>${audioControlVO.name}</span></td>
				<td><a class="k2" id="jy${audioControlVO.id }" alt="静音" title="静音" onclick="mute('${audioControlVO.id }')">静音</a>
				&nbsp;&nbsp;<a id="qxjy${audioControlVO.id }" alt="取消静音" title="取消静音" onclick="unmute('${audioControlVO.id }')">取消静音</a></td>
				<td><img src="${sys_ctx }/meeting/equipmentControl/image/wait.gif" name="logo" id="audio${audioControlVO.id }"/></td>
			</tr>
			</c:forEach>
			<script type="text/javascript">
          	runit();
          </script>  
		</table>
	</div>
</div>
</body>
</html>