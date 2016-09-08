<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>分级管理</title>
<link rel="stylesheet" type="text/css" href="../js/DataTables-1.9.4/demo_table_jui.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../js/DataTables-1.9.4/jquery.dataTables.js" language="javascript"></script>
<script type="text/javascript" src="../js/windowInit.js" ></script>
	<script type="text/javascript" src="../js/jquery-zTree-v3.5.12/jquery.ztree.all-3.5.min.js"></script>
	<link rel="stylesheet" href="../Tab/tree.css" type="text/css" />
</head>
<body>
	<div class="pageheader notab">
		<h3 class="pagetitle">当前位置：产品发布 ⇒ 分级管理</h3>
	</div>
	<div id="basicform" class="contentwrapper">
		<div class="contenttitle2">
			<h5 class="fwb fl10">分级管理</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td class="tableaddtitle" style="min-width:260px" align="left" valign="top"><ul id="treeDemo" class="ztree"></ul></td>
				<td class="tableadd_data" style="margin:0;padding:0">
					<div id="m" style="margin-top:0">
						<ul>
				            <li id="m1" onmousedown="menu(1)" style="background:#fff">人员分级配置</li> 
				            <li id="m2" onmousedown="menu(2)">会议室分级配置</li> 
				        </ul>
					</div>
					<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
						<tr>
							<td class="tableaddtitle">分级名称</td>
							<td class="tableadd_data"><input type="text" class="inputtran" /></td>
							<td class="tableaddtitle">用户名称</td>
							<td class="tableadd_data"><input type="text" class="inputtran" /></td>
							<td class="tableaddtitle" style="width:60px;"><input type="reset" class="stdbtn mlr10" value="查 询" /></td>
						</tr>
					</table>
					<div id="k1" class="k" style="display:block">
						<table cellpadding="0" cellspacing="0" border="0" class="display dataTable" style="overflow-y:auto">
							<thead>
				                <tr>
				                    <th width="50" class="head1">序号</th>
				                    <th width="%" class="">分级名称</th>
				                    <th width="%" class="">超级用户名称</th>
				                    <th width="%" class="">普通用户民称</th>
				                    <th width="150" class="">操作</th>
				                </tr>
							</thead>
							<tbody>
								<tr class="gradeA">
				                    <td class="alc">1</td>
				                    <td>真视通北京总公司</td>
				                    <td>duting</td>
				                    <td></td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
				                <tr class="gradeC">
				                    <td class="alc">2</td>
				                    <td>武汉分公司</td>
				                    <td></td>
				                    <td></td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
				                <tr class="gradeA">
				                    <td class="alc">3</td>
				                    <td>广州分公司</td>
				                    <td>JOHN</td>
				                    <td>段磊</td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
							</tbody>
						</table>
					</div>
					<div id="k2" class="k">						
						<table cellpadding="0" cellspacing="0" border="0" class="display dataTable" style="overflow-y:auto">
							<thead>
				                <tr>
				                    <th width="50px" class="head1">序号</th>
				                    <th width="%">分级名称</th>
				                    <th width="%">超级用户名称</th>
				                    <th width="%">普通用户民称</th>
				                    <th width="150px">操作</th>
				                </tr>
							</thead>
							<tbody>
								<tr class="gradeA">
				                    <td class="alc">1</td>
				                    <td>真视通北京总公司</td>
				                    <td>duting</td>
				                    <td></td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
				                <tr class="gradeC">
				                    <td class="alc">2</td>
				                    <td>武汉分公司</td>
				                    <td></td>
				                    <td></td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
				                <tr class="gradeA">
				                    <td class="alc">3</td>
				                    <td>广州分公司</td>
				                    <td>JOHN</td>
				                    <td>段磊</td>
				                    <td><a href="#">查看</a> | <a href="#">编辑</a> | <a href="#">删除</a></td>
				                </tr>
							</tbody>
						</table>
				    </div>
					<script type="text/javascript" charset="utf-8">
						$(document).ready(function() {
							var oTable = $('.dataTable').dataTable({
								//"iDisplayLength": 20,//每页默认显示数量
								"aLengthMenu": [[5,10, 20, 50, -1], [5,10, 20, 50, "All"]],//下拉框
								"bJQueryUI": true,
								"aaSorting": [[0,'desc']],
								"sPaginationType": "full_numbers"//分页样式 
							});
						} );
						//--选项卡切换
					   function menu(m){
					     for(var x=1;x<=2;x++){
					       document.getElementById("k"+x).style.display="none";
					       document.getElementById("m"+x).style.backgroundColor="";
					       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
					      }
					       document.getElementById("k"+m).style.display="block";
					       document.getElementById("m"+m).style.backgroundColor="#fff";
					       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
					   }
					</script>
				</td>
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