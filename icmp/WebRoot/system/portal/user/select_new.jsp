<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<%@page import="com.zzst.model.enums.UserEnum"%>
<%@page import="com.zzst.model.enums.DateBaseEnum"%>
<%@page import="com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="swh_ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ page import="com.zzst.model.meeting.department.DepartmentVO"%>
<%@ page import="com.zzst.model.meeting.user.UserVO"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>人员选择</title>
	<style>
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/icmp/style/normal/css/style.default.css" type="text/css" />
    <link href="css/select.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="../conference/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="../conference/js1/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="../conference/js1/jquery.ztree.core-3.3.js"></script>
	<script type="text/javascript" src="../conference/js1/jquery.ztree.excheck-3.3.js"></script>
	<script type="text/javascript" src="../conference/js1/jquery.ztree.exedit-3.3.js"></script>
	<script type="text/javascript" src="../conference/js1/jquery.ztree.exhide-3.3.js"></script>
	<script type="text/javascript" src="js/selectAdapter.js"></script>
	<script type='text/javascript' src='${swh_ctx}/dwr/engine.js'></script>
    <script type='text/javascript' src='${swh_ctx}/dwr/util.js'></script>
	<script type='text/javascript' src='${swh_ctx}/dwr/interface/UserAction.js'></script>
		
    <script language="JavaScript">

        //已选择的select
        var selectedSel = new Object();
        //已选择的对象数组
        var selectedObjArray = new Array();
        //已选数组的ID
        var selectedObjArrayID = new Array();
        //获得的原始参数对象
        var parentParam = window.dialogArguments.d_ParametersArray;
        
        var info = " 人员已选择 \n不能重复添加!";
	    window.onload = function(){
	       
	       selectedSel = document.getElementById("selectedObjList");
	       
	       //如果有已经选择的部门则显示
                  if(parentParam.selectedUser){
                       
                        var infoArray = parentParam.selectedUser.split(",");  

               //控制已选择的元素是否显示
 	             	var zTree = $.fn.zTree.getZTreeObj("treeObject");
           			for(var i=0;i<infoArray.length;i++){
	               	   var node = zTree.getNodeByParam("id",infoArray[i],null);//获取当前ID下的node
	               	   if(node && node.name){
	               		   $("#selectedObjList").append("<option value='"+infoArray[i]+"'>"+node.name+"</option>");
	                   	}
                  	}
                  }
                  
                   //控制已选择的元素是否显示
                  
	            if(parentParam.dispSelected&&parentParam.dispSelected=="true"){
	                  
	                   var selectedObjArrayIDLength = selectedObjArrayID.length;
	                   for(var i=selectedObjArrayIDLength;i>=0;i--){
	                            
		                             var itemValue = selectedObjArray["'"+selectedObjArrayID[i]+"'"];
		                             if(itemValue)
			                           select.addOption(selectedSel,eval("dataWH["+itemValue+"].userName;"),itemValue);
	                   }
	            }
                  
	    }
		var setting = {

			view: {
				selectedMulti: true
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				//beforeExpand: zTreeGetExpand,
				//beforeCollapse: zTreeBeforeExpand,  
	            //expand: zTreeBeforeExpand,  
	            //collapse: zTreeBeforeExpand,
	              onDblClick: zTreeOnDblClick
	           // beforeCheck:beforeCheck
	            //onCheck: onCheck
			}
		};
		var isExpand = false;
		function zTreeGetExpand(event,treeId, treeNode){
               
		     var zTree = $.fn.zTree.getZTreeObj("treeObject");
		     //alert(treeId.id);
		     UserAction.getUserListByDepartmentID(treeId.id,function(lst){
		           if(lst){
			           for(var index in lst){
			               zTree.addNodes(treeId,{id:lst[index].userID,pId:treeId.id,name:lst[index].dispName,isParent:false,
				                                      userNO:  lst[index].userNO,
				                                      mobilePhone:lst[index].mobilePhone,
				                                      telPhone:lst[index].telPhone,
				                                      departmentID:lst[index].departmentID,
				                                      departmentName:lst[index].departmentName,
				                                      positionID:lst[index].positionID,
				                                      positionName:lst[index].positionName
			                                     });
			           }
		           }
		     });
		     //var treeNode  = zTree.
		    // zTree.addNodes(treeId,{id:'12312312', pId:treeId.id, name:"newnode1111111111111",isParent:false},true); 
		}
		
        function zTreeOnDblClick(event, treeId, treeNode) {
                 // alert(treeNode ? treeNode.id + ", " + treeNode.name : "isRoot");
                  //var obj = eval("dataWH["+treeNode.id+"]");
                 // alert(treeNode.isParent):
                 if(treeNode){
	                  if(!treeNode.isParent){
	                     treeNode ? addNewOptions('one'):"";
	                  }
                  }
        };

        
        <%
			 /**浏览器缓存问题add by xiongshun 20130305 15:00
        	*/
        	response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store"); 
        	response.setDateHeader("Expires",0);
        	response.setHeader("Pragma","no-cache");
        	/////////
        StringBuffer dataWH = new StringBuffer();
        dataWH.append("var dataWH = new Array();");
        //构造树数据
        StringBuffer dataObj = new StringBuffer();
        
        List dList = new ArrayList();
		List uList = new ArrayList();
		DepartmentVO dpvo = new DepartmentVO();
		UserVO userVO = new UserVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		dList = ServiceFactory.getDepartmentService().getAllFuncList(new DepartmentVO(),null);
		/*///////////////  添加分级分权管理 author:xiongshun/////////////////////   */
		UserVO pUserVO = (UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if(pUserVO.getOpenlevel()&&!pUserVO.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'")){
			LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
			userVO.setOpenlevel(pUserVO.getOpenlevel());
			userVO.setLvoids(lcs.queryByTypeAndLid(pUserVO.getLvoids(),LevelEnum.LEVEL_USER));
		}
		////////////////////////////////////end//////////////////////////////////////
		uList = ServiceFactory.getUserService().getUserList(userVO, null);
		//sbUser.append("[");
		if(dList!=null && dList.size()>0){
			for(int i=0;i<dList.size();i++){
				dpvo = (DepartmentVO)dList.get(i);
				if(dpvo.getParentId().indexOf("-")>=0 || dpvo.getParentId()==null || "".equals(dpvo.getParentId())){//只展开树的一级节点，功能优化
		        	sbUser.append("{id:'"+dpvo.getId()+"_dept',pId:'"+dpvo.getParentId()+"_dept',name:\""+dpvo.getTitle()+"\",fullName:\""+dpvo.getTitle()+"\",open:true,isParent:true},");
		         }else{
		        	sbUser.append("{id:'"+dpvo.getId()+"_dept',pId:'"+dpvo.getParentId()+"_dept',name:\""+dpvo.getTitle()+"\",fullName:\""+dpvo.getTitle()+"\",isParent:true,open:false},");
		         }
			}
			if(uList!=null && uList.size()>0){
				for(int j=0;j<uList.size();j++){
					userVO = (UserVO)uList.get(j);
					sbUser.append("{id:'"+userVO.getUserID()+"',pId:'"+userVO.getDepartmentVO().getId()+"_dept',name:\""+userVO.getName()+"\",fullName:\""+userVO.getName()+"\",icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/user.png\",open:false,isParent:false},");
	                 String newObj = "{"+
			          "userID:'"+userVO.getUserID()+"',"+
			          "userName:'"+userVO.getName()+"',"+
			          "departmentID:'"+userVO.getDepartmentVO().getId()+"',"+
			          "telPhone:'"+userVO.getTel()+"',"+
			          "mobilePhone:'"+userVO.getMobile()+"',"+
			          "departmentName:'"+userVO.getDepartmentVO().getTitle()+"'"+
			         "};";               
	                 dataWH.append("dataWH['"+userVO.getUserID()+"'] = "+newObj+";");
				}
				
			}
			String str = sbUser.substring(0, sbUser.length()-1);
			str += "];";
			dataObj.append("var zNodes = [");
			dataObj.append(str);
			
			 out.println(dataWH);
		      out.println(dataObj);
		}
		%>
		

		var clearFlag = false;
		function onCheck(e, treeId, treeNode) {
		   //alert(treeId.id);
			count();
			if (clearFlag) {
				clearCheckedOldNodes();
			}
		}
		
		var xtree;
		function clearCheckedOldNodes() {
			var zTree = $.fn.zTree.getZTreeObj("treeObject");
			nodes = zTree.getChangeCheckedNodes();
			for (var i=0, l=nodes.length; i<l; i++) {
				nodes[i].checkedOld = nodes[i].checked;
			}
		}
		
		//计数
		function count() {
			var zTree = $.fn.zTree.getZTreeObj("treeObject"),
			checkCount = zTree.getCheckedNodes(true).length,
			nocheckCount = zTree.getCheckedNodes(false).length,
			changeCount = zTree.getChangeCheckedNodes().length;
			$("#checkCount").text(checkCount);
			$("#nocheckCount").text(nocheckCount);
			$("#changeCount").text(changeCount);

		}
		
	
		function createTree() {
			$.fn.zTree.init($("#treeObject"), setting, zNodes);
			$.fn.zTree.getZTreeObj("treeObject").setting.check.chkboxType = { "Y" : "s", "N" : "ps" };
			
			count();
			clearFlag = $("#last").attr("checked");
		}

		$(document).ready(function(){
			createTree();			
			$("#init").bind("change", createTree);
			$("#last").bind("change", createTree);
			if(window.dialogArguments.d_ParametersArray.selectType == "radio"){
				document.getElementById("s1").style.display="none";
				//$("#searchMeeingRoom").css(display:"none");//禁止多选时去掉右搜索框
			};
		});
		//-->
		
		function aa(){
		        var zTree = $.fn.zTree.getZTreeObj("treeObject");
		        var checkedArray = zTree.getCheckedNodes(true);
                alert(checkedArray.length);
                alert(zTree.getSelectedNodes().length+" "+zTree.getSelectedNodes()[0].id);
            }
            
            
             //添加选中的部门
              function addNewOptions(type){
                   
                   var itemValue = "";//用于双击选中
                   var itemText  = "";//用于双击选中
                   var itemObj = new Array();//多选
                   
                   //存放已经选择的名称
                   var selectedObjName = "";
                   
                   var zTree = $.fn.zTree.getZTreeObj("treeObject");
                   //看是否设置了为单选
                   var selectType = window.dialogArguments.d_ParametersArray.selectType;
                   if(type=="one"){//单击选中添加
                	   if(!zTree.getSelectedNodes()[0] && !zTree.getCheckedNodes(true)) return ;
                       if(selectType){
	                        if(selectType=="radio"){
	                           var selectArray = select.getAllOptions(selectedSel);
	                           if(selectArray.length>0){
	                               alert("不能多选！");
	                               return;
	                           }
	                        }
	                   }
                       //高效方法
                      
                       var select_Nodes = zTree.getSelectedNodes();
                       for( var i=0; i<select_Nodes.length; i++ ){
                    	   itemValue = zTree.getSelectedNodes()[i].id;
                           itemText =  zTree.getSelectedNodes()[i].fullName;
                           
                           //过滤前端已选
                           /*moified by wangle 2013-3-13
                           if(selectedObjArray["'"+itemValue+"'"]){
    	                                     selectedObjName =selectedObjName+itemText;
    	                                     alert(selectedObjName+info);
    	                                     return;
    	                   }
    	                   */
    	                   
                           if(!select.hasOptionValue(selectedSel,itemValue) && !select_Nodes[i].isParent)
    	                           select.addOption(selectedSel,itemText,itemValue);
    	                   continue;
                       }
                       
                   }//else{
                        itemObj = zTree.getCheckedNodes(true);//按勾选添加
                        if(!zTree.getCheckedNodes(true)[0]) return ;
                        if(selectType=="radio"){
                           var selectArray = select.getAllOptions(selectedSel);
                           if(selectArray.length>0||itemObj.length>1){
	                            alert("不能多选！");
		                        return;
	                        }
                        }
                      //高效方法
                         var options = "";
                        var select_Nodes1 = zTree.getCheckedNodes(true);
                        for( var i=0; i<select_Nodes1.length; i++ ){
                           
                     	    itemValue = select_Nodes1[i].id;
                            itemText =  select_Nodes1[i].fullName;
                            
                            //过滤前端已选
                            /*moified by wangle 2013-3-13
                            if(selectedObjArray["'"+itemValue+"'"]){
     	                                     selectedObjName =selectedObjName+itemText;
     	                                     alert(selectedObjName+info);
     	                                     return;
     	                   }
     	                   */
                            if(!select.hasOptionValue(selectedSel,itemValue) && !select_Nodes1[i].isParent){
     	                          // select.addOption(selectedSel,itemText,itemValue);
     	                            options = options+"<option value='"+itemValue+"'>"+itemText+"</option>";
                            }
     	                   
                        }
                   //}
             			 $("#selectedObjList").append(options);
		       }
       //删除已选中的部门
              function deleteSelectedOptions(type){
                   try{
	                   if(type=="one"){
	                       select.deleteByIndex(selectedSel,selectedSel.selectedIndex);
	                       return ;
	                   }
	                  
	                   var itemValue =  select.getSelectedValue(selectedSel);
	                   var itemText  =  select.getSelectedText(selectedSel);
	                   var itemLength = itemValue.length;
	                  
	                   for(var i=0;i<itemLength;i++){
	                       select.deleteOptionByValue(selectedSel,itemValue[i]);
	                   }
	                   
                   }catch(err){
                       return;
                   }
              }
       function saveDepartment(){
                  
                    var selectedDepartment = document.getElementById("selectedObjList");
                    var selectedValue = "";
                    var selectedID    = "";
                    var length = selectedDepartment.options.length;

                    returnDepartArray = new Array();
                    
                    var returnIndex = 0;
                    
                    for(var k=0;k<length;k++){
                       
                        selectedValue =selectedDepartment.options[k].text;
                        selectedID    =selectedDepartment.options[k].value;

                        
                         //选择数据 内容控制 （是否添加传入的原数据）
                         //alert(parentParam.valueIncludeSelected);
                         if(parentParam.valueIncludeSelected&&parentParam.valueIncludeSelected=="false"){
                             if(selectedObjArray["'"+selectedID+"'"])
                                continue;
                         }   
                        returnDepartArray[returnIndex] = eval("dataWH['"+selectedID+"'];");
                        returnIndex++;
                    }
                    
                    if(document.getElementById("departNameExtra").value){
                           returnDepartArray["departNameExtra"] = document.getElementById("departNameExtra").value;
                    }else{
                           returnDepartArray["departNameExtra"] = "";
                    }
                    
                    
                    //判断已经选择了多少人
                   if(window.dialogArguments.d_ParametersArray.max){
                        if(!isNaN(Number(window.dialogArguments.d_ParametersArray.max))){
                            var selectLength = select.getAllOptions(selectedSel).length;
                          
                            if(selectLength>Number(window.dialogArguments.d_ParametersArray.max)){
                               alert("只能选择 "+window.dialogArguments.d_ParametersArray.max+" 个员");
                               return ;
                            }
                        }
                   }
                   try{
                          eval("window.dialogArguments."+window.dialogArguments.d_ParametersArray.methodName+"(returnDepartArray)");
                    }catch(err){
                          alert(err.message);
						  window.close();
					}
                    window.close();
       
       }
       function cancelDepartment(){
                window.close();
       } 
       function clearAllSelectedOption(){
           select.deleteAllOption(selectedSel);
       }

     //搜索树add by chenshuo
      function serachRoom(){
			var searchRoom = document.getElementById("searchMeeingRoom1").value;//搜索条件
			var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var nodes = zTree.transformToArray(zTree.getNodes());
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			//先隐藏所有节点
			//for( var i=0; i<allNodes.length; i++ ){
				//zTree.hideNode(zTree.getNodeByParam("id",allNodes[i].id,null));
				zTree.hideNodes(nodes);
			//}
			var isIn = false;
			for( var i=0; i<allNodes.length; i++ ){
				var node =allNodes[i];
				var flag = true;
				var strIndex = node.name.indexOf(searchRoom);
				if( strIndex != -1){//匹配到节点
					isIn = true;
					var showNode = zTree.getNodeByParam("id",node.id,null);//得到当前一个节点对象
					if (showNode.isParent == true){//如果不是子节点
						//所有子节点显示
						var childNodes = zTree.transformToArray(showNode.children);//获取该节点全部节点
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

      function EnterPress(e){ //传入 event 
    	   var e = e || window.event; 
    	   var searchRoom = document.getElementById("searchMeeingRoom1").value;
    	   if(e.keyCode == 13 &&searchRoom != ""){ 
    		   serachRoom();
    	   }else if(e.keyCode == 8 &&searchRoom == ""){ 
    	   		reStore();
    	   }
       } 
       
       
       function serachRoom1(){
	 		var searchRoom = document.getElementById("searchMeeingRoom").value;//搜索条件
			var selectRoom = document.getElementById("selectedObjList");//右边select框
			var options = selectRoom.options;
			for( var i=0; i<options.length; i++ ){
					options[i].selected = false;
				
			}
			if( options.length == 0 ){
				return;
			}
			if( searchRoom == "" ){
				return;
			}
			for( var j=0; j<options.length; j++ ){
				var strIndex = options[j].text.indexOf(searchRoom);
				if( strIndex != -1 ){
					options[j].selected = true;
				}
			}
		}

     //addby chenshuo  清空搜索栏还原树结构
		   function reStore(){
			//搜索条件
			
			var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var nodes = zTree.transformToArray(zTree.getNodes());
			//var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			
				//for( var i=0; i<allNodes.length; i++ ){
				//	zTree.showNode(zTree.getNodeByParam("id",allNodes[i].id,null));
				//}
				zTree.showNodes(nodes);
				zTree.expandAll(false);
				zTree.checkAllNodes(false);
				return;
			
		}
	</script>
</head>
<body>
	<div class="contenttitle2"  style="width:99%">
		<h5 class="fwb fl10">人员选择</h5>
	</div>
   <div class="min-widthdiv">
	<div id="basicform" class="contentwrapper">
      	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #ccc">
        	<tr>
          		<td height="55">搜索 : <input id="searchMeeingRoom1"  type="text" class="glass" value="" onkeyup="EnterPress(event)" title="按回车搜索"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom();" style="cursor:pointer;" title="搜索"></td>
          		<td style="padding-left:100px" id="s1">搜索 : <input id="searchMeeingRoom"  type="text" class="glass" value="" onkeyup="serachRoom1()"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom1();" style="cursor:pointer;" title="搜索"></td>
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
		                      <input type="button" class="stdbtn mlr10" value="添加&gt;&gt;" onclick="addNewOptions('one')" id="button"/>
		                      <br /><br />
		                      <input type="button" class="stdbtn mlr10" value="&lt;&lt;删除" onclick="deleteSelectedOptions()" id="button2"  />
		                   </td>
		                   <td>
	                           <select name="select" style="background:none;border:1px solid #ddd;padding:0;margin:0;width:195px;height:250px" id="selectedObjList" ondblclick="deleteSelectedOptions('one')" multiple size="17" class="selected" >
	                             
	                           </select>
		                    </td>
		                </tr>
          			</table>
          		</td>
          		
        	</tr>
        	<tr>
           <td colspan="3" style="padding-left:10px; padding-top:15px; padding-bottom:20px;">
             <script type="text/javascript">
               // if(window.dialogArguments.d_ParametersArray.extraDept){
               if(false){
	                if(window.dialogArguments.d_ParametersArray.extraDept=='true'){
	                    document.write("<table width='60%' align='left'>");
	                    document.write("<tr>");
	                    document.write("<td width='35%' class='hjsl'>系统外部门</td>");
	                    document.write("<td width='65%'><input type='text' id='departNameExtra'/></td>");
	                    document.write("</tr>");
	                    document.write(" </table>");
	                }else{
	                    document.write("<input type='hidden' id='departNameExtra'/>");
	                }
                }else{
                    document.write("<input type='hidden' id='departNameExtra'/>");
                }
           </script>
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
                <td><input type="button" class="submit1 radius2" value="确 定" onclick="saveDepartment()"/>
                  <input type="button" class="reset1 radius2" value="取 消" onclick="cancelDepartment()"/>
                  </td>
              </tr>
            </tbody>
		</table>
	</div>
</div>
</body>
</html>
