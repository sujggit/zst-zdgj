<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@include file="/common/common.jsp" %>
<title>分屏模式</title>
<style type="text/css">
.k_main{border:1px solid #ccc;margin:1px 0;width:98%;height:360px;display:block;border-right:none}
.k_left{float:left;width:90px;border-right:1px solid #ccc;height:360px}
.k_left li{margin:20px;cursor:hand;cursor:pointer}
.k_left1{background:url(${sys_style1 }/images/yfp.png) no-repeat center;padding-top:50px}
.k_left1:hover{background:url(${sys_style1 }/images/yfpon.png) no-repeat center;}
.k_left2{background:url(${sys_style1 }/images/efp.png) no-repeat center;padding-top:50px}
.k_left2:hover{background:url(${sys_style1 }/images/efpon.png) no-repeat center;}
.k_left3{background:url(${sys_style1 }/images/wfp.png) no-repeat center;padding-top:50px}
.k_left3:hover{background:url(${sys_style1 }/images/wfpon.png) no-repeat center;}
.k_right{margin:0 auto;text-align:center;min-height:460px}

.k_bottom{border:1px solid #ccc;text-align:right;padding-right:10px;padding-top:8px;border-top:none}
</style>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
<script type="text/javascript">
	function change(op){
		var guid=document.getElementById("guid").value;
		document.getElementById("screen").src="${sys_ctx }/screenModel/beforeSetPersonal.action?guid="+guid+"&op="+op;
		
	}
	
	function setConference(id){
		if(id=="m2"){
		var monitor=document.getElementById("guid").value;
		McuDwrMethod.setConference(monitor);
		$("#m2").css("background","#fff");
		$("#m1").removeAttr("style");
		}else{
		$("#m1").css("background","#fff");
		$("#m2").removeAttr("style");
		}
		
	}
</script>
</head>
<body>
<input type="hidden" value="${param.guid }" id="guid"/>
<div >

		<div class="">
        	<div id="m">
                <ul>
                    <li id="m1" style="background:#fff" onclick="setConference('m1')">个人模式</li> 
                    <li id="m2" onclick="setConference('m2')">会议模式</li> 
                    </ul>
        	</div>
			<div id="k1" class="k" style="display:block">
          		<div class="k_main">
                    <ul class="k_left">
                    	<li class="k_left1" onclick="change('one')">单分屏</li>
                        <li class="k_left2" onclick="change('two')">二分屏</li>
                        <li class="k_left3" onclick="change('four')">四分屏</li>
                    </ul>
                    
                    <iframe id="screen" src="" name="screen" style="HEIGHT: 350px; visibility: inherit; WIDTH:500px; Z-INDEX: 1 " frameborder="0"></iframe>
                   
                </div>
    		</div>
          
    	</div>

    </div>
</body>

</html>