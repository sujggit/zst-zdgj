<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DataPollServiceDwr.js'></script>
	<!-- 右下角弹出框的js -->
	<script type="text/javascript" src="${sys_ctx }/js/message/yanue.pop.js"></script>
  <title>欢迎登录${sys_viewName }</title>
  <script type="text/javascript">
	window.onload=function(){
	//将后台推送数据给前台设置为true
  	dwr.engine.setActiveReverseAjax(true);
	//创建一个属于这个页面的scriptSession
// 	DataPollServiceDwr.initScriptSession();
 	DataPollServiceDwr.pollDataToAllPage();
 	};

//dwr反调函数--等待服务器的数据推送,data是服务器推过来的数据，不仅仅是字符串，还可以是其他的任何对象，如果是对象，记得要在dwr中进行转化
function polledDataByServer(data){
	var titles = data.titles;
	var contents = data.contents;
	var ids = data.ids;
	var title = titles.split(",");
	var content = contents.split(",");
	var id = ids.split(",");
	var text="";
	for(var i=0;i<title.length-1;i++){
		var j=0;
		j=i+1;
		text +="<div id='"+id[i]+"' ><span style='text-align:left'><a onclick='detail(\""+id[i]+"\");'>"+title[i]+"</a></span><span style='font-size:13px;font-family:微软雅黑'><br>"+content[i]+"<br></span></div>";
	}
//	alert("推送的消息："+text);
	var pop=new Pop("","#",text);
//	message();
}
 	/**
	*查看推送消息详细信息
	*/
	function detail(id){
		document.getElementById(id).style.display="none";
		window.showModalDialog("${sys_ctx}/message/messageDetail.action?ifVO.infoID="+id,window,'dialogWidth=600px;dialogHeight=270px;');
	}

$(document).ready(function(){
	//将后台推送数据给前台设置为true
  	dwr.engine.setActiveReverseAjax(true);
	//创建一个属于这个页面的scriptSession
 	DataPollServiceDwr.initScriptSession();
});

  </script>
<script type="text/javascript" language="javascript">

    function reinitIframe(){    
    var iframe = document.getElementById("frame1");    
    try{    
    	var bHeight = iframe.contentWindow.document.body.scrollHeight;    
    	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;    
    	var height = Math.max(bHeight, dHeight);    
    	
    	var a = document.documentElement.clientHeight;
//    	alert(a); 
    	iframe.height =  a-8;
//    	alert("gao:"+iframe.height);
    	iframe.width = document.documentElement.clientWidth-8;
//    	alert("kuan:"+iframe.width);
    }catch (ex){}    
    }
    window.setInterval("reinitIframe()", 200);
</script> 

</head>
<body>
<iframe src="/icmp/layout/main.jsp" id="frame1" name="frame1" scrolling=no style="width:100%;" frameborder="0" onload="reinitIframe()"></iframe>
  <div id="pop" style="display:none;">
<style type="text/css">
*{margin:0;padding:0;}
#pop{background:#fff;width:240px;border:1px solid #e0e0e0;font-size:15px;position: fixed;right:10px;bottom:10px;}
#popHead{line-height:32px;background:#f6f0f3;border-bottom:1px solid #e0e0e0;position:relative;font-size:12px;padding:0 0 0 10px;}
#popHead h2{font-size:14px;color:#666;line-height:32px;height:32px;}
#popHead #popClose{position:absolute;right:10px;top:1px;}
#popHead a#popClose:hover{color:#f00;cursor:pointer;}
#popContent{padding:5px 10px;}
#popTitle a{line-height:24px;font-size:14px;font-family:'微软雅黑';color:#333;font-weight:bold;text-decoration:none;}
#popTitle a:hover{color:#f60;}
#popIntro{line-height:160%;margin:5px 0;color:#666;}
#popMore{text-align:right;border-top:1px dotted #ccc;line-height:24px;margin:8px 0 0 0;}
#popMore a{color:#f60;}
#popMore a:hover{color:#f00;}
</style>
  <div id="popHead"> <a id="popClose" title="关闭">关闭</a>
    <h2>温馨提示</h2>
  </div>
  <div id="popContent" style="width:220px;height:180px;overflow:auto;">
    <dl>
      <dt id="popTitle"><a href="http://www.huisem.com/" target="_blank">这里是标题</a></dt>
      <dd id="popIntro">这里是内容简介</dd>
    </dl>
      <p id="popMore"><!--<a href="http://www.huisem.com/" target="_blank">查看 »</a>--></p>
  </div>
</div>
<!--右下角pop弹窗 end-->
</html>
