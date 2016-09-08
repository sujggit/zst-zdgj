<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>设备控制</title>
<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script>
	var setting = {
			view: {
				selectedMulti: false,
				showTitle: true
			},
			edit: {
				enable: false
			},
			data: {
				key: {
					title: "fullName"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				  onClick:getInfo
				}
		};
		equipmentType =(<%=request.getParameter("equipmentType")%>);
		$(document).ready(function createTree() {
			DwrMethod.getMeetingRoomByEquiment(equipmentType,function treeBack(para){
				if(para!=null){
					var zNodes = eval(para);
					$.fn.zTree.init($("#treeObject"), setting, zNodes);
					var treeObject = $.fn.zTree.getZTreeObj("treeObject");
					//模糊查询匹配的节点元素;如果超过两个会场，则可以批量操作全开、全关
					var roomNodes = treeObject.getNodesByParamFuzzy("ccIp",".",null); 
					if(roomNodes.length>1){
						//暂时关闭批量操作功能
						//document.getElementById("controlAll").style.display = "block";
					}
					if(roomNodes[0].ccIp){
						var defalutTreeId = "treeObject_2";//默认选中子节点第一个
						defalutTreeId += "_a";
						$(document).ready(function(){$("#"+defalutTreeId).trigger("click")});
					}
				}else{
					$("#controlAll").attr("style","display: block");
					$("#controlAll").html("<b>&nbsp;&nbsp;会议室下所属的智能中控没有此设备</b>");
				}
			});
		})
		function getInfo(event,treeId,treeNode){
			var ccIp = treeNode.ccIp;
			if(ccIp){
				var URL =["${sys_ctx}/equipmentControl/audioControlBefore.action?equipmentVO.ip="+ccIp//音频扩声audio
			              ,"${sys_ctx}/equipmentControl/cameraBefore.action?equipmentVO.ip="+ccIp//摄像头控制camera
			              ,"${sys_ctx}/equipmentControl/getLightControl.action?equipmentVO.ip="+ccIp//灯光控制light
			              ,"${sys_ctx}/equipmentControl/matrixBefore.action?equipmentVO.ip="+ccIp//矩阵切换matrix
			              ,"${sys_ctx}/equipmentControl/getPlasmaTV.action?equipmentVO.ip="+ccIp//等离子控制pla
			              ,"${sys_ctx}/equipmentControl/getProjector.action?equipmentVO.ip="+ccIp//投影仪控制prog
			              ,"${sys_ctx}/equipmentControl/fixedTimeBeforeNew.action?equipmentVO.ip="+ccIp//系统电源sysPower
			              ,"${sys_ctx}/equipmentControl/getLiftingScreen.action?equipmentVO.ip="+ccIp//升降屏控制upDownScreen
			              ,"${sys_ctx}/equipmentControl/centerControlBefore.action?equipmentVO.ip="+ccIp//中控状态vedioTerminal原型无
			              ,"${sys_ctx}/meeting/equipmentControl/dvdControl.jsp?ccip="+ccIp//DVD控制"dvd"
			              ,"${sys_ctx}/equipmentControl/bigscreenMonitorBefore.action?equipmentVO.ip="+ccIp//大屏监控screent原型无
			              ,"${sys_ctx}/equipmentControl/bigscreenPowerBefore.action?equipmentVO.ip="+ccIp//大屏电源screent
			              ,"${sys_ctx}/equipmentControl/curtainControlBefore.action?equipmentVO.ip="+ccIp//窗帘curtain
			              ,"${sys_ctx}/equipmentControl/getVideom.action?equipmentVO.ip="+ccIp//画面分割器控制videom
			              ];
				if(equipmentType == "audio"){
					$("#iframe_I1").attr("src",URL[0]);
				}else if(equipmentType == "camera"){
					$("#iframe_I1").attr("src",URL[1]);
				}else if(equipmentType == "light"){
					$("#iframe_I1").attr("src",URL[2]);
				}else if(equipmentType == "matrix"){
					$("#iframe_I1").attr("src",URL[3]);
				}else if(equipmentType == "pla"){
					$("#iframe_I1").attr("src",URL[4]);
				}else if(equipmentType == "proj"){
					$("#iframe_I1").attr("src",URL[5]);
				}else if(equipmentType == "sysPower"){
					$("#iframe_I1").attr("src",URL[6]);
				}else if(equipmentType == "upDownScreen"){
					$("#iframe_I1").attr("src",URL[7]);
				}else if(equipmentType == "dvd"){
					$("#iframe_I1").attr("src",URL[9]);
				}else if(equipmentType == "screent"){
					$("#iframe_I1").attr("src",URL[11]);
				}else if(equipmentType == "curtain"){
					$("#iframe_I1").attr("src",URL[12]);
				}else if(equipmentType == "videom"){
					$("#iframe_I1").attr("src",URL[13]);
				}
			}else{
				alert("请选择具体的会议室！");
			}
		}
</script>
</head>
<body>
<div class="Conference_Management" style="border: 0px solid red;height: 99.9%;">
    <div class="dtree" bgcolor="#cccccc" >
        <p style="border-bottom:1px solid #ccc; color: #292421; font-family: 'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold;padding-left: 12px">请选择会场</p>
            <div >
			 <ul id="treeObject" class="ztree"></ul>
			</div>
    </div>
</div>
<!--  <div style="position: absolute;top: 0px;left: 222px;height: 99%;">-->
<div class="centercontent tables list">
	 <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr id="controlAll" style="display: none">
          <td rowspan="1" class="tableaddtitle" style="vertical-align:bottom;">
          	  <input type="reset" class="submit1 radius2" value="全开" style="display: none"/>
              <input type="reset" class="reset1 radius2" value="全关" style="display: none"/>
              </td>
        </tr>
		<tr>
			<td>
				<iframe src="" style="display:block;min-height: 449px" 
				name="I1" id="iframe_I1" width="100%" border="0" frameborder="0" scrolling="yes" width="100%"></iframe>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
