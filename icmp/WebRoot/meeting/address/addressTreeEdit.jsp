<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>


<html>
  <head>
    <title>网络拓扑</title>
      
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
				
				addHoverDom: addHoverDomAddress,
				removeHoverDom: removeHoverDomAddress,
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
			   
			    beforeDrag: beforeDragAddress,
				beforeRemove: beforeRemoveAddress,
				beforeRename: beforeRenameAddress,
				onRemove: onRemoveAddress,
				onRename: onRenameAddress,
				onDrag:onDragAddress,
				onDrop:onDropAddress
			}
		};

		$(document).ready(function(){
			BaseDwrMethod.addressTreeList(function(str){
				if(str){
					var zNodes=eval(str);
					$.fn.zTree.init($("#addressTree"),setting,zNodes);
				}
			});
		})

		var className = "dark";
		
		
		function beforeDragAddress(treeId, treeNodes) {
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
		
		function beforeRenameAddress(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			return true;
		};
		function beforeRemoveAddress(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			if(treeNode.pId==null){
				alert("根节点不能删除");
				//viewDIV("errorDiv");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("addressTree");
			zTree.selectNode(treeNode);
			return confirm("确认删除  " + treeNode.name + " 吗？");
		};
		
		function onRenameAddress(e, treeId, treeNode) {
			var id= treeNode.id;
			var name = treeNode.name;
			//alert(treeNode.id+"改名字为"+treeNode.name);
			DwrMethod.modifyAddressName(id,name,function(back){
				//alert(back);
			
			});
			
		};
		
		function onRemoveAddress(e, treeId, treeNode) {
		    var id=treeNode.id;
			//alert("移除了"+treeNode.name);
			DwrMethod.removeAddressName(id,function(back){
			 //alert(back);
			});
			
		};
		var id1 ;
		function onDragAddress(e, treeId, treeNodes){
		  id1 = treeNodes[0].id;
		  };
		function onDropAddress(e, treeId, treeNodes, targetNode, moveType){
		   if(targetNode==null) {
		  alert("请选择一个节点");
		  return false;
		}
		   var newpId=targetNode.id;
		     
		     DwrMethod.dragAddressName(id1,newpId,function(back){
		   
		   });
		};
		
		var newCount = 1;
		
		function addHoverDomAddress(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("addressTree");
				var newName="new node" + (newCount++);
				var newPId = treeNode.id;
				var newLeaf=treeNode.leaf;
				
				
				//alert(newPId+"的名字为::::::::::::"+newName);
			    DwrMethod.addAddressName(newPId,newName,newLeaf,function(back){
				   //document.execCommand('Refresh') ;
			    	zTree.addNodes(treeNode, {id:back, pId:newPId, name:newName,leaf:newLeaf});//modify by chenshuo 2013-5-14 修复新增节点后不能立刻改名的问题
				});
				//
				
				
			});
			
			
		};
		
		
		function removeHoverDomAddress(treeId, treeNode) {
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
		//window.onload=initjPa;
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
	</style>
  </head>
  <body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
    <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">网络拓扑</h5>
      </div>
     <div class="dtree">
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
              <tfoot>
              </tfoot>
              <tbody>
                <tr class="gradeA">
                  <td align="">
                      <ul id="addressTree" class="ztree"></ul>	
	
	   			</td>
    			</tr>
    		</tbody>
   		 </table>
   	</div>
  </div>
        
      <!--contenttitle-->
   
	</body>
  
</html>
  
