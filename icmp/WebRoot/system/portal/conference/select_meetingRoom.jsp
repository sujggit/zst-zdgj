<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="swh_ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.action.meeting.meetingRoom.MeetingRoomAction"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
<%@ page import="com.zzst.service.meeting.equipment.EquipmentService"%>
<%@ page import="com.zzst.model.meeting.equipment.EquipmentVO" %>
<%@ page import="com.zzst.model.enums.EquipmentEnum" %>
<%@ page import="com.zzst.model.enums.UserEnum" %>
<%@ page import="com.zzst.model.enums.DateBaseEnum" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>会议室选择</title>
	<style>
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="css/select.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="/icmp/style/normal/css/style.default.css" type="text/css" />
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js1/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.core-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.excheck-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.exedit-3.3.js"></script>
	<script type="text/javascript" src="js1/jquery.ztree.exhide-3.3.js"></script>
	<script type="text/javascript" src="js/selectAdapter.js"></script>
	<!-- DWR	start-->
	<script type='text/javascript' src='/icmp/dwr/engine.js'></script>
	<script type='text/javascript' src='/icmp/dwr/util.js'></script>
	<!-- DWR	end-->
	<script type='text/javascript' src='/icmp/dwr/interface/McuDwrMethod.js'></script>	
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
	       
	       //初始化选择MCU下拉框
	       if( parentParam.mcuIpsStr.length > 0){
            var options ="添加到会议：<select style='width:150px' id='mcuIPs'>";
        	for( var i=0; i<parentParam.mcuIpsStr.length; i++ ){
        	    options += "<option value='"+parentParam.mcuIpsStr[i]+"'>"+parentParam.mcuIpsStr[i].split("__")[1]+"</option>";
        	}
        	options +="</select>"
        	document.getElementById("mcuIPsTd").innerHTML=options;
        }
	       
	       selectedSel = document.getElementById("selectedObjList");
	       
	       //如果有已经选择的部门则显示
                  if(parentParam.selectedUser){
                       var departArray = parentParam.selectedUser.split(",");  
                       for(var i=0;i<departArray.length;i++){
                           selectedObjArray["'"+departArray[i]+"'"] = departArray[i];
                           selectedObjArrayID[i]=departArray[i];
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
			 MeetingRoomAction dptAction = new MeetingRoomAction();
			 ArrayList listDpt = dptAction.getRoomAdressList();
	         EquipmentService equipSer = ServiceFactory.getEquipmentService();
			     if(null!=listDpt){
			          
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
					         System.out.println(dpvo.getName());
					          Object sessionUvo=session.getAttribute(UserEnum.USER_SESSION_ID);
					         ArrayList lst_user = dptAction.getMeetingRoomByAddress(departID,sessionUvo);
					          if(!(dpvo.getAddressID().equals(DateBaseEnum.Default_ID))){
								if(lst_user==null||lst_user.size()<1){continue;}
								}
					         if(null!=lst_user){
					            int length = lst_user.size();
					             for(int j=0;j<length;j++){
					                 MeetingRoomVO userVO = (MeetingRoomVO)lst_user.get(j);
					                 EquipmentVO eqm = new EquipmentVO();
					                 eqm.setMeetingRoomVO(userVO);
					                 eqm.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					                 List listEqu = equipSer.query(eqm,null);
					                 if( listEqu != null && listEqu.size()>0){
					                	 for(int k=0;k<listEqu.size();k++){
					                    EquipmentVO equVal = (EquipmentVO)listEqu.get(k);
					                 	dataObj.append("{id:'"+equVal.getEquipmentID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"(ip:"+equVal.getIp()+")"+"\",fullName:\""+userVO.getMeetingRoomName()+"\",open:false,isParent:false},");
						                 //System.out.println("???");
						                 String newObj = "{"+
								          "conferenceID:'"+equVal.getEquipmentID()+"',"+
								          //"userNO:'"+userVO.getUserNO()+"',"+
								          "conferenceName:'"+equVal.getEquipmentNO()+"'"+
								          //"departmentID:'"+userVO.getDepartmentVO().getId()+"',"+
								          //"positionID:'"+userVO.getPositionID()+"',"+
								         // "telPhone:'"+userVO.getTel()+"',"+
								          //"mobilePhone:'"+userVO.getMobile()+"',"+
								          //"positionName:'"+userVO.getPositionName()+"',"+
								         // "departmentName:'"+userVO.getDepartmentVO().getTitle()+"'"+
								         "};";               
						                 dataWH.append("dataWH['"+equVal.getEquipmentID()+"'] = "+newObj+";");
					                	 }
						               }
					                 //else{
						              //   	 dataObj.append("{id:'"+userVO.getMeetingRoomID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"\",fullName:\""+userVO.getMeetingRoomName()+"\",open:false,isParent:false},");
							           //      System.out.println("???");
							           //      String newObj = "{"+
									  //        "conferenceID:'"+userVO.getMeetingRoomID()+"',"+
									          //"userNO:'"+userVO.getUserNO()+"',"+
									   //       "conferenceName:'"+userVO.getMeetingRoomName()+"'"+
									          //"departmentID:'"+userVO.getDepartmentVO().getId()+"',"+
									          //"positionID:'"+userVO.getPositionID()+"',"+
									         // "telPhone:'"+userVO.getTel()+"',"+
									          //"mobilePhone:'"+userVO.getMobile()+"',"+
									          //"positionName:'"+userVO.getPositionName()+"',"+
									         // "departmentName:'"+userVO.getDepartmentVO().getTitle()+"'"+
									//         "};";               
							          //       dataWH.append("dataWH['"+userVO.getMeetingRoomID()+"'] = "+newObj+";");
						              //   }
						                 
					             }
					         }
					         if(i==deptLength-1){
					             dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+departName+"\",fullName:\""+dpvo.getName()+"\",open:false,isParent:true}");
					         }else{
					             dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+dpvo.getName()+"\",fullName:\""+dpvo.getName()+"\",open:false,isParent:true},");
					         }
				         }
				      dataObj.append("];");
				      System.out.println(dataWH);
				      System.out.println(dataObj);
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
                        if(!zTree.getCheckedNodes(true)[0]) return ;
                        if(selectType=="radio"){
                           var selectArray = select.getAllOptions(selectedSel);
                           if(selectArray.length>0||itemObj.length>1){
	                            alert("不能多选！");
		                        return;
	                        }
                        }
                      //高效方法
                        
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
                    
                    
					var mcuIp = document.getElementById("mcuIPs").value;
					var mcu_Ip = mcuIp.split("__")[2];
					
					var confName = mcuIp.split("__")[1];
					var confID = mcuIp.split("__")[0];
					var meetingID = parentParam.meetingDetailID;
					var meetingRoomIDs = new Array();
					
                    returnDepartArray = new Array();
                    
                    var tempIP = document.getElementById("tempIP").value;
                    var tempName = document.getElementById("tempName").value;
                    
                    var returnIndex = 0;
                    var length1 = 0;
                    if( length == 0  && tempIP == "" && tempName == "" ){
                       alert("请选择会场或输入一个终端信息");
                       return;
                    }else if( tempIP == "" && tempName != ""   ){
                    	alert( "请输入IP" );
                    	return;
                    }else if( tempIP != "" && tempName == ""){
                        alert( "请输入显示名称");
                        return;
                    }else if( tempIP != "" && tempName != ""){
                        length1 = 1;
                    }
                    
                    if( mcuIp =="-1"){
                        alert("请选择会议");
                        return;
                    }
                    
                    for(var k=0;k<length;k++){
                        selectedValue =selectedDepartment.options[k].text;
                        selectedID    =selectedDepartment.options[k].value;
                        meetingRoomIDs.push(selectedID);
                    }
                    length1 += length
                    
                    if(confirm("是否添加 "+length1+" 个会场到名称为 "+confName+" 的会议")){
                       //alert("meetingID:"+meetingID+"==confID:"+confID+"==mcu_Ip:"+mcu_Ip+"==tempIP:"+tempIP+"==tempName:"+tempName);
                        McuDwrMethod.addPartyOnConf(meetingID,meetingRoomIDs,confID,mcu_Ip,tempIP,tempName,function backAdd(flag){
                        	if(flag){
                        		window.close();
                        	}else{
                        		alert("添加失败");
                        	}
                        });
                    	
                    }
                    
       
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
						
						zTree.expandNode(showNode,true,false,false,false);//展开该节点
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
<body>
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
                    -->
                    <!--  
                    <tr>
                          <td colspan="2">
                          <table width="98%" align="center" style="margin-top:0px;padding:0 0">
                    <tr>
                      <td width="35%" rowspan="2" style="height:330px;border:1.5px solid #7F9db9">
								    <div  style="height:330px;width:300px;overFlow-y:scroll">
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
           	<td colspan="3" style="padding-left:10px; padding-top:15px; padding-bottom:20px;" align="center">
                	添加到MCU:<select style="width:120px" id="mcuIPs"><option value="-1">未找到MCU</option></select>
           </td>
          </tr>
       </table></td>
     </tr>
     <tr>
       <td colspan="3"><table  align="center" width="60%" style=" margin-top:-3px; margin-bottom:20px;">
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
 <div id="basicform" class="contentwrapper" >
 <div class="contenttitle2" style="margin:0 auto;width:99%">
	<h5 class="fwb fl10">会场选择</h5>
 </div>

	
      	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
          		<td height="55">搜索 : <input id="searchMeeingRoom1" class="glass" onkeypress="EnterPress(event)"  onkeyup="reStore();" title="按回车搜索"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom();" style="cursor:pointer;" title="搜索"></td>
          		<td style="padding-left:100px">搜索 : <input id="searchMeeingRoom" class="glass" value="" onkeyup="serachRoom1()"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom1();" style="cursor:pointer;" title="搜索"></td>
        	</tr>
        	<tr>
				<td>
					<div style="border:#ddd 1px solid; width:260px; height:300px; margin:0 auto; overflow:auto">
						  <ul id="treeObject" class="ztree"></ul>
                	</div>
				</td>
          		<td style="vertical-align:middle">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px">
                       <tr>
		                   <td width="10"> 
		                      <input type="button" class="stdbtn mlr10" value="添加&gt;&gt;" onclick="addNewOptions('one')" id="button"/>
		                      <br /><br />
		                      <input type="button" class="stdbtn mlr10" value="&lt;&lt;删除" onclick="deleteSelectedOptions()" id="button2"  />
		                      
		                   </td>
		                   <td>
		                      <select name="select" style="background:#fff;border:1px solid #ddd;padding:0;margin:0;width:260px;height:300px" id="selectedObjList" ondblclick="deleteSelectedOptions('one')" multiple size="17" class="selected" >
		                             
		                      </select>
		                    </td>
		                </tr>
          			</table>
          		</td>
          		
        	</tr>
        	<tr>
        	  <td style="padding-top:10px;">
                   ip地址:
                   <input type="text" style="margin-left:10px;width:140px;" id="tempIP" ></input>
              </td>
              <td style="padding-top:10px;">
                     显示名称:
                   <input type="text" style="margin-left:15px;" id="tempName"></input>
              </td>
            </tr>
        	 <tr>
        	 
              <td colspan="3" style="padding-left:10px; padding-top:15px; padding-bottom:20px;" align="center" id="mcuIPsTd">
                	添加到会议:<select style="width:150px" id="mcuIPs"><option value="-1">未找到会议</option></select>
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

</body>
</html>
