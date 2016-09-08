<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html>
  <head>
    <title>分级管理</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
	<script language="JavaScript">
		var setting = {
			view: {
				addHoverDom: addHoverDomLevel,
				removeHoverDom: removeHoverDomLevel,
				selectedMulti: false
			},
			check: {
				enable: false
			},
			edit: {
				enable: true,
				showRemoveBtn: showRemoveBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag:beforeDragLevel,
				beforeRemove: beforeRemoveLevel,
				beforeRename: beforeRenameLevel,
				onRemove: onRemoveLevel,
				//onDrag: onDragLevel,
				//onDrop: onDropLevel,
				onClick: onClick,
				onRename: onRenameLevel			
			}
		};

		var isOperate = false;
		$(document).ready(function(){
			BaseDwrMethod.getLevelList(function(str){
				if(str){
					var zNodes=eval(str);
					$.fn.zTree.init($("#levelTree"),setting,zNodes);
				}
			});
			window.onbeforeunload = function(){
				if(isOperate){
					alert("温馨提示：分级管理所做的修改需要重新登录才能生效！");
				}
			}
		})
		
		//传入初始值levelId==levelPath，传出levelPath;
		var levelPathTemp;
		function getLevelPath(levelId, levelPath){
			var treeObj = $.fn.zTree.getZTreeObj("levelTree");
			levelPathTemp = "";
			var nodes = treeObj.getNodesByParam("id",levelId,null);
			if(nodes[0].level==0){//只有根节点
				levelPathTemp = ","+levelPath+",";
				return levelPath;
			}else{
				levelPath =  (nodes[0].pId+",").concat(levelPath);//拼接字符串
				getLevelPath(nodes[0].pId,levelPath);//递归函数
			}
		}

		function showRemoveBtn(treeId, treeNode){
			return !(treeNode.level==0);
		}
		
		var className = "dark";
		function beforeDragLevel(treeId, treeNodes) {
			return false;//不允许拖拽
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			//return true;
		};
		
		function beforeDropFunc(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		};

		var levelIdTemp ;
		var levelNameTemp;
		function onDragLevel(e, treeId, treeNodes){
			levelIdTemp = treeNodes[0].id;
			levelNameTemp = treeNodes[0].name;
		};
		function onDropLevel(e, treeId, treeNodes, targetNode, moveType){
			if(targetNode==null) {
			  alert("请选择一个节点");
			  return false;
			}
			var newpId=targetNode.id;
			var pLevelName = targetNode.name;
			//alert(newpId);
			BaseDwrMethod.dragLevel(levelIdTemp,newpId,levelNameTemp,pLevelName,function(back){
				isOperate = true;
			   //document.execCommand('Refresh') ;
		   });
		};
		
		function beforeRenameLevel(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空");
				return false;
			}
			return true;
		};
		
		function beforeRemoveLevel(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			if(treeNode.pId==null){
				alert("跟节点不能删除");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("levelTree");
			zTree.selectNode(treeNode);
			return confirm("确认删除  " + treeNode.name + " 吗？");
		};
		
		function onRenameLevel(e, treeId, treeNode) {
			var id= treeNode.id;
			var name = treeNode.name;
			BaseDwrMethod.modifyLevel(id,name,function(back){
				isOperate = true;
			});
		};
		
		function onRemoveLevel(e, treeId, treeNode) {
		    var id=treeNode.id;
		    var levelName=treeNode.name;
		    BaseDwrMethod.removeLevel(id,levelName,function(back){
		    	isOperate = true;
			});
		};
		
		var newCount = 1;
		function addHoverDomLevel(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("levelTree");
				var newName="new node" + (newCount++);
				var newPId = treeNode.id;
				var pName = treeNode.name;
				//var newNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:newPId, name:newName});
				getLevelPath(newPId,newPId);
				//alert(levelPathTemp);
				BaseDwrMethod.addLevel(newPId,newName,pName,levelPathTemp,function(result){
					if(result){
						isOperate = true;	
						var results = result.split(";");
						zTree.addNodes(treeNode, {id:results[0], pId:newPId, name:newName, levelPath:results[1]});
					}
				});
			});
		};

		function removeHoverDomLevel(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};
		
		function onClickLevel(e, treeId, treeNode){
			var zTree = $.fn.zTree.getZTreeObj("levelTree");
			nodes = zTree.getSelectedNodes();
			var levelID = nodes[0].id;
			var levelPath = nodes[0].levelPath;
			document.getElementById("levelDiv").style.display = "block";
			document.getElementById("levelID").value = levelID;
			if(levelPath){
				document.getElementById("levelPath").value=nodes[0].levelPath;
			}else{
				document.getElementById("levelPath").value="无";
			}
		}
		
		function closeDIV( divName ){
			document.getElementById(divName).style.display = "none";
		}
		
		function addURL( divName ){
		    var levelID = document.getElementById("levelID").value;
		    var path = document.getElementById("levelPath").value;
		    BaseDwrMethod.addLevelPath( levelID,path , function( back ){
		    	isOperate = true;
		    });
			closeDIV( divName );
		}

		function onClick(e, treeId, treeNode){
			if(treeNode==null||treeNode==""){
				var zTree = $.fn.zTree.getZTreeObj("levelTree");
				treeNode = zTree.getSelectedNodes();
				if(treeNode.length!=0){
					var radios=document.getElementsByName("radio");
					for(var j=0;j<radios.length;j++){
						if(radios[j].checked && radios[j].value=="z_t_user"){
							window.frames["iframe_I2"].location.href="${sys_ctx}/level/userLevelList.action?parentId="+treeNode[0].id;	
						}else if(radios[j].checked && radios[j].value=="z_t_meetingroom"){
							window.frames["iframe_I2"].location.href="${sys_ctx}/level/roomLevelList.action?parentId="+treeNode[0].id;
						}
					}
				}else{
					return;
				}
			}else{
			var radios=document.getElementsByName("radio");
			for(var j=0;j<radios.length;j++){
				if(radios[j].checked && radios[j].value=="z_t_user"){
					window.frames["iframe_I2"].location.href="${sys_ctx}/level/userLevelList.action?parentId="+treeNode.id;	
				}else if(radios[j].checked && radios[j].value=="z_t_meetingroom"){
					window.frames["iframe_I2"].location.href="${sys_ctx}/level/roomLevelList.action?parentId="+treeNode.id;
				}
			}
			}
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
       			<td class="tableaddtitle" style="width:270px;margin:0;padding:0;overflow:hidden;" align="left" valign="top">
       				<div class="tableadd_two">
						<ul>
				            <li><label for="userLevel"><input type="radio" name="radio" id="userLevel" value="z_t_user" checked="checked" onclick="onClick()"/>人员</label></li> 
				            <li><label for="meetingRoom"><input type="radio" name="radio" id="meetingRoom" value="z_t_meetingroom" onclick="onClick()"/>会议室</label></li> 
				        </ul>
					</div>
					<p><ul id="levelTree" class="ztree"></ul></p>
       			</td>
       			<td class="tableadd_data" style="margin:0;padding:0">
       				<iframe name="iframe_I2" id="iframe_I2" width="100%" border="0" frameborder="0" scrolling="yes" style="min-height:442px; display:block;">
                   	<div id="departments"></div>
                   </iframe>
       			</td>
       		</tr>
       	</table>
      </div>
  </body>
</html>