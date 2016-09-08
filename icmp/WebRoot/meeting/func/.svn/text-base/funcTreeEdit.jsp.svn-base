<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.zzst.service.meeting.auth.FuncServiceImpl" %>
<%@ page import="com.zzst.model.meeting.auth.FuncVO" %>
 <html>
  <head>
    <title>菜单管理</title>
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
		var setting = {
			view: {
				addHoverDom: addHoverDomFunc,
				removeHoverDom: removeHoverDomFunc,
				selectedMulti: false
			},
			check: {
				enable: false
			},
			edit: {
				enable: true,
				drag: {
			          prev: true,
			          next: true,
			          inner: true
		        }
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag:beforeDragFunc,
				beforeRemove: beforeRemoveFunc,
				beforeRename: beforeRenameFunc,
				onRemove: onRemoveFunc,
				onRename: onRenameFunc,
				onDrag:onDragFunc,
				onDrop:onDropFunc,
				onClick:onClickFunc				
			}
		};
		<%
	 		 Map map = (Map)request.getAttribute("roleFuncMap");
			 ArrayList list =  new FuncServiceImpl().getFuncList(null, null);
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
				      for(int i=0;i<list.size();i++){
				    	  FuncVO funcVO = (FuncVO)list.get(i);
			                 dataObj.append("{id:'"+funcVO.getFunc_id()+"',pId:'"+funcVO.getParent_id()+"',leaf:'"+funcVO.getLeaf()+"',name:\""+funcVO.getFunc_name()+"\"");
			                 if(i<3)
				                 dataObj.append(",open:true");
			                 
			                 //设置当前角色是否拥有该功能
			                 if(map!=null)
			                	 if(map.get(funcVO.getFunc_id()+"")!=null)
			                		 dataObj.append(",checked:true");
			                 
		                	 dataObj.append("}");
			                 if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                 }
				       }
				      dataObj.append("];");
				      out.print(dataObj);
			     }
		%>
		 
		var className = "dark";
		//var beforeDragPid;
		function beforeDragFunc(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			//beforeDragPid = treeNodes[0].getParentNode().id;
			//alert(treeNodes[0].getParentNode().id);
			return true;
			

		};
		function beforeDropFunc(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		};
		
		function beforeRenameFunc(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空");
				return false;
			}
			return true;
		};
		function beforeRemoveFunc(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			if(treeNode.pId==null){
				alert("根节点不能删除");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("funcTree");
			zTree.selectNode(treeNode);
			return confirm("确认删除  " + treeNode.name + " 吗？");
		};
		
		function onRenameFunc(e, treeId, treeNode) {
			
			var id= treeNode.id;
			
			var name = treeNode.name;

			
			DwrMethod.modifyFuncName(id,name,function(back){
				
			
			});
			
		};
		
		function onRemoveFunc(e, treeId, treeNode) {
		    var id=treeNode.id;
			DwrMethod.removeFuncName(id,function(back){
			
			});
		};
		var funcId ;
		function onDragFunc(e, treeId, treeNodes){
		  funcId = treeNodes[0].id;
		};
		function onDropFunc(e, treeId, treeNodes, targetNode, moveType){
		if(targetNode==null) {
		  alert("请选择一个节点");
		  return false;
		}
		var newpId=targetNode.id;
		
		//var treeNodePid = treeNodes[0].getParentNode().id;//被拖拽节点原来的pid
		//alert("目标pid："+targetNodePid+",选中pid:"+beforeDragPid);
		//alert(newpId);
		if(moveType=="inner"){
			DwrMethod.dragFuncName(funcId,newpId,function(back){
		   //document.execCommand('Refresh') ;
		   });
		}else {
			var targetNodePid = targetNode.getParentNode().id;//目标节点的pid
			DwrMethod.dragFuncName(funcId,targetNodePid,function(back){
				   //document.execCommand('Refresh') ;
			});
		}
		};
		var newCount = 1;
		function addHoverDomFunc(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var level = treeNode.level;
				//if(level<2){
					var zTree = $.fn.zTree.getZTreeObj("funcTree");
					var newName="new node" + (newCount++);
					var newPId = treeNode.id;
					var newLeaf = treeNode.leaf;
					//var newNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:newPId, name:newName});

					DwrMethod.addFuncName(newPId,newName,newLeaf,function(back){
						zTree.addNodes(treeNode, {id:back, pId:newPId, name:newName});
					});
				//}else {
				//	alert("操作按钮不允许添加");
				//}
			});
		};
		
		function removeHoverDomFunc(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};
		
		function initjPa(){
			$.fn.zTree.init($("#funcTree"), setting, zNodes);
		};
		
		function onClickFunc(e, treeId, treeNode){
			var zTree = $.fn.zTree.getZTreeObj("funcTree");
			nodes = zTree.getSelectedNodes();
			nodesNew = zTree.getNodes();
			var index = zTree.getNodeIndex(nodesNew[0]);
			var nodes1 = zTree.transformToArray(nodesNew);//ztree的所有节点的数据
//			alert(nodes1.length);
			var funcID = nodes[0].id;
			//var check = (treeNode && !treeNode.isParent);
			var check = treeNode;//父节点允许修改URL
			if (check){
					document.getElementById("funcDiv").style.display = "block";
					document.getElementById("funcID").value = funcID;
					DwrMethod.getFuncURLByID( funcID, function(back){
						var str = new Array();
						str = back.split("-");
						if(str[0]==null){
							document.getElementById("funcURL").value="无";
							if(str[1]=="null"){
								document.getElementById("funcDescription").value="";
							}else{
								document.getElementById("funcDescription").value=str[1];
							}
						}else{
							document.getElementById("funcURL").value=str[0];
							if(str[1]=="null"){
								document.getElementById("funcDescription").value="";
							}else{
								document.getElementById("funcDescription").value=str[1];
							}
						}
//							 if(back == null){
//							 	 document.getElementById("funcURL").value="无";
//							 }else{
//						     	document.getElementById("funcURL").value=back;
//						     }
					});
				}
		}
		
		function closeDIV( divName ){
			document.getElementById(divName).style.display = "none";
		}
		
		function addURL( divName ){
		    var funcID = document.getElementById("funcID").value;
		    var funcURL = document.getElementById("funcURL").value;
		    var funcDescription = document.getElementById("funcDescription").value;
		    DwrMethod.addFuncURL( funcID,funcURL ,funcDescription, function( back ){
		    	
		    });
			closeDIV( divName );
		}

		function subtree(){
				var zTree = $.fn.zTree.getZTreeObj("funcTree");
				nodesNew = zTree.getNodes();
				var nodes1 = zTree.transformToArray(nodesNew);//ztree的所有节点的数据
				for(var i=0;i<nodes1.length;i++){
					var funcID = nodes1[i].id;
					var orderNum;
					if(i<10){
						orderNum = "0000"+i;
					}else if(i>=10 && i<100){
						orderNum = "000"+i;
					}else if(i>=100 && i<1000){
						orderNum = "00"+i;
					}else if(i>=1000){
						orderNum = "0"+i;
					}
					DwrMethod.UpdateOrderNum(funcID,orderNum,function(back){});
					if(i==nodes1.length-1){
						alert("设置成功，需要重新登陆");
					}
				}
		}
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
	</style>
 </head>
 <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' onload="initjPa();">
 <!--  <div class="vernav2 iconmenu">
    <ul>
      <li class="current"><a href="menu_management.html" class="tables">菜单管理</a></li>
      <li><a href="datadictionary.html" class="gallery">部署配置</a></li>
    </ul>
    <a class="togglemenu"></a> <br />
    <br />
  </div>-->
     <div id="basicform" class="contentwrapper">
       <div class="contenttitle2">
         <h5 class="fwb fl10">菜单管理</h5>
       </div>
       <div class="">
         <div class="dtree">
           <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
             <tfoot>
             </tfoot>
             <tbody>
               <tr class="gradeA">
                 <td>
                 <div class="tablesdiv">
				 <ul id="funcTree" class="ztree"></ul>				 				   
			</div>
                 <br><br></td>
               </tr>
             </tbody>
           </table>
         </div>
       </div>
       <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			        <tfoot>
			        </tfoot>
					<tbody>
			          <tr>
			            <td>
			            	<input class="submit1 radius2" type="button" name="" id="subbtn" value="确 定" style="cursor:pointer" onclick="subtree()"/>
			              	<input class="reset1 radius2" type="button" name="" id="" value="返 回" style="cursor:pointer"  onclick="backHistory();"/>
			              </td>
			          </tr>
			        </tbody>
			    </table>
      </div>
  	 
     <div id="funcDiv" style="overflow:auto;display:none;LEFT: 350px;TOP: 80px;POSITION: absolute;width:490px" class="popdialog">
	  	<div class="topys" style="overflow: hidden;width:100%"></div>
	  	
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-left:1px solid #999;border-right:1px solid #999;margin-left:3px;padding:0 5px;width:331px;" >
		  <tr><td style="margin-bottom:5px">功能链接</td></tr>
		  <tr>
		    <td>
	          <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-bottom:5px">
	            <tr>	              
				  <td width="100%" class="al pl3">
					<input id="funcURL" type="text" style="width: 100%"/>
				  </td>
				  <input id="funcID" type="hidden" style="border:1px solid #ccc" />
	            </tr>
	            <tr>
	            	<td style="margin-bottom:2px">描述</td>
	            </tr>
	            <tr>
	            	<td>
	            	<textarea style="width:99%" name="funcDescription" id="funcDescription"></textarea>
	            	</td>
	            </tr>
	          </table>
	          <table cellpadding="0" cellspacing="1" class="buttoncontainer" width="100%" style="margin-bottom:5px;border:none">
	          	<tfoot>
	        	</tfoot>        
	        	<tbody>
	            <tr>
	              <td>
	              <input name="input3" value="确 定" type="button" class="submit1 radius2" onclick="addURL('funcDiv');"/>
	              <input name="input3" value="返 回" type="button" class="reset1 radius2" onclick="closeDIV('funcDiv');"/>
	              </td>
	            </tr>
	            </tbody>
	         	 </table>
		    </td>
		  </tr>
		</table>
		<div class="downys"></div>
  	 </div>
  </body>
</html>