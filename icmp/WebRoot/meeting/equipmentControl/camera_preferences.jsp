<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>摄像头参数设置</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.all-3.5.min.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
	<style type="text/css">
  		.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
  		/*遮罩层*/
		.lockDiv{display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; overflow: hidden; background-color: rgb(255, 255, 255); opacity: 0.5; z-index: 1981; background-position: initial initial; background-repeat: initial initial;}
		.lockDivIE{display: none; z-index: 1981; position: fixed; filter:  alpha(opacity=50); WIDTH: 100%; zoom: 1; background: #fff; height: 100%; overflow: hidden; top: 0px; left: 0px;}
		#layerDiv{display: none; visibility: visible; position: absolute; width: auto; left: 10%; top: 25%; right: 10%; z-index: 1982;}
		.fontone{padding-top:60px; font-size:24px; color:#a90d19; font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;}
		.fonttwo{text-align:right; padding-right:30px; color:414243; width:280px; font-size:18px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif;}
	</style>
  </head>
 <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
   <div id="lockmask" class="lockDivIE"></div>
   <div id="layerDiv">
   	 <p class="dialog_title"></p>
	 <p class="fontone" id="promptInfo">正在提取当前摄像头参数，请稍等...</p>
	 <p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
	 <p class="fonttwo"></p>
   </div>
  <div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
	    <h5 class="fwb fl10" id="titleDiv">摄像头参数设置（由于设备需要反应时间，因而建议每两次操作的间隔在3秒以上）</h5>
	  </div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="40%"><h5 class="fwb" style="float: left">参数模板 <img src="${sys_ctx}/meeting/equipmentControl/images/ztree_add.jpg" title="新增模板" onclick="addTemplate()"/></h5></td>
			<td width="4%"></td>
			<td width="56%"><h5 class="fwb" style="float: left" id="pageHeadTitle">参数设置</h5></td>
		</tr>
	    <tr>
	  	  <td width="40%">
	  		<div id="treeDiv" class="bk1" style="height:245px;">
			  <ul id="treeObject" class="ztree"></ul>
	  		</div>
	  	  </td>
	  	  <td width="4%"></td>
	  	  <td width="56%">
	  		<div id="formDiv" class="bk1" style="height:245px;border:none">
	  		  <form action="" method="post" id="form" name="form">
	  		  	<input type="hidden" name="equipmentCameraVO.cameraId" id="cameraId" value="${ param.cId}"/>
	  		  	<input type="hidden" name="equipmentCameraVO.ccIP" id="ccIp" value="${ param.ccIp}"/>
	  		  	<input type="hidden" name="equipmentCameraVO.templateName" id="templateName" value=""/>
	  		  	<input type="hidden" name="equipmentCameraVO.templateID" id="templateID" value=""/>
	  		  	<input type="hidden" name="equipmentCameraVO.createUserId" id="createUserId" value="${sys_userSession.userID}"/>
	  		    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	  		  	  <tr>
	  		  	    <td width="35%" class="tableaddtitle" style="text-align: center">背光</td>
	  		  	    <td width="65%" class="tableadd_data">
	  		  	    	<input type="radio" name="equipmentCameraVO.backlight" id="" value="ON" checked="checked" onclick="backlightChange(true)"/>开
	  		  	  		<input type="radio" name="equipmentCameraVO.backlight" id="" value="OFF" onclick="backlightChange(false)"/>关
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle" style="text-align: center">曝光</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<input type="radio" name="equipmentCameraVO.exposure" id="" value="ON" checked="checked" onclick="exposureChange(true,true)"/>自动
	  		  	  		<input type="radio" name="equipmentCameraVO.exposure" id="" value="OFF" onclick="exposureChange(false,true)"/>手动
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle">增益</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<select name="equipmentCameraVO.gain" id="gain" style="width:100px" onchange="gainChange()" disabled="disabled">
		  		  	    	<OPTION  value="-3">-3</OPTION>
							<OPTION  value="0">0</OPTION>
							<OPTION  value="2">2</OPTION>
							<OPTION  value="4">4</OPTION>
							<OPTION  value="6">6</OPTION>
							<OPTION  value="8">8</OPTION>
							<OPTION  value="10">10</OPTION>
							<OPTION selected value="12">12</OPTION>
							<OPTION  value="14">14</OPTION>
							<OPTION  value="16">16</OPTION>
							<OPTION  value="18">18</OPTION>
							<OPTION  value="20">20</OPTION>
							<OPTION  value="22">22</OPTION>
							<OPTION  value="24">24</OPTION>
							<OPTION  value="26">26</OPTION>
							<OPTION  value="28">28</OPTION>
			   			</select>
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle">快门</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<select name="equipmentCameraVO.speed" id="speed" style="width:100px" onchange="speedChange()" disabled="disabled">
	  		  	    		<OPTION  value="1/10000">1/10000</OPTION>
							<OPTION  value="1/6000">1/6000</OPTION>
							<OPTION  value="1/3500">1/3500</OPTION>
							<OPTION  value="1/2500">1/2500</OPTION>
							<OPTION  value="1/1750">1/1750</OPTION>
							<OPTION  value="1/1250">1/1250</OPTION>
							<OPTION  value="1/1000">1/1000</OPTION>
							<OPTION  value="1/600">1/600</OPTION>
							<OPTION  value="1/425">1/425</OPTION>
							<OPTION  value="1/300">1/300</OPTION>
							<OPTION  value="1/215">1/215</OPTION>
							<OPTION  value="1/150">1/150</OPTION>
							<OPTION  value="1/120">1/120</OPTION>
							<OPTION  value="1/100">1/100</OPTION>
							<OPTION  value="1/75">1/75</OPTION>
							<OPTION  value="1/50">1/50</OPTION>
							<OPTION selected value="1/25">1/25</OPTION>
							<OPTION  value="1/12">1/12</OPTION>
							<OPTION  value="1/6">1/6</OPTION>
							<OPTION  value="1/3">1/3</OPTION>
							<OPTION  value="1/2">1/2</OPTION>
							<OPTION  value="1/1">1/1</OPTION>
			   			</select>
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle">光圈</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<select name="equipmentCameraVO.iris" id="iris" style="width:100px" onchange="irisChange()" disabled="disabled">
	  		  	    	<!-- 在接收返回值的时候，比如F1.4只能是接收到F1，所以在发送指令的时候以及中控接口处理的时候也都乘以10 -->
	  		  	    		<!-- <OPTION  value="F14">F1.4</OPTION> -->
	  		  	    		<OPTION selected value="F16">F1.6</OPTION>
							<OPTION  value="F20">F2.0</OPTION>
							<OPTION  value="F24">F2.4</OPTION>
							<OPTION  value="F28">F2.8</OPTION>
							<OPTION  value="F34">F3.4</OPTION>
							<OPTION  value="F40">F4.0</OPTION>
							<OPTION  value="F48">F4.8</OPTION>
							<OPTION  value="F56">F5.6</OPTION>
							<OPTION  value="F68">F6.8</OPTION>
							<OPTION  value="F80">F8.0</OPTION>
							<OPTION  value="F96">F9.6</OPTION>
							<OPTION  value="F110">F11</OPTION>
							<OPTION  value="F140">F14</OPTION>
							<!-- <OPTION  value="F160">F16</OPTION>
							<OPTION  value="F190">F19</OPTION>
							<OPTION  value="F220">F22</OPTION> -->
							<OPTION  value="F0">CLOSE</OPTION>
			   			</select>
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle" style="text-align: center">白平衡</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<input type="radio" name="equipmentCameraVO.whiteBalance" id="" value="ON" checked="checked" onclick="whiteBalanceChange(true,true)"/>自动
	  		  	  		<input type="radio" name="equipmentCameraVO.whiteBalance" id="" value="OFF" onclick="whiteBalanceChange(false,true)"/>手动
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle">红色值</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<div class="acquiesce"><input id="red" name="equipmentCameraVO.red" value="10"  disabled="disabled"/></div>
						<div class="acquiesce_list">
						  <span class="acquiesce_list_1"><input type="button" value="" onclick="plus('red');" /></span>
						  <span class="acquiesce_list_2"><input type="button" value="" onclick="reduce('red');" /></span>
						</div>
						<input type="button" class="reset1 radius2" style="padding: 2px 10px; margin:0 10px;" onclick="redChange()" value="设置"/>
	  		  	    </td>
	  		  	  </tr>
	  		  	  <tr>
	  		  	    <td class="tableaddtitle">蓝色值</td>
	  		  	    <td class="tableadd_data">
	  		  	    	<div class="acquiesce"><input id="blue" name="equipmentCameraVO.blue" value="10"  disabled="disabled"/></div>
						<div class="acquiesce_list">
							<span class="acquiesce_list_1"><input type="button" value="" onclick="plus('blue');" /></span>
							<span class="acquiesce_list_2"><input type="button" value="" onclick="reduce('blue');" /></span>
						</div>
						<input type="button" class="reset1 radius2" style="padding: 2px 10px; margin:0 10px;" onclick="blueChange()" value="设置"/>
	  		  	    </td>
	  		  	  </tr>
	  		  	</table>
	  		  </form>
	  		</div>
	  	  </td>
	    </tr>
      </table> 
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	     <tfoot>
	     </tfoot>
		 <tbody>
          <tr>
            <td>
                <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
                <input class="submit1 radius2" type="button" name="" id="saveBtn" style="display: none" value="保存模板" onclick="saveTemplate()"/>
            	<input class="submit1 radius2" type="button" name="" id="callBtn" style="display: none" value="调用模板" onclick="callTemplate()"/>
              	<input class="reset1 radius2" type="button" name="" id="" value="关 闭" onclick="javascript:window.close();"/>
              </td>
          </tr>
	     </tbody>
	  </table>
    </div>
    <script language="JavaScript">
    	var ccIP = "${ param.ccIp}"; 
    	var cId = "${ param.cId}";
    	var exposure = document.getElementsByName("equipmentCameraVO.exposure");
		var backlight = document.getElementsByName("equipmentCameraVO.backlight");
		var whiteBalance = document.getElementsByName("equipmentCameraVO.whiteBalance");
		var flag = false;
	    function plus(id){
			var num = document.getElementById(id);
			if(num.value){
				if(num.value<127){
					num.value = Number(num.value) +1;
				}else{
					document.getElementById('promptSpan').innerHTML = "值不能大于127";
					clearPromptSpan();
				}
			}
		}
		function reduce(id){
			var num = document.getElementById(id);
			if(num.value){
				if(num.value>-128){
					num.value = num.value - 1;
				}else{
					document.getElementById('promptSpan').innerHTML = "值不能小于-128";
					clearPromptSpan();
				}
			}
		}

		var red = document.getElementById("red");
		var blue = document.getElementById("blue");
		var clearPromptSpan = function(){
			setTimeout("document.getElementById('promptSpan').innerHTML=''",5000);
		}
		red.onkeypress = red.onkeyup = red.onblur = function(){
			if(red.value>127){
				red.value = "";
				document.getElementById('promptSpan').innerHTML = "红色值不能大于127";
			}else if(red.value<-128){
				red.value = "";
				document.getElementById('promptSpan').innerHTML = "红色值不能小于-128";
			}else if(red.value){
				clearPromptSpan();
			}
		}
		blue.onkeypress = blue.onkeyup = blue.onblur = function(){
			if(blue.value>127){
				blue.value = "";
				document.getElementById('promptSpan').innerHTML = "蓝色值不能大于127";
			}else if(blue.value<-128){
				blue.value = "";
				document.getElementById('promptSpan').innerHTML = "蓝色值不能小于-128";
			}else if(blue.value){
				clearPromptSpan();
			}
		}

		function showdiv() {            
	        document.getElementById("lockmask").style.display = "block";
	        document.getElementById("layerDiv").style.display = "block";
	        flag = true;
	    }
	    function hidediv() {
	        document.getElementById("lockmask").style.display = 'none';
	        document.getElementById("layerDiv").style.display = 'none';
	        document.getElementById("promptInfo").innerHTML = "正在提取当前摄像头参数，请稍等...";
	        flag = false;
	    }
		
		var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				keep: {
					parent: true
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename,
				onClick: zTreeOnClick			
			}
		};
		 
		var className = "dark";

		function beforeDrag(treeId, treeNodes) {
			return false;
		};
		function beforeEditName(treeId, treeNode){
			className = (className === "dark" ? "" : "dark");
			var treeObject = $.fn.zTree.getZTreeObj("treeObject");
			treeObject.selectNode(treeNode);
			return confirm("确认修改--"+ treeNode.name+" 的模板名称吗？ ");
		}
		function beforeRemove(treeId, treeNode){
			className = (className === "dark" ? "" : "dark");
			var treeObject = $.fn.zTree.getZTreeObj("treeObject");
			treeObject.selectNode(treeNode);
			return confirm("确认删除模板--"+treeNode.name+" 吗？ ");
		}
		function beforeRename(treeId, treeNode, newName, isCancel){
			className = (className === "dark" ? "" : "dark");
			if(newName.length == 0){
				alert("节点名称不能为空");
				var treeObject = $.fn.zTree.getZTreeObj("treeObject");
				setTimeout(function(){treeObject.editName(treeNode)},10);
				return false;
			}
			return true;
		}
		function onRemove(e, treeId, treeNode){
			DwrMethod.delCameraPreferences(treeNode.id, callback);
			function callback(para){
				if(!para){
					alert("模板删除失败");
				}else{
					document.getElementById("saveBtn").style.display = "none";
					document.getElementById("callBtn").style.display = "none";
					document.getElementById("pageHeadTitle").innerHTML = "参数设置";
					document.getElementById('promptSpan').innerHTML = "成功删除参数模板："+ treeNode.name;
					clearPromptSpan();
				}
			}
		}
		function onRename(e, treeId, treeNode, isCancel){
			DwrMethod.updateCameraPreferences(treeNode.id, treeNode.name, callback);
			function callback(para){
				if(!para){
					alert("模板修改失败");
					isCancel = true;
				}else{
					document.getElementById("templateName").value = treeNode.name;
				}
			}
		}

		function showRemoveBtn(treeId, treeNode){
			if(treeNode.id=='0'){
				return false;
			}
			return !treeNode.isParent;
		}
		function showRenameBtn(treeId, treeNode){
			if(treeNode.id=='0'){
				return false;
			}
			return !treeNode.isParent;
		}

		function zTreeOnClick(e, treeId, treeNode){
			if(treeNode.pId!=null){//具体的参数模板
				document.getElementById("saveBtn").style.display = "inline";
				document.getElementById("callBtn").style.display = "inline";
				document.getElementById("pageHeadTitle").innerHTML = "参数设置（模板名称："+treeNode.name+"）";
				DwrMethod.queryCameraTemplate(treeNode.id, callback);
				function callback(para){
					if(para){//后台获取的参数模板
						var equipmentCameraVO = eval(para)[0];
						document.getElementById("templateID").value = equipmentCameraVO.templateID;
						document.getElementById("cameraId").value = equipmentCameraVO.cameraId;
						document.getElementById("gain").value = equipmentCameraVO.gain;
						document.getElementById("speed").value = equipmentCameraVO.speed;
						document.getElementById("iris").value = equipmentCameraVO.iris;
						document.getElementById("red").value = equipmentCameraVO.red;
						document.getElementById("blue").value = equipmentCameraVO.blue;
						
						for(var i = 0;i< exposure.length;i++){
							if(exposure[i].value == equipmentCameraVO.exposure){
								exposure[i].checked = true;
								break;
							}
						}
						for(var i = 0;i< backlight.length;i++){
							if(backlight[i].value == equipmentCameraVO.backlight){
								backlight[i].checked = true;
								break;
							}
						}
						for(var i = 0;i< whiteBalance.length;i++){
							if(whiteBalance[i].value == equipmentCameraVO.whiteBalance){
								whiteBalance[i].checked = true;
								break;
							}
						}

						if(equipmentCameraVO.whiteBalance == "OFF"){
							document.getElementById("red").disabled = "";
							document.getElementById("blue").disabled = "";
						}else{
							document.getElementById("red").disabled = "disabled";
							document.getElementById("blue").disabled = "disabled";
						}
						if(equipmentCameraVO.exposure == "OFF"){
							document.getElementById("gain").disabled = "";
							document.getElementById("speed").disabled = "";
							document.getElementById("iris").disabled = "";
						}else{
							document.getElementById("gain").disabled = "disabled";
							document.getElementById("speed").disabled = "disabled";
							document.getElementById("iris").disabled = "disabled";
						}
						document.getElementById('promptSpan').innerHTML = "成功提取参数模板："+ treeNode.name;
						clearPromptSpan();
					}else{//尚未保存的新增的模板节点
						document.getElementById("templateID").value = "";
						document.getElementById("templateName").value = treeNode.name;
					}
				}
			}else if(treeNode.id== "0"){//当前参数
				document.getElementById("templateID").value = "";
				document.getElementById("templateName").value = "";
				document.getElementById("saveBtn").style.display = "none";
				document.getElementById("callBtn").style.display = "none";
				document.getElementById("pageHeadTitle").innerHTML = "参数设置（当前参数）";

				errorInfo = "";
				showdiv();
				/**20130726modify;中控接口背光返回时间是1.5s,白平衡和曝光都是3.5s（因为摄像头很多参数都是相同的指令，所以需要等待才能确保正确）
				造成返回值不对可能的原因：1、没有返回值的操作却调用了有返回值的sendCommandByReturn()方法；
				2、在收到返回值之前，又发送了一个指令，导致收到的返回值顺序不对
				*/
				getCameraBackLightStatus();
				setTimeout("getCameraWhiteBalanceManualStatus()",1500);
				setTimeout("getCameraExposureManualStatus()",5000);
				setTimeout("hidediv()",10000);
			}else if(treeNode.id== "-1"){//父节点（参数模板）
				
			}
		}
		
		function addTemplate(){
			var treeObject = $.fn.zTree.getZTreeObj("treeObject");
			var treeNode = treeObject.getNodeByParam("id", "-1", null);
			var nodes = treeObject.getNodesByParam("pId", "-1" , null);
			treeObject.addNodes(treeNode, {id:(100 + nodes.length), pId:'-1', name:'参数模板' + (nodes.length+1)});
		}
		function saveTemplate(){
			if(red.value && blue.value){
				var templateIDVal = document.getElementById("templateID").value;
				var templateNameVal = document.getElementById("templateName").value;
				var backlightVal = $("input[name='equipmentCameraVO.backlight']:checked").val();
				var exposureVal = $("input[name='equipmentCameraVO.exposure']:checked").val();
				var gainVal = document.getElementById("gain").value;
				var speedVal = document.getElementById("speed").value;
				var irisVal = document.getElementById("iris").value;
				var whiteBalanceVal = $("input[name='equipmentCameraVO.whiteBalance']:checked").val();
				var redVal = document.getElementById("red").value;
				var blueVal = document.getElementById("red").value;

				var infos = "${ param.ccIp}"+","+"${ param.cId}"+","+templateIDVal+","+templateNameVal+",";
				var preferences = backlightVal+","+exposureVal+","+gainVal+","+speedVal+","+irisVal+","+whiteBalanceVal+","+redVal+","+blueVal+",";
				DwrMethod.saveCameraTemplate(infos, preferences, function(para){
					if(para){
						document.getElementById("templateID").value = para;
						var treeObject = $.fn.zTree.getZTreeObj("treeObject");
						var treeNode = treeObject.getSelectedNodes()[0];
						if(templateIDVal){
							document.getElementById('promptSpan').innerHTML = "成功修改模板：" + treeNode.name;
						}else{
							document.getElementById('promptSpan').innerHTML = "成功新增模板：" + treeNode.name;
						}
						clearPromptSpan();
					}
				});
			}else{
				alert("红色值和蓝色值都不能为空");
			}
		}
		
		$(document).ready(function(){
			//层的兼容性问题
			if(!!(window.attachEvent && navigator.userAgent.indexOf('Opera') === -1)){//判断IE
				document.getElementById("lockmask").className="lockDivIE";
			}else{
				document.getElementById("lockmask").className="lockDiv";
			}
			//获取模板树
			DwrMethod.cameraPreferencesBefore("${ param.ccIp}", "${ param.cId}", callback);
			function callback(para){
				var zNodes = eval(para);
				$.fn.zTree.init($("#treeObject"), setting, zNodes);
				$(document).ready(function(){$("#treeObject_1_a").trigger("click")});
			}
		})
		
		var errorInfo = "";
		var getCameraBackLightStatus = function(){
			DwrMethod.getCameraBackLightStatus("${ param.ccIp}", "${ param.cId}", function(para){
				if(para){
					for(var i = 0;i< backlight.length;i++){
						if(backlight[i].value == para){
							backlight[i].checked = true;
							break;
						}
					}
				}else{
					errorInfo += "（背光）";
					document.getElementById('promptSpan').innerHTML = "提取当前摄像头的"+errorInfo+"失败";
					clearPromptSpan();
				}
			})
		}
		
		var getCameraExposureManualStatus = function(){
			DwrMethod.getCameraExposureManualStatus("${ param.ccIp}", "${ param.cId}", function(para){
				if(para){
					var data = eval(para);
					if(data[0].exposure == "OFF"){
						document.getElementById("gain").value = data[0].gain;
						document.getElementById("speed").value = data[0].speed;
						document.getElementById("iris").value = data[0].iris;
						document.getElementById("gain").disabled = "";
						document.getElementById("speed").disabled = "";
						document.getElementById("iris").disabled = "";
					}else{
						document.getElementById("gain").disabled = "disabled";
						document.getElementById("speed").disabled = "disabled";
						document.getElementById("iris").disabled = "disabled";
					}
					for(var i = 0;i< exposure.length;i++){
						if(exposure[i].value == data[0].exposure){
							exposure[i].checked = true;
							break;
						}
					}
				}else{
					errorInfo += "（曝光）";
					document.getElementById('promptSpan').innerHTML = "提取当前摄像头的"+errorInfo+"失败";
					clearPromptSpan();
				}
			})
		}
		var getCameraWhiteBalanceManualStatus =	function(){
			DwrMethod.getCameraWhiteBalanceManualStatus("${ param.ccIp}", "${ param.cId}", function(para){
				if(para){
					var data = eval(para);
					if(data[0].whiteBalance == "OFF"){
						document.getElementById("red").value = data[0].red;
						document.getElementById("blue").value = data[0].blue;
						document.getElementById("red").disabled = "";
						document.getElementById("blue").disabled = "";
					}else{
						document.getElementById("red").disabled = "disabled";
						document.getElementById("blue").disabled = "disabled";
					}
					for(var i = 0;i< whiteBalance.length;i++){
						if(whiteBalance[i].value == data[0].whiteBalance){
							whiteBalance[i].checked = true;
							break;
						}
					}
				}else{
					errorInfo += "（白平衡）";
					document.getElementById('promptSpan').innerHTML = "提取当前摄像头的"+errorInfo+"失败";
					clearPromptSpan();
				}
			})
		}
		
		//参数的实时设置
		function backlightChange(flag){
			DwrMethod.cameraBackLight(ccIP ,cId, flag, function(para){
				if(para){
				}else{
					alert("背光操作失败");
				}
			});
		}

		/**第一个参数是input的值，第二个是判断是参数的设置还是调用的模板
		*/
		function exposureChange(flag,isOperate){
			if(flag){
				document.getElementById("gain").disabled = "disabled";
				document.getElementById("speed").disabled = "disabled";
				document.getElementById("iris").disabled = "disabled";
			}else{
				document.getElementById("gain").disabled = "";
				document.getElementById("speed").disabled = "";
				document.getElementById("iris").disabled = "";
			}
			DwrMethod.cameraExposureManual(ccIP ,cId, flag, function(para){
				if(para){
					if(!flag&&isOperate){
						errorInfo = "";
						showdiv();
						getCameraExposureManualStatus();
						setTimeout('hidediv()',5000);
					}
				}else{
					alert("曝光操作失败");
				}
			});
		}

		function whiteBalanceChange(flag,isOperate){
			if(flag){
				document.getElementById("red").disabled = "disabled";
				document.getElementById("blue").disabled = "disabled";
			}else{
				document.getElementById("red").disabled = "";
				document.getElementById("blue").disabled = "";
			}
			DwrMethod.cameraWhiteBalanceManual(ccIP ,cId, flag, function(para){
				if(para){
					if(!flag&&isOperate){
						errorInfo = "";
						showdiv();
						getCameraWhiteBalanceManualStatus();
						setTimeout('hidediv()',4000);
					}
				}else{
					alert("白平衡操作失败");
				}
			});
		}

		function gainChange(){
			var gain = document.getElementById("gain");
			DwrMethod.cameraExposureManualGain(ccIP, cId, gain.value, function(para){
				if(!para){
					alert("曝光_增益：操作失败");
				}
			})
		}

		function speedChange(){
			var speed = document.getElementById("speed");
			DwrMethod.cameraExposureManualSpeed(ccIP, cId, speed.value, function(para){
				if(!para){
					alert("曝光_快门：操作失败");
				}
			})
		}

		function irisChange(){
			var iris = document.getElementById("iris");
			/**移至后台做处理
			var irisval =  $("#iris option:selected").text();
			if($("#iris option:selected").text()=="CLOSE"){
				irisval = $("#iris option:selected").val();
			}*/
			DwrMethod.cameraExposureManuaIris(ccIP, cId, iris.value, function(para){
				if(!para){
					alert("曝光_光圈：操作失败");
				}
			})
		}

		function redChange(){
			var red = document.getElementById("red");
			DwrMethod.cameraWhiteBalanceManualR(ccIP, cId, red.value, function(para){
				if(!para){
					alert("白平衡_红：操作失败");
				}
			})
		}

		function blueChange(){
			var blue = document.getElementById("blue");
			DwrMethod.cameraWhiteBalanceManualB(ccIP, cId, blue.value, function(para){
				if(!para){
					alert("白平衡_蓝：操作失败");
				}
			})
		}

		function callTemplate(){
			if(red.value && blue.value){
				var backlightVal = $("input[name='equipmentCameraVO.backlight']:checked").val();
				var exposureVal = $("input[name='equipmentCameraVO.exposure']:checked").val();
				var whiteBalanceVal = $("input[name='equipmentCameraVO.whiteBalance']:checked").val();

				errorInfo = "";
				document.getElementById("promptInfo").innerHTML = "正在调用模板...";
				showdiv();//弹出层
				clearPromptSpan();
				if(backlightVal == "OFF"){
					backlightChange(false);
				}else{
					backlightChange(true);
				}
				if(whiteBalanceVal == "OFF"){
					setTimeout("whiteBalanceChange(false,false)",500);
					setTimeout("redChange()",800);
					setTimeout("blueChange()",1000);
				}else{
					setTimeout("whiteBalanceChange(true,false)",500);
				}
				if(exposureVal == "OFF"){//曝光起码需要2秒的返回时间，四组数据
					setTimeout("exposureChange(false,false)",1200);
					setTimeout("gainChange()",1600);
					setTimeout("speedChange()",1800);
					setTimeout("irisChange()",2000);
				}else{
					setTimeout("exposureChange(true,false)",1200);
				}
				setTimeout('hidediv()',2200);
			}
		}

		window.onbeforeunload = function(){
			if(flag){
				var warning = "请先确认摄像头参数已经提取完毕？";
				return warning;
			}
		}
	</script>    
  </body>
</html>