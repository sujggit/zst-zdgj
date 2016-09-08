<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>


<html>
  <head>
    <title>设备类型维护</title>
      
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link href="${sys_ctx }/project/zhuanyuanban/css/global.css" rel="stylesheet" type="text/css" />
	<link href="${sys_ctx }/project/zhuanyuanban/css/listheaderfixed.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	 <script language="JavaScript">
		
		var setting = {
			view: {
				
				addHoverDom: addHoverDomDic,
				removeHoverDom: removeHoverDomDic,
				selectedMulti: false
			},
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
			   
			    //beforeDrag: beforeDragDic,
				beforeRemove: beforeRemoveDic,
				beforeRename: beforeRenameDic,
				onRemove: onRemoveDic,
				onRename: onRenameDic
				//onDrag:onDragDic,
				//onDrop:onDropDic
			}
		};

		$(document).ready(function(){
			BaseDwrMethod.dicEquipmentList(function(str){
				if(str){
					var zNodes=eval(str);
					$.fn.zTree.init($("#dicEquipmentTree"),setting,zNodes);
				}
			});
		})

		var className = "dark";
		
		
		function beforeDragDic(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;

		};
		function beforeDropAddress(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		};
		
		function beforeRenameDic(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			if(newName.length >10){
				alert("长度不超过10个字符");
				return false;
			}
			return true;
		};
		function beforeRemoveDic(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			if(treeNode.pId==null){
				alert("根节点不能删除");
				//viewDIV("errorDiv");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("dicEquipmentTree");
			zTree.selectNode(treeNode);
			return confirm("确认删除  " + treeNode.name + " 吗？");
		};
		
		function onRenameDic(e, treeId, treeNode) {
			var id= treeNode.id;
			var name = treeNode.name;
			var level = treeNode.level;
			//alert(treeNode.id+"改名字为"+treeNode.name);
			BaseDwrMethod.checkDicEquipmentName(id,name,function(back){
				if(back){
					BaseDwrMethod.modifyDicEquipmentName(id,name,level,function(back){
						//alert(back);
					
					});
				}else{
					alert("此名称已被占用！");
				}
			});
			
			
		};
		
		function onRemoveDic(e, treeId, treeNode) {
		    var id=treeNode.id;
			//alert("移除了"+treeNode.name);
			BaseDwrMethod.removeDicEquipmentName(id,function(back){
			 //alert(back);
			});
			
		};
		var id1 ;
		function onDragDic(e, treeId, treeNodes){
		  id1 = treeNodes[0].id;
		  };
		function onDropDic(e, treeId, treeNodes, targetNode, moveType){
		   if(targetNode==null) {
		  alert("请选择一个节点");
		  return false;
		}
		   var newpId=targetNode.id;
		     
		     DwrMethod.dragAddressName(id1,newpId,function(back){
		   
		   });
		};
		
		var newCount = 1;
		
		function addHoverDomDic(treeId, treeNode) {
			
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				if(treeNode.pId!=null){
					var level = treeNode.level;
					if(level<3){
						var zTree = $.fn.zTree.getZTreeObj("dicEquipmentTree");
						var newName="new node" + (newCount++);
						var newPId = treeNode.id;
						//var newLeaf=treeNode.leaf;
					
						//alert(newPId+"的名字为::::::::::::"+newName);
						BaseDwrMethod.addDicEquipmentName(newPId,newName,function(back){
				   		//document.execCommand('Refresh') ;
				   		//alert(11);
			    			zTree.addNodes(treeNode, {id:back, pId:newPId, name:newName});//modify by chenshuo 2013-5-14 修复新增节点后不能立刻改名的问题
						});
					}else{
						alert("三级及以上节点暂不允许添加");
					}
				}else{
					alert("基础数据不允许添加");
				}
			});
		};
		
		
		function removeHoverDomDic(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};
		
		
		//打开显示层
		function viewDIV(divID){
			document.getElementById(divID).style.display = "block";
		}
		
		//隐藏显示层
		function displayDiv(divID){
			document.getElementById(divID).style.display = "block";
		}

		function reSet(){
			if(!window.confirm("是否重置设备配置？")) return;
			window.location.href="${sys_ctx }/dictionary/reSet.action";
		}
		//window.onload=initjPa;
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
	</style>
  </head>
  <body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
    <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">设备配置管理</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="reSet();">重置初始数据</a></h5>
      </div>
     <div class="dtree">
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
              <tfoot>
              </tfoot>
              <tbody>
                <tr class="gradeA">
                  <td align="">
                      <ul id="dicEquipmentTree" class="ztree"></ul>	
	
	   			</td>
    			</tr>
    		</tbody>
   		 </table>
   	</div>
  </div>
        
      <!--contenttitle-->
   
	</body>
  
</html>
  
