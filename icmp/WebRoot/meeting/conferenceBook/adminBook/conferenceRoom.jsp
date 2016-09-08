<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/demo.css" type="text/css">
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.exhide-3.5.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.exedit-3.5.js"></script>
	<style>
		.ztree li span.demoIcon{padding:0 2px 0 10px;}
		.ztree li span.button.iconModify{margin:0; background: url(${sys_ctx }/meeting/conferenceBook/adminBook/images/modify.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
		.ztree li span.button.iconAddr{margin:0; background: url(${sys_ctx }/meeting/conferenceBook/adminBook/images/addr.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
		.ztree li span.button.iconMainRoom{margin:0; background: url(${sys_ctx }/meeting/conferenceBook/adminBook/images/mainRoom.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
		.ztree li span.button.icon01_ico_docu{margin:0; background: url(${sys_ctx }/meeting/conferenceBook/adminBook/images/mainRoom.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
		.ztree li span.button.equipmentGroup{margin:0; background: url(${sys_ctx }/meeting/conferenceBook/adminBook/images/mainRoom.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
	</style>
    <SCRIPT type="text/javascript">
   		/**
		*针对树的一些业务算法
		*1、考虑大数据量情况，实现了延迟加载功能，即不展开的节点不创建子节点的DOM。对于每级节点最多一百左右，但总节点数几千甚至几万，且不是全部展开的数据，一次性加载的效果最明显，速度非常快。
		*2、网络拓扑、会议室、设备及设备类型有明确表示
		*
		*
		*
		*json数据：
		*{id:equipID, pId:roomID2, name:equipName ,nodeType:ty,nodeLink:link,mcuIP:ip}
		*nodeType:0网络拓扑，1会议室，2MCU设备，3终端设备
		*ip:只有设备IP
		*nodeLink:父节点全路径
		*parentID:从属ID
		*
		*
		*/
		var nodeType_address	= 0;
		var nodeType_room	= 1;
		var nodeType_mcu	=2;
		var	nodeType_ter	=3;
	    var leftTreeNodes = [];
	    var rightTreeNodes = [];
	    var e_uStatus_invalid = 1;//设备被会议占有
	    var e_uStatus_valid = 0;//设备没有被占用
	    
    	//左侧的树
		function createLeftTree () {
			$("#leftTree").empty();
			var zTree = $.fn.zTree.init($("#leftTree"), leftSetting, leftTreeNodes);
			//zTree.childOuter:false
		}
		
		//右侧的树
		function createRightTree () {
			$.fn.zTree.init($("#rightTree"), rightSetting,rightTreeNodes);
			//var zTree = $.fn.zTree.init($("#rightTree"), setting, leftTreeNodes);
			
			//var nodes = zTree.getNodes();
			//for(var i=0;i<nodes.length;i++){
			//	zTree.hideNode(nodes[i]);
			//}
		}
		
		var leftSetting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				dblClickExpand: false,
				selectedMulti: true,
				nameIsHTML: true,
				expandSpeed: "fast"
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false,
				drag:{
					isCopy: false,
					isMove: false
				}
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
				onDblClick: onDblClick
				//beforeExpand: beforeExpand,//选择互斥-1
				//onExpand: useEquipmentUStatus//选择互斥-2
			}
		};
		
		var rightSetting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				dblClickExpand: false,
				expandSpeed: "fast"
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
				onDblClick: onDblClick_right,
				//beforeExpand: beforeExpand,//选择互斥-1
				//onExpand: onExpand,//选择互斥-2
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				onDrop:onDrop
			}
		};
		
		//计算已经选择的会场个数
		function selectVenueNumber(treeId){
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			var nodes = zTree.transformToArray(zTree.getNodes());
			$("#selectVenueSpan").empty();
			$("#selectVenueSpan").append(nodes.length);
		}
		
		//在右侧树上添加左侧树选中的节点及所有子节点。
		//如果父节点在右侧树不存在，需要先添加父节点。递归处理父节点问题
		var treeDataAdd = function(fromTreeId,toTreeId,node,nodeLink){
			var tozTree = $.fn.zTree.getZTreeObj(toTreeId);
			//根据id，查询左侧树所有节点及属性
			addAllMcuChildrenNodes(tozTree,node);//首先添加MCU
			addAllTerChildrenNodes(tozTree,node);//再添加终端
			
			selectVenueNumber(toTreeId);//计算选择的个数
			alert("添加成功");
			return;
		}
		
		var editStr;
		
		function addAllMcuChildrenNodes(tozTree,node){
			editStr ="";
			if(tozTree.getNodeByParam("id", node.id, null)){
				return;
			}
			if(node.nodeType==nodeType_mcu){//显示MCU模板
				var parentNode = tozTree.getNodeByParam("id", node.cascadeID, null);//是否有所属MCU
				var newNode = tozTree.addNodes(null,node,true);
				viewMeetingModel(node.mcuModel,newNode[0]);
			}
			
		    var childrenNodes = node.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
					addAllMcuChildrenNodes(tozTree,childrenNodes[i]);
			    }
		    }
		}
		
		//主MCU，显示会议模式
		function viewMeetingModel(nodeMcuModel,newNode){
			var mcuCacsdeModelOption = "${mcuCacsdeModelOption}";
			var seID = "diyBtn_right_mcu"+newNode.id;
			var aObj = $("#" + newNode.tId + "_a");
			
			
			if(nodeMcuModel!=11||nodeMcuModel!=17){//1000/500mcu/不需要用户选择模板
				var editStr = "<select class='selDemo' id='"+seID+"' onchange=chooseMeetingModel('"+newNode.tId+"',this)>";
				editStr += mcuCacsdeModelOption;
				editStr += "</select>";
				aObj.after(editStr);
			}
		}
		
		function addEquipmnetGroup(){
			var zTree = $.fn.zTree.getZTreeObj("rightTree");
			var nodes = zTree.getNodes();
			if(nodes.length==0){
				alert("选择设备");
				return;
			}
			
			var groupName = prompt("输入组名称","");
			if(!groupName)	return ;//alert("==");else	alert(groupName);
			
			var nodesArray = zTree.transformToArray(nodes);
			var ids = "";
			for(var j=0;j<nodesArray.length;j++){
				ids +=nodesArray[j].id+",";
			}
			
			DwrMethod.addEquipmentGroup(ids,groupName,function(rs){
				if(rs)
					alert("成功");
				else
					alert("失败");
			})
		}
		
		 //会议模式变化后，更新其他MCU模板
		function chooseMeetingModel(tId,obj){
			//默认设置级联MCU各自的模板
			var zTree = $.fn.zTree.getZTreeObj("rightTree");
			var node = zTree.getNodeByTId(tId);
			DwrMethod.getMcuModelOptionByMeetingModel(obj.value,function(rs){
				if(rs!=null&&rs.length>0){
					var modelStr = rs.split("##");
					if(modelStr==null||modelStr.length!=2) return;
					var mcuIPS		=	modelStr[0];
					var mcuModelIDs	=	modelStr[1];
					if(mcuIPS==null||mcuIPS.length==0||mcuModelIDs==null||mcuModelIDs.length==0) return;
					
					forEachMcu(mcuIPS,mcuModelIDs,node);
				}
			});
		}
		
		//递归子节点中的MCU，并设置相应模板
		function forEachMcu(mcuIPS,mcuModelIDs,node){
			//设置级联MCU模板数据
		    var childrenNodes = node.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
			    	var childNode = childrenNodes[i];
			    	if(childNode.nodeType==nodeType_mcu){
			    		if(childNode.mcuModel==11||childNode.mcuModel==17)	continue;//500 1000不需要模板
						var seID = "diyBtn_right_mcu"+childNode.id;
						//提取mcu对应会议模式的ID
						var modelID = getSelectModelID(mcuIPS,mcuModelIDs,childNode.ip,childNode.name);
						if(modelID==null)
							alert(childNode.name+"没有匹配上对应的模板");
						else
							$("#" + seID).val(modelID);
							
						//递归设置子mcu的模板
			    		forEachMcu(mcuIPS,mcuModelIDs,childNode);
			    	}
			    }
		    }
		}
		
		//mcu对应的mcu模板ID
		function getSelectModelID(mcuIPS,mcuModelIDs,ip,name){
			var ips = mcuIPS.split("_");
			var ids = mcuModelIDs.split("_");
			for(var i=0;i<ips.length;i++){
				if(ip==ips[i]){
					return ids[i];
				}
			}
			return null;
		}
		
		//显示mcu上的模板
		function viewMCUModel(nodeMcuModel,newNode){
			var seID = "diyBtn_right_mcu"+newNode.id;
			//需要解决重复添加的问题
			if(nodeMcuModel!=11&&nodeMcuModel!=17){//1000/500mcu/不需要用户选择模板
				DwrMethod.getMcuModelOption(newNode.ip,function(rs){
					if( rs != null ){
						var aObj = $("#" + newNode.tId + "_a");
						var editStr = "<select class='selDemo' id='"+seID+"' >";
						editStr += rs;
						editStr += "</select>";
						aObj.after(editStr);
					}
				});
			}
		}
		
		function addAllTerChildrenNodes(tozTree,node){
			editStr ="";
			
			if(tozTree.getNodeByParam("id", node.id, null)){
				return;
			}else if(node.uStatus == e_uStatus_invalid){
				return;
			}
			
			if(node.nodeType==nodeType_ter){
				var parentNode = tozTree.getNodeByParam("id", node.cascadeID, null);//是否有所属MCU
				if(parentNode){
					newNode = tozTree.addNodes(parentNode,node,true);
				}else{
					newNode = tozTree.addNodes(null,node,true);
				}
			}

		    var childrenNodes = node.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
					addAllTerChildrenNodes(tozTree,childrenNodes[i]);
			    }
		    }
		}
		
		/**
		*添加孩子节点
		*/
		function addAllChildrenNodes(tozTree,node){
			editStr ="";
			if(tozTree.getNodeByParam("id", node.id, null)){
				return;
			}
			
		    var childrenNodes = node.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
					addAllChildrenNodes(tozTree,childrenNodes[i]);
			    }
		    }
		}
		
		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			if(targetNode.nodeType!=nodeType_mcu){
				alert("只能加入到MCU");
				return	false;
			}

			//if(targetNode.nodeType==nodeType_mcu&&targetNode.level>=1){//加入MCU
			//	if(treeNodes[0].nodeType==nodeType_mcu){
			//		alert("只支持2级MCU级联");
			//		return	false;
			//	}
			//}
			
			if("inner"==moveType){
				for(var i=0;i<treeNodes.length;i++){
					var node =treeNodes[i]; 
					if(node.nodeType==nodeType_mcu){//从MCU不显示会议模式
						var btn = $("#diyBtn_right_mcu"+node.id);
						btn.unbind().remove();
						
						viewMCUModel(node.mcuModel,node);//显示MCU上的模板
					}
				}
				beforeDropAllEquipmentNodes(treeNodes[0],targetNode);
			}else{
				for(var i=0;i<treeNodes.length;i++){
					var node =treeNodes[i]; 
					if(node.nodeType==nodeType_mcu&&targetNode.level==0){//主MCU显示会议模式
						var btn = $("#diyBtn_right_mcu"+node.id);//解决重复添加
						btn.unbind().remove();
						viewMeetingModel(node.mcuModel,node);
					}
				}
				targetNode ? targetNode.drop !== false : true;
			}
			return ;
		}
		
		function beforeDropAllEquipmentNodes(treeNode,targetNode){
			if(treeNode.nodeType==nodeType_mcu||treeNode.nodeType==nodeType_ter){
				targetNode = treeNode;
				targetNode ? targetNode.drop !== false : true;
			}
//			alert(treeNode.name+"==拖动类型");
		    var childrenNodes = treeNode.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
				    beforeDropAllEquipmentNodes(childrenNodes[i],targetNode);
			    }
		    }
		}
		
		function onDrop(){
			
		}
		
		/**
		**最后选择节点的属性
		**/
		var lastSelectNodeIndex = "-99";
		var lastSelectParentNodeID = "-99";
		var lastSelectTreeId = "-99";
		function onClick(e, treeId, treeNode){
			var parentNode = treeNode.getParentNode();
			var parentNodeID="-1" ;
			if(parentNode!=null) 
				parentNodeID = parentNode.id;
				
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			var index = zTree.getNodeIndex(treeNode);
			if(e.shiftKey){
				if(lastSelectTreeId!="-99"&&lastSelectTreeId==treeId&&lastSelectParentNodeID!="-99"&&parentNodeID == lastSelectParentNodeID){
					if(index > lastSelectNodeIndex){//前一个节点
						for(var i=0;i<index-lastSelectNodeIndex;i++){
							var node = treeNode.getPreNode();
							zTree.selectNode(node,true);
							treeNode = node;
						}
					}else if(index < lastSelectNodeIndex){//后一个节点 
						for(var i=0;i<lastSelectNodeIndex-index;i++){
							var node = treeNode.getNextNode();
							zTree.selectNode(node,true);
							treeNode = node;
						}
					}
					
				}
			}
			
			lastSelectParentNodeID = parentNodeID;
			lastSelectNodeIndex = index;
			lastSelectTreeId = treeId;
			//互斥
			//var zTree = $.fn.zTree.getZTreeObj(treeId);
			//zTree.expandNode(treeNode, null, null, null, true);
		}
		
		//删除一侧树上的节点,如果父节点下只有一个节点，删除父节点
		function onDblClick(e, treeId, treeNode){
			var treeObj = $.fn.zTree.getZTreeObj(treeId);
			var node = getParentNodesHasOneChildren(treeId,treeNode);//删除该节点后，父节点为空的节点
			
			treeDataAdd("leftTree","rightTree",node,node.nodeLink);//操作另一侧的树	
			
			//treeObj.removeNode(node);//删除数据			
		}

		//删除一侧树上的节点,如果父节点下只有一个节点，删除父节点，
		function onDblClick_right(e, treeId, treeNode){
			var treeObj = $.fn.zTree.getZTreeObj(treeId);
			if(treeNode.id==$("#mainEquipmentID").val()){
				if(!window.confirm("删除主会场?")) return;
				$("#mainRoomName").empty();
				$("#mainRoomID").attr("value","");
				$("#mainEquipmentID").attr("value","");
			}
			var node = getParentNodesHasOneChildren(treeId,treeNode);//删除该节点后，父节点为空的节点
			treeObj.removeNode(node);//删除数据
		}
		
		//查找只有一个子节点的最高父节点
		function getParentNodesHasOneChildren(treeId,node){
		    var b = true;
			while(b){
				var treeObj = $.fn.zTree.getZTreeObj(treeId);
				
				var parentNode = node.getParentNode();
				
				if(parentNode==null){//如果没有父节点跳出递归。
				 	b=false;
				 	continue;
				}
				var childrens = parentNode.children;
				if(childrens.length >1) {//如果多余一个子节点跳出递归
					b =false;continue;
				}
				if(childrens.length ==1) {
					node = parentNode;
				}
			}
			return node;
		}
		
		function getAllParenteNodesLink(treeNode){
		    var childrenNodes = treeNode.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
				    getAllChildrenNodes(childrenNodes[i],nodes);
			    }
		    }
		}
		function getAllChildrenNodes(treeNode){
		    var childrenNodes = treeNode.children;
		    if (childrenNodes) {
			    for (var i = 0; i < childrenNodes.length; i++) {
				    getAllChildrenNodes(childrenNodes[i],nodes);
			    }
		    }
		}
		
		function addHoverDom(treeId, treeNode) {
			var aObj = $("#" + treeNode.tId + "_a");
			//区域与会议室不显示自定义控件
			if(treeNode.nodeType==nodeType_ter&&treeNode.uStatus != e_uStatus_invalid){//如果状态是占用的时候，不显示操作按钮
				if ($("#diyBtn1_"+treeNode.id).length>0) return;
				if ($("#diyBtn2_"+treeNode.id).length>0) return;
				var editStr = "<span onclick=addHoverDomModifyVenue('"+treeNode.nodeType+"','"+treeNode.id+"') class='button iconModify' id='diyBtn2_" +treeNode.id+ "' title='修改' ></span>";
					editStr += "<span  onclick=addHoverDomMainVenue('"+treeId+"','"+treeNode.name+"','"+treeNode.roomID+"','"+treeNode.id+"') class='button iconMainRoom' id='diyBtn1_" +treeNode.id+ "' title='设为主会场' ></span>";
				aObj.after(editStr);
			}
			if(treeNode.nodeType==nodeType_mcu){
				if ($("#diyBtn1_"+treeNode.id).length>0) return;
				var editStr = "<span onclick=addHoverDomModifyVenue('"+treeNode.nodeType+"','"+treeNode.id+"') class='button iconModify' id='diyBtn1_" +treeNode.id+ "' title='修改' ></span>";
				aObj.after(editStr);
			}
		};
		
		function addHoverDomModifyVenue(nodeType,id){
			if(nodeType_ter==nodeType){
				window.showModalDialog("${sys_ctx}/equipment/terminalBeforModify.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}else if(nodeType_mcu==nodeType){
				window.showModalDialog("${sys_ctx}/equipment/mcuBeforModify.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}
		}
		
		function addHoverDomMainVenue(treeId,name,roomID,id){
			if(treeId=="leftTree"){//解决修改时，还没有初始化树的问题。
				var treeObj = $.fn.zTree.getZTreeObj("rightTree");
				/** 直接在左侧树内点击设为主会场时，首先添加会场到右侧。在 addHoverDom 方法内控制左侧树如果是占用的状态下，不现实操作按钮（这里的过滤状态可以屏蔽）**/
				var leftTreeObj = $.fn.zTree.getZTreeObj("leftTree");
				var leftNode = leftTreeObj.getNodeByParam("id", id);
				if(leftNode.uStatus == e_uStatus_invalid){
					alert("已经被占用");return;
				}
				addAllTerChildrenNodes(treeObj,leftNode);//再添加终端
			}
			
			$("#mainRoomName").empty();
			$("#mainRoomName").append(name);
			$("#mainRoomID").attr("value",roomID);
			$("#mainEquipmentID").attr("value",id);
			
		}
		
		function removeHoverDom(treeId, treeNode) {
			if(treeNode.nodeType==nodeType_ter){
				$("#diyBtn1_"+treeNode.id).unbind().remove();
				$("#diyBtn2_"+treeNode.id).unbind().remove();
			}else if(treeNode.nodeType==nodeType_mcu){
				$("#diyBtn1_"+treeNode.id).unbind().remove();
			}
		}
		
		var curExpandNode = null;
		function beforeExpand(treeId, treeNode) {
			var pNode = curExpandNode ? curExpandNode.getParentNode():null;
			var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
			var zTree = $.fn.zTree.getZTreeObj(treeId);
			for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
				if (treeNode !== treeNodeP.children[i]) {
					zTree.expandNode(treeNodeP.children[i], false);
				}
			}
			while (pNode) {
				if (pNode === treeNode) {
					break;
				}
				pNode = pNode.getParentNode();
			}
			if (!pNode) {
				singlePath(treeId,treeNode);
			}

		}
		
		function updateUseStatus(event, treeId, treeNode) {
			getUseEquipment();
		}
		function onExpand(event, treeId, treeNode) {
			curExpandNode = treeNode;
		}
		
		function singlePath(treeId,newNode) {
			if (newNode === curExpandNode) return;
			if (curExpandNode && curExpandNode.open==true) {
				var zTree = $.fn.zTree.getZTreeObj(treeId);
				if (newNode.parentTId === curExpandNode.parentTId) {
					zTree.expandNode(curExpandNode, false);
				} else {
					var newParents = [];
					while (newNode) {
						newNode = newNode.getParentNode();
						if (newNode === curExpandNode) {
							newParents = null;
							break;
						} else if (newNode) {
							newParents.push(newNode);
						}
					}
					if (newParents!=null) {
						var oldNode = curExpandNode;
						var oldParents = [];
						while (oldNode) {
							oldNode = oldNode.getParentNode();
							if (oldNode) {
								oldParents.push(oldNode);
							}
						}
						if (newParents.length>0) {
							zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
						} else {
							zTree.expandNode(oldParents[oldParents.length-1], false);
						}
					}
				}
			}
			curExpandNode = newNode;
		}
		
		
		function updateMcuModel(mcuIP){
			var zTree = $.fn.zTree.getZTreeObj("rightTree");
			var nodes = zTree.getNodesByParam("level", 0, null);//是否有所属MCU
			
			if(nodes==null ||nodes.length==0||nodes.length>1){
				alert("选择主MCU");
				return;
			}else{
				if(nodes[0].nodeType!=nodeType_mcu){
					alert("根节点必须为MCU");
					return;
				}
			}
			alert("初始化模板");
			//$("#confProfileID").append("<zzst:option type='linkMeetingModelMcuIP' value='"+mcuIP+"' required='true'/>");  
		}
		
		
		//全部删除
		function removeAllConference(str){
			if(str=="all"){
				$("#selectVenueSpan").empty();
				$("#selectVenueSpan").append(0);
				var zTree = $.fn.zTree.getZTreeObj("rightTree");
				var nodes = zTree.getNodesByParam("level", 0, null);
				
				for (var i=0, len=nodes.length; i < len; i++) {
					zTree.removeNode(nodes[i],true);
				}
				clearMainRoom();
			}else if(str=="selected"){
				var zTree = $.fn.zTree.getZTreeObj("rightTree");
				var nodes = zTree.getSelectedNodes();
				var mainID = $("#mainEquipmentID").val();
				for (var i=0, len=nodes.length; i < len; i++) {
					if(nodes[i].id==mainID){//如果删除的是主会场，清空相关数据
						clearMainRoom();
					}
					zTree.removeNode(nodes[i],true);
				}
			}
		}
		
		function clearMainRoom(){
			$("#mainRoomName").empty();
			$("#mainRoomID").attr("value","");
			$("#mainEquipmentID").attr("value","");
		}
		//全部参加
		function selectAllConference(str){
			var zTree = $.fn.zTree.getZTreeObj("leftTree");
			if(str=="all"){
				if(zTree!=null){
					var nodes = zTree.getNodesByParam("level", 0, null);
					for(var i=0;i<nodes.length;i++){
						var tozTree = $.fn.zTree.getZTreeObj("rightTree");
						//根据id，查询左侧树所有节点及属性
						addAllMcuChildrenNodes(tozTree,nodes[i]);//首先添加MCU
						addAllTerChildrenNodes(tozTree,nodes[i]);//再添加终端
						
						selectVenueNumber("rightTree");//计算选择的个数
					}
				}
			}else if(str="selected"){
				if(zTree!=null){
					var nodes = zTree.getSelectedNodes();
					for(var i=0;i<nodes.length;i++){
						var tozTree = $.fn.zTree.getZTreeObj("rightTree");
						//根据id，查询左侧树所有节点及属性
						addAllMcuChildrenNodes(tozTree,nodes[i]);//首先添加MCU
						addAllTerChildrenNodes(tozTree,nodes[i]);//再添加终端
						
						selectVenueNumber("rightTree");//计算选择的个数
					}
				}
			}
		}
		
		//搜索
		function serachRoom(){
			var serachName = $("#searchEquipment").val();
			if(serachName==null||serachName.length==0) {
				return;
			}
			var serachRight = sercahTree("rightTree",serachName);
			var serachLeft = sercahTree("leftTree",serachName);
			if(!serachRight&&!serachLeft)
				alert("没有找到字符串：\""+serachName+"\"");
		}
		
		function sercahTree(treeID,serachName){
			var zTree = $.fn.zTree.getZTreeObj(treeID);
			if(zTree!=null){
				zTree.cancelSelectedNode();
				var nodes = zTree.getNodesByParamFuzzy("name", serachName, null);
				if(nodes!=null&&nodes.length>0){
					for(var i=0;i<nodes.length;i++){
						var node = nodes[i];
						var parentTId = node.parentTId;
						var parentNode = zTree.getNodeByTId(parentTId);
						zTree.selectNode(node,true);//
					}
					return true;
				}else{
					return false;
				}
			}else{
					return false;
			}
		}
		
		document.onkeydown=function(event){
        	var e = event || window.event || arguments.callee.caller.arguments[0];
        	if(e && e.keyCode==13){ // enter 键
        		serachRoom();
        	}
        };
        
        /**
        	更新使用的设备状态
        	更新终端设备状态 0正常1占用；mcu可用状态是 资源数控制
        **/
        function useEquipmentUStatus(lis){
			var zTree = $.fn.zTree.getZTreeObj("leftTree");
			//取消已经占用的设备
			var nodes = zTree.getNodesByParam("uStatus",e_uStatus_invalid);
			for(var i=0;i<nodes.length;i++){
				zTree.setting.view.fontCss["color"] = "black";
				nodes[i].uStatus = e_uStatus_valid;
				removeMeetingHoverDom(nodes[i]);
				zTree.updateNode(nodes[i]);
			}
			if(lis!=null&&lis.length>0){
				for(var i=0;i<lis.length;i++){
					var paramNodes = zTree.getNodesByParam("id", lis[i], null);
					for(var j=0;j<paramNodes.length;j++){//可能存在多个设备，主要是涉及组部分
						var node = paramNodes[j];
						zTree.setting.view.fontCss = {};
						if(node.nodeType==nodeType_mcu){
							zTree.setting.view.fontCss["color"] = "#9400D3";
						}else{
							zTree.setting.view.fontCss["color"] = "#FF0000";
						}
						node.uStatus = e_uStatus_invalid;
						addMeetingHoverDom(node);
						zTree.updateNode(node);
					}
				}
				zTree.setting.view.fontCss = {};
			}
		}
		
		//显示设备参加的会议按钮
		function addMeetingHoverDom(treeNode){
			var aObj = $("#" + treeNode.tId + "_a");
			if ($("#diyMeeting_"+treeNode.id).length>0) return;
			var editStr = "<span  onclick=viewMeetingList('"+treeNode.id+"') class='button iconMainRoom' id='diyMeeting_" +treeNode.id+ "' title='会议信息' ></span>";
			aObj.after(editStr);
		}
		
		//取消显示设备参加的会议按钮
		function removeMeetingHoverDom(treeNode){
			$("#diyMeeting_"+treeNode.id).unbind().remove();
		}
		
		//根据设备ID查询参加的会议列表
		function viewMeetingList(equipmentID){
			window.open("${sys_ctx}/detail/equipmentMeetingList.action?meetingDetailEquipmentVO.equipmentID="+equipmentID,"window",'Width=700px,Height=500px,scrollbars=yes');
//			window.open("/icmp/meeting/conferenceBook/adminBook/equipmentMeetingList.jsp");
		}
	</SCRIPT>
  </head>
  <body>
   <table width="100%" border="0" cellspacing="0" cellpadding="0" class="leftviewdataOff1">
        		<tr>
          			<td width="48%" class="" style="padding-bottom: 5px;">
          				<h5 class="fwb fl10" style="margin-top: 6px;margin-bottom: 10px;">请选择会场&nbsp;&nbsp;共<span style="font-weight:bold;text-align:center;color:red;"  id="allVenueSpan">${fn:length(equipmentList)}</span>个会场</h5>
          			</td>
          			<td></td>
          			<td width="48%" class="" style="padding-bottom: 5px;">
          				<h5 class="fwb fl10" style="margin-top: 6px;margin-bottom: 10px;">已选择<span style="color:#F00;" id="selectVenueSpan">${fn:length(joinEquipmentList)}</span>个会场&nbsp;&nbsp;主会场：
          					<label style="color:#F00;" id="mainRoomName"></label>
          	 				<input id="mainRoomID" type="hidden" name="meetingDetailVO.info3"/>
          	 				<input id="mainEquipmentID" type="hidden" name="meetingDetailVO.info4"/>
          	 				<input type="button" class="stdbtn mlr10" value="存为组" onclick="addEquipmnetGroup();" />
          	 				
          				</h5>
          			</td>
        		</tr>
        		<tr>
          			<td>
          				<div id="leftTree" class="ztree"></div>
          				<c:forEach items="${addressMap}" var="item" varStatus="state">
    	      				<script type="text/javascript">	   
	    	      				var addressID = "${item.value.addressID}";
	    	      				var addressParentID = "${item.value.parentID}";
	    	      				var addressName = "${item.value.name}";
								var addressJosn = {id:addressID, pId:addressParentID, name:addressName,nodeType:nodeType_address,nodeLink:addressParentID};
								leftTreeNodes.push(addressJosn);
	          				</script>
          				</c:forEach>
          				<c:forEach items="${roomMap}" var="item" varStatus="state">
    	      				<script type="text/javascript">	   
	    	      				var roomID = "${item.value.meetingRoomID}";
								var roomName = "${item.value.meetingRoomName}";
								var addressID2 = "${item.value.addressVO.addressID}";
								var roomJosn = {id:roomID, pId:addressID2, name:roomName,nodeType:nodeType_room,nodeLink:addressID2,iconOpen:"${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle/img/diy/1_open.png", iconClose:"${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle/img/diy/1_close.png"};
								leftTreeNodes.push(roomJosn);
	          				</script>
          				</c:forEach>
          				
          				<c:forEach items="${equipmentList}" var="equipmentVO" varStatus="state">
    	      				<script type="text/javascript">
	    	      				var equipID = "${equipmentVO.equipmentID}";
	    	      				
	    	      				var allSourse = "${equipmentVO.allResourceNumber}";
								var useSourse = "${equipmentVO.useResourceNumber}";
								 
								var equipName = "${equipmentVO.equipmentNO}";
								var roomID2 = "${equipmentVO.meetingRoomVO.meetingRoomID}";
								var ip = "${equipmentVO.ip}";
								var cascadeEquipmentID = "${equipmentVO.cascadeEquipmentID}";
								
								var ty = 2;
								if(${equipmentVO.equipmentType==1}){
									ty	=	nodeType_mcu;
									equipName += "("+ip+")";
									equipName += "("+allSourse+")";
									//equipName += "("+useSourse+"/"+allSourse+")";
								} else{
									ty	=	nodeType_ter;
									equipName += "("+ip+")";
								}
								
								var model = "${equipmentVO.equipmentModel}";
								var link = "${equipmentVO.meetingRoomVO.addressVO.addressID}-"+roomID2;
								var equipmentJosn = {id:equipID, pId:roomID2, roomID:roomID2,name:equipName ,nodeType:ty, nodeLink:link,ip:ip,cascadeID:cascadeEquipmentID,allSourse:allSourse,useSourse:useSourse,mcuModel:model,confProfileID:"",uStatus:0};
								
								leftTreeNodes.push(equipmentJosn);
	          				</script>
          				</c:forEach>
          				<c:forEach items="${groupList}" var="groupVO" varStatus="state"><!-- 会场组 -->
    	      				<script type="text/javascript">
    	      					var n ="${state.index}"
    	      					if(n==0){
	    	      					var roomJosn = {id:"groupRoot", pId:"-1", name:"会场组"};
									leftTreeNodes.push(roomJosn);
    	      					}
	    	      				var groupID = "${groupVO.groupname}";
								var groupName = "${groupVO.groupname}";
								var groupJosn = {id:groupID, pId:"groupRoot", name:groupName};
								leftTreeNodes.push(groupJosn);
	          				</script>
          				</c:forEach>
          				<c:forEach items="${groupEquipmentList}" var="equipmentVO" varStatus="state"><!-- 会场组内设备 -->
    	      				 <script type="text/javascript">
	    	      				var allSourse = "${equipmentVO.allResourceNumber}";
								var useSourse = "-";//"${equipmentVO.useResourceNumber}";
								
								var equipName = "${equipmentVO.equipmentNO}";
								var pid = "${equipmentVO.description}";
								var equipID = "${equipmentVO.equipmentID}";
	    	      				
								var ip = "${equipmentVO.ip}";
								var cascadeEquipmentID = "${equipmentVO.cascadeEquipmentID}";
								
								var ty = 2;
								if(${equipmentVO.equipmentType==1}){
									ty	=	nodeType_mcu;
									equipName += "("+ip+")";
									equipName += "("+allSourse+")";
									//equipName += "("+useSourse+"/"+allSourse+")";
								} else{
									ty	=	nodeType_ter;
									equipName += "("+ip+")";
								}
								
								var model = "${equipmentVO.equipmentModel}";
								var link = "-";
								
								var equipmentJosn = {id:equipID, pId:pid, name:equipName ,nodeType:ty, nodeLink:link,ip:ip,cascadeID:cascadeEquipmentID,allSourse:allSourse,useSourse:useSourse,mcuModel:model,confProfileID:"",uStatus:0};
								
								leftTreeNodes.push(equipmentJosn);
	          				</script>
          				</c:forEach> 
          				
	      				<script type="text/javascript">createLeftTree();</script>
          			</td>
          			<td style="vertical-align:middle; text-align:center; ">
          				<input id="searchEquipment" type="text" class="inputtran" style="width:100px" onkeydown="" onkeypress="" onchange=""/><h1>&nbsp;</h1>
						<input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="selectAllConference('all');" /><h1>&nbsp;</h1>
            			<input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="selectAllConference('selected');"/><h1>&nbsp;</h1>
            			<input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="removeAllConference('selected');"/><h1>&nbsp;</h1>
            			<input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="removeAllConference('all');" />
          			</td>
          			<td>
          				<div style="hight:100" id="rightTree" class="ztree"></div>
						
							<c:forEach items="${joinEquipmentList}" var="DetailEquipVO" varStatus="state">
	    	      				<script type="text/javascript">
		    	      				var equipID = "${DetailEquipVO.equipmentID}";
		    	      				
		    	      				var allSourse = "0";
									var useSourse = "0";
									 
									var equipName = "${DetailEquipVO.equipmentNo}";
									var Pid = "${DetailEquipVO.cascadeID}";
									var roomID2 = "${DetailEquipVO.roomID}";
									var ip = "${DetailEquipVO.equipmentIP}";
									var cascadeEquipmentID = "-";
									
									var ty = 2;
									if(${DetailEquipVO.equipmentType==1}){
										ty	=	nodeType_mcu;
										equipName += "("+ip+")";
									} else{
										ty	=	nodeType_ter;
										equipName += "("+ip+")";
									}
									
									var model = "-";
									var link = "-"
									var equipmentJosn = {id:equipID, pId:Pid, roomID:roomID2,name:equipName ,nodeType:ty, nodeLink:link,ip:ip,cascadeID:cascadeEquipmentID,allSourse:allSourse,useSourse:useSourse,mcuModel:model,confProfileID:"",uStatus:0};
									
									if(${DetailEquipVO.mainEquipment==1}){
										addHoverDomMainVenue("rightTree",equipName,roomID2,equipID);
									}
									rightTreeNodes.push(equipmentJosn);
		          				</script>
	          				</c:forEach> 
							<script type="text/javascript">createRightTree();
						</script>
          			</td>
        		</tr>
       		</table>
  </body>
</html>
