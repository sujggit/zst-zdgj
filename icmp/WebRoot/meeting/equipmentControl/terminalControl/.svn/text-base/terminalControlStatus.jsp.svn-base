<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html>
  <head>
    <title>视频终端状态管理</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
	<script type="text/javascript" src="${sys_ctx }/dwr/interface/DwrMethod.js"> </script>
	<script language="JavaScript">
		
		var setting = {
			view: {
				//addHoverDom: addHoverDomLevel,
				//removeHoverDom: removeHoverDomLevel,
				selectedMulti: false
			},
			check: {
				enable: false
			},
			edit: {
				enable: false,
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
			
			}
		};

		var isOperate = false;
		$(document).ready(function(){
		var str="${ztreeDate}";
				if(str){
					var zNodes=eval(str);
					$.fn.zTree.init($("#levelTree"),setting,zNodes);
				}
			
			window.onbeforeunload = function(){
				if(isOperate){
					alert("温馨提示：分级管理所做的修改需要重新登录才能生效！");
				}
			}
		})
		
		
		function onClick(e, treeId, treeNode){
		if(treeNode.isaddress=="false"){
		 //treeNode.icon="/icmp/meeting/equipmentControl/image/wait1.gif";
		 //var zTree = $.fn.zTree.getZTreeObj("levelTree");
		 //zTree.updateNode(treeNode,true);  
		 		
	    window.frames["iframe_I2"].location.href="${sys_ctx}/equipmentControl/videoEndPointBefore.action?equipmentVO.equipmentID="+treeNode.id;	
		}
		}
		function fun(){ 
		   location.href="http://localhost:8888/icmp/equipmentControl/terminalControlBefore.action";
		  
		    alert("设备已连接，欢迎您的使用！");
		}
		function startTer(){
			
			DwrMethod.startTer(function callback(flag){
				if(flag){
					//$("#tishi").innerHTML="设备连接中";
					
					$("#tishi").html("<span  style='color: red'>设备连接中...</span>");
					//alert("设备连接中，请稍后");
					document.getElementById("stopTer").disabled=false;
					document.getElementById("startTer").disabled=true;
					setTimeout(fun,20000); 
					//alert("设备已连接，欢迎您的使用！");
					
					 
				}else{
					alert("操作失败");
				}
			});
		}
		function stopTer(){
			DwrMethod.stopTer(function callback(flag){
				if(flag){
					$("#tishi").html("<span  style='color: red'></span>");
					alert("操作成功");
					document.getElementById("stopTer").disabled=true;
					document.getElementById("startTer").disabled=false;
				}else{
					alert("操作失败");
				}
			});
		}
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
		
	</style>
 </head>

 <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
     <div id="basicform" class="contentwrapper">
       <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd tableadd_one">
       		<tr>
       			<td class="tableaddtitle" align="left" valign="top">
       				<div>
       					<input id="startTer" type="button" value="开启终端" style="float:left;margin-left:10px;font-size:12px;" onclick="startTer();" <c:if test="${numberTerStatus==1}">disabled="disabled"</c:if>/>
       					<input id="stopTer" type="button" value="关闭终端" style="float:left;;margin-left:15px;font-size:12px;" onclick="stopTer();" <c:if test="${numberTerStatus==0||numberTerStatus==2 }">disabled="disabled"</c:if>/>
       					<span id="tishi" ></span>
       					
       				</div>
					<div  style="width:270px;height:500px;padding:0;overflow:auto;"><ul id="levelTree" class="ztree"></ul></div>
       			</td>
       			<td class="tableadd_data" style="margin:0;padding:0" valign="top">
       				<iframe name="iframe_I2" id="iframe_I2" width="100%" border="0" frameborder="0" scrolling="yes" style="min-height:500px; display:block;margin-top: 0;">
                   	
                   </iframe>
       			</td>
       		</tr>
       	</table>
      </div>
  </body>

  
</html>