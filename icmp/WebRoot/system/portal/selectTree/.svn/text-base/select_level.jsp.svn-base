<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="/common/common.jsp"%>
	<title>分级信息选择</title>
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.exhide-3.5.min.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>	
 	<style>
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
    <script language="JavaScript">
    	//获得的原始参数对象
    	var parentParam = window.dialogArguments.u_ParametersArray;
    	//看是否设置了为单选
        var selectType = window.dialogArguments.u_ParametersArray.selectType;

        var setting = {
   			view: {
   				selectedMulti: false,
  				showTitle: true
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
   	        	onDblClick: zTreeOnDblClick
   			}
   		};
		
        function zTreeOnDblClick(event, treeId, treeNode) {
        	if(treeNode){
            	addNewOptions();
            }
        };
        
        function addNewOptions(){//添加options
        	var treeObj = $.fn.zTree.getZTreeObj("treeObject");
            var treeNodes = treeObj.getSelectedNodes();
        	var selectObj = document.getElementById("selectedObjList");
			if(treeNodes.length){
				if(selectType=="radio"){
					if(selectObj.options.length>0){
						alert("分级信息不能多选！");
						return;
	               }
    	        }
				selectObj.options.add(new Option(treeNodes[0].name,treeNodes[0].id));
			}
        }
        
        function delSelOptions(){//删除options
        	var selectObj = document.getElementById("selectedObjList");
        	if(selectObj.selectedIndex>=0){
        		if(selectType=="radio"){
                	selectObj.options.remove(selectObj.selectedIndex);
    	        }
            }
	    }

        //关于搜索
        function EnterPress(e){ //传入 event 
     	   var e = e || window.event; 
     	   if(e.keyCode == 13){ 
     		  searchInfo();
     	   } 
        }
        function searchInfo(){
			var searchInfo = document.getElementById("searchInfo").value;//搜索条件
			var treeObj = $.fn.zTree.getZTreeObj("treeObject");
			var allNodes = treeObj.transformToArray(zNodes);//allNodes Array
			if( searchInfo == "" ){
				for( var i=0; i<allNodes.length; i++ ){
					treeObj.showNode(treeObj.getNodeByParam("id",allNodes[i].id,null));
				}
				treeObj.expandAll(false);
				treeObj.checkAllNodes(false);
				return;
			}
			//先隐藏所有节点
			for( var i=0; i<allNodes.length; i++ ){
				treeObj.hideNode(treeObj.getNodeByParam("id",allNodes[i].id,null));
			}
			var isIn = false;
			for( var i=0; i<allNodes.length; i++ ){
				var node =allNodes[i];
				var flag = true;
				var strIndex = node.name.indexOf(searchInfo);
				if( strIndex != -1){//匹配到节点
					isIn = true;
					var showNode = treeObj.getNodeByParam("id",node.id,null);//得到当前一个节点对象
					if (showNode.isParent == true){//如果不是子节点
						//所有子节点显示
						var childNodes = treeObj.transformToArray(showNode);//获取该节点全部节点
						treeObj.showNodes(childNodes);//显示其子节点
						treeObj.expandNode(showNode,true,true,false,false);//展开该节点(其子节点执行同样操作)
					}
					while(flag){
						treeObj.showNode(showNode);//显示该节点
						
						treeObj.expandNode(showNode,true,false,false,false);//展开该节点(其子节点执行同样操作)
						if( showNode.isParent == false){//如果是子节点
							//treeObj.selectNode(showNode,true);//选中
						 	//treeObj.checkNode(showNode,true,false,false);//勾中
						}
						if( showNode.getParentNode() != null){//如果不是根节点
							showNode = showNode.getParentNode();//获取父节点
						}else{
							flag = false;//是根节点则结束循环
						}
					 	
					}
				}
			}
			if( !isIn ){
				alert("没有相关人员");
			}
	 	}       
        //清空搜索栏还原树结构
		function reStore(){
			var searchInfo = document.getElementById("searchInfo").value;//搜索条件
        	var treeObj = $.fn.zTree.getZTreeObj("treeObject");
			var allNodes = treeObj.transformToArray(zNodes);//allNodes Array
			if( searchInfo == "" ){
				for( var i=0; i<allNodes.length; i++ ){
					treeObj.showNode(treeObj.getNodeByParam("id",allNodes[i].id,null));
				}
				treeObj.expandAll(false);
				treeObj.checkAllNodes(false);
				return;
			}
		}
        
		$(document).ready(function(){
			getTree();
			if(window.dialogArguments.u_ParametersArray.selectType == "radio"){
				document.getElementById("s1").style.display="none";
				//$("#searchInfo1").css(display:"none");//禁止多选时去掉右搜索框
			};
		});

		var zNodes;
		function getTree(){
			document.getElementById("selectedObjList").options.length = 0;
			BaseDwrMethod.getLevelListByPower(function back(para){
				if(para){
					zNodes = eval(para);
					$.fn.zTree.init($("#treeObject"), setting, zNodes);
				}
			})
		}

		 function confirmRet(){//确定并返回
             var selectObj = document.getElementById("selectedObjList");
             var selectedValue = "";
             var selectedID    = "";
             var length = selectObj.options.length;

             var returnInfo = "[";
             if(length>0){
	             for(var k=0;k<length;k++){
	                 returnInfo += "{id:'"+selectObj.options[k].value+"',name:'"+selectObj.options[k].text+"'}";
	                 if(k<(length-1)){
	                	 returnInfo += ",";
	                 }
	             }
             }
             returnInfo += "]";
             try{
                 eval("window.dialogArguments."+window.dialogArguments.u_ParametersArray.methodName+"(returnInfo)");
             }catch(err){
                 alert(err.message);
				 window.close();
			 }
             window.close();
		}
	</script>
