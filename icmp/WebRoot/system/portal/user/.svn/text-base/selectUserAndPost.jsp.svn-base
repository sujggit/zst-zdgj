<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="/common/common.jsp"%>
	<title>人员岗位选择</title>
    <link rel="stylesheet" href="css/select.css" type="text/css" />
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.5/css/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.5/js/jquery.ztree.exhide-3.5.min.js"></script>
	<script type="text/javascript" src="js/selectAdapter.js"></script>
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>	
		
 	<style>
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
    <script language="JavaScript">
    	//获得的原始参数对象
    	var parentParam = window.dialogArguments.d_ParametersArray;
    	//看是否设置了为单选
        var selectType = window.dialogArguments.d_ParametersArray.selectType;
      //看流程的类型，以此判断是否需要岗位
        var flowType = window.dialogArguments.d_ParametersArray.flowType;
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
        var settingPost = {
   			view: {
   				selectedMulti: false
   			},
   			data: {
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
            	if(!treeNode.isParent){
            		addNewOptions();
                }
            }
        };
        var treeObj;
        function getCurTreeObj(){//获取当前tree的Obj对象
        	var selType = $("input[name='checkTyle']:checked").val();
        	if(selType == "person"){
        		treeObj = $.fn.zTree.getZTreeObj("treeObject");
            }else if(selType == "post"){
            	treeObj = $.fn.zTree.getZTreeObj("treeObjectPost");
            }
        }
        function addNewOptions(){//添加options
        	getCurTreeObj();
            var treeNodes = treeObj.getSelectedNodes();
        	var selectObj = document.getElementById("selectedObjList");
			if(treeNodes.length){
				if(!treeNodes[0].isParent){//屏蔽选择人员外的单位
					var selType = $("input[name='checkTyle']:checked").val();
		        	if(selType=="post"){
		        		if(selectObj.options.length>0){
							alert("岗位不能多选！");
		               }else{
		              	 selectObj.options.add(new Option(treeNodes[0].name,treeNodes[0].id));
			           }
		            }else if(selType=="person"){
			            var chongfu = false;
			            var selectObj = document.getElementById("selectedObjList");
			        	if(selectObj.length>=0){
			        		var optionArry = selectObj.options;
							for(var sa=0;sa<optionArry.length;sa++){
								if(optionArry[sa].text==treeNodes[0].name){
									chongfu = true;
									alert("已经添加用户："+optionArry[sa].text);
									break;
								}
							}
			            }
			            
			            if(!chongfu){
			          		selectObj.options.add(new Option(treeNodes[0].name,treeNodes[0].id));
			            }
		            	
		            }
				}
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
     		   serachUser();
     	   } 
        }
        function serachUser(){
			var searchUser = document.getElementById("searchUser").value;//搜索条件
			//var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var selType = $("input[name='checkTyle']:checked").val();
        	if(selType == "person"){
        		zTree = $.fn.zTree.getZTreeObj("treeObject");
            }else if(selType == "post"){
            	zTree = $.fn.zTree.getZTreeObj("treeObjectPost");
            }
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			if( searchUser == "" ){
				for( var i=0; i<allNodes.length; i++ ){
					zTree.showNode(zTree.getNodeByParam("id",allNodes[i].id,null));
				}
				zTree.expandAll(false);
				zTree.checkAllNodes(false);
				return;
			}
			//先隐藏所有节点
			for( var i=0; i<allNodes.length; i++ ){
				zTree.hideNode(zTree.getNodeByParam("id",allNodes[i].id,null));
			}
			var isIn = false;
			for( var i=0; i<allNodes.length; i++ ){
				var node =allNodes[i];
				var flag = true;
				var strIndex = node.name.indexOf(searchUser);
				if( strIndex != -1){//匹配到节点
					isIn = true;
					var showNode = zTree.getNodeByParam("id",node.id,null);//得到当前一个节点对象
					if (showNode.isParent == true){//如果不是子节点
						//所有子节点显示
						var childNodes = zTree.transformToArray(showNode);//获取该节点全部节点
						zTree.showNodes(childNodes);//显示其子节点
						zTree.expandNode(showNode,true,true,false,false);//展开该节点(其子节点执行同样操作)
					}
					while(flag){
						zTree.showNode(showNode);//显示该节点
						
						zTree.expandNode(showNode,true,false,false,false);//展开该节点(其子节点执行同样操作)
						if( showNode.isParent == false){//如果是子节点
							//zTree.selectNode(showNode,true);//选中
						 	//zTree.checkNode(showNode,true,false,false);//勾中
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
			var searchUser = document.getElementById("searchUser").value;//搜索条件
			//var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var selType = $("input[name='checkTyle']:checked").val();
        	if(selType == "person"){
        		zTree = $.fn.zTree.getZTreeObj("treeObject");
            }else if(selType == "post"){
            	zTree = $.fn.zTree.getZTreeObj("treeObjectPost");
            }
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			if( searchUser == "" ){
				for( var i=0; i<allNodes.length; i++ ){
					zTree.showNode(zTree.getNodeByParam("id",allNodes[i].id,null));
				}
				zTree.expandAll(false);
				zTree.checkAllNodes(false);
				return;
			}
		}
        
		$(document).ready(function(){
			if(flowType==1||flowType==2||flowType==3||flowType==4||flowType==0){
				getPostTree();
			}else{
				$("#postSel").next().remove();
				$("#postSel").remove();
				$("#personSel").attr("checked","checked");
				getUserTree();
			}
			if(window.dialogArguments.d_ParametersArray.selectType == "radio"){
				document.getElementById("s1").style.display="none";
				//$("#searchUser1").css(display:"none");//禁止多选时去掉右搜索框
			};
		});

		var zNodes;
		function getUserTree(){
			document.getElementById("selectedObjList").options.length = 0;
			document.getElementById("treeObjectPost").style.display = "none";
			document.getElementById("treeObject").style.display = "block";
			DwrMethod.getUsers(function treeBack(para){
				if(para){
					zNodes = eval(para);
					$.fn.zTree.init($("#treeObject"), setting, zNodes);
				}
			})
		}
		function getPostTree(){
			document.getElementById("selectedObjList").options.length = 0;
			document.getElementById("treeObject").style.display = "none";
			document.getElementById("treeObjectPost").style.display = "block";
			DwrMethod.getPostList(function back(para1){
				if(para1){
					zNodes = eval(para1);
					$.fn.zTree.init($("#treeObjectPost"), settingPost, zNodes);
				}
			})
		}

		 function confirmRet(){//确定并返回
             var selectObj = document.getElementById("selectedObjList");
             var selectedValue = "";
             var selectedID    = "";
             var length = selectObj.options.length;

             var selType = $("input[name='checkTyle']:checked").val();
             var returnInfo = "";
             if(length>0){
            	 returnInfo += "[";
	             for(var k=0;k<length;k++){
	                 if(k<(length-1)){
	                	 selectedValue += selectObj.options[k].text + "<br>";
		                 selectedID    += selectObj.options[k].value + ",";
	                 }else{
	                	 selectedValue += selectObj.options[k].text;
		                 selectedID    += selectObj.options[k].value;
	                 }
	             }
	             returnInfo += "{userID:'"+selectedID+"',userName:'"+selectedValue+"',selType:'"+selType+"'}]";
             }else{
				window.close();
				return;
             }
             try{
                 eval("window.dialogArguments."+window.dialogArguments.d_ParametersArray.methodName+"(returnInfo)");
             }catch(err){
                 alert(err.message);
				 window.close();
			 }
             window.close();
		}
	</script>
</head>
<body style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
<div class="contentwrapper">
	<div class="contenttitle2">
		<h5 class="fwb fl10">
		  <input type="radio" id="postSel" value="post" name="checkTyle" onclick="getPostTree()" checked="checked"/><label>岗位选择</label>
		  <input type="radio" id="personSel" value="person" name="checkTyle" onclick="getUserTree()"/><label>人员选择</label>
		</h5>
	</div>
	<div style="border:1px solid #ccc;margin-bottom:1px">
      	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
          		<td height="55">搜索 : <input id="searchUser" class="glass" onkeypress="EnterPress(event)" onkeyup="reStore();" title="按回车搜索"/><img src="/icmp/images/icons/glass.png" onclick="serachUser();" style="cursor:pointer;" /></td>
          		<td style="padding-left:100px" id="s1">搜索 : <input id="searchUser1" class="glass" onkeyup="serachRoom1()"/><img src="/icmp/images/icons/glass.png" onclick="serachRoom1();" style="cursor:pointer;" /></td>
        	</tr>
        	<tr>
				<td>
					<div style="border:#ddd 1px solid; width:195px; height:250px; margin:0 auto; overflow:auto">
					  <ul id="treeObject" class="ztree"></ul>
					  <ul id="treeObjectPost" class="ztree"></ul>
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
      	</table>
      	</div>
      	<table width="99%" cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>
                  <input type="button" class="submit1 radius2" value="确 定" onclick="confirmRet()"/>
                  <input type="button" class="reset1 radius2" value="取 消" onclick="window.close()"/>
                </td>
              </tr>
            </tbody>
		</table>
	
</div>
</body>
</html>
