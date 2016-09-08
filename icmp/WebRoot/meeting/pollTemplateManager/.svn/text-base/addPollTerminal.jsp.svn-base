<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>终端排序模板</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/plug-in/jquery-ztree-v3.5/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<link href="<%=request.getContextPath() %>/style/normal/css/style.default.css" id='style' rel='stylesheet' type='text/css' />
<script type='text/javascript' src='<%=request.getContextPath() %>/plug-in/jquery-ztree-v3.5/js/jquery.ztree.core-3.5.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/plug-in/jquery-ztree-v3.5/js/jquery.ztree.excheck-3.5.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/plug-in/jquery-ztree-v3.5/js/jquery.ztree.exedit-3.5.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/interface/McuDwrMethod.js'></script>
<script type="text/javascript" >
  <!--
	var zTree;
	var demoIframe;

	var setting = {
			edit: {
				drag: {
					autoExpandTrigger: true,
					prev: dropPrev,
					inner: false,
					next: dropNext
				},
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			view: {
				fontCss: getFontCss
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				beforeDragOpen: beforeDragOpen,
				onDrag: onDrag,
				onDrop: onDrop,
				onExpand: onExpand
			}
		};

	var zNodes =${nodes};
	var key;
	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		
		key = $("#key");
			key.bind("focus", focusKey)
			.bind("blur", blurKey)
			.bind("propertychange", searchNode)
			.bind("input", searchNode);
		//demoIframe = $("#testIframe");
		//demoIframe.bind("load", loadReady);
		//var zTree = $.fn.zTree.getZTreeObj("tree");
		//zTree.selectNode(zTree.getNodeByParam("id", 101));

	});

	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}
	
	function dropPrev(treeId, nodes, targetNode) {
			var pNode = targetNode.getParentNode();
			if (pNode && pNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					var curPNode = curDragNodes[i].getParentNode();
					if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}
		function dropInner(treeId, nodes, targetNode) {
			if (targetNode && targetNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					if (!targetNode && curDragNodes[i].dropRoot === false) {
						return false;
					} else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}
		function dropNext(treeId, nodes, targetNode) {
			var pNode = targetNode.getParentNode();
			if (pNode && pNode.dropInner === false) {
				return false;
			} else {
				for (var i=0,l=curDragNodes.length; i<l; i++) {
					var curPNode = curDragNodes[i].getParentNode();
					if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
						return false;
					}
				}
			}
			return true;
		}

		var log, className = "dark", curDragNodes, autoExpandNode;
		function beforeDrag(treeId, treeNodes) {
		
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					curDragNodes = null;
					return false;
				} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
					curDragNodes = null;
					return false;
				}
			}
			curDragNodes = treeNodes;
			return true;
		}
		function beforeDragOpen(treeId, treeNode) {
			autoExpandNode = treeNode;
			return true;
		}
		function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeDrop ]&nbsp;&nbsp;&nbsp;&nbsp; moveType:" + moveType);
			//showLog("target: " + (targetNode ? targetNode.name : "root") + "  -- is "+ (isCopy==null? "cancel" : isCopy ? "copy" : "move"));
			return true;
		}
		function onDrag(event, treeId, treeNodes) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" onDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
		}
		function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" onDrop ]&nbsp;&nbsp;&nbsp;&nbsp; moveType:" + moveType);
			//showLog("target: " + (targetNode ? targetNode.name : "root") + "  -- is "+ (isCopy==null? "cancel" : isCopy ? "copy" : "move"))
		}
		function onExpand(event, treeId, treeNode) {
			if (treeNode === autoExpandNode) {
				className = (className === "dark" ? "":"dark");
				//showLog("[ "+getTime()+" onExpand ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name);
			}
		}
		function setTrigger() {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
		}
		
		function addTemplate(){
		var zTree = $.fn.zTree.getZTreeObj("tree");
		var nodes = zTree.getNodes();
		var terArr = new Array();
		var locArr = new Array();
		var array = zTree.transformToArray(nodes);
		var temName = document.getElementById("templateName").value;
		if(temName==null||temName==""){
			alert("模板名称不能为空！");
			return;
		}
		for(var i=0;i<array.length;i++){
		if(array[i].isParent){
			locArr.push(array[i].id);
		}else{
		terArr.push(array[i].id);
		}
		}
		McuDwrMethod.addPollTerminal(temName,terArr,locArr,callback);
		
		}
		
		function callback(){
			window.opener.location.reload();
			window.close();
		}
		
		var lastValue = "", nodeList = [], fontCss = {};
			function searchNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			
				var value = $.trim(key.get(0).value);
				var keyType = "";
					keyType = "name";
				if (key.hasClass("empty")) {
					value = "";
				}
				if (lastValue === value) return;
				lastValue = value;
				if (value === "") return;
				
				updateNodes(false);
				
				nodeList = zTree.getNodesByParamFuzzy(keyType, value);
			
			updateNodes(true);

		}
		
		function focusKey(e) {
			if (key.hasClass("empty")) {
				key.removeClass("empty");
			}
		}
		function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
		}
		
		function updateNodes(highlight) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			for( var i=0, l=nodeList.length; i<l; i++) {
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
			}
		}
		function getFontCss(treeId, treeNode) {
			return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		}
		
  //-->
</script>
</head>
<body class="withvernav" >
<div id="contentwrapper" class="contentwrapper">
	<div id="contentwrapper66" class="contenttitle2">
        <h5 class="fwb fl10">
            <table cellpadding="0" cellspacing="0" border="0">
            	<tr>
                    <td><span>*</span>模板名称 <input type="text" id="templateName"/></td>
                    <td><label>搜索: <input type="text" id="key" value="" class="empty" aria-controls="DataTables_Table_0" ><img src="../images/icons/glass.png" /></label></td>
                </tr>
            </table>
        </h5>
	</div>
    <ul id="tree" class="ztree" style="overflow:auto;height:490px;border:1px solid #ccc"></ul>
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
            <tr>
                <td>
                    <input type="submit" class="submit1 radius2" value="确 定" onclick="addTemplate()"/>
                    
                </td>
            </tr>
        </tbody>
	</table>

</div>
</body>
</html>