</head>
<body style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
   <div class="min-widthdiv">
	<div id="basicform" class="contentwrapper">
	  <div class="contenttitle2">
		<h5 class="fwb fl10">分级信息选择</h5>
  	  </div>
      	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #ccc">
        	<tr>
          		<td height="55">搜索 : <input id="searchInfo" class="glass" onkeypress="EnterPress(event)" onkeyup="reStore();" title="按回车搜索"/><img src="/icmp/images/icons/glass.png" onclick="searchInfo();" style="cursor:pointer;" /></td>
          		<td style="padding-left:100px" id="s1">搜索 : <input id="searchInfo1" class="glass" onkeyup="serachRoom1()"/><img src="/icmp/images/icons/glass.png" onclick="serachRoom1();" style="cursor:pointer;" /></td>
        	</tr>
        	<tr>
				<td>
					<div style="border:#ddd 1px solid; width:195px; height:250px; margin:0 auto; overflow:auto; background:none">
					  <ul id="treeObject" class="ztree"></ul>
                	</div>
				</td>
          		<td style="vertical-align:middle">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px">
                       <tr>
		                   <td width="100"> 
		                      <input type="button" class="stdbtn mlr10" value="添加&gt;&gt;" onclick="addNewOptions()" id="button"/>
		                      <br /><br />
		                      <input type="button" class="stdbtn mlr10" value="&lt;&lt;删除" onclick="delSelOptions()" id="button2"  />
		                   </td>
		                   <td>
	                           <select name="select" style="background:#fff;border:1px solid #ddd;padding:0;margin:0;width:195px;height:250px" id="selectedObjList" ondblclick="delSelOptions()" multiple="multiple" size="17" class="selected" >
	                             
	                           </select>
		                    </td>
		                </tr>
          			</table>
          		</td>
        	</tr>
        	<tr>
           <td colspan="3" style="padding-left:10px; padding-top:15px; padding-bottom:20px;">
           </td>
          </tr>
        	<tr >
          		<td colspan="3" height="10"></td>
        	</tr>
      	</table>
      	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="submit" class="submit1 radius2" value="确 定" onclick="confirmRet()"/>
                  <input type="button" class="reset1 radius2" value="取 消" onclick="window.close()"/>
                </td>
              </tr>
            </tbody>
		</table>
	</div>
  </div>
</body>
</html>
