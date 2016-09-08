<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="swh_ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.action.meeting.meetingRoom.MeetingRoomAction"%>
<%@ page import="com.zzst.model.enums.UserEnum"  %>
<%@ page import="com.zzst.model.enums.DateBaseEnum"  %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>会议室选择</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style>
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
	<link rel="stylesheet" href="/icmp/style/normal/css/style.default.css" type="text/css" />
    <link href="css/select.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js1/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.core-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.excheck-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.exedit-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.exhide-3.3.js"></script>
	<script type="text/javascript" src="js/selectAdapter.js"></script>
	<!--  
	<script type='text/javascript' src='${swh_ctx}/dwr/engine.js'></script>
    <script type='text/javascript' src='${swh_ctx}/dwr/util.js'></script>
	<script type='text/javascript' src='${swh_ctx}/dwr/interface/UserAction.js'></script>
	<script type='text/javascript' src='${swh_ctx}/dwr/interface/DepartmentAction.js'></script>		
	-->
 
		
		
		
    <script language="JavaScript">

        //已选择的select
        var selectedSel = new Object();
        //已选择的对象数组
        var selectedObjArray = new Array();
        //已选数组的ID
        var selectedObjArrayID = new Array();
        //获得的原始参数对象
        var parentParam = window.dialogArguments.d_ParametersArray;
        
        var info = " 会场已选择 \n不能重复添加!";
	    window.onload = function(){
	       
	       selectedSel = document.getElementById("selectedObjList");
	       
	       //如果有已经选择的部门则显示
            if(parentParam.selectedConference){
                 var infoArray = parentParam.selectedConference.split(",");  

               //控制已选择的元素是否显示
 	            //if(parentParam.dispSelected&&parentParam.dispSelected=="true"){
 	             	var zTree = $.fn.zTree.getZTreeObj("treeObject");
           			for(var i=0;i<infoArray.length;i++){
	               	   var node = zTree.getNodeByParam("id",infoArray[i],null);//获取当前ID下的node
	               	   if(node && node.name){
	               		   $("#selectedObjList").append("<option value='"+infoArray[i]+"' title='"+node.name+"'>"+node.name+"</option>");
	                   	}
                  	}
 	            //}
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
			 MeetingRoomAction dptAction = new MeetingRoomAction();
        	/**浏览器缓存问题add by xiongshun 20130305 15:00
        	*/
        	response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store"); 
        	response.setDateHeader("Expires",0);
        	response.setHeader("Pragma","no-cache");
        	/////////
        	ArrayList listDpt = dptAction.getRoomAdressList();
	
			     if(null!=listDpt){
			    	 Object sessionUvo=session.getAttribute(UserEnum.USER_SESSION_ID);
			          StringBuffer dataWH = new StringBuffer();
			          dataWH.append("var dataWH = new Array();");
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
			          int deptLength = listDpt.size();
					      for(int i=0;i<deptLength;i++){
					         AddressVO dpvo = (AddressVO)listDpt.get(i);
					         
					        // UserAction  userAction = new UserAction();
					         String departID = dpvo.getAddressID();
					         String departName = dpvo.getName();
					         
					         ArrayList lst_user = dptAction.getMeetingRoomByAddress(departID,sessionUvo);
					         if(!(dpvo.getAddressID().equals(DateBaseEnum.Default_ID))){
								if(lst_user==null||lst_user.size()<1){continue;}
								}
					         if(null!=lst_user){
					            int length = lst_user.size();
					             for(int j=0;j<length;j++){
					                 MeetingRoomVO userVO = (MeetingRoomVO)lst_user.get(j);
					                 dataObj.append("{id:'"+userVO.getMeetingRoomID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"\",fullName:\""+userVO.getMeetingRoomName()+"\",open:false,isParent:false},");
					                 String newObj = "{"+
							          "conferenceID:'"+userVO.getMeetingRoomID()+"',"+
							          //"userNO:'"+userVO.getUserNO()+"',"+
							          "conferenceName:'"+userVO.getMeetingRoomName()+"'"+
							          //"departmentID:'"+userVO.getDepartmentVO().getId()+"',"+
							          //"positionID:'"+userVO.getPositionID()+"',"+
							         // "telPhone:'"+userVO.getTel()+"',"+
							          //"mobilePhone:'"+userVO.getMobile()+"',"+
							          //"positionName:'"+userVO.getPositionName()+"',"+
							         // "departmentName:'"+userVO.getDepartmentVO().getTitle()+"'"+
							         "};";               
					                 dataWH.append("dataWH['"+userVO.getMeetingRoomID()+"'] = "+newObj+";");
					         	}
					         }
				             dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+dpvo.getName()+"\",fullName:\""+dpvo.getName()+"\",open:false,isParent:true},");
				         }
				      dataObj.deleteCharAt(dataObj.length()-1);
				      dataObj.append("];");
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
                           itemText =  zTree.getSelectedNodes()[i].name;
                           
                           //过滤前端已选
                           if(selectedObjArray["'"+itemValue+"'"]){
    	                                     selectedObjName =selectedObjName+itemText;
    	                                     alert(selectedObjName+info);
    	                                     return;
    	                   }
    	                   
                           if(!select.hasOptionValue(selectedSel,itemValue) && !select_Nodes[i].isParent)
    	                           select.addOption(selectedSel,itemText,itemValue);
    	                   continue;
                       }
                       
                   }//else{
                        itemObj = zTree.getCheckedNodes(true);//按勾选添加
                      //高效方法
                        if(!zTree.getCheckedNodes(true)[0]) return ;
                        if(selectType=="radio"){
                            var selectArray = select.getAllOptions(selectedSel);
                            if(selectArray.length>0||itemObj.length>1){
 	                            alert("不能多选！");
 		                        return;
 	                        }
                         }
                        var select_Nodes1 = zTree.getCheckedNodes(true);
                        for( var i=0; i<select_Nodes1.length; i++ ){
                           
                     	    itemValue = zTree.getCheckedNodes(true)[i].id;
                            itemText =  zTree.getCheckedNodes(true)[i].name;
                            
                            //过滤前端已选
                            if(selectedObjArray["'"+itemValue+"'"]){
     	                                     selectedObjName =selectedObjName+itemText;
     	                                     alert(selectedObjName+info);
     	                                     return;
     	                   }
     	                   
                            if(!select.hasOptionValue(selectedSel,itemValue) && !select_Nodes1[i].isParent){
     	                           select.addOption(selectedSel,itemText,itemValue);
                            }
     	                   
                        }
                   //}
                     
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
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			if( searchRoom == "" ){
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
				var strIndex = node.name.indexOf(searchRoom);
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
				alert("没有相关会场");
			}
	 	}

       function EnterPress(e){ //传入 event 
    	   var e = e || window.event; 
    	   if(e.keyCode == 13){ 
    		   serachRoom();
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
			var searchRoom = document.getElementById("searchMeeingRoom1").value;//搜索条件
			var zTree = $.fn.zTree.getZTreeObj("treeObject");
			var allNodes = zTree.transformToArray(zNodes);//allNodes Array
			if( searchRoom == "" ){
				for( var i=0; i<allNodes.length; i++ ){
					zTree.showNode(zTree.getNodeByParam("id",allNodes[i].id,null));
				}
				zTree.expandAll(false);
				zTree.checkAllNodes(false);
				return;
			}
		}

	</script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<!--
<div class="boxbg" align="left"  style="border:1px solid #437e8c;">
   <table width="100%"  height="446" cellspacing="0" cellpadding="0">
     <tr>
       <td  style="width:7px;"><img src="images/xg_02.gif" width="7" height="36" /></td>
       <td class="bluebg" align="left" style="width:502px">会场选择</td>
       <td  style="width:9px;" ><img src="images/xg_06.gif" width="9" height="36" /></td>
     </tr>
     <tr>
            <td height="446" colspan="3">
                 <table width="100%" height="446" style="border-bottom:#437e8c 1px solid;">
                    <tr class="textga">
                         <td width="50%" height="27" align="left" style="padding-left:20px;">可选会场</td>
                         <td width="55%" align="left" style="padding-left:65px;">已选会场</td>
                    </tr>
                    <tr class="textga">
                    	<td width="50%" height="27" align="left" style="padding-left:20px;">搜索<input id="searchMeeingRoom"  type="text" class="" value="" onkeyup="serachRoom(this)"/></td>
                        <td width="55%" align="left" style="padding-left:65px;">搜索<input id="searchMeeingRoom"  type="text" class="" value="" onkeyup="serachRoom1(this)"/></td>
                    </tr>
                    <!--  
                    <tr>
                        <td width="50%" height="14" align="left" style="padding-left:20px;">
                             &nbsp;</td>
                             <td width="55%" align="left" style="padding-left:65px;margin-top:5px">
                                 <input type="button" value="清空" onclick="clearAllSelectedOption()" onfocus="this.blur()" style="width:40px;height:18px;background:#DDEBF4;border:1px solid gray;"/>
                             </td>
                    </tr>
                    --><!-- 
                    <tr>
                          <td colspan="2">
                          <table width="98%" align="center" style="margin-top:0px;padding:0 0">
                    <tr>
                      <td width="35%" rowspan="2" style="height:330px;border:1.5px solid #7F9db9">
								    <div  style="height:330px;width:200px;overFlow-y:scroll">
										  <ul id="treeObject" class="ztree"></ul>
									</div>
								
                            <td width="30%" align="center" valign="bottom"> 
                                <input type="button" name="button" onclick="addNewOptions('one')" id="button" style="margin-bottom:20px"  class="faxi"value="" /></td>
                            <td width="35%" rowspan="2" style="border:1.5px solid #7F9db9" >
	                           <select name="select" style="background:none" id="selectedObjList" ondblclick="deleteSelectedOptions('')" multiple size="18" class="selected" >
	                             
	                           </select>
                            </td>
                    </tr>
                    <tr>
                      <td align="center" valign="top">
                         <input type="button" name="button2" onclick="deleteSelectedOptions()" id="button2" style="margin-top:20px"  class="faxi2" value="" />
                      </td>
                    </tr>
                 </table>
       </td></tr>
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
       </table></td>
     </tr>
     <tr>
       <td colspan="3"><table  align="center" width="60%" style=" margin-top:15px; margin-bottom:20px;">
         <tr>
           <td align="center">
               <input type="submit" name="button" id="button"  onclick="saveDepartment()" class="anjiu"value="确定" />
           </td>
           <td align="center"><input type="submit" name="button" id="button"  onclick="cancelDepartment()" class="anjiu"value="取消" /></td>
         </tr>
       </table></td>
     </tr>
   </table>
 </div>
 -->
  <div class="contenttitle2" style="width:99%">
	<h5 class="fwb fl10">会场选择</h5>
 </div>
 <div id="basicform" class="contentwrapper">

 <div class="min-widthdiv">
	
      	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #ccc">
        	<tr>
          		<td height="55">搜索 : <input id="searchMeeingRoom1"  type="text" class="glass" value="" onkeypress="EnterPress(event)" onkeyup="reStore();"  title=""/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom();" style="cursor:pointer;" title="搜索"></td>
          		<!--  modify by xiongshun 20130305 14:42 因为不能多选，加此搜索亦属冗余 -->
          		 <td style="padding-left:100px" id="s1">搜索 : <input id="searchMeeingRoom"  type="text" class="glass" value="" onkeyup="serachRoom1()" /><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom1();" style="cursor:pointer;" title="搜索"></td>
        	</tr>
        	<tr>
				<td>
					<div style="border:#ddd 1px solid; width:195px; height:250px; margin:0 auto; overflow:auto">
						  <ul id="treeObject" class="ztree"></ul>
                	</div>
				</td>
          		<td style="vertical-align:middle">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px;table-layout:fixed">
                       <tr>
		                   <td width="100"> 
		                      <input type="button" class="stdbtn mlr10" value="添加&gt;&gt;" onclick="addNewOptions('one')" id="button"/>
		                      <br /><br />
		                      <input type="button" class="stdbtn mlr10" value="&lt;&lt;删除" onclick="deleteSelectedOptions()" id="button2"  />
		                   </td>
		                   <td>
		                   		
		                       <select name="select" style="background:#fff;border:1px solid #ddd;padding:0;margin:0;width:195px;height:250px" id="selectedObjList" ondblclick="deleteSelectedOptions('one')" multiple size="17" class="selected" >
		                             
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
