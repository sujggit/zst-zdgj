<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String meetingID=request.getParameter("meetingID");

%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
	<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
	<%--<script type='text/javascript' src='${sys_ctx }/dwr/interface/ControlDWR.js'></script>--%>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/mcuControlMethod.js'></script>
<title>预监</title>
<script type="text/javascript">

function loadXMLDocs()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    var strs=xmlhttp.responseText;
     document.getElementById("initContID").value=strs;
    if(strs!='null'){   
    document.getElementById("zhongduanIpID").value=strs.split('_')[5];
    document.getElementById("fwbid110").innerHTML="会场预监:"+strs.split('_')[4];
    }
     xmlhttp=null;
	delete xmlhttp;
	CollectGarbage();
    }
  }
xmlhttp.open("POST","Md_data.jsp?meetingID="+<%=meetingID %>,true);
xmlhttp.send();

}

function getImage(ip){
				var now=new Date();
				var number = now.getTime();
				McuDwrMethod.getBlowDown(ip, function(nameIP1){
				document.getElementById("nearview").src= "" +nameIP1 +"?"+number;
				number=null;
				now=null;
				delete now;
	            delete xmlhttp;
	            CollectGarbage(); 
				});
				
			}
			

function initImg(){
loadXMLDocs();
var zdip=document.getElementById("zhongduanIpID").value;
getImage(zdip);
zdip=null;
delete zdip;
CollectGarbage();

}

function run(){
window.setInterval('initImg()', 1000);
}



function suspendParticipants(){
var tempsCont=document.getElementById("initContID").value;
if(tempsCont==null||tempsCont=="null"){
alert('没有终端!');
}else{
var tempsConts=tempsCont.split('_');
var tempss=mcuControlMethod.suspendParticipants(tempsConts[2], tempsConts[4]+'__'+tempsConts[1]+'__'+tempsConts[3], true, function(isSuccessful){alert('屏蔽成功!'); });
}
}



function setVideoScreen(){
var tempsCont=document.getElementById("initContID").value;
var xmlhttp;
if (window.XMLHttpRequest) {
  xmlhttp=new XMLHttpRequest();
  }else {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  } 
  xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    var strs=xmlhttp.responseText;
    
    alert(strs);
    
    }
  }
  var now=new Date();
var contString="VideoScreenYJ.jsp?infos="+tempsCont+"&date="+now;
contString=encodeURI(contString);
contString=encodeURI(contString);
xmlhttp.open("POST",contString,true);
xmlhttp.send();

}






</script>

</head>
<body onload="run()">
<input type="hidden" name="zhongduanIp" id="zhongduanIpID"/>
<input type="hidden" name="initCont" id="initContID"/>
<div id="contentwrapper" class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10" id="fwbid110">会场预监</h5>
	</div>
	<div class="dtree">
		<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
			<tbody>
				<tr class="gradeA">
					<td width="352"><img id="nearview" src="${sys_ctx }/images/lineOut.png" /><p><input onclick="suspendParticipants()" type="button" value="视频屏蔽"  class="reset1 radius2" /></p></td>
				</tr>
			</tbody>
		</table>
        <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
			<tbody>
				<tr>
					<td><p style="float:left"><input onclick="setVideoScreen()" type="button" value="设置" class="searchbtn radius2" /></p></td>
				</tr>
			</tbody>
		</table>
	</div>	        
</div>
</body>
</html>