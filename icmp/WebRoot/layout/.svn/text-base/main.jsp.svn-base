<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${sys_ctx }/layout/js/frame.js"></script>
<script type="text/javascript" src="${sys_ctx }/layout/js/alert.js"></script>
<script type="text/javascript" src="${sys_ctx }/layout/js/dateForm.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/AlertDwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DataPollServiceDwr.js'></script>
<script type="text/javascript">
		
	//add by yangyi  当前操作会场信息
	var operateMeetingRoom = "";
	
	function getOperateMeetingRoom(){
		return operateMeetingRoom;
	}
	
	function setOperateMeetingRoom(id){
		operateMeetingRoom = id;
	}

	window.onload = function(){
	  // ${userVO.userID}=id;
		//alert(${dispatherType == 1});height:0;
		if( ${dispatherType == 1} ){
			window.showModalDialog("/icmp/user/getUserBaseInfoFirst.action",window,'dialogWidth=700px;dialogHeight=470px;status:no;help:no;scroll:no');
		}
	}
	
/*
add by tanzanlong 
time:2013-3-6
 掉线警告提醒
*/
function toppopwin(data){

   var js=""; var topdiv=""; 
   var total="(<span id='total'>"+data.length+"</span>条)"
   
   js+="<div id='report'  class='report'  style='position: fixed;overflow-x:hidden;z-index:1000;bottom:0px;right:0px;display:block;'>"; 
   js+="<table class='r_title' border='1' style='margin-top:0'><tr>";
   js+="<td><div class='font'><font size='2'>报警信息</font><font size='1'>"+total+"</font></div><a onclick='showHiddenByAll();'><div style=' color:#fff;  text-indent:5px; margin-top:3px;'>&nbsp;&nbsp;&nbsp;知道了</div></a></td>";
   js+="<td><div class='btn_colse'><a onclick='showHidden();' title='关闭'><img src='${sys_ctx }/images/alert/colse.gif' /></a></div></td>";
   js+=" </tr></table>";
  
   js+="<font color='red'><div class='r_box_t'  style='overflow-y:auto;overflow-x:hidden;width:350px;height:90px;background:#f3f3f3;'>";
   
   for(var i=0;i<data.length;i++){
   var id='"'+data[i].infoID+'"';
   var date =DateUtil.Format("yyyy-MM-dd hh:mm:ss",data[i].createTime);
   //alert(data[i].createTime);
   js+="<a onclick='showAlertDetail("+id+");'><div id="+id+" class='list_w' style='width=100%;'><span>"+data[i].title+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>"+date+"</span><br/><span>"+data[i].content+"</span></div></a>";
   }
   
   js+="</div></font>";
   js+="</div>";
  
   var oScript= top.frames["rightFrame"].document.createElement("script"); 
    oScript.type = "text/javascript"; 
    oScript.src="${sys_ctx }/layout/js/alert.js"; 
    top.frames["rightFrame"].document.body.appendChild(oScript);
    
    var alertScript= top.frames["rightFrame"].document.createElement("script"); 
     alertScript.type = "text/javascript"; 
     alertScript.src="${sys_ctx }/dwr/interface/AlertDwrMethod.js"; 
    top.frames["rightFrame"].document.body.appendChild(alertScript);
   
    topdiv = top.frames["rightFrame"].document.createElement("div");
	topdiv.innerHTML = js;
	top.frames["rightFrame"].document.body.appendChild(topdiv); 
};
	//top.frames["rightFrame"].document.body.appendChild(topdiv); };

function getAlert(){
   AlertDwrMethod.getReAlertInfomation(back);
}

function back(data){
  
  //var bool=top.frames["rightFrame"].document.getElementById('report');
   var bool=(top.frames["rightFrame"].document.getElementById('report')==null)?null:top.frames["rightFrame"].document.getElementById('report');
   if(bool==null){
    
	   if(data.length>0){
	      toppopwin(data);
	   }else{
	       return;
	   }
    }else{
        if(data.length>0){
	        bool.parentNode.removeChild(bool);
	        toppopwin(data);
        }else{
        	bool.parentNode.removeChild(bool);
        }
    }
}


$(document).ready(function(){
	//将后台推送数据给前台设置为true
  	dwr.engine.setActiveReverseAjax(true);
	//创建一个属于这个页面的scriptSession
// 	DataPollServiceDwr.initScriptSession();
 var formId = "${param.formId}";
 var entryId = "${param.entryId}";
	if(entryId=="0"){
		window.location.href = "${sys_ctx}/apply/applyConference/applyDetail.action?applyConferenceVO.applyID="+formId+"&type=1";
	}
});


</script>

<title>欢迎登陆${sys_viewName }</title>

</head>
 
<frameset rows="58,78,*" cols="*" frameborder="no" border="0" framespacing="0" id="mainFrame">
  <frame src="${sys_ctx }/layout/inc1/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <!--<frame src="${sys_ctx }/layout/inc1/menu.jsp" name="menueFrame" scrolling="No" noresize="noresize" id="menueFrame" title="menueFrame" onload="setInterval('getAlert();',2*60*1000);"/>-->
 <frame src="${sys_ctx }/layout/inc1/menu.jsp" name="menueFrame" scrolling="No" noresize="noresize" id="menueFrame" title="menueFrame"/>
 
  <frameset name="secmainbody"  cols="0,*"  frameborder="no" border="1" framespacing="0" id="leftMenu">
    <frame src="${sys_ctx }/layout/inc1/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    
	<frameset rows="28,*" cols="*" frameborder="no" border="0" framespacing="0" id="rightF">
        <frame src="${sys_ctx }/layout/inc1/current.jsp" name="currentFrame" id="currentFrame" style="border-left:1px solid #ccc" title="currentFrame" scrolling="No" />
        <frame src="${sys_ctx }/layout/inc1/welcom.jsp"  id="rightFrame" name="rightFrame" style="border-left:1px solid #ccc" scrolling="auto" noresize />
    </frameset>
  </frameset>
   <!--<frame src="${sys_ctx }/layout/inc1/copyRight.jsp" id="bottomFrame" name="bottomFrame" scrolling="No" noresize />-->
</frameset>
<noframes>
	<body>
	
	</body>
</noframes>
<body>

</body>
</html>
