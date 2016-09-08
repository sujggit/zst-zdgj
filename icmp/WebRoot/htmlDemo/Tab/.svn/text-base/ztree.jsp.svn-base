<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>树状图</title>
	<link rel="stylesheet" href="tree.css" type="text/css" />
	<!--树状图-->
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-zTree-v3.5.12/jquery.ztree.all-3.5.min.js"></script>
</head>
<body>
	<div class="pageheader notab">
		<h3 class="pagetitle">当前位置：视频会议 ⇒ 树状图</h3>
	</div>
	<div id="basicform" class="contentwrapper">
		<div class="contenttitle2">
			<h5 class="fwb fl10">树状图</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">       
			<tr>
				<td class="tableaddtitle"><span>*</span>所属功能</td>
				<td class="tableadd_data" align="left" valign="top" >
					<ul id="treeDemo" class="ztree"></ul>  
				</td>
				<td class="tableaddtitle"><span>*</span>描述</td>
				<td class="tableadd_data"><textarea class="most"></textarea></td>
			</tr>
		</table>
	</div>
	<script>
		var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
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
				onRename: onRename
			}
		};
 
		var zNodes =[
			{ id:0, pId:0, name:"根", open:true},	 
			{ id:1, pId:0, name:"父节点 1", open:true},
			{ id:11, pId:1, name:"叶子节点 1-1"},
			{ id:12, pId:1, name:"叶子节点 1-2"},
			{ id:13, pId:1, name:"叶子节点 1-3"},
			{ id:2, pId:0, name:"父节点 2", open:true},
			{ id:21, pId:2, name:"叶子节点 2-1"},
			{ id:22, pId:2, name:"叶子节点 2-2"},
			{ id:23, pId:2, name:"叶子节点 2-3"},
			{ id:3, pId:0, name:"父节点 3", open:true},
			{ id:31, pId:3, name:"叶子节点 3-1"},
			{ id:32, pId:3, name:"叶子节点 3-2"},
			{ id:33, pId:3, name:"叶子节点 3-3"}
		];
		var className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			//showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			//showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName, isCancel) {
			className = (className === "dark" ? "":"dark");
			//showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		function onRename(e, treeId, treeNode, isCancel) {
			//showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
		}
		function showRemoveBtn(treeId, treeNode) {
			return !treeNode.isFirstNode;
		}
		function showRenameBtn(treeId, treeNode) {
			return !treeNode.isLastNode;
		}
		/**
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}
 		*/
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			$("#selectAll").bind("click", selectAll);
		});


		function loadReady() {
			var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
			htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
			maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
			h = demoIframe.height() >= maxH ? minH:maxH ;
			if (h < 530) h = 530;
			demoIframe.height(h);
		}
	</script>
</body>
</html>