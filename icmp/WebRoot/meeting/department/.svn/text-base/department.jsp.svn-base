<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.department.DepartmentServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.department.DepartmentVO" %>



<html>
  <head>
  <title>拥有的部门</title>
     <%@include file="/common/common_header.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">	
		<!--
		var setting = {
			view: {
				addHoverDom: addHoverDomDepartment,
				removeHoverDom: removeHoverDomDepartment,
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
				beforeDrag: beforeDragDepartment,
				beforeDrop: beforeDropDepartment,
				beforeRemove: beforeRemoveDepartment,
				beforeRename: beforeRenameDepartment,
				onRemove: onRemoveDepartment,
				onRename: onRenameDepartment,
				onDrag:   onDragDepartment,
				onDrop:   onDropDepartment
			}
		};

		<%	 		
			 ArrayList list =  new DepartmentServiceImpl().getAllFuncList(null,null);
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
				      for(int i=0;i<list.size();i++){
				    	  DepartmentVO departmentVO = (DepartmentVO)list.get(i);
				    	    dataObj.append("{id:'"+departmentVO.getId()+"',pId:'"+departmentVO.getParentId()+"',leaf:'"+departmentVO.getLeaf()+"',name:\""+departmentVO.getTitle()+"\"");
			               if(i<3)
				             dataObj.append(",open:true");
				             dataObj.append("}");
		                	
			                 if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                 }
				       }
				      dataObj.append("];");
				      out.print(dataObj);
		}     
		%>

		 
		var className = "dark",targetNode;
		function beforeDragDepartment(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;

		};
		function beforeDropDepartment(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		};
		
		
		function beforeRenameDepartment(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			return true;
		}
		function beforeRemoveDepartment(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			if(treeNode.pId==null){
				alert("根节点不能删除");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("departmentTree");
			zTree.selectNode(treeNode);
			return confirm("确认删除  " + treeNode.name + " 吗？");
		}
		
		function onRenameDepartment(e, treeId, treeNode) {
			var id= treeNode.id;
			var title = treeNode.name;
			DwrMethod.modifyDepartmentName(id,title,function(back){
			
			});
			
		}
		
		
		//删除节点
		function onRemoveDepartment(e, treeId, treeNode) {
		    var id=treeNode.id;
			//alert("移除了"+treeNode.name);
			
			DwrMethod.removeDepartmentName(id,function(back){
			 //alert(back);
		     //if(back=='no'){
		     //return false;}
		     //if(back=='yes'){
		    // return true;
		    //}
		
			});
			
		}
		
		var id1 ;
		function onDragDepartment(e, treeId, treeNodes){
		  
		  id1 = treeNodes[0].id;
	
		};
		function onDropDepartment(e, treeId, treeNodes, targetNode, moveType){
		
		if(targetNode==null) {
		  alert("请选择一个节点");
		  return false;
		}
		var newpId=targetNode.id;
		
		DwrMethod.dragDepartmentName(id1,newpId,function(back){
		     //document.execCommand('Refresh') ;
		   });
		   
		};
		var newCount = 1;
		
		function showCode(str) {
			
		}
		
		function addHoverDomDepartment(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("departmentTree");
				var newName="new node" + (newCount++);
				var newPId = treeNode.id;
				var newLeaf=treeNode.leaf;
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:newPId, name:newName,leaf:newLeaf});
				
				//alert(newPId+"的名字为::::::::::::"+newName);
			    DwrMethod.addDepartmentName(newPId,newName,newLeaf,function(back){
					 //document.execCommand('Refresh') ;
				//alert(back);
				});
				//
				
				
			});
			
			
		}
		
		
		function removeHoverDomDepartment(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		}
		
		
		function initjPa(){
			$.fn.zTree.init($("#departmentTree"), setting, zNodes);
		};
		
		
		
		
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
	</style>
  </head>
  
  <body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' onload="initjPa();">
		<div id="container">
			<div class="content">
				<div class="contenttitle fontstyle ">
					<div class="fl">
						<img src="${sys_page_list_table }" width="20" height="25" />
					</div>
					<div class="fl fontb">
						&nbsp;部门管理
					</div>
				</div>
				<div class="tablesdiv">
					 <ul id="departmentTree" class="ztree"></ul>				 				   
				</div>
			</div>
		</div>
	</body>
</html>
  
